package LinkedLists;

import LinkedLists.SinglyLinkedList.Node;

public class IntersectionList {
	
	static class Result{
		private Node<Integer> tail;
		private int size;
		public Result(Node<Integer> t, int s){
			tail = t;
			size = s;
		}		
	}
	
	public static void main(String[] args){
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
		list1.addFirst(9);
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
		list2.addFirst(9);
		list2.addLast(1);
		list2.addLast(2);
		list2.addLast(3);
		
		Node<Integer> intNode = findIntersection(list1, list2);
		if(intNode == null)
			System.out.println("Lists do not intersect each other");
		else
			System.out.println("The intersecting node between lists is: "+intNode.getElement());	
	}
	
	
	static Node<Integer> findIntersection(SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2){
		if(list1.isEmpty() || list2.isEmpty()) return null;
		
		//get tail and sizes of both the list
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);
		
		//if the tails of both lists do not match each other means they do not intersect
		if(result1.tail != result2.tail) return null;
		
		//set the node pointer to start both the short and long list
		Node<Integer> shorter = result1.size < result2.size ? list1.getHead() : list2.getHead();
		Node<Integer> longer = result1.size < result2.size ? list2.getHead() : list1.getHead();
		
		//advance the pointer of the longer list on the basis of difference between sizes of both the list
		longer = getKthNode(longer, Math.abs(list1.size()-list2.size()));
		
		//exit the loop when nodes of both list match each other
		while(shorter != longer){
			shorter = shorter.getNext();
			longer = longer.getNext();
		}
		
		//return either of the list node
		return longer;
	}
	
	
	/**
	 * @return node after advancing it till the size difference of both the lists if any
	 */
	static Node<Integer> getKthNode(Node<Integer> node, int k){
		Node<Integer> current = node;
		while(k > 0 && current != null){
			current = current.getNext();
			k--;
		}
		return current;
	}
	
	/**
	 * @return the tail and size of the list
	 */
	static Result getTailAndSize(SinglyLinkedList<Integer> list){
		if(list.isEmpty()) return null;
		int size = 1;
		Node<Integer> current = list.getHead();
		while(current.getNext() != null){
			size++;
			current = current.getNext();
		}
		return new Result(current, size); 
	}

}
