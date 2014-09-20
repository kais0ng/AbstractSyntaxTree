package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.BitOrOperator;
import Helper.Flag;

public class BitOrExpression extends NonTerminal {

	private static final long serialVersionUID = -4088846215984835704L;
	
	private BitOrExpression bitOrExp;
	private BitOrOperator bitOrOp;
	private BitXorExpression bitXorExp;
	
	public BitOrExpression(BitXorExpression bitXorExp) {
		this(null, null, bitXorExp);
	}
	
	public BitOrExpression(BitOrExpression bitOrExp, BitOrOperator bitOrOp,
			BitXorExpression bitXorExp) {
		super(Arrays.asList((Node) bitOrExp, (Node) bitOrOp, (Node) bitXorExp));

		if (bitXorExp == null)
			throw new NullPointerException();
		if (bitOrExp == null && bitOrOp != null)
			throw new IllegalArgumentException();
		if (bitOrExp != null && bitOrOp == null)
			throw new IllegalArgumentException();
		this.bitOrExp = bitOrExp;
		this.bitOrOp = bitOrOp;
		this.bitXorExp = bitXorExp;
	}

	public BitOrExpression getBitOrExp() {
		return bitOrExp;
	}

	public BitOrOperator getBitOrOp() {
		return bitOrOp;
	}

	public BitXorExpression getBitXorExp() {
		return bitXorExp;
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
