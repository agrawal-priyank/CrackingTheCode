package StacksAndQueues;

import java.util.Stack;

public class StackNodeMin extends Stack<NodeWithMin> {

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty())
			return Integer.MAX_VALUE;
		else
			return this.peek().getMin();
	}

}

//node class storing stack value and minimum
class NodeWithMin {
	private int value;
	private int min;

	public NodeWithMin(int value, int min) {
		this.setValue(value);
		this.setMin(min);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
}