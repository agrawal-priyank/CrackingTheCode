package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxesOptimal {

    public int createStack(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        int[] memo = new int[boxes.size()];
        return createStack(boxes, null, 0, memo);
    }

    public int createStack(ArrayList<Box> boxes, Box bottom, int index, int[] memo){
        if(index >= boxes.size()){
            return 0;
        }
        Box newBottom = boxes.get(index);
        int heightWithBottom = 0;
        if(bottom == null || newBottom.canBeAbove(bottom)){
            if(memo[index] == 0){
                memo[index] = createStack(boxes, newBottom, index + 1, memo);
                memo[index] += newBottom.height;
            }
            heightWithBottom = memo[index];

        }
        int heightWithoutBottom = createStack(boxes, bottom, index + 1, memo);
        return Math.max(heightWithoutBottom, heightWithBottom);
    }

    public class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box b1, Box b2){
            return b2.height - b1.height;
        }
    }

}