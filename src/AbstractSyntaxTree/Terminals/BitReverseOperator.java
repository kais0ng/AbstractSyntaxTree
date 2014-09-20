package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class BitReverseOperator extends Operator {

	private static final long serialVersionUID = -6057748377681446431L;

	private final static List<TerminalType> BitReverseOperatorTypes = Arrays
			.asList(TerminalType.BIT_REVERSE);

	public BitReverseOperator(TerminalType type) {
		super(type);

		if (!BitReverseOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("~");
		setEndLine(Flag.CurrentLine);
	}
}
