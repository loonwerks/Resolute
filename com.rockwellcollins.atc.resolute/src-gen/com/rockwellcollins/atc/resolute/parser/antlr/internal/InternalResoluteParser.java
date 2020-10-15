package com.rockwellcollins.atc.resolute.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.rockwellcollins.atc.resolute.services.ResoluteGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalResoluteParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Control_flows_to_unconditionally", "Provides_subprogram_group_access", "Requires_subprogram_group_access", "Control_flows_to_conditionally", "Provides_subprogram_access", "Requires_subprogram_access", "Analysis_annotation_type", "Requirement_development", "Subprogram_group_access", "Binary_global_variable", "Revised_without_review", "Source_global_variable", "Class_member_variable", "Error_state_reachable", "Hazard_identification", "Data_dictionary_term", "Is_virtual_processor", "Provides_data_access", "Requires_data_access", "Analysis_annotation", "Flow_specifications", "Is_abstract_feature", "Provides_bus_access", "Requires_bus_access", "Revised_with_review", "Binary_basic_block", "Flow_specification", "System_development", "Analysis_activity", "Class_constructor", "Enumerated_values", "Subprogram_access", "Virtual_processor", "Class_definition", "Code_development", "End_to_end_flows", "Flow_destination", "Is_bidirectional", "Subprogram_group", "Test_developmemt", "Analysis_report", "Analysis_result", "Annotation_type", "Binary_function", "End_to_end_flow", "Event_data_port", "Is_thread_group", "Propagate_error", "Property_member", "Source_function", "Subcomponent_of", "Component_type", "Destination_of", "Has_prototypes", "Is_data_access", "Is_virtual_bus", "Test_execution", "Compile_input", "Contain_error", "Feature_group", "Flow_elements", "Identified_by", "Indeterminate", "Is_bus_access", "Is_event_port", "Is_subprogram", "Justification", "Package_input", "Postcondition", "Receive_error", "Review_result", "Subcomponents", "Class_method", "Developed_by", "Has_property", "Instantiates", "Is_data_port", "Is_processor", "Package_file", "Performed_by", "Precondition", "Requirements", "Review_state", "Thread_group", "Annotations", "Compiled_by", "Connections", "Consumed_by", "Data_access", "Description", "Destination", "Executed_by", "Executed_on", "Flow_source", "From_report", "Governed_by", "Is_bound_to", "Is_in_array", "Lower_bound", "Packaged_by", "Produced_by", "Provided_by", "Requirement", "Restriction", "Structuring", "Test_result", "Test_status", "Undeveloped", "Upper_bound", "Virtual_bus", "Assumption", "Bus_access", "Classifier", "Conclusion", "Connection", "Created_by", "Defined_in", "Definition", "Event_port", "Given_text", "Has_member", "Has_parent", "Identified", "Instanceof", "Is_of_type", "Is_process", "Referenced", "Review_log", "Subprogram", "Value_type", "Component", "Data_port", "Direction", "Has_modes", "Instances", "Interface", "Intersect", "Invariant", "Is_device", "Is_memory", "Is_system", "Is_thread", "Mitigates", "Namespace", "Processor", "Rationale", "Reference", "Result_of", "Satisfies", "Source_of", "Then_text", "Abstract", "Activity", "Analysis", "Analyzes", "Code_gen", "Confirms", "Constant", "Evidence", "Features", "Filename", "Has_type", "Instance", "Mentions", "Notation", "Property", "Provides", "Requires", "Reviewed", "Reviewer", "Solution", "Strategy", "Verifies", "Andthen", "Applies", "As_list", "Binding", "Compile", "Compute", "Context", "Feature", "Governs", "If_text", "Is_data", "Is_port", "Part_of", "Pattern", "Process", "Reviews", "Ruleset", "Type_of", "Warning", "Access", "Append", "As_set", "Author", "Device", "Domain", "Entity", "Exists", "Failed", "Forall", "Format", "Hazard", "Is_bus", "Length", "Member", "Memory", "Metric", "Module", "Orelse", "Parent", "Passed", "Review", "Source", "String", "KW_System", "Thread", "Agent", "Build", "Check", "Debug", "Delta", "Error", "False", "Modes", "Prove", "Range", "Thing", "Union", "Aadl", "Bool", "Data", "Else", "Fail", "File", "Goal", "Head", "Info", "Name", "Port", "Real", "Size", "Step", "Tail", "Test", "Text", "Then", "This", "True", "Type", "PlusSignEqualsSignGreaterThanSign", "And", "Bus", "For", "Gsn", "Int", "Let", "Not", "Sum", "AsteriskAsterisk", "FullStopFullStop", "ColonColon", "LessThanSignEqualsSign", "LessThanSignGreaterThanSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "If", "In", "Jp", "Or", "To", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Entity=202;
    public static final int Requires_subprogram_group_access=6;
    public static final int Or=274;
    public static final int Then_text=154;
    public static final int EqualsSignGreaterThanSign=269;
    public static final int Memory=211;
    public static final int Size=246;
    public static final int Activity=156;
    public static final int String=219;
    public static final int Analyzes=158;
    public static final int Verifies=176;
    public static final int Feature=184;
    public static final int LessThanSign=287;
    public static final int Has_member=124;
    public static final int Package_file=82;
    public static final int Data_port=135;
    public static final int System_development=31;
    public static final int PlusSignEqualsSignGreaterThanSign=255;
    public static final int Justification=70;
    public static final int Then=251;
    public static final int Thing=232;
    public static final int Structuring=108;
    public static final int GreaterThanSign=289;
    public static final int Head=241;
    public static final int RULE_ID=305;
    public static final int Developed_by=77;
    public static final int Filename=164;
    public static final int Sum=263;
    public static final int Review_log=131;
    public static final int GreaterThanSignEqualsSign=270;
    public static final int Flow_elements=64;
    public static final int Mentions=167;
    public static final int ColonColon=266;
    public static final int Is_data=187;
    public static final int Has_property=78;
    public static final int Source_function=53;
    public static final int Analysis=157;
    public static final int Author=199;
    public static final int Code_gen=159;
    public static final int Class_method=76;
    public static final int Control_flows_to_conditionally=7;
    public static final int Ruleset=193;
    public static final int Class_definition=37;
    public static final int Processor=148;
    public static final int Instance=166;
    public static final int RULE_REAL_LIT=300;
    public static final int Property_member=52;
    public static final int Classifier=116;
    public static final int Class_constructor=33;
    public static final int Union=233;
    public static final int Tail=248;
    public static final int Event_port=122;
    public static final int Solidus=284;
    public static final int RightCurlyBracket=295;
    public static final int Hazard=207;
    public static final int Reviewed=172;
    public static final int Context=183;
    public static final int Executed_on=96;
    public static final int Bus=257;
    public static final int FullStop=283;
    public static final int Is_thread=145;
    public static final int Has_modes=137;
    public static final int Provided_by=105;
    public static final int Connection=118;
    public static final int Provides_bus_access=26;
    public static final int Source_of=153;
    public static final int Reviewer=173;
    public static final int Semicolon=286;
    public static final int Analysis_report=44;
    public static final int RULE_EXPONENT=298;
    public static final int Append=197;
    public static final int As_list=179;
    public static final int Length=209;
    public static final int Delta=226;
    public static final int Part_of=189;
    public static final int Is_virtual_processor=20;
    public static final int Interface=139;
    public static final int Flow_specifications=24;
    public static final int Passed=216;
    public static final int End_to_end_flows=39;
    public static final int Type_of=194;
    public static final int Receive_error=73;
    public static final int Port=244;
    public static final int Subprogram_group=42;
    public static final int Process=191;
    public static final int Requires_subprogram_access=9;
    public static final int Name=243;
    public static final int RULE_INT_EXPONENT=299;
    public static final int Subcomponent_of=54;
    public static final int Enumerated_values=34;
    public static final int Confirms=160;
    public static final int Test=249;
    public static final int FullStopFullStop=265;
    public static final int This=252;
    public static final int To=275;
    public static final int Binding=180;
    public static final int Flow_destination=40;
    public static final int Subprogram_group_access=12;
    public static final int Packaged_by=103;
    public static final int Failed=204;
    public static final int Satisfies=152;
    public static final int Component_type=55;
    public static final int Package_input=71;
    public static final int For=258;
    public static final int RightParenthesis=278;
    public static final int Is_event_port=68;
    public static final int Not=262;
    public static final int AsteriskAsterisk=264;
    public static final int Analysis_annotation=23;
    public static final int Subcomponents=75;
    public static final int Is_data_port=80;
    public static final int Subprogram=132;
    public static final int Domain=201;
    public static final int Analysis_annotation_type=10;
    public static final int Test_result=109;
    public static final int Parent=215;
    public static final int Review=217;
    public static final int Step=247;
    public static final int From_report=98;
    public static final int Data_dictionary_term=19;
    public static final int RULE_SL_COMMENT=296;
    public static final int Provides_subprogram_group_access=5;
    public static final int Bus_access=115;
    public static final int Has_parent=125;
    public static final int Aadl=234;
    public static final int Source_global_variable=15;
    public static final int Evidence=162;
    public static final int Features=163;
    public static final int Rationale=149;
    public static final int Colon=285;
    public static final int Component=134;
    public static final int EOF=-1;
    public static final int Asterisk=279;
    public static final int Identified=126;
    public static final int Gsn=259;
    public static final int LeftCurlyBracket=293;
    public static final int Executed_by=95;
    public static final int Test_execution=60;
    public static final int Provides=170;
    public static final int Info=242;
    public static final int End_to_end_flow=48;
    public static final int Feature_group=63;
    public static final int CircumflexAccent=292;
    public static final int Flow_source=97;
    public static final int Is_thread_group=50;
    public static final int Is_system=144;
    public static final int Exists=203;
    public static final int Virtual_processor=36;
    public static final int Orelse=214;
    public static final int Given_text=123;
    public static final int Metric=212;
    public static final int Class_member_variable=16;
    public static final int Connections=90;
    public static final int LessThanSignGreaterThanSign=268;
    public static final int Governed_by=99;
    public static final int Is_port=188;
    public static final int Precondition=84;
    public static final int Data_access=92;
    public static final int KW_System=220;
    public static final int Annotation_type=46;
    public static final int Access=196;
    public static final int Check=224;
    public static final int Provides_data_access=21;
    public static final int False=228;
    public static final int Thread_group=87;
    public static final int Goal=240;
    public static final int Annotations=88;
    public static final int LeftParenthesis=277;
    public static final int Bool=235;
    public static final int Test_status=110;
    public static final int Is_bus=208;
    public static final int Requires_bus_access=27;
    public static final int Fail=238;
    public static final int Defined_in=120;
    public static final int Agent=222;
    public static final int Code_development=38;
    public static final int Is_virtual_bus=59;
    public static final int Definition=121;
    public static final int RULE_DIGIT=297;
    public static final int Namespace=147;
    public static final int Has_prototypes=57;
    public static final int Requirement=106;
    public static final int Is_bus_access=67;
    public static final int Reviews=192;
    public static final int VerticalLine=294;
    public static final int Is_bidirectional=41;
    public static final int PlusSign=280;
    public static final int Is_data_access=58;
    public static final int LeftSquareBracket=290;
    public static final int Module=213;
    public static final int If=271;
    public static final int Mitigates=146;
    public static final int Lower_bound=102;
    public static final int Is_of_type=128;
    public static final int Provides_subprogram_access=8;
    public static final int Hazard_identification=18;
    public static final int Warning=195;
    public static final int Description=93;
    public static final int In=272;
    public static final int Analysis_activity=32;
    public static final int Contain_error=62;
    public static final int Is_memory=143;
    public static final int Direction=136;
    public static final int Compile_input=61;
    public static final int Assumption=114;
    public static final int Comma=281;
    public static final int Governs=185;
    public static final int HyphenMinus=282;
    public static final int Requires_data_access=22;
    public static final int Is_subprogram=69;
    public static final int Created_by=119;
    public static final int LessThanSignEqualsSign=267;
    public static final int Property=169;
    public static final int Binary_function=47;
    public static final int Solution=174;
    public static final int Prove=230;
    public static final int Pattern=190;
    public static final int Modes=229;
    public static final int Revised_with_review=28;
    public static final int Analysis_result=45;
    public static final int Produced_by=104;
    public static final int Reference=150;
    public static final int Abstract=155;
    public static final int Jp=273;
    public static final int Text=250;
    public static final int Is_device=142;
    public static final int Thread=221;
    public static final int Instances=138;
    public static final int Type=254;
    public static final int Compiled_by=89;
    public static final int Else=237;
    public static final int RULE_EXTENDED_DIGIT=303;
    public static final int Destination_of=56;
    public static final int Virtual_bus=113;
    public static final int True=253;
    public static final int Error_state_reachable=17;
    public static final int Undeveloped=111;
    public static final int Requirements=85;
    public static final int PercentSign=276;
    public static final int Intersect=140;
    public static final int Binary_global_variable=13;
    public static final int Upper_bound=112;
    public static final int Build=223;
    public static final int Real=245;
    public static final int As_set=198;
    public static final int Review_state=86;
    public static final int Applies=178;
    public static final int Forall=205;
    public static final int Member=210;
    public static final int RULE_BASED_INTEGER=301;
    public static final int RightSquareBracket=291;
    public static final int Is_in_array=101;
    public static final int Conclusion=117;
    public static final int Requires=171;
    public static final int Device=200;
    public static final int Range=231;
    public static final int Is_process=129;
    public static final int Control_flows_to_unconditionally=4;
    public static final int Is_bound_to=100;
    public static final int Andthen=177;
    public static final int And=256;
    public static final int Is_processor=81;
    public static final int File=239;
    public static final int RULE_INTEGER_LIT=302;
    public static final int Destination=94;
    public static final int Invariant=141;
    public static final int Requirement_development=11;
    public static final int Revised_without_review=14;
    public static final int Review_result=74;
    public static final int Constant=161;
    public static final int Indeterminate=66;
    public static final int Referenced=130;
    public static final int Performed_by=83;
    public static final int If_text=186;
    public static final int RULE_STRING=304;
    public static final int Notation=168;
    public static final int Compile=181;
    public static final int Source=218;
    public static final int Int=260;
    public static final int Flow_specification=30;
    public static final int EqualsSign=288;
    public static final int Format=206;
    public static final int Identified_by=65;
    public static final int Consumed_by=91;
    public static final int Instanceof=127;
    public static final int Subprogram_access=35;
    public static final int Debug=225;
    public static final int Has_type=165;
    public static final int Is_abstract_feature=25;
    public static final int Result_of=151;
    public static final int RULE_WS=306;
    public static final int Error=227;
    public static final int Data=236;
    public static final int Propagate_error=51;
    public static final int Event_data_port=49;
    public static final int Restriction=107;
    public static final int Binary_basic_block=29;
    public static final int Value_type=133;
    public static final int Compute=182;
    public static final int Strategy=175;
    public static final int Let=261;
    public static final int Test_developmemt=43;
    public static final int Instantiates=79;
    public static final int Postcondition=72;

    // delegates
    // delegators


        public InternalResoluteParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalResoluteParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalResoluteParser.tokenNames; }
    public String getGrammarFileName() { return "InternalResoluteParser.g"; }




    	private ResoluteGrammarAccess grammarAccess;
    	 	
    	public InternalResoluteParser(TokenStream input, ResoluteGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "AnnexLibrary";	
    	} 
    	   	   	
    	@Override
    	protected ResoluteGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleAnnexLibrary"
    // InternalResoluteParser.g:61:1: entryRuleAnnexLibrary returns [EObject current=null] : iv_ruleAnnexLibrary= ruleAnnexLibrary EOF ;
    public final EObject entryRuleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexLibrary = null;


        try {
            // InternalResoluteParser.g:62:2: (iv_ruleAnnexLibrary= ruleAnnexLibrary EOF )
            // InternalResoluteParser.g:63:2: iv_ruleAnnexLibrary= ruleAnnexLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnexLibraryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnnexLibrary=ruleAnnexLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnexLibrary; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnexLibrary"


    // $ANTLR start "ruleAnnexLibrary"
    // InternalResoluteParser.g:70:1: ruleAnnexLibrary returns [EObject current=null] : this_ResoluteLibrary_0= ruleResoluteLibrary ;
    public final EObject ruleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject this_ResoluteLibrary_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:73:28: (this_ResoluteLibrary_0= ruleResoluteLibrary )
            // InternalResoluteParser.g:75:5: this_ResoluteLibrary_0= ruleResoluteLibrary
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAnnexLibraryAccess().getResoluteLibraryParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ResoluteLibrary_0=ruleResoluteLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ResoluteLibrary_0;
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnexLibrary"


    // $ANTLR start "entryRuleResoluteLibrary"
    // InternalResoluteParser.g:99:1: entryRuleResoluteLibrary returns [EObject current=null] : iv_ruleResoluteLibrary= ruleResoluteLibrary EOF ;
    public final EObject entryRuleResoluteLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResoluteLibrary = null;


        try {
            // InternalResoluteParser.g:100:2: (iv_ruleResoluteLibrary= ruleResoluteLibrary EOF )
            // InternalResoluteParser.g:101:2: iv_ruleResoluteLibrary= ruleResoluteLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResoluteLibraryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleResoluteLibrary=ruleResoluteLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResoluteLibrary; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResoluteLibrary"


    // $ANTLR start "ruleResoluteLibrary"
    // InternalResoluteParser.g:108:1: ruleResoluteLibrary returns [EObject current=null] : ( () ( (lv_definitions_1_0= ruleDefinition ) )* ) ;
    public final EObject ruleResoluteLibrary() throws RecognitionException {
        EObject current = null;

        EObject lv_definitions_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:111:28: ( ( () ( (lv_definitions_1_0= ruleDefinition ) )* ) )
            // InternalResoluteParser.g:112:1: ( () ( (lv_definitions_1_0= ruleDefinition ) )* )
            {
            // InternalResoluteParser.g:112:1: ( () ( (lv_definitions_1_0= ruleDefinition ) )* )
            // InternalResoluteParser.g:112:2: () ( (lv_definitions_1_0= ruleDefinition ) )*
            {
            // InternalResoluteParser.g:112:2: ()
            // InternalResoluteParser.g:113:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getResoluteLibraryAccess().getResoluteLibraryAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:118:2: ( (lv_definitions_1_0= ruleDefinition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Conclusion||LA1_0==Notation||LA1_0==Strategy||LA1_0==Ruleset||LA1_0==Goal||LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalResoluteParser.g:119:1: (lv_definitions_1_0= ruleDefinition )
            	    {
            	    // InternalResoluteParser.g:119:1: (lv_definitions_1_0= ruleDefinition )
            	    // InternalResoluteParser.g:120:3: lv_definitions_1_0= ruleDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResoluteLibraryAccess().getDefinitionsDefinitionParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_definitions_1_0=ruleDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResoluteLibraryRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"definitions",
            	              		lv_definitions_1_0, 
            	              		"com.rockwellcollins.atc.resolute.Resolute.Definition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResoluteLibrary"


    // $ANTLR start "entryRuleDefinition"
    // InternalResoluteParser.g:144:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalResoluteParser.g:145:2: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalResoluteParser.g:146:2: iv_ruleDefinition= ruleDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // InternalResoluteParser.g:153:1: ruleDefinition returns [EObject current=null] : (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset | this_NotationDefinition_3= ruleNotationDefinition ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantDefinition_0 = null;

        EObject this_FunctionDefinition_1 = null;

        EObject this_Ruleset_2 = null;

        EObject this_NotationDefinition_3 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:156:28: ( (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset | this_NotationDefinition_3= ruleNotationDefinition ) )
            // InternalResoluteParser.g:157:1: (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset | this_NotationDefinition_3= ruleNotationDefinition )
            {
            // InternalResoluteParser.g:157:1: (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset | this_NotationDefinition_3= ruleNotationDefinition )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==Colon) ) {
                    alt2=1;
                }
                else if ( (LA2_1==LeftParenthesis) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
            case Conclusion:
            case Strategy:
            case Goal:
                {
                alt2=2;
                }
                break;
            case Ruleset:
                {
                alt2=3;
                }
                break;
            case Notation:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalResoluteParser.g:158:5: this_ConstantDefinition_0= ruleConstantDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefinitionAccess().getConstantDefinitionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ConstantDefinition_0=ruleConstantDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ConstantDefinition_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:168:5: this_FunctionDefinition_1= ruleFunctionDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefinitionAccess().getFunctionDefinitionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FunctionDefinition_1=ruleFunctionDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FunctionDefinition_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:178:5: this_Ruleset_2= ruleRuleset
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefinitionAccess().getRulesetParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Ruleset_2=ruleRuleset();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Ruleset_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:188:5: this_NotationDefinition_3= ruleNotationDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDefinitionAccess().getNotationDefinitionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NotationDefinition_3=ruleNotationDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NotationDefinition_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleNotationDefinition"
    // InternalResoluteParser.g:204:1: entryRuleNotationDefinition returns [EObject current=null] : iv_ruleNotationDefinition= ruleNotationDefinition EOF ;
    public final EObject entryRuleNotationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotationDefinition = null;


        try {
            // InternalResoluteParser.g:205:2: (iv_ruleNotationDefinition= ruleNotationDefinition EOF )
            // InternalResoluteParser.g:206:2: iv_ruleNotationDefinition= ruleNotationDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotationDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNotationDefinition=ruleNotationDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotationDefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotationDefinition"


    // $ANTLR start "ruleNotationDefinition"
    // InternalResoluteParser.g:213:1: ruleNotationDefinition returns [EObject current=null] : ( ( (lv_name_0_0= Notation ) ) ( (lv_notation_1_0= ruleNotation ) ) ) ;
    public final EObject ruleNotationDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        AntlrDatatypeRuleToken lv_notation_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:216:28: ( ( ( (lv_name_0_0= Notation ) ) ( (lv_notation_1_0= ruleNotation ) ) ) )
            // InternalResoluteParser.g:217:1: ( ( (lv_name_0_0= Notation ) ) ( (lv_notation_1_0= ruleNotation ) ) )
            {
            // InternalResoluteParser.g:217:1: ( ( (lv_name_0_0= Notation ) ) ( (lv_notation_1_0= ruleNotation ) ) )
            // InternalResoluteParser.g:217:2: ( (lv_name_0_0= Notation ) ) ( (lv_notation_1_0= ruleNotation ) )
            {
            // InternalResoluteParser.g:217:2: ( (lv_name_0_0= Notation ) )
            // InternalResoluteParser.g:218:1: (lv_name_0_0= Notation )
            {
            // InternalResoluteParser.g:218:1: (lv_name_0_0= Notation )
            // InternalResoluteParser.g:219:3: lv_name_0_0= Notation
            {
            lv_name_0_0=(Token)match(input,Notation,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getNotationDefinitionAccess().getNameNotationKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNotationDefinitionRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "notation");
              	    
            }

            }


            }

            // InternalResoluteParser.g:233:2: ( (lv_notation_1_0= ruleNotation ) )
            // InternalResoluteParser.g:234:1: (lv_notation_1_0= ruleNotation )
            {
            // InternalResoluteParser.g:234:1: (lv_notation_1_0= ruleNotation )
            // InternalResoluteParser.g:235:3: lv_notation_1_0= ruleNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNotationDefinitionAccess().getNotationNotationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_notation_1_0=ruleNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNotationDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"notation",
                      		lv_notation_1_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.Notation");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotationDefinition"


    // $ANTLR start "entryRuleNotation"
    // InternalResoluteParser.g:259:1: entryRuleNotation returns [String current=null] : iv_ruleNotation= ruleNotation EOF ;
    public final String entryRuleNotation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNotation = null;


        try {
            // InternalResoluteParser.g:260:1: (iv_ruleNotation= ruleNotation EOF )
            // InternalResoluteParser.g:261:2: iv_ruleNotation= ruleNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNotation=ruleNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotation.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotation"


    // $ANTLR start "ruleNotation"
    // InternalResoluteParser.g:268:1: ruleNotation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= Justification kw= Pattern ) | kw= Jp | kw= Gsn | (kw= Goal kw= Structuring kw= Notation ) ) ;
    public final AntlrDatatypeRuleToken ruleNotation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:272:6: ( ( (kw= Justification kw= Pattern ) | kw= Jp | kw= Gsn | (kw= Goal kw= Structuring kw= Notation ) ) )
            // InternalResoluteParser.g:273:1: ( (kw= Justification kw= Pattern ) | kw= Jp | kw= Gsn | (kw= Goal kw= Structuring kw= Notation ) )
            {
            // InternalResoluteParser.g:273:1: ( (kw= Justification kw= Pattern ) | kw= Jp | kw= Gsn | (kw= Goal kw= Structuring kw= Notation ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case Justification:
                {
                alt3=1;
                }
                break;
            case Jp:
                {
                alt3=2;
                }
                break;
            case Gsn:
                {
                alt3=3;
                }
                break;
            case Goal:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalResoluteParser.g:273:2: (kw= Justification kw= Pattern )
                    {
                    // InternalResoluteParser.g:273:2: (kw= Justification kw= Pattern )
                    // InternalResoluteParser.g:274:2: kw= Justification kw= Pattern
                    {
                    kw=(Token)match(input,Justification,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNotationAccess().getJustificationKeyword_0_0()); 
                          
                    }
                    kw=(Token)match(input,Pattern,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNotationAccess().getPatternKeyword_0_1()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:287:2: kw= Jp
                    {
                    kw=(Token)match(input,Jp,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNotationAccess().getJpKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:294:2: kw= Gsn
                    {
                    kw=(Token)match(input,Gsn,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNotationAccess().getGsnKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:300:6: (kw= Goal kw= Structuring kw= Notation )
                    {
                    // InternalResoluteParser.g:300:6: (kw= Goal kw= Structuring kw= Notation )
                    // InternalResoluteParser.g:301:2: kw= Goal kw= Structuring kw= Notation
                    {
                    kw=(Token)match(input,Goal,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNotationAccess().getGoalKeyword_3_0()); 
                          
                    }
                    kw=(Token)match(input,Structuring,FollowSets000.FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNotationAccess().getStructuringKeyword_3_1()); 
                          
                    }
                    kw=(Token)match(input,Notation,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getNotationAccess().getNotationKeyword_3_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotation"


    // $ANTLR start "entryRuleType"
    // InternalResoluteParser.g:326:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalResoluteParser.g:327:2: (iv_ruleType= ruleType EOF )
            // InternalResoluteParser.g:328:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalResoluteParser.g:335:1: ruleType returns [EObject current=null] : ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_libName_13_0=null;
        Token otherlv_14=null;
        Token lv_fnType_15_0=null;
        EObject lv_type_2_0 = null;

        EObject lv_type_6_0 = null;

        EObject this_BaseType_8 = null;

        EObject lv_paramType_10_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:338:28: ( ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) ) )
            // InternalResoluteParser.g:339:1: ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) )
            {
            // InternalResoluteParser.g:339:1: ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt5=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt5=2;
                }
                break;
            case Provides_subprogram_group_access:
            case Requires_subprogram_group_access:
            case Provides_subprogram_access:
            case Requires_subprogram_access:
            case Analysis_annotation_type:
            case Requirement_development:
            case Subprogram_group_access:
            case Binary_global_variable:
            case Source_global_variable:
            case Class_member_variable:
            case Hazard_identification:
            case Data_dictionary_term:
            case Provides_data_access:
            case Requires_data_access:
            case Analysis_annotation:
            case Provides_bus_access:
            case Requires_bus_access:
            case Binary_basic_block:
            case Flow_specification:
            case System_development:
            case Analysis_activity:
            case Class_constructor:
            case Subprogram_access:
            case Virtual_processor:
            case Class_definition:
            case Code_development:
            case Subprogram_group:
            case Test_developmemt:
            case Analysis_report:
            case Analysis_result:
            case Binary_function:
            case End_to_end_flow:
            case Event_data_port:
            case Source_function:
            case Component_type:
            case Test_execution:
            case Feature_group:
            case Postcondition:
            case Class_method:
            case Package_file:
            case Precondition:
            case Review_state:
            case Thread_group:
            case Data_access:
            case Requirement:
            case Test_result:
            case Test_status:
            case Virtual_bus:
            case Bus_access:
            case Connection:
            case Event_port:
            case Review_log:
            case Subprogram:
            case Component:
            case Data_port:
            case Interface:
            case Invariant:
            case Namespace:
            case Processor:
            case Abstract:
            case Activity:
            case Code_gen:
            case Property:
            case Compile:
            case Feature:
            case Process:
            case Access:
            case Device:
            case Entity:
            case Format:
            case Hazard:
            case Memory:
            case Module:
            case Review:
            case String:
            case KW_System:
            case Thread:
            case Agent:
            case Build:
            case Range:
            case Thing:
            case Aadl:
            case Bool:
            case Data:
            case File:
            case Port:
            case Real:
            case Test:
            case Bus:
            case Int:
                {
                alt5=3;
                }
                break;
            case RULE_ID:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalResoluteParser.g:339:2: ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:339:2: ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket )
                    // InternalResoluteParser.g:339:3: () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket
                    {
                    // InternalResoluteParser.g:339:3: ()
                    // InternalResoluteParser.g:340:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getListTypeAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeAccess().getLeftSquareBracketKeyword_0_1());
                          
                    }
                    // InternalResoluteParser.g:350:1: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:351:1: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:351:1: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:352:3: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getTypeTypeParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_type_2_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getRightSquareBracketKeyword_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:374:6: ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:374:6: ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket )
                    // InternalResoluteParser.g:374:7: () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket
                    {
                    // InternalResoluteParser.g:374:7: ()
                    // InternalResoluteParser.g:375:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getSetTypeAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_5=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_1_1());
                          
                    }
                    // InternalResoluteParser.g:385:1: ( (lv_type_6_0= ruleType ) )
                    // InternalResoluteParser.g:386:1: (lv_type_6_0= ruleType )
                    {
                    // InternalResoluteParser.g:386:1: (lv_type_6_0= ruleType )
                    // InternalResoluteParser.g:387:3: lv_type_6_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getTypeTypeParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_type_6_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_6_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_1_3());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:409:6: (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? )
                    {
                    // InternalResoluteParser.g:409:6: (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? )
                    // InternalResoluteParser.g:410:5: this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAccess().getBaseTypeParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_11);
                    this_BaseType_8=ruleBaseType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BaseType_8;
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalResoluteParser.g:418:1: (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==LessThanSign) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalResoluteParser.g:419:2: otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign
                            {
                            otherlv_9=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getTypeAccess().getLessThanSignKeyword_2_1_0());
                                  
                            }
                            // InternalResoluteParser.g:423:1: ( (lv_paramType_10_0= ruleType ) )
                            // InternalResoluteParser.g:424:1: (lv_paramType_10_0= ruleType )
                            {
                            // InternalResoluteParser.g:424:1: (lv_paramType_10_0= ruleType )
                            // InternalResoluteParser.g:425:3: lv_paramType_10_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeTypeParserRuleCall_2_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_12);
                            lv_paramType_10_0=ruleType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"paramType",
                                      		lv_paramType_10_0, 
                                      		"com.rockwellcollins.atc.resolute.Resolute.Type");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_11=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_11, grammarAccess.getTypeAccess().getGreaterThanSignKeyword_2_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:447:6: ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) )
                    {
                    // InternalResoluteParser.g:447:6: ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) )
                    // InternalResoluteParser.g:447:7: () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) )
                    {
                    // InternalResoluteParser.g:447:7: ()
                    // InternalResoluteParser.g:448:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getLibraryFnTypeAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:453:2: ( (lv_libName_13_0= RULE_ID ) )
                    // InternalResoluteParser.g:454:1: (lv_libName_13_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:454:1: (lv_libName_13_0= RULE_ID )
                    // InternalResoluteParser.g:455:3: lv_libName_13_0= RULE_ID
                    {
                    lv_libName_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_libName_13_0, grammarAccess.getTypeAccess().getLibNameIDTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"libName",
                              		lv_libName_13_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTypeAccess().getFullStopKeyword_3_2());
                          
                    }
                    // InternalResoluteParser.g:476:1: ( (lv_fnType_15_0= RULE_ID ) )
                    // InternalResoluteParser.g:477:1: (lv_fnType_15_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:477:1: (lv_fnType_15_0= RULE_ID )
                    // InternalResoluteParser.g:478:3: lv_fnType_15_0= RULE_ID
                    {
                    lv_fnType_15_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_fnType_15_0, grammarAccess.getTypeAccess().getFnTypeIDTerminalRuleCall_3_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"fnType",
                              		lv_fnType_15_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleBaseType"
    // InternalResoluteParser.g:502:1: entryRuleBaseType returns [EObject current=null] : iv_ruleBaseType= ruleBaseType EOF ;
    public final EObject entryRuleBaseType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseType = null;


        try {
            // InternalResoluteParser.g:503:2: (iv_ruleBaseType= ruleBaseType EOF )
            // InternalResoluteParser.g:504:2: iv_ruleBaseType= ruleBaseType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBaseType=ruleBaseType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBaseType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseType"


    // $ANTLR start "ruleBaseType"
    // InternalResoluteParser.g:511:1: ruleBaseType returns [EObject current=null] : ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing | lv_type_0_49= Analysis_activity | lv_type_0_50= Analysis_report | lv_type_0_51= Analysis_result | lv_type_0_52= Analysis_annotation_type | lv_type_0_53= Precondition | lv_type_0_54= Postcondition | lv_type_0_55= Invariant | lv_type_0_56= Analysis_annotation | lv_type_0_57= Hazard | lv_type_0_58= Hazard_identification | lv_type_0_59= Requirement | lv_type_0_60= Data_dictionary_term | lv_type_0_61= Requirement_development | lv_type_0_62= Review | lv_type_0_63= Review_log | lv_type_0_64= Review_state | lv_type_0_65= File | lv_type_0_66= Format | lv_type_0_67= Code_development | lv_type_0_68= Build | lv_type_0_69= Code_gen | lv_type_0_70= Compile | lv_type_0_71= Package_file | lv_type_0_72= Component_type | lv_type_0_73= Source_function | lv_type_0_74= Binary_function | lv_type_0_75= Source_global_variable | lv_type_0_76= Binary_global_variable | lv_type_0_77= Binary_basic_block | lv_type_0_78= Class_definition | lv_type_0_79= Class_method | lv_type_0_80= Class_member_variable | lv_type_0_81= Class_constructor | lv_type_0_82= Module | lv_type_0_83= Namespace | lv_type_0_84= Interface | lv_type_0_85= System_development | lv_type_0_86= Test | lv_type_0_87= Test_result | lv_type_0_88= Test_status | lv_type_0_89= Test_developmemt | lv_type_0_90= Test_execution ) ) ) ;
    public final EObject ruleBaseType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token lv_type_0_3=null;
        Token lv_type_0_4=null;
        Token lv_type_0_5=null;
        Token lv_type_0_6=null;
        Token lv_type_0_7=null;
        Token lv_type_0_8=null;
        Token lv_type_0_9=null;
        Token lv_type_0_10=null;
        Token lv_type_0_11=null;
        Token lv_type_0_12=null;
        Token lv_type_0_13=null;
        Token lv_type_0_14=null;
        Token lv_type_0_15=null;
        Token lv_type_0_16=null;
        Token lv_type_0_17=null;
        Token lv_type_0_18=null;
        Token lv_type_0_19=null;
        Token lv_type_0_20=null;
        Token lv_type_0_21=null;
        Token lv_type_0_22=null;
        Token lv_type_0_23=null;
        Token lv_type_0_24=null;
        Token lv_type_0_25=null;
        Token lv_type_0_26=null;
        Token lv_type_0_27=null;
        Token lv_type_0_28=null;
        Token lv_type_0_29=null;
        Token lv_type_0_30=null;
        Token lv_type_0_31=null;
        Token lv_type_0_32=null;
        Token lv_type_0_33=null;
        Token lv_type_0_34=null;
        Token lv_type_0_35=null;
        Token lv_type_0_36=null;
        Token lv_type_0_37=null;
        Token lv_type_0_38=null;
        Token lv_type_0_39=null;
        Token lv_type_0_40=null;
        Token lv_type_0_41=null;
        Token lv_type_0_42=null;
        Token lv_type_0_43=null;
        Token lv_type_0_44=null;
        Token lv_type_0_45=null;
        Token lv_type_0_46=null;
        Token lv_type_0_47=null;
        Token lv_type_0_48=null;
        Token lv_type_0_49=null;
        Token lv_type_0_50=null;
        Token lv_type_0_51=null;
        Token lv_type_0_52=null;
        Token lv_type_0_53=null;
        Token lv_type_0_54=null;
        Token lv_type_0_55=null;
        Token lv_type_0_56=null;
        Token lv_type_0_57=null;
        Token lv_type_0_58=null;
        Token lv_type_0_59=null;
        Token lv_type_0_60=null;
        Token lv_type_0_61=null;
        Token lv_type_0_62=null;
        Token lv_type_0_63=null;
        Token lv_type_0_64=null;
        Token lv_type_0_65=null;
        Token lv_type_0_66=null;
        Token lv_type_0_67=null;
        Token lv_type_0_68=null;
        Token lv_type_0_69=null;
        Token lv_type_0_70=null;
        Token lv_type_0_71=null;
        Token lv_type_0_72=null;
        Token lv_type_0_73=null;
        Token lv_type_0_74=null;
        Token lv_type_0_75=null;
        Token lv_type_0_76=null;
        Token lv_type_0_77=null;
        Token lv_type_0_78=null;
        Token lv_type_0_79=null;
        Token lv_type_0_80=null;
        Token lv_type_0_81=null;
        Token lv_type_0_82=null;
        Token lv_type_0_83=null;
        Token lv_type_0_84=null;
        Token lv_type_0_85=null;
        Token lv_type_0_86=null;
        Token lv_type_0_87=null;
        Token lv_type_0_88=null;
        Token lv_type_0_89=null;
        Token lv_type_0_90=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:514:28: ( ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing | lv_type_0_49= Analysis_activity | lv_type_0_50= Analysis_report | lv_type_0_51= Analysis_result | lv_type_0_52= Analysis_annotation_type | lv_type_0_53= Precondition | lv_type_0_54= Postcondition | lv_type_0_55= Invariant | lv_type_0_56= Analysis_annotation | lv_type_0_57= Hazard | lv_type_0_58= Hazard_identification | lv_type_0_59= Requirement | lv_type_0_60= Data_dictionary_term | lv_type_0_61= Requirement_development | lv_type_0_62= Review | lv_type_0_63= Review_log | lv_type_0_64= Review_state | lv_type_0_65= File | lv_type_0_66= Format | lv_type_0_67= Code_development | lv_type_0_68= Build | lv_type_0_69= Code_gen | lv_type_0_70= Compile | lv_type_0_71= Package_file | lv_type_0_72= Component_type | lv_type_0_73= Source_function | lv_type_0_74= Binary_function | lv_type_0_75= Source_global_variable | lv_type_0_76= Binary_global_variable | lv_type_0_77= Binary_basic_block | lv_type_0_78= Class_definition | lv_type_0_79= Class_method | lv_type_0_80= Class_member_variable | lv_type_0_81= Class_constructor | lv_type_0_82= Module | lv_type_0_83= Namespace | lv_type_0_84= Interface | lv_type_0_85= System_development | lv_type_0_86= Test | lv_type_0_87= Test_result | lv_type_0_88= Test_status | lv_type_0_89= Test_developmemt | lv_type_0_90= Test_execution ) ) ) )
            // InternalResoluteParser.g:515:1: ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing | lv_type_0_49= Analysis_activity | lv_type_0_50= Analysis_report | lv_type_0_51= Analysis_result | lv_type_0_52= Analysis_annotation_type | lv_type_0_53= Precondition | lv_type_0_54= Postcondition | lv_type_0_55= Invariant | lv_type_0_56= Analysis_annotation | lv_type_0_57= Hazard | lv_type_0_58= Hazard_identification | lv_type_0_59= Requirement | lv_type_0_60= Data_dictionary_term | lv_type_0_61= Requirement_development | lv_type_0_62= Review | lv_type_0_63= Review_log | lv_type_0_64= Review_state | lv_type_0_65= File | lv_type_0_66= Format | lv_type_0_67= Code_development | lv_type_0_68= Build | lv_type_0_69= Code_gen | lv_type_0_70= Compile | lv_type_0_71= Package_file | lv_type_0_72= Component_type | lv_type_0_73= Source_function | lv_type_0_74= Binary_function | lv_type_0_75= Source_global_variable | lv_type_0_76= Binary_global_variable | lv_type_0_77= Binary_basic_block | lv_type_0_78= Class_definition | lv_type_0_79= Class_method | lv_type_0_80= Class_member_variable | lv_type_0_81= Class_constructor | lv_type_0_82= Module | lv_type_0_83= Namespace | lv_type_0_84= Interface | lv_type_0_85= System_development | lv_type_0_86= Test | lv_type_0_87= Test_result | lv_type_0_88= Test_status | lv_type_0_89= Test_developmemt | lv_type_0_90= Test_execution ) ) )
            {
            // InternalResoluteParser.g:515:1: ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing | lv_type_0_49= Analysis_activity | lv_type_0_50= Analysis_report | lv_type_0_51= Analysis_result | lv_type_0_52= Analysis_annotation_type | lv_type_0_53= Precondition | lv_type_0_54= Postcondition | lv_type_0_55= Invariant | lv_type_0_56= Analysis_annotation | lv_type_0_57= Hazard | lv_type_0_58= Hazard_identification | lv_type_0_59= Requirement | lv_type_0_60= Data_dictionary_term | lv_type_0_61= Requirement_development | lv_type_0_62= Review | lv_type_0_63= Review_log | lv_type_0_64= Review_state | lv_type_0_65= File | lv_type_0_66= Format | lv_type_0_67= Code_development | lv_type_0_68= Build | lv_type_0_69= Code_gen | lv_type_0_70= Compile | lv_type_0_71= Package_file | lv_type_0_72= Component_type | lv_type_0_73= Source_function | lv_type_0_74= Binary_function | lv_type_0_75= Source_global_variable | lv_type_0_76= Binary_global_variable | lv_type_0_77= Binary_basic_block | lv_type_0_78= Class_definition | lv_type_0_79= Class_method | lv_type_0_80= Class_member_variable | lv_type_0_81= Class_constructor | lv_type_0_82= Module | lv_type_0_83= Namespace | lv_type_0_84= Interface | lv_type_0_85= System_development | lv_type_0_86= Test | lv_type_0_87= Test_result | lv_type_0_88= Test_status | lv_type_0_89= Test_developmemt | lv_type_0_90= Test_execution ) ) )
            // InternalResoluteParser.g:516:1: ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing | lv_type_0_49= Analysis_activity | lv_type_0_50= Analysis_report | lv_type_0_51= Analysis_result | lv_type_0_52= Analysis_annotation_type | lv_type_0_53= Precondition | lv_type_0_54= Postcondition | lv_type_0_55= Invariant | lv_type_0_56= Analysis_annotation | lv_type_0_57= Hazard | lv_type_0_58= Hazard_identification | lv_type_0_59= Requirement | lv_type_0_60= Data_dictionary_term | lv_type_0_61= Requirement_development | lv_type_0_62= Review | lv_type_0_63= Review_log | lv_type_0_64= Review_state | lv_type_0_65= File | lv_type_0_66= Format | lv_type_0_67= Code_development | lv_type_0_68= Build | lv_type_0_69= Code_gen | lv_type_0_70= Compile | lv_type_0_71= Package_file | lv_type_0_72= Component_type | lv_type_0_73= Source_function | lv_type_0_74= Binary_function | lv_type_0_75= Source_global_variable | lv_type_0_76= Binary_global_variable | lv_type_0_77= Binary_basic_block | lv_type_0_78= Class_definition | lv_type_0_79= Class_method | lv_type_0_80= Class_member_variable | lv_type_0_81= Class_constructor | lv_type_0_82= Module | lv_type_0_83= Namespace | lv_type_0_84= Interface | lv_type_0_85= System_development | lv_type_0_86= Test | lv_type_0_87= Test_result | lv_type_0_88= Test_status | lv_type_0_89= Test_developmemt | lv_type_0_90= Test_execution ) )
            {
            // InternalResoluteParser.g:516:1: ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing | lv_type_0_49= Analysis_activity | lv_type_0_50= Analysis_report | lv_type_0_51= Analysis_result | lv_type_0_52= Analysis_annotation_type | lv_type_0_53= Precondition | lv_type_0_54= Postcondition | lv_type_0_55= Invariant | lv_type_0_56= Analysis_annotation | lv_type_0_57= Hazard | lv_type_0_58= Hazard_identification | lv_type_0_59= Requirement | lv_type_0_60= Data_dictionary_term | lv_type_0_61= Requirement_development | lv_type_0_62= Review | lv_type_0_63= Review_log | lv_type_0_64= Review_state | lv_type_0_65= File | lv_type_0_66= Format | lv_type_0_67= Code_development | lv_type_0_68= Build | lv_type_0_69= Code_gen | lv_type_0_70= Compile | lv_type_0_71= Package_file | lv_type_0_72= Component_type | lv_type_0_73= Source_function | lv_type_0_74= Binary_function | lv_type_0_75= Source_global_variable | lv_type_0_76= Binary_global_variable | lv_type_0_77= Binary_basic_block | lv_type_0_78= Class_definition | lv_type_0_79= Class_method | lv_type_0_80= Class_member_variable | lv_type_0_81= Class_constructor | lv_type_0_82= Module | lv_type_0_83= Namespace | lv_type_0_84= Interface | lv_type_0_85= System_development | lv_type_0_86= Test | lv_type_0_87= Test_result | lv_type_0_88= Test_status | lv_type_0_89= Test_developmemt | lv_type_0_90= Test_execution ) )
            // InternalResoluteParser.g:517:1: (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing | lv_type_0_49= Analysis_activity | lv_type_0_50= Analysis_report | lv_type_0_51= Analysis_result | lv_type_0_52= Analysis_annotation_type | lv_type_0_53= Precondition | lv_type_0_54= Postcondition | lv_type_0_55= Invariant | lv_type_0_56= Analysis_annotation | lv_type_0_57= Hazard | lv_type_0_58= Hazard_identification | lv_type_0_59= Requirement | lv_type_0_60= Data_dictionary_term | lv_type_0_61= Requirement_development | lv_type_0_62= Review | lv_type_0_63= Review_log | lv_type_0_64= Review_state | lv_type_0_65= File | lv_type_0_66= Format | lv_type_0_67= Code_development | lv_type_0_68= Build | lv_type_0_69= Code_gen | lv_type_0_70= Compile | lv_type_0_71= Package_file | lv_type_0_72= Component_type | lv_type_0_73= Source_function | lv_type_0_74= Binary_function | lv_type_0_75= Source_global_variable | lv_type_0_76= Binary_global_variable | lv_type_0_77= Binary_basic_block | lv_type_0_78= Class_definition | lv_type_0_79= Class_method | lv_type_0_80= Class_member_variable | lv_type_0_81= Class_constructor | lv_type_0_82= Module | lv_type_0_83= Namespace | lv_type_0_84= Interface | lv_type_0_85= System_development | lv_type_0_86= Test | lv_type_0_87= Test_result | lv_type_0_88= Test_status | lv_type_0_89= Test_developmemt | lv_type_0_90= Test_execution )
            {
            // InternalResoluteParser.g:517:1: (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing | lv_type_0_49= Analysis_activity | lv_type_0_50= Analysis_report | lv_type_0_51= Analysis_result | lv_type_0_52= Analysis_annotation_type | lv_type_0_53= Precondition | lv_type_0_54= Postcondition | lv_type_0_55= Invariant | lv_type_0_56= Analysis_annotation | lv_type_0_57= Hazard | lv_type_0_58= Hazard_identification | lv_type_0_59= Requirement | lv_type_0_60= Data_dictionary_term | lv_type_0_61= Requirement_development | lv_type_0_62= Review | lv_type_0_63= Review_log | lv_type_0_64= Review_state | lv_type_0_65= File | lv_type_0_66= Format | lv_type_0_67= Code_development | lv_type_0_68= Build | lv_type_0_69= Code_gen | lv_type_0_70= Compile | lv_type_0_71= Package_file | lv_type_0_72= Component_type | lv_type_0_73= Source_function | lv_type_0_74= Binary_function | lv_type_0_75= Source_global_variable | lv_type_0_76= Binary_global_variable | lv_type_0_77= Binary_basic_block | lv_type_0_78= Class_definition | lv_type_0_79= Class_method | lv_type_0_80= Class_member_variable | lv_type_0_81= Class_constructor | lv_type_0_82= Module | lv_type_0_83= Namespace | lv_type_0_84= Interface | lv_type_0_85= System_development | lv_type_0_86= Test | lv_type_0_87= Test_result | lv_type_0_88= Test_status | lv_type_0_89= Test_developmemt | lv_type_0_90= Test_execution )
            int alt6=90;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt6=1;
                }
                break;
            case Real:
                {
                alt6=2;
                }
                break;
            case String:
                {
                alt6=3;
                }
                break;
            case Bool:
                {
                alt6=4;
                }
                break;
            case Range:
                {
                alt6=5;
                }
                break;
            case Aadl:
                {
                alt6=6;
                }
                break;
            case Component:
                {
                alt6=7;
                }
                break;
            case Abstract:
                {
                alt6=8;
                }
                break;
            case Bus:
                {
                alt6=9;
                }
                break;
            case Data:
                {
                alt6=10;
                }
                break;
            case Device:
                {
                alt6=11;
                }
                break;
            case Memory:
                {
                alt6=12;
                }
                break;
            case Processor:
                {
                alt6=13;
                }
                break;
            case Process:
                {
                alt6=14;
                }
                break;
            case Subprogram_group:
                {
                alt6=15;
                }
                break;
            case Subprogram:
                {
                alt6=16;
                }
                break;
            case KW_System:
                {
                alt6=17;
                }
                break;
            case Thread_group:
                {
                alt6=18;
                }
                break;
            case Thread:
                {
                alt6=19;
                }
                break;
            case Virtual_bus:
                {
                alt6=20;
                }
                break;
            case Virtual_processor:
                {
                alt6=21;
                }
                break;
            case Connection:
                {
                alt6=22;
                }
                break;
            case Property:
                {
                alt6=23;
                }
                break;
            case Feature:
                {
                alt6=24;
                }
                break;
            case Port:
                {
                alt6=25;
                }
                break;
            case Data_port:
                {
                alt6=26;
                }
                break;
            case Event_port:
                {
                alt6=27;
                }
                break;
            case Event_data_port:
                {
                alt6=28;
                }
                break;
            case Feature_group:
                {
                alt6=29;
                }
                break;
            case Access:
                {
                alt6=30;
                }
                break;
            case Bus_access:
                {
                alt6=31;
                }
                break;
            case Provides_bus_access:
                {
                alt6=32;
                }
                break;
            case Requires_bus_access:
                {
                alt6=33;
                }
                break;
            case Data_access:
                {
                alt6=34;
                }
                break;
            case Provides_data_access:
                {
                alt6=35;
                }
                break;
            case Requires_data_access:
                {
                alt6=36;
                }
                break;
            case Subprogram_access:
                {
                alt6=37;
                }
                break;
            case Provides_subprogram_access:
                {
                alt6=38;
                }
                break;
            case Requires_subprogram_access:
                {
                alt6=39;
                }
                break;
            case Subprogram_group_access:
                {
                alt6=40;
                }
                break;
            case Provides_subprogram_group_access:
                {
                alt6=41;
                }
                break;
            case Requires_subprogram_group_access:
                {
                alt6=42;
                }
                break;
            case Flow_specification:
                {
                alt6=43;
                }
                break;
            case End_to_end_flow:
                {
                alt6=44;
                }
                break;
            case Entity:
                {
                alt6=45;
                }
                break;
            case Agent:
                {
                alt6=46;
                }
                break;
            case Activity:
                {
                alt6=47;
                }
                break;
            case Thing:
                {
                alt6=48;
                }
                break;
            case Analysis_activity:
                {
                alt6=49;
                }
                break;
            case Analysis_report:
                {
                alt6=50;
                }
                break;
            case Analysis_result:
                {
                alt6=51;
                }
                break;
            case Analysis_annotation_type:
                {
                alt6=52;
                }
                break;
            case Precondition:
                {
                alt6=53;
                }
                break;
            case Postcondition:
                {
                alt6=54;
                }
                break;
            case Invariant:
                {
                alt6=55;
                }
                break;
            case Analysis_annotation:
                {
                alt6=56;
                }
                break;
            case Hazard:
                {
                alt6=57;
                }
                break;
            case Hazard_identification:
                {
                alt6=58;
                }
                break;
            case Requirement:
                {
                alt6=59;
                }
                break;
            case Data_dictionary_term:
                {
                alt6=60;
                }
                break;
            case Requirement_development:
                {
                alt6=61;
                }
                break;
            case Review:
                {
                alt6=62;
                }
                break;
            case Review_log:
                {
                alt6=63;
                }
                break;
            case Review_state:
                {
                alt6=64;
                }
                break;
            case File:
                {
                alt6=65;
                }
                break;
            case Format:
                {
                alt6=66;
                }
                break;
            case Code_development:
                {
                alt6=67;
                }
                break;
            case Build:
                {
                alt6=68;
                }
                break;
            case Code_gen:
                {
                alt6=69;
                }
                break;
            case Compile:
                {
                alt6=70;
                }
                break;
            case Package_file:
                {
                alt6=71;
                }
                break;
            case Component_type:
                {
                alt6=72;
                }
                break;
            case Source_function:
                {
                alt6=73;
                }
                break;
            case Binary_function:
                {
                alt6=74;
                }
                break;
            case Source_global_variable:
                {
                alt6=75;
                }
                break;
            case Binary_global_variable:
                {
                alt6=76;
                }
                break;
            case Binary_basic_block:
                {
                alt6=77;
                }
                break;
            case Class_definition:
                {
                alt6=78;
                }
                break;
            case Class_method:
                {
                alt6=79;
                }
                break;
            case Class_member_variable:
                {
                alt6=80;
                }
                break;
            case Class_constructor:
                {
                alt6=81;
                }
                break;
            case Module:
                {
                alt6=82;
                }
                break;
            case Namespace:
                {
                alt6=83;
                }
                break;
            case Interface:
                {
                alt6=84;
                }
                break;
            case System_development:
                {
                alt6=85;
                }
                break;
            case Test:
                {
                alt6=86;
                }
                break;
            case Test_result:
                {
                alt6=87;
                }
                break;
            case Test_status:
                {
                alt6=88;
                }
                break;
            case Test_developmemt:
                {
                alt6=89;
                }
                break;
            case Test_execution:
                {
                alt6=90;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalResoluteParser.g:518:3: lv_type_0_1= Int
                    {
                    lv_type_0_1=(Token)match(input,Int,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_1, grammarAccess.getBaseTypeAccess().getTypeIntKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:531:8: lv_type_0_2= Real
                    {
                    lv_type_0_2=(Token)match(input,Real,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_2, grammarAccess.getBaseTypeAccess().getTypeRealKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:544:8: lv_type_0_3= String
                    {
                    lv_type_0_3=(Token)match(input,String,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_3, grammarAccess.getBaseTypeAccess().getTypeStringKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_3, null);
                      	    
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:557:8: lv_type_0_4= Bool
                    {
                    lv_type_0_4=(Token)match(input,Bool,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_4, grammarAccess.getBaseTypeAccess().getTypeBoolKeyword_0_3());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_4, null);
                      	    
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:570:8: lv_type_0_5= Range
                    {
                    lv_type_0_5=(Token)match(input,Range,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_5, grammarAccess.getBaseTypeAccess().getTypeRangeKeyword_0_4());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_5, null);
                      	    
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:583:8: lv_type_0_6= Aadl
                    {
                    lv_type_0_6=(Token)match(input,Aadl,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_6, grammarAccess.getBaseTypeAccess().getTypeAadlKeyword_0_5());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_6, null);
                      	    
                    }

                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:596:8: lv_type_0_7= Component
                    {
                    lv_type_0_7=(Token)match(input,Component,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_7, grammarAccess.getBaseTypeAccess().getTypeComponentKeyword_0_6());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_7, null);
                      	    
                    }

                    }
                    break;
                case 8 :
                    // InternalResoluteParser.g:609:8: lv_type_0_8= Abstract
                    {
                    lv_type_0_8=(Token)match(input,Abstract,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_8, grammarAccess.getBaseTypeAccess().getTypeAbstractKeyword_0_7());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_8, null);
                      	    
                    }

                    }
                    break;
                case 9 :
                    // InternalResoluteParser.g:622:8: lv_type_0_9= Bus
                    {
                    lv_type_0_9=(Token)match(input,Bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_9, grammarAccess.getBaseTypeAccess().getTypeBusKeyword_0_8());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_9, null);
                      	    
                    }

                    }
                    break;
                case 10 :
                    // InternalResoluteParser.g:635:8: lv_type_0_10= Data
                    {
                    lv_type_0_10=(Token)match(input,Data,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_10, grammarAccess.getBaseTypeAccess().getTypeDataKeyword_0_9());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_10, null);
                      	    
                    }

                    }
                    break;
                case 11 :
                    // InternalResoluteParser.g:648:8: lv_type_0_11= Device
                    {
                    lv_type_0_11=(Token)match(input,Device,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_11, grammarAccess.getBaseTypeAccess().getTypeDeviceKeyword_0_10());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_11, null);
                      	    
                    }

                    }
                    break;
                case 12 :
                    // InternalResoluteParser.g:661:8: lv_type_0_12= Memory
                    {
                    lv_type_0_12=(Token)match(input,Memory,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_12, grammarAccess.getBaseTypeAccess().getTypeMemoryKeyword_0_11());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_12, null);
                      	    
                    }

                    }
                    break;
                case 13 :
                    // InternalResoluteParser.g:674:8: lv_type_0_13= Processor
                    {
                    lv_type_0_13=(Token)match(input,Processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_13, grammarAccess.getBaseTypeAccess().getTypeProcessorKeyword_0_12());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_13, null);
                      	    
                    }

                    }
                    break;
                case 14 :
                    // InternalResoluteParser.g:687:8: lv_type_0_14= Process
                    {
                    lv_type_0_14=(Token)match(input,Process,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_14, grammarAccess.getBaseTypeAccess().getTypeProcessKeyword_0_13());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_14, null);
                      	    
                    }

                    }
                    break;
                case 15 :
                    // InternalResoluteParser.g:700:8: lv_type_0_15= Subprogram_group
                    {
                    lv_type_0_15=(Token)match(input,Subprogram_group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_15, grammarAccess.getBaseTypeAccess().getTypeSubprogram_groupKeyword_0_14());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_15, null);
                      	    
                    }

                    }
                    break;
                case 16 :
                    // InternalResoluteParser.g:713:8: lv_type_0_16= Subprogram
                    {
                    lv_type_0_16=(Token)match(input,Subprogram,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_16, grammarAccess.getBaseTypeAccess().getTypeSubprogramKeyword_0_15());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_16, null);
                      	    
                    }

                    }
                    break;
                case 17 :
                    // InternalResoluteParser.g:726:8: lv_type_0_17= KW_System
                    {
                    lv_type_0_17=(Token)match(input,KW_System,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_17, grammarAccess.getBaseTypeAccess().getTypeSystemKeyword_0_16());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_17, null);
                      	    
                    }

                    }
                    break;
                case 18 :
                    // InternalResoluteParser.g:739:8: lv_type_0_18= Thread_group
                    {
                    lv_type_0_18=(Token)match(input,Thread_group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_18, grammarAccess.getBaseTypeAccess().getTypeThread_groupKeyword_0_17());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_18, null);
                      	    
                    }

                    }
                    break;
                case 19 :
                    // InternalResoluteParser.g:752:8: lv_type_0_19= Thread
                    {
                    lv_type_0_19=(Token)match(input,Thread,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_19, grammarAccess.getBaseTypeAccess().getTypeThreadKeyword_0_18());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_19, null);
                      	    
                    }

                    }
                    break;
                case 20 :
                    // InternalResoluteParser.g:765:8: lv_type_0_20= Virtual_bus
                    {
                    lv_type_0_20=(Token)match(input,Virtual_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_20, grammarAccess.getBaseTypeAccess().getTypeVirtual_busKeyword_0_19());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_20, null);
                      	    
                    }

                    }
                    break;
                case 21 :
                    // InternalResoluteParser.g:778:8: lv_type_0_21= Virtual_processor
                    {
                    lv_type_0_21=(Token)match(input,Virtual_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_21, grammarAccess.getBaseTypeAccess().getTypeVirtual_processorKeyword_0_20());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_21, null);
                      	    
                    }

                    }
                    break;
                case 22 :
                    // InternalResoluteParser.g:791:8: lv_type_0_22= Connection
                    {
                    lv_type_0_22=(Token)match(input,Connection,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_22, grammarAccess.getBaseTypeAccess().getTypeConnectionKeyword_0_21());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_22, null);
                      	    
                    }

                    }
                    break;
                case 23 :
                    // InternalResoluteParser.g:804:8: lv_type_0_23= Property
                    {
                    lv_type_0_23=(Token)match(input,Property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_23, grammarAccess.getBaseTypeAccess().getTypePropertyKeyword_0_22());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_23, null);
                      	    
                    }

                    }
                    break;
                case 24 :
                    // InternalResoluteParser.g:817:8: lv_type_0_24= Feature
                    {
                    lv_type_0_24=(Token)match(input,Feature,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_24, grammarAccess.getBaseTypeAccess().getTypeFeatureKeyword_0_23());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_24, null);
                      	    
                    }

                    }
                    break;
                case 25 :
                    // InternalResoluteParser.g:830:8: lv_type_0_25= Port
                    {
                    lv_type_0_25=(Token)match(input,Port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_25, grammarAccess.getBaseTypeAccess().getTypePortKeyword_0_24());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_25, null);
                      	    
                    }

                    }
                    break;
                case 26 :
                    // InternalResoluteParser.g:843:8: lv_type_0_26= Data_port
                    {
                    lv_type_0_26=(Token)match(input,Data_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_26, grammarAccess.getBaseTypeAccess().getTypeData_portKeyword_0_25());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_26, null);
                      	    
                    }

                    }
                    break;
                case 27 :
                    // InternalResoluteParser.g:856:8: lv_type_0_27= Event_port
                    {
                    lv_type_0_27=(Token)match(input,Event_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_27, grammarAccess.getBaseTypeAccess().getTypeEvent_portKeyword_0_26());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_27, null);
                      	    
                    }

                    }
                    break;
                case 28 :
                    // InternalResoluteParser.g:869:8: lv_type_0_28= Event_data_port
                    {
                    lv_type_0_28=(Token)match(input,Event_data_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_28, grammarAccess.getBaseTypeAccess().getTypeEvent_data_portKeyword_0_27());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_28, null);
                      	    
                    }

                    }
                    break;
                case 29 :
                    // InternalResoluteParser.g:882:8: lv_type_0_29= Feature_group
                    {
                    lv_type_0_29=(Token)match(input,Feature_group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_29, grammarAccess.getBaseTypeAccess().getTypeFeature_groupKeyword_0_28());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_29, null);
                      	    
                    }

                    }
                    break;
                case 30 :
                    // InternalResoluteParser.g:895:8: lv_type_0_30= Access
                    {
                    lv_type_0_30=(Token)match(input,Access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_30, grammarAccess.getBaseTypeAccess().getTypeAccessKeyword_0_29());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_30, null);
                      	    
                    }

                    }
                    break;
                case 31 :
                    // InternalResoluteParser.g:908:8: lv_type_0_31= Bus_access
                    {
                    lv_type_0_31=(Token)match(input,Bus_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_31, grammarAccess.getBaseTypeAccess().getTypeBus_accessKeyword_0_30());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_31, null);
                      	    
                    }

                    }
                    break;
                case 32 :
                    // InternalResoluteParser.g:921:8: lv_type_0_32= Provides_bus_access
                    {
                    lv_type_0_32=(Token)match(input,Provides_bus_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_32, grammarAccess.getBaseTypeAccess().getTypeProvides_bus_accessKeyword_0_31());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_32, null);
                      	    
                    }

                    }
                    break;
                case 33 :
                    // InternalResoluteParser.g:934:8: lv_type_0_33= Requires_bus_access
                    {
                    lv_type_0_33=(Token)match(input,Requires_bus_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_33, grammarAccess.getBaseTypeAccess().getTypeRequires_bus_accessKeyword_0_32());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_33, null);
                      	    
                    }

                    }
                    break;
                case 34 :
                    // InternalResoluteParser.g:947:8: lv_type_0_34= Data_access
                    {
                    lv_type_0_34=(Token)match(input,Data_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_34, grammarAccess.getBaseTypeAccess().getTypeData_accessKeyword_0_33());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_34, null);
                      	    
                    }

                    }
                    break;
                case 35 :
                    // InternalResoluteParser.g:960:8: lv_type_0_35= Provides_data_access
                    {
                    lv_type_0_35=(Token)match(input,Provides_data_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_35, grammarAccess.getBaseTypeAccess().getTypeProvides_data_accessKeyword_0_34());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_35, null);
                      	    
                    }

                    }
                    break;
                case 36 :
                    // InternalResoluteParser.g:973:8: lv_type_0_36= Requires_data_access
                    {
                    lv_type_0_36=(Token)match(input,Requires_data_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_36, grammarAccess.getBaseTypeAccess().getTypeRequires_data_accessKeyword_0_35());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_36, null);
                      	    
                    }

                    }
                    break;
                case 37 :
                    // InternalResoluteParser.g:986:8: lv_type_0_37= Subprogram_access
                    {
                    lv_type_0_37=(Token)match(input,Subprogram_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_37, grammarAccess.getBaseTypeAccess().getTypeSubprogram_accessKeyword_0_36());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_37, null);
                      	    
                    }

                    }
                    break;
                case 38 :
                    // InternalResoluteParser.g:999:8: lv_type_0_38= Provides_subprogram_access
                    {
                    lv_type_0_38=(Token)match(input,Provides_subprogram_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_38, grammarAccess.getBaseTypeAccess().getTypeProvides_subprogram_accessKeyword_0_37());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_38, null);
                      	    
                    }

                    }
                    break;
                case 39 :
                    // InternalResoluteParser.g:1012:8: lv_type_0_39= Requires_subprogram_access
                    {
                    lv_type_0_39=(Token)match(input,Requires_subprogram_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_39, grammarAccess.getBaseTypeAccess().getTypeRequires_subprogram_accessKeyword_0_38());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_39, null);
                      	    
                    }

                    }
                    break;
                case 40 :
                    // InternalResoluteParser.g:1025:8: lv_type_0_40= Subprogram_group_access
                    {
                    lv_type_0_40=(Token)match(input,Subprogram_group_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_40, grammarAccess.getBaseTypeAccess().getTypeSubprogram_group_accessKeyword_0_39());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_40, null);
                      	    
                    }

                    }
                    break;
                case 41 :
                    // InternalResoluteParser.g:1038:8: lv_type_0_41= Provides_subprogram_group_access
                    {
                    lv_type_0_41=(Token)match(input,Provides_subprogram_group_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_41, grammarAccess.getBaseTypeAccess().getTypeProvides_subprogram_group_accessKeyword_0_40());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_41, null);
                      	    
                    }

                    }
                    break;
                case 42 :
                    // InternalResoluteParser.g:1051:8: lv_type_0_42= Requires_subprogram_group_access
                    {
                    lv_type_0_42=(Token)match(input,Requires_subprogram_group_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_42, grammarAccess.getBaseTypeAccess().getTypeRequires_subprogram_group_accessKeyword_0_41());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_42, null);
                      	    
                    }

                    }
                    break;
                case 43 :
                    // InternalResoluteParser.g:1064:8: lv_type_0_43= Flow_specification
                    {
                    lv_type_0_43=(Token)match(input,Flow_specification,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_43, grammarAccess.getBaseTypeAccess().getTypeFlow_specificationKeyword_0_42());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_43, null);
                      	    
                    }

                    }
                    break;
                case 44 :
                    // InternalResoluteParser.g:1077:8: lv_type_0_44= End_to_end_flow
                    {
                    lv_type_0_44=(Token)match(input,End_to_end_flow,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_44, grammarAccess.getBaseTypeAccess().getTypeEnd_to_end_flowKeyword_0_43());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_44, null);
                      	    
                    }

                    }
                    break;
                case 45 :
                    // InternalResoluteParser.g:1090:8: lv_type_0_45= Entity
                    {
                    lv_type_0_45=(Token)match(input,Entity,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_45, grammarAccess.getBaseTypeAccess().getTypeEntityKeyword_0_44());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_45, null);
                      	    
                    }

                    }
                    break;
                case 46 :
                    // InternalResoluteParser.g:1103:8: lv_type_0_46= Agent
                    {
                    lv_type_0_46=(Token)match(input,Agent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_46, grammarAccess.getBaseTypeAccess().getTypeAgentKeyword_0_45());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_46, null);
                      	    
                    }

                    }
                    break;
                case 47 :
                    // InternalResoluteParser.g:1116:8: lv_type_0_47= Activity
                    {
                    lv_type_0_47=(Token)match(input,Activity,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_47, grammarAccess.getBaseTypeAccess().getTypeActivityKeyword_0_46());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_47, null);
                      	    
                    }

                    }
                    break;
                case 48 :
                    // InternalResoluteParser.g:1129:8: lv_type_0_48= Thing
                    {
                    lv_type_0_48=(Token)match(input,Thing,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_48, grammarAccess.getBaseTypeAccess().getTypeThingKeyword_0_47());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_48, null);
                      	    
                    }

                    }
                    break;
                case 49 :
                    // InternalResoluteParser.g:1142:8: lv_type_0_49= Analysis_activity
                    {
                    lv_type_0_49=(Token)match(input,Analysis_activity,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_49, grammarAccess.getBaseTypeAccess().getTypeAnalysis_activityKeyword_0_48());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_49, null);
                      	    
                    }

                    }
                    break;
                case 50 :
                    // InternalResoluteParser.g:1155:8: lv_type_0_50= Analysis_report
                    {
                    lv_type_0_50=(Token)match(input,Analysis_report,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_50, grammarAccess.getBaseTypeAccess().getTypeAnalysis_reportKeyword_0_49());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_50, null);
                      	    
                    }

                    }
                    break;
                case 51 :
                    // InternalResoluteParser.g:1168:8: lv_type_0_51= Analysis_result
                    {
                    lv_type_0_51=(Token)match(input,Analysis_result,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_51, grammarAccess.getBaseTypeAccess().getTypeAnalysis_resultKeyword_0_50());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_51, null);
                      	    
                    }

                    }
                    break;
                case 52 :
                    // InternalResoluteParser.g:1181:8: lv_type_0_52= Analysis_annotation_type
                    {
                    lv_type_0_52=(Token)match(input,Analysis_annotation_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_52, grammarAccess.getBaseTypeAccess().getTypeAnalysis_annotation_typeKeyword_0_51());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_52, null);
                      	    
                    }

                    }
                    break;
                case 53 :
                    // InternalResoluteParser.g:1194:8: lv_type_0_53= Precondition
                    {
                    lv_type_0_53=(Token)match(input,Precondition,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_53, grammarAccess.getBaseTypeAccess().getTypePreconditionKeyword_0_52());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_53, null);
                      	    
                    }

                    }
                    break;
                case 54 :
                    // InternalResoluteParser.g:1207:8: lv_type_0_54= Postcondition
                    {
                    lv_type_0_54=(Token)match(input,Postcondition,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_54, grammarAccess.getBaseTypeAccess().getTypePostconditionKeyword_0_53());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_54, null);
                      	    
                    }

                    }
                    break;
                case 55 :
                    // InternalResoluteParser.g:1220:8: lv_type_0_55= Invariant
                    {
                    lv_type_0_55=(Token)match(input,Invariant,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_55, grammarAccess.getBaseTypeAccess().getTypeInvariantKeyword_0_54());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_55, null);
                      	    
                    }

                    }
                    break;
                case 56 :
                    // InternalResoluteParser.g:1233:8: lv_type_0_56= Analysis_annotation
                    {
                    lv_type_0_56=(Token)match(input,Analysis_annotation,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_56, grammarAccess.getBaseTypeAccess().getTypeAnalysis_annotationKeyword_0_55());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_56, null);
                      	    
                    }

                    }
                    break;
                case 57 :
                    // InternalResoluteParser.g:1246:8: lv_type_0_57= Hazard
                    {
                    lv_type_0_57=(Token)match(input,Hazard,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_57, grammarAccess.getBaseTypeAccess().getTypeHazardKeyword_0_56());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_57, null);
                      	    
                    }

                    }
                    break;
                case 58 :
                    // InternalResoluteParser.g:1259:8: lv_type_0_58= Hazard_identification
                    {
                    lv_type_0_58=(Token)match(input,Hazard_identification,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_58, grammarAccess.getBaseTypeAccess().getTypeHazard_identificationKeyword_0_57());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_58, null);
                      	    
                    }

                    }
                    break;
                case 59 :
                    // InternalResoluteParser.g:1272:8: lv_type_0_59= Requirement
                    {
                    lv_type_0_59=(Token)match(input,Requirement,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_59, grammarAccess.getBaseTypeAccess().getTypeRequirementKeyword_0_58());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_59, null);
                      	    
                    }

                    }
                    break;
                case 60 :
                    // InternalResoluteParser.g:1285:8: lv_type_0_60= Data_dictionary_term
                    {
                    lv_type_0_60=(Token)match(input,Data_dictionary_term,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_60, grammarAccess.getBaseTypeAccess().getTypeData_dictionary_termKeyword_0_59());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_60, null);
                      	    
                    }

                    }
                    break;
                case 61 :
                    // InternalResoluteParser.g:1298:8: lv_type_0_61= Requirement_development
                    {
                    lv_type_0_61=(Token)match(input,Requirement_development,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_61, grammarAccess.getBaseTypeAccess().getTypeRequirement_developmentKeyword_0_60());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_61, null);
                      	    
                    }

                    }
                    break;
                case 62 :
                    // InternalResoluteParser.g:1311:8: lv_type_0_62= Review
                    {
                    lv_type_0_62=(Token)match(input,Review,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_62, grammarAccess.getBaseTypeAccess().getTypeReviewKeyword_0_61());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_62, null);
                      	    
                    }

                    }
                    break;
                case 63 :
                    // InternalResoluteParser.g:1324:8: lv_type_0_63= Review_log
                    {
                    lv_type_0_63=(Token)match(input,Review_log,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_63, grammarAccess.getBaseTypeAccess().getTypeReview_logKeyword_0_62());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_63, null);
                      	    
                    }

                    }
                    break;
                case 64 :
                    // InternalResoluteParser.g:1337:8: lv_type_0_64= Review_state
                    {
                    lv_type_0_64=(Token)match(input,Review_state,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_64, grammarAccess.getBaseTypeAccess().getTypeReview_stateKeyword_0_63());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_64, null);
                      	    
                    }

                    }
                    break;
                case 65 :
                    // InternalResoluteParser.g:1350:8: lv_type_0_65= File
                    {
                    lv_type_0_65=(Token)match(input,File,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_65, grammarAccess.getBaseTypeAccess().getTypeFileKeyword_0_64());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_65, null);
                      	    
                    }

                    }
                    break;
                case 66 :
                    // InternalResoluteParser.g:1363:8: lv_type_0_66= Format
                    {
                    lv_type_0_66=(Token)match(input,Format,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_66, grammarAccess.getBaseTypeAccess().getTypeFormatKeyword_0_65());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_66, null);
                      	    
                    }

                    }
                    break;
                case 67 :
                    // InternalResoluteParser.g:1376:8: lv_type_0_67= Code_development
                    {
                    lv_type_0_67=(Token)match(input,Code_development,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_67, grammarAccess.getBaseTypeAccess().getTypeCode_developmentKeyword_0_66());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_67, null);
                      	    
                    }

                    }
                    break;
                case 68 :
                    // InternalResoluteParser.g:1389:8: lv_type_0_68= Build
                    {
                    lv_type_0_68=(Token)match(input,Build,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_68, grammarAccess.getBaseTypeAccess().getTypeBuildKeyword_0_67());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_68, null);
                      	    
                    }

                    }
                    break;
                case 69 :
                    // InternalResoluteParser.g:1402:8: lv_type_0_69= Code_gen
                    {
                    lv_type_0_69=(Token)match(input,Code_gen,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_69, grammarAccess.getBaseTypeAccess().getTypeCode_genKeyword_0_68());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_69, null);
                      	    
                    }

                    }
                    break;
                case 70 :
                    // InternalResoluteParser.g:1415:8: lv_type_0_70= Compile
                    {
                    lv_type_0_70=(Token)match(input,Compile,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_70, grammarAccess.getBaseTypeAccess().getTypeCompileKeyword_0_69());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_70, null);
                      	    
                    }

                    }
                    break;
                case 71 :
                    // InternalResoluteParser.g:1428:8: lv_type_0_71= Package_file
                    {
                    lv_type_0_71=(Token)match(input,Package_file,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_71, grammarAccess.getBaseTypeAccess().getTypePackage_fileKeyword_0_70());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_71, null);
                      	    
                    }

                    }
                    break;
                case 72 :
                    // InternalResoluteParser.g:1441:8: lv_type_0_72= Component_type
                    {
                    lv_type_0_72=(Token)match(input,Component_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_72, grammarAccess.getBaseTypeAccess().getTypeComponent_typeKeyword_0_71());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_72, null);
                      	    
                    }

                    }
                    break;
                case 73 :
                    // InternalResoluteParser.g:1454:8: lv_type_0_73= Source_function
                    {
                    lv_type_0_73=(Token)match(input,Source_function,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_73, grammarAccess.getBaseTypeAccess().getTypeSource_functionKeyword_0_72());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_73, null);
                      	    
                    }

                    }
                    break;
                case 74 :
                    // InternalResoluteParser.g:1467:8: lv_type_0_74= Binary_function
                    {
                    lv_type_0_74=(Token)match(input,Binary_function,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_74, grammarAccess.getBaseTypeAccess().getTypeBinary_functionKeyword_0_73());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_74, null);
                      	    
                    }

                    }
                    break;
                case 75 :
                    // InternalResoluteParser.g:1480:8: lv_type_0_75= Source_global_variable
                    {
                    lv_type_0_75=(Token)match(input,Source_global_variable,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_75, grammarAccess.getBaseTypeAccess().getTypeSource_global_variableKeyword_0_74());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_75, null);
                      	    
                    }

                    }
                    break;
                case 76 :
                    // InternalResoluteParser.g:1493:8: lv_type_0_76= Binary_global_variable
                    {
                    lv_type_0_76=(Token)match(input,Binary_global_variable,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_76, grammarAccess.getBaseTypeAccess().getTypeBinary_global_variableKeyword_0_75());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_76, null);
                      	    
                    }

                    }
                    break;
                case 77 :
                    // InternalResoluteParser.g:1506:8: lv_type_0_77= Binary_basic_block
                    {
                    lv_type_0_77=(Token)match(input,Binary_basic_block,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_77, grammarAccess.getBaseTypeAccess().getTypeBinary_basic_blockKeyword_0_76());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_77, null);
                      	    
                    }

                    }
                    break;
                case 78 :
                    // InternalResoluteParser.g:1519:8: lv_type_0_78= Class_definition
                    {
                    lv_type_0_78=(Token)match(input,Class_definition,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_78, grammarAccess.getBaseTypeAccess().getTypeClass_definitionKeyword_0_77());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_78, null);
                      	    
                    }

                    }
                    break;
                case 79 :
                    // InternalResoluteParser.g:1532:8: lv_type_0_79= Class_method
                    {
                    lv_type_0_79=(Token)match(input,Class_method,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_79, grammarAccess.getBaseTypeAccess().getTypeClass_methodKeyword_0_78());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_79, null);
                      	    
                    }

                    }
                    break;
                case 80 :
                    // InternalResoluteParser.g:1545:8: lv_type_0_80= Class_member_variable
                    {
                    lv_type_0_80=(Token)match(input,Class_member_variable,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_80, grammarAccess.getBaseTypeAccess().getTypeClass_member_variableKeyword_0_79());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_80, null);
                      	    
                    }

                    }
                    break;
                case 81 :
                    // InternalResoluteParser.g:1558:8: lv_type_0_81= Class_constructor
                    {
                    lv_type_0_81=(Token)match(input,Class_constructor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_81, grammarAccess.getBaseTypeAccess().getTypeClass_constructorKeyword_0_80());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_81, null);
                      	    
                    }

                    }
                    break;
                case 82 :
                    // InternalResoluteParser.g:1571:8: lv_type_0_82= Module
                    {
                    lv_type_0_82=(Token)match(input,Module,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_82, grammarAccess.getBaseTypeAccess().getTypeModuleKeyword_0_81());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_82, null);
                      	    
                    }

                    }
                    break;
                case 83 :
                    // InternalResoluteParser.g:1584:8: lv_type_0_83= Namespace
                    {
                    lv_type_0_83=(Token)match(input,Namespace,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_83, grammarAccess.getBaseTypeAccess().getTypeNamespaceKeyword_0_82());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_83, null);
                      	    
                    }

                    }
                    break;
                case 84 :
                    // InternalResoluteParser.g:1597:8: lv_type_0_84= Interface
                    {
                    lv_type_0_84=(Token)match(input,Interface,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_84, grammarAccess.getBaseTypeAccess().getTypeInterfaceKeyword_0_83());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_84, null);
                      	    
                    }

                    }
                    break;
                case 85 :
                    // InternalResoluteParser.g:1610:8: lv_type_0_85= System_development
                    {
                    lv_type_0_85=(Token)match(input,System_development,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_85, grammarAccess.getBaseTypeAccess().getTypeSystem_developmentKeyword_0_84());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_85, null);
                      	    
                    }

                    }
                    break;
                case 86 :
                    // InternalResoluteParser.g:1623:8: lv_type_0_86= Test
                    {
                    lv_type_0_86=(Token)match(input,Test,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_86, grammarAccess.getBaseTypeAccess().getTypeTestKeyword_0_85());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_86, null);
                      	    
                    }

                    }
                    break;
                case 87 :
                    // InternalResoluteParser.g:1636:8: lv_type_0_87= Test_result
                    {
                    lv_type_0_87=(Token)match(input,Test_result,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_87, grammarAccess.getBaseTypeAccess().getTypeTest_resultKeyword_0_86());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_87, null);
                      	    
                    }

                    }
                    break;
                case 88 :
                    // InternalResoluteParser.g:1649:8: lv_type_0_88= Test_status
                    {
                    lv_type_0_88=(Token)match(input,Test_status,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_88, grammarAccess.getBaseTypeAccess().getTypeTest_statusKeyword_0_87());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_88, null);
                      	    
                    }

                    }
                    break;
                case 89 :
                    // InternalResoluteParser.g:1662:8: lv_type_0_89= Test_developmemt
                    {
                    lv_type_0_89=(Token)match(input,Test_developmemt,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_89, grammarAccess.getBaseTypeAccess().getTypeTest_developmemtKeyword_0_88());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_89, null);
                      	    
                    }

                    }
                    break;
                case 90 :
                    // InternalResoluteParser.g:1675:8: lv_type_0_90= Test_execution
                    {
                    lv_type_0_90=(Token)match(input,Test_execution,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_90, grammarAccess.getBaseTypeAccess().getTypeTest_executionKeyword_0_89());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBaseTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_90, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseType"


    // $ANTLR start "entryRuleArg"
    // InternalResoluteParser.g:1699:1: entryRuleArg returns [EObject current=null] : iv_ruleArg= ruleArg EOF ;
    public final EObject entryRuleArg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArg = null;


        try {
            // InternalResoluteParser.g:1700:2: (iv_ruleArg= ruleArg EOF )
            // InternalResoluteParser.g:1701:2: iv_ruleArg= ruleArg EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleArg=ruleArg();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArg; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArg"


    // $ANTLR start "ruleArg"
    // InternalResoluteParser.g:1708:1: ruleArg returns [EObject current=null] : ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) ) ;
    public final EObject ruleArg() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_6_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1711:28: ( ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:1712:1: ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:1712:1: ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (synpred1_InternalResoluteParser()) ) {
                    alt7=1;
                }
                else if ( (true) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalResoluteParser.g:1712:2: ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
                    {
                    // InternalResoluteParser.g:1712:2: ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
                    // InternalResoluteParser.g:1712:3: ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
                    {
                    // InternalResoluteParser.g:1723:6: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
                    // InternalResoluteParser.g:1723:7: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) )
                    {
                    // InternalResoluteParser.g:1723:7: ( (lv_name_0_0= RULE_ID ) )
                    // InternalResoluteParser.g:1724:1: (lv_name_0_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1724:1: (lv_name_0_0= RULE_ID )
                    // InternalResoluteParser.g:1725:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_0, grammarAccess.getArgAccess().getNameIDTerminalRuleCall_0_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getArgRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getArgAccess().getColonKeyword_0_0_1());
                          
                    }
                    // InternalResoluteParser.g:1746:1: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:1747:1: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:1747:1: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:1748:3: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArgAccess().getTypeTypeParserRuleCall_0_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_type_2_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArgRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:1765:6: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1765:6: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1765:7: () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1765:7: ()
                    // InternalResoluteParser.g:1766:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getArgAccess().getQuantArgAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:1771:2: ( (lv_name_4_0= RULE_ID ) )
                    // InternalResoluteParser.g:1772:1: (lv_name_4_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1772:1: (lv_name_4_0= RULE_ID )
                    // InternalResoluteParser.g:1773:3: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_4_0, grammarAccess.getArgAccess().getNameIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getArgRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,Colon,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getArgAccess().getColonKeyword_1_2());
                          
                    }
                    // InternalResoluteParser.g:1794:1: ( (lv_expr_6_0= ruleExpr ) )
                    // InternalResoluteParser.g:1795:1: (lv_expr_6_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1795:1: (lv_expr_6_0= ruleExpr )
                    // InternalResoluteParser.g:1796:3: lv_expr_6_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArgAccess().getExprExprParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_6_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArgRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_6_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArg"


    // $ANTLR start "entryRuleConstantDefinition"
    // InternalResoluteParser.g:1820:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // InternalResoluteParser.g:1821:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // InternalResoluteParser.g:1822:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConstantDefinition=ruleConstantDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantDefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantDefinition"


    // $ANTLR start "ruleConstantDefinition"
    // InternalResoluteParser.g:1829:1: ruleConstantDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleConstantDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1832:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) )
            // InternalResoluteParser.g:1833:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // InternalResoluteParser.g:1833:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            // InternalResoluteParser.g:1833:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
            {
            // InternalResoluteParser.g:1833:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:1834:1: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:1834:1: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:1835:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getConstantDefinitionAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConstantDefinitionAccess().getColonKeyword_1());
                  
            }
            // InternalResoluteParser.g:1856:1: ( (lv_type_2_0= ruleType ) )
            // InternalResoluteParser.g:1857:1: (lv_type_2_0= ruleType )
            {
            // InternalResoluteParser.g:1857:1: (lv_type_2_0= ruleType )
            // InternalResoluteParser.g:1858:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_17);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getConstantDefinitionAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalResoluteParser.g:1879:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalResoluteParser.g:1880:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalResoluteParser.g:1880:1: (lv_expr_4_0= ruleExpr )
            // InternalResoluteParser.g:1881:3: lv_expr_4_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getExprExprParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_4_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_4_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantDefinition"


    // $ANTLR start "entryRuleFunctionDefinition"
    // InternalResoluteParser.g:1905:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalResoluteParser.g:1906:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalResoluteParser.g:1907:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDefinition"


    // $ANTLR start "ruleFunctionDefinition"
    // InternalResoluteParser.g:1914:1: ruleFunctionDefinition returns [EObject current=null] : ( ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_claimType_0_0=null;
        Token lv_claimType_1_0=null;
        Token lv_claimType_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_args_5_0 = null;

        EObject lv_args_7_0 = null;

        EObject lv_body_9_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1917:28: ( ( ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) ) ) )
            // InternalResoluteParser.g:1918:1: ( ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) ) )
            {
            // InternalResoluteParser.g:1918:1: ( ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) ) )
            // InternalResoluteParser.g:1918:2: ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) )
            {
            // InternalResoluteParser.g:1918:2: ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )?
            int alt8=4;
            switch ( input.LA(1) ) {
                case Goal:
                    {
                    alt8=1;
                    }
                    break;
                case Conclusion:
                    {
                    alt8=2;
                    }
                    break;
                case Strategy:
                    {
                    alt8=3;
                    }
                    break;
            }

            switch (alt8) {
                case 1 :
                    // InternalResoluteParser.g:1918:3: ( (lv_claimType_0_0= Goal ) )
                    {
                    // InternalResoluteParser.g:1918:3: ( (lv_claimType_0_0= Goal ) )
                    // InternalResoluteParser.g:1919:1: (lv_claimType_0_0= Goal )
                    {
                    // InternalResoluteParser.g:1919:1: (lv_claimType_0_0= Goal )
                    // InternalResoluteParser.g:1920:3: lv_claimType_0_0= Goal
                    {
                    lv_claimType_0_0=(Token)match(input,Goal,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_claimType_0_0, grammarAccess.getFunctionDefinitionAccess().getClaimTypeGoalKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      	        }
                             		setWithLastConsumed(current, "claimType", lv_claimType_0_0, "goal");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:1935:6: ( (lv_claimType_1_0= Conclusion ) )
                    {
                    // InternalResoluteParser.g:1935:6: ( (lv_claimType_1_0= Conclusion ) )
                    // InternalResoluteParser.g:1936:1: (lv_claimType_1_0= Conclusion )
                    {
                    // InternalResoluteParser.g:1936:1: (lv_claimType_1_0= Conclusion )
                    // InternalResoluteParser.g:1937:3: lv_claimType_1_0= Conclusion
                    {
                    lv_claimType_1_0=(Token)match(input,Conclusion,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_claimType_1_0, grammarAccess.getFunctionDefinitionAccess().getClaimTypeConclusionKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      	        }
                             		setWithLastConsumed(current, "claimType", lv_claimType_1_0, "conclusion");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:1952:6: ( (lv_claimType_2_0= Strategy ) )
                    {
                    // InternalResoluteParser.g:1952:6: ( (lv_claimType_2_0= Strategy ) )
                    // InternalResoluteParser.g:1953:1: (lv_claimType_2_0= Strategy )
                    {
                    // InternalResoluteParser.g:1953:1: (lv_claimType_2_0= Strategy )
                    // InternalResoluteParser.g:1954:3: lv_claimType_2_0= Strategy
                    {
                    lv_claimType_2_0=(Token)match(input,Strategy,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_claimType_2_0, grammarAccess.getFunctionDefinitionAccess().getClaimTypeStrategyKeyword_0_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      	        }
                             		setWithLastConsumed(current, "claimType", lv_claimType_2_0, "strategy");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalResoluteParser.g:1968:4: ( (lv_name_3_0= RULE_ID ) )
            // InternalResoluteParser.g:1969:1: (lv_name_3_0= RULE_ID )
            {
            // InternalResoluteParser.g:1969:1: (lv_name_3_0= RULE_ID )
            // InternalResoluteParser.g:1970:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_3_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalResoluteParser.g:1991:1: ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalResoluteParser.g:1991:2: ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )*
                    {
                    // InternalResoluteParser.g:1991:2: ( (lv_args_5_0= ruleArg ) )
                    // InternalResoluteParser.g:1992:1: (lv_args_5_0= ruleArg )
                    {
                    // InternalResoluteParser.g:1992:1: (lv_args_5_0= ruleArg )
                    // InternalResoluteParser.g:1993:3: lv_args_5_0= ruleArg
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getArgsArgParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_20);
                    lv_args_5_0=ruleArg();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_5_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Arg");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalResoluteParser.g:2009:2: (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==Comma) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalResoluteParser.g:2010:2: otherlv_6= Comma ( (lv_args_7_0= ruleArg ) )
                    	    {
                    	    otherlv_6=(Token)match(input,Comma,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:2014:1: ( (lv_args_7_0= ruleArg ) )
                    	    // InternalResoluteParser.g:2015:1: (lv_args_7_0= ruleArg )
                    	    {
                    	    // InternalResoluteParser.g:2015:1: (lv_args_7_0= ruleArg )
                    	    // InternalResoluteParser.g:2016:3: lv_args_7_0= ruleArg
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getArgsArgParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_20);
                    	    lv_args_7_0=ruleArg();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_7_0, 
                    	              		"com.rockwellcollins.atc.resolute.Resolute.Arg");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_4());
                  
            }
            // InternalResoluteParser.g:2037:1: ( (lv_body_9_0= ruleDefinitionBody ) )
            // InternalResoluteParser.g:2038:1: (lv_body_9_0= ruleDefinitionBody )
            {
            // InternalResoluteParser.g:2038:1: (lv_body_9_0= ruleDefinitionBody )
            // InternalResoluteParser.g:2039:3: lv_body_9_0= ruleDefinitionBody
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBodyDefinitionBodyParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_body_9_0=ruleDefinitionBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_9_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.DefinitionBody");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDefinition"


    // $ANTLR start "entryRuleDefinitionBody"
    // InternalResoluteParser.g:2063:1: entryRuleDefinitionBody returns [EObject current=null] : iv_ruleDefinitionBody= ruleDefinitionBody EOF ;
    public final EObject entryRuleDefinitionBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionBody = null;


        try {
            // InternalResoluteParser.g:2064:2: (iv_ruleDefinitionBody= ruleDefinitionBody EOF )
            // InternalResoluteParser.g:2065:2: iv_ruleDefinitionBody= ruleDefinitionBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefinitionBodyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDefinitionBody=ruleDefinitionBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefinitionBody; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinitionBody"


    // $ANTLR start "ruleDefinitionBody"
    // InternalResoluteParser.g:2072:1: ruleDefinitionBody returns [EObject current=null] : ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) ) ;
    public final EObject ruleDefinitionBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;

        EObject lv_claim_8_0 = null;

        EObject lv_attributes_10_0 = null;

        EObject lv_expr_11_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2075:28: ( ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:2076:1: ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:2076:1: ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Colon) ) {
                alt13=1;
            }
            else if ( (LA13_0==LessThanSignEqualsSign) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalResoluteParser.g:2076:2: ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:2076:2: ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:2076:3: () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:2076:3: ()
                    // InternalResoluteParser.g:2077:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDefinitionBodyAccess().getFunctionBodyAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDefinitionBodyAccess().getColonKeyword_0_1());
                          
                    }
                    // InternalResoluteParser.g:2087:1: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:2088:1: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:2088:1: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:2089:3: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getTypeTypeParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_17);
                    lv_type_2_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDefinitionBodyAccess().getEqualsSignKeyword_0_3());
                          
                    }
                    // InternalResoluteParser.g:2110:1: ( (lv_expr_4_0= ruleExpr ) )
                    // InternalResoluteParser.g:2111:1: (lv_expr_4_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:2111:1: (lv_expr_4_0= ruleExpr )
                    // InternalResoluteParser.g:2112:3: lv_expr_4_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getExprExprParserRuleCall_0_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_4_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_4_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:2129:6: ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:2129:6: ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:2129:7: () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:2129:7: ()
                    // InternalResoluteParser.g:2130:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getDefinitionBodyAccess().getClaimBodyAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_6=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDefinitionBodyAccess().getLessThanSignEqualsSignKeyword_1_1());
                          
                    }
                    // InternalResoluteParser.g:2140:1: (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk )
                    // InternalResoluteParser.g:2141:2: otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk
                    {
                    otherlv_7=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDefinitionBodyAccess().getAsteriskAsteriskKeyword_1_2_0());
                          
                    }
                    // InternalResoluteParser.g:2145:1: ( (lv_claim_8_0= ruleClaimText ) )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalResoluteParser.g:2146:1: (lv_claim_8_0= ruleClaimText )
                    	    {
                    	    // InternalResoluteParser.g:2146:1: (lv_claim_8_0= ruleClaimText )
                    	    // InternalResoluteParser.g:2147:3: lv_claim_8_0= ruleClaimText
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getClaimClaimTextParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_24);
                    	    lv_claim_8_0=ruleClaimText();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"claim",
                    	              		lv_claim_8_0, 
                    	              		"com.rockwellcollins.atc.resolute.Resolute.ClaimText");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    otherlv_9=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getDefinitionBodyAccess().getAsteriskAsteriskKeyword_1_2_2());
                          
                    }

                    }

                    // InternalResoluteParser.g:2168:2: ( (lv_attributes_10_0= ruleClaimAttribute ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Justification||LA12_0==Restriction||LA12_0==Assumption||LA12_0==Rationale||LA12_0==Strategy||LA12_0==Context||LA12_0==Domain) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalResoluteParser.g:2169:1: (lv_attributes_10_0= ruleClaimAttribute )
                    	    {
                    	    // InternalResoluteParser.g:2169:1: (lv_attributes_10_0= ruleClaimAttribute )
                    	    // InternalResoluteParser.g:2170:3: lv_attributes_10_0= ruleClaimAttribute
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getAttributesClaimAttributeParserRuleCall_1_3_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_25);
                    	    lv_attributes_10_0=ruleClaimAttribute();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"attributes",
                    	              		lv_attributes_10_0, 
                    	              		"com.rockwellcollins.atc.resolute.Resolute.ClaimAttribute");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // InternalResoluteParser.g:2186:3: ( (lv_expr_11_0= ruleExpr ) )
                    // InternalResoluteParser.g:2187:1: (lv_expr_11_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:2187:1: (lv_expr_11_0= ruleExpr )
                    // InternalResoluteParser.g:2188:3: lv_expr_11_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getExprExprParserRuleCall_1_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_11_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_11_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinitionBody"


    // $ANTLR start "entryRuleClaimAttribute"
    // InternalResoluteParser.g:2212:1: entryRuleClaimAttribute returns [EObject current=null] : iv_ruleClaimAttribute= ruleClaimAttribute EOF ;
    public final EObject entryRuleClaimAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimAttribute = null;


        try {
            // InternalResoluteParser.g:2213:2: (iv_ruleClaimAttribute= ruleClaimAttribute EOF )
            // InternalResoluteParser.g:2214:2: iv_ruleClaimAttribute= ruleClaimAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimAttribute=ruleClaimAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimAttribute; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimAttribute"


    // $ANTLR start "ruleClaimAttribute"
    // InternalResoluteParser.g:2221:1: ruleClaimAttribute returns [EObject current=null] : (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy | this_ClaimUsageDomain_4= ruleClaimUsageDomain | this_ClaimRationale_5= ruleClaimRationale | this_ClaimRestriction_6= ruleClaimRestriction ) ;
    public final EObject ruleClaimAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_ClaimContext_0 = null;

        EObject this_ClaimJustification_1 = null;

        EObject this_ClaimAssumption_2 = null;

        EObject this_ClaimStrategy_3 = null;

        EObject this_ClaimUsageDomain_4 = null;

        EObject this_ClaimRationale_5 = null;

        EObject this_ClaimRestriction_6 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2224:28: ( (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy | this_ClaimUsageDomain_4= ruleClaimUsageDomain | this_ClaimRationale_5= ruleClaimRationale | this_ClaimRestriction_6= ruleClaimRestriction ) )
            // InternalResoluteParser.g:2225:1: (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy | this_ClaimUsageDomain_4= ruleClaimUsageDomain | this_ClaimRationale_5= ruleClaimRationale | this_ClaimRestriction_6= ruleClaimRestriction )
            {
            // InternalResoluteParser.g:2225:1: (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy | this_ClaimUsageDomain_4= ruleClaimUsageDomain | this_ClaimRationale_5= ruleClaimRationale | this_ClaimRestriction_6= ruleClaimRestriction )
            int alt14=7;
            switch ( input.LA(1) ) {
            case Context:
                {
                alt14=1;
                }
                break;
            case Justification:
                {
                alt14=2;
                }
                break;
            case Assumption:
                {
                alt14=3;
                }
                break;
            case Strategy:
                {
                alt14=4;
                }
                break;
            case Domain:
                {
                alt14=5;
                }
                break;
            case Rationale:
                {
                alt14=6;
                }
                break;
            case Restriction:
                {
                alt14=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalResoluteParser.g:2226:5: this_ClaimContext_0= ruleClaimContext
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClaimAttributeAccess().getClaimContextParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClaimContext_0=ruleClaimContext();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClaimContext_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:2236:5: this_ClaimJustification_1= ruleClaimJustification
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClaimAttributeAccess().getClaimJustificationParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClaimJustification_1=ruleClaimJustification();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClaimJustification_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:2246:5: this_ClaimAssumption_2= ruleClaimAssumption
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClaimAttributeAccess().getClaimAssumptionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClaimAssumption_2=ruleClaimAssumption();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClaimAssumption_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:2256:5: this_ClaimStrategy_3= ruleClaimStrategy
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClaimAttributeAccess().getClaimStrategyParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClaimStrategy_3=ruleClaimStrategy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClaimStrategy_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:2266:5: this_ClaimUsageDomain_4= ruleClaimUsageDomain
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClaimAttributeAccess().getClaimUsageDomainParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClaimUsageDomain_4=ruleClaimUsageDomain();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClaimUsageDomain_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:2276:5: this_ClaimRationale_5= ruleClaimRationale
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClaimAttributeAccess().getClaimRationaleParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClaimRationale_5=ruleClaimRationale();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClaimRationale_5;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:2286:5: this_ClaimRestriction_6= ruleClaimRestriction
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClaimAttributeAccess().getClaimRestrictionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClaimRestriction_6=ruleClaimRestriction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClaimRestriction_6;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimAttribute"


    // $ANTLR start "entryRuleClaimContext"
    // InternalResoluteParser.g:2302:1: entryRuleClaimContext returns [EObject current=null] : iv_ruleClaimContext= ruleClaimContext EOF ;
    public final EObject entryRuleClaimContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimContext = null;


        try {
            // InternalResoluteParser.g:2303:2: (iv_ruleClaimContext= ruleClaimContext EOF )
            // InternalResoluteParser.g:2304:2: iv_ruleClaimContext= ruleClaimContext EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimContextRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimContext=ruleClaimContext();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimContext; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimContext"


    // $ANTLR start "ruleClaimContext"
    // InternalResoluteParser.g:2311:1: ruleClaimContext returns [EObject current=null] : (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2314:28: ( (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2315:1: (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2315:1: (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2316:2: otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Context,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimContextAccess().getContextKeyword_0());
                  
            }
            // InternalResoluteParser.g:2320:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2321:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2321:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2322:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClaimContextAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClaimContextRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimContextAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:2343:1: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:2344:1: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:2344:1: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:2345:3: lv_expr_3_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimContextAccess().getExprExprParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_expr_3_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimContextRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_3_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClaimContextAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimContext"


    // $ANTLR start "entryRuleClaimUsageDomain"
    // InternalResoluteParser.g:2374:1: entryRuleClaimUsageDomain returns [EObject current=null] : iv_ruleClaimUsageDomain= ruleClaimUsageDomain EOF ;
    public final EObject entryRuleClaimUsageDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimUsageDomain = null;


        try {
            // InternalResoluteParser.g:2375:2: (iv_ruleClaimUsageDomain= ruleClaimUsageDomain EOF )
            // InternalResoluteParser.g:2376:2: iv_ruleClaimUsageDomain= ruleClaimUsageDomain EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimUsageDomainRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimUsageDomain=ruleClaimUsageDomain();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimUsageDomain; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimUsageDomain"


    // $ANTLR start "ruleClaimUsageDomain"
    // InternalResoluteParser.g:2383:1: ruleClaimUsageDomain returns [EObject current=null] : (otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimUsageDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2386:28: ( (otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2387:1: (otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2387:1: (otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2388:2: otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Domain,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimUsageDomainAccess().getDomainKeyword_0());
                  
            }
            // InternalResoluteParser.g:2392:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2393:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2393:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2394:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClaimUsageDomainAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClaimUsageDomainRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimUsageDomainAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:2415:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:2416:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:2416:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:2417:3: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimUsageDomainAccess().getValStringTermParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_val_3_0=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimUsageDomainRule());
              	        }
                     		set(
                     			current, 
                     			"val",
                      		lv_val_3_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.StringTerm");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClaimUsageDomainAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimUsageDomain"


    // $ANTLR start "entryRuleClaimRationale"
    // InternalResoluteParser.g:2446:1: entryRuleClaimRationale returns [EObject current=null] : iv_ruleClaimRationale= ruleClaimRationale EOF ;
    public final EObject entryRuleClaimRationale() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimRationale = null;


        try {
            // InternalResoluteParser.g:2447:2: (iv_ruleClaimRationale= ruleClaimRationale EOF )
            // InternalResoluteParser.g:2448:2: iv_ruleClaimRationale= ruleClaimRationale EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimRationaleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimRationale=ruleClaimRationale();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimRationale; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimRationale"


    // $ANTLR start "ruleClaimRationale"
    // InternalResoluteParser.g:2455:1: ruleClaimRationale returns [EObject current=null] : (otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimRationale() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2458:28: ( (otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2459:1: (otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2459:1: (otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2460:2: otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Rationale,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimRationaleAccess().getRationaleKeyword_0());
                  
            }
            // InternalResoluteParser.g:2464:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2465:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2465:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2466:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClaimRationaleAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClaimRationaleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimRationaleAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:2487:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:2488:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:2488:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:2489:3: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimRationaleAccess().getValStringTermParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_val_3_0=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimRationaleRule());
              	        }
                     		set(
                     			current, 
                     			"val",
                      		lv_val_3_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.StringTerm");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClaimRationaleAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimRationale"


    // $ANTLR start "entryRuleClaimRestriction"
    // InternalResoluteParser.g:2518:1: entryRuleClaimRestriction returns [EObject current=null] : iv_ruleClaimRestriction= ruleClaimRestriction EOF ;
    public final EObject entryRuleClaimRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimRestriction = null;


        try {
            // InternalResoluteParser.g:2519:2: (iv_ruleClaimRestriction= ruleClaimRestriction EOF )
            // InternalResoluteParser.g:2520:2: iv_ruleClaimRestriction= ruleClaimRestriction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimRestrictionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimRestriction=ruleClaimRestriction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimRestriction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimRestriction"


    // $ANTLR start "ruleClaimRestriction"
    // InternalResoluteParser.g:2527:1: ruleClaimRestriction returns [EObject current=null] : (otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2530:28: ( (otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2531:1: (otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2531:1: (otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2532:2: otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Restriction,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimRestrictionAccess().getRestrictionKeyword_0());
                  
            }
            // InternalResoluteParser.g:2536:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2537:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2537:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2538:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClaimRestrictionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClaimRestrictionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimRestrictionAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:2559:1: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:2560:1: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:2560:1: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:2561:3: lv_expr_3_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimRestrictionAccess().getExprExprParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_expr_3_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimRestrictionRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_3_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClaimRestrictionAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimRestriction"


    // $ANTLR start "entryRuleClaimJustification"
    // InternalResoluteParser.g:2590:1: entryRuleClaimJustification returns [EObject current=null] : iv_ruleClaimJustification= ruleClaimJustification EOF ;
    public final EObject entryRuleClaimJustification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimJustification = null;


        try {
            // InternalResoluteParser.g:2591:2: (iv_ruleClaimJustification= ruleClaimJustification EOF )
            // InternalResoluteParser.g:2592:2: iv_ruleClaimJustification= ruleClaimJustification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimJustificationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimJustification=ruleClaimJustification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimJustification; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimJustification"


    // $ANTLR start "ruleClaimJustification"
    // InternalResoluteParser.g:2599:1: ruleClaimJustification returns [EObject current=null] : (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimJustification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2602:28: ( (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2603:1: (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2603:1: (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2604:2: otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Justification,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimJustificationAccess().getJustificationKeyword_0());
                  
            }
            // InternalResoluteParser.g:2608:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2609:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2609:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2610:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClaimJustificationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClaimJustificationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimJustificationAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:2631:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:2632:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:2632:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:2633:3: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimJustificationAccess().getValStringTermParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_val_3_0=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimJustificationRule());
              	        }
                     		set(
                     			current, 
                     			"val",
                      		lv_val_3_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.StringTerm");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClaimJustificationAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimJustification"


    // $ANTLR start "entryRuleClaimAssumption"
    // InternalResoluteParser.g:2662:1: entryRuleClaimAssumption returns [EObject current=null] : iv_ruleClaimAssumption= ruleClaimAssumption EOF ;
    public final EObject entryRuleClaimAssumption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimAssumption = null;


        try {
            // InternalResoluteParser.g:2663:2: (iv_ruleClaimAssumption= ruleClaimAssumption EOF )
            // InternalResoluteParser.g:2664:2: iv_ruleClaimAssumption= ruleClaimAssumption EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimAssumptionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimAssumption=ruleClaimAssumption();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimAssumption; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimAssumption"


    // $ANTLR start "ruleClaimAssumption"
    // InternalResoluteParser.g:2671:1: ruleClaimAssumption returns [EObject current=null] : (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimAssumption() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2674:28: ( (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2675:1: (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2675:1: (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2676:2: otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Assumption,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimAssumptionAccess().getAssumptionKeyword_0());
                  
            }
            // InternalResoluteParser.g:2680:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2681:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2681:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2682:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClaimAssumptionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClaimAssumptionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimAssumptionAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:2703:1: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:2704:1: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:2704:1: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:2705:3: lv_expr_3_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimAssumptionAccess().getExprExprParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_expr_3_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimAssumptionRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_3_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClaimAssumptionAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimAssumption"


    // $ANTLR start "entryRuleClaimStrategy"
    // InternalResoluteParser.g:2734:1: entryRuleClaimStrategy returns [EObject current=null] : iv_ruleClaimStrategy= ruleClaimStrategy EOF ;
    public final EObject entryRuleClaimStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimStrategy = null;


        try {
            // InternalResoluteParser.g:2735:2: (iv_ruleClaimStrategy= ruleClaimStrategy EOF )
            // InternalResoluteParser.g:2736:2: iv_ruleClaimStrategy= ruleClaimStrategy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimStrategyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimStrategy=ruleClaimStrategy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimStrategy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimStrategy"


    // $ANTLR start "ruleClaimStrategy"
    // InternalResoluteParser.g:2743:1: ruleClaimStrategy returns [EObject current=null] : (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2746:28: ( (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2747:1: (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2747:1: (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2748:2: otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Strategy,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimStrategyAccess().getStrategyKeyword_0());
                  
            }
            // InternalResoluteParser.g:2752:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2753:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2753:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2754:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClaimStrategyAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClaimStrategyRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimStrategyAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:2775:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:2776:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:2776:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:2777:3: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimStrategyAccess().getValStringTermParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_val_3_0=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimStrategyRule());
              	        }
                     		set(
                     			current, 
                     			"val",
                      		lv_val_3_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.StringTerm");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClaimStrategyAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimStrategy"


    // $ANTLR start "entryRuleClaimText"
    // InternalResoluteParser.g:2806:1: entryRuleClaimText returns [EObject current=null] : iv_ruleClaimText= ruleClaimText EOF ;
    public final EObject entryRuleClaimText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimText = null;


        try {
            // InternalResoluteParser.g:2807:2: (iv_ruleClaimText= ruleClaimText EOF )
            // InternalResoluteParser.g:2808:2: iv_ruleClaimText= ruleClaimText EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimTextRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimText=ruleClaimText();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimText; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClaimText"


    // $ANTLR start "ruleClaimText"
    // InternalResoluteParser.g:2815:1: ruleClaimText returns [EObject current=null] : ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) ) ;
    public final EObject ruleClaimText() throws RecognitionException {
        EObject current = null;

        Token lv_str_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2818:28: ( ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) ) )
            // InternalResoluteParser.g:2819:1: ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) )
            {
            // InternalResoluteParser.g:2819:1: ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_ID) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalResoluteParser.g:2819:2: ( () ( (lv_str_1_0= RULE_STRING ) ) )
                    {
                    // InternalResoluteParser.g:2819:2: ( () ( (lv_str_1_0= RULE_STRING ) ) )
                    // InternalResoluteParser.g:2819:3: () ( (lv_str_1_0= RULE_STRING ) )
                    {
                    // InternalResoluteParser.g:2819:3: ()
                    // InternalResoluteParser.g:2820:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getClaimTextAccess().getClaimStringAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2825:2: ( (lv_str_1_0= RULE_STRING ) )
                    // InternalResoluteParser.g:2826:1: (lv_str_1_0= RULE_STRING )
                    {
                    // InternalResoluteParser.g:2826:1: (lv_str_1_0= RULE_STRING )
                    // InternalResoluteParser.g:2827:3: lv_str_1_0= RULE_STRING
                    {
                    lv_str_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_str_1_0, grammarAccess.getClaimTextAccess().getStrSTRINGTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getClaimTextRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"str",
                              		lv_str_1_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:2844:6: ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? )
                    {
                    // InternalResoluteParser.g:2844:6: ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? )
                    // InternalResoluteParser.g:2844:7: () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )?
                    {
                    // InternalResoluteParser.g:2844:7: ()
                    // InternalResoluteParser.g:2845:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getClaimTextAccess().getClaimArgAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2850:2: ( (otherlv_3= RULE_ID ) )
                    // InternalResoluteParser.g:2851:1: (otherlv_3= RULE_ID )
                    {
                    // InternalResoluteParser.g:2851:1: (otherlv_3= RULE_ID )
                    // InternalResoluteParser.g:2852:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getClaimTextRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getClaimTextAccess().getArgClaimTextVarCrossReference_1_1_0()); 
                      	
                    }

                    }


                    }

                    // InternalResoluteParser.g:2863:2: (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==PercentSign) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalResoluteParser.g:2864:2: otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,PercentSign,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getClaimTextAccess().getPercentSignKeyword_1_2_0());
                                  
                            }
                            // InternalResoluteParser.g:2868:1: ( (otherlv_5= RULE_ID ) )
                            // InternalResoluteParser.g:2869:1: (otherlv_5= RULE_ID )
                            {
                            // InternalResoluteParser.g:2869:1: (otherlv_5= RULE_ID )
                            // InternalResoluteParser.g:2870:3: otherlv_5= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getClaimTextRule());
                              	        }
                                      
                            }
                            otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_5, grammarAccess.getClaimTextAccess().getUnitUnitLiteralCrossReference_1_2_1_0()); 
                              	
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClaimText"


    // $ANTLR start "entryRuleExpr"
    // InternalResoluteParser.g:2891:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // InternalResoluteParser.g:2892:2: (iv_ruleExpr= ruleExpr EOF )
            // InternalResoluteParser.g:2893:2: iv_ruleExpr= ruleExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpr=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpr"


    // $ANTLR start "ruleExpr"
    // InternalResoluteParser.g:2900:1: ruleExpr returns [EObject current=null] : this_ImpliesExpr_0= ruleImpliesExpr ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesExpr_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2903:28: (this_ImpliesExpr_0= ruleImpliesExpr )
            // InternalResoluteParser.g:2905:5: this_ImpliesExpr_0= ruleImpliesExpr
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExprAccess().getImpliesExprParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_ImpliesExpr_0=ruleImpliesExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ImpliesExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpr"


    // $ANTLR start "entryRuleImpliesExpr"
    // InternalResoluteParser.g:2921:1: entryRuleImpliesExpr returns [EObject current=null] : iv_ruleImpliesExpr= ruleImpliesExpr EOF ;
    public final EObject entryRuleImpliesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpr = null;


        try {
            // InternalResoluteParser.g:2922:2: (iv_ruleImpliesExpr= ruleImpliesExpr EOF )
            // InternalResoluteParser.g:2923:2: iv_ruleImpliesExpr= ruleImpliesExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImpliesExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImpliesExpr=ruleImpliesExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImpliesExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImpliesExpr"


    // $ANTLR start "ruleImpliesExpr"
    // InternalResoluteParser.g:2930:1: ruleImpliesExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) ;
    public final EObject ruleImpliesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_OrExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2933:28: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) )
            // InternalResoluteParser.g:2934:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            {
            // InternalResoluteParser.g:2934:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            // InternalResoluteParser.g:2935:5: this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getImpliesExprAccess().getOrExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_29);
            this_OrExpr_0=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_OrExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalResoluteParser.g:2943:1: ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==EqualsSignGreaterThanSign) ) {
                int LA17_1 = input.LA(2);

                if ( (synpred2_InternalResoluteParser()) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // InternalResoluteParser.g:2943:2: ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) )
                    {
                    // InternalResoluteParser.g:2943:2: ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) )
                    // InternalResoluteParser.g:2943:3: ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) )
                    {
                    // InternalResoluteParser.g:2951:6: ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) )
                    // InternalResoluteParser.g:2951:7: () ( (lv_op_2_0= EqualsSignGreaterThanSign ) )
                    {
                    // InternalResoluteParser.g:2951:7: ()
                    // InternalResoluteParser.g:2952:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2957:2: ( (lv_op_2_0= EqualsSignGreaterThanSign ) )
                    // InternalResoluteParser.g:2958:1: (lv_op_2_0= EqualsSignGreaterThanSign )
                    {
                    // InternalResoluteParser.g:2958:1: (lv_op_2_0= EqualsSignGreaterThanSign )
                    // InternalResoluteParser.g:2959:3: lv_op_2_0= EqualsSignGreaterThanSign
                    {
                    lv_op_2_0=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getImpliesExprAccess().getOpEqualsSignGreaterThanSignKeyword_1_0_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getImpliesExprRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "=>");
                      	    
                    }

                    }


                    }


                    }


                    }

                    // InternalResoluteParser.g:2973:4: ( (lv_right_3_0= ruleImpliesExpr ) )
                    // InternalResoluteParser.g:2974:1: (lv_right_3_0= ruleImpliesExpr )
                    {
                    // InternalResoluteParser.g:2974:1: (lv_right_3_0= ruleImpliesExpr )
                    // InternalResoluteParser.g:2975:3: lv_right_3_0= ruleImpliesExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImpliesExprAccess().getRightImpliesExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_3_0=ruleImpliesExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImpliesExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.ImpliesExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImpliesExpr"


    // $ANTLR start "entryRuleOrExpr"
    // InternalResoluteParser.g:2999:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // InternalResoluteParser.g:3000:2: (iv_ruleOrExpr= ruleOrExpr EOF )
            // InternalResoluteParser.g:3001:2: iv_ruleOrExpr= ruleOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOrExpr=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpr"


    // $ANTLR start "ruleOrExpr"
    // InternalResoluteParser.g:3008:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3011:28: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* ) )
            // InternalResoluteParser.g:3012:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* )
            {
            // InternalResoluteParser.g:3012:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* )
            // InternalResoluteParser.g:3013:5: this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExprAccess().getAndExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_30);
            this_AndExpr_0=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_AndExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalResoluteParser.g:3021:1: ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==Or) ) {
                    int LA19_2 = input.LA(2);

                    if ( (synpred3_InternalResoluteParser()) ) {
                        alt19=1;
                    }


                }
                else if ( (LA19_0==Orelse) ) {
                    int LA19_3 = input.LA(2);

                    if ( (synpred3_InternalResoluteParser()) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // InternalResoluteParser.g:3021:2: ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) )
            	    {
            	    // InternalResoluteParser.g:3021:2: ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) )
            	    // InternalResoluteParser.g:3021:3: ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) )
            	    {
            	    // InternalResoluteParser.g:3037:7: ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) )
            	    // InternalResoluteParser.g:3037:8: () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) )
            	    {
            	    // InternalResoluteParser.g:3037:8: ()
            	    // InternalResoluteParser.g:3038:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:3043:2: ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) )
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==Or) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==Orelse) ) {
            	        alt18=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // InternalResoluteParser.g:3043:3: ( (lv_op_2_0= Or ) )
            	            {
            	            // InternalResoluteParser.g:3043:3: ( (lv_op_2_0= Or ) )
            	            // InternalResoluteParser.g:3044:1: (lv_op_2_0= Or )
            	            {
            	            // InternalResoluteParser.g:3044:1: (lv_op_2_0= Or )
            	            // InternalResoluteParser.g:3045:3: lv_op_2_0= Or
            	            {
            	            lv_op_2_0=(Token)match(input,Or,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_0, grammarAccess.getOrExprAccess().getOpOrKeyword_1_0_0_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getOrExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_0, "or");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalResoluteParser.g:3060:6: ( (lv_op_3_0= Orelse ) )
            	            {
            	            // InternalResoluteParser.g:3060:6: ( (lv_op_3_0= Orelse ) )
            	            // InternalResoluteParser.g:3061:1: (lv_op_3_0= Orelse )
            	            {
            	            // InternalResoluteParser.g:3061:1: (lv_op_3_0= Orelse )
            	            // InternalResoluteParser.g:3062:3: lv_op_3_0= Orelse
            	            {
            	            lv_op_3_0=(Token)match(input,Orelse,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_3_0, grammarAccess.getOrExprAccess().getOpOrelseKeyword_1_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getOrExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_3_0, "orelse");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalResoluteParser.g:3076:5: ( (lv_right_4_0= ruleAndExpr ) )
            	    // InternalResoluteParser.g:3077:1: (lv_right_4_0= ruleAndExpr )
            	    {
            	    // InternalResoluteParser.g:3077:1: (lv_right_4_0= ruleAndExpr )
            	    // InternalResoluteParser.g:3078:3: lv_right_4_0= ruleAndExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExprAccess().getRightAndExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    lv_right_4_0=ruleAndExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_4_0, 
            	              		"com.rockwellcollins.atc.resolute.Resolute.AndExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpr"


    // $ANTLR start "entryRuleAndExpr"
    // InternalResoluteParser.g:3102:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // InternalResoluteParser.g:3103:2: (iv_ruleAndExpr= ruleAndExpr EOF )
            // InternalResoluteParser.g:3104:2: iv_ruleAndExpr= ruleAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAndExpr=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpr"


    // $ANTLR start "ruleAndExpr"
    // InternalResoluteParser.g:3111:1: ruleAndExpr returns [EObject current=null] : (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_InstanceOfExpr_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3114:28: ( (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* ) )
            // InternalResoluteParser.g:3115:1: (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* )
            {
            // InternalResoluteParser.g:3115:1: (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* )
            // InternalResoluteParser.g:3116:5: this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExprAccess().getInstanceOfExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_31);
            this_InstanceOfExpr_0=ruleInstanceOfExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_InstanceOfExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalResoluteParser.g:3124:1: ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==And) ) {
                    int LA21_2 = input.LA(2);

                    if ( (synpred4_InternalResoluteParser()) ) {
                        alt21=1;
                    }


                }
                else if ( (LA21_0==Andthen) ) {
                    int LA21_3 = input.LA(2);

                    if ( (synpred4_InternalResoluteParser()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalResoluteParser.g:3124:2: ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) )
            	    {
            	    // InternalResoluteParser.g:3124:2: ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) )
            	    // InternalResoluteParser.g:3124:3: ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) )
            	    {
            	    // InternalResoluteParser.g:3140:7: ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) )
            	    // InternalResoluteParser.g:3140:8: () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) )
            	    {
            	    // InternalResoluteParser.g:3140:8: ()
            	    // InternalResoluteParser.g:3141:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:3146:2: ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==And) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==Andthen) ) {
            	        alt20=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // InternalResoluteParser.g:3146:3: ( (lv_op_2_0= And ) )
            	            {
            	            // InternalResoluteParser.g:3146:3: ( (lv_op_2_0= And ) )
            	            // InternalResoluteParser.g:3147:1: (lv_op_2_0= And )
            	            {
            	            // InternalResoluteParser.g:3147:1: (lv_op_2_0= And )
            	            // InternalResoluteParser.g:3148:3: lv_op_2_0= And
            	            {
            	            lv_op_2_0=(Token)match(input,And,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_0, grammarAccess.getAndExprAccess().getOpAndKeyword_1_0_0_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAndExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_0, "and");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalResoluteParser.g:3163:6: ( (lv_op_3_0= Andthen ) )
            	            {
            	            // InternalResoluteParser.g:3163:6: ( (lv_op_3_0= Andthen ) )
            	            // InternalResoluteParser.g:3164:1: (lv_op_3_0= Andthen )
            	            {
            	            // InternalResoluteParser.g:3164:1: (lv_op_3_0= Andthen )
            	            // InternalResoluteParser.g:3165:3: lv_op_3_0= Andthen
            	            {
            	            lv_op_3_0=(Token)match(input,Andthen,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_3_0, grammarAccess.getAndExprAccess().getOpAndthenKeyword_1_0_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getAndExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_3_0, "andthen");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalResoluteParser.g:3179:5: ( (lv_right_4_0= ruleInstanceOfExpr ) )
            	    // InternalResoluteParser.g:3180:1: (lv_right_4_0= ruleInstanceOfExpr )
            	    {
            	    // InternalResoluteParser.g:3180:1: (lv_right_4_0= ruleInstanceOfExpr )
            	    // InternalResoluteParser.g:3181:3: lv_right_4_0= ruleInstanceOfExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExprAccess().getRightInstanceOfExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_31);
            	    lv_right_4_0=ruleInstanceOfExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_4_0, 
            	              		"com.rockwellcollins.atc.resolute.Resolute.InstanceOfExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpr"


    // $ANTLR start "entryRuleInstanceOfExpr"
    // InternalResoluteParser.g:3205:1: entryRuleInstanceOfExpr returns [EObject current=null] : iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF ;
    public final EObject entryRuleInstanceOfExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceOfExpr = null;


        try {
            // InternalResoluteParser.g:3206:2: (iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF )
            // InternalResoluteParser.g:3207:2: iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstanceOfExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInstanceOfExpr=ruleInstanceOfExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstanceOfExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceOfExpr"


    // $ANTLR start "ruleInstanceOfExpr"
    // InternalResoluteParser.g:3214:1: ruleInstanceOfExpr returns [EObject current=null] : (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? ) ;
    public final EObject ruleInstanceOfExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RelationalExpr_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3217:28: ( (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? ) )
            // InternalResoluteParser.g:3218:1: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? )
            {
            // InternalResoluteParser.g:3218:1: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? )
            // InternalResoluteParser.g:3219:5: this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInstanceOfExprAccess().getRelationalExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_32);
            this_RelationalExpr_0=ruleRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_RelationalExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalResoluteParser.g:3227:1: ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Instanceof) ) {
                int LA22_1 = input.LA(2);

                if ( (synpred5_InternalResoluteParser()) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalResoluteParser.g:3227:2: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) )
                    {
                    // InternalResoluteParser.g:3227:2: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) )
                    // InternalResoluteParser.g:3227:3: ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof )
                    {
                    // InternalResoluteParser.g:3230:5: ( () otherlv_2= Instanceof )
                    // InternalResoluteParser.g:3230:6: () otherlv_2= Instanceof
                    {
                    // InternalResoluteParser.g:3230:6: ()
                    // InternalResoluteParser.g:3231:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getInstanceOfExprAccess().getInstanceOfExprExprAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,Instanceof,FollowSets000.FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInstanceOfExprAccess().getInstanceofKeyword_1_0_0_1());
                          
                    }

                    }


                    }

                    // InternalResoluteParser.g:3241:3: ( (lv_type_3_0= ruleBaseType ) )
                    // InternalResoluteParser.g:3242:1: (lv_type_3_0= ruleBaseType )
                    {
                    // InternalResoluteParser.g:3242:1: (lv_type_3_0= ruleBaseType )
                    // InternalResoluteParser.g:3243:3: lv_type_3_0= ruleBaseType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstanceOfExprAccess().getTypeBaseTypeParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_type_3_0=ruleBaseType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInstanceOfExprRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_3_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.BaseType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceOfExpr"


    // $ANTLR start "entryRuleRelationalOp"
    // InternalResoluteParser.g:3267:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // InternalResoluteParser.g:3268:1: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // InternalResoluteParser.g:3269:2: iv_ruleRelationalOp= ruleRelationalOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalOp=ruleRelationalOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOp.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOp"


    // $ANTLR start "ruleRelationalOp"
    // InternalResoluteParser.g:3276:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3280:6: ( (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign ) )
            // InternalResoluteParser.g:3281:1: (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign )
            {
            // InternalResoluteParser.g:3281:1: (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign )
            int alt23=6;
            switch ( input.LA(1) ) {
            case LessThanSign:
                {
                alt23=1;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt23=2;
                }
                break;
            case GreaterThanSign:
                {
                alt23=3;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt23=4;
                }
                break;
            case EqualsSign:
                {
                alt23=5;
                }
                break;
            case LessThanSignGreaterThanSign:
                {
                alt23=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalResoluteParser.g:3282:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:3289:2: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:3296:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:3303:2: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:3310:2: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:3317:2: kw= LessThanSignGreaterThanSign
                    {
                    kw=(Token)match(input,LessThanSignGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignGreaterThanSignKeyword_5()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOp"


    // $ANTLR start "entryRuleRelationalExpr"
    // InternalResoluteParser.g:3330:1: entryRuleRelationalExpr returns [EObject current=null] : iv_ruleRelationalExpr= ruleRelationalExpr EOF ;
    public final EObject entryRuleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpr = null;


        try {
            // InternalResoluteParser.g:3331:2: (iv_ruleRelationalExpr= ruleRelationalExpr EOF )
            // InternalResoluteParser.g:3332:2: iv_ruleRelationalExpr= ruleRelationalExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalExpr=ruleRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpr"


    // $ANTLR start "ruleRelationalExpr"
    // InternalResoluteParser.g:3339:1: ruleRelationalExpr returns [EObject current=null] : (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) ;
    public final EObject ruleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PlusExpr_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3342:28: ( (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) )
            // InternalResoluteParser.g:3343:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            {
            // InternalResoluteParser.g:3343:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            // InternalResoluteParser.g:3344:5: this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalExprAccess().getPlusExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_34);
            this_PlusExpr_0=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_PlusExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalResoluteParser.g:3352:1: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            int alt24=2;
            switch ( input.LA(1) ) {
                case LessThanSign:
                    {
                    int LA24_1 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt24=1;
                    }
                    }
                    break;
                case LessThanSignEqualsSign:
                    {
                    int LA24_2 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt24=1;
                    }
                    }
                    break;
                case GreaterThanSign:
                    {
                    int LA24_3 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt24=1;
                    }
                    }
                    break;
                case GreaterThanSignEqualsSign:
                    {
                    int LA24_4 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt24=1;
                    }
                    }
                    break;
                case EqualsSign:
                    {
                    int LA24_5 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt24=1;
                    }
                    }
                    break;
                case LessThanSignGreaterThanSign:
                    {
                    int LA24_6 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt24=1;
                    }
                    }
                    break;
            }

            switch (alt24) {
                case 1 :
                    // InternalResoluteParser.g:3352:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) )
                    {
                    // InternalResoluteParser.g:3352:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) )
                    // InternalResoluteParser.g:3352:3: ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    {
                    // InternalResoluteParser.g:3357:6: ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    // InternalResoluteParser.g:3357:7: () ( (lv_op_2_0= ruleRelationalOp ) )
                    {
                    // InternalResoluteParser.g:3357:7: ()
                    // InternalResoluteParser.g:3358:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3363:2: ( (lv_op_2_0= ruleRelationalOp ) )
                    // InternalResoluteParser.g:3364:1: (lv_op_2_0= ruleRelationalOp )
                    {
                    // InternalResoluteParser.g:3364:1: (lv_op_2_0= ruleRelationalOp )
                    // InternalResoluteParser.g:3365:3: lv_op_2_0= ruleRelationalOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExprAccess().getOpRelationalOpParserRuleCall_1_0_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_op_2_0=ruleRelationalOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"op",
                              		lv_op_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.RelationalOp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }

                    // InternalResoluteParser.g:3381:4: ( (lv_right_3_0= rulePlusExpr ) )
                    // InternalResoluteParser.g:3382:1: (lv_right_3_0= rulePlusExpr )
                    {
                    // InternalResoluteParser.g:3382:1: (lv_right_3_0= rulePlusExpr )
                    // InternalResoluteParser.g:3383:3: lv_right_3_0= rulePlusExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExprAccess().getRightPlusExprParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_3_0=rulePlusExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExprRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_3_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.PlusExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpr"


    // $ANTLR start "entryRulePlusExpr"
    // InternalResoluteParser.g:3407:1: entryRulePlusExpr returns [EObject current=null] : iv_rulePlusExpr= rulePlusExpr EOF ;
    public final EObject entryRulePlusExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusExpr = null;


        try {
            // InternalResoluteParser.g:3408:2: (iv_rulePlusExpr= rulePlusExpr EOF )
            // InternalResoluteParser.g:3409:2: iv_rulePlusExpr= rulePlusExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePlusExpr=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusExpr"


    // $ANTLR start "rulePlusExpr"
    // InternalResoluteParser.g:3416:1: rulePlusExpr returns [EObject current=null] : (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* ) ;
    public final EObject rulePlusExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_TimesExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3419:28: ( (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* ) )
            // InternalResoluteParser.g:3420:1: (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* )
            {
            // InternalResoluteParser.g:3420:1: (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* )
            // InternalResoluteParser.g:3421:5: this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPlusExprAccess().getTimesExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_35);
            this_TimesExpr_0=ruleTimesExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_TimesExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalResoluteParser.g:3429:1: ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==PlusSign) ) {
                    int LA26_2 = input.LA(2);

                    if ( (synpred7_InternalResoluteParser()) ) {
                        alt26=1;
                    }


                }
                else if ( (LA26_0==HyphenMinus) ) {
                    int LA26_3 = input.LA(2);

                    if ( (synpred7_InternalResoluteParser()) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // InternalResoluteParser.g:3429:2: ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) )
            	    {
            	    // InternalResoluteParser.g:3429:2: ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) )
            	    // InternalResoluteParser.g:3429:3: ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) )
            	    {
            	    // InternalResoluteParser.g:3444:6: ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) )
            	    // InternalResoluteParser.g:3444:7: () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    {
            	    // InternalResoluteParser.g:3444:7: ()
            	    // InternalResoluteParser.g:3445:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPlusExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:3450:2: ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    // InternalResoluteParser.g:3451:1: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    {
            	    // InternalResoluteParser.g:3451:1: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    // InternalResoluteParser.g:3452:1: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    {
            	    // InternalResoluteParser.g:3452:1: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==PlusSign) ) {
            	        alt25=1;
            	    }
            	    else if ( (LA25_0==HyphenMinus) ) {
            	        alt25=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 25, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // InternalResoluteParser.g:3453:3: lv_op_2_1= PlusSign
            	            {
            	            lv_op_2_1=(Token)match(input,PlusSign,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getPlusExprAccess().getOpPlusSignKeyword_1_0_0_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getPlusExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalResoluteParser.g:3466:8: lv_op_2_2= HyphenMinus
            	            {
            	            lv_op_2_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getPlusExprAccess().getOpHyphenMinusKeyword_1_0_0_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getPlusExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	    // InternalResoluteParser.g:3482:4: ( (lv_right_3_0= ruleTimesExpr ) )
            	    // InternalResoluteParser.g:3483:1: (lv_right_3_0= ruleTimesExpr )
            	    {
            	    // InternalResoluteParser.g:3483:1: (lv_right_3_0= ruleTimesExpr )
            	    // InternalResoluteParser.g:3484:3: lv_right_3_0= ruleTimesExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPlusExprAccess().getRightTimesExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_35);
            	    lv_right_3_0=ruleTimesExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPlusExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"com.rockwellcollins.atc.resolute.Resolute.TimesExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusExpr"


    // $ANTLR start "entryRuleTimesExpr"
    // InternalResoluteParser.g:3508:1: entryRuleTimesExpr returns [EObject current=null] : iv_ruleTimesExpr= ruleTimesExpr EOF ;
    public final EObject entryRuleTimesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimesExpr = null;


        try {
            // InternalResoluteParser.g:3509:2: (iv_ruleTimesExpr= ruleTimesExpr EOF )
            // InternalResoluteParser.g:3510:2: iv_ruleTimesExpr= ruleTimesExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimesExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTimesExpr=ruleTimesExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimesExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimesExpr"


    // $ANTLR start "ruleTimesExpr"
    // InternalResoluteParser.g:3517:1: ruleTimesExpr returns [EObject current=null] : (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* ) ;
    public final EObject ruleTimesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_ExpExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3520:28: ( (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* ) )
            // InternalResoluteParser.g:3521:1: (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* )
            {
            // InternalResoluteParser.g:3521:1: (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* )
            // InternalResoluteParser.g:3522:5: this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTimesExprAccess().getExpExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_36);
            this_ExpExpr_0=ruleExpExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ExpExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalResoluteParser.g:3530:1: ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )*
            loop28:
            do {
                int alt28=2;
                switch ( input.LA(1) ) {
                case Asterisk:
                    {
                    int LA28_2 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case Solidus:
                    {
                    int LA28_3 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt28=1;
                    }


                    }
                    break;
                case PercentSign:
                    {
                    int LA28_4 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt28=1;
                    }


                    }
                    break;

                }

                switch (alt28) {
            	case 1 :
            	    // InternalResoluteParser.g:3530:2: ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) )
            	    {
            	    // InternalResoluteParser.g:3530:2: ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) )
            	    // InternalResoluteParser.g:3530:3: ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) )
            	    {
            	    // InternalResoluteParser.g:3549:6: ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) )
            	    // InternalResoluteParser.g:3549:7: () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    {
            	    // InternalResoluteParser.g:3549:7: ()
            	    // InternalResoluteParser.g:3550:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getTimesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:3555:2: ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    // InternalResoluteParser.g:3556:1: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    {
            	    // InternalResoluteParser.g:3556:1: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    // InternalResoluteParser.g:3557:1: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    {
            	    // InternalResoluteParser.g:3557:1: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    int alt27=3;
            	    switch ( input.LA(1) ) {
            	    case Asterisk:
            	        {
            	        alt27=1;
            	        }
            	        break;
            	    case Solidus:
            	        {
            	        alt27=2;
            	        }
            	        break;
            	    case PercentSign:
            	        {
            	        alt27=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt27) {
            	        case 1 :
            	            // InternalResoluteParser.g:3558:3: lv_op_2_1= Asterisk
            	            {
            	            lv_op_2_1=(Token)match(input,Asterisk,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getTimesExprAccess().getOpAsteriskKeyword_1_0_0_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getTimesExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalResoluteParser.g:3571:8: lv_op_2_2= Solidus
            	            {
            	            lv_op_2_2=(Token)match(input,Solidus,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getTimesExprAccess().getOpSolidusKeyword_1_0_0_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getTimesExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalResoluteParser.g:3584:8: lv_op_2_3= PercentSign
            	            {
            	            lv_op_2_3=(Token)match(input,PercentSign,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_3, grammarAccess.getTimesExprAccess().getOpPercentSignKeyword_1_0_0_1_0_2());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getTimesExprRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }


            	    }

            	    // InternalResoluteParser.g:3600:4: ( (lv_right_3_0= ruleExpExpr ) )
            	    // InternalResoluteParser.g:3601:1: (lv_right_3_0= ruleExpExpr )
            	    {
            	    // InternalResoluteParser.g:3601:1: (lv_right_3_0= ruleExpExpr )
            	    // InternalResoluteParser.g:3602:3: lv_right_3_0= ruleExpExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTimesExprAccess().getRightExpExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_36);
            	    lv_right_3_0=ruleExpExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTimesExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"com.rockwellcollins.atc.resolute.Resolute.ExpExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimesExpr"


    // $ANTLR start "entryRuleExpExpr"
    // InternalResoluteParser.g:3626:1: entryRuleExpExpr returns [EObject current=null] : iv_ruleExpExpr= ruleExpExpr EOF ;
    public final EObject entryRuleExpExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpExpr = null;


        try {
            // InternalResoluteParser.g:3627:2: (iv_ruleExpExpr= ruleExpExpr EOF )
            // InternalResoluteParser.g:3628:2: iv_ruleExpExpr= ruleExpExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpExpr=ruleExpExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpExpr"


    // $ANTLR start "ruleExpExpr"
    // InternalResoluteParser.g:3635:1: ruleExpExpr returns [EObject current=null] : (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* ) ;
    public final EObject ruleExpExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_PrefixExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3638:28: ( (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* ) )
            // InternalResoluteParser.g:3639:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* )
            {
            // InternalResoluteParser.g:3639:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* )
            // InternalResoluteParser.g:3640:5: this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpExprAccess().getPrefixExprParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_37);
            this_PrefixExpr_0=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_PrefixExpr_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // InternalResoluteParser.g:3648:1: ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==CircumflexAccent) ) {
                    int LA29_2 = input.LA(2);

                    if ( (synpred9_InternalResoluteParser()) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // InternalResoluteParser.g:3648:2: ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) )
            	    {
            	    // InternalResoluteParser.g:3648:2: ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) )
            	    // InternalResoluteParser.g:3648:3: ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) )
            	    {
            	    // InternalResoluteParser.g:3656:6: ( () ( (lv_op_2_0= CircumflexAccent ) ) )
            	    // InternalResoluteParser.g:3656:7: () ( (lv_op_2_0= CircumflexAccent ) )
            	    {
            	    // InternalResoluteParser.g:3656:7: ()
            	    // InternalResoluteParser.g:3657:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:3662:2: ( (lv_op_2_0= CircumflexAccent ) )
            	    // InternalResoluteParser.g:3663:1: (lv_op_2_0= CircumflexAccent )
            	    {
            	    // InternalResoluteParser.g:3663:1: (lv_op_2_0= CircumflexAccent )
            	    // InternalResoluteParser.g:3664:3: lv_op_2_0= CircumflexAccent
            	    {
            	    lv_op_2_0=(Token)match(input,CircumflexAccent,FollowSets000.FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_op_2_0, grammarAccess.getExpExprAccess().getOpCircumflexAccentKeyword_1_0_0_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getExpExprRule());
            	      	        }
            	             		setWithLastConsumed(current, "op", lv_op_2_0, "^");
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalResoluteParser.g:3678:4: ( (lv_right_3_0= rulePrefixExpr ) )
            	    // InternalResoluteParser.g:3679:1: (lv_right_3_0= rulePrefixExpr )
            	    {
            	    // InternalResoluteParser.g:3679:1: (lv_right_3_0= rulePrefixExpr )
            	    // InternalResoluteParser.g:3680:3: lv_right_3_0= rulePrefixExpr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpExprAccess().getRightPrefixExprParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_37);
            	    lv_right_3_0=rulePrefixExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExpExprRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"com.rockwellcollins.atc.resolute.Resolute.PrefixExpr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpExpr"


    // $ANTLR start "entryRulePrefixExpr"
    // InternalResoluteParser.g:3704:1: entryRulePrefixExpr returns [EObject current=null] : iv_rulePrefixExpr= rulePrefixExpr EOF ;
    public final EObject entryRulePrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpr = null;


        try {
            // InternalResoluteParser.g:3705:2: (iv_rulePrefixExpr= rulePrefixExpr EOF )
            // InternalResoluteParser.g:3706:2: iv_rulePrefixExpr= rulePrefixExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixExpr=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixExpr"


    // $ANTLR start "rulePrefixExpr"
    // InternalResoluteParser.g:3713:1: rulePrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr ) ;
    public final EObject rulePrefixExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expr_2_0 = null;

        EObject lv_type_5_0 = null;

        EObject lv_expr_7_0 = null;

        EObject this_AtomicExpr_8 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3716:28: ( ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr ) )
            // InternalResoluteParser.g:3717:1: ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr )
            {
            // InternalResoluteParser.g:3717:1: ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr )
            int alt31=3;
            switch ( input.LA(1) ) {
            case Not:
            case HyphenMinus:
                {
                alt31=1;
                }
                break;
            case LeftParenthesis:
                {
                switch ( input.LA(2) ) {
                case Control_flows_to_unconditionally:
                case Control_flows_to_conditionally:
                case Revised_without_review:
                case Error_state_reachable:
                case Is_virtual_processor:
                case Flow_specifications:
                case Is_abstract_feature:
                case Revised_with_review:
                case Enumerated_values:
                case End_to_end_flows:
                case Flow_destination:
                case Is_bidirectional:
                case Annotation_type:
                case Is_thread_group:
                case Propagate_error:
                case Property_member:
                case Subcomponent_of:
                case Destination_of:
                case Has_prototypes:
                case Is_data_access:
                case Is_virtual_bus:
                case Compile_input:
                case Contain_error:
                case Flow_elements:
                case Identified_by:
                case Indeterminate:
                case Is_bus_access:
                case Is_event_port:
                case Is_subprogram:
                case Package_input:
                case Receive_error:
                case Review_result:
                case Subcomponents:
                case Developed_by:
                case Has_property:
                case Instantiates:
                case Is_data_port:
                case Is_processor:
                case Performed_by:
                case Requirements:
                case Annotations:
                case Compiled_by:
                case Connections:
                case Consumed_by:
                case Description:
                case Destination:
                case Executed_by:
                case Executed_on:
                case Flow_source:
                case From_report:
                case Governed_by:
                case Is_bound_to:
                case Is_in_array:
                case Lower_bound:
                case Packaged_by:
                case Produced_by:
                case Provided_by:
                case Undeveloped:
                case Upper_bound:
                case Created_by:
                case Defined_in:
                case Definition:
                case Given_text:
                case Has_member:
                case Has_parent:
                case Identified:
                case Is_of_type:
                case Is_process:
                case Referenced:
                case Value_type:
                case Direction:
                case Has_modes:
                case Instances:
                case Intersect:
                case Is_device:
                case Is_memory:
                case Is_system:
                case Is_thread:
                case Mitigates:
                case Result_of:
                case Satisfies:
                case Source_of:
                case Then_text:
                case Analysis:
                case Analyzes:
                case Confirms:
                case Evidence:
                case Features:
                case Filename:
                case Has_type:
                case Instance:
                case Mentions:
                case Provides:
                case Requires:
                case Reviewed:
                case Reviewer:
                case Solution:
                case Verifies:
                case As_list:
                case Governs:
                case If_text:
                case Is_data:
                case Is_port:
                case Part_of:
                case Reviews:
                case Type_of:
                case Warning:
                case Append:
                case As_set:
                case Author:
                case Exists:
                case Failed:
                case Forall:
                case Is_bus:
                case Length:
                case Member:
                case Metric:
                case Parent:
                case Passed:
                case Source:
                case Debug:
                case Error:
                case False:
                case Union:
                case Fail:
                case Head:
                case Info:
                case Name:
                case Size:
                case Step:
                case Tail:
                case Text:
                case This:
                case True:
                case Type:
                case Let:
                case Not:
                case Sum:
                case If:
                case LeftParenthesis:
                case HyphenMinus:
                case LeftSquareBracket:
                case LeftCurlyBracket:
                case RULE_REAL_LIT:
                case RULE_INTEGER_LIT:
                case RULE_STRING:
                case RULE_ID:
                    {
                    alt31=3;
                    }
                    break;
                case Property:
                    {
                    int LA31_4 = input.LA(3);

                    if ( (LA31_4==RightParenthesis) ) {
                        alt31=2;
                    }
                    else if ( (LA31_4==LeftParenthesis) ) {
                        alt31=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case Provides_subprogram_group_access:
                case Requires_subprogram_group_access:
                case Provides_subprogram_access:
                case Requires_subprogram_access:
                case Analysis_annotation_type:
                case Requirement_development:
                case Subprogram_group_access:
                case Binary_global_variable:
                case Source_global_variable:
                case Class_member_variable:
                case Hazard_identification:
                case Data_dictionary_term:
                case Provides_data_access:
                case Requires_data_access:
                case Analysis_annotation:
                case Provides_bus_access:
                case Requires_bus_access:
                case Binary_basic_block:
                case Flow_specification:
                case System_development:
                case Analysis_activity:
                case Class_constructor:
                case Subprogram_access:
                case Virtual_processor:
                case Class_definition:
                case Code_development:
                case Subprogram_group:
                case Test_developmemt:
                case Analysis_report:
                case Analysis_result:
                case Binary_function:
                case End_to_end_flow:
                case Event_data_port:
                case Source_function:
                case Component_type:
                case Test_execution:
                case Feature_group:
                case Postcondition:
                case Class_method:
                case Package_file:
                case Precondition:
                case Review_state:
                case Thread_group:
                case Data_access:
                case Requirement:
                case Test_result:
                case Test_status:
                case Virtual_bus:
                case Bus_access:
                case Connection:
                case Event_port:
                case Review_log:
                case Subprogram:
                case Component:
                case Data_port:
                case Interface:
                case Invariant:
                case Namespace:
                case Processor:
                case Abstract:
                case Activity:
                case Code_gen:
                case Compile:
                case Feature:
                case Process:
                case Access:
                case Device:
                case Entity:
                case Format:
                case Hazard:
                case Memory:
                case Module:
                case Review:
                case String:
                case KW_System:
                case Thread:
                case Agent:
                case Build:
                case Range:
                case Thing:
                case Aadl:
                case Bool:
                case Data:
                case File:
                case Port:
                case Real:
                case Test:
                case Bus:
                case Int:
                    {
                    alt31=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 2, input);

                    throw nvae;
                }

                }
                break;
            case Control_flows_to_unconditionally:
            case Control_flows_to_conditionally:
            case Revised_without_review:
            case Error_state_reachable:
            case Is_virtual_processor:
            case Flow_specifications:
            case Is_abstract_feature:
            case Revised_with_review:
            case Enumerated_values:
            case End_to_end_flows:
            case Flow_destination:
            case Is_bidirectional:
            case Annotation_type:
            case Is_thread_group:
            case Propagate_error:
            case Property_member:
            case Subcomponent_of:
            case Destination_of:
            case Has_prototypes:
            case Is_data_access:
            case Is_virtual_bus:
            case Compile_input:
            case Contain_error:
            case Flow_elements:
            case Identified_by:
            case Indeterminate:
            case Is_bus_access:
            case Is_event_port:
            case Is_subprogram:
            case Package_input:
            case Receive_error:
            case Review_result:
            case Subcomponents:
            case Developed_by:
            case Has_property:
            case Instantiates:
            case Is_data_port:
            case Is_processor:
            case Performed_by:
            case Requirements:
            case Annotations:
            case Compiled_by:
            case Connections:
            case Consumed_by:
            case Description:
            case Destination:
            case Executed_by:
            case Executed_on:
            case Flow_source:
            case From_report:
            case Governed_by:
            case Is_bound_to:
            case Is_in_array:
            case Lower_bound:
            case Packaged_by:
            case Produced_by:
            case Provided_by:
            case Undeveloped:
            case Upper_bound:
            case Created_by:
            case Defined_in:
            case Definition:
            case Given_text:
            case Has_member:
            case Has_parent:
            case Identified:
            case Is_of_type:
            case Is_process:
            case Referenced:
            case Value_type:
            case Direction:
            case Has_modes:
            case Instances:
            case Intersect:
            case Is_device:
            case Is_memory:
            case Is_system:
            case Is_thread:
            case Mitigates:
            case Result_of:
            case Satisfies:
            case Source_of:
            case Then_text:
            case Analysis:
            case Analyzes:
            case Confirms:
            case Evidence:
            case Features:
            case Filename:
            case Has_type:
            case Instance:
            case Mentions:
            case Property:
            case Provides:
            case Requires:
            case Reviewed:
            case Reviewer:
            case Solution:
            case Verifies:
            case As_list:
            case Governs:
            case If_text:
            case Is_data:
            case Is_port:
            case Part_of:
            case Reviews:
            case Type_of:
            case Warning:
            case Append:
            case As_set:
            case Author:
            case Exists:
            case Failed:
            case Forall:
            case Is_bus:
            case Length:
            case Member:
            case Metric:
            case Parent:
            case Passed:
            case Source:
            case Debug:
            case Error:
            case False:
            case Union:
            case Fail:
            case Head:
            case Info:
            case Name:
            case Size:
            case Step:
            case Tail:
            case Text:
            case This:
            case True:
            case Type:
            case Let:
            case Sum:
            case If:
            case LeftSquareBracket:
            case LeftCurlyBracket:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
            case RULE_ID:
                {
                alt31=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalResoluteParser.g:3717:2: ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    {
                    // InternalResoluteParser.g:3717:2: ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    // InternalResoluteParser.g:3717:3: () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) )
                    {
                    // InternalResoluteParser.g:3717:3: ()
                    // InternalResoluteParser.g:3718:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getUnaryExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3723:2: ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) )
                    // InternalResoluteParser.g:3724:1: ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) )
                    {
                    // InternalResoluteParser.g:3724:1: ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) )
                    // InternalResoluteParser.g:3725:1: (lv_op_1_1= HyphenMinus | lv_op_1_2= Not )
                    {
                    // InternalResoluteParser.g:3725:1: (lv_op_1_1= HyphenMinus | lv_op_1_2= Not )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==HyphenMinus) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==Not) ) {
                        alt30=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalResoluteParser.g:3726:3: lv_op_1_1= HyphenMinus
                            {
                            lv_op_1_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_1, grammarAccess.getPrefixExprAccess().getOpHyphenMinusKeyword_0_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalResoluteParser.g:3739:8: lv_op_1_2= Not
                            {
                            lv_op_1_2=(Token)match(input,Not,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_1_2, grammarAccess.getPrefixExprAccess().getOpNotKeyword_0_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getPrefixExprRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_1_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalResoluteParser.g:3755:2: ( (lv_expr_2_0= rulePrefixExpr ) )
                    // InternalResoluteParser.g:3756:1: (lv_expr_2_0= rulePrefixExpr )
                    {
                    // InternalResoluteParser.g:3756:1: (lv_expr_2_0= rulePrefixExpr )
                    // InternalResoluteParser.g:3757:3: lv_expr_2_0= rulePrefixExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixExprAccess().getExprPrefixExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_2_0=rulePrefixExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixExprRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.PrefixExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:3774:6: ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) )
                    {
                    // InternalResoluteParser.g:3774:6: ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) )
                    // InternalResoluteParser.g:3774:7: () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) )
                    {
                    // InternalResoluteParser.g:3774:7: ()
                    // InternalResoluteParser.g:3775:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getCastExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPrefixExprAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // InternalResoluteParser.g:3785:1: ( (lv_type_5_0= ruleBaseType ) )
                    // InternalResoluteParser.g:3786:1: (lv_type_5_0= ruleBaseType )
                    {
                    // InternalResoluteParser.g:3786:1: (lv_type_5_0= ruleBaseType )
                    // InternalResoluteParser.g:3787:3: lv_type_5_0= ruleBaseType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixExprAccess().getTypeBaseTypeParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_38);
                    lv_type_5_0=ruleBaseType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixExprRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_5_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.BaseType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrefixExprAccess().getRightParenthesisKeyword_1_3());
                          
                    }
                    // InternalResoluteParser.g:3808:1: ( (lv_expr_7_0= rulePrefixExpr ) )
                    // InternalResoluteParser.g:3809:1: (lv_expr_7_0= rulePrefixExpr )
                    {
                    // InternalResoluteParser.g:3809:1: (lv_expr_7_0= rulePrefixExpr )
                    // InternalResoluteParser.g:3810:3: lv_expr_7_0= rulePrefixExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixExprAccess().getExprPrefixExprParserRuleCall_1_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_7_0=rulePrefixExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixExprRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_7_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.PrefixExpr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:3828:5: this_AtomicExpr_8= ruleAtomicExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixExprAccess().getAtomicExprParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AtomicExpr_8=ruleAtomicExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_AtomicExpr_8;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixExpr"


    // $ANTLR start "entryRuleAtomicExpr"
    // InternalResoluteParser.g:3844:1: entryRuleAtomicExpr returns [EObject current=null] : iv_ruleAtomicExpr= ruleAtomicExpr EOF ;
    public final EObject entryRuleAtomicExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpr = null;


        try {
            // InternalResoluteParser.g:3845:2: (iv_ruleAtomicExpr= ruleAtomicExpr EOF )
            // InternalResoluteParser.g:3846:2: iv_ruleAtomicExpr= ruleAtomicExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAtomicExpr=ruleAtomicExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExpr; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExpr"


    // $ANTLR start "ruleAtomicExpr"
    // InternalResoluteParser.g:3853:1: ruleAtomicExpr returns [EObject current=null] : ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ( (lv_name_105_0= RULE_ID ) ) otherlv_106= Colon ( (lv_val_107_0= ruleStringTerm ) ) ) | ( () otherlv_109= Solution ( (lv_name_110_0= RULE_ID ) ) otherlv_111= Colon ( (lv_val_112_0= ruleStringTerm ) ) ) ) ;
    public final EObject ruleAtomicExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token lv_quant_30_1=null;
        Token lv_quant_30_2=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token lv_libName_37_0=null;
        Token otherlv_38=null;
        Token lv_fnName_39_0=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_47=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        Token otherlv_54=null;
        Token otherlv_56=null;
        Token otherlv_58=null;
        Token otherlv_61=null;
        Token otherlv_64=null;
        Token otherlv_65=null;
        Token otherlv_67=null;
        Token otherlv_68=null;
        Token otherlv_71=null;
        Token otherlv_73=null;
        Token otherlv_74=null;
        Token otherlv_77=null;
        Token otherlv_78=null;
        Token otherlv_80=null;
        Token otherlv_81=null;
        Token otherlv_84=null;
        Token otherlv_86=null;
        Token otherlv_88=null;
        Token otherlv_89=null;
        Token otherlv_91=null;
        Token otherlv_92=null;
        Token otherlv_94=null;
        Token otherlv_96=null;
        Token otherlv_98=null;
        Token otherlv_100=null;
        Token otherlv_102=null;
        Token otherlv_104=null;
        Token lv_name_105_0=null;
        Token otherlv_106=null;
        Token otherlv_109=null;
        Token lv_name_110_0=null;
        Token otherlv_111=null;
        EObject lv_sub_5_0 = null;

        EObject lv_val_8_0 = null;

        EObject lv_failmsg_10_0 = null;

        AntlrDatatypeRuleToken lv_result_13_0 = null;

        EObject lv_val_15_0 = null;

        EObject lv_val_17_0 = null;

        EObject lv_val_19_0 = null;

        EObject lv_val_21_0 = null;

        EObject lv_cond_24_0 = null;

        EObject lv_then_26_0 = null;

        EObject lv_else_28_0 = null;

        EObject lv_args_32_0 = null;

        EObject lv_expr_35_0 = null;

        EObject lv_args_41_0 = null;

        EObject lv_args_43_0 = null;

        AntlrDatatypeRuleToken lv_fn_46_0 = null;

        EObject lv_args_48_0 = null;

        EObject lv_args_50_0 = null;

        EObject lv_args_55_0 = null;

        EObject lv_args_57_0 = null;

        EObject lv_lintStmt_60_0 = null;

        EObject this_Expr_62 = null;

        EObject lv_args_66_0 = null;

        EObject lv_filter_69_0 = null;

        EObject lv_exprs_72_0 = null;

        EObject this_Expr_75 = null;

        EObject lv_args_79_0 = null;

        EObject lv_filter_82_0 = null;

        EObject lv_exprs_85_0 = null;

        EObject lv_binding_95_0 = null;

        EObject lv_expr_97_0 = null;

        EObject this_Expr_99 = null;

        EObject lv_val_107_0 = null;

        EObject lv_val_112_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3856:28: ( ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ( (lv_name_105_0= RULE_ID ) ) otherlv_106= Colon ( (lv_val_107_0= ruleStringTerm ) ) ) | ( () otherlv_109= Solution ( (lv_name_110_0= RULE_ID ) ) otherlv_111= Colon ( (lv_val_112_0= ruleStringTerm ) ) ) ) )
            // InternalResoluteParser.g:3857:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ( (lv_name_105_0= RULE_ID ) ) otherlv_106= Colon ( (lv_val_107_0= ruleStringTerm ) ) ) | ( () otherlv_109= Solution ( (lv_name_110_0= RULE_ID ) ) otherlv_111= Colon ( (lv_val_112_0= ruleStringTerm ) ) ) )
            {
            // InternalResoluteParser.g:3857:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ( (lv_name_105_0= RULE_ID ) ) otherlv_106= Colon ( (lv_val_107_0= ruleStringTerm ) ) ) | ( () otherlv_109= Solution ( (lv_name_110_0= RULE_ID ) ) otherlv_111= Colon ( (lv_val_112_0= ruleStringTerm ) ) ) )
            int alt51=23;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalResoluteParser.g:3857:2: ( () ( ( ruleQCREF ) ) )
                    {
                    // InternalResoluteParser.g:3857:2: ( () ( ( ruleQCREF ) ) )
                    // InternalResoluteParser.g:3857:3: () ( ( ruleQCREF ) )
                    {
                    // InternalResoluteParser.g:3857:3: ()
                    // InternalResoluteParser.g:3858:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIdExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3863:2: ( ( ruleQCREF ) )
                    // InternalResoluteParser.g:3864:1: ( ruleQCREF )
                    {
                    // InternalResoluteParser.g:3864:1: ( ruleQCREF )
                    // InternalResoluteParser.g:3865:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getIdNamedElementCrossReference_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:3880:6: ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? )
                    {
                    // InternalResoluteParser.g:3880:6: ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? )
                    // InternalResoluteParser.g:3880:7: () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )?
                    {
                    // InternalResoluteParser.g:3880:7: ()
                    // InternalResoluteParser.g:3881:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getThisExprAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,This,FollowSets000.FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getAtomicExprAccess().getThisKeyword_1_1());
                          
                    }
                    // InternalResoluteParser.g:3891:1: (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==FullStop) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalResoluteParser.g:3892:2: otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) )
                            {
                            otherlv_4=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getAtomicExprAccess().getFullStopKeyword_1_2_0());
                                  
                            }
                            // InternalResoluteParser.g:3896:1: ( (lv_sub_5_0= ruleNestedDotID ) )
                            // InternalResoluteParser.g:3897:1: (lv_sub_5_0= ruleNestedDotID )
                            {
                            // InternalResoluteParser.g:3897:1: (lv_sub_5_0= ruleNestedDotID )
                            // InternalResoluteParser.g:3898:3: lv_sub_5_0= ruleNestedDotID
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExprAccess().getSubNestedDotIDParserRuleCall_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_sub_5_0=ruleNestedDotID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"sub",
                                      		lv_sub_5_0, 
                                      		"com.rockwellcollins.atc.resolute.Resolute.NestedDotID");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:3915:6: ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) )
                    {
                    // InternalResoluteParser.g:3915:6: ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) )
                    // InternalResoluteParser.g:3915:7: () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) )
                    {
                    // InternalResoluteParser.g:3915:7: ()
                    // InternalResoluteParser.g:3916:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getFailExprAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,Fail,FollowSets000.FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getAtomicExprAccess().getFailKeyword_2_1());
                          
                    }
                    // InternalResoluteParser.g:3926:1: ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==Control_flows_to_unconditionally||LA34_0==Control_flows_to_conditionally||LA34_0==Revised_without_review||LA34_0==Error_state_reachable||LA34_0==Is_virtual_processor||(LA34_0>=Flow_specifications && LA34_0<=Is_abstract_feature)||LA34_0==Revised_with_review||LA34_0==Enumerated_values||(LA34_0>=End_to_end_flows && LA34_0<=Is_bidirectional)||LA34_0==Annotation_type||(LA34_0>=Is_thread_group && LA34_0<=Property_member)||LA34_0==Subcomponent_of||(LA34_0>=Destination_of && LA34_0<=Is_virtual_bus)||(LA34_0>=Compile_input && LA34_0<=Contain_error)||(LA34_0>=Flow_elements && LA34_0<=Is_subprogram)||LA34_0==Package_input||(LA34_0>=Receive_error && LA34_0<=Subcomponents)||(LA34_0>=Developed_by && LA34_0<=Is_processor)||LA34_0==Performed_by||LA34_0==Requirements||(LA34_0>=Annotations && LA34_0<=Consumed_by)||(LA34_0>=Description && LA34_0<=Provided_by)||(LA34_0>=Undeveloped && LA34_0<=Upper_bound)||(LA34_0>=Created_by && LA34_0<=Definition)||(LA34_0>=Given_text && LA34_0<=Identified)||(LA34_0>=Is_of_type && LA34_0<=Referenced)||LA34_0==Value_type||(LA34_0>=Direction && LA34_0<=Instances)||LA34_0==Intersect||(LA34_0>=Is_device && LA34_0<=Mitigates)||(LA34_0>=Result_of && LA34_0<=Then_text)||(LA34_0>=Analysis && LA34_0<=Analyzes)||LA34_0==Confirms||(LA34_0>=Evidence && LA34_0<=Mentions)||(LA34_0>=Property && LA34_0<=Solution)||LA34_0==Verifies||LA34_0==As_list||(LA34_0>=Governs && LA34_0<=Part_of)||LA34_0==Reviews||(LA34_0>=Type_of && LA34_0<=Warning)||(LA34_0>=Append && LA34_0<=Author)||(LA34_0>=Exists && LA34_0<=Forall)||(LA34_0>=Is_bus && LA34_0<=Member)||LA34_0==Metric||(LA34_0>=Parent && LA34_0<=Passed)||LA34_0==Source||LA34_0==Debug||(LA34_0>=Error && LA34_0<=False)||LA34_0==Union||LA34_0==Fail||(LA34_0>=Head && LA34_0<=Name)||(LA34_0>=Size && LA34_0<=Tail)||LA34_0==Text||(LA34_0>=This && LA34_0<=Type)||(LA34_0>=Let && LA34_0<=Sum)||LA34_0==If||LA34_0==LeftParenthesis||LA34_0==HyphenMinus||LA34_0==LeftSquareBracket||LA34_0==LeftCurlyBracket||LA34_0==RULE_REAL_LIT||LA34_0==RULE_INTEGER_LIT||(LA34_0>=RULE_STRING && LA34_0<=RULE_ID)) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==AsteriskAsterisk) ) {
                        alt34=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalResoluteParser.g:3926:2: ( (lv_val_8_0= ruleExpr ) )
                            {
                            // InternalResoluteParser.g:3926:2: ( (lv_val_8_0= ruleExpr ) )
                            // InternalResoluteParser.g:3927:1: (lv_val_8_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3927:1: (lv_val_8_0= ruleExpr )
                            // InternalResoluteParser.g:3928:3: lv_val_8_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExprAccess().getValExprParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_val_8_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"val",
                                      		lv_val_8_0, 
                                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalResoluteParser.g:3945:6: (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk )
                            {
                            // InternalResoluteParser.g:3945:6: (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk )
                            // InternalResoluteParser.g:3946:2: otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk
                            {
                            otherlv_9=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getAtomicExprAccess().getAsteriskAsteriskKeyword_2_2_1_0());
                                  
                            }
                            // InternalResoluteParser.g:3950:1: ( (lv_failmsg_10_0= ruleClaimText ) )+
                            int cnt33=0;
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_ID)) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3951:1: (lv_failmsg_10_0= ruleClaimText )
                            	    {
                            	    // InternalResoluteParser.g:3951:1: (lv_failmsg_10_0= ruleClaimText )
                            	    // InternalResoluteParser.g:3952:3: lv_failmsg_10_0= ruleClaimText
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFailmsgClaimTextParserRuleCall_2_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_24);
                            	    lv_failmsg_10_0=ruleClaimText();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"failmsg",
                            	              		lv_failmsg_10_0, 
                            	              		"com.rockwellcollins.atc.resolute.Resolute.ClaimText");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt33 >= 1 ) break loop33;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(33, input);
                                        throw eee;
                                }
                                cnt33++;
                            } while (true);

                            otherlv_11=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_11, grammarAccess.getAtomicExprAccess().getAsteriskAsteriskKeyword_2_2_1_2());
                                  
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:3974:6: ( () ( (lv_result_13_0= ruleResult ) ) )
                    {
                    // InternalResoluteParser.g:3974:6: ( () ( (lv_result_13_0= ruleResult ) ) )
                    // InternalResoluteParser.g:3974:7: () ( (lv_result_13_0= ruleResult ) )
                    {
                    // InternalResoluteParser.g:3974:7: ()
                    // InternalResoluteParser.g:3975:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getResultExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3980:2: ( (lv_result_13_0= ruleResult ) )
                    // InternalResoluteParser.g:3981:1: (lv_result_13_0= ruleResult )
                    {
                    // InternalResoluteParser.g:3981:1: (lv_result_13_0= ruleResult )
                    // InternalResoluteParser.g:3982:3: lv_result_13_0= ruleResult
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getResultResultParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_result_13_0=ruleResult();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"result",
                              		lv_result_13_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Result");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:3999:6: ( () ( (lv_val_15_0= ruleIntegerTerm ) ) )
                    {
                    // InternalResoluteParser.g:3999:6: ( () ( (lv_val_15_0= ruleIntegerTerm ) ) )
                    // InternalResoluteParser.g:3999:7: () ( (lv_val_15_0= ruleIntegerTerm ) )
                    {
                    // InternalResoluteParser.g:3999:7: ()
                    // InternalResoluteParser.g:4000:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIntExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4005:2: ( (lv_val_15_0= ruleIntegerTerm ) )
                    // InternalResoluteParser.g:4006:1: (lv_val_15_0= ruleIntegerTerm )
                    {
                    // InternalResoluteParser.g:4006:1: (lv_val_15_0= ruleIntegerTerm )
                    // InternalResoluteParser.g:4007:3: lv_val_15_0= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getValIntegerTermParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_15_0=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_15_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.IntegerTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:4024:6: ( () ( (lv_val_17_0= ruleRealTerm ) ) )
                    {
                    // InternalResoluteParser.g:4024:6: ( () ( (lv_val_17_0= ruleRealTerm ) ) )
                    // InternalResoluteParser.g:4024:7: () ( (lv_val_17_0= ruleRealTerm ) )
                    {
                    // InternalResoluteParser.g:4024:7: ()
                    // InternalResoluteParser.g:4025:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getRealExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4030:2: ( (lv_val_17_0= ruleRealTerm ) )
                    // InternalResoluteParser.g:4031:1: (lv_val_17_0= ruleRealTerm )
                    {
                    // InternalResoluteParser.g:4031:1: (lv_val_17_0= ruleRealTerm )
                    // InternalResoluteParser.g:4032:3: lv_val_17_0= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getValRealTermParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_17_0=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_17_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.RealTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:4049:6: ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) )
                    {
                    // InternalResoluteParser.g:4049:6: ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) )
                    // InternalResoluteParser.g:4049:7: () ( (lv_val_19_0= ruleBooleanLiteral ) )
                    {
                    // InternalResoluteParser.g:4049:7: ()
                    // InternalResoluteParser.g:4050:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getBoolExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4055:2: ( (lv_val_19_0= ruleBooleanLiteral ) )
                    // InternalResoluteParser.g:4056:1: (lv_val_19_0= ruleBooleanLiteral )
                    {
                    // InternalResoluteParser.g:4056:1: (lv_val_19_0= ruleBooleanLiteral )
                    // InternalResoluteParser.g:4057:3: lv_val_19_0= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getValBooleanLiteralParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_19_0=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_19_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.BooleanLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalResoluteParser.g:4074:6: ( () ( (lv_val_21_0= ruleStringTerm ) ) )
                    {
                    // InternalResoluteParser.g:4074:6: ( () ( (lv_val_21_0= ruleStringTerm ) ) )
                    // InternalResoluteParser.g:4074:7: () ( (lv_val_21_0= ruleStringTerm ) )
                    {
                    // InternalResoluteParser.g:4074:7: ()
                    // InternalResoluteParser.g:4075:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getStringExprAction_7_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4080:2: ( (lv_val_21_0= ruleStringTerm ) )
                    // InternalResoluteParser.g:4081:1: (lv_val_21_0= ruleStringTerm )
                    {
                    // InternalResoluteParser.g:4081:1: (lv_val_21_0= ruleStringTerm )
                    // InternalResoluteParser.g:4082:3: lv_val_21_0= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getValStringTermParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_21_0=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_21_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.StringTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalResoluteParser.g:4099:6: ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4099:6: ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4099:7: () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4099:7: ()
                    // InternalResoluteParser.g:4100:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIfThenElseExprAction_8_0(),
                                  current);
                          
                    }

                    }

                    otherlv_23=(Token)match(input,If,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_23, grammarAccess.getAtomicExprAccess().getIfKeyword_8_1());
                          
                    }
                    // InternalResoluteParser.g:4110:1: ( (lv_cond_24_0= ruleExpr ) )
                    // InternalResoluteParser.g:4111:1: (lv_cond_24_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4111:1: (lv_cond_24_0= ruleExpr )
                    // InternalResoluteParser.g:4112:3: lv_cond_24_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getCondExprParserRuleCall_8_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_41);
                    lv_cond_24_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"cond",
                              		lv_cond_24_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_25=(Token)match(input,Then,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getAtomicExprAccess().getThenKeyword_8_3());
                          
                    }
                    // InternalResoluteParser.g:4133:1: ( (lv_then_26_0= ruleExpr ) )
                    // InternalResoluteParser.g:4134:1: (lv_then_26_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4134:1: (lv_then_26_0= ruleExpr )
                    // InternalResoluteParser.g:4135:3: lv_then_26_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getThenExprParserRuleCall_8_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_42);
                    lv_then_26_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"then",
                              		lv_then_26_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_27=(Token)match(input,Else,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getAtomicExprAccess().getElseKeyword_8_5());
                          
                    }
                    // InternalResoluteParser.g:4156:1: ( (lv_else_28_0= ruleExpr ) )
                    // InternalResoluteParser.g:4157:1: (lv_else_28_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4157:1: (lv_else_28_0= ruleExpr )
                    // InternalResoluteParser.g:4158:3: lv_else_28_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getElseExprParserRuleCall_8_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_else_28_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_28_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalResoluteParser.g:4175:6: ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4175:6: ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4175:7: () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4175:7: ()
                    // InternalResoluteParser.g:4176:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getQuantifiedExprAction_9_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4181:2: ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) )
                    // InternalResoluteParser.g:4182:1: ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) )
                    {
                    // InternalResoluteParser.g:4182:1: ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) )
                    // InternalResoluteParser.g:4183:1: (lv_quant_30_1= Forall | lv_quant_30_2= Exists )
                    {
                    // InternalResoluteParser.g:4183:1: (lv_quant_30_1= Forall | lv_quant_30_2= Exists )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==Forall) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==Exists) ) {
                        alt35=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalResoluteParser.g:4184:3: lv_quant_30_1= Forall
                            {
                            lv_quant_30_1=(Token)match(input,Forall,FollowSets000.FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_quant_30_1, grammarAccess.getAtomicExprAccess().getQuantForallKeyword_9_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicExprRule());
                              	        }
                                     		setWithLastConsumed(current, "quant", lv_quant_30_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalResoluteParser.g:4197:8: lv_quant_30_2= Exists
                            {
                            lv_quant_30_2=(Token)match(input,Exists,FollowSets000.FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_quant_30_2, grammarAccess.getAtomicExprAccess().getQuantExistsKeyword_9_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicExprRule());
                              	        }
                                     		setWithLastConsumed(current, "quant", lv_quant_30_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalResoluteParser.g:4213:2: (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==LeftParenthesis) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalResoluteParser.g:4214:2: otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis
                    	    {
                    	    otherlv_31=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_31, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_9_2_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:4218:1: ( (lv_args_32_0= ruleArg ) )
                    	    // InternalResoluteParser.g:4219:1: (lv_args_32_0= ruleArg )
                    	    {
                    	    // InternalResoluteParser.g:4219:1: (lv_args_32_0= ruleArg )
                    	    // InternalResoluteParser.g:4220:3: lv_args_32_0= ruleArg
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsArgParserRuleCall_9_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_38);
                    	    lv_args_32_0=ruleArg();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_32_0, 
                    	              		"com.rockwellcollins.atc.resolute.Resolute.Arg");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    otherlv_33=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_43); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_33, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_9_2_2());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);

                    otherlv_34=(Token)match(input,FullStop,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_34, grammarAccess.getAtomicExprAccess().getFullStopKeyword_9_3());
                          
                    }
                    // InternalResoluteParser.g:4246:1: ( (lv_expr_35_0= ruleExpr ) )
                    // InternalResoluteParser.g:4247:1: (lv_expr_35_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4247:1: (lv_expr_35_0= ruleExpr )
                    // InternalResoluteParser.g:4248:3: lv_expr_35_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprExprParserRuleCall_9_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_35_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_35_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalResoluteParser.g:4265:6: ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) )
                    {
                    // InternalResoluteParser.g:4265:6: ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) )
                    // InternalResoluteParser.g:4265:7: ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis )
                    {
                    // InternalResoluteParser.g:4292:5: ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis )
                    // InternalResoluteParser.g:4292:6: () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis
                    {
                    // InternalResoluteParser.g:4292:6: ()
                    // InternalResoluteParser.g:4293:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getLibraryFnCallExprAction_10_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4298:2: ( (lv_libName_37_0= RULE_ID ) )
                    // InternalResoluteParser.g:4299:1: (lv_libName_37_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:4299:1: (lv_libName_37_0= RULE_ID )
                    // InternalResoluteParser.g:4300:3: lv_libName_37_0= RULE_ID
                    {
                    lv_libName_37_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_libName_37_0, grammarAccess.getAtomicExprAccess().getLibNameIDTerminalRuleCall_10_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"libName",
                              		lv_libName_37_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }

                    otherlv_38=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_38, grammarAccess.getAtomicExprAccess().getFullStopKeyword_10_0_2());
                          
                    }
                    // InternalResoluteParser.g:4321:1: ( (lv_fnName_39_0= RULE_ID ) )
                    // InternalResoluteParser.g:4322:1: (lv_fnName_39_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:4322:1: (lv_fnName_39_0= RULE_ID )
                    // InternalResoluteParser.g:4323:3: lv_fnName_39_0= RULE_ID
                    {
                    lv_fnName_39_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_fnName_39_0, grammarAccess.getAtomicExprAccess().getFnNameIDTerminalRuleCall_10_0_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"fnName",
                              		lv_fnName_39_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }

                    otherlv_40=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_40, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_10_0_4());
                          
                    }
                    // InternalResoluteParser.g:4344:1: ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==Control_flows_to_unconditionally||LA38_0==Control_flows_to_conditionally||LA38_0==Revised_without_review||LA38_0==Error_state_reachable||LA38_0==Is_virtual_processor||(LA38_0>=Flow_specifications && LA38_0<=Is_abstract_feature)||LA38_0==Revised_with_review||LA38_0==Enumerated_values||(LA38_0>=End_to_end_flows && LA38_0<=Is_bidirectional)||LA38_0==Annotation_type||(LA38_0>=Is_thread_group && LA38_0<=Property_member)||LA38_0==Subcomponent_of||(LA38_0>=Destination_of && LA38_0<=Is_virtual_bus)||(LA38_0>=Compile_input && LA38_0<=Contain_error)||(LA38_0>=Flow_elements && LA38_0<=Is_subprogram)||LA38_0==Package_input||(LA38_0>=Receive_error && LA38_0<=Subcomponents)||(LA38_0>=Developed_by && LA38_0<=Is_processor)||LA38_0==Performed_by||LA38_0==Requirements||(LA38_0>=Annotations && LA38_0<=Consumed_by)||(LA38_0>=Description && LA38_0<=Provided_by)||(LA38_0>=Undeveloped && LA38_0<=Upper_bound)||(LA38_0>=Created_by && LA38_0<=Definition)||(LA38_0>=Given_text && LA38_0<=Identified)||(LA38_0>=Is_of_type && LA38_0<=Referenced)||LA38_0==Value_type||(LA38_0>=Direction && LA38_0<=Instances)||LA38_0==Intersect||(LA38_0>=Is_device && LA38_0<=Mitigates)||(LA38_0>=Result_of && LA38_0<=Then_text)||(LA38_0>=Analysis && LA38_0<=Analyzes)||LA38_0==Confirms||(LA38_0>=Evidence && LA38_0<=Mentions)||(LA38_0>=Property && LA38_0<=Solution)||LA38_0==Verifies||LA38_0==As_list||(LA38_0>=Governs && LA38_0<=Part_of)||LA38_0==Reviews||(LA38_0>=Type_of && LA38_0<=Warning)||(LA38_0>=Append && LA38_0<=Author)||(LA38_0>=Exists && LA38_0<=Forall)||(LA38_0>=Is_bus && LA38_0<=Member)||LA38_0==Metric||(LA38_0>=Parent && LA38_0<=Passed)||LA38_0==Source||LA38_0==Debug||(LA38_0>=Error && LA38_0<=False)||LA38_0==Union||LA38_0==Fail||(LA38_0>=Head && LA38_0<=Name)||(LA38_0>=Size && LA38_0<=Tail)||LA38_0==Text||(LA38_0>=This && LA38_0<=Type)||(LA38_0>=Let && LA38_0<=Sum)||LA38_0==If||LA38_0==LeftParenthesis||LA38_0==HyphenMinus||LA38_0==LeftSquareBracket||LA38_0==LeftCurlyBracket||LA38_0==RULE_REAL_LIT||LA38_0==RULE_INTEGER_LIT||(LA38_0>=RULE_STRING && LA38_0<=RULE_ID)) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalResoluteParser.g:4344:2: ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:4344:2: ( (lv_args_41_0= ruleExpr ) )
                            // InternalResoluteParser.g:4345:1: (lv_args_41_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:4345:1: (lv_args_41_0= ruleExpr )
                            // InternalResoluteParser.g:4346:3: lv_args_41_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_10_0_5_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_20);
                            lv_args_41_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"args",
                                      		lv_args_41_0, 
                                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalResoluteParser.g:4362:2: (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )*
                            loop37:
                            do {
                                int alt37=2;
                                int LA37_0 = input.LA(1);

                                if ( (LA37_0==Comma) ) {
                                    alt37=1;
                                }


                                switch (alt37) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4363:2: otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) )
                            	    {
                            	    otherlv_42=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_42, grammarAccess.getAtomicExprAccess().getCommaKeyword_10_0_5_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4367:1: ( (lv_args_43_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:4368:1: (lv_args_43_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:4368:1: (lv_args_43_0= ruleExpr )
                            	    // InternalResoluteParser.g:4369:3: lv_args_43_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_10_0_5_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_20);
                            	    lv_args_43_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"args",
                            	              		lv_args_43_0, 
                            	              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop37;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_44=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_44, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_10_0_6());
                          
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalResoluteParser.g:4391:6: ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis )
                    {
                    // InternalResoluteParser.g:4391:6: ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis )
                    // InternalResoluteParser.g:4391:7: () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis
                    {
                    // InternalResoluteParser.g:4391:7: ()
                    // InternalResoluteParser.g:4392:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getBuiltInFnCallExprAction_11_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4397:2: ( (lv_fn_46_0= ruleBuiltInFn ) )
                    // InternalResoluteParser.g:4398:1: (lv_fn_46_0= ruleBuiltInFn )
                    {
                    // InternalResoluteParser.g:4398:1: (lv_fn_46_0= ruleBuiltInFn )
                    // InternalResoluteParser.g:4399:3: lv_fn_46_0= ruleBuiltInFn
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFnBuiltInFnParserRuleCall_11_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    lv_fn_46_0=ruleBuiltInFn();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"fn",
                              		lv_fn_46_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.BuiltInFn");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_47=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_47, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_11_2());
                          
                    }
                    // InternalResoluteParser.g:4420:1: ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==Control_flows_to_unconditionally||LA40_0==Control_flows_to_conditionally||LA40_0==Revised_without_review||LA40_0==Error_state_reachable||LA40_0==Is_virtual_processor||(LA40_0>=Flow_specifications && LA40_0<=Is_abstract_feature)||LA40_0==Revised_with_review||LA40_0==Enumerated_values||(LA40_0>=End_to_end_flows && LA40_0<=Is_bidirectional)||LA40_0==Annotation_type||(LA40_0>=Is_thread_group && LA40_0<=Property_member)||LA40_0==Subcomponent_of||(LA40_0>=Destination_of && LA40_0<=Is_virtual_bus)||(LA40_0>=Compile_input && LA40_0<=Contain_error)||(LA40_0>=Flow_elements && LA40_0<=Is_subprogram)||LA40_0==Package_input||(LA40_0>=Receive_error && LA40_0<=Subcomponents)||(LA40_0>=Developed_by && LA40_0<=Is_processor)||LA40_0==Performed_by||LA40_0==Requirements||(LA40_0>=Annotations && LA40_0<=Consumed_by)||(LA40_0>=Description && LA40_0<=Provided_by)||(LA40_0>=Undeveloped && LA40_0<=Upper_bound)||(LA40_0>=Created_by && LA40_0<=Definition)||(LA40_0>=Given_text && LA40_0<=Identified)||(LA40_0>=Is_of_type && LA40_0<=Referenced)||LA40_0==Value_type||(LA40_0>=Direction && LA40_0<=Instances)||LA40_0==Intersect||(LA40_0>=Is_device && LA40_0<=Mitigates)||(LA40_0>=Result_of && LA40_0<=Then_text)||(LA40_0>=Analysis && LA40_0<=Analyzes)||LA40_0==Confirms||(LA40_0>=Evidence && LA40_0<=Mentions)||(LA40_0>=Property && LA40_0<=Solution)||LA40_0==Verifies||LA40_0==As_list||(LA40_0>=Governs && LA40_0<=Part_of)||LA40_0==Reviews||(LA40_0>=Type_of && LA40_0<=Warning)||(LA40_0>=Append && LA40_0<=Author)||(LA40_0>=Exists && LA40_0<=Forall)||(LA40_0>=Is_bus && LA40_0<=Member)||LA40_0==Metric||(LA40_0>=Parent && LA40_0<=Passed)||LA40_0==Source||LA40_0==Debug||(LA40_0>=Error && LA40_0<=False)||LA40_0==Union||LA40_0==Fail||(LA40_0>=Head && LA40_0<=Name)||(LA40_0>=Size && LA40_0<=Tail)||LA40_0==Text||(LA40_0>=This && LA40_0<=Type)||(LA40_0>=Let && LA40_0<=Sum)||LA40_0==If||LA40_0==LeftParenthesis||LA40_0==HyphenMinus||LA40_0==LeftSquareBracket||LA40_0==LeftCurlyBracket||LA40_0==RULE_REAL_LIT||LA40_0==RULE_INTEGER_LIT||(LA40_0>=RULE_STRING && LA40_0<=RULE_ID)) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalResoluteParser.g:4420:2: ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:4420:2: ( (lv_args_48_0= ruleExpr ) )
                            // InternalResoluteParser.g:4421:1: (lv_args_48_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:4421:1: (lv_args_48_0= ruleExpr )
                            // InternalResoluteParser.g:4422:3: lv_args_48_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_11_3_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_20);
                            lv_args_48_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"args",
                                      		lv_args_48_0, 
                                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalResoluteParser.g:4438:2: (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )*
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==Comma) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4439:2: otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) )
                            	    {
                            	    otherlv_49=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_49, grammarAccess.getAtomicExprAccess().getCommaKeyword_11_3_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4443:1: ( (lv_args_50_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:4444:1: (lv_args_50_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:4444:1: (lv_args_50_0= ruleExpr )
                            	    // InternalResoluteParser.g:4445:3: lv_args_50_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_11_3_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_20);
                            	    lv_args_50_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"args",
                            	              		lv_args_50_0, 
                            	              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop39;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_51=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_51, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_11_4());
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalResoluteParser.g:4467:6: ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis )
                    {
                    // InternalResoluteParser.g:4467:6: ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis )
                    // InternalResoluteParser.g:4467:7: () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis
                    {
                    // InternalResoluteParser.g:4467:7: ()
                    // InternalResoluteParser.g:4468:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getFnCallExprAction_12_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4473:2: ( (otherlv_53= RULE_ID ) )
                    // InternalResoluteParser.g:4474:1: (otherlv_53= RULE_ID )
                    {
                    // InternalResoluteParser.g:4474:1: (otherlv_53= RULE_ID )
                    // InternalResoluteParser.g:4475:3: otherlv_53= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                              
                    }
                    otherlv_53=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_53, grammarAccess.getAtomicExprAccess().getFnFunctionDefinitionCrossReference_12_1_0()); 
                      	
                    }

                    }


                    }

                    otherlv_54=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_54, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_12_2());
                          
                    }
                    // InternalResoluteParser.g:4491:1: ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==Control_flows_to_unconditionally||LA42_0==Control_flows_to_conditionally||LA42_0==Revised_without_review||LA42_0==Error_state_reachable||LA42_0==Is_virtual_processor||(LA42_0>=Flow_specifications && LA42_0<=Is_abstract_feature)||LA42_0==Revised_with_review||LA42_0==Enumerated_values||(LA42_0>=End_to_end_flows && LA42_0<=Is_bidirectional)||LA42_0==Annotation_type||(LA42_0>=Is_thread_group && LA42_0<=Property_member)||LA42_0==Subcomponent_of||(LA42_0>=Destination_of && LA42_0<=Is_virtual_bus)||(LA42_0>=Compile_input && LA42_0<=Contain_error)||(LA42_0>=Flow_elements && LA42_0<=Is_subprogram)||LA42_0==Package_input||(LA42_0>=Receive_error && LA42_0<=Subcomponents)||(LA42_0>=Developed_by && LA42_0<=Is_processor)||LA42_0==Performed_by||LA42_0==Requirements||(LA42_0>=Annotations && LA42_0<=Consumed_by)||(LA42_0>=Description && LA42_0<=Provided_by)||(LA42_0>=Undeveloped && LA42_0<=Upper_bound)||(LA42_0>=Created_by && LA42_0<=Definition)||(LA42_0>=Given_text && LA42_0<=Identified)||(LA42_0>=Is_of_type && LA42_0<=Referenced)||LA42_0==Value_type||(LA42_0>=Direction && LA42_0<=Instances)||LA42_0==Intersect||(LA42_0>=Is_device && LA42_0<=Mitigates)||(LA42_0>=Result_of && LA42_0<=Then_text)||(LA42_0>=Analysis && LA42_0<=Analyzes)||LA42_0==Confirms||(LA42_0>=Evidence && LA42_0<=Mentions)||(LA42_0>=Property && LA42_0<=Solution)||LA42_0==Verifies||LA42_0==As_list||(LA42_0>=Governs && LA42_0<=Part_of)||LA42_0==Reviews||(LA42_0>=Type_of && LA42_0<=Warning)||(LA42_0>=Append && LA42_0<=Author)||(LA42_0>=Exists && LA42_0<=Forall)||(LA42_0>=Is_bus && LA42_0<=Member)||LA42_0==Metric||(LA42_0>=Parent && LA42_0<=Passed)||LA42_0==Source||LA42_0==Debug||(LA42_0>=Error && LA42_0<=False)||LA42_0==Union||LA42_0==Fail||(LA42_0>=Head && LA42_0<=Name)||(LA42_0>=Size && LA42_0<=Tail)||LA42_0==Text||(LA42_0>=This && LA42_0<=Type)||(LA42_0>=Let && LA42_0<=Sum)||LA42_0==If||LA42_0==LeftParenthesis||LA42_0==HyphenMinus||LA42_0==LeftSquareBracket||LA42_0==LeftCurlyBracket||LA42_0==RULE_REAL_LIT||LA42_0==RULE_INTEGER_LIT||(LA42_0>=RULE_STRING && LA42_0<=RULE_ID)) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalResoluteParser.g:4491:2: ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:4491:2: ( (lv_args_55_0= ruleExpr ) )
                            // InternalResoluteParser.g:4492:1: (lv_args_55_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:4492:1: (lv_args_55_0= ruleExpr )
                            // InternalResoluteParser.g:4493:3: lv_args_55_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_12_3_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_20);
                            lv_args_55_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"args",
                                      		lv_args_55_0, 
                                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalResoluteParser.g:4509:2: (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )*
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==Comma) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4510:2: otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) )
                            	    {
                            	    otherlv_56=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_56, grammarAccess.getAtomicExprAccess().getCommaKeyword_12_3_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4514:1: ( (lv_args_57_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:4515:1: (lv_args_57_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:4515:1: (lv_args_57_0= ruleExpr )
                            	    // InternalResoluteParser.g:4516:3: lv_args_57_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_12_3_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_20);
                            	    lv_args_57_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"args",
                            	              		lv_args_57_0, 
                            	              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop41;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_58=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_58, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_12_4());
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalResoluteParser.g:4538:6: ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) )
                    {
                    // InternalResoluteParser.g:4538:6: ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) )
                    // InternalResoluteParser.g:4538:7: () ( (lv_lintStmt_60_0= ruleLintStatement ) )
                    {
                    // InternalResoluteParser.g:4538:7: ()
                    // InternalResoluteParser.g:4539:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getLintExprAction_13_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4544:2: ( (lv_lintStmt_60_0= ruleLintStatement ) )
                    // InternalResoluteParser.g:4545:1: (lv_lintStmt_60_0= ruleLintStatement )
                    {
                    // InternalResoluteParser.g:4545:1: (lv_lintStmt_60_0= ruleLintStatement )
                    // InternalResoluteParser.g:4546:3: lv_lintStmt_60_0= ruleLintStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getLintStmtLintStatementParserRuleCall_13_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_lintStmt_60_0=ruleLintStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"lintStmt",
                              		lv_lintStmt_60_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.LintStatement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 15 :
                    // InternalResoluteParser.g:4563:6: (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:4563:6: (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket )
                    // InternalResoluteParser.g:4564:2: otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket
                    {
                    otherlv_61=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_61, grammarAccess.getAtomicExprAccess().getLeftSquareBracketKeyword_14_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_14_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_45);
                    this_Expr_62=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Expr_62;
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalResoluteParser.g:4577:1: ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==For) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==Comma||LA46_0==RightSquareBracket) ) {
                        alt46=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalResoluteParser.g:4577:2: ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? )
                            {
                            // InternalResoluteParser.g:4577:2: ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? )
                            // InternalResoluteParser.g:4577:3: () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )?
                            {
                            // InternalResoluteParser.g:4577:3: ()
                            // InternalResoluteParser.g:4578:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getAtomicExprAccess().getListFilterMapExprMapAction_14_2_0_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_64=(Token)match(input,For,FollowSets000.FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_64, grammarAccess.getAtomicExprAccess().getForKeyword_14_2_0_1());
                                  
                            }
                            // InternalResoluteParser.g:4588:1: (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+
                            int cnt43=0;
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==LeftParenthesis) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4589:2: otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis
                            	    {
                            	    otherlv_65=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_65, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_14_2_0_2_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4593:1: ( (lv_args_66_0= ruleArg ) )
                            	    // InternalResoluteParser.g:4594:1: (lv_args_66_0= ruleArg )
                            	    {
                            	    // InternalResoluteParser.g:4594:1: (lv_args_66_0= ruleArg )
                            	    // InternalResoluteParser.g:4595:3: lv_args_66_0= ruleArg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsArgParserRuleCall_14_2_0_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_38);
                            	    lv_args_66_0=ruleArg();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"args",
                            	              		lv_args_66_0, 
                            	              		"com.rockwellcollins.atc.resolute.Resolute.Arg");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }

                            	    otherlv_67=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_46); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_67, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_14_2_0_2_2());
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt43 >= 1 ) break loop43;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(43, input);
                                        throw eee;
                                }
                                cnt43++;
                            } while (true);

                            // InternalResoluteParser.g:4616:3: (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )?
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( (LA44_0==VerticalLine) ) {
                                alt44=1;
                            }
                            switch (alt44) {
                                case 1 :
                                    // InternalResoluteParser.g:4617:2: otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) )
                                    {
                                    otherlv_68=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_16); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_68, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_14_2_0_3_0());
                                          
                                    }
                                    // InternalResoluteParser.g:4621:1: ( (lv_filter_69_0= ruleExpr ) )
                                    // InternalResoluteParser.g:4622:1: (lv_filter_69_0= ruleExpr )
                                    {
                                    // InternalResoluteParser.g:4622:1: (lv_filter_69_0= ruleExpr )
                                    // InternalResoluteParser.g:4623:3: lv_filter_69_0= ruleExpr
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFilterExprParserRuleCall_14_2_0_3_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_9);
                                    lv_filter_69_0=ruleExpr();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"filter",
                                              		lv_filter_69_0, 
                                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalResoluteParser.g:4640:6: ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* )
                            {
                            // InternalResoluteParser.g:4640:6: ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* )
                            // InternalResoluteParser.g:4640:7: () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:4640:7: ()
                            // InternalResoluteParser.g:4641:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndAdd(
                                          grammarAccess.getAtomicExprAccess().getListExprExprsAction_14_2_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalResoluteParser.g:4646:2: (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==Comma) ) {
                                    alt45=1;
                                }


                                switch (alt45) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4647:2: otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) )
                            	    {
                            	    otherlv_71=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_71, grammarAccess.getAtomicExprAccess().getCommaKeyword_14_2_1_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4651:1: ( (lv_exprs_72_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:4652:1: (lv_exprs_72_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:4652:1: (lv_exprs_72_0= ruleExpr )
                            	    // InternalResoluteParser.g:4653:3: lv_exprs_72_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_14_2_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_47);
                            	    lv_exprs_72_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exprs",
                            	              		lv_exprs_72_0, 
                            	              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop45;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_73=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_73, grammarAccess.getAtomicExprAccess().getRightSquareBracketKeyword_14_3());
                          
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalResoluteParser.g:4675:6: (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:4675:6: (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket )
                    // InternalResoluteParser.g:4676:2: otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket
                    {
                    otherlv_74=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_74, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_15_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_15_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_48);
                    this_Expr_75=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Expr_75;
                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalResoluteParser.g:4689:1: ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==For) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==Comma||LA50_0==RightCurlyBracket) ) {
                        alt50=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 0, input);

                        throw nvae;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalResoluteParser.g:4689:2: ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? )
                            {
                            // InternalResoluteParser.g:4689:2: ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? )
                            // InternalResoluteParser.g:4689:3: () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )?
                            {
                            // InternalResoluteParser.g:4689:3: ()
                            // InternalResoluteParser.g:4690:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getAtomicExprAccess().getSetFilterMapExprMapAction_15_2_0_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_77=(Token)match(input,For,FollowSets000.FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_77, grammarAccess.getAtomicExprAccess().getForKeyword_15_2_0_1());
                                  
                            }
                            // InternalResoluteParser.g:4700:1: (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+
                            int cnt47=0;
                            loop47:
                            do {
                                int alt47=2;
                                int LA47_0 = input.LA(1);

                                if ( (LA47_0==LeftParenthesis) ) {
                                    alt47=1;
                                }


                                switch (alt47) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4701:2: otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis
                            	    {
                            	    otherlv_78=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_78, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_15_2_0_2_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4705:1: ( (lv_args_79_0= ruleArg ) )
                            	    // InternalResoluteParser.g:4706:1: (lv_args_79_0= ruleArg )
                            	    {
                            	    // InternalResoluteParser.g:4706:1: (lv_args_79_0= ruleArg )
                            	    // InternalResoluteParser.g:4707:3: lv_args_79_0= ruleArg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsArgParserRuleCall_15_2_0_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_38);
                            	    lv_args_79_0=ruleArg();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"args",
                            	              		lv_args_79_0, 
                            	              		"com.rockwellcollins.atc.resolute.Resolute.Arg");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }

                            	    otherlv_80=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_49); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_80, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_15_2_0_2_2());
                            	          
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt47 >= 1 ) break loop47;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(47, input);
                                        throw eee;
                                }
                                cnt47++;
                            } while (true);

                            // InternalResoluteParser.g:4728:3: (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )?
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( (LA48_0==VerticalLine) ) {
                                alt48=1;
                            }
                            switch (alt48) {
                                case 1 :
                                    // InternalResoluteParser.g:4729:2: otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) )
                                    {
                                    otherlv_81=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_16); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_81, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_15_2_0_3_0());
                                          
                                    }
                                    // InternalResoluteParser.g:4733:1: ( (lv_filter_82_0= ruleExpr ) )
                                    // InternalResoluteParser.g:4734:1: (lv_filter_82_0= ruleExpr )
                                    {
                                    // InternalResoluteParser.g:4734:1: (lv_filter_82_0= ruleExpr )
                                    // InternalResoluteParser.g:4735:3: lv_filter_82_0= ruleExpr
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getFilterExprParserRuleCall_15_2_0_3_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_10);
                                    lv_filter_82_0=ruleExpr();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"filter",
                                              		lv_filter_82_0, 
                                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalResoluteParser.g:4752:6: ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* )
                            {
                            // InternalResoluteParser.g:4752:6: ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* )
                            // InternalResoluteParser.g:4752:7: () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:4752:7: ()
                            // InternalResoluteParser.g:4753:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndAdd(
                                          grammarAccess.getAtomicExprAccess().getSetExprExprsAction_15_2_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalResoluteParser.g:4758:2: (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )*
                            loop49:
                            do {
                                int alt49=2;
                                int LA49_0 = input.LA(1);

                                if ( (LA49_0==Comma) ) {
                                    alt49=1;
                                }


                                switch (alt49) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4759:2: otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) )
                            	    {
                            	    otherlv_84=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_84, grammarAccess.getAtomicExprAccess().getCommaKeyword_15_2_1_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4763:1: ( (lv_exprs_85_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:4764:1: (lv_exprs_85_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:4764:1: (lv_exprs_85_0= ruleExpr )
                            	    // InternalResoluteParser.g:4765:3: lv_exprs_85_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_15_2_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_50);
                            	    lv_exprs_85_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"exprs",
                            	              		lv_exprs_85_0, 
                            	              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop49;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_86=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_86, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_15_3());
                          
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalResoluteParser.g:4787:6: ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:4787:6: ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket )
                    // InternalResoluteParser.g:4787:7: () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket
                    {
                    // InternalResoluteParser.g:4787:7: ()
                    // InternalResoluteParser.g:4788:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getListExprAction_16_0(),
                                  current);
                          
                    }

                    }

                    otherlv_88=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_88, grammarAccess.getAtomicExprAccess().getLeftSquareBracketKeyword_16_1());
                          
                    }
                    otherlv_89=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_89, grammarAccess.getAtomicExprAccess().getRightSquareBracketKeyword_16_2());
                          
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalResoluteParser.g:4804:6: ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:4804:6: ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket )
                    // InternalResoluteParser.g:4804:7: () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket
                    {
                    // InternalResoluteParser.g:4804:7: ()
                    // InternalResoluteParser.g:4805:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getSetExprAction_17_0(),
                                  current);
                          
                    }

                    }

                    otherlv_91=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_91, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_17_1());
                          
                    }
                    otherlv_92=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_92, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_17_2());
                          
                    }

                    }


                    }
                    break;
                case 19 :
                    // InternalResoluteParser.g:4821:6: ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4821:6: ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4821:7: () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4821:7: ()
                    // InternalResoluteParser.g:4822:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getLetExprAction_18_0(),
                                  current);
                          
                    }

                    }

                    otherlv_94=(Token)match(input,Let,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_94, grammarAccess.getAtomicExprAccess().getLetKeyword_18_1());
                          
                    }
                    // InternalResoluteParser.g:4832:1: ( (lv_binding_95_0= ruleLetBinding ) )
                    // InternalResoluteParser.g:4833:1: (lv_binding_95_0= ruleLetBinding )
                    {
                    // InternalResoluteParser.g:4833:1: (lv_binding_95_0= ruleLetBinding )
                    // InternalResoluteParser.g:4834:3: lv_binding_95_0= ruleLetBinding
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getBindingLetBindingParserRuleCall_18_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_26);
                    lv_binding_95_0=ruleLetBinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"binding",
                              		lv_binding_95_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.LetBinding");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_96=(Token)match(input,Semicolon,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_96, grammarAccess.getAtomicExprAccess().getSemicolonKeyword_18_3());
                          
                    }
                    // InternalResoluteParser.g:4855:1: ( (lv_expr_97_0= ruleExpr ) )
                    // InternalResoluteParser.g:4856:1: (lv_expr_97_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4856:1: (lv_expr_97_0= ruleExpr )
                    // InternalResoluteParser.g:4857:3: lv_expr_97_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getExprExprParserRuleCall_18_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_97_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_97_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 20 :
                    // InternalResoluteParser.g:4874:6: (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis )
                    {
                    // InternalResoluteParser.g:4874:6: (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis )
                    // InternalResoluteParser.g:4875:2: otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis
                    {
                    otherlv_98=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_98, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_19_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_19_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_38);
                    this_Expr_99=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Expr_99;
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_100=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_100, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_19_2());
                          
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalResoluteParser.g:4894:6: ( () otherlv_102= Undeveloped )
                    {
                    // InternalResoluteParser.g:4894:6: ( () otherlv_102= Undeveloped )
                    // InternalResoluteParser.g:4894:7: () otherlv_102= Undeveloped
                    {
                    // InternalResoluteParser.g:4894:7: ()
                    // InternalResoluteParser.g:4895:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getUndevelopedExprAction_20_0(),
                                  current);
                          
                    }

                    }

                    otherlv_102=(Token)match(input,Undeveloped,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_102, grammarAccess.getAtomicExprAccess().getUndevelopedKeyword_20_1());
                          
                    }

                    }


                    }
                    break;
                case 22 :
                    // InternalResoluteParser.g:4906:6: ( () otherlv_104= Evidence ( (lv_name_105_0= RULE_ID ) ) otherlv_106= Colon ( (lv_val_107_0= ruleStringTerm ) ) )
                    {
                    // InternalResoluteParser.g:4906:6: ( () otherlv_104= Evidence ( (lv_name_105_0= RULE_ID ) ) otherlv_106= Colon ( (lv_val_107_0= ruleStringTerm ) ) )
                    // InternalResoluteParser.g:4906:7: () otherlv_104= Evidence ( (lv_name_105_0= RULE_ID ) ) otherlv_106= Colon ( (lv_val_107_0= ruleStringTerm ) )
                    {
                    // InternalResoluteParser.g:4906:7: ()
                    // InternalResoluteParser.g:4907:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getEvidenceExprAction_21_0(),
                                  current);
                          
                    }

                    }

                    otherlv_104=(Token)match(input,Evidence,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_104, grammarAccess.getAtomicExprAccess().getEvidenceKeyword_21_1());
                          
                    }
                    // InternalResoluteParser.g:4917:1: ( (lv_name_105_0= RULE_ID ) )
                    // InternalResoluteParser.g:4918:1: (lv_name_105_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:4918:1: (lv_name_105_0= RULE_ID )
                    // InternalResoluteParser.g:4919:3: lv_name_105_0= RULE_ID
                    {
                    lv_name_105_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_105_0, grammarAccess.getAtomicExprAccess().getNameIDTerminalRuleCall_21_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_105_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }

                    otherlv_106=(Token)match(input,Colon,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_106, grammarAccess.getAtomicExprAccess().getColonKeyword_21_3());
                          
                    }
                    // InternalResoluteParser.g:4940:1: ( (lv_val_107_0= ruleStringTerm ) )
                    // InternalResoluteParser.g:4941:1: (lv_val_107_0= ruleStringTerm )
                    {
                    // InternalResoluteParser.g:4941:1: (lv_val_107_0= ruleStringTerm )
                    // InternalResoluteParser.g:4942:3: lv_val_107_0= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getValStringTermParserRuleCall_21_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_107_0=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_107_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.StringTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 23 :
                    // InternalResoluteParser.g:4959:6: ( () otherlv_109= Solution ( (lv_name_110_0= RULE_ID ) ) otherlv_111= Colon ( (lv_val_112_0= ruleStringTerm ) ) )
                    {
                    // InternalResoluteParser.g:4959:6: ( () otherlv_109= Solution ( (lv_name_110_0= RULE_ID ) ) otherlv_111= Colon ( (lv_val_112_0= ruleStringTerm ) ) )
                    // InternalResoluteParser.g:4959:7: () otherlv_109= Solution ( (lv_name_110_0= RULE_ID ) ) otherlv_111= Colon ( (lv_val_112_0= ruleStringTerm ) )
                    {
                    // InternalResoluteParser.g:4959:7: ()
                    // InternalResoluteParser.g:4960:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getSolutionExprAction_22_0(),
                                  current);
                          
                    }

                    }

                    otherlv_109=(Token)match(input,Solution,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_109, grammarAccess.getAtomicExprAccess().getSolutionKeyword_22_1());
                          
                    }
                    // InternalResoluteParser.g:4970:1: ( (lv_name_110_0= RULE_ID ) )
                    // InternalResoluteParser.g:4971:1: (lv_name_110_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:4971:1: (lv_name_110_0= RULE_ID )
                    // InternalResoluteParser.g:4972:3: lv_name_110_0= RULE_ID
                    {
                    lv_name_110_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_110_0, grammarAccess.getAtomicExprAccess().getNameIDTerminalRuleCall_22_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_110_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }

                    otherlv_111=(Token)match(input,Colon,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_111, grammarAccess.getAtomicExprAccess().getColonKeyword_22_3());
                          
                    }
                    // InternalResoluteParser.g:4993:1: ( (lv_val_112_0= ruleStringTerm ) )
                    // InternalResoluteParser.g:4994:1: (lv_val_112_0= ruleStringTerm )
                    {
                    // InternalResoluteParser.g:4994:1: (lv_val_112_0= ruleStringTerm )
                    // InternalResoluteParser.g:4995:3: lv_val_112_0= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getValStringTermParserRuleCall_22_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_112_0=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_112_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.StringTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExpr"


    // $ANTLR start "entryRuleLetBinding"
    // InternalResoluteParser.g:5019:1: entryRuleLetBinding returns [EObject current=null] : iv_ruleLetBinding= ruleLetBinding EOF ;
    public final EObject entryRuleLetBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetBinding = null;


        try {
            // InternalResoluteParser.g:5020:2: (iv_ruleLetBinding= ruleLetBinding EOF )
            // InternalResoluteParser.g:5021:2: iv_ruleLetBinding= ruleLetBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLetBinding=ruleLetBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetBinding"


    // $ANTLR start "ruleLetBinding"
    // InternalResoluteParser.g:5028:1: ruleLetBinding returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleLetBinding() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5031:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) )
            // InternalResoluteParser.g:5032:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // InternalResoluteParser.g:5032:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            // InternalResoluteParser.g:5032:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
            {
            // InternalResoluteParser.g:5032:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:5033:1: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:5033:1: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:5034:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getLetBindingAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLetBindingRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLetBindingAccess().getColonKeyword_1());
                  
            }
            // InternalResoluteParser.g:5055:1: ( (lv_type_2_0= ruleType ) )
            // InternalResoluteParser.g:5056:1: (lv_type_2_0= ruleType )
            {
            // InternalResoluteParser.g:5056:1: (lv_type_2_0= ruleType )
            // InternalResoluteParser.g:5057:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetBindingAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_17);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetBindingRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetBindingAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalResoluteParser.g:5078:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalResoluteParser.g:5079:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalResoluteParser.g:5079:1: (lv_expr_4_0= ruleExpr )
            // InternalResoluteParser.g:5080:3: lv_expr_4_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetBindingAccess().getExprExprParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_expr_4_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetBindingRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_4_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.Expr");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetBinding"


    // $ANTLR start "entryRuleResult"
    // InternalResoluteParser.g:5104:1: entryRuleResult returns [String current=null] : iv_ruleResult= ruleResult EOF ;
    public final String entryRuleResult() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleResult = null;


        try {
            // InternalResoluteParser.g:5105:1: (iv_ruleResult= ruleResult EOF )
            // InternalResoluteParser.g:5106:2: iv_ruleResult= ruleResult EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleResult=ruleResult();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResult.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResult"


    // $ANTLR start "ruleResult"
    // InternalResoluteParser.g:5113:1: ruleResult returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Passed | kw= Failed | kw= Indeterminate | kw= Revised_with_review | kw= Revised_without_review ) ;
    public final AntlrDatatypeRuleToken ruleResult() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5117:6: ( (kw= Passed | kw= Failed | kw= Indeterminate | kw= Revised_with_review | kw= Revised_without_review ) )
            // InternalResoluteParser.g:5118:1: (kw= Passed | kw= Failed | kw= Indeterminate | kw= Revised_with_review | kw= Revised_without_review )
            {
            // InternalResoluteParser.g:5118:1: (kw= Passed | kw= Failed | kw= Indeterminate | kw= Revised_with_review | kw= Revised_without_review )
            int alt52=5;
            switch ( input.LA(1) ) {
            case Passed:
                {
                alt52=1;
                }
                break;
            case Failed:
                {
                alt52=2;
                }
                break;
            case Indeterminate:
                {
                alt52=3;
                }
                break;
            case Revised_with_review:
                {
                alt52=4;
                }
                break;
            case Revised_without_review:
                {
                alt52=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalResoluteParser.g:5119:2: kw= Passed
                    {
                    kw=(Token)match(input,Passed,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getPassedKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:5126:2: kw= Failed
                    {
                    kw=(Token)match(input,Failed,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getFailedKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:5133:2: kw= Indeterminate
                    {
                    kw=(Token)match(input,Indeterminate,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getIndeterminateKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:5140:2: kw= Revised_with_review
                    {
                    kw=(Token)match(input,Revised_with_review,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getRevised_with_reviewKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:5147:2: kw= Revised_without_review
                    {
                    kw=(Token)match(input,Revised_without_review,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getRevised_without_reviewKeyword_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResult"


    // $ANTLR start "entryRuleBuiltInFn"
    // InternalResoluteParser.g:5160:1: entryRuleBuiltInFn returns [String current=null] : iv_ruleBuiltInFn= ruleBuiltInFn EOF ;
    public final String entryRuleBuiltInFn() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBuiltInFn = null;


        try {
            // InternalResoluteParser.g:5161:1: (iv_ruleBuiltInFn= ruleBuiltInFn EOF )
            // InternalResoluteParser.g:5162:2: iv_ruleBuiltInFn= ruleBuiltInFn EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBuiltInFnRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBuiltInFn=ruleBuiltInFn();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBuiltInFn.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBuiltInFn"


    // $ANTLR start "ruleBuiltInFn"
    // InternalResoluteParser.g:5169:1: ruleBuiltInFn returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows | kw= Result_of | kw= Metric | kw= Analyzes | kw= Produced_by | kw= Performed_by | kw= From_report | kw= Description | kw= Annotation_type | kw= Definition | kw= Source_of | kw= Identified | kw= Author | kw= Text | kw= Given_text | kw= If_text | kw= Then_text | kw= Governs | kw= Satisfies | kw= Mitigates | kw= Created_by | kw= Provided_by | kw= Consumed_by | kw= Referenced | kw= Governed_by | kw= Reviews | kw= Review_result | kw= Reviewer | kw= Reviewed | kw= Filename | kw= Step | kw= Compiled_by | kw= Compile_input | kw= Packaged_by | kw= Package_input | kw= Type_of | kw= Value_type | kw= Instantiates | kw= Defined_in | kw= Mentions | kw= Subcomponent_of | kw= Requirements | kw= Annotations | kw= Control_flows_to_unconditionally | kw= Control_flows_to_conditionally | kw= Part_of | kw= Provides | kw= Requires | kw= Destination_of | kw= Identified_by | kw= Developed_by | kw= Verifies | kw= Confirms | kw= Executed_by | kw= Executed_on ) ;
    public final AntlrDatatypeRuleToken ruleBuiltInFn() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5173:6: ( (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows | kw= Result_of | kw= Metric | kw= Analyzes | kw= Produced_by | kw= Performed_by | kw= From_report | kw= Description | kw= Annotation_type | kw= Definition | kw= Source_of | kw= Identified | kw= Author | kw= Text | kw= Given_text | kw= If_text | kw= Then_text | kw= Governs | kw= Satisfies | kw= Mitigates | kw= Created_by | kw= Provided_by | kw= Consumed_by | kw= Referenced | kw= Governed_by | kw= Reviews | kw= Review_result | kw= Reviewer | kw= Reviewed | kw= Filename | kw= Step | kw= Compiled_by | kw= Compile_input | kw= Packaged_by | kw= Package_input | kw= Type_of | kw= Value_type | kw= Instantiates | kw= Defined_in | kw= Mentions | kw= Subcomponent_of | kw= Requirements | kw= Annotations | kw= Control_flows_to_unconditionally | kw= Control_flows_to_conditionally | kw= Part_of | kw= Provides | kw= Requires | kw= Destination_of | kw= Identified_by | kw= Developed_by | kw= Verifies | kw= Confirms | kw= Executed_by | kw= Executed_on ) )
            // InternalResoluteParser.g:5174:1: (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows | kw= Result_of | kw= Metric | kw= Analyzes | kw= Produced_by | kw= Performed_by | kw= From_report | kw= Description | kw= Annotation_type | kw= Definition | kw= Source_of | kw= Identified | kw= Author | kw= Text | kw= Given_text | kw= If_text | kw= Then_text | kw= Governs | kw= Satisfies | kw= Mitigates | kw= Created_by | kw= Provided_by | kw= Consumed_by | kw= Referenced | kw= Governed_by | kw= Reviews | kw= Review_result | kw= Reviewer | kw= Reviewed | kw= Filename | kw= Step | kw= Compiled_by | kw= Compile_input | kw= Packaged_by | kw= Package_input | kw= Type_of | kw= Value_type | kw= Instantiates | kw= Defined_in | kw= Mentions | kw= Subcomponent_of | kw= Requirements | kw= Annotations | kw= Control_flows_to_unconditionally | kw= Control_flows_to_conditionally | kw= Part_of | kw= Provides | kw= Requires | kw= Destination_of | kw= Identified_by | kw= Developed_by | kw= Verifies | kw= Confirms | kw= Executed_by | kw= Executed_on )
            {
            // InternalResoluteParser.g:5174:1: (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows | kw= Result_of | kw= Metric | kw= Analyzes | kw= Produced_by | kw= Performed_by | kw= From_report | kw= Description | kw= Annotation_type | kw= Definition | kw= Source_of | kw= Identified | kw= Author | kw= Text | kw= Given_text | kw= If_text | kw= Then_text | kw= Governs | kw= Satisfies | kw= Mitigates | kw= Created_by | kw= Provided_by | kw= Consumed_by | kw= Referenced | kw= Governed_by | kw= Reviews | kw= Review_result | kw= Reviewer | kw= Reviewed | kw= Filename | kw= Step | kw= Compiled_by | kw= Compile_input | kw= Packaged_by | kw= Package_input | kw= Type_of | kw= Value_type | kw= Instantiates | kw= Defined_in | kw= Mentions | kw= Subcomponent_of | kw= Requirements | kw= Annotations | kw= Control_flows_to_unconditionally | kw= Control_flows_to_conditionally | kw= Part_of | kw= Provides | kw= Requires | kw= Destination_of | kw= Identified_by | kw= Developed_by | kw= Verifies | kw= Confirms | kw= Executed_by | kw= Executed_on )
            int alt53=120;
            switch ( input.LA(1) ) {
            case Has_property:
                {
                alt53=1;
                }
                break;
            case Property:
                {
                alt53=2;
                }
                break;
            case Property_member:
                {
                alt53=3;
                }
                break;
            case Has_parent:
                {
                alt53=4;
                }
                break;
            case Parent:
                {
                alt53=5;
                }
                break;
            case Name:
                {
                alt53=6;
                }
                break;
            case Type:
                {
                alt53=7;
                }
                break;
            case Has_type:
                {
                alt53=8;
                }
                break;
            case Is_in_array:
                {
                alt53=9;
                }
                break;
            case Has_prototypes:
                {
                alt53=10;
                }
                break;
            case Has_modes:
                {
                alt53=11;
                }
                break;
            case Is_processor:
                {
                alt53=12;
                }
                break;
            case Is_virtual_processor:
                {
                alt53=13;
                }
                break;
            case Is_system:
                {
                alt53=14;
                }
                break;
            case Is_bus:
                {
                alt53=15;
                }
                break;
            case Is_virtual_bus:
                {
                alt53=16;
                }
                break;
            case Is_device:
                {
                alt53=17;
                }
                break;
            case Is_memory:
                {
                alt53=18;
                }
                break;
            case Is_thread:
                {
                alt53=19;
                }
                break;
            case Is_thread_group:
                {
                alt53=20;
                }
                break;
            case Is_process:
                {
                alt53=21;
                }
                break;
            case Is_data:
                {
                alt53=22;
                }
                break;
            case Is_subprogram:
                {
                alt53=23;
                }
                break;
            case Is_of_type:
                {
                alt53=24;
                }
                break;
            case Is_bound_to:
                {
                alt53=25;
                }
                break;
            case Has_member:
                {
                alt53=26;
                }
                break;
            case Features:
                {
                alt53=27;
                }
                break;
            case Connections:
                {
                alt53=28;
                }
                break;
            case Enumerated_values:
                {
                alt53=29;
                }
                break;
            case Subcomponents:
                {
                alt53=30;
                }
                break;
            case Source:
                {
                alt53=31;
                }
                break;
            case Destination:
                {
                alt53=32;
                }
                break;
            case Is_bidirectional:
                {
                alt53=33;
                }
                break;
            case Direction:
                {
                alt53=34;
                }
                break;
            case Is_event_port:
                {
                alt53=35;
                }
                break;
            case Is_abstract_feature:
                {
                alt53=36;
                }
                break;
            case Is_data_port:
                {
                alt53=37;
                }
                break;
            case Is_port:
                {
                alt53=38;
                }
                break;
            case Is_data_access:
                {
                alt53=39;
                }
                break;
            case Is_bus_access:
                {
                alt53=40;
                }
                break;
            case Lower_bound:
                {
                alt53=41;
                }
                break;
            case Upper_bound:
                {
                alt53=42;
                }
                break;
            case Member:
                {
                alt53=43;
                }
                break;
            case Length:
                {
                alt53=44;
                }
                break;
            case Size:
                {
                alt53=45;
                }
                break;
            case Sum:
                {
                alt53=46;
                }
                break;
            case Append:
                {
                alt53=47;
                }
                break;
            case Head:
                {
                alt53=48;
                }
                break;
            case Tail:
                {
                alt53=49;
                }
                break;
            case As_set:
                {
                alt53=50;
                }
                break;
            case Union:
                {
                alt53=51;
                }
                break;
            case Intersect:
                {
                alt53=52;
                }
                break;
            case As_list:
                {
                alt53=53;
                }
                break;
            case Instance:
                {
                alt53=54;
                }
                break;
            case Instances:
                {
                alt53=55;
                }
                break;
            case Debug:
                {
                alt53=56;
                }
                break;
            case Analysis:
                {
                alt53=57;
                }
                break;
            case Receive_error:
                {
                alt53=58;
                }
                break;
            case Contain_error:
                {
                alt53=59;
                }
                break;
            case Propagate_error:
                {
                alt53=60;
                }
                break;
            case Error_state_reachable:
                {
                alt53=61;
                }
                break;
            case Flow_source:
                {
                alt53=62;
                }
                break;
            case Flow_destination:
                {
                alt53=63;
                }
                break;
            case Flow_elements:
                {
                alt53=64;
                }
                break;
            case Flow_specifications:
                {
                alt53=65;
                }
                break;
            case End_to_end_flows:
                {
                alt53=66;
                }
                break;
            case Result_of:
                {
                alt53=67;
                }
                break;
            case Metric:
                {
                alt53=68;
                }
                break;
            case Analyzes:
                {
                alt53=69;
                }
                break;
            case Produced_by:
                {
                alt53=70;
                }
                break;
            case Performed_by:
                {
                alt53=71;
                }
                break;
            case From_report:
                {
                alt53=72;
                }
                break;
            case Description:
                {
                alt53=73;
                }
                break;
            case Annotation_type:
                {
                alt53=74;
                }
                break;
            case Definition:
                {
                alt53=75;
                }
                break;
            case Source_of:
                {
                alt53=76;
                }
                break;
            case Identified:
                {
                alt53=77;
                }
                break;
            case Author:
                {
                alt53=78;
                }
                break;
            case Text:
                {
                alt53=79;
                }
                break;
            case Given_text:
                {
                alt53=80;
                }
                break;
            case If_text:
                {
                alt53=81;
                }
                break;
            case Then_text:
                {
                alt53=82;
                }
                break;
            case Governs:
                {
                alt53=83;
                }
                break;
            case Satisfies:
                {
                alt53=84;
                }
                break;
            case Mitigates:
                {
                alt53=85;
                }
                break;
            case Created_by:
                {
                alt53=86;
                }
                break;
            case Provided_by:
                {
                alt53=87;
                }
                break;
            case Consumed_by:
                {
                alt53=88;
                }
                break;
            case Referenced:
                {
                alt53=89;
                }
                break;
            case Governed_by:
                {
                alt53=90;
                }
                break;
            case Reviews:
                {
                alt53=91;
                }
                break;
            case Review_result:
                {
                alt53=92;
                }
                break;
            case Reviewer:
                {
                alt53=93;
                }
                break;
            case Reviewed:
                {
                alt53=94;
                }
                break;
            case Filename:
                {
                alt53=95;
                }
                break;
            case Step:
                {
                alt53=96;
                }
                break;
            case Compiled_by:
                {
                alt53=97;
                }
                break;
            case Compile_input:
                {
                alt53=98;
                }
                break;
            case Packaged_by:
                {
                alt53=99;
                }
                break;
            case Package_input:
                {
                alt53=100;
                }
                break;
            case Type_of:
                {
                alt53=101;
                }
                break;
            case Value_type:
                {
                alt53=102;
                }
                break;
            case Instantiates:
                {
                alt53=103;
                }
                break;
            case Defined_in:
                {
                alt53=104;
                }
                break;
            case Mentions:
                {
                alt53=105;
                }
                break;
            case Subcomponent_of:
                {
                alt53=106;
                }
                break;
            case Requirements:
                {
                alt53=107;
                }
                break;
            case Annotations:
                {
                alt53=108;
                }
                break;
            case Control_flows_to_unconditionally:
                {
                alt53=109;
                }
                break;
            case Control_flows_to_conditionally:
                {
                alt53=110;
                }
                break;
            case Part_of:
                {
                alt53=111;
                }
                break;
            case Provides:
                {
                alt53=112;
                }
                break;
            case Requires:
                {
                alt53=113;
                }
                break;
            case Destination_of:
                {
                alt53=114;
                }
                break;
            case Identified_by:
                {
                alt53=115;
                }
                break;
            case Developed_by:
                {
                alt53=116;
                }
                break;
            case Verifies:
                {
                alt53=117;
                }
                break;
            case Confirms:
                {
                alt53=118;
                }
                break;
            case Executed_by:
                {
                alt53=119;
                }
                break;
            case Executed_on:
                {
                alt53=120;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalResoluteParser.g:5175:2: kw= Has_property
                    {
                    kw=(Token)match(input,Has_property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_propertyKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:5182:2: kw= Property
                    {
                    kw=(Token)match(input,Property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPropertyKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:5189:2: kw= Property_member
                    {
                    kw=(Token)match(input,Property_member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getProperty_memberKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:5196:2: kw= Has_parent
                    {
                    kw=(Token)match(input,Has_parent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_parentKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:5203:2: kw= Parent
                    {
                    kw=(Token)match(input,Parent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getParentKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:5210:2: kw= Name
                    {
                    kw=(Token)match(input,Name,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getNameKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:5217:2: kw= Type
                    {
                    kw=(Token)match(input,Type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTypeKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalResoluteParser.g:5224:2: kw= Has_type
                    {
                    kw=(Token)match(input,Has_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_typeKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalResoluteParser.g:5231:2: kw= Is_in_array
                    {
                    kw=(Token)match(input,Is_in_array,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_in_arrayKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalResoluteParser.g:5238:2: kw= Has_prototypes
                    {
                    kw=(Token)match(input,Has_prototypes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_prototypesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalResoluteParser.g:5245:2: kw= Has_modes
                    {
                    kw=(Token)match(input,Has_modes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_modesKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalResoluteParser.g:5252:2: kw= Is_processor
                    {
                    kw=(Token)match(input,Is_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_processorKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalResoluteParser.g:5259:2: kw= Is_virtual_processor
                    {
                    kw=(Token)match(input,Is_virtual_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_virtual_processorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalResoluteParser.g:5266:2: kw= Is_system
                    {
                    kw=(Token)match(input,Is_system,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_systemKeyword_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // InternalResoluteParser.g:5273:2: kw= Is_bus
                    {
                    kw=(Token)match(input,Is_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_busKeyword_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // InternalResoluteParser.g:5280:2: kw= Is_virtual_bus
                    {
                    kw=(Token)match(input,Is_virtual_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_virtual_busKeyword_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // InternalResoluteParser.g:5287:2: kw= Is_device
                    {
                    kw=(Token)match(input,Is_device,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_deviceKeyword_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // InternalResoluteParser.g:5294:2: kw= Is_memory
                    {
                    kw=(Token)match(input,Is_memory,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_memoryKeyword_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // InternalResoluteParser.g:5301:2: kw= Is_thread
                    {
                    kw=(Token)match(input,Is_thread,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_threadKeyword_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // InternalResoluteParser.g:5308:2: kw= Is_thread_group
                    {
                    kw=(Token)match(input,Is_thread_group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_thread_groupKeyword_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // InternalResoluteParser.g:5315:2: kw= Is_process
                    {
                    kw=(Token)match(input,Is_process,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_processKeyword_20()); 
                          
                    }

                    }
                    break;
                case 22 :
                    // InternalResoluteParser.g:5322:2: kw= Is_data
                    {
                    kw=(Token)match(input,Is_data,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_dataKeyword_21()); 
                          
                    }

                    }
                    break;
                case 23 :
                    // InternalResoluteParser.g:5329:2: kw= Is_subprogram
                    {
                    kw=(Token)match(input,Is_subprogram,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_subprogramKeyword_22()); 
                          
                    }

                    }
                    break;
                case 24 :
                    // InternalResoluteParser.g:5336:2: kw= Is_of_type
                    {
                    kw=(Token)match(input,Is_of_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_of_typeKeyword_23()); 
                          
                    }

                    }
                    break;
                case 25 :
                    // InternalResoluteParser.g:5343:2: kw= Is_bound_to
                    {
                    kw=(Token)match(input,Is_bound_to,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bound_toKeyword_24()); 
                          
                    }

                    }
                    break;
                case 26 :
                    // InternalResoluteParser.g:5350:2: kw= Has_member
                    {
                    kw=(Token)match(input,Has_member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_memberKeyword_25()); 
                          
                    }

                    }
                    break;
                case 27 :
                    // InternalResoluteParser.g:5357:2: kw= Features
                    {
                    kw=(Token)match(input,Features,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFeaturesKeyword_26()); 
                          
                    }

                    }
                    break;
                case 28 :
                    // InternalResoluteParser.g:5364:2: kw= Connections
                    {
                    kw=(Token)match(input,Connections,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getConnectionsKeyword_27()); 
                          
                    }

                    }
                    break;
                case 29 :
                    // InternalResoluteParser.g:5371:2: kw= Enumerated_values
                    {
                    kw=(Token)match(input,Enumerated_values,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getEnumerated_valuesKeyword_28()); 
                          
                    }

                    }
                    break;
                case 30 :
                    // InternalResoluteParser.g:5378:2: kw= Subcomponents
                    {
                    kw=(Token)match(input,Subcomponents,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSubcomponentsKeyword_29()); 
                          
                    }

                    }
                    break;
                case 31 :
                    // InternalResoluteParser.g:5385:2: kw= Source
                    {
                    kw=(Token)match(input,Source,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSourceKeyword_30()); 
                          
                    }

                    }
                    break;
                case 32 :
                    // InternalResoluteParser.g:5392:2: kw= Destination
                    {
                    kw=(Token)match(input,Destination,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDestinationKeyword_31()); 
                          
                    }

                    }
                    break;
                case 33 :
                    // InternalResoluteParser.g:5399:2: kw= Is_bidirectional
                    {
                    kw=(Token)match(input,Is_bidirectional,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bidirectionalKeyword_32()); 
                          
                    }

                    }
                    break;
                case 34 :
                    // InternalResoluteParser.g:5406:2: kw= Direction
                    {
                    kw=(Token)match(input,Direction,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDirectionKeyword_33()); 
                          
                    }

                    }
                    break;
                case 35 :
                    // InternalResoluteParser.g:5413:2: kw= Is_event_port
                    {
                    kw=(Token)match(input,Is_event_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_event_portKeyword_34()); 
                          
                    }

                    }
                    break;
                case 36 :
                    // InternalResoluteParser.g:5420:2: kw= Is_abstract_feature
                    {
                    kw=(Token)match(input,Is_abstract_feature,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_abstract_featureKeyword_35()); 
                          
                    }

                    }
                    break;
                case 37 :
                    // InternalResoluteParser.g:5427:2: kw= Is_data_port
                    {
                    kw=(Token)match(input,Is_data_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_data_portKeyword_36()); 
                          
                    }

                    }
                    break;
                case 38 :
                    // InternalResoluteParser.g:5434:2: kw= Is_port
                    {
                    kw=(Token)match(input,Is_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_portKeyword_37()); 
                          
                    }

                    }
                    break;
                case 39 :
                    // InternalResoluteParser.g:5441:2: kw= Is_data_access
                    {
                    kw=(Token)match(input,Is_data_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_data_accessKeyword_38()); 
                          
                    }

                    }
                    break;
                case 40 :
                    // InternalResoluteParser.g:5448:2: kw= Is_bus_access
                    {
                    kw=(Token)match(input,Is_bus_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bus_accessKeyword_39()); 
                          
                    }

                    }
                    break;
                case 41 :
                    // InternalResoluteParser.g:5455:2: kw= Lower_bound
                    {
                    kw=(Token)match(input,Lower_bound,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getLower_boundKeyword_40()); 
                          
                    }

                    }
                    break;
                case 42 :
                    // InternalResoluteParser.g:5462:2: kw= Upper_bound
                    {
                    kw=(Token)match(input,Upper_bound,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getUpper_boundKeyword_41()); 
                          
                    }

                    }
                    break;
                case 43 :
                    // InternalResoluteParser.g:5469:2: kw= Member
                    {
                    kw=(Token)match(input,Member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMemberKeyword_42()); 
                          
                    }

                    }
                    break;
                case 44 :
                    // InternalResoluteParser.g:5476:2: kw= Length
                    {
                    kw=(Token)match(input,Length,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getLengthKeyword_43()); 
                          
                    }

                    }
                    break;
                case 45 :
                    // InternalResoluteParser.g:5483:2: kw= Size
                    {
                    kw=(Token)match(input,Size,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSizeKeyword_44()); 
                          
                    }

                    }
                    break;
                case 46 :
                    // InternalResoluteParser.g:5490:2: kw= Sum
                    {
                    kw=(Token)match(input,Sum,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSumKeyword_45()); 
                          
                    }

                    }
                    break;
                case 47 :
                    // InternalResoluteParser.g:5497:2: kw= Append
                    {
                    kw=(Token)match(input,Append,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAppendKeyword_46()); 
                          
                    }

                    }
                    break;
                case 48 :
                    // InternalResoluteParser.g:5504:2: kw= Head
                    {
                    kw=(Token)match(input,Head,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHeadKeyword_47()); 
                          
                    }

                    }
                    break;
                case 49 :
                    // InternalResoluteParser.g:5511:2: kw= Tail
                    {
                    kw=(Token)match(input,Tail,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTailKeyword_48()); 
                          
                    }

                    }
                    break;
                case 50 :
                    // InternalResoluteParser.g:5518:2: kw= As_set
                    {
                    kw=(Token)match(input,As_set,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAs_setKeyword_49()); 
                          
                    }

                    }
                    break;
                case 51 :
                    // InternalResoluteParser.g:5525:2: kw= Union
                    {
                    kw=(Token)match(input,Union,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getUnionKeyword_50()); 
                          
                    }

                    }
                    break;
                case 52 :
                    // InternalResoluteParser.g:5532:2: kw= Intersect
                    {
                    kw=(Token)match(input,Intersect,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIntersectKeyword_51()); 
                          
                    }

                    }
                    break;
                case 53 :
                    // InternalResoluteParser.g:5539:2: kw= As_list
                    {
                    kw=(Token)match(input,As_list,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAs_listKeyword_52()); 
                          
                    }

                    }
                    break;
                case 54 :
                    // InternalResoluteParser.g:5546:2: kw= Instance
                    {
                    kw=(Token)match(input,Instance,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstanceKeyword_53()); 
                          
                    }

                    }
                    break;
                case 55 :
                    // InternalResoluteParser.g:5553:2: kw= Instances
                    {
                    kw=(Token)match(input,Instances,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstancesKeyword_54()); 
                          
                    }

                    }
                    break;
                case 56 :
                    // InternalResoluteParser.g:5560:2: kw= Debug
                    {
                    kw=(Token)match(input,Debug,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDebugKeyword_55()); 
                          
                    }

                    }
                    break;
                case 57 :
                    // InternalResoluteParser.g:5567:2: kw= Analysis
                    {
                    kw=(Token)match(input,Analysis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAnalysisKeyword_56()); 
                          
                    }

                    }
                    break;
                case 58 :
                    // InternalResoluteParser.g:5574:2: kw= Receive_error
                    {
                    kw=(Token)match(input,Receive_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReceive_errorKeyword_57()); 
                          
                    }

                    }
                    break;
                case 59 :
                    // InternalResoluteParser.g:5581:2: kw= Contain_error
                    {
                    kw=(Token)match(input,Contain_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getContain_errorKeyword_58()); 
                          
                    }

                    }
                    break;
                case 60 :
                    // InternalResoluteParser.g:5588:2: kw= Propagate_error
                    {
                    kw=(Token)match(input,Propagate_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPropagate_errorKeyword_59()); 
                          
                    }

                    }
                    break;
                case 61 :
                    // InternalResoluteParser.g:5595:2: kw= Error_state_reachable
                    {
                    kw=(Token)match(input,Error_state_reachable,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getError_state_reachableKeyword_60()); 
                          
                    }

                    }
                    break;
                case 62 :
                    // InternalResoluteParser.g:5602:2: kw= Flow_source
                    {
                    kw=(Token)match(input,Flow_source,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_sourceKeyword_61()); 
                          
                    }

                    }
                    break;
                case 63 :
                    // InternalResoluteParser.g:5609:2: kw= Flow_destination
                    {
                    kw=(Token)match(input,Flow_destination,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_destinationKeyword_62()); 
                          
                    }

                    }
                    break;
                case 64 :
                    // InternalResoluteParser.g:5616:2: kw= Flow_elements
                    {
                    kw=(Token)match(input,Flow_elements,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_elementsKeyword_63()); 
                          
                    }

                    }
                    break;
                case 65 :
                    // InternalResoluteParser.g:5623:2: kw= Flow_specifications
                    {
                    kw=(Token)match(input,Flow_specifications,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_specificationsKeyword_64()); 
                          
                    }

                    }
                    break;
                case 66 :
                    // InternalResoluteParser.g:5630:2: kw= End_to_end_flows
                    {
                    kw=(Token)match(input,End_to_end_flows,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getEnd_to_end_flowsKeyword_65()); 
                          
                    }

                    }
                    break;
                case 67 :
                    // InternalResoluteParser.g:5637:2: kw= Result_of
                    {
                    kw=(Token)match(input,Result_of,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getResult_ofKeyword_66()); 
                          
                    }

                    }
                    break;
                case 68 :
                    // InternalResoluteParser.g:5644:2: kw= Metric
                    {
                    kw=(Token)match(input,Metric,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMetricKeyword_67()); 
                          
                    }

                    }
                    break;
                case 69 :
                    // InternalResoluteParser.g:5651:2: kw= Analyzes
                    {
                    kw=(Token)match(input,Analyzes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAnalyzesKeyword_68()); 
                          
                    }

                    }
                    break;
                case 70 :
                    // InternalResoluteParser.g:5658:2: kw= Produced_by
                    {
                    kw=(Token)match(input,Produced_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getProduced_byKeyword_69()); 
                          
                    }

                    }
                    break;
                case 71 :
                    // InternalResoluteParser.g:5665:2: kw= Performed_by
                    {
                    kw=(Token)match(input,Performed_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPerformed_byKeyword_70()); 
                          
                    }

                    }
                    break;
                case 72 :
                    // InternalResoluteParser.g:5672:2: kw= From_report
                    {
                    kw=(Token)match(input,From_report,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFrom_reportKeyword_71()); 
                          
                    }

                    }
                    break;
                case 73 :
                    // InternalResoluteParser.g:5679:2: kw= Description
                    {
                    kw=(Token)match(input,Description,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDescriptionKeyword_72()); 
                          
                    }

                    }
                    break;
                case 74 :
                    // InternalResoluteParser.g:5686:2: kw= Annotation_type
                    {
                    kw=(Token)match(input,Annotation_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAnnotation_typeKeyword_73()); 
                          
                    }

                    }
                    break;
                case 75 :
                    // InternalResoluteParser.g:5693:2: kw= Definition
                    {
                    kw=(Token)match(input,Definition,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDefinitionKeyword_74()); 
                          
                    }

                    }
                    break;
                case 76 :
                    // InternalResoluteParser.g:5700:2: kw= Source_of
                    {
                    kw=(Token)match(input,Source_of,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSource_ofKeyword_75()); 
                          
                    }

                    }
                    break;
                case 77 :
                    // InternalResoluteParser.g:5707:2: kw= Identified
                    {
                    kw=(Token)match(input,Identified,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIdentifiedKeyword_76()); 
                          
                    }

                    }
                    break;
                case 78 :
                    // InternalResoluteParser.g:5714:2: kw= Author
                    {
                    kw=(Token)match(input,Author,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAuthorKeyword_77()); 
                          
                    }

                    }
                    break;
                case 79 :
                    // InternalResoluteParser.g:5721:2: kw= Text
                    {
                    kw=(Token)match(input,Text,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTextKeyword_78()); 
                          
                    }

                    }
                    break;
                case 80 :
                    // InternalResoluteParser.g:5728:2: kw= Given_text
                    {
                    kw=(Token)match(input,Given_text,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getGiven_textKeyword_79()); 
                          
                    }

                    }
                    break;
                case 81 :
                    // InternalResoluteParser.g:5735:2: kw= If_text
                    {
                    kw=(Token)match(input,If_text,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIf_textKeyword_80()); 
                          
                    }

                    }
                    break;
                case 82 :
                    // InternalResoluteParser.g:5742:2: kw= Then_text
                    {
                    kw=(Token)match(input,Then_text,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getThen_textKeyword_81()); 
                          
                    }

                    }
                    break;
                case 83 :
                    // InternalResoluteParser.g:5749:2: kw= Governs
                    {
                    kw=(Token)match(input,Governs,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getGovernsKeyword_82()); 
                          
                    }

                    }
                    break;
                case 84 :
                    // InternalResoluteParser.g:5756:2: kw= Satisfies
                    {
                    kw=(Token)match(input,Satisfies,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSatisfiesKeyword_83()); 
                          
                    }

                    }
                    break;
                case 85 :
                    // InternalResoluteParser.g:5763:2: kw= Mitigates
                    {
                    kw=(Token)match(input,Mitigates,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMitigatesKeyword_84()); 
                          
                    }

                    }
                    break;
                case 86 :
                    // InternalResoluteParser.g:5770:2: kw= Created_by
                    {
                    kw=(Token)match(input,Created_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getCreated_byKeyword_85()); 
                          
                    }

                    }
                    break;
                case 87 :
                    // InternalResoluteParser.g:5777:2: kw= Provided_by
                    {
                    kw=(Token)match(input,Provided_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getProvided_byKeyword_86()); 
                          
                    }

                    }
                    break;
                case 88 :
                    // InternalResoluteParser.g:5784:2: kw= Consumed_by
                    {
                    kw=(Token)match(input,Consumed_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getConsumed_byKeyword_87()); 
                          
                    }

                    }
                    break;
                case 89 :
                    // InternalResoluteParser.g:5791:2: kw= Referenced
                    {
                    kw=(Token)match(input,Referenced,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReferencedKeyword_88()); 
                          
                    }

                    }
                    break;
                case 90 :
                    // InternalResoluteParser.g:5798:2: kw= Governed_by
                    {
                    kw=(Token)match(input,Governed_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getGoverned_byKeyword_89()); 
                          
                    }

                    }
                    break;
                case 91 :
                    // InternalResoluteParser.g:5805:2: kw= Reviews
                    {
                    kw=(Token)match(input,Reviews,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReviewsKeyword_90()); 
                          
                    }

                    }
                    break;
                case 92 :
                    // InternalResoluteParser.g:5812:2: kw= Review_result
                    {
                    kw=(Token)match(input,Review_result,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReview_resultKeyword_91()); 
                          
                    }

                    }
                    break;
                case 93 :
                    // InternalResoluteParser.g:5819:2: kw= Reviewer
                    {
                    kw=(Token)match(input,Reviewer,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReviewerKeyword_92()); 
                          
                    }

                    }
                    break;
                case 94 :
                    // InternalResoluteParser.g:5826:2: kw= Reviewed
                    {
                    kw=(Token)match(input,Reviewed,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReviewedKeyword_93()); 
                          
                    }

                    }
                    break;
                case 95 :
                    // InternalResoluteParser.g:5833:2: kw= Filename
                    {
                    kw=(Token)match(input,Filename,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFilenameKeyword_94()); 
                          
                    }

                    }
                    break;
                case 96 :
                    // InternalResoluteParser.g:5840:2: kw= Step
                    {
                    kw=(Token)match(input,Step,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getStepKeyword_95()); 
                          
                    }

                    }
                    break;
                case 97 :
                    // InternalResoluteParser.g:5847:2: kw= Compiled_by
                    {
                    kw=(Token)match(input,Compiled_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getCompiled_byKeyword_96()); 
                          
                    }

                    }
                    break;
                case 98 :
                    // InternalResoluteParser.g:5854:2: kw= Compile_input
                    {
                    kw=(Token)match(input,Compile_input,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getCompile_inputKeyword_97()); 
                          
                    }

                    }
                    break;
                case 99 :
                    // InternalResoluteParser.g:5861:2: kw= Packaged_by
                    {
                    kw=(Token)match(input,Packaged_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPackaged_byKeyword_98()); 
                          
                    }

                    }
                    break;
                case 100 :
                    // InternalResoluteParser.g:5868:2: kw= Package_input
                    {
                    kw=(Token)match(input,Package_input,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPackage_inputKeyword_99()); 
                          
                    }

                    }
                    break;
                case 101 :
                    // InternalResoluteParser.g:5875:2: kw= Type_of
                    {
                    kw=(Token)match(input,Type_of,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getType_ofKeyword_100()); 
                          
                    }

                    }
                    break;
                case 102 :
                    // InternalResoluteParser.g:5882:2: kw= Value_type
                    {
                    kw=(Token)match(input,Value_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getValue_typeKeyword_101()); 
                          
                    }

                    }
                    break;
                case 103 :
                    // InternalResoluteParser.g:5889:2: kw= Instantiates
                    {
                    kw=(Token)match(input,Instantiates,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstantiatesKeyword_102()); 
                          
                    }

                    }
                    break;
                case 104 :
                    // InternalResoluteParser.g:5896:2: kw= Defined_in
                    {
                    kw=(Token)match(input,Defined_in,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDefined_inKeyword_103()); 
                          
                    }

                    }
                    break;
                case 105 :
                    // InternalResoluteParser.g:5903:2: kw= Mentions
                    {
                    kw=(Token)match(input,Mentions,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMentionsKeyword_104()); 
                          
                    }

                    }
                    break;
                case 106 :
                    // InternalResoluteParser.g:5910:2: kw= Subcomponent_of
                    {
                    kw=(Token)match(input,Subcomponent_of,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSubcomponent_ofKeyword_105()); 
                          
                    }

                    }
                    break;
                case 107 :
                    // InternalResoluteParser.g:5917:2: kw= Requirements
                    {
                    kw=(Token)match(input,Requirements,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getRequirementsKeyword_106()); 
                          
                    }

                    }
                    break;
                case 108 :
                    // InternalResoluteParser.g:5924:2: kw= Annotations
                    {
                    kw=(Token)match(input,Annotations,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAnnotationsKeyword_107()); 
                          
                    }

                    }
                    break;
                case 109 :
                    // InternalResoluteParser.g:5931:2: kw= Control_flows_to_unconditionally
                    {
                    kw=(Token)match(input,Control_flows_to_unconditionally,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getControl_flows_to_unconditionallyKeyword_108()); 
                          
                    }

                    }
                    break;
                case 110 :
                    // InternalResoluteParser.g:5938:2: kw= Control_flows_to_conditionally
                    {
                    kw=(Token)match(input,Control_flows_to_conditionally,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getControl_flows_to_conditionallyKeyword_109()); 
                          
                    }

                    }
                    break;
                case 111 :
                    // InternalResoluteParser.g:5945:2: kw= Part_of
                    {
                    kw=(Token)match(input,Part_of,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPart_ofKeyword_110()); 
                          
                    }

                    }
                    break;
                case 112 :
                    // InternalResoluteParser.g:5952:2: kw= Provides
                    {
                    kw=(Token)match(input,Provides,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getProvidesKeyword_111()); 
                          
                    }

                    }
                    break;
                case 113 :
                    // InternalResoluteParser.g:5959:2: kw= Requires
                    {
                    kw=(Token)match(input,Requires,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getRequiresKeyword_112()); 
                          
                    }

                    }
                    break;
                case 114 :
                    // InternalResoluteParser.g:5966:2: kw= Destination_of
                    {
                    kw=(Token)match(input,Destination_of,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDestination_ofKeyword_113()); 
                          
                    }

                    }
                    break;
                case 115 :
                    // InternalResoluteParser.g:5973:2: kw= Identified_by
                    {
                    kw=(Token)match(input,Identified_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIdentified_byKeyword_114()); 
                          
                    }

                    }
                    break;
                case 116 :
                    // InternalResoluteParser.g:5980:2: kw= Developed_by
                    {
                    kw=(Token)match(input,Developed_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDeveloped_byKeyword_115()); 
                          
                    }

                    }
                    break;
                case 117 :
                    // InternalResoluteParser.g:5987:2: kw= Verifies
                    {
                    kw=(Token)match(input,Verifies,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getVerifiesKeyword_116()); 
                          
                    }

                    }
                    break;
                case 118 :
                    // InternalResoluteParser.g:5994:2: kw= Confirms
                    {
                    kw=(Token)match(input,Confirms,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getConfirmsKeyword_117()); 
                          
                    }

                    }
                    break;
                case 119 :
                    // InternalResoluteParser.g:6001:2: kw= Executed_by
                    {
                    kw=(Token)match(input,Executed_by,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getExecuted_byKeyword_118()); 
                          
                    }

                    }
                    break;
                case 120 :
                    // InternalResoluteParser.g:6008:2: kw= Executed_on
                    {
                    kw=(Token)match(input,Executed_on,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getExecuted_onKeyword_119()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBuiltInFn"


    // $ANTLR start "entryRuleRealTerm"
    // InternalResoluteParser.g:6021:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalResoluteParser.g:6022:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalResoluteParser.g:6023:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealTerm"


    // $ANTLR start "ruleRealTerm"
    // InternalResoluteParser.g:6030:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6033:28: ( ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalResoluteParser.g:6034:1: ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalResoluteParser.g:6034:1: ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalResoluteParser.g:6034:2: ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalResoluteParser.g:6034:2: ( (lv_value_0_0= ruleUnsignedReal ) )
            // InternalResoluteParser.g:6035:1: (lv_value_0_0= ruleUnsignedReal )
            {
            // InternalResoluteParser.g:6035:1: (lv_value_0_0= ruleUnsignedReal )
            // InternalResoluteParser.g:6036:3: lv_value_0_0= ruleUnsignedReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealTermAccess().getValueUnsignedRealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_51);
            lv_value_0_0=ruleUnsignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRealTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.UnsignedReal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:6052:2: ( (otherlv_1= RULE_ID ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==EOF||LA54_1==Conclusion||LA54_1==Instanceof||LA54_1==Notation||LA54_1==Strategy||(LA54_1>=Andthen && LA54_1<=Applies)||LA54_1==Ruleset||LA54_1==Warning||LA54_1==Orelse||LA54_1==Check||(LA54_1>=Delta && LA54_1<=Error)||LA54_1==Prove||LA54_1==Else||LA54_1==Goal||LA54_1==Info||LA54_1==Then||LA54_1==And||LA54_1==For||LA54_1==FullStopFullStop||(LA54_1>=LessThanSignEqualsSign && LA54_1<=GreaterThanSignEqualsSign)||LA54_1==In||LA54_1==Or||LA54_1==PercentSign||(LA54_1>=RightParenthesis && LA54_1<=HyphenMinus)||LA54_1==Solidus||(LA54_1>=Semicolon && LA54_1<=GreaterThanSign)||(LA54_1>=RightSquareBracket && LA54_1<=CircumflexAccent)||LA54_1==RightCurlyBracket||LA54_1==RULE_ID) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalResoluteParser.g:6053:1: (otherlv_1= RULE_ID )
                    {
                    // InternalResoluteParser.g:6053:1: (otherlv_1= RULE_ID )
                    // InternalResoluteParser.g:6054:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getRealTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                      	
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealTerm"


    // $ANTLR start "entryRuleUnsignedReal"
    // InternalResoluteParser.g:6073:1: entryRuleUnsignedReal returns [String current=null] : iv_ruleUnsignedReal= ruleUnsignedReal EOF ;
    public final String entryRuleUnsignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnsignedReal = null;


        try {
            // InternalResoluteParser.g:6074:1: (iv_ruleUnsignedReal= ruleUnsignedReal EOF )
            // InternalResoluteParser.g:6075:2: iv_ruleUnsignedReal= ruleUnsignedReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnsignedRealRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnsignedReal=ruleUnsignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnsignedReal.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnsignedReal"


    // $ANTLR start "ruleUnsignedReal"
    // InternalResoluteParser.g:6082:1: ruleUnsignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleUnsignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6086:6: (this_REAL_LIT_0= RULE_REAL_LIT )
            // InternalResoluteParser.g:6087:5: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_LIT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_REAL_LIT_0, grammarAccess.getUnsignedRealAccess().getREAL_LITTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnsignedReal"


    // $ANTLR start "entryRuleIntegerTerm"
    // InternalResoluteParser.g:6102:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalResoluteParser.g:6103:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalResoluteParser.g:6104:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // InternalResoluteParser.g:6111:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6114:28: ( ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalResoluteParser.g:6115:1: ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalResoluteParser.g:6115:1: ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalResoluteParser.g:6115:2: ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalResoluteParser.g:6115:2: ( (lv_value_0_0= ruleUnsignedInt ) )
            // InternalResoluteParser.g:6116:1: (lv_value_0_0= ruleUnsignedInt )
            {
            // InternalResoluteParser.g:6116:1: (lv_value_0_0= ruleUnsignedInt )
            // InternalResoluteParser.g:6117:3: lv_value_0_0= ruleUnsignedInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueUnsignedIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_51);
            lv_value_0_0=ruleUnsignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIntegerTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.UnsignedInt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:6133:2: ( (otherlv_1= RULE_ID ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==EOF||LA55_1==Conclusion||LA55_1==Instanceof||LA55_1==Notation||LA55_1==Strategy||(LA55_1>=Andthen && LA55_1<=Applies)||LA55_1==Ruleset||LA55_1==Warning||LA55_1==Orelse||LA55_1==Check||(LA55_1>=Delta && LA55_1<=Error)||LA55_1==Prove||LA55_1==Else||LA55_1==Goal||LA55_1==Info||LA55_1==Then||LA55_1==And||LA55_1==For||LA55_1==FullStopFullStop||(LA55_1>=LessThanSignEqualsSign && LA55_1<=GreaterThanSignEqualsSign)||LA55_1==In||LA55_1==Or||LA55_1==PercentSign||(LA55_1>=RightParenthesis && LA55_1<=HyphenMinus)||LA55_1==Solidus||(LA55_1>=Semicolon && LA55_1<=GreaterThanSign)||(LA55_1>=RightSquareBracket && LA55_1<=CircumflexAccent)||LA55_1==RightCurlyBracket||LA55_1==RULE_ID) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // InternalResoluteParser.g:6134:1: (otherlv_1= RULE_ID )
                    {
                    // InternalResoluteParser.g:6134:1: (otherlv_1= RULE_ID )
                    // InternalResoluteParser.g:6135:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getIntegerTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                      	
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleUnsignedInt"
    // InternalResoluteParser.g:6154:1: entryRuleUnsignedInt returns [String current=null] : iv_ruleUnsignedInt= ruleUnsignedInt EOF ;
    public final String entryRuleUnsignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnsignedInt = null;


        try {
            // InternalResoluteParser.g:6155:1: (iv_ruleUnsignedInt= ruleUnsignedInt EOF )
            // InternalResoluteParser.g:6156:2: iv_ruleUnsignedInt= ruleUnsignedInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnsignedIntRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnsignedInt=ruleUnsignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnsignedInt.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnsignedInt"


    // $ANTLR start "ruleUnsignedInt"
    // InternalResoluteParser.g:6163:1: ruleUnsignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleUnsignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6167:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalResoluteParser.g:6168:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INTEGER_LIT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INTEGER_LIT_0, grammarAccess.getUnsignedIntAccess().getINTEGER_LITTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnsignedInt"


    // $ANTLR start "entryRuleResoluteSubclause"
    // InternalResoluteParser.g:6183:1: entryRuleResoluteSubclause returns [EObject current=null] : iv_ruleResoluteSubclause= ruleResoluteSubclause EOF ;
    public final EObject entryRuleResoluteSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResoluteSubclause = null;


        try {
            // InternalResoluteParser.g:6184:2: (iv_ruleResoluteSubclause= ruleResoluteSubclause EOF )
            // InternalResoluteParser.g:6185:2: iv_ruleResoluteSubclause= ruleResoluteSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResoluteSubclauseRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleResoluteSubclause=ruleResoluteSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResoluteSubclause; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResoluteSubclause"


    // $ANTLR start "ruleResoluteSubclause"
    // InternalResoluteParser.g:6192:1: ruleResoluteSubclause returns [EObject current=null] : ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* ) ;
    public final EObject ruleResoluteSubclause() throws RecognitionException {
        EObject current = null;

        EObject lv_proves_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6195:28: ( ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* ) )
            // InternalResoluteParser.g:6196:1: ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* )
            {
            // InternalResoluteParser.g:6196:1: ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* )
            // InternalResoluteParser.g:6196:2: () ( (lv_proves_1_0= ruleAnalysisStatement ) )*
            {
            // InternalResoluteParser.g:6196:2: ()
            // InternalResoluteParser.g:6197:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getResoluteSubclauseAccess().getResoluteSubclauseAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:6202:2: ( (lv_proves_1_0= ruleAnalysisStatement ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==Check||LA56_0==Prove) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalResoluteParser.g:6203:1: (lv_proves_1_0= ruleAnalysisStatement )
            	    {
            	    // InternalResoluteParser.g:6203:1: (lv_proves_1_0= ruleAnalysisStatement )
            	    // InternalResoluteParser.g:6204:3: lv_proves_1_0= ruleAnalysisStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResoluteSubclauseAccess().getProvesAnalysisStatementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_52);
            	    lv_proves_1_0=ruleAnalysisStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getResoluteSubclauseRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"proves",
            	              		lv_proves_1_0, 
            	              		"com.rockwellcollins.atc.resolute.Resolute.AnalysisStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResoluteSubclause"


    // $ANTLR start "entryRuleNestedDotID"
    // InternalResoluteParser.g:6228:1: entryRuleNestedDotID returns [EObject current=null] : iv_ruleNestedDotID= ruleNestedDotID EOF ;
    public final EObject entryRuleNestedDotID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedDotID = null;


        try {
            // InternalResoluteParser.g:6229:2: (iv_ruleNestedDotID= ruleNestedDotID EOF )
            // InternalResoluteParser.g:6230:2: iv_ruleNestedDotID= ruleNestedDotID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedDotIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedDotID=ruleNestedDotID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedDotID; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNestedDotID"


    // $ANTLR start "ruleNestedDotID"
    // InternalResoluteParser.g:6237:1: ruleNestedDotID returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? ) ;
    public final EObject ruleNestedDotID() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_sub_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6240:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? ) )
            // InternalResoluteParser.g:6241:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? )
            {
            // InternalResoluteParser.g:6241:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? )
            // InternalResoluteParser.g:6241:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )?
            {
            // InternalResoluteParser.g:6241:2: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:6242:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:6242:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:6243:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNestedDotIDRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getNestedDotIDAccess().getBaseNamedElementCrossReference_0_0()); 
              	
            }

            }


            }

            // InternalResoluteParser.g:6254:2: (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==FullStop) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalResoluteParser.g:6255:2: otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) )
                    {
                    otherlv_1=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNestedDotIDAccess().getFullStopKeyword_1_0());
                          
                    }
                    // InternalResoluteParser.g:6259:1: ( (lv_sub_2_0= ruleNestedDotID ) )
                    // InternalResoluteParser.g:6260:1: (lv_sub_2_0= ruleNestedDotID )
                    {
                    // InternalResoluteParser.g:6260:1: (lv_sub_2_0= ruleNestedDotID )
                    // InternalResoluteParser.g:6261:3: lv_sub_2_0= ruleNestedDotID
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNestedDotIDAccess().getSubNestedDotIDParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_sub_2_0=ruleNestedDotID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNestedDotIDRule());
                      	        }
                             		set(
                             			current, 
                             			"sub",
                              		lv_sub_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.NestedDotID");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedDotID"


    // $ANTLR start "entryRuleLintStatement"
    // InternalResoluteParser.g:6285:1: entryRuleLintStatement returns [EObject current=null] : iv_ruleLintStatement= ruleLintStatement EOF ;
    public final EObject entryRuleLintStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLintStatement = null;


        try {
            // InternalResoluteParser.g:6286:2: (iv_ruleLintStatement= ruleLintStatement EOF )
            // InternalResoluteParser.g:6287:2: iv_ruleLintStatement= ruleLintStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLintStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLintStatement=ruleLintStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLintStatement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLintStatement"


    // $ANTLR start "ruleLintStatement"
    // InternalResoluteParser.g:6294:1: ruleLintStatement returns [EObject current=null] : ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) ) ;
    public final EObject ruleLintStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_expr_2_0 = null;

        EObject lv_expr_5_0 = null;

        EObject lv_expr_8_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6297:28: ( ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:6298:1: ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:6298:1: ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) )
            int alt58=3;
            switch ( input.LA(1) ) {
            case Warning:
                {
                alt58=1;
                }
                break;
            case Error:
                {
                alt58=2;
                }
                break;
            case Info:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalResoluteParser.g:6298:2: ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:6298:2: ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:6298:3: () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:6298:3: ()
                    // InternalResoluteParser.g:6299:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLintStatementAccess().getWarningStatementAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,Warning,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLintStatementAccess().getWarningKeyword_0_1());
                          
                    }
                    // InternalResoluteParser.g:6309:1: ( (lv_expr_2_0= ruleExpr ) )
                    // InternalResoluteParser.g:6310:1: (lv_expr_2_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:6310:1: (lv_expr_2_0= ruleExpr )
                    // InternalResoluteParser.g:6311:3: lv_expr_2_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLintStatementAccess().getExprExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_2_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLintStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:6328:6: ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:6328:6: ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:6328:7: () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:6328:7: ()
                    // InternalResoluteParser.g:6329:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLintStatementAccess().getErrorStatementAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,Error,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLintStatementAccess().getErrorKeyword_1_1());
                          
                    }
                    // InternalResoluteParser.g:6339:1: ( (lv_expr_5_0= ruleExpr ) )
                    // InternalResoluteParser.g:6340:1: (lv_expr_5_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:6340:1: (lv_expr_5_0= ruleExpr )
                    // InternalResoluteParser.g:6341:3: lv_expr_5_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLintStatementAccess().getExprExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_5_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLintStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_5_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:6358:6: ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:6358:6: ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:6358:7: () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:6358:7: ()
                    // InternalResoluteParser.g:6359:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLintStatementAccess().getInfoStatementAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,Info,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getLintStatementAccess().getInfoKeyword_2_1());
                          
                    }
                    // InternalResoluteParser.g:6369:1: ( (lv_expr_8_0= ruleExpr ) )
                    // InternalResoluteParser.g:6370:1: (lv_expr_8_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:6370:1: (lv_expr_8_0= ruleExpr )
                    // InternalResoluteParser.g:6371:3: lv_expr_8_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLintStatementAccess().getExprExprParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_8_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLintStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_8_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLintStatement"


    // $ANTLR start "entryRuleRuleset"
    // InternalResoluteParser.g:6395:1: entryRuleRuleset returns [EObject current=null] : iv_ruleRuleset= ruleRuleset EOF ;
    public final EObject entryRuleRuleset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleset = null;


        try {
            // InternalResoluteParser.g:6396:2: (iv_ruleRuleset= ruleRuleset EOF )
            // InternalResoluteParser.g:6397:2: iv_ruleRuleset= ruleRuleset EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRulesetRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRuleset=ruleRuleset();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleset; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleset"


    // $ANTLR start "ruleRuleset"
    // InternalResoluteParser.g:6404:1: ruleRuleset returns [EObject current=null] : (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleRuleset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6407:28: ( (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket ) )
            // InternalResoluteParser.g:6408:1: (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket )
            {
            // InternalResoluteParser.g:6408:1: (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket )
            // InternalResoluteParser.g:6409:2: otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,Ruleset,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRulesetAccess().getRulesetKeyword_0());
                  
            }
            // InternalResoluteParser.g:6413:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:6414:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:6414:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:6415:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getRulesetAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRulesetRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRulesetAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalResoluteParser.g:6436:1: ( (lv_body_3_0= ruleRulesetBody ) )
            // InternalResoluteParser.g:6437:1: (lv_body_3_0= ruleRulesetBody )
            {
            // InternalResoluteParser.g:6437:1: (lv_body_3_0= ruleRulesetBody )
            // InternalResoluteParser.g:6438:3: lv_body_3_0= ruleRulesetBody
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRulesetAccess().getBodyRulesetBodyParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_10);
            lv_body_3_0=ruleRulesetBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRulesetRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_3_0, 
                      		"com.rockwellcollins.atc.resolute.Resolute.RulesetBody");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRulesetAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleset"


    // $ANTLR start "entryRuleRulesetBody"
    // InternalResoluteParser.g:6467:1: entryRuleRulesetBody returns [EObject current=null] : iv_ruleRulesetBody= ruleRulesetBody EOF ;
    public final EObject entryRuleRulesetBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRulesetBody = null;


        try {
            // InternalResoluteParser.g:6468:2: (iv_ruleRulesetBody= ruleRulesetBody EOF )
            // InternalResoluteParser.g:6469:2: iv_ruleRulesetBody= ruleRulesetBody EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRulesetBodyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRulesetBody=ruleRulesetBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRulesetBody; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRulesetBody"


    // $ANTLR start "ruleRulesetBody"
    // InternalResoluteParser.g:6476:1: ruleRulesetBody returns [EObject current=null] : ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* ) ;
    public final EObject ruleRulesetBody() throws RecognitionException {
        EObject current = null;

        EObject lv_lintStatements_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6479:28: ( ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* ) )
            // InternalResoluteParser.g:6480:1: ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* )
            {
            // InternalResoluteParser.g:6480:1: ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* )
            // InternalResoluteParser.g:6480:2: () ( (lv_lintStatements_1_0= ruleLintStatement ) )*
            {
            // InternalResoluteParser.g:6480:2: ()
            // InternalResoluteParser.g:6481:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRulesetBodyAccess().getRulesetBodyAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:6486:2: ( (lv_lintStatements_1_0= ruleLintStatement ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==Warning||LA59_0==Error||LA59_0==Info) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalResoluteParser.g:6487:1: (lv_lintStatements_1_0= ruleLintStatement )
            	    {
            	    // InternalResoluteParser.g:6487:1: (lv_lintStatements_1_0= ruleLintStatement )
            	    // InternalResoluteParser.g:6488:3: lv_lintStatements_1_0= ruleLintStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRulesetBodyAccess().getLintStatementsLintStatementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_55);
            	    lv_lintStatements_1_0=ruleLintStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRulesetBodyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"lintStatements",
            	              		lv_lintStatements_1_0, 
            	              		"com.rockwellcollins.atc.resolute.Resolute.LintStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRulesetBody"


    // $ANTLR start "entryRuleAnalysisStatement"
    // InternalResoluteParser.g:6512:1: entryRuleAnalysisStatement returns [EObject current=null] : iv_ruleAnalysisStatement= ruleAnalysisStatement EOF ;
    public final EObject entryRuleAnalysisStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnalysisStatement = null;


        try {
            // InternalResoluteParser.g:6513:2: (iv_ruleAnalysisStatement= ruleAnalysisStatement EOF )
            // InternalResoluteParser.g:6514:2: iv_ruleAnalysisStatement= ruleAnalysisStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnalysisStatementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnalysisStatement=ruleAnalysisStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnalysisStatement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnalysisStatement"


    // $ANTLR start "ruleAnalysisStatement"
    // InternalResoluteParser.g:6521:1: ruleAnalysisStatement returns [EObject current=null] : ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) ) ;
    public final EObject ruleAnalysisStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expr_2_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6524:28: ( ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:6525:1: ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:6525:1: ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==Prove) ) {
                alt60=1;
            }
            else if ( (LA60_0==Check) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalResoluteParser.g:6525:2: ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:6525:2: ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:6525:3: () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:6525:3: ()
                    // InternalResoluteParser.g:6526:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAnalysisStatementAccess().getProveStatementAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,Prove,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getAnalysisStatementAccess().getProveKeyword_0_1());
                          
                    }
                    // InternalResoluteParser.g:6536:1: ( (lv_expr_2_0= ruleExpr ) )
                    // InternalResoluteParser.g:6537:1: (lv_expr_2_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:6537:1: (lv_expr_2_0= ruleExpr )
                    // InternalResoluteParser.g:6538:3: lv_expr_2_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAnalysisStatementAccess().getExprExprParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_2_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAnalysisStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:6555:6: ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:6555:6: ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:6555:7: () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:6555:7: ()
                    // InternalResoluteParser.g:6556:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAnalysisStatementAccess().getCheckStatementAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,Check,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAnalysisStatementAccess().getCheckKeyword_1_1());
                          
                    }
                    // InternalResoluteParser.g:6566:1: ( (lv_expr_5_0= ruleExpr ) )
                    // InternalResoluteParser.g:6567:1: (lv_expr_5_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:6567:1: (lv_expr_5_0= ruleExpr )
                    // InternalResoluteParser.g:6568:3: lv_expr_5_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAnalysisStatementAccess().getExprExprParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_5_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAnalysisStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_5_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnalysisStatement"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // InternalResoluteParser.g:6594:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalResoluteParser.g:6595:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalResoluteParser.g:6596:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainedPropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainedPropertyAssociation"


    // $ANTLR start "ruleContainedPropertyAssociation"
    // InternalResoluteParser.g:6603:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;

        EObject lv_appliesTo_8_0 = null;

        EObject lv_appliesTo_10_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6606:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) )
            // InternalResoluteParser.g:6607:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            {
            // InternalResoluteParser.g:6607:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            // InternalResoluteParser.g:6607:2: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon
            {
            // InternalResoluteParser.g:6607:2: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:6608:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:6608:1: ( ruleQPREF )
            // InternalResoluteParser.g:6609:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_56);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:6623:2: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==EqualsSignGreaterThanSign) ) {
                alt61=1;
            }
            else if ( (LA61_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalResoluteParser.g:6624:2: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:6629:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalResoluteParser.g:6629:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalResoluteParser.g:6630:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalResoluteParser.g:6630:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalResoluteParser.g:6631:3: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		setWithLastConsumed(current, "append", true, "+=>");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalResoluteParser.g:6645:3: ( (lv_constant_3_0= Constant ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==Constant) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalResoluteParser.g:6646:1: (lv_constant_3_0= Constant )
                    {
                    // InternalResoluteParser.g:6646:1: (lv_constant_3_0= Constant )
                    // InternalResoluteParser.g:6647:3: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FollowSets000.FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		setWithLastConsumed(current, "constant", true, "constant");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalResoluteParser.g:6661:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalResoluteParser.g:6661:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalResoluteParser.g:6661:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalResoluteParser.g:6662:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalResoluteParser.g:6662:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalResoluteParser.g:6663:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_58);
            lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
              	        }
                     		add(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_4_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:6679:2: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==Comma) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalResoluteParser.g:6680:2: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	          
            	    }
            	    // InternalResoluteParser.g:6684:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalResoluteParser.g:6685:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalResoluteParser.g:6685:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalResoluteParser.g:6686:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_58);
            	    lv_ownedValue_6_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedValue",
            	              		lv_ownedValue_6_0, 
            	              		"org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }

            // InternalResoluteParser.g:6702:5: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==Applies) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalResoluteParser.g:6703:5: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    ruleAppliesToKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }
                    // InternalResoluteParser.g:6710:1: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalResoluteParser.g:6711:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalResoluteParser.g:6711:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalResoluteParser.g:6712:3: lv_appliesTo_8_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_59);
                    lv_appliesTo_8_0=ruleContainmentPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		add(
                             			current, 
                             			"appliesTo",
                              		lv_appliesTo_8_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalResoluteParser.g:6728:2: (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==Comma) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalResoluteParser.g:6729:2: otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:6733:1: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalResoluteParser.g:6734:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalResoluteParser.g:6734:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalResoluteParser.g:6735:3: lv_appliesTo_10_0= ruleContainmentPath
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_59);
                    	    lv_appliesTo_10_0=ruleContainmentPath();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"appliesTo",
                    	              		lv_appliesTo_10_0, 
                    	              		"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalResoluteParser.g:6751:6: ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==In) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalResoluteParser.g:6752:5: ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    ruleInBindingKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_12=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
                          
                    }
                    // InternalResoluteParser.g:6764:1: ( ( ruleQCREF ) )
                    // InternalResoluteParser.g:6765:1: ( ruleQCREF )
                    {
                    // InternalResoluteParser.g:6765:1: ( ruleQCREF )
                    // InternalResoluteParser.g:6766:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_38);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
                          
                    }

                    }
                    break;

            }

            otherlv_15=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainedPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPath"
    // InternalResoluteParser.g:6802:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalResoluteParser.g:6803:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalResoluteParser.g:6804:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPath; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPath"


    // $ANTLR start "ruleContainmentPath"
    // InternalResoluteParser.g:6811:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6814:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalResoluteParser.g:6815:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalResoluteParser.g:6815:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalResoluteParser.g:6816:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalResoluteParser.g:6816:1: (lv_path_0_0= ruleContainmentPathElement )
            // InternalResoluteParser.g:6817:3: lv_path_0_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_path_0_0=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getContainmentPathRule());
              	        }
                     		set(
                     			current, 
                     			"path",
                      		lv_path_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPath"


    // $ANTLR start "entryRuleOptionalModalPropertyValue"
    // InternalResoluteParser.g:6843:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalResoluteParser.g:6844:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalResoluteParser.g:6845:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptionalModalPropertyValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalModalPropertyValue"


    // $ANTLR start "ruleOptionalModalPropertyValue"
    // InternalResoluteParser.g:6852:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) ;
    public final EObject ruleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6855:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) )
            // InternalResoluteParser.g:6856:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            {
            // InternalResoluteParser.g:6856:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            // InternalResoluteParser.g:6856:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            {
            // InternalResoluteParser.g:6856:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:6857:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:6857:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalResoluteParser.g:6858:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_60);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:6874:2: ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==In) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==Modes) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalResoluteParser.g:6875:5: ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_18);
                    ruleInModesKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // InternalResoluteParser.g:6887:1: ( (otherlv_3= RULE_ID ) )
                    // InternalResoluteParser.g:6888:1: (otherlv_3= RULE_ID )
                    {
                    // InternalResoluteParser.g:6888:1: (otherlv_3= RULE_ID )
                    // InternalResoluteParser.g:6889:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0()); 
                      	
                    }

                    }


                    }

                    // InternalResoluteParser.g:6900:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==Comma) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalResoluteParser.g:6901:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:6905:1: ( (otherlv_5= RULE_ID ) )
                    	    // InternalResoluteParser.g:6906:1: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalResoluteParser.g:6906:1: (otherlv_5= RULE_ID )
                    	    // InternalResoluteParser.g:6907:3: otherlv_5= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_4());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalModalPropertyValue"


    // $ANTLR start "entryRulePropertyValue"
    // InternalResoluteParser.g:6931:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalResoluteParser.g:6932:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalResoluteParser.g:6933:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyValue"


    // $ANTLR start "rulePropertyValue"
    // InternalResoluteParser.g:6940:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6943:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalResoluteParser.g:6944:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalResoluteParser.g:6944:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:6945:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:6945:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalResoluteParser.g:6946:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyValueRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyValue"


    // $ANTLR start "entryRulePropertyExpression"
    // InternalResoluteParser.g:6970:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalResoluteParser.g:6971:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalResoluteParser.g:6972:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyExpression"


    // $ANTLR start "rulePropertyExpression"
    // InternalResoluteParser.g:6979:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_ReferenceTerm_1 = null;

        EObject this_ComponentClassifierTerm_2 = null;

        EObject this_ComputedTerm_3 = null;

        EObject this_StringTerm_4 = null;

        EObject this_NumericRangeTerm_5 = null;

        EObject this_RealTerm_6 = null;

        EObject this_IntegerTerm_7 = null;

        EObject this_ListTerm_8 = null;

        EObject this_BooleanLiteral_9 = null;

        EObject this_LiteralorReferenceTerm_10 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6982:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalResoluteParser.g:6983:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalResoluteParser.g:6983:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt69=11;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // InternalResoluteParser.g:6984:5: this_RecordTerm_0= ruleRecordTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RecordTerm_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:6994:5: this_ReferenceTerm_1= ruleReferenceTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReferenceTerm_1=ruleReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ReferenceTerm_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:7004:5: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ComponentClassifierTerm_2=ruleComponentClassifierTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ComponentClassifierTerm_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:7014:5: this_ComputedTerm_3= ruleComputedTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ComputedTerm_3=ruleComputedTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ComputedTerm_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:7024:5: this_StringTerm_4= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_StringTerm_4=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_StringTerm_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:7034:5: this_NumericRangeTerm_5= ruleNumericRangeTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_NumericRangeTerm_5=ruleNumericRangeTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NumericRangeTerm_5;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:7044:5: this_RealTerm_6= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RealTerm_6=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RealTerm_6;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalResoluteParser.g:7054:5: this_IntegerTerm_7= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IntegerTerm_7=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IntegerTerm_7;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalResoluteParser.g:7064:5: this_ListTerm_8= ruleListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ListTerm_8=ruleListTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ListTerm_8;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalResoluteParser.g:7074:5: this_BooleanLiteral_9= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_BooleanLiteral_9=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BooleanLiteral_9;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalResoluteParser.g:7084:5: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LiteralorReferenceTerm_10=ruleLiteralorReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_LiteralorReferenceTerm_10;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyExpression"


    // $ANTLR start "entryRuleLiteralorReferenceTerm"
    // InternalResoluteParser.g:7100:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalResoluteParser.g:7101:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalResoluteParser.g:7102:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralorReferenceTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralorReferenceTerm"


    // $ANTLR start "ruleLiteralorReferenceTerm"
    // InternalResoluteParser.g:7109:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7112:28: ( ( ( ruleQPREF ) ) )
            // InternalResoluteParser.g:7113:1: ( ( ruleQPREF ) )
            {
            // InternalResoluteParser.g:7113:1: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:7114:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:7114:1: ( ruleQPREF )
            // InternalResoluteParser.g:7115:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralorReferenceTerm"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalResoluteParser.g:7137:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalResoluteParser.g:7138:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalResoluteParser.g:7139:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalResoluteParser.g:7146:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7149:28: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalResoluteParser.g:7150:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalResoluteParser.g:7150:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalResoluteParser.g:7150:2: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalResoluteParser.g:7150:2: ()
            // InternalResoluteParser.g:7151:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:7156:2: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==True) ) {
                alt70=1;
            }
            else if ( (LA70_0==False) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalResoluteParser.g:7156:3: ( (lv_value_1_0= True ) )
                    {
                    // InternalResoluteParser.g:7156:3: ( (lv_value_1_0= True ) )
                    // InternalResoluteParser.g:7157:1: (lv_value_1_0= True )
                    {
                    // InternalResoluteParser.g:7157:1: (lv_value_1_0= True )
                    // InternalResoluteParser.g:7158:3: lv_value_1_0= True
                    {
                    lv_value_1_0=(Token)match(input,True,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "value", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:7174:2: otherlv_2= False
                    {
                    otherlv_2=(Token)match(input,False,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleConstantValue"
    // InternalResoluteParser.g:7186:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalResoluteParser.g:7187:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalResoluteParser.g:7188:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // InternalResoluteParser.g:7195:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7198:28: ( ( ( ruleQPREF ) ) )
            // InternalResoluteParser.g:7199:1: ( ( ruleQPREF ) )
            {
            // InternalResoluteParser.g:7199:1: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:7200:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:7200:1: ( ruleQPREF )
            // InternalResoluteParser.g:7201:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantValueRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleReferenceTerm"
    // InternalResoluteParser.g:7223:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalResoluteParser.g:7224:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalResoluteParser.g:7225:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceTerm"


    // $ANTLR start "ruleReferenceTerm"
    // InternalResoluteParser.g:7232:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7235:28: ( (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:7236:1: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:7236:1: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:7237:2: otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Reference,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:7246:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalResoluteParser.g:7247:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalResoluteParser.g:7247:1: (lv_path_2_0= ruleContainmentPathElement )
            // InternalResoluteParser.g:7248:3: lv_path_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_38);
            lv_path_2_0=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceTermRule());
              	        }
                     		set(
                     			current, 
                     			"path",
                      		lv_path_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceTerm"


    // $ANTLR start "entryRuleRecordTerm"
    // InternalResoluteParser.g:7277:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalResoluteParser.g:7278:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalResoluteParser.g:7279:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordTerm"


    // $ANTLR start "ruleRecordTerm"
    // InternalResoluteParser.g:7286:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7289:28: ( (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) )
            // InternalResoluteParser.g:7290:1: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            {
            // InternalResoluteParser.g:7290:1: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            // InternalResoluteParser.g:7291:2: otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // InternalResoluteParser.g:7295:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_ID) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalResoluteParser.g:7296:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalResoluteParser.g:7296:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalResoluteParser.g:7297:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_61);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRecordTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedFieldValue",
            	              		lv_ownedFieldValue_1_0, 
            	              		"org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt71 >= 1 ) break loop71;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
            } while (true);

            otherlv_2=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordTerm"


    // $ANTLR start "entryRuleComputedTerm"
    // InternalResoluteParser.g:7328:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalResoluteParser.g:7329:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalResoluteParser.g:7330:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComputedTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComputedTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComputedTerm"


    // $ANTLR start "ruleComputedTerm"
    // InternalResoluteParser.g:7337:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7340:28: ( (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:7341:1: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:7341:1: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:7342:2: otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Compute,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:7351:1: ( (lv_function_2_0= RULE_ID ) )
            // InternalResoluteParser.g:7352:1: (lv_function_2_0= RULE_ID )
            {
            // InternalResoluteParser.g:7352:1: (lv_function_2_0= RULE_ID )
            // InternalResoluteParser.g:7353:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getComputedTermRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"function",
                      		lv_function_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComputedTerm"


    // $ANTLR start "entryRuleComponentClassifierTerm"
    // InternalResoluteParser.g:7382:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalResoluteParser.g:7383:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalResoluteParser.g:7384:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentClassifierTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentClassifierTerm"


    // $ANTLR start "ruleComponentClassifierTerm"
    // InternalResoluteParser.g:7391:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7394:28: ( (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:7395:1: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:7395:1: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:7396:2: otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Classifier,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:7405:1: ( ( ruleQCREF ) )
            // InternalResoluteParser.g:7406:1: ( ruleQCREF )
            {
            // InternalResoluteParser.g:7406:1: ( ruleQCREF )
            // InternalResoluteParser.g:7407:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getComponentClassifierTermRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_38);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentClassifierTerm"


    // $ANTLR start "entryRuleListTerm"
    // InternalResoluteParser.g:7434:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalResoluteParser.g:7435:2: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalResoluteParser.g:7436:2: iv_ruleListTerm= ruleListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListTerm"


    // $ANTLR start "ruleListTerm"
    // InternalResoluteParser.g:7443:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7446:28: ( ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) )
            // InternalResoluteParser.g:7447:1: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            {
            // InternalResoluteParser.g:7447:1: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            // InternalResoluteParser.g:7447:2: () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis
            {
            // InternalResoluteParser.g:7447:2: ()
            // InternalResoluteParser.g:7448:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getListTermAccess().getListValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:7458:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==Classifier||LA73_0==Reference||LA73_0==Compute||LA73_0==False||LA73_0==True||LA73_0==LeftParenthesis||LA73_0==PlusSign||LA73_0==HyphenMinus||LA73_0==LeftSquareBracket||LA73_0==RULE_REAL_LIT||LA73_0==RULE_INTEGER_LIT||(LA73_0>=RULE_STRING && LA73_0<=RULE_ID)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalResoluteParser.g:7458:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalResoluteParser.g:7458:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalResoluteParser.g:7459:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalResoluteParser.g:7459:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalResoluteParser.g:7460:3: lv_ownedListElement_2_0= rulePropertyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_20);
                    lv_ownedListElement_2_0=rulePropertyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getListTermRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedListElement",
                              		lv_ownedListElement_2_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalResoluteParser.g:7476:2: (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==Comma) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalResoluteParser.g:7477:2: otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_57); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:7481:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalResoluteParser.g:7482:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalResoluteParser.g:7482:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalResoluteParser.g:7483:3: lv_ownedListElement_4_0= rulePropertyExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_20);
                    	    lv_ownedListElement_4_0=rulePropertyExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getListTermRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedListElement",
                    	              		lv_ownedListElement_4_0, 
                    	              		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListTerm"


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // InternalResoluteParser.g:7512:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalResoluteParser.g:7513:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalResoluteParser.g:7514:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldPropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldPropertyAssociation"


    // $ANTLR start "ruleFieldPropertyAssociation"
    // InternalResoluteParser.g:7521:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7524:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalResoluteParser.g:7525:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalResoluteParser.g:7525:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalResoluteParser.g:7525:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalResoluteParser.g:7525:2: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:7526:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:7526:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:7527:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // InternalResoluteParser.g:7543:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:7544:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:7544:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalResoluteParser.g:7545:3: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,Semicolon,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPathElement"
    // InternalResoluteParser.g:7574:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalResoluteParser.g:7575:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalResoluteParser.g:7576:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPathElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPathElement"


    // $ANTLR start "ruleContainmentPathElement"
    // InternalResoluteParser.g:7583:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7586:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalResoluteParser.g:7587:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalResoluteParser.g:7587:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalResoluteParser.g:7587:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalResoluteParser.g:7587:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalResoluteParser.g:7587:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalResoluteParser.g:7587:3: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:7588:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:7588:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:7589:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); 
              	
            }

            }


            }

            // InternalResoluteParser.g:7600:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==LeftSquareBracket) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalResoluteParser.g:7601:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalResoluteParser.g:7601:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalResoluteParser.g:7602:3: lv_arrayRange_1_0= ruleArrayRange
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_64);
            	    lv_arrayRange_1_0=ruleArrayRange();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"arrayRange",
            	              		lv_arrayRange_1_0, 
            	              		"org.osate.xtext.aadl2.properties.Properties.ArrayRange");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }

            // InternalResoluteParser.g:7618:4: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==FullStop) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalResoluteParser.g:7619:2: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                          
                    }
                    // InternalResoluteParser.g:7623:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalResoluteParser.g:7624:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalResoluteParser.g:7624:1: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalResoluteParser.g:7625:3: lv_path_3_0= ruleContainmentPathElement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_path_3_0=ruleContainmentPathElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                      	        }
                             		set(
                             			current, 
                             			"path",
                              		lv_path_3_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPathElement"


    // $ANTLR start "entryRulePlusMinus"
    // InternalResoluteParser.g:7651:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalResoluteParser.g:7652:1: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalResoluteParser.g:7653:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusMinusRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusMinus.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusMinus"


    // $ANTLR start "rulePlusMinus"
    // InternalResoluteParser.g:7660:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7664:6: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalResoluteParser.g:7665:1: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalResoluteParser.g:7665:1: (kw= PlusSign | kw= HyphenMinus )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==PlusSign) ) {
                alt76=1;
            }
            else if ( (LA76_0==HyphenMinus) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalResoluteParser.g:7666:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:7673:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleStringTerm"
    // InternalResoluteParser.g:7686:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalResoluteParser.g:7687:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalResoluteParser.g:7688:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // InternalResoluteParser.g:7695:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7698:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalResoluteParser.g:7699:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalResoluteParser.g:7699:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalResoluteParser.g:7700:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalResoluteParser.g:7700:1: (lv_value_0_0= ruleNoQuoteString )
            // InternalResoluteParser.g:7701:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStringTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalResoluteParser.g:7725:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalResoluteParser.g:7726:1: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalResoluteParser.g:7727:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // InternalResoluteParser.g:7734:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7738:6: (this_STRING_0= RULE_STRING )
            // InternalResoluteParser.g:7739:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleArrayRange"
    // InternalResoluteParser.g:7754:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalResoluteParser.g:7755:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalResoluteParser.g:7756:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRangeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRange; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayRange"


    // $ANTLR start "ruleArrayRange"
    // InternalResoluteParser.g:7763:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7766:28: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalResoluteParser.g:7767:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalResoluteParser.g:7767:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalResoluteParser.g:7767:2: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalResoluteParser.g:7767:2: ()
            // InternalResoluteParser.g:7768:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // InternalResoluteParser.g:7778:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalResoluteParser.g:7779:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalResoluteParser.g:7779:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalResoluteParser.g:7780:3: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_66);
            lv_lowerBound_2_0=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
              	        }
                     		set(
                     			current, 
                     			"lowerBound",
                      		lv_lowerBound_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:7796:2: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==FullStopFullStop) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalResoluteParser.g:7797:2: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                          
                    }
                    // InternalResoluteParser.g:7801:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalResoluteParser.g:7802:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalResoluteParser.g:7802:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalResoluteParser.g:7803:3: lv_upperBound_4_0= ruleINTVALUE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_upperBound_4_0=ruleINTVALUE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_4_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayRange"


    // $ANTLR start "entryRuleSignedConstant"
    // InternalResoluteParser.g:7832:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalResoluteParser.g:7833:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalResoluteParser.g:7834:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedConstantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedConstant; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedConstant"


    // $ANTLR start "ruleSignedConstant"
    // InternalResoluteParser.g:7841:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7844:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalResoluteParser.g:7845:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalResoluteParser.g:7845:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalResoluteParser.g:7845:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalResoluteParser.g:7845:2: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalResoluteParser.g:7846:1: (lv_op_0_0= rulePlusMinus )
            {
            // InternalResoluteParser.g:7846:1: (lv_op_0_0= rulePlusMinus )
            // InternalResoluteParser.g:7847:3: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_67);
            lv_op_0_0=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.PlusMinus");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:7863:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalResoluteParser.g:7864:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalResoluteParser.g:7864:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalResoluteParser.g:7865:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_ownedPropertyExpression_1_0=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPropertyExpression",
                      		lv_ownedPropertyExpression_1_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ConstantValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedConstant"


    // $ANTLR start "entryRuleNumericRangeTerm"
    // InternalResoluteParser.g:7893:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalResoluteParser.g:7894:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalResoluteParser.g:7895:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericRangeTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericRangeTerm"


    // $ANTLR start "ruleNumericRangeTerm"
    // InternalResoluteParser.g:7902:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7905:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalResoluteParser.g:7906:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalResoluteParser.g:7906:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalResoluteParser.g:7906:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalResoluteParser.g:7906:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalResoluteParser.g:7907:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalResoluteParser.g:7907:1: (lv_minimum_0_0= ruleNumAlt )
            // InternalResoluteParser.g:7908:3: lv_minimum_0_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_68);
            lv_minimum_0_0=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
              	        }
                     		set(
                     			current, 
                     			"minimum",
                      		lv_minimum_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                  
            }
            // InternalResoluteParser.g:7929:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalResoluteParser.g:7930:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalResoluteParser.g:7930:1: (lv_maximum_2_0= ruleNumAlt )
            // InternalResoluteParser.g:7931:3: lv_maximum_2_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_69);
            lv_maximum_2_0=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
              	        }
                     		set(
                     			current, 
                     			"maximum",
                      		lv_maximum_2_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:7947:2: (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==Delta) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalResoluteParser.g:7948:2: otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,Delta,FollowSets000.FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                          
                    }
                    // InternalResoluteParser.g:7952:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalResoluteParser.g:7953:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalResoluteParser.g:7953:1: (lv_delta_4_0= ruleNumAlt )
                    // InternalResoluteParser.g:7954:3: lv_delta_4_0= ruleNumAlt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_delta_4_0=ruleNumAlt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"delta",
                              		lv_delta_4_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericRangeTerm"


    // $ANTLR start "entryRuleNumAlt"
    // InternalResoluteParser.g:7978:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalResoluteParser.g:7979:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalResoluteParser.g:7980:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumAltRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumAlt; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumAlt"


    // $ANTLR start "ruleNumAlt"
    // InternalResoluteParser.g:7987:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7990:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalResoluteParser.g:7991:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalResoluteParser.g:7991:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt79=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_LIT:
                {
                alt79=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt79=2;
                }
                break;
            case PlusSign:
            case HyphenMinus:
                {
                alt79=3;
                }
                break;
            case RULE_ID:
                {
                alt79=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // InternalResoluteParser.g:7992:5: this_RealTerm_0= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RealTerm_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:8002:5: this_IntegerTerm_1= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IntegerTerm_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:8012:5: this_SignedConstant_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SignedConstant_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:8022:5: this_ConstantValue_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ConstantValue_3=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ConstantValue_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumAlt"


    // $ANTLR start "entryRuleAppliesToKeywords"
    // InternalResoluteParser.g:8038:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalResoluteParser.g:8039:1: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalResoluteParser.g:8040:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAppliesToKeywords=ruleAppliesToKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAppliesToKeywords.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAppliesToKeywords"


    // $ANTLR start "ruleAppliesToKeywords"
    // InternalResoluteParser.g:8047:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Applies kw= To ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:8051:6: ( (kw= Applies kw= To ) )
            // InternalResoluteParser.g:8052:1: (kw= Applies kw= To )
            {
            // InternalResoluteParser.g:8052:1: (kw= Applies kw= To )
            // InternalResoluteParser.g:8053:2: kw= Applies kw= To
            {
            kw=(Token)match(input,Applies,FollowSets000.FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0()); 
                  
            }
            kw=(Token)match(input,To,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAppliesToKeywords"


    // $ANTLR start "entryRuleInBindingKeywords"
    // InternalResoluteParser.g:8072:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalResoluteParser.g:8073:1: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalResoluteParser.g:8074:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInBindingKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInBindingKeywords=ruleInBindingKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInBindingKeywords.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInBindingKeywords"


    // $ANTLR start "ruleInBindingKeywords"
    // InternalResoluteParser.g:8081:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Binding ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:8085:6: ( (kw= In kw= Binding ) )
            // InternalResoluteParser.g:8086:1: (kw= In kw= Binding )
            {
            // InternalResoluteParser.g:8086:1: (kw= In kw= Binding )
            // InternalResoluteParser.g:8087:2: kw= In kw= Binding
            {
            kw=(Token)match(input,In,FollowSets000.FOLLOW_71); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); 
                  
            }
            kw=(Token)match(input,Binding,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInBindingKeywords"


    // $ANTLR start "entryRuleInModesKeywords"
    // InternalResoluteParser.g:8106:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalResoluteParser.g:8107:1: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalResoluteParser.g:8108:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInModesKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInModesKeywords=ruleInModesKeywords();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInModesKeywords.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInModesKeywords"


    // $ANTLR start "ruleInModesKeywords"
    // InternalResoluteParser.g:8115:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Modes ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:8119:6: ( (kw= In kw= Modes ) )
            // InternalResoluteParser.g:8120:1: (kw= In kw= Modes )
            {
            // InternalResoluteParser.g:8120:1: (kw= In kw= Modes )
            // InternalResoluteParser.g:8121:2: kw= In kw= Modes
            {
            kw=(Token)match(input,In,FollowSets000.FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0()); 
                  
            }
            kw=(Token)match(input,Modes,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInModesKeywords"


    // $ANTLR start "entryRuleINTVALUE"
    // InternalResoluteParser.g:8140:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalResoluteParser.g:8141:1: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalResoluteParser.g:8142:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTVALUERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTVALUE.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTVALUE"


    // $ANTLR start "ruleINTVALUE"
    // InternalResoluteParser.g:8149:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:8153:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalResoluteParser.g:8154:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INTEGER_LIT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTVALUE"


    // $ANTLR start "entryRuleQPREF"
    // InternalResoluteParser.g:8171:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalResoluteParser.g:8172:1: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalResoluteParser.g:8173:2: iv_ruleQPREF= ruleQPREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQPREFRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQPREF.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQPREF"


    // $ANTLR start "ruleQPREF"
    // InternalResoluteParser.g:8180:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:8184:6: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalResoluteParser.g:8185:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalResoluteParser.g:8185:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalResoluteParser.g:8185:6: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalResoluteParser.g:8192:1: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==ColonColon) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalResoluteParser.g:8193:2: kw= ColonColon this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQPREF"


    // $ANTLR start "entryRuleQCREF"
    // InternalResoluteParser.g:8213:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalResoluteParser.g:8214:1: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalResoluteParser.g:8215:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQCREF"


    // $ANTLR start "ruleQCREF"
    // InternalResoluteParser.g:8222:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:8226:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalResoluteParser.g:8227:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalResoluteParser.g:8227:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalResoluteParser.g:8227:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalResoluteParser.g:8227:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==RULE_ID) ) {
                    int LA81_1 = input.LA(2);

                    if ( (LA81_1==ColonColon) ) {
                        alt81=1;
                    }


                }


                switch (alt81) {
            	case 1 :
            	    // InternalResoluteParser.g:8227:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_74); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // InternalResoluteParser.g:8247:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==FullStop) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalResoluteParser.g:8248:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQCREF"


    // $ANTLR start "entryRuleSTAR"
    // InternalResoluteParser.g:8268:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalResoluteParser.g:8269:1: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalResoluteParser.g:8270:2: iv_ruleSTAR= ruleSTAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTARRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTAR.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTAR"


    // $ANTLR start "ruleSTAR"
    // InternalResoluteParser.g:8277:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:8281:6: (kw= Asterisk )
            // InternalResoluteParser.g:8283:2: kw= Asterisk
            {
            kw=(Token)match(input,Asterisk,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTAR"

    // $ANTLR start synpred1_InternalResoluteParser
    public final void synpred1_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:1712:3: ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )
        // InternalResoluteParser.g:1712:4: ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) )
        {
        // InternalResoluteParser.g:1712:4: ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) )
        // InternalResoluteParser.g:1712:5: ( ( RULE_ID ) ) Colon ( ( ruleType ) )
        {
        // InternalResoluteParser.g:1712:5: ( ( RULE_ID ) )
        // InternalResoluteParser.g:1713:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:1713:1: ( RULE_ID )
        // InternalResoluteParser.g:1714:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return ;

        }


        }

        match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalResoluteParser.g:1719:1: ( ( ruleType ) )
        // InternalResoluteParser.g:1720:1: ( ruleType )
        {
        // InternalResoluteParser.g:1720:1: ( ruleType )
        // InternalResoluteParser.g:1721:1: ruleType
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleType();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalResoluteParser

    // $ANTLR start synpred2_InternalResoluteParser
    public final void synpred2_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:2943:3: ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )
        // InternalResoluteParser.g:2943:4: ( () ( ( EqualsSignGreaterThanSign ) ) )
        {
        // InternalResoluteParser.g:2943:4: ( () ( ( EqualsSignGreaterThanSign ) ) )
        // InternalResoluteParser.g:2943:5: () ( ( EqualsSignGreaterThanSign ) )
        {
        // InternalResoluteParser.g:2943:5: ()
        // InternalResoluteParser.g:2944:1: 
        {
        }

        // InternalResoluteParser.g:2944:2: ( ( EqualsSignGreaterThanSign ) )
        // InternalResoluteParser.g:2945:1: ( EqualsSignGreaterThanSign )
        {
        // InternalResoluteParser.g:2945:1: ( EqualsSignGreaterThanSign )
        // InternalResoluteParser.g:2947:1: EqualsSignGreaterThanSign
        {
        match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalResoluteParser

    // $ANTLR start synpred3_InternalResoluteParser
    public final void synpred3_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:3021:3: ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )
        // InternalResoluteParser.g:3021:4: ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) )
        {
        // InternalResoluteParser.g:3021:4: ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) )
        // InternalResoluteParser.g:3021:5: () ( ( ( Or ) ) | ( ( Orelse ) ) )
        {
        // InternalResoluteParser.g:3021:5: ()
        // InternalResoluteParser.g:3022:1: 
        {
        }

        // InternalResoluteParser.g:3022:2: ( ( ( Or ) ) | ( ( Orelse ) ) )
        int alt83=2;
        int LA83_0 = input.LA(1);

        if ( (LA83_0==Or) ) {
            alt83=1;
        }
        else if ( (LA83_0==Orelse) ) {
            alt83=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 83, 0, input);

            throw nvae;
        }
        switch (alt83) {
            case 1 :
                // InternalResoluteParser.g:3022:3: ( ( Or ) )
                {
                // InternalResoluteParser.g:3022:3: ( ( Or ) )
                // InternalResoluteParser.g:3023:1: ( Or )
                {
                // InternalResoluteParser.g:3023:1: ( Or )
                // InternalResoluteParser.g:3025:1: Or
                {
                match(input,Or,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalResoluteParser.g:3030:6: ( ( Orelse ) )
                {
                // InternalResoluteParser.g:3030:6: ( ( Orelse ) )
                // InternalResoluteParser.g:3031:1: ( Orelse )
                {
                // InternalResoluteParser.g:3031:1: ( Orelse )
                // InternalResoluteParser.g:3033:1: Orelse
                {
                match(input,Orelse,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalResoluteParser

    // $ANTLR start synpred4_InternalResoluteParser
    public final void synpred4_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:3124:3: ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )
        // InternalResoluteParser.g:3124:4: ( () ( ( ( And ) ) | ( ( Andthen ) ) ) )
        {
        // InternalResoluteParser.g:3124:4: ( () ( ( ( And ) ) | ( ( Andthen ) ) ) )
        // InternalResoluteParser.g:3124:5: () ( ( ( And ) ) | ( ( Andthen ) ) )
        {
        // InternalResoluteParser.g:3124:5: ()
        // InternalResoluteParser.g:3125:1: 
        {
        }

        // InternalResoluteParser.g:3125:2: ( ( ( And ) ) | ( ( Andthen ) ) )
        int alt84=2;
        int LA84_0 = input.LA(1);

        if ( (LA84_0==And) ) {
            alt84=1;
        }
        else if ( (LA84_0==Andthen) ) {
            alt84=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 84, 0, input);

            throw nvae;
        }
        switch (alt84) {
            case 1 :
                // InternalResoluteParser.g:3125:3: ( ( And ) )
                {
                // InternalResoluteParser.g:3125:3: ( ( And ) )
                // InternalResoluteParser.g:3126:1: ( And )
                {
                // InternalResoluteParser.g:3126:1: ( And )
                // InternalResoluteParser.g:3128:1: And
                {
                match(input,And,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalResoluteParser.g:3133:6: ( ( Andthen ) )
                {
                // InternalResoluteParser.g:3133:6: ( ( Andthen ) )
                // InternalResoluteParser.g:3134:1: ( Andthen )
                {
                // InternalResoluteParser.g:3134:1: ( Andthen )
                // InternalResoluteParser.g:3136:1: Andthen
                {
                match(input,Andthen,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred4_InternalResoluteParser

    // $ANTLR start synpred5_InternalResoluteParser
    public final void synpred5_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:3227:3: ( ( () Instanceof ) )
        // InternalResoluteParser.g:3227:4: ( () Instanceof )
        {
        // InternalResoluteParser.g:3227:4: ( () Instanceof )
        // InternalResoluteParser.g:3227:5: () Instanceof
        {
        // InternalResoluteParser.g:3227:5: ()
        // InternalResoluteParser.g:3228:1: 
        {
        }

        match(input,Instanceof,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalResoluteParser

    // $ANTLR start synpred6_InternalResoluteParser
    public final void synpred6_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:3352:3: ( ( () ( ( ruleRelationalOp ) ) ) )
        // InternalResoluteParser.g:3352:4: ( () ( ( ruleRelationalOp ) ) )
        {
        // InternalResoluteParser.g:3352:4: ( () ( ( ruleRelationalOp ) ) )
        // InternalResoluteParser.g:3352:5: () ( ( ruleRelationalOp ) )
        {
        // InternalResoluteParser.g:3352:5: ()
        // InternalResoluteParser.g:3353:1: 
        {
        }

        // InternalResoluteParser.g:3353:2: ( ( ruleRelationalOp ) )
        // InternalResoluteParser.g:3354:1: ( ruleRelationalOp )
        {
        // InternalResoluteParser.g:3354:1: ( ruleRelationalOp )
        // InternalResoluteParser.g:3355:1: ruleRelationalOp
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleRelationalOp();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalResoluteParser

    // $ANTLR start synpred7_InternalResoluteParser
    public final void synpred7_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:3429:3: ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )
        // InternalResoluteParser.g:3429:4: ( () ( ( ( PlusSign | HyphenMinus ) ) ) )
        {
        // InternalResoluteParser.g:3429:4: ( () ( ( ( PlusSign | HyphenMinus ) ) ) )
        // InternalResoluteParser.g:3429:5: () ( ( ( PlusSign | HyphenMinus ) ) )
        {
        // InternalResoluteParser.g:3429:5: ()
        // InternalResoluteParser.g:3430:1: 
        {
        }

        // InternalResoluteParser.g:3430:2: ( ( ( PlusSign | HyphenMinus ) ) )
        // InternalResoluteParser.g:3431:1: ( ( PlusSign | HyphenMinus ) )
        {
        // InternalResoluteParser.g:3431:1: ( ( PlusSign | HyphenMinus ) )
        // InternalResoluteParser.g:3432:1: ( PlusSign | HyphenMinus )
        {
        if ( input.LA(1)==PlusSign||input.LA(1)==HyphenMinus ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalResoluteParser

    // $ANTLR start synpred8_InternalResoluteParser
    public final void synpred8_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:3530:3: ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )
        // InternalResoluteParser.g:3530:4: ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) )
        {
        // InternalResoluteParser.g:3530:4: ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) )
        // InternalResoluteParser.g:3530:5: () ( ( ( Asterisk | Solidus | PercentSign ) ) )
        {
        // InternalResoluteParser.g:3530:5: ()
        // InternalResoluteParser.g:3531:1: 
        {
        }

        // InternalResoluteParser.g:3531:2: ( ( ( Asterisk | Solidus | PercentSign ) ) )
        // InternalResoluteParser.g:3532:1: ( ( Asterisk | Solidus | PercentSign ) )
        {
        // InternalResoluteParser.g:3532:1: ( ( Asterisk | Solidus | PercentSign ) )
        // InternalResoluteParser.g:3533:1: ( Asterisk | Solidus | PercentSign )
        {
        if ( input.LA(1)==PercentSign||input.LA(1)==Asterisk||input.LA(1)==Solidus ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalResoluteParser

    // $ANTLR start synpred9_InternalResoluteParser
    public final void synpred9_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:3648:3: ( ( () ( ( CircumflexAccent ) ) ) )
        // InternalResoluteParser.g:3648:4: ( () ( ( CircumflexAccent ) ) )
        {
        // InternalResoluteParser.g:3648:4: ( () ( ( CircumflexAccent ) ) )
        // InternalResoluteParser.g:3648:5: () ( ( CircumflexAccent ) )
        {
        // InternalResoluteParser.g:3648:5: ()
        // InternalResoluteParser.g:3649:1: 
        {
        }

        // InternalResoluteParser.g:3649:2: ( ( CircumflexAccent ) )
        // InternalResoluteParser.g:3650:1: ( CircumflexAccent )
        {
        // InternalResoluteParser.g:3650:1: ( CircumflexAccent )
        // InternalResoluteParser.g:3652:1: CircumflexAccent
        {
        match(input,CircumflexAccent,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalResoluteParser

    // $ANTLR start synpred10_InternalResoluteParser
    public final void synpred10_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:4265:7: ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )
        // InternalResoluteParser.g:4265:8: ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis )
        {
        // InternalResoluteParser.g:4265:8: ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis )
        // InternalResoluteParser.g:4265:9: () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis
        {
        // InternalResoluteParser.g:4265:9: ()
        // InternalResoluteParser.g:4266:1: 
        {
        }

        // InternalResoluteParser.g:4266:2: ( ( RULE_ID ) )
        // InternalResoluteParser.g:4267:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:4267:1: ( RULE_ID )
        // InternalResoluteParser.g:4268:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return ;

        }


        }

        match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return ;
        // InternalResoluteParser.g:4273:1: ( ( RULE_ID ) )
        // InternalResoluteParser.g:4274:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:4274:1: ( RULE_ID )
        // InternalResoluteParser.g:4275:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_18); if (state.failed) return ;

        }


        }

        match(input,LeftParenthesis,FollowSets000.FOLLOW_44); if (state.failed) return ;
        // InternalResoluteParser.g:4280:1: ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )?
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( (LA86_0==Control_flows_to_unconditionally||LA86_0==Control_flows_to_conditionally||LA86_0==Revised_without_review||LA86_0==Error_state_reachable||LA86_0==Is_virtual_processor||(LA86_0>=Flow_specifications && LA86_0<=Is_abstract_feature)||LA86_0==Revised_with_review||LA86_0==Enumerated_values||(LA86_0>=End_to_end_flows && LA86_0<=Is_bidirectional)||LA86_0==Annotation_type||(LA86_0>=Is_thread_group && LA86_0<=Property_member)||LA86_0==Subcomponent_of||(LA86_0>=Destination_of && LA86_0<=Is_virtual_bus)||(LA86_0>=Compile_input && LA86_0<=Contain_error)||(LA86_0>=Flow_elements && LA86_0<=Is_subprogram)||LA86_0==Package_input||(LA86_0>=Receive_error && LA86_0<=Subcomponents)||(LA86_0>=Developed_by && LA86_0<=Is_processor)||LA86_0==Performed_by||LA86_0==Requirements||(LA86_0>=Annotations && LA86_0<=Consumed_by)||(LA86_0>=Description && LA86_0<=Provided_by)||(LA86_0>=Undeveloped && LA86_0<=Upper_bound)||(LA86_0>=Created_by && LA86_0<=Definition)||(LA86_0>=Given_text && LA86_0<=Identified)||(LA86_0>=Is_of_type && LA86_0<=Referenced)||LA86_0==Value_type||(LA86_0>=Direction && LA86_0<=Instances)||LA86_0==Intersect||(LA86_0>=Is_device && LA86_0<=Mitigates)||(LA86_0>=Result_of && LA86_0<=Then_text)||(LA86_0>=Analysis && LA86_0<=Analyzes)||LA86_0==Confirms||(LA86_0>=Evidence && LA86_0<=Mentions)||(LA86_0>=Property && LA86_0<=Solution)||LA86_0==Verifies||LA86_0==As_list||(LA86_0>=Governs && LA86_0<=Part_of)||LA86_0==Reviews||(LA86_0>=Type_of && LA86_0<=Warning)||(LA86_0>=Append && LA86_0<=Author)||(LA86_0>=Exists && LA86_0<=Forall)||(LA86_0>=Is_bus && LA86_0<=Member)||LA86_0==Metric||(LA86_0>=Parent && LA86_0<=Passed)||LA86_0==Source||LA86_0==Debug||(LA86_0>=Error && LA86_0<=False)||LA86_0==Union||LA86_0==Fail||(LA86_0>=Head && LA86_0<=Name)||(LA86_0>=Size && LA86_0<=Tail)||LA86_0==Text||(LA86_0>=This && LA86_0<=Type)||(LA86_0>=Let && LA86_0<=Sum)||LA86_0==If||LA86_0==LeftParenthesis||LA86_0==HyphenMinus||LA86_0==LeftSquareBracket||LA86_0==LeftCurlyBracket||LA86_0==RULE_REAL_LIT||LA86_0==RULE_INTEGER_LIT||(LA86_0>=RULE_STRING && LA86_0<=RULE_ID)) ) {
            alt86=1;
        }
        switch (alt86) {
            case 1 :
                // InternalResoluteParser.g:4280:2: ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )*
                {
                // InternalResoluteParser.g:4280:2: ( ( ruleExpr ) )
                // InternalResoluteParser.g:4281:1: ( ruleExpr )
                {
                // InternalResoluteParser.g:4281:1: ( ruleExpr )
                // InternalResoluteParser.g:4282:1: ruleExpr
                {
                pushFollow(FollowSets000.FOLLOW_20);
                ruleExpr();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalResoluteParser.g:4284:2: ( Comma ( ( ruleExpr ) ) )*
                loop85:
                do {
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==Comma) ) {
                        alt85=1;
                    }


                    switch (alt85) {
                	case 1 :
                	    // InternalResoluteParser.g:4285:1: Comma ( ( ruleExpr ) )
                	    {
                	    match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return ;
                	    // InternalResoluteParser.g:4286:1: ( ( ruleExpr ) )
                	    // InternalResoluteParser.g:4287:1: ( ruleExpr )
                	    {
                	    // InternalResoluteParser.g:4287:1: ( ruleExpr )
                	    // InternalResoluteParser.g:4288:1: ruleExpr
                	    {
                	    pushFollow(FollowSets000.FOLLOW_20);
                	    ruleExpr();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop85;
                    }
                } while (true);


                }
                break;

        }

        match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalResoluteParser

    // Delegated rules

    public final boolean synpred4_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalResoluteParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalResoluteParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA51 dfa51 = new DFA51(this);
    protected DFA69 dfa69 = new DFA69(this);
    static final String dfa_1s = "\35\uffff";
    static final String dfa_2s = "\1\uffff\1\25\31\uffff\1\25\1\uffff";
    static final String dfa_3s = "\1\4\1\165\13\uffff\2\4\5\uffff\1\u0131\6\uffff\1\165\1\uffff";
    static final String dfa_4s = "\2\u0131\13\uffff\2\u0131\5\uffff\1\u0131\6\uffff\1\u0131\1\uffff";
    static final String dfa_5s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\14\1\16\2\uffff\1\23\1\24\1\25\1\26\1\27\1\uffff\1\1\1\15\1\21\1\17\1\20\1\22\1\uffff\1\13";
    static final String dfa_6s = "\33\uffff\1\0\1\uffff}>";
    static final String[] dfa_7s = {
            "\1\13\2\uffff\1\13\6\uffff\1\4\2\uffff\1\13\2\uffff\1\13\3\uffff\2\13\2\uffff\1\4\5\uffff\1\13\4\uffff\3\13\4\uffff\1\13\3\uffff\3\13\1\uffff\1\13\1\uffff\4\13\1\uffff\2\13\1\uffff\2\13\1\4\3\13\1\uffff\1\13\1\uffff\3\13\1\uffff\5\13\1\uffff\1\13\1\uffff\1\13\2\uffff\4\13\1\uffff\15\13\5\uffff\1\21\1\13\6\uffff\3\13\1\uffff\4\13\1\uffff\3\13\2\uffff\1\13\2\uffff\3\13\1\uffff\1\13\1\uffff\5\13\4\uffff\4\13\2\uffff\2\13\1\uffff\1\13\1\uffff\1\22\5\13\1\uffff\5\13\1\23\1\uffff\1\13\2\uffff\1\13\5\uffff\5\13\2\uffff\1\13\1\uffff\1\13\1\14\1\uffff\3\13\3\uffff\1\12\1\4\1\12\2\uffff\3\13\1\uffff\1\13\2\uffff\1\13\1\4\1\uffff\1\13\6\uffff\1\13\1\uffff\1\14\1\7\4\uffff\1\13\4\uffff\1\3\2\uffff\1\13\1\14\1\13\2\uffff\3\13\1\uffff\1\13\1\uffff\1\2\1\7\1\13\6\uffff\1\17\1\uffff\1\13\7\uffff\1\11\5\uffff\1\20\14\uffff\1\15\2\uffff\1\16\6\uffff\1\6\1\uffff\1\5\1\uffff\1\10\1\1",
            "\1\25\11\uffff\1\25\50\uffff\1\25\6\uffff\1\25\1\uffff\1\25\17\uffff\1\25\1\uffff\1\25\22\uffff\1\25\11\uffff\1\25\2\uffff\1\25\2\uffff\1\25\6\uffff\1\25\2\uffff\1\25\1\uffff\1\25\10\uffff\1\25\4\uffff\1\25\1\uffff\1\25\7\uffff\5\25\3\uffff\1\25\1\uffff\1\25\1\26\5\25\1\24\1\25\1\uffff\4\25\1\uffff\2\25\2\uffff\1\25\11\uffff\1\25",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\30\2\uffff\1\30\6\uffff\1\30\2\uffff\1\30\2\uffff\1\30\3\uffff\2\30\2\uffff\1\30\5\uffff\1\30\4\uffff\3\30\4\uffff\1\30\3\uffff\3\30\1\uffff\1\30\1\uffff\4\30\1\uffff\2\30\1\uffff\6\30\1\uffff\1\30\1\uffff\3\30\1\uffff\5\30\1\uffff\1\30\1\uffff\1\30\2\uffff\4\30\1\uffff\15\30\5\uffff\2\30\6\uffff\3\30\1\uffff\4\30\1\uffff\3\30\2\uffff\1\30\2\uffff\3\30\1\uffff\1\30\1\uffff\5\30\4\uffff\4\30\2\uffff\2\30\1\uffff\1\30\1\uffff\6\30\1\uffff\6\30\1\uffff\1\30\2\uffff\1\30\5\uffff\5\30\2\uffff\1\30\1\uffff\2\30\1\uffff\3\30\3\uffff\3\30\2\uffff\3\30\1\uffff\1\30\2\uffff\2\30\1\uffff\1\30\6\uffff\1\30\1\uffff\2\30\4\uffff\1\30\4\uffff\1\30\2\uffff\3\30\2\uffff\3\30\1\uffff\1\30\1\uffff\3\30\6\uffff\3\30\7\uffff\1\30\5\uffff\1\30\4\uffff\1\30\7\uffff\1\30\1\27\1\uffff\1\30\6\uffff\1\30\1\uffff\1\30\1\uffff\2\30",
            "\1\31\2\uffff\1\31\6\uffff\1\31\2\uffff\1\31\2\uffff\1\31\3\uffff\2\31\2\uffff\1\31\5\uffff\1\31\4\uffff\3\31\4\uffff\1\31\3\uffff\3\31\1\uffff\1\31\1\uffff\4\31\1\uffff\2\31\1\uffff\6\31\1\uffff\1\31\1\uffff\3\31\1\uffff\5\31\1\uffff\1\31\1\uffff\1\31\2\uffff\4\31\1\uffff\15\31\5\uffff\2\31\6\uffff\3\31\1\uffff\4\31\1\uffff\3\31\2\uffff\1\31\2\uffff\3\31\1\uffff\1\31\1\uffff\5\31\4\uffff\4\31\2\uffff\2\31\1\uffff\1\31\1\uffff\6\31\1\uffff\6\31\1\uffff\1\31\2\uffff\1\31\5\uffff\5\31\2\uffff\1\31\1\uffff\2\31\1\uffff\3\31\3\uffff\3\31\2\uffff\3\31\1\uffff\1\31\2\uffff\2\31\1\uffff\1\31\6\uffff\1\31\1\uffff\2\31\4\uffff\1\31\4\uffff\1\31\2\uffff\3\31\2\uffff\3\31\1\uffff\1\31\1\uffff\3\31\6\uffff\3\31\7\uffff\1\31\5\uffff\1\31\4\uffff\1\31\7\uffff\1\31\2\uffff\1\31\1\uffff\1\32\4\uffff\1\31\1\uffff\1\31\1\uffff\2\31",
            "",
            "",
            "",
            "",
            "",
            "\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\25\11\uffff\1\25\50\uffff\1\25\6\uffff\1\25\1\uffff\1\25\17\uffff\1\25\1\uffff\1\25\22\uffff\1\25\11\uffff\1\25\2\uffff\1\25\2\uffff\1\25\6\uffff\1\25\2\uffff\1\25\1\uffff\1\25\10\uffff\1\25\4\uffff\1\25\1\uffff\1\25\10\uffff\4\25\3\uffff\1\25\1\uffff\1\25\1\34\5\25\1\uffff\1\25\1\uffff\4\25\1\uffff\2\25\2\uffff\1\25\11\uffff\1\25",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3857:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ( (lv_name_105_0= RULE_ID ) ) otherlv_106= Colon ( (lv_val_107_0= ruleStringTerm ) ) ) | ( () otherlv_109= Solution ( (lv_name_110_0= RULE_ID ) ) otherlv_111= Colon ( (lv_val_112_0= ruleStringTerm ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA51_27 = input.LA(1);

                         
                        int index51_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA51_27==LeftParenthesis) && (synpred10_InternalResoluteParser())) {s = 28;}

                        else if ( (LA51_27==EOF||LA51_27==Conclusion||LA51_27==Instanceof||LA51_27==Notation||LA51_27==Strategy||LA51_27==Andthen||LA51_27==Ruleset||LA51_27==Warning||LA51_27==Orelse||LA51_27==Check||LA51_27==Error||LA51_27==Prove||LA51_27==Else||LA51_27==Goal||LA51_27==Info||LA51_27==Then||LA51_27==And||LA51_27==For||(LA51_27>=LessThanSignEqualsSign && LA51_27<=GreaterThanSignEqualsSign)||LA51_27==Or||LA51_27==PercentSign||(LA51_27>=RightParenthesis && LA51_27<=HyphenMinus)||LA51_27==Solidus||(LA51_27>=Semicolon && LA51_27<=GreaterThanSign)||(LA51_27>=RightSquareBracket && LA51_27<=CircumflexAccent)||LA51_27==RightCurlyBracket||LA51_27==RULE_ID) ) {s = 21;}

                         
                        input.seek(index51_27);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\23\uffff";
    static final String dfa_9s = "\6\uffff\1\15\1\17\1\uffff\1\21\2\uffff\1\15\1\uffff\1\17\3\uffff\1\21";
    static final String dfa_10s = "\1\164\5\uffff\2\u00b2\1\uffff\1\u00b2\2\uffff\1\u00b2\1\uffff\1\u00b2\1\uffff\1\u0131\1\uffff\1\u00b2";
    static final String dfa_11s = "\1\u0131\5\uffff\2\u0131\1\uffff\1\u011e\2\uffff\1\u011e\1\uffff\1\u011e\1\uffff\1\u0131\1\uffff\1\u011e";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\6\1\uffff\1\11\1\12\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_13s = "\23\uffff}>";
    static final String[] dfa_14s = {
            "\1\3\41\uffff\1\2\37\uffff\1\4\55\uffff\1\13\30\uffff\1\13\27\uffff\1\12\2\uffff\1\10\1\uffff\1\10\7\uffff\1\1\11\uffff\1\6\1\uffff\1\7\1\uffff\1\5\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\15\126\uffff\1\10\6\uffff\1\15\5\uffff\1\15\2\uffff\1\15\4\uffff\1\15\22\uffff\1\14",
            "\1\17\126\uffff\1\10\6\uffff\1\17\5\uffff\1\17\2\uffff\1\17\4\uffff\1\17\22\uffff\1\16",
            "",
            "\1\21\126\uffff\1\10\1\20\5\uffff\1\21\5\uffff\1\21\2\uffff\1\21\4\uffff\1\21",
            "",
            "",
            "\1\15\126\uffff\1\10\6\uffff\1\15\5\uffff\1\15\2\uffff\1\15\4\uffff\1\15",
            "",
            "\1\17\126\uffff\1\10\6\uffff\1\17\5\uffff\1\17\2\uffff\1\17\4\uffff\1\17",
            "",
            "\1\22",
            "",
            "\1\21\126\uffff\1\10\6\uffff\1\21\5\uffff\1\21\2\uffff\1\21\4\uffff\1\21"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "6983:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000000L,0x0000810000000000L,0x0001000000000002L,0x0002000000000000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x0000000000000000L,0x0001000000000000L,0x0000000000020008L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x90A3BC7BECEDBF60L,0x044A640010D41100L,0x81200200981828D8L,0x02309D80FA28C510L,0x0002002400000012L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x6F5C438413124090L,0x7B8183FFEF2BEEBFL,0x3E097EFD6787D727L,0x75CE421A059738EDL,0x00035024042080E0L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000100000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002000000400000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002400000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000020000800L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0003000000000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0003000000000100L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x6F5C438413124090L,0x7B858BFFEF2BEEFFL,0x3E89FEFD67A7D727L,0x75CE421A05973AEDL,0x00035024042080E0L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000400000L,0x0000000000040000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002000000000000L,0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x90A3BC7BECEDBF60L,0x044A640010D41100L,0x81200200981828D8L,0x02309D80FA28C510L,0x0000000000000012L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000380005800L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000005000000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000010900000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x6F5C438413124090L,0x7B8183FFEF2BEEBFL,0x3E097EFD6787D727L,0x75CE421A059738EDL,0x00035024042081E0L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008200000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x6F5C438413124090L,0x7B8183FFEF2BEEBFL,0x3E097EFD6787D727L,0x75CE421A059738EDL,0x00035024046080E0L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000802000004L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000004800200000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000802000000L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008002000004L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x000000C000200000L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000008002000000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000004100000000L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0004000800000008L,0x0000008000000000L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0004000800000008L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x8000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L,0x0040000200400000L,0x2000001000000000L,0x0003500405200000L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L,0x0000000000000000L,0x0000000042010000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000042010000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002000800000000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L,0x0040000200400000L,0x2000001000000000L,0x0003500405600000L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000408000000L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000400000000000L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000800000200L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0002500005000000L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0010000000000000L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    }


}