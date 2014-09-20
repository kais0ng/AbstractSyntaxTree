package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class AssignOperator extends Operator {

	private static final long serialVersionUID = -4462107940654673090L;

	private final static List<TerminalType> AssignOperatorTypes = Arrays
			.asList(TerminalType.ASSIGN);

	public AssignOperator(TerminalType type) {
		super(type);

		if (!AssignOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("=");
		setEndLine(Flag.CurrentLine);
	}
}
