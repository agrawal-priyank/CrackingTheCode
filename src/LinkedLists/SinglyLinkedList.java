package LinkedLists;

public class SinglyLinkedList<E> { //generic framework as node can hold data of any type
	//nested node class
	static class Node<E>{
		private E element;
		private Node<E> next;	
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		public Node(){
			//
		}
		public E getElement(){
			return element;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setNext(Node<E> n){
			next = n;
		}
	}
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	public SinglyLinkedList(){}
	//access methods
	public Node<E> getHead() {
		return head;
	}
	public Node<E> getTail() {
		return tail;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public E first(){
		if(isEmpty()) return null;
		return head.getElement();
	}
	public E last(){
		if(isEmpty()) return null;
		return tail.getElement();
	}
	//update methods
	public void addFirst(E e){
		head = new Node<>(e, head);
		if(size==0){
			tail = head;
		}
		size++;		
	}
	public void addLast(E e){
		Node<E> newest = new Node<>(e,null);
		if(isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;		
	}
	public E removeFirst(){
		if(isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if(size == 0)
			tail = null;
		return answer;
	}
	/*//sample initialization
	public static void main(String[] args){
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		System.out.println("Linked list size: "+list.size());
		System.out.println("First element: "+list.first());
		System.out.println("Last element: "+list.last());
		list.removeFirst();
		System.out.println("New first element: "+list.first());
		list.addLast(0);
		System.out.println("New last element: "+list.last());
		System.out.println("Head node element: "+list.getHead().getElement());
		System.out.println("Tail node element: "+list.getTail().getElement());
		System.out.println("Linked list size: "+list.isEmpty());
	}*/
	
}
