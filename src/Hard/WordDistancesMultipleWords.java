package Hard;

import java.util.ArrayList;
import java.util.HashMap;

public class WordDistancesMultipleWords {

    public static void main(String[] args){
        String cat = "cat";
        String dog = "dog";
        String animal = "animal";
        String[] words = {cat, animal, animal, animal, dog, dog, animal, animal, cat, cat, animal, animal, dog};
        WordDistancesMultipleWords w = new WordDistancesMultipleWords();
        LocationPair best = w.findClosestDistance(words, cat, dog);
        System.out.println(best.location1 + " and " + best.location2);
    }

    public LocationPair findClosestDistance(String[] words, String word1, String word2){
        HashMap<String, ArrayList<Integer>> locations = getWordLocations(words);
        ArrayList<Integer> locations1 = locations.get(word1);
        ArrayList<Integer> locations2 = locations.get(word2);
        return findClosestDistanceBetweenPair(locations1, locations2);
    }

    private LocationPair findClosestDistanceBetweenPair(ArrayList<Integer> arr1,
                                                        ArrayList<Integer> arr2){
        if(arr1 == null || arr2 == null || arr1.size() == 0 || arr2.size() == 0){
            return null;
        }
        LocationPair current = new LocationPair(arr1.get(0), arr2.get(0));
        LocationPair best = new LocationPair(arr1.get(0), arr2.get(0));
        int index1 = 1, index2 = 1;
        while(index1 < arr1.size() && index2 < arr2.size()){
            current.setLocation(arr1.get(index1),arr2.get(index2));
            best.updateWithMin(current);
            if(arr1.get(index1) < arr2.get(index2)){
                index1++;
            } else{
                index2++;
            }
        }
        return best;
    }

    private HashMap<String, ArrayList<Integer>> getWordLocations(String[] words){
        HashMap<String, ArrayList<Integer>> locations = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(!locations.containsKey(words[i])){
                locations.put(words[i], new ArrayList<Integer>());
            }
            locations.get(words[i]).add(i);
        }
        return locations;
    }

}