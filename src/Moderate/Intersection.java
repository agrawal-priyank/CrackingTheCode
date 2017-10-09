package Moderate;

public class Intersection {

    public static void main(String[] args){
        // Line 1
        Point p1 = new Point(10, 0);
        Point q1 = new Point(0, 10);
        // Line 2
        Point p2 = new Point(0, 0);
        Point q2 = new Point(10, 10);
        Intersection i = new Intersection();
        System.out.println(i.doIntersect(p1, q1, p2, q2));
    }

    public boolean doIntersect(Point p1, Point q1, Point p2, Point q2){
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if(o1 != o2 && o3 != o4){
            return true;
        }

        if(o1 == 0 && inBetween(p1, q1, p2)){
            return true;
        }

        if(o2 == 0 && inBetween(p1, q1, q2)){
            return true;
        }

        if(o3 == 0 && inBetween(p2, q2, p1)){
            return true;
        }

        if(o4 == 0 && inBetween(p2, q2, q1)){
            return true;
        }

        return false;
    }

    private int orientation(Point p, Point q, Point r){
        double val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);
        return val == 0 ? 0 : val > 0 ? 1 : 2;
    }

    private boolean inBetween(Point p, Point q, Point r){
        if((Math.min(p.x, q.x) <= r.x && r.x <= Math.max(p.x, q.x))
                && (Math.min(p.y, q.y) <= r.y && r.y <= Math.max(p.y, q.y))){
            return true;
        }
        return false;
    }

}