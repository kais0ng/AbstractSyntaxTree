package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class BreakStatement extends NonTerminal {

	private static final long serialVersionUID = 3682854992163697533L;

	public BreakStatement(Keyword keyword, Punctuation punctuation) {
		super(Arrays.asList((Node) keyword, (Node) punctuation));

		if (keyword == null || punctuation == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_BREAK
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
