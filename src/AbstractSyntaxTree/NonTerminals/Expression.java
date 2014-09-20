package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class Expression extends NonTerminal {

	private static final long serialVersionUID = -7391361315717117159L;

	/*
	 * exp --> assignmentExp exp --> exp, assignmentExp */
	private AssignmentExpression assignmentExp;
	private Expression exp;
	//表达式是一个赋值表达式
	public Expression(AssignmentExpression assignmentExp) {
		this(null, null, assignmentExp);
		this.assignmentExp = assignmentExp;
	}

	public Expression(Expression exp, Punctuation punctuation,
			AssignmentExpression assignmentExp) {
		super(Arrays.asList((Node) exp, (Node) punctuation,
				(Node) assignmentExp));

		if (assignmentExp == null)
			throw new NullPointerException();
		if (exp == null && punctuation != null)
			throw new IllegalArgumentException();
		if (exp != null && punctuation == null)
			throw new IllegalArgumentException();
		if (punctuation != null && punctuation.getType() != TerminalType.COMMA)
			throw new IllegalArgumentException();
		this.assignmentExp = assignmentExp;
		this.exp = exp;
	}

	public AssignmentExpression getAssignmentExp() {
		return assignmentExp;
	}

	public Expression getExp() {
		return exp;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if (subNodes.size() > 1) {
			subNodes.get(1).Print(0);
			System.out.print(" ");
			subNodes.get(2).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}

}
