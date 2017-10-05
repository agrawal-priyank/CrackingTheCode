package RecursionAndDynamicProgramming;

public class Box {
    public int height, width, depth;

    public Box(int h, int w, int d){
        height = h;
        width = w;
        depth = d;
    }

    public boolean canBeAbove(Box b){
        if(height < b.height && width < b.width && depth < b.depth){
            return true;
        }
        return false;
    }

}