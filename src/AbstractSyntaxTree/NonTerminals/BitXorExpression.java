package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.BitXorOperator;
import Helper.Flag;

public class BitXorExpression extends NonTerminal {

	private static final long serialVersionUID = -1979201950964024344L;
	
	private BitXorExpression bitXorExp;
	private BitXorOperator bitXorOp;
	private BitAndExpression bitAndExp;

	public BitXorExpression(BitAndExpression bitAndExp) {
		this(null, null, bitAndExp);
	}

	public BitXorExpression(BitXorExpression bitXorExp,
			BitXorOperator bitXorOp, BitAndExpression bitAndExp) {
		super(Arrays.asList((Node) bitXorExp, (Node)bitXorOp, (Node) bitAndExp));

		if (bitAndExp == null)
			throw new NullPointerException();
		if (bitXorExp == null && bitXorOp != null)
			throw new IllegalArgumentException();
		if (bitXorExp != null && bitXorOp == null)
			throw new IllegalArgumentException();
		this.bitXorExp = bitXorExp;
		this.bitXorOp = bitXorOp;
		this.bitAndExp = bitAndExp;
	}

	public BitXorExpression getBitXorExp() {
		return bitXorExp;
	}

	public BitXorOperator getBitXorOp() {
		return bitXorOp;
	}

	public BitAndExpression getBitAndExp() {
		return bitAndExp;
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
