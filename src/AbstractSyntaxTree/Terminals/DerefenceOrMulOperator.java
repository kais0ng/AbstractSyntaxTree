package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class DerefenceOrMulOperator extends Operator {

	private static final long serialVersionUID = 4806610443858351409L;

	private final static List<TerminalType> DerefenceOrMulOperatorTypes = Arrays
			.asList(TerminalType.DEREF_MUL);

	public DerefenceOrMulOperator(TerminalType type) {
		super(type);

		if (!DerefenceOrMulOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("*");
		setEndLine(Flag.CurrentLine);
	}
}
