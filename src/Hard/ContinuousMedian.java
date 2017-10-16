package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {

    private static PriorityQueue<Integer> minHeap;
    private static PriorityQueue<Integer> maxHeap;

    public static void main(String[] args){
        int[] nums = {3, 13, 7, 5, 21, 23, 39, 23, 40, 23, 14, 12, 56, 23, 29};
        minHeap = new PriorityQueue<Integer>(new MinHeapComparator());
        maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        for(int i = 0; i < nums.length; i++){
            addAndPrintMedian(nums[i]);
        }
    }

    public static void addAndPrintMedian(int number){
        addNewNumber(number);
        System.out.println(getMedian());
    }

    private static void addNewNumber(int number){
        if(minHeap.size() == maxHeap.size()){
            if(minHeap.peek() != null && number > minHeap.peek()){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(number);
            } else{
                maxHeap.offer(number);
            }
        } else{
            if(number < maxHeap.peek()){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(number);
            } else{
                minHeap.offer(number);
            }
        }
    }

    private static double getMedian(){
        if(maxHeap.size() == 0){
            return 0;
        }
        if(minHeap.size() == maxHeap.size()){
            return ((double)minHeap.peek() + (double)maxHeap.peek())/2;
        } else{
            return (double)maxHeap.peek();
        }
    }

    private static class MaxHeapComparator implements Comparator<Integer>{
        public int compare(Integer i1, Integer i2){
            if(i1 > i2){
                return -1;
            } else if(i1 < i2){
                return 1;
            } else{
                return 0;
            }
        }
    }

    private static class MinHeapComparator implements Comparator<Integer>{
        public int compare(Integer i1, Integer i2){
            if(i1 > i2){
                return 1;
            } else if(i1 < i2){
                return -1;
            } else{
                return 0;
            }
        }
    }

}