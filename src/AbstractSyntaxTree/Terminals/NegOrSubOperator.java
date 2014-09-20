package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class NegOrSubOperator extends Operator {

	private static final long serialVersionUID = 924816865652198046L;

	private final static List<TerminalType> NegOrSubOperatorTypes = Arrays
			.asList(TerminalType.NEG_OR_SUB);

	public NegOrSubOperator(TerminalType type) {
		super(type);

		if (!NegOrSubOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("-");
		setEndLine(Flag.CurrentLine);
	}
}
