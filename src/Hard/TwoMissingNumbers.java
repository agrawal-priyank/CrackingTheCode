package Hard;

import java.util.Arrays;

public class TwoMissingNumbers {

    public static void main(String[] args){
        int[] arr = {1, 3, 5, 6};
        TwoMissingNumbers t = new TwoMissingNumbers();
        int[] res = t.missingTwo(arr);
        System.out.println(Arrays.toString(res));
    }

    public int[] missingTwo(int[] arr){
        int max_value = arr.length + 2;
        int sum_one = max_value * (max_value + 1) / 2;
        int sum_two = computeSumOfN(max_value, 2);
        int rem_one = sum_one, rem_two = sum_two;
        for(int i = 0; i < arr.length; i++){
            rem_one -= arr[i];
            rem_two -= arr[i] * arr[i];
        }
        return solveEquation(rem_one, rem_two);
    }

    private int computeSumOfN(int n, int power){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += (int)Math.pow(i, power);
        }
        return sum;
    }

    private int[] solveEquation(int r1, int r2){
        int a = 2, b = -2 * r1, c = (r1 * r1) - r2;
        // Equation -> (-b + sqrt(b^2 - 4ac))/2a
        double part1 = -1 * b;
        double part2 = Math.sqrt((b * b) - 4 * a * c);
        double part3 = 2 * a;
        int x = (int)((part1 + part2)/part3);
        int y = r1 - x;
        return new int[]{x, y};
    }

}