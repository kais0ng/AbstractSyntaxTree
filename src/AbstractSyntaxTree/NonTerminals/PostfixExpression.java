package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Bracket;
import AbstractSyntaxTree.Terminals.DomainOperator;
import AbstractSyntaxTree.Terminals.DotOperator;
import AbstractSyntaxTree.Terminals.Identifier;
import AbstractSyntaxTree.Terminals.MinusMinusOperator;
import AbstractSyntaxTree.Terminals.Parenthesis;
import AbstractSyntaxTree.Terminals.PlusPlusOperator;
import Helper.Flag;

public class PostfixExpression extends NonTerminal {

	private static final long serialVersionUID = 3044579113959376015L;
	
	/* PostfixExp --> PrimaryExp 
	 * 				| PostfixExp[exp] 
	 * 				| PostfixExp() 
	 * 				| PostfixExp(OneOrMoreArgumentExp) 
	 * 				| PostfixExp.Identifier 
	 * 				| PostfixExp->Identifier 
	 * 				| PostfixExp++ 
	 * 				| PostfixExp-- 
	 * 				*/
	private PrimaryExpression primaryExp;
	private PostfixExpression postfixExp;
	private Expression exp;
	private OneOrMoreArgumentExpression argumentExpressions;
	private List<AssignmentExpression> assignmentExpList;
	private DotOperator dotOp;
	private DomainOperator domainOp;
	private Identifier identifier;
	private PlusPlusOperator plusPlusOp;
	private MinusMinusOperator minusMinusOp;
	
	public PostfixExpression(PrimaryExpression primaryExp) {
		super(Arrays.asList((Node) primaryExp));

		if (primaryExp == null)
			throw new NullPointerException();
		this.primaryExp = primaryExp;
	}

	public PostfixExpression(PostfixExpression postfixExp, Bracket lBracket,
			Expression exp, Bracket rBracket) {
		super(Arrays.asList((Node) postfixExp, (Node) lBracket, (Node) exp,
				(Node) rBracket));

		if (postfixExp == null || lBracket == null || exp == null
				|| rBracket == null)
			throw new NullPointerException();
		if (lBracket.getType() != TerminalType.LBRACKET
				|| rBracket.getType() != TerminalType.RBRACKET)
			throw new IllegalArgumentException();
		this.postfixExp = postfixExp;
		this.exp = exp;
	}
	
	// Function  call
	public PostfixExpression(PostfixExpression postfixExp,
			Parenthesis lParenthesis, Parenthesis rParenthesis) {
		super(Arrays.asList((Node) postfixExp, (Node) lParenthesis,
				(Node) rParenthesis));

		if (postfixExp == null || lParenthesis == null || rParenthesis == null)
			throw new NullPointerException();
		if (lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.postfixExp = postfixExp;
	}

	// Function  call
	public PostfixExpression(PostfixExpression postfixExp,
			Parenthesis lParenthesis,
			OneOrMoreArgumentExpression oneOrMoreArgumentExp,
			Parenthesis rParenthesis) {
		super(Arrays.asList((Node) postfixExp, (Node) lParenthesis,
				(Node) oneOrMoreArgumentExp, (Node) rParenthesis));

		if (oneOrMoreArgumentExp == null || postfixExp == null
				|| lParenthesis == null || rParenthesis == null)
			throw new NullPointerException();
		if (lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.postfixExp = postfixExp;
		this.argumentExpressions = oneOrMoreArgumentExp;
		this.assignmentExpList = oneOrMoreArgumentExp.getAssignmentExpList();
	}
	
	public PostfixExpression(PostfixExpression postfixExp, DotOperator dotOp,
			Identifier identifier) {
		super(Arrays.asList((Node) postfixExp, (Node) dotOp, (Node) identifier));

		if (postfixExp == null || dotOp == null || identifier == null)
			throw new NullPointerException();
		this.postfixExp = postfixExp;
		this.dotOp = dotOp;
		this.identifier = identifier;
	}

	public PostfixExpression(PostfixExpression postfixExp,
			DomainOperator domainOp, Identifier identifier) {
		super(Arrays.asList((Node) postfixExp, (Node) domainOp,
				(Node) identifier));

		if (postfixExp == null || domainOp == null || identifier == null)
			throw new NullPointerException();
		this.postfixExp = postfixExp;
		this.domainOp = domainOp;
		this.identifier = identifier;
	}

	public PostfixExpression(PostfixExpression postfixExp,
			PlusPlusOperator plusPlusOp) {
		super(Arrays.asList((Node) postfixExp, (Node) plusPlusOp));

		if (postfixExp == null || plusPlusOp == null)
			throw new NullPointerException();
		this.postfixExp = postfixExp;
		this.plusPlusOp = plusPlusOp;
	}

	public PostfixExpression(PostfixExpression postfixExp,
			MinusMinusOperator minusMinusOp) {
		super(Arrays.asList((Node) postfixExp, (Node) minusMinusOp));

		if (postfixExp == null || minusMinusOp == null)
			throw new NullPointerException();
		this.postfixExp = postfixExp;
		this.minusMinusOp = minusMinusOp;
	}
	
	public PrimaryExpression getPrimaryExp() {
		return primaryExp;
	}
	
	public PostfixExpression getPostfixExp() {
		return postfixExp;
	}
	
	public Expression getExp() {
		return exp;
	}
	
	public OneOrMoreArgumentExpression getArgumentExpressions() {
		return argumentExpressions;
	}
	
	public List<AssignmentExpression> getAssignmentExpList() {
		return assignmentExpList;
	}
	
	public DotOperator getDotOp() { 
		return dotOp;
	}
	
	public DomainOperator getDomainOp() {
		return domainOp;
	}
	
	public PlusPlusOperator getPlusPlusOp() {
		return plusPlusOp;
	}
	
	public MinusMinusOperator getMinusMinusOp() {
		return minusMinusOp;
	}

	public Identifier getIdentifier() {
		return identifier;
	}
	
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		for (int index = 0; index < subNodes.size(); ++index)
			subNodes.get(index).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
