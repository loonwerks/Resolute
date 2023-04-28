#!/usr/bin/env python3

import urllib3
import certifi
import json

########### FIELDS ###########

# This set of labels dictates the sections of the changelog
VALID_LABELS = ['Resolute', 'bug', 'enhancement', 'documentation', 'releng']

# The main data structure holding the titles, sorted by labels. ie, it's a
# mapping from labels to sets of titles in that label
titles = dict()

########### INITIALIZATION ###########
for label in VALID_LABELS:
    titles[label] = list()

########### API REQUEST ###########

http = urllib3.PoolManager(10, headers={'user-agent': 'Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.0'}, cert_reqs='CERT_REQUIRED', ca_certs=certifi.where())
r = http.request('GET', 'https://api.github.com/repos/loonwerks/resolute/issues?milestone=4&state=closed&per_page=80')

########### BUILDING THE TITLES DATA STRUCTURE ###########

data = json.loads(r.data.decode('utf-8'))
for elem in data:
    for label in elem['labels']:
        if label['name'] in VALID_LABELS:
            titles[label['name']].append(elem['title'] + ' ([' + str(elem['number']) + '](<https://github.com/loonwerks/resolute/issues/' + str(elem['number']) + '>))')

########### PRINTING THE OUTPUT ###########

print('#### Fixed issues\n')

for label in VALID_LABELS:
    if len(titles[label]) == 0:
        continue
    print(' * ' + label)
    for title in reversed(titles[label]):
        print('   -' + ' ' + title)
