package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

/*
 * 定义声明语句的组成：Declaration+punctuation(声明+标点符号)
 */
public class DeclarationStatement extends NonTerminal {

	private static final long serialVersionUID = -6499931131025517939L;

	public DeclarationStatement(Declaration declaration, Punctuation punctuation) {
		super(Arrays.asList((Node) declaration, (Node) punctuation));

		if (declaration == null || punctuation == null)
			throw new NullPointerException();
		if (punctuation.getType() != TerminalType.SEMICOLON)
			throw new IllegalArgumentException();
	}

	public Declaration getDeclaration() {
		return (Declaration) subNodes.get(0);
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
		subNodes.get(0).Print(0);
		System.out.print(";");
		setEndLine(Flag.CurrentLine);
	}
}
