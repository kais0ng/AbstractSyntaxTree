package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class DivOperator extends Operator {

	private static final long serialVersionUID = -670554022767086631L;

	private final static List<TerminalType> DivOperatorTypes = Arrays
			.asList(TerminalType.DIV);

	public DivOperator(TerminalType type) {
		super(type);

		if (!DivOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("/");
		setEndLine(Flag.CurrentLine);
	}
}
