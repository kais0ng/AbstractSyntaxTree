package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class CaseStatement extends NonTerminal {
	
	private static final long serialVersionUID = 6360051407654810033L;
	
	private ConstantExpression constExp;
	private Statement statement;
	
	public CaseStatement(Keyword keyword, ConstantExpression constExp, Punctuation punctuation, Statement statement) {
		super(Arrays.asList((Node)keyword, (Node)constExp, (Node)punctuation, (Node)statement));
		
		if(keyword == null || constExp == null || punctuation == null || statement == null)
			throw new NullPointerException();
		if(keyword.getType() != TerminalType.KEYWORD_CASE)
			throw new IllegalArgumentException();
		if(punctuation.getType() != TerminalType.COLON)
			throw new IllegalArgumentException();
		this.constExp = constExp;
		this.statement = statement;
	}
	
	public ConstantExpression getConstantExpression() {
		return constExp;
	}
	
	public Statement getStatement() {
		return statement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		System.out.print(" ");
		subNodes.get(1).Print(0);
		subNodes.get(2).Println(0);
		++Flag.CurrentLine;
		subNodes.get(3).Print(indent + 1);
		setEndLine(Flag.CurrentLine);
	}
}
