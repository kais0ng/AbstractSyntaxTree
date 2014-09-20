package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class DotOperator extends Operator {

	private static final long serialVersionUID = 8334352719981560843L;

	private final static List<TerminalType> DotOperatorTypes = Arrays
			.asList(TerminalType.DOT);

	public DotOperator(TerminalType type) {
		super(type);

		if (!DotOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print(".");
		setEndLine(Flag.CurrentLine);
	}
}
