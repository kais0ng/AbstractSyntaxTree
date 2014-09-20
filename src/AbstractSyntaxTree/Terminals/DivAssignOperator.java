package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class DivAssignOperator extends Operator {

	private static final long serialVersionUID = 6948319157753232638L;

	private final static List<TerminalType> DivAssignOperatorTypes = Arrays
			.asList(TerminalType.DIV_ASSIGN);

	public DivAssignOperator(TerminalType type) {
		super(type);
		if (!DivAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("/=");
		setEndLine(Flag.CurrentLine);
	}
}
