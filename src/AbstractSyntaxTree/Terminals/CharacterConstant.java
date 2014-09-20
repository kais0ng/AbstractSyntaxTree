package AbstractSyntaxTree.Terminals;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class CharacterConstant extends Terminal {

	private static final long serialVersionUID = -5961919583469875993L;

	private String content;

	public CharacterConstant(String content) {
		super(TerminalType.CHARACTER_CONSTANT);
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
		System.out.println(content);
		setEndLine(Flag.CurrentLine);
	}
}
