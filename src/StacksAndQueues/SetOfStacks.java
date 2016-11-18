package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * @author Priyank Agrawal
 * 
 * Implementing a Stack of plates and each Stack in the Set of Stacks can only have a limited capacity of plates
 * 
 * Date: 11/17/2016
 */
public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<>();
	public int capacity;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public Stack getLastStack() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}

	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}

	public void push(int v) {
		Stack last = getLastStack();
		if (last != null && !last.isFull())
			last.push(v);
		else {
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		int value;
		if (last == null || last.isEmpty())
			throw new EmptyStackException();
		else
			value = last.pop();
		if (last.size == 0)
			stacks.remove(stacks.size() - 1);
		return value;
	}

	public int popAt(int index) {
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		if (removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.removeBottom();
		if (stack.isEmpty())
			stacks.remove(index);
		else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}

}

class Stack {
	private int capacity;
	public int size = 0;
	private Node top, bottom;

	static class Node {
		private int value;
		private Node above;
		private Node below;

		public Node(int value) {
			this.setValue(value);
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getAbove() {
			return above;
		}

		public void setAbove(Node above) {
			this.above = above;
		}

		public Node getBelow() {
			return below;
		}

		public void setBelow(Node below) {
			this.below = below;
		}
	}

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return capacity == size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void join(Node above, Node below) {
		if (below != null)
			below.setAbove(above);
		if (above != null)
			above.setBelow(below);
	}

	public boolean push(int v) {
		if (size >= capacity)
			return false;
		size++;
		Node node = new Node(v);
		if (size == 1)
			bottom = node;
		join(node, top);
		top = node;
		return true;
	}

	public int pop() {
		Node node = top;
		top = top.getBelow();
		size--;
		return node.getValue();
	}

	public int removeBottom() {
		Node node = bottom;
		bottom = bottom.getAbove();
		if (bottom != null)
			bottom.setBelow(null);
		size--;
		return node.getValue();
	}

}