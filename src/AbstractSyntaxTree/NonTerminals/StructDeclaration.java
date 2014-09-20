package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class StructDeclaration extends NonTerminal{
	
	private static final long serialVersionUID = -5531816282802786706L;
	
	private OneOrMoreSpecifierQualifier specifierQualifiers;
	private OneOrMoreStructDeclarator structDeclarators;
	
	public StructDeclaration(OneOrMoreSpecifierQualifier specifierQualifiers, OneOrMoreStructDeclarator structDeclarators, Punctuation punctuation) {
		super(Arrays.asList((Node)specifierQualifiers, (Node)structDeclarators, (Node)punctuation));
		if(specifierQualifiers==null || structDeclarators==null || punctuation==null)
			throw new NullPointerException();
		if(!punctuation.getType().equals(TerminalType.SEMICOLON))
			throw new IllegalArgumentException();
		this.specifierQualifiers = specifierQualifiers;
		this.structDeclarators = structDeclarators;
	}

	public OneOrMoreSpecifierQualifier getSpecifierQualifiers() {
		return specifierQualifiers;
	}

	public OneOrMoreStructDeclarator getStructDeclarators() {
		return structDeclarators;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		System.out.print(" ");
		subNodes.get(1).Print(0);
		subNodes.get(2).Print(0);
		setEndLine(Flag.CurrentLine);
	}
	
}
