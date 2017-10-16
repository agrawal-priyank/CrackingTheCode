package Hard.SparseSimilarity;

import java.util.*;

public class SparseSimilarity {

    public static void main(String[] args){
        Document doc1 = new Document(1, new ArrayList<Integer>(Arrays.asList(1, 2, 5, 6, 7)));
        Document doc2 = new Document(2, new ArrayList<Integer>(Arrays.asList(2, 1, 7, 8, 9)));
        Document doc3 = new Document(3, new ArrayList<Integer>(Arrays.asList(1, 4, 5, 6, 6)));
        ArrayList<Document> documents = new ArrayList<Document>();
        documents.add(doc1);
        documents.add(doc2);
        documents.add(doc3);
        SparseSimilarity s = new SparseSimilarity();
        HashMap<DocPair, Double> similarities = s.computeSimilarities(documents);
        for(Map.Entry<DocPair, Double> entry : similarities.entrySet()){
            System.out.println(entry.getKey().doc1 + ", " + entry.getKey().doc2 + ", " + entry.getValue());
        }
    }

    public HashMap<DocPair, Double> computeSimilarities(ArrayList<Document> documents){
        HashMap<DocPair, Double> similarities = new HashMap<DocPair, Double>();
        for(int i = 0; i < documents.size(); i++){
            for(int j = i + 1; j < documents.size(); j++){
                Document doc1 = documents.get(i);
                Document doc2 = documents.get(j);
                double sim = computeSimilarity(doc1, doc2);
                if(sim > 0){
                    DocPair pair = new DocPair(doc1.getId(), doc2.getId());
                    similarities.put(pair, sim);
                }
            }
        }
        return similarities;
    }

    private double computeSimilarity(Document doc1, Document doc2){
        int intersection = 0;
        HashSet<Integer> set1 = new HashSet<Integer>();
        set1.addAll(doc1.getWords());
        for(int word : doc2.getWords()){
            if(set1.contains(word)){
                intersection++;
            }
        }
        double union = doc1.size() + doc2.size() - intersection;
        return intersection / union;
    }

}