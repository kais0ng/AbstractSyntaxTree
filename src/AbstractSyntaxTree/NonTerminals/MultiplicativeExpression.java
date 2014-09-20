package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.DerefenceOrMulOperator;
import AbstractSyntaxTree.Terminals.DivOperator;
import AbstractSyntaxTree.Terminals.ModOperator;
import Helper.Flag;

public class MultiplicativeExpression extends NonTerminal {

	private static final long serialVersionUID = -289572068165535578L;

	/* MultiplicativeExp --> CastExp | MultiplicativeExp * castExp | MultiplicativeExp / castExp |
	 * MultiplicativeExp % castExp */
	private MultiplicativeExpression multiplicativeExp;
	private DerefenceOrMulOperator mulOp;
	private DivOperator divOp;
	private ModOperator modOp;
	private CastExpression castExp;

	public MultiplicativeExpression(CastExpression castExp) {
		super(Arrays.asList((Node) castExp));

		if (castExp == null)
			throw new NullPointerException();
		this.castExp = castExp;
	}

	public MultiplicativeExpression(MultiplicativeExpression multiplicativeExp,
			DerefenceOrMulOperator mulOp, CastExpression castExp) {
		super(Arrays.asList((Node) multiplicativeExp, (Node) mulOp,
				(Node) castExp));

		if (castExp == null)
			throw new NullPointerException();
		if (multiplicativeExp == null && mulOp != null)
			throw new IllegalArgumentException();
		if (multiplicativeExp != null && mulOp == null)
			throw new IllegalArgumentException();
		this.multiplicativeExp = multiplicativeExp;
		this.mulOp = mulOp;
		this.castExp = castExp;
	}

	public MultiplicativeExpression(MultiplicativeExpression multiplicativeExp,
			DivOperator divOp, CastExpression castExp) {
		super(Arrays.asList((Node) multiplicativeExp, (Node) divOp,
				(Node) castExp));

		if (castExp == null)
			throw new NullPointerException();
		if (multiplicativeExp == null && divOp != null)
			throw new IllegalArgumentException();
		if (multiplicativeExp != null && divOp == null)
			throw new IllegalArgumentException();
		this.multiplicativeExp = multiplicativeExp;
		this.divOp = divOp;
		this.castExp = castExp;
	}

	public MultiplicativeExpression(MultiplicativeExpression multiplicativeExp,
			ModOperator modOp, CastExpression castExp) {
		super(Arrays.asList((Node) multiplicativeExp, (Node) modOp,
				(Node) castExp));

		if (castExp == null)
			throw new NullPointerException();
		if (multiplicativeExp == null && modOp != null)
			throw new IllegalArgumentException();
		if (multiplicativeExp != null && modOp == null)
			throw new IllegalArgumentException();
		this.multiplicativeExp = multiplicativeExp;
		this.modOp = modOp;
		this.castExp = castExp;
	}

	public MultiplicativeExpression getMultiplicativeExp() {
		return multiplicativeExp;
	}

	public DerefenceOrMulOperator getMulOp() {
		return mulOp;
	}

	public DivOperator getDivOp() {
		return divOp;
	}

	public ModOperator getModOp() {
		return modOp;
	}

	public CastExpression getCastExp() {
		return castExp;
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
