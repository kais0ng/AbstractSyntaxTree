package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class MinusMinusOperator extends Operator {

	private static final long serialVersionUID = 1939693096631315443L;

	private final static List<TerminalType> MinusMinusOperatorTypes = Arrays
			.asList(TerminalType.MINUS_MINUS);

	public MinusMinusOperator(TerminalType type) {
		super(type);

		if (!MinusMinusOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("--");
		setEndLine(Flag.CurrentLine);
	}
}
