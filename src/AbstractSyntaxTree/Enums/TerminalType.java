package AbstractSyntaxTree.Enums;


public enum TerminalType {

	LBRACE("ASTNode_Terminal_LBRACE"), //������
	RBRACE("ASTNode_Terminal_RBRACE"), 
	LBRACKET("ASTNode_Terminal_LBRACKET"), //С����
	RBRACKET("ASTNode_Terminal_RBRACKET"), 
	LPARENTHESIS("ASTNode_Terminal_LPARENTHESIS"),//���� 
	RPARENTHESIS("ASTNode_Terminal_RPARENTHESIS"), 
	DOT("ASTNode_Terminal_DOT"), //��
	DOMAIN("ASTNode_Terminal_DOMAIN"), 
	POS_OR_ADD("ASTNode_Terminal_POS_OR_ADD"),//����� 
	NEG_OR_SUB("ASTNode_Terminal_NEG_OR_SUB"), 
	PLUS_PLUS("ASTNode_Terminal_PLUS_PLUS"), //������
	MINUS_MINUS("ASTNode_Terminal_MINUS_MINUS"), //�Լ���
	DEREF_MUL("ASTNode_Terminal_DEREF_MUL"), 
	ADDRESS_BIT_AND("ASTNode_Terminal_ADDRESS_BIT_AND"), //ȡ��ַ������
	NOT("ASTNode_Terminal_NOT"), //��
	BIT_REVERSE("ASTNode_Terminal_BIT_REVERSE"), 
	DIV("ASTNode_Terminal_DIV"), //��
	MOD("ASTNode_Terminal_MOD"), //����
	LSHIFT("ASTNode_Terminal_LSHIFT"),//���� 
	RSHIFT("ASTNode_Terminal_RSHIFT"), 
	GREATER_THAN("ASTNode_Terminal_GREATER_THAN"),//���� 
	GREATER_EQUAL("ASTNode_Terminal_GREATER_EQUAL"), //���ڵ���
	LESS_THAN("ASTNode_Terminal_LESS_THAN"), 
	LESS_EQUAL("ASTNode_Terminal_LESS_EQUAL"), 
	EQUAL("ASTNode_Terminal_EQUAL"), //����
	NOT_EQUAL("ASTNode_Terminal_NOT_EQUAL"),//������ 
	BIT_XOR("ASTNode_Terminal_BIT_XOR"), 
	BIT_OR("ASTNode_Terminal_BIT_OR"), //λ��
	//BIT_AND("ASTNode_Terminal_ADDRESS_BIT_AND"), 
	AND("ASTNode_Terminal_AND"), //��
	OR("ASTNode_Terminal_OR"), //��
	QUESTION_MARK("ASTNode_Terminal_QUESTION_MARK"),//�ʺ� 
	ASSIGN("ASTNode_Terminal_ASSIGN"), //��ֵ
	DIV_ASSIGN("ASTNode_Terminal_DIV_ASSIGN"), 
	MUL_ASSIGN("ASTNode_Terminal_MUL_ASSIGN"), 
	MOD_ASSIGN("ASTNode_Terminal_MOD_ASSIGN"), 
	ADD_ASSIGN("ASTNode_Terminal_ADD_ASSIGN"), 
	SUB_ASSIGN("ASTNode_Terminal_SUB_ASSIGN"), 
	LSHIFT_ASSIGN("ASTNode_Terminal_LSHIFT_ASSIGN"),//���Ʋ���ֵ 
	RSHIFT_ASSIGN("ASTNode_Terminal_RSHIFT_ASSIGN"), 
	BIT_AND_ASSIGN("ASTNode_Terminal_BIT_AND_ASSIGN"), 
	BIT_XOR_ASSIGN("ASTNode_Terminal_BIT_XOR_ASSIGN"), 
	BIT_OR_ASSIGN("ASTNode_Terminal_BIT_OR_ASSIGN"), 
	COMMA("ASTNode_Terminal_COMMA"), //����
	COLON("ASTNode_Terminal_COLON"), //ð��
	SEMICOLON("ASTNode_Terminal_SEMICOLON"),//�ֺ� 
	KEYWORD_AUTO("ASTNode_Terminal_KEYWORD_AUTO"),//�ؼ���auto 
	KEYWORD_BREAK("ASTNode_Terminal_KEYWORD_BREAK"), 
	KEYWORD_CASE("ASTNode_Terminal_KEYWORD_CASE"), 
	KEYWORD_CHAR("ASTNode_Terminal_KEYWORD_CHAR"), 
	KEYWORD_CONST("ASTNode_Terminal_KEYWORD_CONST"), 
	KEYWORD_CONTINUE("ASTNode_Terminal_KEYWORD_CONTINUE"), 
	KEYWORD_DEFAULT("ASTNode_Terminal_KEYWORD_DEFAULT"), 
	KEYWORD_DO("ASTNode_Terminal_KEYWORD_DO"), 
	KEYWORD_DOUBLE("ASTNode_Terminal_KEYWORD_DOUBLE"), 
	KEYWORD_ELSE("ASTNode_Terminal_KEYWORD_ELSE"), 
	KEYWORD_ENUM("ASTNode_Terminal_KEYWORD_ENUM"), 
	KEYWORD_EXTERN("ASTNode_Terminal_KEYWORD_EXTERN"), 
	KEYWORD_FLOAT("ASTNode_Terminal_KEYWORD_FLOAT"), 
	KEYWORD_FOR("ASTNode_Terminal_KEYWORD_FOR"), 
	KEYWORD_GOTO("ASTNode_Terminal_KEYWORD_GOTO"), 
	KEYWORD_IF("ASTNode_Terminal_KEYWORD_IF"), 
	KEYWORD_INT("ASTNode_Terminal_KEYWORD_INT"), 
	KEYWORD_LONG("ASTNode_Terminal_KEYWORD_LONG"), 
	KEYWORD_REGISTER("ASTNode_Terminal_KEYWORD_REGISTER"), 
	KEYWORD_RETURN("ASTNode_Terminal_KEYWORD_RETURN"), 
	KEYWORD_SHORT("ASTNode_Terminal_KEYWORD_SHORT"), 
	KEYWORD_SIGNED("ASTNode_Terminal_KEYWORD_SIGNED"), 
	KEYWORD_SIZEOF("ASTNode_Terminal_KEYWORD_SIZEOF"), 
	KEYWORD_STATIC("ASTNode_Terminal_KEYWORD_STATIC"), 
	KEYWORD_STRUCT("ASTNode_Terminal_KEYWORD_STRUCT"), 
	KEYWORD_SWITCH("ASTNode_Terminal_KEYWORD_SWITCH"), 
	KEYWORD_TYPEDEF("ASTNode_Terminal_KEYWORD_TYPEDEF"), 
	KEYWORD_UNION("ASTNode_Terminal_KEYWORD_UNION"), 
	KEYWORD_UNSIGNED("ASTNode_Terminal_KEYWORD_UNSIGNED"), 
	KEYWORD_VOID("ASTNode_Terminal_KEYWORD_VOID"), 
	KEYWORD_VOLATILE("ASTNode_Terminal_KEYWORD_VOLATILE"), //
	KEYWORD_WHILE("ASTNode_Terminal_KEYWORD_WHILE"), 
	KEYWORD_INCLUDE("ASTNode_Terminal_KEYWORD_INCLUDE"), 
	KEYWORD_DEFINE("ASTNode_Terminal_KEYWORD_DEFINE"), 
	INTEGER_CONSTANT("ASTNode_Terminal_INTEGER_CONSTANT"), 
	LONG_CONSTANT("ASTNode_Terminal_LONG_CONSTANT"), 
	DOUBLE_CONSTANT("ASTNode_Terminal_DOUBLE_CONSTANT"), 
	FLOAT_CONSTANT("ASTNode_Terminal_FLOAT_CONSTANT"), 
	LITERAL_CONSTANT("ASTNode_Terminal_LITERAL_CONSTANT"), 
	CHARACTER_CONSTANT("ASTNode_Terminal_CHARACER_CONSTANT"), 
	IDENTIFIER("ASTNode_Terminal_IDENTIFIER");
	
	private final String value;
	
	private TerminalType(String value) { this.value = value; }
	
	@Override
	public String toString() {
		return value;
	}
}
