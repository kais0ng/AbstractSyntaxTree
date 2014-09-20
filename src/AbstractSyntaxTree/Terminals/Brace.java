package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class Brace extends Terminal {

	private static final long serialVersionUID = 6593178236364902566L;

	private final static List<TerminalType> BraceTypes = Arrays.asList(
			TerminalType.LBRACE, TerminalType.RBRACE);

	public Brace(TerminalType type) {
		super(type);

		if (!BraceTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (type == TerminalType.LBRACE)
			System.out.print("{");
		else
			System.out.print("}");
		setEndLine(Flag.CurrentLine);
	}
}
