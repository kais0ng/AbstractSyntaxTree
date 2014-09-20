package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class TypeName extends NonTerminal {

	private static final long serialVersionUID = 4901699322023629436L;

	/* typeName --> oneOrMoreSpecifierQualifier */
	private OneOrMoreSpecifierQualifier specifierQualifiers;
	private Pointer pointer;
	private List<TypeSpecifier> typeSpecifierList;
	private List<TypeQualifier> typeQualifierList;

	public TypeName(OneOrMoreSpecifierQualifier specifierQualifiers) {
		this(specifierQualifiers, null);
	}
	/* typeName -> oneOrMoreSpecifierQualifier Pointer */
	public TypeName(OneOrMoreSpecifierQualifier specifierQualifiers, Pointer pointer){
		super(Arrays.asList((Node) specifierQualifiers, (Node)pointer));
		if (specifierQualifiers == null)
			throw new NullPointerException();
		typeSpecifierList = specifierQualifiers.getTypeSpecifierList();
		typeQualifierList = specifierQualifiers.getTypeQualifierList();
		this.specifierQualifiers = specifierQualifiers;
		this.pointer = pointer;
		
	}
	public OneOrMoreSpecifierQualifier getSpecifierQualifiers() {
		return specifierQualifiers;
	}
	
	public Pointer getPointer() {
		return pointer;
	}
	public List<TypeSpecifier> getTypeSpecifierList() {
		return typeSpecifierList;
	}

	public List<TypeQualifier> getTypeQualifierList() {
		return typeQualifierList;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if(subNodes.size() == 2){
			System.out.print(" ");
			subNodes.get(1).Print(0);
		}	
		setEndLine(Flag.CurrentLine);
	}
}
