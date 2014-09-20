package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;
import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class EqualityOperator extends Terminal {

	private static final long serialVersionUID = -3945073569061605945L;

	private final static List<TerminalType> EqualityOperatorTypes = Arrays
			.asList(TerminalType.EQUAL, TerminalType.NOT_EQUAL);

	public EqualityOperator(TerminalType type) {
		super(type);

		if (!EqualityOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (type == TerminalType.EQUAL)
			System.out.print("==");
		else
			System.out.print("!=");
		setEndLine(Flag.CurrentLine);
	}
}
