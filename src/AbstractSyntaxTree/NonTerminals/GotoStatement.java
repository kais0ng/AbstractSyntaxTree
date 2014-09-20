package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Identifier;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class GotoStatement extends NonTerminal {

	private static final long serialVersionUID = 7309692582433578178L;
	
	private Identifier label;
	
	public GotoStatement(Keyword keyword, Punctuation punctuation, Identifier label) {
		super(Arrays.asList((Node)keyword, (Node)punctuation, (Node)label));
		
		if(keyword == null || punctuation == null || label == null)
			throw new NullPointerException();
		if(keyword.getType() != TerminalType.KEYWORD_GOTO || punctuation.getType() != TerminalType.COLON)
			throw new IllegalArgumentException();
		this.label = label;
	}
	
	public Identifier getLabel() {
		return label;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		subNodes.get(1).Println(1);
		++Flag.CurrentLine;
		subNodes.get(2).Println(indent + 1);
		++Flag.CurrentLine;
		setEndLine(Flag.CurrentLine);
	}
}
