/**
 */
package com.rockwellcollins.atc.resolute.resolute.impl;

import com.rockwellcollins.atc.resolute.resolute.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResoluteFactoryImpl extends EFactoryImpl implements ResoluteFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ResoluteFactory init()
  {
    try
    {
      ResoluteFactory theResoluteFactory = (ResoluteFactory)EPackage.Registry.INSTANCE.getEFactory(ResolutePackage.eNS_URI);
      if (theResoluteFactory != null)
      {
        return theResoluteFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ResoluteFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResoluteFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ResolutePackage.RESOLUTE_LIBRARY: return createResoluteLibrary();
      case ResolutePackage.DEFINITION: return createDefinition();
      case ResolutePackage.TYPE: return createType();
      case ResolutePackage.BASE_TYPE: return createBaseType();
      case ResolutePackage.ARG: return createArg();
      case ResolutePackage.CONSTANT_DEFINITION: return createConstantDefinition();
      case ResolutePackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case ResolutePackage.DEFINITION_BODY: return createDefinitionBody();
      case ResolutePackage.CLAIM_CONTEXT: return createClaimContext();
      case ResolutePackage.CLAIM_ASSUMPTION: return createClaimAssumption();
      case ResolutePackage.CLAIM_STRATEGY: return createClaimStrategy();
      case ResolutePackage.CLAIM_TEXT: return createClaimText();
      case ResolutePackage.CLAIM_TEXT_VAR: return createClaimTextVar();
      case ResolutePackage.EXPR: return createExpr();
      case ResolutePackage.LET_BINDING: return createLetBinding();
      case ResolutePackage.RESOLUTE_SUBCLAUSE: return createResoluteSubclause();
      case ResolutePackage.NESTED_DOT_ID: return createNestedDotID();
      case ResolutePackage.LINT_STATEMENT: return createLintStatement();
      case ResolutePackage.RULESET: return createRuleset();
      case ResolutePackage.RULESET_BODY: return createRulesetBody();
      case ResolutePackage.ANALYSIS_STATEMENT: return createAnalysisStatement();
      case ResolutePackage.LIST_TYPE: return createListType();
      case ResolutePackage.SET_TYPE: return createSetType();
      case ResolutePackage.LIBRARY_FN_TYPE: return createLibraryFnType();
      case ResolutePackage.QUANT_ARG: return createQuantArg();
      case ResolutePackage.FUNCTION_BODY: return createFunctionBody();
      case ResolutePackage.CLAIM_BODY: return createClaimBody();
      case ResolutePackage.CLAIM_STRING: return createClaimString();
      case ResolutePackage.CLAIM_ARG: return createClaimArg();
      case ResolutePackage.BINARY_EXPR: return createBinaryExpr();
      case ResolutePackage.INSTANCE_OF_EXPR: return createInstanceOfExpr();
      case ResolutePackage.UNARY_EXPR: return createUnaryExpr();
      case ResolutePackage.CAST_EXPR: return createCastExpr();
      case ResolutePackage.ID_EXPR: return createIdExpr();
      case ResolutePackage.THIS_EXPR: return createThisExpr();
      case ResolutePackage.FAIL_EXPR: return createFailExpr();
      case ResolutePackage.INT_EXPR: return createIntExpr();
      case ResolutePackage.REAL_EXPR: return createRealExpr();
      case ResolutePackage.BOOL_EXPR: return createBoolExpr();
      case ResolutePackage.STRING_EXPR: return createStringExpr();
      case ResolutePackage.IF_THEN_ELSE_EXPR: return createIfThenElseExpr();
      case ResolutePackage.QUANTIFIED_EXPR: return createQuantifiedExpr();
      case ResolutePackage.LIBRARY_FN_CALL_EXPR: return createLibraryFnCallExpr();
      case ResolutePackage.BUILT_IN_FN_CALL_EXPR: return createBuiltInFnCallExpr();
      case ResolutePackage.FN_CALL_EXPR: return createFnCallExpr();
      case ResolutePackage.LINT_EXPR: return createLintExpr();
      case ResolutePackage.LIST_FILTER_MAP_EXPR: return createListFilterMapExpr();
      case ResolutePackage.LIST_EXPR: return createListExpr();
      case ResolutePackage.SET_FILTER_MAP_EXPR: return createSetFilterMapExpr();
      case ResolutePackage.SET_EXPR: return createSetExpr();
      case ResolutePackage.LET_EXPR: return createLetExpr();
      case ResolutePackage.WARNING_STATEMENT: return createWarningStatement();
      case ResolutePackage.ERROR_STATEMENT: return createErrorStatement();
      case ResolutePackage.INFO_STATEMENT: return createInfoStatement();
      case ResolutePackage.PROVE_STATEMENT: return createProveStatement();
      case ResolutePackage.CHECK_STATEMENT: return createCheckStatement();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResoluteLibrary createResoluteLibrary()
  {
    ResoluteLibraryImpl resoluteLibrary = new ResoluteLibraryImpl();
    return resoluteLibrary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Definition createDefinition()
  {
    DefinitionImpl definition = new DefinitionImpl();
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BaseType createBaseType()
  {
    BaseTypeImpl baseType = new BaseTypeImpl();
    return baseType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Arg createArg()
  {
    ArgImpl arg = new ArgImpl();
    return arg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConstantDefinition createConstantDefinition()
  {
    ConstantDefinitionImpl constantDefinition = new ConstantDefinitionImpl();
    return constantDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FunctionDefinition createFunctionDefinition()
  {
    FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DefinitionBody createDefinitionBody()
  {
    DefinitionBodyImpl definitionBody = new DefinitionBodyImpl();
    return definitionBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClaimContext createClaimContext()
  {
    ClaimContextImpl claimContext = new ClaimContextImpl();
    return claimContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClaimAssumption createClaimAssumption()
  {
    ClaimAssumptionImpl claimAssumption = new ClaimAssumptionImpl();
    return claimAssumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClaimStrategy createClaimStrategy()
  {
    ClaimStrategyImpl claimStrategy = new ClaimStrategyImpl();
    return claimStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClaimText createClaimText()
  {
    ClaimTextImpl claimText = new ClaimTextImpl();
    return claimText;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClaimTextVar createClaimTextVar()
  {
    ClaimTextVarImpl claimTextVar = new ClaimTextVarImpl();
    return claimTextVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expr createExpr()
  {
    ExprImpl expr = new ExprImpl();
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LetBinding createLetBinding()
  {
    LetBindingImpl letBinding = new LetBindingImpl();
    return letBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResoluteSubclause createResoluteSubclause()
  {
    ResoluteSubclauseImpl resoluteSubclause = new ResoluteSubclauseImpl();
    return resoluteSubclause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NestedDotID createNestedDotID()
  {
    NestedDotIDImpl nestedDotID = new NestedDotIDImpl();
    return nestedDotID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LintStatement createLintStatement()
  {
    LintStatementImpl lintStatement = new LintStatementImpl();
    return lintStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Ruleset createRuleset()
  {
    RulesetImpl ruleset = new RulesetImpl();
    return ruleset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RulesetBody createRulesetBody()
  {
    RulesetBodyImpl rulesetBody = new RulesetBodyImpl();
    return rulesetBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AnalysisStatement createAnalysisStatement()
  {
    AnalysisStatementImpl analysisStatement = new AnalysisStatementImpl();
    return analysisStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ListType createListType()
  {
    ListTypeImpl listType = new ListTypeImpl();
    return listType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SetType createSetType()
  {
    SetTypeImpl setType = new SetTypeImpl();
    return setType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LibraryFnType createLibraryFnType()
  {
    LibraryFnTypeImpl libraryFnType = new LibraryFnTypeImpl();
    return libraryFnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QuantArg createQuantArg()
  {
    QuantArgImpl quantArg = new QuantArgImpl();
    return quantArg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FunctionBody createFunctionBody()
  {
    FunctionBodyImpl functionBody = new FunctionBodyImpl();
    return functionBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClaimBody createClaimBody()
  {
    ClaimBodyImpl claimBody = new ClaimBodyImpl();
    return claimBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClaimString createClaimString()
  {
    ClaimStringImpl claimString = new ClaimStringImpl();
    return claimString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClaimArg createClaimArg()
  {
    ClaimArgImpl claimArg = new ClaimArgImpl();
    return claimArg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BinaryExpr createBinaryExpr()
  {
    BinaryExprImpl binaryExpr = new BinaryExprImpl();
    return binaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InstanceOfExpr createInstanceOfExpr()
  {
    InstanceOfExprImpl instanceOfExpr = new InstanceOfExprImpl();
    return instanceOfExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryExpr createUnaryExpr()
  {
    UnaryExprImpl unaryExpr = new UnaryExprImpl();
    return unaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CastExpr createCastExpr()
  {
    CastExprImpl castExpr = new CastExprImpl();
    return castExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IdExpr createIdExpr()
  {
    IdExprImpl idExpr = new IdExprImpl();
    return idExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ThisExpr createThisExpr()
  {
    ThisExprImpl thisExpr = new ThisExprImpl();
    return thisExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FailExpr createFailExpr()
  {
    FailExprImpl failExpr = new FailExprImpl();
    return failExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntExpr createIntExpr()
  {
    IntExprImpl intExpr = new IntExprImpl();
    return intExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RealExpr createRealExpr()
  {
    RealExprImpl realExpr = new RealExprImpl();
    return realExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BoolExpr createBoolExpr()
  {
    BoolExprImpl boolExpr = new BoolExprImpl();
    return boolExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StringExpr createStringExpr()
  {
    StringExprImpl stringExpr = new StringExprImpl();
    return stringExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IfThenElseExpr createIfThenElseExpr()
  {
    IfThenElseExprImpl ifThenElseExpr = new IfThenElseExprImpl();
    return ifThenElseExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QuantifiedExpr createQuantifiedExpr()
  {
    QuantifiedExprImpl quantifiedExpr = new QuantifiedExprImpl();
    return quantifiedExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LibraryFnCallExpr createLibraryFnCallExpr()
  {
    LibraryFnCallExprImpl libraryFnCallExpr = new LibraryFnCallExprImpl();
    return libraryFnCallExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BuiltInFnCallExpr createBuiltInFnCallExpr()
  {
    BuiltInFnCallExprImpl builtInFnCallExpr = new BuiltInFnCallExprImpl();
    return builtInFnCallExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FnCallExpr createFnCallExpr()
  {
    FnCallExprImpl fnCallExpr = new FnCallExprImpl();
    return fnCallExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LintExpr createLintExpr()
  {
    LintExprImpl lintExpr = new LintExprImpl();
    return lintExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ListFilterMapExpr createListFilterMapExpr()
  {
    ListFilterMapExprImpl listFilterMapExpr = new ListFilterMapExprImpl();
    return listFilterMapExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ListExpr createListExpr()
  {
    ListExprImpl listExpr = new ListExprImpl();
    return listExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SetFilterMapExpr createSetFilterMapExpr()
  {
    SetFilterMapExprImpl setFilterMapExpr = new SetFilterMapExprImpl();
    return setFilterMapExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SetExpr createSetExpr()
  {
    SetExprImpl setExpr = new SetExprImpl();
    return setExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LetExpr createLetExpr()
  {
    LetExprImpl letExpr = new LetExprImpl();
    return letExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WarningStatement createWarningStatement()
  {
    WarningStatementImpl warningStatement = new WarningStatementImpl();
    return warningStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ErrorStatement createErrorStatement()
  {
    ErrorStatementImpl errorStatement = new ErrorStatementImpl();
    return errorStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InfoStatement createInfoStatement()
  {
    InfoStatementImpl infoStatement = new InfoStatementImpl();
    return infoStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProveStatement createProveStatement()
  {
    ProveStatementImpl proveStatement = new ProveStatementImpl();
    return proveStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CheckStatement createCheckStatement()
  {
    CheckStatementImpl checkStatement = new CheckStatementImpl();
    return checkStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResolutePackage getResolutePackage()
  {
    return (ResolutePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ResolutePackage getPackage()
  {
    return ResolutePackage.eINSTANCE;
  }

} //ResoluteFactoryImpl
