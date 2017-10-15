package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultiSearchTrieAlternate {

    public static void main(String[] args){
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        MultiSearchTrieAlternate mSTA = new MultiSearchTrieAlternate();
        HashMap<String, ArrayList<Integer>> locations = mSTA.searchAll(big, smalls);
        for(Map.Entry entry : locations.entrySet()){
            System.out.println(entry.getKey() + " -> ");
            if(entry.getValue() != null){
                System.out.println(entry.getValue().toString());
            }
        }
    }

    public HashMap<String, ArrayList<Integer>> searchAll(String big, String[] smalls){
        HashMap<String, ArrayList<Integer>> lookup = new HashMap<String, ArrayList<Integer>>();
        int maxLen = big.length();
        Trie trie = createTrieFromStrings(smalls, maxLen);
        for(int i = 0; i < maxLen; i++){
            ArrayList<String> strings = findStringAtLoc(trie.getRoot(), big, i);
            for(String string : strings){
                if(!lookup.containsKey(string)){
                    lookup.put(string, new ArrayList<Integer>());
                }
                lookup.get(string).add(i);
            }
        }
        return lookup;
    }

    private ArrayList<String> findStringAtLoc(TrieNode root, String big, int start){
        ArrayList<String> strings = new ArrayList<String>();
        int index = start;
        while(index < big.length()){
            root = root.getChild(big.charAt(index));
            if(root == null){
                break;
            }
            if(root.terminates()){
                strings.add(big.substring(start, index + 1));
            }
            index++;
        }
        return strings;
    }

    private Trie createTrieFromStrings(String[] smalls, int maxLen){
        Trie trie = new Trie();
        for(String small : smalls){
            if(small.length() <= maxLen){
                trie.insertString(small, 0);
            }
        }
        return trie;
    }

}