package RecursionAndDynamicProgramming;

public class TowersOfHanoi {

    public static void main(String[] args){
        int n = 5;
        Tower[] towers = new Tower[3];
        for(int i = 0; i < 3; i++){
            towers[i] = new Tower(i);
        }
        for(int i = n - 1; i >= 0; i--){
            towers[0].add(i);
        }
        towers[0].print();
        towers[0].moveDisks(n, towers[2], towers[1]);
        towers[2].print();
    }

}