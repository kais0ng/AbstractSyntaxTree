package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class ConstantExpression extends NonTerminal {

	private static final long serialVersionUID = 3950477038158395336L;
	
	ConditionalExpression conditionalExp;

	public ConstantExpression(ConditionalExpression conditionalExp) {
		super(Arrays.asList((Node) conditionalExp));

		if (conditionalExp == null)
			throw new NullPointerException();
		this.conditionalExp = conditionalExp;
	}

	public ConditionalExpression getConditionalExpression() {
		return conditionalExp;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
