package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import Helper.Flag;

public class TypeSpecifier extends NonTerminal implements
		Comparable<TypeSpecifier> {

	private static final long serialVersionUID = 3549189437430028412L;

	private Keyword keyword;
	private StructOrUnionSpecifier structOrUnionSpecifier;

	private final static List<TerminalType> TypeSpecifierKeywordTypes = Arrays
			.asList(TerminalType.KEYWORD_VOID, TerminalType.KEYWORD_CHAR,
					TerminalType.KEYWORD_SHORT, TerminalType.KEYWORD_INT,
					TerminalType.KEYWORD_LONG, TerminalType.KEYWORD_FLOAT,
					TerminalType.KEYWORD_DOUBLE, TerminalType.KEYWORD_SIGNED,
					TerminalType.KEYWORD_UNSIGNED);

	public TypeSpecifier(TypeSpecifier other) {
		super(new ArrayList<Node>());
		Node node = other.subNodes.get(0);
		subNodes.add(node);
		if (node instanceof Keyword) {
			this.keyword = (Keyword) node;
		} else {
			this.structOrUnionSpecifier = (StructOrUnionSpecifier) node;
		}
	}

	public TypeSpecifier(Keyword keyword) {
		super(Arrays.asList((Node) keyword));

		if (keyword == null)
			throw new NullPointerException();
		if (!TypeSpecifierKeywordTypes.contains(keyword.getType()))
			throw new IllegalArgumentException();
		this.keyword = keyword;
	}

	public TypeSpecifier(StructOrUnionSpecifier specifier) {
		super(Arrays.asList((Node) specifier));

		if (specifier == null)
			throw new NullPointerException();
		this.structOrUnionSpecifier = specifier;
	}

	public Keyword getKeyword() {
		return keyword;
	}

	public StructOrUnionSpecifier getStructOrUnionSpecifier() {
		return structOrUnionSpecifier;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
//		super.Print(indent);
		subNodes.get(0).Print(indent);
		setEndLine(Flag.CurrentLine);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof TypeSpecifier))
			return false;
		TypeSpecifier specifier = (TypeSpecifier) obj;
		if(subNodes.get(0) instanceof Keyword){
			if(!(specifier.subNodes.get(0) instanceof Keyword))
				return false;
			return subNodes.get(0).equals(specifier.subNodes.get(0));
		}
		if(subNodes.get(0) instanceof StructOrUnionSpecifier){
			if(!(specifier.subNodes.get(0) instanceof StructOrUnionSpecifier))
				return false;
			return subNodes.get(0).equals(specifier.subNodes.get(0));
		}
		return ((Keyword) subNodes.get(0)).equals((Keyword) specifier.subNodes
				.get(0));
	}

	@Override
	public int compareTo(TypeSpecifier o) {
		if (o == null)
			return -1;
		if (subNodes.get(0) instanceof Keyword) {
			if (!(o.subNodes.get(0) instanceof Keyword))
				return -1;
			return TypeSpecifierKeywordTypes.indexOf(o.subNodes.get(0))
					- TypeSpecifierKeywordTypes.indexOf(o.subNodes.get(0));
		} else if (o.subNodes.get(0) instanceof Keyword) {
			return 1;
		} else {
			return ((StructOrUnionSpecifier) subNodes.get(0))
					.compareTo((StructOrUnionSpecifier) subNodes.get(0));
		}
	}
}
