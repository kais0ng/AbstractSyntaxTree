package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.AddressBitAndOperator;
import Helper.Flag;

public class BitAndExpression extends NonTerminal {

	private static final long serialVersionUID = 6244125420903275555L;
	
	private BitAndExpression bitAndExp;
	private AddressBitAndOperator bitAndOp;
	private EqualityExpression equalityExp;

	public BitAndExpression(EqualityExpression equalityExp) {
		this(null, null, equalityExp);
	}

	public BitAndExpression(BitAndExpression bitAndExp,
			AddressBitAndOperator bitAndOp, EqualityExpression equalityExp) {
		super(Arrays.asList((Node) bitAndExp, (Node) bitAndOp,
				(Node) equalityExp));

		if (equalityExp == null)
			throw new NullPointerException();
		if (bitAndExp == null && bitAndOp != null)
			throw new IllegalArgumentException();
		if (bitAndExp != null && bitAndOp == null)
			throw new IllegalArgumentException();
		this.bitAndExp = bitAndExp;
		this.bitAndOp = bitAndOp;
		this.equalityExp = equalityExp;
	}

	public BitAndExpression getBitAndExp() {
		return bitAndExp;
	}

	public AddressBitAndOperator getBitAndOp() {
		return bitAndOp;
	}

	public EqualityExpression getEqualityExp() {
		return equalityExp;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		for (int index = 0; index < subNodes.size(); ++index) {
			if (index != 0)
				System.out.print(" ");
			subNodes.get(index).Print(indent);
		}
		setEndLine(Flag.CurrentLine);
	}

}
