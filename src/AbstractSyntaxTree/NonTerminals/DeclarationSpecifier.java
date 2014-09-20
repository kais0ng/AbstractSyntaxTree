package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;
/*
 * 定义了变量类型的组成
 */
public class DeclarationSpecifier extends NonTerminal implements
		Comparable<DeclarationSpecifier> {

	private static final long serialVersionUID = -1890137180060553076L;

	private StorageClassSpecifier storageClassSpecifier;
	private TypeSpecifier typeSpecifier;
	private TypeQualifier typeQualifier;

	public DeclarationSpecifier(StorageClassSpecifier storageClassSpecifier) {
		super(Arrays.asList((Node) storageClassSpecifier));
		if (storageClassSpecifier == null)
			throw new NullPointerException();
		this.storageClassSpecifier = storageClassSpecifier;
	}

	public DeclarationSpecifier(TypeSpecifier typeSpecifier) {
		super(Arrays.asList((Node) typeSpecifier));
		if (typeSpecifier == null)
			throw new NullPointerException();
		this.typeSpecifier = typeSpecifier;
	}

	public DeclarationSpecifier(TypeQualifier typeQualifier) {
		super(Arrays.asList((Node) typeQualifier));
		if (typeQualifier == null)
			throw new NullPointerException();
		this.typeQualifier = typeQualifier;
	}

	public StorageClassSpecifier getStorageClassSpecifier() {
		return storageClassSpecifier;
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
//		super.Print(indent);
		subNodes.get(0).Print(indent);
		setEndLine(Flag.CurrentLine);
	}

	@Override
	public int compareTo(DeclarationSpecifier o) {
		if (o == null)
			return -1;
		if (subNodes.get(0) instanceof StorageClassSpecifier) {
			if (!(o.subNodes.get(0) instanceof StorageClassSpecifier))
				return -1;
			return ((StorageClassSpecifier) subNodes.get(0))
					.compareTo((StorageClassSpecifier) o.subNodes.get(0));
		} else if (o.subNodes.get(0) instanceof StorageClassSpecifier) {
			return 1;
		} else if (subNodes.get(0) instanceof TypeSpecifier) {
			if (!(o.subNodes.get(0) instanceof TypeSpecifier))
				return -1;
			return ((TypeSpecifier) subNodes.get(0))
					.compareTo((TypeSpecifier) subNodes.get(0));
		} else if (o.subNodes.get(0) instanceof TypeSpecifier) {
			return 1;
		} else {
			return ((TypeQualifier) subNodes.get(0))
					.compareTo((TypeQualifier) o.subNodes.get(0));
		}
	}
}
