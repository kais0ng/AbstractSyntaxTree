package AbstractSyntaxTree.Terminals;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class IntegerConstant extends Terminal {

	private static final long serialVersionUID = -457263417109836414L;

	private String content;

	public IntegerConstant(String content) {
		super(TerminalType.INTEGER_CONSTANT);
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
