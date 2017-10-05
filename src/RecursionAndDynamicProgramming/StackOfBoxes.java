package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {

    // With Memoization
    public int createStackMemo(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        int[] stackMap = new int[boxes.size()];
        for(int i = 0; i < boxes.size(); i++){
            int height = createStackMemo(boxes, i, stackMap);
            maxHeight = Math.max(height, maxHeight);
        }
        return maxHeight;
    }

    private int createStackMemo(ArrayList<Box> boxes, int bottomIndex, int[] memo){
        if(bottomIndex < boxes.size() && memo[bottomIndex] > 0){
            return memo[bottomIndex];
        }
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for(int i = bottomIndex + 1; i < boxes.size(); i++){
            if(boxes.get(i).canBeAbove(bottom)){
                int height = createStackMemo(boxes, i, memo);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        memo[bottomIndex] = maxHeight;
        return maxHeight;
    }
    // End

    // No Memoization
    public int createStack(ArrayList<Box> boxes){
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        for(int i = 0; i < boxes.size(); i++){
            int height = createStack(boxes, i);
            maxHeight = Math.max(height, maxHeight);
        }
        return maxHeight;
    }

    private int createStack(ArrayList<Box> boxes, int bottomIndex){
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for(int i = bottomIndex + 1; i < boxes.size(); i++){
            if(boxes.get(i).canBeAbove(bottom)){
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        return maxHeight;
    }
    // End

    public class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box b1, Box b2){
            return b2.height - b1.height;
        }
    }

}