package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import AbstractSyntaxTree.Terminals.Keyword;
import Helper.Flag;

public class ReturnStatement extends NonTerminal {

	private static final long serialVersionUID = 2969164237029710250L;

	private Expression exp;

	public ReturnStatement(Keyword keyword, Punctuation punctuation) {
		this(keyword, null, punctuation);
	}

	public ReturnStatement(Keyword keyword, Expression exp,
			Punctuation punctuation) {
		super(Arrays.asList((Node) keyword, (Node) exp, (Node) punctuation));

		if (keyword == null || punctuation == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_RETURN
				|| punctuation.getType() != TerminalType.SEMICOLON)
			throw new IllegalArgumentException();
		this.exp = exp;
	}

	public Expression getExpression() {
		return exp;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		System.out.print(" ");
		for (int index = 1; index < subNodes.size(); ++index)
			subNodes.get(index).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
