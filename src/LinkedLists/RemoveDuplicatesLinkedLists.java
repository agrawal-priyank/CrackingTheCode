package LinkedLists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import LinkedLists.SinglyLinkedList.Node;
//removing duplicates from a singly/singularly linked list with hash-set as a buffer
//time complexity is O(n)
//space complexity is O(n)
public class RemoveDuplicatesLinkedLists {
	
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
		System.out.println("Before size of Linked list: \n"+list.size());
		HashSet<Integer> set = new HashSet<>();
		removeDups(list, set);
		System.out.println("Linked list after removing duplicates: ");
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("After size: \n"+set.size());
	}

	static HashSet<Integer> removeDups(SinglyLinkedList<Integer> list, HashSet<Integer> set){
		if(list.size() <= 0){
			return null;
		}
		Node<Integer> node = list.getHead();
		while(node.getNext() != null){
			//add only those elements that are new to the set
			if(set.contains(node.getElement())){
				//remove duplicates from list or do not add them to the set
			}
			else{
				set.add(node.getElement());
			}
			node = node.getNext();
		}
		return set;
	}

}
