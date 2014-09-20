package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class DefaultStatement extends NonTerminal {

	private static final long serialVersionUID = 2597611243754918665L;
	
	private Statement statement;
	
	public DefaultStatement(Keyword keyword, Punctuation punctuation, Statement statement) {
		super(Arrays.asList((Node)keyword, (Node)punctuation, (Node)statement));
		
		if(keyword == null || punctuation == null)
			throw new NullPointerException();
		if(keyword.getType() != TerminalType.KEYWORD_DEFAULT || punctuation.getType() != TerminalType.COLON)
			throw new IllegalArgumentException();
		this.statement = statement;
	}
	
	public Statement getStatement() {
		return statement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		subNodes.get(1).Println(0);
		++Flag.CurrentLine;
		subNodes.get(2).Print(indent + 1);
		setEndLine(Flag.CurrentLine);
	}
}
