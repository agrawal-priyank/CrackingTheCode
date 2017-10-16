package Hard.SparseSimilarity;

import java.util.ArrayList;

public class Document {

    private int docId;
    private ArrayList<Integer> words;

    public Document(int id, ArrayList<Integer> w){
        docId = id;
        words = w;
    }

    public int getId(){
        return docId;
    }

    public ArrayList<Integer> getWords(){
        return words;
    }

    public int size(){
        return words == null ? 0 : words.size();
    }

}