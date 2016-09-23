package LinkedLists;

import java.util.Scanner;

import LinkedLists.SinglyLinkedList.Node;
//runner technique with no buffer
//time complexity is O(n^2)
//space complexity is O(1)
public class RemoveDupsLinkedListRunner {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the linked list: ");
		int n = scan.nextInt();
		if(n<=0){
			System.out.println("Enter valid size: ");
			n = scan.nextInt();
		}
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		System.out.println("Enter the elements of the linked list: ");
		for(int i=0;i<n;++i){
			if(list.size() == 0){
				list.addFirst(scan.nextInt());
			}
			else{
				list.addLast(scan.nextInt());
			}
		}
		scan.close();
		deleteDups(list);
		System.out.println("Linked list after removing duplicates: ");
		Node<Integer> node = list.getHead();
		while(node != null){
			System.out.print(node.getElement()+" ");
			node = node.getNext();
		}

	}
	
	static SinglyLinkedList<Integer> deleteDups(SinglyLinkedList<Integer> list){
		if(list.size() <= 0){
			return null;
		}
		
		Node<Integer> currentNode = list.getHead();
		
		while(currentNode != null){					
			Node<Integer> runner = currentNode;
			
			while(runner.getNext() != null){
				if(currentNode.getElement() == runner.getNext().getElement()){
					if(runner.getNext().getNext() == null){
						runner.setNext(null);
					}
					else{
						runner.setNext(runner.getNext().getNext());
					}
				}
				else{
					runner = runner.getNext();
				}				
			}
			
			currentNode = currentNode.getNext();			
		}
		return list;
	}

}
