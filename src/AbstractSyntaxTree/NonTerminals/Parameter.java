package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class Parameter extends NonTerminal implements Comparable<Parameter> {

	private static final long serialVersionUID = 6615331974994324752L;

	private Declarator declarator;
	private OneOrMoreDeclarationSpecifier declarationSpecifier;
	private List<StorageClassSpecifier> storageClassSpecifierList;
	private List<TypeSpecifier> typeSpecifierList;
	private List<TypeQualifier> typeQualifierList;

	public Parameter(OneOrMoreDeclarationSpecifier declarationSpecifiers,
			Declarator declarator) {
		super(Arrays.asList((Node) declarationSpecifiers, (Node) declarator));
		if (declarationSpecifiers == null || declarator == null)
			throw new NullPointerException();
		this.declarator = declarator;
		this.declarationSpecifier = declarationSpecifiers;

		storageClassSpecifierList = declarationSpecifiers
				.getStorageClassSpecifierList();
		typeSpecifierList = declarationSpecifiers.getTypeSpecifierList();
		typeQualifierList = declarationSpecifiers.getTypeQualifierList();
	}

	public List<StorageClassSpecifier> getStorageClassSpecifierList() {
		return storageClassSpecifierList;
	}

	public List<TypeSpecifier> getTypeSpecifierList() {
		return typeSpecifierList;
	}

	public List<TypeQualifier> getTypeQualifierList() {
		return typeQualifierList;
	}

	public Declarator getDeclarator() {
		return declarator;
	}

	public OneOrMoreDeclarationSpecifier getDeclarationSpecifier() {
		return declarationSpecifier;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		System.out.print(" ");
		subNodes.get(1).Print(0);
		setEndLine(Flag.CurrentLine);
	}

	@Override
	public int compareTo(Parameter o) {
		if (o == null)
			return -1;
		int declarationSpecifierCompRes = ((OneOrMoreDeclarationSpecifier) subNodes
				.get(0)).compareTo((OneOrMoreDeclarationSpecifier) o.subNodes
				.get(0));
		if (declarationSpecifierCompRes != 0)
			return declarationSpecifierCompRes;
		Declarator declarator = (Declarator) subNodes.get(1);
		Declarator oDeclarator = (Declarator) o.subNodes.get(1);
		return declarator.compareToWithoutIdentifier(oDeclarator);
	}
}