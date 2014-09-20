package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;
import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;

public abstract class Operator extends Terminal {

	private static final long serialVersionUID = -8482896943393294736L;

	List<TerminalType> OperatorTypes = Arrays.asList(TerminalType.DOT,
			TerminalType.DOMAIN, TerminalType.POS_OR_ADD, TerminalType.NEG_OR_SUB,
			TerminalType.PLUS_PLUS, TerminalType.MINUS_MINUS,
			TerminalType.DEREF_MUL, TerminalType.DEREF_MUL,
			TerminalType.ADDRESS_BIT_AND, TerminalType.NOT,
			TerminalType.BIT_REVERSE, TerminalType.DIV, TerminalType.MOD,
			TerminalType.LSHIFT, TerminalType.RSHIFT,
			TerminalType.GREATER_THAN, TerminalType.GREATER_EQUAL,
			TerminalType.LESS_THAN, TerminalType.LESS_EQUAL,
			TerminalType.EQUAL, TerminalType.NOT_EQUAL, TerminalType.BIT_OR,
			TerminalType.BIT_XOR, TerminalType.AND, TerminalType.OR,
			TerminalType.QUESTION_MARK, TerminalType.ASSIGN,
			TerminalType.DIV_ASSIGN, TerminalType.MUL_ASSIGN,
			TerminalType.MOD_ASSIGN, TerminalType.ADD_ASSIGN,
			TerminalType.SUB_ASSIGN, TerminalType.LSHIFT_ASSIGN,
			TerminalType.RSHIFT_ASSIGN, TerminalType.BIT_AND_ASSIGN,
			TerminalType.BIT_XOR_ASSIGN);

	public Operator(TerminalType type) {
		super(type);

		if (!OperatorTypes.contains(type))
			throw new IllegalArgumentException();
	}

	public TerminalType getOperatorType() {
		return type;
	}
}
