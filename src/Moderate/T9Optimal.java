package Moderate;

import java.util.ArrayList;
import java.util.HashMap;

public class T9Optimal {

    char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args){
        String[] words = {"tree", "used", "cat", "dog"};
        String number = "8733";
        T9Optimal t9O = new T9Optimal();
        HashMap<String, ArrayList<String>> dictionary = t9O.initializeDictionary(words);
        ArrayList<String> results = t9O.lookupWords(number, dictionary);
        System.out.println(results.toString());
    }

    public ArrayList<String> lookupWords(String number, HashMap<String, ArrayList<String>> dictionary){
        return dictionary.get(number);
    }

    public HashMap<String, ArrayList<String>> initializeDictionary(String[] words){
        HashMap<Character, Character> letterToNumberMap = letterToNumberMap();
        HashMap<String, ArrayList<String>> numberToWordsMap = new HashMap<String, ArrayList<String>>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){
                if(letterToNumberMap.containsKey(c)){
                    char digit = letterToNumberMap.get(c);
                    sb.append(digit);
                }
            }
            String number = sb.toString();
            if(numberToWordsMap.containsKey(number)){
                numberToWordsMap.get(number).add(word);
            } else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(word);
                numberToWordsMap.put(number, list);
            }

        }
        return numberToWordsMap;
    }

    private HashMap<Character, Character> letterToNumberMap(){
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < t9Letters.length; i++){
            char[] letters = t9Letters[i];
            if(letters != null){
                for(char letter : letters){
                    map.put(letter, Character.forDigit(i, 10));
                }
            }
        }
        return map;
    }

}