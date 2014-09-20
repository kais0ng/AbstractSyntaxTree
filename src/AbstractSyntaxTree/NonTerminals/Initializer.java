package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Brace;
import Helper.Flag;

public class Initializer extends NonTerminal {

	private static final long serialVersionUID = -3500352384650519367L;
	
	private AssignmentExpression assignmentExp;
	private List<Initializer> initializerList;
	private OneOrMoreInitializer initializers;

	public Initializer(AssignmentExpression assignmentExp) {
		super(Arrays.asList((Node) assignmentExp));

		if (assignmentExp == null)
			throw new NullPointerException();
		this.assignmentExp = assignmentExp;
	}

	public Initializer(Brace lBrace, OneOrMoreInitializer initializers,
			Brace rBrace) {
		super(Arrays.asList((Node) lBrace, (Node) initializers, (Node) rBrace));

		if (lBrace == null || initializers == null || rBrace == null)
			throw new NullPointerException();
		if (lBrace.getType() != TerminalType.LBRACE
				|| rBrace.getType() != TerminalType.RBRACE)
			throw new IllegalArgumentException();
		initializerList = initializers.getInitializerList();
		this.initializers = initializers;
	}

	public AssignmentExpression getAssignmentExp() {
		return assignmentExp;
	}

	public List<Initializer> getInitializerList() {
		return initializerList;
	}
	
	public OneOrMoreInitializer getInitializers() {
		return initializers;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		for (int index = 0; index < subNodes.size(); ++index)
			subNodes.get(index).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
