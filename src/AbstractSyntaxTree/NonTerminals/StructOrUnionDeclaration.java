package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Brace;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class StructOrUnionDeclaration extends NonTerminal {

	private static final long serialVersionUID = -6565131250761210030L;

	private StructOrUnionSpecifier structOrUnionSpecifier;
	private Brace lBrace;
	private OneOrMoreDeclarationStatement declarationStatements;
	private Brace rBrace;
	private OneOrMoreInitDeclarator initDeclarators;
	private Punctuation punctuation;

	public StructOrUnionDeclaration(
			StructOrUnionSpecifier structOrUnionSpecifier, Brace lBrace,
			Brace rBrace, Punctuation punctuation) {
		this(structOrUnionSpecifier, lBrace, null, rBrace, punctuation);
	}

	public StructOrUnionDeclaration(
			StructOrUnionSpecifier structOrUnionSpecifier, Brace lBrace,
			OneOrMoreDeclarationStatement declarationStatements, Brace rBrace,
			Punctuation punctuation) {
		this(structOrUnionSpecifier, lBrace, declarationStatements, rBrace,
				null, punctuation);
	}

	public StructOrUnionDeclaration(
			StructOrUnionSpecifier structOrUnionSpecifier, Brace lBrace,
			Brace rBrace, OneOrMoreInitDeclarator initDeclarators,
			Punctuation punctuation) {
		this(structOrUnionSpecifier, lBrace, null, rBrace, initDeclarators,
				punctuation);
	}

	public StructOrUnionDeclaration(
			StructOrUnionSpecifier structOrUnionSpecifier, Brace lBrace,
			OneOrMoreDeclarationStatement declarationStatements, Brace rBrace,
			OneOrMoreInitDeclarator initDeclarators, Punctuation punctuation) {
		super(Arrays.asList((Node) structOrUnionSpecifier, (Node) lBrace,
				(Node) declarationStatements, (Node) rBrace,
				(Node) initDeclarators, (Node) punctuation));

		if (structOrUnionSpecifier == null || lBrace == null || rBrace == null
				|| punctuation == null)
			throw new NullPointerException();
		if (lBrace.getType() != TerminalType.LBRACE
				|| rBrace.getType() != TerminalType.RBRACE
				|| punctuation.getType() != TerminalType.SEMICOLON)
			throw new IllegalArgumentException();

		this.structOrUnionSpecifier = structOrUnionSpecifier;
		this.lBrace = lBrace;
		this.declarationStatements = declarationStatements;
		this.rBrace = rBrace;
		this.initDeclarators = initDeclarators;
		this.punctuation = punctuation;
	}

	public StructOrUnionSpecifier getStructOrUnionSpecifier() {
		return structOrUnionSpecifier;
	}
	
	public List<DeclarationStatement> getDeclarationStatement() {
		return declarationStatements.getDeclarationStatements();
	}
	public OneOrMoreInitDeclarator getOneOrMoreInitDeclarator(){
		return initDeclarators;
	}
	public List<InitDeclarator> getInitDeclarator(){
		return initDeclarators.getInitDeclaratorList();
	}
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		structOrUnionSpecifier.Println(indent);
		++Flag.CurrentLine;
		lBrace.Println(indent);
		++Flag.CurrentLine;
		if (declarationStatements != null) {
			declarationStatements.Println(indent + 1);
			++Flag.CurrentLine;
		}
		rBrace.Print(indent);
		if (initDeclarators != null)
			initDeclarators.Print(0);
		punctuation.Print(indent);
		setEndLine(Flag.CurrentLine);
	}


}
