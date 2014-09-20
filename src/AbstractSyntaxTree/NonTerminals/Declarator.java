
package AbstractSyntaxTree.NonTerminals;

import java.util.Arrays;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import Helper.Flag;
/*
 * 变量名的组成：1.直接的变量名，在类DirectDeclarator；2.直接的变量名和指针符
 */
public class Declarator extends NonTerminal implements Comparable<Declarator> {

	private static final long serialVersionUID = -3451149439417014323L;

	public Declarator(DirectDeclarator directDeclarator) {
		this(null, directDeclarator);
	}
	//变量名还有指针符*
	public Declarator(Pointer pointer, DirectDeclarator directDeclarator) {
		super(Arrays.asList((Node) pointer, (Node) directDeclarator));
		if (directDeclarator == null)
			throw new NullPointerException();
	}

	public Pointer getPointer() {
		if (subNodes.size() > 1)
			return (Pointer) subNodes.get(0);
		return null;
	}
	
	public DirectDeclarator getDirectDeclarator() {
		if(subNodes.size() == 1)
			return (DirectDeclarator)subNodes.get(0);
		else
			return (DirectDeclarator)subNodes.get(1);
	}

	@Override
	public void Print(int indent) {
		setStartLine(Flag.CurrentLine);
		subNodes.get(0).Print(indent);
		if (subNodes.size() > 1) {
			subNodes.get(1).Print(0);
		}
		setEndLine(Flag.CurrentLine);
	}

	@Override
	public int compareTo(Declarator o) {
		if (o == null)
			return -1;
		if (subNodes.size() != o.subNodes.size()) {
			return subNodes.size() - o.subNodes.size();
		} else if (subNodes.size() == 1) {
			return ((DirectDeclarator) subNodes.get(0))
					.compareTo((DirectDeclarator) o.subNodes.get(0));
		} else {
			int pointerCompRes = ((Pointer) subNodes.get(0))
					.compareTo((Pointer) o.subNodes.get(0));
			if (pointerCompRes != 0)
				return pointerCompRes;
			return ((DirectDeclarator) subNodes.get(1))
					.compareTo((DirectDeclarator) o.subNodes.get(1));
		}
	}

	public int compareToWithoutIdentifier(Declarator o) {
		if (o == null)
			return -1;
		if (subNodes.size() != o.subNodes.size()) {
			return subNodes.size() - o.subNodes.size();
		} else if (subNodes.size() == 1) {
			return ((DirectDeclarator) subNodes.get(0))
					.compareToWithoutIdentifier((DirectDeclarator) o.subNodes
							.get(0));
		} else {
			int pointerCompRes = ((Pointer) subNodes.get(0))
					.compareTo((Pointer) o.subNodes.get(0));
			if (pointerCompRes != 0)
				return pointerCompRes;
			return ((DirectDeclarator) subNodes.get(1))
					.compareToWithoutIdentifier((DirectDeclarator) o.subNodes
							.get(1));
		}
	}
}
