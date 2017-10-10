package Moderate;

public class OperationDivide {

    OperationSubtract oS = new OperationSubtract();
    OperationMultiply oM = new OperationMultiply();

    public static void main(String[] args){
        int a = 520, b = -40;
        OperationDivide oD = new OperationDivide();
        System.out.println(oD.divide(a, b));
    }

    public int divide(int a, int b) throws java.lang.ArithmeticException{
        if(b == 0){
            throw new java.lang.ArithmeticException("ERROR");
        }
        int absA = oM.abs(a);
        int absB = oM.abs(b);
        int product = 0;
        int x = 0;
        while(product + absB <= absA){
            product += absB;
            x++;
        }
        if((a > 0 && b > 0) || (a < 0 && b < 0)){
            return x;
        } else{
            return oS.negateOptimal(x);
        }
    }

}