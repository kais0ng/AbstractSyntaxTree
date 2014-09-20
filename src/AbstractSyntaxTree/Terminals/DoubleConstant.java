package AbstractSyntaxTree.Terminals;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class DoubleConstant extends Terminal {

	private static final long serialVersionUID = -5049425958168658566L;

	private String content;

	public DoubleConstant(String content) {
		super(TerminalType.DOUBLE_CONSTANT);
		if (content == null)
			throw new NullPointerException();

		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		System.out.print(content);
		setEndLine(Flag.CurrentLine);
	}
}
