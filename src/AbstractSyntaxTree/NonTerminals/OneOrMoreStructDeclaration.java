package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class OneOrMoreStructDeclaration extends NonTerminal{

	private static final long serialVersionUID = 294368380344915635L;
	
	private StructDeclaration structDeclaration;
	private OneOrMoreStructDeclaration structDeclarations;
	private List<StructDeclaration> structDeclarationsList;
	
	public OneOrMoreStructDeclaration(StructDeclaration structDeclaration){
		this(null, structDeclaration);
	}
	public OneOrMoreStructDeclaration(OneOrMoreStructDeclaration structDeclarations, StructDeclaration structDeclaration) {
		super(Arrays.asList((Node)structDeclarations, (Node)structDeclaration));
		if(structDeclaration == null)
			throw new NullPointerException();
		structDeclarationsList = new ArrayList<StructDeclaration>();
		if(structDeclarations != null)
			structDeclarationsList.addAll(structDeclarations.getStructDeclarationsList());
		structDeclarationsList.add(structDeclaration);
		this.structDeclarations = structDeclarations;
		this.structDeclaration = structDeclaration;
	}

	public StructDeclaration getStructDeclaration() {
		return structDeclaration;
	}

	public OneOrMoreStructDeclaration getStructDeclarations() {
		return structDeclarations;
	}

	public List<StructDeclaration> getStructDeclarationsList() {
		return structDeclarationsList;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		if(subNodes.size() > 1){
			System.out.println();
			++Flag.CurrentLine;
			subNodes.get(1).Print(indent);
		}
		setEndLine(Flag.CurrentLine);
	}
	
}
