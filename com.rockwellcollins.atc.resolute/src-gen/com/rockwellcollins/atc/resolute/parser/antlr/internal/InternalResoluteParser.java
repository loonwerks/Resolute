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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Provides_subprogram_group_access", "Requires_subprogram_group_access", "Provides_subprogram_access", "Requires_subprogram_access", "Subprogram_group_access", "Error_state_reachable", "Is_virtual_processor", "Provides_data_access", "Requires_data_access", "Flow_specifications", "Is_abstract_feature", "Provides_bus_access", "Requires_bus_access", "Flow_specification", "Enumerated_values", "Subprogram_access", "Virtual_processor", "End_to_end_flows", "Flow_destination", "Is_bidirectional", "Subprogram_group", "End_to_end_flow", "Event_data_port", "Is_thread_group", "Propagate_error", "Property_member", "Has_prototypes", "Is_data_access", "Is_virtual_bus", "Contain_error", "Feature_group", "Flow_elements", "Is_bus_access", "Is_event_port", "Is_subprogram", "Receive_error", "Subcomponents", "Has_property", "Is_data_port", "Is_processor", "Thread_group", "Connections", "Data_access", "Destination", "Flow_source", "Is_bound_to", "Is_in_array", "Lower_bound", "Upper_bound", "Virtual_bus", "Assumption", "Bus_access", "Classifier", "Connection", "Event_port", "Has_member", "Has_parent", "Instanceof", "Is_of_type", "Is_process", "Subprogram", "Component", "Data_port", "Direction", "Has_modes", "Instances", "Intersect", "Is_device", "Is_memory", "Is_system", "Is_thread", "Processor", "Reference", "Abstract", "Analysis", "Constant", "Features", "Has_type", "Instance", "Property", "Strategy", "Andthen", "Applies", "As_list", "Binding", "Compute", "Context", "Feature", "Is_data", "Is_port", "Process", "Ruleset", "Warning", "Access", "Append", "As_set", "Device", "Exists", "Forall", "Is_bus", "Length", "Member", "Memory", "Orelse", "Parent", "Source", "String", "KW_System", "Thread", "Check", "Debug", "Delta", "Error", "False", "Modes", "Prove", "Range", "Union", "Aadl", "Bool", "Data", "Else", "Fail", "Head", "Info", "Name", "Port", "Real", "Size", "Tail", "Then", "This", "True", "Type", "PlusSignEqualsSignGreaterThanSign", "And", "Bus", "For", "Int", "Let", "Not", "Sum", "AsteriskAsterisk", "FullStopFullStop", "ColonColon", "LessThanSignEqualsSign", "LessThanSignGreaterThanSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "If", "In", "Or", "To", "PercentSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int Requires_subprogram_group_access=5;
    public static final int Or=155;
    public static final int EqualsSignGreaterThanSign=151;
    public static final int Memory=106;
    public static final int Size=132;
    public static final int String=110;
    public static final int Feature=91;
    public static final int LessThanSign=168;
    public static final int Has_member=59;
    public static final int Data_port=66;
    public static final int PlusSignEqualsSignGreaterThanSign=138;
    public static final int Then=134;
    public static final int GreaterThanSign=170;
    public static final int Head=127;
    public static final int RULE_ID=186;
    public static final int Sum=145;
    public static final int GreaterThanSignEqualsSign=152;
    public static final int Flow_elements=35;
    public static final int ColonColon=148;
    public static final int Is_data=92;
    public static final int Has_property=41;
    public static final int Analysis=78;
    public static final int Ruleset=95;
    public static final int Processor=75;
    public static final int Instance=82;
    public static final int RULE_REAL_LIT=181;
    public static final int Property_member=29;
    public static final int Classifier=56;
    public static final int Union=121;
    public static final int Tail=133;
    public static final int Event_port=58;
    public static final int Solidus=165;
    public static final int RightCurlyBracket=176;
    public static final int Context=90;
    public static final int Bus=140;
    public static final int FullStop=164;
    public static final int Is_thread=74;
    public static final int Has_modes=68;
    public static final int Connection=57;
    public static final int Provides_bus_access=15;
    public static final int Semicolon=167;
    public static final int RULE_EXPONENT=179;
    public static final int Append=98;
    public static final int As_list=87;
    public static final int Length=104;
    public static final int Delta=115;
    public static final int Is_virtual_processor=10;
    public static final int Flow_specifications=13;
    public static final int End_to_end_flows=21;
    public static final int Receive_error=39;
    public static final int Port=130;
    public static final int Subprogram_group=24;
    public static final int Process=94;
    public static final int Requires_subprogram_access=7;
    public static final int Name=129;
    public static final int RULE_INT_EXPONENT=180;
    public static final int Enumerated_values=18;
    public static final int FullStopFullStop=147;
    public static final int This=135;
    public static final int To=156;
    public static final int Binding=88;
    public static final int Flow_destination=22;
    public static final int Subprogram_group_access=8;
    public static final int For=141;
    public static final int RightParenthesis=159;
    public static final int Is_event_port=37;
    public static final int Not=144;
    public static final int AsteriskAsterisk=146;
    public static final int Subcomponents=40;
    public static final int Is_data_port=42;
    public static final int Subprogram=64;
    public static final int Parent=108;
    public static final int RULE_SL_COMMENT=177;
    public static final int Provides_subprogram_group_access=4;
    public static final int Bus_access=55;
    public static final int Has_parent=60;
    public static final int Aadl=122;
    public static final int Features=80;
    public static final int Colon=166;
    public static final int Component=65;
    public static final int EOF=-1;
    public static final int Asterisk=160;
    public static final int LeftCurlyBracket=174;
    public static final int Info=128;
    public static final int End_to_end_flow=25;
    public static final int Feature_group=34;
    public static final int CircumflexAccent=173;
    public static final int Flow_source=48;
    public static final int Is_thread_group=27;
    public static final int Is_system=73;
    public static final int Exists=101;
    public static final int Virtual_processor=20;
    public static final int Orelse=107;
    public static final int Connections=45;
    public static final int LessThanSignGreaterThanSign=150;
    public static final int Is_port=93;
    public static final int Data_access=46;
    public static final int KW_System=111;
    public static final int Access=97;
    public static final int Check=113;
    public static final int Provides_data_access=11;
    public static final int False=117;
    public static final int Thread_group=44;
    public static final int LeftParenthesis=158;
    public static final int Bool=123;
    public static final int Is_bus=103;
    public static final int Requires_bus_access=16;
    public static final int Fail=126;
    public static final int Is_virtual_bus=32;
    public static final int RULE_DIGIT=178;
    public static final int Has_prototypes=30;
    public static final int Is_bus_access=36;
    public static final int VerticalLine=175;
    public static final int Is_bidirectional=23;
    public static final int PlusSign=161;
    public static final int Is_data_access=31;
    public static final int LeftSquareBracket=171;
    public static final int If=153;
    public static final int Lower_bound=51;
    public static final int Is_of_type=62;
    public static final int Provides_subprogram_access=6;
    public static final int Warning=96;
    public static final int In=154;
    public static final int Contain_error=33;
    public static final int Is_memory=72;
    public static final int Direction=67;
    public static final int Assumption=54;
    public static final int Comma=162;
    public static final int HyphenMinus=163;
    public static final int Requires_data_access=12;
    public static final int Is_subprogram=38;
    public static final int LessThanSignEqualsSign=149;
    public static final int Property=83;
    public static final int Prove=119;
    public static final int Modes=118;
    public static final int Reference=76;
    public static final int Abstract=77;
    public static final int Is_device=71;
    public static final int Thread=112;
    public static final int Instances=69;
    public static final int Type=137;
    public static final int Else=125;
    public static final int RULE_EXTENDED_DIGIT=184;
    public static final int Virtual_bus=53;
    public static final int True=136;
    public static final int Error_state_reachable=9;
    public static final int PercentSign=157;
    public static final int Intersect=70;
    public static final int Upper_bound=52;
    public static final int Real=131;
    public static final int As_set=99;
    public static final int Applies=86;
    public static final int Forall=102;
    public static final int Member=105;
    public static final int RULE_BASED_INTEGER=182;
    public static final int RightSquareBracket=172;
    public static final int Is_in_array=50;
    public static final int Device=100;
    public static final int Range=120;
    public static final int Is_process=63;
    public static final int Is_bound_to=49;
    public static final int Andthen=85;
    public static final int And=139;
    public static final int Is_processor=43;
    public static final int RULE_INTEGER_LIT=183;
    public static final int Destination=47;
    public static final int Constant=79;
    public static final int RULE_STRING=185;
    public static final int Source=109;
    public static final int Int=142;
    public static final int Flow_specification=17;
    public static final int EqualsSign=169;
    public static final int Instanceof=61;
    public static final int Subprogram_access=19;
    public static final int Debug=114;
    public static final int Has_type=81;
    public static final int Is_abstract_feature=14;
    public static final int RULE_WS=187;
    public static final int Error=116;
    public static final int Data=124;
    public static final int Propagate_error=28;
    public static final int Event_data_port=26;
    public static final int Compute=89;
    public static final int Strategy=84;
    public static final int Let=143;

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

                if ( (LA1_0==Ruleset||LA1_0==RULE_ID) ) {
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
    // InternalResoluteParser.g:153:1: ruleDefinition returns [EObject current=null] : (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantDefinition_0 = null;

        EObject this_FunctionDefinition_1 = null;

        EObject this_Ruleset_2 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:156:28: ( (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset ) )
            // InternalResoluteParser.g:157:1: (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset )
            {
            // InternalResoluteParser.g:157:1: (this_ConstantDefinition_0= ruleConstantDefinition | this_FunctionDefinition_1= ruleFunctionDefinition | this_Ruleset_2= ruleRuleset )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
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
            else if ( (LA2_0==Ruleset) ) {
                alt2=3;
            }
            else {
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
    // InternalResoluteParser.g:194:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalResoluteParser.g:195:2: (iv_ruleType= ruleType EOF )
            // InternalResoluteParser.g:196:2: iv_ruleType= ruleType EOF
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
    // InternalResoluteParser.g:203:1: ruleType returns [EObject current=null] : ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) ) ;
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
            // InternalResoluteParser.g:206:28: ( ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) ) )
            // InternalResoluteParser.g:207:1: ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) )
            {
            // InternalResoluteParser.g:207:1: ( ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket ) | ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket ) | (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? ) | ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) ) )
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
                    // InternalResoluteParser.g:207:2: ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:207:2: ( () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket )
                    // InternalResoluteParser.g:207:3: () otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleType ) ) otherlv_3= RightSquareBracket
                    {
                    // InternalResoluteParser.g:207:3: ()
                    // InternalResoluteParser.g:208:5: 
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
                    // InternalResoluteParser.g:218:1: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:219:1: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:219:1: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:220:3: lv_type_2_0= ruleType
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
                    // InternalResoluteParser.g:242:6: ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:242:6: ( () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket )
                    // InternalResoluteParser.g:242:7: () otherlv_5= LeftCurlyBracket ( (lv_type_6_0= ruleType ) ) otherlv_7= RightCurlyBracket
                    {
                    // InternalResoluteParser.g:242:7: ()
                    // InternalResoluteParser.g:243:5: 
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
                    // InternalResoluteParser.g:253:1: ( (lv_type_6_0= ruleType ) )
                    // InternalResoluteParser.g:254:1: (lv_type_6_0= ruleType )
                    {
                    // InternalResoluteParser.g:254:1: (lv_type_6_0= ruleType )
                    // InternalResoluteParser.g:255:3: lv_type_6_0= ruleType
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
                    // InternalResoluteParser.g:277:6: (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? )
                    {
                    // InternalResoluteParser.g:277:6: (this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )? )
                    // InternalResoluteParser.g:278:5: this_BaseType_8= ruleBaseType (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )?
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
                    // InternalResoluteParser.g:286:1: (otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==LessThanSign) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalResoluteParser.g:287:2: otherlv_9= LessThanSign ( (lv_paramType_10_0= ruleType ) ) otherlv_11= GreaterThanSign
                            {
                            otherlv_9=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getTypeAccess().getLessThanSignKeyword_2_1_0());
                                  
                            }
                            // InternalResoluteParser.g:291:1: ( (lv_paramType_10_0= ruleType ) )
                            // InternalResoluteParser.g:292:1: (lv_paramType_10_0= ruleType )
                            {
                            // InternalResoluteParser.g:292:1: (lv_paramType_10_0= ruleType )
                            // InternalResoluteParser.g:293:3: lv_paramType_10_0= ruleType
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
                    // InternalResoluteParser.g:315:6: ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) )
                    {
                    // InternalResoluteParser.g:315:6: ( () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) ) )
                    // InternalResoluteParser.g:315:7: () ( (lv_libName_13_0= RULE_ID ) ) otherlv_14= FullStop ( (lv_fnType_15_0= RULE_ID ) )
                    {
                    // InternalResoluteParser.g:315:7: ()
                    // InternalResoluteParser.g:316:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeAccess().getLibraryFnTypeAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:321:2: ( (lv_libName_13_0= RULE_ID ) )
                    // InternalResoluteParser.g:322:1: (lv_libName_13_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:322:1: (lv_libName_13_0= RULE_ID )
                    // InternalResoluteParser.g:323:3: lv_libName_13_0= RULE_ID
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
                    // InternalResoluteParser.g:344:1: ( (lv_fnType_15_0= RULE_ID ) )
                    // InternalResoluteParser.g:345:1: (lv_fnType_15_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:345:1: (lv_fnType_15_0= RULE_ID )
                    // InternalResoluteParser.g:346:3: lv_fnType_15_0= RULE_ID
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
    // InternalResoluteParser.g:370:1: entryRuleBaseType returns [EObject current=null] : iv_ruleBaseType= ruleBaseType EOF ;
    public final EObject entryRuleBaseType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseType = null;


        try {
            // InternalResoluteParser.g:371:2: (iv_ruleBaseType= ruleBaseType EOF )
            // InternalResoluteParser.g:372:2: iv_ruleBaseType= ruleBaseType EOF
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
    // InternalResoluteParser.g:379:1: ruleBaseType returns [EObject current=null] : ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) ) ) ;
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
            // InternalResoluteParser.g:382:28: ( ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) ) ) )
            // InternalResoluteParser.g:383:1: ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) ) )
            {
            // InternalResoluteParser.g:383:1: ( ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) ) )
            // InternalResoluteParser.g:384:1: ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) )
            {
            // InternalResoluteParser.g:384:1: ( (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow ) )
            // InternalResoluteParser.g:385:1: (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow )
            {
            // InternalResoluteParser.g:385:1: (lv_type_0_1= Int | lv_type_0_2= Real | lv_type_0_3= String | lv_type_0_4= Bool | lv_type_0_5= Range | lv_type_0_6= Aadl | lv_type_0_7= Component | lv_type_0_8= Abstract | lv_type_0_9= Bus | lv_type_0_10= Data | lv_type_0_11= Device | lv_type_0_12= Memory | lv_type_0_13= Processor | lv_type_0_14= Process | lv_type_0_15= Subprogram_group | lv_type_0_16= Subprogram | lv_type_0_17= KW_System | lv_type_0_18= Thread_group | lv_type_0_19= Thread | lv_type_0_20= Virtual_bus | lv_type_0_21= Virtual_processor | lv_type_0_22= Connection | lv_type_0_23= Property | lv_type_0_24= Feature | lv_type_0_25= Port | lv_type_0_26= Data_port | lv_type_0_27= Event_port | lv_type_0_28= Event_data_port | lv_type_0_29= Feature_group | lv_type_0_30= Access | lv_type_0_31= Bus_access | lv_type_0_32= Provides_bus_access | lv_type_0_33= Requires_bus_access | lv_type_0_34= Data_access | lv_type_0_35= Provides_data_access | lv_type_0_36= Requires_data_access | lv_type_0_37= Subprogram_access | lv_type_0_38= Provides_subprogram_access | lv_type_0_39= Requires_subprogram_access | lv_type_0_40= Subprogram_group_access | lv_type_0_41= Provides_subprogram_group_access | lv_type_0_42= Requires_subprogram_group_access | lv_type_0_43= Flow_specification | lv_type_0_44= End_to_end_flow )
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
                    // InternalResoluteParser.g:386:3: lv_type_0_1= Int
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
                    // InternalResoluteParser.g:399:8: lv_type_0_2= Real
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
                    // InternalResoluteParser.g:412:8: lv_type_0_3= String
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
                    // InternalResoluteParser.g:425:8: lv_type_0_4= Bool
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
                    // InternalResoluteParser.g:438:8: lv_type_0_5= Range
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
                    // InternalResoluteParser.g:451:8: lv_type_0_6= Aadl
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
                    // InternalResoluteParser.g:464:8: lv_type_0_7= Component
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
                    // InternalResoluteParser.g:477:8: lv_type_0_8= Abstract
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
                    // InternalResoluteParser.g:490:8: lv_type_0_9= Bus
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
                    // InternalResoluteParser.g:503:8: lv_type_0_10= Data
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
                    // InternalResoluteParser.g:516:8: lv_type_0_11= Device
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
                    // InternalResoluteParser.g:529:8: lv_type_0_12= Memory
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
                    // InternalResoluteParser.g:542:8: lv_type_0_13= Processor
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
                    // InternalResoluteParser.g:555:8: lv_type_0_14= Process
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
                    // InternalResoluteParser.g:568:8: lv_type_0_15= Subprogram_group
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
                    // InternalResoluteParser.g:581:8: lv_type_0_16= Subprogram
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
                    // InternalResoluteParser.g:594:8: lv_type_0_17= KW_System
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
                    // InternalResoluteParser.g:607:8: lv_type_0_18= Thread_group
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
                    // InternalResoluteParser.g:620:8: lv_type_0_19= Thread
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
                    // InternalResoluteParser.g:633:8: lv_type_0_20= Virtual_bus
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
                    // InternalResoluteParser.g:646:8: lv_type_0_21= Virtual_processor
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
                    // InternalResoluteParser.g:659:8: lv_type_0_22= Connection
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
                    // InternalResoluteParser.g:672:8: lv_type_0_23= Property
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
                    // InternalResoluteParser.g:685:8: lv_type_0_24= Feature
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
                    // InternalResoluteParser.g:698:8: lv_type_0_25= Port
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
                    // InternalResoluteParser.g:711:8: lv_type_0_26= Data_port
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
                    // InternalResoluteParser.g:724:8: lv_type_0_27= Event_port
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
                    // InternalResoluteParser.g:737:8: lv_type_0_28= Event_data_port
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
                    // InternalResoluteParser.g:750:8: lv_type_0_29= Feature_group
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
                    // InternalResoluteParser.g:763:8: lv_type_0_30= Access
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
                    // InternalResoluteParser.g:776:8: lv_type_0_31= Bus_access
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
                    // InternalResoluteParser.g:789:8: lv_type_0_32= Provides_bus_access
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
                    // InternalResoluteParser.g:802:8: lv_type_0_33= Requires_bus_access
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
                    // InternalResoluteParser.g:815:8: lv_type_0_34= Data_access
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
                    // InternalResoluteParser.g:828:8: lv_type_0_35= Provides_data_access
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
                    // InternalResoluteParser.g:841:8: lv_type_0_36= Requires_data_access
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
                    // InternalResoluteParser.g:854:8: lv_type_0_37= Subprogram_access
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
                    // InternalResoluteParser.g:867:8: lv_type_0_38= Provides_subprogram_access
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
                    // InternalResoluteParser.g:880:8: lv_type_0_39= Requires_subprogram_access
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
                    // InternalResoluteParser.g:893:8: lv_type_0_40= Subprogram_group_access
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
                    // InternalResoluteParser.g:906:8: lv_type_0_41= Provides_subprogram_group_access
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
                    // InternalResoluteParser.g:919:8: lv_type_0_42= Requires_subprogram_group_access
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
                    // InternalResoluteParser.g:932:8: lv_type_0_43= Flow_specification
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
                    // InternalResoluteParser.g:945:8: lv_type_0_44= End_to_end_flow
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
    // InternalResoluteParser.g:969:1: entryRuleArg returns [EObject current=null] : iv_ruleArg= ruleArg EOF ;
    public final EObject entryRuleArg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArg = null;


        try {
            // InternalResoluteParser.g:970:2: (iv_ruleArg= ruleArg EOF )
            // InternalResoluteParser.g:971:2: iv_ruleArg= ruleArg EOF
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
    // InternalResoluteParser.g:978:1: ruleArg returns [EObject current=null] : ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) ) ;
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
            // InternalResoluteParser.g:981:28: ( ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:982:1: ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:982:1: ( ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) ) | ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) ) )
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
                    // InternalResoluteParser.g:982:2: ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
                    {
                    // InternalResoluteParser.g:982:2: ( ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) ) )
                    // InternalResoluteParser.g:982:3: ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )=> ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
                    {
                    // InternalResoluteParser.g:993:6: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) )
                    // InternalResoluteParser.g:993:7: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) )
                    {
                    // InternalResoluteParser.g:993:7: ( (lv_name_0_0= RULE_ID ) )
                    // InternalResoluteParser.g:994:1: (lv_name_0_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:994:1: (lv_name_0_0= RULE_ID )
                    // InternalResoluteParser.g:995:3: lv_name_0_0= RULE_ID
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
                    // InternalResoluteParser.g:1016:1: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:1017:1: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:1017:1: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:1018:3: lv_type_2_0= ruleType
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
                    // InternalResoluteParser.g:1035:6: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1035:6: ( () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1035:7: () ( (lv_name_4_0= RULE_ID ) ) otherlv_5= Colon ( (lv_expr_6_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1035:7: ()
                    // InternalResoluteParser.g:1036:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getArgAccess().getQuantArgAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:1041:2: ( (lv_name_4_0= RULE_ID ) )
                    // InternalResoluteParser.g:1042:1: (lv_name_4_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:1042:1: (lv_name_4_0= RULE_ID )
                    // InternalResoluteParser.g:1043:3: lv_name_4_0= RULE_ID
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
                    // InternalResoluteParser.g:1064:1: ( (lv_expr_6_0= ruleExpr ) )
                    // InternalResoluteParser.g:1065:1: (lv_expr_6_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1065:1: (lv_expr_6_0= ruleExpr )
                    // InternalResoluteParser.g:1066:3: lv_expr_6_0= ruleExpr
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
    // InternalResoluteParser.g:1090:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // InternalResoluteParser.g:1091:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // InternalResoluteParser.g:1092:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
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
    // InternalResoluteParser.g:1099:1: ruleConstantDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleConstantDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1102:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) )
            // InternalResoluteParser.g:1103:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // InternalResoluteParser.g:1103:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            // InternalResoluteParser.g:1103:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
            {
            // InternalResoluteParser.g:1103:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:1104:1: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:1104:1: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:1105:3: lv_name_0_0= RULE_ID
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
            // InternalResoluteParser.g:1126:1: ( (lv_type_2_0= ruleType ) )
            // InternalResoluteParser.g:1127:1: (lv_type_2_0= ruleType )
            {
            // InternalResoluteParser.g:1127:1: (lv_type_2_0= ruleType )
            // InternalResoluteParser.g:1128:3: lv_type_2_0= ruleType
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
            // InternalResoluteParser.g:1149:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalResoluteParser.g:1150:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalResoluteParser.g:1150:1: (lv_expr_4_0= ruleExpr )
            // InternalResoluteParser.g:1151:3: lv_expr_4_0= ruleExpr
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
    // InternalResoluteParser.g:1175:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalResoluteParser.g:1176:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalResoluteParser.g:1177:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
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
    // InternalResoluteParser.g:1184:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( ( (lv_args_2_0= ruleArg ) ) (otherlv_3= Comma ( (lv_args_4_0= ruleArg ) ) )* )? otherlv_5= RightParenthesis ( (lv_body_6_0= ruleDefinitionBody ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;

        EObject lv_body_6_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1187:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( ( (lv_args_2_0= ruleArg ) ) (otherlv_3= Comma ( (lv_args_4_0= ruleArg ) ) )* )? otherlv_5= RightParenthesis ( (lv_body_6_0= ruleDefinitionBody ) ) ) )
            // InternalResoluteParser.g:1188:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( ( (lv_args_2_0= ruleArg ) ) (otherlv_3= Comma ( (lv_args_4_0= ruleArg ) ) )* )? otherlv_5= RightParenthesis ( (lv_body_6_0= ruleDefinitionBody ) ) )
            {
            // InternalResoluteParser.g:1188:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( ( (lv_args_2_0= ruleArg ) ) (otherlv_3= Comma ( (lv_args_4_0= ruleArg ) ) )* )? otherlv_5= RightParenthesis ( (lv_body_6_0= ruleDefinitionBody ) ) )
            // InternalResoluteParser.g:1188:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftParenthesis ( ( (lv_args_2_0= ruleArg ) ) (otherlv_3= Comma ( (lv_args_4_0= ruleArg ) ) )* )? otherlv_5= RightParenthesis ( (lv_body_6_0= ruleDefinitionBody ) )
            {
            // InternalResoluteParser.g:1188:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:1189:1: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:1189:1: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:1190:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.osate.xtext.aadl2.properties.Properties.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:1211:1: ( ( (lv_args_2_0= ruleArg ) ) (otherlv_3= Comma ( (lv_args_4_0= ruleArg ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalResoluteParser.g:1211:2: ( (lv_args_2_0= ruleArg ) ) (otherlv_3= Comma ( (lv_args_4_0= ruleArg ) ) )*
                    {
                    // InternalResoluteParser.g:1211:2: ( (lv_args_2_0= ruleArg ) )
                    // InternalResoluteParser.g:1212:1: (lv_args_2_0= ruleArg )
                    {
                    // InternalResoluteParser.g:1212:1: (lv_args_2_0= ruleArg )
                    // InternalResoluteParser.g:1213:3: lv_args_2_0= ruleArg
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getArgsArgParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_16);
                    lv_args_2_0=ruleArg();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_2_0, 
                              		"com.rockwellcollins.atc.resolute.Resolute.Arg");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalResoluteParser.g:1229:2: (otherlv_3= Comma ( (lv_args_4_0= ruleArg ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==Comma) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1230:2: otherlv_3= Comma ( (lv_args_4_0= ruleArg ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:1234:1: ( (lv_args_4_0= ruleArg ) )
                    	    // InternalResoluteParser.g:1235:1: (lv_args_4_0= ruleArg )
                    	    {
                    	    // InternalResoluteParser.g:1235:1: (lv_args_4_0= ruleArg )
                    	    // InternalResoluteParser.g:1236:3: lv_args_4_0= ruleArg
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getArgsArgParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_16);
                    	    lv_args_4_0=ruleArg();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_4_0, 
                    	              		"com.rockwellcollins.atc.resolute.Resolute.Arg");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalResoluteParser.g:1257:1: ( (lv_body_6_0= ruleDefinitionBody ) )
            // InternalResoluteParser.g:1258:1: (lv_body_6_0= ruleDefinitionBody )
            {
            // InternalResoluteParser.g:1258:1: (lv_body_6_0= ruleDefinitionBody )
            // InternalResoluteParser.g:1259:3: lv_body_6_0= ruleDefinitionBody
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBodyDefinitionBodyParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_body_6_0=ruleDefinitionBody();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_6_0, 
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
    // InternalResoluteParser.g:1283:1: entryRuleDefinitionBody returns [EObject current=null] : iv_ruleDefinitionBody= ruleDefinitionBody EOF ;
    public final EObject entryRuleDefinitionBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionBody = null;


        try {
            // InternalResoluteParser.g:1284:2: (iv_ruleDefinitionBody= ruleDefinitionBody EOF )
            // InternalResoluteParser.g:1285:2: iv_ruleDefinitionBody= ruleDefinitionBody EOF
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
    // InternalResoluteParser.g:1292:1: ruleDefinitionBody returns [EObject current=null] : ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_context_10_0= ruleClaimContext ) )* ( (lv_assumptions_11_0= ruleClaimAssumption ) )* ( (lv_strategies_12_0= ruleClaimStrategy ) )* ( (lv_expr_13_0= ruleExpr ) ) ) ) ;
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

        EObject lv_context_10_0 = null;

        EObject lv_assumptions_11_0 = null;

        EObject lv_strategies_12_0 = null;

        EObject lv_expr_13_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1295:28: ( ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_context_10_0= ruleClaimContext ) )* ( (lv_assumptions_11_0= ruleClaimAssumption ) )* ( (lv_strategies_12_0= ruleClaimStrategy ) )* ( (lv_expr_13_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:1296:1: ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_context_10_0= ruleClaimContext ) )* ( (lv_assumptions_11_0= ruleClaimAssumption ) )* ( (lv_strategies_12_0= ruleClaimStrategy ) )* ( (lv_expr_13_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:1296:1: ( ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) | ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_context_10_0= ruleClaimContext ) )* ( (lv_assumptions_11_0= ruleClaimAssumption ) )* ( (lv_strategies_12_0= ruleClaimStrategy ) )* ( (lv_expr_13_0= ruleExpr ) ) ) )
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
                    // InternalResoluteParser.g:1296:2: ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1296:2: ( () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1296:3: () otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1296:3: ()
                    // InternalResoluteParser.g:1297:5: 
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
                    // InternalResoluteParser.g:1307:1: ( (lv_type_2_0= ruleType ) )
                    // InternalResoluteParser.g:1308:1: (lv_type_2_0= ruleType )
                    {
                    // InternalResoluteParser.g:1308:1: (lv_type_2_0= ruleType )
                    // InternalResoluteParser.g:1309:3: lv_type_2_0= ruleType
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
                    // InternalResoluteParser.g:1330:1: ( (lv_expr_4_0= ruleExpr ) )
                    // InternalResoluteParser.g:1331:1: (lv_expr_4_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1331:1: (lv_expr_4_0= ruleExpr )
                    // InternalResoluteParser.g:1332:3: lv_expr_4_0= ruleExpr
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
                    // InternalResoluteParser.g:1349:6: ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_context_10_0= ruleClaimContext ) )* ( (lv_assumptions_11_0= ruleClaimAssumption ) )* ( (lv_strategies_12_0= ruleClaimStrategy ) )* ( (lv_expr_13_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:1349:6: ( () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_context_10_0= ruleClaimContext ) )* ( (lv_assumptions_11_0= ruleClaimAssumption ) )* ( (lv_strategies_12_0= ruleClaimStrategy ) )* ( (lv_expr_13_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:1349:7: () otherlv_6= LessThanSignEqualsSign (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk ) ( (lv_context_10_0= ruleClaimContext ) )* ( (lv_assumptions_11_0= ruleClaimAssumption ) )* ( (lv_strategies_12_0= ruleClaimStrategy ) )* ( (lv_expr_13_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:1349:7: ()
                    // InternalResoluteParser.g:1350:5: 
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
                    // InternalResoluteParser.g:1360:1: (otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk )
                    // InternalResoluteParser.g:1361:2: otherlv_7= AsteriskAsterisk ( (lv_claim_8_0= ruleClaimText ) )+ otherlv_9= AsteriskAsterisk
                    {
                    otherlv_7=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDefinitionBodyAccess().getAsteriskAsteriskKeyword_1_2_0());
                          
                    }
                    // InternalResoluteParser.g:1365:1: ( (lv_claim_8_0= ruleClaimText ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1366:1: (lv_claim_8_0= ruleClaimText )
                    	    {
                    	    // InternalResoluteParser.g:1366:1: (lv_claim_8_0= ruleClaimText )
                    	    // InternalResoluteParser.g:1367:3: lv_claim_8_0= ruleClaimText
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
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    otherlv_9=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getDefinitionBodyAccess().getAsteriskAsteriskKeyword_1_2_2());
                          
                    }

                    }

                    // InternalResoluteParser.g:1388:2: ( (lv_context_10_0= ruleClaimContext ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==Context) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1389:1: (lv_context_10_0= ruleClaimContext )
                    	    {
                    	    // InternalResoluteParser.g:1389:1: (lv_context_10_0= ruleClaimContext )
                    	    // InternalResoluteParser.g:1390:3: lv_context_10_0= ruleClaimContext
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getContextClaimContextParserRuleCall_1_3_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_21);
                    	    lv_context_10_0=ruleClaimContext();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"context",
                    	              		lv_context_10_0, 
                    	              		"com.rockwellcollins.atc.resolute.Resolute.ClaimContext");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // InternalResoluteParser.g:1406:3: ( (lv_assumptions_11_0= ruleClaimAssumption ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==Assumption) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1407:1: (lv_assumptions_11_0= ruleClaimAssumption )
                    	    {
                    	    // InternalResoluteParser.g:1407:1: (lv_assumptions_11_0= ruleClaimAssumption )
                    	    // InternalResoluteParser.g:1408:3: lv_assumptions_11_0= ruleClaimAssumption
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getAssumptionsClaimAssumptionParserRuleCall_1_4_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_22);
                    	    lv_assumptions_11_0=ruleClaimAssumption();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"assumptions",
                    	              		lv_assumptions_11_0, 
                    	              		"com.rockwellcollins.atc.resolute.Resolute.ClaimAssumption");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    // InternalResoluteParser.g:1424:3: ( (lv_strategies_12_0= ruleClaimStrategy ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Strategy) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalResoluteParser.g:1425:1: (lv_strategies_12_0= ruleClaimStrategy )
                    	    {
                    	    // InternalResoluteParser.g:1425:1: (lv_strategies_12_0= ruleClaimStrategy )
                    	    // InternalResoluteParser.g:1426:3: lv_strategies_12_0= ruleClaimStrategy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getStrategiesClaimStrategyParserRuleCall_1_5_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_23);
                    	    lv_strategies_12_0=ruleClaimStrategy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"strategies",
                    	              		lv_strategies_12_0, 
                    	              		"com.rockwellcollins.atc.resolute.Resolute.ClaimStrategy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // InternalResoluteParser.g:1442:3: ( (lv_expr_13_0= ruleExpr ) )
                    // InternalResoluteParser.g:1443:1: (lv_expr_13_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:1443:1: (lv_expr_13_0= ruleExpr )
                    // InternalResoluteParser.g:1444:3: lv_expr_13_0= ruleExpr
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefinitionBodyAccess().getExprExprParserRuleCall_1_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_13_0=ruleExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefinitionBodyRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_13_0, 
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


    // $ANTLR start "entryRuleClaimContext"
    // InternalResoluteParser.g:1468:1: entryRuleClaimContext returns [EObject current=null] : iv_ruleClaimContext= ruleClaimContext EOF ;
    public final EObject entryRuleClaimContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimContext = null;


        try {
            // InternalResoluteParser.g:1469:2: (iv_ruleClaimContext= ruleClaimContext EOF )
            // InternalResoluteParser.g:1470:2: iv_ruleClaimContext= ruleClaimContext EOF
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
    // InternalResoluteParser.g:1477:1: ruleClaimContext returns [EObject current=null] : (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) ) ;
    public final EObject ruleClaimContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1480:28: ( (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) ) )
            // InternalResoluteParser.g:1481:1: (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) )
            {
            // InternalResoluteParser.g:1481:1: (otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) )
            // InternalResoluteParser.g:1482:2: otherlv_0= Context ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) )
            {
            otherlv_0=(Token)match(input,Context,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimContextAccess().getContextKeyword_0());
                  
            }
            // InternalResoluteParser.g:1486:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:1487:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:1487:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:1488:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimContextAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:1509:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:1510:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:1510:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:1511:3: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimContextAccess().getValStringTermParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_val_3_0=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimContextRule());
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


    // $ANTLR start "entryRuleClaimAssumption"
    // InternalResoluteParser.g:1535:1: entryRuleClaimAssumption returns [EObject current=null] : iv_ruleClaimAssumption= ruleClaimAssumption EOF ;
    public final EObject entryRuleClaimAssumption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimAssumption = null;


        try {
            // InternalResoluteParser.g:1536:2: (iv_ruleClaimAssumption= ruleClaimAssumption EOF )
            // InternalResoluteParser.g:1537:2: iv_ruleClaimAssumption= ruleClaimAssumption EOF
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
    // InternalResoluteParser.g:1544:1: ruleClaimAssumption returns [EObject current=null] : (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) ) ;
    public final EObject ruleClaimAssumption() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1547:28: ( (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) ) )
            // InternalResoluteParser.g:1548:1: (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) )
            {
            // InternalResoluteParser.g:1548:1: (otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) )
            // InternalResoluteParser.g:1549:2: otherlv_0= Assumption ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) )
            {
            otherlv_0=(Token)match(input,Assumption,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimAssumptionAccess().getAssumptionKeyword_0());
                  
            }
            // InternalResoluteParser.g:1553:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:1554:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:1554:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:1555:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimAssumptionAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:1576:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:1577:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:1577:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:1578:3: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimAssumptionAccess().getValStringTermParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_val_3_0=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClaimAssumptionRule());
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
    // InternalResoluteParser.g:1602:1: entryRuleClaimStrategy returns [EObject current=null] : iv_ruleClaimStrategy= ruleClaimStrategy EOF ;
    public final EObject entryRuleClaimStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimStrategy = null;


        try {
            // InternalResoluteParser.g:1603:2: (iv_ruleClaimStrategy= ruleClaimStrategy EOF )
            // InternalResoluteParser.g:1604:2: iv_ruleClaimStrategy= ruleClaimStrategy EOF
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
    // InternalResoluteParser.g:1611:1: ruleClaimStrategy returns [EObject current=null] : (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) ) ;
    public final EObject ruleClaimStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1614:28: ( (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) ) )
            // InternalResoluteParser.g:1615:1: (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) )
            {
            // InternalResoluteParser.g:1615:1: (otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) ) )
            // InternalResoluteParser.g:1616:2: otherlv_0= Strategy ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_val_3_0= ruleStringTerm ) )
            {
            otherlv_0=(Token)match(input,Strategy,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClaimStrategyAccess().getStrategyKeyword_0());
                  
            }
            // InternalResoluteParser.g:1620:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:1621:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:1621:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:1622:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,Colon,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClaimStrategyAccess().getColonKeyword_2());
                  
            }
            // InternalResoluteParser.g:1643:1: ( (lv_val_3_0= ruleStringTerm ) )
            // InternalResoluteParser.g:1644:1: (lv_val_3_0= ruleStringTerm )
            {
            // InternalResoluteParser.g:1644:1: (lv_val_3_0= ruleStringTerm )
            // InternalResoluteParser.g:1645:3: lv_val_3_0= ruleStringTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClaimStrategyAccess().getValStringTermParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalResoluteParser.g:1669:1: entryRuleClaimText returns [EObject current=null] : iv_ruleClaimText= ruleClaimText EOF ;
    public final EObject entryRuleClaimText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClaimText = null;


        try {
            // InternalResoluteParser.g:1670:2: (iv_ruleClaimText= ruleClaimText EOF )
            // InternalResoluteParser.g:1671:2: iv_ruleClaimText= ruleClaimText EOF
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
    // InternalResoluteParser.g:1678:1: ruleClaimText returns [EObject current=null] : ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) ) ;
    public final EObject ruleClaimText() throws RecognitionException {
        EObject current = null;

        Token lv_str_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1681:28: ( ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) ) )
            // InternalResoluteParser.g:1682:1: ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) )
            {
            // InternalResoluteParser.g:1682:1: ( ( () ( (lv_str_1_0= RULE_STRING ) ) ) | ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_STRING) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalResoluteParser.g:1682:2: ( () ( (lv_str_1_0= RULE_STRING ) ) )
                    {
                    // InternalResoluteParser.g:1682:2: ( () ( (lv_str_1_0= RULE_STRING ) ) )
                    // InternalResoluteParser.g:1682:3: () ( (lv_str_1_0= RULE_STRING ) )
                    {
                    // InternalResoluteParser.g:1682:3: ()
                    // InternalResoluteParser.g:1683:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getClaimTextAccess().getClaimStringAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:1688:2: ( (lv_str_1_0= RULE_STRING ) )
                    // InternalResoluteParser.g:1689:1: (lv_str_1_0= RULE_STRING )
                    {
                    // InternalResoluteParser.g:1689:1: (lv_str_1_0= RULE_STRING )
                    // InternalResoluteParser.g:1690:3: lv_str_1_0= RULE_STRING
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
                    // InternalResoluteParser.g:1707:6: ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? )
                    {
                    // InternalResoluteParser.g:1707:6: ( () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )? )
                    // InternalResoluteParser.g:1707:7: () ( (otherlv_3= RULE_ID ) ) (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )?
                    {
                    // InternalResoluteParser.g:1707:7: ()
                    // InternalResoluteParser.g:1708:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getClaimTextAccess().getClaimArgAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:1713:2: ( (otherlv_3= RULE_ID ) )
                    // InternalResoluteParser.g:1714:1: (otherlv_3= RULE_ID )
                    {
                    // InternalResoluteParser.g:1714:1: (otherlv_3= RULE_ID )
                    // InternalResoluteParser.g:1715:3: otherlv_3= RULE_ID
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

                    // InternalResoluteParser.g:1726:2: (otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==PercentSign) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalResoluteParser.g:1727:2: otherlv_4= PercentSign ( (otherlv_5= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,PercentSign,FollowSets000.FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getClaimTextAccess().getPercentSignKeyword_1_2_0());
                                  
                            }
                            // InternalResoluteParser.g:1731:1: ( (otherlv_5= RULE_ID ) )
                            // InternalResoluteParser.g:1732:1: (otherlv_5= RULE_ID )
                            {
                            // InternalResoluteParser.g:1732:1: (otherlv_5= RULE_ID )
                            // InternalResoluteParser.g:1733:3: otherlv_5= RULE_ID
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
    // InternalResoluteParser.g:1754:1: entryRuleExpr returns [EObject current=null] : iv_ruleExpr= ruleExpr EOF ;
    public final EObject entryRuleExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpr = null;


        try {
            // InternalResoluteParser.g:1755:2: (iv_ruleExpr= ruleExpr EOF )
            // InternalResoluteParser.g:1756:2: iv_ruleExpr= ruleExpr EOF
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
    // InternalResoluteParser.g:1763:1: ruleExpr returns [EObject current=null] : this_ImpliesExpr_0= ruleImpliesExpr ;
    public final EObject ruleExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesExpr_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1766:28: (this_ImpliesExpr_0= ruleImpliesExpr )
            // InternalResoluteParser.g:1768:5: this_ImpliesExpr_0= ruleImpliesExpr
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
    // InternalResoluteParser.g:1784:1: entryRuleImpliesExpr returns [EObject current=null] : iv_ruleImpliesExpr= ruleImpliesExpr EOF ;
    public final EObject entryRuleImpliesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpr = null;


        try {
            // InternalResoluteParser.g:1785:2: (iv_ruleImpliesExpr= ruleImpliesExpr EOF )
            // InternalResoluteParser.g:1786:2: iv_ruleImpliesExpr= ruleImpliesExpr EOF
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
    // InternalResoluteParser.g:1793:1: ruleImpliesExpr returns [EObject current=null] : (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) ;
    public final EObject ruleImpliesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_OrExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1796:28: ( (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? ) )
            // InternalResoluteParser.g:1797:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            {
            // InternalResoluteParser.g:1797:1: (this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )? )
            // InternalResoluteParser.g:1798:5: this_OrExpr_0= ruleOrExpr ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
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
            // InternalResoluteParser.g:1806:1: ( ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==EqualsSignGreaterThanSign) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred2_InternalResoluteParser()) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // InternalResoluteParser.g:1806:2: ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) ) ( (lv_right_3_0= ruleImpliesExpr ) )
                    {
                    // InternalResoluteParser.g:1806:2: ( ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) ) )
                    // InternalResoluteParser.g:1806:3: ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )=> ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) )
                    {
                    // InternalResoluteParser.g:1814:6: ( () ( (lv_op_2_0= EqualsSignGreaterThanSign ) ) )
                    // InternalResoluteParser.g:1814:7: () ( (lv_op_2_0= EqualsSignGreaterThanSign ) )
                    {
                    // InternalResoluteParser.g:1814:7: ()
                    // InternalResoluteParser.g:1815:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getImpliesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:1820:2: ( (lv_op_2_0= EqualsSignGreaterThanSign ) )
                    // InternalResoluteParser.g:1821:1: (lv_op_2_0= EqualsSignGreaterThanSign )
                    {
                    // InternalResoluteParser.g:1821:1: (lv_op_2_0= EqualsSignGreaterThanSign )
                    // InternalResoluteParser.g:1822:3: lv_op_2_0= EqualsSignGreaterThanSign
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

                    // InternalResoluteParser.g:1836:4: ( (lv_right_3_0= ruleImpliesExpr ) )
                    // InternalResoluteParser.g:1837:1: (lv_right_3_0= ruleImpliesExpr )
                    {
                    // InternalResoluteParser.g:1837:1: (lv_right_3_0= ruleImpliesExpr )
                    // InternalResoluteParser.g:1838:3: lv_right_3_0= ruleImpliesExpr
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
    // InternalResoluteParser.g:1862:1: entryRuleOrExpr returns [EObject current=null] : iv_ruleOrExpr= ruleOrExpr EOF ;
    public final EObject entryRuleOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpr = null;


        try {
            // InternalResoluteParser.g:1863:2: (iv_ruleOrExpr= ruleOrExpr EOF )
            // InternalResoluteParser.g:1864:2: iv_ruleOrExpr= ruleOrExpr EOF
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
    // InternalResoluteParser.g:1871:1: ruleOrExpr returns [EObject current=null] : (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* ) ;
    public final EObject ruleOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_AndExpr_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1874:28: ( (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* ) )
            // InternalResoluteParser.g:1875:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* )
            {
            // InternalResoluteParser.g:1875:1: (this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )* )
            // InternalResoluteParser.g:1876:5: this_AndExpr_0= ruleAndExpr ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )*
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
            // InternalResoluteParser.g:1884:1: ( ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==Or) ) {
                    int LA18_2 = input.LA(2);

                    if ( (synpred3_InternalResoluteParser()) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==Orelse) ) {
                    int LA18_3 = input.LA(2);

                    if ( (synpred3_InternalResoluteParser()) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // InternalResoluteParser.g:1884:2: ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) ) ( (lv_right_4_0= ruleAndExpr ) )
            	    {
            	    // InternalResoluteParser.g:1884:2: ( ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) ) )
            	    // InternalResoluteParser.g:1884:3: ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )=> ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) )
            	    {
            	    // InternalResoluteParser.g:1900:7: ( () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) ) )
            	    // InternalResoluteParser.g:1900:8: () ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) )
            	    {
            	    // InternalResoluteParser.g:1900:8: ()
            	    // InternalResoluteParser.g:1901:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:1906:2: ( ( (lv_op_2_0= Or ) ) | ( (lv_op_3_0= Orelse ) ) )
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==Or) ) {
            	        alt17=1;
            	    }
            	    else if ( (LA17_0==Orelse) ) {
            	        alt17=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // InternalResoluteParser.g:1906:3: ( (lv_op_2_0= Or ) )
            	            {
            	            // InternalResoluteParser.g:1906:3: ( (lv_op_2_0= Or ) )
            	            // InternalResoluteParser.g:1907:1: (lv_op_2_0= Or )
            	            {
            	            // InternalResoluteParser.g:1907:1: (lv_op_2_0= Or )
            	            // InternalResoluteParser.g:1908:3: lv_op_2_0= Or
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
            	            // InternalResoluteParser.g:1923:6: ( (lv_op_3_0= Orelse ) )
            	            {
            	            // InternalResoluteParser.g:1923:6: ( (lv_op_3_0= Orelse ) )
            	            // InternalResoluteParser.g:1924:1: (lv_op_3_0= Orelse )
            	            {
            	            // InternalResoluteParser.g:1924:1: (lv_op_3_0= Orelse )
            	            // InternalResoluteParser.g:1925:3: lv_op_3_0= Orelse
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

            	    // InternalResoluteParser.g:1939:5: ( (lv_right_4_0= ruleAndExpr ) )
            	    // InternalResoluteParser.g:1940:1: (lv_right_4_0= ruleAndExpr )
            	    {
            	    // InternalResoluteParser.g:1940:1: (lv_right_4_0= ruleAndExpr )
            	    // InternalResoluteParser.g:1941:3: lv_right_4_0= ruleAndExpr
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
            	    break loop18;
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
    // InternalResoluteParser.g:1965:1: entryRuleAndExpr returns [EObject current=null] : iv_ruleAndExpr= ruleAndExpr EOF ;
    public final EObject entryRuleAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpr = null;


        try {
            // InternalResoluteParser.g:1966:2: (iv_ruleAndExpr= ruleAndExpr EOF )
            // InternalResoluteParser.g:1967:2: iv_ruleAndExpr= ruleAndExpr EOF
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
    // InternalResoluteParser.g:1974:1: ruleAndExpr returns [EObject current=null] : (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* ) ;
    public final EObject ruleAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        Token lv_op_3_0=null;
        EObject this_InstanceOfExpr_0 = null;

        EObject lv_right_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:1977:28: ( (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* ) )
            // InternalResoluteParser.g:1978:1: (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* )
            {
            // InternalResoluteParser.g:1978:1: (this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )* )
            // InternalResoluteParser.g:1979:5: this_InstanceOfExpr_0= ruleInstanceOfExpr ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )*
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
            // InternalResoluteParser.g:1987:1: ( ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==And) ) {
                    int LA20_2 = input.LA(2);

                    if ( (synpred4_InternalResoluteParser()) ) {
                        alt20=1;
                    }


                }
                else if ( (LA20_0==Andthen) ) {
                    int LA20_3 = input.LA(2);

                    if ( (synpred4_InternalResoluteParser()) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // InternalResoluteParser.g:1987:2: ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) ) ( (lv_right_4_0= ruleInstanceOfExpr ) )
            	    {
            	    // InternalResoluteParser.g:1987:2: ( ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) ) )
            	    // InternalResoluteParser.g:1987:3: ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )=> ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2003:7: ( () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) ) )
            	    // InternalResoluteParser.g:2003:8: () ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) )
            	    {
            	    // InternalResoluteParser.g:2003:8: ()
            	    // InternalResoluteParser.g:2004:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:2009:2: ( ( (lv_op_2_0= And ) ) | ( (lv_op_3_0= Andthen ) ) )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==And) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==Andthen) ) {
            	        alt19=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // InternalResoluteParser.g:2009:3: ( (lv_op_2_0= And ) )
            	            {
            	            // InternalResoluteParser.g:2009:3: ( (lv_op_2_0= And ) )
            	            // InternalResoluteParser.g:2010:1: (lv_op_2_0= And )
            	            {
            	            // InternalResoluteParser.g:2010:1: (lv_op_2_0= And )
            	            // InternalResoluteParser.g:2011:3: lv_op_2_0= And
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
            	            // InternalResoluteParser.g:2026:6: ( (lv_op_3_0= Andthen ) )
            	            {
            	            // InternalResoluteParser.g:2026:6: ( (lv_op_3_0= Andthen ) )
            	            // InternalResoluteParser.g:2027:1: (lv_op_3_0= Andthen )
            	            {
            	            // InternalResoluteParser.g:2027:1: (lv_op_3_0= Andthen )
            	            // InternalResoluteParser.g:2028:3: lv_op_3_0= Andthen
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

            	    // InternalResoluteParser.g:2042:5: ( (lv_right_4_0= ruleInstanceOfExpr ) )
            	    // InternalResoluteParser.g:2043:1: (lv_right_4_0= ruleInstanceOfExpr )
            	    {
            	    // InternalResoluteParser.g:2043:1: (lv_right_4_0= ruleInstanceOfExpr )
            	    // InternalResoluteParser.g:2044:3: lv_right_4_0= ruleInstanceOfExpr
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
            	    break loop20;
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
    // InternalResoluteParser.g:2068:1: entryRuleInstanceOfExpr returns [EObject current=null] : iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF ;
    public final EObject entryRuleInstanceOfExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceOfExpr = null;


        try {
            // InternalResoluteParser.g:2069:2: (iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF )
            // InternalResoluteParser.g:2070:2: iv_ruleInstanceOfExpr= ruleInstanceOfExpr EOF
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
    // InternalResoluteParser.g:2077:1: ruleInstanceOfExpr returns [EObject current=null] : (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? ) ;
    public final EObject ruleInstanceOfExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RelationalExpr_0 = null;

        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2080:28: ( (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? ) )
            // InternalResoluteParser.g:2081:1: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? )
            {
            // InternalResoluteParser.g:2081:1: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )? )
            // InternalResoluteParser.g:2082:5: this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )?
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
            // InternalResoluteParser.g:2090:1: ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Instanceof) ) {
                int LA21_1 = input.LA(2);

                if ( (synpred5_InternalResoluteParser()) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalResoluteParser.g:2090:2: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleBaseType ) )
                    {
                    // InternalResoluteParser.g:2090:2: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) )
                    // InternalResoluteParser.g:2090:3: ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof )
                    {
                    // InternalResoluteParser.g:2093:5: ( () otherlv_2= Instanceof )
                    // InternalResoluteParser.g:2093:6: () otherlv_2= Instanceof
                    {
                    // InternalResoluteParser.g:2093:6: ()
                    // InternalResoluteParser.g:2094:5: 
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

                    // InternalResoluteParser.g:2104:3: ( (lv_type_3_0= ruleBaseType ) )
                    // InternalResoluteParser.g:2105:1: (lv_type_3_0= ruleBaseType )
                    {
                    // InternalResoluteParser.g:2105:1: (lv_type_3_0= ruleBaseType )
                    // InternalResoluteParser.g:2106:3: lv_type_3_0= ruleBaseType
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
    // InternalResoluteParser.g:2130:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // InternalResoluteParser.g:2131:1: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // InternalResoluteParser.g:2132:2: iv_ruleRelationalOp= ruleRelationalOp EOF
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
    // InternalResoluteParser.g:2139:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2143:6: ( (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign ) )
            // InternalResoluteParser.g:2144:1: (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign )
            {
            // InternalResoluteParser.g:2144:1: (kw= LessThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSign | kw= GreaterThanSignEqualsSign | kw= EqualsSign | kw= LessThanSignGreaterThanSign )
            int alt22=6;
            switch ( input.LA(1) ) {
            case LessThanSign:
                {
                alt22=1;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt22=2;
                }
                break;
            case GreaterThanSign:
                {
                alt22=3;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt22=4;
                }
                break;
            case EqualsSign:
                {
                alt22=5;
                }
                break;
            case LessThanSignGreaterThanSign:
                {
                alt22=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalResoluteParser.g:2145:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:2152:2: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:2159:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:2166:2: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:2173:2: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:2180:2: kw= LessThanSignGreaterThanSign
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
    // InternalResoluteParser.g:2193:1: entryRuleRelationalExpr returns [EObject current=null] : iv_ruleRelationalExpr= ruleRelationalExpr EOF ;
    public final EObject entryRuleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpr = null;


        try {
            // InternalResoluteParser.g:2194:2: (iv_ruleRelationalExpr= ruleRelationalExpr EOF )
            // InternalResoluteParser.g:2195:2: iv_ruleRelationalExpr= ruleRelationalExpr EOF
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
    // InternalResoluteParser.g:2202:1: ruleRelationalExpr returns [EObject current=null] : (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) ;
    public final EObject ruleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PlusExpr_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2205:28: ( (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? ) )
            // InternalResoluteParser.g:2206:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            {
            // InternalResoluteParser.g:2206:1: (this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )? )
            // InternalResoluteParser.g:2207:5: this_PlusExpr_0= rulePlusExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
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
            // InternalResoluteParser.g:2215:1: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) ) )?
            int alt23=2;
            switch ( input.LA(1) ) {
                case LessThanSign:
                    {
                    int LA23_1 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt23=1;
                    }
                    }
                    break;
                case LessThanSignEqualsSign:
                    {
                    int LA23_2 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt23=1;
                    }
                    }
                    break;
                case GreaterThanSign:
                    {
                    int LA23_3 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt23=1;
                    }
                    }
                    break;
                case GreaterThanSignEqualsSign:
                    {
                    int LA23_4 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt23=1;
                    }
                    }
                    break;
                case EqualsSign:
                    {
                    int LA23_5 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt23=1;
                    }
                    }
                    break;
                case LessThanSignGreaterThanSign:
                    {
                    int LA23_6 = input.LA(2);

                    if ( (synpred6_InternalResoluteParser()) ) {
                        alt23=1;
                    }
                    }
                    break;
            }

            switch (alt23) {
                case 1 :
                    // InternalResoluteParser.g:2215:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePlusExpr ) )
                    {
                    // InternalResoluteParser.g:2215:2: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) )
                    // InternalResoluteParser.g:2215:3: ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    {
                    // InternalResoluteParser.g:2220:6: ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    // InternalResoluteParser.g:2220:7: () ( (lv_op_2_0= ruleRelationalOp ) )
                    {
                    // InternalResoluteParser.g:2220:7: ()
                    // InternalResoluteParser.g:2221:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2226:2: ( (lv_op_2_0= ruleRelationalOp ) )
                    // InternalResoluteParser.g:2227:1: (lv_op_2_0= ruleRelationalOp )
                    {
                    // InternalResoluteParser.g:2227:1: (lv_op_2_0= ruleRelationalOp )
                    // InternalResoluteParser.g:2228:3: lv_op_2_0= ruleRelationalOp
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

                    // InternalResoluteParser.g:2244:4: ( (lv_right_3_0= rulePlusExpr ) )
                    // InternalResoluteParser.g:2245:1: (lv_right_3_0= rulePlusExpr )
                    {
                    // InternalResoluteParser.g:2245:1: (lv_right_3_0= rulePlusExpr )
                    // InternalResoluteParser.g:2246:3: lv_right_3_0= rulePlusExpr
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
    // InternalResoluteParser.g:2270:1: entryRulePlusExpr returns [EObject current=null] : iv_rulePlusExpr= rulePlusExpr EOF ;
    public final EObject entryRulePlusExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusExpr = null;


        try {
            // InternalResoluteParser.g:2271:2: (iv_rulePlusExpr= rulePlusExpr EOF )
            // InternalResoluteParser.g:2272:2: iv_rulePlusExpr= rulePlusExpr EOF
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
    // InternalResoluteParser.g:2279:1: rulePlusExpr returns [EObject current=null] : (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* ) ;
    public final EObject rulePlusExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_TimesExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2282:28: ( (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* ) )
            // InternalResoluteParser.g:2283:1: (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* )
            {
            // InternalResoluteParser.g:2283:1: (this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )* )
            // InternalResoluteParser.g:2284:5: this_TimesExpr_0= ruleTimesExpr ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )*
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
            // InternalResoluteParser.g:2292:1: ( ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==PlusSign) ) {
                    int LA25_2 = input.LA(2);

                    if ( (synpred7_InternalResoluteParser()) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==HyphenMinus) ) {
                    int LA25_3 = input.LA(2);

                    if ( (synpred7_InternalResoluteParser()) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // InternalResoluteParser.g:2292:2: ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) ) ( (lv_right_3_0= ruleTimesExpr ) )
            	    {
            	    // InternalResoluteParser.g:2292:2: ( ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) ) )
            	    // InternalResoluteParser.g:2292:3: ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )=> ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2307:6: ( () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) ) )
            	    // InternalResoluteParser.g:2307:7: () ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    {
            	    // InternalResoluteParser.g:2307:7: ()
            	    // InternalResoluteParser.g:2308:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPlusExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:2313:2: ( ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) ) )
            	    // InternalResoluteParser.g:2314:1: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    {
            	    // InternalResoluteParser.g:2314:1: ( (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus ) )
            	    // InternalResoluteParser.g:2315:1: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    {
            	    // InternalResoluteParser.g:2315:1: (lv_op_2_1= PlusSign | lv_op_2_2= HyphenMinus )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==PlusSign) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==HyphenMinus) ) {
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
            	            // InternalResoluteParser.g:2316:3: lv_op_2_1= PlusSign
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
            	            // InternalResoluteParser.g:2329:8: lv_op_2_2= HyphenMinus
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

            	    // InternalResoluteParser.g:2345:4: ( (lv_right_3_0= ruleTimesExpr ) )
            	    // InternalResoluteParser.g:2346:1: (lv_right_3_0= ruleTimesExpr )
            	    {
            	    // InternalResoluteParser.g:2346:1: (lv_right_3_0= ruleTimesExpr )
            	    // InternalResoluteParser.g:2347:3: lv_right_3_0= ruleTimesExpr
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
    // $ANTLR end "rulePlusExpr"


    // $ANTLR start "entryRuleTimesExpr"
    // InternalResoluteParser.g:2371:1: entryRuleTimesExpr returns [EObject current=null] : iv_ruleTimesExpr= ruleTimesExpr EOF ;
    public final EObject entryRuleTimesExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimesExpr = null;


        try {
            // InternalResoluteParser.g:2372:2: (iv_ruleTimesExpr= ruleTimesExpr EOF )
            // InternalResoluteParser.g:2373:2: iv_ruleTimesExpr= ruleTimesExpr EOF
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
    // InternalResoluteParser.g:2380:1: ruleTimesExpr returns [EObject current=null] : (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* ) ;
    public final EObject ruleTimesExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_ExpExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2383:28: ( (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* ) )
            // InternalResoluteParser.g:2384:1: (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* )
            {
            // InternalResoluteParser.g:2384:1: (this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )* )
            // InternalResoluteParser.g:2385:5: this_ExpExpr_0= ruleExpExpr ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )*
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
            // InternalResoluteParser.g:2393:1: ( ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) ) )*
            loop27:
            do {
                int alt27=2;
                switch ( input.LA(1) ) {
                case Asterisk:
                    {
                    int LA27_2 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt27=1;
                    }


                    }
                    break;
                case Solidus:
                    {
                    int LA27_3 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt27=1;
                    }


                    }
                    break;
                case PercentSign:
                    {
                    int LA27_4 = input.LA(2);

                    if ( (synpred8_InternalResoluteParser()) ) {
                        alt27=1;
                    }


                    }
                    break;

                }

                switch (alt27) {
            	case 1 :
            	    // InternalResoluteParser.g:2393:2: ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) ) ( (lv_right_3_0= ruleExpExpr ) )
            	    {
            	    // InternalResoluteParser.g:2393:2: ( ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) ) )
            	    // InternalResoluteParser.g:2393:3: ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )=> ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) )
            	    {
            	    // InternalResoluteParser.g:2412:6: ( () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) ) )
            	    // InternalResoluteParser.g:2412:7: () ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    {
            	    // InternalResoluteParser.g:2412:7: ()
            	    // InternalResoluteParser.g:2413:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getTimesExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:2418:2: ( ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) ) )
            	    // InternalResoluteParser.g:2419:1: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    {
            	    // InternalResoluteParser.g:2419:1: ( (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign ) )
            	    // InternalResoluteParser.g:2420:1: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    {
            	    // InternalResoluteParser.g:2420:1: (lv_op_2_1= Asterisk | lv_op_2_2= Solidus | lv_op_2_3= PercentSign )
            	    int alt26=3;
            	    switch ( input.LA(1) ) {
            	    case Asterisk:
            	        {
            	        alt26=1;
            	        }
            	        break;
            	    case Solidus:
            	        {
            	        alt26=2;
            	        }
            	        break;
            	    case PercentSign:
            	        {
            	        alt26=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt26) {
            	        case 1 :
            	            // InternalResoluteParser.g:2421:3: lv_op_2_1= Asterisk
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
            	            // InternalResoluteParser.g:2434:8: lv_op_2_2= Solidus
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
            	            // InternalResoluteParser.g:2447:8: lv_op_2_3= PercentSign
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

            	    // InternalResoluteParser.g:2463:4: ( (lv_right_3_0= ruleExpExpr ) )
            	    // InternalResoluteParser.g:2464:1: (lv_right_3_0= ruleExpExpr )
            	    {
            	    // InternalResoluteParser.g:2464:1: (lv_right_3_0= ruleExpExpr )
            	    // InternalResoluteParser.g:2465:3: lv_right_3_0= ruleExpExpr
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
            	    break loop27;
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
    // InternalResoluteParser.g:2489:1: entryRuleExpExpr returns [EObject current=null] : iv_ruleExpExpr= ruleExpExpr EOF ;
    public final EObject entryRuleExpExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpExpr = null;


        try {
            // InternalResoluteParser.g:2490:2: (iv_ruleExpExpr= ruleExpExpr EOF )
            // InternalResoluteParser.g:2491:2: iv_ruleExpExpr= ruleExpExpr EOF
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
    // InternalResoluteParser.g:2498:1: ruleExpExpr returns [EObject current=null] : (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* ) ;
    public final EObject ruleExpExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_PrefixExpr_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2501:28: ( (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* ) )
            // InternalResoluteParser.g:2502:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* )
            {
            // InternalResoluteParser.g:2502:1: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )* )
            // InternalResoluteParser.g:2503:5: this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )*
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
            // InternalResoluteParser.g:2511:1: ( ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==CircumflexAccent) ) {
                    int LA28_2 = input.LA(2);

                    if ( (synpred9_InternalResoluteParser()) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // InternalResoluteParser.g:2511:2: ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) )
            	    {
            	    // InternalResoluteParser.g:2511:2: ( ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) ) )
            	    // InternalResoluteParser.g:2511:3: ( ( () ( ( CircumflexAccent ) ) ) )=> ( () ( (lv_op_2_0= CircumflexAccent ) ) )
            	    {
            	    // InternalResoluteParser.g:2519:6: ( () ( (lv_op_2_0= CircumflexAccent ) ) )
            	    // InternalResoluteParser.g:2519:7: () ( (lv_op_2_0= CircumflexAccent ) )
            	    {
            	    // InternalResoluteParser.g:2519:7: ()
            	    // InternalResoluteParser.g:2520:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getExpExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // InternalResoluteParser.g:2525:2: ( (lv_op_2_0= CircumflexAccent ) )
            	    // InternalResoluteParser.g:2526:1: (lv_op_2_0= CircumflexAccent )
            	    {
            	    // InternalResoluteParser.g:2526:1: (lv_op_2_0= CircumflexAccent )
            	    // InternalResoluteParser.g:2527:3: lv_op_2_0= CircumflexAccent
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

            	    // InternalResoluteParser.g:2541:4: ( (lv_right_3_0= rulePrefixExpr ) )
            	    // InternalResoluteParser.g:2542:1: (lv_right_3_0= rulePrefixExpr )
            	    {
            	    // InternalResoluteParser.g:2542:1: (lv_right_3_0= rulePrefixExpr )
            	    // InternalResoluteParser.g:2543:3: lv_right_3_0= rulePrefixExpr
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
    // $ANTLR end "ruleExpExpr"


    // $ANTLR start "entryRulePrefixExpr"
    // InternalResoluteParser.g:2567:1: entryRulePrefixExpr returns [EObject current=null] : iv_rulePrefixExpr= rulePrefixExpr EOF ;
    public final EObject entryRulePrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpr = null;


        try {
            // InternalResoluteParser.g:2568:2: (iv_rulePrefixExpr= rulePrefixExpr EOF )
            // InternalResoluteParser.g:2569:2: iv_rulePrefixExpr= rulePrefixExpr EOF
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
    // InternalResoluteParser.g:2576:1: rulePrefixExpr returns [EObject current=null] : ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr ) ;
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
            // InternalResoluteParser.g:2579:28: ( ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr ) )
            // InternalResoluteParser.g:2580:1: ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr )
            {
            // InternalResoluteParser.g:2580:1: ( ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) ) | this_AtomicExpr_8= ruleAtomicExpr )
            int alt30=3;
            switch ( input.LA(1) ) {
            case Not:
            case HyphenMinus:
                {
                alt30=1;
                }
                break;
            case LeftParenthesis:
                {
                switch ( input.LA(2) ) {
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
                    alt30=3;
                    }
                    break;
                case Property:
                    {
                    int LA30_4 = input.LA(3);

                    if ( (LA30_4==LeftParenthesis) ) {
                        alt30=3;
                    }
                    else if ( (LA30_4==RightParenthesis) ) {
                        alt30=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 4, input);

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
                    alt30=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 2, input);

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
            case Sum:
            case If:
            case LeftSquareBracket:
            case LeftCurlyBracket:
            case RULE_REAL_LIT:
            case RULE_INTEGER_LIT:
            case RULE_STRING:
            case RULE_ID:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalResoluteParser.g:2580:2: ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    {
                    // InternalResoluteParser.g:2580:2: ( () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    // InternalResoluteParser.g:2580:3: () ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) ) ( (lv_expr_2_0= rulePrefixExpr ) )
                    {
                    // InternalResoluteParser.g:2580:3: ()
                    // InternalResoluteParser.g:2581:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixExprAccess().getUnaryExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2586:2: ( ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) ) )
                    // InternalResoluteParser.g:2587:1: ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) )
                    {
                    // InternalResoluteParser.g:2587:1: ( (lv_op_1_1= HyphenMinus | lv_op_1_2= Not ) )
                    // InternalResoluteParser.g:2588:1: (lv_op_1_1= HyphenMinus | lv_op_1_2= Not )
                    {
                    // InternalResoluteParser.g:2588:1: (lv_op_1_1= HyphenMinus | lv_op_1_2= Not )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==HyphenMinus) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==Not) ) {
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
                            // InternalResoluteParser.g:2589:3: lv_op_1_1= HyphenMinus
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
                            // InternalResoluteParser.g:2602:8: lv_op_1_2= Not
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

                    // InternalResoluteParser.g:2618:2: ( (lv_expr_2_0= rulePrefixExpr ) )
                    // InternalResoluteParser.g:2619:1: (lv_expr_2_0= rulePrefixExpr )
                    {
                    // InternalResoluteParser.g:2619:1: (lv_expr_2_0= rulePrefixExpr )
                    // InternalResoluteParser.g:2620:3: lv_expr_2_0= rulePrefixExpr
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
                    // InternalResoluteParser.g:2637:6: ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) )
                    {
                    // InternalResoluteParser.g:2637:6: ( () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) ) )
                    // InternalResoluteParser.g:2637:7: () otherlv_4= LeftParenthesis ( (lv_type_5_0= ruleBaseType ) ) otherlv_6= RightParenthesis ( (lv_expr_7_0= rulePrefixExpr ) )
                    {
                    // InternalResoluteParser.g:2637:7: ()
                    // InternalResoluteParser.g:2638:5: 
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
                    // InternalResoluteParser.g:2648:1: ( (lv_type_5_0= ruleBaseType ) )
                    // InternalResoluteParser.g:2649:1: (lv_type_5_0= ruleBaseType )
                    {
                    // InternalResoluteParser.g:2649:1: (lv_type_5_0= ruleBaseType )
                    // InternalResoluteParser.g:2650:3: lv_type_5_0= ruleBaseType
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
                    // InternalResoluteParser.g:2671:1: ( (lv_expr_7_0= rulePrefixExpr ) )
                    // InternalResoluteParser.g:2672:1: (lv_expr_7_0= rulePrefixExpr )
                    {
                    // InternalResoluteParser.g:2672:1: (lv_expr_7_0= rulePrefixExpr )
                    // InternalResoluteParser.g:2673:3: lv_expr_7_0= rulePrefixExpr
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
                    // InternalResoluteParser.g:2691:5: this_AtomicExpr_8= ruleAtomicExpr
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
    // InternalResoluteParser.g:2707:1: entryRuleAtomicExpr returns [EObject current=null] : iv_ruleAtomicExpr= ruleAtomicExpr EOF ;
    public final EObject entryRuleAtomicExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpr = null;


        try {
            // InternalResoluteParser.g:2708:2: (iv_ruleAtomicExpr= ruleAtomicExpr EOF )
            // InternalResoluteParser.g:2709:2: iv_ruleAtomicExpr= ruleAtomicExpr EOF
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
    // InternalResoluteParser.g:2716:1: ruleAtomicExpr returns [EObject current=null] : ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) ) ;
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


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:2719:28: ( ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) ) )
            // InternalResoluteParser.g:2720:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) )
            {
            // InternalResoluteParser.g:2720:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) )
            int alt50=19;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // InternalResoluteParser.g:2720:2: ( () ( ( ruleQCREF ) ) )
                    {
                    // InternalResoluteParser.g:2720:2: ( () ( ( ruleQCREF ) ) )
                    // InternalResoluteParser.g:2720:3: () ( ( ruleQCREF ) )
                    {
                    // InternalResoluteParser.g:2720:3: ()
                    // InternalResoluteParser.g:2721:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIdExprAction_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2726:2: ( ( ruleQCREF ) )
                    // InternalResoluteParser.g:2727:1: ( ruleQCREF )
                    {
                    // InternalResoluteParser.g:2727:1: ( ruleQCREF )
                    // InternalResoluteParser.g:2728:3: ruleQCREF
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
                    // InternalResoluteParser.g:2743:6: ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? )
                    {
                    // InternalResoluteParser.g:2743:6: ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? )
                    // InternalResoluteParser.g:2743:7: () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )?
                    {
                    // InternalResoluteParser.g:2743:7: ()
                    // InternalResoluteParser.g:2744:5: 
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
                    // InternalResoluteParser.g:2754:1: (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==FullStop) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalResoluteParser.g:2755:2: otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) )
                            {
                            otherlv_4=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getAtomicExprAccess().getFullStopKeyword_1_2_0());
                                  
                            }
                            // InternalResoluteParser.g:2759:1: ( (lv_sub_5_0= ruleNestedDotID ) )
                            // InternalResoluteParser.g:2760:1: (lv_sub_5_0= ruleNestedDotID )
                            {
                            // InternalResoluteParser.g:2760:1: (lv_sub_5_0= ruleNestedDotID )
                            // InternalResoluteParser.g:2761:3: lv_sub_5_0= ruleNestedDotID
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
                    // InternalResoluteParser.g:2778:6: ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) )
                    {
                    // InternalResoluteParser.g:2778:6: ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) )
                    // InternalResoluteParser.g:2778:7: () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) )
                    {
                    // InternalResoluteParser.g:2778:7: ()
                    // InternalResoluteParser.g:2779:5: 
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
                    // InternalResoluteParser.g:2789:1: ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=Error_state_reachable && LA33_0<=Is_virtual_processor)||(LA33_0>=Flow_specifications && LA33_0<=Is_abstract_feature)||LA33_0==Enumerated_values||(LA33_0>=End_to_end_flows && LA33_0<=Is_bidirectional)||(LA33_0>=Is_thread_group && LA33_0<=Contain_error)||(LA33_0>=Flow_elements && LA33_0<=Is_processor)||LA33_0==Connections||(LA33_0>=Destination && LA33_0<=Upper_bound)||(LA33_0>=Has_member && LA33_0<=Has_parent)||(LA33_0>=Is_of_type && LA33_0<=Is_process)||(LA33_0>=Direction && LA33_0<=Is_thread)||LA33_0==Analysis||(LA33_0>=Features && LA33_0<=Property)||LA33_0==As_list||(LA33_0>=Is_data && LA33_0<=Is_port)||LA33_0==Warning||(LA33_0>=Append && LA33_0<=As_set)||(LA33_0>=Exists && LA33_0<=Member)||(LA33_0>=Parent && LA33_0<=Source)||LA33_0==Debug||(LA33_0>=Error && LA33_0<=False)||LA33_0==Union||(LA33_0>=Fail && LA33_0<=Name)||(LA33_0>=Size && LA33_0<=Tail)||(LA33_0>=This && LA33_0<=Type)||(LA33_0>=Let && LA33_0<=Sum)||LA33_0==If||LA33_0==LeftParenthesis||LA33_0==HyphenMinus||LA33_0==LeftSquareBracket||LA33_0==LeftCurlyBracket||LA33_0==RULE_REAL_LIT||LA33_0==RULE_INTEGER_LIT||(LA33_0>=RULE_STRING && LA33_0<=RULE_ID)) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==AsteriskAsterisk) ) {
                        alt33=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalResoluteParser.g:2789:2: ( (lv_val_8_0= ruleExpr ) )
                            {
                            // InternalResoluteParser.g:2789:2: ( (lv_val_8_0= ruleExpr ) )
                            // InternalResoluteParser.g:2790:1: (lv_val_8_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:2790:1: (lv_val_8_0= ruleExpr )
                            // InternalResoluteParser.g:2791:3: lv_val_8_0= ruleExpr
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
                            // InternalResoluteParser.g:2808:6: (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk )
                            {
                            // InternalResoluteParser.g:2808:6: (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk )
                            // InternalResoluteParser.g:2809:2: otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk
                            {
                            otherlv_9=(Token)match(input,AsteriskAsterisk,FollowSets000.FOLLOW_19); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getAtomicExprAccess().getAsteriskAsteriskKeyword_2_2_1_0());
                                  
                            }
                            // InternalResoluteParser.g:2813:1: ( (lv_failmsg_10_0= ruleClaimText ) )+
                            int cnt32=0;
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_ID)) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // InternalResoluteParser.g:2814:1: (lv_failmsg_10_0= ruleClaimText )
                            	    {
                            	    // InternalResoluteParser.g:2814:1: (lv_failmsg_10_0= ruleClaimText )
                            	    // InternalResoluteParser.g:2815:3: lv_failmsg_10_0= ruleClaimText
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
                            	    if ( cnt32 >= 1 ) break loop32;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(32, input);
                                        throw eee;
                                }
                                cnt32++;
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
                    // InternalResoluteParser.g:2837:6: ( () ( (lv_val_13_0= ruleIntegerTerm ) ) )
                    {
                    // InternalResoluteParser.g:2837:6: ( () ( (lv_val_13_0= ruleIntegerTerm ) ) )
                    // InternalResoluteParser.g:2837:7: () ( (lv_val_13_0= ruleIntegerTerm ) )
                    {
                    // InternalResoluteParser.g:2837:7: ()
                    // InternalResoluteParser.g:2838:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getIntExprAction_3_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2843:2: ( (lv_val_13_0= ruleIntegerTerm ) )
                    // InternalResoluteParser.g:2844:1: (lv_val_13_0= ruleIntegerTerm )
                    {
                    // InternalResoluteParser.g:2844:1: (lv_val_13_0= ruleIntegerTerm )
                    // InternalResoluteParser.g:2845:3: lv_val_13_0= ruleIntegerTerm
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
                    // InternalResoluteParser.g:2862:6: ( () ( (lv_val_15_0= ruleRealTerm ) ) )
                    {
                    // InternalResoluteParser.g:2862:6: ( () ( (lv_val_15_0= ruleRealTerm ) ) )
                    // InternalResoluteParser.g:2862:7: () ( (lv_val_15_0= ruleRealTerm ) )
                    {
                    // InternalResoluteParser.g:2862:7: ()
                    // InternalResoluteParser.g:2863:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getRealExprAction_4_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2868:2: ( (lv_val_15_0= ruleRealTerm ) )
                    // InternalResoluteParser.g:2869:1: (lv_val_15_0= ruleRealTerm )
                    {
                    // InternalResoluteParser.g:2869:1: (lv_val_15_0= ruleRealTerm )
                    // InternalResoluteParser.g:2870:3: lv_val_15_0= ruleRealTerm
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
                    // InternalResoluteParser.g:2887:6: ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) )
                    {
                    // InternalResoluteParser.g:2887:6: ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) )
                    // InternalResoluteParser.g:2887:7: () ( (lv_val_17_0= ruleBooleanLiteral ) )
                    {
                    // InternalResoluteParser.g:2887:7: ()
                    // InternalResoluteParser.g:2888:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getBoolExprAction_5_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2893:2: ( (lv_val_17_0= ruleBooleanLiteral ) )
                    // InternalResoluteParser.g:2894:1: (lv_val_17_0= ruleBooleanLiteral )
                    {
                    // InternalResoluteParser.g:2894:1: (lv_val_17_0= ruleBooleanLiteral )
                    // InternalResoluteParser.g:2895:3: lv_val_17_0= ruleBooleanLiteral
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
                    // InternalResoluteParser.g:2912:6: ( () ( (lv_val_19_0= ruleStringTerm ) ) )
                    {
                    // InternalResoluteParser.g:2912:6: ( () ( (lv_val_19_0= ruleStringTerm ) ) )
                    // InternalResoluteParser.g:2912:7: () ( (lv_val_19_0= ruleStringTerm ) )
                    {
                    // InternalResoluteParser.g:2912:7: ()
                    // InternalResoluteParser.g:2913:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getStringExprAction_6_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:2918:2: ( (lv_val_19_0= ruleStringTerm ) )
                    // InternalResoluteParser.g:2919:1: (lv_val_19_0= ruleStringTerm )
                    {
                    // InternalResoluteParser.g:2919:1: (lv_val_19_0= ruleStringTerm )
                    // InternalResoluteParser.g:2920:3: lv_val_19_0= ruleStringTerm
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
                    // InternalResoluteParser.g:2937:6: ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:2937:6: ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:2937:7: () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:2937:7: ()
                    // InternalResoluteParser.g:2938:5: 
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
                    // InternalResoluteParser.g:2948:1: ( (lv_cond_22_0= ruleExpr ) )
                    // InternalResoluteParser.g:2949:1: (lv_cond_22_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:2949:1: (lv_cond_22_0= ruleExpr )
                    // InternalResoluteParser.g:2950:3: lv_cond_22_0= ruleExpr
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
                    // InternalResoluteParser.g:2971:1: ( (lv_then_24_0= ruleExpr ) )
                    // InternalResoluteParser.g:2972:1: (lv_then_24_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:2972:1: (lv_then_24_0= ruleExpr )
                    // InternalResoluteParser.g:2973:3: lv_then_24_0= ruleExpr
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
                    // InternalResoluteParser.g:2994:1: ( (lv_else_26_0= ruleExpr ) )
                    // InternalResoluteParser.g:2995:1: (lv_else_26_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:2995:1: (lv_else_26_0= ruleExpr )
                    // InternalResoluteParser.g:2996:3: lv_else_26_0= ruleExpr
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
                    // InternalResoluteParser.g:3013:6: ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:3013:6: ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:3013:7: () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:3013:7: ()
                    // InternalResoluteParser.g:3014:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getQuantifiedExprAction_8_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3019:2: ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) )
                    // InternalResoluteParser.g:3020:1: ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) )
                    {
                    // InternalResoluteParser.g:3020:1: ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) )
                    // InternalResoluteParser.g:3021:1: (lv_quant_28_1= Forall | lv_quant_28_2= Exists )
                    {
                    // InternalResoluteParser.g:3021:1: (lv_quant_28_1= Forall | lv_quant_28_2= Exists )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==Forall) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==Exists) ) {
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
                            // InternalResoluteParser.g:3022:3: lv_quant_28_1= Forall
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
                            // InternalResoluteParser.g:3035:8: lv_quant_28_2= Exists
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

                    // InternalResoluteParser.g:3051:2: (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==LeftParenthesis) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalResoluteParser.g:3052:2: otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis
                    	    {
                    	    otherlv_29=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_29, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_8_2_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:3056:1: ( (lv_args_30_0= ruleArg ) )
                    	    // InternalResoluteParser.g:3057:1: (lv_args_30_0= ruleArg )
                    	    {
                    	    // InternalResoluteParser.g:3057:1: (lv_args_30_0= ruleArg )
                    	    // InternalResoluteParser.g:3058:3: lv_args_30_0= ruleArg
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
                    	    if ( cnt35 >= 1 ) break loop35;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);

                    otherlv_32=(Token)match(input,FullStop,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getAtomicExprAccess().getFullStopKeyword_8_3());
                          
                    }
                    // InternalResoluteParser.g:3084:1: ( (lv_expr_33_0= ruleExpr ) )
                    // InternalResoluteParser.g:3085:1: (lv_expr_33_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3085:1: (lv_expr_33_0= ruleExpr )
                    // InternalResoluteParser.g:3086:3: lv_expr_33_0= ruleExpr
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
                    // InternalResoluteParser.g:3103:6: ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) )
                    {
                    // InternalResoluteParser.g:3103:6: ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) )
                    // InternalResoluteParser.g:3103:7: ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3130:5: ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis )
                    // InternalResoluteParser.g:3130:6: () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis
                    {
                    // InternalResoluteParser.g:3130:6: ()
                    // InternalResoluteParser.g:3131:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getLibraryFnCallExprAction_9_0_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3136:2: ( (lv_libName_35_0= RULE_ID ) )
                    // InternalResoluteParser.g:3137:1: (lv_libName_35_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:3137:1: (lv_libName_35_0= RULE_ID )
                    // InternalResoluteParser.g:3138:3: lv_libName_35_0= RULE_ID
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
                    // InternalResoluteParser.g:3159:1: ( (lv_fnName_37_0= RULE_ID ) )
                    // InternalResoluteParser.g:3160:1: (lv_fnName_37_0= RULE_ID )
                    {
                    // InternalResoluteParser.g:3160:1: (lv_fnName_37_0= RULE_ID )
                    // InternalResoluteParser.g:3161:3: lv_fnName_37_0= RULE_ID
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
                    // InternalResoluteParser.g:3182:1: ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( ((LA37_0>=Error_state_reachable && LA37_0<=Is_virtual_processor)||(LA37_0>=Flow_specifications && LA37_0<=Is_abstract_feature)||LA37_0==Enumerated_values||(LA37_0>=End_to_end_flows && LA37_0<=Is_bidirectional)||(LA37_0>=Is_thread_group && LA37_0<=Contain_error)||(LA37_0>=Flow_elements && LA37_0<=Is_processor)||LA37_0==Connections||(LA37_0>=Destination && LA37_0<=Upper_bound)||(LA37_0>=Has_member && LA37_0<=Has_parent)||(LA37_0>=Is_of_type && LA37_0<=Is_process)||(LA37_0>=Direction && LA37_0<=Is_thread)||LA37_0==Analysis||(LA37_0>=Features && LA37_0<=Property)||LA37_0==As_list||(LA37_0>=Is_data && LA37_0<=Is_port)||LA37_0==Warning||(LA37_0>=Append && LA37_0<=As_set)||(LA37_0>=Exists && LA37_0<=Member)||(LA37_0>=Parent && LA37_0<=Source)||LA37_0==Debug||(LA37_0>=Error && LA37_0<=False)||LA37_0==Union||(LA37_0>=Fail && LA37_0<=Name)||(LA37_0>=Size && LA37_0<=Tail)||(LA37_0>=This && LA37_0<=Type)||(LA37_0>=Let && LA37_0<=Sum)||LA37_0==If||LA37_0==LeftParenthesis||LA37_0==HyphenMinus||LA37_0==LeftSquareBracket||LA37_0==LeftCurlyBracket||LA37_0==RULE_REAL_LIT||LA37_0==RULE_INTEGER_LIT||(LA37_0>=RULE_STRING && LA37_0<=RULE_ID)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalResoluteParser.g:3182:2: ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3182:2: ( (lv_args_39_0= ruleExpr ) )
                            // InternalResoluteParser.g:3183:1: (lv_args_39_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3183:1: (lv_args_39_0= ruleExpr )
                            // InternalResoluteParser.g:3184:3: lv_args_39_0= ruleExpr
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

                            // InternalResoluteParser.g:3200:2: (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )*
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==Comma) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3201:2: otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) )
                            	    {
                            	    otherlv_40=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_40, grammarAccess.getAtomicExprAccess().getCommaKeyword_9_0_5_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3205:1: ( (lv_args_41_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3206:1: (lv_args_41_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3206:1: (lv_args_41_0= ruleExpr )
                            	    // InternalResoluteParser.g:3207:3: lv_args_41_0= ruleExpr
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
                            	    break loop36;
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
                    // InternalResoluteParser.g:3229:6: ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3229:6: ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis )
                    // InternalResoluteParser.g:3229:7: () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis
                    {
                    // InternalResoluteParser.g:3229:7: ()
                    // InternalResoluteParser.g:3230:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getBuiltInFnCallExprAction_10_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3235:2: ( (lv_fn_44_0= ruleBuiltInFn ) )
                    // InternalResoluteParser.g:3236:1: (lv_fn_44_0= ruleBuiltInFn )
                    {
                    // InternalResoluteParser.g:3236:1: (lv_fn_44_0= ruleBuiltInFn )
                    // InternalResoluteParser.g:3237:3: lv_fn_44_0= ruleBuiltInFn
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
                    // InternalResoluteParser.g:3258:1: ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=Error_state_reachable && LA39_0<=Is_virtual_processor)||(LA39_0>=Flow_specifications && LA39_0<=Is_abstract_feature)||LA39_0==Enumerated_values||(LA39_0>=End_to_end_flows && LA39_0<=Is_bidirectional)||(LA39_0>=Is_thread_group && LA39_0<=Contain_error)||(LA39_0>=Flow_elements && LA39_0<=Is_processor)||LA39_0==Connections||(LA39_0>=Destination && LA39_0<=Upper_bound)||(LA39_0>=Has_member && LA39_0<=Has_parent)||(LA39_0>=Is_of_type && LA39_0<=Is_process)||(LA39_0>=Direction && LA39_0<=Is_thread)||LA39_0==Analysis||(LA39_0>=Features && LA39_0<=Property)||LA39_0==As_list||(LA39_0>=Is_data && LA39_0<=Is_port)||LA39_0==Warning||(LA39_0>=Append && LA39_0<=As_set)||(LA39_0>=Exists && LA39_0<=Member)||(LA39_0>=Parent && LA39_0<=Source)||LA39_0==Debug||(LA39_0>=Error && LA39_0<=False)||LA39_0==Union||(LA39_0>=Fail && LA39_0<=Name)||(LA39_0>=Size && LA39_0<=Tail)||(LA39_0>=This && LA39_0<=Type)||(LA39_0>=Let && LA39_0<=Sum)||LA39_0==If||LA39_0==LeftParenthesis||LA39_0==HyphenMinus||LA39_0==LeftSquareBracket||LA39_0==LeftCurlyBracket||LA39_0==RULE_REAL_LIT||LA39_0==RULE_INTEGER_LIT||(LA39_0>=RULE_STRING && LA39_0<=RULE_ID)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalResoluteParser.g:3258:2: ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3258:2: ( (lv_args_46_0= ruleExpr ) )
                            // InternalResoluteParser.g:3259:1: (lv_args_46_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3259:1: (lv_args_46_0= ruleExpr )
                            // InternalResoluteParser.g:3260:3: lv_args_46_0= ruleExpr
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

                            // InternalResoluteParser.g:3276:2: (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )*
                            loop38:
                            do {
                                int alt38=2;
                                int LA38_0 = input.LA(1);

                                if ( (LA38_0==Comma) ) {
                                    alt38=1;
                                }


                                switch (alt38) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3277:2: otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) )
                            	    {
                            	    otherlv_47=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_47, grammarAccess.getAtomicExprAccess().getCommaKeyword_10_3_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3281:1: ( (lv_args_48_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3282:1: (lv_args_48_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3282:1: (lv_args_48_0= ruleExpr )
                            	    // InternalResoluteParser.g:3283:3: lv_args_48_0= ruleExpr
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
                            	    break loop38;
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
                    // InternalResoluteParser.g:3305:6: ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3305:6: ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis )
                    // InternalResoluteParser.g:3305:7: () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis
                    {
                    // InternalResoluteParser.g:3305:7: ()
                    // InternalResoluteParser.g:3306:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getFnCallExprAction_11_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3311:2: ( (otherlv_51= RULE_ID ) )
                    // InternalResoluteParser.g:3312:1: (otherlv_51= RULE_ID )
                    {
                    // InternalResoluteParser.g:3312:1: (otherlv_51= RULE_ID )
                    // InternalResoluteParser.g:3313:3: otherlv_51= RULE_ID
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
                    // InternalResoluteParser.g:3329:1: ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( ((LA41_0>=Error_state_reachable && LA41_0<=Is_virtual_processor)||(LA41_0>=Flow_specifications && LA41_0<=Is_abstract_feature)||LA41_0==Enumerated_values||(LA41_0>=End_to_end_flows && LA41_0<=Is_bidirectional)||(LA41_0>=Is_thread_group && LA41_0<=Contain_error)||(LA41_0>=Flow_elements && LA41_0<=Is_processor)||LA41_0==Connections||(LA41_0>=Destination && LA41_0<=Upper_bound)||(LA41_0>=Has_member && LA41_0<=Has_parent)||(LA41_0>=Is_of_type && LA41_0<=Is_process)||(LA41_0>=Direction && LA41_0<=Is_thread)||LA41_0==Analysis||(LA41_0>=Features && LA41_0<=Property)||LA41_0==As_list||(LA41_0>=Is_data && LA41_0<=Is_port)||LA41_0==Warning||(LA41_0>=Append && LA41_0<=As_set)||(LA41_0>=Exists && LA41_0<=Member)||(LA41_0>=Parent && LA41_0<=Source)||LA41_0==Debug||(LA41_0>=Error && LA41_0<=False)||LA41_0==Union||(LA41_0>=Fail && LA41_0<=Name)||(LA41_0>=Size && LA41_0<=Tail)||(LA41_0>=This && LA41_0<=Type)||(LA41_0>=Let && LA41_0<=Sum)||LA41_0==If||LA41_0==LeftParenthesis||LA41_0==HyphenMinus||LA41_0==LeftSquareBracket||LA41_0==LeftCurlyBracket||LA41_0==RULE_REAL_LIT||LA41_0==RULE_INTEGER_LIT||(LA41_0>=RULE_STRING && LA41_0<=RULE_ID)) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // InternalResoluteParser.g:3329:2: ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3329:2: ( (lv_args_53_0= ruleExpr ) )
                            // InternalResoluteParser.g:3330:1: (lv_args_53_0= ruleExpr )
                            {
                            // InternalResoluteParser.g:3330:1: (lv_args_53_0= ruleExpr )
                            // InternalResoluteParser.g:3331:3: lv_args_53_0= ruleExpr
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

                            // InternalResoluteParser.g:3347:2: (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )*
                            loop40:
                            do {
                                int alt40=2;
                                int LA40_0 = input.LA(1);

                                if ( (LA40_0==Comma) ) {
                                    alt40=1;
                                }


                                switch (alt40) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3348:2: otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) )
                            	    {
                            	    otherlv_54=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_54, grammarAccess.getAtomicExprAccess().getCommaKeyword_11_3_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3352:1: ( (lv_args_55_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3353:1: (lv_args_55_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3353:1: (lv_args_55_0= ruleExpr )
                            	    // InternalResoluteParser.g:3354:3: lv_args_55_0= ruleExpr
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
                            	    break loop40;
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
                    // InternalResoluteParser.g:3376:6: ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) )
                    {
                    // InternalResoluteParser.g:3376:6: ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) )
                    // InternalResoluteParser.g:3376:7: () ( (lv_lintStmt_58_0= ruleLintStatement ) )
                    {
                    // InternalResoluteParser.g:3376:7: ()
                    // InternalResoluteParser.g:3377:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicExprAccess().getLintExprAction_12_0(),
                                  current);
                          
                    }

                    }

                    // InternalResoluteParser.g:3382:2: ( (lv_lintStmt_58_0= ruleLintStatement ) )
                    // InternalResoluteParser.g:3383:1: (lv_lintStmt_58_0= ruleLintStatement )
                    {
                    // InternalResoluteParser.g:3383:1: (lv_lintStmt_58_0= ruleLintStatement )
                    // InternalResoluteParser.g:3384:3: lv_lintStmt_58_0= ruleLintStatement
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
                    // InternalResoluteParser.g:3401:6: (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:3401:6: (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket )
                    // InternalResoluteParser.g:3402:2: otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket
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
                    // InternalResoluteParser.g:3415:1: ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==For) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==Comma||LA45_0==RightSquareBracket) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalResoluteParser.g:3415:2: ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? )
                            {
                            // InternalResoluteParser.g:3415:2: ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? )
                            // InternalResoluteParser.g:3415:3: () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )?
                            {
                            // InternalResoluteParser.g:3415:3: ()
                            // InternalResoluteParser.g:3416:5: 
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
                            // InternalResoluteParser.g:3426:1: (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+
                            int cnt42=0;
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==LeftParenthesis) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3427:2: otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis
                            	    {
                            	    otherlv_63=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_63, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_13_2_0_2_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3431:1: ( (lv_args_64_0= ruleArg ) )
                            	    // InternalResoluteParser.g:3432:1: (lv_args_64_0= ruleArg )
                            	    {
                            	    // InternalResoluteParser.g:3432:1: (lv_args_64_0= ruleArg )
                            	    // InternalResoluteParser.g:3433:3: lv_args_64_0= ruleArg
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
                            	    if ( cnt42 >= 1 ) break loop42;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(42, input);
                                        throw eee;
                                }
                                cnt42++;
                            } while (true);

                            // InternalResoluteParser.g:3454:3: (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==VerticalLine) ) {
                                alt43=1;
                            }
                            switch (alt43) {
                                case 1 :
                                    // InternalResoluteParser.g:3455:2: otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) )
                                    {
                                    otherlv_66=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_12); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_66, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_13_2_0_3_0());
                                          
                                    }
                                    // InternalResoluteParser.g:3459:1: ( (lv_filter_67_0= ruleExpr ) )
                                    // InternalResoluteParser.g:3460:1: (lv_filter_67_0= ruleExpr )
                                    {
                                    // InternalResoluteParser.g:3460:1: (lv_filter_67_0= ruleExpr )
                                    // InternalResoluteParser.g:3461:3: lv_filter_67_0= ruleExpr
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
                            // InternalResoluteParser.g:3478:6: ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* )
                            {
                            // InternalResoluteParser.g:3478:6: ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* )
                            // InternalResoluteParser.g:3478:7: () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3478:7: ()
                            // InternalResoluteParser.g:3479:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndAdd(
                                          grammarAccess.getAtomicExprAccess().getListExprExprsAction_13_2_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalResoluteParser.g:3484:2: (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==Comma) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3485:2: otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) )
                            	    {
                            	    otherlv_69=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_69, grammarAccess.getAtomicExprAccess().getCommaKeyword_13_2_1_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3489:1: ( (lv_exprs_70_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3490:1: (lv_exprs_70_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3490:1: (lv_exprs_70_0= ruleExpr )
                            	    // InternalResoluteParser.g:3491:3: lv_exprs_70_0= ruleExpr
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
                            	    break loop44;
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
                    // InternalResoluteParser.g:3513:6: (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:3513:6: (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket )
                    // InternalResoluteParser.g:3514:2: otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket
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
                    // InternalResoluteParser.g:3527:1: ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==For) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==Comma||LA49_0==RightCurlyBracket) ) {
                        alt49=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalResoluteParser.g:3527:2: ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? )
                            {
                            // InternalResoluteParser.g:3527:2: ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? )
                            // InternalResoluteParser.g:3527:3: () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )?
                            {
                            // InternalResoluteParser.g:3527:3: ()
                            // InternalResoluteParser.g:3528:5: 
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
                            // InternalResoluteParser.g:3538:1: (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+
                            int cnt46=0;
                            loop46:
                            do {
                                int alt46=2;
                                int LA46_0 = input.LA(1);

                                if ( (LA46_0==LeftParenthesis) ) {
                                    alt46=1;
                                }


                                switch (alt46) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3539:2: otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis
                            	    {
                            	    otherlv_76=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_76, grammarAccess.getAtomicExprAccess().getLeftParenthesisKeyword_14_2_0_2_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3543:1: ( (lv_args_77_0= ruleArg ) )
                            	    // InternalResoluteParser.g:3544:1: (lv_args_77_0= ruleArg )
                            	    {
                            	    // InternalResoluteParser.g:3544:1: (lv_args_77_0= ruleArg )
                            	    // InternalResoluteParser.g:3545:3: lv_args_77_0= ruleArg
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
                            	    if ( cnt46 >= 1 ) break loop46;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(46, input);
                                        throw eee;
                                }
                                cnt46++;
                            } while (true);

                            // InternalResoluteParser.g:3566:3: (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )?
                            int alt47=2;
                            int LA47_0 = input.LA(1);

                            if ( (LA47_0==VerticalLine) ) {
                                alt47=1;
                            }
                            switch (alt47) {
                                case 1 :
                                    // InternalResoluteParser.g:3567:2: otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) )
                                    {
                                    otherlv_79=(Token)match(input,VerticalLine,FollowSets000.FOLLOW_12); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_79, grammarAccess.getAtomicExprAccess().getVerticalLineKeyword_14_2_0_3_0());
                                          
                                    }
                                    // InternalResoluteParser.g:3571:1: ( (lv_filter_80_0= ruleExpr ) )
                                    // InternalResoluteParser.g:3572:1: (lv_filter_80_0= ruleExpr )
                                    {
                                    // InternalResoluteParser.g:3572:1: (lv_filter_80_0= ruleExpr )
                                    // InternalResoluteParser.g:3573:3: lv_filter_80_0= ruleExpr
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
                            // InternalResoluteParser.g:3590:6: ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* )
                            {
                            // InternalResoluteParser.g:3590:6: ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* )
                            // InternalResoluteParser.g:3590:7: () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )*
                            {
                            // InternalResoluteParser.g:3590:7: ()
                            // InternalResoluteParser.g:3591:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndAdd(
                                          grammarAccess.getAtomicExprAccess().getSetExprExprsAction_14_2_1_0(),
                                          current);
                                  
                            }

                            }

                            // InternalResoluteParser.g:3596:2: (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )*
                            loop48:
                            do {
                                int alt48=2;
                                int LA48_0 = input.LA(1);

                                if ( (LA48_0==Comma) ) {
                                    alt48=1;
                                }


                                switch (alt48) {
                            	case 1 :
                            	    // InternalResoluteParser.g:3597:2: otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) )
                            	    {
                            	    otherlv_82=(Token)match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_82, grammarAccess.getAtomicExprAccess().getCommaKeyword_14_2_1_1_0());
                            	          
                            	    }
                            	    // InternalResoluteParser.g:3601:1: ( (lv_exprs_83_0= ruleExpr ) )
                            	    // InternalResoluteParser.g:3602:1: (lv_exprs_83_0= ruleExpr )
                            	    {
                            	    // InternalResoluteParser.g:3602:1: (lv_exprs_83_0= ruleExpr )
                            	    // InternalResoluteParser.g:3603:3: lv_exprs_83_0= ruleExpr
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
                            	    break loop48;
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
                    // InternalResoluteParser.g:3625:6: ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket )
                    {
                    // InternalResoluteParser.g:3625:6: ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket )
                    // InternalResoluteParser.g:3625:7: () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket
                    {
                    // InternalResoluteParser.g:3625:7: ()
                    // InternalResoluteParser.g:3626:5: 
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
                    // InternalResoluteParser.g:3642:6: ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket )
                    {
                    // InternalResoluteParser.g:3642:6: ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket )
                    // InternalResoluteParser.g:3642:7: () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket
                    {
                    // InternalResoluteParser.g:3642:7: ()
                    // InternalResoluteParser.g:3643:5: 
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
                    // InternalResoluteParser.g:3659:6: ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:3659:6: ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:3659:7: () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:3659:7: ()
                    // InternalResoluteParser.g:3660:5: 
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
                    // InternalResoluteParser.g:3670:1: ( (lv_binding_93_0= ruleLetBinding ) )
                    // InternalResoluteParser.g:3671:1: (lv_binding_93_0= ruleLetBinding )
                    {
                    // InternalResoluteParser.g:3671:1: (lv_binding_93_0= ruleLetBinding )
                    // InternalResoluteParser.g:3672:3: lv_binding_93_0= ruleLetBinding
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicExprAccess().getBindingLetBindingParserRuleCall_17_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_48);
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
                    // InternalResoluteParser.g:3693:1: ( (lv_expr_95_0= ruleExpr ) )
                    // InternalResoluteParser.g:3694:1: (lv_expr_95_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:3694:1: (lv_expr_95_0= ruleExpr )
                    // InternalResoluteParser.g:3695:3: lv_expr_95_0= ruleExpr
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
                    // InternalResoluteParser.g:3712:6: (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis )
                    {
                    // InternalResoluteParser.g:3712:6: (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis )
                    // InternalResoluteParser.g:3713:2: otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis
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
    // InternalResoluteParser.g:3739:1: entryRuleLetBinding returns [EObject current=null] : iv_ruleLetBinding= ruleLetBinding EOF ;
    public final EObject entryRuleLetBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetBinding = null;


        try {
            // InternalResoluteParser.g:3740:2: (iv_ruleLetBinding= ruleLetBinding EOF )
            // InternalResoluteParser.g:3741:2: iv_ruleLetBinding= ruleLetBinding EOF
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
    // InternalResoluteParser.g:3748:1: ruleLetBinding returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) ;
    public final EObject ruleLetBinding() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3751:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) ) )
            // InternalResoluteParser.g:3752:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            {
            // InternalResoluteParser.g:3752:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) ) )
            // InternalResoluteParser.g:3752:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= Colon ( (lv_type_2_0= ruleType ) ) otherlv_3= EqualsSign ( (lv_expr_4_0= ruleExpr ) )
            {
            // InternalResoluteParser.g:3752:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalResoluteParser.g:3753:1: (lv_name_0_0= RULE_ID )
            {
            // InternalResoluteParser.g:3753:1: (lv_name_0_0= RULE_ID )
            // InternalResoluteParser.g:3754:3: lv_name_0_0= RULE_ID
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
            // InternalResoluteParser.g:3775:1: ( (lv_type_2_0= ruleType ) )
            // InternalResoluteParser.g:3776:1: (lv_type_2_0= ruleType )
            {
            // InternalResoluteParser.g:3776:1: (lv_type_2_0= ruleType )
            // InternalResoluteParser.g:3777:3: lv_type_2_0= ruleType
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
            // InternalResoluteParser.g:3798:1: ( (lv_expr_4_0= ruleExpr ) )
            // InternalResoluteParser.g:3799:1: (lv_expr_4_0= ruleExpr )
            {
            // InternalResoluteParser.g:3799:1: (lv_expr_4_0= ruleExpr )
            // InternalResoluteParser.g:3800:3: lv_expr_4_0= ruleExpr
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
    // InternalResoluteParser.g:3824:1: entryRuleBuiltInFn returns [String current=null] : iv_ruleBuiltInFn= ruleBuiltInFn EOF ;
    public final String entryRuleBuiltInFn() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBuiltInFn = null;


        try {
            // InternalResoluteParser.g:3825:1: (iv_ruleBuiltInFn= ruleBuiltInFn EOF )
            // InternalResoluteParser.g:3826:2: iv_ruleBuiltInFn= ruleBuiltInFn EOF
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
    // InternalResoluteParser.g:3833:1: ruleBuiltInFn returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows ) ;
    public final AntlrDatatypeRuleToken ruleBuiltInFn() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:3837:6: ( (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows ) )
            // InternalResoluteParser.g:3838:1: (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows )
            {
            // InternalResoluteParser.g:3838:1: (kw= Has_property | kw= Property | kw= Property_member | kw= Has_parent | kw= Parent | kw= Name | kw= Type | kw= Has_type | kw= Is_in_array | kw= Has_prototypes | kw= Has_modes | kw= Is_processor | kw= Is_virtual_processor | kw= Is_system | kw= Is_bus | kw= Is_virtual_bus | kw= Is_device | kw= Is_memory | kw= Is_thread | kw= Is_thread_group | kw= Is_process | kw= Is_data | kw= Is_subprogram | kw= Is_of_type | kw= Is_bound_to | kw= Has_member | kw= Features | kw= Connections | kw= Enumerated_values | kw= Subcomponents | kw= Source | kw= Destination | kw= Is_bidirectional | kw= Direction | kw= Is_event_port | kw= Is_abstract_feature | kw= Is_data_port | kw= Is_port | kw= Is_data_access | kw= Is_bus_access | kw= Lower_bound | kw= Upper_bound | kw= Member | kw= Length | kw= Size | kw= Sum | kw= Append | kw= Head | kw= Tail | kw= As_set | kw= Union | kw= Intersect | kw= As_list | kw= Instance | kw= Instances | kw= Debug | kw= Analysis | kw= Receive_error | kw= Contain_error | kw= Propagate_error | kw= Error_state_reachable | kw= Flow_source | kw= Flow_destination | kw= Flow_elements | kw= Flow_specifications | kw= End_to_end_flows )
            int alt51=66;
            switch ( input.LA(1) ) {
            case Has_property:
                {
                alt51=1;
                }
                break;
            case Property:
                {
                alt51=2;
                }
                break;
            case Property_member:
                {
                alt51=3;
                }
                break;
            case Has_parent:
                {
                alt51=4;
                }
                break;
            case Parent:
                {
                alt51=5;
                }
                break;
            case Name:
                {
                alt51=6;
                }
                break;
            case Type:
                {
                alt51=7;
                }
                break;
            case Has_type:
                {
                alt51=8;
                }
                break;
            case Is_in_array:
                {
                alt51=9;
                }
                break;
            case Has_prototypes:
                {
                alt51=10;
                }
                break;
            case Has_modes:
                {
                alt51=11;
                }
                break;
            case Is_processor:
                {
                alt51=12;
                }
                break;
            case Is_virtual_processor:
                {
                alt51=13;
                }
                break;
            case Is_system:
                {
                alt51=14;
                }
                break;
            case Is_bus:
                {
                alt51=15;
                }
                break;
            case Is_virtual_bus:
                {
                alt51=16;
                }
                break;
            case Is_device:
                {
                alt51=17;
                }
                break;
            case Is_memory:
                {
                alt51=18;
                }
                break;
            case Is_thread:
                {
                alt51=19;
                }
                break;
            case Is_thread_group:
                {
                alt51=20;
                }
                break;
            case Is_process:
                {
                alt51=21;
                }
                break;
            case Is_data:
                {
                alt51=22;
                }
                break;
            case Is_subprogram:
                {
                alt51=23;
                }
                break;
            case Is_of_type:
                {
                alt51=24;
                }
                break;
            case Is_bound_to:
                {
                alt51=25;
                }
                break;
            case Has_member:
                {
                alt51=26;
                }
                break;
            case Features:
                {
                alt51=27;
                }
                break;
            case Connections:
                {
                alt51=28;
                }
                break;
            case Enumerated_values:
                {
                alt51=29;
                }
                break;
            case Subcomponents:
                {
                alt51=30;
                }
                break;
            case Source:
                {
                alt51=31;
                }
                break;
            case Destination:
                {
                alt51=32;
                }
                break;
            case Is_bidirectional:
                {
                alt51=33;
                }
                break;
            case Direction:
                {
                alt51=34;
                }
                break;
            case Is_event_port:
                {
                alt51=35;
                }
                break;
            case Is_abstract_feature:
                {
                alt51=36;
                }
                break;
            case Is_data_port:
                {
                alt51=37;
                }
                break;
            case Is_port:
                {
                alt51=38;
                }
                break;
            case Is_data_access:
                {
                alt51=39;
                }
                break;
            case Is_bus_access:
                {
                alt51=40;
                }
                break;
            case Lower_bound:
                {
                alt51=41;
                }
                break;
            case Upper_bound:
                {
                alt51=42;
                }
                break;
            case Member:
                {
                alt51=43;
                }
                break;
            case Length:
                {
                alt51=44;
                }
                break;
            case Size:
                {
                alt51=45;
                }
                break;
            case Sum:
                {
                alt51=46;
                }
                break;
            case Append:
                {
                alt51=47;
                }
                break;
            case Head:
                {
                alt51=48;
                }
                break;
            case Tail:
                {
                alt51=49;
                }
                break;
            case As_set:
                {
                alt51=50;
                }
                break;
            case Union:
                {
                alt51=51;
                }
                break;
            case Intersect:
                {
                alt51=52;
                }
                break;
            case As_list:
                {
                alt51=53;
                }
                break;
            case Instance:
                {
                alt51=54;
                }
                break;
            case Instances:
                {
                alt51=55;
                }
                break;
            case Debug:
                {
                alt51=56;
                }
                break;
            case Analysis:
                {
                alt51=57;
                }
                break;
            case Receive_error:
                {
                alt51=58;
                }
                break;
            case Contain_error:
                {
                alt51=59;
                }
                break;
            case Propagate_error:
                {
                alt51=60;
                }
                break;
            case Error_state_reachable:
                {
                alt51=61;
                }
                break;
            case Flow_source:
                {
                alt51=62;
                }
                break;
            case Flow_destination:
                {
                alt51=63;
                }
                break;
            case Flow_elements:
                {
                alt51=64;
                }
                break;
            case Flow_specifications:
                {
                alt51=65;
                }
                break;
            case End_to_end_flows:
                {
                alt51=66;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalResoluteParser.g:3839:2: kw= Has_property
                    {
                    kw=(Token)match(input,Has_property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_propertyKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:3846:2: kw= Property
                    {
                    kw=(Token)match(input,Property,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPropertyKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalResoluteParser.g:3853:2: kw= Property_member
                    {
                    kw=(Token)match(input,Property_member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getProperty_memberKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalResoluteParser.g:3860:2: kw= Has_parent
                    {
                    kw=(Token)match(input,Has_parent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_parentKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalResoluteParser.g:3867:2: kw= Parent
                    {
                    kw=(Token)match(input,Parent,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getParentKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalResoluteParser.g:3874:2: kw= Name
                    {
                    kw=(Token)match(input,Name,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getNameKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalResoluteParser.g:3881:2: kw= Type
                    {
                    kw=(Token)match(input,Type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTypeKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalResoluteParser.g:3888:2: kw= Has_type
                    {
                    kw=(Token)match(input,Has_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_typeKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalResoluteParser.g:3895:2: kw= Is_in_array
                    {
                    kw=(Token)match(input,Is_in_array,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_in_arrayKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalResoluteParser.g:3902:2: kw= Has_prototypes
                    {
                    kw=(Token)match(input,Has_prototypes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_prototypesKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // InternalResoluteParser.g:3909:2: kw= Has_modes
                    {
                    kw=(Token)match(input,Has_modes,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_modesKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // InternalResoluteParser.g:3916:2: kw= Is_processor
                    {
                    kw=(Token)match(input,Is_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_processorKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // InternalResoluteParser.g:3923:2: kw= Is_virtual_processor
                    {
                    kw=(Token)match(input,Is_virtual_processor,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_virtual_processorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // InternalResoluteParser.g:3930:2: kw= Is_system
                    {
                    kw=(Token)match(input,Is_system,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_systemKeyword_13()); 
                          
                    }

                    }
                    break;
                case 15 :
                    // InternalResoluteParser.g:3937:2: kw= Is_bus
                    {
                    kw=(Token)match(input,Is_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_busKeyword_14()); 
                          
                    }

                    }
                    break;
                case 16 :
                    // InternalResoluteParser.g:3944:2: kw= Is_virtual_bus
                    {
                    kw=(Token)match(input,Is_virtual_bus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_virtual_busKeyword_15()); 
                          
                    }

                    }
                    break;
                case 17 :
                    // InternalResoluteParser.g:3951:2: kw= Is_device
                    {
                    kw=(Token)match(input,Is_device,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_deviceKeyword_16()); 
                          
                    }

                    }
                    break;
                case 18 :
                    // InternalResoluteParser.g:3958:2: kw= Is_memory
                    {
                    kw=(Token)match(input,Is_memory,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_memoryKeyword_17()); 
                          
                    }

                    }
                    break;
                case 19 :
                    // InternalResoluteParser.g:3965:2: kw= Is_thread
                    {
                    kw=(Token)match(input,Is_thread,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_threadKeyword_18()); 
                          
                    }

                    }
                    break;
                case 20 :
                    // InternalResoluteParser.g:3972:2: kw= Is_thread_group
                    {
                    kw=(Token)match(input,Is_thread_group,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_thread_groupKeyword_19()); 
                          
                    }

                    }
                    break;
                case 21 :
                    // InternalResoluteParser.g:3979:2: kw= Is_process
                    {
                    kw=(Token)match(input,Is_process,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_processKeyword_20()); 
                          
                    }

                    }
                    break;
                case 22 :
                    // InternalResoluteParser.g:3986:2: kw= Is_data
                    {
                    kw=(Token)match(input,Is_data,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_dataKeyword_21()); 
                          
                    }

                    }
                    break;
                case 23 :
                    // InternalResoluteParser.g:3993:2: kw= Is_subprogram
                    {
                    kw=(Token)match(input,Is_subprogram,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_subprogramKeyword_22()); 
                          
                    }

                    }
                    break;
                case 24 :
                    // InternalResoluteParser.g:4000:2: kw= Is_of_type
                    {
                    kw=(Token)match(input,Is_of_type,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_of_typeKeyword_23()); 
                          
                    }

                    }
                    break;
                case 25 :
                    // InternalResoluteParser.g:4007:2: kw= Is_bound_to
                    {
                    kw=(Token)match(input,Is_bound_to,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bound_toKeyword_24()); 
                          
                    }

                    }
                    break;
                case 26 :
                    // InternalResoluteParser.g:4014:2: kw= Has_member
                    {
                    kw=(Token)match(input,Has_member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHas_memberKeyword_25()); 
                          
                    }

                    }
                    break;
                case 27 :
                    // InternalResoluteParser.g:4021:2: kw= Features
                    {
                    kw=(Token)match(input,Features,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFeaturesKeyword_26()); 
                          
                    }

                    }
                    break;
                case 28 :
                    // InternalResoluteParser.g:4028:2: kw= Connections
                    {
                    kw=(Token)match(input,Connections,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getConnectionsKeyword_27()); 
                          
                    }

                    }
                    break;
                case 29 :
                    // InternalResoluteParser.g:4035:2: kw= Enumerated_values
                    {
                    kw=(Token)match(input,Enumerated_values,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getEnumerated_valuesKeyword_28()); 
                          
                    }

                    }
                    break;
                case 30 :
                    // InternalResoluteParser.g:4042:2: kw= Subcomponents
                    {
                    kw=(Token)match(input,Subcomponents,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSubcomponentsKeyword_29()); 
                          
                    }

                    }
                    break;
                case 31 :
                    // InternalResoluteParser.g:4049:2: kw= Source
                    {
                    kw=(Token)match(input,Source,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSourceKeyword_30()); 
                          
                    }

                    }
                    break;
                case 32 :
                    // InternalResoluteParser.g:4056:2: kw= Destination
                    {
                    kw=(Token)match(input,Destination,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDestinationKeyword_31()); 
                          
                    }

                    }
                    break;
                case 33 :
                    // InternalResoluteParser.g:4063:2: kw= Is_bidirectional
                    {
                    kw=(Token)match(input,Is_bidirectional,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bidirectionalKeyword_32()); 
                          
                    }

                    }
                    break;
                case 34 :
                    // InternalResoluteParser.g:4070:2: kw= Direction
                    {
                    kw=(Token)match(input,Direction,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDirectionKeyword_33()); 
                          
                    }

                    }
                    break;
                case 35 :
                    // InternalResoluteParser.g:4077:2: kw= Is_event_port
                    {
                    kw=(Token)match(input,Is_event_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_event_portKeyword_34()); 
                          
                    }

                    }
                    break;
                case 36 :
                    // InternalResoluteParser.g:4084:2: kw= Is_abstract_feature
                    {
                    kw=(Token)match(input,Is_abstract_feature,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_abstract_featureKeyword_35()); 
                          
                    }

                    }
                    break;
                case 37 :
                    // InternalResoluteParser.g:4091:2: kw= Is_data_port
                    {
                    kw=(Token)match(input,Is_data_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_data_portKeyword_36()); 
                          
                    }

                    }
                    break;
                case 38 :
                    // InternalResoluteParser.g:4098:2: kw= Is_port
                    {
                    kw=(Token)match(input,Is_port,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_portKeyword_37()); 
                          
                    }

                    }
                    break;
                case 39 :
                    // InternalResoluteParser.g:4105:2: kw= Is_data_access
                    {
                    kw=(Token)match(input,Is_data_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_data_accessKeyword_38()); 
                          
                    }

                    }
                    break;
                case 40 :
                    // InternalResoluteParser.g:4112:2: kw= Is_bus_access
                    {
                    kw=(Token)match(input,Is_bus_access,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIs_bus_accessKeyword_39()); 
                          
                    }

                    }
                    break;
                case 41 :
                    // InternalResoluteParser.g:4119:2: kw= Lower_bound
                    {
                    kw=(Token)match(input,Lower_bound,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getLower_boundKeyword_40()); 
                          
                    }

                    }
                    break;
                case 42 :
                    // InternalResoluteParser.g:4126:2: kw= Upper_bound
                    {
                    kw=(Token)match(input,Upper_bound,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getUpper_boundKeyword_41()); 
                          
                    }

                    }
                    break;
                case 43 :
                    // InternalResoluteParser.g:4133:2: kw= Member
                    {
                    kw=(Token)match(input,Member,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getMemberKeyword_42()); 
                          
                    }

                    }
                    break;
                case 44 :
                    // InternalResoluteParser.g:4140:2: kw= Length
                    {
                    kw=(Token)match(input,Length,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getLengthKeyword_43()); 
                          
                    }

                    }
                    break;
                case 45 :
                    // InternalResoluteParser.g:4147:2: kw= Size
                    {
                    kw=(Token)match(input,Size,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSizeKeyword_44()); 
                          
                    }

                    }
                    break;
                case 46 :
                    // InternalResoluteParser.g:4154:2: kw= Sum
                    {
                    kw=(Token)match(input,Sum,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getSumKeyword_45()); 
                          
                    }

                    }
                    break;
                case 47 :
                    // InternalResoluteParser.g:4161:2: kw= Append
                    {
                    kw=(Token)match(input,Append,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAppendKeyword_46()); 
                          
                    }

                    }
                    break;
                case 48 :
                    // InternalResoluteParser.g:4168:2: kw= Head
                    {
                    kw=(Token)match(input,Head,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getHeadKeyword_47()); 
                          
                    }

                    }
                    break;
                case 49 :
                    // InternalResoluteParser.g:4175:2: kw= Tail
                    {
                    kw=(Token)match(input,Tail,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getTailKeyword_48()); 
                          
                    }

                    }
                    break;
                case 50 :
                    // InternalResoluteParser.g:4182:2: kw= As_set
                    {
                    kw=(Token)match(input,As_set,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAs_setKeyword_49()); 
                          
                    }

                    }
                    break;
                case 51 :
                    // InternalResoluteParser.g:4189:2: kw= Union
                    {
                    kw=(Token)match(input,Union,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getUnionKeyword_50()); 
                          
                    }

                    }
                    break;
                case 52 :
                    // InternalResoluteParser.g:4196:2: kw= Intersect
                    {
                    kw=(Token)match(input,Intersect,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getIntersectKeyword_51()); 
                          
                    }

                    }
                    break;
                case 53 :
                    // InternalResoluteParser.g:4203:2: kw= As_list
                    {
                    kw=(Token)match(input,As_list,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAs_listKeyword_52()); 
                          
                    }

                    }
                    break;
                case 54 :
                    // InternalResoluteParser.g:4210:2: kw= Instance
                    {
                    kw=(Token)match(input,Instance,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstanceKeyword_53()); 
                          
                    }

                    }
                    break;
                case 55 :
                    // InternalResoluteParser.g:4217:2: kw= Instances
                    {
                    kw=(Token)match(input,Instances,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getInstancesKeyword_54()); 
                          
                    }

                    }
                    break;
                case 56 :
                    // InternalResoluteParser.g:4224:2: kw= Debug
                    {
                    kw=(Token)match(input,Debug,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getDebugKeyword_55()); 
                          
                    }

                    }
                    break;
                case 57 :
                    // InternalResoluteParser.g:4231:2: kw= Analysis
                    {
                    kw=(Token)match(input,Analysis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getAnalysisKeyword_56()); 
                          
                    }

                    }
                    break;
                case 58 :
                    // InternalResoluteParser.g:4238:2: kw= Receive_error
                    {
                    kw=(Token)match(input,Receive_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getReceive_errorKeyword_57()); 
                          
                    }

                    }
                    break;
                case 59 :
                    // InternalResoluteParser.g:4245:2: kw= Contain_error
                    {
                    kw=(Token)match(input,Contain_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getContain_errorKeyword_58()); 
                          
                    }

                    }
                    break;
                case 60 :
                    // InternalResoluteParser.g:4252:2: kw= Propagate_error
                    {
                    kw=(Token)match(input,Propagate_error,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getPropagate_errorKeyword_59()); 
                          
                    }

                    }
                    break;
                case 61 :
                    // InternalResoluteParser.g:4259:2: kw= Error_state_reachable
                    {
                    kw=(Token)match(input,Error_state_reachable,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getError_state_reachableKeyword_60()); 
                          
                    }

                    }
                    break;
                case 62 :
                    // InternalResoluteParser.g:4266:2: kw= Flow_source
                    {
                    kw=(Token)match(input,Flow_source,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_sourceKeyword_61()); 
                          
                    }

                    }
                    break;
                case 63 :
                    // InternalResoluteParser.g:4273:2: kw= Flow_destination
                    {
                    kw=(Token)match(input,Flow_destination,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_destinationKeyword_62()); 
                          
                    }

                    }
                    break;
                case 64 :
                    // InternalResoluteParser.g:4280:2: kw= Flow_elements
                    {
                    kw=(Token)match(input,Flow_elements,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_elementsKeyword_63()); 
                          
                    }

                    }
                    break;
                case 65 :
                    // InternalResoluteParser.g:4287:2: kw= Flow_specifications
                    {
                    kw=(Token)match(input,Flow_specifications,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getFlow_specificationsKeyword_64()); 
                          
                    }

                    }
                    break;
                case 66 :
                    // InternalResoluteParser.g:4294:2: kw= End_to_end_flows
                    {
                    kw=(Token)match(input,End_to_end_flows,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBuiltInFnAccess().getEnd_to_end_flowsKeyword_65()); 
                          
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
    // InternalResoluteParser.g:4307:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalResoluteParser.g:4308:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalResoluteParser.g:4309:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalResoluteParser.g:4316:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4319:28: ( ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalResoluteParser.g:4320:1: ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalResoluteParser.g:4320:1: ( ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalResoluteParser.g:4320:2: ( (lv_value_0_0= ruleUnsignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalResoluteParser.g:4320:2: ( (lv_value_0_0= ruleUnsignedReal ) )
            // InternalResoluteParser.g:4321:1: (lv_value_0_0= ruleUnsignedReal )
            {
            // InternalResoluteParser.g:4321:1: (lv_value_0_0= ruleUnsignedReal )
            // InternalResoluteParser.g:4322:3: lv_value_0_0= ruleUnsignedReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealTermAccess().getValueUnsignedRealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_49);
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

            // InternalResoluteParser.g:4338:2: ( (otherlv_1= RULE_ID ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==EOF||LA52_1==Instanceof||(LA52_1>=Andthen && LA52_1<=Applies)||(LA52_1>=Ruleset && LA52_1<=Warning)||LA52_1==Orelse||LA52_1==Check||(LA52_1>=Delta && LA52_1<=Error)||LA52_1==Prove||LA52_1==Else||LA52_1==Info||LA52_1==Then||LA52_1==And||LA52_1==For||LA52_1==FullStopFullStop||(LA52_1>=LessThanSignEqualsSign && LA52_1<=GreaterThanSignEqualsSign)||(LA52_1>=In && LA52_1<=Or)||LA52_1==PercentSign||(LA52_1>=RightParenthesis && LA52_1<=HyphenMinus)||LA52_1==Solidus||(LA52_1>=Semicolon && LA52_1<=GreaterThanSign)||(LA52_1>=RightSquareBracket && LA52_1<=CircumflexAccent)||LA52_1==RightCurlyBracket||LA52_1==RULE_ID) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalResoluteParser.g:4339:1: (otherlv_1= RULE_ID )
                    {
                    // InternalResoluteParser.g:4339:1: (otherlv_1= RULE_ID )
                    // InternalResoluteParser.g:4340:3: otherlv_1= RULE_ID
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
    // InternalResoluteParser.g:4359:1: entryRuleUnsignedReal returns [String current=null] : iv_ruleUnsignedReal= ruleUnsignedReal EOF ;
    public final String entryRuleUnsignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnsignedReal = null;


        try {
            // InternalResoluteParser.g:4360:1: (iv_ruleUnsignedReal= ruleUnsignedReal EOF )
            // InternalResoluteParser.g:4361:2: iv_ruleUnsignedReal= ruleUnsignedReal EOF
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
    // InternalResoluteParser.g:4368:1: ruleUnsignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleUnsignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4372:6: (this_REAL_LIT_0= RULE_REAL_LIT )
            // InternalResoluteParser.g:4373:5: this_REAL_LIT_0= RULE_REAL_LIT
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
    // InternalResoluteParser.g:4388:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalResoluteParser.g:4389:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalResoluteParser.g:4390:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalResoluteParser.g:4397:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4400:28: ( ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalResoluteParser.g:4401:1: ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalResoluteParser.g:4401:1: ( ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalResoluteParser.g:4401:2: ( (lv_value_0_0= ruleUnsignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalResoluteParser.g:4401:2: ( (lv_value_0_0= ruleUnsignedInt ) )
            // InternalResoluteParser.g:4402:1: (lv_value_0_0= ruleUnsignedInt )
            {
            // InternalResoluteParser.g:4402:1: (lv_value_0_0= ruleUnsignedInt )
            // InternalResoluteParser.g:4403:3: lv_value_0_0= ruleUnsignedInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueUnsignedIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_49);
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

            // InternalResoluteParser.g:4419:2: ( (otherlv_1= RULE_ID ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==EOF||LA53_1==Instanceof||(LA53_1>=Andthen && LA53_1<=Applies)||(LA53_1>=Ruleset && LA53_1<=Warning)||LA53_1==Orelse||LA53_1==Check||(LA53_1>=Delta && LA53_1<=Error)||LA53_1==Prove||LA53_1==Else||LA53_1==Info||LA53_1==Then||LA53_1==And||LA53_1==For||LA53_1==FullStopFullStop||(LA53_1>=LessThanSignEqualsSign && LA53_1<=GreaterThanSignEqualsSign)||(LA53_1>=In && LA53_1<=Or)||LA53_1==PercentSign||(LA53_1>=RightParenthesis && LA53_1<=HyphenMinus)||LA53_1==Solidus||(LA53_1>=Semicolon && LA53_1<=GreaterThanSign)||(LA53_1>=RightSquareBracket && LA53_1<=CircumflexAccent)||LA53_1==RightCurlyBracket||LA53_1==RULE_ID) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalResoluteParser.g:4420:1: (otherlv_1= RULE_ID )
                    {
                    // InternalResoluteParser.g:4420:1: (otherlv_1= RULE_ID )
                    // InternalResoluteParser.g:4421:3: otherlv_1= RULE_ID
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
    // InternalResoluteParser.g:4440:1: entryRuleUnsignedInt returns [String current=null] : iv_ruleUnsignedInt= ruleUnsignedInt EOF ;
    public final String entryRuleUnsignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnsignedInt = null;


        try {
            // InternalResoluteParser.g:4441:1: (iv_ruleUnsignedInt= ruleUnsignedInt EOF )
            // InternalResoluteParser.g:4442:2: iv_ruleUnsignedInt= ruleUnsignedInt EOF
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
    // InternalResoluteParser.g:4449:1: ruleUnsignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleUnsignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4453:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalResoluteParser.g:4454:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalResoluteParser.g:4469:1: entryRuleResoluteSubclause returns [EObject current=null] : iv_ruleResoluteSubclause= ruleResoluteSubclause EOF ;
    public final EObject entryRuleResoluteSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResoluteSubclause = null;


        try {
            // InternalResoluteParser.g:4470:2: (iv_ruleResoluteSubclause= ruleResoluteSubclause EOF )
            // InternalResoluteParser.g:4471:2: iv_ruleResoluteSubclause= ruleResoluteSubclause EOF
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
    // InternalResoluteParser.g:4478:1: ruleResoluteSubclause returns [EObject current=null] : ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* ) ;
    public final EObject ruleResoluteSubclause() throws RecognitionException {
        EObject current = null;

        EObject lv_proves_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4481:28: ( ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* ) )
            // InternalResoluteParser.g:4482:1: ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* )
            {
            // InternalResoluteParser.g:4482:1: ( () ( (lv_proves_1_0= ruleAnalysisStatement ) )* )
            // InternalResoluteParser.g:4482:2: () ( (lv_proves_1_0= ruleAnalysisStatement ) )*
            {
            // InternalResoluteParser.g:4482:2: ()
            // InternalResoluteParser.g:4483:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getResoluteSubclauseAccess().getResoluteSubclauseAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:4488:2: ( (lv_proves_1_0= ruleAnalysisStatement ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==Check||LA54_0==Prove) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalResoluteParser.g:4489:1: (lv_proves_1_0= ruleAnalysisStatement )
            	    {
            	    // InternalResoluteParser.g:4489:1: (lv_proves_1_0= ruleAnalysisStatement )
            	    // InternalResoluteParser.g:4490:3: lv_proves_1_0= ruleAnalysisStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getResoluteSubclauseAccess().getProvesAnalysisStatementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_50);
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
            	    break loop54;
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
    // InternalResoluteParser.g:4514:1: entryRuleNestedDotID returns [EObject current=null] : iv_ruleNestedDotID= ruleNestedDotID EOF ;
    public final EObject entryRuleNestedDotID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedDotID = null;


        try {
            // InternalResoluteParser.g:4515:2: (iv_ruleNestedDotID= ruleNestedDotID EOF )
            // InternalResoluteParser.g:4516:2: iv_ruleNestedDotID= ruleNestedDotID EOF
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
    // InternalResoluteParser.g:4523:1: ruleNestedDotID returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? ) ;
    public final EObject ruleNestedDotID() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_sub_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4526:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? ) )
            // InternalResoluteParser.g:4527:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? )
            {
            // InternalResoluteParser.g:4527:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )? )
            // InternalResoluteParser.g:4527:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )?
            {
            // InternalResoluteParser.g:4527:2: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:4528:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:4528:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:4529:3: otherlv_0= RULE_ID
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

            // InternalResoluteParser.g:4540:2: (otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==FullStop) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalResoluteParser.g:4541:2: otherlv_1= FullStop ( (lv_sub_2_0= ruleNestedDotID ) )
                    {
                    otherlv_1=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNestedDotIDAccess().getFullStopKeyword_1_0());
                          
                    }
                    // InternalResoluteParser.g:4545:1: ( (lv_sub_2_0= ruleNestedDotID ) )
                    // InternalResoluteParser.g:4546:1: (lv_sub_2_0= ruleNestedDotID )
                    {
                    // InternalResoluteParser.g:4546:1: (lv_sub_2_0= ruleNestedDotID )
                    // InternalResoluteParser.g:4547:3: lv_sub_2_0= ruleNestedDotID
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
    // InternalResoluteParser.g:4571:1: entryRuleLintStatement returns [EObject current=null] : iv_ruleLintStatement= ruleLintStatement EOF ;
    public final EObject entryRuleLintStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLintStatement = null;


        try {
            // InternalResoluteParser.g:4572:2: (iv_ruleLintStatement= ruleLintStatement EOF )
            // InternalResoluteParser.g:4573:2: iv_ruleLintStatement= ruleLintStatement EOF
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
    // InternalResoluteParser.g:4580:1: ruleLintStatement returns [EObject current=null] : ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) ) ;
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
            // InternalResoluteParser.g:4583:28: ( ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:4584:1: ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:4584:1: ( ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) ) | ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) ) )
            int alt56=3;
            switch ( input.LA(1) ) {
            case Warning:
                {
                alt56=1;
                }
                break;
            case Error:
                {
                alt56=2;
                }
                break;
            case Info:
                {
                alt56=3;
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
                    // InternalResoluteParser.g:4584:2: ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4584:2: ( () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4584:3: () otherlv_1= Warning ( (lv_expr_2_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4584:3: ()
                    // InternalResoluteParser.g:4585:5: 
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
                    // InternalResoluteParser.g:4595:1: ( (lv_expr_2_0= ruleExpr ) )
                    // InternalResoluteParser.g:4596:1: (lv_expr_2_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4596:1: (lv_expr_2_0= ruleExpr )
                    // InternalResoluteParser.g:4597:3: lv_expr_2_0= ruleExpr
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
                    // InternalResoluteParser.g:4614:6: ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4614:6: ( () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4614:7: () otherlv_4= Error ( (lv_expr_5_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4614:7: ()
                    // InternalResoluteParser.g:4615:5: 
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
                    // InternalResoluteParser.g:4625:1: ( (lv_expr_5_0= ruleExpr ) )
                    // InternalResoluteParser.g:4626:1: (lv_expr_5_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4626:1: (lv_expr_5_0= ruleExpr )
                    // InternalResoluteParser.g:4627:3: lv_expr_5_0= ruleExpr
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
                    // InternalResoluteParser.g:4644:6: ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4644:6: ( () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4644:7: () otherlv_7= Info ( (lv_expr_8_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4644:7: ()
                    // InternalResoluteParser.g:4645:5: 
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
                    // InternalResoluteParser.g:4655:1: ( (lv_expr_8_0= ruleExpr ) )
                    // InternalResoluteParser.g:4656:1: (lv_expr_8_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4656:1: (lv_expr_8_0= ruleExpr )
                    // InternalResoluteParser.g:4657:3: lv_expr_8_0= ruleExpr
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
    // InternalResoluteParser.g:4681:1: entryRuleRuleset returns [EObject current=null] : iv_ruleRuleset= ruleRuleset EOF ;
    public final EObject entryRuleRuleset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleset = null;


        try {
            // InternalResoluteParser.g:4682:2: (iv_ruleRuleset= ruleRuleset EOF )
            // InternalResoluteParser.g:4683:2: iv_ruleRuleset= ruleRuleset EOF
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
    // InternalResoluteParser.g:4690:1: ruleRuleset returns [EObject current=null] : (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket ) ;
    public final EObject ruleRuleset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4693:28: ( (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket ) )
            // InternalResoluteParser.g:4694:1: (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket )
            {
            // InternalResoluteParser.g:4694:1: (otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket )
            // InternalResoluteParser.g:4695:2: otherlv_0= Ruleset ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftCurlyBracket ( (lv_body_3_0= ruleRulesetBody ) ) otherlv_4= RightCurlyBracket
            {
            otherlv_0=(Token)match(input,Ruleset,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRulesetAccess().getRulesetKeyword_0());
                  
            }
            // InternalResoluteParser.g:4699:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalResoluteParser.g:4700:1: (lv_name_1_0= RULE_ID )
            {
            // InternalResoluteParser.g:4700:1: (lv_name_1_0= RULE_ID )
            // InternalResoluteParser.g:4701:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_51); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRulesetAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalResoluteParser.g:4722:1: ( (lv_body_3_0= ruleRulesetBody ) )
            // InternalResoluteParser.g:4723:1: (lv_body_3_0= ruleRulesetBody )
            {
            // InternalResoluteParser.g:4723:1: (lv_body_3_0= ruleRulesetBody )
            // InternalResoluteParser.g:4724:3: lv_body_3_0= ruleRulesetBody
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
    // InternalResoluteParser.g:4753:1: entryRuleRulesetBody returns [EObject current=null] : iv_ruleRulesetBody= ruleRulesetBody EOF ;
    public final EObject entryRuleRulesetBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRulesetBody = null;


        try {
            // InternalResoluteParser.g:4754:2: (iv_ruleRulesetBody= ruleRulesetBody EOF )
            // InternalResoluteParser.g:4755:2: iv_ruleRulesetBody= ruleRulesetBody EOF
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
    // InternalResoluteParser.g:4762:1: ruleRulesetBody returns [EObject current=null] : ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* ) ;
    public final EObject ruleRulesetBody() throws RecognitionException {
        EObject current = null;

        EObject lv_lintStatements_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4765:28: ( ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* ) )
            // InternalResoluteParser.g:4766:1: ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* )
            {
            // InternalResoluteParser.g:4766:1: ( () ( (lv_lintStatements_1_0= ruleLintStatement ) )* )
            // InternalResoluteParser.g:4766:2: () ( (lv_lintStatements_1_0= ruleLintStatement ) )*
            {
            // InternalResoluteParser.g:4766:2: ()
            // InternalResoluteParser.g:4767:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRulesetBodyAccess().getRulesetBodyAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:4772:2: ( (lv_lintStatements_1_0= ruleLintStatement ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==Warning||LA57_0==Error||LA57_0==Info) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalResoluteParser.g:4773:1: (lv_lintStatements_1_0= ruleLintStatement )
            	    {
            	    // InternalResoluteParser.g:4773:1: (lv_lintStatements_1_0= ruleLintStatement )
            	    // InternalResoluteParser.g:4774:3: lv_lintStatements_1_0= ruleLintStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRulesetBodyAccess().getLintStatementsLintStatementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_53);
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
            	    break loop57;
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
    // InternalResoluteParser.g:4798:1: entryRuleAnalysisStatement returns [EObject current=null] : iv_ruleAnalysisStatement= ruleAnalysisStatement EOF ;
    public final EObject entryRuleAnalysisStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnalysisStatement = null;


        try {
            // InternalResoluteParser.g:4799:2: (iv_ruleAnalysisStatement= ruleAnalysisStatement EOF )
            // InternalResoluteParser.g:4800:2: iv_ruleAnalysisStatement= ruleAnalysisStatement EOF
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
    // InternalResoluteParser.g:4807:1: ruleAnalysisStatement returns [EObject current=null] : ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) ) ;
    public final EObject ruleAnalysisStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expr_2_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:4810:28: ( ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) ) )
            // InternalResoluteParser.g:4811:1: ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) )
            {
            // InternalResoluteParser.g:4811:1: ( ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) ) | ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==Prove) ) {
                alt58=1;
            }
            else if ( (LA58_0==Check) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalResoluteParser.g:4811:2: ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4811:2: ( () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4811:3: () otherlv_1= Prove ( (lv_expr_2_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4811:3: ()
                    // InternalResoluteParser.g:4812:5: 
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
                    // InternalResoluteParser.g:4822:1: ( (lv_expr_2_0= ruleExpr ) )
                    // InternalResoluteParser.g:4823:1: (lv_expr_2_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4823:1: (lv_expr_2_0= ruleExpr )
                    // InternalResoluteParser.g:4824:3: lv_expr_2_0= ruleExpr
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
                    // InternalResoluteParser.g:4841:6: ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) )
                    {
                    // InternalResoluteParser.g:4841:6: ( () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) ) )
                    // InternalResoluteParser.g:4841:7: () otherlv_4= Check ( (lv_expr_5_0= ruleExpr ) )
                    {
                    // InternalResoluteParser.g:4841:7: ()
                    // InternalResoluteParser.g:4842:5: 
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
                    // InternalResoluteParser.g:4852:1: ( (lv_expr_5_0= ruleExpr ) )
                    // InternalResoluteParser.g:4853:1: (lv_expr_5_0= ruleExpr )
                    {
                    // InternalResoluteParser.g:4853:1: (lv_expr_5_0= ruleExpr )
                    // InternalResoluteParser.g:4854:3: lv_expr_5_0= ruleExpr
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
    // InternalResoluteParser.g:4880:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalResoluteParser.g:4881:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalResoluteParser.g:4882:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalResoluteParser.g:4889:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) ;
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
            // InternalResoluteParser.g:4892:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon ) )
            // InternalResoluteParser.g:4893:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            {
            // InternalResoluteParser.g:4893:1: ( ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon )
            // InternalResoluteParser.g:4893:2: ( ( ruleQPREF ) ) (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) ) ( (lv_constant_3_0= Constant ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )? otherlv_15= Semicolon
            {
            // InternalResoluteParser.g:4893:2: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:4894:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:4894:1: ( ruleQPREF )
            // InternalResoluteParser.g:4895:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_54);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalResoluteParser.g:4909:2: (otherlv_1= EqualsSignGreaterThanSign | ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==EqualsSignGreaterThanSign) ) {
                alt59=1;
            }
            else if ( (LA59_0==PlusSignEqualsSignGreaterThanSign) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalResoluteParser.g:4910:2: otherlv_1= EqualsSignGreaterThanSign
                    {
                    otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:4915:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    {
                    // InternalResoluteParser.g:4915:6: ( (lv_append_2_0= PlusSignEqualsSignGreaterThanSign ) )
                    // InternalResoluteParser.g:4916:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    {
                    // InternalResoluteParser.g:4916:1: (lv_append_2_0= PlusSignEqualsSignGreaterThanSign )
                    // InternalResoluteParser.g:4917:3: lv_append_2_0= PlusSignEqualsSignGreaterThanSign
                    {
                    lv_append_2_0=(Token)match(input,PlusSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_55); if (state.failed) return current;
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

            // InternalResoluteParser.g:4931:3: ( (lv_constant_3_0= Constant ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==Constant) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalResoluteParser.g:4932:1: (lv_constant_3_0= Constant )
                    {
                    // InternalResoluteParser.g:4932:1: (lv_constant_3_0= Constant )
                    // InternalResoluteParser.g:4933:3: lv_constant_3_0= Constant
                    {
                    lv_constant_3_0=(Token)match(input,Constant,FollowSets000.FOLLOW_55); if (state.failed) return current;
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

            // InternalResoluteParser.g:4947:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalResoluteParser.g:4947:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalResoluteParser.g:4947:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalResoluteParser.g:4948:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalResoluteParser.g:4948:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalResoluteParser.g:4949:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_56);
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

            // InternalResoluteParser.g:4965:2: (otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==Comma) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalResoluteParser.g:4966:2: otherlv_5= Comma ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_55); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	          
            	    }
            	    // InternalResoluteParser.g:4970:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalResoluteParser.g:4971:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalResoluteParser.g:4971:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalResoluteParser.g:4972:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_56);
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
            	    break loop61;
                }
            } while (true);


            }

            // InternalResoluteParser.g:4988:5: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==Applies) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalResoluteParser.g:4989:5: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
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
                    // InternalResoluteParser.g:4996:1: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalResoluteParser.g:4997:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalResoluteParser.g:4997:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalResoluteParser.g:4998:3: lv_appliesTo_8_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_57);
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

                    // InternalResoluteParser.g:5014:2: (otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==Comma) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalResoluteParser.g:5015:2: otherlv_9= Comma ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:5019:1: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalResoluteParser.g:5020:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalResoluteParser.g:5020:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalResoluteParser.g:5021:3: lv_appliesTo_10_0= ruleContainmentPath
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_57);
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
                    	    break loop62;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalResoluteParser.g:5037:6: ( ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==In) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalResoluteParser.g:5038:5: ruleInBindingKeywords otherlv_12= LeftParenthesis ( ( ruleQCREF ) ) otherlv_14= RightParenthesis
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
                    // InternalResoluteParser.g:5050:1: ( ( ruleQCREF ) )
                    // InternalResoluteParser.g:5051:1: ( ruleQCREF )
                    {
                    // InternalResoluteParser.g:5051:1: ( ruleQCREF )
                    // InternalResoluteParser.g:5052:3: ruleQCREF
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

                    otherlv_14=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_48); if (state.failed) return current;
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
    // InternalResoluteParser.g:5088:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalResoluteParser.g:5089:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalResoluteParser.g:5090:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalResoluteParser.g:5097:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5100:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalResoluteParser.g:5101:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalResoluteParser.g:5101:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalResoluteParser.g:5102:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalResoluteParser.g:5102:1: (lv_path_0_0= ruleContainmentPathElement )
            // InternalResoluteParser.g:5103:3: lv_path_0_0= ruleContainmentPathElement
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
    // InternalResoluteParser.g:5129:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalResoluteParser.g:5130:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalResoluteParser.g:5131:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalResoluteParser.g:5138:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) ;
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
            // InternalResoluteParser.g:5141:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? ) )
            // InternalResoluteParser.g:5142:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            {
            // InternalResoluteParser.g:5142:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )? )
            // InternalResoluteParser.g:5142:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            {
            // InternalResoluteParser.g:5142:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:5143:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:5143:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalResoluteParser.g:5144:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_58);
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

            // InternalResoluteParser.g:5160:2: ( ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==In) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==Modes) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // InternalResoluteParser.g:5161:5: ruleInModesKeywords otherlv_2= LeftParenthesis ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* otherlv_6= RightParenthesis
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
                    // InternalResoluteParser.g:5173:1: ( (otherlv_3= RULE_ID ) )
                    // InternalResoluteParser.g:5174:1: (otherlv_3= RULE_ID )
                    {
                    // InternalResoluteParser.g:5174:1: (otherlv_3= RULE_ID )
                    // InternalResoluteParser.g:5175:3: otherlv_3= RULE_ID
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

                    // InternalResoluteParser.g:5186:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==Comma) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalResoluteParser.g:5187:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_3_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:5191:1: ( (otherlv_5= RULE_ID ) )
                    	    // InternalResoluteParser.g:5192:1: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalResoluteParser.g:5192:1: (otherlv_5= RULE_ID )
                    	    // InternalResoluteParser.g:5193:3: otherlv_5= RULE_ID
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
                    	    break loop65;
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
    // InternalResoluteParser.g:5217:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalResoluteParser.g:5218:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalResoluteParser.g:5219:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalResoluteParser.g:5226:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5229:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalResoluteParser.g:5230:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalResoluteParser.g:5230:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:5231:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:5231:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalResoluteParser.g:5232:3: lv_ownedValue_0_0= rulePropertyExpression
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
    // InternalResoluteParser.g:5256:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalResoluteParser.g:5257:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalResoluteParser.g:5258:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalResoluteParser.g:5265:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
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
            // InternalResoluteParser.g:5268:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // InternalResoluteParser.g:5269:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // InternalResoluteParser.g:5269:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt67=11;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // InternalResoluteParser.g:5270:5: this_RecordTerm_0= ruleRecordTerm
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
                    // InternalResoluteParser.g:5280:5: this_ReferenceTerm_1= ruleReferenceTerm
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
                    // InternalResoluteParser.g:5290:5: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
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
                    // InternalResoluteParser.g:5300:5: this_ComputedTerm_3= ruleComputedTerm
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
                    // InternalResoluteParser.g:5310:5: this_StringTerm_4= ruleStringTerm
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
                    // InternalResoluteParser.g:5320:5: this_NumericRangeTerm_5= ruleNumericRangeTerm
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
                    // InternalResoluteParser.g:5330:5: this_RealTerm_6= ruleRealTerm
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
                    // InternalResoluteParser.g:5340:5: this_IntegerTerm_7= ruleIntegerTerm
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
                    // InternalResoluteParser.g:5350:5: this_ListTerm_8= ruleListTerm
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
                    // InternalResoluteParser.g:5360:5: this_BooleanLiteral_9= ruleBooleanLiteral
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
                    // InternalResoluteParser.g:5370:5: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
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
    // InternalResoluteParser.g:5386:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalResoluteParser.g:5387:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalResoluteParser.g:5388:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
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
    // InternalResoluteParser.g:5395:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5398:28: ( ( ( ruleQPREF ) ) )
            // InternalResoluteParser.g:5399:1: ( ( ruleQPREF ) )
            {
            // InternalResoluteParser.g:5399:1: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:5400:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:5400:1: ( ruleQPREF )
            // InternalResoluteParser.g:5401:3: ruleQPREF
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
    // InternalResoluteParser.g:5423:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalResoluteParser.g:5424:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalResoluteParser.g:5425:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalResoluteParser.g:5432:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5435:28: ( ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) ) )
            // InternalResoluteParser.g:5436:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            {
            // InternalResoluteParser.g:5436:1: ( () ( ( (lv_value_1_0= True ) ) | otherlv_2= False ) )
            // InternalResoluteParser.g:5436:2: () ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            {
            // InternalResoluteParser.g:5436:2: ()
            // InternalResoluteParser.g:5437:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // InternalResoluteParser.g:5442:2: ( ( (lv_value_1_0= True ) ) | otherlv_2= False )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==True) ) {
                alt68=1;
            }
            else if ( (LA68_0==False) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalResoluteParser.g:5442:3: ( (lv_value_1_0= True ) )
                    {
                    // InternalResoluteParser.g:5442:3: ( (lv_value_1_0= True ) )
                    // InternalResoluteParser.g:5443:1: (lv_value_1_0= True )
                    {
                    // InternalResoluteParser.g:5443:1: (lv_value_1_0= True )
                    // InternalResoluteParser.g:5444:3: lv_value_1_0= True
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
                    // InternalResoluteParser.g:5460:2: otherlv_2= False
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
    // InternalResoluteParser.g:5472:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalResoluteParser.g:5473:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalResoluteParser.g:5474:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalResoluteParser.g:5481:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5484:28: ( ( ( ruleQPREF ) ) )
            // InternalResoluteParser.g:5485:1: ( ( ruleQPREF ) )
            {
            // InternalResoluteParser.g:5485:1: ( ( ruleQPREF ) )
            // InternalResoluteParser.g:5486:1: ( ruleQPREF )
            {
            // InternalResoluteParser.g:5486:1: ( ruleQPREF )
            // InternalResoluteParser.g:5487:3: ruleQPREF
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
    // InternalResoluteParser.g:5509:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalResoluteParser.g:5510:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalResoluteParser.g:5511:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
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
    // InternalResoluteParser.g:5518:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5521:28: ( (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:5522:1: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:5522:1: (otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:5523:2: otherlv_0= Reference otherlv_1= LeftParenthesis ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Reference,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:5532:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalResoluteParser.g:5533:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalResoluteParser.g:5533:1: (lv_path_2_0= ruleContainmentPathElement )
            // InternalResoluteParser.g:5534:3: lv_path_2_0= ruleContainmentPathElement
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
    // InternalResoluteParser.g:5563:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalResoluteParser.g:5564:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalResoluteParser.g:5565:2: iv_ruleRecordTerm= ruleRecordTerm EOF
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
    // InternalResoluteParser.g:5572:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5575:28: ( (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket ) )
            // InternalResoluteParser.g:5576:1: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            {
            // InternalResoluteParser.g:5576:1: (otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket )
            // InternalResoluteParser.g:5577:2: otherlv_0= LeftSquareBracket ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= RightSquareBracket
            {
            otherlv_0=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // InternalResoluteParser.g:5581:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt69=0;
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_ID) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalResoluteParser.g:5582:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalResoluteParser.g:5582:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalResoluteParser.g:5583:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_59);
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
            	    if ( cnt69 >= 1 ) break loop69;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(69, input);
                        throw eee;
                }
                cnt69++;
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
    // InternalResoluteParser.g:5614:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalResoluteParser.g:5615:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalResoluteParser.g:5616:2: iv_ruleComputedTerm= ruleComputedTerm EOF
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
    // InternalResoluteParser.g:5623:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5626:28: ( (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:5627:1: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:5627:1: (otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:5628:2: otherlv_0= Compute otherlv_1= LeftParenthesis ( (lv_function_2_0= RULE_ID ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Compute,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:5637:1: ( (lv_function_2_0= RULE_ID ) )
            // InternalResoluteParser.g:5638:1: (lv_function_2_0= RULE_ID )
            {
            // InternalResoluteParser.g:5638:1: (lv_function_2_0= RULE_ID )
            // InternalResoluteParser.g:5639:3: lv_function_2_0= RULE_ID
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
    // InternalResoluteParser.g:5668:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalResoluteParser.g:5669:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalResoluteParser.g:5670:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
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
    // InternalResoluteParser.g:5677:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5680:28: ( (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis ) )
            // InternalResoluteParser.g:5681:1: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            {
            // InternalResoluteParser.g:5681:1: (otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis )
            // InternalResoluteParser.g:5682:2: otherlv_0= Classifier otherlv_1= LeftParenthesis ( ( ruleQCREF ) ) otherlv_3= RightParenthesis
            {
            otherlv_0=(Token)match(input,Classifier,FollowSets000.FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:5691:1: ( ( ruleQCREF ) )
            // InternalResoluteParser.g:5692:1: ( ruleQCREF )
            {
            // InternalResoluteParser.g:5692:1: ( ruleQCREF )
            // InternalResoluteParser.g:5693:3: ruleQCREF
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
    // InternalResoluteParser.g:5720:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalResoluteParser.g:5721:2: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalResoluteParser.g:5722:2: iv_ruleListTerm= ruleListTerm EOF
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
    // InternalResoluteParser.g:5729:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5732:28: ( ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis ) )
            // InternalResoluteParser.g:5733:1: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            {
            // InternalResoluteParser.g:5733:1: ( () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis )
            // InternalResoluteParser.g:5733:2: () otherlv_1= LeftParenthesis ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= RightParenthesis
            {
            // InternalResoluteParser.g:5733:2: ()
            // InternalResoluteParser.g:5734:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getListTermAccess().getListValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalResoluteParser.g:5744:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==Classifier||LA71_0==Reference||LA71_0==Compute||LA71_0==False||LA71_0==True||LA71_0==LeftParenthesis||LA71_0==PlusSign||LA71_0==HyphenMinus||LA71_0==LeftSquareBracket||LA71_0==RULE_REAL_LIT||LA71_0==RULE_INTEGER_LIT||(LA71_0>=RULE_STRING && LA71_0<=RULE_ID)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalResoluteParser.g:5744:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalResoluteParser.g:5744:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalResoluteParser.g:5745:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalResoluteParser.g:5745:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalResoluteParser.g:5746:3: lv_ownedListElement_2_0= rulePropertyExpression
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

                    // InternalResoluteParser.g:5762:2: (otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==Comma) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalResoluteParser.g:5763:2: otherlv_3= Comma ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FollowSets000.FOLLOW_55); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalResoluteParser.g:5767:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalResoluteParser.g:5768:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalResoluteParser.g:5768:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalResoluteParser.g:5769:3: lv_ownedListElement_4_0= rulePropertyExpression
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
                    	    break loop70;
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
    // InternalResoluteParser.g:5798:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalResoluteParser.g:5799:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalResoluteParser.g:5800:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalResoluteParser.g:5807:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5810:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon ) )
            // InternalResoluteParser.g:5811:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            {
            // InternalResoluteParser.g:5811:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon )
            // InternalResoluteParser.g:5811:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= EqualsSignGreaterThanSign ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= Semicolon
            {
            // InternalResoluteParser.g:5811:2: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:5812:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:5812:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:5813:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_61); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,EqualsSignGreaterThanSign,FollowSets000.FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // InternalResoluteParser.g:5829:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalResoluteParser.g:5830:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalResoluteParser.g:5830:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalResoluteParser.g:5831:3: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_48);
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
    // InternalResoluteParser.g:5860:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalResoluteParser.g:5861:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalResoluteParser.g:5862:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalResoluteParser.g:5869:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5872:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalResoluteParser.g:5873:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalResoluteParser.g:5873:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalResoluteParser.g:5873:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* ) (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalResoluteParser.g:5873:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )* )
            // InternalResoluteParser.g:5873:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            {
            // InternalResoluteParser.g:5873:3: ( (otherlv_0= RULE_ID ) )
            // InternalResoluteParser.g:5874:1: (otherlv_0= RULE_ID )
            {
            // InternalResoluteParser.g:5874:1: (otherlv_0= RULE_ID )
            // InternalResoluteParser.g:5875:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); 
              	
            }

            }


            }

            // InternalResoluteParser.g:5886:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==LeftSquareBracket) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalResoluteParser.g:5887:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    {
            	    // InternalResoluteParser.g:5887:1: (lv_arrayRange_1_0= ruleArrayRange )
            	    // InternalResoluteParser.g:5888:3: lv_arrayRange_1_0= ruleArrayRange
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_62);
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
            	    break loop72;
                }
            } while (true);


            }

            // InternalResoluteParser.g:5904:4: (otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==FullStop) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalResoluteParser.g:5905:2: otherlv_2= FullStop ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
                          
                    }
                    // InternalResoluteParser.g:5909:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalResoluteParser.g:5910:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalResoluteParser.g:5910:1: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalResoluteParser.g:5911:3: lv_path_3_0= ruleContainmentPathElement
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
    // InternalResoluteParser.g:5937:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalResoluteParser.g:5938:1: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalResoluteParser.g:5939:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalResoluteParser.g:5946:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5950:6: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalResoluteParser.g:5951:1: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalResoluteParser.g:5951:1: (kw= PlusSign | kw= HyphenMinus )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==PlusSign) ) {
                alt74=1;
            }
            else if ( (LA74_0==HyphenMinus) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalResoluteParser.g:5952:2: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalResoluteParser.g:5959:2: kw= HyphenMinus
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
    // InternalResoluteParser.g:5972:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalResoluteParser.g:5973:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalResoluteParser.g:5974:2: iv_ruleStringTerm= ruleStringTerm EOF
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
    // InternalResoluteParser.g:5981:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:5984:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalResoluteParser.g:5985:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalResoluteParser.g:5985:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalResoluteParser.g:5986:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalResoluteParser.g:5986:1: (lv_value_0_0= ruleNoQuoteString )
            // InternalResoluteParser.g:5987:3: lv_value_0_0= ruleNoQuoteString
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
    // InternalResoluteParser.g:6011:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalResoluteParser.g:6012:1: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalResoluteParser.g:6013:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalResoluteParser.g:6020:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6024:6: (this_STRING_0= RULE_STRING )
            // InternalResoluteParser.g:6025:5: this_STRING_0= RULE_STRING
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
    // InternalResoluteParser.g:6040:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalResoluteParser.g:6041:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalResoluteParser.g:6042:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalResoluteParser.g:6049:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6052:28: ( ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket ) )
            // InternalResoluteParser.g:6053:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            {
            // InternalResoluteParser.g:6053:1: ( () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket )
            // InternalResoluteParser.g:6053:2: () otherlv_1= LeftSquareBracket ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= RightSquareBracket
            {
            // InternalResoluteParser.g:6053:2: ()
            // InternalResoluteParser.g:6054:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // InternalResoluteParser.g:6064:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalResoluteParser.g:6065:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalResoluteParser.g:6065:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalResoluteParser.g:6066:3: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_64);
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

            // InternalResoluteParser.g:6082:2: (otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==FullStopFullStop) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalResoluteParser.g:6083:2: otherlv_3= FullStopFullStop ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                          
                    }
                    // InternalResoluteParser.g:6087:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalResoluteParser.g:6088:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalResoluteParser.g:6088:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalResoluteParser.g:6089:3: lv_upperBound_4_0= ruleINTVALUE
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
    // InternalResoluteParser.g:6118:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalResoluteParser.g:6119:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalResoluteParser.g:6120:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalResoluteParser.g:6127:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6130:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalResoluteParser.g:6131:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalResoluteParser.g:6131:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalResoluteParser.g:6131:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalResoluteParser.g:6131:2: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalResoluteParser.g:6132:1: (lv_op_0_0= rulePlusMinus )
            {
            // InternalResoluteParser.g:6132:1: (lv_op_0_0= rulePlusMinus )
            // InternalResoluteParser.g:6133:3: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_65);
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

            // InternalResoluteParser.g:6149:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalResoluteParser.g:6150:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalResoluteParser.g:6150:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalResoluteParser.g:6151:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalResoluteParser.g:6179:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalResoluteParser.g:6180:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalResoluteParser.g:6181:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
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
    // InternalResoluteParser.g:6188:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6191:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalResoluteParser.g:6192:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalResoluteParser.g:6192:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalResoluteParser.g:6192:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= FullStopFullStop ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalResoluteParser.g:6192:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalResoluteParser.g:6193:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalResoluteParser.g:6193:1: (lv_minimum_0_0= ruleNumAlt )
            // InternalResoluteParser.g:6194:3: lv_minimum_0_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_66);
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

            otherlv_1=(Token)match(input,FullStopFullStop,FollowSets000.FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                  
            }
            // InternalResoluteParser.g:6215:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalResoluteParser.g:6216:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalResoluteParser.g:6216:1: (lv_maximum_2_0= ruleNumAlt )
            // InternalResoluteParser.g:6217:3: lv_maximum_2_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_67);
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

            // InternalResoluteParser.g:6233:2: (otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==Delta) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalResoluteParser.g:6234:2: otherlv_3= Delta ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,Delta,FollowSets000.FOLLOW_65); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                          
                    }
                    // InternalResoluteParser.g:6238:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalResoluteParser.g:6239:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalResoluteParser.g:6239:1: (lv_delta_4_0= ruleNumAlt )
                    // InternalResoluteParser.g:6240:3: lv_delta_4_0= ruleNumAlt
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
    // InternalResoluteParser.g:6264:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalResoluteParser.g:6265:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalResoluteParser.g:6266:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalResoluteParser.g:6273:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6276:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalResoluteParser.g:6277:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalResoluteParser.g:6277:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt77=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_LIT:
                {
                alt77=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt77=2;
                }
                break;
            case PlusSign:
            case HyphenMinus:
                {
                alt77=3;
                }
                break;
            case RULE_ID:
                {
                alt77=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalResoluteParser.g:6278:5: this_RealTerm_0= ruleRealTerm
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
                    // InternalResoluteParser.g:6288:5: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalResoluteParser.g:6298:5: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalResoluteParser.g:6308:5: this_ConstantValue_3= ruleConstantValue
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
    // InternalResoluteParser.g:6324:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalResoluteParser.g:6325:1: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalResoluteParser.g:6326:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
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
    // InternalResoluteParser.g:6333:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Applies kw= To ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6337:6: ( (kw= Applies kw= To ) )
            // InternalResoluteParser.g:6338:1: (kw= Applies kw= To )
            {
            // InternalResoluteParser.g:6338:1: (kw= Applies kw= To )
            // InternalResoluteParser.g:6339:2: kw= Applies kw= To
            {
            kw=(Token)match(input,Applies,FollowSets000.FOLLOW_68); if (state.failed) return current;
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
    // InternalResoluteParser.g:6358:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalResoluteParser.g:6359:1: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalResoluteParser.g:6360:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
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
    // InternalResoluteParser.g:6367:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Binding ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6371:6: ( (kw= In kw= Binding ) )
            // InternalResoluteParser.g:6372:1: (kw= In kw= Binding )
            {
            // InternalResoluteParser.g:6372:1: (kw= In kw= Binding )
            // InternalResoluteParser.g:6373:2: kw= In kw= Binding
            {
            kw=(Token)match(input,In,FollowSets000.FOLLOW_69); if (state.failed) return current;
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
    // InternalResoluteParser.g:6392:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalResoluteParser.g:6393:1: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalResoluteParser.g:6394:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
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
    // InternalResoluteParser.g:6401:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= In kw= Modes ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6405:6: ( (kw= In kw= Modes ) )
            // InternalResoluteParser.g:6406:1: (kw= In kw= Modes )
            {
            // InternalResoluteParser.g:6406:1: (kw= In kw= Modes )
            // InternalResoluteParser.g:6407:2: kw= In kw= Modes
            {
            kw=(Token)match(input,In,FollowSets000.FOLLOW_70); if (state.failed) return current;
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
    // InternalResoluteParser.g:6426:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalResoluteParser.g:6427:1: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalResoluteParser.g:6428:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalResoluteParser.g:6435:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6439:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalResoluteParser.g:6440:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalResoluteParser.g:6457:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalResoluteParser.g:6458:1: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalResoluteParser.g:6459:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalResoluteParser.g:6466:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6470:6: ( (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? ) )
            // InternalResoluteParser.g:6471:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            {
            // InternalResoluteParser.g:6471:1: (this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )? )
            // InternalResoluteParser.g:6471:6: this_ID_0= RULE_ID (kw= ColonColon this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_71); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // InternalResoluteParser.g:6478:1: (kw= ColonColon this_ID_2= RULE_ID )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==ColonColon) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalResoluteParser.g:6479:2: kw= ColonColon this_ID_2= RULE_ID
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
    // InternalResoluteParser.g:6499:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalResoluteParser.g:6500:1: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalResoluteParser.g:6501:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalResoluteParser.g:6508:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6512:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // InternalResoluteParser.g:6513:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // InternalResoluteParser.g:6513:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // InternalResoluteParser.g:6513:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // InternalResoluteParser.g:6513:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==RULE_ID) ) {
                    int LA79_1 = input.LA(2);

                    if ( (LA79_1==ColonColon) ) {
                        alt79=1;
                    }


                }


                switch (alt79) {
            	case 1 :
            	    // InternalResoluteParser.g:6513:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_72); if (state.failed) return current;
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
            	    break loop79;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // InternalResoluteParser.g:6533:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==FullStop) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalResoluteParser.g:6534:2: kw= FullStop this_ID_4= RULE_ID
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
    // InternalResoluteParser.g:6554:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalResoluteParser.g:6555:1: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalResoluteParser.g:6556:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalResoluteParser.g:6563:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Asterisk ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalResoluteParser.g:6567:6: (kw= Asterisk )
            // InternalResoluteParser.g:6569:2: kw= Asterisk
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
        // InternalResoluteParser.g:982:3: ( ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) ) )
        // InternalResoluteParser.g:982:4: ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) )
        {
        // InternalResoluteParser.g:982:4: ( ( ( RULE_ID ) ) Colon ( ( ruleType ) ) )
        // InternalResoluteParser.g:982:5: ( ( RULE_ID ) ) Colon ( ( ruleType ) )
        {
        // InternalResoluteParser.g:982:5: ( ( RULE_ID ) )
        // InternalResoluteParser.g:983:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:983:1: ( RULE_ID )
        // InternalResoluteParser.g:984:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_11); if (state.failed) return ;

        }


        }

        match(input,Colon,FollowSets000.FOLLOW_4); if (state.failed) return ;
        // InternalResoluteParser.g:989:1: ( ( ruleType ) )
        // InternalResoluteParser.g:990:1: ( ruleType )
        {
        // InternalResoluteParser.g:990:1: ( ruleType )
        // InternalResoluteParser.g:991:1: ruleType
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
        // InternalResoluteParser.g:1806:3: ( ( () ( ( EqualsSignGreaterThanSign ) ) ) )
        // InternalResoluteParser.g:1806:4: ( () ( ( EqualsSignGreaterThanSign ) ) )
        {
        // InternalResoluteParser.g:1806:4: ( () ( ( EqualsSignGreaterThanSign ) ) )
        // InternalResoluteParser.g:1806:5: () ( ( EqualsSignGreaterThanSign ) )
        {
        // InternalResoluteParser.g:1806:5: ()
        // InternalResoluteParser.g:1807:1: 
        {
        }

        // InternalResoluteParser.g:1807:2: ( ( EqualsSignGreaterThanSign ) )
        // InternalResoluteParser.g:1808:1: ( EqualsSignGreaterThanSign )
        {
        // InternalResoluteParser.g:1808:1: ( EqualsSignGreaterThanSign )
        // InternalResoluteParser.g:1810:1: EqualsSignGreaterThanSign
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
        // InternalResoluteParser.g:1884:3: ( ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) ) )
        // InternalResoluteParser.g:1884:4: ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) )
        {
        // InternalResoluteParser.g:1884:4: ( () ( ( ( Or ) ) | ( ( Orelse ) ) ) )
        // InternalResoluteParser.g:1884:5: () ( ( ( Or ) ) | ( ( Orelse ) ) )
        {
        // InternalResoluteParser.g:1884:5: ()
        // InternalResoluteParser.g:1885:1: 
        {
        }

        // InternalResoluteParser.g:1885:2: ( ( ( Or ) ) | ( ( Orelse ) ) )
        int alt81=2;
        int LA81_0 = input.LA(1);

        if ( (LA81_0==Or) ) {
            alt81=1;
        }
        else if ( (LA81_0==Orelse) ) {
            alt81=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 81, 0, input);

            throw nvae;
        }
        switch (alt81) {
            case 1 :
                // InternalResoluteParser.g:1885:3: ( ( Or ) )
                {
                // InternalResoluteParser.g:1885:3: ( ( Or ) )
                // InternalResoluteParser.g:1886:1: ( Or )
                {
                // InternalResoluteParser.g:1886:1: ( Or )
                // InternalResoluteParser.g:1888:1: Or
                {
                match(input,Or,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalResoluteParser.g:1893:6: ( ( Orelse ) )
                {
                // InternalResoluteParser.g:1893:6: ( ( Orelse ) )
                // InternalResoluteParser.g:1894:1: ( Orelse )
                {
                // InternalResoluteParser.g:1894:1: ( Orelse )
                // InternalResoluteParser.g:1896:1: Orelse
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
        // InternalResoluteParser.g:1987:3: ( ( () ( ( ( And ) ) | ( ( Andthen ) ) ) ) )
        // InternalResoluteParser.g:1987:4: ( () ( ( ( And ) ) | ( ( Andthen ) ) ) )
        {
        // InternalResoluteParser.g:1987:4: ( () ( ( ( And ) ) | ( ( Andthen ) ) ) )
        // InternalResoluteParser.g:1987:5: () ( ( ( And ) ) | ( ( Andthen ) ) )
        {
        // InternalResoluteParser.g:1987:5: ()
        // InternalResoluteParser.g:1988:1: 
        {
        }

        // InternalResoluteParser.g:1988:2: ( ( ( And ) ) | ( ( Andthen ) ) )
        int alt82=2;
        int LA82_0 = input.LA(1);

        if ( (LA82_0==And) ) {
            alt82=1;
        }
        else if ( (LA82_0==Andthen) ) {
            alt82=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 82, 0, input);

            throw nvae;
        }
        switch (alt82) {
            case 1 :
                // InternalResoluteParser.g:1988:3: ( ( And ) )
                {
                // InternalResoluteParser.g:1988:3: ( ( And ) )
                // InternalResoluteParser.g:1989:1: ( And )
                {
                // InternalResoluteParser.g:1989:1: ( And )
                // InternalResoluteParser.g:1991:1: And
                {
                match(input,And,FollowSets000.FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalResoluteParser.g:1996:6: ( ( Andthen ) )
                {
                // InternalResoluteParser.g:1996:6: ( ( Andthen ) )
                // InternalResoluteParser.g:1997:1: ( Andthen )
                {
                // InternalResoluteParser.g:1997:1: ( Andthen )
                // InternalResoluteParser.g:1999:1: Andthen
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
        // InternalResoluteParser.g:2090:3: ( ( () Instanceof ) )
        // InternalResoluteParser.g:2090:4: ( () Instanceof )
        {
        // InternalResoluteParser.g:2090:4: ( () Instanceof )
        // InternalResoluteParser.g:2090:5: () Instanceof
        {
        // InternalResoluteParser.g:2090:5: ()
        // InternalResoluteParser.g:2091:1: 
        {
        }

        match(input,Instanceof,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalResoluteParser

    // $ANTLR start synpred6_InternalResoluteParser
    public final void synpred6_InternalResoluteParser_fragment() throws RecognitionException {   
        // InternalResoluteParser.g:2215:3: ( ( () ( ( ruleRelationalOp ) ) ) )
        // InternalResoluteParser.g:2215:4: ( () ( ( ruleRelationalOp ) ) )
        {
        // InternalResoluteParser.g:2215:4: ( () ( ( ruleRelationalOp ) ) )
        // InternalResoluteParser.g:2215:5: () ( ( ruleRelationalOp ) )
        {
        // InternalResoluteParser.g:2215:5: ()
        // InternalResoluteParser.g:2216:1: 
        {
        }

        // InternalResoluteParser.g:2216:2: ( ( ruleRelationalOp ) )
        // InternalResoluteParser.g:2217:1: ( ruleRelationalOp )
        {
        // InternalResoluteParser.g:2217:1: ( ruleRelationalOp )
        // InternalResoluteParser.g:2218:1: ruleRelationalOp
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
        // InternalResoluteParser.g:2292:3: ( ( () ( ( ( PlusSign | HyphenMinus ) ) ) ) )
        // InternalResoluteParser.g:2292:4: ( () ( ( ( PlusSign | HyphenMinus ) ) ) )
        {
        // InternalResoluteParser.g:2292:4: ( () ( ( ( PlusSign | HyphenMinus ) ) ) )
        // InternalResoluteParser.g:2292:5: () ( ( ( PlusSign | HyphenMinus ) ) )
        {
        // InternalResoluteParser.g:2292:5: ()
        // InternalResoluteParser.g:2293:1: 
        {
        }

        // InternalResoluteParser.g:2293:2: ( ( ( PlusSign | HyphenMinus ) ) )
        // InternalResoluteParser.g:2294:1: ( ( PlusSign | HyphenMinus ) )
        {
        // InternalResoluteParser.g:2294:1: ( ( PlusSign | HyphenMinus ) )
        // InternalResoluteParser.g:2295:1: ( PlusSign | HyphenMinus )
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
        // InternalResoluteParser.g:2393:3: ( ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) ) )
        // InternalResoluteParser.g:2393:4: ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) )
        {
        // InternalResoluteParser.g:2393:4: ( () ( ( ( Asterisk | Solidus | PercentSign ) ) ) )
        // InternalResoluteParser.g:2393:5: () ( ( ( Asterisk | Solidus | PercentSign ) ) )
        {
        // InternalResoluteParser.g:2393:5: ()
        // InternalResoluteParser.g:2394:1: 
        {
        }

        // InternalResoluteParser.g:2394:2: ( ( ( Asterisk | Solidus | PercentSign ) ) )
        // InternalResoluteParser.g:2395:1: ( ( Asterisk | Solidus | PercentSign ) )
        {
        // InternalResoluteParser.g:2395:1: ( ( Asterisk | Solidus | PercentSign ) )
        // InternalResoluteParser.g:2396:1: ( Asterisk | Solidus | PercentSign )
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
        // InternalResoluteParser.g:2511:3: ( ( () ( ( CircumflexAccent ) ) ) )
        // InternalResoluteParser.g:2511:4: ( () ( ( CircumflexAccent ) ) )
        {
        // InternalResoluteParser.g:2511:4: ( () ( ( CircumflexAccent ) ) )
        // InternalResoluteParser.g:2511:5: () ( ( CircumflexAccent ) )
        {
        // InternalResoluteParser.g:2511:5: ()
        // InternalResoluteParser.g:2512:1: 
        {
        }

        // InternalResoluteParser.g:2512:2: ( ( CircumflexAccent ) )
        // InternalResoluteParser.g:2513:1: ( CircumflexAccent )
        {
        // InternalResoluteParser.g:2513:1: ( CircumflexAccent )
        // InternalResoluteParser.g:2515:1: CircumflexAccent
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
        // InternalResoluteParser.g:3103:7: ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )
        // InternalResoluteParser.g:3103:8: ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis )
        {
        // InternalResoluteParser.g:3103:8: ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis )
        // InternalResoluteParser.g:3103:9: () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis
        {
        // InternalResoluteParser.g:3103:9: ()
        // InternalResoluteParser.g:3104:1: 
        {
        }

        // InternalResoluteParser.g:3104:2: ( ( RULE_ID ) )
        // InternalResoluteParser.g:3105:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:3105:1: ( RULE_ID )
        // InternalResoluteParser.g:3106:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_9); if (state.failed) return ;

        }


        }

        match(input,FullStop,FollowSets000.FOLLOW_10); if (state.failed) return ;
        // InternalResoluteParser.g:3111:1: ( ( RULE_ID ) )
        // InternalResoluteParser.g:3112:1: ( RULE_ID )
        {
        // InternalResoluteParser.g:3112:1: ( RULE_ID )
        // InternalResoluteParser.g:3113:1: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_14); if (state.failed) return ;

        }


        }

        match(input,LeftParenthesis,FollowSets000.FOLLOW_41); if (state.failed) return ;
        // InternalResoluteParser.g:3118:1: ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )?
        int alt84=2;
        int LA84_0 = input.LA(1);

        if ( ((LA84_0>=Error_state_reachable && LA84_0<=Is_virtual_processor)||(LA84_0>=Flow_specifications && LA84_0<=Is_abstract_feature)||LA84_0==Enumerated_values||(LA84_0>=End_to_end_flows && LA84_0<=Is_bidirectional)||(LA84_0>=Is_thread_group && LA84_0<=Contain_error)||(LA84_0>=Flow_elements && LA84_0<=Is_processor)||LA84_0==Connections||(LA84_0>=Destination && LA84_0<=Upper_bound)||(LA84_0>=Has_member && LA84_0<=Has_parent)||(LA84_0>=Is_of_type && LA84_0<=Is_process)||(LA84_0>=Direction && LA84_0<=Is_thread)||LA84_0==Analysis||(LA84_0>=Features && LA84_0<=Property)||LA84_0==As_list||(LA84_0>=Is_data && LA84_0<=Is_port)||LA84_0==Warning||(LA84_0>=Append && LA84_0<=As_set)||(LA84_0>=Exists && LA84_0<=Member)||(LA84_0>=Parent && LA84_0<=Source)||LA84_0==Debug||(LA84_0>=Error && LA84_0<=False)||LA84_0==Union||(LA84_0>=Fail && LA84_0<=Name)||(LA84_0>=Size && LA84_0<=Tail)||(LA84_0>=This && LA84_0<=Type)||(LA84_0>=Let && LA84_0<=Sum)||LA84_0==If||LA84_0==LeftParenthesis||LA84_0==HyphenMinus||LA84_0==LeftSquareBracket||LA84_0==LeftCurlyBracket||LA84_0==RULE_REAL_LIT||LA84_0==RULE_INTEGER_LIT||(LA84_0>=RULE_STRING && LA84_0<=RULE_ID)) ) {
            alt84=1;
        }
        switch (alt84) {
            case 1 :
                // InternalResoluteParser.g:3118:2: ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )*
                {
                // InternalResoluteParser.g:3118:2: ( ( ruleExpr ) )
                // InternalResoluteParser.g:3119:1: ( ruleExpr )
                {
                // InternalResoluteParser.g:3119:1: ( ruleExpr )
                // InternalResoluteParser.g:3120:1: ruleExpr
                {
                pushFollow(FollowSets000.FOLLOW_16);
                ruleExpr();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalResoluteParser.g:3122:2: ( Comma ( ( ruleExpr ) ) )*
                loop83:
                do {
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==Comma) ) {
                        alt83=1;
                    }


                    switch (alt83) {
                	case 1 :
                	    // InternalResoluteParser.g:3123:1: Comma ( ( ruleExpr ) )
                	    {
                	    match(input,Comma,FollowSets000.FOLLOW_12); if (state.failed) return ;
                	    // InternalResoluteParser.g:3124:1: ( ( ruleExpr ) )
                	    // InternalResoluteParser.g:3125:1: ( ruleExpr )
                	    {
                	    // InternalResoluteParser.g:3125:1: ( ruleExpr )
                	    // InternalResoluteParser.g:3126:1: ruleExpr
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
                	    break loop83;
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


    protected DFA50 dfa50 = new DFA50(this);
    protected DFA67 dfa67 = new DFA67(this);
    static final String dfa_1s = "\31\uffff";
    static final String dfa_2s = "\1\uffff\1\22\25\uffff\1\22\1\uffff";
    static final String dfa_3s = "\1\11\1\75\12\uffff\2\11\2\uffff\1\u00ba\6\uffff\1\75\1\uffff";
    static final String dfa_4s = "\2\u00ba\12\uffff\2\u00ba\2\uffff\1\u00ba\6\uffff\1\u00ba\1\uffff";
    static final String dfa_5s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\13\1\15\2\uffff\1\22\1\23\1\uffff\1\14\1\1\1\16\1\20\1\17\1\21\1\uffff\1\12";
    static final String dfa_6s = "\27\uffff\1\0\1\uffff}>";
    static final String[] dfa_7s = {
            "\2\12\2\uffff\2\12\3\uffff\1\12\2\uffff\3\12\3\uffff\7\12\1\uffff\11\12\1\uffff\1\12\1\uffff\6\12\6\uffff\2\12\1\uffff\2\12\3\uffff\10\12\3\uffff\1\12\1\uffff\4\12\3\uffff\1\12\4\uffff\2\12\2\uffff\1\13\1\uffff\2\12\1\uffff\2\11\3\12\2\uffff\2\12\4\uffff\1\12\1\uffff\1\13\1\6\3\uffff\1\12\4\uffff\1\3\1\12\1\13\1\12\2\uffff\2\12\1\uffff\1\2\1\6\1\12\5\uffff\1\16\1\uffff\1\12\7\uffff\1\10\4\uffff\1\17\14\uffff\1\14\2\uffff\1\15\6\uffff\1\5\1\uffff\1\4\1\uffff\1\7\1\1",
            "\1\22\27\uffff\1\22\11\uffff\2\22\12\uffff\1\22\5\uffff\1\22\2\uffff\1\22\2\uffff\1\22\5\uffff\1\22\2\uffff\1\22\5\uffff\1\22\4\uffff\1\22\1\uffff\1\22\6\uffff\5\22\2\uffff\1\22\1\uffff\1\22\1\21\5\22\1\20\1\22\1\uffff\4\22\1\uffff\2\22\2\uffff\1\22\11\uffff\1\22",
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
            "\2\23\2\uffff\2\23\3\uffff\1\23\2\uffff\3\23\3\uffff\7\23\1\uffff\11\23\1\uffff\1\23\1\uffff\6\23\6\uffff\2\23\1\uffff\2\23\3\uffff\10\23\3\uffff\1\23\1\uffff\4\23\3\uffff\1\23\4\uffff\2\23\2\uffff\1\23\1\uffff\2\23\1\uffff\5\23\2\uffff\2\23\4\uffff\1\23\1\uffff\2\23\3\uffff\1\23\4\uffff\4\23\2\uffff\2\23\1\uffff\3\23\5\uffff\3\23\7\uffff\1\23\4\uffff\1\23\4\uffff\1\23\7\uffff\1\23\1\24\1\uffff\1\23\6\uffff\1\23\1\uffff\1\23\1\uffff\2\23",
            "\2\25\2\uffff\2\25\3\uffff\1\25\2\uffff\3\25\3\uffff\7\25\1\uffff\11\25\1\uffff\1\25\1\uffff\6\25\6\uffff\2\25\1\uffff\2\25\3\uffff\10\25\3\uffff\1\25\1\uffff\4\25\3\uffff\1\25\4\uffff\2\25\2\uffff\1\25\1\uffff\2\25\1\uffff\5\25\2\uffff\2\25\4\uffff\1\25\1\uffff\2\25\3\uffff\1\25\4\uffff\4\25\2\uffff\2\25\1\uffff\3\25\5\uffff\3\25\7\uffff\1\25\4\uffff\1\25\4\uffff\1\25\7\uffff\1\25\2\uffff\1\25\1\uffff\1\26\4\uffff\1\25\1\uffff\1\25\1\uffff\2\25",
            "",
            "",
            "\1\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\22\27\uffff\1\22\11\uffff\2\22\12\uffff\1\22\5\uffff\1\22\2\uffff\1\22\2\uffff\1\22\5\uffff\1\22\2\uffff\1\22\5\uffff\1\22\4\uffff\1\22\1\uffff\1\22\7\uffff\4\22\2\uffff\1\22\1\uffff\1\22\1\30\5\22\1\uffff\1\22\1\uffff\4\22\1\uffff\2\22\2\uffff\1\22\11\uffff\1\22",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2720:1: ( ( () ( ( ruleQCREF ) ) ) | ( () otherlv_3= This (otherlv_4= FullStop ( (lv_sub_5_0= ruleNestedDotID ) ) )? ) | ( () otherlv_7= Fail ( ( (lv_val_8_0= ruleExpr ) ) | (otherlv_9= AsteriskAsterisk ( (lv_failmsg_10_0= ruleClaimText ) )+ otherlv_11= AsteriskAsterisk ) ) ) | ( () ( (lv_val_13_0= ruleIntegerTerm ) ) ) | ( () ( (lv_val_15_0= ruleRealTerm ) ) ) | ( () ( (lv_val_17_0= ruleBooleanLiteral ) ) ) | ( () ( (lv_val_19_0= ruleStringTerm ) ) ) | ( () otherlv_21= If ( (lv_cond_22_0= ruleExpr ) ) otherlv_23= Then ( (lv_then_24_0= ruleExpr ) ) otherlv_25= Else ( (lv_else_26_0= ruleExpr ) ) ) | ( () ( ( (lv_quant_28_1= Forall | lv_quant_28_2= Exists ) ) ) (otherlv_29= LeftParenthesis ( (lv_args_30_0= ruleArg ) ) otherlv_31= RightParenthesis )+ otherlv_32= FullStop ( (lv_expr_33_0= ruleExpr ) ) ) | ( ( ( () ( ( RULE_ID ) ) FullStop ( ( RULE_ID ) ) LeftParenthesis ( ( ( ruleExpr ) ) ( Comma ( ( ruleExpr ) ) )* )? RightParenthesis ) )=> ( () ( (lv_libName_35_0= RULE_ID ) ) otherlv_36= FullStop ( (lv_fnName_37_0= RULE_ID ) ) otherlv_38= LeftParenthesis ( ( (lv_args_39_0= ruleExpr ) ) (otherlv_40= Comma ( (lv_args_41_0= ruleExpr ) ) )* )? otherlv_42= RightParenthesis ) ) | ( () ( (lv_fn_44_0= ruleBuiltInFn ) ) otherlv_45= LeftParenthesis ( ( (lv_args_46_0= ruleExpr ) ) (otherlv_47= Comma ( (lv_args_48_0= ruleExpr ) ) )* )? otherlv_49= RightParenthesis ) | ( () ( (otherlv_51= RULE_ID ) ) otherlv_52= LeftParenthesis ( ( (lv_args_53_0= ruleExpr ) ) (otherlv_54= Comma ( (lv_args_55_0= ruleExpr ) ) )* )? otherlv_56= RightParenthesis ) | ( () ( (lv_lintStmt_58_0= ruleLintStatement ) ) ) | (otherlv_59= LeftSquareBracket this_Expr_60= ruleExpr ( ( () otherlv_62= For (otherlv_63= LeftParenthesis ( (lv_args_64_0= ruleArg ) ) otherlv_65= RightParenthesis )+ (otherlv_66= VerticalLine ( (lv_filter_67_0= ruleExpr ) ) )? ) | ( () (otherlv_69= Comma ( (lv_exprs_70_0= ruleExpr ) ) )* ) ) otherlv_71= RightSquareBracket ) | (otherlv_72= LeftCurlyBracket this_Expr_73= ruleExpr ( ( () otherlv_75= For (otherlv_76= LeftParenthesis ( (lv_args_77_0= ruleArg ) ) otherlv_78= RightParenthesis )+ (otherlv_79= VerticalLine ( (lv_filter_80_0= ruleExpr ) ) )? ) | ( () (otherlv_82= Comma ( (lv_exprs_83_0= ruleExpr ) ) )* ) ) otherlv_84= RightCurlyBracket ) | ( () otherlv_86= LeftSquareBracket otherlv_87= RightSquareBracket ) | ( () otherlv_89= LeftCurlyBracket otherlv_90= RightCurlyBracket ) | ( () otherlv_92= Let ( (lv_binding_93_0= ruleLetBinding ) ) otherlv_94= Semicolon ( (lv_expr_95_0= ruleExpr ) ) ) | (otherlv_96= LeftParenthesis this_Expr_97= ruleExpr otherlv_98= RightParenthesis ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA50_23 = input.LA(1);

                         
                        int index50_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA50_23==EOF||LA50_23==Instanceof||LA50_23==Andthen||(LA50_23>=Ruleset && LA50_23<=Warning)||LA50_23==Orelse||LA50_23==Check||LA50_23==Error||LA50_23==Prove||LA50_23==Else||LA50_23==Info||LA50_23==Then||LA50_23==And||LA50_23==For||(LA50_23>=LessThanSignEqualsSign && LA50_23<=GreaterThanSignEqualsSign)||LA50_23==Or||LA50_23==PercentSign||(LA50_23>=RightParenthesis && LA50_23<=HyphenMinus)||LA50_23==Solidus||(LA50_23>=Semicolon && LA50_23<=GreaterThanSign)||(LA50_23>=RightSquareBracket && LA50_23<=CircumflexAccent)||LA50_23==RightCurlyBracket||LA50_23==RULE_ID) ) {s = 18;}

                        else if ( (LA50_23==LeftParenthesis) && (synpred10_InternalResoluteParser())) {s = 24;}

                         
                        input.seek(index50_23);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 50, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\23\uffff";
    static final String dfa_9s = "\6\uffff\1\15\1\17\1\uffff\1\21\2\uffff\1\15\1\uffff\1\17\3\uffff\1\21";
    static final String dfa_10s = "\1\70\5\uffff\2\126\1\uffff\1\126\2\uffff\1\126\1\uffff\1\126\1\uffff\1\u00ba\1\uffff\1\126";
    static final String dfa_11s = "\1\u00ba\5\uffff\2\u00ba\1\uffff\1\u00a7\2\uffff\1\u00a7\1\uffff\1\u00a7\1\uffff\1\u00ba\1\uffff\1\u00a7";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\6\1\uffff\1\11\1\12\1\uffff\1\7\1\uffff\1\10\1\uffff\1\13\1\uffff";
    static final String dfa_13s = "\23\uffff}>";
    static final String[] dfa_14s = {
            "\1\3\23\uffff\1\2\14\uffff\1\4\33\uffff\1\13\22\uffff\1\13\25\uffff\1\12\2\uffff\1\10\1\uffff\1\10\7\uffff\1\1\11\uffff\1\6\1\uffff\1\7\1\uffff\1\5\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\15\74\uffff\1\10\6\uffff\1\15\4\uffff\1\15\2\uffff\1\15\4\uffff\1\15\22\uffff\1\14",
            "\1\17\74\uffff\1\10\6\uffff\1\17\4\uffff\1\17\2\uffff\1\17\4\uffff\1\17\22\uffff\1\16",
            "",
            "\1\21\74\uffff\1\10\1\20\5\uffff\1\21\4\uffff\1\21\2\uffff\1\21\4\uffff\1\21",
            "",
            "",
            "\1\15\74\uffff\1\10\6\uffff\1\15\4\uffff\1\15\2\uffff\1\15\4\uffff\1\15",
            "",
            "\1\17\74\uffff\1\10\6\uffff\1\17\4\uffff\1\17\2\uffff\1\17\4\uffff\1\17",
            "",
            "\1\22",
            "",
            "\1\21\74\uffff\1\10\6\uffff\1\21\4\uffff\1\21\2\uffff\1\21\4\uffff\1\21"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "5269:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_BooleanLiteral_9= ruleBooleanLiteral | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L,0x0400000000000000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x06A05004071B99F0L,0x1D01C41248082807L,0x040048000000500CL});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000010000000000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000040000000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000000000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xD81FAFFBF8E46600L,0xC23433ED308F47F8L,0x06A04808420383B3L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400000080000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000480000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000004000200000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0600000000000000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0600000000040000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xD85FAFFBF8E46600L,0xC23433ED349F47F8L,0x06A04808420383B3L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xD85FAFFBF8E46600L,0xC23433ED309F47F8L,0x06A04808420383B3L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xD81FAFFBF8E46600L,0xC23433ED309F47F8L,0x06A04808420383B3L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000020000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L,0x0000000000000800L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x06A05004071B99F0L,0x1D01C41248082807L,0x000000000000500CL});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000070001600000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000A00000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000002120000000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000200000000000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000001000000000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xD81FAFFBF8E46600L,0xC23433ED308F47F8L,0x06A04808420783B3L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001040000000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0xD81FAFFBF8E46600L,0xC23433ED308F47F8L,0x06A04808C20383B3L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100400002000L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000900040000000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100400000000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000400002000L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001800040000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000400000000L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0400000000000000L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0082000000000000L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0010000100000000L,0x0001000000000001L});
        public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0010000100000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800400L});
        public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0100000000000000L,0x0020000002009000L,0x06A0080A40000100L});
        public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L,0x0000008404000000L});
        public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008404000000L});
        public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000004000000L});
        public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0400100000000000L});
        public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0100000000000000L,0x0020000002009000L,0x06A0080AC0000100L});
        public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000081000000000L});
        public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0080000000000000L});
        public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000100000080000L});
        public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x04A0000A00000000L});
        public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
        public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});
        public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
        public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
        public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    }


}