package LinkedLists;

import LinkedLists.SinglyLinkedList.Node;
/* @author Priyank Agrawal
 * 
 * Date 08/17/2016
 * 
 * sum numbers present in linked lists in reverse order
 * 
 */
public class SumLists {
	
	public static void main(String[] args){
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
		list1.addFirst(7);
		list1.addLast(1);
		list1.addLast(6);		
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
		list2.addFirst(5);
		list2.addLast(9);
		list2.addLast(2);
		
		//print original list 1
		Node<Integer> list1Node = list1.getHead();
		System.out.println("Linked List 1:");
		for(int i=0;i<list1.size();++i){
			System.out.print(list1Node.getElement());
			list1Node = list1Node.getNext();
		}
		//print original list 2
		Node<Integer> list2Node = list2.getHead();
		System.out.println("\nLinked List 2:");
		for(int i=0;i<list2.size();++i){
			System.out.print(list2Node.getElement());
			list2Node = list2Node.getNext();
		}
		
		if(list1.size() == list2.size()){
			//perform addition
			Node<Integer> sumNode = sumLists(list1.getHead(), list2.getHead(), 0);
			//print added list
			System.out.println("\nAdded linked list: ");
			//if sumNode has a null value or not
			if(sumNode == null)
				System.out.println("No addition possible");
			while(sumNode!=null){				
				System.out.print(sumNode.getElement());
				sumNode = sumNode.getNext();				
			}			
		}		
		else
			System.out.println("Size mismatch");//if the user inputed size of both linked lists do not match		
	}
	//recursive technique
	static Node<Integer> sumLists(Node<Integer> list1Node, Node<Integer> list2Node, int carry){
		
		if(list1Node == null && list2Node == null && carry == 0){
			return null;
		}
		
		Node<Integer> resultNode = new Node<Integer>(0, null);
		int value = carry;
		
		if(list1Node != null){
			value += list1Node.getElement();
		}
		if(list2Node != null){
			value += list2Node.getElement();
		}
		
		resultNode.setElement(value%10);
		
		if(list1Node != null || list2Node != null){
			Node<Integer> more = sumLists(list1Node == null ? null : list1Node.getNext(), list2Node == null ? null : list2Node.getNext(), value >=10 ? 1:0);
			resultNode.setNext(more);
		}
		
		return resultNode;
	}

}
