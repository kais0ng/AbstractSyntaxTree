package AbstractSyntaxTree.NonTerminals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import AbstractSyntaxTree.Node;
import AbstractSyntaxTree.NonTerminal;
import AbstractSyntaxTree.Enums.TerminalType;
import AbstractSyntaxTree.Terminals.Punctuation;
import Helper.Flag;

public class OneOrMoreParameter extends NonTerminal {

	private static final long serialVersionUID = 4161437081871236330L;
	
	private List<Parameter> parameterList;

	public OneOrMoreParameter(Parameter parameter) {
		this(null, null, parameter);
	}

	public static OneOrMoreParameter CreateOneOrMoreParameter(
			List<Parameter> parameterList) {
		if (parameterList == null)
			throw new NullPointerException();
		if (parameterList.isEmpty())
			throw new IllegalArgumentException();
		if (parameterList.size() == 1) {
			return new OneOrMoreParameter(parameterList.get(0));
		} else {
			return new OneOrMoreParameter(CreateOneOrMoreParameter(parameterList.subList(0,
					parameterList.size() - 1)), new Punctuation(
					TerminalType.COMMA),
					parameterList.get(parameterList.size() - 1));
		}
	}

	public OneOrMoreParameter(OneOrMoreParameter parameters,
			Punctuation punctuation, Parameter parameter) {
		super(Arrays.asList((Node) parameters, (Node) punctuation,
				(Node) parameter));

		if (parameter == null)
			throw new NullPointerException();
		if (parameters == null && punctuation != null)
			throw new IllegalArgumentException();
		if (parameters != null && punctuation == null)
			throw new IllegalArgumentException();
		if (punctuation != null && punctuation.getType() != TerminalType.COMMA)
			throw new IllegalArgumentException();
		if (parameters == null) {
			parameterList = Arrays.asList(parameter);
		} else {
			parameterList = new ArrayList<Parameter>();
			parameterList.addAll(parameters.getParameterList());
			parameterList.add(parameter);
		}
	}

	public List<Parameter> getParameterList() {
		return parameterList;
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