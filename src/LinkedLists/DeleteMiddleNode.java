package LinkedLists;

import java.util.Scanner;

import LinkedLists.SinglyLinkedList.Node;

public class DeleteMiddleNode {
	
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
		System.out.println("Enter the element number to delete: ");
		int number = scan.nextInt();
		if(number>=list.size()){
			System.out.println("Invalid! Try lesser number: ");
			number = scan.nextInt();
		}
		scan.close();
		Node<Integer> node = list.getHead();
		for(int i=0;i<number-1;++i){
			node = node.getNext();
		}
		boolean result = deleteNode(node);
		if(result == true){
			Node<Integer> newNode = list.getHead();
			System.out.println("The new linked list: ");
			while(newNode != null){
				System.out.print(newNode.getElement() +" ");
				newNode = newNode.getNext();
			}			
		}
		else{
			System.out.println("Operation failed");
		}
	}
	
	static boolean deleteNode(Node<Integer> node){
		if(node == null){
			return false;
		}
		Node<Integer> nextNode = node.getNext();
		node.setElement(nextNode.getElement());
		node.setNext(nextNode.getNext());
		return true;
	}
	
}
