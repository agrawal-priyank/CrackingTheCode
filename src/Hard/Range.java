package Hard;

public class Range {

    private int start;
    private int end;

    public Range(int start, int end){
        this.start =  start;
        this.end = end;
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }

    public int length(){
        return end - start + 1;
    }

    public boolean isShorterThan(Range r){
        return length() < r.length();
    }

}