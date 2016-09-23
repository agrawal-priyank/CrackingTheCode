package LinkedLists;

import java.util.Scanner;

import LinkedLists.SinglyLinkedList.Node;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/24/2016
 * 
 * Checking if a Linked List is Palindrome using Recursive approach
 * 
 * Time complexity is O(m*n)
 */
public class PalindromeListRecursive {

	public static class Result{
		public Result(Node<Integer> head, boolean b) {
			node = head;
			result = b;
		}
		private Node<Integer> node;
		private boolean result;
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size of the linked list: ");
		int size = scanner.nextInt();
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for(int i=0;i<size;++i){
			if(list.size() == 0)
				list.addFirst(scanner.nextInt());
			else
				list.addLast(scanner.nextInt());
		}
		scanner.close();
		Result res = isPalindrome(list.getHead(), listLength(list.getHead()));
		System.out.println("The list is a palindrome: " +res.result);		
	}
	
	/**
	 * @return the final result whether list is palindrome or not
	 */
	static Result isPalindrome(Node<Integer> head, int length){		
		if(head == null || length <= 0){
			return new Result(head, true);
		}
		else if(length == 1){
			return new Result(head.getNext(), true);
		}
		//recurse on the sublist
		Result res = isPalindrome(head.getNext(), length - 2);
		
		//if child calls are not palindrome, pass back up a failure
		if(!res.result || res.node==null){
			return res;
		}
		
		//checks if there is a match between the node and corresponding node on the other side
		res.result = (head.getElement() == res.node.getElement());
		
		//returns the corresponding node
		res.node = res.node.getNext();
		
		return res;		
	}
	
	/**
	 * @return the number of elements in the linked list
	 */
	static int listLength(Node<Integer> node){
		int size = 0;
		while(node!=null){
			size++;
			node = node.getNext();
		}
		return size;
	}
		
}