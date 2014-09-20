package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.MinusMinusOperator;
import AbstractSyntaxTree.Terminals.Parenthesis;
import AbstractSyntaxTree.Terminals.PlusPlusOperator;
import Helper.Flag;

public class UnaryExpression extends NonTerminal {

	private static final long serialVersionUID = -2937681995823314914L;

	/* UnaryExp --> PostfixExp | ++UnaryExp | --UnaryExp | UnaryOp CastExp | sizeof(UnaryExp) |
	 * sizeof(typeName) */
	private PostfixExpression postfixExp;
	private PlusPlusOperator plusPlusOp;
	private MinusMinusOperator minusMinusOp;
	private UnaryExpression unaryExp;
	private UnaryOperator unaryOp;
	private CastExpression castExp;
	private Keyword keyword;
	private TypeName typeName;

	public UnaryExpression(PostfixExpression postfixExp) {
		super(Arrays.asList((Node) postfixExp));

		if (postfixExp == null)
			throw new NullPointerException();
		this.postfixExp = postfixExp;
	}

	public UnaryExpression(PlusPlusOperator plusPlusOp, UnaryExpression unaryExp) {
		super(Arrays.asList((Node) plusPlusOp, (Node) unaryExp));

		if (plusPlusOp == null || unaryExp == null)
			throw new IllegalArgumentException();
		this.plusPlusOp = plusPlusOp;
		this.unaryExp = unaryExp;
	}

	public UnaryExpression(MinusMinusOperator minusMinusOp,
			UnaryExpression unaryExp) {
		super(Arrays.asList((Node) minusMinusOp, (Node) unaryExp));

		if (minusMinusOp == null || unaryExp == null)
			throw new IllegalArgumentException();
		this.minusMinusOp = minusMinusOp;
		this.unaryExp = unaryExp;
	}

	public UnaryExpression(UnaryOperator unaryOp, CastExpression castExp) {
		super(Arrays.asList((Node) unaryOp, (Node) castExp));

		if (unaryOp == null || castExp == null)
			throw new IllegalArgumentException();
		this.unaryOp = unaryOp;
		this.castExp = castExp;
	}

	public UnaryExpression(Keyword keyword, Parenthesis lParenthesis,
			UnaryExpression unaryExp, Parenthesis rParenthesis) {
		super(Arrays.asList((Node) keyword, (Node) lParenthesis,
				(Node) unaryExp, (Node) rParenthesis));

		if (keyword == null || lParenthesis == null || unaryExp == null
				|| rParenthesis == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_SIZEOF
				|| lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.keyword = keyword;
		this.unaryExp = unaryExp;
	}

	public UnaryExpression(Keyword keyword, Parenthesis lParenthesis,
			TypeName typeName, Parenthesis rParenthesis) {
		super(Arrays.asList((Node) keyword, (Node) lParenthesis,
				(Node) typeName, (Node) rParenthesis));

		if (keyword == null || lParenthesis == null || typeName == null
				|| rParenthesis == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_SIZEOF
				|| lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.keyword = keyword;
		this.typeName = typeName;
	}

	public PostfixExpression getPostfixExp() {
		return postfixExp;
	}

	public PlusPlusOperator getPlusPlusOp() {
		return plusPlusOp;
	}

	public MinusMinusOperator getMinusMinusOp() {
		return minusMinusOp;
	}

	public UnaryExpression getUnaryExp() {
		return unaryExp;
	}

	public UnaryOperator getUnaryOp() {
		return unaryOp;
	}

	public CastExpression getCastExp() {
		return castExp;
	}

	public Keyword getKeyword() {
		return keyword;
	}

	public TypeName getTypeName() {
		return typeName;
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
