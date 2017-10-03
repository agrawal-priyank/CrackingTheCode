package RecursionAndDynamicProgramming;

public class RecursiveMultiplyBest {

    public static void main(String[] args){
        int a = 97, b = 990;
        RecursiveMultiplyBest rM = new RecursiveMultiplyBest();
        System.out.print(rM.product(a, b));
    }

    public int product(int a, int b){
        int smaller = a > b ? b : a;
        int bigger = a > b ? a : b;
        return productHelper(smaller, bigger);
    }

    private int productHelper(int smaller, int bigger){
        if(smaller == 0){
            return 0;
        } else if(smaller == 1){
            return bigger;
        }
        int s = smaller >> 1;
        int halfprod = productHelper(s, bigger);
        if(smaller % 2 == 0){
            return halfprod + halfprod;
        } else{
            return halfprod + halfprod + bigger;
        }
    }

}