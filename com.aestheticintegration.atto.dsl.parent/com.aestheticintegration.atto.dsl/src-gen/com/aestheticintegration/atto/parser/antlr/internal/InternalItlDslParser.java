package com.aestheticintegration.atto.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.aestheticintegration.atto.services.ItlDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalItlDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BOOLEAN", "RULE_INTEGER", "RULE_FLOAT", "RULE_STRING", "RULE_NULL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'datatype'", "'{'", "'}'", "'datavalue'", "'='", "'('", "','", "')'", "'function'", "':'", "'boolean'", "'Boolean'", "'short'", "'Short'", "'int'", "'Integer'", "'long'", "'Long'", "'float'", "'Float'", "'double'", "'Double'", "'String'", "'if'", "'&&'", "'||'", "'then'", "'else'", "'endif'", "'<='", "'>='", "'>'", "'<'", "'<>'", "'.'", "'Exception'", "'test'"
    };
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=5;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=8;
    public static final int RULE_NULL=9;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=12;
    public static final int RULE_ANY_OTHER=13;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=7;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_INTEGER=6;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalItlDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalItlDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalItlDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalItlDsl.g"; }



     	private ItlDslGrammarAccess grammarAccess;

        public InternalItlDslParser(TokenStream input, ItlDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected ItlDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalItlDsl.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalItlDsl.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalItlDsl.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalItlDsl.g:72:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleDefImport ) )* ( (lv_datatypes_1_0= ruleDefDataType ) )* ( (lv_datavalues_2_0= ruleDefDataValue ) )* ( (lv_functions_3_0= ruleDefFunction ) )* ( (lv_tests_4_0= ruleDefTest ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_datatypes_1_0 = null;

        EObject lv_datavalues_2_0 = null;

        EObject lv_functions_3_0 = null;

        EObject lv_tests_4_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:78:2: ( ( ( (lv_imports_0_0= ruleDefImport ) )* ( (lv_datatypes_1_0= ruleDefDataType ) )* ( (lv_datavalues_2_0= ruleDefDataValue ) )* ( (lv_functions_3_0= ruleDefFunction ) )* ( (lv_tests_4_0= ruleDefTest ) )* ) )
            // InternalItlDsl.g:79:2: ( ( (lv_imports_0_0= ruleDefImport ) )* ( (lv_datatypes_1_0= ruleDefDataType ) )* ( (lv_datavalues_2_0= ruleDefDataValue ) )* ( (lv_functions_3_0= ruleDefFunction ) )* ( (lv_tests_4_0= ruleDefTest ) )* )
            {
            // InternalItlDsl.g:79:2: ( ( (lv_imports_0_0= ruleDefImport ) )* ( (lv_datatypes_1_0= ruleDefDataType ) )* ( (lv_datavalues_2_0= ruleDefDataValue ) )* ( (lv_functions_3_0= ruleDefFunction ) )* ( (lv_tests_4_0= ruleDefTest ) )* )
            // InternalItlDsl.g:80:3: ( (lv_imports_0_0= ruleDefImport ) )* ( (lv_datatypes_1_0= ruleDefDataType ) )* ( (lv_datavalues_2_0= ruleDefDataValue ) )* ( (lv_functions_3_0= ruleDefFunction ) )* ( (lv_tests_4_0= ruleDefTest ) )*
            {
            // InternalItlDsl.g:80:3: ( (lv_imports_0_0= ruleDefImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalItlDsl.g:81:4: (lv_imports_0_0= ruleDefImport )
            	    {
            	    // InternalItlDsl.g:81:4: (lv_imports_0_0= ruleDefImport )
            	    // InternalItlDsl.g:82:5: lv_imports_0_0= ruleDefImport
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getImportsDefImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleDefImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"com.aestheticintegration.atto.ItlDsl.DefImport");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalItlDsl.g:99:3: ( (lv_datatypes_1_0= ruleDefDataType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalItlDsl.g:100:4: (lv_datatypes_1_0= ruleDefDataType )
            	    {
            	    // InternalItlDsl.g:100:4: (lv_datatypes_1_0= ruleDefDataType )
            	    // InternalItlDsl.g:101:5: lv_datatypes_1_0= ruleDefDataType
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getDatatypesDefDataTypeParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_datatypes_1_0=ruleDefDataType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"datatypes",
            	    						lv_datatypes_1_0,
            	    						"com.aestheticintegration.atto.ItlDsl.DefDataType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalItlDsl.g:118:3: ( (lv_datavalues_2_0= ruleDefDataValue ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalItlDsl.g:119:4: (lv_datavalues_2_0= ruleDefDataValue )
            	    {
            	    // InternalItlDsl.g:119:4: (lv_datavalues_2_0= ruleDefDataValue )
            	    // InternalItlDsl.g:120:5: lv_datavalues_2_0= ruleDefDataValue
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getDatavaluesDefDataValueParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_datavalues_2_0=ruleDefDataValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"datavalues",
            	    						lv_datavalues_2_0,
            	    						"com.aestheticintegration.atto.ItlDsl.DefDataValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalItlDsl.g:137:3: ( (lv_functions_3_0= ruleDefFunction ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==23) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalItlDsl.g:138:4: (lv_functions_3_0= ruleDefFunction )
            	    {
            	    // InternalItlDsl.g:138:4: (lv_functions_3_0= ruleDefFunction )
            	    // InternalItlDsl.g:139:5: lv_functions_3_0= ruleDefFunction
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getFunctionsDefFunctionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_functions_3_0=ruleDefFunction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"functions",
            	    						lv_functions_3_0,
            	    						"com.aestheticintegration.atto.ItlDsl.DefFunction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalItlDsl.g:156:3: ( (lv_tests_4_0= ruleDefTest ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==51) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalItlDsl.g:157:4: (lv_tests_4_0= ruleDefTest )
            	    {
            	    // InternalItlDsl.g:157:4: (lv_tests_4_0= ruleDefTest )
            	    // InternalItlDsl.g:158:5: lv_tests_4_0= ruleDefTest
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getTestsDefTestParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_tests_4_0=ruleDefTest();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tests",
            	    						lv_tests_4_0,
            	    						"com.aestheticintegration.atto.ItlDsl.DefTest");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDefImport"
    // InternalItlDsl.g:179:1: entryRuleDefImport returns [EObject current=null] : iv_ruleDefImport= ruleDefImport EOF ;
    public final EObject entryRuleDefImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefImport = null;


        try {
            // InternalItlDsl.g:179:50: (iv_ruleDefImport= ruleDefImport EOF )
            // InternalItlDsl.g:180:2: iv_ruleDefImport= ruleDefImport EOF
            {
             newCompositeNode(grammarAccess.getDefImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefImport=ruleDefImport();

            state._fsp--;

             current =iv_ruleDefImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefImport"


    // $ANTLR start "ruleDefImport"
    // InternalItlDsl.g:186:1: ruleDefImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleDefImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:192:2: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalItlDsl.g:193:2: (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalItlDsl.g:193:2: (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalItlDsl.g:194:3: otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDefImportAccess().getImportKeyword_0());
            		
            // InternalItlDsl.g:198:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalItlDsl.g:199:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalItlDsl.g:199:4: (lv_name_1_0= ruleQualifiedName )
            // InternalItlDsl.g:200:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getDefImportAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefImportRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.aestheticintegration.atto.ItlDsl.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefImport"


    // $ANTLR start "entryRuleDefDataType"
    // InternalItlDsl.g:221:1: entryRuleDefDataType returns [EObject current=null] : iv_ruleDefDataType= ruleDefDataType EOF ;
    public final EObject entryRuleDefDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefDataType = null;


        try {
            // InternalItlDsl.g:221:52: (iv_ruleDefDataType= ruleDefDataType EOF )
            // InternalItlDsl.g:222:2: iv_ruleDefDataType= ruleDefDataType EOF
            {
             newCompositeNode(grammarAccess.getDefDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefDataType=ruleDefDataType();

            state._fsp--;

             current =iv_ruleDefDataType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefDataType"


    // $ANTLR start "ruleDefDataType"
    // InternalItlDsl.g:228:1: ruleDefDataType returns [EObject current=null] : (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleInputParam ) )* otherlv_4= '}' ) ;
    public final EObject ruleDefDataType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_fields_3_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:234:2: ( (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleInputParam ) )* otherlv_4= '}' ) )
            // InternalItlDsl.g:235:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleInputParam ) )* otherlv_4= '}' )
            {
            // InternalItlDsl.g:235:2: (otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleInputParam ) )* otherlv_4= '}' )
            // InternalItlDsl.g:236:3: otherlv_0= 'datatype' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleInputParam ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDefDataTypeAccess().getDatatypeKeyword_0());
            		
            // InternalItlDsl.g:240:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalItlDsl.g:241:4: (lv_name_1_0= RULE_ID )
            {
            // InternalItlDsl.g:241:4: (lv_name_1_0= RULE_ID )
            // InternalItlDsl.g:242:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDefDataTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDefDataTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.aestheticintegration.atto.ItlDsl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getDefDataTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalItlDsl.g:262:3: ( (lv_fields_3_0= ruleInputParam ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalItlDsl.g:263:4: (lv_fields_3_0= ruleInputParam )
            	    {
            	    // InternalItlDsl.g:263:4: (lv_fields_3_0= ruleInputParam )
            	    // InternalItlDsl.g:264:5: lv_fields_3_0= ruleInputParam
            	    {

            	    					newCompositeNode(grammarAccess.getDefDataTypeAccess().getFieldsInputParamParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_fields_3_0=ruleInputParam();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDefDataTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"fields",
            	    						lv_fields_3_0,
            	    						"com.aestheticintegration.atto.ItlDsl.InputParam");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getDefDataTypeAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefDataType"


    // $ANTLR start "entryRuleDefDataValue"
    // InternalItlDsl.g:289:1: entryRuleDefDataValue returns [EObject current=null] : iv_ruleDefDataValue= ruleDefDataValue EOF ;
    public final EObject entryRuleDefDataValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefDataValue = null;


        try {
            // InternalItlDsl.g:289:53: (iv_ruleDefDataValue= ruleDefDataValue EOF )
            // InternalItlDsl.g:290:2: iv_ruleDefDataValue= ruleDefDataValue EOF
            {
             newCompositeNode(grammarAccess.getDefDataValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefDataValue=ruleDefDataValue();

            state._fsp--;

             current =iv_ruleDefDataValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefDataValue"


    // $ANTLR start "ruleDefDataValue"
    // InternalItlDsl.g:296:1: ruleDefDataValue returns [EObject current=null] : (otherlv_0= 'datavalue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_dataTypeInstance_3_0= ruleDataTypeInstance ) ) ) ;
    public final EObject ruleDefDataValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_dataTypeInstance_3_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:302:2: ( (otherlv_0= 'datavalue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_dataTypeInstance_3_0= ruleDataTypeInstance ) ) ) )
            // InternalItlDsl.g:303:2: (otherlv_0= 'datavalue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_dataTypeInstance_3_0= ruleDataTypeInstance ) ) )
            {
            // InternalItlDsl.g:303:2: (otherlv_0= 'datavalue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_dataTypeInstance_3_0= ruleDataTypeInstance ) ) )
            // InternalItlDsl.g:304:3: otherlv_0= 'datavalue' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_dataTypeInstance_3_0= ruleDataTypeInstance ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDefDataValueAccess().getDatavalueKeyword_0());
            		
            // InternalItlDsl.g:308:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalItlDsl.g:309:4: (lv_name_1_0= RULE_ID )
            {
            // InternalItlDsl.g:309:4: (lv_name_1_0= RULE_ID )
            // InternalItlDsl.g:310:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDefDataValueAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDefDataValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.aestheticintegration.atto.ItlDsl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getDefDataValueAccess().getEqualsSignKeyword_2());
            		
            // InternalItlDsl.g:330:3: ( (lv_dataTypeInstance_3_0= ruleDataTypeInstance ) )
            // InternalItlDsl.g:331:4: (lv_dataTypeInstance_3_0= ruleDataTypeInstance )
            {
            // InternalItlDsl.g:331:4: (lv_dataTypeInstance_3_0= ruleDataTypeInstance )
            // InternalItlDsl.g:332:5: lv_dataTypeInstance_3_0= ruleDataTypeInstance
            {

            					newCompositeNode(grammarAccess.getDefDataValueAccess().getDataTypeInstanceDataTypeInstanceParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_dataTypeInstance_3_0=ruleDataTypeInstance();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefDataValueRule());
            					}
            					set(
            						current,
            						"dataTypeInstance",
            						lv_dataTypeInstance_3_0,
            						"com.aestheticintegration.atto.ItlDsl.DataTypeInstance");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefDataValue"


    // $ANTLR start "entryRuleDataTypeInstance"
    // InternalItlDsl.g:353:1: entryRuleDataTypeInstance returns [EObject current=null] : iv_ruleDataTypeInstance= ruleDataTypeInstance EOF ;
    public final EObject entryRuleDataTypeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeInstance = null;


        try {
            // InternalItlDsl.g:353:57: (iv_ruleDataTypeInstance= ruleDataTypeInstance EOF )
            // InternalItlDsl.g:354:2: iv_ruleDataTypeInstance= ruleDataTypeInstance EOF
            {
             newCompositeNode(grammarAccess.getDataTypeInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeInstance=ruleDataTypeInstance();

            state._fsp--;

             current =iv_ruleDataTypeInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTypeInstance"


    // $ANTLR start "ruleDataTypeInstance"
    // InternalItlDsl.g:360:1: ruleDataTypeInstance returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_literals_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) ) )* )* otherlv_5= ')' ) ;
    public final EObject ruleDataTypeInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_literals_2_0 = null;

        EObject lv_literals_4_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:366:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_literals_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) ) )* )* otherlv_5= ')' ) )
            // InternalItlDsl.g:367:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_literals_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) ) )* )* otherlv_5= ')' )
            {
            // InternalItlDsl.g:367:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_literals_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) ) )* )* otherlv_5= ')' )
            // InternalItlDsl.g:368:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_literals_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) ) )* )* otherlv_5= ')'
            {
            // InternalItlDsl.g:368:3: ( (otherlv_0= RULE_ID ) )
            // InternalItlDsl.g:369:4: (otherlv_0= RULE_ID )
            {
            // InternalItlDsl.g:369:4: (otherlv_0= RULE_ID )
            // InternalItlDsl.g:370:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDataTypeInstanceRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(otherlv_0, grammarAccess.getDataTypeInstanceAccess().getDefDataTypeDefDataTypeCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getDataTypeInstanceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalItlDsl.g:385:3: ( ( (lv_literals_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) ) )* )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_NULL)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalItlDsl.g:386:4: ( (lv_literals_2_0= ruleLiteral ) ) (otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) ) )*
            	    {
            	    // InternalItlDsl.g:386:4: ( (lv_literals_2_0= ruleLiteral ) )
            	    // InternalItlDsl.g:387:5: (lv_literals_2_0= ruleLiteral )
            	    {
            	    // InternalItlDsl.g:387:5: (lv_literals_2_0= ruleLiteral )
            	    // InternalItlDsl.g:388:6: lv_literals_2_0= ruleLiteral
            	    {

            	    						newCompositeNode(grammarAccess.getDataTypeInstanceAccess().getLiteralsLiteralParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    lv_literals_2_0=ruleLiteral();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDataTypeInstanceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"literals",
            	    							lv_literals_2_0,
            	    							"com.aestheticintegration.atto.ItlDsl.Literal");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalItlDsl.g:405:4: (otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==21) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalItlDsl.g:406:5: otherlv_3= ',' ( (lv_literals_4_0= ruleLiteral ) )
            	    	    {
            	    	    otherlv_3=(Token)match(input,21,FOLLOW_15); 

            	    	    					newLeafNode(otherlv_3, grammarAccess.getDataTypeInstanceAccess().getCommaKeyword_2_1_0());
            	    	    				
            	    	    // InternalItlDsl.g:410:5: ( (lv_literals_4_0= ruleLiteral ) )
            	    	    // InternalItlDsl.g:411:6: (lv_literals_4_0= ruleLiteral )
            	    	    {
            	    	    // InternalItlDsl.g:411:6: (lv_literals_4_0= ruleLiteral )
            	    	    // InternalItlDsl.g:412:7: lv_literals_4_0= ruleLiteral
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getDataTypeInstanceAccess().getLiteralsLiteralParserRuleCall_2_1_1_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_literals_4_0=ruleLiteral();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getDataTypeInstanceRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"literals",
            	    	    								lv_literals_4_0,
            	    	    								"com.aestheticintegration.atto.ItlDsl.Literal");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

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

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getDataTypeInstanceAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTypeInstance"


    // $ANTLR start "entryRuleDefFunction"
    // InternalItlDsl.g:439:1: entryRuleDefFunction returns [EObject current=null] : iv_ruleDefFunction= ruleDefFunction EOF ;
    public final EObject entryRuleDefFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefFunction = null;


        try {
            // InternalItlDsl.g:439:52: (iv_ruleDefFunction= ruleDefFunction EOF )
            // InternalItlDsl.g:440:2: iv_ruleDefFunction= ruleDefFunction EOF
            {
             newCompositeNode(grammarAccess.getDefFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefFunction=ruleDefFunction();

            state._fsp--;

             current =iv_ruleDefFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefFunction"


    // $ANTLR start "ruleDefFunction"
    // InternalItlDsl.g:446:1: ruleDefFunction returns [EObject current=null] : (otherlv_0= 'function' ( (lv_name_1_0= ruleQualifiedName2 ) ) otherlv_2= '(' ( ( (lv_inputParams_3_0= ruleInputParam ) ) (otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_outputDataType_8_0= ruleDataType ) ) otherlv_9= '{' ( (lv_functionBody_10_0= ruleFunctionBody ) ) otherlv_11= '}' ) ;
    public final EObject ruleDefFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputParams_3_0 = null;

        EObject lv_inputParams_5_0 = null;

        EObject lv_outputDataType_8_0 = null;

        EObject lv_functionBody_10_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:452:2: ( (otherlv_0= 'function' ( (lv_name_1_0= ruleQualifiedName2 ) ) otherlv_2= '(' ( ( (lv_inputParams_3_0= ruleInputParam ) ) (otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_outputDataType_8_0= ruleDataType ) ) otherlv_9= '{' ( (lv_functionBody_10_0= ruleFunctionBody ) ) otherlv_11= '}' ) )
            // InternalItlDsl.g:453:2: (otherlv_0= 'function' ( (lv_name_1_0= ruleQualifiedName2 ) ) otherlv_2= '(' ( ( (lv_inputParams_3_0= ruleInputParam ) ) (otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_outputDataType_8_0= ruleDataType ) ) otherlv_9= '{' ( (lv_functionBody_10_0= ruleFunctionBody ) ) otherlv_11= '}' )
            {
            // InternalItlDsl.g:453:2: (otherlv_0= 'function' ( (lv_name_1_0= ruleQualifiedName2 ) ) otherlv_2= '(' ( ( (lv_inputParams_3_0= ruleInputParam ) ) (otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_outputDataType_8_0= ruleDataType ) ) otherlv_9= '{' ( (lv_functionBody_10_0= ruleFunctionBody ) ) otherlv_11= '}' )
            // InternalItlDsl.g:454:3: otherlv_0= 'function' ( (lv_name_1_0= ruleQualifiedName2 ) ) otherlv_2= '(' ( ( (lv_inputParams_3_0= ruleInputParam ) ) (otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_outputDataType_8_0= ruleDataType ) ) otherlv_9= '{' ( (lv_functionBody_10_0= ruleFunctionBody ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDefFunctionAccess().getFunctionKeyword_0());
            		
            // InternalItlDsl.g:458:3: ( (lv_name_1_0= ruleQualifiedName2 ) )
            // InternalItlDsl.g:459:4: (lv_name_1_0= ruleQualifiedName2 )
            {
            // InternalItlDsl.g:459:4: (lv_name_1_0= ruleQualifiedName2 )
            // InternalItlDsl.g:460:5: lv_name_1_0= ruleQualifiedName2
            {

            					newCompositeNode(grammarAccess.getDefFunctionAccess().getNameQualifiedName2ParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
            lv_name_1_0=ruleQualifiedName2();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.aestheticintegration.atto.ItlDsl.QualifiedName2");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getDefFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalItlDsl.g:481:3: ( ( (lv_inputParams_3_0= ruleInputParam ) ) (otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalItlDsl.g:482:4: ( (lv_inputParams_3_0= ruleInputParam ) ) (otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) ) )*
                    {
                    // InternalItlDsl.g:482:4: ( (lv_inputParams_3_0= ruleInputParam ) )
                    // InternalItlDsl.g:483:5: (lv_inputParams_3_0= ruleInputParam )
                    {
                    // InternalItlDsl.g:483:5: (lv_inputParams_3_0= ruleInputParam )
                    // InternalItlDsl.g:484:6: lv_inputParams_3_0= ruleInputParam
                    {

                    						newCompositeNode(grammarAccess.getDefFunctionAccess().getInputParamsInputParamParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_inputParams_3_0=ruleInputParam();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDefFunctionRule());
                    						}
                    						add(
                    							current,
                    							"inputParams",
                    							lv_inputParams_3_0,
                    							"com.aestheticintegration.atto.ItlDsl.InputParam");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalItlDsl.g:501:4: (otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalItlDsl.g:502:5: otherlv_4= ',' ( (lv_inputParams_5_0= ruleInputParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_8); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDefFunctionAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalItlDsl.g:506:5: ( (lv_inputParams_5_0= ruleInputParam ) )
                    	    // InternalItlDsl.g:507:6: (lv_inputParams_5_0= ruleInputParam )
                    	    {
                    	    // InternalItlDsl.g:507:6: (lv_inputParams_5_0= ruleInputParam )
                    	    // InternalItlDsl.g:508:7: lv_inputParams_5_0= ruleInputParam
                    	    {

                    	    							newCompositeNode(grammarAccess.getDefFunctionAccess().getInputParamsInputParamParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_17);
                    	    lv_inputParams_5_0=ruleInputParam();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDefFunctionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"inputParams",
                    	    								lv_inputParams_5_0,
                    	    								"com.aestheticintegration.atto.ItlDsl.InputParam");
                    	    							afterParserOrEnumRuleCall();
                    	    						

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

            otherlv_6=(Token)match(input,22,FOLLOW_18); 

            			newLeafNode(otherlv_6, grammarAccess.getDefFunctionAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,24,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getDefFunctionAccess().getColonKeyword_5());
            		
            // InternalItlDsl.g:535:3: ( (lv_outputDataType_8_0= ruleDataType ) )
            // InternalItlDsl.g:536:4: (lv_outputDataType_8_0= ruleDataType )
            {
            // InternalItlDsl.g:536:4: (lv_outputDataType_8_0= ruleDataType )
            // InternalItlDsl.g:537:5: lv_outputDataType_8_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getDefFunctionAccess().getOutputDataTypeDataTypeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_9);
            lv_outputDataType_8_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefFunctionRule());
            					}
            					set(
            						current,
            						"outputDataType",
            						lv_outputDataType_8_0,
            						"com.aestheticintegration.atto.ItlDsl.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_20); 

            			newLeafNode(otherlv_9, grammarAccess.getDefFunctionAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalItlDsl.g:558:3: ( (lv_functionBody_10_0= ruleFunctionBody ) )
            // InternalItlDsl.g:559:4: (lv_functionBody_10_0= ruleFunctionBody )
            {
            // InternalItlDsl.g:559:4: (lv_functionBody_10_0= ruleFunctionBody )
            // InternalItlDsl.g:560:5: lv_functionBody_10_0= ruleFunctionBody
            {

            					newCompositeNode(grammarAccess.getDefFunctionAccess().getFunctionBodyFunctionBodyParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_21);
            lv_functionBody_10_0=ruleFunctionBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefFunctionRule());
            					}
            					set(
            						current,
            						"functionBody",
            						lv_functionBody_10_0,
            						"com.aestheticintegration.atto.ItlDsl.FunctionBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getDefFunctionAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefFunction"


    // $ANTLR start "entryRuleInputParam"
    // InternalItlDsl.g:585:1: entryRuleInputParam returns [EObject current=null] : iv_ruleInputParam= ruleInputParam EOF ;
    public final EObject entryRuleInputParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputParam = null;


        try {
            // InternalItlDsl.g:585:51: (iv_ruleInputParam= ruleInputParam EOF )
            // InternalItlDsl.g:586:2: iv_ruleInputParam= ruleInputParam EOF
            {
             newCompositeNode(grammarAccess.getInputParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInputParam=ruleInputParam();

            state._fsp--;

             current =iv_ruleInputParam; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInputParam"


    // $ANTLR start "ruleInputParam"
    // InternalItlDsl.g:592:1: ruleInputParam returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inputDataType_2_0= ruleDataType ) ) ) ;
    public final EObject ruleInputParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_inputDataType_2_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:598:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inputDataType_2_0= ruleDataType ) ) ) )
            // InternalItlDsl.g:599:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inputDataType_2_0= ruleDataType ) ) )
            {
            // InternalItlDsl.g:599:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inputDataType_2_0= ruleDataType ) ) )
            // InternalItlDsl.g:600:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inputDataType_2_0= ruleDataType ) )
            {
            // InternalItlDsl.g:600:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalItlDsl.g:601:4: (lv_name_0_0= RULE_ID )
            {
            // InternalItlDsl.g:601:4: (lv_name_0_0= RULE_ID )
            // InternalItlDsl.g:602:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getInputParamAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInputParamRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"com.aestheticintegration.atto.ItlDsl.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getInputParamAccess().getColonKeyword_1());
            		
            // InternalItlDsl.g:622:3: ( (lv_inputDataType_2_0= ruleDataType ) )
            // InternalItlDsl.g:623:4: (lv_inputDataType_2_0= ruleDataType )
            {
            // InternalItlDsl.g:623:4: (lv_inputDataType_2_0= ruleDataType )
            // InternalItlDsl.g:624:5: lv_inputDataType_2_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getInputParamAccess().getInputDataTypeDataTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_inputDataType_2_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInputParamRule());
            					}
            					set(
            						current,
            						"inputDataType",
            						lv_inputDataType_2_0,
            						"com.aestheticintegration.atto.ItlDsl.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputParam"


    // $ANTLR start "entryRuleDataType"
    // InternalItlDsl.g:645:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalItlDsl.g:645:49: (iv_ruleDataType= ruleDataType EOF )
            // InternalItlDsl.g:646:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalItlDsl.g:652:1: ruleDataType returns [EObject current=null] : ( ( (lv_boolean_0_0= 'boolean' ) ) | ( (lv_booleanObj_1_0= 'Boolean' ) ) | ( (lv_short_2_0= 'short' ) ) | ( (lv_shortObj_3_0= 'Short' ) ) | ( (lv_int_4_0= 'int' ) ) | ( (lv_intObj_5_0= 'Integer' ) ) | ( (lv_long_6_0= 'long' ) ) | ( (lv_longObj_7_0= 'Long' ) ) | ( (lv_float_8_0= 'float' ) ) | ( (lv_floatObj_9_0= 'Float' ) ) | ( (lv_double_10_0= 'double' ) ) | ( (lv_doubleObj_11_0= 'Double' ) ) | ( (lv_string_12_0= 'String' ) ) | ( (otherlv_13= RULE_ID ) ) ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token lv_boolean_0_0=null;
        Token lv_booleanObj_1_0=null;
        Token lv_short_2_0=null;
        Token lv_shortObj_3_0=null;
        Token lv_int_4_0=null;
        Token lv_intObj_5_0=null;
        Token lv_long_6_0=null;
        Token lv_longObj_7_0=null;
        Token lv_float_8_0=null;
        Token lv_floatObj_9_0=null;
        Token lv_double_10_0=null;
        Token lv_doubleObj_11_0=null;
        Token lv_string_12_0=null;
        Token otherlv_13=null;


        	enterRule();

        try {
            // InternalItlDsl.g:658:2: ( ( ( (lv_boolean_0_0= 'boolean' ) ) | ( (lv_booleanObj_1_0= 'Boolean' ) ) | ( (lv_short_2_0= 'short' ) ) | ( (lv_shortObj_3_0= 'Short' ) ) | ( (lv_int_4_0= 'int' ) ) | ( (lv_intObj_5_0= 'Integer' ) ) | ( (lv_long_6_0= 'long' ) ) | ( (lv_longObj_7_0= 'Long' ) ) | ( (lv_float_8_0= 'float' ) ) | ( (lv_floatObj_9_0= 'Float' ) ) | ( (lv_double_10_0= 'double' ) ) | ( (lv_doubleObj_11_0= 'Double' ) ) | ( (lv_string_12_0= 'String' ) ) | ( (otherlv_13= RULE_ID ) ) ) )
            // InternalItlDsl.g:659:2: ( ( (lv_boolean_0_0= 'boolean' ) ) | ( (lv_booleanObj_1_0= 'Boolean' ) ) | ( (lv_short_2_0= 'short' ) ) | ( (lv_shortObj_3_0= 'Short' ) ) | ( (lv_int_4_0= 'int' ) ) | ( (lv_intObj_5_0= 'Integer' ) ) | ( (lv_long_6_0= 'long' ) ) | ( (lv_longObj_7_0= 'Long' ) ) | ( (lv_float_8_0= 'float' ) ) | ( (lv_floatObj_9_0= 'Float' ) ) | ( (lv_double_10_0= 'double' ) ) | ( (lv_doubleObj_11_0= 'Double' ) ) | ( (lv_string_12_0= 'String' ) ) | ( (otherlv_13= RULE_ID ) ) )
            {
            // InternalItlDsl.g:659:2: ( ( (lv_boolean_0_0= 'boolean' ) ) | ( (lv_booleanObj_1_0= 'Boolean' ) ) | ( (lv_short_2_0= 'short' ) ) | ( (lv_shortObj_3_0= 'Short' ) ) | ( (lv_int_4_0= 'int' ) ) | ( (lv_intObj_5_0= 'Integer' ) ) | ( (lv_long_6_0= 'long' ) ) | ( (lv_longObj_7_0= 'Long' ) ) | ( (lv_float_8_0= 'float' ) ) | ( (lv_floatObj_9_0= 'Float' ) ) | ( (lv_double_10_0= 'double' ) ) | ( (lv_doubleObj_11_0= 'Double' ) ) | ( (lv_string_12_0= 'String' ) ) | ( (otherlv_13= RULE_ID ) ) )
            int alt11=14;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt11=1;
                }
                break;
            case 26:
                {
                alt11=2;
                }
                break;
            case 27:
                {
                alt11=3;
                }
                break;
            case 28:
                {
                alt11=4;
                }
                break;
            case 29:
                {
                alt11=5;
                }
                break;
            case 30:
                {
                alt11=6;
                }
                break;
            case 31:
                {
                alt11=7;
                }
                break;
            case 32:
                {
                alt11=8;
                }
                break;
            case 33:
                {
                alt11=9;
                }
                break;
            case 34:
                {
                alt11=10;
                }
                break;
            case 35:
                {
                alt11=11;
                }
                break;
            case 36:
                {
                alt11=12;
                }
                break;
            case 37:
                {
                alt11=13;
                }
                break;
            case RULE_ID:
                {
                alt11=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalItlDsl.g:660:3: ( (lv_boolean_0_0= 'boolean' ) )
                    {
                    // InternalItlDsl.g:660:3: ( (lv_boolean_0_0= 'boolean' ) )
                    // InternalItlDsl.g:661:4: (lv_boolean_0_0= 'boolean' )
                    {
                    // InternalItlDsl.g:661:4: (lv_boolean_0_0= 'boolean' )
                    // InternalItlDsl.g:662:5: lv_boolean_0_0= 'boolean'
                    {
                    lv_boolean_0_0=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(lv_boolean_0_0, grammarAccess.getDataTypeAccess().getBooleanBooleanKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "boolean", lv_boolean_0_0, "boolean");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalItlDsl.g:675:3: ( (lv_booleanObj_1_0= 'Boolean' ) )
                    {
                    // InternalItlDsl.g:675:3: ( (lv_booleanObj_1_0= 'Boolean' ) )
                    // InternalItlDsl.g:676:4: (lv_booleanObj_1_0= 'Boolean' )
                    {
                    // InternalItlDsl.g:676:4: (lv_booleanObj_1_0= 'Boolean' )
                    // InternalItlDsl.g:677:5: lv_booleanObj_1_0= 'Boolean'
                    {
                    lv_booleanObj_1_0=(Token)match(input,26,FOLLOW_2); 

                    					newLeafNode(lv_booleanObj_1_0, grammarAccess.getDataTypeAccess().getBooleanObjBooleanKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "booleanObj", lv_booleanObj_1_0, "Boolean");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalItlDsl.g:690:3: ( (lv_short_2_0= 'short' ) )
                    {
                    // InternalItlDsl.g:690:3: ( (lv_short_2_0= 'short' ) )
                    // InternalItlDsl.g:691:4: (lv_short_2_0= 'short' )
                    {
                    // InternalItlDsl.g:691:4: (lv_short_2_0= 'short' )
                    // InternalItlDsl.g:692:5: lv_short_2_0= 'short'
                    {
                    lv_short_2_0=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_short_2_0, grammarAccess.getDataTypeAccess().getShortShortKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "short", lv_short_2_0, "short");
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalItlDsl.g:705:3: ( (lv_shortObj_3_0= 'Short' ) )
                    {
                    // InternalItlDsl.g:705:3: ( (lv_shortObj_3_0= 'Short' ) )
                    // InternalItlDsl.g:706:4: (lv_shortObj_3_0= 'Short' )
                    {
                    // InternalItlDsl.g:706:4: (lv_shortObj_3_0= 'Short' )
                    // InternalItlDsl.g:707:5: lv_shortObj_3_0= 'Short'
                    {
                    lv_shortObj_3_0=(Token)match(input,28,FOLLOW_2); 

                    					newLeafNode(lv_shortObj_3_0, grammarAccess.getDataTypeAccess().getShortObjShortKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "shortObj", lv_shortObj_3_0, "Short");
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalItlDsl.g:720:3: ( (lv_int_4_0= 'int' ) )
                    {
                    // InternalItlDsl.g:720:3: ( (lv_int_4_0= 'int' ) )
                    // InternalItlDsl.g:721:4: (lv_int_4_0= 'int' )
                    {
                    // InternalItlDsl.g:721:4: (lv_int_4_0= 'int' )
                    // InternalItlDsl.g:722:5: lv_int_4_0= 'int'
                    {
                    lv_int_4_0=(Token)match(input,29,FOLLOW_2); 

                    					newLeafNode(lv_int_4_0, grammarAccess.getDataTypeAccess().getIntIntKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "int", lv_int_4_0, "int");
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalItlDsl.g:735:3: ( (lv_intObj_5_0= 'Integer' ) )
                    {
                    // InternalItlDsl.g:735:3: ( (lv_intObj_5_0= 'Integer' ) )
                    // InternalItlDsl.g:736:4: (lv_intObj_5_0= 'Integer' )
                    {
                    // InternalItlDsl.g:736:4: (lv_intObj_5_0= 'Integer' )
                    // InternalItlDsl.g:737:5: lv_intObj_5_0= 'Integer'
                    {
                    lv_intObj_5_0=(Token)match(input,30,FOLLOW_2); 

                    					newLeafNode(lv_intObj_5_0, grammarAccess.getDataTypeAccess().getIntObjIntegerKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "intObj", lv_intObj_5_0, "Integer");
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalItlDsl.g:750:3: ( (lv_long_6_0= 'long' ) )
                    {
                    // InternalItlDsl.g:750:3: ( (lv_long_6_0= 'long' ) )
                    // InternalItlDsl.g:751:4: (lv_long_6_0= 'long' )
                    {
                    // InternalItlDsl.g:751:4: (lv_long_6_0= 'long' )
                    // InternalItlDsl.g:752:5: lv_long_6_0= 'long'
                    {
                    lv_long_6_0=(Token)match(input,31,FOLLOW_2); 

                    					newLeafNode(lv_long_6_0, grammarAccess.getDataTypeAccess().getLongLongKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "long", lv_long_6_0, "long");
                    				

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalItlDsl.g:765:3: ( (lv_longObj_7_0= 'Long' ) )
                    {
                    // InternalItlDsl.g:765:3: ( (lv_longObj_7_0= 'Long' ) )
                    // InternalItlDsl.g:766:4: (lv_longObj_7_0= 'Long' )
                    {
                    // InternalItlDsl.g:766:4: (lv_longObj_7_0= 'Long' )
                    // InternalItlDsl.g:767:5: lv_longObj_7_0= 'Long'
                    {
                    lv_longObj_7_0=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(lv_longObj_7_0, grammarAccess.getDataTypeAccess().getLongObjLongKeyword_7_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "longObj", lv_longObj_7_0, "Long");
                    				

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalItlDsl.g:780:3: ( (lv_float_8_0= 'float' ) )
                    {
                    // InternalItlDsl.g:780:3: ( (lv_float_8_0= 'float' ) )
                    // InternalItlDsl.g:781:4: (lv_float_8_0= 'float' )
                    {
                    // InternalItlDsl.g:781:4: (lv_float_8_0= 'float' )
                    // InternalItlDsl.g:782:5: lv_float_8_0= 'float'
                    {
                    lv_float_8_0=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_float_8_0, grammarAccess.getDataTypeAccess().getFloatFloatKeyword_8_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "float", lv_float_8_0, "float");
                    				

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalItlDsl.g:795:3: ( (lv_floatObj_9_0= 'Float' ) )
                    {
                    // InternalItlDsl.g:795:3: ( (lv_floatObj_9_0= 'Float' ) )
                    // InternalItlDsl.g:796:4: (lv_floatObj_9_0= 'Float' )
                    {
                    // InternalItlDsl.g:796:4: (lv_floatObj_9_0= 'Float' )
                    // InternalItlDsl.g:797:5: lv_floatObj_9_0= 'Float'
                    {
                    lv_floatObj_9_0=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_floatObj_9_0, grammarAccess.getDataTypeAccess().getFloatObjFloatKeyword_9_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "floatObj", lv_floatObj_9_0, "Float");
                    				

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalItlDsl.g:810:3: ( (lv_double_10_0= 'double' ) )
                    {
                    // InternalItlDsl.g:810:3: ( (lv_double_10_0= 'double' ) )
                    // InternalItlDsl.g:811:4: (lv_double_10_0= 'double' )
                    {
                    // InternalItlDsl.g:811:4: (lv_double_10_0= 'double' )
                    // InternalItlDsl.g:812:5: lv_double_10_0= 'double'
                    {
                    lv_double_10_0=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_double_10_0, grammarAccess.getDataTypeAccess().getDoubleDoubleKeyword_10_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "double", lv_double_10_0, "double");
                    				

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalItlDsl.g:825:3: ( (lv_doubleObj_11_0= 'Double' ) )
                    {
                    // InternalItlDsl.g:825:3: ( (lv_doubleObj_11_0= 'Double' ) )
                    // InternalItlDsl.g:826:4: (lv_doubleObj_11_0= 'Double' )
                    {
                    // InternalItlDsl.g:826:4: (lv_doubleObj_11_0= 'Double' )
                    // InternalItlDsl.g:827:5: lv_doubleObj_11_0= 'Double'
                    {
                    lv_doubleObj_11_0=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_doubleObj_11_0, grammarAccess.getDataTypeAccess().getDoubleObjDoubleKeyword_11_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "doubleObj", lv_doubleObj_11_0, "Double");
                    				

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalItlDsl.g:840:3: ( (lv_string_12_0= 'String' ) )
                    {
                    // InternalItlDsl.g:840:3: ( (lv_string_12_0= 'String' ) )
                    // InternalItlDsl.g:841:4: (lv_string_12_0= 'String' )
                    {
                    // InternalItlDsl.g:841:4: (lv_string_12_0= 'String' )
                    // InternalItlDsl.g:842:5: lv_string_12_0= 'String'
                    {
                    lv_string_12_0=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_string_12_0, grammarAccess.getDataTypeAccess().getStringStringKeyword_12_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    					setWithLastConsumed(current, "string", lv_string_12_0, "String");
                    				

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalItlDsl.g:855:3: ( (otherlv_13= RULE_ID ) )
                    {
                    // InternalItlDsl.g:855:3: ( (otherlv_13= RULE_ID ) )
                    // InternalItlDsl.g:856:4: (otherlv_13= RULE_ID )
                    {
                    // InternalItlDsl.g:856:4: (otherlv_13= RULE_ID )
                    // InternalItlDsl.g:857:5: otherlv_13= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeRule());
                    					}
                    				
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_13, grammarAccess.getDataTypeAccess().getDefDataTypeDefDataTypeCrossReference_13_0());
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleFunctionBody"
    // InternalItlDsl.g:872:1: entryRuleFunctionBody returns [EObject current=null] : iv_ruleFunctionBody= ruleFunctionBody EOF ;
    public final EObject entryRuleFunctionBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionBody = null;


        try {
            // InternalItlDsl.g:872:53: (iv_ruleFunctionBody= ruleFunctionBody EOF )
            // InternalItlDsl.g:873:2: iv_ruleFunctionBody= ruleFunctionBody EOF
            {
             newCompositeNode(grammarAccess.getFunctionBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionBody=ruleFunctionBody();

            state._fsp--;

             current =iv_ruleFunctionBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionBody"


    // $ANTLR start "ruleFunctionBody"
    // InternalItlDsl.g:879:1: ruleFunctionBody returns [EObject current=null] : ( () ( (lv_statement_1_0= ruleStatement ) )* ) ;
    public final EObject ruleFunctionBody() throws RecognitionException {
        EObject current = null;

        EObject lv_statement_1_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:885:2: ( ( () ( (lv_statement_1_0= ruleStatement ) )* ) )
            // InternalItlDsl.g:886:2: ( () ( (lv_statement_1_0= ruleStatement ) )* )
            {
            // InternalItlDsl.g:886:2: ( () ( (lv_statement_1_0= ruleStatement ) )* )
            // InternalItlDsl.g:887:3: () ( (lv_statement_1_0= ruleStatement ) )*
            {
            // InternalItlDsl.g:887:3: ()
            // InternalItlDsl.g:888:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFunctionBodyAccess().getFunctionBodyAction_0(),
            					current);
            			

            }

            // InternalItlDsl.g:894:3: ( (lv_statement_1_0= ruleStatement ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_ID && LA12_0<=RULE_NULL)||LA12_0==38||LA12_0==50) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalItlDsl.g:895:4: (lv_statement_1_0= ruleStatement )
            	    {
            	    // InternalItlDsl.g:895:4: (lv_statement_1_0= ruleStatement )
            	    // InternalItlDsl.g:896:5: lv_statement_1_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getFunctionBodyAccess().getStatementStatementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_22);
            	    lv_statement_1_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statement",
            	    						lv_statement_1_0,
            	    						"com.aestheticintegration.atto.ItlDsl.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionBody"


    // $ANTLR start "entryRuleStatement"
    // InternalItlDsl.g:917:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalItlDsl.g:917:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalItlDsl.g:918:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalItlDsl.g:924:1: ruleStatement returns [EObject current=null] : ( ( (lv_ifStatement_0_0= ruleIfStatement ) ) | ( (lv_outputExpression_1_0= ruleOutputExpression ) ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_ifStatement_0_0 = null;

        EObject lv_outputExpression_1_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:930:2: ( ( ( (lv_ifStatement_0_0= ruleIfStatement ) ) | ( (lv_outputExpression_1_0= ruleOutputExpression ) ) ) )
            // InternalItlDsl.g:931:2: ( ( (lv_ifStatement_0_0= ruleIfStatement ) ) | ( (lv_outputExpression_1_0= ruleOutputExpression ) ) )
            {
            // InternalItlDsl.g:931:2: ( ( (lv_ifStatement_0_0= ruleIfStatement ) ) | ( (lv_outputExpression_1_0= ruleOutputExpression ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_NULL)||LA13_0==50) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalItlDsl.g:932:3: ( (lv_ifStatement_0_0= ruleIfStatement ) )
                    {
                    // InternalItlDsl.g:932:3: ( (lv_ifStatement_0_0= ruleIfStatement ) )
                    // InternalItlDsl.g:933:4: (lv_ifStatement_0_0= ruleIfStatement )
                    {
                    // InternalItlDsl.g:933:4: (lv_ifStatement_0_0= ruleIfStatement )
                    // InternalItlDsl.g:934:5: lv_ifStatement_0_0= ruleIfStatement
                    {

                    					newCompositeNode(grammarAccess.getStatementAccess().getIfStatementIfStatementParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_ifStatement_0_0=ruleIfStatement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStatementRule());
                    					}
                    					set(
                    						current,
                    						"ifStatement",
                    						lv_ifStatement_0_0,
                    						"com.aestheticintegration.atto.ItlDsl.IfStatement");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalItlDsl.g:952:3: ( (lv_outputExpression_1_0= ruleOutputExpression ) )
                    {
                    // InternalItlDsl.g:952:3: ( (lv_outputExpression_1_0= ruleOutputExpression ) )
                    // InternalItlDsl.g:953:4: (lv_outputExpression_1_0= ruleOutputExpression )
                    {
                    // InternalItlDsl.g:953:4: (lv_outputExpression_1_0= ruleOutputExpression )
                    // InternalItlDsl.g:954:5: lv_outputExpression_1_0= ruleOutputExpression
                    {

                    					newCompositeNode(grammarAccess.getStatementAccess().getOutputExpressionOutputExpressionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_outputExpression_1_0=ruleOutputExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStatementRule());
                    					}
                    					set(
                    						current,
                    						"outputExpression",
                    						lv_outputExpression_1_0,
                    						"com.aestheticintegration.atto.ItlDsl.OutputExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleIfStatement"
    // InternalItlDsl.g:975:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalItlDsl.g:975:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalItlDsl.g:976:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalItlDsl.g:982:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_inputBoolExpression_2_0= ruleBoolExpression ) ) ( ( ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) ) ) ( (lv_inputBoolExpression_4_0= ruleBoolExpression ) ) )* otherlv_5= ')' otherlv_6= 'then' ( (lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement ) ) otherlv_8= 'else' ( (lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement ) ) otherlv_10= 'endif' ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_sign_3_1=null;
        Token lv_sign_3_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_inputBoolExpression_2_0 = null;

        EObject lv_inputBoolExpression_4_0 = null;

        EObject lv_thenExpOrIfStatement_7_0 = null;

        EObject lv_elseExpOrIfStatement_9_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:988:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_inputBoolExpression_2_0= ruleBoolExpression ) ) ( ( ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) ) ) ( (lv_inputBoolExpression_4_0= ruleBoolExpression ) ) )* otherlv_5= ')' otherlv_6= 'then' ( (lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement ) ) otherlv_8= 'else' ( (lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement ) ) otherlv_10= 'endif' ) )
            // InternalItlDsl.g:989:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_inputBoolExpression_2_0= ruleBoolExpression ) ) ( ( ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) ) ) ( (lv_inputBoolExpression_4_0= ruleBoolExpression ) ) )* otherlv_5= ')' otherlv_6= 'then' ( (lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement ) ) otherlv_8= 'else' ( (lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement ) ) otherlv_10= 'endif' )
            {
            // InternalItlDsl.g:989:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_inputBoolExpression_2_0= ruleBoolExpression ) ) ( ( ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) ) ) ( (lv_inputBoolExpression_4_0= ruleBoolExpression ) ) )* otherlv_5= ')' otherlv_6= 'then' ( (lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement ) ) otherlv_8= 'else' ( (lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement ) ) otherlv_10= 'endif' )
            // InternalItlDsl.g:990:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_inputBoolExpression_2_0= ruleBoolExpression ) ) ( ( ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) ) ) ( (lv_inputBoolExpression_4_0= ruleBoolExpression ) ) )* otherlv_5= ')' otherlv_6= 'then' ( (lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement ) ) otherlv_8= 'else' ( (lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement ) ) otherlv_10= 'endif'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
            		
            otherlv_1=(Token)match(input,20,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
            		
            // InternalItlDsl.g:998:3: ( (lv_inputBoolExpression_2_0= ruleBoolExpression ) )
            // InternalItlDsl.g:999:4: (lv_inputBoolExpression_2_0= ruleBoolExpression )
            {
            // InternalItlDsl.g:999:4: (lv_inputBoolExpression_2_0= ruleBoolExpression )
            // InternalItlDsl.g:1000:5: lv_inputBoolExpression_2_0= ruleBoolExpression
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getInputBoolExpressionBoolExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_inputBoolExpression_2_0=ruleBoolExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					add(
            						current,
            						"inputBoolExpression",
            						lv_inputBoolExpression_2_0,
            						"com.aestheticintegration.atto.ItlDsl.BoolExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalItlDsl.g:1017:3: ( ( ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) ) ) ( (lv_inputBoolExpression_4_0= ruleBoolExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=39 && LA15_0<=40)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalItlDsl.g:1018:4: ( ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) ) ) ( (lv_inputBoolExpression_4_0= ruleBoolExpression ) )
            	    {
            	    // InternalItlDsl.g:1018:4: ( ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) ) )
            	    // InternalItlDsl.g:1019:5: ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) )
            	    {
            	    // InternalItlDsl.g:1019:5: ( (lv_sign_3_1= '&&' | lv_sign_3_2= '||' ) )
            	    // InternalItlDsl.g:1020:6: (lv_sign_3_1= '&&' | lv_sign_3_2= '||' )
            	    {
            	    // InternalItlDsl.g:1020:6: (lv_sign_3_1= '&&' | lv_sign_3_2= '||' )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==39) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==40) ) {
            	        alt14=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalItlDsl.g:1021:7: lv_sign_3_1= '&&'
            	            {
            	            lv_sign_3_1=(Token)match(input,39,FOLLOW_15); 

            	            							newLeafNode(lv_sign_3_1, grammarAccess.getIfStatementAccess().getSignAmpersandAmpersandKeyword_3_0_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getIfStatementRule());
            	            							}
            	            							addWithLastConsumed(current, "sign", lv_sign_3_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalItlDsl.g:1032:7: lv_sign_3_2= '||'
            	            {
            	            lv_sign_3_2=(Token)match(input,40,FOLLOW_15); 

            	            							newLeafNode(lv_sign_3_2, grammarAccess.getIfStatementAccess().getSignVerticalLineVerticalLineKeyword_3_0_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getIfStatementRule());
            	            							}
            	            							addWithLastConsumed(current, "sign", lv_sign_3_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalItlDsl.g:1045:4: ( (lv_inputBoolExpression_4_0= ruleBoolExpression ) )
            	    // InternalItlDsl.g:1046:5: (lv_inputBoolExpression_4_0= ruleBoolExpression )
            	    {
            	    // InternalItlDsl.g:1046:5: (lv_inputBoolExpression_4_0= ruleBoolExpression )
            	    // InternalItlDsl.g:1047:6: lv_inputBoolExpression_4_0= ruleBoolExpression
            	    {

            	    						newCompositeNode(grammarAccess.getIfStatementAccess().getInputBoolExpressionBoolExpressionParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_inputBoolExpression_4_0=ruleBoolExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputBoolExpression",
            	    							lv_inputBoolExpression_4_0,
            	    							"com.aestheticintegration.atto.ItlDsl.BoolExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_24); 

            			newLeafNode(otherlv_5, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,41,FOLLOW_25); 

            			newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getThenKeyword_5());
            		
            // InternalItlDsl.g:1073:3: ( (lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement ) )
            // InternalItlDsl.g:1074:4: (lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement )
            {
            // InternalItlDsl.g:1074:4: (lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement )
            // InternalItlDsl.g:1075:5: lv_thenExpOrIfStatement_7_0= ruleExpOrIfStatement
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getThenExpOrIfStatementExpOrIfStatementParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_26);
            lv_thenExpOrIfStatement_7_0=ruleExpOrIfStatement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					set(
            						current,
            						"thenExpOrIfStatement",
            						lv_thenExpOrIfStatement_7_0,
            						"com.aestheticintegration.atto.ItlDsl.ExpOrIfStatement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,42,FOLLOW_25); 

            			newLeafNode(otherlv_8, grammarAccess.getIfStatementAccess().getElseKeyword_7());
            		
            // InternalItlDsl.g:1096:3: ( (lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement ) )
            // InternalItlDsl.g:1097:4: (lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement )
            {
            // InternalItlDsl.g:1097:4: (lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement )
            // InternalItlDsl.g:1098:5: lv_elseExpOrIfStatement_9_0= ruleExpOrIfStatement
            {

            					newCompositeNode(grammarAccess.getIfStatementAccess().getElseExpOrIfStatementExpOrIfStatementParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_27);
            lv_elseExpOrIfStatement_9_0=ruleExpOrIfStatement();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            					}
            					set(
            						current,
            						"elseExpOrIfStatement",
            						lv_elseExpOrIfStatement_9_0,
            						"com.aestheticintegration.atto.ItlDsl.ExpOrIfStatement");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,43,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getIfStatementAccess().getEndifKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleExpOrIfStatement"
    // InternalItlDsl.g:1123:1: entryRuleExpOrIfStatement returns [EObject current=null] : iv_ruleExpOrIfStatement= ruleExpOrIfStatement EOF ;
    public final EObject entryRuleExpOrIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpOrIfStatement = null;


        try {
            // InternalItlDsl.g:1123:57: (iv_ruleExpOrIfStatement= ruleExpOrIfStatement EOF )
            // InternalItlDsl.g:1124:2: iv_ruleExpOrIfStatement= ruleExpOrIfStatement EOF
            {
             newCompositeNode(grammarAccess.getExpOrIfStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpOrIfStatement=ruleExpOrIfStatement();

            state._fsp--;

             current =iv_ruleExpOrIfStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpOrIfStatement"


    // $ANTLR start "ruleExpOrIfStatement"
    // InternalItlDsl.g:1130:1: ruleExpOrIfStatement returns [EObject current=null] : ( ( (lv_outputExpression_0_0= ruleOutputExpression ) ) | ( (lv_ifStatement_1_0= ruleIfStatement ) ) ) ;
    public final EObject ruleExpOrIfStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_outputExpression_0_0 = null;

        EObject lv_ifStatement_1_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:1136:2: ( ( ( (lv_outputExpression_0_0= ruleOutputExpression ) ) | ( (lv_ifStatement_1_0= ruleIfStatement ) ) ) )
            // InternalItlDsl.g:1137:2: ( ( (lv_outputExpression_0_0= ruleOutputExpression ) ) | ( (lv_ifStatement_1_0= ruleIfStatement ) ) )
            {
            // InternalItlDsl.g:1137:2: ( ( (lv_outputExpression_0_0= ruleOutputExpression ) ) | ( (lv_ifStatement_1_0= ruleIfStatement ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_NULL)||LA16_0==50) ) {
                alt16=1;
            }
            else if ( (LA16_0==38) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalItlDsl.g:1138:3: ( (lv_outputExpression_0_0= ruleOutputExpression ) )
                    {
                    // InternalItlDsl.g:1138:3: ( (lv_outputExpression_0_0= ruleOutputExpression ) )
                    // InternalItlDsl.g:1139:4: (lv_outputExpression_0_0= ruleOutputExpression )
                    {
                    // InternalItlDsl.g:1139:4: (lv_outputExpression_0_0= ruleOutputExpression )
                    // InternalItlDsl.g:1140:5: lv_outputExpression_0_0= ruleOutputExpression
                    {

                    					newCompositeNode(grammarAccess.getExpOrIfStatementAccess().getOutputExpressionOutputExpressionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_outputExpression_0_0=ruleOutputExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpOrIfStatementRule());
                    					}
                    					set(
                    						current,
                    						"outputExpression",
                    						lv_outputExpression_0_0,
                    						"com.aestheticintegration.atto.ItlDsl.OutputExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalItlDsl.g:1158:3: ( (lv_ifStatement_1_0= ruleIfStatement ) )
                    {
                    // InternalItlDsl.g:1158:3: ( (lv_ifStatement_1_0= ruleIfStatement ) )
                    // InternalItlDsl.g:1159:4: (lv_ifStatement_1_0= ruleIfStatement )
                    {
                    // InternalItlDsl.g:1159:4: (lv_ifStatement_1_0= ruleIfStatement )
                    // InternalItlDsl.g:1160:5: lv_ifStatement_1_0= ruleIfStatement
                    {

                    					newCompositeNode(grammarAccess.getExpOrIfStatementAccess().getIfStatementIfStatementParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_ifStatement_1_0=ruleIfStatement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getExpOrIfStatementRule());
                    					}
                    					set(
                    						current,
                    						"ifStatement",
                    						lv_ifStatement_1_0,
                    						"com.aestheticintegration.atto.ItlDsl.IfStatement");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpOrIfStatement"


    // $ANTLR start "entryRuleBoolExpression"
    // InternalItlDsl.g:1181:1: entryRuleBoolExpression returns [EObject current=null] : iv_ruleBoolExpression= ruleBoolExpression EOF ;
    public final EObject entryRuleBoolExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolExpression = null;


        try {
            // InternalItlDsl.g:1181:55: (iv_ruleBoolExpression= ruleBoolExpression EOF )
            // InternalItlDsl.g:1182:2: iv_ruleBoolExpression= ruleBoolExpression EOF
            {
             newCompositeNode(grammarAccess.getBoolExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolExpression=ruleBoolExpression();

            state._fsp--;

             current =iv_ruleBoolExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolExpression"


    // $ANTLR start "ruleBoolExpression"
    // InternalItlDsl.g:1188:1: ruleBoolExpression returns [EObject current=null] : ( ( (lv_literalLeft_0_0= ruleLiteral ) ) ( ( ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) ) ) ( (lv_literalRight_2_0= ruleLiteral ) ) )? ) ;
    public final EObject ruleBoolExpression() throws RecognitionException {
        EObject current = null;

        Token lv_sign_1_1=null;
        Token lv_sign_1_2=null;
        Token lv_sign_1_3=null;
        Token lv_sign_1_4=null;
        Token lv_sign_1_5=null;
        Token lv_sign_1_6=null;
        EObject lv_literalLeft_0_0 = null;

        EObject lv_literalRight_2_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:1194:2: ( ( ( (lv_literalLeft_0_0= ruleLiteral ) ) ( ( ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) ) ) ( (lv_literalRight_2_0= ruleLiteral ) ) )? ) )
            // InternalItlDsl.g:1195:2: ( ( (lv_literalLeft_0_0= ruleLiteral ) ) ( ( ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) ) ) ( (lv_literalRight_2_0= ruleLiteral ) ) )? )
            {
            // InternalItlDsl.g:1195:2: ( ( (lv_literalLeft_0_0= ruleLiteral ) ) ( ( ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) ) ) ( (lv_literalRight_2_0= ruleLiteral ) ) )? )
            // InternalItlDsl.g:1196:3: ( (lv_literalLeft_0_0= ruleLiteral ) ) ( ( ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) ) ) ( (lv_literalRight_2_0= ruleLiteral ) ) )?
            {
            // InternalItlDsl.g:1196:3: ( (lv_literalLeft_0_0= ruleLiteral ) )
            // InternalItlDsl.g:1197:4: (lv_literalLeft_0_0= ruleLiteral )
            {
            // InternalItlDsl.g:1197:4: (lv_literalLeft_0_0= ruleLiteral )
            // InternalItlDsl.g:1198:5: lv_literalLeft_0_0= ruleLiteral
            {

            					newCompositeNode(grammarAccess.getBoolExpressionAccess().getLiteralLeftLiteralParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_28);
            lv_literalLeft_0_0=ruleLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBoolExpressionRule());
            					}
            					set(
            						current,
            						"literalLeft",
            						lv_literalLeft_0_0,
            						"com.aestheticintegration.atto.ItlDsl.Literal");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalItlDsl.g:1215:3: ( ( ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) ) ) ( (lv_literalRight_2_0= ruleLiteral ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19||(LA18_0>=44 && LA18_0<=48)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalItlDsl.g:1216:4: ( ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) ) ) ( (lv_literalRight_2_0= ruleLiteral ) )
                    {
                    // InternalItlDsl.g:1216:4: ( ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) ) )
                    // InternalItlDsl.g:1217:5: ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) )
                    {
                    // InternalItlDsl.g:1217:5: ( (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' ) )
                    // InternalItlDsl.g:1218:6: (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' )
                    {
                    // InternalItlDsl.g:1218:6: (lv_sign_1_1= '<=' | lv_sign_1_2= '>=' | lv_sign_1_3= '>' | lv_sign_1_4= '<' | lv_sign_1_5= '=' | lv_sign_1_6= '<>' )
                    int alt17=6;
                    switch ( input.LA(1) ) {
                    case 44:
                        {
                        alt17=1;
                        }
                        break;
                    case 45:
                        {
                        alt17=2;
                        }
                        break;
                    case 46:
                        {
                        alt17=3;
                        }
                        break;
                    case 47:
                        {
                        alt17=4;
                        }
                        break;
                    case 19:
                        {
                        alt17=5;
                        }
                        break;
                    case 48:
                        {
                        alt17=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }

                    switch (alt17) {
                        case 1 :
                            // InternalItlDsl.g:1219:7: lv_sign_1_1= '<='
                            {
                            lv_sign_1_1=(Token)match(input,44,FOLLOW_15); 

                            							newLeafNode(lv_sign_1_1, grammarAccess.getBoolExpressionAccess().getSignLessThanSignEqualsSignKeyword_1_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getBoolExpressionRule());
                            							}
                            							setWithLastConsumed(current, "sign", lv_sign_1_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalItlDsl.g:1230:7: lv_sign_1_2= '>='
                            {
                            lv_sign_1_2=(Token)match(input,45,FOLLOW_15); 

                            							newLeafNode(lv_sign_1_2, grammarAccess.getBoolExpressionAccess().getSignGreaterThanSignEqualsSignKeyword_1_0_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getBoolExpressionRule());
                            							}
                            							setWithLastConsumed(current, "sign", lv_sign_1_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalItlDsl.g:1241:7: lv_sign_1_3= '>'
                            {
                            lv_sign_1_3=(Token)match(input,46,FOLLOW_15); 

                            							newLeafNode(lv_sign_1_3, grammarAccess.getBoolExpressionAccess().getSignGreaterThanSignKeyword_1_0_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getBoolExpressionRule());
                            							}
                            							setWithLastConsumed(current, "sign", lv_sign_1_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalItlDsl.g:1252:7: lv_sign_1_4= '<'
                            {
                            lv_sign_1_4=(Token)match(input,47,FOLLOW_15); 

                            							newLeafNode(lv_sign_1_4, grammarAccess.getBoolExpressionAccess().getSignLessThanSignKeyword_1_0_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getBoolExpressionRule());
                            							}
                            							setWithLastConsumed(current, "sign", lv_sign_1_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalItlDsl.g:1263:7: lv_sign_1_5= '='
                            {
                            lv_sign_1_5=(Token)match(input,19,FOLLOW_15); 

                            							newLeafNode(lv_sign_1_5, grammarAccess.getBoolExpressionAccess().getSignEqualsSignKeyword_1_0_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getBoolExpressionRule());
                            							}
                            							setWithLastConsumed(current, "sign", lv_sign_1_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalItlDsl.g:1274:7: lv_sign_1_6= '<>'
                            {
                            lv_sign_1_6=(Token)match(input,48,FOLLOW_15); 

                            							newLeafNode(lv_sign_1_6, grammarAccess.getBoolExpressionAccess().getSignLessThanSignGreaterThanSignKeyword_1_0_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getBoolExpressionRule());
                            							}
                            							setWithLastConsumed(current, "sign", lv_sign_1_6, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    // InternalItlDsl.g:1287:4: ( (lv_literalRight_2_0= ruleLiteral ) )
                    // InternalItlDsl.g:1288:5: (lv_literalRight_2_0= ruleLiteral )
                    {
                    // InternalItlDsl.g:1288:5: (lv_literalRight_2_0= ruleLiteral )
                    // InternalItlDsl.g:1289:6: lv_literalRight_2_0= ruleLiteral
                    {

                    						newCompositeNode(grammarAccess.getBoolExpressionAccess().getLiteralRightLiteralParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_literalRight_2_0=ruleLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBoolExpressionRule());
                    						}
                    						set(
                    							current,
                    							"literalRight",
                    							lv_literalRight_2_0,
                    							"com.aestheticintegration.atto.ItlDsl.Literal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolExpression"


    // $ANTLR start "entryRuleLiteral"
    // InternalItlDsl.g:1311:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalItlDsl.g:1311:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalItlDsl.g:1312:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalItlDsl.g:1318:1: ruleLiteral returns [EObject current=null] : ( ( (lv_variable_0_0= ruleQualifiedName ) ) | ( (lv_primary_1_0= rulePrimary ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_variable_0_0 = null;

        EObject lv_primary_1_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:1324:2: ( ( ( (lv_variable_0_0= ruleQualifiedName ) ) | ( (lv_primary_1_0= rulePrimary ) ) ) )
            // InternalItlDsl.g:1325:2: ( ( (lv_variable_0_0= ruleQualifiedName ) ) | ( (lv_primary_1_0= rulePrimary ) ) )
            {
            // InternalItlDsl.g:1325:2: ( ( (lv_variable_0_0= ruleQualifiedName ) ) | ( (lv_primary_1_0= rulePrimary ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=RULE_BOOLEAN && LA19_0<=RULE_NULL)) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalItlDsl.g:1326:3: ( (lv_variable_0_0= ruleQualifiedName ) )
                    {
                    // InternalItlDsl.g:1326:3: ( (lv_variable_0_0= ruleQualifiedName ) )
                    // InternalItlDsl.g:1327:4: (lv_variable_0_0= ruleQualifiedName )
                    {
                    // InternalItlDsl.g:1327:4: (lv_variable_0_0= ruleQualifiedName )
                    // InternalItlDsl.g:1328:5: lv_variable_0_0= ruleQualifiedName
                    {

                    					newCompositeNode(grammarAccess.getLiteralAccess().getVariableQualifiedNameParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_variable_0_0=ruleQualifiedName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLiteralRule());
                    					}
                    					set(
                    						current,
                    						"variable",
                    						lv_variable_0_0,
                    						"com.aestheticintegration.atto.ItlDsl.QualifiedName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalItlDsl.g:1346:3: ( (lv_primary_1_0= rulePrimary ) )
                    {
                    // InternalItlDsl.g:1346:3: ( (lv_primary_1_0= rulePrimary ) )
                    // InternalItlDsl.g:1347:4: (lv_primary_1_0= rulePrimary )
                    {
                    // InternalItlDsl.g:1347:4: (lv_primary_1_0= rulePrimary )
                    // InternalItlDsl.g:1348:5: lv_primary_1_0= rulePrimary
                    {

                    					newCompositeNode(grammarAccess.getLiteralAccess().getPrimaryPrimaryParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_primary_1_0=rulePrimary();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getLiteralRule());
                    					}
                    					set(
                    						current,
                    						"primary",
                    						lv_primary_1_0,
                    						"com.aestheticintegration.atto.ItlDsl.Primary");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalItlDsl.g:1369:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalItlDsl.g:1369:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalItlDsl.g:1370:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalItlDsl.g:1376:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalItlDsl.g:1382:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalItlDsl.g:1383:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalItlDsl.g:1383:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalItlDsl.g:1384:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalItlDsl.g:1391:3: (kw= '.' this_ID_2= RULE_ID )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==49) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalItlDsl.g:1392:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,49,FOLLOW_8); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_29); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedName2"
    // InternalItlDsl.g:1409:1: entryRuleQualifiedName2 returns [String current=null] : iv_ruleQualifiedName2= ruleQualifiedName2 EOF ;
    public final String entryRuleQualifiedName2() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName2 = null;


        try {
            // InternalItlDsl.g:1409:54: (iv_ruleQualifiedName2= ruleQualifiedName2 EOF )
            // InternalItlDsl.g:1410:2: iv_ruleQualifiedName2= ruleQualifiedName2 EOF
            {
             newCompositeNode(grammarAccess.getQualifiedName2Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName2=ruleQualifiedName2();

            state._fsp--;

             current =iv_ruleQualifiedName2.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName2"


    // $ANTLR start "ruleQualifiedName2"
    // InternalItlDsl.g:1416:1: ruleQualifiedName2 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+ ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName2() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalItlDsl.g:1422:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+ ) )
            // InternalItlDsl.g:1423:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+ )
            {
            // InternalItlDsl.g:1423:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+ )
            // InternalItlDsl.g:1424:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )+
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedName2Access().getIDTerminalRuleCall_0());
            		
            // InternalItlDsl.g:1431:3: (kw= '.' this_ID_2= RULE_ID )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==49) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalItlDsl.g:1432:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,49,FOLLOW_8); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedName2Access().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_29); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedName2Access().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName2"


    // $ANTLR start "entryRulePrimary"
    // InternalItlDsl.g:1449:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalItlDsl.g:1449:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalItlDsl.g:1450:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalItlDsl.g:1456:1: rulePrimary returns [EObject current=null] : ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token lv_valueBoolean_1_0=null;
        Token lv_valueInteger_3_0=null;
        Token lv_valueFloat_5_0=null;
        Token lv_valueString_7_0=null;
        Token lv_valueNull_9_0=null;


        	enterRule();

        try {
            // InternalItlDsl.g:1462:2: ( ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) ) )
            // InternalItlDsl.g:1463:2: ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) )
            {
            // InternalItlDsl.g:1463:2: ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) )
            int alt22=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt22=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt22=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt22=3;
                }
                break;
            case RULE_STRING:
                {
                alt22=4;
                }
                break;
            case RULE_NULL:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalItlDsl.g:1464:3: ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) )
                    {
                    // InternalItlDsl.g:1464:3: ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) )
                    // InternalItlDsl.g:1465:4: () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalItlDsl.g:1465:4: ()
                    // InternalItlDsl.g:1466:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryAccess().getBooleanAction_0_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1472:4: ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) )
                    // InternalItlDsl.g:1473:5: (lv_valueBoolean_1_0= RULE_BOOLEAN )
                    {
                    // InternalItlDsl.g:1473:5: (lv_valueBoolean_1_0= RULE_BOOLEAN )
                    // InternalItlDsl.g:1474:6: lv_valueBoolean_1_0= RULE_BOOLEAN
                    {
                    lv_valueBoolean_1_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    						newLeafNode(lv_valueBoolean_1_0, grammarAccess.getPrimaryAccess().getValueBooleanBOOLEANTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimaryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueBoolean",
                    							lv_valueBoolean_1_0,
                    							"com.aestheticintegration.atto.ItlDsl.BOOLEAN");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalItlDsl.g:1492:3: ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) )
                    {
                    // InternalItlDsl.g:1492:3: ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) )
                    // InternalItlDsl.g:1493:4: () ( (lv_valueInteger_3_0= RULE_INTEGER ) )
                    {
                    // InternalItlDsl.g:1493:4: ()
                    // InternalItlDsl.g:1494:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryAccess().getIntegerAction_1_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1500:4: ( (lv_valueInteger_3_0= RULE_INTEGER ) )
                    // InternalItlDsl.g:1501:5: (lv_valueInteger_3_0= RULE_INTEGER )
                    {
                    // InternalItlDsl.g:1501:5: (lv_valueInteger_3_0= RULE_INTEGER )
                    // InternalItlDsl.g:1502:6: lv_valueInteger_3_0= RULE_INTEGER
                    {
                    lv_valueInteger_3_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); 

                    						newLeafNode(lv_valueInteger_3_0, grammarAccess.getPrimaryAccess().getValueIntegerINTEGERTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimaryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueInteger",
                    							lv_valueInteger_3_0,
                    							"com.aestheticintegration.atto.ItlDsl.INTEGER");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalItlDsl.g:1520:3: ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) )
                    {
                    // InternalItlDsl.g:1520:3: ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) )
                    // InternalItlDsl.g:1521:4: () ( (lv_valueFloat_5_0= RULE_FLOAT ) )
                    {
                    // InternalItlDsl.g:1521:4: ()
                    // InternalItlDsl.g:1522:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryAccess().getFloatAction_2_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1528:4: ( (lv_valueFloat_5_0= RULE_FLOAT ) )
                    // InternalItlDsl.g:1529:5: (lv_valueFloat_5_0= RULE_FLOAT )
                    {
                    // InternalItlDsl.g:1529:5: (lv_valueFloat_5_0= RULE_FLOAT )
                    // InternalItlDsl.g:1530:6: lv_valueFloat_5_0= RULE_FLOAT
                    {
                    lv_valueFloat_5_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); 

                    						newLeafNode(lv_valueFloat_5_0, grammarAccess.getPrimaryAccess().getValueFloatFLOATTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimaryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueFloat",
                    							lv_valueFloat_5_0,
                    							"com.aestheticintegration.atto.ItlDsl.FLOAT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalItlDsl.g:1548:3: ( () ( (lv_valueString_7_0= RULE_STRING ) ) )
                    {
                    // InternalItlDsl.g:1548:3: ( () ( (lv_valueString_7_0= RULE_STRING ) ) )
                    // InternalItlDsl.g:1549:4: () ( (lv_valueString_7_0= RULE_STRING ) )
                    {
                    // InternalItlDsl.g:1549:4: ()
                    // InternalItlDsl.g:1550:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryAccess().getStringAction_3_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1556:4: ( (lv_valueString_7_0= RULE_STRING ) )
                    // InternalItlDsl.g:1557:5: (lv_valueString_7_0= RULE_STRING )
                    {
                    // InternalItlDsl.g:1557:5: (lv_valueString_7_0= RULE_STRING )
                    // InternalItlDsl.g:1558:6: lv_valueString_7_0= RULE_STRING
                    {
                    lv_valueString_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_valueString_7_0, grammarAccess.getPrimaryAccess().getValueStringSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimaryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueString",
                    							lv_valueString_7_0,
                    							"com.aestheticintegration.atto.ItlDsl.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalItlDsl.g:1576:3: ( () ( (lv_valueNull_9_0= RULE_NULL ) ) )
                    {
                    // InternalItlDsl.g:1576:3: ( () ( (lv_valueNull_9_0= RULE_NULL ) ) )
                    // InternalItlDsl.g:1577:4: () ( (lv_valueNull_9_0= RULE_NULL ) )
                    {
                    // InternalItlDsl.g:1577:4: ()
                    // InternalItlDsl.g:1578:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryAccess().getNullAction_4_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1584:4: ( (lv_valueNull_9_0= RULE_NULL ) )
                    // InternalItlDsl.g:1585:5: (lv_valueNull_9_0= RULE_NULL )
                    {
                    // InternalItlDsl.g:1585:5: (lv_valueNull_9_0= RULE_NULL )
                    // InternalItlDsl.g:1586:6: lv_valueNull_9_0= RULE_NULL
                    {
                    lv_valueNull_9_0=(Token)match(input,RULE_NULL,FOLLOW_2); 

                    						newLeafNode(lv_valueNull_9_0, grammarAccess.getPrimaryAccess().getValueNullNULLTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPrimaryRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueNull",
                    							lv_valueNull_9_0,
                    							"com.aestheticintegration.atto.ItlDsl.NULL");
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleOutputExpression"
    // InternalItlDsl.g:1607:1: entryRuleOutputExpression returns [EObject current=null] : iv_ruleOutputExpression= ruleOutputExpression EOF ;
    public final EObject entryRuleOutputExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputExpression = null;


        try {
            // InternalItlDsl.g:1607:57: (iv_ruleOutputExpression= ruleOutputExpression EOF )
            // InternalItlDsl.g:1608:2: iv_ruleOutputExpression= ruleOutputExpression EOF
            {
             newCompositeNode(grammarAccess.getOutputExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputExpression=ruleOutputExpression();

            state._fsp--;

             current =iv_ruleOutputExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputExpression"


    // $ANTLR start "ruleOutputExpression"
    // InternalItlDsl.g:1614:1: ruleOutputExpression returns [EObject current=null] : ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) | ( () ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) ) ) | ( () ( (otherlv_13= RULE_ID ) ) ) | ( () otherlv_15= 'Exception' otherlv_16= '(' ( (lv_valueException_17_0= RULE_STRING ) ) otherlv_18= ')' ) ) ;
    public final EObject ruleOutputExpression() throws RecognitionException {
        EObject current = null;

        Token lv_valueBoolean_1_0=null;
        Token lv_valueInteger_3_0=null;
        Token lv_valueFloat_5_0=null;
        Token lv_valueString_7_0=null;
        Token lv_valueNull_9_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token lv_valueException_17_0=null;
        Token otherlv_18=null;
        EObject lv_dataTypeInstance_11_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:1620:2: ( ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) | ( () ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) ) ) | ( () ( (otherlv_13= RULE_ID ) ) ) | ( () otherlv_15= 'Exception' otherlv_16= '(' ( (lv_valueException_17_0= RULE_STRING ) ) otherlv_18= ')' ) ) )
            // InternalItlDsl.g:1621:2: ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) | ( () ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) ) ) | ( () ( (otherlv_13= RULE_ID ) ) ) | ( () otherlv_15= 'Exception' otherlv_16= '(' ( (lv_valueException_17_0= RULE_STRING ) ) otherlv_18= ')' ) )
            {
            // InternalItlDsl.g:1621:2: ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) | ( () ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) ) ) | ( () ( (otherlv_13= RULE_ID ) ) ) | ( () otherlv_15= 'Exception' otherlv_16= '(' ( (lv_valueException_17_0= RULE_STRING ) ) otherlv_18= ')' ) )
            int alt23=8;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalItlDsl.g:1622:3: ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) )
                    {
                    // InternalItlDsl.g:1622:3: ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) )
                    // InternalItlDsl.g:1623:4: () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) )
                    {
                    // InternalItlDsl.g:1623:4: ()
                    // InternalItlDsl.g:1624:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOutputExpressionAccess().getBooleanAction_0_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1630:4: ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) )
                    // InternalItlDsl.g:1631:5: (lv_valueBoolean_1_0= RULE_BOOLEAN )
                    {
                    // InternalItlDsl.g:1631:5: (lv_valueBoolean_1_0= RULE_BOOLEAN )
                    // InternalItlDsl.g:1632:6: lv_valueBoolean_1_0= RULE_BOOLEAN
                    {
                    lv_valueBoolean_1_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    						newLeafNode(lv_valueBoolean_1_0, grammarAccess.getOutputExpressionAccess().getValueBooleanBOOLEANTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOutputExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueBoolean",
                    							lv_valueBoolean_1_0,
                    							"com.aestheticintegration.atto.ItlDsl.BOOLEAN");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalItlDsl.g:1650:3: ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) )
                    {
                    // InternalItlDsl.g:1650:3: ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) )
                    // InternalItlDsl.g:1651:4: () ( (lv_valueInteger_3_0= RULE_INTEGER ) )
                    {
                    // InternalItlDsl.g:1651:4: ()
                    // InternalItlDsl.g:1652:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOutputExpressionAccess().getIntegerAction_1_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1658:4: ( (lv_valueInteger_3_0= RULE_INTEGER ) )
                    // InternalItlDsl.g:1659:5: (lv_valueInteger_3_0= RULE_INTEGER )
                    {
                    // InternalItlDsl.g:1659:5: (lv_valueInteger_3_0= RULE_INTEGER )
                    // InternalItlDsl.g:1660:6: lv_valueInteger_3_0= RULE_INTEGER
                    {
                    lv_valueInteger_3_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); 

                    						newLeafNode(lv_valueInteger_3_0, grammarAccess.getOutputExpressionAccess().getValueIntegerINTEGERTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOutputExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueInteger",
                    							lv_valueInteger_3_0,
                    							"com.aestheticintegration.atto.ItlDsl.INTEGER");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalItlDsl.g:1678:3: ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) )
                    {
                    // InternalItlDsl.g:1678:3: ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) )
                    // InternalItlDsl.g:1679:4: () ( (lv_valueFloat_5_0= RULE_FLOAT ) )
                    {
                    // InternalItlDsl.g:1679:4: ()
                    // InternalItlDsl.g:1680:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOutputExpressionAccess().getFloatAction_2_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1686:4: ( (lv_valueFloat_5_0= RULE_FLOAT ) )
                    // InternalItlDsl.g:1687:5: (lv_valueFloat_5_0= RULE_FLOAT )
                    {
                    // InternalItlDsl.g:1687:5: (lv_valueFloat_5_0= RULE_FLOAT )
                    // InternalItlDsl.g:1688:6: lv_valueFloat_5_0= RULE_FLOAT
                    {
                    lv_valueFloat_5_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); 

                    						newLeafNode(lv_valueFloat_5_0, grammarAccess.getOutputExpressionAccess().getValueFloatFLOATTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOutputExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueFloat",
                    							lv_valueFloat_5_0,
                    							"com.aestheticintegration.atto.ItlDsl.FLOAT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalItlDsl.g:1706:3: ( () ( (lv_valueString_7_0= RULE_STRING ) ) )
                    {
                    // InternalItlDsl.g:1706:3: ( () ( (lv_valueString_7_0= RULE_STRING ) ) )
                    // InternalItlDsl.g:1707:4: () ( (lv_valueString_7_0= RULE_STRING ) )
                    {
                    // InternalItlDsl.g:1707:4: ()
                    // InternalItlDsl.g:1708:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOutputExpressionAccess().getStringAction_3_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1714:4: ( (lv_valueString_7_0= RULE_STRING ) )
                    // InternalItlDsl.g:1715:5: (lv_valueString_7_0= RULE_STRING )
                    {
                    // InternalItlDsl.g:1715:5: (lv_valueString_7_0= RULE_STRING )
                    // InternalItlDsl.g:1716:6: lv_valueString_7_0= RULE_STRING
                    {
                    lv_valueString_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_valueString_7_0, grammarAccess.getOutputExpressionAccess().getValueStringSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOutputExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueString",
                    							lv_valueString_7_0,
                    							"com.aestheticintegration.atto.ItlDsl.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalItlDsl.g:1734:3: ( () ( (lv_valueNull_9_0= RULE_NULL ) ) )
                    {
                    // InternalItlDsl.g:1734:3: ( () ( (lv_valueNull_9_0= RULE_NULL ) ) )
                    // InternalItlDsl.g:1735:4: () ( (lv_valueNull_9_0= RULE_NULL ) )
                    {
                    // InternalItlDsl.g:1735:4: ()
                    // InternalItlDsl.g:1736:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOutputExpressionAccess().getNullAction_4_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1742:4: ( (lv_valueNull_9_0= RULE_NULL ) )
                    // InternalItlDsl.g:1743:5: (lv_valueNull_9_0= RULE_NULL )
                    {
                    // InternalItlDsl.g:1743:5: (lv_valueNull_9_0= RULE_NULL )
                    // InternalItlDsl.g:1744:6: lv_valueNull_9_0= RULE_NULL
                    {
                    lv_valueNull_9_0=(Token)match(input,RULE_NULL,FOLLOW_2); 

                    						newLeafNode(lv_valueNull_9_0, grammarAccess.getOutputExpressionAccess().getValueNullNULLTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOutputExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueNull",
                    							lv_valueNull_9_0,
                    							"com.aestheticintegration.atto.ItlDsl.NULL");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalItlDsl.g:1762:3: ( () ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) ) )
                    {
                    // InternalItlDsl.g:1762:3: ( () ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) ) )
                    // InternalItlDsl.g:1763:4: () ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) )
                    {
                    // InternalItlDsl.g:1763:4: ()
                    // InternalItlDsl.g:1764:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOutputExpressionAccess().getDataTypeInstanceAction_5_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1770:4: ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) )
                    // InternalItlDsl.g:1771:5: (lv_dataTypeInstance_11_0= ruleDataTypeInstance )
                    {
                    // InternalItlDsl.g:1771:5: (lv_dataTypeInstance_11_0= ruleDataTypeInstance )
                    // InternalItlDsl.g:1772:6: lv_dataTypeInstance_11_0= ruleDataTypeInstance
                    {

                    						newCompositeNode(grammarAccess.getOutputExpressionAccess().getDataTypeInstanceDataTypeInstanceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_dataTypeInstance_11_0=ruleDataTypeInstance();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOutputExpressionRule());
                    						}
                    						set(
                    							current,
                    							"dataTypeInstance",
                    							lv_dataTypeInstance_11_0,
                    							"com.aestheticintegration.atto.ItlDsl.DataTypeInstance");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalItlDsl.g:1791:3: ( () ( (otherlv_13= RULE_ID ) ) )
                    {
                    // InternalItlDsl.g:1791:3: ( () ( (otherlv_13= RULE_ID ) ) )
                    // InternalItlDsl.g:1792:4: () ( (otherlv_13= RULE_ID ) )
                    {
                    // InternalItlDsl.g:1792:4: ()
                    // InternalItlDsl.g:1793:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOutputExpressionAccess().getDefDataValueAction_6_0(),
                    						current);
                    				

                    }

                    // InternalItlDsl.g:1799:4: ( (otherlv_13= RULE_ID ) )
                    // InternalItlDsl.g:1800:5: (otherlv_13= RULE_ID )
                    {
                    // InternalItlDsl.g:1800:5: (otherlv_13= RULE_ID )
                    // InternalItlDsl.g:1801:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOutputExpressionRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_13, grammarAccess.getOutputExpressionAccess().getValueDataValueDefDataValueCrossReference_6_1_0());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalItlDsl.g:1814:3: ( () otherlv_15= 'Exception' otherlv_16= '(' ( (lv_valueException_17_0= RULE_STRING ) ) otherlv_18= ')' )
                    {
                    // InternalItlDsl.g:1814:3: ( () otherlv_15= 'Exception' otherlv_16= '(' ( (lv_valueException_17_0= RULE_STRING ) ) otherlv_18= ')' )
                    // InternalItlDsl.g:1815:4: () otherlv_15= 'Exception' otherlv_16= '(' ( (lv_valueException_17_0= RULE_STRING ) ) otherlv_18= ')'
                    {
                    // InternalItlDsl.g:1815:4: ()
                    // InternalItlDsl.g:1816:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOutputExpressionAccess().getExceptionAction_7_0(),
                    						current);
                    				

                    }

                    otherlv_15=(Token)match(input,50,FOLLOW_12); 

                    				newLeafNode(otherlv_15, grammarAccess.getOutputExpressionAccess().getExceptionKeyword_7_1());
                    			
                    otherlv_16=(Token)match(input,20,FOLLOW_31); 

                    				newLeafNode(otherlv_16, grammarAccess.getOutputExpressionAccess().getLeftParenthesisKeyword_7_2());
                    			
                    // InternalItlDsl.g:1830:4: ( (lv_valueException_17_0= RULE_STRING ) )
                    // InternalItlDsl.g:1831:5: (lv_valueException_17_0= RULE_STRING )
                    {
                    // InternalItlDsl.g:1831:5: (lv_valueException_17_0= RULE_STRING )
                    // InternalItlDsl.g:1832:6: lv_valueException_17_0= RULE_STRING
                    {
                    lv_valueException_17_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

                    						newLeafNode(lv_valueException_17_0, grammarAccess.getOutputExpressionAccess().getValueExceptionSTRINGTerminalRuleCall_7_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOutputExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"valueException",
                    							lv_valueException_17_0,
                    							"com.aestheticintegration.atto.ItlDsl.STRING");
                    					

                    }


                    }

                    otherlv_18=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getOutputExpressionAccess().getRightParenthesisKeyword_7_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputExpression"


    // $ANTLR start "entryRuleDefTest"
    // InternalItlDsl.g:1857:1: entryRuleDefTest returns [EObject current=null] : iv_ruleDefTest= ruleDefTest EOF ;
    public final EObject entryRuleDefTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefTest = null;


        try {
            // InternalItlDsl.g:1857:48: (iv_ruleDefTest= ruleDefTest EOF )
            // InternalItlDsl.g:1858:2: iv_ruleDefTest= ruleDefTest EOF
            {
             newCompositeNode(grammarAccess.getDefTestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefTest=ruleDefTest();

            state._fsp--;

             current =iv_ruleDefTest; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefTest"


    // $ANTLR start "ruleDefTest"
    // InternalItlDsl.g:1864:1: ruleDefTest returns [EObject current=null] : (otherlv_0= 'test' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( ruleQualifiedName ) ) otherlv_4= '(' ( ( (lv_dataTypeValues_5_0= ruleDataTypeValue ) ) (otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) ) )* )? otherlv_8= ')' otherlv_9= ':' ( (lv_outputExpression_10_0= ruleOutputExpression ) ) ) ;
    public final EObject ruleDefTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_dataTypeValues_5_0 = null;

        EObject lv_dataTypeValues_7_0 = null;

        EObject lv_outputExpression_10_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:1870:2: ( (otherlv_0= 'test' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( ruleQualifiedName ) ) otherlv_4= '(' ( ( (lv_dataTypeValues_5_0= ruleDataTypeValue ) ) (otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) ) )* )? otherlv_8= ')' otherlv_9= ':' ( (lv_outputExpression_10_0= ruleOutputExpression ) ) ) )
            // InternalItlDsl.g:1871:2: (otherlv_0= 'test' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( ruleQualifiedName ) ) otherlv_4= '(' ( ( (lv_dataTypeValues_5_0= ruleDataTypeValue ) ) (otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) ) )* )? otherlv_8= ')' otherlv_9= ':' ( (lv_outputExpression_10_0= ruleOutputExpression ) ) )
            {
            // InternalItlDsl.g:1871:2: (otherlv_0= 'test' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( ruleQualifiedName ) ) otherlv_4= '(' ( ( (lv_dataTypeValues_5_0= ruleDataTypeValue ) ) (otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) ) )* )? otherlv_8= ')' otherlv_9= ':' ( (lv_outputExpression_10_0= ruleOutputExpression ) ) )
            // InternalItlDsl.g:1872:3: otherlv_0= 'test' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( ( ruleQualifiedName ) ) otherlv_4= '(' ( ( (lv_dataTypeValues_5_0= ruleDataTypeValue ) ) (otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) ) )* )? otherlv_8= ')' otherlv_9= ':' ( (lv_outputExpression_10_0= ruleOutputExpression ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getDefTestAccess().getTestKeyword_0());
            		
            // InternalItlDsl.g:1876:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalItlDsl.g:1877:4: (lv_name_1_0= RULE_ID )
            {
            // InternalItlDsl.g:1877:4: (lv_name_1_0= RULE_ID )
            // InternalItlDsl.g:1878:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDefTestAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDefTestRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.aestheticintegration.atto.ItlDsl.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getDefTestAccess().getEqualsSignKeyword_2());
            		
            // InternalItlDsl.g:1898:3: ( ( ruleQualifiedName ) )
            // InternalItlDsl.g:1899:4: ( ruleQualifiedName )
            {
            // InternalItlDsl.g:1899:4: ( ruleQualifiedName )
            // InternalItlDsl.g:1900:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDefTestRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDefTestAccess().getDefFuncDefFunctionCrossReference_3_0());
            				
            pushFollow(FOLLOW_12);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getDefTestAccess().getLeftParenthesisKeyword_4());
            		
            // InternalItlDsl.g:1918:3: ( ( (lv_dataTypeValues_5_0= ruleDataTypeValue ) ) (otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_NULL)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalItlDsl.g:1919:4: ( (lv_dataTypeValues_5_0= ruleDataTypeValue ) ) (otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) ) )*
                    {
                    // InternalItlDsl.g:1919:4: ( (lv_dataTypeValues_5_0= ruleDataTypeValue ) )
                    // InternalItlDsl.g:1920:5: (lv_dataTypeValues_5_0= ruleDataTypeValue )
                    {
                    // InternalItlDsl.g:1920:5: (lv_dataTypeValues_5_0= ruleDataTypeValue )
                    // InternalItlDsl.g:1921:6: lv_dataTypeValues_5_0= ruleDataTypeValue
                    {

                    						newCompositeNode(grammarAccess.getDefTestAccess().getDataTypeValuesDataTypeValueParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_dataTypeValues_5_0=ruleDataTypeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDefTestRule());
                    						}
                    						add(
                    							current,
                    							"dataTypeValues",
                    							lv_dataTypeValues_5_0,
                    							"com.aestheticintegration.atto.ItlDsl.DataTypeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalItlDsl.g:1938:4: (otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==21) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalItlDsl.g:1939:5: otherlv_6= ',' ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) )
                    	    {
                    	    otherlv_6=(Token)match(input,21,FOLLOW_15); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getDefTestAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalItlDsl.g:1943:5: ( (lv_dataTypeValues_7_0= ruleDataTypeValue ) )
                    	    // InternalItlDsl.g:1944:6: (lv_dataTypeValues_7_0= ruleDataTypeValue )
                    	    {
                    	    // InternalItlDsl.g:1944:6: (lv_dataTypeValues_7_0= ruleDataTypeValue )
                    	    // InternalItlDsl.g:1945:7: lv_dataTypeValues_7_0= ruleDataTypeValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getDefTestAccess().getDataTypeValuesDataTypeValueParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_17);
                    	    lv_dataTypeValues_7_0=ruleDataTypeValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDefTestRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dataTypeValues",
                    	    								lv_dataTypeValues_7_0,
                    	    								"com.aestheticintegration.atto.ItlDsl.DataTypeValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,22,FOLLOW_18); 

            			newLeafNode(otherlv_8, grammarAccess.getDefTestAccess().getRightParenthesisKeyword_6());
            		
            otherlv_9=(Token)match(input,24,FOLLOW_25); 

            			newLeafNode(otherlv_9, grammarAccess.getDefTestAccess().getColonKeyword_7());
            		
            // InternalItlDsl.g:1972:3: ( (lv_outputExpression_10_0= ruleOutputExpression ) )
            // InternalItlDsl.g:1973:4: (lv_outputExpression_10_0= ruleOutputExpression )
            {
            // InternalItlDsl.g:1973:4: (lv_outputExpression_10_0= ruleOutputExpression )
            // InternalItlDsl.g:1974:5: lv_outputExpression_10_0= ruleOutputExpression
            {

            					newCompositeNode(grammarAccess.getDefTestAccess().getOutputExpressionOutputExpressionParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_2);
            lv_outputExpression_10_0=ruleOutputExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefTestRule());
            					}
            					set(
            						current,
            						"outputExpression",
            						lv_outputExpression_10_0,
            						"com.aestheticintegration.atto.ItlDsl.OutputExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefTest"


    // $ANTLR start "entryRuleDataTypeValue"
    // InternalItlDsl.g:1995:1: entryRuleDataTypeValue returns [EObject current=null] : iv_ruleDataTypeValue= ruleDataTypeValue EOF ;
    public final EObject entryRuleDataTypeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeValue = null;


        try {
            // InternalItlDsl.g:1995:54: (iv_ruleDataTypeValue= ruleDataTypeValue EOF )
            // InternalItlDsl.g:1996:2: iv_ruleDataTypeValue= ruleDataTypeValue EOF
            {
             newCompositeNode(grammarAccess.getDataTypeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeValue=ruleDataTypeValue();

            state._fsp--;

             current =iv_ruleDataTypeValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataTypeValue"


    // $ANTLR start "ruleDataTypeValue"
    // InternalItlDsl.g:2002:1: ruleDataTypeValue returns [EObject current=null] : ( ( (lv_primary_0_0= rulePrimary ) ) | ( (lv_dataTypeInstance_1_0= ruleDataTypeInstance ) ) | ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleDataTypeValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_primary_0_0 = null;

        EObject lv_dataTypeInstance_1_0 = null;



        	enterRule();

        try {
            // InternalItlDsl.g:2008:2: ( ( ( (lv_primary_0_0= rulePrimary ) ) | ( (lv_dataTypeInstance_1_0= ruleDataTypeInstance ) ) | ( (otherlv_2= RULE_ID ) ) ) )
            // InternalItlDsl.g:2009:2: ( ( (lv_primary_0_0= rulePrimary ) ) | ( (lv_dataTypeInstance_1_0= ruleDataTypeInstance ) ) | ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalItlDsl.g:2009:2: ( ( (lv_primary_0_0= rulePrimary ) ) | ( (lv_dataTypeInstance_1_0= ruleDataTypeInstance ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_BOOLEAN && LA26_0<=RULE_NULL)) ) {
                alt26=1;
            }
            else if ( (LA26_0==RULE_ID) ) {
                int LA26_2 = input.LA(2);

                if ( (LA26_2==20) ) {
                    alt26=2;
                }
                else if ( (LA26_2==EOF||(LA26_2>=21 && LA26_2<=22)) ) {
                    alt26=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalItlDsl.g:2010:3: ( (lv_primary_0_0= rulePrimary ) )
                    {
                    // InternalItlDsl.g:2010:3: ( (lv_primary_0_0= rulePrimary ) )
                    // InternalItlDsl.g:2011:4: (lv_primary_0_0= rulePrimary )
                    {
                    // InternalItlDsl.g:2011:4: (lv_primary_0_0= rulePrimary )
                    // InternalItlDsl.g:2012:5: lv_primary_0_0= rulePrimary
                    {

                    					newCompositeNode(grammarAccess.getDataTypeValueAccess().getPrimaryPrimaryParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_primary_0_0=rulePrimary();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDataTypeValueRule());
                    					}
                    					set(
                    						current,
                    						"primary",
                    						lv_primary_0_0,
                    						"com.aestheticintegration.atto.ItlDsl.Primary");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalItlDsl.g:2030:3: ( (lv_dataTypeInstance_1_0= ruleDataTypeInstance ) )
                    {
                    // InternalItlDsl.g:2030:3: ( (lv_dataTypeInstance_1_0= ruleDataTypeInstance ) )
                    // InternalItlDsl.g:2031:4: (lv_dataTypeInstance_1_0= ruleDataTypeInstance )
                    {
                    // InternalItlDsl.g:2031:4: (lv_dataTypeInstance_1_0= ruleDataTypeInstance )
                    // InternalItlDsl.g:2032:5: lv_dataTypeInstance_1_0= ruleDataTypeInstance
                    {

                    					newCompositeNode(grammarAccess.getDataTypeValueAccess().getDataTypeInstanceDataTypeInstanceParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_dataTypeInstance_1_0=ruleDataTypeInstance();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDataTypeValueRule());
                    					}
                    					set(
                    						current,
                    						"dataTypeInstance",
                    						lv_dataTypeInstance_1_0,
                    						"com.aestheticintegration.atto.ItlDsl.DataTypeInstance");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalItlDsl.g:2050:3: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalItlDsl.g:2050:3: ( (otherlv_2= RULE_ID ) )
                    // InternalItlDsl.g:2051:4: (otherlv_2= RULE_ID )
                    {
                    // InternalItlDsl.g:2051:4: (otherlv_2= RULE_ID )
                    // InternalItlDsl.g:2052:5: otherlv_2= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getDataTypeValueRule());
                    					}
                    				
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(otherlv_2, grammarAccess.getDataTypeValueAccess().getDefDataValueDefDataValueCrossReference_2_0());
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataTypeValue"

    // Delegated rules


    protected DFA23 dfa23 = new DFA23(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\6\uffff\1\10\3\uffff";
    static final String dfa_3s = "\1\4\5\uffff\1\4\3\uffff";
    static final String dfa_4s = "\1\62\5\uffff\1\63\3\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\7\1\6";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\6\1\1\1\2\1\3\1\4\1\5\50\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "\6\10\7\uffff\1\10\2\uffff\1\11\21\uffff\1\10\3\uffff\2\10\6\uffff\2\10",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1621:2: ( ( () ( (lv_valueBoolean_1_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_valueInteger_3_0= RULE_INTEGER ) ) ) | ( () ( (lv_valueFloat_5_0= RULE_FLOAT ) ) ) | ( () ( (lv_valueString_7_0= RULE_STRING ) ) ) | ( () ( (lv_valueNull_9_0= RULE_NULL ) ) ) | ( () ( (lv_dataTypeInstance_11_0= ruleDataTypeInstance ) ) ) | ( () ( (otherlv_13= RULE_ID ) ) ) | ( () otherlv_15= 'Exception' otherlv_16= '(' ( (lv_valueException_17_0= RULE_STRING ) ) otherlv_18= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000800000084C002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0008000000848002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0008000000840002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0008000000800002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000004003F0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000006003F0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000000003F0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000003FFE000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00040040000203F0L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00040040000003F2L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000018000400000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00040040000003F0L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0001F00000080002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000400000L});

}