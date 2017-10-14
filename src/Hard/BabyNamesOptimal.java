package Hard;

import java.util.HashMap;
import java.util.Map;

public class BabyNamesOptimal {

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
        Graph graph = constructGraph(names);
        connectNodes(graph, synonyms);
        return getTrueFrequencies(graph);
    }

    private Graph constructGraph(HashMap<String, Integer> names){
        Graph graph = new Graph();
        for(Map.Entry<String, Integer> entry : names.entrySet()){
            graph.createNode(entry.getKey(), entry.getValue());
        }
        return graph;
    }

    private void connectNodes(Graph graph, String[][] synonyms){
        for(String[] entry : synonyms){
            graph.addEdge(entry[0], entry[1]);
        }
    }

    private HashMap<String, Integer> getTrueFrequencies(Graph graph){
        HashMap<String, Integer> rootNames = new HashMap<String, Integer>();
        for(GraphNode node : graph.getNodes()){
            if(!node.isVisited()){
                int frequency = getComponentFrequency(node);
                String name = node.getName();
                rootNames.put(name, frequency);
            }
        }
        return rootNames;

    }

    private int getComponentFrequency(GraphNode node){
        if(node.isVisited()){
            return 0;
        }
        node.setIsVisited(true);
        int sum = node.getFrequency();
        for(GraphNode child : node.getNeighbors()){
            sum += getComponentFrequency(child);
        }
        return sum;
    }

}