package StacksAndQueues;

import java.util.Stack;

/**
 * @author Priyank Agrawal
 *
 * Implementing Queue with two Stacks
 * 
 * Date: 11/14/2016
 */
public class QueueViaStacks<T> {
	
	private Stack<T> stack, stackReverse;
	
	public QueueViaStacks(){
		stack = new Stack<>();
		stackReverse = new Stack<>();
	}
	
	public void enqueue(T element){
		stack.push(element);
	}
	
	/**
	 * reversing the elements of original stack into a new reversed stack so that it follows
	 * queue rule of first-in-first-out while peeking and popping
	 */
	public void shiftStacks(){
		if(stackReverse.isEmpty()){
			if(!stack.isEmpty()){
				stackReverse.push(stack.pop());
			}
		}
	}
	
	public T first(){
		shiftStacks();
		return stackReverse.peek();
	}
	
	public T dequeue(){
		shiftStacks();
		return stackReverse.pop();
	}

}