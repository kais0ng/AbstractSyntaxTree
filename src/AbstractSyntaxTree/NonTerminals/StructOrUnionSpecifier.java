package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Brace;
import AbstractSyntaxTree.Terminals.Identifier;
import Helper.Flag;

public class StructOrUnionSpecifier extends NonTerminal{

	private static final long serialVersionUID = 8439111544410606052L;
	
	private StructOrUnion structOrUnion;
	private Identifier identifier;
	private Brace lBrace;
	private OneOrMoreStructDeclaration structDeclarations;
	private Brace rBrace;
	
	public StructOrUnionSpecifier(Identifier identifier){
		this(null, identifier);
	}
	public StructOrUnionSpecifier(StructOrUnion structOrUnion,
			Identifier identifier) {
		this(structOrUnion, identifier, null, null, null);
	}
	public StructOrUnionSpecifier(StructOrUnion structOrUnion,
			Brace lBrace, OneOrMoreStructDeclaration structDeclarations, Brace rBrace) {
		this(structOrUnion, null, lBrace, structDeclarations, rBrace);
	}
	public StructOrUnionSpecifier(StructOrUnion structOrUnion, Identifier identifier, Brace lBrace, 
			OneOrMoreStructDeclaration structDeclarations, Brace rBrace){
		super(Arrays.asList(structOrUnion, identifier, lBrace, structDeclarations, rBrace));
		if(structDeclarations != null && (lBrace == null ||rBrace == null))
			throw new IllegalArgumentException();
		if(structDeclarations != null && (lBrace.getType()!=TerminalType.LBRACE || rBrace.getType()!=TerminalType.RBRACE))
			throw new IllegalArgumentException();
		this.structOrUnion = structOrUnion;
		this.identifier = identifier;
		this.lBrace = lBrace;
		this.structDeclarations = structDeclarations;
		this.rBrace = rBrace;
	}
	public StructOrUnion getStructOrUnion() {
		return structOrUnion;
	}
	public Identifier getIdentifier() {
		return identifier;
	}
	public OneOrMoreStructDeclaration getStructDeclarations() {
		return structDeclarations;
	}
	public Brace getlBrace() {
		return lBrace;
	}
	public Brace getrBrace() {
		return rBrace;
	}
	@Override
	public void Print(int indent) {
		int numOfsubNodes = subNodes.size();
		setStartLine(Flag.CurrentLine);
		if(numOfsubNodes == 1){
			subNodes.get(0).Print(indent);
		}
		if(numOfsubNodes == 2){
			subNodes.get(0).Print(indent);
			System.out.print(" ");
			subNodes.get(1).Print(0);
		}
		if(numOfsubNodes == 4){
			subNodes.get(0).Println(indent);
			++Flag.CurrentLine;
			lBrace.Println(indent);
			++Flag.CurrentLine;
			subNodes.get(2).Print(indent+1);
			System.out.println();
			++Flag.CurrentLine;
			subNodes.get(3).Print(indent);			
		}
		if(numOfsubNodes == 5){
			subNodes.get(0).Print(indent);
			System.out.println(" ");
			subNodes.get(1).Print(0);
			System.out.println();
			++Flag.CurrentLine;
			subNodes.get(2).Print(indent);
			System.out.println();
			++Flag.CurrentLine;
			subNodes.get(3).Print(indent+1);
			System.out.println();
			++Flag.CurrentLine;
			subNodes.get(4).Print(indent);
		}
		setEndLine(Flag.CurrentLine);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime
				* result
				+ ((structDeclarations == null) ? 0 : structDeclarations
						.hashCode());
		result = prime * result
				+ ((structOrUnion == null) ? 0 : structOrUnion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof StructOrUnionSpecifier))
			return false;
		StructOrUnionSpecifier specifier = (StructOrUnionSpecifier) obj;
		if(subNodes.size() == 1)
			return identifier.equals(specifier.getIdentifier());
		else if(subNodes.size() == 2 || subNodes.size() == 5){
			return subNodes.get(1).equals(specifier.subNodes.get(1));
		}else {
			return subNodes.get(2).equals(specifier.subNodes.get(2));
		}
	}
	public int compareTo(StructOrUnionSpecifier o) {
		if (o == null)
			return -1;
		int structOrUnionCompRes = ((StructOrUnion) subNodes.get(0))
				.compareTo((StructOrUnion) o.subNodes.get(0));
		if (structOrUnionCompRes != 0)
			return structOrUnionCompRes;
		return ((Identifier) subNodes.get(1)).compareTo((Identifier) o.subNodes
				.get(1));
	}
}
