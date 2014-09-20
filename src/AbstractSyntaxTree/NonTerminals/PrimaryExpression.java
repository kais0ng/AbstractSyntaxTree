package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Identifier;
import AbstractSyntaxTree.Terminals.Parenthesis;
import Helper.Flag;

public class PrimaryExpression extends NonTerminal {

	private static final long serialVersionUID = -3148041622501601077L;

	/*
	 * PrimaryExp --> Identifier | Constant | (exp) */
	private Identifier identifier;
	private Constant constant;
	private Expression exp;

	public PrimaryExpression(Identifier identifier) {
		super(Arrays.asList((Node) identifier));

		if (identifier == null)
			throw new NullPointerException();
		this.identifier = identifier;
	}

	public PrimaryExpression(Constant constant) {
		super(Arrays.asList((Node) constant));

		if (constant == null)
			throw new NullPointerException();
		this.constant = constant;
	}

	public PrimaryExpression(Parenthesis lParenthesis, Expression exp,
			Parenthesis rParenthesis) {
		super(Arrays.asList((Node) lParenthesis, (Node) exp,
				(Node) rParenthesis));

		if (lParenthesis == null || exp == null || rParenthesis == null)
			throw new NullPointerException();
		if (lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.exp = exp;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public Constant getConstant() {
		return constant;
	}

	public Expression getExp() {
		return exp;
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
