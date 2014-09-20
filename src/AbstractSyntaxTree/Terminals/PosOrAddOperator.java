package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class PosOrAddOperator extends Operator {

	private static final long serialVersionUID = -7116033838812717167L;

	private final static List<TerminalType> PosOrAddOperatorTypes = Arrays
			.asList(TerminalType.POS_OR_ADD);

	public PosOrAddOperator(TerminalType type) {
		super(type);

		if (!PosOrAddOperatorTypes.contains(type)) {
			System.out.println(type);
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("+");
		setEndLine(Flag.CurrentLine);
	}
}
