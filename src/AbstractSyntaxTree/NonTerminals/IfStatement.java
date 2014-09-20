package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Parenthesis;
import Helper.Flag;

public class IfStatement extends NonTerminal {

	private static final long serialVersionUID = 1429738343773680728L;

	private Expression conditionExp;//条件表达式
	private Statement ifClauseStatement;
	private Statement elseClauseStatement;
	//只含有if
	public IfStatement(Keyword keywordIf, Parenthesis lParenthesis,
			Expression condition, Parenthesis rParenthesis, Statement statement) {
		this(keywordIf, lParenthesis, condition, rParenthesis, statement, null,
				null);
	}
	//含有if和else
	public IfStatement(Keyword keywordIf, Parenthesis lParenthesis,
			Expression condition, Parenthesis rParenthesis,
			Statement ifClauseStatement, Keyword elseKeyword,
			Statement elseCluaseStatement) {
		super(Arrays.asList((Node) keywordIf, (Node) lParenthesis,
				(Node) condition, (Node) rParenthesis,
				(Node) ifClauseStatement, (Node) elseKeyword,
				(Node) elseCluaseStatement));

		if (keywordIf == null || lParenthesis == null || condition == null
				|| rParenthesis == null || ifClauseStatement == null)
			throw new NullPointerException();
		if (elseKeyword == null && elseCluaseStatement != null)
			throw new IllegalArgumentException();
		if (elseKeyword != null && elseCluaseStatement == null)
			throw new IllegalArgumentException();
		if (keywordIf.getType() != TerminalType.KEYWORD_IF
				|| lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS
				|| (elseKeyword != null && elseKeyword.getType() != TerminalType.KEYWORD_ELSE))
			throw new IllegalArgumentException();

		this.conditionExp = condition;
		this.ifClauseStatement = ifClauseStatement;
		this.elseClauseStatement = elseCluaseStatement;
	}

	public Expression getConditionExp() {
		return conditionExp;
	}

	public Statement getIfClauseStatement() {
		return ifClauseStatement;
	}

	public Statement getElseClauseStatement() {
		return elseClauseStatement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("if(");
		conditionExp.Print(0);
		System.out.print(")");
		if (Flag.__LINE__ && ifClauseStatement.getCompoundStatement() == null)
			System.out.print(" {");
		System.out.println();
		++Flag.CurrentLine;
		ifClauseStatement.Print(indent + 1);
		if (Flag.__LINE__ && ifClauseStatement.getCompoundStatement() == null) {
			System.out.print("}");
		}

		if (elseClauseStatement != null) {
			System.out.println();
			++Flag.CurrentLine;
			super.Print(indent);
			System.out.print("else");
			if (Flag.__LINE__
					&& elseClauseStatement.getCompoundStatement() == null)
				System.out.print(" {");
			System.out.println();
			++Flag.CurrentLine;
			elseClauseStatement.Print(indent + 1);
			if (Flag.__LINE__
					&& elseClauseStatement.getCompoundStatement() == null)
				System.out.print("}");
		}
		setEndLine(Flag.CurrentLine);
	}
}
