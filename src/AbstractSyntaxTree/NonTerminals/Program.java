package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class Program extends NonTerminal {

	private static final long serialVersionUID = 7695443993256081062L;

	private Program headProgram;
	private FunctionDefinition funcDefinition;
	private DeclarationStatement declarationStatement;

	public Program() {
		super(new ArrayList<Node>());
	}

	public Program(Program program, FunctionDefinition functionDefinition) {
		super(Arrays.asList((Node) program, (Node) functionDefinition));
		if (program == null || functionDefinition == null)
			throw new IllegalArgumentException();
		headProgram = program;
		funcDefinition = functionDefinition;
	}

	public Program(Program program, DeclarationStatement declarationStatement) {
		super(Arrays.asList((Node) program, declarationStatement));
		if (program == null || declarationStatement == null)
			throw new NullPointerException();
		headProgram = program;
		this.declarationStatement = declarationStatement;
	}

	public Program getHeadProgram() {
		return headProgram;
	}

	public FunctionDefinition getFunctionDefinition() {
		return funcDefinition;
	}

	public DeclarationStatement getDeclarationStatement() {
		return declarationStatement;
	}


	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		if (subNodes.size() == 0) {
			setEndLine(Flag.CurrentLine);
			return;
		}
		subNodes.get(0).Println(indent);
		++Flag.CurrentLine;
		subNodes.get(1).Println(indent);
		++Flag.CurrentLine;
		setEndLine(Flag.CurrentLine);
	}
}
