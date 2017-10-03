package StacksAndQueues;

public class FixedMultiStackArray {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStackArray(int stackSize){
		this.stackCapacity = stackSize;
		this.values = new int[numberOfStacks*stackSize];
		this.sizes = new int[numberOfStacks];
	}
	
	public boolean isEmpty(int stackNum){
		return sizes[stackNum] == 0;
	}
	
	public boolean isFull(int stackNum){
		return sizes[stackNum] == stackCapacity;
	}
	
	public void push(int stackNum, int value) throws IllegalStateException{
		if(isFull(stackNum))
			throw new IllegalStateException();
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	public int pop(int stackNum) throws IllegalStateException{
		if(isEmpty(stackNum))
			throw new IllegalStateException();
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}
	
	public int peek(int stackNum) throws IllegalStateException{
		if(isEmpty(stackNum))
			throw new IllegalStateException();
		int topIndex = indexOfTop(stackNum);
		return values[topIndex];
	}
	
	public int indexOfTop(int stackNum){
		int offset = stackNum*stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

}