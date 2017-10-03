package RecursionAndDynamicProgramming;

public class RecursiveMultiply {

    public static void main(String[] args) {
        int a = 97, b = 990;
        RecursiveMultiply rM = new RecursiveMultiply();
        System.out.print(rM.product(a, b));
    }

    public int product(int a, int b) {
        int smaller = a > b ? b : a;
        int bigger = a > b ? a : b;
        return productHelper(smaller, bigger);
    }

    private int productHelper(int smaller, int bigger) {
        if(smaller == 0){
            return 0;
        } else if(smaller == 1){
            return bigger;
        }
        int s = smaller >> 1;
        int side1 = productHelper(s, bigger);
        int side2 = side1;
        if(smaller % 2 == 1){
            side2 = productHelper(smaller - s, bigger);
        }
        return side1 + side2;
    }

}