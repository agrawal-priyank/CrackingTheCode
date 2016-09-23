package LinkedLists;

import java.util.Scanner;
import java.util.Stack;

import LinkedLists.SinglyLinkedList.Node;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/20/2016
 * 
 * Check whether a linked list is palindrome using Stack approach with the help of fast and slow pointer
 */
public class PalindromeListStackPointerApproach {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size of the list: ");
		int size = scanner.nextInt();
		System.out.println("Please enter elements of the list: ");
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for(int i=0;i<size;++i){
			if(list.isEmpty()){
				list.addFirst(scanner.nextInt());
			}
			else{
				list.addLast(scanner.nextInt());
			}
		}
		scanner.close();
		System.out.println("The list is Palindrome:\n"+isPalindrome(list.getHead()));
	}
	
	static boolean isPalindrome(Node<Integer> node){
		Node<Integer> slow = node;
		Node<Integer> fast = node;
		
		Stack<Integer> stack = new Stack<>();
		//increment slow by 1x speed(node) and fast by 2x speed(node)
		while(fast != null && fast.getNext() != null){
			stack.push(slow.getElement());
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		//list has odd number of elements so skip the middle element as it is not needed for comparison
		if(fast != null){
			slow = slow.getNext();
		}
		
		while(slow!=null){
			int top = stack.pop().intValue();
			//the top stack element does not match with list element
			if(top != slow.getElement())
				//list is not a palindrome
				return false;
			slow = slow.getNext();
		}
		//list is a palindrome
		return true;
	}

}
