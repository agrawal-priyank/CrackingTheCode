package LinkedLists;

import java.util.Scanner;

import LinkedLists.SinglyLinkedList.Node;
/* @author Priyank Agrawal
 * 
 * Date 08/19/2016
 * 
 * Check if the input integer linked list is a palindrome using Reverse and Compare approach 
 */
public class PalindromeList {
	
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
		System.out.println(isPalindrome(list.getHead()));
	}
	//check if the input list is palindrome
	static boolean isPalindrome(Node<Integer> head){
		Node<Integer> reversedHead = reverse(head); 
		return isEqual(head, reversedHead);
	}
	//reverse the input list
	static Node<Integer> reverse(Node<Integer> head){
		SinglyLinkedList<Integer> reversedList = new SinglyLinkedList<>();
		while(head != null){
			reversedList.addFirst(head.getElement());
			head = head.getNext();
		}		
		return reversedList.getHead();
	}
	//check if original list and reversed list are equal
	static boolean isEqual(Node<Integer> n1, Node<Integer> n2){
		Node<Integer> head1 = n1;
		Node<Integer> head2 = n2;
		while(head1 != null && head2 != null){
			if(head1.getElement() != head2.getElement())
				return false;
			else{
				head1 = head1.getNext();
				head2 = head2.getNext();
			}
		}		
		return head1 == null && head2 == null;
	}

}