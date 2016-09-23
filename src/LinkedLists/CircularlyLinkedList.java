package LinkedLists;

/**
 * @author Priyank Agrawal
 * 
 * Date 08/22/2016
 * 
 * Implementation of Generic Circularly Linked List
 *
 */
public class CircularlyLinkedList<E> {
	
	//nested node class
	static class Node<E>{
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		public Node(){ }
											//default constructor
		public E getElement() {
			return element;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	private Node<E> tail = null; 			//store the tail and not the head
	private int size = 0;					//number of nodes in the list
	
	public Node<E> getTail() {
		return tail;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}
	
	public CircularlyLinkedList(){ }		//default constructor
	
	//access methods
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public E first(){						//returns but does not remove the first element	
		if(isEmpty()) return null;
		return tail.getNext().getElement();
	}
	
	public E last(){						//returns but does not remove the last element
		if(isEmpty()) return null;
		return tail.getElement();
	}
	
	//update methods
	public void rotate(){					//rotate the first element to the back of the list
		if(tail != null)					//if empty do nothing
			tail = tail.getNext();			//the old head becomes the new tail
	}
	
	public void addFirst(E e){				//adds element e to front of the list
		if(size == 0){
			tail = new Node<>(e, null);
			tail.setNext(tail);				//tail links to itself
		}
		else{
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}
	
	public void addLast(E e){				//adds element e to end of the list
		addFirst(e);						//add element e to the front of the list
		tail = tail.getNext();				//element e is the new tail
	}
	
	public E removeFirst(){					//removes and returns the first element of the list
		if(isEmpty()) return null;			//nothing to remove
		Node<E> head = tail.getNext();		
		if(head == tail) tail = null;		//if only one element then list will be empty now
		else tail.setNext(head.getNext());	//removes head node from the list
		size--;
		return head.getElement();
	}
	
}
