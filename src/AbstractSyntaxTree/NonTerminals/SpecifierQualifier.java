package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class SpecifierQualifier extends NonTerminal {

	private static final long serialVersionUID = -6717936770717528592L;
	
	private TypeSpecifier typeSpecifier;
	private TypeQualifier typeQualifier;
	
	public SpecifierQualifier(TypeSpecifier typeSpecifier) {
		super(Arrays.asList((Node) typeSpecifier));

		if (typeSpecifier == null)
			throw new NullPointerException();
		this.typeSpecifier = typeSpecifier;
	}

	public SpecifierQualifier(TypeQualifier typeQualifier) {
		super(Arrays.asList((Node) typeQualifier));
		
		if(typeQualifier == null)
			throw new NullPointerException();
		this.typeQualifier = typeQualifier;
	}
	
	public TypeSpecifier getTypeSpecifier() {
		return typeSpecifier;
	}
	
	public TypeQualifier getTypeQualifier() {
		return typeQualifier;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(indent);
		setEndLine(Flag.CurrentLine);
	}
}
