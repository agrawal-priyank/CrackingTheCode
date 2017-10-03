package StacksAndQueues;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args){
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(8);
		stack.push(9);
		Stack<Integer> sorted = sort(stack);
		int length = sorted.size();
		System.out.println("Sorted Stack:");
		for(int i=0; i<length;i++){
			System.out.print(sorted.pop()+" ");
		}
	}
	
	/**
	 * @param original stack
	 * @return sorted stack
	 */
	public static Stack<Integer> sort(Stack<Integer> original){
		Stack<Integer> sorted = new Stack<>();				//new sorted stack
		while(!original.isEmpty()){
			int temp = original.pop();						//top element of original stack stored in temporary variable						
			while(!sorted.isEmpty() && sorted.peek()>temp){ //check whether top element of sorted stack is greater than top element of original stack
				original.push(sorted.pop());				//push elements of sorted stack back onto the original stack
			}
			sorted.push(temp);								//push top element of original stack onto the sorted stack
		}
		return sorted;
	}

}