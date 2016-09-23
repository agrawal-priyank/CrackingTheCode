package LinkedLists;

import java.util.Scanner;
import java.util.Stack;

import LinkedLists.SinglyLinkedList.Node;
/* @author Priyank Agrawal
 * 
 * Date 08/19/2016
 * 
 * Check if the input integer linked list is a palindrome using stack with iterative approach 
 */

public class PalindromeListStackApproach {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter size of the list: ");
		int size = scanner.nextInt();		
		System.out.println("Please enter elements of the list: ");
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for(int i=0;i<size;++i){
			if(list.size()==0)
				list.addFirst(scanner.nextInt());
			else
				list.addLast(scanner.nextInt());
		}
		scanner.close();
		System.out.println(isPalindrome(list));
	}
	//check if the input list is a palindrome
	static boolean isPalindrome(SinglyLinkedList<Integer> list){
		Stack<Integer> stack = reverseStack(list.getHead(), list.size()); 
		return isEqual(list.getHead(), stack, list.size());
	}
	//fill the stack with the first half elements of the list
	static Stack<Integer> reverseStack(Node<Integer> node, int size){
		Stack<Integer> stack = new Stack<>();
		Node<Integer> head = node;
			for(int i=0;i<size/2;++i){
				stack.push(head.getElement());
				head = head.getNext();
			}
		return stack;
	}
	//check whether stack and second half of the list are equal
	static boolean isEqual(Node<Integer> node, Stack<Integer> stack, int size){
		Node<Integer> head = new Node<Integer>(0, null);
		if(size%2==0)
			head = node; //head will be first node is list has even size
		else
			head = node.getNext(); //head will be second node if list is odd
		//move the head to beginning of second half of the list
		for(int i=0;i<size/2;++i){
			head = head.getNext();
		}
		//remove every element of the stack and compare with the second half of the list
		for(int i=0;i<size/2;++i){
			if(stack.pop() != head.getElement())
				return false;
			else{
				head = head.getNext();					
			}
		}
		return head == null && stack.isEmpty();
	}

}
