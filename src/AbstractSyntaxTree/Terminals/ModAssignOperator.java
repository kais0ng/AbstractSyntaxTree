package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class ModAssignOperator extends Operator {

	private static final long serialVersionUID = 1390726422540522354L;

	private final static List<TerminalType> ModAssignOperatorTypes = Arrays
			.asList(TerminalType.MOD_ASSIGN);

	public ModAssignOperator(TerminalType type) {
		super(type);
		if (!ModAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("%=");
		setEndLine(Flag.CurrentLine);
	}
}
