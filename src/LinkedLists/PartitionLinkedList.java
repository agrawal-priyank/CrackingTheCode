package LinkedLists;

import java.util.Scanner;

import LinkedLists.SinglyLinkedList.Node;

public class PartitionLinkedList {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of elements in the linked list: ");
		int n = scan.nextInt();
		if(n<=0){
			System.out.println("Enter valid size: ");
			n = scan.nextInt();
		}
		System.out.println("Enter the elements of the linked list: ");
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		for(int i=0;i<n;++i){
			if(list.size() == 0){
				list.addFirst(scan.nextInt());
			}
			else{
				list.addLast(scan.nextInt());
			}
		}
		System.out.println("Enter the element to partition linked list with: ");
		int k = scan.nextInt();
		scan.close();
		Node<Integer> head = list.getHead();
		Node<Integer> node = partition(head, k);
		System.out.println("The partitioned linked list: ");
		while(node != null){
			System.out.print(node.getElement()+" ");
			node = node.getNext();
		}
	}
	
	static Node<Integer> partition(Node<Integer> node, int k){
		Node<Integer> head = node;
		Node<Integer> tail = node;
		while(node != null){
			Node<Integer> next = node.getNext();
			if(node.getElement() < k){
				node.setNext(head);
				head = node;
			}
			else{
				tail.setNext(node);
				tail = node;
			}
			node = next;
		}
		tail.setNext(null);
		return head;
	}
	
}
