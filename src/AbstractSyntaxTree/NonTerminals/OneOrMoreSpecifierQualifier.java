package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class OneOrMoreSpecifierQualifier extends NonTerminal {

	private static final long serialVersionUID = 6225666718988212093L;
	
	private List<TypeSpecifier> typeSpecifierList;
	private List<TypeQualifier> typeQualifierList;

	public OneOrMoreSpecifierQualifier(SpecifierQualifier specifierQualifier) {
		this(null, specifierQualifier);
	}

	public OneOrMoreSpecifierQualifier(
			OneOrMoreSpecifierQualifier specifierQualifiers,
			SpecifierQualifier specifierQualifier) {
		super(Arrays.asList((Node) specifierQualifiers,
				(Node) specifierQualifier));

		if (specifierQualifier == null)
			throw new NullPointerException();
		typeSpecifierList = new ArrayList<TypeSpecifier>();
		typeQualifierList = new ArrayList<TypeQualifier>();

		if (specifierQualifiers != null) {
			typeSpecifierList
					.addAll(specifierQualifiers.getTypeSpecifierList());
			typeQualifierList
					.addAll(specifierQualifiers.getTypeQualifierList());
		}
		if (specifierQualifier.getTypeSpecifier() != null)
			typeSpecifierList.add(specifierQualifier.getTypeSpecifier());
		else
			typeQualifierList.add(specifierQualifier.getTypeQualifier());
	}

	public List<TypeSpecifier> getTypeSpecifierList() {
		return typeSpecifierList;
	}

	public List<TypeQualifier> getTypeQualifierList() {
		return typeQualifierList;
	}
	public static OneOrMoreSpecifierQualifier createOneOrMoreSpecifierQualifier(
			List<TypeSpecifier> typeSpeList, List<TypeQualifier> typeQuaList){
		if(typeSpeList == null && typeQuaList == null)
			throw new NullPointerException();
		OneOrMoreSpecifierQualifier specifierQualifiers = null;
		if(typeSpeList != null){
			for(TypeSpecifier specifier: typeSpeList){
				if(specifierQualifiers == null)
					specifierQualifiers = new OneOrMoreSpecifierQualifier(new SpecifierQualifier(new TypeSpecifier(specifier)));
				else {
					specifierQualifiers = new OneOrMoreSpecifierQualifier(specifierQualifiers, new SpecifierQualifier(new TypeSpecifier(specifier)));
				}
			}
		}
		if(typeQuaList != null){
			for(TypeQualifier qualifier: typeQuaList){
				if(specifierQualifiers == null)
					specifierQualifiers = new OneOrMoreSpecifierQualifier(new SpecifierQualifier(new TypeQualifier(qualifier)));
				else {
					specifierQualifiers = new OneOrMoreSpecifierQualifier(specifierQualifiers, new SpecifierQualifier(new TypeQualifier(qualifier)));
				}
			}
		}
		return specifierQualifiers;
	}
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if (subNodes.size() > 1) {
			System.out.print(" ");
			subNodes.get(1).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
