package Hard.WordRectangle;

import java.util.ArrayList;

public class WordRectangle {

    private WordGroup[] groupList;
    private int maxWordLength;
    private Trie[] trieList;

    public static void main(String[] args){
        String[] list = WordList.getListOfWords();
        WordRectangle wR = new WordRectangle(list);
        Rectangle rect = wR.maxRectangle();
        if(rect != null){
            for(int i = 0; i < rect.height; i++){
                for(int j = 0; j < rect.length; j++){
                    System.out.print(rect.matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else{
            System.out.println("No rectangle found!");
        }
    }

    public WordRectangle(String[] list){
        groupList = WordGroup.createWordGroups(list);
        maxWordLength = groupList.length;
        trieList = new Trie[maxWordLength];
    }

    public Rectangle maxRectangle(){
        int maxSize = maxWordLength * maxWordLength;
        for(int z = maxSize; z >= 1; z--){
            for(int i = 1; i <= maxWordLength; i++){
                if(z % i == 0){
                    int j = z / i;
                    if(j <= maxWordLength){
                        Rectangle rectangle = makeRectangle(i, j);
                        if(rectangle != null){
                            return rectangle;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Rectangle makeRectangle(int length, int height){
        if(groupList[length - 1] == null || groupList[height - 1] == null){
            return null;
        }
        if(trieList[height- 1] == null){
            ArrayList<String> words = groupList[height - 1].getWords();
            trieList[height - 1] = new Trie(words);
        }
        return makePartialRectangle(length, height, new Rectangle(length));
    }

    public Rectangle makePartialRectangle(int l, int h, Rectangle rectangle){
        if(rectangle.height == h){
            if(rectangle.isComplete(l, h, groupList[h - 1])){
                return rectangle;
            }
            return null;
        }
        if(!rectangle.isPartialComplete(l, trieList[h - 1])){
            return null;
        }
        for(int i = 0; i < groupList[l - 1].length(); i++){
            Rectangle newRect = rectangle.append(groupList[l - 1].getWord(i));
            Rectangle rect = makePartialRectangle(l, h, newRect);
            if(rect != null){
                return rect;
            }
        }
        return null;
    }

}