package BitManipulation;

public class Conversion {

    public static void main(String[] args){
        int a = 29, b = 15;
        Conversion c = new Conversion();
        int res1 = c.bitSwapRequired(a, b);
        int res2 = c.bitSwapRequiredOptimal(a, b);
        System.out.println(res1);
        System.out.println(res2);
    }

    public int bitSwapRequired(int a, int b){
        int count = 0;
        for(int c = a ^ b; c != 0; c = c >> 1){
            count += c & 1;
        }
        return count;
    }

    public int bitSwapRequiredOptimal(int a, int b){
        int count = 0;
        for(int c = a ^ b; c != 0; c = c & (c - 1)){
            count++;
        }
        return count;
    }

}