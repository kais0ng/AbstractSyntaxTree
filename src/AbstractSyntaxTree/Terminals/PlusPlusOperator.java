package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class PlusPlusOperator extends Operator {

	private static final long serialVersionUID = -2273938457337563011L;

	private final static List<TerminalType> PlusPlusOperatorTypes = Arrays
			.asList(TerminalType.PLUS_PLUS);

	public PlusPlusOperator(TerminalType type) {
		super(type);

		if (!PlusPlusOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("++");
		setEndLine(Flag.CurrentLine);
	}
}
