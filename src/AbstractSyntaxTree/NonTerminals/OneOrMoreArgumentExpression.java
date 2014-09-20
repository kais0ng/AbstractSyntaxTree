package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class OneOrMoreArgumentExpression extends NonTerminal {

	private static final long serialVersionUID = 231969476854762783L;

	private List<AssignmentExpression> assignmentExpList;

	public OneOrMoreArgumentExpression(AssignmentExpression assignmentExp) {
		this(null, null, assignmentExp);
	}

	public OneOrMoreArgumentExpression(
			OneOrMoreArgumentExpression oneOrMoreArgumentExp,
			Punctuation punctuation, AssignmentExpression assignmentExp) {
		super(Arrays.asList((Node) oneOrMoreArgumentExp, (Node) punctuation,
				(Node) assignmentExp));

		if (assignmentExp == null)
			throw new NullPointerException();
		if (oneOrMoreArgumentExp == null && punctuation != null)
			throw new IllegalArgumentException();
		if (oneOrMoreArgumentExp != null && punctuation == null)
			throw new IllegalArgumentException();
		if (punctuation != null && punctuation.getType() != TerminalType.COMMA)
			throw new IllegalArgumentException();
		if (oneOrMoreArgumentExp == null) {
			assignmentExpList = Arrays.asList(assignmentExp);
		} else {
			assignmentExpList = new ArrayList<AssignmentExpression>();
			assignmentExpList.addAll(oneOrMoreArgumentExp.assignmentExpList);
			assignmentExpList.add(assignmentExp);
		}
	}

	public List<AssignmentExpression> getAssignmentExpList() {
		return assignmentExpList;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		if (subNodes.size() > 1) {
			subNodes.get(1).Print(0);
			System.out.print(" ");
			subNodes.get(2).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
