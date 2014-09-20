package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.EqualityOperator;
import Helper.Flag;

public class EqualityExpression extends NonTerminal {

	private static final long serialVersionUID = -4681065924978061031L;
	
	private EqualityExpression equalityExp;
	private EqualityOperator equalityOp;
	private RelationalExpression relationalExp;

	public EqualityExpression(RelationalExpression relationalExp) {
		this(null, null, relationalExp);
	}

	public EqualityExpression(EqualityExpression equalityExp,
			EqualityOperator equalityOp, RelationalExpression relationalExp) {
		super(Arrays.asList((Node) equalityExp, (Node) equalityOp,
				(Node) relationalExp));

		if (relationalExp == null)
			throw new NullPointerException();
		if (equalityExp == null && equalityOp != null)
			throw new IllegalArgumentException();
		if (equalityExp != null && equalityOp == null)
			throw new IllegalArgumentException();
		this.equalityExp = equalityExp;
		this.equalityOp = equalityOp;
		this.relationalExp = relationalExp;
	}

	public EqualityExpression getEqualityExp() {
		return equalityExp;
	}

	public EqualityOperator getEqualityOp() {
		return equalityOp;
	}

	public RelationalExpression getRelationalExp() {
		return relationalExp;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if (subNodes.size() > 1) {
			System.out.print(" ");
			subNodes.get(1).Print(0);
			System.out.print(" ");
			subNodes.get(2).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
