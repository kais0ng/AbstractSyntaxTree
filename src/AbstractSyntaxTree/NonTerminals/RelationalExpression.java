package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.RelationalOperator;
import Helper.Flag;

/*
 * 定义关系表达式
 */
public class RelationalExpression extends NonTerminal {

	private static final long serialVersionUID = -1477832935015986319L;

	private RelationalExpression relationalExp;
	private RelationalOperator relationalOp;
	private ShiftExpression shiftExp;

	public RelationalExpression(ShiftExpression shiftExp) {
		this(null, null, shiftExp);
	}

	public RelationalExpression(RelationalExpression relationalExp,
			RelationalOperator relationalOp, ShiftExpression shiftExp) {
		super(Arrays.asList((Node) relationalExp, (Node) relationalOp,
				(Node) shiftExp));

		if (shiftExp == null)
			throw new NullPointerException();
		if (relationalExp == null && relationalOp != null)
			throw new IllegalArgumentException();
		if (relationalExp != null && relationalOp == null)
			throw new IllegalArgumentException();
		this.relationalExp = relationalExp;
		this.relationalOp = relationalOp;
		this.shiftExp = shiftExp;
	}

	public RelationalExpression getRelationalExp() {
		return relationalExp;
	}

	public RelationalOperator getRelationalOp() {
		return relationalOp;
	}

	public ShiftExpression getShiftExp() {
		return shiftExp;
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
