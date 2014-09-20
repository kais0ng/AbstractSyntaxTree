package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Terminals.DoubleConstant;
import AbstractSyntaxTree.Terminals.FloatConstant;
import AbstractSyntaxTree.Terminals.IntegerConstant;
import AbstractSyntaxTree.Terminals.LiteralConstant;
import AbstractSyntaxTree.Terminals.LongConstant;
import Helper.Flag;

public class Constant extends NonTerminal {
	
	private static final long serialVersionUID = 1607004961749280455L;

	public Constant(IntegerConstant integerConstant) {
		super(Arrays.asList((Node)integerConstant));
		
		if(integerConstant == null)
			throw new NullPointerException();
	}
	
	public Constant(LongConstant longConstant) {
		super(Arrays.asList((Node)longConstant));
		
		if(longConstant == null)
			throw new NullPointerException();
	}
	
	public Constant(FloatConstant floatConstant) {
		super(Arrays.asList((Node)floatConstant));
		
		if(floatConstant == null)
			throw new NullPointerException();
	}
	
	public Constant(DoubleConstant doubleConstant) { 
		super(Arrays.asList((Node)doubleConstant));
		
		if(doubleConstant == null)
			throw new NullPointerException();
	}
	
	public Constant(LiteralConstant literalConstant) { 
		super(Arrays.asList((Node)literalConstant));
		
		if(literalConstant == null)
			throw new NullPointerException();
	}

	public Terminal getConstant() {
		return (Terminal)subNodes.get(0);
	}
//	public static void main(String[] args){
//		Constant constant = new Constant(new IntegerConstant("100"));
//		System.out.println(constant.getConstant().getType().toString());
//		
//	}
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
