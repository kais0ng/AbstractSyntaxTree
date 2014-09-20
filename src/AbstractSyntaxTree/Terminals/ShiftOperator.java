package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class ShiftOperator extends Operator {

	private static final long serialVersionUID = -5474566078424247373L;

	private final static List<TerminalType> ShiftOperatorTypes = Arrays.asList(
			TerminalType.LSHIFT, TerminalType.RSHIFT);

	public ShiftOperator(TerminalType type) {
		super(type);

		if (!ShiftOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (type == TerminalType.LSHIFT)
			System.out.print("<<");
		else
			System.out.print(">>");
		setEndLine(Flag.CurrentLine);
	}
}
