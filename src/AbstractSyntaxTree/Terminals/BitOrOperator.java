package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class BitOrOperator extends Operator {

	private static final long serialVersionUID = 8491653377100299802L;

	private final static List<TerminalType> BitOrOperatorTypes = Arrays
			.asList(TerminalType.BIT_OR);

	public BitOrOperator(TerminalType type) {
		super(type);

		if (!BitOrOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("|");
		setEndLine(Flag.CurrentLine);
	}
}
