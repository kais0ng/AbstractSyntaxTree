package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class ExpressionStatement extends NonTerminal {

	private static final long serialVersionUID = 5966710581568927157L;

	private Expression expression;

	public ExpressionStatement(Punctuation punctuation) {
		this(null, punctuation);
	}

	public ExpressionStatement(Expression exp, Punctuation punctuation) {
		super(Arrays.asList((Node) exp, (Node) punctuation));

		if (punctuation == null)
			throw new NullPointerException();
		if (punctuation.getType() != TerminalType.SEMICOLON)
			throw new IllegalArgumentException();
		this.expression = exp;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (Flag.__LINE__)
			System.out
					.print("{ int tempValue = __LINE__; char buffer[20]; int pos = 0; while (tempValue > 0) { buffer[pos++] = tempValue % 10 + '0'; tempValue /= 10; } int i; for (i = 0; i < pos / 2; ++i) { char temp = buffer[i]; buffer[i] = buffer[pos - i - 1]; buffer[pos - i - 1] = temp; } buffer[pos++] = '\\n'; buffer[pos++] = '\\0'; FILE *p = fopen(\""
							+ "internalFile\\\\"
							+ Flag.LineFilePath
							+ "\", \"a+\"); fwrite(buffer, 1, strlen(buffer), p); fclose(p); }");
		for (int index = 0; index < subNodes.size(); ++index)
			subNodes.get(index).Print(0);
		setEndLine(Flag.CurrentLine);
	}
}
