package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class SelectionStatement extends NonTerminal {

	private static final long serialVersionUID = -6646537701515926553L;

	private IfStatement ifStatement;
	private SwitchStatement switchStatement;

	public SelectionStatement(IfStatement ifStatement) {
		super(Arrays.asList((Node) ifStatement));

		if (ifStatement == null)
			throw new NullPointerException();
		this.ifStatement = ifStatement;
	}

	public SelectionStatement(SwitchStatement switchStatement) {
		super(Arrays.asList((Node) switchStatement));

		if (switchStatement == null)
			throw new NullPointerException();
		this.switchStatement = switchStatement;
	}

	public IfStatement getIfStatement() {
		return ifStatement;
	}

	public SwitchStatement getSwitchStatement() {
		return switchStatement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		setEndLine(Flag.CurrentLine);
	}
}
