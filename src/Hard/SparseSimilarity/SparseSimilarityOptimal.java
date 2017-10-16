package Hard.SparseSimilarity;

import java.util.*;

public class SparseSimilarityOptimal {

    public static void main(String[] args){
        Document doc1 = new Document(1, new ArrayList<Integer>(Arrays.asList(1, 2, 5, 6, 7)));
        Document doc2 = new Document(2, new ArrayList<Integer>(Arrays.asList(2, 1, 7, 8, 9)));
        Document doc3 = new Document(3, new ArrayList<Integer>(Arrays.asList(1, 4, 5, 6, 6)));
        HashMap<Integer, Document> documents = new HashMap<Integer, Document>();
        documents.put(doc1.getId(), doc1);
        documents.put(doc2.getId(), doc2);
        documents.put(doc3.getId(), doc3);
        SparseSimilarityOptimal s = new SparseSimilarityOptimal();
        HashMap<DocPair, Double> similarities = s.computeSimilarities(documents);
        for(Map.Entry<DocPair, Double> entry : similarities.entrySet()){
            System.out.println(entry.getKey().doc1 + ", " + entry.getKey().doc2 + ", " + entry.getValue());
        }
    }

    public HashMap<DocPair, Double> computeSimilarities(HashMap<Integer, Document> documents){
        HashMap<Integer, ArrayList<Integer>> wordToDocs = groupDocs(documents);
        HashMap<DocPair, Double> similarities = computeIntersection(wordToDocs);
        adjustSimilarities(documents, similarities);
        return similarities;
    }

    private HashMap<Integer, ArrayList<Integer>> groupDocs(HashMap<Integer, Document> documents){
        HashMap<Integer, ArrayList<Integer>> wordToDocs = new HashMap<Integer, ArrayList<Integer>>();
        for(Document doc : documents.values()){
            ArrayList<Integer> words = doc.getWords();
            for(int word : words){
                if(!wordToDocs.containsKey(word)){
                    wordToDocs.put(word, new ArrayList<Integer>());
                }
                wordToDocs.get(word).add(doc.getId());
            }
        }
        return wordToDocs;
    }

    private HashMap<DocPair, Double> computeIntersection(HashMap<Integer, ArrayList<Integer>> wordToDocs){
        HashMap<DocPair, Double> similarities = new HashMap<DocPair, Double>();
        Set<Integer> words = wordToDocs.keySet();
        for(int word : words){
            ArrayList<Integer> docs = wordToDocs.get(word);
            Collections.sort(docs);
            for(int i = 0; i < docs.size(); i++){
                for(int j = i + 1; j < docs.size(); j++){
                    increment(similarities, docs.get(i), docs.get(j));
                }
            }
        }
        return similarities;
    }

    private void increment(HashMap<DocPair, Double> similarities, int doc1, int doc2){
        DocPair pair = new DocPair(doc1, doc2);
        if(!similarities.containsKey(pair)){
            similarities.put(pair, 1.0);
        } else{
            similarities.put(pair, similarities.get(pair) + 1);
        }
    }

    private void adjustSimilarities(HashMap<Integer, Document> documents,
                                                        HashMap<DocPair, Double> similarities){
        for(Map.Entry<DocPair, Double> entry : similarities.entrySet()){
            DocPair pair = entry.getKey();
            Double intersection = entry.getValue();
            Document doc1 = documents.get(pair.doc1);
            Document doc2 = documents.get(pair.doc2);
            double union = (double)doc1.size() + doc2.size() - intersection;
            entry.setValue(intersection / union);
        }
    }

}