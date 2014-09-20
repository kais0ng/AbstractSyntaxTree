package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;
/*
 * 关于处理变量声明（此声明可能包含对变量的初始化）
 */
public class Declaration extends NonTerminal {

	private static final long serialVersionUID = 8526532993453341739L;

	private List<StorageClassSpecifier> storageClassSpecifierList;
	private List<TypeSpecifier> typeSpecifierList;
	private List<TypeQualifier> typeQualifierList;
	private List<InitDeclarator> initDeclaratorList;

	public Declaration(OneOrMoreDeclarationSpecifier declarationSpecifiers,
			OneOrMoreInitDeclarator initDeclarators) {
		super(Arrays.asList((Node) declarationSpecifiers,
				(Node) initDeclarators));
		if (declarationSpecifiers == null || initDeclarators == null)
			throw new NullPointerException();
		storageClassSpecifierList = declarationSpecifiers
				.getStorageClassSpecifierList();
		typeSpecifierList = declarationSpecifiers.getTypeSpecifierList();
		typeQualifierList = declarationSpecifiers.getTypeQualifierList();
		initDeclaratorList = initDeclarators.getInitDeclaratorList();
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

	public List<InitDeclarator> getInitDeclaratorList() {
		return initDeclaratorList;
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
}
