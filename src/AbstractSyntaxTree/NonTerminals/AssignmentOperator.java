package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.AddAssignOperator;
import AbstractSyntaxTree.Terminals.AssignOperator;
import AbstractSyntaxTree.Terminals.BitAndAssignOperator;
import AbstractSyntaxTree.Terminals.BitOrAssignOperator;
import AbstractSyntaxTree.Terminals.BitXorAssignOperator;
import AbstractSyntaxTree.Terminals.DivAssignOperator;
import AbstractSyntaxTree.Terminals.LshiftAssignOperator;
import AbstractSyntaxTree.Terminals.ModAssignOperator;
import AbstractSyntaxTree.Terminals.MulAssignOperator;
import AbstractSyntaxTree.Terminals.RshiftAssignOperator;
import AbstractSyntaxTree.Terminals.SubAssignOperator;
import Helper.Flag;

public class AssignmentOperator extends NonTerminal {

	private static final long serialVersionUID = -1694087960053971764L;

	public AssignmentOperator(AssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(MulAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(DivAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(ModAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(AddAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(SubAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(LshiftAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(RshiftAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(BitAndAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(BitOrAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	public AssignmentOperator(BitXorAssignOperator op) {
		super(Arrays.asList((Node) op));
		if (op == null)
			throw new NullPointerException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
