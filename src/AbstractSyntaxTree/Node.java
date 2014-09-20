package AbstractSyntaxTree;

import java.io.Serializable;

public abstract class Node implements Serializable {

	private static final long serialVersionUID = -1460952403224615927L;

	private int startLine;
	private int endLine;

	public void Print(int indent) {
		while (indent-- > 0)
			System.out.print('\t');
	}

	public void Println(int indent) {
		Print(indent);
		System.out.println();
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public int getStartLine() {
		return startLine;
	}

	public int getEndLine() {
		return endLine;
	}
}