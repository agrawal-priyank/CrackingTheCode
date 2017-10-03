package StacksAndQueues;

import java.util.Stack;

public class StackMin extends Stack<Integer> {

	Stack<Integer> stack;

	public StackMin() {
		stack = new Stack<>();
	}

	public void push(int value) {
		if (value <= stack.peek())
			stack.push(value);
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min())
			stack.pop();
		return value;
	}

	public int min() {
		if (stack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return stack.peek();
	}

}