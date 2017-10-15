package Hard;

import java.util.ArrayList;

public class Trie {

    private TrieNode root = new TrieNode();

    public Trie(){}

    public Trie(String s){
        insertString(s, 0);
    }

    public void insertString(String s, int location){
        root.insertString(s, location);
    }

    public ArrayList<Integer> search(String s){
        return root.search(s);
    }

    public TrieNode getRoot(){
        return root;
    }

}