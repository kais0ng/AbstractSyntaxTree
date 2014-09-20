package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class OneOrMoreTypeQualifier extends NonTerminal {

	private static final long serialVersionUID = 827380470060404201L;

	private List<TypeQualifier> typeQualifierList;

	public OneOrMoreTypeQualifier(TypeQualifier typeQualifier) {
		this(null, typeQualifier);
	}

	public OneOrMoreTypeQualifier(
			OneOrMoreTypeQualifier oneOrMoreTypeQualifier,
			TypeQualifier typeQualifier) {
		super(Arrays
				.asList((Node) oneOrMoreTypeQualifier, (Node) typeQualifier));

		if (typeQualifier == null)
			throw new NullPointerException();

		typeQualifierList = new ArrayList<TypeQualifier>();
		if (oneOrMoreTypeQualifier != null)
			typeQualifierList.addAll(oneOrMoreTypeQualifier
					.getTypeQualifierList());
		typeQualifierList.add(typeQualifier);
	}

	public List<TypeQualifier> getTypeQualifierList() {
		return typeQualifierList;
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
