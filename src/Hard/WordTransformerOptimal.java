package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordTransformerOptimal {

    public static void main(String[] args){
        String start = "tree", stop = "flat";
        String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat",
                "trap", "fret", "trip", "trie", "frat", "fril"};
        WordTransformerOptimal wTO = new WordTransformerOptimal();
        LinkedList<String> path = wTO.findPath(start, stop, words);
        for(String s : path){
            System.out.print(" -> " + s);
        }
    }

    public LinkedList<String> findPath(String start, String stop, String[] words){
        HashMap<String, ArrayList<String>> wildcardToWords = createWildcardToWordMap(words);
        HashSet<String> visited = new HashSet<String>();
        return transform(start, stop, visited, wildcardToWords);
    }

    private LinkedList<String> transform(String start, String stop, HashSet<String> visited,
                                         HashMap<String, ArrayList<String>> wildcardToWords){
        if(start.equals(stop)){
            LinkedList<String> path = new LinkedList<String>();
            path.add(start);
            return path;
        } else if(visited.contains(start)){
            return null;
        }
        visited.add(start);
        ArrayList<String> linkedWords = getValidLinkedWords(start, wildcardToWords);
        for(String word : linkedWords){
            LinkedList<String> path = transform(word, stop, visited, wildcardToWords);
            if(path != null){
                path.addFirst(start);
                return path;
            }
        }
        return null;
    }

    private HashMap<String, ArrayList<String>> createWildcardToWordMap(String[] words){
        HashMap<String, ArrayList<String>> wildcardToWords = new HashMap<String, ArrayList<String>>();
        for(String word : words){
            ArrayList<String> wildcards = getWildcards(word);
            for(String wildcard : wildcards){
                if(!wildcardToWords.containsKey(wildcard)){
                    wildcardToWords.put(wildcard, new ArrayList<String>());
                }
                wildcardToWords.get(wildcard).add(word);
            }
        }
        return wildcardToWords;
    }

    private ArrayList<String> getWildcards(String word){
        ArrayList<String> wildcards = new ArrayList<String>();
        for(int i = 0; i < word.length(); i++){
            String wildcard = word.substring(0, i) + "_" + word.substring(i + 1);
            wildcards.add(wildcard);
        }
        return wildcards;
    }

    private ArrayList<String> getValidLinkedWords(String word, HashMap<String, ArrayList<String>> wildcardToWords){
        ArrayList<String> linkedWords = new ArrayList<String>();
        ArrayList<String> wildcards = getWildcards(word);
        for(String wildcard : wildcards){
            ArrayList<String> words = wildcardToWords.get(wildcard);
            for(String linkedWord : words){
                if(!linkedWord.equals(word)){
                    linkedWords.add(linkedWord);
                }
            }
        }
        return linkedWords;
    }

}