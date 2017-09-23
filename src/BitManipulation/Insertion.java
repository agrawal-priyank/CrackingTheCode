package BitManipulation;

public class Insertion {

    public static void main(String[] args){
        String N = "10000000000";
        String M = "10011";
        int n = Integer.parseInt(N, 2);
        int m = Integer.parseInt(M, 2);
        Insertion i = new Insertion();
        int res = i.updateBits(n, m, 2, 6);
        System.out.println(Integer.toBinaryString(res));
    }

    public int updateBits(int n, int m, int i, int j){
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;
        int masked = left | right;
        int n_cleared = n & masked;
        int m_cleared = m << i;
        return n_cleared | m_cleared;
    }

}