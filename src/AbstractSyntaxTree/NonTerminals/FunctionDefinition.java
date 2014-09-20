package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class FunctionDefinition extends NonTerminal {

	private static final long serialVersionUID = 1171105905545789736L;

	private OneOrMoreDeclarationSpecifier declarationSpecifiers; // function return type
	private Declarator declarator;//function name + parameters' list
	private CompoundStatement compoundStatement;// function body

	public FunctionDefinition(
			OneOrMoreDeclarationSpecifier declarationSpecifiers,
			Declarator declarator, CompoundStatement compoundStatement) {
		super(Arrays.asList((Node) declarationSpecifiers, (Node) declarator,
				(Node) compoundStatement));

		if (declarationSpecifiers == null || declarator == null
				|| compoundStatement == null)
			throw new NullPointerException();
		this.declarationSpecifiers = declarationSpecifiers;
		this.declarator = declarator;
		this.compoundStatement = compoundStatement;
	}

	public List<StorageClassSpecifier> getStorageClassSpecifierList() {
		return declarationSpecifiers.getStorageClassSpecifierList();
	}

	public List<TypeSpecifier> getTypeSpecifierList() {
		return declarationSpecifiers.getTypeSpecifierList();
	}

	public List<TypeQualifier> getTypeQualifierList() {
		return declarationSpecifiers.getTypeQualifierList();
	}

	public Declarator getDeclarator() {
		return declarator;
	}

	public CompoundStatement getCompoundStatement() {
		return compoundStatement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		System.out.print(" ");
		subNodes.get(1).Print(0);
		System.out.println("");
		++Flag.CurrentLine;
		subNodes.get(2).Print(indent + 1);
		setEndLine(Flag.CurrentLine);
	}
}