package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class Bracket extends Terminal {

	private static final long serialVersionUID = 6476457811418290687L;

	private final static List<TerminalType> BracketTypes = Arrays.asList(
			TerminalType.LBRACKET, TerminalType.RBRACKET);

	public Bracket(TerminalType type) {
		super(type);

		if (!BracketTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (type == TerminalType.LBRACKET)
			System.out.print("[");
		else
			System.out.print("]");
		setEndLine(Flag.CurrentLine);
	}
}
