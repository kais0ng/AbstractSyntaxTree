package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class AddAssignOperator extends Operator {

	private static final long serialVersionUID = 3422578671413450972L;

	private final static List<TerminalType> AddAssignOperatorTypes = Arrays
			.asList(TerminalType.ADD_ASSIGN);

	public AddAssignOperator(TerminalType type) {
		super(type);
		if (!AddAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("+=");
		setEndLine(Flag.CurrentLine);
	}
}
