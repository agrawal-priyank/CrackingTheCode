package Moderate;

public class OperationSubtract {

    public static void main(String[] args) {
        int a = 999, b = 666;
        OperationSubtract oS = new OperationSubtract();
        System.out.println(oS.subtract(a, b));
        System.out.println(oS.subtractOptimal(a, b));
    }

    public int subtractOptimal(int a, int b){
        return a + negateOptimal(b);
    }

    public int negateOptimal(int x){
        int newNum = 0;
        int newSign = x < 0 ? 1 : -1;
        int delta = newSign;
        while(x != 0){
            if((x > 0 == (x + delta < 0)) || (x < 0 == (x + delta > 0))){
                delta = newSign;
            }
            newNum += delta;
            x += delta;
            delta += delta;
        }
        return newNum;
    }

    public int subtract(int a, int b){
        return a + negate(b);
    }

    private int negate(int x){
        int newNum = 0;
        int newSign = x < 0 ? 1 : -1;
        while(x != 0){
            newNum += newSign;
            x += newSign;
        }
        return newNum;
    }

}