package LinkedLists;

import java.util.Scanner;

import LinkedLists.SinglyLinkedList.Node;

public class ReturnKthElementLinkedList {
	
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
		System.out.println("Enter the element to find from last: ");
		int k = scan.nextInt();
		if(k>=list.size()){
			System.out.println("Invalid index! Try again: ");
			k = scan.nextInt();
		}
		scan.close();
		Node<Integer> head = list.getHead();
		returnKthElement(head, k);
		System.out.println("Iterative approach: "+kthToLast(head, k));
	}
	//recursive approach
	//time complexity is O(n^2)
	static int returnKthElement(Node<Integer> head, int k){		
		if(head == null){
			return 0;
		}
		int index = returnKthElement(head.getNext(), k) + 1;
		if(index == k){
			System.out.println("Recursive approach: "+head.getElement());
		}
		return index;
	}
	//iterative approach using two pointers
	//time complexity is O(n)
	//space complexity is O(1)
	static int kthToLast(Node<Integer> head, int k){
		Node<Integer> p1 = head;
		Node<Integer> p2 = head;
		//move p1 k nodes ahead in the list
		for(int i=0;i<k;++i){
			if(p1 == null) return 0;
			p1 = p1.getNext();
		}
		while(p1 != null){
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		
		return p2.getElement();
	}

}
