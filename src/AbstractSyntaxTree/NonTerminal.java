package AbstractSyntaxTree;

import java.util.ArrayList;
import java.util.List;

/* Non terminal definitions */

public abstract class NonTerminal extends Node {

	private static final long serialVersionUID = -2724363002597597154L;

	protected List<Node> subNodes;

	public NonTerminal(List<Node> list) {
		subNodes = new ArrayList<Node>();
		for (Node node : list)
			if (node != null)
				subNodes.add(node);
	}
	
	public List<Node> getSubNodeList() {
		return subNodes;
	}
}