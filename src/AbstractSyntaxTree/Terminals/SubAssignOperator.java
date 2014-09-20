package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class SubAssignOperator extends Operator {

	private static final long serialVersionUID = 1531934510589747514L;

	private final static List<TerminalType> SubAssignOperatorTypes = Arrays
			.asList(TerminalType.SUB_ASSIGN);

	public SubAssignOperator(TerminalType type) {
		super(type);
		if (!SubAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("-=");
		setEndLine(Flag.CurrentLine);
	}
}
