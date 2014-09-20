package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class QuestionOperator extends Operator {

	private static final long serialVersionUID = -6975560211162492943L;

	private final static List<TerminalType> QuestionOperatorTypes = Arrays
			.asList(TerminalType.QUESTION_MARK);

	public QuestionOperator(TerminalType type) {
		super(type);

		if (!QuestionOperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print("?");
		setEndLine(Flag.CurrentLine);
	}
}
