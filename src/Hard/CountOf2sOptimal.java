package Hard;

public class CountOf2sOptimal {

    public static void main(String[] args) {
        int number = 22;
        CountOf2sOptimal c = new CountOf2sOptimal();
        System.out.println(c.count2sInRange(number));
    }

    public int count2sInRange(int number) {
        int count = 0;
        int len = String.valueOf(number).length();
        for(int i = 0; i < len; i++){
            count += count2sInRangeAtDigit(number, i);
        }
        return count;
    }

    private int count2sInRangeAtDigit(int number, int d){
        int powerOf10 = (int)Math.pow(10, d);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;
        int roundDown = number - number % nextPowerOf10;
        int roundUp = roundDown + nextPowerOf10;
        int digit = (number / powerOf10) % 10;
        if(digit < 2){
            return roundDown / 10;
        } else if(digit == 2){
            return roundDown / 10 + right + 1;
        } else{
            return roundUp / 10;
        }
    }

}