package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class MulAssignOperator extends Operator {

	private static final long serialVersionUID = 7734107502145696445L;

	private final static List<TerminalType> MulAssignOperatorTypes = Arrays
			.asList(TerminalType.MUL_ASSIGN);

	public MulAssignOperator(TerminalType type) {
		super(type);
		if (!MulAssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("*=");
		setEndLine(Flag.CurrentLine);
	}
}
