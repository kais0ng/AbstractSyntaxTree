package AbstractSyntaxTree.Terminals;

import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Terminal;
import AbstractSyntaxTree.Enums.TerminalType;
import Helper.Flag;

public class Keyword extends Terminal {

	private static final long serialVersionUID = 1134980691146256391L;

	private final static List<TerminalType> KeywordTypes = Arrays.asList(
			TerminalType.KEYWORD_AUTO, TerminalType.KEYWORD_BREAK,
			TerminalType.KEYWORD_CASE, TerminalType.KEYWORD_CHAR,
			TerminalType.KEYWORD_CONST, TerminalType.KEYWORD_CONTINUE,
			TerminalType.KEYWORD_DEFAULT, TerminalType.KEYWORD_DEFINE,
			TerminalType.KEYWORD_DO, TerminalType.KEYWORD_DOUBLE,
			TerminalType.KEYWORD_ELSE, TerminalType.KEYWORD_ENUM,
			TerminalType.KEYWORD_EXTERN, TerminalType.KEYWORD_EXTERN,
			TerminalType.KEYWORD_FLOAT, TerminalType.KEYWORD_FOR,
			TerminalType.KEYWORD_GOTO, TerminalType.KEYWORD_IF,
			TerminalType.KEYWORD_INCLUDE, TerminalType.KEYWORD_INT,
			TerminalType.KEYWORD_LONG, TerminalType.KEYWORD_REGISTER,
			TerminalType.KEYWORD_RETURN, TerminalType.KEYWORD_SHORT,
			TerminalType.KEYWORD_SIGNED, TerminalType.KEYWORD_SIZEOF,
			TerminalType.KEYWORD_STATIC, TerminalType.KEYWORD_STRUCT,
			TerminalType.KEYWORD_SWITCH, TerminalType.KEYWORD_TYPEDEF,
			TerminalType.KEYWORD_UNION, TerminalType.KEYWORD_UNSIGNED,
			TerminalType.KEYWORD_VOID, TerminalType.KEYWORD_VOLATILE,
			TerminalType.KEYWORD_WHILE);

	public Keyword(TerminalType type) {
		super(type);

		if (!KeywordTypes.contains(type))
			throw new IllegalArgumentException();
	}
	
	public String getContent(){
		String output = null;
		switch (type) {
			case KEYWORD_AUTO:
				output = "auto";
				break;
			case KEYWORD_BREAK:
				output = "break";
				break;
			case KEYWORD_CASE:
				output = "case";
				break;
			case KEYWORD_CHAR:
				output = "char";
				break;
			case KEYWORD_CONST:
				output = "const";
				break;
			case KEYWORD_CONTINUE:
				output = "continue";
				break;
			case KEYWORD_DEFAULT:
				output = "default";
				break;
			case KEYWORD_DEFINE:
				output = "define";
				break;
			case KEYWORD_DO:
				output = "do";
				break;
			case KEYWORD_DOUBLE:
				output = "double";
				break;
			case KEYWORD_ELSE:
				output = "else";
				break;
			case KEYWORD_ENUM:
				output = "enum";
				break;
			case KEYWORD_EXTERN:
				output = "extern";
				break;
			case KEYWORD_FLOAT:
				output = "float";
				break;
			case KEYWORD_FOR:
				output = "for";
				break;
			case KEYWORD_GOTO:
				output = "goto";
				break;
			case KEYWORD_IF:
				output = "if";
				break;
			case KEYWORD_INCLUDE:
				output = "include";
				break;
			case KEYWORD_INT:
				output = "int";
				break;
			case KEYWORD_LONG:
				output = "long";
				break;
			case KEYWORD_REGISTER:
				output = "register";
				break;
			case KEYWORD_RETURN:
				output = "return";
				break;
			case KEYWORD_SHORT:
				output = "short";
				break;
			case KEYWORD_SIGNED:
				output = "signed";
				break;
			case KEYWORD_SIZEOF:
				output = "sizeof";
				break;
			case KEYWORD_STATIC:
				output = "static";
				break;
			case KEYWORD_STRUCT:
				output = "struct";
				break;
			case KEYWORD_SWITCH:
				output = "switch";
				break;
			case KEYWORD_TYPEDEF:
				output = "typedef";
				break;
			case KEYWORD_UNION:
				output = "union";
				break;
			case KEYWORD_UNSIGNED:
				output = "unsigned";
				break;
			case KEYWORD_VOID:
				output = "void";
				break;
			case KEYWORD_VOLATILE:
				output = "volatile";
				break;
			case KEYWORD_WHILE:
				output = "while";
				break;
		default:
			break;
		}
		return output;
	}
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		String output = null;
		switch (type) {
			case KEYWORD_AUTO:
				output = "auto";
				break;
			case KEYWORD_BREAK:
				output = "break";
				break;
			case KEYWORD_CASE:
				output = "case";
				break;
			case KEYWORD_CHAR:
				output = "char";
				break;
			case KEYWORD_CONST:
				output = "const";
				break;
			case KEYWORD_CONTINUE:
				output = "continue";
				break;
			case KEYWORD_DEFAULT:
				output = "default";
				break;
			case KEYWORD_DEFINE:
				output = "define";
				break;
			case KEYWORD_DO:
				output = "do";
				break;
			case KEYWORD_DOUBLE:
				output = "double";
				break;
			case KEYWORD_ELSE:
				output = "else";
				break;
			case KEYWORD_ENUM:
				output = "enum";
				break;
			case KEYWORD_EXTERN:
				output = "extern";
				break;
			case KEYWORD_FLOAT:
				output = "float";
				break;
			case KEYWORD_FOR:
				output = "for";
				break;
			case KEYWORD_GOTO:
				output = "goto";
				break;
			case KEYWORD_IF:
				output = "if";
				break;
			case KEYWORD_INCLUDE:
				output = "include";
				break;
			case KEYWORD_INT:
				output = "int";
				break;
			case KEYWORD_LONG:
				output = "long";
				break;
			case KEYWORD_REGISTER:
				output = "register";
				break;
			case KEYWORD_RETURN:
				output = "return";
				break;
			case KEYWORD_SHORT:
				output = "short";
				break;
			case KEYWORD_SIGNED:
				output = "signed";
				break;
			case KEYWORD_SIZEOF:
				output = "sizeof";
				break;
			case KEYWORD_STATIC:
				output = "static";
				break;
			case KEYWORD_STRUCT:
				output = "struct";
				break;
			case KEYWORD_SWITCH:
				output = "switch";
				break;
			case KEYWORD_TYPEDEF:
				output = "typedef";
				break;
			case KEYWORD_UNION:
				output = "union";
				break;
			case KEYWORD_UNSIGNED:
				output = "unsigned";
				break;
			case KEYWORD_VOID:
				output = "void";
				break;
			case KEYWORD_VOLATILE:
				output = "volatile";
				break;
			case KEYWORD_WHILE:
				output = "while";
				break;
		default:
			break;
		}
		System.out.print(output);
		setEndLine(Flag.CurrentLine);
	}
}
