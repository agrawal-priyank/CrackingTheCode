package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultiSearchTrie {

    public static void main(String[] args){
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        MultiSearchTrie mST = new MultiSearchTrie();
        HashMap<String, ArrayList<Integer>> locations = mST.searchAll(big, smalls);
        for(Map.Entry entry : locations.entrySet()){
            System.out.println(entry.getKey() + " -> ");
            if(entry.getValue() != null){
                System.out.println(entry.getValue().toString());
            }
        }
    }

    public HashMap<String, ArrayList<Integer>> searchAll(String big, String[] smalls){
        HashMap<String, ArrayList<Integer>> lookup = new HashMap<String, ArrayList<Integer>>();
        Trie trie = createTrieFromString(big);
        for(String small : smalls){
            ArrayList<Integer> locations = trie.search(small);
            subtractValue(locations, small.length());
            lookup.put(small, locations);
        }
        return lookup;
    }

    private Trie createTrieFromString(String s){
        Trie trie = new Trie();
        for(int i = 0; i < s.length(); i++){
            String suffix = s.substring(i);
            trie.insertString(suffix, i);
        }
        return trie;
    }

    void subtractValue(ArrayList<Integer> locations, int delta){
        if(locations == null){
            return;
        }
        for(int i = 0; i < locations.size(); i++){
            locations.set(i, locations.get(i) - delta);
        }
    }

}