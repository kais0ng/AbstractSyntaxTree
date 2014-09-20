package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;
/*
 * �����˱����ţ����ţ�ð�ţ��ֺ�
 */
public class Punctuation extends Terminal {

	private static final long serialVersionUID = 8825034846806809082L;

	private final static List<TerminalType> PunctuationTypes = Arrays.asList(
			TerminalType.COMMA, TerminalType.COLON, TerminalType.SEMICOLON);

	public Punctuation(TerminalType type) {
		super(type);
		if (type == null)
			throw new NullPointerException();
		if (!PunctuationTypes.contains(type))
			throw new IllegalArgumentException();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		if (type == TerminalType.COMMA)
			System.out.print(",");
		else if (type == TerminalType.COLON)
			System.out.print(":");
		else
			System.out.print(";");
		setEndLine(Flag.CurrentLine);
	}
}
