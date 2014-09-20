package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;
/*
 * 定义多个变量声明，其中变量初始化，也可以不初始化
 */
public class OneOrMoreInitDeclarator extends NonTerminal {

	private static final long serialVersionUID = 9117560629654253181L;
	
	private List<InitDeclarator> initDeclaratorList;
	
	public OneOrMoreInitDeclarator(InitDeclarator initDeclarator) {
		this(null, null, initDeclarator);
	}
	
	public OneOrMoreInitDeclarator(OneOrMoreInitDeclarator initDeclarators, Punctuation punctuation, InitDeclarator initDeclarator) {
		super(Arrays.asList((Node)initDeclarators, (Node)punctuation, (Node)initDeclarator));
		
		if(initDeclarator == null)
			throw new NullPointerException();
		if(initDeclarators == null && punctuation != null)
			throw new IllegalArgumentException();
		if(initDeclarators != null && punctuation == null)
			throw new IllegalArgumentException();
		if(punctuation != null && punctuation.getType() != TerminalType.COMMA)
			throw new IllegalArgumentException();
		
		initDeclaratorList = new ArrayList<InitDeclarator>();
		if(initDeclarators != null) {
			for(InitDeclarator subInitDeclarator: initDeclarators.getInitDeclaratorList())
				initDeclaratorList.add(subInitDeclarator);
		}
		initDeclaratorList.add(initDeclarator);
	}

	public List<InitDeclarator> getInitDeclaratorList() { return initDeclaratorList; }
	
	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if(subNodes.size() > 1) {
			subNodes.get(1).Print(0);
			System.out.print(" ");
			subNodes.get(2).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
