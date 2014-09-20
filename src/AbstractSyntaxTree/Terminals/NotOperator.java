package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class NotOperator extends Operator {

	private static final long serialVersionUID = -8275099772731918948L;

	private final static List<TerminalType> NotOperatorTypes = Arrays
			.asList(TerminalType.NOT);

	public NotOperator(TerminalType type) {
		super(type);

		if (!NotOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("!");
		setEndLine(Flag.CurrentLine);
	}
}
