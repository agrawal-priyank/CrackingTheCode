package Moderate;

public class NumberSwapper {

    public static void main(String[] args){
        int a = 9, b = 5;
        NumberSwapper nS = new NumberSwapper();
        System.out.println("Initial a: " + a);
        System.out.println("Initial b: " + b);
        System.out.println();
        nS.swapUsingArithmetic(a, b);
        System.out.println();
        nS.swapUsingXOR(a, b);
    }

    public void swapUsingArithmetic(int a, int b){
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public void swapUsingXOR(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

}