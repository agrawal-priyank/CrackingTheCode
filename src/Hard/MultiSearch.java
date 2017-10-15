package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultiSearch {

    public static void main(String[] args){
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        MultiSearch mS = new MultiSearch();
        HashMap<String, ArrayList<Integer>> locations = mS.searchAll(big, smalls);
        for(Map.Entry entry : locations.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue().toString());
        }
    }

    public HashMap<String, ArrayList<Integer>> searchAll(String big, String[] smalls){
        HashMap<String, ArrayList<Integer>> lookup = new HashMap<String, ArrayList<Integer>>();
        for(String small : smalls){
            ArrayList<Integer> locations = search(big, small);
            lookup.put(small, locations);
        }
        return lookup;
    }

    private ArrayList<Integer> search(String big, String small){
        ArrayList<Integer> locations = new ArrayList<Integer>();
        for(int i = 0; i < big.length() - small.length() + 1; i++){
            if(isSubstringAtIndex(big, small, i)){
                locations.add(i);
            }
        }
        return locations;
    }

    private boolean isSubstringAtIndex(String big, String small, int offset){
        for(int i = 0; i < small.length(); i++){
            if(big.charAt(offset + i) != small.charAt(i)){
                return false;
            }
        }
        return true;
    }

}