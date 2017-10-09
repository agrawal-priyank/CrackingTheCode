package Moderate;

import java.util.HashMap;

public class WordFrequencies {

    public static void main(String[] args){
        String[] book = {"cat", "dog", "CAT", "dog", "Cat"};
        String word = "cAt";
        WordFrequencies wF = new WordFrequencies();
        HashMap<String, Integer> dictionary = wF.setupDictionary(book);
        System.out.println(wF.getFrequency(word, dictionary));
    }

    public int getFrequency(String word, HashMap<String, Integer> dictionary){
        if(dictionary == null || dictionary.size() == 0 || word == null || word.length() == 0){
            return -1;
        }
        word = word.toLowerCase();
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }
        return 0;
    }

    public HashMap<String, Integer> setupDictionary(String[] book){
        HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
        for(String word : book){
            word = word.toLowerCase();
            if(dictionary.containsKey(word)){
                dictionary.put(word, dictionary.get(word) + 1);
            } else{
                dictionary.put(word, 1);
            }
        }
        return dictionary;
    }

}