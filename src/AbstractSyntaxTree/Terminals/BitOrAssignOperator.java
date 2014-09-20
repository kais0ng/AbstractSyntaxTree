package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class BitOrAssignOperator extends Operator {

	private static final long serialVersionUID = 2792847819456623021L;

	private final static List<TerminalType> BitOrAssignOperatorTypes = Arrays
			.asList(TerminalType.BIT_OR_ASSIGN);

	public BitOrAssignOperator(TerminalType type) {
		super(type);
		if (!BitOrAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("|=");
		setEndLine(Flag.CurrentLine);
	}
}
