package Hard;

public class WordDistances {

    public static void main(String[] args){
        String cat = "cat";
        String dog = "dog";
        String animal = "animal";
        String[] words = {cat, animal, animal, animal, dog, dog, animal, animal, cat, cat, animal, animal, dog};
        WordDistances wD = new WordDistances();
        LocationPair best = wD.findClosestDistance(words, cat, dog);
        System.out.println(best.location1 + " and " + best.location2);
    }

    public LocationPair findClosestDistance(String[] words, String word1, String word2){
        LocationPair best = new LocationPair(-1, -1);
        LocationPair current = new LocationPair(-1, -1);
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                current.location1 = i;
                best.updateWithMin(current);
            } else if(words[i].equals(word2)){
                current.location2 = i;
                best.updateWithMin(current);
            }
        }
        return best;
    }

}