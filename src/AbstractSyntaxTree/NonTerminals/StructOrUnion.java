package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Enums.UserDefinedType;
import AbstractSyntaxTree.Terminals.Keyword;
import Helper.Flag;

public class StructOrUnion extends NonTerminal implements
		Comparable<StructOrUnion> {

	private static final long serialVersionUID = -6649099644123204783L;

	public StructOrUnion(Keyword keyword) {
		super(Arrays.asList((Node) keyword));
		if (keyword == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_STRUCT
				&& keyword.getType() != TerminalType.KEYWORD_UNION)
			throw new IllegalArgumentException();
	}

	public UserDefinedType getUserDefinedType() {
		if (((Keyword) subNodes.get(0)).getType() == TerminalType.KEYWORD_STRUCT)
			return UserDefinedType.STRUCT;
		return UserDefinedType.UNION;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		setEndLine(Flag.CurrentLine);
	}

	@Override
	public int compareTo(StructOrUnion o) {
		if (o == null)
			return -1;
		TerminalType type = ((Keyword) subNodes.get(0)).getType();
		TerminalType oType = ((Keyword) o.subNodes.get(0)).getType();
		if (type.equals(oType))
			return 0;
		if (type == TerminalType.KEYWORD_STRUCT)
			return -1;
		return 1;
	}
}
