package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class OneOrMoreDeclarationSpecifier extends NonTerminal implements
		Comparable<OneOrMoreDeclarationSpecifier> {

	private static final long serialVersionUID = 7531560652744677405L;

	public static OneOrMoreDeclarationSpecifier CreateOneOrMoreDeclarationSpecifier(
			List<StorageClassSpecifier> strgClsSpeList,
			List<TypeSpecifier> typeSpeList, List<TypeQualifier> typeQuaList) {
		if (strgClsSpeList == null && typeSpeList == null
				&& typeQuaList == null)
			throw new NullPointerException();
		OneOrMoreDeclarationSpecifier declarationSpecifiers = null;
		if (strgClsSpeList != null) {
			for (StorageClassSpecifier spe : strgClsSpeList) {
				if (declarationSpecifiers == null) {
					declarationSpecifiers = new OneOrMoreDeclarationSpecifier(
							new DeclarationSpecifier(new StorageClassSpecifier(
									spe)));
				} else {
					declarationSpecifiers = new OneOrMoreDeclarationSpecifier(
							declarationSpecifiers, new DeclarationSpecifier(
									new StorageClassSpecifier(spe)));
				}
			}
		}

		if (typeSpeList != null) {
			for (TypeSpecifier spe : typeSpeList) {
				if (declarationSpecifiers == null) {
					declarationSpecifiers = new OneOrMoreDeclarationSpecifier(
							new DeclarationSpecifier(new TypeSpecifier(spe)));
				} else {
					declarationSpecifiers = new OneOrMoreDeclarationSpecifier(
							declarationSpecifiers, new DeclarationSpecifier(
									new TypeSpecifier(spe)));
				}
			}
		}

		if (typeQuaList != null) {
			for (TypeQualifier qua : typeQuaList) {
				if (declarationSpecifiers == null) {
					declarationSpecifiers = new OneOrMoreDeclarationSpecifier(
							new DeclarationSpecifier(new TypeQualifier(qua)));
				} else {
					declarationSpecifiers = new OneOrMoreDeclarationSpecifier(
							declarationSpecifiers, new DeclarationSpecifier(
									new TypeQualifier(qua)));
				}
			}

		}

		return declarationSpecifiers;
	}

	private List<StorageClassSpecifier> storageClassSpecifierList;
	private List<TypeSpecifier> typeSpecifierList;
	private List<TypeQualifier> typeQualifierList;

	public OneOrMoreDeclarationSpecifier(
			DeclarationSpecifier declarationSpecifier) {
		this(null, declarationSpecifier);
	}

	public OneOrMoreDeclarationSpecifier(
			OneOrMoreDeclarationSpecifier declarationSpecifiers,
			DeclarationSpecifier declarationSpecifier) {
		super(Arrays.asList((Node) declarationSpecifiers,
				(Node) declarationSpecifier));
		if (declarationSpecifier == null)
			throw new NullPointerException();
		storageClassSpecifierList = new ArrayList<StorageClassSpecifier>();
		typeSpecifierList = new ArrayList<TypeSpecifier>();
		typeQualifierList = new ArrayList<TypeQualifier>();

		if (declarationSpecifiers != null) {
			for (StorageClassSpecifier storageClassSpecifier : declarationSpecifiers
					.getStorageClassSpecifierList())
				storageClassSpecifierList.add(storageClassSpecifier);
			for (TypeSpecifier typeSpecifier : declarationSpecifiers
					.getTypeSpecifierList())
				typeSpecifierList.add(typeSpecifier);
			for (TypeQualifier typeQualifier : declarationSpecifiers
					.getTypeQualifierList())
				typeQualifierList.add(typeQualifier);
		}
		if (declarationSpecifier.getStorageClassSpecifier() != null)
			storageClassSpecifierList.add(declarationSpecifier
					.getStorageClassSpecifier());
		else if (declarationSpecifier.getTypeSpecifier() != null)
			typeSpecifierList.add(declarationSpecifier.getTypeSpecifier());
		else
			typeQualifierList.add(declarationSpecifier.getTypeQualifier());
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

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		if (subNodes.size() > 1) {
			System.out.print(" ");
			subNodes.get(1).Print(0);
		}
		
		setEndLine(Flag.CurrentLine);
	}

	@Override
	public int compareTo(OneOrMoreDeclarationSpecifier o) {
		if (o == null)
			return -1;
		for (int index = 0; index < typeSpecifierList.size(); ++index) {
			if (index >= o.typeSpecifierList.size())
				return 1;
			int compRes = typeSpecifierList.get(index).compareTo(
					o.typeSpecifierList.get(index));
			if (compRes != 0)
				return compRes;
		}
		if (typeSpecifierList.size() < o.typeSpecifierList.size())
			return -1;
		return 0;
	}
}
