package AbstractSyntaxTree;

import AbstractSyntaxTree.Enums.TerminalType;

/* Terminal definitions */
public abstract class Terminal extends Node {

	private static final long serialVersionUID = -7083076228248479372L;

	protected TerminalType type;

	public Terminal(TerminalType type) {
		if (type == null)
			throw new NullPointerException();
		this.type = type;
	}

	public TerminalType getType() {
		return type;
	}

	@Override
	public void Print(int indent) {
		super.Print(indent);
		// System.out.print(type.toString());
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null || !(obj instanceof Terminal))
			return false;
		Terminal terminal = (Terminal) obj;
		return type == terminal.type;
	}
}
