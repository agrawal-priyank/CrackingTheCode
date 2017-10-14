package Hard;

import java.util.ArrayList;
import java.util.Collections;

public class CircusTower {

    public static void main(String[] args){
        ArrayList<HTWT> list = initialize();
        CircusTower cT = new CircusTower();
        ArrayList<HTWT> seq = cT.findLongestIncreasingSeq(list);
        for(HTWT person : seq){
            System.out.println(person.toString());
        }

    }

    public ArrayList<HTWT> findLongestIncreasingSeq(ArrayList<HTWT> list){
        Collections.sort(list);
        return bestSequence(list, new ArrayList<HTWT>(), 0);
    }

    private ArrayList<HTWT> bestSequence(ArrayList<HTWT> list, ArrayList<HTWT> sequence, int index){
        if(index >= list.size()){
            return sequence;
        }
        HTWT value = list.get(index);
        ArrayList<HTWT> bestWith = null;
        if(canAppend(sequence, value)){
            ArrayList<HTWT> sequenceWith = (ArrayList<HTWT>)sequence.clone();
            sequenceWith.add(value);
            bestWith = bestSequence(list, sequenceWith, index + 1);
        }
        ArrayList<HTWT> bestWithout = bestSequence(list, sequence, index + 1);
        if(bestWith == null || bestWithout.size() > bestWith.size()){
            return bestWithout;
        } else{
            return bestWith;
        }
    }

    private boolean canAppend(ArrayList<HTWT> solution, HTWT value){
        if(solution == null){
            return false;
        } else if(solution.size() == 0){
            return true;
        } else{
            HTWT last = solution.get(solution.size() - 1);
            return last.isBefore(value);
        }
    }

    public static ArrayList<HTWT> initialize() {
        ArrayList<HTWT> items = new ArrayList<HTWT>();

        HTWT item = new HTWT(65, 60);
        items.add(item);

        item = new HTWT(70, 150);
        items.add(item);

        item = new HTWT(56, 90);
        items.add(item);

        item = new HTWT(75, 190);
        items.add(item);

        item = new HTWT(60, 95);
        items.add(item);

        item = new HTWT(68, 110);
        items.add(item);

        item = new HTWT(35, 65);
        items.add(item);

        item = new HTWT(40, 60);
        items.add(item);

        item = new HTWT(45, 63);
        items.add(item);

        return items;
    }

}