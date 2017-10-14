package Hard;

import java.util.LinkedList;
import java.util.Queue;

public class KthMultipleAlternate {

    public static void main(String[] args){
        int k = 5;
        KthMultipleAlternate kMA = new KthMultipleAlternate();
        System.out.println(kMA.getKthNumber(k));
    }

    public int getKthNumber(int k) {
        if (k < 0) {
            return 0;
        }
        int val = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        addToQueue(q, val);
        for(int i = 0; i < k; i++){
            val = removeMin(q);
            addToQueue(q, val);
        }
        return val;
    }

    private void addToQueue(Queue<Integer> q, int i){
        q.add(3 * i);
        q.add(5 * i);
        q.add(7 * i);
    }

    private int removeMin(Queue<Integer> q){
        int min = q.peek();
        for(Integer i : q){
            if(min > i){
                min = i;
            }
        }
        while(q.contains(min)){
            q.remove(min);
        }
        return min;
    }

}