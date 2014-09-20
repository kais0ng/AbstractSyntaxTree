package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class ModOperator extends Operator {

	private static final long serialVersionUID = 3028671370438851621L;

	private final static List<TerminalType> ModOperatorTypes = Arrays
			.asList(TerminalType.MOD);

	public ModOperator(TerminalType type) {
		super(type);

		if (!ModOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("%");
		setEndLine(Flag.CurrentLine);
	}
}
