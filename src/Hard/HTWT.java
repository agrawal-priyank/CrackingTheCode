package Hard;

public class HTWT implements Comparable<HTWT> {

    private int height;
    private int weight;

    public HTWT(int h, int w){
        height = h;
        weight = w;
    }

    public int compareTo(HTWT second){
        if(this.height != second.height){
            return ((Integer)this.height).compareTo((Integer)second.height);
        } else{
            return((Integer)this.weight).compareTo((Integer)second.weight);
        }
    }

    public boolean isBefore(HTWT other){
        if(height < other.height && weight < other.weight){
            return true;
        } else{
            return false;
        }
    }

    public String toString() {
        return "(" + height + ", " + weight + ")";
    }

}