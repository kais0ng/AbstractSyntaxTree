package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class BitXorAssignOperator extends Operator {

	private static final long serialVersionUID = -5193972077763880342L;

	private final static List<TerminalType> BitXorAssignOperatorTypes = Arrays
			.asList(TerminalType.BIT_XOR_ASSIGN);

	public BitXorAssignOperator(TerminalType type) {
		super(type);
		if (!BitXorAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("^=");
		setEndLine(Flag.CurrentLine);
	}
}
