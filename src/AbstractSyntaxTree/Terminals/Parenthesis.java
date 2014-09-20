package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class Parenthesis extends Terminal {

	private static final long serialVersionUID = 2125921360344950455L;

	private final static List<TerminalType> ParenthesisTypes = Arrays.asList(
			TerminalType.LPARENTHESIS, TerminalType.RPARENTHESIS);

	public Parenthesis(TerminalType type) {
		super(type);

		if (!ParenthesisTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (type == TerminalType.LPARENTHESIS)
			System.out.print("(");
		else
			System.out.print(")");
		setEndLine(Flag.CurrentLine);
	}
}
