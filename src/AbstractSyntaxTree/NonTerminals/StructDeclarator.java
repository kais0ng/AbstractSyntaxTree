package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class StructDeclarator extends NonTerminal{
	private static final long serialVersionUID = -1321113721375607541L;
	
	private Declarator declarator;
	private ConstantExpression constantExp;
	
	public StructDeclarator(Declarator declarator) {
		super(Arrays.asList((Node)declarator));
		if(declarator == null)
			throw new NullPointerException();
		this.declarator = declarator;
	}
	public StructDeclarator(Punctuation punctuation, ConstantExpression constantExp){
		super(Arrays.asList((Node)punctuation, (Node)constantExp));
		if(punctuation == null || constantExp == null)
			throw new NullPointerException();
		if(punctuation.getType() != TerminalType.COLON)
			throw new IllegalArgumentException();
		this.constantExp = constantExp;
	}
	public StructDeclarator(Declarator declarator, Punctuation punctuation, ConstantExpression constantExp){
		super(Arrays.asList((Node)declarator, (Node)punctuation, (Node)constantExp));
		if(declarator == null || punctuation == null || constantExp == null)
			throw new NullPointerException();
		if(punctuation.getType() != TerminalType.COLON)
			throw new IllegalArgumentException();
		this.declarator = declarator;
		this.constantExp = constantExp;
	}
	public Declarator getDeclarator() {
		return declarator;
	}
	public ConstantExpression getConstantExp() {
		return constantExp;
	}
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		for(int i =0; i<subNodes.size(); i++){
			if(i == (subNodes.size()-1)){
				subNodes.get(i).Print(0);
				break;
			}
			subNodes.get(i).Print(0);
		    System.out.print(" ");
		}
		setEndLine(Flag.CurrentLine);
	}
	
}
