package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class ContinueStatement extends NonTerminal {

	private static final long serialVersionUID = -4502951231144035435L;

	public ContinueStatement(Keyword keyword, Punctuation punctuation) {
		super(Arrays.asList((Node) keyword, (Node) punctuation));

		if (keyword == null || punctuation == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_CONTINUE
				|| punctuation.getType() != TerminalType.SEMICOLON)
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		subNodes.get(1).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
