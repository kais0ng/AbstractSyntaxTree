package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.AssignOperator;
import Helper.Flag;

public class InitDeclarator extends NonTerminal {

	private static final long serialVersionUID = -2577272796497710421L;
	//仅含有变量名（变量标识符）
	public InitDeclarator(Declarator declarator) {
		this(declarator, null, null);
	}
	//含有变量名和对变量的初始化
	public InitDeclarator(Declarator declarator, AssignOperator assignOp,
			Initializer initializer) {
		super(Arrays.asList((Node) declarator, (Node) assignOp,
				(Node) initializer));

		if (declarator == null)
			throw new NullPointerException();
		if (assignOp == null && initializer != null)
			throw new IllegalArgumentException();
		if (assignOp != null && initializer == null)
			throw new IllegalArgumentException();
		if (assignOp != null && assignOp.getType() != TerminalType.ASSIGN)
			throw new IllegalArgumentException();
	}

	public Declarator getDeclarator() {
		return (Declarator) subNodes.get(0);
	}

	public AssignOperator getAssignOperator() {
		if (subNodes.size() > 1)
			return (AssignOperator) subNodes.get(1);
		return null;
	}

	public Initializer getInitializer() {
		if (subNodes.size() > 1)
			return (Initializer) subNodes.get(2);
		return null;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if (subNodes.size() > 1) {
			for (int index = 1; index < subNodes.size(); ++index) {
				System.out.print(" ");
				subNodes.get(index).Print(0);
			}
		}
		setEndLine(Flag.CurrentLine);
	}
}
