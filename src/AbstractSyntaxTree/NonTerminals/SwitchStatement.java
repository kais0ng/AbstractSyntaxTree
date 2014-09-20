package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Parenthesis;
import Helper.Flag;

public class SwitchStatement extends NonTerminal {

	private static final long serialVersionUID = 7540287579401492719L;
	private Expression exp;
	private Statement statement;

	public SwitchStatement(Keyword keyword, Parenthesis lParenthesis,
			Expression exp, Parenthesis rParenthesis,
			Statement statement) {
		super(Arrays.asList((Node) keyword, (Node) lParenthesis,
				(Node) exp, (Node) rParenthesis, (Node) statement));

		if (keyword == null || lParenthesis == null || exp == null
				|| rParenthesis == null || statement == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_SWITCH
				|| lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.exp = exp;
		this.statement = statement;
	}
	public Expression getExpression(){
		return exp;
	}

	public Statement getStatement() {
		return statement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		for (int index = 0; index < 4; ++index)
			subNodes.get(index).Print(0);
		System.out.println();
		++Flag.CurrentLine;
		subNodes.get(4).Print(indent + 1);
		setEndLine(Flag.CurrentLine);
	}
}
