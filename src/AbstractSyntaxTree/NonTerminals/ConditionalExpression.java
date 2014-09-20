package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import AbstractSyntaxTree.Terminals.QuestionOperator;
import Helper.Flag;

public class ConditionalExpression extends NonTerminal {

	private static final long serialVersionUID = -3098327801652713536L;
	
	// ConditionalExp --> orExp ? exp: conditionalExp
	// ConditionalExp --> orExp
	private OrExpression orExp;
	private QuestionOperator questionOp;
	private Expression exp;
	private Punctuation punctuation;
	private ConditionalExpression conditionalExp;
	
	public ConditionalExpression(OrExpression orExp) {
		this(orExp, null, null, null, null);
	}

	public ConditionalExpression(OrExpression orExp,
			QuestionOperator questionOp, Expression exp,
			Punctuation punctuation, ConditionalExpression conditionalExp) {
		super(Arrays.asList((Node) orExp, (Node) questionOp, (Node) exp,
				(Node) punctuation, (Node) conditionalExp));

		if (orExp == null)
			throw new NullPointerException();

		int numOfNulls = 0;
		if (questionOp == null)
			++numOfNulls;
		if (exp == null)
			++numOfNulls;
		if (punctuation == null)
			++numOfNulls;
		if (conditionalExp == null)
			++numOfNulls;

		if (numOfNulls != 0 && numOfNulls != 4)
			throw new IllegalArgumentException();
		if (punctuation != null && punctuation.getType() != TerminalType.COLON)
			throw new IllegalArgumentException();
		this.orExp = orExp;
		this.questionOp = questionOp;
		this.exp = exp;
		this.punctuation = punctuation;
		this.conditionalExp = conditionalExp;
	}

	public OrExpression getOrExp() {
		return orExp;
	}
	
	public QuestionOperator getQuestionOp() {
		return questionOp;
	}
	
	public Expression getExp() {
		return exp;
	}
	
	public Punctuation getPunctuation() {
		return punctuation;
	}
	
	public ConditionalExpression getConditionalExp() {
		return conditionalExp;
	}
	
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (subNodes.size() == 1) {
			subNodes.get(0).Print(0);
		} else {
			subNodes.get(0).Print(0);
			subNodes.get(1).Print(0);
			System.out.print(" ");
			subNodes.get(2).Print(0);
			subNodes.get(3).Print(0);
			System.out.print(" ");
			subNodes.get(4).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
