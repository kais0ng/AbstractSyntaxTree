package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.NegOrSubOperator;
import AbstractSyntaxTree.Terminals.PosOrAddOperator;
import Helper.Flag;

public class AdditiveExpression extends NonTerminal {

	private static final long serialVersionUID = 6407423292222768523L;
	/* AdditiveExp --> MultiplicativeExp 
	 * 				 | AdditiveExp + MultiplicativeExp 
	 * 				 | AdditiveExp - MultiplicativeExp */
	private AdditiveExpression additiveExp;
	private PosOrAddOperator addOp;
	private NegOrSubOperator subOp;
	private MultiplicativeExpression multiplicativeExp;
	//Additive expression constructed in the first way,way=0
	public AdditiveExpression(MultiplicativeExpression multiplicativeExp) {
		super(Arrays.asList((Node) multiplicativeExp));

		if (multiplicativeExp == null)
			throw new NullPointerException();
		this.multiplicativeExp = multiplicativeExp;
	}
	//Additive expression constructed in the second way,way=1
	public AdditiveExpression(AdditiveExpression additiveExp,
			PosOrAddOperator addOp, MultiplicativeExpression multiplicativeExp) {
		super(Arrays.asList((Node) additiveExp, (Node) addOp,
				(Node) multiplicativeExp));

		if (multiplicativeExp == null)
			throw new NullPointerException();
		if (additiveExp == null && addOp != null)
			throw new IllegalArgumentException();
		if (additiveExp != null && addOp == null)
			throw new IllegalArgumentException();
		this.additiveExp = additiveExp;
		this.addOp = addOp;
		this.multiplicativeExp = multiplicativeExp;
	}
	//Additive expression constructed in  the third way,way=3
	public AdditiveExpression(AdditiveExpression additiveExp,
			NegOrSubOperator subOp, MultiplicativeExpression multiplicativeExp) {
		super(Arrays.asList((Node) additiveExp, (Node) subOp,
				(Node) multiplicativeExp));

		if (multiplicativeExp == null)
			throw new NullPointerException();
		if (additiveExp == null && subOp != null)
			throw new IllegalArgumentException();
		if (additiveExp != null && subOp == null)
			throw new IllegalArgumentException();
		this.additiveExp = additiveExp;
		this.subOp = subOp;
		this.multiplicativeExp = multiplicativeExp;
	}

	public AdditiveExpression getAdditiveExp() {
		return additiveExp;
	}

	public PosOrAddOperator getAddOp() {
		return addOp;
	}

	public NegOrSubOperator getSubOp() {
		return subOp;
	}

	public MultiplicativeExpression getMultiplicativeExp() {
		return multiplicativeExp;
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
