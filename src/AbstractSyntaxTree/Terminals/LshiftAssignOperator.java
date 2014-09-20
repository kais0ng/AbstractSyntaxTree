package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class LshiftAssignOperator extends Operator {

	private static final long serialVersionUID = 1437414583080984755L;

	private final static List<TerminalType> LshiftAssignOperatorTypes = Arrays
			.asList(TerminalType.LSHIFT_ASSIGN);

	public LshiftAssignOperator(TerminalType type) {
		super(type);
		if (!LshiftAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("<<=");
		setEndLine(Flag.CurrentLine);
	}
}
