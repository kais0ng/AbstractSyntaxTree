package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class AddressBitAndOperator extends Operator {

	private static final long serialVersionUID = 5889641378525224895L;

	private final static List<TerminalType> AddressBitAndOperatorTypes = Arrays
			.asList(TerminalType.ADDRESS_BIT_AND);

	public AddressBitAndOperator(TerminalType type) {
		super(type);
		if (!AddressBitAndOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("&");
		setEndLine(Flag.CurrentLine);
	}
}
