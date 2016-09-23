package LinkedLists;

import java.util.Scanner;

import LinkedLists.SinglyLinkedList.Node;

public class PartitionListWithNewLists {
	
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
	
	//making two new lists and merging them if necessary
	static Node<Integer> partition(Node<Integer> head, int k){		
		//consist of list smaller than partition element
		SinglyLinkedList<Integer> listBefore = new SinglyLinkedList<>();
		//consist of element equal to partition element and greater than it
		SinglyLinkedList<Integer> listAfter = new SinglyLinkedList<>();
		if(head == null) return null;
		Node<Integer> node = head;
		while(node != null){
			//if node element is less place it in listBefore
			if(node.getElement() < k){
				if(listBefore.size() == 0){
					listBefore.addFirst(node.getElement());
				}
				else{
					listBefore.addLast(node.getElement());
				}
			}
			//if node element is equal to partition element place it in listAfter's head so this list is never null
			else if(node.getElement() == k){
				listAfter.addFirst(node.getElement());
			}
			//if node element is greater place it in listAfter
			else{
				if(listAfter.size() == 0){
					listAfter.addFirst(node.getElement());
				}
				else{
					listAfter.addLast(node.getElement());
				}
			}
			node = node.getNext();
		}
		//if partitioning element is smallest so listBefore will never have any element
		if(listBefore.size() == 0){
			return listAfter.getHead();
		}
		//merging both lists
		listBefore.getTail().setNext(listAfter.getHead());
		return listBefore.getHead();
	}

}
