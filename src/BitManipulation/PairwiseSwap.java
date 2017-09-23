package BitManipulation;

public class PairwiseSwap {

    public static void main(String[] args){
        String s = "101101000";
        int x = Integer.parseInt(s, 2);
        PairwiseSwap pS = new PairwiseSwap();
        int res = pS.swapOddEven(x);
        System.out.print(Integer.toBinaryString(res));
    }

    public int swapOddEven(int x){
        return ((x & 0xAAAAAAAA) >>> 1) | ((x & 0x55555555) << 1);
    }

}