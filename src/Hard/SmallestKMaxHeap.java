package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestKMaxHeap {

    public static void main(String[] args){
        int[] arr = {1, 8, 9, 4, 5, 7, 3, 2, 6};
        SmallestKMaxHeap sK = new SmallestKMaxHeap();
        int[] res = sK.smallestK(arr, 7);
        System.out.println(Arrays.toString(res));
    }

    public int[] smallestK(int[] arr, int k){
        if(k <= 0 || k > arr.length){
            return null;
        }
        PriorityQueue<Integer> heap = getMaxHeap(arr, k);
        return maxHeapToArr(heap);
    }

    private PriorityQueue<Integer> getMaxHeap(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new MaxHeapComparator());
        for(int a : arr){
            if(heap.size() < k){
                heap.add(a);
            } else if(a < heap.peek()){
                heap.poll();
                heap.add(a);
            }
        }
        return heap;
    }

    private int[] maxHeapToArr(PriorityQueue<Integer> heap){
        int[] arr = new int[heap.size()];
        while(!heap.isEmpty()){
            arr[heap.size() - 1] = heap.poll();
        }
        return arr;
    }

    private class MaxHeapComparator implements Comparator<Integer>{
        public int compare(Integer x, Integer y){
            return y - x;
        }
    }

}