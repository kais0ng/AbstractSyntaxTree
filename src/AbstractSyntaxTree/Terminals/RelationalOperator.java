package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class RelationalOperator extends Operator {

	private static final long serialVersionUID = 7916591485941877042L;

	private final static List<TerminalType> RelationalOperatorTypes = Arrays
			.asList(TerminalType.LESS_THAN, TerminalType.LESS_EQUAL,
					TerminalType.GREATER_THAN, TerminalType.GREATER_EQUAL);

	public RelationalOperator(TerminalType type) {
		super(type);
		if (!RelationalOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (type == TerminalType.LESS_THAN)
			System.out.print("<");
		else if (type == TerminalType.LESS_EQUAL)
			System.out.print("<=");
		else if (type == TerminalType.GREATER_THAN)
			System.out.print(">");
		else
			System.out.print(">=");
		setEndLine(Flag.CurrentLine);
	}
}
