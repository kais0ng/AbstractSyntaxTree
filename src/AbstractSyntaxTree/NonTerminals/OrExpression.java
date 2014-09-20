package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.OrOperator;
import Helper.Flag;

public class OrExpression extends NonTerminal {

	private static final long serialVersionUID = -1540132305531625879L;
	
	private OrExpression orExp;
	private OrOperator orOp;
	private AndExpression andExp;
	
	public OrExpression(AndExpression andExp) {
		this(null, null, andExp);
	}
	
	public OrExpression(OrExpression orExp, OrOperator orOp, AndExpression andExp) {
		super(Arrays.asList(
				(Node)orExp, (Node)orOp, (Node)andExp));
		
		if(andExp == null)
			throw new NullPointerException();
		if(orExp == null && orOp != null)
			throw new IllegalArgumentException();
		if(orExp != null && orOp == null)
			throw new IllegalArgumentException();
		this.orExp = orExp;
		this.orOp = orOp;
		this.andExp = andExp;
	}
	
	public OrExpression getOrExp() {
		return orExp;
	}
	
	public OrOperator getOrOp() {
		return orOp;
	}
	
	public AndExpression getAndExp() {
		return andExp;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if(subNodes.size() > 1) {
			System.out.print(" ");
			subNodes.get(1).Print(0);
			System.out.print(" ");
			subNodes.get(2).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
