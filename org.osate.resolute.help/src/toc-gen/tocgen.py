#!/usr/bin/env python3

# ToC Gen

import argparse
import logging
import pathlib
import re
import sys
import xml.etree.ElementTree as ET

from html.parser import HTMLParser

logging.basicConfig(
    stream=sys.stdout,
    level=logging.INFO,
    format='%(asctime)s %(levelname)-8s %(filename)s %(lineno)d %(message)s',
    datefmt='%Y-%m-%d %H:%M:%S',
)
logger = logging.getLogger(__name__)

class ToCGenHTMLParser(HTMLParser):
    HEADING_REGEX = '[Hh](\d+)'
    headings = []
    context_stack = []
    url = None

    def set_url(self, url):
        self.url = url

    def handle_starttag(self, tag, attrs):
        match = re.search(self.HEADING_REGEX, tag)
        if match is not None:
            self.context_stack.append({ 'level' : int(match.group(1)), 'id' : None, 'href' : None, 'data' : None, 'found_link' : False })
        else:
            if tag == 'a' and self.context_stack and not self.context_stack[-1]['found_link']:
                name = None
                href = None
                for attr in attrs:
                    if attr[0] == 'id':
                        name = attr[1]
                    if attr[0] == 'href':
                        href = attr[1]
                self.context_stack[-1]['id'] = name
                self.context_stack[-1]['href'] = (self.url if self.url is not None else '') + href
                self.context_stack[-1]['found_link'] = True

    def handle_endtag(self, tag):
        match = re.search(self.HEADING_REGEX, tag)
        if match is not None:
            self.headings.append(self.context_stack.pop())

    def handle_data(self, data):
        if self.context_stack and self.context_stack[-1]['data'] is None:
            self.context_stack[-1]['data'] = data

def extract_hierarchy(headings):
    sections = { 'level' : 0, 'subsections' : [] }
    context_stack = [sections]
    while headings:
        current_section = context_stack[-1]
        next_heading, *headings_tail = headings
        next_heading['subsections'] = []
        logger.debug('next_heading: {}'.format(next_heading))
        if next_heading['level'] == current_section['level'] + 1:
            current_section['subsections'].append(next_heading)
            headings = headings_tail
        elif next_heading['level'] > current_section['level'] + 1:
            if not current_section['subsections']:
                # handle case where it skips a level
                logger.warning("UPWARD SKIP")
                current_section['subsections'].append({ 'level' : current_section['level'] + 1, 'subsections' : [] })
            context_stack.append(current_section['subsections'][-1])
        else:
            context_stack.pop()
    return sections['subsections']

def build_element_tree(sections, topic_file, title):
    def build_element_tree_rec(parent, sections):
        for section in sections:
            subelement = ET.SubElement(parent, 'topic')
            subelement.attrib['label'] = section.get('data', '<unnamed>')
            subelement.attrib['href'] = section.get('href', '#MISSING')
            build_element_tree_rec(subelement, section['subsections'])
    root = ET.Element('toc')
    root.attrib['label'] = title
    root.attrib['topic'] = topic_file
    build_element_tree_rec(root, sections)
    ET.indent(root, space='\t', level=0)
    return ET.ElementTree(root)

if __name__ == "__main__":
    arg_parser = argparse.ArgumentParser()
    arg_parser.add_argument('input_html', type=str, nargs='+',
                            help='Provide filename of input HTML help',
                            default=None)
    arg_parser.add_argument('-o', '--output', type=str,
                            help='Provide filename of output XML help ToC',
                            default=None)
    arg_parser.add_argument('-log', '--log', nargs='+',
                            help='Provide logging level. Example: --log debug', default=['INFO'])
    arg_parser.add_argument('-t', '--title',
                            help='Provide title label for top level ToC entry',
                            default='Title')
    args = arg_parser.parse_args()

    log_level_arg = args.log
    logger.setLevel(log_level_arg[0].upper())

    parser = ToCGenHTMLParser()
    for input_html in args.input_html:
        with open(input_html, 'r') as f:
            parser.set_url(pathlib.Path(input_html).as_posix())
            parser.feed(f.read())
    sections = extract_hierarchy(parser.headings)
    logger.debug('sections: {}'.format(sections))
    element_tree = build_element_tree(sections, args.input_html[0], args.title)

    if args.output is not None:
        element_tree.write(args.output, encoding='utf-8', short_empty_elements=False)
    else:
        print(ET.tostring(element_tree.getroot(), encoding='utf8').decode('utf8'))
