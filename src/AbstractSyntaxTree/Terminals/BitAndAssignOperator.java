package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class BitAndAssignOperator extends Operator {

	private static final long serialVersionUID = -5392852987838432799L;

	private final static List<TerminalType> BitAndAssignOperatorTypes = Arrays
			.asList(TerminalType.BIT_AND_ASSIGN);

	public BitAndAssignOperator(TerminalType type) {
		super(type);
		if (!BitAndAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("&=");
		setEndLine(Flag.CurrentLine);
	}
}
