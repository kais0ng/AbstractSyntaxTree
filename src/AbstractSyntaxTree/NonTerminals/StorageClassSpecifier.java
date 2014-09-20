package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import Helper.Flag;

public class StorageClassSpecifier extends NonTerminal implements
		Comparable<StorageClassSpecifier> {

	private static final long serialVersionUID = 7861030366379592081L;

	private final static List<TerminalType> StorageClassSpecifierTypes = Arrays
			.asList(TerminalType.KEYWORD_AUTO, TerminalType.KEYWORD_EXTERN,
					TerminalType.KEYWORD_STATIC, TerminalType.KEYWORD_REGISTER,
					TerminalType.KEYWORD_TYPEDEF);

	public StorageClassSpecifier(StorageClassSpecifier other) {
		this(new Keyword(((Keyword) other.subNodes.get(0)).getType()));
	}

	public StorageClassSpecifier(Keyword keyword) {
		super(Arrays.asList((Node) keyword));
		if (keyword == null)
			throw new NullPointerException();
		if (!StorageClassSpecifierTypes.contains(keyword.getType()))
			throw new IllegalArgumentException();
	}

	public Keyword getKeyword() {
		return (Keyword) subNodes.get(0);
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		setEndLine(Flag.CurrentLine);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof StorageClassSpecifier))
			return false;
		StorageClassSpecifier specifier = (StorageClassSpecifier) obj;
		return ((Keyword) subNodes.get(0)).equals((Keyword) specifier.subNodes
				.get(0));
	}

	@Override
	public int compareTo(StorageClassSpecifier o) {
		if (o == null)
			return -1;
		Keyword keyword = (Keyword) subNodes.get(0);
		Keyword oKeyword = (Keyword) o.subNodes.get(0);
		int index = StorageClassSpecifierTypes.indexOf(keyword);
		int oIndex = StorageClassSpecifierTypes.indexOf(oKeyword);
		return index - oIndex;
	}
}
