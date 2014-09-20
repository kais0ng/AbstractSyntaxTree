package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.AndOperator;
import Helper.Flag;

public class AndExpression extends NonTerminal {

	private static final long serialVersionUID = -4300502498737429113L;

	private AndExpression andExp;
	private AndOperator andOp;
	private BitOrExpression bitOrExp;

	public AndExpression(BitOrExpression bitOrExp) {
		this(null, null, bitOrExp);
	}

	public AndExpression(AndExpression andExp, AndOperator andOp,
			BitOrExpression bitOrExp) {
		super(Arrays.asList((Node) andExp, (Node) andOp, (Node) bitOrExp));
		if (bitOrExp == null)
			throw new NullPointerException();

		if (andExp == null && andOp != null)
			throw new IllegalArgumentException();
		if (andExp != null && andOp == null)
			throw new IllegalArgumentException();
		this.andExp = andExp;
		this.andOp = andOp;
		this.bitOrExp = bitOrExp;
	}

	public AndExpression getAndExp() {
		return andExp;
	}

	public AndOperator getAndOp() {
		return andOp;
	}

	public BitOrExpression getBitOrExp() {
		return bitOrExp;
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
