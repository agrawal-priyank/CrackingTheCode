package Hard;

public class AddWithoutPlus {

    public static void main(String[] args){
        int a = 96, b = 45;
        AddWithoutPlus aWP = new AddWithoutPlus();
        System.out.println(aWP.add(a, b));
    }

    public int add(int a, int b){
        while(b != 0){
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public int addRecurse(int a, int b){
        if(b == 0){
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return addRecurse(sum, carry);
    }

}