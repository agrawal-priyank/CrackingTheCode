package Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestSupersequenceOptimal {

    public static void main(String[] args){
        int[] bigArr = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7};
        int[] smallArr = {1, 5, 9};
        ShortestSupersequenceOptimal s = new ShortestSupersequenceOptimal();
        Range best = s.getShortestSupersequence(bigArr, smallArr);
        if(best != null){
            System.out.println(best.getStart() + " " + best.getEnd());
        }
    }

    public Range getShortestSupersequence(int[] bigArr, int[] smallArr){
        ArrayList<Queue<Integer>> locations = getAllLocations(bigArr, smallArr);
        if(locations == null){
            return null;
        }
        return getShortestClosure(locations);
    }

    private ArrayList<Queue<Integer>> getAllLocations(int[] bigArr, int[] smallArr){
        ArrayList<Queue<Integer>> list = new ArrayList<Queue<Integer>>();
        for(int i = 0; i < smallArr.length; i++){
            Queue<Integer> locations = getLocations(bigArr, smallArr[i]);
            if(locations.size() == 0){
                return null;
            }
            list.add(locations);
        }
        return list;
    }

    private Queue<Integer> getLocations(int[] bigArr, int value){
        Queue<Integer> locations = new LinkedList<Integer>();
        for(int i = 0; i < bigArr.length; i++){
            if(bigArr[i] == value){
                locations.add(i);
            }
        }
        return locations;
    }

    private Range getShortestClosure(ArrayList<Queue<Integer>> lists){
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < lists.size(); i++){
            int head = lists.get(i).remove();
            minHeap.add(new HeapNode(head, i));
            max = Math.max(max, head);
        }
        int min = minHeap.peek().locationWithinList;
        int bestRangeMin = min;
        int bestRangeMax = max;
        while(true){
            HeapNode n = minHeap.poll();
            Queue<Integer> list = lists.get(n.listId);
            min = n.locationWithinList;
            if(max - min < bestRangeMax - bestRangeMin){
                bestRangeMax = max;
                bestRangeMin = min;
            }
            if(list.size() == 0){
                break;
            }
            n.locationWithinList = list.remove();
            minHeap.add(n);
            max = Math.max(max, n.locationWithinList);
        }
        return new Range(bestRangeMin, bestRangeMax);
    }

}