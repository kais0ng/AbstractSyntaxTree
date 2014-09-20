package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Parenthesis;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class DoWhileStatement extends NonTerminal {

	private static final long serialVersionUID = 9109979300876516640L;
	
	private Expression exp;
	private Statement statement;

	public DoWhileStatement(Keyword keywordDo, Statement statement,
			Keyword keywordWhile, Parenthesis lParenthesis, Expression exp,
			Parenthesis rParenthesis, Punctuation punctuation) {
		super(Arrays.asList((Node) keywordDo, (Node) statement,
				(Node) keywordWhile, (Node) lParenthesis, (Node) exp,
				(Node) rParenthesis, (Node) punctuation));

		if (keywordDo == null || statement == null || keywordWhile == null
				|| lParenthesis == null || exp == null || rParenthesis == null
				|| punctuation == null)
			throw new NullPointerException();
		if (keywordDo.getType() != TerminalType.KEYWORD_DO
				|| keywordWhile.getType() != TerminalType.KEYWORD_WHILE
				|| lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS
				|| punctuation.getType() != TerminalType.SEMICOLON)
			throw new IllegalArgumentException();
		this.exp = exp;
		this.statement = statement;
	}

	public Expression getExpression() {
		return exp;
	}

	public Statement getStatement() {
		return statement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Println(0);
		++Flag.CurrentLine;
		subNodes.get(1).Println(indent + 1);
		++Flag.CurrentLine;
		super.Print(indent);
		for (int index = 2; index < subNodes.size(); ++index)
			subNodes.get(index).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
