package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import Helper.Flag;

public class TypeQualifier extends NonTerminal implements
		Comparable<TypeQualifier> {

	private static final long serialVersionUID = -4149229307537779514L;
	private Keyword keyword;
	private final static List<TerminalType> TypeQualifierTypes = Arrays.asList(
			TerminalType.KEYWORD_CONST, TerminalType.KEYWORD_VOLATILE);

	public TypeQualifier(TypeQualifier other) {
		this((Keyword) other.subNodes.get(0));
	}

	public TypeQualifier(Keyword keyword) {
		super(Arrays.asList((Node) keyword));
		if (keyword == null)
			throw new NullPointerException();
		if (!TypeQualifierTypes.contains(keyword.getType()))
			throw new IllegalArgumentException();
		this.keyword = keyword;
		
	}
	public Keyword getKeyword(){
		
		return keyword;
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
		if (obj == null || !(obj instanceof TypeQualifier))
			return false;
		TypeQualifier specifier = (TypeQualifier) obj;
		return ((Keyword) subNodes.get(0)).equals((Keyword) specifier.subNodes
				.get(0));
	}

	@Override
	public int compareTo(TypeQualifier o) {
		if (o == null)
			return -1;
		int index = TypeQualifierTypes.indexOf(((Keyword) subNodes.get(0))
				.getType());
		int oIndex = TypeQualifierTypes.indexOf(((Keyword) o.subNodes.get(0))
				.getType());
		return index - oIndex;
	}
}
