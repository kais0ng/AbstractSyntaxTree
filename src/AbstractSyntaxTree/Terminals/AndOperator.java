package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class AndOperator extends Operator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6093055400937406700L;
	private final static List<TerminalType> OrOperatorTypes = Arrays
			.asList(TerminalType.AND);

	public AndOperator(TerminalType type) {
		super(type);

		if (!OrOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("&&");
		setEndLine(Flag.CurrentLine);
	}
}
