package Moderate;

public class MasterMind {

    final int MAX_COLORS = 4;

    public static void main(String[] args){
        String guess = "GGRR";
        String solution = "RGBY";
        MasterMind m = new MasterMind();
        Result result = m.estimate(guess, solution);
        System.out.println(result.toString());
    }

    public Result estimate(String guess, String solution){
        if(guess.length() != solution.length()){
            return null;
        }
        Result res = new Result();
        int[] freq = new int[MAX_COLORS];
        for(int i = 0; i < guess.length(); i++){
            if(guess.charAt(i) == solution.charAt(i)){
                res.hits++;
            } else{
                int code = code(solution.charAt(i));
                freq[code]++;
            }
        }
        for(int i = 0; i < guess.length(); i++){
            int code = code(guess.charAt(i));
            if(code >= 0 && freq[code] > 0 && (guess.charAt(i) != solution.charAt(i))){
                res.pseudoHits++;
                freq[code]--;
            }
        }
        return res;
    }

    private int code(char c){
        switch(c){
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }

}