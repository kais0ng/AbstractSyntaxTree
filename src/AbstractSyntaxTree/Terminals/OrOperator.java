package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class OrOperator extends Operator {

	private static final long serialVersionUID = -8429672281550189287L;

	private final static List<TerminalType> OrOperatorTypes = Arrays
			.asList(TerminalType.OR);

	public OrOperator(TerminalType type) {
		super(type);

		if (!OrOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("||");
		setEndLine(Flag.CurrentLine);
	}
}
