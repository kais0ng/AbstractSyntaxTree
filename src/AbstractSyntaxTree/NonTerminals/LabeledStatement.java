package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Identifier;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class LabeledStatement extends NonTerminal {

	private static final long serialVersionUID = -1485030724721352571L;

	private CaseStatement caseStatement;
	private DefaultStatement defaultStatement;
	private Identifier identifier;
	private Statement statement;

	public LabeledStatement(CaseStatement caseStatement) {
		super(Arrays.asList((Node) caseStatement));

		if (caseStatement == null)
			throw new NullPointerException();
		this.caseStatement = caseStatement;
	}

	public LabeledStatement(DefaultStatement defaultStatement) {
		super(Arrays.asList((Node) defaultStatement));

		if (defaultStatement == null)
			throw new NullPointerException();
		this.defaultStatement = defaultStatement;
	}

	public LabeledStatement(Identifier identifier, Punctuation punctuation,
			Statement statement) {
		super(Arrays.asList((Node) identifier, (Node) punctuation,
				(Node) statement));

		if (identifier == null || punctuation == null || statement == null)
			throw new NullPointerException();
		if (punctuation.getType() != TerminalType.COLON)
			throw new IllegalArgumentException();
		this.identifier = identifier;
		this.statement = statement;
	}

	public CaseStatement getCaseStatement() {
		return caseStatement;
	}

	public DefaultStatement getDefaultStatement() {
		return defaultStatement;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public Statement getStatement() {
		return statement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		if (subNodes.size() == 1) {
			subNodes.get(0).Print(indent);
		} else {
			super.Print(indent);
			subNodes.get(0).Print(0);
			if (subNodes.size() > 1) {
				subNodes.get(1).Println(0);
				++Flag.CurrentLine;
				subNodes.get(2).Print(indent + 1);
			}
		}
		setEndLine(Flag.CurrentLine);
	}
}
