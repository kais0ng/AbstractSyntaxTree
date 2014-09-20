//package AbstractSyntaxTree;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import AbstractSyntaxTree.NonTerminals.Declaration;
//import AbstractSyntaxTree.NonTerminals.Expression;
//import AbstractSyntaxTree.NonTerminals.ForStatement;
//import AbstractSyntaxTree.NonTerminals.Statement;
//
//public class Reader {
//	private String fileContent;
//	private List<ASTNode> astNodeList;
//	private boolean getASTNodeMethodExecuted;
//
//	/**
//	 * This method set the input file for later analyzing If there is no such
//	 * file, an exception will be thrown
//	 * 
//	 * @author Totalfrank
//	 * @param String
//	 */
//
//	public void setFile(String path) {
//	}
//
//	/**
//	 * This method will generate an AST(Abstract Syntax Tree) for given data
//	 * input, which should be stored beforehand(call setFile method to do it).
//	 * If it is called even before calling setFile method, an exception will be
//	 * thrown
//	 * 
//	 * @author Totalfrank
//	 * @return List<ASTNode>
//	 * @throws Exception
//	 */
//
//	public List<ASTNode> getASTNodeList() {
//		astNodeList = new ArrayList<ASTNode>();
//		String[] lines = fileContent.split("\n");
//		for (int index = 0; index < lines.length;) {
//			String name = lines[index++];
//			int way = Integer.parseInt(lines[index++]);
//			int numOfSubNodes = Integer.parseInt(lines[index++]);
//			int[] subNodePos = new int[numOfSubNodes];
//			String[] pos = lines[index++].split(" ");
//			for (int i = 0; i < numOfSubNodes; ++i)
//				subNodePos[i] = Integer.parseInt(pos[i]);
//			String content = null;
//			if (lines[index++] == "1")
//				content = lines[index++];
//			astNodeList.add(new ASTNode(name, way, subNodePos, content));
//		}
//		getASTNodeMethodExecuted = true;
//		return astNodeList;
//	}
//
//	/**
//	 * This method should be called after getASTNodeList() executed. The method
//	 * would build a AST(abstract syntax tree based on analyzing result output
//	 * of getASTNodeList() method and return the root of the AST. If it's called
//	 * before getASTNodeList executed, an IllegalStateException will be thrown.
//	 * If input data doesn't contain sufficient data or the data it contains is
//	 * invalid to generate AST structure or the root of this AST can't be
//	 * induced, an IllegalArgumentException will be thrown.
//	 * 
//	 * @author Totalfrank
//	 * @return Node root
//	 * @throws IllegalStateException
//	 *             , IllegalArgumentException
//	 */
//
//	public Node getRoot() throws Exception {
//		if (!getASTNodeMethodExecuted)
//			throw new IllegalStateException();
//		if (astNodeList.size() == 0)
//			throw new IllegalArgumentException();
//
//		int numOfASTNode = astNodeList.size();
//		boolean[] isRoot = new boolean[numOfASTNode];
//		Arrays.fill(isRoot, true);
//
//		for (int index = 0; index < numOfASTNode; ++index)
//			for (int subNode : astNodeList.get(index).subNodePos)
//				isRoot[subNode] = false;
//
//		int root = -1;
//		for (int index = 0; index < numOfASTNode; ++index) {
//			if (isRoot[index]) {
//				if (root != -1)
//					throw new IllegalArgumentException();
//				root = index;
//			}
//		}
//
//		return build(root);
//	}
//
//	/**
//	 * Build node recursively using java reflection
//	 * 
//	 * @author Totalfrank
//	 * @para rootIndex
//	 * @return Node of this AST sub node
//	 */
//
//	private Node build(int rootIndex) throws Exception {
//		Node rootNode = null;
//
//		ASTNodeName name = astNodeList.get(rootIndex).name;
//		int way = astNodeList.get(rootIndex).way;
//		int[] subNodepos = astNodeList.get(rootIndex).subNodePos;
//		String content = astNodeList.get(rootIndex).content;
//		String className = null;
//		
//		switch(name) {
//			/*
//			 * Terminal components which's definition is a little bit different from
//			 * C's Syntax in order to improve programming in Java
//			 */
//			
//			case ASTNode_ASSIGNMENT_OPERATOR:
//				className = "AbstractSyntaxTree.Terminals.AssignmentOperator";
//				break;
//			case ASTNode_UNARY_OPERATOR:
//				className = "AbstractSyntaxTree.Terminals.UnaryOperator";
//				break;
//			case ASTNode_INTEGER_CONSTANT:
//				className = "AbstractSyntaxTree.Terminals.IntegerConstant";
//				break;
//			case ASTNode_LONG_CONSTANT:
//				className = "AbstractSyntaxTree.Terminals.LongConstant";
//				break;
//			case ASTNode_DOUBLE_CONSTANT:
//				className = "AbstractSyntaxTree.Terminals.DoubleConstant";
//				
//				break;
//			case ASTNode_FLOAT_CONSTANT:
//				className = "AbstractSyntaxTree.Terminals.FloatConstant";
//				break;
//			case ASTNode_IDENTIFIER:
//				className = "AbstractSyntaxTree.Terminals.Identifier";
//				break;
//		}
//		
//		/*
//		 * handle "for" statement manually others types by reflection
//		 */
//		if (name == ASTNodeName.ASTNode_FOR_STATEMENT) {
//			switch (way) {
//			case 0:
//				rootNode = new ForStatement(null, null,
//						(Statement) build(subNodepos[0]));
//				break;
//			case 1:
//				rootNode = new ForStatement(null,
//						(Expression) build(subNodepos[0]),
//						(Statement) build(subNodepos[1]));
//				break;
//			case 2:
//				rootNode = new ForStatement((Expression) build(subNodepos[0]),
//						null, (Statement) build(subNodepos[1]));
//				break;
//			case 3:
//				rootNode = new ForStatement((Expression) build(subNodepos[0]),
//						(Expression) build(subNodepos[1]),
//						(Statement) build(subNodepos[2]));
//				break;
//			case 4:
//				rootNode = new ForStatement((Expression) build(subNodepos[0]),
//						null, null, (Statement) build(subNodepos[1]));
//				break;
//			case 5:
//				rootNode = new ForStatement((Expression) build(subNodepos[0]),
//						null, (Expression) build(subNodepos[1]),
//						(Statement) build(subNodepos[2]));
//				break;
//			case 6:
//				rootNode = new ForStatement((Expression) build(subNodepos[0]),
//						(Expression) build(subNodepos[1]), null,
//						(Statement) build(subNodepos[2]));
//				break;
//			case 7:
//				rootNode = new ForStatement((Expression) build(subNodepos[0]),
//						(Expression) build(subNodepos[1]),
//						(Expression) build(subNodepos[2]),
//						(Statement) build(subNodepos[3]));
//			case 8:
//				rootNode = new ForStatement((Declaration) build(subNodepos[0]),
//						null, null, (Statement) build(subNodepos[1]));
//				break;
//			case 9:
//				rootNode = new ForStatement((Declaration) build(subNodepos[0]),
//						null, (Expression) build(subNodepos[1]),
//						(Statement) build(subNodepos[2]));
//				break;
//			case 10:
//				rootNode = new ForStatement((Declaration) build(subNodepos[0]),
//						(Expression) build(subNodepos[1]), null,
//						(Statement) build(subNodepos[2]));
//				break;
//			case 11:
//				rootNode = new ForStatement((Declaration) build(subNodepos[0]),
//						(Expression) build(subNodepos[1]),
//						(Expression) build(subNodepos[2]),
//						(Statement) build(subNodepos[3]));
//				break;
//			}
//		}
//
//		switch (name) {
//			/*
//			 * Non terminal component which's definition is a little bit different
//			 * from C's Syntax in order to improve programming in Java
//			 */
//	
//			case ASTNode_PROGRAM:
//				className = "AbstractSyntaxTree.NonTerminals.Program";
//				break;
//			case ASTNode_FUNCTION_DEFINITION:
//				className = "AbstractSyntaxTree.NonTerminals.FunctionDefinition";
//				break;
//			case ASTNode_PARAMETER:
//				className = "AbstractSyntaxTree.NonTerminals.Parameter";
//				break;
//			case ASTNode_ONE_OR_MORE_PARAMETER:
//				className = "AbstractSyntaxTree.NonTerminals.OneOrMoreParameter";
//				break;
//			case ASTNode_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.Expression";
//				break;
//			case ASTNode_ASSIGNMENT_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.AssignmentExpression";
//				break;
//			case ASTNode_CONSTANT_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.ConstantExpression";
//				break;
//			case ASTNode_CONDITIONAL_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.ConditionalExpression";
//				break;
//			case ASTNode_OR_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.OrExpression";
//				break;
//			case ASTNode_AND_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.AndExpression";
//				break;
//			case ASTNode_BIT_OR_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.BitOrExpression";
//				break;
//			case ASTNode_BIT_XOR_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.BitXorExpression";
//				break;
//			case ASTNode_BIT_AND_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.BitAndExpression";
//				break;
//			case ASTNode_EQUALITY_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.EqualityExpression";
//				break;
//			case ASTNode_RELATIONAL_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.RelationalExpression";
//				break;
//			case ASTNode_SHIFT_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.ShiftExpression";
//				break;
//			case ASTNode_ADDITIVE_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.AdditiveExpression";
//				break;
//			case ASTNode_MULTIPLICATIVE_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.MultiplicativeExpression";
//				break;
//			case ASTNode_CAST_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.CastExpression";
//				break;
//			case ASTNode_UNARY_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.UnaryExpression";
//				break;
//			case ASTNode_POSTFIX_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.PostFixExpression";
//				break;
//			case ASTNode_PRIMARY_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.PrimaryExpression";
//				break;
//			case ASTNode_CONSTANT:
//				className = "AbstractSyntaxTree.NonTerminals.Constant";
//				break;
//			case ASTNode_ONE_OR_MORE_ARGUMENT_EXPRESSION:
//				className = "AbstractSyntaxTree.NonTerminals.OneOrMoreArgumentExpression";
//				break;
//			case ASTNode_DECLARATION_OR_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.DeclarationOrStatement";
//				break;
//			case ASTNode_ONE_OR_MORE_DECLARATION_OR_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.OneOrMoreDeclarationOrStatement";
//				break;
//			case ASTNode_DECLARATION_SPECIFIER:
//				className = "AbstractSyntaxTree.NonTerminals.DeclarationSpecifier";
//				break;
//			case ASTNode_ONE_OR_MORE_DECLARATION_SPECIFIER:
//				className = "AbstractSyntaxTree.NonTerminals.OneOrMoreDeclarationSpecifier";
//				break;
//			case ASTNode_DECLARATION:
//				className = "AbstractSyntaxTree.NonTerminals.Declaration";
//				break;
//			case ASTNode_DECLARATION_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.DeclarationStatement";
//				break;
//			case ASTNode_ONE_OR_MORE_INIT_DECLARATOR:
//				className = "AbstractSyntaxTree.NonTerminals.OneOrMoreInitDeclarator";
//				break;
//			case ASTNode_INIT_DECLARATOR:
//				className = "AbstractSyntaxTree.NonTerminals.InitDeclarator";
//				break;
//			case ASTNode_DECLARATOR:
//				className = "AbstractSyntaxTree.NonTerminals.Declarator";
//				break;
//			case ASTNode_DIRECT_DECLARATOR:
//				className = "AbstractSyntaxTree.NonTerminals.DirectDeclarator";
//				break;
//			case ASTNode_POINTER:
//				className = "AbstractSyntaxTree.NonTerminals.Pointer";
//				break;
//			case ASTNode_ONE_OR_MORE_INITIALIZER:
//				className = "AbstractSyntaxTree.NonTerminals.OneOrMoreInitializer";
//				break;
//			case ASTNode_INITIALIZER:
//				className = "AbstractSyntaxTree.NonTerminals.Initializer";
//				break;
//			case ASTNode_COMPOUND_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.CompoundStatement";
//				break;
//			case ASTNode_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.Statement";
//				break;
//			case ASTNode_LABELED_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.LabeledStatement";
//				break;
//			case ASTNode_EXPRESSION_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.ExpressionStatement";
//				break;
//			case ASTNode_SELECTION_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.SelectionStatement";
//				break;
//			case ASTNode_IF_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.IfStatement";
//				break;
//			case ASTNode_SWITCH_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.SwitchStatement";
//				break;
//			case ASTNode_ITERATION_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.IterationStatement";
//				break;
//			case ASTNode_WHILE_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.WhileStatement";
//				break;
//			case ASTNode_DO_WHILE_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.DoWhileStatement";
//				break;
//			case ASTNode_FOR_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.ForStatement";
//				break;
//			case ASTNode_JUMP_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.JumpStatement";
//				break;
//			case ASTNode_GOTO_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.GotoStatement";
//				break;
//			case ASTNode_CONTINUE_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.ContinueStatement";
//				break;
//			case ASTNode_BREAK_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.BreakStatement";
//				break;
//			case ASTNode_RETURN_STATEMENT:
//				className = "AbstractSyntaxTree.NonTerminals.ReturnStatement";
//				break;
//			case ASTNode_TYPE_SPECIFIER:
//				className = "AbstractSyntaxTree.NonTerminals.TypeSpecifier";
//				break;
//			case ASTNode_STORAGE_CLASS_SPECIFIER:
//				className = "AbstractSyntaxTree.NonTerminals.StorageClassSpecifier";
//				break;
//			case ASTNode_TYPE_QUALIFIER:
//				className = "AbstractSyntaxTree.NonTerminals.TypeQualifier";
//				break;
//			case ASTNode_ONE_OR_MORE_TYPE_QUALIFIER:
//				className = "AbstractSyntaxTree.NonTerminals.OneOrMoreTypeQualifier";
//				break;
//		}
//
//		Class c = Class.forName(className);
//		Class[] classes = new Class[subNodepos.length];
//		Object[] objects = new Object[subNodepos.length];
//
//		for (int index = 0; index < subNodepos.length; ++index) {
//			Node subNode = build(subNodepos[index]);
//			objects[index] = subNode;
//			classes[index] = subNode.getClass();
//		}
//
//		rootNode = (Node) (c.getConstructor(classes).newInstance(objects));
//		return rootNode;
//	}
//}
//
//class ASTNode {
//	public ASTNodeName name;
//	public int way;
//	public int[] subNodePos;
//	public String content;
//
//	public ASTNode() {
//
//	}
//
//	public ASTNode(String name, int way, int[] subNodePos, String content) {
//		this.name = ASTNodeName.valueOf(name);
//		this.way = way;
//		this.subNodePos = subNodePos;
//		this.content = content;
//	}
//}
//
//enum ASTNodeName {
//	ASTNode_LBRACKET, ASTNode_RBRACKET, ASTNode_LPARENTHESIS, ASTNode_RPARENTHESIS, ASTNode_LBRACE, ASTNode_RBRACE, ASTNode_POS_ADD, ASTNode_NEG_SUB, ASTNode_DEREF_MUL, ASTNode_ADDRESS_BIT_AND, ASTNode_PLUS_PLUS, ASTNode_MINUS_MINUS, ASTNode_NOT, ASTNode_BIT_REVERSE, ASTNode_DIV, ASTNode_MOD, ASTNode_LSHIFT, ASTNode_RSHIFT, ASTNode_BIT_AND, ASTNode_BIT_XOR, ASTNode_BIT_OR, ASTNode_ASSIGN, ASTNode_DIV_ASSIGN, ASTNode_MUL_ASSIGN, ASTNode_MOD_ASSIGN, ASTNode_ADD_ASSIGN, ASTNode_SUB_ASSIGN, ASTNode_LSHIFT_ASSIGN, ASTNode_RSHIFT_ASSIGN, ASTNode_BIT_AND_ASSIGN, ASTNode_BIT_XOR_ASSIGN, ASTNode_BIT_OR_ASSIGN, ASTNode_GREATER_THAN, ASTNode_GREATER_EQUAL, ASTNode_LESS_THAN, ASTNode_LESS_EQUAL, ASTNode_EQUAL, ASTNode_NOT_EQUAL, ASTNode_OR, ASTNode_AND, ASTNode_DOT, ASTNode_ARROW, ASTNode_QUESTION_MARK, ASTNode_COMMA, ASTNode_COLON, ASTNode_SEMICOLON, ASTNode_KEYWORD_AUTO, ASTNode_KEYWORD_BREAK, ASTNode_KEYWORD_CASE, ASTNode_KEYWORD_CHAR, ASTNode_KEYWORD_CONST, ASTNode_KEYWORD_CONTINUE, ASTNode_KEYWORD_DEFAULT, ASTNode_KEYWORD_DO, ASTNode_KEYWORD_DOUBLE, ASTNode_KEYWORD_ELSE, ASTNode_KEYWORD_ENUM, ASTNode_KEYWORD_EXTERN, ASTNode_KEYWORD_FLOAT, ASTNode_KEYWORD_FOR, ASTNode_KEYWORD_GOTO, ASTNode_KEYWORD_IF, ASTNode_KEYWORD_INT, ASTNode_KEYWORD_LONG, ASTNode_KEYWORD_REGISTER, ASTNode_KEYWORD_RETURN, ASTNode_KEYWORD_SHORT, ASTNode_KEYWORD_SIGNED, ASTNode_KEYWORD_SIZEOF, ASTNode_KEYWORD_STATIC, ASTNode_KEYWORD_STRUCT, ASTNode_KEYWORD_SWITCH, ASTNode_KEYWORD_TYPEDEF, ASTNode_KEYWORD_UNION, ASTNode_KEYWORD_UNSIGNED, ASTNode_KEYWORD_VOID, ASTNode_KEYWORD_VOLATILE, ASTNode_KEYWORD_WHILE, ASTNode_KEYWORD_INCLUDE, ASTNode_KEYWORD_DEFINE, ASTNode_INTEGER_CONSTANT, ASTNode_DOUBLE_CONSTANT, ASTNode_FLOAT_CONSTANT, ASTNode_LONG_CONSTANT, ASTNode_IDENTIFIER, ASTNode_PROGRAM, ASTNode_FUNCTION_DEFINITION, ASTNode_PARAMETER, ASTNode_ONE_OR_MORE_PARAMETER, ASTNode_EXPRESSION, ASTNode_ASSIGNMENT_EXPRESSION, ASTNode_CONSTANT_EXPRESSION, ASTNode_CONDITIONAL_EXPRESSION, ASTNode_OR_EXPRESSION, ASTNode_AND_EXPRESSION, ASTNode_BIT_OR_EXPRESSION, ASTNode_BIT_XOR_EXPRESSION, ASTNode_BIT_AND_EXPRESSION, ASTNode_EQUALITY_EXPRESSION, ASTNode_RELATIONAL_EXPRESSION, ASTNode_SHIFT_EXPRESSION, ASTNode_ADDITIVE_EXPRESSION, ASTNode_MULTIPLICATIVE_EXPRESSION, ASTNode_CAST_EXPRESSION, ASTNode_UNARY_EXPRESSION, ASTNode_POSTFIX_EXPRESSION, ASTNode_PRIMARY_EXPRESSION, ASTNode_CONSTANT, ASTNode_ONE_OR_MORE_ARGUMENT_EXPRESSION, ASTNode_DECLARATION_OR_STATEMENT, ASTNode_ONE_OR_MORE_DECLARATION_OR_STATEMENT, ASTNode_DECLARATION_SPECIFIER, ASTNode_ONE_OR_MORE_DECLARATION_SPECIFIER, ASTNode_DECLARATION, ASTNode_DECLARATION_STATEMENT, ASTNode_ONE_OR_MORE_INIT_DECLARATOR, ASTNode_INIT_DECLARATOR, ASTNode_DECLARATOR, ASTNode_DIRECT_DECLARATOR, ASTNode_POINTER, ASTNode_INITIALIZER, ASTNode_ONE_OR_MORE_INITIALIZER, ASTNode_COMPOUND_STATEMENT, ASTNode_STATEMENT, ASTNode_LABELED_STATEMENT, ASTNode_EXPRESSION_STATEMENT, ASTNode_SELECTION_STATEMENT, ASTNode_IF_STATEMENT, ASTNode_SWITCH_STATEMENT, ASTNode_ITERATION_STATEMENT, ASTNode_WHILE_STATEMENT, ASTNode_DO_WHILE_STATEMENT, ASTNode_FOR_STATEMENT, ASTNode_JUMP_STATEMENT, ASTNode_GOTO_STATEMENT, ASTNode_CONTINUE_STATEMENT, ASTNode_BREAK_STATEMENT, ASTNode_RETURN_STATEMENT, ASTNode_ASSIGNMENT_OPERATOR, ASTNode_UNARY_OPERATOR, ASTNode_TYPE_SPECIFIER, ASTNode_STORAGE_CLASS_SPECIFIER, ASTNode_TYPE_QUALIFIER, ASTNode_ONE_OR_MORE_TYPE_QUALIFIER, ASTNode_SPECIFIER_QUALIFIER, ASTNode_ONE_OR_MORE_SPECIFIER_QUALIFIER, ASTNode_ONE_OR_MORE_IDENTIFIER, ASTNode_TYPE_NAME
//}

package AbstractSyntaxTree;

public class Reader {
	
}