package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;
/*
 * 程序的每一行可能是声明，也可能是语句
 */
public class DeclarationOrStatement extends NonTerminal {

	private static final long serialVersionUID = 1797879408956945357L;
	
	private DeclarationStatement declarationStatement;
	private Statement statement;
	
	public DeclarationOrStatement(DeclarationStatement declarationStatement) {
		super(Arrays.asList((Node) declarationStatement));

		if (declarationStatement == null)
			throw new NullPointerException();
		this.declarationStatement = declarationStatement;
	}

	public DeclarationOrStatement(Statement statement) {
		super(Arrays.asList((Node) statement));

		if (statement == null)
			throw new NullPointerException();
		this.statement = statement;
	}
	
	public DeclarationStatement getDeclarationStatement() {
		return declarationStatement;
	}
	
	public Statement getStatement() {
		return statement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		setEndLine(Flag.CurrentLine);
	}
}
