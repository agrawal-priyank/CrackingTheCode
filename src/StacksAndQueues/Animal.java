package StacksAndQueues;

import java.util.LinkedList;

public abstract class Animal {
	private int order;
	protected String name;

	public Animal(String n) {
		this.name = n;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * to check whether the animal (cat or dog) was inserted first compared to other on the basis of their insertion order
	 * @return
	 */
	public boolean isOlderThan(Animal a) {
		return this.getOrder() < a.getOrder();
	}

}

class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
}

class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
}

class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<>();		//consists of dogs
	LinkedList<Cat> cats = new LinkedList<>();		//consists of cats
	private int order = 0;

	public void enqueue(Animal a) {
		a.setOrder(order);					//set the order of the new animal to be added to one of the two queues
		order++;
		if (a instanceof Dog)				//animal is actually a dog
			dogs.addLast((Dog) a);			//add in dogs queue
		else if (a instanceof Cat)			//animal is actually a cat
			cats.addLast((Cat) a);			//add in cats queue
	}

	/**
	 * @return animal either cat or dog based on their order
	 */
	public Animal dequeueAny() {
		if (dogs.isEmpty())					//no dogs then dequeue cat
			return dequeueCat();
		else if (cats.isEmpty())			//no cats then dequeue dog
			return dequeueDog();
		else {
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			if (dog.isOlderThan(cat))		//check whether which one is older if both cats and dogs exists on the basis of their order
				return dequeueDog();
			else
				return dequeueCat();
		}
	}

	public Dog dequeueDog() {
		return dogs.removeFirst();
	}

	public Cat dequeueCat() {
		return cats.removeFirst();
	}

}