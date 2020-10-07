
/*
 * generated by Xtext
 */
lexer grammar InternalResoluteLexer;


@header {
package com.rockwellcollins.atc.resolute.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}




Control_flows_to_unconditionally : ('C'|'c')('O'|'o')('N'|'n')('T'|'t')('R'|'r')('O'|'o')('L'|'l')'_'('F'|'f')('L'|'l')('O'|'o')('W'|'w')('S'|'s')'_'('T'|'t')('O'|'o')'_'('U'|'u')('N'|'n')('C'|'c')('O'|'o')('N'|'n')('D'|'d')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l')('L'|'l')('Y'|'y');

Provides_subprogram_group_access : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('S'|'s')'_'('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m')'_'('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Requires_subprogram_group_access : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('S'|'s')'_'('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m')'_'('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Control_flows_to_conditionally : ('C'|'c')('O'|'o')('N'|'n')('T'|'t')('R'|'r')('O'|'o')('L'|'l')'_'('F'|'f')('L'|'l')('O'|'o')('W'|'w')('S'|'s')'_'('T'|'t')('O'|'o')'_'('C'|'c')('O'|'o')('N'|'n')('D'|'d')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l')('L'|'l')('Y'|'y');

Provides_subprogram_access : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('S'|'s')'_'('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Requires_subprogram_access : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('S'|'s')'_'('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Analysis_annotation_type : ('A'|'a')('N'|'n')('A'|'a')('L'|'l')('Y'|'y')('S'|'s')('I'|'i')('S'|'s')'_'('A'|'a')('N'|'n')('N'|'n')('O'|'o')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')'_'('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

Requirement_development : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t')'_'('D'|'d')('E'|'e')('V'|'v')('E'|'e')('L'|'l')('O'|'o')('P'|'p')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

Subprogram_group_access : ('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m')'_'('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Binary_global_variable : ('B'|'b')('I'|'i')('N'|'n')('A'|'a')('R'|'r')('Y'|'y')'_'('G'|'g')('L'|'l')('O'|'o')('B'|'b')('A'|'a')('L'|'l')'_'('V'|'v')('A'|'a')('R'|'r')('I'|'i')('A'|'a')('B'|'b')('L'|'l')('E'|'e');

Revised_without_review : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('S'|'s')('E'|'e')('D'|'d')'_'('W'|'w')('I'|'i')('T'|'t')('H'|'h')('O'|'o')('U'|'u')('T'|'t')'_'('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w');

Source_global_variable : ('S'|'s')('O'|'o')('U'|'u')('R'|'r')('C'|'c')('E'|'e')'_'('G'|'g')('L'|'l')('O'|'o')('B'|'b')('A'|'a')('L'|'l')'_'('V'|'v')('A'|'a')('R'|'r')('I'|'i')('A'|'a')('B'|'b')('L'|'l')('E'|'e');

Class_member_variable : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')'_'('M'|'m')('E'|'e')('M'|'m')('B'|'b')('E'|'e')('R'|'r')'_'('V'|'v')('A'|'a')('R'|'r')('I'|'i')('A'|'a')('B'|'b')('L'|'l')('E'|'e');

Error_state_reachable : ('E'|'e')('R'|'r')('R'|'r')('O'|'o')('R'|'r')'_'('S'|'s')('T'|'t')('A'|'a')('T'|'t')('E'|'e')'_'('R'|'r')('E'|'e')('A'|'a')('C'|'c')('H'|'h')('A'|'a')('B'|'b')('L'|'l')('E'|'e');

Hazard_identification : ('H'|'h')('A'|'a')('Z'|'z')('A'|'a')('R'|'r')('D'|'d')'_'('I'|'i')('D'|'d')('E'|'e')('N'|'n')('T'|'t')('I'|'i')('F'|'f')('I'|'i')('C'|'c')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Data_dictionary_term : ('D'|'d')('A'|'a')('T'|'t')('A'|'a')'_'('D'|'d')('I'|'i')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('R'|'r')('Y'|'y')'_'('T'|'t')('E'|'e')('R'|'r')('M'|'m');

Is_virtual_processor : ('I'|'i')('S'|'s')'_'('V'|'v')('I'|'i')('R'|'r')('T'|'t')('U'|'u')('A'|'a')('L'|'l')'_'('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s')('O'|'o')('R'|'r');

Provides_data_access : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('S'|'s')'_'('D'|'d')('A'|'a')('T'|'t')('A'|'a')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Requires_data_access : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('S'|'s')'_'('D'|'d')('A'|'a')('T'|'t')('A'|'a')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Analysis_annotation : ('A'|'a')('N'|'n')('A'|'a')('L'|'l')('Y'|'y')('S'|'s')('I'|'i')('S'|'s')'_'('A'|'a')('N'|'n')('N'|'n')('O'|'o')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Flow_specifications : ('F'|'f')('L'|'l')('O'|'o')('W'|'w')'_'('S'|'s')('P'|'p')('E'|'e')('C'|'c')('I'|'i')('F'|'f')('I'|'i')('C'|'c')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Is_abstract_feature : ('I'|'i')('S'|'s')'_'('A'|'a')('B'|'b')('S'|'s')('T'|'t')('R'|'r')('A'|'a')('C'|'c')('T'|'t')'_'('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e');

Provides_bus_access : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('S'|'s')'_'('B'|'b')('U'|'u')('S'|'s')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Requires_bus_access : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('S'|'s')'_'('B'|'b')('U'|'u')('S'|'s')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Revised_with_review : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('S'|'s')('E'|'e')('D'|'d')'_'('W'|'w')('I'|'i')('T'|'t')('H'|'h')'_'('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w');

Binary_basic_block : ('B'|'b')('I'|'i')('N'|'n')('A'|'a')('R'|'r')('Y'|'y')'_'('B'|'b')('A'|'a')('S'|'s')('I'|'i')('C'|'c')'_'('B'|'b')('L'|'l')('O'|'o')('C'|'c')('K'|'k');

Flow_specification : ('F'|'f')('L'|'l')('O'|'o')('W'|'w')'_'('S'|'s')('P'|'p')('E'|'e')('C'|'c')('I'|'i')('F'|'f')('I'|'i')('C'|'c')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

System_development : ('S'|'s')('Y'|'y')('S'|'s')('T'|'t')('E'|'e')('M'|'m')'_'('D'|'d')('E'|'e')('V'|'v')('E'|'e')('L'|'l')('O'|'o')('P'|'p')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

Analysis_activity : ('A'|'a')('N'|'n')('A'|'a')('L'|'l')('Y'|'y')('S'|'s')('I'|'i')('S'|'s')'_'('A'|'a')('C'|'c')('T'|'t')('I'|'i')('V'|'v')('I'|'i')('T'|'t')('Y'|'y');

Class_constructor : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')'_'('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('R'|'r')('U'|'u')('C'|'c')('T'|'t')('O'|'o')('R'|'r');

Enumerated_values : ('E'|'e')('N'|'n')('U'|'u')('M'|'m')('E'|'e')('R'|'r')('A'|'a')('T'|'t')('E'|'e')('D'|'d')'_'('V'|'v')('A'|'a')('L'|'l')('U'|'u')('E'|'e')('S'|'s');

Subprogram_access : ('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Virtual_processor : ('V'|'v')('I'|'i')('R'|'r')('T'|'t')('U'|'u')('A'|'a')('L'|'l')'_'('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s')('O'|'o')('R'|'r');

Class_definition : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')'_'('D'|'d')('E'|'e')('F'|'f')('I'|'i')('N'|'n')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Code_development : ('C'|'c')('O'|'o')('D'|'d')('E'|'e')'_'('D'|'d')('E'|'e')('V'|'v')('E'|'e')('L'|'l')('O'|'o')('P'|'p')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

End_to_end_flows : ('E'|'e')('N'|'n')('D'|'d')'_'('T'|'t')('O'|'o')'_'('E'|'e')('N'|'n')('D'|'d')'_'('F'|'f')('L'|'l')('O'|'o')('W'|'w')('S'|'s');

Flow_destination : ('F'|'f')('L'|'l')('O'|'o')('W'|'w')'_'('D'|'d')('E'|'e')('S'|'s')('T'|'t')('I'|'i')('N'|'n')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Is_bidirectional : ('I'|'i')('S'|'s')'_'('B'|'b')('I'|'i')('D'|'d')('I'|'i')('R'|'r')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l');

Subprogram_group : ('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m')'_'('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');

Test_developmemt : ('T'|'t')('E'|'e')('S'|'s')('T'|'t')'_'('D'|'d')('E'|'e')('V'|'v')('E'|'e')('L'|'l')('O'|'o')('P'|'p')('M'|'m')('E'|'e')('M'|'m')('T'|'t');

Analysis_report : ('A'|'a')('N'|'n')('A'|'a')('L'|'l')('Y'|'y')('S'|'s')('I'|'i')('S'|'s')'_'('R'|'r')('E'|'e')('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Analysis_result : ('A'|'a')('N'|'n')('A'|'a')('L'|'l')('Y'|'y')('S'|'s')('I'|'i')('S'|'s')'_'('R'|'r')('E'|'e')('S'|'s')('U'|'u')('L'|'l')('T'|'t');

Annotation_type : ('A'|'a')('N'|'n')('N'|'n')('O'|'o')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')'_'('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

Binary_function : ('B'|'b')('I'|'i')('N'|'n')('A'|'a')('R'|'r')('Y'|'y')'_'('F'|'f')('U'|'u')('N'|'n')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

End_to_end_flow : ('E'|'e')('N'|'n')('D'|'d')'_'('T'|'t')('O'|'o')'_'('E'|'e')('N'|'n')('D'|'d')'_'('F'|'f')('L'|'l')('O'|'o')('W'|'w');

Event_data_port : ('E'|'e')('V'|'v')('E'|'e')('N'|'n')('T'|'t')'_'('D'|'d')('A'|'a')('T'|'t')('A'|'a')'_'('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Is_thread_group : ('I'|'i')('S'|'s')'_'('T'|'t')('H'|'h')('R'|'r')('E'|'e')('A'|'a')('D'|'d')'_'('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');

Propagate_error : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('A'|'a')('G'|'g')('A'|'a')('T'|'t')('E'|'e')'_'('E'|'e')('R'|'r')('R'|'r')('O'|'o')('R'|'r');

Property_member : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('Y'|'y')'_'('M'|'m')('E'|'e')('M'|'m')('B'|'b')('E'|'e')('R'|'r');

Source_function : ('S'|'s')('O'|'o')('U'|'u')('R'|'r')('C'|'c')('E'|'e')'_'('F'|'f')('U'|'u')('N'|'n')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Subcomponent_of : ('S'|'s')('U'|'u')('B'|'b')('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('N'|'n')('E'|'e')('N'|'n')('T'|'t')'_'('O'|'o')('F'|'f');

Component_type : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('N'|'n')('E'|'e')('N'|'n')('T'|'t')'_'('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

Destination_of : ('D'|'d')('E'|'e')('S'|'s')('T'|'t')('I'|'i')('N'|'n')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')'_'('O'|'o')('F'|'f');

Has_prototypes : ('H'|'h')('A'|'a')('S'|'s')'_'('P'|'p')('R'|'r')('O'|'o')('T'|'t')('O'|'o')('T'|'t')('Y'|'y')('P'|'p')('E'|'e')('S'|'s');

Is_data_access : ('I'|'i')('S'|'s')'_'('D'|'d')('A'|'a')('T'|'t')('A'|'a')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Is_virtual_bus : ('I'|'i')('S'|'s')'_'('V'|'v')('I'|'i')('R'|'r')('T'|'t')('U'|'u')('A'|'a')('L'|'l')'_'('B'|'b')('U'|'u')('S'|'s');

Test_execution : ('T'|'t')('E'|'e')('S'|'s')('T'|'t')'_'('E'|'e')('X'|'x')('E'|'e')('C'|'c')('U'|'u')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Compile_input : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('I'|'i')('L'|'l')('E'|'e')'_'('I'|'i')('N'|'n')('P'|'p')('U'|'u')('T'|'t');

Contain_error : ('C'|'c')('O'|'o')('N'|'n')('T'|'t')('A'|'a')('I'|'i')('N'|'n')'_'('E'|'e')('R'|'r')('R'|'r')('O'|'o')('R'|'r');

Feature_group : ('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e')'_'('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');

Flow_elements : ('F'|'f')('L'|'l')('O'|'o')('W'|'w')'_'('E'|'e')('L'|'l')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t')('S'|'s');

Identified_by : ('I'|'i')('D'|'d')('E'|'e')('N'|'n')('T'|'t')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Indeterminate : ('I'|'i')('N'|'n')('D'|'d')('E'|'e')('T'|'t')('E'|'e')('R'|'r')('M'|'m')('I'|'i')('N'|'n')('A'|'a')('T'|'t')('E'|'e');

Is_bus_access : ('I'|'i')('S'|'s')'_'('B'|'b')('U'|'u')('S'|'s')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Is_event_port : ('I'|'i')('S'|'s')'_'('E'|'e')('V'|'v')('E'|'e')('N'|'n')('T'|'t')'_'('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Is_subprogram : ('I'|'i')('S'|'s')'_'('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m');

Justification : ('J'|'j')('U'|'u')('S'|'s')('T'|'t')('I'|'i')('F'|'f')('I'|'i')('C'|'c')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Package_input : ('P'|'p')('A'|'a')('C'|'c')('K'|'k')('A'|'a')('G'|'g')('E'|'e')'_'('I'|'i')('N'|'n')('P'|'p')('U'|'u')('T'|'t');

Postcondition : ('P'|'p')('O'|'o')('S'|'s')('T'|'t')('C'|'c')('O'|'o')('N'|'n')('D'|'d')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Receive_error : ('R'|'r')('E'|'e')('C'|'c')('E'|'e')('I'|'i')('V'|'v')('E'|'e')'_'('E'|'e')('R'|'r')('R'|'r')('O'|'o')('R'|'r');

Review_result : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w')'_'('R'|'r')('E'|'e')('S'|'s')('U'|'u')('L'|'l')('T'|'t');

Subcomponents : ('S'|'s')('U'|'u')('B'|'b')('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('N'|'n')('E'|'e')('N'|'n')('T'|'t')('S'|'s');

Class_method : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')'_'('M'|'m')('E'|'e')('T'|'t')('H'|'h')('O'|'o')('D'|'d');

Developed_by : ('D'|'d')('E'|'e')('V'|'v')('E'|'e')('L'|'l')('O'|'o')('P'|'p')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Has_property : ('H'|'h')('A'|'a')('S'|'s')'_'('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('Y'|'y');

Instantiates : ('I'|'i')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('T'|'t')('I'|'i')('A'|'a')('T'|'t')('E'|'e')('S'|'s');

Is_data_port : ('I'|'i')('S'|'s')'_'('D'|'d')('A'|'a')('T'|'t')('A'|'a')'_'('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Is_processor : ('I'|'i')('S'|'s')'_'('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s')('O'|'o')('R'|'r');

Package_file : ('P'|'p')('A'|'a')('C'|'c')('K'|'k')('A'|'a')('G'|'g')('E'|'e')'_'('F'|'f')('I'|'i')('L'|'l')('E'|'e');

Performed_by : ('P'|'p')('E'|'e')('R'|'r')('F'|'f')('O'|'o')('R'|'r')('M'|'m')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Precondition : ('P'|'p')('R'|'r')('E'|'e')('C'|'c')('O'|'o')('N'|'n')('D'|'d')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Requirements : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t')('S'|'s');

Review_state : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w')'_'('S'|'s')('T'|'t')('A'|'a')('T'|'t')('E'|'e');

Thread_group : ('T'|'t')('H'|'h')('R'|'r')('E'|'e')('A'|'a')('D'|'d')'_'('G'|'g')('R'|'r')('O'|'o')('U'|'u')('P'|'p');

Annotations : ('A'|'a')('N'|'n')('N'|'n')('O'|'o')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Compiled_by : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('I'|'i')('L'|'l')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Connections : ('C'|'c')('O'|'o')('N'|'n')('N'|'n')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Consumed_by : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('U'|'u')('M'|'m')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Data_access : ('D'|'d')('A'|'a')('T'|'t')('A'|'a')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Description : ('D'|'d')('E'|'e')('S'|'s')('C'|'c')('R'|'r')('I'|'i')('P'|'p')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Destination : ('D'|'d')('E'|'e')('S'|'s')('T'|'t')('I'|'i')('N'|'n')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Executed_by : ('E'|'e')('X'|'x')('E'|'e')('C'|'c')('U'|'u')('T'|'t')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Executed_on : ('E'|'e')('X'|'x')('E'|'e')('C'|'c')('U'|'u')('T'|'t')('E'|'e')('D'|'d')'_'('O'|'o')('N'|'n');

Flow_source : ('F'|'f')('L'|'l')('O'|'o')('W'|'w')'_'('S'|'s')('O'|'o')('U'|'u')('R'|'r')('C'|'c')('E'|'e');

From_report : ('F'|'f')('R'|'r')('O'|'o')('M'|'m')'_'('R'|'r')('E'|'e')('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Governed_by : ('G'|'g')('O'|'o')('V'|'v')('E'|'e')('R'|'r')('N'|'n')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Is_bound_to : ('I'|'i')('S'|'s')'_'('B'|'b')('O'|'o')('U'|'u')('N'|'n')('D'|'d')'_'('T'|'t')('O'|'o');

Is_in_array : ('I'|'i')('S'|'s')'_'('I'|'i')('N'|'n')'_'('A'|'a')('R'|'r')('R'|'r')('A'|'a')('Y'|'y');

Lower_bound : ('L'|'l')('O'|'o')('W'|'w')('E'|'e')('R'|'r')'_'('B'|'b')('O'|'o')('U'|'u')('N'|'n')('D'|'d');

Packaged_by : ('P'|'p')('A'|'a')('C'|'c')('K'|'k')('A'|'a')('G'|'g')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Produced_by : ('P'|'p')('R'|'r')('O'|'o')('D'|'d')('U'|'u')('C'|'c')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Provided_by : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Requirement : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('M'|'m')('E'|'e')('N'|'n')('T'|'t');

Restriction : ('R'|'r')('E'|'e')('S'|'s')('T'|'t')('R'|'r')('I'|'i')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Structuring : ('S'|'s')('T'|'t')('R'|'r')('U'|'u')('C'|'c')('T'|'t')('U'|'u')('R'|'r')('I'|'i')('N'|'n')('G'|'g');

Test_result : ('T'|'t')('E'|'e')('S'|'s')('T'|'t')'_'('R'|'r')('E'|'e')('S'|'s')('U'|'u')('L'|'l')('T'|'t');

Test_status : ('T'|'t')('E'|'e')('S'|'s')('T'|'t')'_'('S'|'s')('T'|'t')('A'|'a')('T'|'t')('U'|'u')('S'|'s');

Undeveloped : ('U'|'u')('N'|'n')('D'|'d')('E'|'e')('V'|'v')('E'|'e')('L'|'l')('O'|'o')('P'|'p')('E'|'e')('D'|'d');

Upper_bound : ('U'|'u')('P'|'p')('P'|'p')('E'|'e')('R'|'r')'_'('B'|'b')('O'|'o')('U'|'u')('N'|'n')('D'|'d');

Virtual_bus : ('V'|'v')('I'|'i')('R'|'r')('T'|'t')('U'|'u')('A'|'a')('L'|'l')'_'('B'|'b')('U'|'u')('S'|'s');

Assumption : ('A'|'a')('S'|'s')('S'|'s')('U'|'u')('M'|'m')('P'|'p')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Bus_access : ('B'|'b')('U'|'u')('S'|'s')'_'('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Classifier : ('C'|'c')('L'|'l')('A'|'a')('S'|'s')('S'|'s')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('R'|'r');

Conclusion : ('C'|'c')('O'|'o')('N'|'n')('C'|'c')('L'|'l')('U'|'u')('S'|'s')('I'|'i')('O'|'o')('N'|'n');

Connection : ('C'|'c')('O'|'o')('N'|'n')('N'|'n')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Created_by : ('C'|'c')('R'|'r')('E'|'e')('A'|'a')('T'|'t')('E'|'e')('D'|'d')'_'('B'|'b')('Y'|'y');

Defined_in : ('D'|'d')('E'|'e')('F'|'f')('I'|'i')('N'|'n')('E'|'e')('D'|'d')'_'('I'|'i')('N'|'n');

Definition : ('D'|'d')('E'|'e')('F'|'f')('I'|'i')('N'|'n')('I'|'i')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Event_port : ('E'|'e')('V'|'v')('E'|'e')('N'|'n')('T'|'t')'_'('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Given_text : ('G'|'g')('I'|'i')('V'|'v')('E'|'e')('N'|'n')'_'('T'|'t')('E'|'e')('X'|'x')('T'|'t');

Has_member : ('H'|'h')('A'|'a')('S'|'s')'_'('M'|'m')('E'|'e')('M'|'m')('B'|'b')('E'|'e')('R'|'r');

Has_parent : ('H'|'h')('A'|'a')('S'|'s')'_'('P'|'p')('A'|'a')('R'|'r')('E'|'e')('N'|'n')('T'|'t');

Identified : ('I'|'i')('D'|'d')('E'|'e')('N'|'n')('T'|'t')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('D'|'d');

Instanceof : ('I'|'i')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('C'|'c')('E'|'e')('O'|'o')('F'|'f');

Is_of_type : ('I'|'i')('S'|'s')'_'('O'|'o')('F'|'f')'_'('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

Is_process : ('I'|'i')('S'|'s')'_'('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Referenced : ('R'|'r')('E'|'e')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e')('D'|'d');

Review_log : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w')'_'('L'|'l')('O'|'o')('G'|'g');

Subprogram : ('S'|'s')('U'|'u')('B'|'b')('P'|'p')('R'|'r')('O'|'o')('G'|'g')('R'|'r')('A'|'a')('M'|'m');

Value_type : ('V'|'v')('A'|'a')('L'|'l')('U'|'u')('E'|'e')'_'('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

Component : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('O'|'o')('N'|'n')('E'|'e')('N'|'n')('T'|'t');

Data_port : ('D'|'d')('A'|'a')('T'|'t')('A'|'a')'_'('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Direction : ('D'|'d')('I'|'i')('R'|'r')('E'|'e')('C'|'c')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Has_modes : ('H'|'h')('A'|'a')('S'|'s')'_'('M'|'m')('O'|'o')('D'|'d')('E'|'e')('S'|'s');

Instances : ('I'|'i')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('C'|'c')('E'|'e')('S'|'s');

Interface : ('I'|'i')('N'|'n')('T'|'t')('E'|'e')('R'|'r')('F'|'f')('A'|'a')('C'|'c')('E'|'e');

Intersect : ('I'|'i')('N'|'n')('T'|'t')('E'|'e')('R'|'r')('S'|'s')('E'|'e')('C'|'c')('T'|'t');

Invariant : ('I'|'i')('N'|'n')('V'|'v')('A'|'a')('R'|'r')('I'|'i')('A'|'a')('N'|'n')('T'|'t');

Is_device : ('I'|'i')('S'|'s')'_'('D'|'d')('E'|'e')('V'|'v')('I'|'i')('C'|'c')('E'|'e');

Is_memory : ('I'|'i')('S'|'s')'_'('M'|'m')('E'|'e')('M'|'m')('O'|'o')('R'|'r')('Y'|'y');

Is_system : ('I'|'i')('S'|'s')'_'('S'|'s')('Y'|'y')('S'|'s')('T'|'t')('E'|'e')('M'|'m');

Is_thread : ('I'|'i')('S'|'s')'_'('T'|'t')('H'|'h')('R'|'r')('E'|'e')('A'|'a')('D'|'d');

Mitigates : ('M'|'m')('I'|'i')('T'|'t')('I'|'i')('G'|'g')('A'|'a')('T'|'t')('E'|'e')('S'|'s');

Namespace : ('N'|'n')('A'|'a')('M'|'m')('E'|'e')('S'|'s')('P'|'p')('A'|'a')('C'|'c')('E'|'e');

Processor : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s')('O'|'o')('R'|'r');

Rationale : ('R'|'r')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('A'|'a')('L'|'l')('E'|'e');

Reference : ('R'|'r')('E'|'e')('F'|'f')('E'|'e')('R'|'r')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

Result_of : ('R'|'r')('E'|'e')('S'|'s')('U'|'u')('L'|'l')('T'|'t')'_'('O'|'o')('F'|'f');

Satisfies : ('S'|'s')('A'|'a')('T'|'t')('I'|'i')('S'|'s')('F'|'f')('I'|'i')('E'|'e')('S'|'s');

Source_of : ('S'|'s')('O'|'o')('U'|'u')('R'|'r')('C'|'c')('E'|'e')'_'('O'|'o')('F'|'f');

Then_text : ('T'|'t')('H'|'h')('E'|'e')('N'|'n')'_'('T'|'t')('E'|'e')('X'|'x')('T'|'t');

Abstract : ('A'|'a')('B'|'b')('S'|'s')('T'|'t')('R'|'r')('A'|'a')('C'|'c')('T'|'t');

Activity : ('A'|'a')('C'|'c')('T'|'t')('I'|'i')('V'|'v')('I'|'i')('T'|'t')('Y'|'y');

Analysis : ('A'|'a')('N'|'n')('A'|'a')('L'|'l')('Y'|'y')('S'|'s')('I'|'i')('S'|'s');

Analyzes : ('A'|'a')('N'|'n')('A'|'a')('L'|'l')('Y'|'y')('Z'|'z')('E'|'e')('S'|'s');

Code_gen : ('C'|'c')('O'|'o')('D'|'d')('E'|'e')'_'('G'|'g')('E'|'e')('N'|'n');

Confirms : ('C'|'c')('O'|'o')('N'|'n')('F'|'f')('I'|'i')('R'|'r')('M'|'m')('S'|'s');

Constant : ('C'|'c')('O'|'o')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('T'|'t');

Evidence : ('E'|'e')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('N'|'n')('C'|'c')('E'|'e');

Features : ('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e')('S'|'s');

Filename : ('F'|'f')('I'|'i')('L'|'l')('E'|'e')('N'|'n')('A'|'a')('M'|'m')('E'|'e');

Has_type : ('H'|'h')('A'|'a')('S'|'s')'_'('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

Instance : ('I'|'i')('N'|'n')('S'|'s')('T'|'t')('A'|'a')('N'|'n')('C'|'c')('E'|'e');

Mentions : ('M'|'m')('E'|'e')('N'|'n')('T'|'t')('I'|'i')('O'|'o')('N'|'n')('S'|'s');

Notation : ('N'|'n')('O'|'o')('T'|'t')('A'|'a')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Property : ('P'|'p')('R'|'r')('O'|'o')('P'|'p')('E'|'e')('R'|'r')('T'|'t')('Y'|'y');

Provides : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('I'|'i')('D'|'d')('E'|'e')('S'|'s');

Requires : ('R'|'r')('E'|'e')('Q'|'q')('U'|'u')('I'|'i')('R'|'r')('E'|'e')('S'|'s');

Reviewed : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w')('E'|'e')('D'|'d');

Reviewer : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w')('E'|'e')('R'|'r');

Solution : ('S'|'s')('O'|'o')('L'|'l')('U'|'u')('T'|'t')('I'|'i')('O'|'o')('N'|'n');

Strategy : ('S'|'s')('T'|'t')('R'|'r')('A'|'a')('T'|'t')('E'|'e')('G'|'g')('Y'|'y');

Verifies : ('V'|'v')('E'|'e')('R'|'r')('I'|'i')('F'|'f')('I'|'i')('E'|'e')('S'|'s');

Andthen : ('A'|'a')('N'|'n')('D'|'d')('T'|'t')('H'|'h')('E'|'e')('N'|'n');

Applies : ('A'|'a')('P'|'p')('P'|'p')('L'|'l')('I'|'i')('E'|'e')('S'|'s');

As_list : ('A'|'a')('S'|'s')'_'('L'|'l')('I'|'i')('S'|'s')('T'|'t');

Binding : ('B'|'b')('I'|'i')('N'|'n')('D'|'d')('I'|'i')('N'|'n')('G'|'g');

Compile : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('I'|'i')('L'|'l')('E'|'e');

Compute : ('C'|'c')('O'|'o')('M'|'m')('P'|'p')('U'|'u')('T'|'t')('E'|'e');

Context : ('C'|'c')('O'|'o')('N'|'n')('T'|'t')('E'|'e')('X'|'x')('T'|'t');

Feature : ('F'|'f')('E'|'e')('A'|'a')('T'|'t')('U'|'u')('R'|'r')('E'|'e');

Governs : ('G'|'g')('O'|'o')('V'|'v')('E'|'e')('R'|'r')('N'|'n')('S'|'s');

If_text : ('I'|'i')('F'|'f')'_'('T'|'t')('E'|'e')('X'|'x')('T'|'t');

Is_data : ('I'|'i')('S'|'s')'_'('D'|'d')('A'|'a')('T'|'t')('A'|'a');

Is_port : ('I'|'i')('S'|'s')'_'('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Part_of : ('P'|'p')('A'|'a')('R'|'r')('T'|'t')'_'('O'|'o')('F'|'f');

Pattern : ('P'|'p')('A'|'a')('T'|'t')('T'|'t')('E'|'e')('R'|'r')('N'|'n');

Process : ('P'|'p')('R'|'r')('O'|'o')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Reviews : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w')('S'|'s');

Ruleset : ('R'|'r')('U'|'u')('L'|'l')('E'|'e')('S'|'s')('E'|'e')('T'|'t');

Type_of : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e')'_'('O'|'o')('F'|'f');

Warning : ('W'|'w')('A'|'a')('R'|'r')('N'|'n')('I'|'i')('N'|'n')('G'|'g');

Access : ('A'|'a')('C'|'c')('C'|'c')('E'|'e')('S'|'s')('S'|'s');

Append : ('A'|'a')('P'|'p')('P'|'p')('E'|'e')('N'|'n')('D'|'d');

As_set : ('A'|'a')('S'|'s')'_'('S'|'s')('E'|'e')('T'|'t');

Author : ('A'|'a')('U'|'u')('T'|'t')('H'|'h')('O'|'o')('R'|'r');

Device : ('D'|'d')('E'|'e')('V'|'v')('I'|'i')('C'|'c')('E'|'e');

Domain : ('D'|'d')('O'|'o')('M'|'m')('A'|'a')('I'|'i')('N'|'n');

Entity : ('E'|'e')('N'|'n')('T'|'t')('I'|'i')('T'|'t')('Y'|'y');

Exists : ('E'|'e')('X'|'x')('I'|'i')('S'|'s')('T'|'t')('S'|'s');

Failed : ('F'|'f')('A'|'a')('I'|'i')('L'|'l')('E'|'e')('D'|'d');

Forall : ('F'|'f')('O'|'o')('R'|'r')('A'|'a')('L'|'l')('L'|'l');

Format : ('F'|'f')('O'|'o')('R'|'r')('M'|'m')('A'|'a')('T'|'t');

Hazard : ('H'|'h')('A'|'a')('Z'|'z')('A'|'a')('R'|'r')('D'|'d');

Is_bus : ('I'|'i')('S'|'s')'_'('B'|'b')('U'|'u')('S'|'s');

Length : ('L'|'l')('E'|'e')('N'|'n')('G'|'g')('T'|'t')('H'|'h');

Member : ('M'|'m')('E'|'e')('M'|'m')('B'|'b')('E'|'e')('R'|'r');

Memory : ('M'|'m')('E'|'e')('M'|'m')('O'|'o')('R'|'r')('Y'|'y');

Metric : ('M'|'m')('E'|'e')('T'|'t')('R'|'r')('I'|'i')('C'|'c');

Module : ('M'|'m')('O'|'o')('D'|'d')('U'|'u')('L'|'l')('E'|'e');

Orelse : ('O'|'o')('R'|'r')('E'|'e')('L'|'l')('S'|'s')('E'|'e');

Parent : ('P'|'p')('A'|'a')('R'|'r')('E'|'e')('N'|'n')('T'|'t');

Passed : ('P'|'p')('A'|'a')('S'|'s')('S'|'s')('E'|'e')('D'|'d');

Review : ('R'|'r')('E'|'e')('V'|'v')('I'|'i')('E'|'e')('W'|'w');

Source : ('S'|'s')('O'|'o')('U'|'u')('R'|'r')('C'|'c')('E'|'e');

String : ('S'|'s')('T'|'t')('R'|'r')('I'|'i')('N'|'n')('G'|'g');

KW_System : ('S'|'s')('Y'|'y')('S'|'s')('T'|'t')('E'|'e')('M'|'m');

Thread : ('T'|'t')('H'|'h')('R'|'r')('E'|'e')('A'|'a')('D'|'d');

Agent : ('A'|'a')('G'|'g')('E'|'e')('N'|'n')('T'|'t');

Build : ('B'|'b')('U'|'u')('I'|'i')('L'|'l')('D'|'d');

Check : ('C'|'c')('H'|'h')('E'|'e')('C'|'c')('K'|'k');

Debug : ('D'|'d')('E'|'e')('B'|'b')('U'|'u')('G'|'g');

Delta : ('D'|'d')('E'|'e')('L'|'l')('T'|'t')('A'|'a');

Error : ('E'|'e')('R'|'r')('R'|'r')('O'|'o')('R'|'r');

False : ('F'|'f')('A'|'a')('L'|'l')('S'|'s')('E'|'e');

Modes : ('M'|'m')('O'|'o')('D'|'d')('E'|'e')('S'|'s');

Prove : ('P'|'p')('R'|'r')('O'|'o')('V'|'v')('E'|'e');

Range : ('R'|'r')('A'|'a')('N'|'n')('G'|'g')('E'|'e');

Thing : ('T'|'t')('H'|'h')('I'|'i')('N'|'n')('G'|'g');

Union : ('U'|'u')('N'|'n')('I'|'i')('O'|'o')('N'|'n');

Aadl : ('A'|'a')('A'|'a')('D'|'d')('L'|'l');

Bool : ('B'|'b')('O'|'o')('O'|'o')('L'|'l');

Data : ('D'|'d')('A'|'a')('T'|'t')('A'|'a');

Else : ('E'|'e')('L'|'l')('S'|'s')('E'|'e');

Fail : ('F'|'f')('A'|'a')('I'|'i')('L'|'l');

File : ('F'|'f')('I'|'i')('L'|'l')('E'|'e');

Goal : ('G'|'g')('O'|'o')('A'|'a')('L'|'l');

Head : ('H'|'h')('E'|'e')('A'|'a')('D'|'d');

Info : ('I'|'i')('N'|'n')('F'|'f')('O'|'o');

Name : ('N'|'n')('A'|'a')('M'|'m')('E'|'e');

Port : ('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Real : ('R'|'r')('E'|'e')('A'|'a')('L'|'l');

Size : ('S'|'s')('I'|'i')('Z'|'z')('E'|'e');

Step : ('S'|'s')('T'|'t')('E'|'e')('P'|'p');

Tail : ('T'|'t')('A'|'a')('I'|'i')('L'|'l');

Test : ('T'|'t')('E'|'e')('S'|'s')('T'|'t');

Text : ('T'|'t')('E'|'e')('X'|'x')('T'|'t');

Then : ('T'|'t')('H'|'h')('E'|'e')('N'|'n');

This : ('T'|'t')('H'|'h')('I'|'i')('S'|'s');

True : ('T'|'t')('R'|'r')('U'|'u')('E'|'e');

Type : ('T'|'t')('Y'|'y')('P'|'p')('E'|'e');

PlusSignEqualsSignGreaterThanSign : '+''=''>';

And : ('A'|'a')('N'|'n')('D'|'d');

Bus : ('B'|'b')('U'|'u')('S'|'s');

For : ('F'|'f')('O'|'o')('R'|'r');

Gsn : ('G'|'g')('S'|'s')('N'|'n');

Int : ('I'|'i')('N'|'n')('T'|'t');

Let : ('L'|'l')('E'|'e')('T'|'t');

Not : ('N'|'n')('O'|'o')('T'|'t');

Sum : ('S'|'s')('U'|'u')('M'|'m');

AsteriskAsterisk : '*''*';

FullStopFullStop : '.''.';

ColonColon : ':'':';

LessThanSignEqualsSign : '<''=';

LessThanSignGreaterThanSign : '<''>';

EqualsSignGreaterThanSign : '=''>';

GreaterThanSignEqualsSign : '>''=';

If : ('I'|'i')('F'|'f');

In : ('I'|'i')('N'|'n');

Jp : ('J'|'j')('P'|'p');

Or : ('O'|'o')('R'|'r');

To : ('T'|'t')('O'|'o');

PercentSign : '%';

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Solidus : '/';

Colon : ':';

Semicolon : ';';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

LeftSquareBracket : '[';

RightSquareBracket : ']';

CircumflexAccent : '^';

LeftCurlyBracket : '{';

VerticalLine : '|';

RightCurlyBracket : '}';



RULE_SL_COMMENT : '--' ~(('\n'|'\r'))* ('\r'? '\n')?;

fragment RULE_EXPONENT : ('e'|'E') ('+'|'-')? RULE_DIGIT+;

fragment RULE_INT_EXPONENT : ('e'|'E') '+'? RULE_DIGIT+;

RULE_REAL_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* '.' RULE_DIGIT+ ('_' RULE_DIGIT+)* RULE_EXPONENT?;

RULE_INTEGER_LIT : RULE_DIGIT+ ('_' RULE_DIGIT+)* ('#' RULE_BASED_INTEGER '#' RULE_INT_EXPONENT?|RULE_INT_EXPONENT?);

fragment RULE_DIGIT : '0'..'9';

fragment RULE_EXTENDED_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F');

fragment RULE_BASED_INTEGER : RULE_EXTENDED_DIGIT ('_'? RULE_EXTENDED_DIGIT)*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ID : ('a'..'z'|'A'..'Z') ('_'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_WS : (' '|'\t'|'\r'|'\n')+;



