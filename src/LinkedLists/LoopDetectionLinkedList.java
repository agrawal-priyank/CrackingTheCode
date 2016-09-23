package LinkedLists;

import java.util.Scanner;

import LinkedLists.CircularlyLinkedList.Node;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/24/2016
 * 
 * To detect loop in the Linked List and return corresponding node
 *
 */
public class LoopDetectionLinkedList {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size of the list: ");
		int size = scanner.nextInt();
		CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
		for(int i=0;i<size;++i){
			if(list.isEmpty())
				list.addFirst(scanner.nextInt());
			else
				list.addLast(scanner.nextInt());
		}
		scanner.close();
		Node<Integer> node = findBegining(list.getTail().getNext());
		if(node == null)
			System.out.println("The list has no loop");
		else
			System.out.println("The node where the loop begins has value: "+node.getElement());
	}
	
	static Node<Integer> findBegining(Node<Integer> head){
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		//find the meeting point of both the nodes
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast)
				break;
		}
		
		//if there is no meeting point means there is no loop
		if(fast == null || fast.getNext() == null)
			return null;
		
		slow = head;
		//move slow and fast at the same pace now so that they collide 
		while(slow != fast){
			slow = slow.getNext();
			fast = fast.getNext();
		}
		
		//both now point to the start of the loop
		return fast;
	}
	
}
