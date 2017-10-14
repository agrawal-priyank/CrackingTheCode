package Hard;

import java.util.ArrayList;
import java.util.Collections;

public class CircusTowerOptimal {

    public static void main(String[] args){
        ArrayList<HTWT> list = initialize();
        CircusTowerOptimal cTO = new CircusTowerOptimal();
        ArrayList<HTWT> seq = cTO.findLongestIncreasingSeq(list);
        for(HTWT person : seq){
            System.out.println(person.toString());
        }

    }

    public ArrayList<HTWT> findLongestIncreasingSeq(ArrayList<HTWT> array){
        Collections.sort(array);
        ArrayList<ArrayList<HTWT>> solutions = new ArrayList<ArrayList<HTWT>>();
        ArrayList<HTWT> bestSequence = null;
        for(int i = 0; i < array.size(); i++){
            ArrayList<HTWT> longestAtIndex = bestSequenceAtIndex(array, solutions, i);
            solutions.add(longestAtIndex);
            bestSequence = max(longestAtIndex, bestSequence);
        }
        return bestSequence;
    }

    private ArrayList<HTWT> bestSequenceAtIndex(ArrayList<HTWT> array, ArrayList<ArrayList<HTWT>> solutions, int index){
        HTWT value = array.get(index);
        ArrayList<HTWT> bestSequence = new ArrayList<HTWT>();
        for(int i = 0; i < index; i++){
            ArrayList<HTWT> solution = solutions.get(i);
            if(canAppend(solution, value)){
                bestSequence = max(solution, bestSequence);
            }
        }
        ArrayList<HTWT> best = (ArrayList<HTWT>)bestSequence.clone();
        best.add(value);
        return best;
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

    private ArrayList<HTWT> max(ArrayList<HTWT> seq1, ArrayList<HTWT> seq2){
        if(seq1 == null){
            return seq2;
        } else if(seq2 == null){
            return seq1;
        } else{
            return seq1.size() > seq2.size() ? seq1 : seq2;
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