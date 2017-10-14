package Hard;

import java.util.HashSet;
import java.util.Set;

public class NameSet {

    private HashSet<String> names = new HashSet<String>();
    private int frequency = 0;
    private String rootName;

    public NameSet(String rootName, int frequency){
        names.add(rootName);
        this.frequency = frequency;
        this.rootName = rootName;
    }

    public void copyNamesWithFrequency(HashSet<String> moreNames, int freq){
        names.addAll(moreNames);
        frequency += freq;
    }

    public HashSet<String> getNames(){
        return names;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getRootName(){
        return rootName;
    }

    public int getSize(){
        return names.size();
    }

}