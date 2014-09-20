package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class OneOrMoreStructDeclarator extends NonTerminal{
	
	private static final long serialVersionUID = 780155967264285700L;
	
	private StructDeclarator structDeclarator;
	private OneOrMoreStructDeclarator structDeclarators;
	private List<StructDeclarator> structDeclaratorList;

	public OneOrMoreStructDeclarator(StructDeclarator structDeclarator) {
		this(null, null, structDeclarator);
	}
	public OneOrMoreStructDeclarator(OneOrMoreStructDeclarator structDeclarators, 
			Punctuation punctuation, StructDeclarator structDeclarator) {
		super(Arrays.asList((Node)structDeclarators, (Node)punctuation, (Node)structDeclarator));
		if(structDeclarator == null)
			throw new NullPointerException();
		if(structDeclarators == null && punctuation != null)
			throw new IllegalArgumentException();
		if(structDeclarators != null && punctuation == null)
			throw new IllegalArgumentException();
		if(punctuation != null && punctuation.getType() != TerminalType.COMMA)
			throw new IllegalArgumentException();
		if(structDeclarators == null)
			structDeclaratorList = Arrays.asList(structDeclarator);
		else {
			structDeclaratorList = new ArrayList<StructDeclarator>();
			structDeclaratorList.addAll(structDeclarators.getStructDeclaratorList());
			structDeclaratorList.add(structDeclarator);
		}
	}
	public StructDeclarator getStructDeclarator() {
		return structDeclarator;
	}
	public OneOrMoreStructDeclarator getStructDeclarators() {
		return structDeclarators;
	}
	public List<StructDeclarator> getStructDeclaratorList() {
		return structDeclaratorList;
	}
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if(subNodes.size() > 1){
			subNodes.get(1).Print(0);
			System.out.println(" ");
			subNodes.get(2).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
