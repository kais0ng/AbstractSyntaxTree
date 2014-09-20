package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Parenthesis;
import Helper.Flag;

public class CastExpression extends NonTerminal {
	
	private static final long serialVersionUID = -761152785828347824L;
	
	/* CastExp --> UnaryExp
	 * 			 | (TypeName)CastExp */
	private UnaryExpression unaryExp;
	private TypeName typeName;
	private CastExpression castExp;
	
	
	public CastExpression(UnaryExpression unaryExp) {
		super(Arrays.asList((Node)unaryExp));
		
		if(unaryExp == null)
			throw new NullPointerException();
		this.unaryExp = unaryExp;
	}
	
	public CastExpression(Parenthesis lParenthesis, TypeName typeName, Parenthesis rParenthesis, CastExpression castExp) {
		super(Arrays.asList((Node)lParenthesis, (Node)typeName, (Node)rParenthesis, (Node)castExp));
		
		if(lParenthesis == null || typeName == null || rParenthesis == null || castExp == null)
			throw new NullPointerException();
		if(lParenthesis.getType() != TerminalType.LPARENTHESIS || rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.typeName = typeName;
		this.castExp = castExp;
	}
	
	public UnaryExpression getUnaryExp() {
		return unaryExp;
	}
	
	public TypeName getTypeName() {
		return typeName;
	}
	
	public CastExpression getCastExp() {
		return castExp;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		for(int index = 0; index < subNodes.size(); ++index)
			subNodes.get(index).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
