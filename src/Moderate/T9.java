package Moderate;

import java.util.ArrayList;
import java.util.HashSet;

public class T9 {

    char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args){
        String number = "8733";
        HashSet<String> wordList = new HashSet<String>();
        wordList.add("tree");
        wordList.add("used");
        wordList.add("cat");
        wordList.add("dog");
        T9 t9 = new T9();
        ArrayList<String> words = t9.getValidT9Words(number, wordList);
        System.out.println(words.toString());
    }

    public ArrayList<String> getValidT9Words(String number, HashSet<String> wordList){
        ArrayList<String> words = new ArrayList<String>();
        getValidWords(number, 0, "", wordList, words);
        return words;
    }

    private void getValidWords(String number, int index, String prefix, HashSet<String> wordList,
                               ArrayList<String> words){
        if(index == number.length()){
            if(wordList.contains(prefix)){
                words.add(prefix);
            }
            return;
        }
        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);if(letters != null){
            for(char letter : letters){
                getValidWords(number, index + 1, prefix + letter, wordList, words);
            }
        }
    }

    private char[] getT9Chars(char c){
        if(!Character.isDigit(c)){
            return null;
        }
        int digit = Character.getNumericValue(c) - Character.getNumericValue('0');
        return t9Letters[digit];
    }

}