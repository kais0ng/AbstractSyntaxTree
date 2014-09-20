package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Bracket;
import AbstractSyntaxTree.Terminals.Identifier;
import AbstractSyntaxTree.Terminals.Keyword;
import AbstractSyntaxTree.Terminals.Parenthesis;
import Helper.Flag;

public class DirectDeclarator extends NonTerminal implements
		Comparable<DirectDeclarator> {

	private static final long serialVersionUID = 3102652313070231016L;

	private int way;
	private Identifier identifier;
	private DirectDeclarator directDeclarator;
	private ConstantExpression constExp;
	private OneOrMoreParameter parameters;
	//一般变量名
	public DirectDeclarator(Identifier identifier) {
		super(Arrays.asList((Node) identifier));
		if (identifier == null)
			throw new NullPointerException();
		this.identifier = identifier;	
		way = 0;
	}
	//数组变量名
	public DirectDeclarator(DirectDeclarator directDeclarator,
			Bracket lBracket, ConstantExpression constantExp, Bracket rBracket) {
		super(Arrays.asList((Node) directDeclarator, (Node) lBracket,
				(Node) constantExp, (Node) rBracket));
		if (directDeclarator == null || lBracket == null || constantExp == null
				|| rBracket == null)
			throw new NullPointerException();
		if (lBracket.getType() != TerminalType.LBRACKET
				|| rBracket.getType() != TerminalType.RBRACKET)
			throw new IllegalArgumentException();
		this.directDeclarator = directDeclarator;
		this.constExp = constantExp;
		way = 1;
	}
	//对象变量，含有参数构造
	public DirectDeclarator(DirectDeclarator directDeclarator,
			Parenthesis lParenthesis, OneOrMoreParameter parameters,
			Parenthesis rParenthesis) {
		super(Arrays.asList((Node) directDeclarator, (Node) lParenthesis,
				(Node) parameters, (Node) rParenthesis));
		if (directDeclarator == null || lParenthesis == null
				|| parameters == null || rParenthesis == null)
			throw new NullPointerException();
		if (lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.directDeclarator = directDeclarator;
		this.parameters = parameters;
		way = 2;
	}
	//对象变量，不含参数构造
	public DirectDeclarator(DirectDeclarator directDeclarator,
			Parenthesis lParenthesis, Parenthesis rParenthesis) {
		super(Arrays.asList((Node) directDeclarator, (Node) lParenthesis,
				(Node) rParenthesis));
		if (directDeclarator == null || lParenthesis == null
				|| rParenthesis == null)
			throw new NullPointerException();
		if (lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS)
			throw new IllegalArgumentException();
		this.directDeclarator = directDeclarator;
		way = 3;
	}
	// function(void)
	public DirectDeclarator(DirectDeclarator directDeclarator,
			Parenthesis lParenthesis, Keyword keyword, Parenthesis rParenthesis) {
		super(Arrays.asList((Node)directDeclarator, (Node)lParenthesis, 
				(Node)keyword, (Node)rParenthesis));
		if (directDeclarator == null || lParenthesis == null
				|| rParenthesis == null)
			throw new NullPointerException();
		if (lParenthesis.getType() != TerminalType.LPARENTHESIS
				|| rParenthesis.getType() != TerminalType.RPARENTHESIS || keyword.getType() != TerminalType.KEYWORD_VOID)
			throw new IllegalArgumentException();
		this.directDeclarator = directDeclarator;
		way = 4;
	}
	public Identifier getIdentifier() {
		return identifier;
	}

	public DirectDeclarator getHeadDirectDeclarator() {
		return directDeclarator;
	}

	public DirectDeclarator getTopDirectDeclarator() {
		if (directDeclarator != null)
			return directDeclarator.getTopDirectDeclarator();
		return this;
	}

	public OneOrMoreParameter getParameters() {
		return parameters;
	}

	public ConstantExpression getConstExp() {
		return constExp;
	}

	public int getNumOfBracket() {
		if (way == 0)
			return 0;
		if (way == 1)
			return 1 + ((DirectDeclarator) subNodes.get(0)).getNumOfBracket();
		return ((DirectDeclarator) subNodes.get(0)).getNumOfBracket();
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		switch (way) {
			case 0:
				subNodes.get(0).Print(0);
				break;
			default:
				for (int index = 0; index < subNodes.size(); ++index)
					subNodes.get(index).Print(0);
				break;
		}
		setEndLine(Flag.CurrentLine);
	}

	@Override
	public int compareTo(DirectDeclarator o) {
		if (o == null)
			return -1;
		if (subNodes.size() == 1) {
			if (o.subNodes.size() != 1)
				return -1;
			return 1;
		} else if (o.subNodes.size() == 1) {
			return 1;
		} else {
			int directDeclaratorCompRes = ((DirectDeclarator) subNodes.get(0))
					.compareTo((DirectDeclarator) o.subNodes.get(0));
			if (directDeclaratorCompRes != 0)
				return directDeclaratorCompRes;
			if (subNodes.size() != o.subNodes.size())
				return subNodes.size() - o.subNodes.size();
			if ((subNodes.get(1) instanceof Parenthesis)
					&& !(o.subNodes.get(1) instanceof Parenthesis))
				return -1;
			if ((o.subNodes.get(1) instanceof Parenthesis)
					&& !(subNodes.get(1) instanceof Parenthesis))
				return 1;
			return 0;
		}
	}

	public int compareToWithoutIdentifier(DirectDeclarator o) {
		if (o == null)
			return -1;
		List<DirectDeclarator> directDeclarators = expand((DirectDeclarator) subNodes
				.get(1));
		List<DirectDeclarator> oDirectDeclarators = null;
		if (o.subNodes.size() == 1)
			oDirectDeclarators = new ArrayList<DirectDeclarator>();
		else
			oDirectDeclarators = o.expand((DirectDeclarator) subNodes.get(0));
		for (int index = 0; index < directDeclarators.size(); ++index) {
			if (index >= oDirectDeclarators.size())
				return 1;
			DirectDeclarator d1 = directDeclarators.get(index);
			DirectDeclarator d2 = oDirectDeclarators.get(index);
			if (d1.subNodes.size() != d2.subNodes.size())
				return d1.subNodes.size() - d2.subNodes.size();
			if (d1.subNodes.get(1) instanceof Parenthesis
					&& !(d2.subNodes.get(1) instanceof Parenthesis))
				return -1;
			if (d2.subNodes.get(1) instanceof Parenthesis
					&& !(d1.subNodes.get(1) instanceof Parenthesis))
				return 1;
		}
		if (directDeclarators.size() < oDirectDeclarators.size())
			return -1;
		return 0;
	}

	private List<DirectDeclarator> expand(DirectDeclarator directDeclarator) {
		if (directDeclarator.subNodes.size() == 1)
			return new ArrayList<DirectDeclarator>();
		ArrayList<DirectDeclarator> directDeclaratorList = (ArrayList<DirectDeclarator>) expand((DirectDeclarator) subNodes
				.get(0));
		directDeclaratorList.add(this);
		return directDeclaratorList;
	}
}
