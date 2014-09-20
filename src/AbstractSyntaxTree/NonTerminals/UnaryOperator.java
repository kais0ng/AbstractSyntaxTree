package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.AddressBitAndOperator;
import AbstractSyntaxTree.Terminals.BitReverseOperator;
import AbstractSyntaxTree.Terminals.DerefenceOrMulOperator;
import AbstractSyntaxTree.Terminals.NegOrSubOperator;
import AbstractSyntaxTree.Terminals.NotOperator;
import AbstractSyntaxTree.Terminals.Operator;
import AbstractSyntaxTree.Terminals.PosOrAddOperator;
import Helper.Flag;

public class UnaryOperator extends NonTerminal {

	private static final long serialVersionUID = 7827582046101105288L;

	private Operator op;

	public UnaryOperator(AddressBitAndOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
		this.op = op;
	}

	public UnaryOperator(DerefenceOrMulOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
		this.op = op;
	}

	public UnaryOperator(PosOrAddOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
		this.op = op;
	}

	public UnaryOperator(NegOrSubOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
		this.op = op;
	}

	public UnaryOperator(BitReverseOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
		this.op = op;
	}

	public UnaryOperator(NotOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
		this.op = op;
	}

	public Operator getOp() {
		return op;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
