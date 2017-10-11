package Hard;

public class LettersAndNumbers {

    public static void main(String[] args){
        char a = 'a';
        char b = '1';
        char[] arr = {a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a};
        LettersAndNumbers lAN = new LettersAndNumbers();
        char[] subarr = lAN.findLongestSubarray(arr);
        System.out.println(subarr);
    }

    public char[] findLongestSubarray(char[] arr){
        for(int len = arr.length; len > 1; len--){
            for(int i = 0; i <= arr.length - len; i++){
                if(hasEqualLettersNumbers(arr, i, i + len - 1)){
                    return extractSubarray(arr, i, i + len - 1);
                }
            }
        }
        return null;
    }


    private boolean hasEqualLettersNumbers(char[] arr, int start, int end){
        int counter = 0;
        for(int i = start; i <= end; i++){
            if(Character.isLetter(arr[i])){
                counter++;
            } else if(Character.isDigit(arr[i])){
                counter--;
            }
        }
        return counter == 0;
    }

    private char[] extractSubarray(char[] arr, int start, int end){
        char[] subarr = new char[end - start + 1];
        for(int i = start; i <= end; i++){
            subarr[i - start] = arr[i];
        }
        return subarr;
    }

}