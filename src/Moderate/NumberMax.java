package Moderate;

public class NumberMax {

    public static void main(String[] args){
        int a = 9, b = 5;
        NumberMax nM = new NumberMax();
        System.out.println(nM.getMax(a, b));
        System.out.println(nM.getMaxNaive(a, b));
    }

    public int getMax(int a, int b){
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int use_sign_of_a = sa ^ sb;
        int use_sign_of_c = flip(sa ^ sb);
        int k = use_sign_of_a * sa + use_sign_of_c * sc;
        int q = flip(k);
        return a * k + b * q;
    }

    // Integer overflow might occur while doing a - b
    public int getMaxNaive(int a, int b){
        int k = sign(a - b);
        int q = flip(k);
        return k * a + q * b;
    }

    private int sign(int a){
        return flip((a >> 31) & 0x1);
    }

    private int flip(int bit){
        return 1 ^ bit;
    }

}