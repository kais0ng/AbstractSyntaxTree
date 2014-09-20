package AbstractSyntaxTree.Generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.NonTerminalType;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.AddAssignOperator;
import AbstractSyntaxTree.Terminals.AddressBitAndOperator;
import AbstractSyntaxTree.Terminals.AndOperator;
import AbstractSyntaxTree.Terminals.AssignOperator;
import AbstractSyntaxTree.Terminals.BitAndAssignOperator;
import AbstractSyntaxTree.Terminals.BitOrAssignOperator;
import AbstractSyntaxTree.Terminals.BitOrOperator;
import AbstractSyntaxTree.Terminals.BitReverseOperator;
import AbstractSyntaxTree.Terminals.BitXorAssignOperator;
import AbstractSyntaxTree.Terminals.BitXorOperator;
import AbstractSyntaxTree.Terminals.Brace;
import AbstractSyntaxTree.Terminals.Bracket;
import AbstractSyntaxTree.Terminals.DerefenceOrMulOperator;
import AbstractSyntaxTree.Terminals.DivAssignOperator;
import AbstractSyntaxTree.Terminals.DivOperator;
import AbstractSyntaxTree.Terminals.DomainOperator;
import AbstractSyntaxTree.Terminals.DotOperator;
import AbstractSyntaxTree.Terminals.DoubleConstant;
import AbstractSyntaxTree.Terminals.EqualityOperator;
import AbstractSyntaxTree.Terminals.FloatConstant;
import AbstractSyntaxTree.Terminals.Identifier;
import AbstractSyntaxTree.Terminals.IntegerConstant;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.LiteralConstant;
import AbstractSyntaxTree.Terminals.LongConstant;
import AbstractSyntaxTree.Terminals.LshiftAssignOperator;
import AbstractSyntaxTree.Terminals.MinusMinusOperator;
import AbstractSyntaxTree.Terminals.ModAssignOperator;
import AbstractSyntaxTree.Terminals.ModOperator;
import AbstractSyntaxTree.Terminals.MulAssignOperator;
import AbstractSyntaxTree.Terminals.NegOrSubOperator;
import AbstractSyntaxTree.Terminals.NotOperator;
import AbstractSyntaxTree.Terminals.OrOperator;
import AbstractSyntaxTree.Terminals.Parenthesis;
import AbstractSyntaxTree.Terminals.PlusPlusOperator;
import AbstractSyntaxTree.Terminals.PosOrAddOperator;
import AbstractSyntaxTree.Terminals.Punctuation;
import AbstractSyntaxTree.Terminals.QuestionOperator;
import AbstractSyntaxTree.Terminals.RelationalOperator;
import AbstractSyntaxTree.Terminals.RshiftAssignOperator;
import AbstractSyntaxTree.Terminals.ShiftOperator;
import AbstractSyntaxTree.Terminals.SubAssignOperator;

public class Generator {

	private static final String TerminalStart = "ASTNode_Terminal_";
	private static final String NonTerminalStart = "ASTNode_NonTerminal_";
	private static final HashMap<String, TerminalType> TerminalMap = new HashMap<String, TerminalType>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			for (TerminalType type : TerminalType.class.getEnumConstants()) {
				put(type.toString(), type);
			}
		}
	};

	private static final HashMap<String, NonTerminalType> NonTerminalMap = new HashMap<String, NonTerminalType>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			for (NonTerminalType type : NonTerminalType.class
					.getEnumConstants()) {
				put(type.toString(), type);
			}
		}
	};

	private String fileName;
	private List<String> lines;
	private List<ASTNode> astNodeList;

	public Generator(String fileName) {
		if (fileName == null)
			throw new NullPointerException();
		this.fileName = fileName;
	}
	public Node Generate() throws ClassNotFoundException,
			IllegalAccessException, NoSuchMethodException,
			InstantiationException, InvocationTargetException,
			FileNotFoundException, IOException, Exception {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		lines = new ArrayList<String>();
		while ((line = br.readLine()) != null)
			lines.add(line);
		br.close();
		astNodeList = new ArrayList<ASTNode>();
		for (int index = 0; index < lines.size();) {
			String name = lines.get(index++);
			int way = Integer.parseInt(lines.get(index++));
			int numOfSubNodes = Integer.parseInt(lines.get(index++));
			int[] subNodePos = new int[numOfSubNodes];
			if (numOfSubNodes > 0) {
				String[] pos = lines.get(index++).split(" ");
				for (int i = 0; i < numOfSubNodes; ++i)
					subNodePos[i] = Integer.parseInt(pos[i]);
			}
			String content = null;
			if (lines.get(index++).equals("1"))
				content = lines.get(index++);
			astNodeList.add(new ASTNode(name, way, subNodePos, content));
		}

		int numOfASTNode = astNodeList.size();
		boolean[] isRoot = new boolean[numOfASTNode];
		Arrays.fill(isRoot, true);
		for (int index = 0; index < numOfASTNode; ++index)
			for (int subNode : astNodeList.get(index).subNodePos)
				isRoot[subNode] = false;
		int root = -1;
		System.out.println(numOfASTNode);
		for (int i = 0; i < numOfASTNode; ++i)
			if (isRoot[i]) {
				System.out.println("root:"+i);
				System.out.println(astNodeList.get(i).name);
				System.out.println("subNodes:");
				int[] tmp=astNodeList.get(i).subNodePos;
				for(int j=0;j<tmp.length;j++){
					System.out.println(astNodeList.get(tmp[j]).name);
				}
			}
		for (int index = 0; index < numOfASTNode; ++index) {
			if (isRoot[index]) {
				if (root != -1)
					//throw new IllegalArgumentException();
					break;
				root = index;
			}
		}
		return build(root);
	}

	private Node build(int root) throws ClassNotFoundException,
			IllegalAccessException, NoSuchMethodException,
			InstantiationException, InvocationTargetException {
		ASTNode node = astNodeList.get(root);
		if (node.name.toString().startsWith(TerminalStart)) {
			return getTerminalByNameAndContent(node.name.toString(),
					node.content);
		} else {
			Class<?>[] constructorParaClasses = new Class[node.subNodePos.length];
			Object[] constructorParaObjs = new Object[node.subNodePos.length];
			for (int index = 0; index < node.subNodePos.length; ++index) {
				Node subNode = build(node.subNodePos[index]);
				constructorParaObjs[index] = subNode;
				constructorParaClasses[index] = subNode.getClass();
			}
			return getNonTerminalByNameAndSubNodes(node.name.toString()
					.substring(NonTerminalStart.length()),
					constructorParaClasses, constructorParaObjs);
		}
	}

	private Terminal getTerminalByNameAndContent(String name, String content) {
		if (name == null)
			throw new NullPointerException();
		TerminalType type = TerminalMap.get(name);
		if (type == null) {
			 System.out.println(name);
			throw new IllegalArgumentException();
		}
		switch (type) {
			case ADDRESS_BIT_AND:
				return new AddressBitAndOperator(type);
			case AND:
				return new AndOperator(type);
			case ASSIGN:
				return new AssignOperator(type);
			case MUL_ASSIGN:
				return new MulAssignOperator(type);
			case DIV_ASSIGN:
				return new DivAssignOperator(type);
			case MOD_ASSIGN:
				return new ModAssignOperator(type);
			case ADD_ASSIGN:
				return new AddAssignOperator(type);
			case SUB_ASSIGN:
				return new SubAssignOperator(type);
			case LSHIFT_ASSIGN:
				return new LshiftAssignOperator(type);
			case RSHIFT_ASSIGN:
				return new RshiftAssignOperator(type);
			case BIT_AND_ASSIGN:
				return new BitAndAssignOperator(type);
			case BIT_XOR_ASSIGN:
				return new BitXorAssignOperator(type);
			case BIT_OR_ASSIGN:
				return new BitOrAssignOperator(type);
			case BIT_OR:
				return new BitOrOperator(type);
			case BIT_REVERSE:
				return new BitReverseOperator(type);
			case BIT_XOR:
				return new BitXorOperator(type);
			case LBRACE:
			case RBRACE:
				return new Brace(type);
			case LBRACKET:
			case RBRACKET:
				return new Bracket(type);
			case DEREF_MUL:
				return new DerefenceOrMulOperator(type);
			case DIV:
				return new DivOperator(type);
			case DOMAIN:
				return new DomainOperator(type);
			case DOT:
				return new DotOperator(type);
			case DOUBLE_CONSTANT:
				return new DoubleConstant(content);
			case EQUAL:
			case NOT_EQUAL:
				return new EqualityOperator(type);
			case FLOAT_CONSTANT:
				return new FloatConstant(content);
			case IDENTIFIER:
				return new Identifier(content);
			case INTEGER_CONSTANT:
				return new IntegerConstant(content);
			case KEYWORD_AUTO:
			case KEYWORD_BREAK:
			case KEYWORD_CASE:
			case KEYWORD_CHAR:
			case KEYWORD_CONST:
			case KEYWORD_CONTINUE:
			case KEYWORD_DEFAULT:
			case KEYWORD_DEFINE:
			case KEYWORD_DO:
			case KEYWORD_DOUBLE:
			case KEYWORD_ELSE:
			case KEYWORD_ENUM:
			case KEYWORD_EXTERN:
			case KEYWORD_FLOAT:
			case KEYWORD_FOR:
			case KEYWORD_GOTO:
			case KEYWORD_IF:
			case KEYWORD_INCLUDE:
			case KEYWORD_INT:
			case KEYWORD_LONG:
			case KEYWORD_REGISTER:
			case KEYWORD_RETURN:
			case KEYWORD_SHORT:
			case KEYWORD_SIGNED:
			case KEYWORD_SIZEOF:
			case KEYWORD_STATIC:
			case KEYWORD_STRUCT:
			case KEYWORD_SWITCH:
			case KEYWORD_TYPEDEF:
			case KEYWORD_UNION:
			case KEYWORD_UNSIGNED:
			case KEYWORD_VOID:
			case KEYWORD_VOLATILE:
			case KEYWORD_WHILE:
				return new Keyword(type);
			case LITERAL_CONSTANT:
				return new LiteralConstant(content);
			case LONG_CONSTANT:
				return new LongConstant(content);
			case MINUS_MINUS:
				return new MinusMinusOperator(type);
			case MOD:
				return new ModOperator(type);
			case NEG_OR_SUB:
				return new NegOrSubOperator(type);
			case NOT:
				return new NotOperator(type);
			case OR:
				return new OrOperator(type);
			case LPARENTHESIS:
			case RPARENTHESIS:
				return new Parenthesis(type);
			case PLUS_PLUS:
				return new PlusPlusOperator(type);
			case POS_OR_ADD:
				return new PosOrAddOperator(type);
			case COMMA:
			case COLON:
			case SEMICOLON:
				return new Punctuation(type);
			case QUESTION_MARK:
				return new QuestionOperator(type);
			case LESS_THAN:
			case LESS_EQUAL:
			case GREATER_THAN:
			case GREATER_EQUAL: {
				return new RelationalOperator(type);
			}
			case LSHIFT:
			case RSHIFT:
				return new ShiftOperator(type);
			default:
				throw new IllegalArgumentException();
		}
	}

	private NonTerminal getNonTerminalByNameAndSubNodes(String name,
			Class<?>[] constructorParaClasses, Object[] constructorParaObjs)
			throws ClassNotFoundException, IllegalAccessException,
			NoSuchMethodException, InstantiationException,
			InvocationTargetException {
		if (name == null)
			throw new NullPointerException();
		NonTerminalType type = NonTerminalMap.get(name);
		if (type == null) {
			System.out.println(name);
			// System.out.println("name = " + name);
			// for(int i = 0; i < constructorParaClasses.length; ++i)
			// System.out.print(constructorParaClasses[i] + " ");
			// System.out.println();
			throw new IllegalArgumentException();
		}
		StringBuilder className = new StringBuilder(
				"AbstractSyntaxTree.NonTerminals.");
		String[] subNames = name.split("_");
		for (String subName : subNames) {
			StringBuilder sb = new StringBuilder(subName);
			for (int index = 1; index < sb.length(); ++index)
				sb.setCharAt(index, Character.toLowerCase(sb.charAt(index)));
			className.append(sb);
		}

		Class<?> c = Class.forName(className.toString());
		try {
			return (NonTerminal) (c.getConstructor(constructorParaClasses)
					.newInstance(constructorParaObjs));
			
		} catch (NoSuchMethodException e) {
			// TODO: handle exception
			System.out.println("Class = " + c.toString());
			for(Class<?> cc: constructorParaClasses)
				System.out.println(cc);
			throw e;
		}
	}
}


class ASTNode {

	public ASTNodeName name;
	public int way;
	public int[] subNodePos;
	public String content;

	public ASTNode() {
	}

	public ASTNode(String name, int way, int[] subNodePos, String content) throws Exception {
		try {
			this.name = ASTNodeName.valueOf(name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(name);
			throw e;
		}
		this.way = way;
		this.subNodePos = subNodePos;
		this.content = content;
	}
}


enum ASTNodeName {
	ASTNode_Terminal_LBRACKET, 
	ASTNode_Terminal_RBRACKET, 
	ASTNode_Terminal_LPARENTHESIS, 
	ASTNode_Terminal_RPARENTHESIS, 
	ASTNode_Terminal_LBRACE, 
	ASTNode_Terminal_RBRACE, 
	ASTNode_Terminal_POS_OR_ADD, 
	ASTNode_Terminal_NEG_OR_SUB, 
	ASTNode_Terminal_DEREF_MUL, 
	ASTNode_Terminal_ADDRESS_BIT_AND,
	ASTNode_Terminal_PLUS_PLUS, 
	ASTNode_Terminal_MINUS_MINUS, 
	ASTNode_Terminal_NOT, 
	ASTNode_Terminal_BIT_REVERSE, 
	ASTNode_Terminal_DIV, 
	ASTNode_Terminal_MOD, 
	ASTNode_Terminal_LSHIFT, 
	ASTNode_Terminal_RSHIFT, 
	ASTNode_Terminal_BIT_XOR, 
	ASTNode_Terminal_BIT_OR, 
	ASTNode_Terminal_ASSIGN, 
	ASTNode_Terminal_DIV_ASSIGN, 
	ASTNode_Terminal_MUL_ASSIGN, 
	ASTNode_Terminal_MOD_ASSIGN, 
	ASTNode_Terminal_ADD_ASSIGN, 
	ASTNode_Terminal_SUB_ASSIGN, 
	ASTNode_Terminal_LSHIFT_ASSIGN, 
	ASTNode_Terminal_RSHIFT_ASSIGN, 
	ASTNode_Terminal_BIT_AND_ASSIGN, 
	ASTNode_Terminal_BIT_XOR_ASSIGN, 
	ASTNode_Terminal_BIT_OR_ASSIGN, 
	ASTNode_Terminal_GREATER_THAN, 
	ASTNode_Terminal_GREATER_EQUAL, 
	ASTNode_Terminal_LESS_THAN, 
	ASTNode_Terminal_LESS_EQUAL, 
	ASTNode_Terminal_EQUAL, 
	ASTNode_Terminal_NOT_EQUAL, 
	ASTNode_Terminal_OR, 
	ASTNode_Terminal_AND, 
	ASTNode_Terminal_DOT, 
	ASTNode_Terminal_DOMAIN, 
	ASTNode_Terminal_QUESTION_MARK, 
	ASTNode_Terminal_COMMA, 
	ASTNode_Terminal_COLON, 
	ASTNode_Terminal_SEMICOLON,
	ASTNode_Terminal_KEYWORD_AUTO, 
	ASTNode_Terminal_KEYWORD_BREAK, 
	ASTNode_Terminal_KEYWORD_CASE, 
	ASTNode_Terminal_KEYWORD_CHAR, 
	ASTNode_Terminal_KEYWORD_CONST, 
	ASTNode_Terminal_KEYWORD_CONTINUE, 
	ASTNode_Terminal_KEYWORD_DEFAULT, 
	ASTNode_Terminal_KEYWORD_DO, 
	ASTNode_Terminal_KEYWORD_DOUBLE, 
	ASTNode_Terminal_KEYWORD_ELSE, 
	ASTNode_Terminal_KEYWORD_ENUM, 
	ASTNode_Terminal_KEYWORD_EXTERN, 
	ASTNode_Terminal_KEYWORD_FLOAT, 
	ASTNode_Terminal_KEYWORD_FOR, 
	ASTNode_Terminal_KEYWORD_GOTO, 
	ASTNode_Terminal_KEYWORD_IF, 
	ASTNode_Terminal_KEYWORD_INT, 
	ASTNode_Terminal_KEYWORD_LONG, 
	ASTNode_Terminal_KEYWORD_REGISTER, 
	ASTNode_Terminal_KEYWORD_RETURN, 
	ASTNode_Terminal_KEYWORD_SHORT, 
	ASTNode_Terminal_KEYWORD_SIGNED, 
	ASTNode_Terminal_KEYWORD_SIZEOF,
	ASTNode_Terminal_KEYWORD_STATIC, 
	ASTNode_Terminal_KEYWORD_STRUCT, 
	ASTNode_Terminal_KEYWORD_SWITCH, 
	ASTNode_Terminal_KEYWORD_TYPEDEF, 
	ASTNode_Terminal_KEYWORD_UNION, 
	ASTNode_Terminal_KEYWORD_UNSIGNED, 
	ASTNode_Terminal_KEYWORD_VOID, 
	ASTNode_Terminal_KEYWORD_VOLATILE, 
	ASTNode_Terminal_KEYWORD_WHILE, 
	ASTNode_Terminal_KEYWORD_INCLUDE, 
	ASTNode_Terminal_KEYWORD_DEFINE, 
	ASTNode_Terminal_INTEGER_CONSTANT, 
	ASTNode_Terminal_DOUBLE_CONSTANT, 
	ASTNode_Terminal_FLOAT_CONSTANT, 
	ASTNode_Terminal_LONG_CONSTANT, 
	ASTNode_Terminal_CHARACTER_CONSTANT, 
	ASTNode_Terminal_LITERAL_CONSTANT, 
	ASTNode_Terminal_IDENTIFIER,
	
	ASTNode_NonTerminal_PROGRAM, 
	ASTNode_NonTerminal_FUNCTION_DEFINITION, 
	ASTNode_NonTerminal_PARAMETER, 
	ASTNode_NonTerminal_ONE_OR_MORE_PARAMETER, 
	ASTNode_NonTerminal_EXPRESSION, 
	ASTNode_NonTerminal_ASSIGNMENT_EXPRESSION, 
	ASTNode_NonTerminal_CONSTANT_EXPRESSION, 
	ASTNode_NonTerminal_CONDITIONAL_EXPRESSION, 
	ASTNode_NonTerminal_OR_EXPRESSION, 
	ASTNode_NonTerminal_AND_EXPRESSION, 
	ASTNode_NonTerminal_BIT_OR_EXPRESSION, 
	ASTNode_NonTerminal_BIT_XOR_EXPRESSION, 
	ASTNode_NonTerminal_BIT_AND_EXPRESSION, 
	ASTNode_NonTerminal_EQUALITY_EXPRESSION, 
	ASTNode_NonTerminal_RELATIONAL_EXPRESSION, 
	ASTNode_NonTerminal_SHIFT_EXPRESSION, 
	ASTNode_NonTerminal_ADDITIVE_EXPRESSION, 
	ASTNode_NonTerminal_MULTIPLICATIVE_EXPRESSION, 
	ASTNode_NonTerminal_CAST_EXPRESSION, 
	ASTNode_NonTerminal_UNARY_EXPRESSION, 
	ASTNode_NonTerminal_POSTFIX_EXPRESSION, 
	ASTNode_NonTerminal_PRIMARY_EXPRESSION, 
	ASTNode_NonTerminal_CONSTANT, 
	ASTNode_NonTerminal_ONE_OR_MORE_ARGUMENT_EXPRESSION, 
	ASTNode_NonTerminal_DECLARATION_OR_STATEMENT, 
	ASTNode_NonTerminal_ONE_OR_MORE_DECLARATION_OR_STATEMENT, 
	ASTNode_NonTerminal_DECLARATION_SPECIFIER, 
	ASTNode_NonTerminal_ONE_OR_MORE_DECLARATION_SPECIFIER, 
	ASTNode_NonTerminal_DECLARATION, 
	ASTNode_NonTerminal_DECLARATION_STATEMENT, 
	ASTNode_NonTerminal_ONE_OR_MORE_DECLARATION_STATEMENT, 
	ASTNode_NonTerminal_ONE_OR_MORE_INIT_DECLARATOR, 
	ASTNode_NonTerminal_INIT_DECLARATOR, 
	ASTNode_NonTerminal_DECLARATOR, 
	ASTNode_NonTerminal_DIRECT_DECLARATOR, 
	ASTNode_NonTerminal_POINTER, 
	ASTNode_NonTerminal_INITIALIZER, 
	ASTNode_NonTerminal_ONE_OR_MORE_INITIALIZER, 
	ASTNode_NonTerminal_COMPOUND_STATEMENT, 
	ASTNode_NonTerminal_STATEMENT, 
	ASTNode_NonTerminal_LABELED_STATEMENT,
	ASTNode_NonTerminal_CASE_STATEMENT,
	ASTNode_NonTerminal_DEFAULT_STATEMENT,
	ASTNode_NonTerminal_EXPRESSION_STATEMENT, 
	ASTNode_NonTerminal_SELECTION_STATEMENT, 
	ASTNode_NonTerminal_IF_STATEMENT, 
	ASTNode_NonTerminal_SWITCH_STATEMENT, 
	ASTNode_NonTerminal_ITERATION_STATEMENT, 
	ASTNode_NonTerminal_WHILE_STATEMENT, 
	ASTNode_NonTerminal_DO_WHILE_STATEMENT, 
	ASTNode_NonTerminal_FOR_STATEMENT, 
	ASTNode_NonTerminal_JUMP_STATEMENT, 
	ASTNode_NonTerminal_GOTO_STATEMENT, 
	ASTNode_NonTerminal_CONTINUE_STATEMENT, 
	ASTNode_NonTerminal_BREAK_STATEMENT, 
	ASTNode_NonTerminal_RETURN_STATEMENT, 
	ASTNode_NonTerminal_ASSIGNMENT_OPERATOR, 
	ASTNode_NonTerminal_UNARY_OPERATOR, 
	ASTNode_NonTerminal_TYPE_SPECIFIER, 
	ASTNode_NonTerminal_STORAGE_CLASS_SPECIFIER, 
	ASTNode_NonTerminal_TYPE_QUALIFIER, 
	ASTNode_NonTerminal_ONE_OR_MORE_TYPE_QUALIFIER, 
	ASTNode_NonTerminal_SPECIFIER_QUALIFIER, 
	ASTNode_NonTerminal_ONE_OR_MORE_SPECIFIER_QUALIFIER, 
	ASTNode_NonTerminal_ONE_OR_MORE_IDENTIFIER, 
	ASTNode_NonTerminal_TYPE_NAME, 
	ASTNode_NonTerminal_STRUCT_OR_UNION, 
	ASTNode_NonTerminal_STRUCT_OR_UNION_SPECIFIER,
	ASTNode_NonTerminal_ONE_OR_MORE_STRUCT_DECLARATION,
	ASTNode_NonTerminal_STRUCT_DECLARATION,
	ASTNode_NonTerminal_ONE_OR_MORE_STRUCT_DECLARATOR,
	ASTNode_NonTerminal_STRUCT_DECLARATOR
}