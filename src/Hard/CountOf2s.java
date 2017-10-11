package Hard;

public class CountOf2s {

    public static void main(String[] args){
        int num = 22;
        CountOf2s c = new CountOf2s();
        System.out.println(c.count(num));
    }

    public int count(int num){
        int count = 0;
        for(int i = 2; i <= num; i++){
            count += numberOf2s(i);
        }
        return count;
    }

    private int numberOf2s(int num){
        int count = 0;
        while(num > 0){
            if(num % 10 == 2){
                count++;
            }
            num = num / 10;
        }
        return count;
    }

}