package MathAndLogicPuzzles;

import java.util.Random;

public class TheApocalypse {

    public static void main(String[] args){
        int n = 100;
        TheApocalypse tA = new TheApocalypse();
        System.out.println(tA.runFamilies(n));
    }

    public double runFamilies(int n){
        int boys = 0;
        int girls = 0;
        for(int i = 0; i < n; i++){
            int[] gender = runOneFamily();
            girls += gender[0];
            boys += gender[1];
        }
        return girls / (double) (girls + boys);
    }

    private int[] runOneFamily(){
        Random random = new Random();
        int boys = 0;
        int girls = 0;
        while(girls == 0){
            if(random.nextBoolean()){
                girls += 1;
            } else{
                boys += 1;
            }
        }
        int[] genders = {girls, boys};
        return genders;
    }

}