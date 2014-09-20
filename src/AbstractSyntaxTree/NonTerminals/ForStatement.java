package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Parenthesis;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class ForStatement extends NonTerminal {

	private static final long serialVersionUID = 8994913537893937022L;
	
	private Expression initExp;
	private Declaration initDeclaration;
	private Expression conditionExp;
	private Expression stepExp;
	private Statement statement;

	/* for(i = 0; ; ) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Expression initExp, Punctuation firstPunctuation,
			Punctuation secondPunctuation, Parenthesis rParenthesis,
			Statement statement) {
		this(keyword, lParenthesis, initExp, firstPunctuation, null,
				secondPunctuation, null, rParenthesis, statement);
	}

	/* for(i = 0; ; exp) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Expression initExp, Punctuation firstPunctuation,
			Punctuation secondPunctuation, Expression stepForwardExp,
			Parenthesis rParenthesis, Statement statement) {
		this(keyword, lParenthesis, initExp, firstPunctuation, null,
				secondPunctuation, stepForwardExp, rParenthesis, statement);
	}

	/* for(i = 0; exp; ) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Expression initExp, Punctuation firstPunctuation,
			Expression conditionExp, Punctuation secondPunctuation,
			Parenthesis rParenthesis, Statement statement) {
		this(keyword, lParenthesis, initExp, firstPunctuation, conditionExp,
				secondPunctuation, null, rParenthesis, statement);
	}

	/* for(i = 0; exp; exp) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Expression initExp, Punctuation firstPunctuation,
			Expression conditionExp, Punctuation secondPunctuation,
			Expression stepForwardExp, Parenthesis rParenthesis,
			Statement statement) {
		super(Arrays.asList((Node) keyword, (Node) lParenthesis,
				(Node) initExp, (Node) firstPunctuation, (Node) conditionExp,
				(Node) secondPunctuation, (Node) stepForwardExp,
				(Node) rParenthesis, (Node) statement));
		if (keyword == null || lParenthesis == null || initExp == null
				|| firstPunctuation == null || secondPunctuation == null
				|| rParenthesis == null || statement == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_FOR
				|| lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| firstPunctuation.getType() != TerminalType.SEMICOLON
				|| secondPunctuation.getType() != TerminalType.SEMICOLON
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.initExp = initExp;
		this.conditionExp = conditionExp;
		this.stepExp = stepForwardExp;
		this.statement = statement;
	}

	/* for(int i = 0; ; ;) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Declaration initDeclaration, Punctuation firstPunctuation,
			Punctuation secondPunctuation, Parenthesis rParenthesis,
			Statement statement) {
		this(keyword, lParenthesis, initDeclaration, firstPunctuation, null,
				secondPunctuation, null, rParenthesis, statement);
	}

	/* for(int i = 0; ; exp) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Declaration initDeclaration, Punctuation firstPunctuation,
			Punctuation secondPunctuation, Expression stepForwardExp,
			Parenthesis rParenthesis, Statement statement) {
		this(keyword, lParenthesis, initDeclaration, firstPunctuation, null,
				secondPunctuation, stepForwardExp, rParenthesis, statement);
	}

	/* for(int i = 0; exp; ) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Declaration initDeclaration, Punctuation firstPunctuation,
			Expression conditionExp, Punctuation seconPunctuation,
			Parenthesis rParenthesis, Statement statement) {
		this(keyword, lParenthesis, initDeclaration, firstPunctuation,
				conditionExp, seconPunctuation, null, rParenthesis, statement);
	}

	/* for(int i = 0; exp; exp) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Declaration initDeclaration, Punctuation firstPunctuation,
			Expression conditionExp, Punctuation secondPunctuation,
			Expression stepForwardExp, Parenthesis rParenthesis,
			Statement statement) {
		super(Arrays.asList((Node) keyword, (Node) lParenthesis,
				(Node) initDeclaration, (Node) firstPunctuation,
				(Node) conditionExp, (Node) secondPunctuation,
				(Node) stepForwardExp, (Node) rParenthesis, (Node) statement));
		if (keyword == null || lParenthesis == null || initDeclaration == null
				|| firstPunctuation == null || secondPunctuation == null
				|| rParenthesis == null || statement == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_FOR
				|| lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| firstPunctuation.getType() != TerminalType.SEMICOLON
				|| secondPunctuation.getType() != TerminalType.SEMICOLON
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.initDeclaration = initDeclaration;
		this.conditionExp = conditionExp;
		this.stepExp = stepForwardExp;
		this.statement = statement;
	}

	/* for( ; ; ) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Punctuation firstPunctuation, Punctuation secondPunctuation,
			Parenthesis rParenthesis, Statement statement) {
		this(keyword, lParenthesis, firstPunctuation, null, secondPunctuation,
				null, rParenthesis, statement);
	}

	/* for( ; ; exp) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Punctuation firstPunctuation, Punctuation secondPunctuation,
			Expression stepForwardExp, Parenthesis rParenthesis,
			Statement statement) {
		this(keyword, lParenthesis, firstPunctuation, null, secondPunctuation,
				stepForwardExp, rParenthesis, statement);
	}

	/* for( ; exp; ) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Punctuation firstPunctuation, Expression conditionExp,
			Punctuation secondPunctuation, Parenthesis rParenthesis,
			Statement statement) {
		this(keyword, lParenthesis, firstPunctuation, conditionExp,
				secondPunctuation, null, rParenthesis, statement);
	}

	/* for( ; exp; exp; ) statement */
	public ForStatement(Keyword keyword, Parenthesis lParenthesis,
			Punctuation firstPunctuation, Expression conditionExp,
			Punctuation secondPunctuation, Expression stepForwardExp,
			Parenthesis rParenthesis, Statement statement) {
		super(Arrays.asList((Node) keyword, (Node) lParenthesis,
				(Node) firstPunctuation, (Node) conditionExp,
				(Node) secondPunctuation, (Node) stepForwardExp,
				(Node) rParenthesis, (Node) statement));
		if (keyword == null || lParenthesis == null || firstPunctuation == null
				|| secondPunctuation == null || rParenthesis == null
				|| statement == null)
			throw new NullPointerException();
		if (keyword.getType() != TerminalType.KEYWORD_FOR
				|| lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| firstPunctuation.getType() != TerminalType.SEMICOLON
				|| secondPunctuation.getType() != TerminalType.SEMICOLON
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.conditionExp = conditionExp;
		this.stepExp = stepForwardExp;
		this.statement = statement;
	}

	public Expression getInitExp() {
		return initExp;
	}

	public Declaration getInitDeclaration() {
		return initDeclaration;
	}

	public Expression getConditionExp() {
		return conditionExp;
	}

	public Expression getStepExp() {
		return stepExp;
	}

	public Statement getStatement() {
		return statement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		for (int index = 0; index < subNodes.size(); ++index) {
			if (index == subNodes.size() - 1) {
				if (statement.getCompoundStatement() == null) {
					System.out.print(" {");
				}
				System.out.println();
				++Flag.CurrentLine;
				subNodes.get(index).Print(indent + 1);
				if (statement.getCompoundStatement() == null) {
					System.out.print("}");
				}
			} else {
				subNodes.get(index).Print(0);
				if (subNodes.get(index) instanceof Punctuation)
					System.out.print(" ");
			}
		}
		setEndLine(Flag.CurrentLine);
	}
}
