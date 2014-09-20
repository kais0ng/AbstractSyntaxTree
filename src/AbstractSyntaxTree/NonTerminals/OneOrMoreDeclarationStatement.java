
package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class OneOrMoreDeclarationStatement extends NonTerminal {

	private static final long serialVersionUID = 3959800348438304185L;
	
	private List<DeclarationStatement> statements;

	public OneOrMoreDeclarationStatement(
			DeclarationStatement declarationStatement) {
		this(null, declarationStatement);
	}

	public OneOrMoreDeclarationStatement(
			OneOrMoreDeclarationStatement declarationStatements,
			DeclarationStatement declarationStatement) {
		super(Arrays.asList((Node) declarationStatements,
				(Node) declarationStatement));
		if (declarationStatement == null)
			throw new NullPointerException();
		if (declarationStatements == null)
			statements = Arrays.asList(declarationStatement);
		else {
			statements = new ArrayList<DeclarationStatement>();
			for(DeclarationStatement statement: declarationStatements.statements) {
				statements.add(statement);
			}
			statements.add(declarationStatement);
		}
	}

	public List<DeclarationStatement> getDeclarationStatements() {
		return statements;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		if (subNodes.size() > 1) {
			System.out.println(" ");
			++Flag.CurrentLine;
			subNodes.get(1).Print(indent);
		}
		setEndLine(Flag.CurrentLine);
	}
}
