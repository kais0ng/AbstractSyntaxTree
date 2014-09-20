package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class OneOrMoreInitializer extends NonTerminal {

	private static final long serialVersionUID = -5358403923711171090L;
	
	private List<Initializer> initializerList;

	public OneOrMoreInitializer(Initializer initializer) {
		this(null, null, initializer);
	}

	public OneOrMoreInitializer(OneOrMoreInitializer initializers,
			Punctuation punctuation, Initializer initializer) {
		super(Arrays.asList((Node) initializers, (Node) punctuation,
				(Node) initializer));

		if (initializer == null)
			throw new NullPointerException();
		if (initializers == null && punctuation != null)
			throw new IllegalArgumentException();
		if (initializers != null && punctuation == null)
			throw new IllegalArgumentException();
		if (punctuation != null && punctuation.getType() != TerminalType.COMMA)
			throw new IllegalArgumentException();
		initializerList = new ArrayList<Initializer>();
		if (initializers != null)
			initializerList.addAll(initializers.initializerList);
		initializerList.add(initializer);
	}

	public List<Initializer> getInitializerList() {
		return initializerList;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if (subNodes.size() > 1) {
			subNodes.get(1).Print(0);
			System.out.print(" ");
			subNodes.get(2).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
}
