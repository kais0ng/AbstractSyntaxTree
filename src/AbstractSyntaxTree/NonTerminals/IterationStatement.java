package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class IterationStatement extends NonTerminal {

	private static final long serialVersionUID = 4011674131179309531L;
	
	private ForStatement forStatement;
	private WhileStatement whileStatement;
	private DoWhileStatement doWhileStatement;

	public IterationStatement(ForStatement forStatement) {
		super(Arrays.asList((Node) forStatement));

		if (forStatement == null)
			throw new NullPointerException();
		this.forStatement = forStatement;
	}

	public IterationStatement(WhileStatement whileStatement) {
		super(Arrays.asList((Node) whileStatement));

		if (whileStatement == null)
			throw new NullPointerException();
		this.whileStatement = whileStatement;
	}

	public IterationStatement(DoWhileStatement doWhileStatement) {
		super(Arrays.asList((Node) doWhileStatement));

		if (doWhileStatement == null)
			throw new NullPointerException();
		this.doWhileStatement = doWhileStatement;
	}
	
	public ForStatement getForStatement() {
		return forStatement;
	}
	
	public WhileStatement getWhileStatement() {
		return whileStatement;
	}
	
	public DoWhileStatement getDoWhileStatement() {
		return doWhileStatement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		setEndLine(Flag.CurrentLine);
	}
}
