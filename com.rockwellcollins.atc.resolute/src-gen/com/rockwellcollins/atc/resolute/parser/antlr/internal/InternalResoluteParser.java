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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Provides_subprogram_group_access", "Requires_subprogram_group_access", "Provides_subprogram_access", "Requires_subprogram_access", "Subprogram_group_access", "Revised_without_review", "Error_state_reachable", "Is_virtual_processor", "Provides_data_access", "Requires_data_access", "Flow_specifications", "Is_abstract_feature", "Provides_bus_access", "Requires_bus_access", "Revised_with_review", "Flow_specification", "Enumerated_values", "Subprogram_access", "Virtual_processor", "End_to_end_flows", "Flow_destination", "Is_bidirectional", "Subprogram_group", "End_to_end_flow", "Event_data_port", "Is_thread_group", "Propagate_error", "Property_member", "Has_prototypes", "Is_data_access", "Is_virtual_bus", "Contain_error", "Feature_group", "Flow_elements", "Indeterminate", "Is_bus_access", "Is_event_port", "Is_subprogram", "Justification", "Receive_error", "Subcomponents", "Has_property", "Is_data_port", "Is_processor", "Thread_group", "Connections", "Data_access", "Destination", "Flow_source", "Is_bound_to", "Is_in_array", "Lower_bound", "Restriction", "Structuring", "Undeveloped", "Upper_bound", "Virtual_bus", "Assumption", "Bus_access", "Classifier", "Conclusion", "Connection", "Event_port", "Has_member", "Has_parent", "Identifier", "Instanceof", "Is_of_type", "Is_process", "Subprogram", "Component", "Data_port", "Direction", "Has_modes", "Instances", "Intersect", "Is_device", "Is_memory", "Is_system", "Is_thread", "Processor", "Rationale", "Reference", "Abstract", "Activity", "Analysis", "Constant", "Evidence", "Features", "Has_type", "Instance", "Notation", "Property", "Solution", "Strategy", "Andthen", "Applies", "As_list", "Binding", "Compute", "Context", "Feature", "Is_data", "Is_port", "Pattern", "Process", "Ruleset", "Warning", "Access", "Append", "As_set", "Device", "Domain", "Entity", "Exists", "Failed", "Forall", "Is_bus", "Length", "Member", "Memory", "Orelse", "Parent", "Passed", "Source", "String", "KW_System", "Thread", "Agent", "Check", "Claim", "Debug", "Delta", "Error", "False", "Modes", "Prove", "Range", "Thing", "Union", "Aadl", "Bool", "Data", "Else", "Fail", "Goal", "Head", "Info", "Name", "Port", "Real", "Size", "Tail", "Then", "This", "True", "Type", "PlusSignEqualsSignGreaterThanSign", "And", "Bus", "For", "Gsn", "Int", "Let", "Not", "Sum", "AsteriskAsterisk", "FullStopFullStop", "ColonColon", "LessThanSignEqualsSign", "LessThanSignGreaterThanSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "If", "In", "Jp", "Or", "To", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Entity=117;
    public static final int Requires_subprogram_group_access=5;
    public static final int Or=180;
    public static final int EqualsSignGreaterThanSign=175;
    public static final int Memory=124;
    public static final int Size=155;
    public static final int Activity=88;
    public static final int String=129;
    public static final int Feature=105;
    public static final int LessThanSign=193;
    public static final int Has_member=67;
    public static final int Data_port=75;
    public static final int PlusSignEqualsSignGreaterThanSign=161;
    public static final int Justification=42;
    public static final int Then=157;
    public static final int Thing=142;
    public static final int Structuring=57;
    public static final int GreaterThanSign=195;
    public static final int Head=150;
    public static final int RULE_ID=211;
    public static final int Sum=169;
    public static final int GreaterThanSignEqualsSign=176;
    public static final int Flow_elements=37;
    public static final int ColonColon=172;
    public static final int Is_data=106;
    public static final int Has_property=45;
    public static final int Analysis=89;
    public static final int Ruleset=110;
    public static final int Processor=84;
    public static final int Instance=94;
    public static final int RULE_REAL_LIT=206;
    public static final int Property_member=31;
    public static final int Classifier=63;
    public static final int Union=143;
    public static final int Tail=156;
    public static final int Event_port=66;
    public static final int Solidus=190;
    public static final int RightCurlyBracket=201;
    public static final int Context=104;
    public static final int Bus=163;
    public static final int FullStop=189;
    public static final int Is_thread=83;
    public static final int Has_modes=77;
    public static final int Connection=65;
    public static final int Provides_bus_access=16;
    public static final int Semicolon=192;
    public static final int RULE_EXPONENT=204;
    public static final int Append=113;
    public static final int As_list=101;
    public static final int Length=122;
    public static final int Delta=136;
    public static final int Is_virtual_processor=11;
    public static final int Flow_specifications=14;
    public static final int Passed=127;
    public static final int End_to_end_flows=23;
    public static final int Receive_error=43;
    public static final int Port=153;
    public static final int Subprogram_group=26;
    public static final int Process=109;
    public static final int Requires_subprogram_access=7;
    public static final int Name=152;
    public static final int RULE_INT_EXPONENT=205;
    public static final int Enumerated_values=20;
    public static final int Identifier=69;
    public static final int FullStopFullStop=171;
    public static final int This=158;
    public static final int To=181;
    public static final int Binding=102;
    public static final int Flow_destination=24;
    public static final int Subprogram_group_access=8;
    public static final int Failed=119;
    public static final int For=164;
    public static final int RightParenthesis=184;
    public static final int Is_event_port=40;
    public static final int Not=168;
    public static final int AsteriskAsterisk=170;
    public static final int Subcomponents=44;
    public static final int Is_data_port=46;
    public static final int Subprogram=73;
    public static final int Domain=116;
    public static final int Parent=126;
    public static final int RULE_SL_COMMENT=202;
    public static final int Provides_subprogram_group_access=4;
    public static final int Bus_access=62;
    public static final int Has_parent=68;
    public static final int Aadl=144;
    public static final int Evidence=91;
    public static final int Features=92;
    public static final int Rationale=85;
    public static final int Colon=191;
    public static final int Component=74;
    public static final int EOF=-1;
    public static final int Asterisk=185;
    public static final int Gsn=165;
    public static final int LeftCurlyBracket=199;
    public static final int Info=151;
    public static final int End_to_end_flow=27;
    public static final int Feature_group=36;
    public static final int CircumflexAccent=198;
    public static final int Flow_source=52;
    public static final int Is_thread_group=29;
    public static final int Is_system=82;
    public static final int Exists=118;
    public static final int Virtual_processor=22;
    public static final int Orelse=125;
    public static final int Connections=49;
    public static final int LessThanSignGreaterThanSign=174;
    public static final int Is_port=107;
    public static final int Data_access=50;
    public static final int KW_System=130;
    public static final int Access=112;
    public static final int Check=133;
    public static final int Provides_data_access=12;
    public static final int False=138;
    public static final int Thread_group=48;
    public static final int Goal=149;
    public static final int LeftParenthesis=183;
    public static final int Bool=145;
    public static final int Is_bus=121;
    public static final int Requires_bus_access=17;
    public static final int Fail=148;
    public static final int Agent=132;
    public static final int Is_virtual_bus=34;
    public static final int RULE_DIGIT=203;
    public static final int Has_prototypes=32;
    public static final int Is_bus_access=39;
    public static final int VerticalLine=200;
    public static final int Is_bidirectional=25;
    public static final int PlusSign=186;
    public static final int Is_data_access=33;
    public static final int LeftSquareBracket=196;
    public static final int If=177;
    public static final int Lower_bound=55;
    public static final int Is_of_type=71;
    public static final int Provides_subprogram_access=6;
    public static final int Warning=111;
    public static final int In=178;
    public static final int Contain_error=35;
    public static final int Is_memory=81;
    public static final int Direction=76;
    public static final int Assumption=61;
    public static final int Comma=187;
    public static final int HyphenMinus=188;
    public static final int Requires_data_access=13;
    public static final int Is_subprogram=41;
    public static final int LessThanSignEqualsSign=173;
    public static final int Property=96;
    public static final int Solution=97;
    public static final int Prove=140;
    public static final int Pattern=108;
    public static final int Modes=139;
    public static final int Revised_with_review=18;
    public static final int Reference=86;
    public static final int Abstract=87;
    public static final int Jp=179;
    public static final int Is_device=80;
    public static final int Thread=131;
    public static final int Instances=78;
    public static final int Type=160;
    public static final int Else=147;
    public static final int RULE_EXTENDED_DIGIT=209;
    public static final int Virtual_bus=60;
    public static final int True=159;
    public static final int Error_state_reachable=10;
    public static final int Undeveloped=58;
    public static final int PercentSign=182;
    public static final int Intersect=79;
    public static final int Upper_bound=59;
    public static final int Real=154;
    public static final int As_set=114;
    public static final int Applies=100;
    public static final int Forall=120;
    public static final int Member=123;
    public static final int RULE_BASED_INTEGER=207;
    public static final int RightSquareBracket=197;
    public static final int Is_in_array=54;
    public static final int Conclusion=64;
    public static final int Device=115;
    public static final int Range=141;
    public static final int Is_process=72;
    public static final int Is_bound_to=53;
    public static final int Andthen=99;
    public static final int And=162;
    public static final int Is_processor=47;
    public static final int RULE_INTEGER_LIT=208;
    public static final int Destination=51;
    public static final int Revised_without_review=9;
    public static final int Constant=90;
    public static final int Indeterminate=38;
    public static final int RULE_STRING=210;
    public static final int Notation=95;
    public static final int Source=128;
    public static final int Int=166;
    public static final int Flow_specification=19;
    public static final int EqualsSign=194;
    public static final int Instanceof=70;
    public static final int Subprogram_access=21;
    public static final int Debug=135;
    public static final int Has_type=93;
    public static final int Is_abstract_feature=15;
    public static final int RULE_WS=212;
    public static final int Error=137;
    public static final int Data=146;
    public static final int Propagate_error=30;
    public static final int Event_data_port=28;
    public static final int Restriction=56;
    public static final int Compute=103;
    public static final int Strategy=98;
    public static final int Let=167;
    public static final int Claim=134;

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
            case Activity:
            case Property:
            case Feature:
            case Process:
            case Access:
            case Device:
            case Entity:
            case Memory:
            case String:
            case KW_System:
            case Thread:
            case Agent:
            case Range:
            case Thing:
            case Aadl:
            case Bool:
            case Data:
            case Port:
            case Real:
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
    // InternalResoluteParser.g:511:1: ruleBaseType returns [EObject current=null] : ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing ) ) ) ;
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

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:514:28: ( ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing ) ) ) )
            // InternalResoluteParser.g:515:1: ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing ) ) )
            {
            // InternalResoluteParser.g:515:1: ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing ) ) )
            // InternalResoluteParser.g:516:1: ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing ) )
            {
            // InternalResoluteParser.g:516:1: ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing ) )
            // InternalResoluteParser.g:517:1: (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing )
            {
            // InternalResoluteParser.g:517:1: (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow | lv_type_0_45= Entity | lv_type_0_46= Agent | lv_type_0_47= Activity | lv_type_0_48= Thing )
            int alt6=48;
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
    // InternalResoluteParser.g:1153:1: entryRuleArg returns [EObject current=null] : iv_ruleArg= ruleArg EOF ;
    public final EObject entryRuleArg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArg = null;


        try {
            // InternalResoluteParser.g:1154:2: (iv_ruleArg= ruleArg EOF )
            // InternalResoluteParser.g:1155:2: iv_ruleArg= ruleArg EOF
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
    // InternalResoluteParser.g:1162:1: ruleArg returns [EObject current=null] : ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) ) ;
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
            // InternalResoluteParser.g:1165:28: ( ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:1166:1: ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:1166:1: ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) )
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
                    // InternalResoluteParser.g:1166:2: ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
                    {
                    // InternalResoluteParser.g:1166:2: ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
                    // InternalResoluteParser.g:1166:3: ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
                    {
                    // InternalResoluteParser.g:1177:6: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
                    // InternalResoluteParser.g:1177:7: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) )
                    {
                    // InternalResoluteParser.g:1177:7: ( (lv_name_0_0= RULE_ID ) )
                    // InternalResoluteParser.g:1178:1: (lv_name_0_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1178:1: (lv_name_0_0= RULE_ID )
                    // InternalResoluteParser.g:1179:3: lv_name_0_0= RULE_ID
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
                    // InternalResoluteParser.g:1200:1: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:1201:1: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:1201:1: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:1202:3: lv_type_2_0= ruleType
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
                    // InternalResoluteParser.g:1219:6: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1219:6: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1219:7: () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1219:7: ()
                    // InternalResoluteParser.g:1220:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getArgAccess().getQuantArgAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:1225:2: ( (lv_name_4_0= RULE_ID ) )
                    // InternalResoluteParser.g:1226:1: (lv_name_4_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1226:1: (lv_name_4_0= RULE_ID )
                    // InternalResoluteParser.g:1227:3: lv_name_4_0= RULE_ID
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
                    // InternalResoluteParser.g:1248:1: ( (lv_expr_6_0= ruleExpr ) )
                    // InternalResoluteParser.g:1249:1: (lv_expr_6_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1249:1: (lv_expr_6_0= ruleExpr )
                    // InternalResoluteParser.g:1250:3: lv_expr_6_0= ruleExpr
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
    // InternalResoluteParser.g:1274:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // InternalResoluteParser.g:1275:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // InternalResoluteParser.g:1276:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
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
    // InternalResoluteParser.g:1283:1: ruleConstantDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleConstantDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1286:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) )
            // InternalResoluteParser.g:1287:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // InternalResoluteParser.g:1287:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            // InternalResoluteParser.g:1287:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
            {
            // InternalResoluteParser.g:1287:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:1288:1: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:1288:1: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:1289:3: lv_name_0_0= RULE_ID
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
            // InternalResoluteParser.g:1310:1: ( (lv_type_2_0= ruleType ) )
            // InternalResoluteParser.g:1311:1: (lv_type_2_0= ruleType )
            {
            // InternalResoluteParser.g:1311:1: (lv_type_2_0= ruleType )
            // InternalResoluteParser.g:1312:3: lv_type_2_0= ruleType
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
            // InternalResoluteParser.g:1333:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalResoluteParser.g:1334:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalResoluteParser.g:1334:1: (lv_expr_4_0= ruleExpr )
            // InternalResoluteParser.g:1335:3: lv_expr_4_0= ruleExpr
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
    // InternalResoluteParser.g:1359:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalResoluteParser.g:1360:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalResoluteParser.g:1361:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
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
    // InternalResoluteParser.g:1368:1: ruleFunctionDefinition returns [EObject current=null] : ( ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) ) ) ;
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
            // InternalResoluteParser.g:1371:28: ( ( ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) ) ) )
            // InternalResoluteParser.g:1372:1: ( ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) ) )
            {
            // InternalResoluteParser.g:1372:1: ( ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) ) )
            // InternalResoluteParser.g:1372:2: ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= LeftParenthesis ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )? otherlv_8= RightParenthesis ( (lv_body_9_0= ruleDefinitionBody ) )
            {
            // InternalResoluteParser.g:1372:2: ( ( (lv_claimType_0_0= Goal ) ) | ( (lv_claimType_1_0= Conclusion ) ) | ( (lv_claimType_2_0= Strategy ) ) )?
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
                    // InternalResoluteParser.g:1372:3: ( (lv_claimType_0_0= Goal ) )
                    {
                    // InternalResoluteParser.g:1372:3: ( (lv_claimType_0_0= Goal ) )
                    // InternalResoluteParser.g:1373:1: (lv_claimType_0_0= Goal )
                    {
                    // InternalResoluteParser.g:1373:1: (lv_claimType_0_0= Goal )
                    // InternalResoluteParser.g:1374:3: lv_claimType_0_0= Goal
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
                    // InternalResoluteParser.g:1389:6: ( (lv_claimType_1_0= Conclusion ) )
                    {
                    // InternalResoluteParser.g:1389:6: ( (lv_claimType_1_0= Conclusion ) )
                    // InternalResoluteParser.g:1390:1: (lv_claimType_1_0= Conclusion )
                    {
                    // InternalResoluteParser.g:1390:1: (lv_claimType_1_0= Conclusion )
                    // InternalResoluteParser.g:1391:3: lv_claimType_1_0= Conclusion
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
                    // InternalResoluteParser.g:1406:6: ( (lv_claimType_2_0= Strategy ) )
                    {
                    // InternalResoluteParser.g:1406:6: ( (lv_claimType_2_0= Strategy ) )
                    // InternalResoluteParser.g:1407:1: (lv_claimType_2_0= Strategy )
                    {
                    // InternalResoluteParser.g:1407:1: (lv_claimType_2_0= Strategy )
                    // InternalResoluteParser.g:1408:3: lv_claimType_2_0= Strategy
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

            // InternalResoluteParser.g:1422:4: ( (lv_name_3_0= RULE_ID ) )
            // InternalResoluteParser.g:1423:1: (lv_name_3_0= RULE_ID )
            {
            // InternalResoluteParser.g:1423:1: (lv_name_3_0= RULE_ID )
            // InternalResoluteParser.g:1424:3: lv_name_3_0= RULE_ID
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
            // InternalResoluteParser.g:1445:1: ( ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalResoluteParser.g:1445:2: ( (lv_args_5_0= ruleArg ) ) (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )*
                    {
                    // InternalResoluteParser.g:1445:2: ( (lv_args_5_0= ruleArg ) )
                    // InternalResoluteParser.g:1446:1: (lv_args_5_0= ruleArg )
                    {
                    // InternalResoluteParser.g:1446:1: (lv_args_5_0= ruleArg )
                    // InternalResoluteParser.g:1447:3: lv_args_5_0= ruleArg
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

                    // InternalResoluteParser.g:1463:2: (otherlv_6= Comma ( (lv_args_7_0= ruleArg ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==Comma) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1464:2: otherlv_6= Comma ( (lv_args_7_0= ruleArg ) )
                    	    {
                    	    otherlv_6=(Token)match(input,Comma,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:1468:1: ( (lv_args_7_0= ruleArg ) )
                    	    // InternalResoluteParser.g:1469:1: (lv_args_7_0= ruleArg )
                    	    {
                    	    // InternalResoluteParser.g:1469:1: (lv_args_7_0= ruleArg )
                    	    // InternalResoluteParser.g:1470:3: lv_args_7_0= ruleArg
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
            // InternalResoluteParser.g:1491:1: ( (lv_body_9_0= ruleDefinitionBody ) )
            // InternalResoluteParser.g:1492:1: (lv_body_9_0= ruleDefinitionBody )
            {
            // InternalResoluteParser.g:1492:1: (lv_body_9_0= ruleDefinitionBody )
            // InternalResoluteParser.g:1493:3: lv_body_9_0= ruleDefinitionBody
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
    // InternalResoluteParser.g:1517:1: entryRuleDefinitionBody returns [EObject current=null] : iv_ruleDefinitionBody= ruleDefinitionBody EOF ;
    public final EObject entryRuleDefinitionBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionBody = null;


        try {
            // InternalResoluteParser.g:1518:2: (iv_ruleDefinitionBody= ruleDefinitionBody EOF )
            // InternalResoluteParser.g:1519:2: iv_ruleDefinitionBody= ruleDefinitionBody EOF
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
    // InternalResoluteParser.g:1526:1: ruleDefinitionBody returns [EObject current=null] : ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) ) ;
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
            // InternalResoluteParser.g:1529:28: ( ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:1530:1: ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:1530:1: ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) ) )
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
                    // InternalResoluteParser.g:1530:2: ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1530:2: ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1530:3: () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1530:3: ()
                    // InternalResoluteParser.g:1531:5: 
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
                    // InternalResoluteParser.g:1541:1: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:1542:1: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:1542:1: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:1543:3: lv_type_2_0= ruleType
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
                    // InternalResoluteParser.g:1564:1: ( (lv_expr_4_0= ruleExpr ) )
                    // InternalResoluteParser.g:1565:1: (lv_expr_4_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1565:1: (lv_expr_4_0= ruleExpr )
                    // InternalResoluteParser.g:1566:3: lv_expr_4_0= ruleExpr
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
                    // InternalResoluteParser.g:1583:6: ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1583:6: ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1583:7: () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_attributes_10_0= ruleClaimAttribute ) )* ( (lv_expr_11_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1583:7: ()
                    // InternalResoluteParser.g:1584:5: 
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
                    // InternalResoluteParser.g:1594:1: (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk )
                    // InternalResoluteParser.g:1595:2: otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk
                    {
                    otherlv_7=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDefinitionBodyAccess().getAsteriskAsteriskKeyword_1_2_0());
                          
                    }
                    // InternalResoluteParser.g:1599:1: ( (lv_claim_8_0= ruleClaimText ) )+
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
                    	    // InternalResoluteParser.g:1600:1: (lv_claim_8_0= ruleClaimText )
                    	    {
                    	    // InternalResoluteParser.g:1600:1: (lv_claim_8_0= ruleClaimText )
                    	    // InternalResoluteParser.g:1601:3: lv_claim_8_0= ruleClaimText
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

                    // InternalResoluteParser.g:1622:2: ( (lv_attributes_10_0= ruleClaimAttribute ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Justification||LA12_0==Restriction||LA12_0==Assumption||LA12_0==Rationale||LA12_0==Strategy||LA12_0==Context||LA12_0==Domain||LA12_0==Claim) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1623:1: (lv_attributes_10_0= ruleClaimAttribute )
                    	    {
                    	    // InternalResoluteParser.g:1623:1: (lv_attributes_10_0= ruleClaimAttribute )
                    	    // InternalResoluteParser.g:1624:3: lv_attributes_10_0= ruleClaimAttribute
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

                    // InternalResoluteParser.g:1640:3: ( (lv_expr_11_0= ruleExpr ) )
                    // InternalResoluteParser.g:1641:1: (lv_expr_11_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1641:1: (lv_expr_11_0= ruleExpr )
                    // InternalResoluteParser.g:1642:3: lv_expr_11_0= ruleExpr
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
    // InternalResoluteParser.g:1666:1: entryRuleClaimAttribute returns [EObject current=null] : iv_ruleClaimAttribute= ruleClaimAttribute EOF ;
    public final EObject entryRuleClaimAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimAttribute = null;


        try {
            // InternalResoluteParser.g:1667:2: (iv_ruleClaimAttribute= ruleClaimAttribute EOF )
            // InternalResoluteParser.g:1668:2: iv_ruleClaimAttribute= ruleClaimAttribute EOF
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
    // InternalResoluteParser.g:1675:1: ruleClaimAttribute returns [EObject current=null] : (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy | this_ClaimUsageDomain_4= ruleClaimUsageDomain | this_ClaimRationale_5= ruleClaimRationale | this_ClaimRestriction_6= ruleClaimRestriction | this_ClaimGuarantee_7= ruleClaimGuarantee ) ;
    public final EObject ruleClaimAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_ClaimContext_0 = null;

        EObject this_ClaimJustification_1 = null;

        EObject this_ClaimAssumption_2 = null;

        EObject this_ClaimStrategy_3 = null;

        EObject this_ClaimUsageDomain_4 = null;

        EObject this_ClaimRationale_5 = null;

        EObject this_ClaimRestriction_6 = null;

        EObject this_ClaimGuarantee_7 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1678:28: ( (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy | this_ClaimUsageDomain_4= ruleClaimUsageDomain | this_ClaimRationale_5= ruleClaimRationale | this_ClaimRestriction_6= ruleClaimRestriction | this_ClaimGuarantee_7= ruleClaimGuarantee ) )
            // InternalResoluteParser.g:1679:1: (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy | this_ClaimUsageDomain_4= ruleClaimUsageDomain | this_ClaimRationale_5= ruleClaimRationale | this_ClaimRestriction_6= ruleClaimRestriction | this_ClaimGuarantee_7= ruleClaimGuarantee )
            {
            // InternalResoluteParser.g:1679:1: (this_ClaimContext_0= ruleClaimContext | this_ClaimJustification_1= ruleClaimJustification | this_ClaimAssumption_2= ruleClaimAssumption | this_ClaimStrategy_3= ruleClaimStrategy | this_ClaimUsageDomain_4= ruleClaimUsageDomain | this_ClaimRationale_5= ruleClaimRationale | this_ClaimRestriction_6= ruleClaimRestriction | this_ClaimGuarantee_7= ruleClaimGuarantee )
            int alt14=8;
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
            case Claim:
                {
                alt14=8;
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
                    // InternalResoluteParser.g:1680:5: this_ClaimContext_0= ruleClaimContext
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
                    // InternalResoluteParser.g:1690:5: this_ClaimJustification_1= ruleClaimJustification
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
                    // InternalResoluteParser.g:1700:5: this_ClaimAssumption_2= ruleClaimAssumption
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
                    // InternalResoluteParser.g:1710:5: this_ClaimStrategy_3= ruleClaimStrategy
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
                    // InternalResoluteParser.g:1720:5: this_ClaimUsageDomain_4= ruleClaimUsageDomain
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
                    // InternalResoluteParser.g:1730:5: this_ClaimRationale_5= ruleClaimRationale
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
                    // InternalResoluteParser.g:1740:5: this_ClaimRestriction_6= ruleClaimRestriction
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
                case 8 :
                    // InternalResoluteParser.g:1750:5: this_ClaimGuarantee_7= ruleClaimGuarantee
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getClaimAttributeAccess().getClaimGuaranteeParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ClaimGuarantee_7=ruleClaimGuarantee();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ClaimGuarantee_7;
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
    // InternalResoluteParser.g:1766:1: entryRuleClaimContext returns [EObject current=null] : iv_ruleClaimContext= ruleClaimContext EOF ;
    public final EObject entryRuleClaimContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimContext = null;


        try {
            // InternalResoluteParser.g:1767:2: (iv_ruleClaimContext= ruleClaimContext EOF )
            // InternalResoluteParser.g:1768:2: iv_ruleClaimContext= ruleClaimContext EOF
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
    // InternalResoluteParser.g:1775:1: ruleClaimContext returns [EObject current=null] : (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1778:28: ( (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:1779:1: (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:1779:1: (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:1780:2: otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Context,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimContextAccess().getContextKeyword_0());
                  
            }
            // InternalResoluteParser.g:1784:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:1785:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:1785:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:1786:3: lv_name_1_0= RULE_ID
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
            // InternalResoluteParser.g:1807:1: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:1808:1: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:1808:1: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:1809:3: lv_expr_3_0= ruleExpr
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
    // InternalResoluteParser.g:1838:1: entryRuleClaimUsageDomain returns [EObject current=null] : iv_ruleClaimUsageDomain= ruleClaimUsageDomain EOF ;
    public final EObject entryRuleClaimUsageDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimUsageDomain = null;


        try {
            // InternalResoluteParser.g:1839:2: (iv_ruleClaimUsageDomain= ruleClaimUsageDomain EOF )
            // InternalResoluteParser.g:1840:2: iv_ruleClaimUsageDomain= ruleClaimUsageDomain EOF
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
    // InternalResoluteParser.g:1847:1: ruleClaimUsageDomain returns [EObject current=null] : (otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimUsageDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1850:28: ( (otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:1851:1: (otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:1851:1: (otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:1852:2: otherlv_0= Domain ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Domain,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimUsageDomainAccess().getDomainKeyword_0());
                  
            }
            // InternalResoluteParser.g:1856:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:1857:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:1857:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:1858:3: lv_name_1_0= RULE_ID
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
            // InternalResoluteParser.g:1879:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:1880:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:1880:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:1881:3: lv_val_3_0= ruleStringTerm
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
    // InternalResoluteParser.g:1910:1: entryRuleClaimRationale returns [EObject current=null] : iv_ruleClaimRationale= ruleClaimRationale EOF ;
    public final EObject entryRuleClaimRationale() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimRationale = null;


        try {
            // InternalResoluteParser.g:1911:2: (iv_ruleClaimRationale= ruleClaimRationale EOF )
            // InternalResoluteParser.g:1912:2: iv_ruleClaimRationale= ruleClaimRationale EOF
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
    // InternalResoluteParser.g:1919:1: ruleClaimRationale returns [EObject current=null] : (otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimRationale() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1922:28: ( (otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:1923:1: (otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:1923:1: (otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:1924:2: otherlv_0= Rationale ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Rationale,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimRationaleAccess().getRationaleKeyword_0());
                  
            }
            // InternalResoluteParser.g:1928:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:1929:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:1929:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:1930:3: lv_name_1_0= RULE_ID
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
            // InternalResoluteParser.g:1951:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:1952:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:1952:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:1953:3: lv_val_3_0= ruleStringTerm
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
    // InternalResoluteParser.g:1982:1: entryRuleClaimRestriction returns [EObject current=null] : iv_ruleClaimRestriction= ruleClaimRestriction EOF ;
    public final EObject entryRuleClaimRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimRestriction = null;


        try {
            // InternalResoluteParser.g:1983:2: (iv_ruleClaimRestriction= ruleClaimRestriction EOF )
            // InternalResoluteParser.g:1984:2: iv_ruleClaimRestriction= ruleClaimRestriction EOF
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
    // InternalResoluteParser.g:1991:1: ruleClaimRestriction returns [EObject current=null] : (otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1994:28: ( (otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:1995:1: (otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:1995:1: (otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:1996:2: otherlv_0= Restriction ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Restriction,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimRestrictionAccess().getRestrictionKeyword_0());
                  
            }
            // InternalResoluteParser.g:2000:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2001:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2001:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2002:3: lv_name_1_0= RULE_ID
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
            // InternalResoluteParser.g:2023:1: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:2024:1: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:2024:1: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:2025:3: lv_expr_3_0= ruleExpr
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
    // InternalResoluteParser.g:2054:1: entryRuleClaimJustification returns [EObject current=null] : iv_ruleClaimJustification= ruleClaimJustification EOF ;
    public final EObject entryRuleClaimJustification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimJustification = null;


        try {
            // InternalResoluteParser.g:2055:2: (iv_ruleClaimJustification= ruleClaimJustification EOF )
            // InternalResoluteParser.g:2056:2: iv_ruleClaimJustification= ruleClaimJustification EOF
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
    // InternalResoluteParser.g:2063:1: ruleClaimJustification returns [EObject current=null] : (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimJustification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2066:28: ( (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2067:1: (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2067:1: (otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2068:2: otherlv_0= Justification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Justification,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimJustificationAccess().getJustificationKeyword_0());
                  
            }
            // InternalResoluteParser.g:2072:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2073:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2073:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2074:3: lv_name_1_0= RULE_ID
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
            // InternalResoluteParser.g:2095:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:2096:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:2096:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:2097:3: lv_val_3_0= ruleStringTerm
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
    // InternalResoluteParser.g:2126:1: entryRuleClaimAssumption returns [EObject current=null] : iv_ruleClaimAssumption= ruleClaimAssumption EOF ;
    public final EObject entryRuleClaimAssumption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimAssumption = null;


        try {
            // InternalResoluteParser.g:2127:2: (iv_ruleClaimAssumption= ruleClaimAssumption EOF )
            // InternalResoluteParser.g:2128:2: iv_ruleClaimAssumption= ruleClaimAssumption EOF
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
    // InternalResoluteParser.g:2135:1: ruleClaimAssumption returns [EObject current=null] : (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimAssumption() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2138:28: ( (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2139:1: (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2139:1: (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2140:2: otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Assumption,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimAssumptionAccess().getAssumptionKeyword_0());
                  
            }
            // InternalResoluteParser.g:2144:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2145:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2145:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2146:3: lv_name_1_0= RULE_ID
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
            // InternalResoluteParser.g:2167:1: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:2168:1: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:2168:1: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:2169:3: lv_expr_3_0= ruleExpr
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
    // InternalResoluteParser.g:2198:1: entryRuleClaimStrategy returns [EObject current=null] : iv_ruleClaimStrategy= ruleClaimStrategy EOF ;
    public final EObject entryRuleClaimStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimStrategy = null;


        try {
            // InternalResoluteParser.g:2199:2: (iv_ruleClaimStrategy= ruleClaimStrategy EOF )
            // InternalResoluteParser.g:2200:2: iv_ruleClaimStrategy= ruleClaimStrategy EOF
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
    // InternalResoluteParser.g:2207:1: ruleClaimStrategy returns [EObject current=null] : (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2210:28: ( (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2211:1: (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2211:1: (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2212:2: otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Strategy,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimStrategyAccess().getStrategyKeyword_0());
                  
            }
            // InternalResoluteParser.g:2216:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2217:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2217:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2218:3: lv_name_1_0= RULE_ID
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
            // InternalResoluteParser.g:2239:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:2240:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:2240:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:2241:3: lv_val_3_0= ruleStringTerm
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


    // $ANTLR start "entryRuleClaimGuarantee"
    // InternalResoluteParser.g:2270:1: entryRuleClaimGuarantee returns [EObject current=null] : iv_ruleClaimGuarantee= ruleClaimGuarantee EOF ;
    public final EObject entryRuleClaimGuarantee() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimGuarantee = null;


        try {
            // InternalResoluteParser.g:2271:2: (iv_ruleClaimGuarantee= ruleClaimGuarantee EOF )
            // InternalResoluteParser.g:2272:2: iv_ruleClaimGuarantee= ruleClaimGuarantee EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClaimGuaranteeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClaimGuarantee=ruleClaimGuarantee();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClaimGuarantee; 
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
    // $ANTLR end "entryRuleClaimGuarantee"


    // $ANTLR start "ruleClaimGuarantee"
    // InternalResoluteParser.g:2279:1: ruleClaimGuarantee returns [EObject current=null] : (otherlv_0= Claim ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) ;
    public final EObject ruleClaimGuarantee() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2282:28: ( (otherlv_0= Claim ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon ) )
            // InternalResoluteParser.g:2283:1: (otherlv_0= Claim ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            {
            // InternalResoluteParser.g:2283:1: (otherlv_0= Claim ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon )
            // InternalResoluteParser.g:2284:2: otherlv_0= Claim ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_expr_3_0= ruleExpr ) ) otherlv_4= Semicolon
            {
            otherlv_0=(Token)match(input,Claim,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimGuaranteeAccess().getClaimKeyword_0());
                  
            }
            // InternalResoluteParser.g:2288:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:2289:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:2289:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:2290:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getClaimGuaranteeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClaimGuaranteeRule());
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

                  	newLeafNode(otherlv_2, grammarAccess.getClaimGuaranteeAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:2311:1: ( (lv_expr_3_0= ruleExpr ) )
            // InternalResoluteParser.g:2312:1: (lv_expr_3_0= ruleExpr )
            {
            // InternalResoluteParser.g:2312:1: (lv_expr_3_0= ruleExpr )
            // InternalResoluteParser.g:2313:3: lv_expr_3_0= ruleExpr
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimGuaranteeAccess().getExprExprParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_26);
            lv_expr_3_0=ruleExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimGuaranteeRule());
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

                  	newLeafNode(otherlv_4, grammarAccess.getClaimGuaranteeAccess().getSemicolonKeyword_4());
                  
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
    // $ANTLR end "ruleClaimGuarantee"


    // $ANTLR start "entryRuleClaimText"
    // InternalResoluteParser.g:2342:1: entryRuleClaimText returns [EObject current=null] : iv_ruleClaimText= ruleClaimText EOF ;
    public final EObject entryRuleClaimText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimText = null;


        try {
            // InternalResoluteParser.g:2343:2: (iv_ruleClaimText= ruleClaimText EOF )
            // InternalResoluteParser.g:2344:2: iv_ruleClaimText= ruleClaimText EOF
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
    // InternalResoluteParser.g:2351:1: ruleClaimText returns [EObject current=null] : ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) ) ;
    public final EObject ruleClaimText() throws RecognitionException {
        EObject current = null;

        Token lv_str_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2354:28: ( ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) ) )
            // InternalResoluteParser.g:2355:1: ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) )
            {
            // InternalResoluteParser.g:2355:1: ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) )
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
                    // InternalResoluteParser.g:2355:2: ( () ( (lv_str_1_0= RULE_STRING ) ) )
                    {
                    // InternalResoluteParser.g:2355:2: ( () ( (lv_str_1_0= RULE_STRING ) ) )
                    // InternalResoluteParser.g:2355:3: () ( (lv_str_1_0= RULE_STRING ) )
                    {
                    // InternalResoluteParser.g:2355:3: ()
                    // InternalResoluteParser.g:2356:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getClaimTextAccess().getClaimStringAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2361:2: ( (lv_str_1_0= RULE_STRING ) )
                    // InternalResoluteParser.g:2362:1: (lv_str_1_0= RULE_STRING )
                    {
                    // InternalResoluteParser.g:2362:1: (lv_str_1_0= RULE_STRING )
                    // InternalResoluteParser.g:2363:3: lv_str_1_0= RULE_STRING
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
                    // InternalResoluteParser.g:2380:6: ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? )
                    {
                    // InternalResoluteParser.g:2380:6: ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? )
                    // InternalResoluteParser.g:2380:7: () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )?
                    {
                    // InternalResoluteParser.g:2380:7: ()
                    // InternalResoluteParser.g:2381:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getClaimTextAccess().getClaimArgAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2386:2: ( (otherlv_3= RULE_ID ) )
                    // InternalResoluteParser.g:2387:1: (otherlv_3= RULE_ID )
                    {
                    // InternalResoluteParser.g:2387:1: (otherlv_3= RULE_ID )
                    // InternalResoluteParser.g:2388:3: otherlv_3= RULE_ID
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

                    // InternalResoluteParser.g:2399:2: (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==PercentSign) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalResoluteParser.g:2400:2: otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,PercentSign,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getClaimTextAccess().getPercentSignKeyword_1_2_0());
                                  
                            }
                            // InternalResoluteParser.g:2404:1: ( (otherlv_5= RULE_ID ) )
                            // InternalResoluteParser.g:2405:1: (otherlv_5= RULE_ID )
                            {
                            // InternalResoluteParser.g:2405:1: (otherlv_5= RULE_ID )
                            // InternalResoluteParser.g:2406:3: otherlv_5= RULE_ID
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
    // InternalResoluteParser.g:2427:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // InternalResoluteParser.g:2428:2: (iv_ruleExpr= ruleExpr EOF )
            // InternalResoluteParser.g:2429:2: iv_ruleExpr= ruleExpr EOF
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
    // InternalResoluteParser.g:2436:1: ruleExpr returns [EObject current=null] : this_ImpliesExpr_0= ruleImpliesExpr ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesExpr_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2439:28: (this_ImpliesExpr_0= ruleImpliesExpr )
            // InternalResoluteParser.g:2441:5: this_ImpliesExpr_0= ruleImpliesExpr
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
    // InternalResoluteParser.g:2457:1: entryRuleImpliesExpr returns [EObject current=null] : iv_ruleImpliesExpr= ruleImpliesExpr EOF ;
    public final EObject entryRuleImpliesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpr = null;


        try {
            // InternalResoluteParser.g:2458:2: (iv_ruleImpliesExpr= ruleImpliesExpr EOF )
            // InternalResoluteParser.g:2459:2: iv_ruleImpliesExpr= ruleImpliesExpr EOF
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
    // InternalResoluteParser.g:2466:1: ruleImpliesExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) ;
    public final EObject ruleImpliesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_OrExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2469:28: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) )
            // InternalResoluteParser.g:2470:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            {
            // InternalResoluteParser.g:2470:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            // InternalResoluteParser.g:2471:5: this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
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
            // InternalResoluteParser.g:2479:1: ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
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
                    // InternalResoluteParser.g:2479:2: ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) )
                    {
                    // InternalResoluteParser.g:2479:2: ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) )
                    // InternalResoluteParser.g:2479:3: ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) )
                    {
                    // InternalResoluteParser.g:2487:6: ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) )
                    // InternalResoluteParser.g:2487:7: () ( (lv_op_2_0= EqualsSignGreaterThanSign ) )
                    {
                    // InternalResoluteParser.g:2487:7: ()
                    // InternalResoluteParser.g:2488:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2493:2: ( (lv_op_2_0= EqualsSignGreaterThanSign ) )
                    // InternalResoluteParser.g:2494:1: (lv_op_2_0= EqualsSignGreaterThanSign )
                    {
                    // InternalResoluteParser.g:2494:1: (lv_op_2_0= EqualsSignGreaterThanSign )
                    // InternalResoluteParser.g:2495:3: lv_op_2_0= EqualsSignGreaterThanSign
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

                    // InternalResoluteParser.g:2509:4: ( (lv_right_3_0= ruleImpliesExpr ) )
                    // InternalResoluteParser.g:2510:1: (lv_right_3_0= ruleImpliesExpr )
                    {
                    // InternalResoluteParser.g:2510:1: (lv_right_3_0= ruleImpliesExpr )
                    // InternalResoluteParser.g:2511:3: lv_right_3_0= ruleImpliesExpr
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
    // InternalResoluteParser.g:2535:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // InternalResoluteParser.g:2536:2: (iv_ruleOrExpr= ruleOrExpr EOF )
            // InternalResoluteParser.g:2537:2: iv_ruleOrExpr= ruleOrExpr EOF
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
    // InternalResoluteParser.g:2544:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2547:28: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* ) )
            // InternalResoluteParser.g:2548:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* )
            {
            // InternalResoluteParser.g:2548:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* )
            // InternalResoluteParser.g:2549:5: this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )*
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
            // InternalResoluteParser.g:2557:1: ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )*
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
            	    // InternalResoluteParser.g:2557:2: ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) )
            	    {
            	    // InternalResoluteParser.g:2557:2: ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) )
            	    // InternalResoluteParser.g:2557:3: ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2573:7: ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) )
            	    // InternalResoluteParser.g:2573:8: () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) )
            	    {
            	    // InternalResoluteParser.g:2573:8: ()
            	    // InternalResoluteParser.g:2574:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:2579:2: ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) )
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
            	            // InternalResoluteParser.g:2579:3: ( (lv_op_2_0= Or ) )
            	            {
            	            // InternalResoluteParser.g:2579:3: ( (lv_op_2_0= Or ) )
            	            // InternalResoluteParser.g:2580:1: (lv_op_2_0= Or )
            	            {
            	            // InternalResoluteParser.g:2580:1: (lv_op_2_0= Or )
            	            // InternalResoluteParser.g:2581:3: lv_op_2_0= Or
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
            	            // InternalResoluteParser.g:2596:6: ( (lv_op_3_0= Orelse ) )
            	            {
            	            // InternalResoluteParser.g:2596:6: ( (lv_op_3_0= Orelse ) )
            	            // InternalResoluteParser.g:2597:1: (lv_op_3_0= Orelse )
            	            {
            	            // InternalResoluteParser.g:2597:1: (lv_op_3_0= Orelse )
            	            // InternalResoluteParser.g:2598:3: lv_op_3_0= Orelse
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

            	    // InternalResoluteParser.g:2612:5: ( (lv_right_4_0= ruleAndExpr ) )
            	    // InternalResoluteParser.g:2613:1: (lv_right_4_0= ruleAndExpr )
            	    {
            	    // InternalResoluteParser.g:2613:1: (lv_right_4_0= ruleAndExpr )
            	    // InternalResoluteParser.g:2614:3: lv_right_4_0= ruleAndExpr
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
    // InternalResoluteParser.g:2638:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // InternalResoluteParser.g:2639:2: (iv_ruleAndExpr= ruleAndExpr EOF )
            // InternalResoluteParser.g:2640:2: iv_ruleAndExpr= ruleAndExpr EOF
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
    // InternalResoluteParser.g:2647:1: ruleAndExpr returns [EObject current=null] : (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_InstanceOfExpr_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2650:28: ( (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* ) )
            // InternalResoluteParser.g:2651:1: (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* )
            {
            // InternalResoluteParser.g:2651:1: (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* )
            // InternalResoluteParser.g:2652:5: this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )*
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
            // InternalResoluteParser.g:2660:1: ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )*
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
            	    // InternalResoluteParser.g:2660:2: ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) )
            	    {
            	    // InternalResoluteParser.g:2660:2: ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) )
            	    // InternalResoluteParser.g:2660:3: ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2676:7: ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) )
            	    // InternalResoluteParser.g:2676:8: () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) )
            	    {
            	    // InternalResoluteParser.g:2676:8: ()
            	    // InternalResoluteParser.g:2677:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:2682:2: ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) )
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
            	            // InternalResoluteParser.g:2682:3: ( (lv_op_2_0= And ) )
            	            {
            	            // InternalResoluteParser.g:2682:3: ( (lv_op_2_0= And ) )
            	            // InternalResoluteParser.g:2683:1: (lv_op_2_0= And )
            	            {
            	            // InternalResoluteParser.g:2683:1: (lv_op_2_0= And )
            	            // InternalResoluteParser.g:2684:3: lv_op_2_0= And
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
            	            // InternalResoluteParser.g:2699:6: ( (lv_op_3_0= Andthen ) )
            	            {
            	            // InternalResoluteParser.g:2699:6: ( (lv_op_3_0= Andthen ) )
            	            // InternalResoluteParser.g:2700:1: (lv_op_3_0= Andthen )
            	            {
            	            // InternalResoluteParser.g:2700:1: (lv_op_3_0= Andthen )
            	            // InternalResoluteParser.g:2701:3: lv_op_3_0= Andthen
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

            	    // InternalResoluteParser.g:2715:5: ( (lv_right_4_0= ruleInstanceOfExpr ) )
            	    // InternalResoluteParser.g:2716:1: (lv_right_4_0= ruleInstanceOfExpr )
            	    {
            	    // InternalResoluteParser.g:2716:1: (lv_right_4_0= ruleInstanceOfExpr )
            	    // InternalResoluteParser.g:2717:3: lv_right_4_0= ruleInstanceOfExpr
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
    // InternalResoluteParser.g:2741:1: entryRuleInstanceOfExpr returns [EObject current=null] : iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF ;
    public final EObject entryRuleInstanceOfExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceOfExpr = null;


        try {
            // InternalResoluteParser.g:2742:2: (iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF )
            // InternalResoluteParser.g:2743:2: iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF
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
    // InternalResoluteParser.g:2750:1: ruleInstanceOfExpr returns [EObject current=null] : (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? ) ;
    public final EObject ruleInstanceOfExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RelationalExpr_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2753:28: ( (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? ) )
            // InternalResoluteParser.g:2754:1: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? )
            {
            // InternalResoluteParser.g:2754:1: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? )
            // InternalResoluteParser.g:2755:5: this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )?
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
            // InternalResoluteParser.g:2763:1: ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )?
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
                    // InternalResoluteParser.g:2763:2: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) )
                    {
                    // InternalResoluteParser.g:2763:2: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) )
                    // InternalResoluteParser.g:2763:3: ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof )
                    {
                    // InternalResoluteParser.g:2766:5: ( () otherlv_2= Instanceof )
                    // InternalResoluteParser.g:2766:6: () otherlv_2= Instanceof
                    {
                    // InternalResoluteParser.g:2766:6: ()
                    // InternalResoluteParser.g:2767:5: 
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

                    // InternalResoluteParser.g:2777:3: ( (lv_type_3_0= ruleBaseType ) )
                    // InternalResoluteParser.g:2778:1: (lv_type_3_0= ruleBaseType )
                    {
                    // InternalResoluteParser.g:2778:1: (lv_type_3_0= ruleBaseType )
                    // InternalResoluteParser.g:2779:3: lv_type_3_0= ruleBaseType
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
    // InternalResoluteParser.g:2803:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // InternalResoluteParser.g:2804:1: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // InternalResoluteParser.g:2805:2: iv_ruleRelationalOp= ruleRelationalOp EOF
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
    // InternalResoluteParser.g:2812:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2816:6: ( (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign ) )
            // InternalResoluteParser.g:2817:1: (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign )
            {
            // InternalResoluteParser.g:2817:1: (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign )
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
                    // InternalResoluteParser.g:2818:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:2825:2: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:2832:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:2839:2: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:2846:2: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:2853:2: kw= LessThanSignGreaterThanSign
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
    // InternalResoluteParser.g:2866:1: entryRuleRelationalExpr returns [EObject current=null] : iv_ruleRelationalExpr= ruleRelationalExpr EOF ;
    public final EObject entryRuleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpr = null;


        try {
            // InternalResoluteParser.g:2867:2: (iv_ruleRelationalExpr= ruleRelationalExpr EOF )
            // InternalResoluteParser.g:2868:2: iv_ruleRelationalExpr= ruleRelationalExpr EOF
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
    // InternalResoluteParser.g:2875:1: ruleRelationalExpr returns [EObject current=null] : (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) ;
    public final EObject ruleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PlusExpr_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2878:28: ( (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) )
            // InternalResoluteParser.g:2879:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            {
            // InternalResoluteParser.g:2879:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            // InternalResoluteParser.g:2880:5: this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
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
            // InternalResoluteParser.g:2888:1: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
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
                    // InternalResoluteParser.g:2888:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) )
                    {
                    // InternalResoluteParser.g:2888:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) )
                    // InternalResoluteParser.g:2888:3: ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    {
                    // InternalResoluteParser.g:2893:6: ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    // InternalResoluteParser.g:2893:7: () ( (lv_op_2_0= ruleRelationalOp ) )
                    {
                    // InternalResoluteParser.g:2893:7: ()
                    // InternalResoluteParser.g:2894:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2899:2: ( (lv_op_2_0= ruleRelationalOp ) )
                    // InternalResoluteParser.g:2900:1: (lv_op_2_0= ruleRelationalOp )
                    {
                    // InternalResoluteParser.g:2900:1: (lv_op_2_0= ruleRelationalOp )
                    // InternalResoluteParser.g:2901:3: lv_op_2_0= ruleRelationalOp
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

                    // InternalResoluteParser.g:2917:4: ( (lv_right_3_0= rulePlusExpr ) )
                    // InternalResoluteParser.g:2918:1: (lv_right_3_0= rulePlusExpr )
                    {
                    // InternalResoluteParser.g:2918:1: (lv_right_3_0= rulePlusExpr )
                    // InternalResoluteParser.g:2919:3: lv_right_3_0= rulePlusExpr
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
    // InternalResoluteParser.g:2943:1: entryRulePlusExpr returns [EObject current=null] : iv_rulePlusExpr= rulePlusExpr EOF ;
    public final EObject entryRulePlusExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusExpr = null;


        try {
            // InternalResoluteParser.g:2944:2: (iv_rulePlusExpr= rulePlusExpr EOF )
            // InternalResoluteParser.g:2945:2: iv_rulePlusExpr= rulePlusExpr EOF
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
    // InternalResoluteParser.g:2952:1: rulePlusExpr returns [EObject current=null] : (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* ) ;
    public final EObject rulePlusExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_TimesExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2955:28: ( (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* ) )
            // InternalResoluteParser.g:2956:1: (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* )
            {
            // InternalResoluteParser.g:2956:1: (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* )
            // InternalResoluteParser.g:2957:5: this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )*
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
            // InternalResoluteParser.g:2965:1: ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )*
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
            	    // InternalResoluteParser.g:2965:2: ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) )
            	    {
            	    // InternalResoluteParser.g:2965:2: ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) )
            	    // InternalResoluteParser.g:2965:3: ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2980:6: ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) )
            	    // InternalResoluteParser.g:2980:7: () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    {
            	    // InternalResoluteParser.g:2980:7: ()
            	    // InternalResoluteParser.g:2981:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPlusExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:2986:2: ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    // InternalResoluteParser.g:2987:1: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    {
            	    // InternalResoluteParser.g:2987:1: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    // InternalResoluteParser.g:2988:1: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    {
            	    // InternalResoluteParser.g:2988:1: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
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
            	            // InternalResoluteParser.g:2989:3: lv_op_2_1= PlusSign
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
            	            // InternalResoluteParser.g:3002:8: lv_op_2_2= HyphenMinus
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

            	    // InternalResoluteParser.g:3018:4: ( (lv_right_3_0= ruleTimesExpr ) )
            	    // InternalResoluteParser.g:3019:1: (lv_right_3_0= ruleTimesExpr )
            	    {
            	    // InternalResoluteParser.g:3019:1: (lv_right_3_0= ruleTimesExpr )
            	    // InternalResoluteParser.g:3020:3: lv_right_3_0= ruleTimesExpr
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
    // InternalResoluteParser.g:3044:1: entryRuleTimesExpr returns [EObject current=null] : iv_ruleTimesExpr= ruleTimesExpr EOF ;
    public final EObject entryRuleTimesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimesExpr = null;


        try {
            // InternalResoluteParser.g:3045:2: (iv_ruleTimesExpr= ruleTimesExpr EOF )
            // InternalResoluteParser.g:3046:2: iv_ruleTimesExpr= ruleTimesExpr EOF
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
    // InternalResoluteParser.g:3053:1: ruleTimesExpr returns [EObject current=null] : (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* ) ;
    public final EObject ruleTimesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_ExpExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3056:28: ( (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* ) )
            // InternalResoluteParser.g:3057:1: (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* )
            {
            // InternalResoluteParser.g:3057:1: (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* )
            // InternalResoluteParser.g:3058:5: this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )*
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
            // InternalResoluteParser.g:3066:1: ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )*
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
            	    // InternalResoluteParser.g:3066:2: ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) )
            	    {
            	    // InternalResoluteParser.g:3066:2: ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) )
            	    // InternalResoluteParser.g:3066:3: ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) )
            	    {
            	    // InternalResoluteParser.g:3085:6: ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) )
            	    // InternalResoluteParser.g:3085:7: () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    {
            	    // InternalResoluteParser.g:3085:7: ()
            	    // InternalResoluteParser.g:3086:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getTimesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:3091:2: ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    // InternalResoluteParser.g:3092:1: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    {
            	    // InternalResoluteParser.g:3092:1: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    // InternalResoluteParser.g:3093:1: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    {
            	    // InternalResoluteParser.g:3093:1: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
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
            	            // InternalResoluteParser.g:3094:3: lv_op_2_1= Asterisk
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
            	            // InternalResoluteParser.g:3107:8: lv_op_2_2= Solidus
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
            	            // InternalResoluteParser.g:3120:8: lv_op_2_3= PercentSign
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

            	    // InternalResoluteParser.g:3136:4: ( (lv_right_3_0= ruleExpExpr ) )
            	    // InternalResoluteParser.g:3137:1: (lv_right_3_0= ruleExpExpr )
            	    {
            	    // InternalResoluteParser.g:3137:1: (lv_right_3_0= ruleExpExpr )
            	    // InternalResoluteParser.g:3138:3: lv_right_3_0= ruleExpExpr
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
    // InternalResoluteParser.g:3162:1: entryRuleExpExpr returns [EObject current=null] : iv_ruleExpExpr= ruleExpExpr EOF ;
    public final EObject entryRuleExpExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpExpr = null;


        try {
            // InternalResoluteParser.g:3163:2: (iv_ruleExpExpr= ruleExpExpr EOF )
            // InternalResoluteParser.g:3164:2: iv_ruleExpExpr= ruleExpExpr EOF
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
    // InternalResoluteParser.g:3171:1: ruleExpExpr returns [EObject current=null] : (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* ) ;
    public final EObject ruleExpExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_PrefixExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3174:28: ( (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* ) )
            // InternalResoluteParser.g:3175:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* )
            {
            // InternalResoluteParser.g:3175:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* )
            // InternalResoluteParser.g:3176:5: this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )*
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
            // InternalResoluteParser.g:3184:1: ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )*
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
            	    // InternalResoluteParser.g:3184:2: ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) )
            	    {
            	    // InternalResoluteParser.g:3184:2: ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) )
            	    // InternalResoluteParser.g:3184:3: ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) )
            	    {
            	    // InternalResoluteParser.g:3192:6: ( () ( (lv_op_2_0= CircumflexAccent ) ) )
            	    // InternalResoluteParser.g:3192:7: () ( (lv_op_2_0= CircumflexAccent ) )
            	    {
            	    // InternalResoluteParser.g:3192:7: ()
            	    // InternalResoluteParser.g:3193:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:3198:2: ( (lv_op_2_0= CircumflexAccent ) )
            	    // InternalResoluteParser.g:3199:1: (lv_op_2_0= CircumflexAccent )
            	    {
            	    // InternalResoluteParser.g:3199:1: (lv_op_2_0= CircumflexAccent )
            	    // InternalResoluteParser.g:3200:3: lv_op_2_0= CircumflexAccent
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

            	    // InternalResoluteParser.g:3214:4: ( (lv_right_3_0= rulePrefixExpr ) )
            	    // InternalResoluteParser.g:3215:1: (lv_right_3_0= rulePrefixExpr )
            	    {
            	    // InternalResoluteParser.g:3215:1: (lv_right_3_0= rulePrefixExpr )
            	    // InternalResoluteParser.g:3216:3: lv_right_3_0= rulePrefixExpr
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
    // InternalResoluteParser.g:3240:1: entryRulePrefixExpr returns [EObject current=null] : iv_rulePrefixExpr= rulePrefixExpr EOF ;
    public final EObject entryRulePrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpr = null;


        try {
            // InternalResoluteParser.g:3241:2: (iv_rulePrefixExpr= rulePrefixExpr EOF )
            // InternalResoluteParser.g:3242:2: iv_rulePrefixExpr= rulePrefixExpr EOF
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
    // InternalResoluteParser.g:3249:1: rulePrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr ) ;
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
            // InternalResoluteParser.g:3252:28: ( ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr ) )
            // InternalResoluteParser.g:3253:1: ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr )
            {
            // InternalResoluteParser.g:3253:1: ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr )
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
                case Is_thread_group:
                case Propagate_error:
                case Property_member:
                case Has_prototypes:
                case Is_data_access:
                case Is_virtual_bus:
                case Contain_error:
                case Flow_elements:
                case Indeterminate:
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
                case Identifier:
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
                case Evidence:
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
                case Failed:
                case Forall:
                case Is_bus:
                case Length:
                case Member:
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
                case Tail:
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
                case Activity:
                case Feature:
                case Process:
                case Access:
                case Device:
                case Entity:
                case Memory:
                case String:
                case KW_System:
                case Thread:
                case Agent:
                case Range:
                case Thing:
                case Aadl:
                case Bool:
                case Data:
                case Port:
                case Real:
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
            case Is_thread_group:
            case Propagate_error:
            case Property_member:
            case Has_prototypes:
            case Is_data_access:
            case Is_virtual_bus:
            case Contain_error:
            case Flow_elements:
            case Indeterminate:
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
            case Identifier:
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
            case Evidence:
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
            case Failed:
            case Forall:
            case Is_bus:
            case Length:
            case Member:
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
            case Tail:
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
                    // InternalResoluteParser.g:3253:2: ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    {
                    // InternalResoluteParser.g:3253:2: ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    // InternalResoluteParser.g:3253:3: () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) )
                    {
                    // InternalResoluteParser.g:3253:3: ()
                    // InternalResoluteParser.g:3254:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getUnaryExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3259:2: ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) )
                    // InternalResoluteParser.g:3260:1: ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) )
                    {
                    // InternalResoluteParser.g:3260:1: ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) )
                    // InternalResoluteParser.g:3261:1: (lv_op_1_1= HyphenMinus | lv_op_1_2= Not )
                    {
                    // InternalResoluteParser.g:3261:1: (lv_op_1_1= HyphenMinus | lv_op_1_2= Not )
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
                            // InternalResoluteParser.g:3262:3: lv_op_1_1= HyphenMinus
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
                            // InternalResoluteParser.g:3275:8: lv_op_1_2= Not
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

                    // InternalResoluteParser.g:3291:2: ( (lv_expr_2_0= rulePrefixExpr ) )
                    // InternalResoluteParser.g:3292:1: (lv_expr_2_0= rulePrefixExpr )
                    {
                    // InternalResoluteParser.g:3292:1: (lv_expr_2_0= rulePrefixExpr )
                    // InternalResoluteParser.g:3293:3: lv_expr_2_0= rulePrefixExpr
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
                    // InternalResoluteParser.g:3310:6: ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) )
                    {
                    // InternalResoluteParser.g:3310:6: ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) )
                    // InternalResoluteParser.g:3310:7: () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) )
                    {
                    // InternalResoluteParser.g:3310:7: ()
                    // InternalResoluteParser.g:3311:5: 
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
                    // InternalResoluteParser.g:3321:1: ( (lv_type_5_0= ruleBaseType ) )
                    // InternalResoluteParser.g:3322:1: (lv_type_5_0= ruleBaseType )
                    {
                    // InternalResoluteParser.g:3322:1: (lv_type_5_0= ruleBaseType )
                    // InternalResoluteParser.g:3323:3: lv_type_5_0= ruleBaseType
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
                    // InternalResoluteParser.g:3344:1: ( (lv_expr_7_0= rulePrefixExpr ) )
                    // InternalResoluteParser.g:3345:1: (lv_expr_7_0= rulePrefixExpr )
                    {
                    // InternalResoluteParser.g:3345:1: (lv_expr_7_0= rulePrefixExpr )
                    // InternalResoluteParser.g:3346:3: lv_expr_7_0= rulePrefixExpr
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
                    // InternalResoluteParser.g:3364:5: this_AtomicExpr_8= ruleAtomicExpr
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
    // InternalResoluteParser.g:3380:1: entryRuleAtomicExpr returns [EObject current=null] : iv_ruleAtomicExpr= ruleAtomicExpr EOF ;
    public final EObject entryRuleAtomicExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpr = null;


        try {
            // InternalResoluteParser.g:3381:2: (iv_ruleAtomicExpr= ruleAtomicExpr EOF )
            // InternalResoluteParser.g:3382:2: iv_ruleAtomicExpr= ruleAtomicExpr EOF
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
    // InternalResoluteParser.g:3389:1: ruleAtomicExpr returns [EObject current=null] : ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ) | ( () otherlv_106= Solution ( (lv_name_107_0= RULE_ID ) ) otherlv_108= Colon ( (lv_val_109_0= ruleStringTerm ) ) ) ) ;
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
        Token otherlv_106=null;
        Token lv_name_107_0=null;
        Token otherlv_108=null;
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

        EObject lv_val_109_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3392:28: ( ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ) | ( () otherlv_106= Solution ( (lv_name_107_0= RULE_ID ) ) otherlv_108= Colon ( (lv_val_109_0= ruleStringTerm ) ) ) ) )
            // InternalResoluteParser.g:3393:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ) | ( () otherlv_106= Solution ( (lv_name_107_0= RULE_ID ) ) otherlv_108= Colon ( (lv_val_109_0= ruleStringTerm ) ) ) )
            {
            // InternalResoluteParser.g:3393:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ) | ( () otherlv_106= Solution ( (lv_name_107_0= RULE_ID ) ) otherlv_108= Colon ( (lv_val_109_0= ruleStringTerm ) ) ) )
            int alt51=23;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalResoluteParser.g:3393:2: ( () ( ( ruleQCREF ) ) )
                    {
                    // InternalResoluteParser.g:3393:2: ( () ( ( ruleQCREF ) ) )
                    // InternalResoluteParser.g:3393:3: () ( ( ruleQCREF ) )
                    {
                    // InternalResoluteParser.g:3393:3: ()
                    // InternalResoluteParser.g:3394:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIdExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3399:2: ( ( ruleQCREF ) )
                    // InternalResoluteParser.g:3400:1: ( ruleQCREF )
                    {
                    // InternalResoluteParser.g:3400:1: ( ruleQCREF )
                    // InternalResoluteParser.g:3401:3: ruleQCREF
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
                    // InternalResoluteParser.g:3416:6: ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? )
                    {
                    // InternalResoluteParser.g:3416:6: ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? )
                    // InternalResoluteParser.g:3416:7: () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )?
                    {
                    // InternalResoluteParser.g:3416:7: ()
                    // InternalResoluteParser.g:3417:5: 
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
                    // InternalResoluteParser.g:3427:1: (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==FullStop) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalResoluteParser.g:3428:2: otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) )
                            {
                            otherlv_4=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getAtomicExprAccess().getFullStopKeyword_1_2_0());
                                  
                            }
                            // InternalResoluteParser.g:3432:1: ( (lv_sub_5_0= ruleNestedDotID ) )
                            // InternalResoluteParser.g:3433:1: (lv_sub_5_0= ruleNestedDotID )
                            {
                            // InternalResoluteParser.g:3433:1: (lv_sub_5_0= ruleNestedDotID )
                            // InternalResoluteParser.g:3434:3: lv_sub_5_0= ruleNestedDotID
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
                    // InternalResoluteParser.g:3451:6: ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) )
                    {
                    // InternalResoluteParser.g:3451:6: ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) )
                    // InternalResoluteParser.g:3451:7: () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) )
                    {
                    // InternalResoluteParser.g:3451:7: ()
                    // InternalResoluteParser.g:3452:5: 
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
                    // InternalResoluteParser.g:3462:1: ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( ((LA34_0>=Revised_without_review && LA34_0<=Is_virtual_processor)||(LA34_0>=Flow_specifications && LA34_0<=Is_abstract_feature)||LA34_0==Revised_with_review||LA34_0==Enumerated_values||(LA34_0>=End_to_end_flows && LA34_0<=Is_bidirectional)||(LA34_0>=Is_thread_group && LA34_0<=Contain_error)||(LA34_0>=Flow_elements && LA34_0<=Is_subprogram)||(LA34_0>=Receive_error && LA34_0<=Is_processor)||LA34_0==Connections||(LA34_0>=Destination && LA34_0<=Lower_bound)||(LA34_0>=Undeveloped && LA34_0<=Upper_bound)||(LA34_0>=Has_member && LA34_0<=Identifier)||(LA34_0>=Is_of_type && LA34_0<=Is_process)||(LA34_0>=Direction && LA34_0<=Is_thread)||LA34_0==Analysis||(LA34_0>=Evidence && LA34_0<=Instance)||(LA34_0>=Property && LA34_0<=Solution)||LA34_0==As_list||(LA34_0>=Is_data && LA34_0<=Is_port)||LA34_0==Warning||(LA34_0>=Append && LA34_0<=As_set)||(LA34_0>=Exists && LA34_0<=Member)||(LA34_0>=Parent && LA34_0<=Source)||LA34_0==Debug||(LA34_0>=Error && LA34_0<=False)||LA34_0==Union||LA34_0==Fail||(LA34_0>=Head && LA34_0<=Name)||(LA34_0>=Size && LA34_0<=Tail)||(LA34_0>=This && LA34_0<=Type)||(LA34_0>=Let && LA34_0<=Sum)||LA34_0==If||LA34_0==LeftParenthesis||LA34_0==HyphenMinus||LA34_0==LeftSquareBracket||LA34_0==LeftCurlyBracket||LA34_0==RULE_REAL_LIT||LA34_0==RULE_INTEGER_LIT||(LA34_0>=RULE_STRING && LA34_0<=RULE_ID)) ) {
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
                            // InternalResoluteParser.g:3462:2: ( (lv_val_8_0= ruleExpr ) )
                            {
                            // InternalResoluteParser.g:3462:2: ( (lv_val_8_0= ruleExpr ) )
                            // InternalResoluteParser.g:3463:1: (lv_val_8_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3463:1: (lv_val_8_0= ruleExpr )
                            // InternalResoluteParser.g:3464:3: lv_val_8_0= ruleExpr
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
                            // InternalResoluteParser.g:3481:6: (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk )
                            {
                            // InternalResoluteParser.g:3481:6: (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk )
                            // InternalResoluteParser.g:3482:2: otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk
                            {
                            otherlv_9=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_23); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getAtomicExprAccess().getAsteriskAsteriskKeyword_2_2_1_0());
                                  
                            }
                            // InternalResoluteParser.g:3486:1: ( (lv_failmsg_10_0= ruleClaimText ) )+
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
                            	    // InternalResoluteParser.g:3487:1: (lv_failmsg_10_0= ruleClaimText )
                            	    {
                            	    // InternalResoluteParser.g:3487:1: (lv_failmsg_10_0= ruleClaimText )
                            	    // InternalResoluteParser.g:3488:3: lv_failmsg_10_0= ruleClaimText
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
                    // InternalResoluteParser.g:3510:6: ( () ( (lv_result_13_0= ruleResult ) ) )
                    {
                    // InternalResoluteParser.g:3510:6: ( () ( (lv_result_13_0= ruleResult ) ) )
                    // InternalResoluteParser.g:3510:7: () ( (lv_result_13_0= ruleResult ) )
                    {
                    // InternalResoluteParser.g:3510:7: ()
                    // InternalResoluteParser.g:3511:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getResultExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3516:2: ( (lv_result_13_0= ruleResult ) )
                    // InternalResoluteParser.g:3517:1: (lv_result_13_0= ruleResult )
                    {
                    // InternalResoluteParser.g:3517:1: (lv_result_13_0= ruleResult )
                    // InternalResoluteParser.g:3518:3: lv_result_13_0= ruleResult
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
                    // InternalResoluteParser.g:3535:6: ( () ( (lv_val_15_0= ruleIntegerTerm ) ) )
                    {
                    // InternalResoluteParser.g:3535:6: ( () ( (lv_val_15_0= ruleIntegerTerm ) ) )
                    // InternalResoluteParser.g:3535:7: () ( (lv_val_15_0= ruleIntegerTerm ) )
                    {
                    // InternalResoluteParser.g:3535:7: ()
                    // InternalResoluteParser.g:3536:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIntExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3541:2: ( (lv_val_15_0= ruleIntegerTerm ) )
                    // InternalResoluteParser.g:3542:1: (lv_val_15_0= ruleIntegerTerm )
                    {
                    // InternalResoluteParser.g:3542:1: (lv_val_15_0= ruleIntegerTerm )
                    // InternalResoluteParser.g:3543:3: lv_val_15_0= ruleIntegerTerm
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
                    // InternalResoluteParser.g:3560:6: ( () ( (lv_val_17_0= ruleRealTerm ) ) )
                    {
                    // InternalResoluteParser.g:3560:6: ( () ( (lv_val_17_0= ruleRealTerm ) ) )
                    // InternalResoluteParser.g:3560:7: () ( (lv_val_17_0= ruleRealTerm ) )
                    {
                    // InternalResoluteParser.g:3560:7: ()
                    // InternalResoluteParser.g:3561:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getRealExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3566:2: ( (lv_val_17_0= ruleRealTerm ) )
                    // InternalResoluteParser.g:3567:1: (lv_val_17_0= ruleRealTerm )
                    {
                    // InternalResoluteParser.g:3567:1: (lv_val_17_0= ruleRealTerm )
                    // InternalResoluteParser.g:3568:3: lv_val_17_0= ruleRealTerm
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
                    // InternalResoluteParser.g:3585:6: ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) )
                    {
                    // InternalResoluteParser.g:3585:6: ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) )
                    // InternalResoluteParser.g:3585:7: () ( (lv_val_19_0= ruleBooleanLiteral ) )
                    {
                    // InternalResoluteParser.g:3585:7: ()
                    // InternalResoluteParser.g:3586:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getBoolExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3591:2: ( (lv_val_19_0= ruleBooleanLiteral ) )
                    // InternalResoluteParser.g:3592:1: (lv_val_19_0= ruleBooleanLiteral )
                    {
                    // InternalResoluteParser.g:3592:1: (lv_val_19_0= ruleBooleanLiteral )
                    // InternalResoluteParser.g:3593:3: lv_val_19_0= ruleBooleanLiteral
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
                    // InternalResoluteParser.g:3610:6: ( () ( (lv_val_21_0= ruleStringTerm ) ) )
                    {
                    // InternalResoluteParser.g:3610:6: ( () ( (lv_val_21_0= ruleStringTerm ) ) )
                    // InternalResoluteParser.g:3610:7: () ( (lv_val_21_0= ruleStringTerm ) )
                    {
                    // InternalResoluteParser.g:3610:7: ()
                    // InternalResoluteParser.g:3611:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getStringExprAction_7_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3616:2: ( (lv_val_21_0= ruleStringTerm ) )
                    // InternalResoluteParser.g:3617:1: (lv_val_21_0= ruleStringTerm )
                    {
                    // InternalResoluteParser.g:3617:1: (lv_val_21_0= ruleStringTerm )
                    // InternalResoluteParser.g:3618:3: lv_val_21_0= ruleStringTerm
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
                    // InternalResoluteParser.g:3635:6: ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:3635:6: ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:3635:7: () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:3635:7: ()
                    // InternalResoluteParser.g:3636:5: 
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
                    // InternalResoluteParser.g:3646:1: ( (lv_cond_24_0= ruleExpr ) )
                    // InternalResoluteParser.g:3647:1: (lv_cond_24_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3647:1: (lv_cond_24_0= ruleExpr )
                    // InternalResoluteParser.g:3648:3: lv_cond_24_0= ruleExpr
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
                    // InternalResoluteParser.g:3669:1: ( (lv_then_26_0= ruleExpr ) )
                    // InternalResoluteParser.g:3670:1: (lv_then_26_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3670:1: (lv_then_26_0= ruleExpr )
                    // InternalResoluteParser.g:3671:3: lv_then_26_0= ruleExpr
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
                    // InternalResoluteParser.g:3692:1: ( (lv_else_28_0= ruleExpr ) )
                    // InternalResoluteParser.g:3693:1: (lv_else_28_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3693:1: (lv_else_28_0= ruleExpr )
                    // InternalResoluteParser.g:3694:3: lv_else_28_0= ruleExpr
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
                    // InternalResoluteParser.g:3711:6: ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:3711:6: ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:3711:7: () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:3711:7: ()
                    // InternalResoluteParser.g:3712:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getQuantifiedExprAction_9_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3717:2: ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) )
                    // InternalResoluteParser.g:3718:1: ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) )
                    {
                    // InternalResoluteParser.g:3718:1: ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) )
                    // InternalResoluteParser.g:3719:1: (lv_quant_30_1= Forall | lv_quant_30_2= Exists )
                    {
                    // InternalResoluteParser.g:3719:1: (lv_quant_30_1= Forall | lv_quant_30_2= Exists )
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
                            // InternalResoluteParser.g:3720:3: lv_quant_30_1= Forall
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
                            // InternalResoluteParser.g:3733:8: lv_quant_30_2= Exists
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

                    // InternalResoluteParser.g:3749:2: (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+
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
                    	    // InternalResoluteParser.g:3750:2: otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis
                    	    {
                    	    otherlv_31=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_31, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_9_2_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:3754:1: ( (lv_args_32_0= ruleArg ) )
                    	    // InternalResoluteParser.g:3755:1: (lv_args_32_0= ruleArg )
                    	    {
                    	    // InternalResoluteParser.g:3755:1: (lv_args_32_0= ruleArg )
                    	    // InternalResoluteParser.g:3756:3: lv_args_32_0= ruleArg
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
                    // InternalResoluteParser.g:3782:1: ( (lv_expr_35_0= ruleExpr ) )
                    // InternalResoluteParser.g:3783:1: (lv_expr_35_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3783:1: (lv_expr_35_0= ruleExpr )
                    // InternalResoluteParser.g:3784:3: lv_expr_35_0= ruleExpr
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
                    // InternalResoluteParser.g:3801:6: ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) )
                    {
                    // InternalResoluteParser.g:3801:6: ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) )
                    // InternalResoluteParser.g:3801:7: ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3828:5: ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis )
                    // InternalResoluteParser.g:3828:6: () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis
                    {
                    // InternalResoluteParser.g:3828:6: ()
                    // InternalResoluteParser.g:3829:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getLibraryFnCallExprAction_10_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3834:2: ( (lv_libName_37_0= RULE_ID ) )
                    // InternalResoluteParser.g:3835:1: (lv_libName_37_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:3835:1: (lv_libName_37_0= RULE_ID )
                    // InternalResoluteParser.g:3836:3: lv_libName_37_0= RULE_ID
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
                    // InternalResoluteParser.g:3857:1: ( (lv_fnName_39_0= RULE_ID ) )
                    // InternalResoluteParser.g:3858:1: (lv_fnName_39_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:3858:1: (lv_fnName_39_0= RULE_ID )
                    // InternalResoluteParser.g:3859:3: lv_fnName_39_0= RULE_ID
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
                    // InternalResoluteParser.g:3880:1: ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( ((LA38_0>=Revised_without_review && LA38_0<=Is_virtual_processor)||(LA38_0>=Flow_specifications && LA38_0<=Is_abstract_feature)||LA38_0==Revised_with_review||LA38_0==Enumerated_values||(LA38_0>=End_to_end_flows && LA38_0<=Is_bidirectional)||(LA38_0>=Is_thread_group && LA38_0<=Contain_error)||(LA38_0>=Flow_elements && LA38_0<=Is_subprogram)||(LA38_0>=Receive_error && LA38_0<=Is_processor)||LA38_0==Connections||(LA38_0>=Destination && LA38_0<=Lower_bound)||(LA38_0>=Undeveloped && LA38_0<=Upper_bound)||(LA38_0>=Has_member && LA38_0<=Identifier)||(LA38_0>=Is_of_type && LA38_0<=Is_process)||(LA38_0>=Direction && LA38_0<=Is_thread)||LA38_0==Analysis||(LA38_0>=Evidence && LA38_0<=Instance)||(LA38_0>=Property && LA38_0<=Solution)||LA38_0==As_list||(LA38_0>=Is_data && LA38_0<=Is_port)||LA38_0==Warning||(LA38_0>=Append && LA38_0<=As_set)||(LA38_0>=Exists && LA38_0<=Member)||(LA38_0>=Parent && LA38_0<=Source)||LA38_0==Debug||(LA38_0>=Error && LA38_0<=False)||LA38_0==Union||LA38_0==Fail||(LA38_0>=Head && LA38_0<=Name)||(LA38_0>=Size && LA38_0<=Tail)||(LA38_0>=This && LA38_0<=Type)||(LA38_0>=Let && LA38_0<=Sum)||LA38_0==If||LA38_0==LeftParenthesis||LA38_0==HyphenMinus||LA38_0==LeftSquareBracket||LA38_0==LeftCurlyBracket||LA38_0==RULE_REAL_LIT||LA38_0==RULE_INTEGER_LIT||(LA38_0>=RULE_STRING && LA38_0<=RULE_ID)) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalResoluteParser.g:3880:2: ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3880:2: ( (lv_args_41_0= ruleExpr ) )
                            // InternalResoluteParser.g:3881:1: (lv_args_41_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3881:1: (lv_args_41_0= ruleExpr )
                            // InternalResoluteParser.g:3882:3: lv_args_41_0= ruleExpr
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

                            // InternalResoluteParser.g:3898:2: (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )*
                            loop37:
                            do {
                                int alt37=2;
                                int LA37_0 = input.LA(1);

                                if ( (LA37_0==Comma) ) {
                                    alt37=1;
                                }


                                switch (alt37) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3899:2: otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) )
                            	    {
                            	    otherlv_42=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_42, grammarAccess.getAtomicExprAccess().getCommaKeyword_10_0_5_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3903:1: ( (lv_args_43_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3904:1: (lv_args_43_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3904:1: (lv_args_43_0= ruleExpr )
                            	    // InternalResoluteParser.g:3905:3: lv_args_43_0= ruleExpr
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
                    // InternalResoluteParser.g:3927:6: ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3927:6: ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis )
                    // InternalResoluteParser.g:3927:7: () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis
                    {
                    // InternalResoluteParser.g:3927:7: ()
                    // InternalResoluteParser.g:3928:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getBuiltInFnCallExprAction_11_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3933:2: ( (lv_fn_46_0= ruleBuiltInFn ) )
                    // InternalResoluteParser.g:3934:1: (lv_fn_46_0= ruleBuiltInFn )
                    {
                    // InternalResoluteParser.g:3934:1: (lv_fn_46_0= ruleBuiltInFn )
                    // InternalResoluteParser.g:3935:3: lv_fn_46_0= ruleBuiltInFn
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
                    // InternalResoluteParser.g:3956:1: ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( ((LA40_0>=Revised_without_review && LA40_0<=Is_virtual_processor)||(LA40_0>=Flow_specifications && LA40_0<=Is_abstract_feature)||LA40_0==Revised_with_review||LA40_0==Enumerated_values||(LA40_0>=End_to_end_flows && LA40_0<=Is_bidirectional)||(LA40_0>=Is_thread_group && LA40_0<=Contain_error)||(LA40_0>=Flow_elements && LA40_0<=Is_subprogram)||(LA40_0>=Receive_error && LA40_0<=Is_processor)||LA40_0==Connections||(LA40_0>=Destination && LA40_0<=Lower_bound)||(LA40_0>=Undeveloped && LA40_0<=Upper_bound)||(LA40_0>=Has_member && LA40_0<=Identifier)||(LA40_0>=Is_of_type && LA40_0<=Is_process)||(LA40_0>=Direction && LA40_0<=Is_thread)||LA40_0==Analysis||(LA40_0>=Evidence && LA40_0<=Instance)||(LA40_0>=Property && LA40_0<=Solution)||LA40_0==As_list||(LA40_0>=Is_data && LA40_0<=Is_port)||LA40_0==Warning||(LA40_0>=Append && LA40_0<=As_set)||(LA40_0>=Exists && LA40_0<=Member)||(LA40_0>=Parent && LA40_0<=Source)||LA40_0==Debug||(LA40_0>=Error && LA40_0<=False)||LA40_0==Union||LA40_0==Fail||(LA40_0>=Head && LA40_0<=Name)||(LA40_0>=Size && LA40_0<=Tail)||(LA40_0>=This && LA40_0<=Type)||(LA40_0>=Let && LA40_0<=Sum)||LA40_0==If||LA40_0==LeftParenthesis||LA40_0==HyphenMinus||LA40_0==LeftSquareBracket||LA40_0==LeftCurlyBracket||LA40_0==RULE_REAL_LIT||LA40_0==RULE_INTEGER_LIT||(LA40_0>=RULE_STRING && LA40_0<=RULE_ID)) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalResoluteParser.g:3956:2: ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3956:2: ( (lv_args_48_0= ruleExpr ) )
                            // InternalResoluteParser.g:3957:1: (lv_args_48_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3957:1: (lv_args_48_0= ruleExpr )
                            // InternalResoluteParser.g:3958:3: lv_args_48_0= ruleExpr
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

                            // InternalResoluteParser.g:3974:2: (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )*
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==Comma) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3975:2: otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) )
                            	    {
                            	    otherlv_49=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_49, grammarAccess.getAtomicExprAccess().getCommaKeyword_11_3_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3979:1: ( (lv_args_50_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3980:1: (lv_args_50_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3980:1: (lv_args_50_0= ruleExpr )
                            	    // InternalResoluteParser.g:3981:3: lv_args_50_0= ruleExpr
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
                    // InternalResoluteParser.g:4003:6: ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis )
                    {
                    // InternalResoluteParser.g:4003:6: ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis )
                    // InternalResoluteParser.g:4003:7: () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis
                    {
                    // InternalResoluteParser.g:4003:7: ()
                    // InternalResoluteParser.g:4004:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getFnCallExprAction_12_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4009:2: ( (otherlv_53= RULE_ID ) )
                    // InternalResoluteParser.g:4010:1: (otherlv_53= RULE_ID )
                    {
                    // InternalResoluteParser.g:4010:1: (otherlv_53= RULE_ID )
                    // InternalResoluteParser.g:4011:3: otherlv_53= RULE_ID
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
                    // InternalResoluteParser.g:4027:1: ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=Revised_without_review && LA42_0<=Is_virtual_processor)||(LA42_0>=Flow_specifications && LA42_0<=Is_abstract_feature)||LA42_0==Revised_with_review||LA42_0==Enumerated_values||(LA42_0>=End_to_end_flows && LA42_0<=Is_bidirectional)||(LA42_0>=Is_thread_group && LA42_0<=Contain_error)||(LA42_0>=Flow_elements && LA42_0<=Is_subprogram)||(LA42_0>=Receive_error && LA42_0<=Is_processor)||LA42_0==Connections||(LA42_0>=Destination && LA42_0<=Lower_bound)||(LA42_0>=Undeveloped && LA42_0<=Upper_bound)||(LA42_0>=Has_member && LA42_0<=Identifier)||(LA42_0>=Is_of_type && LA42_0<=Is_process)||(LA42_0>=Direction && LA42_0<=Is_thread)||LA42_0==Analysis||(LA42_0>=Evidence && LA42_0<=Instance)||(LA42_0>=Property && LA42_0<=Solution)||LA42_0==As_list||(LA42_0>=Is_data && LA42_0<=Is_port)||LA42_0==Warning||(LA42_0>=Append && LA42_0<=As_set)||(LA42_0>=Exists && LA42_0<=Member)||(LA42_0>=Parent && LA42_0<=Source)||LA42_0==Debug||(LA42_0>=Error && LA42_0<=False)||LA42_0==Union||LA42_0==Fail||(LA42_0>=Head && LA42_0<=Name)||(LA42_0>=Size && LA42_0<=Tail)||(LA42_0>=This && LA42_0<=Type)||(LA42_0>=Let && LA42_0<=Sum)||LA42_0==If||LA42_0==LeftParenthesis||LA42_0==HyphenMinus||LA42_0==LeftSquareBracket||LA42_0==LeftCurlyBracket||LA42_0==RULE_REAL_LIT||LA42_0==RULE_INTEGER_LIT||(LA42_0>=RULE_STRING && LA42_0<=RULE_ID)) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalResoluteParser.g:4027:2: ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:4027:2: ( (lv_args_55_0= ruleExpr ) )
                            // InternalResoluteParser.g:4028:1: (lv_args_55_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:4028:1: (lv_args_55_0= ruleExpr )
                            // InternalResoluteParser.g:4029:3: lv_args_55_0= ruleExpr
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

                            // InternalResoluteParser.g:4045:2: (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )*
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==Comma) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4046:2: otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) )
                            	    {
                            	    otherlv_56=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_56, grammarAccess.getAtomicExprAccess().getCommaKeyword_12_3_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4050:1: ( (lv_args_57_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:4051:1: (lv_args_57_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:4051:1: (lv_args_57_0= ruleExpr )
                            	    // InternalResoluteParser.g:4052:3: lv_args_57_0= ruleExpr
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
                    // InternalResoluteParser.g:4074:6: ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) )
                    {
                    // InternalResoluteParser.g:4074:6: ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) )
                    // InternalResoluteParser.g:4074:7: () ( (lv_lintStmt_60_0= ruleLintStatement ) )
                    {
                    // InternalResoluteParser.g:4074:7: ()
                    // InternalResoluteParser.g:4075:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getLintExprAction_13_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:4080:2: ( (lv_lintStmt_60_0= ruleLintStatement ) )
                    // InternalResoluteParser.g:4081:1: (lv_lintStmt_60_0= ruleLintStatement )
                    {
                    // InternalResoluteParser.g:4081:1: (lv_lintStmt_60_0= ruleLintStatement )
                    // InternalResoluteParser.g:4082:3: lv_lintStmt_60_0= ruleLintStatement
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
                    // InternalResoluteParser.g:4099:6: (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:4099:6: (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket )
                    // InternalResoluteParser.g:4100:2: otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket
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
                    // InternalResoluteParser.g:4113:1: ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) )
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
                            // InternalResoluteParser.g:4113:2: ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? )
                            {
                            // InternalResoluteParser.g:4113:2: ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? )
                            // InternalResoluteParser.g:4113:3: () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )?
                            {
                            // InternalResoluteParser.g:4113:3: ()
                            // InternalResoluteParser.g:4114:5: 
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
                            // InternalResoluteParser.g:4124:1: (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+
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
                            	    // InternalResoluteParser.g:4125:2: otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis
                            	    {
                            	    otherlv_65=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_65, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_14_2_0_2_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4129:1: ( (lv_args_66_0= ruleArg ) )
                            	    // InternalResoluteParser.g:4130:1: (lv_args_66_0= ruleArg )
                            	    {
                            	    // InternalResoluteParser.g:4130:1: (lv_args_66_0= ruleArg )
                            	    // InternalResoluteParser.g:4131:3: lv_args_66_0= ruleArg
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

                            // InternalResoluteParser.g:4152:3: (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )?
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( (LA44_0==VerticalLine) ) {
                                alt44=1;
                            }
                            switch (alt44) {
                                case 1 :
                                    // InternalResoluteParser.g:4153:2: otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) )
                                    {
                                    otherlv_68=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_16); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_68, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_14_2_0_3_0());
                                          
                                    }
                                    // InternalResoluteParser.g:4157:1: ( (lv_filter_69_0= ruleExpr ) )
                                    // InternalResoluteParser.g:4158:1: (lv_filter_69_0= ruleExpr )
                                    {
                                    // InternalResoluteParser.g:4158:1: (lv_filter_69_0= ruleExpr )
                                    // InternalResoluteParser.g:4159:3: lv_filter_69_0= ruleExpr
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
                            // InternalResoluteParser.g:4176:6: ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* )
                            {
                            // InternalResoluteParser.g:4176:6: ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* )
                            // InternalResoluteParser.g:4176:7: () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:4176:7: ()
                            // InternalResoluteParser.g:4177:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndAdd(
                                          grammarAccess.getAtomicExprAccess().getListExprExprsAction_14_2_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalResoluteParser.g:4182:2: (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )*
                            loop45:
                            do {
                                int alt45=2;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==Comma) ) {
                                    alt45=1;
                                }


                                switch (alt45) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4183:2: otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) )
                            	    {
                            	    otherlv_71=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_71, grammarAccess.getAtomicExprAccess().getCommaKeyword_14_2_1_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4187:1: ( (lv_exprs_72_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:4188:1: (lv_exprs_72_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:4188:1: (lv_exprs_72_0= ruleExpr )
                            	    // InternalResoluteParser.g:4189:3: lv_exprs_72_0= ruleExpr
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
                    // InternalResoluteParser.g:4211:6: (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:4211:6: (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket )
                    // InternalResoluteParser.g:4212:2: otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket
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
                    // InternalResoluteParser.g:4225:1: ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) )
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
                            // InternalResoluteParser.g:4225:2: ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? )
                            {
                            // InternalResoluteParser.g:4225:2: ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? )
                            // InternalResoluteParser.g:4225:3: () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )?
                            {
                            // InternalResoluteParser.g:4225:3: ()
                            // InternalResoluteParser.g:4226:5: 
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
                            // InternalResoluteParser.g:4236:1: (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+
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
                            	    // InternalResoluteParser.g:4237:2: otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis
                            	    {
                            	    otherlv_78=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_78, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_15_2_0_2_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4241:1: ( (lv_args_79_0= ruleArg ) )
                            	    // InternalResoluteParser.g:4242:1: (lv_args_79_0= ruleArg )
                            	    {
                            	    // InternalResoluteParser.g:4242:1: (lv_args_79_0= ruleArg )
                            	    // InternalResoluteParser.g:4243:3: lv_args_79_0= ruleArg
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

                            // InternalResoluteParser.g:4264:3: (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )?
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( (LA48_0==VerticalLine) ) {
                                alt48=1;
                            }
                            switch (alt48) {
                                case 1 :
                                    // InternalResoluteParser.g:4265:2: otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) )
                                    {
                                    otherlv_81=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_16); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_81, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_15_2_0_3_0());
                                          
                                    }
                                    // InternalResoluteParser.g:4269:1: ( (lv_filter_82_0= ruleExpr ) )
                                    // InternalResoluteParser.g:4270:1: (lv_filter_82_0= ruleExpr )
                                    {
                                    // InternalResoluteParser.g:4270:1: (lv_filter_82_0= ruleExpr )
                                    // InternalResoluteParser.g:4271:3: lv_filter_82_0= ruleExpr
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
                            // InternalResoluteParser.g:4288:6: ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* )
                            {
                            // InternalResoluteParser.g:4288:6: ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* )
                            // InternalResoluteParser.g:4288:7: () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:4288:7: ()
                            // InternalResoluteParser.g:4289:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndAdd(
                                          grammarAccess.getAtomicExprAccess().getSetExprExprsAction_15_2_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalResoluteParser.g:4294:2: (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )*
                            loop49:
                            do {
                                int alt49=2;
                                int LA49_0 = input.LA(1);

                                if ( (LA49_0==Comma) ) {
                                    alt49=1;
                                }


                                switch (alt49) {
                            	case 1 :
                            	    // InternalResoluteParser.g:4295:2: otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) )
                            	    {
                            	    otherlv_84=(Token)match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_84, grammarAccess.getAtomicExprAccess().getCommaKeyword_15_2_1_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:4299:1: ( (lv_exprs_85_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:4300:1: (lv_exprs_85_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:4300:1: (lv_exprs_85_0= ruleExpr )
                            	    // InternalResoluteParser.g:4301:3: lv_exprs_85_0= ruleExpr
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
                    // InternalResoluteParser.g:4323:6: ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:4323:6: ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket )
                    // InternalResoluteParser.g:4323:7: () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket
                    {
                    // InternalResoluteParser.g:4323:7: ()
                    // InternalResoluteParser.g:4324:5: 
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
                    // InternalResoluteParser.g:4340:6: ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:4340:6: ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket )
                    // InternalResoluteParser.g:4340:7: () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket
                    {
                    // InternalResoluteParser.g:4340:7: ()
                    // InternalResoluteParser.g:4341:5: 
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
                    // InternalResoluteParser.g:4357:6: ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4357:6: ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4357:7: () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4357:7: ()
                    // InternalResoluteParser.g:4358:5: 
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
                    // InternalResoluteParser.g:4368:1: ( (lv_binding_95_0= ruleLetBinding ) )
                    // InternalResoluteParser.g:4369:1: (lv_binding_95_0= ruleLetBinding )
                    {
                    // InternalResoluteParser.g:4369:1: (lv_binding_95_0= ruleLetBinding )
                    // InternalResoluteParser.g:4370:3: lv_binding_95_0= ruleLetBinding
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
                    // InternalResoluteParser.g:4391:1: ( (lv_expr_97_0= ruleExpr ) )
                    // InternalResoluteParser.g:4392:1: (lv_expr_97_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4392:1: (lv_expr_97_0= ruleExpr )
                    // InternalResoluteParser.g:4393:3: lv_expr_97_0= ruleExpr
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
                    // InternalResoluteParser.g:4410:6: (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis )
                    {
                    // InternalResoluteParser.g:4410:6: (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis )
                    // InternalResoluteParser.g:4411:2: otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis
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
                    // InternalResoluteParser.g:4430:6: ( () otherlv_102= Undeveloped )
                    {
                    // InternalResoluteParser.g:4430:6: ( () otherlv_102= Undeveloped )
                    // InternalResoluteParser.g:4430:7: () otherlv_102= Undeveloped
                    {
                    // InternalResoluteParser.g:4430:7: ()
                    // InternalResoluteParser.g:4431:5: 
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
                    // InternalResoluteParser.g:4442:6: ( () otherlv_104= Evidence )
                    {
                    // InternalResoluteParser.g:4442:6: ( () otherlv_104= Evidence )
                    // InternalResoluteParser.g:4442:7: () otherlv_104= Evidence
                    {
                    // InternalResoluteParser.g:4442:7: ()
                    // InternalResoluteParser.g:4443:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getEvidenceExprAction_21_0(),
                                  current);
                          
                    }

                    }

                    otherlv_104=(Token)match(input,Evidence,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_104, grammarAccess.getAtomicExprAccess().getEvidenceKeyword_21_1());
                          
                    }

                    }


                    }
                    break;
                case 23 :
                    // InternalResoluteParser.g:4454:6: ( () otherlv_106= Solution ( (lv_name_107_0= RULE_ID ) ) otherlv_108= Colon ( (lv_val_109_0= ruleStringTerm ) ) )
                    {
                    // InternalResoluteParser.g:4454:6: ( () otherlv_106= Solution ( (lv_name_107_0= RULE_ID ) ) otherlv_108= Colon ( (lv_val_109_0= ruleStringTerm ) ) )
                    // InternalResoluteParser.g:4454:7: () otherlv_106= Solution ( (lv_name_107_0= RULE_ID ) ) otherlv_108= Colon ( (lv_val_109_0= ruleStringTerm ) )
                    {
                    // InternalResoluteParser.g:4454:7: ()
                    // InternalResoluteParser.g:4455:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getSolutionExprAction_22_0(),
                                  current);
                          
                    }

                    }

                    otherlv_106=(Token)match(input,Solution,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_106, grammarAccess.getAtomicExprAccess().getSolutionKeyword_22_1());
                          
                    }
                    // InternalResoluteParser.g:4465:1: ( (lv_name_107_0= RULE_ID ) )
                    // InternalResoluteParser.g:4466:1: (lv_name_107_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:4466:1: (lv_name_107_0= RULE_ID )
                    // InternalResoluteParser.g:4467:3: lv_name_107_0= RULE_ID
                    {
                    lv_name_107_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_107_0, grammarAccess.getAtomicExprAccess().getNameIDTerminalRuleCall_22_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicExprRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_107_0, 
                              		"org.osate.xtext.aadl2.properties.Properties.ID");
                      	    
                    }

                    }


                    }

                    otherlv_108=(Token)match(input,Colon,FollowSets000.FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_108, grammarAccess.getAtomicExprAccess().getColonKeyword_22_3());
                          
                    }
                    // InternalResoluteParser.g:4488:1: ( (lv_val_109_0= ruleStringTerm ) )
                    // InternalResoluteParser.g:4489:1: (lv_val_109_0= ruleStringTerm )
                    {
                    // InternalResoluteParser.g:4489:1: (lv_val_109_0= ruleStringTerm )
                    // InternalResoluteParser.g:4490:3: lv_val_109_0= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getValStringTermParserRuleCall_22_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_109_0=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicExprRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_109_0, 
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
    // InternalResoluteParser.g:4514:1: entryRuleLetBinding returns [EObject current=null] : iv_ruleLetBinding= ruleLetBinding EOF ;
    public final EObject entryRuleLetBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetBinding = null;


        try {
            // InternalResoluteParser.g:4515:2: (iv_ruleLetBinding= ruleLetBinding EOF )
            // InternalResoluteParser.g:4516:2: iv_ruleLetBinding= ruleLetBinding EOF
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
    // InternalResoluteParser.g:4523:1: ruleLetBinding returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleLetBinding() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4526:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) )
            // InternalResoluteParser.g:4527:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // InternalResoluteParser.g:4527:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            // InternalResoluteParser.g:4527:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
            {
            // InternalResoluteParser.g:4527:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:4528:1: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:4528:1: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:4529:3: lv_name_0_0= RULE_ID
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
            // InternalResoluteParser.g:4550:1: ( (lv_type_2_0= ruleType ) )
            // InternalResoluteParser.g:4551:1: (lv_type_2_0= ruleType )
            {
            // InternalResoluteParser.g:4551:1: (lv_type_2_0= ruleType )
            // InternalResoluteParser.g:4552:3: lv_type_2_0= ruleType
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
            // InternalResoluteParser.g:4573:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalResoluteParser.g:4574:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalResoluteParser.g:4574:1: (lv_expr_4_0= ruleExpr )
            // InternalResoluteParser.g:4575:3: lv_expr_4_0= ruleExpr
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
    // InternalResoluteParser.g:4599:1: entryRuleResult returns [String current=null] : iv_ruleResult= ruleResult EOF ;
    public final String entryRuleResult() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleResult = null;


        try {
            // InternalResoluteParser.g:4600:1: (iv_ruleResult= ruleResult EOF )
            // InternalResoluteParser.g:4601:2: iv_ruleResult= ruleResult EOF
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
    // InternalResoluteParser.g:4608:1: ruleResult returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Passed | kw= Failed | kw= Indeterminate | kw= Revised_with_review | kw= Revised_without_review ) ;
    public final AntlrDatatypeRuleToken ruleResult() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4612:6: ( (kw= Passed | kw= Failed | kw= Indeterminate | kw= Revised_with_review | kw= Revised_without_review ) )
            // InternalResoluteParser.g:4613:1: (kw= Passed | kw= Failed | kw= Indeterminate | kw= Revised_with_review | kw= Revised_without_review )
            {
            // InternalResoluteParser.g:4613:1: (kw= Passed | kw= Failed | kw= Indeterminate | kw= Revised_with_review | kw= Revised_without_review )
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
                    // InternalResoluteParser.g:4614:2: kw= Passed
                    {
                    kw=(Token)match(input,Passed,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getPassedKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:4621:2: kw= Failed
                    {
                    kw=(Token)match(input,Failed,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getFailedKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:4628:2: kw= Indeterminate
                    {
                    kw=(Token)match(input,Indeterminate,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getIndeterminateKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:4635:2: kw= Revised_with_review
                    {
                    kw=(Token)match(input,Revised_with_review,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getResultAccess().getRevised_with_reviewKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:4642:2: kw= Revised_without_review
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
    // InternalResoluteParser.g:4655:1: entryRuleBuiltInFn returns [String current=null] : iv_ruleBuiltInFn= ruleBuiltInFn EOF ;
    public final String entryRuleBuiltInFn() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBuiltInFn = null;


        try {
            // InternalResoluteParser.g:4656:1: (iv_ruleBuiltInFn= ruleBuiltInFn EOF )
            // InternalResoluteParser.g:4657:2: iv_ruleBuiltInFn= ruleBuiltInFn EOF
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
    // InternalResoluteParser.g:4664:1: ruleBuiltInFn returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows | kw= Identifier ) ;
    public final AntlrDatatypeRuleToken ruleBuiltInFn() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4668:6: ( (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows | kw= Identifier ) )
            // InternalResoluteParser.g:4669:1: (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows | kw= Identifier )
            {
            // InternalResoluteParser.g:4669:1: (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows | kw= Identifier )
            int alt53=67;
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
            case Identifier:
                {
                alt53=67;
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
                    // InternalResoluteParser.g:4670:2: kw= Has_property
                    {
                    kw=(Token)match(input,Has_property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_propertyKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:4677:2: kw= Property
                    {
                    kw=(Token)match(input,Property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPropertyKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:4684:2: kw= Property_member
                    {
                    kw=(Token)match(input,Property_member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getProperty_memberKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:4691:2: kw= Has_parent
                    {
                    kw=(Token)match(input,Has_parent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_parentKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:4698:2: kw= Parent
                    {
                    kw=(Token)match(input,Parent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getParentKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:4705:2: kw= Name
                    {
                    kw=(Token)match(input,Name,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getNameKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:4712:2: kw= Type
                    {
                    kw=(Token)match(input,Type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTypeKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalResoluteParser.g:4719:2: kw= Has_type
                    {
                    kw=(Token)match(input,Has_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_typeKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalResoluteParser.g:4726:2: kw= Is_in_array
                    {
                    kw=(Token)match(input,Is_in_array,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_in_arrayKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalResoluteParser.g:4733:2: kw= Has_prototypes
                    {
                    kw=(Token)match(input,Has_prototypes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_prototypesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalResoluteParser.g:4740:2: kw= Has_modes
                    {
                    kw=(Token)match(input,Has_modes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_modesKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalResoluteParser.g:4747:2: kw= Is_processor
                    {
                    kw=(Token)match(input,Is_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_processorKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalResoluteParser.g:4754:2: kw= Is_virtual_processor
                    {
                    kw=(Token)match(input,Is_virtual_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_virtual_processorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalResoluteParser.g:4761:2: kw= Is_system
                    {
                    kw=(Token)match(input,Is_system,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_systemKeyword_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // InternalResoluteParser.g:4768:2: kw= Is_bus
                    {
                    kw=(Token)match(input,Is_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_busKeyword_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // InternalResoluteParser.g:4775:2: kw= Is_virtual_bus
                    {
                    kw=(Token)match(input,Is_virtual_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_virtual_busKeyword_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // InternalResoluteParser.g:4782:2: kw= Is_device
                    {
                    kw=(Token)match(input,Is_device,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_deviceKeyword_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // InternalResoluteParser.g:4789:2: kw= Is_memory
                    {
                    kw=(Token)match(input,Is_memory,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_memoryKeyword_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // InternalResoluteParser.g:4796:2: kw= Is_thread
                    {
                    kw=(Token)match(input,Is_thread,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_threadKeyword_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // InternalResoluteParser.g:4803:2: kw= Is_thread_group
                    {
                    kw=(Token)match(input,Is_thread_group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_thread_groupKeyword_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // InternalResoluteParser.g:4810:2: kw= Is_process
                    {
                    kw=(Token)match(input,Is_process,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_processKeyword_20()); 
                          
                    }

                    }
                    break;
                case 22 :
                    // InternalResoluteParser.g:4817:2: kw= Is_data
                    {
                    kw=(Token)match(input,Is_data,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_dataKeyword_21()); 
                          
                    }

                    }
                    break;
                case 23 :
                    // InternalResoluteParser.g:4824:2: kw= Is_subprogram
                    {
                    kw=(Token)match(input,Is_subprogram,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_subprogramKeyword_22()); 
                          
                    }

                    }
                    break;
                case 24 :
                    // InternalResoluteParser.g:4831:2: kw= Is_of_type
                    {
                    kw=(Token)match(input,Is_of_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_of_typeKeyword_23()); 
                          
                    }

                    }
                    break;
                case 25 :
                    // InternalResoluteParser.g:4838:2: kw= Is_bound_to
                    {
                    kw=(Token)match(input,Is_bound_to,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bound_toKeyword_24()); 
                          
                    }

                    }
                    break;
                case 26 :
                    // InternalResoluteParser.g:4845:2: kw= Has_member
                    {
                    kw=(Token)match(input,Has_member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_memberKeyword_25()); 
                          
                    }

                    }
                    break;
                case 27 :
                    // InternalResoluteParser.g:4852:2: kw= Features
                    {
                    kw=(Token)match(input,Features,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFeaturesKeyword_26()); 
                          
                    }

                    }
                    break;
                case 28 :
                    // InternalResoluteParser.g:4859:2: kw= Connections
                    {
                    kw=(Token)match(input,Connections,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getConnectionsKeyword_27()); 
                          
                    }

                    }
                    break;
                case 29 :
                    // InternalResoluteParser.g:4866:2: kw= Enumerated_values
                    {
                    kw=(Token)match(input,Enumerated_values,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getEnumerated_valuesKeyword_28()); 
                          
                    }

                    }
                    break;
                case 30 :
                    // InternalResoluteParser.g:4873:2: kw= Subcomponents
                    {
                    kw=(Token)match(input,Subcomponents,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSubcomponentsKeyword_29()); 
                          
                    }

                    }
                    break;
                case 31 :
                    // InternalResoluteParser.g:4880:2: kw= Source
                    {
                    kw=(Token)match(input,Source,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSourceKeyword_30()); 
                          
                    }

                    }
                    break;
                case 32 :
                    // InternalResoluteParser.g:4887:2: kw= Destination
                    {
                    kw=(Token)match(input,Destination,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDestinationKeyword_31()); 
                          
                    }

                    }
                    break;
                case 33 :
                    // InternalResoluteParser.g:4894:2: kw= Is_bidirectional
                    {
                    kw=(Token)match(input,Is_bidirectional,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bidirectionalKeyword_32()); 
                          
                    }

                    }
                    break;
                case 34 :
                    // InternalResoluteParser.g:4901:2: kw= Direction
                    {
                    kw=(Token)match(input,Direction,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDirectionKeyword_33()); 
                          
                    }

                    }
                    break;
                case 35 :
                    // InternalResoluteParser.g:4908:2: kw= Is_event_port
                    {
                    kw=(Token)match(input,Is_event_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_event_portKeyword_34()); 
                          
                    }

                    }
                    break;
                case 36 :
                    // InternalResoluteParser.g:4915:2: kw= Is_abstract_feature
                    {
                    kw=(Token)match(input,Is_abstract_feature,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_abstract_featureKeyword_35()); 
                          
                    }

                    }
                    break;
                case 37 :
                    // InternalResoluteParser.g:4922:2: kw= Is_data_port
                    {
                    kw=(Token)match(input,Is_data_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_data_portKeyword_36()); 
                          
                    }

                    }
                    break;
                case 38 :
                    // InternalResoluteParser.g:4929:2: kw= Is_port
                    {
                    kw=(Token)match(input,Is_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_portKeyword_37()); 
                          
                    }

                    }
                    break;
                case 39 :
                    // InternalResoluteParser.g:4936:2: kw= Is_data_access
                    {
                    kw=(Token)match(input,Is_data_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_data_accessKeyword_38()); 
                          
                    }

                    }
                    break;
                case 40 :
                    // InternalResoluteParser.g:4943:2: kw= Is_bus_access
                    {
                    kw=(Token)match(input,Is_bus_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bus_accessKeyword_39()); 
                          
                    }

                    }
                    break;
                case 41 :
                    // InternalResoluteParser.g:4950:2: kw= Lower_bound
                    {
                    kw=(Token)match(input,Lower_bound,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getLower_boundKeyword_40()); 
                          
                    }

                    }
                    break;
                case 42 :
                    // InternalResoluteParser.g:4957:2: kw= Upper_bound
                    {
                    kw=(Token)match(input,Upper_bound,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getUpper_boundKeyword_41()); 
                          
                    }

                    }
                    break;
                case 43 :
                    // InternalResoluteParser.g:4964:2: kw= Member
                    {
                    kw=(Token)match(input,Member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMemberKeyword_42()); 
                          
                    }

                    }
                    break;
                case 44 :
                    // InternalResoluteParser.g:4971:2: kw= Length
                    {
                    kw=(Token)match(input,Length,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getLengthKeyword_43()); 
                          
                    }

                    }
                    break;
                case 45 :
                    // InternalResoluteParser.g:4978:2: kw= Size
                    {
                    kw=(Token)match(input,Size,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSizeKeyword_44()); 
                          
                    }

                    }
                    break;
                case 46 :
                    // InternalResoluteParser.g:4985:2: kw= Sum
                    {
                    kw=(Token)match(input,Sum,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSumKeyword_45()); 
                          
                    }

                    }
                    break;
                case 47 :
                    // InternalResoluteParser.g:4992:2: kw= Append
                    {
                    kw=(Token)match(input,Append,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAppendKeyword_46()); 
                          
                    }

                    }
                    break;
                case 48 :
                    // InternalResoluteParser.g:4999:2: kw= Head
                    {
                    kw=(Token)match(input,Head,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHeadKeyword_47()); 
                          
                    }

                    }
                    break;
                case 49 :
                    // InternalResoluteParser.g:5006:2: kw= Tail
                    {
                    kw=(Token)match(input,Tail,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTailKeyword_48()); 
                          
                    }

                    }
                    break;
                case 50 :
                    // InternalResoluteParser.g:5013:2: kw= As_set
                    {
                    kw=(Token)match(input,As_set,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAs_setKeyword_49()); 
                          
                    }

                    }
                    break;
                case 51 :
                    // InternalResoluteParser.g:5020:2: kw= Union
                    {
                    kw=(Token)match(input,Union,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getUnionKeyword_50()); 
                          
                    }

                    }
                    break;
                case 52 :
                    // InternalResoluteParser.g:5027:2: kw= Intersect
                    {
                    kw=(Token)match(input,Intersect,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIntersectKeyword_51()); 
                          
                    }

                    }
                    break;
                case 53 :
                    // InternalResoluteParser.g:5034:2: kw= As_list
                    {
                    kw=(Token)match(input,As_list,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAs_listKeyword_52()); 
                          
                    }

                    }
                    break;
                case 54 :
                    // InternalResoluteParser.g:5041:2: kw= Instance
                    {
                    kw=(Token)match(input,Instance,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstanceKeyword_53()); 
                          
                    }

                    }
                    break;
                case 55 :
                    // InternalResoluteParser.g:5048:2: kw= Instances
                    {
                    kw=(Token)match(input,Instances,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstancesKeyword_54()); 
                          
                    }

                    }
                    break;
                case 56 :
                    // InternalResoluteParser.g:5055:2: kw= Debug
                    {
                    kw=(Token)match(input,Debug,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDebugKeyword_55()); 
                          
                    }

                    }
                    break;
                case 57 :
                    // InternalResoluteParser.g:5062:2: kw= Analysis
                    {
                    kw=(Token)match(input,Analysis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAnalysisKeyword_56()); 
                          
                    }

                    }
                    break;
                case 58 :
                    // InternalResoluteParser.g:5069:2: kw= Receive_error
                    {
                    kw=(Token)match(input,Receive_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReceive_errorKeyword_57()); 
                          
                    }

                    }
                    break;
                case 59 :
                    // InternalResoluteParser.g:5076:2: kw= Contain_error
                    {
                    kw=(Token)match(input,Contain_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getContain_errorKeyword_58()); 
                          
                    }

                    }
                    break;
                case 60 :
                    // InternalResoluteParser.g:5083:2: kw= Propagate_error
                    {
                    kw=(Token)match(input,Propagate_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPropagate_errorKeyword_59()); 
                          
                    }

                    }
                    break;
                case 61 :
                    // InternalResoluteParser.g:5090:2: kw= Error_state_reachable
                    {
                    kw=(Token)match(input,Error_state_reachable,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getError_state_reachableKeyword_60()); 
                          
                    }

                    }
                    break;
                case 62 :
                    // InternalResoluteParser.g:5097:2: kw= Flow_source
                    {
                    kw=(Token)match(input,Flow_source,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_sourceKeyword_61()); 
                          
                    }

                    }
                    break;
                case 63 :
                    // InternalResoluteParser.g:5104:2: kw= Flow_destination
                    {
                    kw=(Token)match(input,Flow_destination,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_destinationKeyword_62()); 
                          
                    }

                    }
                    break;
                case 64 :
                    // InternalResoluteParser.g:5111:2: kw= Flow_elements
                    {
                    kw=(Token)match(input,Flow_elements,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_elementsKeyword_63()); 
                          
                    }

                    }
                    break;
                case 65 :
                    // InternalResoluteParser.g:5118:2: kw= Flow_specifications
                    {
                    kw=(Token)match(input,Flow_specifications,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_specificationsKeyword_64()); 
                          
                    }

                    }
                    break;
                case 66 :
                    // InternalResoluteParser.g:5125:2: kw= End_to_end_flows
                    {
                    kw=(Token)match(input,End_to_end_flows,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getEnd_to_end_flowsKeyword_65()); 
                          
                    }

                    }
                    break;
                case 67 :
                    // InternalResoluteParser.g:5132:2: kw= Identifier
                    {
                    kw=(Token)match(input,Identifier,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIdentifierKeyword_66()); 
                          
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
    // InternalResoluteParser.g:5145:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalResoluteParser.g:5146:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalResoluteParser.g:5147:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalResoluteParser.g:5154:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5157:28: ( ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalResoluteParser.g:5158:1: ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalResoluteParser.g:5158:1: ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalResoluteParser.g:5158:2: ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalResoluteParser.g:5158:2: ( (lv_value_0_0= ruleUnsignedReal ) )
            // InternalResoluteParser.g:5159:1: (lv_value_0_0= ruleUnsignedReal )
            {
            // InternalResoluteParser.g:5159:1: (lv_value_0_0= ruleUnsignedReal )
            // InternalResoluteParser.g:5160:3: lv_value_0_0= ruleUnsignedReal
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

            // InternalResoluteParser.g:5176:2: ( (otherlv_1= RULE_ID ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==EOF||LA54_1==Conclusion||LA54_1==Instanceof||LA54_1==Notation||(LA54_1>=Strategy && LA54_1<=Applies)||(LA54_1>=Ruleset && LA54_1<=Warning)||LA54_1==Orelse||LA54_1==Check||(LA54_1>=Delta && LA54_1<=Error)||LA54_1==Prove||LA54_1==Else||LA54_1==Goal||LA54_1==Info||LA54_1==Then||LA54_1==And||LA54_1==For||LA54_1==FullStopFullStop||(LA54_1>=LessThanSignEqualsSign && LA54_1<=GreaterThanSignEqualsSign)||LA54_1==In||LA54_1==Or||LA54_1==PercentSign||(LA54_1>=RightParenthesis && LA54_1<=HyphenMinus)||LA54_1==Solidus||(LA54_1>=Semicolon && LA54_1<=GreaterThanSign)||(LA54_1>=RightSquareBracket && LA54_1<=CircumflexAccent)||LA54_1==RightCurlyBracket||LA54_1==RULE_ID) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalResoluteParser.g:5177:1: (otherlv_1= RULE_ID )
                    {
                    // InternalResoluteParser.g:5177:1: (otherlv_1= RULE_ID )
                    // InternalResoluteParser.g:5178:3: otherlv_1= RULE_ID
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
    // InternalResoluteParser.g:5197:1: entryRuleUnsignedReal returns [String current=null] : iv_ruleUnsignedReal= ruleUnsignedReal EOF ;
    public final String entryRuleUnsignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnsignedReal = null;


        try {
            // InternalResoluteParser.g:5198:1: (iv_ruleUnsignedReal= ruleUnsignedReal EOF )
            // InternalResoluteParser.g:5199:2: iv_ruleUnsignedReal= ruleUnsignedReal EOF
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
    // InternalResoluteParser.g:5206:1: ruleUnsignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleUnsignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5210:6: (this_REAL_LIT_0= RULE_REAL_LIT )
            // InternalResoluteParser.g:5211:5: this_REAL_LIT_0= RULE_REAL_LIT
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
    // InternalResoluteParser.g:5226:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalResoluteParser.g:5227:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalResoluteParser.g:5228:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalResoluteParser.g:5235:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5238:28: ( ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalResoluteParser.g:5239:1: ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalResoluteParser.g:5239:1: ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalResoluteParser.g:5239:2: ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalResoluteParser.g:5239:2: ( (lv_value_0_0= ruleUnsignedInt ) )
            // InternalResoluteParser.g:5240:1: (lv_value_0_0= ruleUnsignedInt )
            {
            // InternalResoluteParser.g:5240:1: (lv_value_0_0= ruleUnsignedInt )
            // InternalResoluteParser.g:5241:3: lv_value_0_0= ruleUnsignedInt
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

            // InternalResoluteParser.g:5257:2: ( (otherlv_1= RULE_ID ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==EOF||LA55_1==Conclusion||LA55_1==Instanceof||LA55_1==Notation||(LA55_1>=Strategy && LA55_1<=Applies)||(LA55_1>=Ruleset && LA55_1<=Warning)||LA55_1==Orelse||LA55_1==Check||(LA55_1>=Delta && LA55_1<=Error)||LA55_1==Prove||LA55_1==Else||LA55_1==Goal||LA55_1==Info||LA55_1==Then||LA55_1==And||LA55_1==For||LA55_1==FullStopFullStop||(LA55_1>=LessThanSignEqualsSign && LA55_1<=GreaterThanSignEqualsSign)||LA55_1==In||LA55_1==Or||LA55_1==PercentSign||(LA55_1>=RightParenthesis && LA55_1<=HyphenMinus)||LA55_1==Solidus||(LA55_1>=Semicolon && LA55_1<=GreaterThanSign)||(LA55_1>=RightSquareBracket && LA55_1<=CircumflexAccent)||LA55_1==RightCurlyBracket||LA55_1==RULE_ID) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // InternalResoluteParser.g:5258:1: (otherlv_1= RULE_ID )
                    {
                    // InternalResoluteParser.g:5258:1: (otherlv_1= RULE_ID )
                    // InternalResoluteParser.g:5259:3: otherlv_1= RULE_ID
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
    // InternalResoluteParser.g:5278:1: entryRuleUnsignedInt returns [String current=null] : iv_ruleUnsignedInt= ruleUnsignedInt EOF ;
    public final String entryRuleUnsignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnsignedInt = null;


        try {
            // InternalResoluteParser.g:5279:1: (iv_ruleUnsignedInt= ruleUnsignedInt EOF )
            // InternalResoluteParser.g:5280:2: iv_ruleUnsignedInt= ruleUnsignedInt EOF
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
    // InternalResoluteParser.g:5287:1: ruleUnsignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleUnsignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5291:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalResoluteParser.g:5292:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalResoluteParser.g:5307:1: entryRuleResoluteSubclause returns [EObject current=null] : iv_ruleResoluteSubclause= ruleResoluteSubclause EOF ;
    public final EObject entryRuleResoluteSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResoluteSubclause = null;


        try {
            // InternalResoluteParser.g:5308:2: (iv_ruleResoluteSubclause= ruleResoluteSubclause EOF )
            // InternalResoluteParser.g:5309:2: iv_ruleResoluteSubclause= ruleResoluteSubclause EOF
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
    // InternalResoluteParser.g:5316:1: ruleResoluteSubclause returns [EObject current=null] : ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* ) ;
    public final EObject ruleResoluteSubclause() throws RecognitionException {
        EObject current = null;

        EObject lv_proves_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5319:28: ( ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* ) )
            // InternalResoluteParser.g:5320:1: ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* )
            {
            // InternalResoluteParser.g:5320:1: ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* )
            // InternalResoluteParser.g:5320:2: () ( (lv_proves_1_0= ruleAnalysisStatement ) )*
            {
            // InternalResoluteParser.g:5320:2: ()
            // InternalResoluteParser.g:5321:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getResoluteSubclauseAccess().getResoluteSubclauseAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:5326:2: ( (lv_proves_1_0= ruleAnalysisStatement ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==Check||LA56_0==Prove) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalResoluteParser.g:5327:1: (lv_proves_1_0= ruleAnalysisStatement )
            	    {
            	    // InternalResoluteParser.g:5327:1: (lv_proves_1_0= ruleAnalysisStatement )
            	    // InternalResoluteParser.g:5328:3: lv_proves_1_0= ruleAnalysisStatement
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
    // InternalResoluteParser.g:5352:1: entryRuleNestedDotID returns [EObject current=null] : iv_ruleNestedDotID= ruleNestedDotID EOF ;
    public final EObject entryRuleNestedDotID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedDotID = null;


        try {
            // InternalResoluteParser.g:5353:2: (iv_ruleNestedDotID= ruleNestedDotID EOF )
            // InternalResoluteParser.g:5354:2: iv_ruleNestedDotID= ruleNestedDotID EOF
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
    // InternalResoluteParser.g:5361:1: ruleNestedDotID returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? ) ;
    public final EObject ruleNestedDotID() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_sub_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5364:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? ) )
            // InternalResoluteParser.g:5365:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? )
            {
            // InternalResoluteParser.g:5365:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? )
            // InternalResoluteParser.g:5365:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )?
            {
            // InternalResoluteParser.g:5365:2: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:5366:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:5366:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:5367:3: otherlv_0= RULE_ID
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

            // InternalResoluteParser.g:5378:2: (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==FullStop) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalResoluteParser.g:5379:2: otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) )
                    {
                    otherlv_1=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNestedDotIDAccess().getFullStopKeyword_1_0());
                          
                    }
                    // InternalResoluteParser.g:5383:1: ( (lv_sub_2_0= ruleNestedDotID ) )
                    // InternalResoluteParser.g:5384:1: (lv_sub_2_0= ruleNestedDotID )
                    {
                    // InternalResoluteParser.g:5384:1: (lv_sub_2_0= ruleNestedDotID )
                    // InternalResoluteParser.g:5385:3: lv_sub_2_0= ruleNestedDotID
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
    // InternalResoluteParser.g:5409:1: entryRuleLintStatement returns [EObject current=null] : iv_ruleLintStatement= ruleLintStatement EOF ;
    public final EObject entryRuleLintStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLintStatement = null;


        try {
            // InternalResoluteParser.g:5410:2: (iv_ruleLintStatement= ruleLintStatement EOF )
            // InternalResoluteParser.g:5411:2: iv_ruleLintStatement= ruleLintStatement EOF
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
    // InternalResoluteParser.g:5418:1: ruleLintStatement returns [EObject current=null] : ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) ) ;
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
            // InternalResoluteParser.g:5421:28: ( ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:5422:1: ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:5422:1: ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) )
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
                    // InternalResoluteParser.g:5422:2: ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:5422:2: ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:5422:3: () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:5422:3: ()
                    // InternalResoluteParser.g:5423:5: 
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
                    // InternalResoluteParser.g:5433:1: ( (lv_expr_2_0= ruleExpr ) )
                    // InternalResoluteParser.g:5434:1: (lv_expr_2_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:5434:1: (lv_expr_2_0= ruleExpr )
                    // InternalResoluteParser.g:5435:3: lv_expr_2_0= ruleExpr
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
                    // InternalResoluteParser.g:5452:6: ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:5452:6: ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:5452:7: () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:5452:7: ()
                    // InternalResoluteParser.g:5453:5: 
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
                    // InternalResoluteParser.g:5463:1: ( (lv_expr_5_0= ruleExpr ) )
                    // InternalResoluteParser.g:5464:1: (lv_expr_5_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:5464:1: (lv_expr_5_0= ruleExpr )
                    // InternalResoluteParser.g:5465:3: lv_expr_5_0= ruleExpr
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
                    // InternalResoluteParser.g:5482:6: ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:5482:6: ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:5482:7: () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:5482:7: ()
                    // InternalResoluteParser.g:5483:5: 
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
                    // InternalResoluteParser.g:5493:1: ( (lv_expr_8_0= ruleExpr ) )
                    // InternalResoluteParser.g:5494:1: (lv_expr_8_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:5494:1: (lv_expr_8_0= ruleExpr )
                    // InternalResoluteParser.g:5495:3: lv_expr_8_0= ruleExpr
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
    // InternalResoluteParser.g:5519:1: entryRuleRuleset returns [EObject current=null] : iv_ruleRuleset= ruleRuleset EOF ;
    public final EObject entryRuleRuleset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleset = null;


        try {
            // InternalResoluteParser.g:5520:2: (iv_ruleRuleset= ruleRuleset EOF )
            // InternalResoluteParser.g:5521:2: iv_ruleRuleset= ruleRuleset EOF
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
    // InternalResoluteParser.g:5528:1: ruleRuleset returns [EObject current=null] : (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleRuleset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5531:28: ( (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket ) )
            // InternalResoluteParser.g:5532:1: (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket )
            {
            // InternalResoluteParser.g:5532:1: (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket )
            // InternalResoluteParser.g:5533:2: otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,Ruleset,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRulesetAccess().getRulesetKeyword_0());
                  
            }
            // InternalResoluteParser.g:5537:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:5538:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:5538:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:5539:3: lv_name_1_0= RULE_ID
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
            // InternalResoluteParser.g:5560:1: ( (lv_body_3_0= ruleRulesetBody ) )
            // InternalResoluteParser.g:5561:1: (lv_body_3_0= ruleRulesetBody )
            {
            // InternalResoluteParser.g:5561:1: (lv_body_3_0= ruleRulesetBody )
            // InternalResoluteParser.g:5562:3: lv_body_3_0= ruleRulesetBody
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
    // InternalResoluteParser.g:5591:1: entryRuleRulesetBody returns [EObject current=null] : iv_ruleRulesetBody= ruleRulesetBody EOF ;
    public final EObject entryRuleRulesetBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRulesetBody = null;


        try {
            // InternalResoluteParser.g:5592:2: (iv_ruleRulesetBody= ruleRulesetBody EOF )
            // InternalResoluteParser.g:5593:2: iv_ruleRulesetBody= ruleRulesetBody EOF
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
    // InternalResoluteParser.g:5600:1: ruleRulesetBody returns [EObject current=null] : ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* ) ;
    public final EObject ruleRulesetBody() throws RecognitionException {
        EObject current = null;

        EObject lv_lintStatements_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5603:28: ( ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* ) )
            // InternalResoluteParser.g:5604:1: ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* )
            {
            // InternalResoluteParser.g:5604:1: ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* )
            // InternalResoluteParser.g:5604:2: () ( (lv_lintStatements_1_0= ruleLintStatement ) )*
            {
            // InternalResoluteParser.g:5604:2: ()
            // InternalResoluteParser.g:5605:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRulesetBodyAccess().getRulesetBodyAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:5610:2: ( (lv_lintStatements_1_0= ruleLintStatement ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==Warning||LA59_0==Error||LA59_0==Info) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalResoluteParser.g:5611:1: (lv_lintStatements_1_0= ruleLintStatement )
            	    {
            	    // InternalResoluteParser.g:5611:1: (lv_lintStatements_1_0= ruleLintStatement )
            	    // InternalResoluteParser.g:5612:3: lv_lintStatements_1_0= ruleLintStatement
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
    // InternalResoluteParser.g:5636:1: entryRuleAnalysisStatement returns [EObject current=null] : iv_ruleAnalysisStatement= ruleAnalysisStatement EOF ;
    public final EObject entryRuleAnalysisStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnalysisStatement = null;


        try {
            // InternalResoluteParser.g:5637:2: (iv_ruleAnalysisStatement= ruleAnalysisStatement EOF )
            // InternalResoluteParser.g:5638:2: iv_ruleAnalysisStatement= ruleAnalysisStatement EOF
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
    // InternalResoluteParser.g:5645:1: ruleAnalysisStatement returns [EObject current=null] : ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) ) ;
    public final EObject ruleAnalysisStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expr_2_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5648:28: ( ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:5649:1: ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:5649:1: ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) )
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
                    // InternalResoluteParser.g:5649:2: ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:5649:2: ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:5649:3: () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:5649:3: ()
                    // InternalResoluteParser.g:5650:5: 
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
                    // InternalResoluteParser.g:5660:1: ( (lv_expr_2_0= ruleExpr ) )
                    // InternalResoluteParser.g:5661:1: (lv_expr_2_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:5661:1: (lv_expr_2_0= ruleExpr )
                    // InternalResoluteParser.g:5662:3: lv_expr_2_0= ruleExpr
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
                    // InternalResoluteParser.g:5679:6: ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:5679:6: ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:5679:7: () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:5679:7: ()
                    // InternalResoluteParser.g:5680:5: 
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
                    // InternalResoluteParser.g:5690:1: ( (lv_expr_5_0= ruleExpr ) )
                    // InternalResoluteParser.g:5691:1: (lv_expr_5_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:5691:1: (lv_expr_5_0= ruleExpr )
                    // InternalResoluteParser.g:5692:3: lv_expr_5_0= ruleExpr
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
    // InternalResoluteParser.g:5718:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalResoluteParser.g:5719:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalResoluteParser.g:5720:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalResoluteParser.g:5727:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) ;
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
            // InternalResoluteParser.g:5730:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) )
            // InternalResoluteParser.g:5731:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            {
            // InternalResoluteParser.g:5731:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            // InternalResoluteParser.g:5731:2: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon
            {
            // InternalResoluteParser.g:5731:2: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:5732:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:5732:1: ( ruleQPREF )
            // InternalResoluteParser.g:5733:3: ruleQPREF
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

            // InternalResoluteParser.g:5747:2: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
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
                    // InternalResoluteParser.g:5748:2: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:5753:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalResoluteParser.g:5753:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalResoluteParser.g:5754:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalResoluteParser.g:5754:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalResoluteParser.g:5755:3: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
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

            // InternalResoluteParser.g:5769:3: ( (lv_constant_3_0= Constant ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==Constant) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalResoluteParser.g:5770:1: (lv_constant_3_0= Constant )
                    {
                    // InternalResoluteParser.g:5770:1: (lv_constant_3_0= Constant )
                    // InternalResoluteParser.g:5771:3: lv_constant_3_0= Constant
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

            // InternalResoluteParser.g:5785:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalResoluteParser.g:5785:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalResoluteParser.g:5785:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalResoluteParser.g:5786:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalResoluteParser.g:5786:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalResoluteParser.g:5787:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
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

            // InternalResoluteParser.g:5803:2: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==Comma) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalResoluteParser.g:5804:2: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	          
            	    }
            	    // InternalResoluteParser.g:5808:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalResoluteParser.g:5809:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalResoluteParser.g:5809:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalResoluteParser.g:5810:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
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

            // InternalResoluteParser.g:5826:5: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==Applies) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalResoluteParser.g:5827:5: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
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
                    // InternalResoluteParser.g:5834:1: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalResoluteParser.g:5835:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalResoluteParser.g:5835:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalResoluteParser.g:5836:3: lv_appliesTo_8_0= ruleContainmentPath
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

                    // InternalResoluteParser.g:5852:2: (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==Comma) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalResoluteParser.g:5853:2: otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:5857:1: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalResoluteParser.g:5858:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalResoluteParser.g:5858:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalResoluteParser.g:5859:3: lv_appliesTo_10_0= ruleContainmentPath
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

            // InternalResoluteParser.g:5875:6: ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==In) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalResoluteParser.g:5876:5: ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis
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
                    // InternalResoluteParser.g:5888:1: ( ( ruleQCREF ) )
                    // InternalResoluteParser.g:5889:1: ( ruleQCREF )
                    {
                    // InternalResoluteParser.g:5889:1: ( ruleQCREF )
                    // InternalResoluteParser.g:5890:3: ruleQCREF
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
    // InternalResoluteParser.g:5926:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalResoluteParser.g:5927:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalResoluteParser.g:5928:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalResoluteParser.g:5935:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5938:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalResoluteParser.g:5939:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalResoluteParser.g:5939:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalResoluteParser.g:5940:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalResoluteParser.g:5940:1: (lv_path_0_0= ruleContainmentPathElement )
            // InternalResoluteParser.g:5941:3: lv_path_0_0= ruleContainmentPathElement
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
    // InternalResoluteParser.g:5967:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalResoluteParser.g:5968:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalResoluteParser.g:5969:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalResoluteParser.g:5976:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) ;
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
            // InternalResoluteParser.g:5979:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) )
            // InternalResoluteParser.g:5980:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            {
            // InternalResoluteParser.g:5980:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            // InternalResoluteParser.g:5980:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            {
            // InternalResoluteParser.g:5980:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:5981:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:5981:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalResoluteParser.g:5982:3: lv_ownedValue_0_0= rulePropertyExpression
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

            // InternalResoluteParser.g:5998:2: ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
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
                    // InternalResoluteParser.g:5999:5: ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis
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
                    // InternalResoluteParser.g:6011:1: ( (otherlv_3= RULE_ID ) )
                    // InternalResoluteParser.g:6012:1: (otherlv_3= RULE_ID )
                    {
                    // InternalResoluteParser.g:6012:1: (otherlv_3= RULE_ID )
                    // InternalResoluteParser.g:6013:3: otherlv_3= RULE_ID
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

                    // InternalResoluteParser.g:6024:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==Comma) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalResoluteParser.g:6025:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:6029:1: ( (otherlv_5= RULE_ID ) )
                    	    // InternalResoluteParser.g:6030:1: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalResoluteParser.g:6030:1: (otherlv_5= RULE_ID )
                    	    // InternalResoluteParser.g:6031:3: otherlv_5= RULE_ID
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
    // InternalResoluteParser.g:6055:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalResoluteParser.g:6056:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalResoluteParser.g:6057:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalResoluteParser.g:6064:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6067:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalResoluteParser.g:6068:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalResoluteParser.g:6068:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:6069:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:6069:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalResoluteParser.g:6070:3: lv_ownedValue_0_0= rulePropertyExpression
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
    // InternalResoluteParser.g:6094:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalResoluteParser.g:6095:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalResoluteParser.g:6096:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalResoluteParser.g:6103:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
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
            // InternalResoluteParser.g:6106:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalResoluteParser.g:6107:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalResoluteParser.g:6107:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt69=11;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // InternalResoluteParser.g:6108:5: this_RecordTerm_0= ruleRecordTerm
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
                    // InternalResoluteParser.g:6118:5: this_ReferenceTerm_1= ruleReferenceTerm
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
                    // InternalResoluteParser.g:6128:5: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
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
                    // InternalResoluteParser.g:6138:5: this_ComputedTerm_3= ruleComputedTerm
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
                    // InternalResoluteParser.g:6148:5: this_StringTerm_4= ruleStringTerm
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
                    // InternalResoluteParser.g:6158:5: this_NumericRangeTerm_5= ruleNumericRangeTerm
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
                    // InternalResoluteParser.g:6168:5: this_RealTerm_6= ruleRealTerm
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
                    // InternalResoluteParser.g:6178:5: this_IntegerTerm_7= ruleIntegerTerm
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
                    // InternalResoluteParser.g:6188:5: this_ListTerm_8= ruleListTerm
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
                    // InternalResoluteParser.g:6198:5: this_BooleanLiteral_9= ruleBooleanLiteral
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
                    // InternalResoluteParser.g:6208:5: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
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
    // InternalResoluteParser.g:6224:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalResoluteParser.g:6225:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalResoluteParser.g:6226:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
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
    // InternalResoluteParser.g:6233:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6236:28: ( ( ( ruleQPREF ) ) )
            // InternalResoluteParser.g:6237:1: ( ( ruleQPREF ) )
            {
            // InternalResoluteParser.g:6237:1: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:6238:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:6238:1: ( ruleQPREF )
            // InternalResoluteParser.g:6239:3: ruleQPREF
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
    // InternalResoluteParser.g:6261:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalResoluteParser.g:6262:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalResoluteParser.g:6263:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalResoluteParser.g:6270:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6273:28: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalResoluteParser.g:6274:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalResoluteParser.g:6274:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalResoluteParser.g:6274:2: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalResoluteParser.g:6274:2: ()
            // InternalResoluteParser.g:6275:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:6280:2: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
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
                    // InternalResoluteParser.g:6280:3: ( (lv_value_1_0= True ) )
                    {
                    // InternalResoluteParser.g:6280:3: ( (lv_value_1_0= True ) )
                    // InternalResoluteParser.g:6281:1: (lv_value_1_0= True )
                    {
                    // InternalResoluteParser.g:6281:1: (lv_value_1_0= True )
                    // InternalResoluteParser.g:6282:3: lv_value_1_0= True
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
                    // InternalResoluteParser.g:6298:2: otherlv_2= False
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
    // InternalResoluteParser.g:6310:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalResoluteParser.g:6311:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalResoluteParser.g:6312:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalResoluteParser.g:6319:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6322:28: ( ( ( ruleQPREF ) ) )
            // InternalResoluteParser.g:6323:1: ( ( ruleQPREF ) )
            {
            // InternalResoluteParser.g:6323:1: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:6324:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:6324:1: ( ruleQPREF )
            // InternalResoluteParser.g:6325:3: ruleQPREF
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
    // InternalResoluteParser.g:6347:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalResoluteParser.g:6348:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalResoluteParser.g:6349:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
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
    // InternalResoluteParser.g:6356:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6359:28: ( (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:6360:1: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:6360:1: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:6361:2: otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Reference,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:6370:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalResoluteParser.g:6371:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalResoluteParser.g:6371:1: (lv_path_2_0= ruleContainmentPathElement )
            // InternalResoluteParser.g:6372:3: lv_path_2_0= ruleContainmentPathElement
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
    // InternalResoluteParser.g:6401:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalResoluteParser.g:6402:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalResoluteParser.g:6403:2: iv_ruleRecordTerm= ruleRecordTerm EOF
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
    // InternalResoluteParser.g:6410:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6413:28: ( (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) )
            // InternalResoluteParser.g:6414:1: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            {
            // InternalResoluteParser.g:6414:1: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            // InternalResoluteParser.g:6415:2: otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // InternalResoluteParser.g:6419:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
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
            	    // InternalResoluteParser.g:6420:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalResoluteParser.g:6420:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalResoluteParser.g:6421:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
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
    // InternalResoluteParser.g:6452:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalResoluteParser.g:6453:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalResoluteParser.g:6454:2: iv_ruleComputedTerm= ruleComputedTerm EOF
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
    // InternalResoluteParser.g:6461:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6464:28: ( (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:6465:1: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:6465:1: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:6466:2: otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Compute,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:6475:1: ( (lv_function_2_0= RULE_ID ) )
            // InternalResoluteParser.g:6476:1: (lv_function_2_0= RULE_ID )
            {
            // InternalResoluteParser.g:6476:1: (lv_function_2_0= RULE_ID )
            // InternalResoluteParser.g:6477:3: lv_function_2_0= RULE_ID
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
    // InternalResoluteParser.g:6506:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalResoluteParser.g:6507:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalResoluteParser.g:6508:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
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
    // InternalResoluteParser.g:6515:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6518:28: ( (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:6519:1: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:6519:1: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:6520:2: otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Classifier,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:6529:1: ( ( ruleQCREF ) )
            // InternalResoluteParser.g:6530:1: ( ruleQCREF )
            {
            // InternalResoluteParser.g:6530:1: ( ruleQCREF )
            // InternalResoluteParser.g:6531:3: ruleQCREF
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
    // InternalResoluteParser.g:6558:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalResoluteParser.g:6559:2: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalResoluteParser.g:6560:2: iv_ruleListTerm= ruleListTerm EOF
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
    // InternalResoluteParser.g:6567:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6570:28: ( ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) )
            // InternalResoluteParser.g:6571:1: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            {
            // InternalResoluteParser.g:6571:1: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            // InternalResoluteParser.g:6571:2: () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis
            {
            // InternalResoluteParser.g:6571:2: ()
            // InternalResoluteParser.g:6572:5: 
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
            // InternalResoluteParser.g:6582:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==Classifier||LA73_0==Reference||LA73_0==Compute||LA73_0==False||LA73_0==True||LA73_0==LeftParenthesis||LA73_0==PlusSign||LA73_0==HyphenMinus||LA73_0==LeftSquareBracket||LA73_0==RULE_REAL_LIT||LA73_0==RULE_INTEGER_LIT||(LA73_0>=RULE_STRING && LA73_0<=RULE_ID)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalResoluteParser.g:6582:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalResoluteParser.g:6582:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalResoluteParser.g:6583:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalResoluteParser.g:6583:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalResoluteParser.g:6584:3: lv_ownedListElement_2_0= rulePropertyExpression
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

                    // InternalResoluteParser.g:6600:2: (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==Comma) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // InternalResoluteParser.g:6601:2: otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_57); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:6605:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalResoluteParser.g:6606:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalResoluteParser.g:6606:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalResoluteParser.g:6607:3: lv_ownedListElement_4_0= rulePropertyExpression
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
    // InternalResoluteParser.g:6636:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalResoluteParser.g:6637:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalResoluteParser.g:6638:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalResoluteParser.g:6645:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6648:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalResoluteParser.g:6649:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalResoluteParser.g:6649:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalResoluteParser.g:6649:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalResoluteParser.g:6649:2: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:6650:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:6650:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:6651:3: otherlv_0= RULE_ID
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
            // InternalResoluteParser.g:6667:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:6668:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:6668:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalResoluteParser.g:6669:3: lv_ownedValue_2_0= rulePropertyExpression
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
    // InternalResoluteParser.g:6698:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalResoluteParser.g:6699:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalResoluteParser.g:6700:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalResoluteParser.g:6707:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6710:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalResoluteParser.g:6711:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalResoluteParser.g:6711:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalResoluteParser.g:6711:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalResoluteParser.g:6711:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalResoluteParser.g:6711:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalResoluteParser.g:6711:3: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:6712:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:6712:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:6713:3: otherlv_0= RULE_ID
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

            // InternalResoluteParser.g:6724:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==LeftSquareBracket) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalResoluteParser.g:6725:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalResoluteParser.g:6725:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalResoluteParser.g:6726:3: lv_arrayRange_1_0= ruleArrayRange
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

            // InternalResoluteParser.g:6742:4: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==FullStop) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalResoluteParser.g:6743:2: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                          
                    }
                    // InternalResoluteParser.g:6747:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalResoluteParser.g:6748:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalResoluteParser.g:6748:1: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalResoluteParser.g:6749:3: lv_path_3_0= ruleContainmentPathElement
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
    // InternalResoluteParser.g:6775:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalResoluteParser.g:6776:1: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalResoluteParser.g:6777:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalResoluteParser.g:6784:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6788:6: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalResoluteParser.g:6789:1: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalResoluteParser.g:6789:1: (kw= PlusSign | kw= HyphenMinus )
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
                    // InternalResoluteParser.g:6790:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:6797:2: kw= HyphenMinus
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
    // InternalResoluteParser.g:6810:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalResoluteParser.g:6811:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalResoluteParser.g:6812:2: iv_ruleStringTerm= ruleStringTerm EOF
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
    // InternalResoluteParser.g:6819:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6822:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalResoluteParser.g:6823:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalResoluteParser.g:6823:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalResoluteParser.g:6824:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalResoluteParser.g:6824:1: (lv_value_0_0= ruleNoQuoteString )
            // InternalResoluteParser.g:6825:3: lv_value_0_0= ruleNoQuoteString
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
    // InternalResoluteParser.g:6849:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalResoluteParser.g:6850:1: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalResoluteParser.g:6851:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalResoluteParser.g:6858:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6862:6: (this_STRING_0= RULE_STRING )
            // InternalResoluteParser.g:6863:5: this_STRING_0= RULE_STRING
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
    // InternalResoluteParser.g:6878:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalResoluteParser.g:6879:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalResoluteParser.g:6880:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalResoluteParser.g:6887:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6890:28: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalResoluteParser.g:6891:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalResoluteParser.g:6891:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalResoluteParser.g:6891:2: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalResoluteParser.g:6891:2: ()
            // InternalResoluteParser.g:6892:5: 
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
            // InternalResoluteParser.g:6902:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalResoluteParser.g:6903:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalResoluteParser.g:6903:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalResoluteParser.g:6904:3: lv_lowerBound_2_0= ruleINTVALUE
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

            // InternalResoluteParser.g:6920:2: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==FullStopFullStop) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalResoluteParser.g:6921:2: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                          
                    }
                    // InternalResoluteParser.g:6925:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalResoluteParser.g:6926:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalResoluteParser.g:6926:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalResoluteParser.g:6927:3: lv_upperBound_4_0= ruleINTVALUE
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
    // InternalResoluteParser.g:6956:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalResoluteParser.g:6957:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalResoluteParser.g:6958:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalResoluteParser.g:6965:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6968:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalResoluteParser.g:6969:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalResoluteParser.g:6969:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalResoluteParser.g:6969:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalResoluteParser.g:6969:2: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalResoluteParser.g:6970:1: (lv_op_0_0= rulePlusMinus )
            {
            // InternalResoluteParser.g:6970:1: (lv_op_0_0= rulePlusMinus )
            // InternalResoluteParser.g:6971:3: lv_op_0_0= rulePlusMinus
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

            // InternalResoluteParser.g:6987:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalResoluteParser.g:6988:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalResoluteParser.g:6988:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalResoluteParser.g:6989:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalResoluteParser.g:7017:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalResoluteParser.g:7018:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalResoluteParser.g:7019:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
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
    // InternalResoluteParser.g:7026:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7029:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalResoluteParser.g:7030:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalResoluteParser.g:7030:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalResoluteParser.g:7030:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalResoluteParser.g:7030:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalResoluteParser.g:7031:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalResoluteParser.g:7031:1: (lv_minimum_0_0= ruleNumAlt )
            // InternalResoluteParser.g:7032:3: lv_minimum_0_0= ruleNumAlt
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
            // InternalResoluteParser.g:7053:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalResoluteParser.g:7054:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalResoluteParser.g:7054:1: (lv_maximum_2_0= ruleNumAlt )
            // InternalResoluteParser.g:7055:3: lv_maximum_2_0= ruleNumAlt
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

            // InternalResoluteParser.g:7071:2: (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==Delta) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalResoluteParser.g:7072:2: otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,Delta,FollowSets000.FOLLOW_67); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                          
                    }
                    // InternalResoluteParser.g:7076:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalResoluteParser.g:7077:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalResoluteParser.g:7077:1: (lv_delta_4_0= ruleNumAlt )
                    // InternalResoluteParser.g:7078:3: lv_delta_4_0= ruleNumAlt
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
    // InternalResoluteParser.g:7102:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalResoluteParser.g:7103:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalResoluteParser.g:7104:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalResoluteParser.g:7111:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7114:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalResoluteParser.g:7115:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalResoluteParser.g:7115:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
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
                    // InternalResoluteParser.g:7116:5: this_RealTerm_0= ruleRealTerm
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
                    // InternalResoluteParser.g:7126:5: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalResoluteParser.g:7136:5: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalResoluteParser.g:7146:5: this_ConstantValue_3= ruleConstantValue
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
    // InternalResoluteParser.g:7162:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalResoluteParser.g:7163:1: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalResoluteParser.g:7164:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
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
    // InternalResoluteParser.g:7171:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Applies kw= To ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7175:6: ( (kw= Applies kw= To ) )
            // InternalResoluteParser.g:7176:1: (kw= Applies kw= To )
            {
            // InternalResoluteParser.g:7176:1: (kw= Applies kw= To )
            // InternalResoluteParser.g:7177:2: kw= Applies kw= To
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
    // InternalResoluteParser.g:7196:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalResoluteParser.g:7197:1: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalResoluteParser.g:7198:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
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
    // InternalResoluteParser.g:7205:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Binding ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7209:6: ( (kw= In kw= Binding ) )
            // InternalResoluteParser.g:7210:1: (kw= In kw= Binding )
            {
            // InternalResoluteParser.g:7210:1: (kw= In kw= Binding )
            // InternalResoluteParser.g:7211:2: kw= In kw= Binding
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
    // InternalResoluteParser.g:7230:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalResoluteParser.g:7231:1: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalResoluteParser.g:7232:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
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
    // InternalResoluteParser.g:7239:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Modes ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7243:6: ( (kw= In kw= Modes ) )
            // InternalResoluteParser.g:7244:1: (kw= In kw= Modes )
            {
            // InternalResoluteParser.g:7244:1: (kw= In kw= Modes )
            // InternalResoluteParser.g:7245:2: kw= In kw= Modes
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
    // InternalResoluteParser.g:7264:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalResoluteParser.g:7265:1: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalResoluteParser.g:7266:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalResoluteParser.g:7273:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7277:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalResoluteParser.g:7278:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalResoluteParser.g:7295:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalResoluteParser.g:7296:1: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalResoluteParser.g:7297:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalResoluteParser.g:7304:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7308:6: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalResoluteParser.g:7309:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalResoluteParser.g:7309:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalResoluteParser.g:7309:6: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_73); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalResoluteParser.g:7316:1: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==ColonColon) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalResoluteParser.g:7317:2: kw= ColonColon this_ID_2= RULE_ID
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
    // InternalResoluteParser.g:7337:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalResoluteParser.g:7338:1: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalResoluteParser.g:7339:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalResoluteParser.g:7346:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7350:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalResoluteParser.g:7351:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalResoluteParser.g:7351:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalResoluteParser.g:7351:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalResoluteParser.g:7351:2: (this_ID_0= RULE_ID kw= ColonColon )*
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
            	    // InternalResoluteParser.g:7351:7: this_ID_0= RULE_ID kw= ColonColon
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
            // InternalResoluteParser.g:7371:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==FullStop) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalResoluteParser.g:7372:2: kw= FullStop this_ID_4= RULE_ID
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
    // InternalResoluteParser.g:7392:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalResoluteParser.g:7393:1: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalResoluteParser.g:7394:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalResoluteParser.g:7401:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:7405:6: (kw= Asterisk )
            // InternalResoluteParser.g:7407:2: kw= Asterisk
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
        // InternalResoluteParser.g:1166:3: ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )
        // InternalResoluteParser.g:1166:4: ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) )
        {
        // InternalResoluteParser.g:1166:4: ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) )
        // InternalResoluteParser.g:1166:5: ( ( RULE_ID ) ) Colon ( ( ruleType ) )
        {
        // InternalResoluteParser.g:1166:5: ( ( RULE_ID ) )
        // InternalResoluteParser.g:1167:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:1167:1: ( RULE_ID )
        // InternalResoluteParser.g:1168:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_15); if (state.failed) return ;

        }


        }

        match(input,Colon,FollowSets000.FOLLOW_8); if (state.failed) return ;
        // InternalResoluteParser.g:1173:1: ( ( ruleType ) )
        // InternalResoluteParser.g:1174:1: ( ruleType )
        {
        // InternalResoluteParser.g:1174:1: ( ruleType )
        // InternalResoluteParser.g:1175:1: ruleType
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
        // InternalResoluteParser.g:2479:3: ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )
        // InternalResoluteParser.g:2479:4: ( () ( ( EqualsSignGreaterThanSign ) ) )
        {
        // InternalResoluteParser.g:2479:4: ( () ( ( EqualsSignGreaterThanSign ) ) )
        // InternalResoluteParser.g:2479:5: () ( ( EqualsSignGreaterThanSign ) )
        {
        // InternalResoluteParser.g:2479:5: ()
        // InternalResoluteParser.g:2480:1: 
        {
        }

        // InternalResoluteParser.g:2480:2: ( ( EqualsSignGreaterThanSign ) )
        // InternalResoluteParser.g:2481:1: ( EqualsSignGreaterThanSign )
        {
        // InternalResoluteParser.g:2481:1: ( EqualsSignGreaterThanSign )
        // InternalResoluteParser.g:2483:1: EqualsSignGreaterThanSign
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
        // InternalResoluteParser.g:2557:3: ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )
        // InternalResoluteParser.g:2557:4: ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) )
        {
        // InternalResoluteParser.g:2557:4: ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) )
        // InternalResoluteParser.g:2557:5: () ( ( ( Or ) ) | ( ( Orelse ) ) )
        {
        // InternalResoluteParser.g:2557:5: ()
        // InternalResoluteParser.g:2558:1: 
        {
        }

        // InternalResoluteParser.g:2558:2: ( ( ( Or ) ) | ( ( Orelse ) ) )
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
                // InternalResoluteParser.g:2558:3: ( ( Or ) )
                {
                // InternalResoluteParser.g:2558:3: ( ( Or ) )
                // InternalResoluteParser.g:2559:1: ( Or )
                {
                // InternalResoluteParser.g:2559:1: ( Or )
                // InternalResoluteParser.g:2561:1: Or
                {
                match(input,Or,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalResoluteParser.g:2566:6: ( ( Orelse ) )
                {
                // InternalResoluteParser.g:2566:6: ( ( Orelse ) )
                // InternalResoluteParser.g:2567:1: ( Orelse )
                {
                // InternalResoluteParser.g:2567:1: ( Orelse )
                // InternalResoluteParser.g:2569:1: Orelse
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
        // InternalResoluteParser.g:2660:3: ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )
        // InternalResoluteParser.g:2660:4: ( () ( ( ( And ) ) | ( ( Andthen ) ) ) )
        {
        // InternalResoluteParser.g:2660:4: ( () ( ( ( And ) ) | ( ( Andthen ) ) ) )
        // InternalResoluteParser.g:2660:5: () ( ( ( And ) ) | ( ( Andthen ) ) )
        {
        // InternalResoluteParser.g:2660:5: ()
        // InternalResoluteParser.g:2661:1: 
        {
        }

        // InternalResoluteParser.g:2661:2: ( ( ( And ) ) | ( ( Andthen ) ) )
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
                // InternalResoluteParser.g:2661:3: ( ( And ) )
                {
                // InternalResoluteParser.g:2661:3: ( ( And ) )
                // InternalResoluteParser.g:2662:1: ( And )
                {
                // InternalResoluteParser.g:2662:1: ( And )
                // InternalResoluteParser.g:2664:1: And
                {
                match(input,And,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalResoluteParser.g:2669:6: ( ( Andthen ) )
                {
                // InternalResoluteParser.g:2669:6: ( ( Andthen ) )
                // InternalResoluteParser.g:2670:1: ( Andthen )
                {
                // InternalResoluteParser.g:2670:1: ( Andthen )
                // InternalResoluteParser.g:2672:1: Andthen
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
        // InternalResoluteParser.g:2763:3: ( ( () Instanceof ) )
        // InternalResoluteParser.g:2763:4: ( () Instanceof )
        {
        // InternalResoluteParser.g:2763:4: ( () Instanceof )
        // InternalResoluteParser.g:2763:5: () Instanceof
        {
        // InternalResoluteParser.g:2763:5: ()
        // InternalResoluteParser.g:2764:1: 
        {
        }

        match(input,Instanceof,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalResoluteParser

    // $ANTLR start synpred6_InternalResoluteParser
    public final void synpred6_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:2888:3: ( ( () ( ( ruleRelationalOp ) ) ) )
        // InternalResoluteParser.g:2888:4: ( () ( ( ruleRelationalOp ) ) )
        {
        // InternalResoluteParser.g:2888:4: ( () ( ( ruleRelationalOp ) ) )
        // InternalResoluteParser.g:2888:5: () ( ( ruleRelationalOp ) )
        {
        // InternalResoluteParser.g:2888:5: ()
        // InternalResoluteParser.g:2889:1: 
        {
        }

        // InternalResoluteParser.g:2889:2: ( ( ruleRelationalOp ) )
        // InternalResoluteParser.g:2890:1: ( ruleRelationalOp )
        {
        // InternalResoluteParser.g:2890:1: ( ruleRelationalOp )
        // InternalResoluteParser.g:2891:1: ruleRelationalOp
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
        // InternalResoluteParser.g:2965:3: ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )
        // InternalResoluteParser.g:2965:4: ( () ( ( ( PlusSign | HyphenMinus ) ) ) )
        {
        // InternalResoluteParser.g:2965:4: ( () ( ( ( PlusSign | HyphenMinus ) ) ) )
        // InternalResoluteParser.g:2965:5: () ( ( ( PlusSign | HyphenMinus ) ) )
        {
        // InternalResoluteParser.g:2965:5: ()
        // InternalResoluteParser.g:2966:1: 
        {
        }

        // InternalResoluteParser.g:2966:2: ( ( ( PlusSign | HyphenMinus ) ) )
        // InternalResoluteParser.g:2967:1: ( ( PlusSign | HyphenMinus ) )
        {
        // InternalResoluteParser.g:2967:1: ( ( PlusSign | HyphenMinus ) )
        // InternalResoluteParser.g:2968:1: ( PlusSign | HyphenMinus )
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
        // InternalResoluteParser.g:3066:3: ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )
        // InternalResoluteParser.g:3066:4: ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) )
        {
        // InternalResoluteParser.g:3066:4: ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) )
        // InternalResoluteParser.g:3066:5: () ( ( ( Asterisk | Solidus | PercentSign ) ) )
        {
        // InternalResoluteParser.g:3066:5: ()
        // InternalResoluteParser.g:3067:1: 
        {
        }

        // InternalResoluteParser.g:3067:2: ( ( ( Asterisk | Solidus | PercentSign ) ) )
        // InternalResoluteParser.g:3068:1: ( ( Asterisk | Solidus | PercentSign ) )
        {
        // InternalResoluteParser.g:3068:1: ( ( Asterisk | Solidus | PercentSign ) )
        // InternalResoluteParser.g:3069:1: ( Asterisk | Solidus | PercentSign )
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
        // InternalResoluteParser.g:3184:3: ( ( () ( ( CircumflexAccent ) ) ) )
        // InternalResoluteParser.g:3184:4: ( () ( ( CircumflexAccent ) ) )
        {
        // InternalResoluteParser.g:3184:4: ( () ( ( CircumflexAccent ) ) )
        // InternalResoluteParser.g:3184:5: () ( ( CircumflexAccent ) )
        {
        // InternalResoluteParser.g:3184:5: ()
        // InternalResoluteParser.g:3185:1: 
        {
        }

        // InternalResoluteParser.g:3185:2: ( ( CircumflexAccent ) )
        // InternalResoluteParser.g:3186:1: ( CircumflexAccent )
        {
        // InternalResoluteParser.g:3186:1: ( CircumflexAccent )
        // InternalResoluteParser.g:3188:1: CircumflexAccent
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
        // InternalResoluteParser.g:3801:7: ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )
        // InternalResoluteParser.g:3801:8: ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis )
        {
        // InternalResoluteParser.g:3801:8: ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis )
        // InternalResoluteParser.g:3801:9: () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis
        {
        // InternalResoluteParser.g:3801:9: ()
        // InternalResoluteParser.g:3802:1: 
        {
        }

        // InternalResoluteParser.g:3802:2: ( ( RULE_ID ) )
        // InternalResoluteParser.g:3803:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:3803:1: ( RULE_ID )
        // InternalResoluteParser.g:3804:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_13); if (state.failed) return ;

        }


        }

        match(input,FullStop,FollowSets000.FOLLOW_14); if (state.failed) return ;
        // InternalResoluteParser.g:3809:1: ( ( RULE_ID ) )
        // InternalResoluteParser.g:3810:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:3810:1: ( RULE_ID )
        // InternalResoluteParser.g:3811:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_18); if (state.failed) return ;

        }


        }

        match(input,LeftParenthesis,FollowSets000.FOLLOW_44); if (state.failed) return ;
        // InternalResoluteParser.g:3816:1: ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )?
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( ((LA86_0>=Revised_without_review && LA86_0<=Is_virtual_processor)||(LA86_0>=Flow_specifications && LA86_0<=Is_abstract_feature)||LA86_0==Revised_with_review||LA86_0==Enumerated_values||(LA86_0>=End_to_end_flows && LA86_0<=Is_bidirectional)||(LA86_0>=Is_thread_group && LA86_0<=Contain_error)||(LA86_0>=Flow_elements && LA86_0<=Is_subprogram)||(LA86_0>=Receive_error && LA86_0<=Is_processor)||LA86_0==Connections||(LA86_0>=Destination && LA86_0<=Lower_bound)||(LA86_0>=Undeveloped && LA86_0<=Upper_bound)||(LA86_0>=Has_member && LA86_0<=Identifier)||(LA86_0>=Is_of_type && LA86_0<=Is_process)||(LA86_0>=Direction && LA86_0<=Is_thread)||LA86_0==Analysis||(LA86_0>=Evidence && LA86_0<=Instance)||(LA86_0>=Property && LA86_0<=Solution)||LA86_0==As_list||(LA86_0>=Is_data && LA86_0<=Is_port)||LA86_0==Warning||(LA86_0>=Append && LA86_0<=As_set)||(LA86_0>=Exists && LA86_0<=Member)||(LA86_0>=Parent && LA86_0<=Source)||LA86_0==Debug||(LA86_0>=Error && LA86_0<=False)||LA86_0==Union||LA86_0==Fail||(LA86_0>=Head && LA86_0<=Name)||(LA86_0>=Size && LA86_0<=Tail)||(LA86_0>=This && LA86_0<=Type)||(LA86_0>=Let && LA86_0<=Sum)||LA86_0==If||LA86_0==LeftParenthesis||LA86_0==HyphenMinus||LA86_0==LeftSquareBracket||LA86_0==LeftCurlyBracket||LA86_0==RULE_REAL_LIT||LA86_0==RULE_INTEGER_LIT||(LA86_0>=RULE_STRING && LA86_0<=RULE_ID)) ) {
            alt86=1;
        }
        switch (alt86) {
            case 1 :
                // InternalResoluteParser.g:3816:2: ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )*
                {
                // InternalResoluteParser.g:3816:2: ( ( ruleExpr ) )
                // InternalResoluteParser.g:3817:1: ( ruleExpr )
                {
                // InternalResoluteParser.g:3817:1: ( ruleExpr )
                // InternalResoluteParser.g:3818:1: ruleExpr
                {
                pushFollow(FollowSets000.FOLLOW_20);
                ruleExpr();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalResoluteParser.g:3820:2: ( Comma ( ( ruleExpr ) ) )*
                loop85:
                do {
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==Comma) ) {
                        alt85=1;
                    }


                    switch (alt85) {
                	case 1 :
                	    // InternalResoluteParser.g:3821:1: Comma ( ( ruleExpr ) )
                	    {
                	    match(input,Comma,FollowSets000.FOLLOW_16); if (state.failed) return ;
                	    // InternalResoluteParser.g:3822:1: ( ( ruleExpr ) )
                	    // InternalResoluteParser.g:3823:1: ( ruleExpr )
                	    {
                	    // InternalResoluteParser.g:3823:1: ( ruleExpr )
                	    // InternalResoluteParser.g:3824:1: ruleExpr
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
    static final String dfa_3s = "\1\11\1\100\13\uffff\2\11\5\uffff\1\u00d3\6\uffff\1\100\1\uffff";
    static final String dfa_4s = "\2\u00d3\13\uffff\2\u00d3\5\uffff\1\u00d3\6\uffff\1\u00d3\1\uffff";
    static final String dfa_5s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\14\1\16\2\uffff\1\23\1\24\1\25\1\26\1\27\1\uffff\1\1\1\15\1\17\1\21\1\20\1\22\1\uffff\1\13";
    static final String dfa_6s = "\33\uffff\1\0\1\uffff}>";
    static final String[] dfa_7s = {
            "\1\4\2\13\2\uffff\2\13\2\uffff\1\4\1\uffff\1\13\2\uffff\3\13\3\uffff\7\13\1\uffff\1\13\1\4\3\13\1\uffff\5\13\1\uffff\1\13\1\uffff\5\13\2\uffff\1\21\1\13\7\uffff\3\13\1\uffff\2\13\3\uffff\10\13\5\uffff\1\13\1\uffff\1\22\3\13\1\uffff\1\13\1\23\3\uffff\1\13\4\uffff\2\13\3\uffff\1\14\1\uffff\2\13\3\uffff\1\12\1\4\1\12\3\13\2\uffff\1\13\1\4\1\13\6\uffff\1\13\1\uffff\1\14\1\7\4\uffff\1\13\4\uffff\1\3\1\uffff\1\13\1\14\1\13\2\uffff\2\13\1\uffff\1\2\1\7\1\13\6\uffff\1\17\1\uffff\1\13\7\uffff\1\11\5\uffff\1\20\14\uffff\1\15\2\uffff\1\16\6\uffff\1\6\1\uffff\1\5\1\uffff\1\10\1\1",
            "\1\25\5\uffff\1\25\30\uffff\1\25\2\uffff\2\25\12\uffff\2\25\15\uffff\1\25\7\uffff\1\25\3\uffff\1\25\2\uffff\1\25\6\uffff\1\25\1\uffff\1\25\1\uffff\1\25\5\uffff\1\25\4\uffff\1\25\1\uffff\1\25\7\uffff\5\25\3\uffff\1\25\1\uffff\1\25\1\26\5\25\1\24\1\25\1\uffff\4\25\1\uffff\2\25\2\uffff\1\25\11\uffff\1\25",
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
            "\3\27\2\uffff\2\27\2\uffff\1\27\1\uffff\1\27\2\uffff\3\27\3\uffff\7\27\1\uffff\5\27\1\uffff\5\27\1\uffff\1\27\1\uffff\5\27\2\uffff\2\27\7\uffff\3\27\1\uffff\2\27\3\uffff\10\27\5\uffff\1\27\1\uffff\4\27\1\uffff\2\27\3\uffff\1\27\4\uffff\2\27\3\uffff\1\27\1\uffff\2\27\3\uffff\6\27\2\uffff\3\27\6\uffff\1\27\1\uffff\2\27\4\uffff\1\27\4\uffff\1\27\1\uffff\3\27\2\uffff\2\27\1\uffff\3\27\6\uffff\3\27\7\uffff\1\27\5\uffff\1\27\4\uffff\1\27\7\uffff\1\27\1\30\1\uffff\1\27\6\uffff\1\27\1\uffff\1\27\1\uffff\2\27",
            "\3\31\2\uffff\2\31\2\uffff\1\31\1\uffff\1\31\2\uffff\3\31\3\uffff\7\31\1\uffff\5\31\1\uffff\5\31\1\uffff\1\31\1\uffff\5\31\2\uffff\2\31\7\uffff\3\31\1\uffff\2\31\3\uffff\10\31\5\uffff\1\31\1\uffff\4\31\1\uffff\2\31\3\uffff\1\31\4\uffff\2\31\3\uffff\1\31\1\uffff\2\31\3\uffff\6\31\2\uffff\3\31\6\uffff\1\31\1\uffff\2\31\4\uffff\1\31\4\uffff\1\31\1\uffff\3\31\2\uffff\2\31\1\uffff\3\31\6\uffff\3\31\7\uffff\1\31\5\uffff\1\31\4\uffff\1\31\7\uffff\1\31\2\uffff\1\31\1\uffff\1\32\4\uffff\1\31\1\uffff\1\31\1\uffff\2\31",
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
            "\1\25\5\uffff\1\25\30\uffff\1\25\2\uffff\2\25\12\uffff\2\25\15\uffff\1\25\7\uffff\1\25\3\uffff\1\25\2\uffff\1\25\6\uffff\1\25\1\uffff\1\25\1\uffff\1\25\5\uffff\1\25\4\uffff\1\25\1\uffff\1\25\10\uffff\4\25\3\uffff\1\25\1\uffff\1\25\1\34\5\25\1\uffff\1\25\1\uffff\4\25\1\uffff\2\25\2\uffff\1\25\11\uffff\1\25",
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
            return "3393:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_result_13_0= ruleResult ) ) ) | ( () ( (lv_val_15_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_17_0= ruleRealTerm ) ) ) | ( () ( (lv_val_19_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_21_0= ruleStringTerm ) ) ) | ( () otherlv_23= If ( (lv_cond_24_0= ruleExpr ) ) otherlv_25= Then ( (lv_then_26_0= ruleExpr ) ) otherlv_27= Else ( (lv_else_28_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_30_1= Forall | lv_quant_30_2= Exists ) ) ) (otherlv_31= LeftParenthesis ( (lv_args_32_0= ruleArg ) ) otherlv_33= RightParenthesis )+ otherlv_34= FullStop ( (lv_expr_35_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_37_0= RULE_ID ) ) otherlv_38= FullStop ( (lv_fnName_39_0= RULE_ID ) ) otherlv_40= LeftParenthesis ( ( (lv_args_41_0= ruleExpr ) ) (otherlv_42= Comma ( (lv_args_43_0= ruleExpr ) ) )* )? otherlv_44= RightParenthesis ) ) | ( () ( (lv_fn_46_0= ruleBuiltInFn ) ) otherlv_47= LeftParenthesis ( ( (lv_args_48_0= ruleExpr ) ) (otherlv_49= Comma ( (lv_args_50_0= ruleExpr ) ) )* )? otherlv_51= RightParenthesis ) | ( () ( (otherlv_53= RULE_ID ) ) otherlv_54= LeftParenthesis ( ( (lv_args_55_0= ruleExpr ) ) (otherlv_56= Comma ( (lv_args_57_0= ruleExpr ) ) )* )? otherlv_58= RightParenthesis ) | ( () ( (lv_lintStmt_60_0= ruleLintStatement ) ) ) | (otherlv_61= LeftSquareBracket this_Expr_62= ruleExpr ( ( () otherlv_64= For (otherlv_65= LeftParenthesis ( (lv_args_66_0= ruleArg ) ) otherlv_67= RightParenthesis )+ (otherlv_68= VerticalLine ( (lv_filter_69_0= ruleExpr ) ) )? ) | ( () (otherlv_71= Comma ( (lv_exprs_72_0= ruleExpr ) ) )* ) ) otherlv_73= RightSquareBracket ) | (otherlv_74= LeftCurlyBracket this_Expr_75= ruleExpr ( ( () otherlv_77= For (otherlv_78= LeftParenthesis ( (lv_args_79_0= ruleArg ) ) otherlv_80= RightParenthesis )+ (otherlv_81= VerticalLine ( (lv_filter_82_0= ruleExpr ) ) )? ) | ( () (otherlv_84= Comma ( (lv_exprs_85_0= ruleExpr ) ) )* ) ) otherlv_86= RightCurlyBracket ) | ( () otherlv_88= LeftSquareBracket otherlv_89= RightSquareBracket ) | ( () otherlv_91= LeftCurlyBracket otherlv_92= RightCurlyBracket ) | ( () otherlv_94= Let ( (lv_binding_95_0= ruleLetBinding ) ) otherlv_96= Semicolon ( (lv_expr_97_0= ruleExpr ) ) ) | (otherlv_98= LeftParenthesis this_Expr_99= ruleExpr otherlv_100= RightParenthesis ) | ( () otherlv_102= Undeveloped ) | ( () otherlv_104= Evidence ) | ( () otherlv_106= Solution ( (lv_name_107_0= RULE_ID ) ) otherlv_108= Colon ( (lv_val_109_0= ruleStringTerm ) ) ) )";
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

                        else if ( (LA51_27==EOF||LA51_27==Conclusion||LA51_27==Instanceof||LA51_27==Notation||(LA51_27>=Strategy && LA51_27<=Andthen)||(LA51_27>=Ruleset && LA51_27<=Warning)||LA51_27==Orelse||LA51_27==Check||LA51_27==Error||LA51_27==Prove||LA51_27==Else||LA51_27==Goal||LA51_27==Info||LA51_27==Then||LA51_27==And||LA51_27==For||(LA51_27>=LessThanSignEqualsSign && LA51_27<=GreaterThanSignEqualsSign)||LA51_27==Or||LA51_27==PercentSign||(LA51_27>=RightParenthesis && LA51_27<=HyphenMinus)||LA51_27==Solidus||(LA51_27>=Semicolon && LA51_27<=GreaterThanSign)||(LA51_27>=RightSquareBracket && LA51_27<=CircumflexAccent)||LA51_27==RightCurlyBracket||LA51_27==RULE_ID) ) {s = 21;}

                         
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
    static final String dfa_10s = "\1\77\5\uffff\2\144\1\uffff\1\144\2\uffff\1\144\1\uffff\1\144\1\uffff\1\u00d3\1\uffff\1\144";
    static final String dfa_11s = "\1\u00d3\5\uffff\2\u00d3\1\uffff\1\u00c0\2\uffff\1\u00c0\1\uffff\1\u00c0\1\uffff\1\u00d3\1\uffff\1\u00c0";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\6\1\uffff\1\11\1\12\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_13s = "\23\uffff}>";
    static final String[] dfa_14s = {
            "\1\3\26\uffff\1\2\20\uffff\1\4\42\uffff\1\13\24\uffff\1\13\27\uffff\1\12\2\uffff\1\10\1\uffff\1\10\7\uffff\1\1\11\uffff\1\6\1\uffff\1\7\1\uffff\1\5\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\15\106\uffff\1\10\6\uffff\1\15\5\uffff\1\15\2\uffff\1\15\4\uffff\1\15\22\uffff\1\14",
            "\1\17\106\uffff\1\10\6\uffff\1\17\5\uffff\1\17\2\uffff\1\17\4\uffff\1\17\22\uffff\1\16",
            "",
            "\1\21\106\uffff\1\10\1\20\5\uffff\1\21\5\uffff\1\21\2\uffff\1\21\4\uffff\1\21",
            "",
            "",
            "\1\15\106\uffff\1\10\6\uffff\1\15\5\uffff\1\15\2\uffff\1\15\4\uffff\1\15",
            "",
            "\1\17\106\uffff\1\10\6\uffff\1\17\5\uffff\1\17\2\uffff\1\17\4\uffff\1\17",
            "",
            "\1\22",
            "",
            "\1\21\106\uffff\1\10\6\uffff\1\21\5\uffff\1\21\2\uffff\1\21\4\uffff\1\21"
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
            return "6107:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0000400480000001L,0x0000000000200000L,0x0000000000080000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0008002000200000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x500500101C6B31F0L,0x1029220101900E06L,0x000000480607601EL,0x0000000000080090L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0CFAFBEFE394CE00L,0xCFC68C237A0FF1B8L,0x10820381D9D08681L,0x00000000000D4090L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0900000000000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000200000000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x00000000000C0000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L,0x00000000000C0000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x2DFAFFEFE394CE00L,0xCFD68D277A2FF1B8L,0x10820381D9D086C1L,0x00000000000D4090L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0040000000000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x2000000000000000L,0x0010000000000000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L,0x0000000400000000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x500500101C6B31F0L,0x1029220101900E06L,0x000000480607601EL});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0001600000000000L,0x000000000000000EL});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x1400000000000000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x4240000000000000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x2000000000000000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0CFAFBEFE394CE00L,0xCFC68C237A0FF1B8L,0x10820781D9D08681L,0x00000000000D4090L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2080000000000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0CFAFBEFE394CE00L,0xCFC68C237A0FF1B8L,0x11820381D9D08681L,0x00000000000D4090L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800001000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L,0x0000000000000120L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800001000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L,0x0000000000000300L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0800000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000001020L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L,0x0000000000800200L,0x0000000000000200L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L,0x0000000000800200L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000800200000000L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x8000000000000000L,0x0000008004400000L,0x1480000080000400L,0x00000000000D4010L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L,0x0804000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0804000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0004000000000000L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080020L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x8000000000000000L,0x0000008004400000L,0x1580000080000400L,0x00000000000D4010L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x2000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1400000000000000L,0x0000000000094000L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080000000000L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0020000000000000L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
    }


}