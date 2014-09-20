package AbstractSyntaxTree.Terminals;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class Identifier extends Terminal implements Comparable<Identifier> {

	private static final long serialVersionUID = 8143063324222333327L;

	private String content;

	public Identifier(String content) {
		super(TerminalType.IDENTIFIER);
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
	@Override
	public boolean equals(Object obj){
		if(obj == null ||!(obj instanceof Identifier))
			return false;
		Identifier identifier = (Identifier) obj;
		return content.equals(identifier.content);
			
	}
	@Override
	public int compareTo(Identifier o) {
		if (o == null)
			return -1;
		return content.compareTo(o.content);
	}
}
