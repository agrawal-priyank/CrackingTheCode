package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BabyNames {

    public static void main(String[] args){
        HashMap<String, Integer> names = new HashMap<String, Integer>();
        names.put("John", 3);
        names.put("Jonathan", 4);
        names.put("Johnny", 5);
        names.put("Chris", 1);
        names.put("Kris", 3);
        names.put("Brian", 2);
        names.put("Bryan", 4);
        names.put("Carleton", 4);

        String[][] synonyms = {{"John", "Jonathan"},
                               {"Jonathan", "Johnny"},
                               {"Chris", "Kris"},
                               {"Brian", "Bryan"}};

        BabyNames bN = new BabyNames();
        HashMap<String, Integer> map = bN.trulyMostPopular(names, synonyms);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms){
        HashMap<String, NameSet> groups = constructGroups(names);
        mergeNames(groups, synonyms);
        return convertToMap(groups);
    }

    private void mergeNames(HashMap<String, NameSet> groups, String[][] synonyms){
        for(String[] entry : synonyms){
            String name1 = entry[0];
            String name2 = entry[1];
            NameSet set1 = groups.get(name1);
            NameSet set2 = groups.get(name2);
            if(set1 != set2){
                NameSet smaller = set1.getSize() < set2.getSize() ? set1 : set2;
                NameSet larger = set1.getSize() < set2.getSize() ? set2 : set1;
                HashSet<String> moreNames = smaller.getNames();
                int freq = smaller.getFrequency();
                larger.copyNamesWithFrequency(moreNames, freq);
                for(String name : moreNames){
                    groups.put(name, larger);
                }
            }
        }
    }

    private HashMap<String, NameSet> constructGroups(HashMap<String, Integer> names){
        HashMap<String, NameSet> groups = new HashMap<String, NameSet>();
        for(Map.Entry<String, Integer> entry : names.entrySet()){
            String name = entry.getKey();
            int frequency = entry.getValue();
            NameSet nameSet = new NameSet(name, frequency);
            groups.put(name, nameSet);
        }
        return groups;
    }

    private HashMap<String, Integer> convertToMap(HashMap<String, NameSet> groups){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(NameSet nS : groups.values()){
            map.put(nS.getRootName(), nS.getFrequency());
        }
        return map;
    }

}