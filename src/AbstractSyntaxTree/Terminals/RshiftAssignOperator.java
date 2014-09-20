package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class RshiftAssignOperator extends Operator {

	private static final long serialVersionUID = 6779606121663165974L;

	private final static List<TerminalType> RshiftAssignOperatorTypes = Arrays
			.asList(TerminalType.RSHIFT_ASSIGN);

	public RshiftAssignOperator(TerminalType type) {
		super(type);
		if (!RshiftAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print(">>=");
		setEndLine(Flag.CurrentLine);
	}
}
