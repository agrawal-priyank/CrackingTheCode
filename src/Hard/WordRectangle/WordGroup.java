package Hard.WordRectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class WordGroup {

    private ArrayList<String> group = new ArrayList<String>();
    private HashMap<String, Boolean> lookup = new HashMap<String, Boolean>();

    public void addWord(String word){
        group.add(word);
        lookup.put(word, true);
    }

    public String getWord(int i){
        return group.get(i);
    }

    public ArrayList<String> getWords(){
        return group;
    }

    public boolean containsWord(String word){
        return lookup.containsKey(word);
    }

    public int length(){
        return group.size();
    }

    public static WordGroup[] createWordGroups(String[] list){
        WordGroup[] groupList;
        int maxWordLength = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i].length() > maxWordLength){
                maxWordLength = list[i].length();
            }
        }
        groupList = new WordGroup[maxWordLength];
        for(int i = 0; i < list.length; i++){
            int wordLength = list[i].length() - 1;
            if(groupList[wordLength] == null){
                groupList[wordLength] = new WordGroup();
            }
            groupList[wordLength].addWord(list[i]);
        }
        return groupList;
    }

}