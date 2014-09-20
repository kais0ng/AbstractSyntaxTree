
package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Terminals.DerefenceOrMulOperator;
import Helper.Flag;

public class Pointer extends NonTerminal implements Comparable<Pointer> {

	private static final long serialVersionUID = -2162897801828756830L;
	
	private int numOfDerefenceOps;
	private OneOrMoreTypeQualifier typeQualifiers;
	public Pointer(DerefenceOrMulOperator deRefOp) {
		super(Arrays.asList((Node) deRefOp));
		if (deRefOp == null)
			throw new NullPointerException();
		numOfDerefenceOps = 1;
	}

	public Pointer(DerefenceOrMulOperator deRefOp, Pointer pointer) {
		super(Arrays.asList((Node) deRefOp, (Node) pointer));
		if (deRefOp == null)
			throw new NullPointerException();
		if(pointer == null)
			numOfDerefenceOps = 1;
		else
			numOfDerefenceOps = 1 + pointer.numOfDerefenceOps;
	}

	public Pointer(DerefenceOrMulOperator deRefOp,
			OneOrMoreTypeQualifier typeQualifiers) {
		super(Arrays.asList((Node) deRefOp, (Node) typeQualifiers));
		if (deRefOp == null || typeQualifiers == null)
			throw new NullPointerException();
		numOfDerefenceOps = 1;
		this.typeQualifiers = typeQualifiers;
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		super.Print(indent);
		subNodes.get(0).Print(0);
		if (subNodes.size() > 1) {
			if (!(subNodes.get(1) instanceof Pointer))
				System.out.print(" ");
			subNodes.get(1).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}
	
	public int getNumOfDerefenceOps() {
		return numOfDerefenceOps;
	}
	
	public OneOrMoreTypeQualifier getTypeQualifiers() {
		return typeQualifiers;
	}

	@Override
	public int compareTo(Pointer o) {
		if(o == null)
			return -1;
		return numOfDerefenceOps - o.numOfDerefenceOps;
	}
}
