/*
 * generated by Xtext
 */
package com.rockwellcollins.atc.resolute.formatting2;

import com.google.inject.Inject
import com.rockwellcollins.atc.resolute.resolute.Arg
import com.rockwellcollins.atc.resolute.resolute.BaseType
import com.rockwellcollins.atc.resolute.resolute.BinaryExpr
import com.rockwellcollins.atc.resolute.resolute.BoolExpr
import com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr
import com.rockwellcollins.atc.resolute.resolute.CastExpr
import com.rockwellcollins.atc.resolute.resolute.ClaimBody
import com.rockwellcollins.atc.resolute.resolute.ClaimText
import com.rockwellcollins.atc.resolute.resolute.ConstantDefinition
import com.rockwellcollins.atc.resolute.resolute.Definition
import com.rockwellcollins.atc.resolute.resolute.Expr
import com.rockwellcollins.atc.resolute.resolute.FailExpr
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr
import com.rockwellcollins.atc.resolute.resolute.FunctionBody
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
import com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr
import com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr
import com.rockwellcollins.atc.resolute.resolute.IntExpr
import com.rockwellcollins.atc.resolute.resolute.LetBinding
import com.rockwellcollins.atc.resolute.resolute.LetExpr
import com.rockwellcollins.atc.resolute.resolute.ListExpr
import com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr
import com.rockwellcollins.atc.resolute.resolute.ListType
import com.rockwellcollins.atc.resolute.resolute.NestedDotID
import com.rockwellcollins.atc.resolute.resolute.ProveStatement
import com.rockwellcollins.atc.resolute.resolute.QuantArg
import com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr
import com.rockwellcollins.atc.resolute.resolute.RealExpr
import com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary
import com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause
import com.rockwellcollins.atc.resolute.resolute.SetExpr
import com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr
import com.rockwellcollins.atc.resolute.resolute.SetType
import com.rockwellcollins.atc.resolute.resolute.StringExpr
import com.rockwellcollins.atc.resolute.resolute.ThisExpr
import com.rockwellcollins.atc.resolute.resolute.UnaryExpr
import com.rockwellcollins.atc.resolute.services.ResoluteGrammarAccess
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter
import com.rockwellcollins.atc.resolute.resolute.AnalysisStatement
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
import java.util.List
import com.rockwellcollins.atc.resolute.resolute.ClaimContext
import com.rockwellcollins.atc.resolute.resolute.ClaimAssumption
import com.rockwellcollins.atc.resolute.resolute.CheckStatement

class ResoluteFormatter extends PropertiesFormatter {
	
	@Inject extension ResoluteGrammarAccess

	def dispatch void format(ResoluteLibrary resolutelibrary, extension IFormattableDocument document) {
		resolutelibrary.surround[noSpace];
		for (Definition definitions : resolutelibrary.getDefinitions()) {
			format(definitions, document);
		}
	}

	def dispatch void format(ListType listtype, extension IFormattableDocument document) {
		listtype.regionFor.keyword("[").append[noSpace];
		listtype.regionFor.keyword("]").prepend[noSpace];
		format(listtype.getType(), document);
	}

	def dispatch void format(SetType settype, extension IFormattableDocument document) {
		settype.regionFor.keyword("{").append[noSpace];
		settype.regionFor.keyword("}").prepend[noSpace];
		format(settype.getType(), document);
	}

	def dispatch void format(BaseType basetype, extension IFormattableDocument document) {
		basetype.regionFor.keyword("<").append[noSpace];
		basetype.regionFor.keyword(">").prepend[noSpace];
		format(basetype.getParamType(), document);
	}

	def dispatch void format(Arg arg, extension IFormattableDocument document) { 
		format(arg.getType(), document);
	}

	def dispatch void format(QuantArg quantarg, extension IFormattableDocument document) {
		formatExpr(quantarg.getExpr(), document);
	}

	def dispatch void format(ConstantDefinition constantdefinition, extension IFormattableDocument document) {
		format(constantdefinition.getType(), document);
		formatExpr(constantdefinition.getExpr(), document);
	}

	def dispatch void format(FunctionDefinition functiondefinition, extension IFormattableDocument document) {

		functiondefinition.regionFor.keyword("(").surround[noSpace];
		functiondefinition.regionFor.keyword(")").prepend[noSpace];
		functiondefinition.regionFor.keywords(",").forEach[prepend[noSpace]];
		for (Arg args : functiondefinition.getArgs()) {
			format(args, document);
		}
		format(functiondefinition.getBody(), document);
		functiondefinition.append[newLines=2];
	}

	def dispatch void format(FunctionBody functionbody, extension IFormattableDocument document) {
		functionbody.regionFor.keyword("=").prepend[oneSpace].append[newLines = 1];
		functionbody.getExpr().surround[indent];
		format(functionbody.getType(), document);
		formatExpr(functionbody.getExpr(), document);
		
	}

	def dispatch void format(ClaimBody claimbody, extension IFormattableDocument document) {
		claimbody.regionFor.keyword("<=").prepend[oneSpace].append[newLines = 1];
		
		claimbody.regionFor.keyword("**").surround[indent];
		
		for (ClaimText claim : claimbody.getClaim()) {
			format(claim, document);
		}
		
//		for (ClaimContext context : claimbody.getContext()) {
//			context.prepend[newLines = 1].surround[indent];
//		}
//		
//		for (ClaimAssumption assumption : claimbody.getAssumptions()) {
//			assumption.prepend[newLines = 1].surround[indent];
//		}
		
		claimbody.getExpr().prepend[newLines = 1].surround[indent];
		formatExpr(claimbody.getExpr(), document);
	}

	def dispatch void format(BinaryExpr binaryexpr, extension IFormattableDocument document) {
		formatExpr(binaryexpr.getRight(), document);
		formatExpr(binaryexpr.getLeft(), document);
	}

	def dispatch void format(InstanceOfExpr instanceofexpr, extension IFormattableDocument document) {
		format(instanceofexpr.getType(), document);
		formatExpr(instanceofexpr.getExpr(), document);
	}

	def dispatch void format(UnaryExpr unaryexpr, extension IFormattableDocument document) {
		formatExpr(unaryexpr.getExpr(), document);
	}

	def dispatch void format(CastExpr castexpr, extension IFormattableDocument document) {
		format(castexpr.getType(), document);
		formatExpr(castexpr.getExpr(), document);
	}

	def dispatch void format(ThisExpr thisexpr, extension IFormattableDocument document) {
		thisexpr.regionFor.keyword(".").surround[noSpace];
		format(thisexpr.getSub(), document);
	}

	def dispatch void format(FailExpr failexpr, extension IFormattableDocument document) {
		format(failexpr.getVal(), document);
		for (ClaimText failmsg : failexpr.getFailmsg()) {
			format(failmsg, document);
		}
	}

	def dispatch void format(IntExpr intexpr, extension IFormattableDocument document) {
		format(intexpr.getVal(), document);
	}

	def dispatch void format(RealExpr realexpr, extension IFormattableDocument document) {
		format(realexpr.getVal(), document);
	}

	def dispatch void format(BoolExpr boolexpr, extension IFormattableDocument document) {
		format(boolexpr.getVal(), document);
	}

	def dispatch void format(StringExpr stringexpr, extension IFormattableDocument document) {
		format(stringexpr.getVal(), document);
	}

	def dispatch void format(IfThenElseExpr ifthenelseexpr, extension IFormattableDocument document) {
		ifthenelseexpr.regionFor.keyword("then").append[newLines=1];
		ifthenelseexpr.regionFor.keyword("else").prepend[newLines=1].append[newLines=1];
		ifthenelseexpr.getThen().surround[indent];
		ifthenelseexpr.getElse().surround[indent];
		
		formatExpr(ifthenelseexpr.getCond(), document);
		formatExpr(ifthenelseexpr.getThen(), document);
		formatExpr(ifthenelseexpr.getElse(), document);
	}

	def dispatch void format(QuantifiedExpr quantifiedexpr, extension IFormattableDocument document) {
		for (Arg args : quantifiedexpr.getArgs()) {
			format(args, document);
		}
		formatExpr(quantifiedexpr.getExpr(), document);
	}

	def dispatch void format(BuiltInFnCallExpr builtinfncallexpr, extension IFormattableDocument document) {
		builtinfncallexpr.regionFor.keyword("(").surround[noSpace];
		builtinfncallexpr.regionFor.keyword(")").prepend[noSpace];
		builtinfncallexpr.regionFor.keywords(",").forEach[prepend[noSpace]];
		for (Expr args : builtinfncallexpr.getArgs()) {
			formatExpr(args, document);
		}
	}

	def dispatch void format(FnCallExpr fncallexpr, extension IFormattableDocument document) {
		
		fncallexpr.regionFor.keyword("(").surround[noSpace];
		fncallexpr.regionFor.keyword(")").prepend[noSpace];
		fncallexpr.regionFor.keywords(",").forEach[prepend[noSpace]];
		
		for (Expr args : fncallexpr.getArgs()) {
			formatExpr(args, document);
		}
	}

	def dispatch void format(ListFilterMapExpr listfiltermapexpr, extension IFormattableDocument document) {
		listfiltermapexpr.regionFor.keyword("for").surround[oneSpace];
		listfiltermapexpr.regionFor.keywords("(").forEach[append[noSpace]];
		listfiltermapexpr.regionFor.keywords(")").forEach[prepend[noSpace]];
		for (Arg args : listfiltermapexpr.getArgs()) {
			format(args, document);
		}
		
		formatExpr(listfiltermapexpr.getFilter(), document);
		formatExpr(listfiltermapexpr.getMap(), document);
	}

	def dispatch void format(ListExpr listexpr, extension IFormattableDocument document) {
		listexpr.regionFor.keyword("[").append[noSpace];
		listexpr.regionFor.keyword("]").prepend[noSpace];
		for (Expr exprs : listexpr.getExprs()) {
			formatExpr(exprs, document);
		}
	}

	def dispatch void format(SetFilterMapExpr setfiltermapexpr, extension IFormattableDocument document) {
		setfiltermapexpr.regionFor.keyword("for").surround[oneSpace];
		setfiltermapexpr.regionFor.keywords("(").forEach[append[noSpace]];
		setfiltermapexpr.regionFor.keywords(")").forEach[prepend[noSpace]];
		for (Arg args : setfiltermapexpr.getArgs()) {
			format(args, document);
		}

		formatExpr(setfiltermapexpr.getFilter(), document);
		formatExpr(setfiltermapexpr.getMap(), document);
	}

	def dispatch void format(SetExpr setexpr, extension IFormattableDocument document) {
		setexpr.regionFor.keyword("{").append[noSpace];
		setexpr.regionFor.keyword("}").prepend[noSpace];
		for (Expr exprs : setexpr.getExprs()) {
			formatExpr(exprs, document);
		}
	}

	def dispatch void format(LetExpr letexpr, extension IFormattableDocument document) {
		letexpr.regionFor.keyword(";").prepend[noSpace].append[newLines=1];
		format(letexpr.getBinding(), document);
		formatExpr(letexpr.getExpr(), document);
	}

	def dispatch void format(LetBinding letbinding, extension IFormattableDocument document) {
		format(letbinding.getType(), document);
		formatExpr(letbinding.getExpr(), document);
	}

	def dispatch void format(ResoluteSubclause resolutesubclause, extension IFormattableDocument document) {
		
		resolutesubclause.surround[noSpace];
		
		for (AnalysisStatement proves : resolutesubclause.getProves()) {
			format(proves, document);
		}
	}

	def dispatch void format(NestedDotID nesteddotid, extension IFormattableDocument document) {
		nesteddotid.regionFor.keywords(".").forEach[surround[noSpace]];
		format(nesteddotid.getSub(), document);
	}

	def dispatch void format(ProveStatement provestatement, extension IFormattableDocument document) {
		provestatement.append[newLines=1];
		formatExpr(provestatement.getExpr(), document);
	}
	
	def dispatch void format(CheckStatement checkstatement, extension IFormattableDocument document) {
		checkstatement.append[newLines=1];
		formatExpr(checkstatement.getExpr(), document);
	}
	
	def private void formatExpr(Expr expr, extension IFormattableDocument document) {
		// ( )
		expr.regionFor.keyword("(").append[noSpace];
		expr.regionFor.keyword(")").prepend[noSpace];
		
		// [ ]
		expr.regionFor.keyword("[").append[noSpace];
		expr.regionFor.keyword("]").prepend[noSpace];
		
		// { }
		expr.regionFor.keyword("{").append[noSpace];
		expr.regionFor.keyword("}").prepend[noSpace];
		
		// ,
		expr.regionFor.keywords(",").forEach[append[oneSpace]];
		expr.regionFor.keywords(",").forEach[prepend[noSpace]];
		
		format(expr, document);
	}
}
