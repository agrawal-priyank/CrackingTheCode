package Moderate;

public class OperationMultiply {

    OperationSubtract oS = new OperationSubtract();

    public static void main(String[] args){
        int a = 9, b = 5;
        OperationMultiply oM =new OperationMultiply();
        System.out.println(oM.Multiply(a, b));
    }

    public int Multiply(int a, int b){
        if(a < b){
            return Multiply(b, a);
        }
        int sum = 0;
        for(int i = 0; i < abs(b); i++){
            sum += a;
        }
        if(b < 0){
            sum = oS.negateOptimal(sum);
        }
        return sum;
    }

    public int abs(int x){
        if(x < 0){
            return oS.negateOptimal(x);
        } else{
            return x;
        }
    }

}