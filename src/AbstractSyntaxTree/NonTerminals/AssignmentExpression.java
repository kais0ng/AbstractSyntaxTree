package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class AssignmentExpression extends NonTerminal {
	
	private static final long serialVersionUID = 2874650842186117688L;
	private ConditionalExpression conditionalExp;
	private UnaryExpression unaryExp;
	private AssignmentOperator assignmentOp;
	private AssignmentExpression assignmentExp;
	
	public AssignmentExpression(ConditionalExpression conditionalExp) {
		super(Arrays.asList((Node)conditionalExp));
		
		if(conditionalExp == null)
			throw new NullPointerException();
		this.conditionalExp = conditionalExp;
	}
	
	public AssignmentExpression(UnaryExpression unaryExp, 
			AssignmentOperator assignmentOp, AssignmentExpression assignmentExp) {
		super(Arrays.asList((Node)unaryExp, (Node)assignmentOp, (Node)assignmentExp));
		
		if(unaryExp == null || assignmentOp == null || assignmentExp == null)
			throw new NullPointerException();
		this.unaryExp = unaryExp;
		this.assignmentOp = assignmentOp;
		this.assignmentExp = assignmentExp;
	}
	
	public ConditionalExpression getConditionalExp() {
		return conditionalExp;
	}
	
	public UnaryExpression getUnaryExp() {
		return unaryExp;
	}
	
	public AssignmentOperator getAssignmentOp() {
		return assignmentOp;
	}

	public AssignmentExpression getAssignmentExp() {
		return assignmentExp;
	}
	
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		for(int index = 0; index < subNodes.size(); ++index) {
			if(index != 0) System.out.print(" ");
			subNodes.get(index).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
