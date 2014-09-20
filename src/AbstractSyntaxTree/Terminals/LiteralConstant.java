package AbstractSyntaxTree.Terminals;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class LiteralConstant extends Terminal {

	private static final long serialVersionUID = -8760941134549033231L;

	private String content;

	public LiteralConstant(String content) {
		super(TerminalType.LITERAL_CONSTANT);
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
