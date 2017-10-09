package Moderate;

public class FactorialZeros {

    public static void main(String[] args){
        int n = 20;
        FactorialZeros fZ = new FactorialZeros();
        System.out.println(fZ.countZeros(n));
        System.out.println(fZ.countZerosOptimal(n));
    }

    public int countZerosOptimal(int num){
        int count = 0;
        for(int i = 5; num / i > 0; i *= 5){
            count += num / i;
        }
        return count;
    }

    public int countZeros(int n){
        int count = 0;
        for(int i = 2; i <= n; i++){
            count += factorOf5(i);
        }
        return count;
    }

    private int factorOf5(int i){
        int count = 0;
        while(i % 5 == 0){
            count++;
            i = i / 5;
        }
        return count;
    }

}