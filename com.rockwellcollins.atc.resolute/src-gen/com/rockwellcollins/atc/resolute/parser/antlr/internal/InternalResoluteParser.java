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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Provides_subprogram_group_access", "Requires_subprogram_group_access", "Provides_subprogram_access", "Requires_subprogram_access", "Subprogram_group_access", "Error_state_reachable", "Is_virtual_processor", "Provides_data_access", "Requires_data_access", "Flow_specifications", "Is_abstract_feature", "Provides_bus_access", "Requires_bus_access", "Flow_specification", "Enumerated_values", "Subprogram_access", "Virtual_processor", "End_to_end_flows", "Flow_destination", "Is_bidirectional", "Subprogram_group", "End_to_end_flow", "Event_data_port", "Is_thread_group", "Propagate_error", "Property_member", "Has_prototypes", "Is_data_access", "Is_virtual_bus", "Contain_error", "Feature_group", "Flow_elements", "Is_bus_access", "Is_event_port", "Is_subprogram", "Justification", "Receive_error", "Subcomponents", "Has_property", "Is_data_port", "Is_processor", "Thread_group", "Connections", "Data_access", "Destination", "Flow_source", "Is_bound_to", "Is_in_array", "Lower_bound", "Undeveloped", "Upper_bound", "Virtual_bus", "Assumption", "Bus_access", "Classifier", "Connection", "Event_port", "Has_member", "Has_parent", "Instanceof", "Is_of_type", "Is_process", "Subprogram", "Component", "Data_port", "Direction", "Has_modes", "Instances", "Intersect", "Is_device", "Is_memory", "Is_system", "Is_thread", "Processor", "Reference", "Abstract", "Analysis", "Constant", "Features", "Has_type", "Instance", "Property", "Solution", "Strategy", "Andthen", "Applies", "As_list", "Binding", "Compute", "Context", "Feature", "Is_data", "Is_port", "Process", "Ruleset", "Warning", "Access", "Append", "As_set", "Device", "Exists", "Forall", "Is_bus", "Length", "Member", "Memory", "Orelse", "Parent", "Source", "String", "KW_System", "Thread", "Check", "Debug", "Delta", "Error", "False", "Modes", "Prove", "Range", "Union", "Aadl", "Bool", "Data", "Else", "Fail", "Goal", "Head", "Info", "Name", "Port", "Real", "Size", "Tail", "Then", "This", "True", "Type", "PlusSignEqualsSignGreaterThanSign", "And", "Bus", "For", "Int", "Let", "Max", "Min", "Not", "Sum", "AsteriskAsterisk", "FullStopFullStop", "ColonColon", "LessThanSignEqualsSign", "LessThanSignGreaterThanSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "If", "In", "Or", "To", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Requires_subprogram_group_access=5;
    public static final int Or=161;
    public static final int EqualsSignGreaterThanSign=157;
    public static final int Memory=109;
    public static final int Size=136;
    public static final int String=113;
    public static final int Feature=94;
    public static final int LessThanSign=174;
    public static final int Has_member=61;
    public static final int Data_port=68;
    public static final int PlusSignEqualsSignGreaterThanSign=142;
    public static final int Justification=39;
    public static final int Then=138;
    public static final int GreaterThanSign=176;
    public static final int Head=131;
    public static final int RULE_ID=192;
    public static final int Sum=151;
    public static final int GreaterThanSignEqualsSign=158;
    public static final int Flow_elements=35;
    public static final int ColonColon=154;
    public static final int Is_data=95;
    public static final int Min=149;
    public static final int Has_property=42;
    public static final int Analysis=80;
    public static final int Ruleset=98;
    public static final int Processor=77;
    public static final int Instance=84;
    public static final int RULE_REAL_LIT=187;
    public static final int Property_member=29;
    public static final int Classifier=58;
    public static final int Union=124;
    public static final int Tail=137;
    public static final int Event_port=60;
    public static final int Solidus=171;
    public static final int RightCurlyBracket=182;
    public static final int Context=93;
    public static final int Bus=144;
    public static final int FullStop=170;
    public static final int Is_thread=76;
    public static final int Has_modes=70;
    public static final int Connection=59;
    public static final int Provides_bus_access=15;
    public static final int Semicolon=173;
    public static final int RULE_EXPONENT=185;
    public static final int Append=101;
    public static final int As_list=90;
    public static final int Length=107;
    public static final int Delta=118;
    public static final int Is_virtual_processor=10;
    public static final int Flow_specifications=13;
    public static final int End_to_end_flows=21;
    public static final int Receive_error=40;
    public static final int Port=134;
    public static final int Subprogram_group=24;
    public static final int Process=97;
    public static final int Requires_subprogram_access=7;
    public static final int Name=133;
    public static final int RULE_INT_EXPONENT=186;
    public static final int Enumerated_values=18;
    public static final int FullStopFullStop=153;
    public static final int This=139;
    public static final int To=162;
    public static final int Binding=91;
    public static final int Flow_destination=22;
    public static final int Subprogram_group_access=8;
    public static final int For=145;
    public static final int RightParenthesis=165;
    public static final int Is_event_port=37;
    public static final int Not=150;
    public static final int AsteriskAsterisk=152;
    public static final int Subcomponents=41;
    public static final int Is_data_port=43;
    public static final int Subprogram=66;
    public static final int Parent=111;
    public static final int RULE_SL_COMMENT=183;
    public static final int Provides_subprogram_group_access=4;
    public static final int Bus_access=57;
    public static final int Has_parent=62;
    public static final int Aadl=125;
    public static final int Features=82;
    public static final int Colon=172;
    public static final int Component=67;
    public static final int EOF=-1;
    public static final int Asterisk=166;
    public static final int LeftCurlyBracket=180;
    public static final int Info=132;
    public static final int End_to_end_flow=25;
    public static final int Feature_group=34;
    public static final int CircumflexAccent=179;
    public static final int Flow_source=49;
    public static final int Is_thread_group=27;
    public static final int Is_system=75;
    public static final int Exists=104;
    public static final int Virtual_processor=20;
    public static final int Orelse=110;
    public static final int Connections=46;
    public static final int LessThanSignGreaterThanSign=156;
    public static final int Is_port=96;
    public static final int Data_access=47;
    public static final int KW_System=114;
    public static final int Access=100;
    public static final int Check=116;
    public static final int Provides_data_access=11;
    public static final int False=120;
    public static final int Thread_group=45;
    public static final int Goal=130;
    public static final int LeftParenthesis=164;
    public static final int Bool=126;
    public static final int Is_bus=106;
    public static final int Requires_bus_access=16;
    public static final int Fail=129;
    public static final int Is_virtual_bus=32;
    public static final int RULE_DIGIT=184;
    public static final int Has_prototypes=30;
    public static final int Is_bus_access=36;
    public static final int VerticalLine=181;
    public static final int Is_bidirectional=23;
    public static final int PlusSign=167;
    public static final int Is_data_access=31;
    public static final int LeftSquareBracket=177;
    public static final int If=159;
    public static final int Lower_bound=52;
    public static final int Is_of_type=64;
    public static final int Provides_subprogram_access=6;
    public static final int Warning=99;
    public static final int Max=148;
    public static final int In=160;
    public static final int Contain_error=33;
    public static final int Is_memory=74;
    public static final int Direction=69;
    public static final int Assumption=56;
    public static final int Comma=168;
    public static final int HyphenMinus=169;
    public static final int Requires_data_access=12;
    public static final int Is_subprogram=38;
    public static final int LessThanSignEqualsSign=155;
    public static final int Property=85;
    public static final int Solution=86;
    public static final int Prove=122;
    public static final int Modes=121;
    public static final int Reference=78;
    public static final int Abstract=79;
    public static final int Is_device=73;
    public static final int Thread=115;
    public static final int Instances=71;
    public static final int Type=141;
    public static final int Else=128;
    public static final int RULE_EXTENDED_DIGIT=190;
    public static final int Virtual_bus=55;
    public static final int True=140;
    public static final int Error_state_reachable=9;
    public static final int Undeveloped=53;
    public static final int PercentSign=163;
    public static final int Intersect=72;
    public static final int Upper_bound=54;
    public static final int Real=135;
    public static final int As_set=102;
    public static final int Applies=89;
    public static final int Forall=105;
    public static final int Member=108;
    public static final int RULE_BASED_INTEGER=188;
    public static final int RightSquareBracket=178;
    public static final int Is_in_array=51;
    public static final int Device=103;
    public static final int Range=123;
    public static final int Is_process=65;
    public static final int Is_bound_to=50;
    public static final int Andthen=88;
    public static final int And=143;
    public static final int Is_processor=44;
    public static final int RULE_INTEGER_LIT=189;
    public static final int Destination=48;
    public static final int Constant=81;
    public static final int RULE_STRING=191;
    public static final int Source=112;
    public static final int Int=146;
    public static final int Flow_specification=17;
    public static final int EqualsSign=175;
    public static final int Instanceof=63;
    public static final int Subprogram_access=19;
    public static final int Debug=117;
    public static final int Has_type=83;
    public static final int Is_abstract_feature=14;
    public static final int RULE_WS=193;
    public static final int Error=119;
    public static final int Data=127;
    public static final int Propagate_error=28;
    public static final int Event_data_port=26;
    public static final int Compute=92;
    public static final int Strategy=87;
    public static final int Let=147;

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
    // InternalResoluteParser.g:77:1: entryRuleAnnexLibrary returns [EObject current=null] : iv_ruleAnnexLibrary= ruleAnnexLibrary EOF ;
    public final EObject entryRuleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexLibrary = null;


        try {
            // InternalResoluteParser.g:77:53: (iv_ruleAnnexLibrary= ruleAnnexLibrary EOF )
            // InternalResoluteParser.g:78:2: iv_ruleAnnexLibrary= ruleAnnexLibrary EOF
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
    // InternalResoluteParser.g:84:1: ruleAnnexLibrary returns [EObject current=null] : this_ResoluteLibrary_0= ruleResoluteLibrary ;
    public final EObject ruleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject this_ResoluteLibrary_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:90:2: (this_ResoluteLibrary_0= ruleResoluteLibrary )
            // InternalResoluteParser.g:91:2: this_ResoluteLibrary_0= ruleResoluteLibrary
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
    // InternalResoluteParser.g:102:1: entryRuleResoluteLibrary returns [EObject current=null] : iv_ruleResoluteLibrary= ruleResoluteLibrary EOF ;
    public final EObject entryRuleResoluteLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResoluteLibrary = null;


        try {
            // InternalResoluteParser.g:102:56: (iv_ruleResoluteLibrary= ruleResoluteLibrary EOF )
            // InternalResoluteParser.g:103:2: iv_ruleResoluteLibrary= ruleResoluteLibrary EOF
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
    // InternalResoluteParser.g:109:1: ruleResoluteLibrary returns [EObject current=null] : ( () ( (lv_definitions_1_0= ruleDefinition ) )* ) ;
    public final EObject ruleResoluteLibrary() throws RecognitionException {
        EObject current = null;

        EObject lv_definitions_1_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:115:2: ( ( () ( (lv_definitions_1_0= ruleDefinition ) )* ) )
            // InternalResoluteParser.g:116:2: ( () ( (lv_definitions_1_0= ruleDefinition ) )* )
            {
            // InternalResoluteParser.g:116:2: ( () ( (lv_definitions_1_0= ruleDefinition ) )* )
            // InternalResoluteParser.g:117:3: () ( (lv_definitions_1_0= ruleDefinition ) )*
            {
            // InternalResoluteParser.g:117:3: ()
            // InternalResoluteParser.g:118:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getResoluteLibraryAccess().getResoluteLibraryAction_0(),
              					current);
              			
            }

            }

            // InternalResoluteParser.g:124:3: ( (lv_definitions_1_0= ruleDefinition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Strategy||LA1_0==Ruleset||LA1_0==Goal||LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalResoluteParser.g:125:4: (lv_definitions_1_0= ruleDefinition )
            	    {
            	    // InternalResoluteParser.g:125:4: (lv_definitions_1_0= ruleDefinition )
            	    // InternalResoluteParser.g:126:5: lv_definitions_1_0= ruleDefinition
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
    // InternalResoluteParser.g:147:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalResoluteParser.g:147:51: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalResoluteParser.g:148:2: iv_ruleDefinition= ruleDefinition EOF
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
    // InternalResoluteParser.g:154:1: ruleDefinition returns [EObject current=null] : (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantDefinition_0 = null;

        EObject this_FunctionDefinition_1 = null;

        EObject this_Ruleset_2 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:160:2: ( (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset ) )
            // InternalResoluteParser.g:161:2: (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset )
            {
            // InternalResoluteParser.g:161:2: (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==LeftParenthesis) ) {
                    alt2=2;
                }
                else if ( (LA2_1==Colon) ) {
                    alt2=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
                }
                break;
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
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalResoluteParser.g:162:3: this_ConstantDefinition_0= ruleConstantDefinition
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
                    // InternalResoluteParser.g:171:3: this_FunctionDefinition_1= ruleFunctionDefinition
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
                    // InternalResoluteParser.g:180:3: this_Ruleset_2= ruleRuleset
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


    // $ANTLR start "entryRuleType"
    // InternalResoluteParser.g:192:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalResoluteParser.g:192:45: (iv_ruleType= ruleType EOF )
            // InternalResoluteParser.g:193:2: iv_ruleType= ruleType EOF
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
    // InternalResoluteParser.g:199:1: ruleType returns [EObject current=null] : ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) ) ;
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
            // InternalResoluteParser.g:205:2: ( ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) ) )
            // InternalResoluteParser.g:206:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) )
            {
            // InternalResoluteParser.g:206:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt4=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt4=2;
                }
                break;
            case Provides_subprogram_group_access:
            case Requires_subprogram_group_access:
            case Provides_subprogram_access:
            case Requires_subprogram_access:
            case Subprogram_group_access:
            case Provides_data_access:
            case Requires_data_access:
            case Provides_bus_access:
            case Requires_bus_access:
            case Flow_specification:
            case Subprogram_access:
            case Virtual_processor:
            case Subprogram_group:
            case End_to_end_flow:
            case Event_data_port:
            case Feature_group:
            case Thread_group:
            case Data_access:
            case Virtual_bus:
            case Bus_access:
            case Connection:
            case Event_port:
            case Subprogram:
            case Component:
            case Data_port:
            case Processor:
            case Abstract:
            case Property:
            case Feature:
            case Process:
            case Access:
            case Device:
            case Memory:
            case String:
            case KW_System:
            case Thread:
            case Range:
            case Aadl:
            case Bool:
            case Data:
            case Port:
            case Real:
            case Bus:
            case Int:
                {
                alt4=3;
                }
                break;
            case RULE_ID:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalResoluteParser.g:207:3: ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:207:3: ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket )
                    // InternalResoluteParser.g:208:4: () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket
                    {
                    // InternalResoluteParser.g:208:4: ()
                    // InternalResoluteParser.g:209:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeAccess().getListTypeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeAccess().getLeftSquareBracketKeyword_0_1());
                      			
                    }
                    // InternalResoluteParser.g:219:4: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:220:5: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:220:5: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:221:6: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeAccess().getTypeTypeParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
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
                    // InternalResoluteParser.g:244:3: ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:244:3: ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket )
                    // InternalResoluteParser.g:245:4: () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket
                    {
                    // InternalResoluteParser.g:245:4: ()
                    // InternalResoluteParser.g:246:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeAccess().getSetTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_1_1());
                      			
                    }
                    // InternalResoluteParser.g:256:4: ( (lv_type_6_0= ruleType ) )
                    // InternalResoluteParser.g:257:5: (lv_type_6_0= ruleType )
                    {
                    // InternalResoluteParser.g:257:5: (lv_type_6_0= ruleType )
                    // InternalResoluteParser.g:258:6: lv_type_6_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeAccess().getTypeTypeParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_6);
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
                    // InternalResoluteParser.g:281:3: (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? )
                    {
                    // InternalResoluteParser.g:281:3: (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? )
                    // InternalResoluteParser.g:282:4: this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getTypeAccess().getBaseTypeParserRuleCall_2_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_7);
                    this_BaseType_8=ruleBaseType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_BaseType_8;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalResoluteParser.g:290:4: (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==LessThanSign) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalResoluteParser.g:291:5: otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign
                            {
                            otherlv_9=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_9, grammarAccess.getTypeAccess().getLessThanSignKeyword_2_1_0());
                              				
                            }
                            // InternalResoluteParser.g:295:5: ( (lv_paramType_10_0= ruleType ) )
                            // InternalResoluteParser.g:296:6: (lv_paramType_10_0= ruleType )
                            {
                            // InternalResoluteParser.g:296:6: (lv_paramType_10_0= ruleType )
                            // InternalResoluteParser.g:297:7: lv_paramType_10_0= ruleType
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getTypeAccess().getParamTypeTypeParserRuleCall_2_1_1_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_8);
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
                    // InternalResoluteParser.g:321:3: ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) )
                    {
                    // InternalResoluteParser.g:321:3: ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) )
                    // InternalResoluteParser.g:322:4: () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) )
                    {
                    // InternalResoluteParser.g:322:4: ()
                    // InternalResoluteParser.g:323:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeAccess().getLibraryFnTypeAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:329:4: ( (lv_libName_13_0= RULE_ID ) )
                    // InternalResoluteParser.g:330:5: (lv_libName_13_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:330:5: (lv_libName_13_0= RULE_ID )
                    // InternalResoluteParser.g:331:6: lv_libName_13_0= RULE_ID
                    {
                    lv_libName_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return current;
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

                    otherlv_14=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getTypeAccess().getFullStopKeyword_3_2());
                      			
                    }
                    // InternalResoluteParser.g:351:4: ( (lv_fnType_15_0= RULE_ID ) )
                    // InternalResoluteParser.g:352:5: (lv_fnType_15_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:352:5: (lv_fnType_15_0= RULE_ID )
                    // InternalResoluteParser.g:353:6: lv_fnType_15_0= RULE_ID
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
    // InternalResoluteParser.g:374:1: entryRuleBaseType returns [EObject current=null] : iv_ruleBaseType= ruleBaseType EOF ;
    public final EObject entryRuleBaseType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseType = null;


        try {
            // InternalResoluteParser.g:374:49: (iv_ruleBaseType= ruleBaseType EOF )
            // InternalResoluteParser.g:375:2: iv_ruleBaseType= ruleBaseType EOF
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
    // InternalResoluteParser.g:381:1: ruleBaseType returns [EObject current=null] : ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) ) ) ;
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


        	enterRule();

        try {
            // InternalResoluteParser.g:387:2: ( ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) ) ) )
            // InternalResoluteParser.g:388:2: ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) ) )
            {
            // InternalResoluteParser.g:388:2: ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) ) )
            // InternalResoluteParser.g:389:3: ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) )
            {
            // InternalResoluteParser.g:389:3: ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) )
            // InternalResoluteParser.g:390:4: (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow )
            {
            // InternalResoluteParser.g:390:4: (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow )
            int alt5=44;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt5=1;
                }
                break;
            case Real:
                {
                alt5=2;
                }
                break;
            case String:
                {
                alt5=3;
                }
                break;
            case Bool:
                {
                alt5=4;
                }
                break;
            case Range:
                {
                alt5=5;
                }
                break;
            case Aadl:
                {
                alt5=6;
                }
                break;
            case Component:
                {
                alt5=7;
                }
                break;
            case Abstract:
                {
                alt5=8;
                }
                break;
            case Bus:
                {
                alt5=9;
                }
                break;
            case Data:
                {
                alt5=10;
                }
                break;
            case Device:
                {
                alt5=11;
                }
                break;
            case Memory:
                {
                alt5=12;
                }
                break;
            case Processor:
                {
                alt5=13;
                }
                break;
            case Process:
                {
                alt5=14;
                }
                break;
            case Subprogram_group:
                {
                alt5=15;
                }
                break;
            case Subprogram:
                {
                alt5=16;
                }
                break;
            case KW_System:
                {
                alt5=17;
                }
                break;
            case Thread_group:
                {
                alt5=18;
                }
                break;
            case Thread:
                {
                alt5=19;
                }
                break;
            case Virtual_bus:
                {
                alt5=20;
                }
                break;
            case Virtual_processor:
                {
                alt5=21;
                }
                break;
            case Connection:
                {
                alt5=22;
                }
                break;
            case Property:
                {
                alt5=23;
                }
                break;
            case Feature:
                {
                alt5=24;
                }
                break;
            case Port:
                {
                alt5=25;
                }
                break;
            case Data_port:
                {
                alt5=26;
                }
                break;
            case Event_port:
                {
                alt5=27;
                }
                break;
            case Event_data_port:
                {
                alt5=28;
                }
                break;
            case Feature_group:
                {
                alt5=29;
                }
                break;
            case Access:
                {
                alt5=30;
                }
                break;
            case Bus_access:
                {
                alt5=31;
                }
                break;
            case Provides_bus_access:
                {
                alt5=32;
                }
                break;
            case Requires_bus_access:
                {
                alt5=33;
                }
                break;
            case Data_access:
                {
                alt5=34;
                }
                break;
            case Provides_data_access:
                {
                alt5=35;
                }
                break;
            case Requires_data_access:
                {
                alt5=36;
                }
                break;
            case Subprogram_access:
                {
                alt5=37;
                }
                break;
            case Provides_subprogram_access:
                {
                alt5=38;
                }
                break;
            case Requires_subprogram_access:
                {
                alt5=39;
                }
                break;
            case Subprogram_group_access:
                {
                alt5=40;
                }
                break;
            case Provides_subprogram_group_access:
                {
                alt5=41;
                }
                break;
            case Requires_subprogram_group_access:
                {
                alt5=42;
                }
                break;
            case Flow_specification:
                {
                alt5=43;
                }
                break;
            case End_to_end_flow:
                {
                alt5=44;
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
                    // InternalResoluteParser.g:391:5: lv_type_0_1= Int
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
                    // InternalResoluteParser.g:402:5: lv_type_0_2= Real
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
                    // InternalResoluteParser.g:413:5: lv_type_0_3= String
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
                    // InternalResoluteParser.g:424:5: lv_type_0_4= Bool
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
                    // InternalResoluteParser.g:435:5: lv_type_0_5= Range
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
                    // InternalResoluteParser.g:446:5: lv_type_0_6= Aadl
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
                    // InternalResoluteParser.g:457:5: lv_type_0_7= Component
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
                    // InternalResoluteParser.g:468:5: lv_type_0_8= Abstract
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
                    // InternalResoluteParser.g:479:5: lv_type_0_9= Bus
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
                    // InternalResoluteParser.g:490:5: lv_type_0_10= Data
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
                    // InternalResoluteParser.g:501:5: lv_type_0_11= Device
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
                    // InternalResoluteParser.g:512:5: lv_type_0_12= Memory
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
                    // InternalResoluteParser.g:523:5: lv_type_0_13= Processor
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
                    // InternalResoluteParser.g:534:5: lv_type_0_14= Process
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
                    // InternalResoluteParser.g:545:5: lv_type_0_15= Subprogram_group
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
                    // InternalResoluteParser.g:556:5: lv_type_0_16= Subprogram
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
                    // InternalResoluteParser.g:567:5: lv_type_0_17= KW_System
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
                    // InternalResoluteParser.g:578:5: lv_type_0_18= Thread_group
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
                    // InternalResoluteParser.g:589:5: lv_type_0_19= Thread
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
                    // InternalResoluteParser.g:600:5: lv_type_0_20= Virtual_bus
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
                    // InternalResoluteParser.g:611:5: lv_type_0_21= Virtual_processor
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
                    // InternalResoluteParser.g:622:5: lv_type_0_22= Connection
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
                    // InternalResoluteParser.g:633:5: lv_type_0_23= Property
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
                    // InternalResoluteParser.g:644:5: lv_type_0_24= Feature
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
                    // InternalResoluteParser.g:655:5: lv_type_0_25= Port
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
                    // InternalResoluteParser.g:666:5: lv_type_0_26= Data_port
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
                    // InternalResoluteParser.g:677:5: lv_type_0_27= Event_port
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
                    // InternalResoluteParser.g:688:5: lv_type_0_28= Event_data_port
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
                    // InternalResoluteParser.g:699:5: lv_type_0_29= Feature_group
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
                    // InternalResoluteParser.g:710:5: lv_type_0_30= Access
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
                    // InternalResoluteParser.g:721:5: lv_type_0_31= Bus_access
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
                    // InternalResoluteParser.g:732:5: lv_type_0_32= Provides_bus_access
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
                    // InternalResoluteParser.g:743:5: lv_type_0_33= Requires_bus_access
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
                    // InternalResoluteParser.g:754:5: lv_type_0_34= Data_access
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
                    // InternalResoluteParser.g:765:5: lv_type_0_35= Provides_data_access
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
                    // InternalResoluteParser.g:776:5: lv_type_0_36= Requires_data_access
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
                    // InternalResoluteParser.g:787:5: lv_type_0_37= Subprogram_access
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
                    // InternalResoluteParser.g:798:5: lv_type_0_38= Provides_subprogram_access
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
                    // InternalResoluteParser.g:809:5: lv_type_0_39= Requires_subprogram_access
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
                    // InternalResoluteParser.g:820:5: lv_type_0_40= Subprogram_group_access
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
                    // InternalResoluteParser.g:831:5: lv_type_0_41= Provides_subprogram_group_access
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
                    // InternalResoluteParser.g:842:5: lv_type_0_42= Requires_subprogram_group_access
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
                    // InternalResoluteParser.g:853:5: lv_type_0_43= Flow_specification
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
                    // InternalResoluteParser.g:864:5: lv_type_0_44= End_to_end_flow
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
    // InternalResoluteParser.g:880:1: entryRuleArg returns [EObject current=null] : iv_ruleArg= ruleArg EOF ;
    public final EObject entryRuleArg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArg = null;


        try {
            // InternalResoluteParser.g:880:44: (iv_ruleArg= ruleArg EOF )
            // InternalResoluteParser.g:881:2: iv_ruleArg= ruleArg EOF
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
    // InternalResoluteParser.g:887:1: ruleArg returns [EObject current=null] : ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) ) ;
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
            // InternalResoluteParser.g:893:2: ( ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:894:2: ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:894:2: ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (synpred1_InternalResoluteParser()) ) {
                    alt6=1;
                }
                else if ( (true) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalResoluteParser.g:895:3: ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
                    {
                    // InternalResoluteParser.g:895:3: ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
                    // InternalResoluteParser.g:896:4: ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
                    {
                    // InternalResoluteParser.g:910:4: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
                    // InternalResoluteParser.g:911:5: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) )
                    {
                    // InternalResoluteParser.g:911:5: ( (lv_name_0_0= RULE_ID ) )
                    // InternalResoluteParser.g:912:6: (lv_name_0_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:912:6: (lv_name_0_0= RULE_ID )
                    // InternalResoluteParser.g:913:7: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
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

                    otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getArgAccess().getColonKeyword_0_0_1());
                      				
                    }
                    // InternalResoluteParser.g:933:5: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:934:6: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:934:6: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:935:7: lv_type_2_0= ruleType
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
                    // InternalResoluteParser.g:955:3: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:955:3: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:956:4: () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:956:4: ()
                    // InternalResoluteParser.g:957:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getArgAccess().getQuantArgAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:963:4: ( (lv_name_4_0= RULE_ID ) )
                    // InternalResoluteParser.g:964:5: (lv_name_4_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:964:5: (lv_name_4_0= RULE_ID )
                    // InternalResoluteParser.g:965:6: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,Colon,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getArgAccess().getColonKeyword_1_2());
                      			
                    }
                    // InternalResoluteParser.g:985:4: ( (lv_expr_6_0= ruleExpr ) )
                    // InternalResoluteParser.g:986:5: (lv_expr_6_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:986:5: (lv_expr_6_0= ruleExpr )
                    // InternalResoluteParser.g:987:6: lv_expr_6_0= ruleExpr
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
    // InternalResoluteParser.g:1009:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // InternalResoluteParser.g:1009:59: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // InternalResoluteParser.g:1010:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
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
    // InternalResoluteParser.g:1016:1: ruleConstantDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleConstantDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1022:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) )
            // InternalResoluteParser.g:1023:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // InternalResoluteParser.g:1023:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            // InternalResoluteParser.g:1024:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
            {
            // InternalResoluteParser.g:1024:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:1025:4: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:1025:4: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:1026:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getConstantDefinitionAccess().getColonKeyword_1());
              		
            }
            // InternalResoluteParser.g:1046:3: ( (lv_type_2_0= ruleType ) )
            // InternalResoluteParser.g:1047:4: (lv_type_2_0= ruleType )
            {
            // InternalResoluteParser.g:1047:4: (lv_type_2_0= ruleType )
            // InternalResoluteParser.g:1048:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstantDefinitionAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_13);
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

            otherlv_3=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstantDefinitionAccess().getEqualsSignKeyword_3());
              		
            }
            // InternalResoluteParser.g:1069:3: ( (lv_expr_4_0= ruleExpr ) )
            // InternalResoluteParser.g:1070:4: (lv_expr_4_0= ruleExpr )
            {
            // InternalResoluteParser.g:1070:4: (lv_expr_4_0= ruleExpr )
            // InternalResoluteParser.g:1071:5: lv_expr_4_0= ruleExpr
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
    // InternalResoluteParser.g:1092:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalResoluteParser.g:1092:59: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalResoluteParser.g:1093:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
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
    // InternalResoluteParser.g:1099:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_claimType_0_0= ruleClaimType ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleArg ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleArg ) ) )* )? otherlv_6= RightParenthesis ( (lv_body_7_0= ruleDefinitionBody ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_claimType_0_0 = null;

        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_body_7_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1105:2: ( ( ( (lv_claimType_0_0= ruleClaimType ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleArg ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleArg ) ) )* )? otherlv_6= RightParenthesis ( (lv_body_7_0= ruleDefinitionBody ) ) ) )
            // InternalResoluteParser.g:1106:2: ( ( (lv_claimType_0_0= ruleClaimType ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleArg ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleArg ) ) )* )? otherlv_6= RightParenthesis ( (lv_body_7_0= ruleDefinitionBody ) ) )
            {
            // InternalResoluteParser.g:1106:2: ( ( (lv_claimType_0_0= ruleClaimType ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleArg ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleArg ) ) )* )? otherlv_6= RightParenthesis ( (lv_body_7_0= ruleDefinitionBody ) ) )
            // InternalResoluteParser.g:1107:3: ( (lv_claimType_0_0= ruleClaimType ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_args_3_0= ruleArg ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleArg ) ) )* )? otherlv_6= RightParenthesis ( (lv_body_7_0= ruleDefinitionBody ) )
            {
            // InternalResoluteParser.g:1107:3: ( (lv_claimType_0_0= ruleClaimType ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Strategy||LA7_0==Goal) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalResoluteParser.g:1108:4: (lv_claimType_0_0= ruleClaimType )
                    {
                    // InternalResoluteParser.g:1108:4: (lv_claimType_0_0= ruleClaimType )
                    // InternalResoluteParser.g:1109:5: lv_claimType_0_0= ruleClaimType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getClaimTypeClaimTypeParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_claimType_0_0=ruleClaimType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      					}
                      					set(
                      						current,
                      						"claimType",
                      						lv_claimType_0_0,
                      						"com.rockwellcollins.atc.resolute.Resolute.ClaimType");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalResoluteParser.g:1126:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:1127:4: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:1127:4: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:1128:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.osate.xtext.aadl2.properties.Properties.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalResoluteParser.g:1148:3: ( ( (lv_args_3_0= ruleArg ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleArg ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalResoluteParser.g:1149:4: ( (lv_args_3_0= ruleArg ) ) (otherlv_4= Comma ( (lv_args_5_0= ruleArg ) ) )*
                    {
                    // InternalResoluteParser.g:1149:4: ( (lv_args_3_0= ruleArg ) )
                    // InternalResoluteParser.g:1150:5: (lv_args_3_0= ruleArg )
                    {
                    // InternalResoluteParser.g:1150:5: (lv_args_3_0= ruleArg )
                    // InternalResoluteParser.g:1151:6: lv_args_3_0= ruleArg
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getArgsArgParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_args_3_0=ruleArg();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						add(
                      							current,
                      							"args",
                      							lv_args_3_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.Arg");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalResoluteParser.g:1168:4: (otherlv_4= Comma ( (lv_args_5_0= ruleArg ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==Comma) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1169:5: otherlv_4= Comma ( (lv_args_5_0= ruleArg ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalResoluteParser.g:1173:5: ( (lv_args_5_0= ruleArg ) )
                    	    // InternalResoluteParser.g:1174:6: (lv_args_5_0= ruleArg )
                    	    {
                    	    // InternalResoluteParser.g:1174:6: (lv_args_5_0= ruleArg )
                    	    // InternalResoluteParser.g:1175:7: lv_args_5_0= ruleArg
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getArgsArgParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_16);
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


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalResoluteParser.g:1198:3: ( (lv_body_7_0= ruleDefinitionBody ) )
            // InternalResoluteParser.g:1199:4: (lv_body_7_0= ruleDefinitionBody )
            {
            // InternalResoluteParser.g:1199:4: (lv_body_7_0= ruleDefinitionBody )
            // InternalResoluteParser.g:1200:5: lv_body_7_0= ruleDefinitionBody
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBodyDefinitionBodyParserRuleCall_5_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_body_7_0=ruleDefinitionBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_7_0,
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


    // $ANTLR start "entryRuleClaimType"
    // InternalResoluteParser.g:1221:1: entryRuleClaimType returns [String current=null] : iv_ruleClaimType= ruleClaimType EOF ;
    public final String entryRuleClaimType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleClaimType = null;


        try {
            // InternalResoluteParser.g:1221:49: (iv_ruleClaimType= ruleClaimType EOF )
            // InternalResoluteParser.g:1222:2: iv_ruleClaimType= ruleClaimType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimType=ruleClaimType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimType.getText(); 
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
    // $ANTLR end "entryRuleClaimType"


    // $ANTLR start "ruleClaimType"
    // InternalResoluteParser.g:1228:1: ruleClaimType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Strategy ) ;
    public final AntlrDatatypeRuleToken ruleClaimType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:1234:2: ( (kw= Goal | kw= Strategy ) )
            // InternalResoluteParser.g:1235:2: (kw= Goal | kw= Strategy )
            {
            // InternalResoluteParser.g:1235:2: (kw= Goal | kw= Strategy )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Goal) ) {
                alt10=1;
            }
            else if ( (LA10_0==Strategy) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalResoluteParser.g:1236:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getClaimTypeAccess().getGoalKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:1242:3: kw= Strategy
                    {
                    kw=(Token)match(input,Strategy,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getClaimTypeAccess().getStrategyKeyword_1());
                      		
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
    // $ANTLR end "ruleClaimType"


    // $ANTLR start "entryRuleDefinitionBody"
    // InternalResoluteParser.g:1251:1: entryRuleDefinitionBody returns [EObject current=null] : iv_ruleDefinitionBody= ruleDefinitionBody EOF ;
    public final EObject entryRuleDefinitionBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionBody = null;


        try {
            // InternalResoluteParser.g:1251:55: (iv_ruleDefinitionBody= ruleDefinitionBody EOF )
            // InternalResoluteParser.g:1252:2: iv_ruleDefinitionBody= ruleDefinitionBody EOF
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
    // InternalResoluteParser.g:1258:1: ruleDefinitionBody returns [EObject current=null] : ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) ) ;
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
            // InternalResoluteParser.g:1264:2: ( ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:1265:2: ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:1265:2: ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) )
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
                    // InternalResoluteParser.g:1266:3: ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1266:3: ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1267:4: () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1267:4: ()
                    // InternalResoluteParser.g:1268:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDefinitionBodyAccess().getFunctionBodyAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDefinitionBodyAccess().getColonKeyword_0_1());
                      			
                    }
                    // InternalResoluteParser.g:1278:4: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:1279:5: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:1279:5: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:1280:6: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDefinitionBodyAccess().getTypeTypeParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
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

                    otherlv_3=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getDefinitionBodyAccess().getEqualsSignKeyword_0_3());
                      			
                    }
                    // InternalResoluteParser.g:1301:4: ( (lv_expr_4_0= ruleExpr ) )
                    // InternalResoluteParser.g:1302:5: (lv_expr_4_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1302:5: (lv_expr_4_0= ruleExpr )
                    // InternalResoluteParser.g:1303:6: lv_expr_4_0= ruleExpr
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
                    // InternalResoluteParser.g:1322:3: ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1322:3: ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1323:4: () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1323:4: ()
                    // InternalResoluteParser.g:1324:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getDefinitionBodyAccess().getClaimBodyAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_6=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getDefinitionBodyAccess().getLessThanSignEqualsSignKeyword_1_1());
                      			
                    }
                    // InternalResoluteParser.g:1334:4: (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk )
                    // InternalResoluteParser.g:1335:5: otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk
                    {
                    otherlv_7=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getDefinitionBodyAccess().getAsteriskAsteriskKeyword_1_2_0());
                      				
                    }
                    // InternalResoluteParser.g:1339:5: ( (lv_claim_8_0= ruleClaimText ) )+
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
                    	    // InternalResoluteParser.g:1340:6: (lv_claim_8_0= ruleClaimText )
                    	    {
                    	    // InternalResoluteParser.g:1340:6: (lv_claim_8_0= ruleClaimText )
                    	    // InternalResoluteParser.g:1341:7: lv_claim_8_0= ruleClaimText
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getDefinitionBodyAccess().getClaimClaimTextParserRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_20);
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

                    otherlv_9=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_9, grammarAccess.getDefinitionBodyAccess().getAsteriskAsteriskKeyword_1_2_2());
                      				
                    }

                    }

                    // InternalResoluteParser.g:1363:4: ( (lv_attributes_10_0= ruleClaimAttribute ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Justification||LA12_0==Assumption||LA12_0==Strategy||LA12_0==Context) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1364:5: (lv_attributes_10_0= ruleClaimAttribute )
                    	    {
                    	    // InternalResoluteParser.g:1364:5: (lv_attributes_10_0= ruleClaimAttribute )
                    	    // InternalResoluteParser.g:1365:6: lv_attributes_10_0= ruleClaimAttribute
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getDefinitionBodyAccess().getAttributesClaimAttributeParserRuleCall_1_3_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_21);
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

                    // InternalResoluteParser.g:1382:4: ( (lv_expr_11_0= ruleExpr ) )
                    // InternalResoluteParser.g:1383:5: (lv_expr_11_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1383:5: (lv_expr_11_0= ruleExpr )
                    // InternalResoluteParser.g:1384:6: lv_expr_11_0= ruleExpr
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
    // InternalResoluteParser.g:1406:1: entryRuleClaimAttribute returns [EObject current=null] : iv_ruleClaimAttribute= ruleClaimAttribute EOF ;
    public final EObject entryRuleClaimAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimAttribute = null;


        try {
            // InternalResoluteParser.g:1406:55: (iv_ruleClaimAttribute= ruleClaimAttribute EOF )
            // InternalResoluteParser.g:1407:2: iv_ruleClaimAttribute= ruleClaimAttribute EOF
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
    // InternalResoluteParser.g:1413:1: ruleClaimAttribute returns [EObject current=null] : (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy ) ;
    public final EObject ruleClaimAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_ClaimContext_0 = null;

        EObject this_ClaimJustification_1 = null;

        EObject this_ClaimAssumption_2 = null;

        EObject this_ClaimStrategy_3 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1419:2: ( (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy ) )
            // InternalResoluteParser.g:1420:2: (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy )
            {
            // InternalResoluteParser.g:1420:2: (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy )
            int alt14=4;
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
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalResoluteParser.g:1421:3: this_ClaimContext_0= ruleClaimContext
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
                    // InternalResoluteParser.g:1430:3: this_ClaimJustification_1= ruleClaimJustification
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
                    // InternalResoluteParser.g:1439:3: this_ClaimAssumption_2= ruleClaimAssumption
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
                    // InternalResoluteParser.g:1448:3: this_ClaimStrategy_3= ruleClaimStrategy
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
    // InternalResoluteParser.g:1460:1: entryRuleClaimContext returns [EObject current=null] : iv_ruleClaimContext= ruleClaimContext EOF ;
    public final EObject entryRuleClaimContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimContext = null;


        try {
            // InternalResoluteParser.g:1460:53: (iv_ruleClaimContext= ruleClaimContext EOF )
            // InternalResoluteParser.g:1461:2: iv_ruleClaimContext= ruleClaimContext EOF
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
    // InternalResoluteParser.g:1467:1: ruleClaimContext returns [EObject current=null] : (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1473:2: ( (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:1474:2: (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:1474:2: (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:1475:3: otherlv_0= Context ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Context,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClaimContextAccess().getContextKeyword_0());
              		
            }
            // InternalResoluteParser.g:1479:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalResoluteParser.g:1480:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1480:4: (lv_name_1_0= RULE_ID )
                    // InternalResoluteParser.g:1481:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
                    break;

            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getClaimContextAccess().getColonKeyword_2());
              		
            }
            // InternalResoluteParser.g:1501:3: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:1502:4: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:1502:4: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:1503:5: lv_expr_3_0= ruleExpr
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getClaimContextAccess().getExprExprParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_23);
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


    // $ANTLR start "entryRuleClaimJustification"
    // InternalResoluteParser.g:1528:1: entryRuleClaimJustification returns [EObject current=null] : iv_ruleClaimJustification= ruleClaimJustification EOF ;
    public final EObject entryRuleClaimJustification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimJustification = null;


        try {
            // InternalResoluteParser.g:1528:59: (iv_ruleClaimJustification= ruleClaimJustification EOF )
            // InternalResoluteParser.g:1529:2: iv_ruleClaimJustification= ruleClaimJustification EOF
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
    // InternalResoluteParser.g:1535:1: ruleClaimJustification returns [EObject current=null] : (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimJustification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1541:2: ( (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:1542:2: (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:1542:2: (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:1543:3: otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Justification,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClaimJustificationAccess().getJustificationKeyword_0());
              		
            }
            // InternalResoluteParser.g:1547:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalResoluteParser.g:1548:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1548:4: (lv_name_1_0= RULE_ID )
                    // InternalResoluteParser.g:1549:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
                    break;

            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getClaimJustificationAccess().getColonKeyword_2());
              		
            }
            // InternalResoluteParser.g:1569:3: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:1570:4: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:1570:4: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:1571:5: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getClaimJustificationAccess().getValStringTermParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_23);
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
    // InternalResoluteParser.g:1596:1: entryRuleClaimAssumption returns [EObject current=null] : iv_ruleClaimAssumption= ruleClaimAssumption EOF ;
    public final EObject entryRuleClaimAssumption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimAssumption = null;


        try {
            // InternalResoluteParser.g:1596:56: (iv_ruleClaimAssumption= ruleClaimAssumption EOF )
            // InternalResoluteParser.g:1597:2: iv_ruleClaimAssumption= ruleClaimAssumption EOF
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
    // InternalResoluteParser.g:1603:1: ruleClaimAssumption returns [EObject current=null] : (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimAssumption() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1609:2: ( (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:1610:2: (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:1610:2: (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:1611:3: otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Assumption,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClaimAssumptionAccess().getAssumptionKeyword_0());
              		
            }
            // InternalResoluteParser.g:1615:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalResoluteParser.g:1616:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1616:4: (lv_name_1_0= RULE_ID )
                    // InternalResoluteParser.g:1617:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
                    break;

            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getClaimAssumptionAccess().getColonKeyword_2());
              		
            }
            // InternalResoluteParser.g:1637:3: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:1638:4: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:1638:4: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:1639:5: lv_expr_3_0= ruleExpr
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getClaimAssumptionAccess().getExprExprParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_23);
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
    // InternalResoluteParser.g:1664:1: entryRuleClaimStrategy returns [EObject current=null] : iv_ruleClaimStrategy= ruleClaimStrategy EOF ;
    public final EObject entryRuleClaimStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimStrategy = null;


        try {
            // InternalResoluteParser.g:1664:54: (iv_ruleClaimStrategy= ruleClaimStrategy EOF )
            // InternalResoluteParser.g:1665:2: iv_ruleClaimStrategy= ruleClaimStrategy EOF
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
    // InternalResoluteParser.g:1671:1: ruleClaimStrategy returns [EObject current=null] : (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1677:2: ( (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:1678:2: (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:1678:2: (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:1679:3: otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) )? otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Strategy,FollowSets000.FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClaimStrategyAccess().getStrategyKeyword_0());
              		
            }
            // InternalResoluteParser.g:1683:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalResoluteParser.g:1684:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1684:4: (lv_name_1_0= RULE_ID )
                    // InternalResoluteParser.g:1685:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
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
                    break;

            }

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getClaimStrategyAccess().getColonKeyword_2());
              		
            }
            // InternalResoluteParser.g:1705:3: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:1706:4: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:1706:4: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:1707:5: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getClaimStrategyAccess().getValStringTermParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_23);
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
    // InternalResoluteParser.g:1732:1: entryRuleClaimText returns [EObject current=null] : iv_ruleClaimText= ruleClaimText EOF ;
    public final EObject entryRuleClaimText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimText = null;


        try {
            // InternalResoluteParser.g:1732:50: (iv_ruleClaimText= ruleClaimText EOF )
            // InternalResoluteParser.g:1733:2: iv_ruleClaimText= ruleClaimText EOF
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
    // InternalResoluteParser.g:1739:1: ruleClaimText returns [EObject current=null] : ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) ) ;
    public final EObject ruleClaimText() throws RecognitionException {
        EObject current = null;

        Token lv_str_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:1745:2: ( ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) ) )
            // InternalResoluteParser.g:1746:2: ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) )
            {
            // InternalResoluteParser.g:1746:2: ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_STRING) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ID) ) {
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
                    // InternalResoluteParser.g:1747:3: ( () ( (lv_str_1_0= RULE_STRING ) ) )
                    {
                    // InternalResoluteParser.g:1747:3: ( () ( (lv_str_1_0= RULE_STRING ) ) )
                    // InternalResoluteParser.g:1748:4: () ( (lv_str_1_0= RULE_STRING ) )
                    {
                    // InternalResoluteParser.g:1748:4: ()
                    // InternalResoluteParser.g:1749:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getClaimTextAccess().getClaimStringAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:1755:4: ( (lv_str_1_0= RULE_STRING ) )
                    // InternalResoluteParser.g:1756:5: (lv_str_1_0= RULE_STRING )
                    {
                    // InternalResoluteParser.g:1756:5: (lv_str_1_0= RULE_STRING )
                    // InternalResoluteParser.g:1757:6: lv_str_1_0= RULE_STRING
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
                    // InternalResoluteParser.g:1775:3: ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? )
                    {
                    // InternalResoluteParser.g:1775:3: ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? )
                    // InternalResoluteParser.g:1776:4: () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )?
                    {
                    // InternalResoluteParser.g:1776:4: ()
                    // InternalResoluteParser.g:1777:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getClaimTextAccess().getClaimArgAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:1783:4: ( (otherlv_3= RULE_ID ) )
                    // InternalResoluteParser.g:1784:5: (otherlv_3= RULE_ID )
                    {
                    // InternalResoluteParser.g:1784:5: (otherlv_3= RULE_ID )
                    // InternalResoluteParser.g:1785:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClaimTextRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getClaimTextAccess().getArgClaimTextVarCrossReference_1_1_0());
                      					
                    }

                    }


                    }

                    // InternalResoluteParser.g:1796:4: (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==PercentSign) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalResoluteParser.g:1797:5: otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,PercentSign,FollowSets000.FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getClaimTextAccess().getPercentSignKeyword_1_2_0());
                              				
                            }
                            // InternalResoluteParser.g:1801:5: ( (otherlv_5= RULE_ID ) )
                            // InternalResoluteParser.g:1802:6: (otherlv_5= RULE_ID )
                            {
                            // InternalResoluteParser.g:1802:6: (otherlv_5= RULE_ID )
                            // InternalResoluteParser.g:1803:7: otherlv_5= RULE_ID
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
    // InternalResoluteParser.g:1820:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // InternalResoluteParser.g:1820:45: (iv_ruleExpr= ruleExpr EOF )
            // InternalResoluteParser.g:1821:2: iv_ruleExpr= ruleExpr EOF
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
    // InternalResoluteParser.g:1827:1: ruleExpr returns [EObject current=null] : this_ImpliesExpr_0= ruleImpliesExpr ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesExpr_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1833:2: (this_ImpliesExpr_0= ruleImpliesExpr )
            // InternalResoluteParser.g:1834:2: this_ImpliesExpr_0= ruleImpliesExpr
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
    // InternalResoluteParser.g:1845:1: entryRuleImpliesExpr returns [EObject current=null] : iv_ruleImpliesExpr= ruleImpliesExpr EOF ;
    public final EObject entryRuleImpliesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpr = null;


        try {
            // InternalResoluteParser.g:1845:52: (iv_ruleImpliesExpr= ruleImpliesExpr EOF )
            // InternalResoluteParser.g:1846:2: iv_ruleImpliesExpr= ruleImpliesExpr EOF
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
    // InternalResoluteParser.g:1852:1: ruleImpliesExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) ;
    public final EObject ruleImpliesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_OrExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1858:2: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) )
            // InternalResoluteParser.g:1859:2: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            {
            // InternalResoluteParser.g:1859:2: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            // InternalResoluteParser.g:1860:3: this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getImpliesExprAccess().getOrExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_26);
            this_OrExpr_0=ruleOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_OrExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalResoluteParser.g:1868:3: ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==EqualsSignGreaterThanSign) ) {
                int LA21_1 = input.LA(2);

                if ( (synpred2_InternalResoluteParser()) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalResoluteParser.g:1869:4: ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) )
                    {
                    // InternalResoluteParser.g:1869:4: ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) )
                    // InternalResoluteParser.g:1870:5: ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) )
                    {
                    // InternalResoluteParser.g:1880:5: ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) )
                    // InternalResoluteParser.g:1881:6: () ( (lv_op_2_0= EqualsSignGreaterThanSign ) )
                    {
                    // InternalResoluteParser.g:1881:6: ()
                    // InternalResoluteParser.g:1882:7: 
                    {
                    if ( state.backtracking==0 ) {

                      							current = forceCreateModelElementAndSet(
                      								grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                      								current);
                      						
                    }

                    }

                    // InternalResoluteParser.g:1888:6: ( (lv_op_2_0= EqualsSignGreaterThanSign ) )
                    // InternalResoluteParser.g:1889:7: (lv_op_2_0= EqualsSignGreaterThanSign )
                    {
                    // InternalResoluteParser.g:1889:7: (lv_op_2_0= EqualsSignGreaterThanSign )
                    // InternalResoluteParser.g:1890:8: lv_op_2_0= EqualsSignGreaterThanSign
                    {
                    lv_op_2_0=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_12); if (state.failed) return current;
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

                    // InternalResoluteParser.g:1904:4: ( (lv_right_3_0= ruleImpliesExpr ) )
                    // InternalResoluteParser.g:1905:5: (lv_right_3_0= ruleImpliesExpr )
                    {
                    // InternalResoluteParser.g:1905:5: (lv_right_3_0= ruleImpliesExpr )
                    // InternalResoluteParser.g:1906:6: lv_right_3_0= ruleImpliesExpr
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
    // InternalResoluteParser.g:1928:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // InternalResoluteParser.g:1928:47: (iv_ruleOrExpr= ruleOrExpr EOF )
            // InternalResoluteParser.g:1929:2: iv_ruleOrExpr= ruleOrExpr EOF
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
    // InternalResoluteParser.g:1935:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:1941:2: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* ) )
            // InternalResoluteParser.g:1942:2: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* )
            {
            // InternalResoluteParser.g:1942:2: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* )
            // InternalResoluteParser.g:1943:3: this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrExprAccess().getAndExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_27);
            this_AndExpr_0=ruleAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalResoluteParser.g:1951:3: ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==Or) ) {
                    int LA23_2 = input.LA(2);

                    if ( (synpred3_InternalResoluteParser()) ) {
                        alt23=1;
                    }


                }
                else if ( (LA23_0==Orelse) ) {
                    int LA23_3 = input.LA(2);

                    if ( (synpred3_InternalResoluteParser()) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // InternalResoluteParser.g:1952:4: ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) )
            	    {
            	    // InternalResoluteParser.g:1952:4: ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) )
            	    // InternalResoluteParser.g:1953:5: ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) )
            	    {
            	    // InternalResoluteParser.g:1971:5: ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) )
            	    // InternalResoluteParser.g:1972:6: () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) )
            	    {
            	    // InternalResoluteParser.g:1972:6: ()
            	    // InternalResoluteParser.g:1973:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalResoluteParser.g:1979:6: ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==Or) ) {
            	        alt22=1;
            	    }
            	    else if ( (LA22_0==Orelse) ) {
            	        alt22=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // InternalResoluteParser.g:1980:7: ( (lv_op_2_0= Or ) )
            	            {
            	            // InternalResoluteParser.g:1980:7: ( (lv_op_2_0= Or ) )
            	            // InternalResoluteParser.g:1981:8: (lv_op_2_0= Or )
            	            {
            	            // InternalResoluteParser.g:1981:8: (lv_op_2_0= Or )
            	            // InternalResoluteParser.g:1982:9: lv_op_2_0= Or
            	            {
            	            lv_op_2_0=(Token)match(input,Or,FollowSets000.FOLLOW_12); if (state.failed) return current;
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
            	            // InternalResoluteParser.g:1995:7: ( (lv_op_3_0= Orelse ) )
            	            {
            	            // InternalResoluteParser.g:1995:7: ( (lv_op_3_0= Orelse ) )
            	            // InternalResoluteParser.g:1996:8: (lv_op_3_0= Orelse )
            	            {
            	            // InternalResoluteParser.g:1996:8: (lv_op_3_0= Orelse )
            	            // InternalResoluteParser.g:1997:9: lv_op_3_0= Orelse
            	            {
            	            lv_op_3_0=(Token)match(input,Orelse,FollowSets000.FOLLOW_12); if (state.failed) return current;
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

            	    // InternalResoluteParser.g:2012:4: ( (lv_right_4_0= ruleAndExpr ) )
            	    // InternalResoluteParser.g:2013:5: (lv_right_4_0= ruleAndExpr )
            	    {
            	    // InternalResoluteParser.g:2013:5: (lv_right_4_0= ruleAndExpr )
            	    // InternalResoluteParser.g:2014:6: lv_right_4_0= ruleAndExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExprAccess().getRightAndExprParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_27);
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
            	    break loop23;
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
    // InternalResoluteParser.g:2036:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // InternalResoluteParser.g:2036:48: (iv_ruleAndExpr= ruleAndExpr EOF )
            // InternalResoluteParser.g:2037:2: iv_ruleAndExpr= ruleAndExpr EOF
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
    // InternalResoluteParser.g:2043:1: ruleAndExpr returns [EObject current=null] : (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_InstanceOfExpr_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:2049:2: ( (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* ) )
            // InternalResoluteParser.g:2050:2: (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* )
            {
            // InternalResoluteParser.g:2050:2: (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* )
            // InternalResoluteParser.g:2051:3: this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExprAccess().getInstanceOfExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_28);
            this_InstanceOfExpr_0=ruleInstanceOfExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InstanceOfExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalResoluteParser.g:2059:3: ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==And) ) {
                    int LA25_2 = input.LA(2);

                    if ( (synpred4_InternalResoluteParser()) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==Andthen) ) {
                    int LA25_3 = input.LA(2);

                    if ( (synpred4_InternalResoluteParser()) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // InternalResoluteParser.g:2060:4: ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) )
            	    {
            	    // InternalResoluteParser.g:2060:4: ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) )
            	    // InternalResoluteParser.g:2061:5: ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2079:5: ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) )
            	    // InternalResoluteParser.g:2080:6: () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) )
            	    {
            	    // InternalResoluteParser.g:2080:6: ()
            	    // InternalResoluteParser.g:2081:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalResoluteParser.g:2087:6: ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==And) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==Andthen) ) {
            	        alt24=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // InternalResoluteParser.g:2088:7: ( (lv_op_2_0= And ) )
            	            {
            	            // InternalResoluteParser.g:2088:7: ( (lv_op_2_0= And ) )
            	            // InternalResoluteParser.g:2089:8: (lv_op_2_0= And )
            	            {
            	            // InternalResoluteParser.g:2089:8: (lv_op_2_0= And )
            	            // InternalResoluteParser.g:2090:9: lv_op_2_0= And
            	            {
            	            lv_op_2_0=(Token)match(input,And,FollowSets000.FOLLOW_12); if (state.failed) return current;
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
            	            // InternalResoluteParser.g:2103:7: ( (lv_op_3_0= Andthen ) )
            	            {
            	            // InternalResoluteParser.g:2103:7: ( (lv_op_3_0= Andthen ) )
            	            // InternalResoluteParser.g:2104:8: (lv_op_3_0= Andthen )
            	            {
            	            // InternalResoluteParser.g:2104:8: (lv_op_3_0= Andthen )
            	            // InternalResoluteParser.g:2105:9: lv_op_3_0= Andthen
            	            {
            	            lv_op_3_0=(Token)match(input,Andthen,FollowSets000.FOLLOW_12); if (state.failed) return current;
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

            	    // InternalResoluteParser.g:2120:4: ( (lv_right_4_0= ruleInstanceOfExpr ) )
            	    // InternalResoluteParser.g:2121:5: (lv_right_4_0= ruleInstanceOfExpr )
            	    {
            	    // InternalResoluteParser.g:2121:5: (lv_right_4_0= ruleInstanceOfExpr )
            	    // InternalResoluteParser.g:2122:6: lv_right_4_0= ruleInstanceOfExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExprAccess().getRightInstanceOfExprParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_28);
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
            	    break loop25;
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
    // InternalResoluteParser.g:2144:1: entryRuleInstanceOfExpr returns [EObject current=null] : iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF ;
    public final EObject entryRuleInstanceOfExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceOfExpr = null;


        try {
            // InternalResoluteParser.g:2144:55: (iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF )
            // InternalResoluteParser.g:2145:2: iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF
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
    // InternalResoluteParser.g:2151:1: ruleInstanceOfExpr returns [EObject current=null] : (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? ) ;
    public final EObject ruleInstanceOfExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RelationalExpr_0 = null;

        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:2157:2: ( (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? ) )
            // InternalResoluteParser.g:2158:2: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? )
            {
            // InternalResoluteParser.g:2158:2: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? )
            // InternalResoluteParser.g:2159:3: this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getInstanceOfExprAccess().getRelationalExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_29);
            this_RelationalExpr_0=ruleRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalResoluteParser.g:2167:3: ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Instanceof) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred5_InternalResoluteParser()) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // InternalResoluteParser.g:2168:4: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) )
                    {
                    // InternalResoluteParser.g:2168:4: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) )
                    // InternalResoluteParser.g:2169:5: ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof )
                    {
                    // InternalResoluteParser.g:2175:5: ( () otherlv_2= Instanceof )
                    // InternalResoluteParser.g:2176:6: () otherlv_2= Instanceof
                    {
                    // InternalResoluteParser.g:2176:6: ()
                    // InternalResoluteParser.g:2177:7: 
                    {
                    if ( state.backtracking==0 ) {

                      							current = forceCreateModelElementAndSet(
                      								grammarAccess.getInstanceOfExprAccess().getInstanceOfExprExprAction_1_0_0_0(),
                      								current);
                      						
                    }

                    }

                    otherlv_2=(Token)match(input,Instanceof,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_2, grammarAccess.getInstanceOfExprAccess().getInstanceofKeyword_1_0_0_1());
                      					
                    }

                    }


                    }

                    // InternalResoluteParser.g:2189:4: ( (lv_type_3_0= ruleBaseType ) )
                    // InternalResoluteParser.g:2190:5: (lv_type_3_0= ruleBaseType )
                    {
                    // InternalResoluteParser.g:2190:5: (lv_type_3_0= ruleBaseType )
                    // InternalResoluteParser.g:2191:6: lv_type_3_0= ruleBaseType
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
    // InternalResoluteParser.g:2213:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // InternalResoluteParser.g:2213:52: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // InternalResoluteParser.g:2214:2: iv_ruleRelationalOp= ruleRelationalOp EOF
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
    // InternalResoluteParser.g:2220:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:2226:2: ( (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign ) )
            // InternalResoluteParser.g:2227:2: (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign )
            {
            // InternalResoluteParser.g:2227:2: (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign )
            int alt27=6;
            switch ( input.LA(1) ) {
            case LessThanSign:
                {
                alt27=1;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt27=2;
                }
                break;
            case GreaterThanSign:
                {
                alt27=3;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt27=4;
                }
                break;
            case EqualsSign:
                {
                alt27=5;
                }
                break;
            case LessThanSignGreaterThanSign:
                {
                alt27=6;
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
                    // InternalResoluteParser.g:2228:3: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:2234:3: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:2240:3: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:2246:3: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:2252:3: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:2258:3: kw= LessThanSignGreaterThanSign
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
    // InternalResoluteParser.g:2267:1: entryRuleRelationalExpr returns [EObject current=null] : iv_ruleRelationalExpr= ruleRelationalExpr EOF ;
    public final EObject entryRuleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpr = null;


        try {
            // InternalResoluteParser.g:2267:55: (iv_ruleRelationalExpr= ruleRelationalExpr EOF )
            // InternalResoluteParser.g:2268:2: iv_ruleRelationalExpr= ruleRelationalExpr EOF
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
    // InternalResoluteParser.g:2274:1: ruleRelationalExpr returns [EObject current=null] : (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) ;
    public final EObject ruleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PlusExpr_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:2280:2: ( (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) )
            // InternalResoluteParser.g:2281:2: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            {
            // InternalResoluteParser.g:2281:2: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            // InternalResoluteParser.g:2282:3: this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExprAccess().getPlusExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_31);
            this_PlusExpr_0=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PlusExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalResoluteParser.g:2290:3: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            int alt28=2;
            switch ( input.LA(1) ) {
                case LessThanSign:
                    {
                    int LA28_1 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt28=1;
                    }
                    }
                    break;
                case LessThanSignEqualsSign:
                    {
                    int LA28_2 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt28=1;
                    }
                    }
                    break;
                case GreaterThanSign:
                    {
                    int LA28_3 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt28=1;
                    }
                    }
                    break;
                case GreaterThanSignEqualsSign:
                    {
                    int LA28_4 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt28=1;
                    }
                    }
                    break;
                case EqualsSign:
                    {
                    int LA28_5 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt28=1;
                    }
                    }
                    break;
                case LessThanSignGreaterThanSign:
                    {
                    int LA28_6 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt28=1;
                    }
                    }
                    break;
            }

            switch (alt28) {
                case 1 :
                    // InternalResoluteParser.g:2291:4: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) )
                    {
                    // InternalResoluteParser.g:2291:4: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) )
                    // InternalResoluteParser.g:2292:5: ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    {
                    // InternalResoluteParser.g:2302:5: ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    // InternalResoluteParser.g:2303:6: () ( (lv_op_2_0= ruleRelationalOp ) )
                    {
                    // InternalResoluteParser.g:2303:6: ()
                    // InternalResoluteParser.g:2304:7: 
                    {
                    if ( state.backtracking==0 ) {

                      							current = forceCreateModelElementAndSet(
                      								grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                      								current);
                      						
                    }

                    }

                    // InternalResoluteParser.g:2310:6: ( (lv_op_2_0= ruleRelationalOp ) )
                    // InternalResoluteParser.g:2311:7: (lv_op_2_0= ruleRelationalOp )
                    {
                    // InternalResoluteParser.g:2311:7: (lv_op_2_0= ruleRelationalOp )
                    // InternalResoluteParser.g:2312:8: lv_op_2_0= ruleRelationalOp
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getRelationalExprAccess().getOpRelationalOpParserRuleCall_1_0_0_1_0());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
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

                    // InternalResoluteParser.g:2331:4: ( (lv_right_3_0= rulePlusExpr ) )
                    // InternalResoluteParser.g:2332:5: (lv_right_3_0= rulePlusExpr )
                    {
                    // InternalResoluteParser.g:2332:5: (lv_right_3_0= rulePlusExpr )
                    // InternalResoluteParser.g:2333:6: lv_right_3_0= rulePlusExpr
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
    // InternalResoluteParser.g:2355:1: entryRulePlusExpr returns [EObject current=null] : iv_rulePlusExpr= rulePlusExpr EOF ;
    public final EObject entryRulePlusExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusExpr = null;


        try {
            // InternalResoluteParser.g:2355:49: (iv_rulePlusExpr= rulePlusExpr EOF )
            // InternalResoluteParser.g:2356:2: iv_rulePlusExpr= rulePlusExpr EOF
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
    // InternalResoluteParser.g:2362:1: rulePlusExpr returns [EObject current=null] : (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* ) ;
    public final EObject rulePlusExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_TimesExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:2368:2: ( (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* ) )
            // InternalResoluteParser.g:2369:2: (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* )
            {
            // InternalResoluteParser.g:2369:2: (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* )
            // InternalResoluteParser.g:2370:3: this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPlusExprAccess().getTimesExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_32);
            this_TimesExpr_0=ruleTimesExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_TimesExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalResoluteParser.g:2378:3: ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==PlusSign) ) {
                    int LA30_2 = input.LA(2);

                    if ( (synpred7_InternalResoluteParser()) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==HyphenMinus) ) {
                    int LA30_3 = input.LA(2);

                    if ( (synpred7_InternalResoluteParser()) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // InternalResoluteParser.g:2379:4: ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) )
            	    {
            	    // InternalResoluteParser.g:2379:4: ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) )
            	    // InternalResoluteParser.g:2380:5: ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2394:5: ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) )
            	    // InternalResoluteParser.g:2395:6: () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    {
            	    // InternalResoluteParser.g:2395:6: ()
            	    // InternalResoluteParser.g:2396:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPlusExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalResoluteParser.g:2402:6: ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    // InternalResoluteParser.g:2403:7: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    {
            	    // InternalResoluteParser.g:2403:7: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    // InternalResoluteParser.g:2404:8: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    {
            	    // InternalResoluteParser.g:2404:8: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==PlusSign) ) {
            	        alt29=1;
            	    }
            	    else if ( (LA29_0==HyphenMinus) ) {
            	        alt29=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 29, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // InternalResoluteParser.g:2405:9: lv_op_2_1= PlusSign
            	            {
            	            lv_op_2_1=(Token)match(input,PlusSign,FollowSets000.FOLLOW_12); if (state.failed) return current;
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
            	            // InternalResoluteParser.g:2416:9: lv_op_2_2= HyphenMinus
            	            {
            	            lv_op_2_2=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_12); if (state.failed) return current;
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

            	    // InternalResoluteParser.g:2431:4: ( (lv_right_3_0= ruleTimesExpr ) )
            	    // InternalResoluteParser.g:2432:5: (lv_right_3_0= ruleTimesExpr )
            	    {
            	    // InternalResoluteParser.g:2432:5: (lv_right_3_0= ruleTimesExpr )
            	    // InternalResoluteParser.g:2433:6: lv_right_3_0= ruleTimesExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPlusExprAccess().getRightTimesExprParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
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
            	    break loop30;
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
    // InternalResoluteParser.g:2455:1: entryRuleTimesExpr returns [EObject current=null] : iv_ruleTimesExpr= ruleTimesExpr EOF ;
    public final EObject entryRuleTimesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimesExpr = null;


        try {
            // InternalResoluteParser.g:2455:50: (iv_ruleTimesExpr= ruleTimesExpr EOF )
            // InternalResoluteParser.g:2456:2: iv_ruleTimesExpr= ruleTimesExpr EOF
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
    // InternalResoluteParser.g:2462:1: ruleTimesExpr returns [EObject current=null] : (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* ) ;
    public final EObject ruleTimesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_ExpExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:2468:2: ( (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* ) )
            // InternalResoluteParser.g:2469:2: (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* )
            {
            // InternalResoluteParser.g:2469:2: (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* )
            // InternalResoluteParser.g:2470:3: this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getTimesExprAccess().getExpExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_33);
            this_ExpExpr_0=ruleExpExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExpExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalResoluteParser.g:2478:3: ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )*
            loop32:
            do {
                int alt32=2;
                switch ( input.LA(1) ) {
                case Asterisk:
                    {
                    int LA32_2 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt32=1;
                    }


                    }
                    break;
                case Solidus:
                    {
                    int LA32_3 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt32=1;
                    }


                    }
                    break;
                case PercentSign:
                    {
                    int LA32_4 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt32=1;
                    }


                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // InternalResoluteParser.g:2479:4: ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) )
            	    {
            	    // InternalResoluteParser.g:2479:4: ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) )
            	    // InternalResoluteParser.g:2480:5: ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2496:5: ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) )
            	    // InternalResoluteParser.g:2497:6: () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    {
            	    // InternalResoluteParser.g:2497:6: ()
            	    // InternalResoluteParser.g:2498:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getTimesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalResoluteParser.g:2504:6: ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    // InternalResoluteParser.g:2505:7: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    {
            	    // InternalResoluteParser.g:2505:7: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    // InternalResoluteParser.g:2506:8: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    {
            	    // InternalResoluteParser.g:2506:8: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    int alt31=3;
            	    switch ( input.LA(1) ) {
            	    case Asterisk:
            	        {
            	        alt31=1;
            	        }
            	        break;
            	    case Solidus:
            	        {
            	        alt31=2;
            	        }
            	        break;
            	    case PercentSign:
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
            	            // InternalResoluteParser.g:2507:9: lv_op_2_1= Asterisk
            	            {
            	            lv_op_2_1=(Token)match(input,Asterisk,FollowSets000.FOLLOW_12); if (state.failed) return current;
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
            	            // InternalResoluteParser.g:2518:9: lv_op_2_2= Solidus
            	            {
            	            lv_op_2_2=(Token)match(input,Solidus,FollowSets000.FOLLOW_12); if (state.failed) return current;
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
            	            // InternalResoluteParser.g:2529:9: lv_op_2_3= PercentSign
            	            {
            	            lv_op_2_3=(Token)match(input,PercentSign,FollowSets000.FOLLOW_12); if (state.failed) return current;
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

            	    // InternalResoluteParser.g:2544:4: ( (lv_right_3_0= ruleExpExpr ) )
            	    // InternalResoluteParser.g:2545:5: (lv_right_3_0= ruleExpExpr )
            	    {
            	    // InternalResoluteParser.g:2545:5: (lv_right_3_0= ruleExpExpr )
            	    // InternalResoluteParser.g:2546:6: lv_right_3_0= ruleExpExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTimesExprAccess().getRightExpExprParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_33);
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
            	    break loop32;
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
    // InternalResoluteParser.g:2568:1: entryRuleExpExpr returns [EObject current=null] : iv_ruleExpExpr= ruleExpExpr EOF ;
    public final EObject entryRuleExpExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpExpr = null;


        try {
            // InternalResoluteParser.g:2568:48: (iv_ruleExpExpr= ruleExpExpr EOF )
            // InternalResoluteParser.g:2569:2: iv_ruleExpExpr= ruleExpExpr EOF
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
    // InternalResoluteParser.g:2575:1: ruleExpExpr returns [EObject current=null] : (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* ) ;
    public final EObject ruleExpExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_PrefixExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:2581:2: ( (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* ) )
            // InternalResoluteParser.g:2582:2: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* )
            {
            // InternalResoluteParser.g:2582:2: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* )
            // InternalResoluteParser.g:2583:3: this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExpExprAccess().getPrefixExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_34);
            this_PrefixExpr_0=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrefixExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalResoluteParser.g:2591:3: ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==CircumflexAccent) ) {
                    int LA33_2 = input.LA(2);

                    if ( (synpred9_InternalResoluteParser()) ) {
                        alt33=1;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // InternalResoluteParser.g:2592:4: ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) )
            	    {
            	    // InternalResoluteParser.g:2592:4: ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) )
            	    // InternalResoluteParser.g:2593:5: ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) )
            	    {
            	    // InternalResoluteParser.g:2603:5: ( () ( (lv_op_2_0= CircumflexAccent ) ) )
            	    // InternalResoluteParser.g:2604:6: () ( (lv_op_2_0= CircumflexAccent ) )
            	    {
            	    // InternalResoluteParser.g:2604:6: ()
            	    // InternalResoluteParser.g:2605:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalResoluteParser.g:2611:6: ( (lv_op_2_0= CircumflexAccent ) )
            	    // InternalResoluteParser.g:2612:7: (lv_op_2_0= CircumflexAccent )
            	    {
            	    // InternalResoluteParser.g:2612:7: (lv_op_2_0= CircumflexAccent )
            	    // InternalResoluteParser.g:2613:8: lv_op_2_0= CircumflexAccent
            	    {
            	    lv_op_2_0=(Token)match(input,CircumflexAccent,FollowSets000.FOLLOW_12); if (state.failed) return current;
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

            	    // InternalResoluteParser.g:2627:4: ( (lv_right_3_0= rulePrefixExpr ) )
            	    // InternalResoluteParser.g:2628:5: (lv_right_3_0= rulePrefixExpr )
            	    {
            	    // InternalResoluteParser.g:2628:5: (lv_right_3_0= rulePrefixExpr )
            	    // InternalResoluteParser.g:2629:6: lv_right_3_0= rulePrefixExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getExpExprAccess().getRightPrefixExprParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_34);
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
            	    break loop33;
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
    // InternalResoluteParser.g:2651:1: entryRulePrefixExpr returns [EObject current=null] : iv_rulePrefixExpr= rulePrefixExpr EOF ;
    public final EObject entryRulePrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpr = null;


        try {
            // InternalResoluteParser.g:2651:51: (iv_rulePrefixExpr= rulePrefixExpr EOF )
            // InternalResoluteParser.g:2652:2: iv_rulePrefixExpr= rulePrefixExpr EOF
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
    // InternalResoluteParser.g:2658:1: rulePrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr ) ;
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
            // InternalResoluteParser.g:2664:2: ( ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr ) )
            // InternalResoluteParser.g:2665:2: ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr )
            {
            // InternalResoluteParser.g:2665:2: ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr )
            int alt35=3;
            switch ( input.LA(1) ) {
            case Not:
            case HyphenMinus:
                {
                alt35=1;
                }
                break;
            case LeftParenthesis:
                {
                switch ( input.LA(2) ) {
                case Provides_subprogram_group_access:
                case Requires_subprogram_group_access:
                case Provides_subprogram_access:
                case Requires_subprogram_access:
                case Subprogram_group_access:
                case Provides_data_access:
                case Requires_data_access:
                case Provides_bus_access:
                case Requires_bus_access:
                case Flow_specification:
                case Subprogram_access:
                case Virtual_processor:
                case Subprogram_group:
                case End_to_end_flow:
                case Event_data_port:
                case Feature_group:
                case Thread_group:
                case Data_access:
                case Virtual_bus:
                case Bus_access:
                case Connection:
                case Event_port:
                case Subprogram:
                case Component:
                case Data_port:
                case Processor:
                case Abstract:
                case Feature:
                case Process:
                case Access:
                case Device:
                case Memory:
                case String:
                case KW_System:
                case Thread:
                case Range:
                case Aadl:
                case Bool:
                case Data:
                case Port:
                case Real:
                case Bus:
                case Int:
                    {
                    alt35=2;
                    }
                    break;
                case Property:
                    {
                    int LA35_5 = input.LA(3);

                    if ( (LA35_5==RightParenthesis) ) {
                        alt35=2;
                    }
                    else if ( (LA35_5==LeftParenthesis) ) {
                        alt35=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case Error_state_reachable:
                case Is_virtual_processor:
                case Flow_specifications:
                case Is_abstract_feature:
                case Enumerated_values:
                case End_to_end_flows:
                case Flow_destination:
                case Is_bidirectional:
                case Is_thread_group:
                case Propagate_error:
                case Property_member:
                case Has_prototypes:
                case Is_data_access:
                case Is_virtual_bus:
                case Contain_error:
                case Flow_elements:
                case Is_bus_access:
                case Is_event_port:
                case Is_subprogram:
                case Receive_error:
                case Subcomponents:
                case Has_property:
                case Is_data_port:
                case Is_processor:
                case Connections:
                case Destination:
                case Flow_source:
                case Is_bound_to:
                case Is_in_array:
                case Lower_bound:
                case Undeveloped:
                case Upper_bound:
                case Has_member:
                case Has_parent:
                case Is_of_type:
                case Is_process:
                case Direction:
                case Has_modes:
                case Instances:
                case Intersect:
                case Is_device:
                case Is_memory:
                case Is_system:
                case Is_thread:
                case Analysis:
                case Features:
                case Has_type:
                case Instance:
                case Solution:
                case As_list:
                case Is_data:
                case Is_port:
                case Warning:
                case Append:
                case As_set:
                case Exists:
                case Forall:
                case Is_bus:
                case Length:
                case Member:
                case Parent:
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
                case Tail:
                case This:
                case True:
                case Type:
                case Let:
                case Max:
                case Min:
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
                    alt35=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 2, input);

                    throw nvae;
                }

                }
                break;
            case Error_state_reachable:
            case Is_virtual_processor:
            case Flow_specifications:
            case Is_abstract_feature:
            case Enumerated_values:
            case End_to_end_flows:
            case Flow_destination:
            case Is_bidirectional:
            case Is_thread_group:
            case Propagate_error:
            case Property_member:
            case Has_prototypes:
            case Is_data_access:
            case Is_virtual_bus:
            case Contain_error:
            case Flow_elements:
            case Is_bus_access:
            case Is_event_port:
            case Is_subprogram:
            case Receive_error:
            case Subcomponents:
            case Has_property:
            case Is_data_port:
            case Is_processor:
            case Connections:
            case Destination:
            case Flow_source:
            case Is_bound_to:
            case Is_in_array:
            case Lower_bound:
            case Undeveloped:
            case Upper_bound:
            case Has_member:
            case Has_parent:
            case Is_of_type:
            case Is_process:
            case Direction:
            case Has_modes:
            case Instances:
            case Intersect:
            case Is_device:
            case Is_memory:
            case Is_system:
            case Is_thread:
            case Analysis:
            case Features:
            case Has_type:
            case Instance:
            case Property:
            case Solution:
            case As_list:
            case Is_data:
            case Is_port:
            case Warning:
            case Append:
            case As_set:
            case Exists:
            case Forall:
            case Is_bus:
            case Length:
            case Member:
            case Parent:
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
            case Tail:
            case This:
            case True:
            case Type:
            case Let:
            case Max:
            case Min:
            case Sum:
            case If:
            case LeftSquareBracket:
            case LeftCurlyBracket:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
            case RULE_ID:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalResoluteParser.g:2666:3: ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    {
                    // InternalResoluteParser.g:2666:3: ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    // InternalResoluteParser.g:2667:4: () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) )
                    {
                    // InternalResoluteParser.g:2667:4: ()
                    // InternalResoluteParser.g:2668:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixExprAccess().getUnaryExprAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:2674:4: ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) )
                    // InternalResoluteParser.g:2675:5: ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) )
                    {
                    // InternalResoluteParser.g:2675:5: ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) )
                    // InternalResoluteParser.g:2676:6: (lv_op_1_1= HyphenMinus | lv_op_1_2= Not )
                    {
                    // InternalResoluteParser.g:2676:6: (lv_op_1_1= HyphenMinus | lv_op_1_2= Not )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==HyphenMinus) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==Not) ) {
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
                            // InternalResoluteParser.g:2677:7: lv_op_1_1= HyphenMinus
                            {
                            lv_op_1_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_12); if (state.failed) return current;
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
                            // InternalResoluteParser.g:2688:7: lv_op_1_2= Not
                            {
                            lv_op_1_2=(Token)match(input,Not,FollowSets000.FOLLOW_12); if (state.failed) return current;
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

                    // InternalResoluteParser.g:2701:4: ( (lv_expr_2_0= rulePrefixExpr ) )
                    // InternalResoluteParser.g:2702:5: (lv_expr_2_0= rulePrefixExpr )
                    {
                    // InternalResoluteParser.g:2702:5: (lv_expr_2_0= rulePrefixExpr )
                    // InternalResoluteParser.g:2703:6: lv_expr_2_0= rulePrefixExpr
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
                    // InternalResoluteParser.g:2722:3: ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) )
                    {
                    // InternalResoluteParser.g:2722:3: ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) )
                    // InternalResoluteParser.g:2723:4: () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) )
                    {
                    // InternalResoluteParser.g:2723:4: ()
                    // InternalResoluteParser.g:2724:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixExprAccess().getCastExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrefixExprAccess().getLeftParenthesisKeyword_1_1());
                      			
                    }
                    // InternalResoluteParser.g:2734:4: ( (lv_type_5_0= ruleBaseType ) )
                    // InternalResoluteParser.g:2735:5: (lv_type_5_0= ruleBaseType )
                    {
                    // InternalResoluteParser.g:2735:5: (lv_type_5_0= ruleBaseType )
                    // InternalResoluteParser.g:2736:6: lv_type_5_0= ruleBaseType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixExprAccess().getTypeBaseTypeParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_35);
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

                    otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getPrefixExprAccess().getRightParenthesisKeyword_1_3());
                      			
                    }
                    // InternalResoluteParser.g:2757:4: ( (lv_expr_7_0= rulePrefixExpr ) )
                    // InternalResoluteParser.g:2758:5: (lv_expr_7_0= rulePrefixExpr )
                    {
                    // InternalResoluteParser.g:2758:5: (lv_expr_7_0= rulePrefixExpr )
                    // InternalResoluteParser.g:2759:6: lv_expr_7_0= rulePrefixExpr
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
                    // InternalResoluteParser.g:2778:3: this_AtomicExpr_8= ruleAtomicExpr
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
    // InternalResoluteParser.g:2790:1: entryRuleAtomicExpr returns [EObject current=null] : iv_ruleAtomicExpr= ruleAtomicExpr EOF ;
    public final EObject entryRuleAtomicExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpr = null;


        try {
            // InternalResoluteParser.g:2790:51: (iv_ruleAtomicExpr= ruleAtomicExpr EOF )
            // InternalResoluteParser.g:2791:2: iv_ruleAtomicExpr= ruleAtomicExpr EOF
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
    // InternalResoluteParser.g:2797:1: ruleAtomicExpr returns [EObject current=null] : ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) | ( () otherlv_100= Undeveloped ) | ( () otherlv_102= Solution ( (lv_name_103_0= RULE_ID ) ) otherlv_104= Colon ( (lv_val_105_0= ruleStringTerm ) ) ) ) ;
    public final EObject ruleAtomicExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token lv_quant_28_1=null;
        Token lv_quant_28_2=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token lv_libName_35_0=null;
        Token otherlv_36=null;
        Token lv_fnName_37_0=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        Token otherlv_45=null;
        Token otherlv_47=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_56=null;
        Token otherlv_59=null;
        Token otherlv_62=null;
        Token otherlv_63=null;
        Token otherlv_65=null;
        Token otherlv_66=null;
        Token otherlv_69=null;
        Token otherlv_71=null;
        Token otherlv_72=null;
        Token otherlv_75=null;
        Token otherlv_76=null;
        Token otherlv_78=null;
        Token otherlv_79=null;
        Token otherlv_82=null;
        Token otherlv_84=null;
        Token otherlv_86=null;
        Token otherlv_87=null;
        Token otherlv_89=null;
        Token otherlv_90=null;
        Token otherlv_92=null;
        Token otherlv_94=null;
        Token otherlv_96=null;
        Token otherlv_98=null;
        Token otherlv_100=null;
        Token otherlv_102=null;
        Token lv_name_103_0=null;
        Token otherlv_104=null;
        EObject lv_sub_5_0 = null;

        EObject lv_val_8_0 = null;

        EObject lv_failmsg_10_0 = null;

        EObject lv_val_13_0 = null;

        EObject lv_val_15_0 = null;

        EObject lv_val_17_0 = null;

        EObject lv_val_19_0 = null;

        EObject lv_cond_22_0 = null;

        EObject lv_then_24_0 = null;

        EObject lv_else_26_0 = null;

        EObject lv_args_30_0 = null;

        EObject lv_expr_33_0 = null;

        EObject lv_args_39_0 = null;

        EObject lv_args_41_0 = null;

        AntlrDatatypeRuleToken lv_fn_44_0 = null;

        EObject lv_args_46_0 = null;

        EObject lv_args_48_0 = null;

        EObject lv_args_53_0 = null;

        EObject lv_args_55_0 = null;

        EObject lv_lintStmt_58_0 = null;

        EObject this_Expr_60 = null;

        EObject lv_args_64_0 = null;

        EObject lv_filter_67_0 = null;

        EObject lv_exprs_70_0 = null;

        EObject this_Expr_73 = null;

        EObject lv_args_77_0 = null;

        EObject lv_filter_80_0 = null;

        EObject lv_exprs_83_0 = null;

        EObject lv_binding_93_0 = null;

        EObject lv_expr_95_0 = null;

        EObject this_Expr_97 = null;

        EObject lv_val_105_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:2803:2: ( ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) | ( () otherlv_100= Undeveloped ) | ( () otherlv_102= Solution ( (lv_name_103_0= RULE_ID ) ) otherlv_104= Colon ( (lv_val_105_0= ruleStringTerm ) ) ) ) )
            // InternalResoluteParser.g:2804:2: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) | ( () otherlv_100= Undeveloped ) | ( () otherlv_102= Solution ( (lv_name_103_0= RULE_ID ) ) otherlv_104= Colon ( (lv_val_105_0= ruleStringTerm ) ) ) )
            {
            // InternalResoluteParser.g:2804:2: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) | ( () otherlv_100= Undeveloped ) | ( () otherlv_102= Solution ( (lv_name_103_0= RULE_ID ) ) otherlv_104= Colon ( (lv_val_105_0= ruleStringTerm ) ) ) )
            int alt55=21;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // InternalResoluteParser.g:2805:3: ( () ( ( ruleQCREF ) ) )
                    {
                    // InternalResoluteParser.g:2805:3: ( () ( ( ruleQCREF ) ) )
                    // InternalResoluteParser.g:2806:4: () ( ( ruleQCREF ) )
                    {
                    // InternalResoluteParser.g:2806:4: ()
                    // InternalResoluteParser.g:2807:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getIdExprAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:2813:4: ( ( ruleQCREF ) )
                    // InternalResoluteParser.g:2814:5: ( ruleQCREF )
                    {
                    // InternalResoluteParser.g:2814:5: ( ruleQCREF )
                    // InternalResoluteParser.g:2815:6: ruleQCREF
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
                    // InternalResoluteParser.g:2831:3: ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? )
                    {
                    // InternalResoluteParser.g:2831:3: ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? )
                    // InternalResoluteParser.g:2832:4: () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )?
                    {
                    // InternalResoluteParser.g:2832:4: ()
                    // InternalResoluteParser.g:2833:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getThisExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,This,FollowSets000.FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAtomicExprAccess().getThisKeyword_1_1());
                      			
                    }
                    // InternalResoluteParser.g:2843:4: (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==FullStop) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // InternalResoluteParser.g:2844:5: otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) )
                            {
                            otherlv_4=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getAtomicExprAccess().getFullStopKeyword_1_2_0());
                              				
                            }
                            // InternalResoluteParser.g:2848:5: ( (lv_sub_5_0= ruleNestedDotID ) )
                            // InternalResoluteParser.g:2849:6: (lv_sub_5_0= ruleNestedDotID )
                            {
                            // InternalResoluteParser.g:2849:6: (lv_sub_5_0= ruleNestedDotID )
                            // InternalResoluteParser.g:2850:7: lv_sub_5_0= ruleNestedDotID
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
                    // InternalResoluteParser.g:2870:3: ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) )
                    {
                    // InternalResoluteParser.g:2870:3: ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) )
                    // InternalResoluteParser.g:2871:4: () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) )
                    {
                    // InternalResoluteParser.g:2871:4: ()
                    // InternalResoluteParser.g:2872:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getFailExprAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,Fail,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getAtomicExprAccess().getFailKeyword_2_1());
                      			
                    }
                    // InternalResoluteParser.g:2882:4: ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( ((LA38_0>=Error_state_reachable && LA38_0<=Is_virtual_processor)||(LA38_0>=Flow_specifications && LA38_0<=Is_abstract_feature)||LA38_0==Enumerated_values||(LA38_0>=End_to_end_flows && LA38_0<=Is_bidirectional)||(LA38_0>=Is_thread_group && LA38_0<=Contain_error)||(LA38_0>=Flow_elements && LA38_0<=Is_subprogram)||(LA38_0>=Receive_error && LA38_0<=Is_processor)||LA38_0==Connections||(LA38_0>=Destination && LA38_0<=Upper_bound)||(LA38_0>=Has_member && LA38_0<=Has_parent)||(LA38_0>=Is_of_type && LA38_0<=Is_process)||(LA38_0>=Direction && LA38_0<=Is_thread)||LA38_0==Analysis||(LA38_0>=Features && LA38_0<=Solution)||LA38_0==As_list||(LA38_0>=Is_data && LA38_0<=Is_port)||LA38_0==Warning||(LA38_0>=Append && LA38_0<=As_set)||(LA38_0>=Exists && LA38_0<=Member)||(LA38_0>=Parent && LA38_0<=Source)||LA38_0==Debug||(LA38_0>=Error && LA38_0<=False)||LA38_0==Union||LA38_0==Fail||(LA38_0>=Head && LA38_0<=Name)||(LA38_0>=Size && LA38_0<=Tail)||(LA38_0>=This && LA38_0<=Type)||(LA38_0>=Let && LA38_0<=Sum)||LA38_0==If||LA38_0==LeftParenthesis||LA38_0==HyphenMinus||LA38_0==LeftSquareBracket||LA38_0==LeftCurlyBracket||LA38_0==RULE_REAL_LIT||LA38_0==RULE_INTEGER_LIT||(LA38_0>=RULE_STRING && LA38_0<=RULE_ID)) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==AsteriskAsterisk) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalResoluteParser.g:2883:5: ( (lv_val_8_0= ruleExpr ) )
                            {
                            // InternalResoluteParser.g:2883:5: ( (lv_val_8_0= ruleExpr ) )
                            // InternalResoluteParser.g:2884:6: (lv_val_8_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:2884:6: (lv_val_8_0= ruleExpr )
                            // InternalResoluteParser.g:2885:7: lv_val_8_0= ruleExpr
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
                            // InternalResoluteParser.g:2903:5: (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk )
                            {
                            // InternalResoluteParser.g:2903:5: (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk )
                            // InternalResoluteParser.g:2904:6: otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk
                            {
                            otherlv_9=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_9, grammarAccess.getAtomicExprAccess().getAsteriskAsteriskKeyword_2_2_1_0());
                              					
                            }
                            // InternalResoluteParser.g:2908:6: ( (lv_failmsg_10_0= ruleClaimText ) )+
                            int cnt37=0;
                            loop37:
                            do {
                                int alt37=2;
                                int LA37_0 = input.LA(1);

                                if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_ID)) ) {
                                    alt37=1;
                                }


                                switch (alt37) {
                            	case 1 :
                            	    // InternalResoluteParser.g:2909:7: (lv_failmsg_10_0= ruleClaimText )
                            	    {
                            	    // InternalResoluteParser.g:2909:7: (lv_failmsg_10_0= ruleClaimText )
                            	    // InternalResoluteParser.g:2910:8: lv_failmsg_10_0= ruleClaimText
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getAtomicExprAccess().getFailmsgClaimTextParserRuleCall_2_2_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_20);
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
                            	    if ( cnt37 >= 1 ) break loop37;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(37, input);
                                        throw eee;
                                }
                                cnt37++;
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
                    // InternalResoluteParser.g:2935:3: ( () ( (lv_val_13_0= ruleIntegerTerm ) ) )
                    {
                    // InternalResoluteParser.g:2935:3: ( () ( (lv_val_13_0= ruleIntegerTerm ) ) )
                    // InternalResoluteParser.g:2936:4: () ( (lv_val_13_0= ruleIntegerTerm ) )
                    {
                    // InternalResoluteParser.g:2936:4: ()
                    // InternalResoluteParser.g:2937:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getIntExprAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:2943:4: ( (lv_val_13_0= ruleIntegerTerm ) )
                    // InternalResoluteParser.g:2944:5: (lv_val_13_0= ruleIntegerTerm )
                    {
                    // InternalResoluteParser.g:2944:5: (lv_val_13_0= ruleIntegerTerm )
                    // InternalResoluteParser.g:2945:6: lv_val_13_0= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getValIntegerTermParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_13_0=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"val",
                      							lv_val_13_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.IntegerTerm");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:2964:3: ( () ( (lv_val_15_0= ruleRealTerm ) ) )
                    {
                    // InternalResoluteParser.g:2964:3: ( () ( (lv_val_15_0= ruleRealTerm ) ) )
                    // InternalResoluteParser.g:2965:4: () ( (lv_val_15_0= ruleRealTerm ) )
                    {
                    // InternalResoluteParser.g:2965:4: ()
                    // InternalResoluteParser.g:2966:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getRealExprAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:2972:4: ( (lv_val_15_0= ruleRealTerm ) )
                    // InternalResoluteParser.g:2973:5: (lv_val_15_0= ruleRealTerm )
                    {
                    // InternalResoluteParser.g:2973:5: (lv_val_15_0= ruleRealTerm )
                    // InternalResoluteParser.g:2974:6: lv_val_15_0= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getValRealTermParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_15_0=ruleRealTerm();

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
                      							"com.rockwellcollins.atc.resolute.Resolute.RealTerm");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:2993:3: ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) )
                    {
                    // InternalResoluteParser.g:2993:3: ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) )
                    // InternalResoluteParser.g:2994:4: () ( (lv_val_17_0= ruleBooleanLiteral ) )
                    {
                    // InternalResoluteParser.g:2994:4: ()
                    // InternalResoluteParser.g:2995:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getBoolExprAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:3001:4: ( (lv_val_17_0= ruleBooleanLiteral ) )
                    // InternalResoluteParser.g:3002:5: (lv_val_17_0= ruleBooleanLiteral )
                    {
                    // InternalResoluteParser.g:3002:5: (lv_val_17_0= ruleBooleanLiteral )
                    // InternalResoluteParser.g:3003:6: lv_val_17_0= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getValBooleanLiteralParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_17_0=ruleBooleanLiteral();

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
                      							"org.osate.xtext.aadl2.properties.Properties.BooleanLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:3022:3: ( () ( (lv_val_19_0= ruleStringTerm ) ) )
                    {
                    // InternalResoluteParser.g:3022:3: ( () ( (lv_val_19_0= ruleStringTerm ) ) )
                    // InternalResoluteParser.g:3023:4: () ( (lv_val_19_0= ruleStringTerm ) )
                    {
                    // InternalResoluteParser.g:3023:4: ()
                    // InternalResoluteParser.g:3024:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getStringExprAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:3030:4: ( (lv_val_19_0= ruleStringTerm ) )
                    // InternalResoluteParser.g:3031:5: (lv_val_19_0= ruleStringTerm )
                    {
                    // InternalResoluteParser.g:3031:5: (lv_val_19_0= ruleStringTerm )
                    // InternalResoluteParser.g:3032:6: lv_val_19_0= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getValStringTermParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_19_0=ruleStringTerm();

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
                      							"org.osate.xtext.aadl2.properties.Properties.StringTerm");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalResoluteParser.g:3051:3: ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:3051:3: ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:3052:4: () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:3052:4: ()
                    // InternalResoluteParser.g:3053:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getIfThenElseExprAction_7_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_21=(Token)match(input,If,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getAtomicExprAccess().getIfKeyword_7_1());
                      			
                    }
                    // InternalResoluteParser.g:3063:4: ( (lv_cond_22_0= ruleExpr ) )
                    // InternalResoluteParser.g:3064:5: (lv_cond_22_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3064:5: (lv_cond_22_0= ruleExpr )
                    // InternalResoluteParser.g:3065:6: lv_cond_22_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getCondExprParserRuleCall_7_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_38);
                    lv_cond_22_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"cond",
                      							lv_cond_22_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_23=(Token)match(input,Then,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_23, grammarAccess.getAtomicExprAccess().getThenKeyword_7_3());
                      			
                    }
                    // InternalResoluteParser.g:3086:4: ( (lv_then_24_0= ruleExpr ) )
                    // InternalResoluteParser.g:3087:5: (lv_then_24_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3087:5: (lv_then_24_0= ruleExpr )
                    // InternalResoluteParser.g:3088:6: lv_then_24_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getThenExprParserRuleCall_7_4_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_39);
                    lv_then_24_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"then",
                      							lv_then_24_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_25=(Token)match(input,Else,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_25, grammarAccess.getAtomicExprAccess().getElseKeyword_7_5());
                      			
                    }
                    // InternalResoluteParser.g:3109:4: ( (lv_else_26_0= ruleExpr ) )
                    // InternalResoluteParser.g:3110:5: (lv_else_26_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3110:5: (lv_else_26_0= ruleExpr )
                    // InternalResoluteParser.g:3111:6: lv_else_26_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getElseExprParserRuleCall_7_6_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_else_26_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_26_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalResoluteParser.g:3130:3: ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:3130:3: ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:3131:4: () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:3131:4: ()
                    // InternalResoluteParser.g:3132:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getQuantifiedExprAction_8_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:3138:4: ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) )
                    // InternalResoluteParser.g:3139:5: ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) )
                    {
                    // InternalResoluteParser.g:3139:5: ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) )
                    // InternalResoluteParser.g:3140:6: (lv_quant_28_1= Forall | lv_quant_28_2= Exists )
                    {
                    // InternalResoluteParser.g:3140:6: (lv_quant_28_1= Forall | lv_quant_28_2= Exists )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==Forall) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==Exists) ) {
                        alt39=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalResoluteParser.g:3141:7: lv_quant_28_1= Forall
                            {
                            lv_quant_28_1=(Token)match(input,Forall,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_quant_28_1, grammarAccess.getAtomicExprAccess().getQuantForallKeyword_8_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicExprRule());
                              							}
                              							setWithLastConsumed(current, "quant", lv_quant_28_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalResoluteParser.g:3152:7: lv_quant_28_2= Exists
                            {
                            lv_quant_28_2=(Token)match(input,Exists,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_quant_28_2, grammarAccess.getAtomicExprAccess().getQuantExistsKeyword_8_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicExprRule());
                              							}
                              							setWithLastConsumed(current, "quant", lv_quant_28_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalResoluteParser.g:3165:4: (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==LeftParenthesis) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalResoluteParser.g:3166:5: otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis
                    	    {
                    	    otherlv_29=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_29, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_8_2_0());
                    	      				
                    	    }
                    	    // InternalResoluteParser.g:3170:5: ( (lv_args_30_0= ruleArg ) )
                    	    // InternalResoluteParser.g:3171:6: (lv_args_30_0= ruleArg )
                    	    {
                    	    // InternalResoluteParser.g:3171:6: (lv_args_30_0= ruleArg )
                    	    // InternalResoluteParser.g:3172:7: lv_args_30_0= ruleArg
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsArgParserRuleCall_8_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_35);
                    	    lv_args_30_0=ruleArg();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"args",
                    	      								lv_args_30_0,
                    	      								"com.rockwellcollins.atc.resolute.Resolute.Arg");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    otherlv_31=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_40); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_31, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_8_2_2());
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);

                    otherlv_32=(Token)match(input,FullStop,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_32, grammarAccess.getAtomicExprAccess().getFullStopKeyword_8_3());
                      			
                    }
                    // InternalResoluteParser.g:3198:4: ( (lv_expr_33_0= ruleExpr ) )
                    // InternalResoluteParser.g:3199:5: (lv_expr_33_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3199:5: (lv_expr_33_0= ruleExpr )
                    // InternalResoluteParser.g:3200:6: lv_expr_33_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getExprExprParserRuleCall_8_4_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_33_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_33_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalResoluteParser.g:3219:3: ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) )
                    {
                    // InternalResoluteParser.g:3219:3: ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) )
                    // InternalResoluteParser.g:3220:4: ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3253:4: ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis )
                    // InternalResoluteParser.g:3254:5: () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis
                    {
                    // InternalResoluteParser.g:3254:5: ()
                    // InternalResoluteParser.g:3255:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElement(
                      							grammarAccess.getAtomicExprAccess().getLibraryFnCallExprAction_9_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalResoluteParser.g:3261:5: ( (lv_libName_35_0= RULE_ID ) )
                    // InternalResoluteParser.g:3262:6: (lv_libName_35_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:3262:6: (lv_libName_35_0= RULE_ID )
                    // InternalResoluteParser.g:3263:7: lv_libName_35_0= RULE_ID
                    {
                    lv_libName_35_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_libName_35_0, grammarAccess.getAtomicExprAccess().getLibNameIDTerminalRuleCall_9_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getAtomicExprRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"libName",
                      								lv_libName_35_0,
                      								"org.osate.xtext.aadl2.properties.Properties.ID");
                      						
                    }

                    }


                    }

                    otherlv_36=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_36, grammarAccess.getAtomicExprAccess().getFullStopKeyword_9_0_2());
                      				
                    }
                    // InternalResoluteParser.g:3283:5: ( (lv_fnName_37_0= RULE_ID ) )
                    // InternalResoluteParser.g:3284:6: (lv_fnName_37_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:3284:6: (lv_fnName_37_0= RULE_ID )
                    // InternalResoluteParser.g:3285:7: lv_fnName_37_0= RULE_ID
                    {
                    lv_fnName_37_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_fnName_37_0, grammarAccess.getAtomicExprAccess().getFnNameIDTerminalRuleCall_9_0_3_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getAtomicExprRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"fnName",
                      								lv_fnName_37_0,
                      								"org.osate.xtext.aadl2.properties.Properties.ID");
                      						
                    }

                    }


                    }

                    otherlv_38=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_38, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_9_0_4());
                      				
                    }
                    // InternalResoluteParser.g:3305:5: ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=Error_state_reachable && LA42_0<=Is_virtual_processor)||(LA42_0>=Flow_specifications && LA42_0<=Is_abstract_feature)||LA42_0==Enumerated_values||(LA42_0>=End_to_end_flows && LA42_0<=Is_bidirectional)||(LA42_0>=Is_thread_group && LA42_0<=Contain_error)||(LA42_0>=Flow_elements && LA42_0<=Is_subprogram)||(LA42_0>=Receive_error && LA42_0<=Is_processor)||LA42_0==Connections||(LA42_0>=Destination && LA42_0<=Upper_bound)||(LA42_0>=Has_member && LA42_0<=Has_parent)||(LA42_0>=Is_of_type && LA42_0<=Is_process)||(LA42_0>=Direction && LA42_0<=Is_thread)||LA42_0==Analysis||(LA42_0>=Features && LA42_0<=Solution)||LA42_0==As_list||(LA42_0>=Is_data && LA42_0<=Is_port)||LA42_0==Warning||(LA42_0>=Append && LA42_0<=As_set)||(LA42_0>=Exists && LA42_0<=Member)||(LA42_0>=Parent && LA42_0<=Source)||LA42_0==Debug||(LA42_0>=Error && LA42_0<=False)||LA42_0==Union||LA42_0==Fail||(LA42_0>=Head && LA42_0<=Name)||(LA42_0>=Size && LA42_0<=Tail)||(LA42_0>=This && LA42_0<=Type)||(LA42_0>=Let && LA42_0<=Sum)||LA42_0==If||LA42_0==LeftParenthesis||LA42_0==HyphenMinus||LA42_0==LeftSquareBracket||LA42_0==LeftCurlyBracket||LA42_0==RULE_REAL_LIT||LA42_0==RULE_INTEGER_LIT||(LA42_0>=RULE_STRING && LA42_0<=RULE_ID)) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalResoluteParser.g:3306:6: ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3306:6: ( (lv_args_39_0= ruleExpr ) )
                            // InternalResoluteParser.g:3307:7: (lv_args_39_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3307:7: (lv_args_39_0= ruleExpr )
                            // InternalResoluteParser.g:3308:8: lv_args_39_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_9_0_5_0_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_16);
                            lv_args_39_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              								}
                              								add(
                              									current,
                              									"args",
                              									lv_args_39_0,
                              									"com.rockwellcollins.atc.resolute.Resolute.Expr");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalResoluteParser.g:3325:6: (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )*
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==Comma) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3326:7: otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) )
                            	    {
                            	    otherlv_40=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_40, grammarAccess.getAtomicExprAccess().getCommaKeyword_9_0_5_1_0());
                            	      						
                            	    }
                            	    // InternalResoluteParser.g:3330:7: ( (lv_args_41_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3331:8: (lv_args_41_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3331:8: (lv_args_41_0= ruleExpr )
                            	    // InternalResoluteParser.g:3332:9: lv_args_41_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_9_0_5_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_16);
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


                            	    }
                            	    break;

                            	default :
                            	    break loop41;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_42=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_42, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_9_0_6());
                      				
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalResoluteParser.g:3358:3: ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3358:3: ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis )
                    // InternalResoluteParser.g:3359:4: () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis
                    {
                    // InternalResoluteParser.g:3359:4: ()
                    // InternalResoluteParser.g:3360:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getBuiltInFnCallExprAction_10_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:3366:4: ( (lv_fn_44_0= ruleBuiltInFn ) )
                    // InternalResoluteParser.g:3367:5: (lv_fn_44_0= ruleBuiltInFn )
                    {
                    // InternalResoluteParser.g:3367:5: (lv_fn_44_0= ruleBuiltInFn )
                    // InternalResoluteParser.g:3368:6: lv_fn_44_0= ruleBuiltInFn
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getFnBuiltInFnParserRuleCall_10_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_fn_44_0=ruleBuiltInFn();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"fn",
                      							lv_fn_44_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.BuiltInFn");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_45=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_45, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_10_2());
                      			
                    }
                    // InternalResoluteParser.g:3389:4: ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( ((LA44_0>=Error_state_reachable && LA44_0<=Is_virtual_processor)||(LA44_0>=Flow_specifications && LA44_0<=Is_abstract_feature)||LA44_0==Enumerated_values||(LA44_0>=End_to_end_flows && LA44_0<=Is_bidirectional)||(LA44_0>=Is_thread_group && LA44_0<=Contain_error)||(LA44_0>=Flow_elements && LA44_0<=Is_subprogram)||(LA44_0>=Receive_error && LA44_0<=Is_processor)||LA44_0==Connections||(LA44_0>=Destination && LA44_0<=Upper_bound)||(LA44_0>=Has_member && LA44_0<=Has_parent)||(LA44_0>=Is_of_type && LA44_0<=Is_process)||(LA44_0>=Direction && LA44_0<=Is_thread)||LA44_0==Analysis||(LA44_0>=Features && LA44_0<=Solution)||LA44_0==As_list||(LA44_0>=Is_data && LA44_0<=Is_port)||LA44_0==Warning||(LA44_0>=Append && LA44_0<=As_set)||(LA44_0>=Exists && LA44_0<=Member)||(LA44_0>=Parent && LA44_0<=Source)||LA44_0==Debug||(LA44_0>=Error && LA44_0<=False)||LA44_0==Union||LA44_0==Fail||(LA44_0>=Head && LA44_0<=Name)||(LA44_0>=Size && LA44_0<=Tail)||(LA44_0>=This && LA44_0<=Type)||(LA44_0>=Let && LA44_0<=Sum)||LA44_0==If||LA44_0==LeftParenthesis||LA44_0==HyphenMinus||LA44_0==LeftSquareBracket||LA44_0==LeftCurlyBracket||LA44_0==RULE_REAL_LIT||LA44_0==RULE_INTEGER_LIT||(LA44_0>=RULE_STRING && LA44_0<=RULE_ID)) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalResoluteParser.g:3390:5: ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3390:5: ( (lv_args_46_0= ruleExpr ) )
                            // InternalResoluteParser.g:3391:6: (lv_args_46_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3391:6: (lv_args_46_0= ruleExpr )
                            // InternalResoluteParser.g:3392:7: lv_args_46_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_10_3_0_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_16);
                            lv_args_46_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_46_0,
                              								"com.rockwellcollins.atc.resolute.Resolute.Expr");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalResoluteParser.g:3409:5: (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )*
                            loop43:
                            do {
                                int alt43=2;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==Comma) ) {
                                    alt43=1;
                                }


                                switch (alt43) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3410:6: otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) )
                            	    {
                            	    otherlv_47=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_47, grammarAccess.getAtomicExprAccess().getCommaKeyword_10_3_1_0());
                            	      					
                            	    }
                            	    // InternalResoluteParser.g:3414:6: ( (lv_args_48_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3415:7: (lv_args_48_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3415:7: (lv_args_48_0= ruleExpr )
                            	    // InternalResoluteParser.g:3416:8: lv_args_48_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_10_3_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_16);
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


                            	    }
                            	    break;

                            	default :
                            	    break loop43;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_49=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_49, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_10_4());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalResoluteParser.g:3441:3: ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3441:3: ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis )
                    // InternalResoluteParser.g:3442:4: () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis
                    {
                    // InternalResoluteParser.g:3442:4: ()
                    // InternalResoluteParser.g:3443:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getFnCallExprAction_11_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:3449:4: ( (otherlv_51= RULE_ID ) )
                    // InternalResoluteParser.g:3450:5: (otherlv_51= RULE_ID )
                    {
                    // InternalResoluteParser.g:3450:5: (otherlv_51= RULE_ID )
                    // InternalResoluteParser.g:3451:6: otherlv_51= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicExprRule());
                      						}
                      					
                    }
                    otherlv_51=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_51, grammarAccess.getAtomicExprAccess().getFnFunctionDefinitionCrossReference_11_1_0());
                      					
                    }

                    }


                    }

                    otherlv_52=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_52, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_11_2());
                      			
                    }
                    // InternalResoluteParser.g:3466:4: ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( ((LA46_0>=Error_state_reachable && LA46_0<=Is_virtual_processor)||(LA46_0>=Flow_specifications && LA46_0<=Is_abstract_feature)||LA46_0==Enumerated_values||(LA46_0>=End_to_end_flows && LA46_0<=Is_bidirectional)||(LA46_0>=Is_thread_group && LA46_0<=Contain_error)||(LA46_0>=Flow_elements && LA46_0<=Is_subprogram)||(LA46_0>=Receive_error && LA46_0<=Is_processor)||LA46_0==Connections||(LA46_0>=Destination && LA46_0<=Upper_bound)||(LA46_0>=Has_member && LA46_0<=Has_parent)||(LA46_0>=Is_of_type && LA46_0<=Is_process)||(LA46_0>=Direction && LA46_0<=Is_thread)||LA46_0==Analysis||(LA46_0>=Features && LA46_0<=Solution)||LA46_0==As_list||(LA46_0>=Is_data && LA46_0<=Is_port)||LA46_0==Warning||(LA46_0>=Append && LA46_0<=As_set)||(LA46_0>=Exists && LA46_0<=Member)||(LA46_0>=Parent && LA46_0<=Source)||LA46_0==Debug||(LA46_0>=Error && LA46_0<=False)||LA46_0==Union||LA46_0==Fail||(LA46_0>=Head && LA46_0<=Name)||(LA46_0>=Size && LA46_0<=Tail)||(LA46_0>=This && LA46_0<=Type)||(LA46_0>=Let && LA46_0<=Sum)||LA46_0==If||LA46_0==LeftParenthesis||LA46_0==HyphenMinus||LA46_0==LeftSquareBracket||LA46_0==LeftCurlyBracket||LA46_0==RULE_REAL_LIT||LA46_0==RULE_INTEGER_LIT||(LA46_0>=RULE_STRING && LA46_0<=RULE_ID)) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalResoluteParser.g:3467:5: ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3467:5: ( (lv_args_53_0= ruleExpr ) )
                            // InternalResoluteParser.g:3468:6: (lv_args_53_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3468:6: (lv_args_53_0= ruleExpr )
                            // InternalResoluteParser.g:3469:7: lv_args_53_0= ruleExpr
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_11_3_0_0());
                              						
                            }
                            pushFollow(FollowSets000.FOLLOW_16);
                            lv_args_53_0=ruleExpr();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_53_0,
                              								"com.rockwellcollins.atc.resolute.Resolute.Expr");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalResoluteParser.g:3486:5: (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==Comma) ) {
                                    alt45=1;
                                }


                                switch (alt45) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3487:6: otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) )
                            	    {
                            	    otherlv_54=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_54, grammarAccess.getAtomicExprAccess().getCommaKeyword_11_3_1_0());
                            	      					
                            	    }
                            	    // InternalResoluteParser.g:3491:6: ( (lv_args_55_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3492:7: (lv_args_55_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3492:7: (lv_args_55_0= ruleExpr )
                            	    // InternalResoluteParser.g:3493:8: lv_args_55_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsExprParserRuleCall_11_3_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_16);
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


                            	    }
                            	    break;

                            	default :
                            	    break loop45;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_56=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_56, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_11_4());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalResoluteParser.g:3518:3: ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) )
                    {
                    // InternalResoluteParser.g:3518:3: ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) )
                    // InternalResoluteParser.g:3519:4: () ( (lv_lintStmt_58_0= ruleLintStatement ) )
                    {
                    // InternalResoluteParser.g:3519:4: ()
                    // InternalResoluteParser.g:3520:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getLintExprAction_12_0(),
                      						current);
                      				
                    }

                    }

                    // InternalResoluteParser.g:3526:4: ( (lv_lintStmt_58_0= ruleLintStatement ) )
                    // InternalResoluteParser.g:3527:5: (lv_lintStmt_58_0= ruleLintStatement )
                    {
                    // InternalResoluteParser.g:3527:5: (lv_lintStmt_58_0= ruleLintStatement )
                    // InternalResoluteParser.g:3528:6: lv_lintStmt_58_0= ruleLintStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getLintStmtLintStatementParserRuleCall_12_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_lintStmt_58_0=ruleLintStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"lintStmt",
                      							lv_lintStmt_58_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.LintStatement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalResoluteParser.g:3547:3: (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:3547:3: (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket )
                    // InternalResoluteParser.g:3548:4: otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket
                    {
                    otherlv_59=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_59, grammarAccess.getAtomicExprAccess().getLeftSquareBracketKeyword_13_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_13_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_42);
                    this_Expr_60=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expr_60;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalResoluteParser.g:3560:4: ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==For) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==Comma||LA50_0==RightSquareBracket) ) {
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
                            // InternalResoluteParser.g:3561:5: ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? )
                            {
                            // InternalResoluteParser.g:3561:5: ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? )
                            // InternalResoluteParser.g:3562:6: () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )?
                            {
                            // InternalResoluteParser.g:3562:6: ()
                            // InternalResoluteParser.g:3563:7: 
                            {
                            if ( state.backtracking==0 ) {

                              							current = forceCreateModelElementAndSet(
                              								grammarAccess.getAtomicExprAccess().getListFilterMapExprMapAction_13_2_0_0(),
                              								current);
                              						
                            }

                            }

                            otherlv_62=(Token)match(input,For,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_62, grammarAccess.getAtomicExprAccess().getForKeyword_13_2_0_1());
                              					
                            }
                            // InternalResoluteParser.g:3573:6: (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+
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
                            	    // InternalResoluteParser.g:3574:7: otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis
                            	    {
                            	    otherlv_63=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_63, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_13_2_0_2_0());
                            	      						
                            	    }
                            	    // InternalResoluteParser.g:3578:7: ( (lv_args_64_0= ruleArg ) )
                            	    // InternalResoluteParser.g:3579:8: (lv_args_64_0= ruleArg )
                            	    {
                            	    // InternalResoluteParser.g:3579:8: (lv_args_64_0= ruleArg )
                            	    // InternalResoluteParser.g:3580:9: lv_args_64_0= ruleArg
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsArgParserRuleCall_13_2_0_2_1_0());
                            	      								
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_35);
                            	    lv_args_64_0=ruleArg();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"args",
                            	      										lv_args_64_0,
                            	      										"com.rockwellcollins.atc.resolute.Resolute.Arg");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }

                            	    otherlv_65=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_43); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_65, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_13_2_0_2_2());
                            	      						
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

                            // InternalResoluteParser.g:3602:6: (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )?
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( (LA48_0==VerticalLine) ) {
                                alt48=1;
                            }
                            switch (alt48) {
                                case 1 :
                                    // InternalResoluteParser.g:3603:7: otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) )
                                    {
                                    otherlv_66=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_12); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_66, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_13_2_0_3_0());
                                      						
                                    }
                                    // InternalResoluteParser.g:3607:7: ( (lv_filter_67_0= ruleExpr ) )
                                    // InternalResoluteParser.g:3608:8: (lv_filter_67_0= ruleExpr )
                                    {
                                    // InternalResoluteParser.g:3608:8: (lv_filter_67_0= ruleExpr )
                                    // InternalResoluteParser.g:3609:9: lv_filter_67_0= ruleExpr
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getAtomicExprAccess().getFilterExprParserRuleCall_13_2_0_3_1_0());
                                      								
                                    }
                                    pushFollow(FollowSets000.FOLLOW_5);
                                    lv_filter_67_0=ruleExpr();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                                      									}
                                      									set(
                                      										current,
                                      										"filter",
                                      										lv_filter_67_0,
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
                            // InternalResoluteParser.g:3629:5: ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* )
                            {
                            // InternalResoluteParser.g:3629:5: ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* )
                            // InternalResoluteParser.g:3630:6: () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3630:6: ()
                            // InternalResoluteParser.g:3631:7: 
                            {
                            if ( state.backtracking==0 ) {

                              							current = forceCreateModelElementAndAdd(
                              								grammarAccess.getAtomicExprAccess().getListExprExprsAction_13_2_1_0(),
                              								current);
                              						
                            }

                            }

                            // InternalResoluteParser.g:3637:6: (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )*
                            loop49:
                            do {
                                int alt49=2;
                                int LA49_0 = input.LA(1);

                                if ( (LA49_0==Comma) ) {
                                    alt49=1;
                                }


                                switch (alt49) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3638:7: otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) )
                            	    {
                            	    otherlv_69=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_69, grammarAccess.getAtomicExprAccess().getCommaKeyword_13_2_1_1_0());
                            	      						
                            	    }
                            	    // InternalResoluteParser.g:3642:7: ( (lv_exprs_70_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3643:8: (lv_exprs_70_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3643:8: (lv_exprs_70_0= ruleExpr )
                            	    // InternalResoluteParser.g:3644:9: lv_exprs_70_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_13_2_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_44);
                            	    lv_exprs_70_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"exprs",
                            	      										lv_exprs_70_0,
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

                    otherlv_71=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_71, grammarAccess.getAtomicExprAccess().getRightSquareBracketKeyword_13_3());
                      			
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalResoluteParser.g:3670:3: (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:3670:3: (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket )
                    // InternalResoluteParser.g:3671:4: otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket
                    {
                    otherlv_72=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_72, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_14_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_14_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_45);
                    this_Expr_73=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expr_73;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalResoluteParser.g:3683:4: ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) )
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==For) ) {
                        alt54=1;
                    }
                    else if ( (LA54_0==Comma||LA54_0==RightCurlyBracket) ) {
                        alt54=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;
                    }
                    switch (alt54) {
                        case 1 :
                            // InternalResoluteParser.g:3684:5: ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? )
                            {
                            // InternalResoluteParser.g:3684:5: ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? )
                            // InternalResoluteParser.g:3685:6: () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )?
                            {
                            // InternalResoluteParser.g:3685:6: ()
                            // InternalResoluteParser.g:3686:7: 
                            {
                            if ( state.backtracking==0 ) {

                              							current = forceCreateModelElementAndSet(
                              								grammarAccess.getAtomicExprAccess().getSetFilterMapExprMapAction_14_2_0_0(),
                              								current);
                              						
                            }

                            }

                            otherlv_75=(Token)match(input,For,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_75, grammarAccess.getAtomicExprAccess().getForKeyword_14_2_0_1());
                              					
                            }
                            // InternalResoluteParser.g:3696:6: (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+
                            int cnt51=0;
                            loop51:
                            do {
                                int alt51=2;
                                int LA51_0 = input.LA(1);

                                if ( (LA51_0==LeftParenthesis) ) {
                                    alt51=1;
                                }


                                switch (alt51) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3697:7: otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis
                            	    {
                            	    otherlv_76=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_76, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_14_2_0_2_0());
                            	      						
                            	    }
                            	    // InternalResoluteParser.g:3701:7: ( (lv_args_77_0= ruleArg ) )
                            	    // InternalResoluteParser.g:3702:8: (lv_args_77_0= ruleArg )
                            	    {
                            	    // InternalResoluteParser.g:3702:8: (lv_args_77_0= ruleArg )
                            	    // InternalResoluteParser.g:3703:9: lv_args_77_0= ruleArg
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getAtomicExprAccess().getArgsArgParserRuleCall_14_2_0_2_1_0());
                            	      								
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_35);
                            	    lv_args_77_0=ruleArg();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"args",
                            	      										lv_args_77_0,
                            	      										"com.rockwellcollins.atc.resolute.Resolute.Arg");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }

                            	    otherlv_78=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_46); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_78, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_14_2_0_2_2());
                            	      						
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt51 >= 1 ) break loop51;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(51, input);
                                        throw eee;
                                }
                                cnt51++;
                            } while (true);

                            // InternalResoluteParser.g:3725:6: (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )?
                            int alt52=2;
                            int LA52_0 = input.LA(1);

                            if ( (LA52_0==VerticalLine) ) {
                                alt52=1;
                            }
                            switch (alt52) {
                                case 1 :
                                    // InternalResoluteParser.g:3726:7: otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) )
                                    {
                                    otherlv_79=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_12); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(otherlv_79, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_14_2_0_3_0());
                                      						
                                    }
                                    // InternalResoluteParser.g:3730:7: ( (lv_filter_80_0= ruleExpr ) )
                                    // InternalResoluteParser.g:3731:8: (lv_filter_80_0= ruleExpr )
                                    {
                                    // InternalResoluteParser.g:3731:8: (lv_filter_80_0= ruleExpr )
                                    // InternalResoluteParser.g:3732:9: lv_filter_80_0= ruleExpr
                                    {
                                    if ( state.backtracking==0 ) {

                                      									newCompositeNode(grammarAccess.getAtomicExprAccess().getFilterExprParserRuleCall_14_2_0_3_1_0());
                                      								
                                    }
                                    pushFollow(FollowSets000.FOLLOW_6);
                                    lv_filter_80_0=ruleExpr();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									if (current==null) {
                                      										current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                                      									}
                                      									set(
                                      										current,
                                      										"filter",
                                      										lv_filter_80_0,
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
                            // InternalResoluteParser.g:3752:5: ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* )
                            {
                            // InternalResoluteParser.g:3752:5: ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* )
                            // InternalResoluteParser.g:3753:6: () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3753:6: ()
                            // InternalResoluteParser.g:3754:7: 
                            {
                            if ( state.backtracking==0 ) {

                              							current = forceCreateModelElementAndAdd(
                              								grammarAccess.getAtomicExprAccess().getSetExprExprsAction_14_2_1_0(),
                              								current);
                              						
                            }

                            }

                            // InternalResoluteParser.g:3760:6: (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )*
                            loop53:
                            do {
                                int alt53=2;
                                int LA53_0 = input.LA(1);

                                if ( (LA53_0==Comma) ) {
                                    alt53=1;
                                }


                                switch (alt53) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3761:7: otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) )
                            	    {
                            	    otherlv_82=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_82, grammarAccess.getAtomicExprAccess().getCommaKeyword_14_2_1_1_0());
                            	      						
                            	    }
                            	    // InternalResoluteParser.g:3765:7: ( (lv_exprs_83_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3766:8: (lv_exprs_83_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3766:8: (lv_exprs_83_0= ruleExpr )
                            	    // InternalResoluteParser.g:3767:9: lv_exprs_83_0= ruleExpr
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getAtomicExprAccess().getExprsExprParserRuleCall_14_2_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_47);
                            	    lv_exprs_83_0=ruleExpr();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"exprs",
                            	      										lv_exprs_83_0,
                            	      										"com.rockwellcollins.atc.resolute.Resolute.Expr");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop53;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_84=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_84, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_14_3());
                      			
                    }

                    }


                    }
                    break;
                case 16 :
                    // InternalResoluteParser.g:3793:3: ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:3793:3: ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket )
                    // InternalResoluteParser.g:3794:4: () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket
                    {
                    // InternalResoluteParser.g:3794:4: ()
                    // InternalResoluteParser.g:3795:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getListExprAction_15_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_86=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_86, grammarAccess.getAtomicExprAccess().getLeftSquareBracketKeyword_15_1());
                      			
                    }
                    otherlv_87=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_87, grammarAccess.getAtomicExprAccess().getRightSquareBracketKeyword_15_2());
                      			
                    }

                    }


                    }
                    break;
                case 17 :
                    // InternalResoluteParser.g:3811:3: ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:3811:3: ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket )
                    // InternalResoluteParser.g:3812:4: () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket
                    {
                    // InternalResoluteParser.g:3812:4: ()
                    // InternalResoluteParser.g:3813:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getSetExprAction_16_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_89=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_89, grammarAccess.getAtomicExprAccess().getLeftCurlyBracketKeyword_16_1());
                      			
                    }
                    otherlv_90=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_90, grammarAccess.getAtomicExprAccess().getRightCurlyBracketKeyword_16_2());
                      			
                    }

                    }


                    }
                    break;
                case 18 :
                    // InternalResoluteParser.g:3829:3: ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:3829:3: ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:3830:4: () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:3830:4: ()
                    // InternalResoluteParser.g:3831:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getLetExprAction_17_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_92=(Token)match(input,Let,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_92, grammarAccess.getAtomicExprAccess().getLetKeyword_17_1());
                      			
                    }
                    // InternalResoluteParser.g:3841:4: ( (lv_binding_93_0= ruleLetBinding ) )
                    // InternalResoluteParser.g:3842:5: (lv_binding_93_0= ruleLetBinding )
                    {
                    // InternalResoluteParser.g:3842:5: (lv_binding_93_0= ruleLetBinding )
                    // InternalResoluteParser.g:3843:6: lv_binding_93_0= ruleLetBinding
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getBindingLetBindingParserRuleCall_17_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_binding_93_0=ruleLetBinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"binding",
                      							lv_binding_93_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.LetBinding");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_94=(Token)match(input,Semicolon,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_94, grammarAccess.getAtomicExprAccess().getSemicolonKeyword_17_3());
                      			
                    }
                    // InternalResoluteParser.g:3864:4: ( (lv_expr_95_0= ruleExpr ) )
                    // InternalResoluteParser.g:3865:5: (lv_expr_95_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3865:5: (lv_expr_95_0= ruleExpr )
                    // InternalResoluteParser.g:3866:6: lv_expr_95_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getExprExprParserRuleCall_17_4_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_95_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_95_0,
                      							"com.rockwellcollins.atc.resolute.Resolute.Expr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 19 :
                    // InternalResoluteParser.g:3885:3: (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3885:3: (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis )
                    // InternalResoluteParser.g:3886:4: otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis
                    {
                    otherlv_96=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_96, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_18_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAtomicExprAccess().getExprParserRuleCall_18_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_35);
                    this_Expr_97=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expr_97;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_98=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_98, grammarAccess.getAtomicExprAccess().getRightParenthesisKeyword_18_2());
                      			
                    }

                    }


                    }
                    break;
                case 20 :
                    // InternalResoluteParser.g:3904:3: ( () otherlv_100= Undeveloped )
                    {
                    // InternalResoluteParser.g:3904:3: ( () otherlv_100= Undeveloped )
                    // InternalResoluteParser.g:3905:4: () otherlv_100= Undeveloped
                    {
                    // InternalResoluteParser.g:3905:4: ()
                    // InternalResoluteParser.g:3906:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getUndevelopedExprAction_19_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_100=(Token)match(input,Undeveloped,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_100, grammarAccess.getAtomicExprAccess().getUndevelopedKeyword_19_1());
                      			
                    }

                    }


                    }
                    break;
                case 21 :
                    // InternalResoluteParser.g:3918:3: ( () otherlv_102= Solution ( (lv_name_103_0= RULE_ID ) ) otherlv_104= Colon ( (lv_val_105_0= ruleStringTerm ) ) )
                    {
                    // InternalResoluteParser.g:3918:3: ( () otherlv_102= Solution ( (lv_name_103_0= RULE_ID ) ) otherlv_104= Colon ( (lv_val_105_0= ruleStringTerm ) ) )
                    // InternalResoluteParser.g:3919:4: () otherlv_102= Solution ( (lv_name_103_0= RULE_ID ) ) otherlv_104= Colon ( (lv_val_105_0= ruleStringTerm ) )
                    {
                    // InternalResoluteParser.g:3919:4: ()
                    // InternalResoluteParser.g:3920:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExprAccess().getSolutionExprAction_20_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_102=(Token)match(input,Solution,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_102, grammarAccess.getAtomicExprAccess().getSolutionKeyword_20_1());
                      			
                    }
                    // InternalResoluteParser.g:3930:4: ( (lv_name_103_0= RULE_ID ) )
                    // InternalResoluteParser.g:3931:5: (lv_name_103_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:3931:5: (lv_name_103_0= RULE_ID )
                    // InternalResoluteParser.g:3932:6: lv_name_103_0= RULE_ID
                    {
                    lv_name_103_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_103_0, grammarAccess.getAtomicExprAccess().getNameIDTerminalRuleCall_20_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_103_0,
                      							"org.osate.xtext.aadl2.properties.Properties.ID");
                      					
                    }

                    }


                    }

                    otherlv_104=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_104, grammarAccess.getAtomicExprAccess().getColonKeyword_20_3());
                      			
                    }
                    // InternalResoluteParser.g:3952:4: ( (lv_val_105_0= ruleStringTerm ) )
                    // InternalResoluteParser.g:3953:5: (lv_val_105_0= ruleStringTerm )
                    {
                    // InternalResoluteParser.g:3953:5: (lv_val_105_0= ruleStringTerm )
                    // InternalResoluteParser.g:3954:6: lv_val_105_0= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExprAccess().getValStringTermParserRuleCall_20_4_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_105_0=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      						}
                      						set(
                      							current,
                      							"val",
                      							lv_val_105_0,
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
    // InternalResoluteParser.g:3976:1: entryRuleLetBinding returns [EObject current=null] : iv_ruleLetBinding= ruleLetBinding EOF ;
    public final EObject entryRuleLetBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetBinding = null;


        try {
            // InternalResoluteParser.g:3976:51: (iv_ruleLetBinding= ruleLetBinding EOF )
            // InternalResoluteParser.g:3977:2: iv_ruleLetBinding= ruleLetBinding EOF
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
    // InternalResoluteParser.g:3983:1: ruleLetBinding returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleLetBinding() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:3989:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) )
            // InternalResoluteParser.g:3990:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // InternalResoluteParser.g:3990:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            // InternalResoluteParser.g:3991:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
            {
            // InternalResoluteParser.g:3991:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:3992:4: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:3992:4: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:3993:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,Colon,FollowSets000.FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLetBindingAccess().getColonKeyword_1());
              		
            }
            // InternalResoluteParser.g:4013:3: ( (lv_type_2_0= ruleType ) )
            // InternalResoluteParser.g:4014:4: (lv_type_2_0= ruleType )
            {
            // InternalResoluteParser.g:4014:4: (lv_type_2_0= ruleType )
            // InternalResoluteParser.g:4015:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetBindingAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_13);
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

            otherlv_3=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getLetBindingAccess().getEqualsSignKeyword_3());
              		
            }
            // InternalResoluteParser.g:4036:3: ( (lv_expr_4_0= ruleExpr ) )
            // InternalResoluteParser.g:4037:4: (lv_expr_4_0= ruleExpr )
            {
            // InternalResoluteParser.g:4037:4: (lv_expr_4_0= ruleExpr )
            // InternalResoluteParser.g:4038:5: lv_expr_4_0= ruleExpr
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


    // $ANTLR start "entryRuleBuiltInFn"
    // InternalResoluteParser.g:4059:1: entryRuleBuiltInFn returns [String current=null] : iv_ruleBuiltInFn= ruleBuiltInFn EOF ;
    public final String entryRuleBuiltInFn() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBuiltInFn = null;


        try {
            // InternalResoluteParser.g:4059:49: (iv_ruleBuiltInFn= ruleBuiltInFn EOF )
            // InternalResoluteParser.g:4060:2: iv_ruleBuiltInFn= ruleBuiltInFn EOF
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
    // InternalResoluteParser.g:4066:1: ruleBuiltInFn returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Min | kw= Max | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows ) ;
    public final AntlrDatatypeRuleToken ruleBuiltInFn() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:4072:2: ( (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Min | kw= Max | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows ) )
            // InternalResoluteParser.g:4073:2: (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Min | kw= Max | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows )
            {
            // InternalResoluteParser.g:4073:2: (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Min | kw= Max | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows )
            int alt56=68;
            switch ( input.LA(1) ) {
            case Has_property:
                {
                alt56=1;
                }
                break;
            case Property:
                {
                alt56=2;
                }
                break;
            case Property_member:
                {
                alt56=3;
                }
                break;
            case Has_parent:
                {
                alt56=4;
                }
                break;
            case Parent:
                {
                alt56=5;
                }
                break;
            case Name:
                {
                alt56=6;
                }
                break;
            case Type:
                {
                alt56=7;
                }
                break;
            case Has_type:
                {
                alt56=8;
                }
                break;
            case Is_in_array:
                {
                alt56=9;
                }
                break;
            case Has_prototypes:
                {
                alt56=10;
                }
                break;
            case Has_modes:
                {
                alt56=11;
                }
                break;
            case Is_processor:
                {
                alt56=12;
                }
                break;
            case Is_virtual_processor:
                {
                alt56=13;
                }
                break;
            case Is_system:
                {
                alt56=14;
                }
                break;
            case Is_bus:
                {
                alt56=15;
                }
                break;
            case Is_virtual_bus:
                {
                alt56=16;
                }
                break;
            case Is_device:
                {
                alt56=17;
                }
                break;
            case Is_memory:
                {
                alt56=18;
                }
                break;
            case Is_thread:
                {
                alt56=19;
                }
                break;
            case Is_thread_group:
                {
                alt56=20;
                }
                break;
            case Is_process:
                {
                alt56=21;
                }
                break;
            case Is_data:
                {
                alt56=22;
                }
                break;
            case Is_subprogram:
                {
                alt56=23;
                }
                break;
            case Is_of_type:
                {
                alt56=24;
                }
                break;
            case Is_bound_to:
                {
                alt56=25;
                }
                break;
            case Has_member:
                {
                alt56=26;
                }
                break;
            case Features:
                {
                alt56=27;
                }
                break;
            case Connections:
                {
                alt56=28;
                }
                break;
            case Enumerated_values:
                {
                alt56=29;
                }
                break;
            case Subcomponents:
                {
                alt56=30;
                }
                break;
            case Source:
                {
                alt56=31;
                }
                break;
            case Destination:
                {
                alt56=32;
                }
                break;
            case Is_bidirectional:
                {
                alt56=33;
                }
                break;
            case Direction:
                {
                alt56=34;
                }
                break;
            case Is_event_port:
                {
                alt56=35;
                }
                break;
            case Is_abstract_feature:
                {
                alt56=36;
                }
                break;
            case Is_data_port:
                {
                alt56=37;
                }
                break;
            case Is_port:
                {
                alt56=38;
                }
                break;
            case Is_data_access:
                {
                alt56=39;
                }
                break;
            case Is_bus_access:
                {
                alt56=40;
                }
                break;
            case Lower_bound:
                {
                alt56=41;
                }
                break;
            case Upper_bound:
                {
                alt56=42;
                }
                break;
            case Member:
                {
                alt56=43;
                }
                break;
            case Length:
                {
                alt56=44;
                }
                break;
            case Size:
                {
                alt56=45;
                }
                break;
            case Sum:
                {
                alt56=46;
                }
                break;
            case Min:
                {
                alt56=47;
                }
                break;
            case Max:
                {
                alt56=48;
                }
                break;
            case Append:
                {
                alt56=49;
                }
                break;
            case Head:
                {
                alt56=50;
                }
                break;
            case Tail:
                {
                alt56=51;
                }
                break;
            case As_set:
                {
                alt56=52;
                }
                break;
            case Union:
                {
                alt56=53;
                }
                break;
            case Intersect:
                {
                alt56=54;
                }
                break;
            case As_list:
                {
                alt56=55;
                }
                break;
            case Instance:
                {
                alt56=56;
                }
                break;
            case Instances:
                {
                alt56=57;
                }
                break;
            case Debug:
                {
                alt56=58;
                }
                break;
            case Analysis:
                {
                alt56=59;
                }
                break;
            case Receive_error:
                {
                alt56=60;
                }
                break;
            case Contain_error:
                {
                alt56=61;
                }
                break;
            case Propagate_error:
                {
                alt56=62;
                }
                break;
            case Error_state_reachable:
                {
                alt56=63;
                }
                break;
            case Flow_source:
                {
                alt56=64;
                }
                break;
            case Flow_destination:
                {
                alt56=65;
                }
                break;
            case Flow_elements:
                {
                alt56=66;
                }
                break;
            case Flow_specifications:
                {
                alt56=67;
                }
                break;
            case End_to_end_flows:
                {
                alt56=68;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalResoluteParser.g:4074:3: kw= Has_property
                    {
                    kw=(Token)match(input,Has_property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_propertyKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:4080:3: kw= Property
                    {
                    kw=(Token)match(input,Property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPropertyKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:4086:3: kw= Property_member
                    {
                    kw=(Token)match(input,Property_member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getProperty_memberKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:4092:3: kw= Has_parent
                    {
                    kw=(Token)match(input,Has_parent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_parentKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:4098:3: kw= Parent
                    {
                    kw=(Token)match(input,Parent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getParentKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:4104:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getNameKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:4110:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTypeKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalResoluteParser.g:4116:3: kw= Has_type
                    {
                    kw=(Token)match(input,Has_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_typeKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalResoluteParser.g:4122:3: kw= Is_in_array
                    {
                    kw=(Token)match(input,Is_in_array,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_in_arrayKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalResoluteParser.g:4128:3: kw= Has_prototypes
                    {
                    kw=(Token)match(input,Has_prototypes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_prototypesKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalResoluteParser.g:4134:3: kw= Has_modes
                    {
                    kw=(Token)match(input,Has_modes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_modesKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalResoluteParser.g:4140:3: kw= Is_processor
                    {
                    kw=(Token)match(input,Is_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_processorKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalResoluteParser.g:4146:3: kw= Is_virtual_processor
                    {
                    kw=(Token)match(input,Is_virtual_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_virtual_processorKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalResoluteParser.g:4152:3: kw= Is_system
                    {
                    kw=(Token)match(input,Is_system,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_systemKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalResoluteParser.g:4158:3: kw= Is_bus
                    {
                    kw=(Token)match(input,Is_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_busKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalResoluteParser.g:4164:3: kw= Is_virtual_bus
                    {
                    kw=(Token)match(input,Is_virtual_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_virtual_busKeyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalResoluteParser.g:4170:3: kw= Is_device
                    {
                    kw=(Token)match(input,Is_device,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_deviceKeyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalResoluteParser.g:4176:3: kw= Is_memory
                    {
                    kw=(Token)match(input,Is_memory,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_memoryKeyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalResoluteParser.g:4182:3: kw= Is_thread
                    {
                    kw=(Token)match(input,Is_thread,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_threadKeyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalResoluteParser.g:4188:3: kw= Is_thread_group
                    {
                    kw=(Token)match(input,Is_thread_group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_thread_groupKeyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalResoluteParser.g:4194:3: kw= Is_process
                    {
                    kw=(Token)match(input,Is_process,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_processKeyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalResoluteParser.g:4200:3: kw= Is_data
                    {
                    kw=(Token)match(input,Is_data,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_dataKeyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalResoluteParser.g:4206:3: kw= Is_subprogram
                    {
                    kw=(Token)match(input,Is_subprogram,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_subprogramKeyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalResoluteParser.g:4212:3: kw= Is_of_type
                    {
                    kw=(Token)match(input,Is_of_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_of_typeKeyword_23());
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalResoluteParser.g:4218:3: kw= Is_bound_to
                    {
                    kw=(Token)match(input,Is_bound_to,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bound_toKeyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalResoluteParser.g:4224:3: kw= Has_member
                    {
                    kw=(Token)match(input,Has_member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_memberKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalResoluteParser.g:4230:3: kw= Features
                    {
                    kw=(Token)match(input,Features,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFeaturesKeyword_26());
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalResoluteParser.g:4236:3: kw= Connections
                    {
                    kw=(Token)match(input,Connections,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getConnectionsKeyword_27());
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalResoluteParser.g:4242:3: kw= Enumerated_values
                    {
                    kw=(Token)match(input,Enumerated_values,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getEnumerated_valuesKeyword_28());
                      		
                    }

                    }
                    break;
                case 30 :
                    // InternalResoluteParser.g:4248:3: kw= Subcomponents
                    {
                    kw=(Token)match(input,Subcomponents,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSubcomponentsKeyword_29());
                      		
                    }

                    }
                    break;
                case 31 :
                    // InternalResoluteParser.g:4254:3: kw= Source
                    {
                    kw=(Token)match(input,Source,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSourceKeyword_30());
                      		
                    }

                    }
                    break;
                case 32 :
                    // InternalResoluteParser.g:4260:3: kw= Destination
                    {
                    kw=(Token)match(input,Destination,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDestinationKeyword_31());
                      		
                    }

                    }
                    break;
                case 33 :
                    // InternalResoluteParser.g:4266:3: kw= Is_bidirectional
                    {
                    kw=(Token)match(input,Is_bidirectional,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bidirectionalKeyword_32());
                      		
                    }

                    }
                    break;
                case 34 :
                    // InternalResoluteParser.g:4272:3: kw= Direction
                    {
                    kw=(Token)match(input,Direction,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDirectionKeyword_33());
                      		
                    }

                    }
                    break;
                case 35 :
                    // InternalResoluteParser.g:4278:3: kw= Is_event_port
                    {
                    kw=(Token)match(input,Is_event_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_event_portKeyword_34());
                      		
                    }

                    }
                    break;
                case 36 :
                    // InternalResoluteParser.g:4284:3: kw= Is_abstract_feature
                    {
                    kw=(Token)match(input,Is_abstract_feature,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_abstract_featureKeyword_35());
                      		
                    }

                    }
                    break;
                case 37 :
                    // InternalResoluteParser.g:4290:3: kw= Is_data_port
                    {
                    kw=(Token)match(input,Is_data_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_data_portKeyword_36());
                      		
                    }

                    }
                    break;
                case 38 :
                    // InternalResoluteParser.g:4296:3: kw= Is_port
                    {
                    kw=(Token)match(input,Is_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_portKeyword_37());
                      		
                    }

                    }
                    break;
                case 39 :
                    // InternalResoluteParser.g:4302:3: kw= Is_data_access
                    {
                    kw=(Token)match(input,Is_data_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_data_accessKeyword_38());
                      		
                    }

                    }
                    break;
                case 40 :
                    // InternalResoluteParser.g:4308:3: kw= Is_bus_access
                    {
                    kw=(Token)match(input,Is_bus_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bus_accessKeyword_39());
                      		
                    }

                    }
                    break;
                case 41 :
                    // InternalResoluteParser.g:4314:3: kw= Lower_bound
                    {
                    kw=(Token)match(input,Lower_bound,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getLower_boundKeyword_40());
                      		
                    }

                    }
                    break;
                case 42 :
                    // InternalResoluteParser.g:4320:3: kw= Upper_bound
                    {
                    kw=(Token)match(input,Upper_bound,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getUpper_boundKeyword_41());
                      		
                    }

                    }
                    break;
                case 43 :
                    // InternalResoluteParser.g:4326:3: kw= Member
                    {
                    kw=(Token)match(input,Member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMemberKeyword_42());
                      		
                    }

                    }
                    break;
                case 44 :
                    // InternalResoluteParser.g:4332:3: kw= Length
                    {
                    kw=(Token)match(input,Length,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getLengthKeyword_43());
                      		
                    }

                    }
                    break;
                case 45 :
                    // InternalResoluteParser.g:4338:3: kw= Size
                    {
                    kw=(Token)match(input,Size,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSizeKeyword_44());
                      		
                    }

                    }
                    break;
                case 46 :
                    // InternalResoluteParser.g:4344:3: kw= Sum
                    {
                    kw=(Token)match(input,Sum,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSumKeyword_45());
                      		
                    }

                    }
                    break;
                case 47 :
                    // InternalResoluteParser.g:4350:3: kw= Min
                    {
                    kw=(Token)match(input,Min,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMinKeyword_46());
                      		
                    }

                    }
                    break;
                case 48 :
                    // InternalResoluteParser.g:4356:3: kw= Max
                    {
                    kw=(Token)match(input,Max,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMaxKeyword_47());
                      		
                    }

                    }
                    break;
                case 49 :
                    // InternalResoluteParser.g:4362:3: kw= Append
                    {
                    kw=(Token)match(input,Append,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAppendKeyword_48());
                      		
                    }

                    }
                    break;
                case 50 :
                    // InternalResoluteParser.g:4368:3: kw= Head
                    {
                    kw=(Token)match(input,Head,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHeadKeyword_49());
                      		
                    }

                    }
                    break;
                case 51 :
                    // InternalResoluteParser.g:4374:3: kw= Tail
                    {
                    kw=(Token)match(input,Tail,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTailKeyword_50());
                      		
                    }

                    }
                    break;
                case 52 :
                    // InternalResoluteParser.g:4380:3: kw= As_set
                    {
                    kw=(Token)match(input,As_set,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAs_setKeyword_51());
                      		
                    }

                    }
                    break;
                case 53 :
                    // InternalResoluteParser.g:4386:3: kw= Union
                    {
                    kw=(Token)match(input,Union,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getUnionKeyword_52());
                      		
                    }

                    }
                    break;
                case 54 :
                    // InternalResoluteParser.g:4392:3: kw= Intersect
                    {
                    kw=(Token)match(input,Intersect,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIntersectKeyword_53());
                      		
                    }

                    }
                    break;
                case 55 :
                    // InternalResoluteParser.g:4398:3: kw= As_list
                    {
                    kw=(Token)match(input,As_list,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAs_listKeyword_54());
                      		
                    }

                    }
                    break;
                case 56 :
                    // InternalResoluteParser.g:4404:3: kw= Instance
                    {
                    kw=(Token)match(input,Instance,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstanceKeyword_55());
                      		
                    }

                    }
                    break;
                case 57 :
                    // InternalResoluteParser.g:4410:3: kw= Instances
                    {
                    kw=(Token)match(input,Instances,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstancesKeyword_56());
                      		
                    }

                    }
                    break;
                case 58 :
                    // InternalResoluteParser.g:4416:3: kw= Debug
                    {
                    kw=(Token)match(input,Debug,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDebugKeyword_57());
                      		
                    }

                    }
                    break;
                case 59 :
                    // InternalResoluteParser.g:4422:3: kw= Analysis
                    {
                    kw=(Token)match(input,Analysis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAnalysisKeyword_58());
                      		
                    }

                    }
                    break;
                case 60 :
                    // InternalResoluteParser.g:4428:3: kw= Receive_error
                    {
                    kw=(Token)match(input,Receive_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReceive_errorKeyword_59());
                      		
                    }

                    }
                    break;
                case 61 :
                    // InternalResoluteParser.g:4434:3: kw= Contain_error
                    {
                    kw=(Token)match(input,Contain_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getContain_errorKeyword_60());
                      		
                    }

                    }
                    break;
                case 62 :
                    // InternalResoluteParser.g:4440:3: kw= Propagate_error
                    {
                    kw=(Token)match(input,Propagate_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPropagate_errorKeyword_61());
                      		
                    }

                    }
                    break;
                case 63 :
                    // InternalResoluteParser.g:4446:3: kw= Error_state_reachable
                    {
                    kw=(Token)match(input,Error_state_reachable,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getError_state_reachableKeyword_62());
                      		
                    }

                    }
                    break;
                case 64 :
                    // InternalResoluteParser.g:4452:3: kw= Flow_source
                    {
                    kw=(Token)match(input,Flow_source,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_sourceKeyword_63());
                      		
                    }

                    }
                    break;
                case 65 :
                    // InternalResoluteParser.g:4458:3: kw= Flow_destination
                    {
                    kw=(Token)match(input,Flow_destination,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_destinationKeyword_64());
                      		
                    }

                    }
                    break;
                case 66 :
                    // InternalResoluteParser.g:4464:3: kw= Flow_elements
                    {
                    kw=(Token)match(input,Flow_elements,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_elementsKeyword_65());
                      		
                    }

                    }
                    break;
                case 67 :
                    // InternalResoluteParser.g:4470:3: kw= Flow_specifications
                    {
                    kw=(Token)match(input,Flow_specifications,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_specificationsKeyword_66());
                      		
                    }

                    }
                    break;
                case 68 :
                    // InternalResoluteParser.g:4476:3: kw= End_to_end_flows
                    {
                    kw=(Token)match(input,End_to_end_flows,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getEnd_to_end_flowsKeyword_67());
                      		
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
    // InternalResoluteParser.g:4485:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalResoluteParser.g:4485:49: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalResoluteParser.g:4486:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalResoluteParser.g:4492:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:4498:2: ( ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalResoluteParser.g:4499:2: ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalResoluteParser.g:4499:2: ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalResoluteParser.g:4500:3: ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalResoluteParser.g:4500:3: ( (lv_value_0_0= ruleUnsignedReal ) )
            // InternalResoluteParser.g:4501:4: (lv_value_0_0= ruleUnsignedReal )
            {
            // InternalResoluteParser.g:4501:4: (lv_value_0_0= ruleUnsignedReal )
            // InternalResoluteParser.g:4502:5: lv_value_0_0= ruleUnsignedReal
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRealTermAccess().getValueUnsignedRealParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_48);
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

            // InternalResoluteParser.g:4519:3: ( (otherlv_1= RULE_ID ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==EOF||LA57_1==Instanceof||(LA57_1>=Strategy && LA57_1<=Applies)||(LA57_1>=Ruleset && LA57_1<=Warning)||LA57_1==Orelse||LA57_1==Check||(LA57_1>=Delta && LA57_1<=Error)||LA57_1==Prove||LA57_1==Else||LA57_1==Goal||LA57_1==Info||LA57_1==Then||LA57_1==And||LA57_1==For||LA57_1==FullStopFullStop||(LA57_1>=LessThanSignEqualsSign && LA57_1<=GreaterThanSignEqualsSign)||(LA57_1>=In && LA57_1<=Or)||LA57_1==PercentSign||(LA57_1>=RightParenthesis && LA57_1<=HyphenMinus)||LA57_1==Solidus||(LA57_1>=Semicolon && LA57_1<=GreaterThanSign)||(LA57_1>=RightSquareBracket && LA57_1<=CircumflexAccent)||LA57_1==RightCurlyBracket||LA57_1==RULE_ID) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalResoluteParser.g:4520:4: (otherlv_1= RULE_ID )
                    {
                    // InternalResoluteParser.g:4520:4: (otherlv_1= RULE_ID )
                    // InternalResoluteParser.g:4521:5: otherlv_1= RULE_ID
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
    // InternalResoluteParser.g:4536:1: entryRuleUnsignedReal returns [String current=null] : iv_ruleUnsignedReal= ruleUnsignedReal EOF ;
    public final String entryRuleUnsignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnsignedReal = null;


        try {
            // InternalResoluteParser.g:4536:52: (iv_ruleUnsignedReal= ruleUnsignedReal EOF )
            // InternalResoluteParser.g:4537:2: iv_ruleUnsignedReal= ruleUnsignedReal EOF
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
    // InternalResoluteParser.g:4543:1: ruleUnsignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleUnsignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:4549:2: (this_REAL_LIT_0= RULE_REAL_LIT )
            // InternalResoluteParser.g:4550:2: this_REAL_LIT_0= RULE_REAL_LIT
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
    // InternalResoluteParser.g:4560:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalResoluteParser.g:4560:52: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalResoluteParser.g:4561:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalResoluteParser.g:4567:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:4573:2: ( ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalResoluteParser.g:4574:2: ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalResoluteParser.g:4574:2: ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalResoluteParser.g:4575:3: ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalResoluteParser.g:4575:3: ( (lv_value_0_0= ruleUnsignedInt ) )
            // InternalResoluteParser.g:4576:4: (lv_value_0_0= ruleUnsignedInt )
            {
            // InternalResoluteParser.g:4576:4: (lv_value_0_0= ruleUnsignedInt )
            // InternalResoluteParser.g:4577:5: lv_value_0_0= ruleUnsignedInt
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIntegerTermAccess().getValueUnsignedIntParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_48);
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

            // InternalResoluteParser.g:4594:3: ( (otherlv_1= RULE_ID ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==EOF||LA58_1==Instanceof||(LA58_1>=Strategy && LA58_1<=Applies)||(LA58_1>=Ruleset && LA58_1<=Warning)||LA58_1==Orelse||LA58_1==Check||(LA58_1>=Delta && LA58_1<=Error)||LA58_1==Prove||LA58_1==Else||LA58_1==Goal||LA58_1==Info||LA58_1==Then||LA58_1==And||LA58_1==For||LA58_1==FullStopFullStop||(LA58_1>=LessThanSignEqualsSign && LA58_1<=GreaterThanSignEqualsSign)||(LA58_1>=In && LA58_1<=Or)||LA58_1==PercentSign||(LA58_1>=RightParenthesis && LA58_1<=HyphenMinus)||LA58_1==Solidus||(LA58_1>=Semicolon && LA58_1<=GreaterThanSign)||(LA58_1>=RightSquareBracket && LA58_1<=CircumflexAccent)||LA58_1==RightCurlyBracket||LA58_1==RULE_ID) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // InternalResoluteParser.g:4595:4: (otherlv_1= RULE_ID )
                    {
                    // InternalResoluteParser.g:4595:4: (otherlv_1= RULE_ID )
                    // InternalResoluteParser.g:4596:5: otherlv_1= RULE_ID
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
    // InternalResoluteParser.g:4611:1: entryRuleUnsignedInt returns [String current=null] : iv_ruleUnsignedInt= ruleUnsignedInt EOF ;
    public final String entryRuleUnsignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnsignedInt = null;


        try {
            // InternalResoluteParser.g:4611:51: (iv_ruleUnsignedInt= ruleUnsignedInt EOF )
            // InternalResoluteParser.g:4612:2: iv_ruleUnsignedInt= ruleUnsignedInt EOF
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
    // InternalResoluteParser.g:4618:1: ruleUnsignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleUnsignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:4624:2: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalResoluteParser.g:4625:2: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalResoluteParser.g:4635:1: entryRuleResoluteSubclause returns [EObject current=null] : iv_ruleResoluteSubclause= ruleResoluteSubclause EOF ;
    public final EObject entryRuleResoluteSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResoluteSubclause = null;


        try {
            // InternalResoluteParser.g:4635:58: (iv_ruleResoluteSubclause= ruleResoluteSubclause EOF )
            // InternalResoluteParser.g:4636:2: iv_ruleResoluteSubclause= ruleResoluteSubclause EOF
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
    // InternalResoluteParser.g:4642:1: ruleResoluteSubclause returns [EObject current=null] : ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* ) ;
    public final EObject ruleResoluteSubclause() throws RecognitionException {
        EObject current = null;

        EObject lv_proves_1_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:4648:2: ( ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* ) )
            // InternalResoluteParser.g:4649:2: ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* )
            {
            // InternalResoluteParser.g:4649:2: ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* )
            // InternalResoluteParser.g:4650:3: () ( (lv_proves_1_0= ruleAnalysisStatement ) )*
            {
            // InternalResoluteParser.g:4650:3: ()
            // InternalResoluteParser.g:4651:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getResoluteSubclauseAccess().getResoluteSubclauseAction_0(),
              					current);
              			
            }

            }

            // InternalResoluteParser.g:4657:3: ( (lv_proves_1_0= ruleAnalysisStatement ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==Check||LA59_0==Prove) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalResoluteParser.g:4658:4: (lv_proves_1_0= ruleAnalysisStatement )
            	    {
            	    // InternalResoluteParser.g:4658:4: (lv_proves_1_0= ruleAnalysisStatement )
            	    // InternalResoluteParser.g:4659:5: lv_proves_1_0= ruleAnalysisStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getResoluteSubclauseAccess().getProvesAnalysisStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_49);
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
    // $ANTLR end "ruleResoluteSubclause"


    // $ANTLR start "entryRuleNestedDotID"
    // InternalResoluteParser.g:4680:1: entryRuleNestedDotID returns [EObject current=null] : iv_ruleNestedDotID= ruleNestedDotID EOF ;
    public final EObject entryRuleNestedDotID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedDotID = null;


        try {
            // InternalResoluteParser.g:4680:52: (iv_ruleNestedDotID= ruleNestedDotID EOF )
            // InternalResoluteParser.g:4681:2: iv_ruleNestedDotID= ruleNestedDotID EOF
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
    // InternalResoluteParser.g:4687:1: ruleNestedDotID returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? ) ;
    public final EObject ruleNestedDotID() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_sub_2_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:4693:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? ) )
            // InternalResoluteParser.g:4694:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? )
            {
            // InternalResoluteParser.g:4694:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? )
            // InternalResoluteParser.g:4695:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )?
            {
            // InternalResoluteParser.g:4695:3: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:4696:4: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:4696:4: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:4697:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getNestedDotIDRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getNestedDotIDAccess().getBaseNamedElementCrossReference_0_0());
              				
            }

            }


            }

            // InternalResoluteParser.g:4708:3: (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==FullStop) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalResoluteParser.g:4709:4: otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) )
                    {
                    otherlv_1=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getNestedDotIDAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalResoluteParser.g:4713:4: ( (lv_sub_2_0= ruleNestedDotID ) )
                    // InternalResoluteParser.g:4714:5: (lv_sub_2_0= ruleNestedDotID )
                    {
                    // InternalResoluteParser.g:4714:5: (lv_sub_2_0= ruleNestedDotID )
                    // InternalResoluteParser.g:4715:6: lv_sub_2_0= ruleNestedDotID
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
    // InternalResoluteParser.g:4737:1: entryRuleLintStatement returns [EObject current=null] : iv_ruleLintStatement= ruleLintStatement EOF ;
    public final EObject entryRuleLintStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLintStatement = null;


        try {
            // InternalResoluteParser.g:4737:54: (iv_ruleLintStatement= ruleLintStatement EOF )
            // InternalResoluteParser.g:4738:2: iv_ruleLintStatement= ruleLintStatement EOF
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
    // InternalResoluteParser.g:4744:1: ruleLintStatement returns [EObject current=null] : ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) ) ;
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
            // InternalResoluteParser.g:4750:2: ( ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:4751:2: ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:4751:2: ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) )
            int alt61=3;
            switch ( input.LA(1) ) {
            case Warning:
                {
                alt61=1;
                }
                break;
            case Error:
                {
                alt61=2;
                }
                break;
            case Info:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalResoluteParser.g:4752:3: ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4752:3: ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4753:4: () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4753:4: ()
                    // InternalResoluteParser.g:4754:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLintStatementAccess().getWarningStatementAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,Warning,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getLintStatementAccess().getWarningKeyword_0_1());
                      			
                    }
                    // InternalResoluteParser.g:4764:4: ( (lv_expr_2_0= ruleExpr ) )
                    // InternalResoluteParser.g:4765:5: (lv_expr_2_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4765:5: (lv_expr_2_0= ruleExpr )
                    // InternalResoluteParser.g:4766:6: lv_expr_2_0= ruleExpr
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
                    // InternalResoluteParser.g:4785:3: ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4785:3: ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4786:4: () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4786:4: ()
                    // InternalResoluteParser.g:4787:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLintStatementAccess().getErrorStatementAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,Error,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getLintStatementAccess().getErrorKeyword_1_1());
                      			
                    }
                    // InternalResoluteParser.g:4797:4: ( (lv_expr_5_0= ruleExpr ) )
                    // InternalResoluteParser.g:4798:5: (lv_expr_5_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4798:5: (lv_expr_5_0= ruleExpr )
                    // InternalResoluteParser.g:4799:6: lv_expr_5_0= ruleExpr
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
                    // InternalResoluteParser.g:4818:3: ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4818:3: ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4819:4: () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4819:4: ()
                    // InternalResoluteParser.g:4820:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLintStatementAccess().getInfoStatementAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,Info,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getLintStatementAccess().getInfoKeyword_2_1());
                      			
                    }
                    // InternalResoluteParser.g:4830:4: ( (lv_expr_8_0= ruleExpr ) )
                    // InternalResoluteParser.g:4831:5: (lv_expr_8_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4831:5: (lv_expr_8_0= ruleExpr )
                    // InternalResoluteParser.g:4832:6: lv_expr_8_0= ruleExpr
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
    // InternalResoluteParser.g:4854:1: entryRuleRuleset returns [EObject current=null] : iv_ruleRuleset= ruleRuleset EOF ;
    public final EObject entryRuleRuleset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleset = null;


        try {
            // InternalResoluteParser.g:4854:48: (iv_ruleRuleset= ruleRuleset EOF )
            // InternalResoluteParser.g:4855:2: iv_ruleRuleset= ruleRuleset EOF
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
    // InternalResoluteParser.g:4861:1: ruleRuleset returns [EObject current=null] : (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleRuleset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:4867:2: ( (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket ) )
            // InternalResoluteParser.g:4868:2: (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket )
            {
            // InternalResoluteParser.g:4868:2: (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket )
            // InternalResoluteParser.g:4869:3: otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,Ruleset,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRulesetAccess().getRulesetKeyword_0());
              		
            }
            // InternalResoluteParser.g:4873:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:4874:4: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:4874:4: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:4875:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_50); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRulesetAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalResoluteParser.g:4895:3: ( (lv_body_3_0= ruleRulesetBody ) )
            // InternalResoluteParser.g:4896:4: (lv_body_3_0= ruleRulesetBody )
            {
            // InternalResoluteParser.g:4896:4: (lv_body_3_0= ruleRulesetBody )
            // InternalResoluteParser.g:4897:5: lv_body_3_0= ruleRulesetBody
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRulesetAccess().getBodyRulesetBodyParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_6);
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
    // InternalResoluteParser.g:4922:1: entryRuleRulesetBody returns [EObject current=null] : iv_ruleRulesetBody= ruleRulesetBody EOF ;
    public final EObject entryRuleRulesetBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRulesetBody = null;


        try {
            // InternalResoluteParser.g:4922:52: (iv_ruleRulesetBody= ruleRulesetBody EOF )
            // InternalResoluteParser.g:4923:2: iv_ruleRulesetBody= ruleRulesetBody EOF
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
    // InternalResoluteParser.g:4929:1: ruleRulesetBody returns [EObject current=null] : ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* ) ;
    public final EObject ruleRulesetBody() throws RecognitionException {
        EObject current = null;

        EObject lv_lintStatements_1_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:4935:2: ( ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* ) )
            // InternalResoluteParser.g:4936:2: ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* )
            {
            // InternalResoluteParser.g:4936:2: ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* )
            // InternalResoluteParser.g:4937:3: () ( (lv_lintStatements_1_0= ruleLintStatement ) )*
            {
            // InternalResoluteParser.g:4937:3: ()
            // InternalResoluteParser.g:4938:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRulesetBodyAccess().getRulesetBodyAction_0(),
              					current);
              			
            }

            }

            // InternalResoluteParser.g:4944:3: ( (lv_lintStatements_1_0= ruleLintStatement ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==Warning||LA62_0==Error||LA62_0==Info) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalResoluteParser.g:4945:4: (lv_lintStatements_1_0= ruleLintStatement )
            	    {
            	    // InternalResoluteParser.g:4945:4: (lv_lintStatements_1_0= ruleLintStatement )
            	    // InternalResoluteParser.g:4946:5: lv_lintStatements_1_0= ruleLintStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRulesetBodyAccess().getLintStatementsLintStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_52);
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
            	    break loop62;
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
    // InternalResoluteParser.g:4967:1: entryRuleAnalysisStatement returns [EObject current=null] : iv_ruleAnalysisStatement= ruleAnalysisStatement EOF ;
    public final EObject entryRuleAnalysisStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnalysisStatement = null;


        try {
            // InternalResoluteParser.g:4967:58: (iv_ruleAnalysisStatement= ruleAnalysisStatement EOF )
            // InternalResoluteParser.g:4968:2: iv_ruleAnalysisStatement= ruleAnalysisStatement EOF
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
    // InternalResoluteParser.g:4974:1: ruleAnalysisStatement returns [EObject current=null] : ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) ) ;
    public final EObject ruleAnalysisStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expr_2_0 = null;

        EObject lv_expr_5_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:4980:2: ( ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:4981:2: ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:4981:2: ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==Prove) ) {
                alt63=1;
            }
            else if ( (LA63_0==Check) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalResoluteParser.g:4982:3: ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4982:3: ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4983:4: () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4983:4: ()
                    // InternalResoluteParser.g:4984:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAnalysisStatementAccess().getProveStatementAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,Prove,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAnalysisStatementAccess().getProveKeyword_0_1());
                      			
                    }
                    // InternalResoluteParser.g:4994:4: ( (lv_expr_2_0= ruleExpr ) )
                    // InternalResoluteParser.g:4995:5: (lv_expr_2_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4995:5: (lv_expr_2_0= ruleExpr )
                    // InternalResoluteParser.g:4996:6: lv_expr_2_0= ruleExpr
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
                    // InternalResoluteParser.g:5015:3: ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:5015:3: ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:5016:4: () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:5016:4: ()
                    // InternalResoluteParser.g:5017:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAnalysisStatementAccess().getCheckStatementAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,Check,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getAnalysisStatementAccess().getCheckKeyword_1_1());
                      			
                    }
                    // InternalResoluteParser.g:5027:4: ( (lv_expr_5_0= ruleExpr ) )
                    // InternalResoluteParser.g:5028:5: (lv_expr_5_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:5028:5: (lv_expr_5_0= ruleExpr )
                    // InternalResoluteParser.g:5029:6: lv_expr_5_0= ruleExpr
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
    // InternalResoluteParser.g:5051:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalResoluteParser.g:5051:69: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalResoluteParser.g:5052:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalResoluteParser.g:5058:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) ;
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
            // InternalResoluteParser.g:5064:2: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) )
            // InternalResoluteParser.g:5065:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            {
            // InternalResoluteParser.g:5065:2: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            // InternalResoluteParser.g:5066:3: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon
            {
            // InternalResoluteParser.g:5066:3: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:5067:4: ( ruleQPREF )
            {
            // InternalResoluteParser.g:5067:4: ( ruleQPREF )
            // InternalResoluteParser.g:5068:5: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_53);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalResoluteParser.g:5082:3: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==EqualsSignGreaterThanSign) ) {
                alt64=1;
            }
            else if ( (LA64_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalResoluteParser.g:5083:4: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:5088:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalResoluteParser.g:5088:4: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalResoluteParser.g:5089:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalResoluteParser.g:5089:5: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalResoluteParser.g:5090:6: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      						}
                      						setWithLastConsumed(current, "append", lv_append_2_0 != null, "+=>");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalResoluteParser.g:5103:3: ( (lv_constant_3_0= Constant ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==Constant) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalResoluteParser.g:5104:4: (lv_constant_3_0= Constant )
                    {
                    // InternalResoluteParser.g:5104:4: (lv_constant_3_0= Constant )
                    // InternalResoluteParser.g:5105:5: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FollowSets000.FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      					}
                      					setWithLastConsumed(current, "constant", lv_constant_3_0 != null, "constant");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalResoluteParser.g:5117:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalResoluteParser.g:5118:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalResoluteParser.g:5118:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalResoluteParser.g:5119:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalResoluteParser.g:5119:5: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalResoluteParser.g:5120:6: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
              					
            }
            pushFollow(FollowSets000.FOLLOW_55);
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

            // InternalResoluteParser.g:5137:4: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==Comma) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalResoluteParser.g:5138:5: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_54); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	      				
            	    }
            	    // InternalResoluteParser.g:5142:5: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalResoluteParser.g:5143:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalResoluteParser.g:5143:6: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalResoluteParser.g:5144:7: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_55);
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
            	    break loop66;
                }
            } while (true);


            }

            // InternalResoluteParser.g:5163:3: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==Applies) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalResoluteParser.g:5164:4: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_10);
                    ruleAppliesToKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalResoluteParser.g:5171:4: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalResoluteParser.g:5172:5: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalResoluteParser.g:5172:5: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalResoluteParser.g:5173:6: lv_appliesTo_8_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_56);
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

                    // InternalResoluteParser.g:5190:4: (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==Comma) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalResoluteParser.g:5191:5: otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalResoluteParser.g:5195:5: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalResoluteParser.g:5196:6: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalResoluteParser.g:5196:6: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalResoluteParser.g:5197:7: lv_appliesTo_10_0= ruleContainmentPath
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_56);
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
                    	    break loop67;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalResoluteParser.g:5216:3: ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==In) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalResoluteParser.g:5217:4: ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    ruleInBindingKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_12=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
                      			
                    }
                    // InternalResoluteParser.g:5228:4: ( ( ruleQCREF ) )
                    // InternalResoluteParser.g:5229:5: ( ruleQCREF )
                    {
                    // InternalResoluteParser.g:5229:5: ( ruleQCREF )
                    // InternalResoluteParser.g:5230:6: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_35);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_23); if (state.failed) return current;
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
    // InternalResoluteParser.g:5257:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalResoluteParser.g:5257:56: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalResoluteParser.g:5258:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalResoluteParser.g:5264:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:5270:2: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalResoluteParser.g:5271:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalResoluteParser.g:5271:2: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalResoluteParser.g:5272:3: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalResoluteParser.g:5272:3: (lv_path_0_0= ruleContainmentPathElement )
            // InternalResoluteParser.g:5273:4: lv_path_0_0= ruleContainmentPathElement
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
    // InternalResoluteParser.g:5293:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalResoluteParser.g:5293:67: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalResoluteParser.g:5294:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalResoluteParser.g:5300:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) ;
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
            // InternalResoluteParser.g:5306:2: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) )
            // InternalResoluteParser.g:5307:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            {
            // InternalResoluteParser.g:5307:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            // InternalResoluteParser.g:5308:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            {
            // InternalResoluteParser.g:5308:3: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:5309:4: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:5309:4: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalResoluteParser.g:5310:5: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_57);
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

            // InternalResoluteParser.g:5327:3: ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==In) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==Modes) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // InternalResoluteParser.g:5328:4: ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModesKeywordsParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    ruleInModesKeywords();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_2=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_1());
                      			
                    }
                    // InternalResoluteParser.g:5339:4: ( (otherlv_3= RULE_ID ) )
                    // InternalResoluteParser.g:5340:5: (otherlv_3= RULE_ID )
                    {
                    // InternalResoluteParser.g:5340:5: (otherlv_3= RULE_ID )
                    // InternalResoluteParser.g:5341:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_2_0());
                      					
                    }

                    }


                    }

                    // InternalResoluteParser.g:5352:4: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==Comma) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalResoluteParser.g:5353:5: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
                    	      				
                    	    }
                    	    // InternalResoluteParser.g:5357:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalResoluteParser.g:5358:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalResoluteParser.g:5358:6: (otherlv_5= RULE_ID )
                    	    // InternalResoluteParser.g:5359:7: otherlv_5= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	      							}
                    	      						
                    	    }
                    	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_1_0());
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
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
    // InternalResoluteParser.g:5380:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalResoluteParser.g:5380:54: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalResoluteParser.g:5381:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalResoluteParser.g:5387:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:5393:2: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalResoluteParser.g:5394:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalResoluteParser.g:5394:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:5395:3: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:5395:3: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalResoluteParser.g:5396:4: lv_ownedValue_0_0= rulePropertyExpression
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
    // InternalResoluteParser.g:5416:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalResoluteParser.g:5416:59: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalResoluteParser.g:5417:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalResoluteParser.g:5423:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
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
            // InternalResoluteParser.g:5429:2: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalResoluteParser.g:5430:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalResoluteParser.g:5430:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt72=11;
            alt72 = dfa72.predict(input);
            switch (alt72) {
                case 1 :
                    // InternalResoluteParser.g:5431:3: this_RecordTerm_0= ruleRecordTerm
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
                    // InternalResoluteParser.g:5440:3: this_ReferenceTerm_1= ruleReferenceTerm
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
                    // InternalResoluteParser.g:5449:3: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
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
                    // InternalResoluteParser.g:5458:3: this_ComputedTerm_3= ruleComputedTerm
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
                    // InternalResoluteParser.g:5467:3: this_StringTerm_4= ruleStringTerm
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
                    // InternalResoluteParser.g:5476:3: this_NumericRangeTerm_5= ruleNumericRangeTerm
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
                    // InternalResoluteParser.g:5485:3: this_RealTerm_6= ruleRealTerm
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
                    // InternalResoluteParser.g:5494:3: this_IntegerTerm_7= ruleIntegerTerm
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
                    // InternalResoluteParser.g:5503:3: this_ListTerm_8= ruleListTerm
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
                    // InternalResoluteParser.g:5512:3: this_BooleanLiteral_9= ruleBooleanLiteral
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
                    // InternalResoluteParser.g:5521:3: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
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
    // InternalResoluteParser.g:5533:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalResoluteParser.g:5533:63: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalResoluteParser.g:5534:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
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
    // InternalResoluteParser.g:5540:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalResoluteParser.g:5546:2: ( ( ( ruleQPREF ) ) )
            // InternalResoluteParser.g:5547:2: ( ( ruleQPREF ) )
            {
            // InternalResoluteParser.g:5547:2: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:5548:3: ( ruleQPREF )
            {
            // InternalResoluteParser.g:5548:3: ( ruleQPREF )
            // InternalResoluteParser.g:5549:4: ruleQPREF
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
    // InternalResoluteParser.g:5566:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalResoluteParser.g:5566:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalResoluteParser.g:5567:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalResoluteParser.g:5573:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:5579:2: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalResoluteParser.g:5580:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalResoluteParser.g:5580:2: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalResoluteParser.g:5581:3: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalResoluteParser.g:5581:3: ()
            // InternalResoluteParser.g:5582:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalResoluteParser.g:5588:3: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==True) ) {
                alt73=1;
            }
            else if ( (LA73_0==False) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalResoluteParser.g:5589:4: ( (lv_value_1_0= True ) )
                    {
                    // InternalResoluteParser.g:5589:4: ( (lv_value_1_0= True ) )
                    // InternalResoluteParser.g:5590:5: (lv_value_1_0= True )
                    {
                    // InternalResoluteParser.g:5590:5: (lv_value_1_0= True )
                    // InternalResoluteParser.g:5591:6: lv_value_1_0= True
                    {
                    lv_value_1_0=(Token)match(input,True,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_1_0 != null, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:5604:4: otherlv_2= False
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
    // InternalResoluteParser.g:5613:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalResoluteParser.g:5613:54: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalResoluteParser.g:5614:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalResoluteParser.g:5620:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalResoluteParser.g:5626:2: ( ( ( ruleQPREF ) ) )
            // InternalResoluteParser.g:5627:2: ( ( ruleQPREF ) )
            {
            // InternalResoluteParser.g:5627:2: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:5628:3: ( ruleQPREF )
            {
            // InternalResoluteParser.g:5628:3: ( ruleQPREF )
            // InternalResoluteParser.g:5629:4: ruleQPREF
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
    // InternalResoluteParser.g:5646:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalResoluteParser.g:5646:54: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalResoluteParser.g:5647:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
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
    // InternalResoluteParser.g:5653:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:5659:2: ( (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:5660:2: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:5660:2: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:5661:3: otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Reference,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalResoluteParser.g:5669:3: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalResoluteParser.g:5670:4: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalResoluteParser.g:5670:4: (lv_path_2_0= ruleContainmentPathElement )
            // InternalResoluteParser.g:5671:5: lv_path_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_35);
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
    // InternalResoluteParser.g:5696:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalResoluteParser.g:5696:51: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalResoluteParser.g:5697:2: iv_ruleRecordTerm= ruleRecordTerm EOF
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
    // InternalResoluteParser.g:5703:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:5709:2: ( (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) )
            // InternalResoluteParser.g:5710:2: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            {
            // InternalResoluteParser.g:5710:2: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            // InternalResoluteParser.g:5711:3: otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
              		
            }
            // InternalResoluteParser.g:5715:3: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_ID) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalResoluteParser.g:5716:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalResoluteParser.g:5716:4: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalResoluteParser.g:5717:5: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_58);
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
            	    if ( cnt74 >= 1 ) break loop74;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
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
    // InternalResoluteParser.g:5742:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalResoluteParser.g:5742:53: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalResoluteParser.g:5743:2: iv_ruleComputedTerm= ruleComputedTerm EOF
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
    // InternalResoluteParser.g:5749:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:5755:2: ( (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:5756:2: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:5756:2: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:5757:3: otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Compute,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalResoluteParser.g:5765:3: ( (lv_function_2_0= RULE_ID ) )
            // InternalResoluteParser.g:5766:4: (lv_function_2_0= RULE_ID )
            {
            // InternalResoluteParser.g:5766:4: (lv_function_2_0= RULE_ID )
            // InternalResoluteParser.g:5767:5: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_35); if (state.failed) return current;
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
    // InternalResoluteParser.g:5791:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalResoluteParser.g:5791:64: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalResoluteParser.g:5792:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
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
    // InternalResoluteParser.g:5798:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:5804:2: ( (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:5805:2: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:5805:2: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:5806:3: otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Classifier,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalResoluteParser.g:5814:3: ( ( ruleQCREF ) )
            // InternalResoluteParser.g:5815:4: ( ruleQCREF )
            {
            // InternalResoluteParser.g:5815:4: ( ruleQCREF )
            // InternalResoluteParser.g:5816:5: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getComponentClassifierTermRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_35);
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
    // InternalResoluteParser.g:5838:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalResoluteParser.g:5838:49: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalResoluteParser.g:5839:2: iv_ruleListTerm= ruleListTerm EOF
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
    // InternalResoluteParser.g:5845:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:5851:2: ( ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) )
            // InternalResoluteParser.g:5852:2: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            {
            // InternalResoluteParser.g:5852:2: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            // InternalResoluteParser.g:5853:3: () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis
            {
            // InternalResoluteParser.g:5853:3: ()
            // InternalResoluteParser.g:5854:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getListTermAccess().getListValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalResoluteParser.g:5864:3: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==Classifier||LA76_0==Reference||LA76_0==Compute||LA76_0==False||LA76_0==True||LA76_0==LeftParenthesis||LA76_0==PlusSign||LA76_0==HyphenMinus||LA76_0==LeftSquareBracket||LA76_0==RULE_REAL_LIT||LA76_0==RULE_INTEGER_LIT||(LA76_0>=RULE_STRING && LA76_0<=RULE_ID)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalResoluteParser.g:5865:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalResoluteParser.g:5865:4: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalResoluteParser.g:5866:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalResoluteParser.g:5866:5: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalResoluteParser.g:5867:6: lv_ownedListElement_2_0= rulePropertyExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
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

                    // InternalResoluteParser.g:5884:4: (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==Comma) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // InternalResoluteParser.g:5885:5: otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_54); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalResoluteParser.g:5889:5: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalResoluteParser.g:5890:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalResoluteParser.g:5890:6: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalResoluteParser.g:5891:7: lv_ownedListElement_4_0= rulePropertyExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_16);
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
                    	    break loop75;
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
    // InternalResoluteParser.g:5918:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalResoluteParser.g:5918:65: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalResoluteParser.g:5919:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalResoluteParser.g:5925:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:5931:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalResoluteParser.g:5932:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalResoluteParser.g:5932:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalResoluteParser.g:5933:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalResoluteParser.g:5933:3: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:5934:4: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:5934:4: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:5935:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
              		
            }
            // InternalResoluteParser.g:5950:3: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:5951:4: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:5951:4: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalResoluteParser.g:5952:5: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_23);
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
    // InternalResoluteParser.g:5977:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalResoluteParser.g:5977:63: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalResoluteParser.g:5978:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalResoluteParser.g:5984:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:5990:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalResoluteParser.g:5991:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalResoluteParser.g:5991:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalResoluteParser.g:5992:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalResoluteParser.g:5992:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalResoluteParser.g:5993:4: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalResoluteParser.g:5993:4: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:5994:5: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:5994:5: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:5995:6: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getContainmentPathElementRule());
              						}
              					
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_61); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());
              					
            }

            }


            }

            // InternalResoluteParser.g:6006:4: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==LeftSquareBracket) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalResoluteParser.g:6007:5: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalResoluteParser.g:6007:5: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalResoluteParser.g:6008:6: lv_arrayRange_1_0= ruleArrayRange
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_61);
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
            	    break loop77;
                }
            } while (true);


            }

            // InternalResoluteParser.g:6026:3: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==FullStop) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalResoluteParser.g:6027:4: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                      			
                    }
                    // InternalResoluteParser.g:6031:4: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalResoluteParser.g:6032:5: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalResoluteParser.g:6032:5: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalResoluteParser.g:6033:6: lv_path_3_0= ruleContainmentPathElement
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
    // InternalResoluteParser.g:6055:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalResoluteParser.g:6055:49: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalResoluteParser.g:6056:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalResoluteParser.g:6062:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6068:2: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalResoluteParser.g:6069:2: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalResoluteParser.g:6069:2: (kw= PlusSign | kw= HyphenMinus )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==PlusSign) ) {
                alt79=1;
            }
            else if ( (LA79_0==HyphenMinus) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalResoluteParser.g:6070:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:6076:3: kw= HyphenMinus
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
    // InternalResoluteParser.g:6085:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalResoluteParser.g:6085:51: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalResoluteParser.g:6086:2: iv_ruleStringTerm= ruleStringTerm EOF
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
    // InternalResoluteParser.g:6092:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:6098:2: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalResoluteParser.g:6099:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalResoluteParser.g:6099:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalResoluteParser.g:6100:3: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalResoluteParser.g:6100:3: (lv_value_0_0= ruleNoQuoteString )
            // InternalResoluteParser.g:6101:4: lv_value_0_0= ruleNoQuoteString
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
    // InternalResoluteParser.g:6121:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalResoluteParser.g:6121:53: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalResoluteParser.g:6122:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalResoluteParser.g:6128:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6134:2: (this_STRING_0= RULE_STRING )
            // InternalResoluteParser.g:6135:2: this_STRING_0= RULE_STRING
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
    // InternalResoluteParser.g:6145:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalResoluteParser.g:6145:51: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalResoluteParser.g:6146:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalResoluteParser.g:6152:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:6158:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalResoluteParser.g:6159:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalResoluteParser.g:6159:2: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalResoluteParser.g:6160:3: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalResoluteParser.g:6160:3: ()
            // InternalResoluteParser.g:6161:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalResoluteParser.g:6171:3: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalResoluteParser.g:6172:4: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalResoluteParser.g:6172:4: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalResoluteParser.g:6173:5: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_63);
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

            // InternalResoluteParser.g:6190:3: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==FullStopFullStop) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalResoluteParser.g:6191:4: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_62); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                      			
                    }
                    // InternalResoluteParser.g:6195:4: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalResoluteParser.g:6196:5: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalResoluteParser.g:6196:5: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalResoluteParser.g:6197:6: lv_upperBound_4_0= ruleINTVALUE
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_5);
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
    // InternalResoluteParser.g:6223:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalResoluteParser.g:6223:55: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalResoluteParser.g:6224:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalResoluteParser.g:6230:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:6236:2: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalResoluteParser.g:6237:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalResoluteParser.g:6237:2: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalResoluteParser.g:6238:3: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalResoluteParser.g:6238:3: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalResoluteParser.g:6239:4: (lv_op_0_0= rulePlusMinus )
            {
            // InternalResoluteParser.g:6239:4: (lv_op_0_0= rulePlusMinus )
            // InternalResoluteParser.g:6240:5: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_64);
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

            // InternalResoluteParser.g:6257:3: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalResoluteParser.g:6258:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalResoluteParser.g:6258:4: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalResoluteParser.g:6259:5: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalResoluteParser.g:6280:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalResoluteParser.g:6280:57: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalResoluteParser.g:6281:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
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
    // InternalResoluteParser.g:6287:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:6293:2: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalResoluteParser.g:6294:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalResoluteParser.g:6294:2: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalResoluteParser.g:6295:3: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalResoluteParser.g:6295:3: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalResoluteParser.g:6296:4: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalResoluteParser.g:6296:4: (lv_minimum_0_0= ruleNumAlt )
            // InternalResoluteParser.g:6297:5: lv_minimum_0_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_65);
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

            otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
              		
            }
            // InternalResoluteParser.g:6318:3: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalResoluteParser.g:6319:4: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalResoluteParser.g:6319:4: (lv_maximum_2_0= ruleNumAlt )
            // InternalResoluteParser.g:6320:5: lv_maximum_2_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_66);
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

            // InternalResoluteParser.g:6337:3: (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==Delta) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalResoluteParser.g:6338:4: otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,Delta,FollowSets000.FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                      			
                    }
                    // InternalResoluteParser.g:6342:4: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalResoluteParser.g:6343:5: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalResoluteParser.g:6343:5: (lv_delta_4_0= ruleNumAlt )
                    // InternalResoluteParser.g:6344:6: lv_delta_4_0= ruleNumAlt
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
    // InternalResoluteParser.g:6366:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalResoluteParser.g:6366:47: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalResoluteParser.g:6367:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalResoluteParser.g:6373:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;



        	enterRule();

        try {
            // InternalResoluteParser.g:6379:2: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalResoluteParser.g:6380:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalResoluteParser.g:6380:2: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt82=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_LIT:
                {
                alt82=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt82=2;
                }
                break;
            case PlusSign:
            case HyphenMinus:
                {
                alt82=3;
                }
                break;
            case RULE_ID:
                {
                alt82=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalResoluteParser.g:6381:3: this_RealTerm_0= ruleRealTerm
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
                    // InternalResoluteParser.g:6390:3: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalResoluteParser.g:6399:3: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalResoluteParser.g:6408:3: this_ConstantValue_3= ruleConstantValue
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
    // InternalResoluteParser.g:6420:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalResoluteParser.g:6420:57: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalResoluteParser.g:6421:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
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
    // InternalResoluteParser.g:6427:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Applies kw= To ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6433:2: ( (kw= Applies kw= To ) )
            // InternalResoluteParser.g:6434:2: (kw= Applies kw= To )
            {
            // InternalResoluteParser.g:6434:2: (kw= Applies kw= To )
            // InternalResoluteParser.g:6435:3: kw= Applies kw= To
            {
            kw=(Token)match(input,Applies,FollowSets000.FOLLOW_67); if (state.failed) return current;
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
    // InternalResoluteParser.g:6449:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalResoluteParser.g:6449:57: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalResoluteParser.g:6450:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
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
    // InternalResoluteParser.g:6456:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Binding ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6462:2: ( (kw= In kw= Binding ) )
            // InternalResoluteParser.g:6463:2: (kw= In kw= Binding )
            {
            // InternalResoluteParser.g:6463:2: (kw= In kw= Binding )
            // InternalResoluteParser.g:6464:3: kw= In kw= Binding
            {
            kw=(Token)match(input,In,FollowSets000.FOLLOW_68); if (state.failed) return current;
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
    // InternalResoluteParser.g:6478:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalResoluteParser.g:6478:55: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalResoluteParser.g:6479:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
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
    // InternalResoluteParser.g:6485:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Modes ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6491:2: ( (kw= In kw= Modes ) )
            // InternalResoluteParser.g:6492:2: (kw= In kw= Modes )
            {
            // InternalResoluteParser.g:6492:2: (kw= In kw= Modes )
            // InternalResoluteParser.g:6493:3: kw= In kw= Modes
            {
            kw=(Token)match(input,In,FollowSets000.FOLLOW_69); if (state.failed) return current;
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
    // InternalResoluteParser.g:6507:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalResoluteParser.g:6507:48: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalResoluteParser.g:6508:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalResoluteParser.g:6514:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6520:2: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalResoluteParser.g:6521:2: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalResoluteParser.g:6531:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalResoluteParser.g:6531:45: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalResoluteParser.g:6532:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalResoluteParser.g:6538:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6544:2: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalResoluteParser.g:6545:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalResoluteParser.g:6545:2: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalResoluteParser.g:6546:3: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalResoluteParser.g:6553:3: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==ColonColon) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalResoluteParser.g:6554:4: kw= ColonColon this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_10); if (state.failed) return current;
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
    // InternalResoluteParser.g:6571:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalResoluteParser.g:6571:45: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalResoluteParser.g:6572:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalResoluteParser.g:6578:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6584:2: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalResoluteParser.g:6585:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalResoluteParser.g:6585:2: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalResoluteParser.g:6586:3: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalResoluteParser.g:6586:3: (this_ID_0= RULE_ID kw= ColonColon )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==RULE_ID) ) {
                    int LA84_1 = input.LA(2);

                    if ( (LA84_1==ColonColon) ) {
                        alt84=1;
                    }


                }


                switch (alt84) {
            	case 1 :
            	    // InternalResoluteParser.g:6587:4: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_71); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_0);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
            	      			
            	    }
            	    kw=(Token)match(input,ColonColon,FollowSets000.FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
              		
            }
            // InternalResoluteParser.g:6607:3: (kw= FullStop this_ID_4= RULE_ID )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==FullStop) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalResoluteParser.g:6608:4: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
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
    // InternalResoluteParser.g:6625:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalResoluteParser.g:6625:44: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalResoluteParser.g:6626:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalResoluteParser.g:6632:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalResoluteParser.g:6638:2: (kw= Asterisk )
            // InternalResoluteParser.g:6639:2: kw= Asterisk
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
        // InternalResoluteParser.g:896:4: ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )
        // InternalResoluteParser.g:896:5: ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) )
        {
        // InternalResoluteParser.g:896:5: ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) )
        // InternalResoluteParser.g:897:5: ( ( RULE_ID ) ) Colon ( ( ruleType ) )
        {
        // InternalResoluteParser.g:897:5: ( ( RULE_ID ) )
        // InternalResoluteParser.g:898:6: ( RULE_ID )
        {
        // InternalResoluteParser.g:898:6: ( RULE_ID )
        // InternalResoluteParser.g:899:7: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return ;

        }


        }

        match(input,Colon,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // InternalResoluteParser.g:903:5: ( ( ruleType ) )
        // InternalResoluteParser.g:904:6: ( ruleType )
        {
        // InternalResoluteParser.g:904:6: ( ruleType )
        // InternalResoluteParser.g:905:7: ruleType
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
        // InternalResoluteParser.g:1870:5: ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )
        // InternalResoluteParser.g:1870:6: ( () ( ( EqualsSignGreaterThanSign ) ) )
        {
        // InternalResoluteParser.g:1870:6: ( () ( ( EqualsSignGreaterThanSign ) ) )
        // InternalResoluteParser.g:1871:6: () ( ( EqualsSignGreaterThanSign ) )
        {
        // InternalResoluteParser.g:1871:6: ()
        // InternalResoluteParser.g:1872:6: 
        {
        }

        // InternalResoluteParser.g:1873:6: ( ( EqualsSignGreaterThanSign ) )
        // InternalResoluteParser.g:1874:7: ( EqualsSignGreaterThanSign )
        {
        // InternalResoluteParser.g:1874:7: ( EqualsSignGreaterThanSign )
        // InternalResoluteParser.g:1875:8: EqualsSignGreaterThanSign
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
        // InternalResoluteParser.g:1953:5: ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )
        // InternalResoluteParser.g:1953:6: ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) )
        {
        // InternalResoluteParser.g:1953:6: ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) )
        // InternalResoluteParser.g:1954:6: () ( ( ( Or ) ) | ( ( Orelse ) ) )
        {
        // InternalResoluteParser.g:1954:6: ()
        // InternalResoluteParser.g:1955:6: 
        {
        }

        // InternalResoluteParser.g:1956:6: ( ( ( Or ) ) | ( ( Orelse ) ) )
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( (LA86_0==Or) ) {
            alt86=1;
        }
        else if ( (LA86_0==Orelse) ) {
            alt86=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 86, 0, input);

            throw nvae;
        }
        switch (alt86) {
            case 1 :
                // InternalResoluteParser.g:1957:7: ( ( Or ) )
                {
                // InternalResoluteParser.g:1957:7: ( ( Or ) )
                // InternalResoluteParser.g:1958:8: ( Or )
                {
                // InternalResoluteParser.g:1958:8: ( Or )
                // InternalResoluteParser.g:1959:9: Or
                {
                match(input,Or,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalResoluteParser.g:1963:7: ( ( Orelse ) )
                {
                // InternalResoluteParser.g:1963:7: ( ( Orelse ) )
                // InternalResoluteParser.g:1964:8: ( Orelse )
                {
                // InternalResoluteParser.g:1964:8: ( Orelse )
                // InternalResoluteParser.g:1965:9: Orelse
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
        // InternalResoluteParser.g:2061:5: ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )
        // InternalResoluteParser.g:2061:6: ( () ( ( ( And ) ) | ( ( Andthen ) ) ) )
        {
        // InternalResoluteParser.g:2061:6: ( () ( ( ( And ) ) | ( ( Andthen ) ) ) )
        // InternalResoluteParser.g:2062:6: () ( ( ( And ) ) | ( ( Andthen ) ) )
        {
        // InternalResoluteParser.g:2062:6: ()
        // InternalResoluteParser.g:2063:6: 
        {
        }

        // InternalResoluteParser.g:2064:6: ( ( ( And ) ) | ( ( Andthen ) ) )
        int alt87=2;
        int LA87_0 = input.LA(1);

        if ( (LA87_0==And) ) {
            alt87=1;
        }
        else if ( (LA87_0==Andthen) ) {
            alt87=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 87, 0, input);

            throw nvae;
        }
        switch (alt87) {
            case 1 :
                // InternalResoluteParser.g:2065:7: ( ( And ) )
                {
                // InternalResoluteParser.g:2065:7: ( ( And ) )
                // InternalResoluteParser.g:2066:8: ( And )
                {
                // InternalResoluteParser.g:2066:8: ( And )
                // InternalResoluteParser.g:2067:9: And
                {
                match(input,And,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalResoluteParser.g:2071:7: ( ( Andthen ) )
                {
                // InternalResoluteParser.g:2071:7: ( ( Andthen ) )
                // InternalResoluteParser.g:2072:8: ( Andthen )
                {
                // InternalResoluteParser.g:2072:8: ( Andthen )
                // InternalResoluteParser.g:2073:9: Andthen
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
        // InternalResoluteParser.g:2169:5: ( ( () Instanceof ) )
        // InternalResoluteParser.g:2169:6: ( () Instanceof )
        {
        // InternalResoluteParser.g:2169:6: ( () Instanceof )
        // InternalResoluteParser.g:2170:6: () Instanceof
        {
        // InternalResoluteParser.g:2170:6: ()
        // InternalResoluteParser.g:2171:6: 
        {
        }

        match(input,Instanceof,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalResoluteParser

    // $ANTLR start synpred6_InternalResoluteParser
    public final void synpred6_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:2292:5: ( ( () ( ( ruleRelationalOp ) ) ) )
        // InternalResoluteParser.g:2292:6: ( () ( ( ruleRelationalOp ) ) )
        {
        // InternalResoluteParser.g:2292:6: ( () ( ( ruleRelationalOp ) ) )
        // InternalResoluteParser.g:2293:6: () ( ( ruleRelationalOp ) )
        {
        // InternalResoluteParser.g:2293:6: ()
        // InternalResoluteParser.g:2294:6: 
        {
        }

        // InternalResoluteParser.g:2295:6: ( ( ruleRelationalOp ) )
        // InternalResoluteParser.g:2296:7: ( ruleRelationalOp )
        {
        // InternalResoluteParser.g:2296:7: ( ruleRelationalOp )
        // InternalResoluteParser.g:2297:8: ruleRelationalOp
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
        // InternalResoluteParser.g:2380:5: ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )
        // InternalResoluteParser.g:2380:6: ( () ( ( ( PlusSign | HyphenMinus ) ) ) )
        {
        // InternalResoluteParser.g:2380:6: ( () ( ( ( PlusSign | HyphenMinus ) ) ) )
        // InternalResoluteParser.g:2381:6: () ( ( ( PlusSign | HyphenMinus ) ) )
        {
        // InternalResoluteParser.g:2381:6: ()
        // InternalResoluteParser.g:2382:6: 
        {
        }

        // InternalResoluteParser.g:2383:6: ( ( ( PlusSign | HyphenMinus ) ) )
        // InternalResoluteParser.g:2384:7: ( ( PlusSign | HyphenMinus ) )
        {
        // InternalResoluteParser.g:2384:7: ( ( PlusSign | HyphenMinus ) )
        // InternalResoluteParser.g:2385:8: ( PlusSign | HyphenMinus )
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
        // InternalResoluteParser.g:2480:5: ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )
        // InternalResoluteParser.g:2480:6: ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) )
        {
        // InternalResoluteParser.g:2480:6: ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) )
        // InternalResoluteParser.g:2481:6: () ( ( ( Asterisk | Solidus | PercentSign ) ) )
        {
        // InternalResoluteParser.g:2481:6: ()
        // InternalResoluteParser.g:2482:6: 
        {
        }

        // InternalResoluteParser.g:2483:6: ( ( ( Asterisk | Solidus | PercentSign ) ) )
        // InternalResoluteParser.g:2484:7: ( ( Asterisk | Solidus | PercentSign ) )
        {
        // InternalResoluteParser.g:2484:7: ( ( Asterisk | Solidus | PercentSign ) )
        // InternalResoluteParser.g:2485:8: ( Asterisk | Solidus | PercentSign )
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
        // InternalResoluteParser.g:2593:5: ( ( () ( ( CircumflexAccent ) ) ) )
        // InternalResoluteParser.g:2593:6: ( () ( ( CircumflexAccent ) ) )
        {
        // InternalResoluteParser.g:2593:6: ( () ( ( CircumflexAccent ) ) )
        // InternalResoluteParser.g:2594:6: () ( ( CircumflexAccent ) )
        {
        // InternalResoluteParser.g:2594:6: ()
        // InternalResoluteParser.g:2595:6: 
        {
        }

        // InternalResoluteParser.g:2596:6: ( ( CircumflexAccent ) )
        // InternalResoluteParser.g:2597:7: ( CircumflexAccent )
        {
        // InternalResoluteParser.g:2597:7: ( CircumflexAccent )
        // InternalResoluteParser.g:2598:8: CircumflexAccent
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
        // InternalResoluteParser.g:3220:4: ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )
        // InternalResoluteParser.g:3220:5: ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis )
        {
        // InternalResoluteParser.g:3220:5: ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis )
        // InternalResoluteParser.g:3221:5: () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis
        {
        // InternalResoluteParser.g:3221:5: ()
        // InternalResoluteParser.g:3222:5: 
        {
        }

        // InternalResoluteParser.g:3223:5: ( ( RULE_ID ) )
        // InternalResoluteParser.g:3224:6: ( RULE_ID )
        {
        // InternalResoluteParser.g:3224:6: ( RULE_ID )
        // InternalResoluteParser.g:3225:7: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return ;

        }


        }

        match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return ;
        // InternalResoluteParser.g:3229:5: ( ( RULE_ID ) )
        // InternalResoluteParser.g:3230:6: ( RULE_ID )
        {
        // InternalResoluteParser.g:3230:6: ( RULE_ID )
        // InternalResoluteParser.g:3231:7: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return ;
        // InternalResoluteParser.g:3235:5: ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )?
        int alt89=2;
        int LA89_0 = input.LA(1);

        if ( ((LA89_0>=Error_state_reachable && LA89_0<=Is_virtual_processor)||(LA89_0>=Flow_specifications && LA89_0<=Is_abstract_feature)||LA89_0==Enumerated_values||(LA89_0>=End_to_end_flows && LA89_0<=Is_bidirectional)||(LA89_0>=Is_thread_group && LA89_0<=Contain_error)||(LA89_0>=Flow_elements && LA89_0<=Is_subprogram)||(LA89_0>=Receive_error && LA89_0<=Is_processor)||LA89_0==Connections||(LA89_0>=Destination && LA89_0<=Upper_bound)||(LA89_0>=Has_member && LA89_0<=Has_parent)||(LA89_0>=Is_of_type && LA89_0<=Is_process)||(LA89_0>=Direction && LA89_0<=Is_thread)||LA89_0==Analysis||(LA89_0>=Features && LA89_0<=Solution)||LA89_0==As_list||(LA89_0>=Is_data && LA89_0<=Is_port)||LA89_0==Warning||(LA89_0>=Append && LA89_0<=As_set)||(LA89_0>=Exists && LA89_0<=Member)||(LA89_0>=Parent && LA89_0<=Source)||LA89_0==Debug||(LA89_0>=Error && LA89_0<=False)||LA89_0==Union||LA89_0==Fail||(LA89_0>=Head && LA89_0<=Name)||(LA89_0>=Size && LA89_0<=Tail)||(LA89_0>=This && LA89_0<=Type)||(LA89_0>=Let && LA89_0<=Sum)||LA89_0==If||LA89_0==LeftParenthesis||LA89_0==HyphenMinus||LA89_0==LeftSquareBracket||LA89_0==LeftCurlyBracket||LA89_0==RULE_REAL_LIT||LA89_0==RULE_INTEGER_LIT||(LA89_0>=RULE_STRING && LA89_0<=RULE_ID)) ) {
            alt89=1;
        }
        switch (alt89) {
            case 1 :
                // InternalResoluteParser.g:3236:6: ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )*
                {
                // InternalResoluteParser.g:3236:6: ( ( ruleExpr ) )
                // InternalResoluteParser.g:3237:7: ( ruleExpr )
                {
                // InternalResoluteParser.g:3237:7: ( ruleExpr )
                // InternalResoluteParser.g:3238:8: ruleExpr
                {
                pushFollow(FollowSets000.FOLLOW_16);
                ruleExpr();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalResoluteParser.g:3241:6: ( Comma ( ( ruleExpr ) ) )*
                loop88:
                do {
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==Comma) ) {
                        alt88=1;
                    }


                    switch (alt88) {
                	case 1 :
                	    // InternalResoluteParser.g:3242:7: Comma ( ( ruleExpr ) )
                	    {
                	    match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return ;
                	    // InternalResoluteParser.g:3243:7: ( ( ruleExpr ) )
                	    // InternalResoluteParser.g:3244:8: ( ruleExpr )
                	    {
                	    // InternalResoluteParser.g:3244:8: ( ruleExpr )
                	    // InternalResoluteParser.g:3245:9: ruleExpr
                	    {
                	    pushFollow(FollowSets000.FOLLOW_16);
                	    ruleExpr();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop88;
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


    protected DFA55 dfa55 = new DFA55(this);
    protected DFA72 dfa72 = new DFA72(this);
    static final String dfa_1s = "\33\uffff";
    static final String dfa_2s = "\1\uffff\1\22\27\uffff\1\22\1\uffff";
    static final String dfa_3s = "\1\11\1\77\12\uffff\2\11\6\uffff\1\u00c0\4\uffff\1\77\1\uffff";
    static final String dfa_4s = "\2\u00c0\12\uffff\2\u00c0\6\uffff\1\u00c0\4\uffff\1\u00c0\1\uffff";
    static final String dfa_5s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\13\1\15\2\uffff\1\22\1\23\1\24\1\25\1\1\1\14\1\uffff\1\20\1\16\1\17\1\21\1\uffff\1\12";
    static final String dfa_6s = "\31\uffff\1\0\1\uffff}>";
    static final String[] dfa_7s = {
            "\2\12\2\uffff\2\12\3\uffff\1\12\2\uffff\3\12\3\uffff\7\12\1\uffff\4\12\1\uffff\5\12\1\uffff\1\12\1\uffff\5\12\1\20\1\12\6\uffff\2\12\1\uffff\2\12\3\uffff\10\12\3\uffff\1\12\1\uffff\4\12\1\21\3\uffff\1\12\4\uffff\2\12\2\uffff\1\13\1\uffff\2\12\1\uffff\2\11\3\12\2\uffff\2\12\4\uffff\1\12\1\uffff\1\13\1\6\3\uffff\1\12\4\uffff\1\3\1\uffff\1\12\1\13\1\12\2\uffff\2\12\1\uffff\1\2\1\6\1\12\5\uffff\1\16\2\12\1\uffff\1\12\7\uffff\1\10\4\uffff\1\17\14\uffff\1\14\2\uffff\1\15\6\uffff\1\5\1\uffff\1\4\1\uffff\1\7\1\1",
            "\1\22\27\uffff\2\22\11\uffff\2\22\12\uffff\1\22\5\uffff\1\22\2\uffff\1\22\2\uffff\1\22\5\uffff\1\22\1\uffff\1\22\1\uffff\1\22\5\uffff\1\22\4\uffff\1\22\1\uffff\1\22\10\uffff\5\22\2\uffff\1\22\1\uffff\1\22\1\23\5\22\1\24\1\22\1\uffff\4\22\1\uffff\2\22\2\uffff\1\22\11\uffff\1\22",
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
            "\2\26\2\uffff\2\26\3\uffff\1\26\2\uffff\3\26\3\uffff\7\26\1\uffff\4\26\1\uffff\5\26\1\uffff\1\26\1\uffff\7\26\6\uffff\2\26\1\uffff\2\26\3\uffff\10\26\3\uffff\1\26\1\uffff\5\26\3\uffff\1\26\4\uffff\2\26\2\uffff\1\26\1\uffff\2\26\1\uffff\5\26\2\uffff\2\26\4\uffff\1\26\1\uffff\2\26\3\uffff\1\26\4\uffff\1\26\1\uffff\3\26\2\uffff\2\26\1\uffff\3\26\5\uffff\5\26\7\uffff\1\26\4\uffff\1\26\4\uffff\1\26\7\uffff\1\26\1\25\1\uffff\1\26\6\uffff\1\26\1\uffff\1\26\1\uffff\2\26",
            "\2\27\2\uffff\2\27\3\uffff\1\27\2\uffff\3\27\3\uffff\7\27\1\uffff\4\27\1\uffff\5\27\1\uffff\1\27\1\uffff\7\27\6\uffff\2\27\1\uffff\2\27\3\uffff\10\27\3\uffff\1\27\1\uffff\5\27\3\uffff\1\27\4\uffff\2\27\2\uffff\1\27\1\uffff\2\27\1\uffff\5\27\2\uffff\2\27\4\uffff\1\27\1\uffff\2\27\3\uffff\1\27\4\uffff\1\27\1\uffff\3\27\2\uffff\2\27\1\uffff\3\27\5\uffff\5\27\7\uffff\1\27\4\uffff\1\27\4\uffff\1\27\7\uffff\1\27\2\uffff\1\27\1\uffff\1\30\4\uffff\1\27\1\uffff\1\27\1\uffff\2\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\31",
            "",
            "",
            "",
            "",
            "\1\22\27\uffff\2\22\11\uffff\2\22\12\uffff\1\22\5\uffff\1\22\2\uffff\1\22\2\uffff\1\22\5\uffff\1\22\1\uffff\1\22\1\uffff\1\22\5\uffff\1\22\4\uffff\1\22\1\uffff\1\22\11\uffff\4\22\2\uffff\1\22\1\uffff\1\22\1\32\5\22\1\uffff\1\22\1\uffff\4\22\1\uffff\2\22\2\uffff\1\22\11\uffff\1\22",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2804:2: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) | ( () otherlv_100= Undeveloped ) | ( () otherlv_102= Solution ( (lv_name_103_0= RULE_ID ) ) otherlv_104= Colon ( (lv_val_105_0= ruleStringTerm ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA55_25 = input.LA(1);

                         
                        int index55_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA55_25==EOF||LA55_25==Instanceof||(LA55_25>=Strategy && LA55_25<=Andthen)||(LA55_25>=Ruleset && LA55_25<=Warning)||LA55_25==Orelse||LA55_25==Check||LA55_25==Error||LA55_25==Prove||LA55_25==Else||LA55_25==Goal||LA55_25==Info||LA55_25==Then||LA55_25==And||LA55_25==For||(LA55_25>=LessThanSignEqualsSign && LA55_25<=GreaterThanSignEqualsSign)||LA55_25==Or||LA55_25==PercentSign||(LA55_25>=RightParenthesis && LA55_25<=HyphenMinus)||LA55_25==Solidus||(LA55_25>=Semicolon && LA55_25<=GreaterThanSign)||(LA55_25>=RightSquareBracket && LA55_25<=CircumflexAccent)||LA55_25==RightCurlyBracket||LA55_25==RULE_ID) ) {s = 18;}

                        else if ( (LA55_25==LeftParenthesis) && (synpred10_InternalResoluteParser())) {s = 26;}

                         
                        input.seek(index55_25);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 55, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\23\uffff";
    static final String dfa_9s = "\6\uffff\1\15\1\17\1\uffff\1\21\2\uffff\1\15\1\uffff\1\17\3\uffff\1\21";
    static final String dfa_10s = "\1\72\5\uffff\2\131\1\uffff\1\131\2\uffff\1\131\1\uffff\1\131\1\uffff\1\u00c0\1\uffff\1\131";
    static final String dfa_11s = "\1\u00c0\5\uffff\2\u00c0\1\uffff\1\u00ad\2\uffff\1\u00ad\1\uffff\1\u00ad\1\uffff\1\u00c0\1\uffff\1\u00ad";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\6\1\uffff\1\11\1\12\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_13s = "\23\uffff}>";
    static final String[] dfa_14s = {
            "\1\3\23\uffff\1\2\15\uffff\1\4\33\uffff\1\13\23\uffff\1\13\27\uffff\1\12\2\uffff\1\10\1\uffff\1\10\7\uffff\1\1\11\uffff\1\6\1\uffff\1\7\1\uffff\1\5\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\15\77\uffff\1\10\6\uffff\1\15\4\uffff\1\15\2\uffff\1\15\4\uffff\1\15\22\uffff\1\14",
            "\1\17\77\uffff\1\10\6\uffff\1\17\4\uffff\1\17\2\uffff\1\17\4\uffff\1\17\22\uffff\1\16",
            "",
            "\1\21\77\uffff\1\10\1\20\5\uffff\1\21\4\uffff\1\21\2\uffff\1\21\4\uffff\1\21",
            "",
            "",
            "\1\15\77\uffff\1\10\6\uffff\1\15\4\uffff\1\15\2\uffff\1\15\4\uffff\1\15",
            "",
            "\1\17\77\uffff\1\10\6\uffff\1\17\4\uffff\1\17\2\uffff\1\17\4\uffff\1\17",
            "",
            "\1\22",
            "",
            "\1\21\77\uffff\1\10\6\uffff\1\21\4\uffff\1\21\2\uffff\1\21\4\uffff\1\21"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA72 extends DFA {

        public DFA72(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 72;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "5430:2: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0000000400800000L,0x0000000000000004L,0x0000000000000001L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x1A80A004071B99F0L,0xE80E20924020A01CL,0x00120000000500C0L,0x0000000000000001L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000400000000000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x607F5F7BF8E46600L,0x11A19F69847D1FE3L,0xA812021080F83B3AL,0x0000000000000001L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000012000000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100008000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000001000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x617F5FFBF8E46600L,0x11A19F69A4FD1FE3L,0xA812021080F83B3AL,0x0000000000000001L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000800000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000020000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000400000000000L,0x0000000200000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x1A80A004071B99F0L,0xE80E20924020A01CL,0x00000000000500C0L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0001C00058000000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000028000000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000084800000000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0008000000000000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000040000000000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x607F5F7BF8E46600L,0x11A19F69847D1FE3L,0xA812021081F83B3AL,0x0000000000000001L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000041000000000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x607F5F7BF8E46600L,0x11A19F69847D1FE3L,0xA812023080F83B3AL,0x0000000000000001L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004010000020000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0024001000000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004010000000000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040010000020000L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0060001000000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0040010000000000L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0410000000000000L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0010000000000000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0080000800000000L,0x0040000000000010L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0080000800000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020004000L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0400000000000000L,0x0100000010024000L,0xA802029000001000L,0x0000000000000001L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L,0x0000210100000000L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000210100000000L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000100000000L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0400000000000000L,0x0100000010024000L,0xA80202B000001000L,0x0000000000000001L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0002040000000000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000002000000L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2800028000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400000000L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000004000000L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    }


}