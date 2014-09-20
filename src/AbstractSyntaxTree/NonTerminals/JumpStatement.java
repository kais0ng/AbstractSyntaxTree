package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class JumpStatement extends NonTerminal {

	private static final long serialVersionUID = 2676101319433611206L;
	
	private GotoStatement gotoStatement;
	private ContinueStatement continueStatement;
	private BreakStatement breakStatement;
	private ReturnStatement returnStatement;
	
	public JumpStatement(GotoStatement gotoStatement) {
		super(Arrays.asList((Node)gotoStatement));
		
		if(gotoStatement == null)
			throw new NullPointerException();
		this.gotoStatement = gotoStatement;
	}
	
	public JumpStatement(ContinueStatement continueStatement) {
		super(Arrays.asList((Node)continueStatement));
		
		if(continueStatement == null)
			throw new NullPointerException();
		this.continueStatement = continueStatement;
	}
	
	public JumpStatement(BreakStatement breakStatement) {
		super(Arrays.asList((Node)breakStatement));
		
		if(breakStatement == null)
			throw new NullPointerException();
		this.breakStatement = breakStatement;
	}
	
	public JumpStatement(ReturnStatement returnStatement) {
		super(Arrays.asList((Node)returnStatement));
		
		if(returnStatement == null)
			throw new NullPointerException();
		this.returnStatement = returnStatement;
	}
	
	public GotoStatement getGotoStatement() {
		return gotoStatement;
	}
	
	public ContinueStatement getContinueStatement() {
		return continueStatement;
	}
	
	public BreakStatement getBreakStatement() {
		return breakStatement;
	}
	
	public ReturnStatement getReturnStatement() {
		return returnStatement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
