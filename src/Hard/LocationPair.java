package Hard;

public class LocationPair {

    public int location1, location2;

    public LocationPair(int loc1, int loc2){
        setLocation(loc1, loc2);
    }

    public void setLocation(int loc1, int loc2){
        location1 = loc1;
        location2 = loc2;
    }

    public void setLocation(LocationPair lP){
        location1 = lP.location1;
        location2 = lP.location2;
    }

    public int distance(){
        return Math.abs(location1 - location2);
    }

    public boolean isValid(){
        return location1 >= 0 && location2 >= 0;
    }

    public void updateWithMin(LocationPair lP){
        if(!isValid() || lP.distance() < distance()){
            setLocation(lP);
        }
    }

}