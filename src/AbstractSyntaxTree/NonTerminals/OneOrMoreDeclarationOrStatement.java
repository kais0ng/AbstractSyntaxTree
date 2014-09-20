package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class OneOrMoreDeclarationOrStatement extends NonTerminal {

	private static final long serialVersionUID = -708359474194716535L;

	private List<DeclarationOrStatement> declarationOrStatementList;

	public OneOrMoreDeclarationOrStatement(
			DeclarationOrStatement declarationOrtatement) {
		this(null, declarationOrtatement);
	}

	public OneOrMoreDeclarationOrStatement(
			OneOrMoreDeclarationOrStatement oneOrMoreDeclarationOrStatement,
			DeclarationOrStatement declarationOrStatement) {
		super(Arrays.asList((Node) oneOrMoreDeclarationOrStatement,
				(Node) declarationOrStatement));

		if (declarationOrStatement == null)
			throw new NullPointerException();
		declarationOrStatementList = new ArrayList<DeclarationOrStatement>();
		if (oneOrMoreDeclarationOrStatement != null)
			declarationOrStatementList
					.addAll(oneOrMoreDeclarationOrStatement.declarationOrStatementList);
		declarationOrStatementList.add(declarationOrStatement);
	}

	// public OneOrMoreDeclarationOrStatement(
	// OneOrMoreDeclarationOrStatement oneOrMoreDeclarationOrStatement,
	// Statement statement) {
	// super(Arrays.asList((Node) oneOrMoreDeclarationOrStatement,
	// (Node) statement));
	//
	// if (statement == null)
	// throw new NullPointerException();
	//
	// }

	public List<DeclarationOrStatement> getDeclarationOrStatementList() {
		return declarationOrStatementList;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		if (subNodes.size() > 1) {
			System.out.println();
			++Flag.CurrentLine;
			subNodes.get(1).Print(indent);
		}
		setEndLine(Flag.CurrentLine);
	}
}
