package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class DomainOperator extends Operator {

	private static final long serialVersionUID = 5479193858868132255L;

	private final static List<TerminalType> DomainOperatorTypes = Arrays
			.asList(TerminalType.DOMAIN);

	public DomainOperator(TerminalType type) {
		super(type);

		if (!DomainOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("->");
		setEndLine(Flag.CurrentLine);
	}
}
