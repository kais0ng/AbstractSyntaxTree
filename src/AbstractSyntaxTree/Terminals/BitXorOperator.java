package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class BitXorOperator extends Operator {

	private static final long serialVersionUID = -3878258626581949729L;

	private final static List<TerminalType> BitXorOperators = Arrays
			.asList(TerminalType.BIT_XOR);

	public BitXorOperator(TerminalType type) {
		super(type);

		if (!BitXorOperators.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("^");
		setEndLine(Flag.CurrentLine);
	}
}
