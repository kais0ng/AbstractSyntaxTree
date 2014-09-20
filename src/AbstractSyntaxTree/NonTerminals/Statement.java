package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;

public class Statement extends NonTerminal {

	private static final long serialVersionUID = 768207680503034478L;

	private ExpressionStatement expressionStatement;
	private CompoundStatement compoundStatement;
	private LabeledStatement labeledStatement;
	private SelectionStatement selectionStatement;
	private IterationStatement iterationStatement;
	private JumpStatement jumpStatement;

	public Statement(ExpressionStatement expressionStatement) {
		super(Arrays.asList((Node) expressionStatement));

		if (expressionStatement == null)
			throw new NullPointerException();
		this.expressionStatement = expressionStatement;
	}

	public Statement(LabeledStatement labeledStatement) {
		super(Arrays.asList((Node) labeledStatement));

		if (labeledStatement == null)
			throw new NullPointerException();
		this.labeledStatement = labeledStatement;
	}

	public Statement(SelectionStatement selectionStatement) {
		super(Arrays.asList((Node) selectionStatement));

		if (selectionStatement == null)
			throw new NullPointerException();
		this.selectionStatement = selectionStatement;
	}

	public Statement(IterationStatement iterationStatement) {
		super(Arrays.asList((Node) iterationStatement));

		if (iterationStatement == null)
			throw new NullPointerException();
		this.iterationStatement = iterationStatement;
	}

	public Statement(JumpStatement jumpStatement) {
		super(Arrays.asList((Node) jumpStatement));

		if (jumpStatement == null)
			throw new NullPointerException();
		this.jumpStatement = jumpStatement;
	}

	public Statement(CompoundStatement compoundStatement) {
		super(Arrays.asList((Node) compoundStatement));

		if (compoundStatement == null)
			throw new NullPointerException();
		this.compoundStatement = compoundStatement;
	}

	public ExpressionStatement getExpressionStatement() {
		return expressionStatement;
	}

	public LabeledStatement getLabeledStatement() {
		return labeledStatement;
	}

	public SelectionStatement getSelectionStatement() {
		return selectionStatement;
	}

	public IterationStatement getIterationStatement() {
		return iterationStatement;
	}

	public JumpStatement getJumpStatement() {
		return jumpStatement;
	}

	public CompoundStatement getCompoundStatement() {
		return compoundStatement;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		setEndLine(Flag.CurrentLine);
	}
}
