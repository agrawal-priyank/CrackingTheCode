package Hard.WordRectangle;

public class Rectangle {

    public int length, height;
    public char[][] matrix;

    public Rectangle(int length){
        this.length = length;
        height = 0;
    }

    public Rectangle(int length, int height, char[][] letters){
        this.length = length;
        this.height = height;
        matrix = letters;
    }

    public char getLetter(int i, int j){
        return matrix[i][j];
    }

    public String getColumn(int j){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; i++){
            sb.append(matrix[i][j]);
        }
        return sb.toString();
    }

    public boolean isComplete(int l, int h, WordGroup group){
        if(height == h){
            for(int i = 0; i < l; i++){
                String word = getColumn(i);
                if(!group.containsWord(word)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isPartialComplete(int l, Trie trie){
        if(height == 0){
            return true;
        }
        for(int i = 0; i < l; i++){
            String prefix = getColumn(i);
            if(!trie.contains(prefix)){
                return false;
            }
        }
        return true;
    }

    public Rectangle append(String s) {
        if (s.length() == length) {
            char temp[][] = new char[height + 1][length];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    temp[i][j] = matrix[i][j];
                }
            }
            s.getChars(0, length, temp[height], 0);
            return new Rectangle(length, height + 1, temp);
        }
        return null;
    }

}