package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.ShiftOperator;
import Helper.Flag;

public class ShiftExpression extends NonTerminal {

	private static final long serialVersionUID = -5188876009511679105L;

	private ShiftExpression shiftExp;
	private ShiftOperator shiftOp;
	private AdditiveExpression additiveExp;

	public ShiftExpression(AdditiveExpression additiveExp) {
		this(null, null, additiveExp);
	}

	public ShiftExpression(ShiftExpression shiftExp, ShiftOperator shiftOp,
			AdditiveExpression additiveExp) {
		super(Arrays
				.asList((Node) shiftExp, (Node) shiftOp, (Node) additiveExp));

		if (additiveExp == null)
			throw new NullPointerException();
		if (shiftExp == null && shiftOp != null)
			throw new IllegalArgumentException();
		if (shiftExp != null && shiftOp == null)
			throw new IllegalAccessError();
		this.shiftExp = shiftExp;
		this.shiftOp = shiftOp;
		this.additiveExp = additiveExp;
	}

	public ShiftExpression getShiftExp() {
		return shiftExp;
	}

	public ShiftOperator getShiftOp() {
		return shiftOp;
	}

	public AdditiveExpression getAdditiveExp() {
		return additiveExp;
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
