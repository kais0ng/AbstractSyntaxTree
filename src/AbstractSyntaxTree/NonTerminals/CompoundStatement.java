package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Brace;
import Helper.Flag;

public class CompoundStatement extends NonTerminal {

	private static final long serialVersionUID = 1303646387590489678L;
	
	private OneOrMoreDeclarationOrStatement declarationOrStatements;  //
	// CompoundStatement is empty
	public CompoundStatement(Brace lBrace, Brace rBrace) {
		super(Arrays.asList((Node)lBrace, null, (Node)rBrace));
	}
	// CompoundStatement is comprised by brace and declarations&statements
	public CompoundStatement(Brace lBrace, OneOrMoreDeclarationOrStatement declarationOrStatements, Brace rBrace) {
		super(Arrays.asList((Node)lBrace, (Node)declarationOrStatements, (Node)rBrace));
		
		if(lBrace == null || rBrace == null)
			throw new IllegalArgumentException();
		if(lBrace.getType() != TerminalType.LBRACE || rBrace.getType() != TerminalType.RBRACE)
			throw new IllegalArgumentException();
		this.declarationOrStatements = declarationOrStatements;
	}
	
	public OneOrMoreDeclarationOrStatement getDeclarationOrStatements() {
		return declarationOrStatements;
	}
	
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		if(subNodes.size() == 2) {
			subNodes.get(0).Println(indent - 1);
			++Flag.CurrentLine;
			subNodes.get(1).Print(indent - 1);
		} else {
			subNodes.get(0).Println(indent - 1);
			++Flag.CurrentLine;
			subNodes.get(1).Println(indent);
			++Flag.CurrentLine;
			subNodes.get(2).Print(indent - 1);
		}
		setEndLine(Flag.CurrentLine);
	}
}
