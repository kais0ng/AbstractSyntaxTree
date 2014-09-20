package AbstractSyntaxTree.Terminals;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class LongConstant extends Terminal {

	private static final long serialVersionUID = 8352310685063923229L;

	private String content;

	public LongConstant(String content) {
		super(TerminalType.LONG_CONSTANT);
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
