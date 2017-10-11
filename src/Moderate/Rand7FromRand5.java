package Moderate;

import java.util.Random;

public class Rand7FromRand5 {

    public static void main(String[] args){
        Rand7FromRand5 rand = new Rand7FromRand5();
        System.out.println(rand.rand7());
        System.out.println(rand.rand7Alternate());
    }

    public int rand7(){
        while(true){
            Random rand = new Random();
            int r1 = 2 * rand.nextInt(5);
            int r2 = rand.nextInt(5);
            if(r2 != 4){
                r2 = r2 % 2;
                int num = r1 + r2;
                if(num < 7){
                    return num;
                }
            }
        }
    }

    public int rand7Alternate(){
        while(true){
            Random rand = new Random();
            int num = (5 * rand.nextInt(5)) + rand.nextInt(5);
            if(num < 21){
                return num % 7;
            }
        }
    }

}