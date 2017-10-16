package Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class WordTransformer {

    public static void main(String[] args){
        String start = "tree", stop = "flat";
        String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat",
                "trap", "fret", "trip", "trie", "frat", "fril"};
        WordTransformer wT = new WordTransformer();
        LinkedList<String> path = wT.findPath(start, stop, words);
        for(String s : path){
            System.out.print(" -> " + s);
        }
    }

    public LinkedList<String> findPath(String start, String stop, String[] words){
        HashSet<String> dictionary = setupDictionary(words);
        HashSet<String> visited = new HashSet<String>();
        return transform(start, stop, dictionary, visited);
    }

    private HashSet<String> setupDictionary(String[] words){
        HashSet<String> dictionary = new HashSet<String>();
        for(String word : words){
            dictionary.add(word.toLowerCase());
        }
        return dictionary;
    }

    private LinkedList<String> transform(String startWord, String stopWord,
                                         HashSet<String> dictionary, HashSet<String> visited){
        if(startWord.equalsIgnoreCase(stopWord)){
            LinkedList<String> path = new LinkedList<String>();
            path.add(startWord);
            return path;
        } else if(visited.contains(startWord) || !dictionary.contains(startWord)){
            return null;
        }
        visited.add(startWord);
        ArrayList<String> words = wordsOneAway(startWord);
        for(String word : words){
            LinkedList<String> path = transform(word, stopWord, dictionary, visited);
            if(path != null){
                path.addFirst(startWord);
                return path;
            }
        }
        return null;
    }

    private ArrayList<String> wordsOneAway(String word){
        ArrayList<String> words = new ArrayList<String>();
        for(int i = 0; i < word.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                String w = word.substring(0, i) + c + word.substring(i + 1);
                words.add(w);
            }
        }
        return words;
    }

}