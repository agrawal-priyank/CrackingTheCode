package Moderate;

import java.util.concurrent.ThreadLocalRandom;

public class LivingPeople {

    public static void main(String[] args){
        int num = 5;
        Person[] people = new Person[num];
        people[0] = new Person(1905, 1950);
        people[1] = new Person(1945, 1975);
        people[2] = new Person(1950, 2000);
        people[3] = new Person(1900, 1975);
        people[4] = new Person(1920, 2000);
        LivingPeople lP = new LivingPeople();
        System.out.println(lP.maxAliveYear(people, 1900, 2000));
    }

    public int maxAliveYear(Person[] people, int min, int max){
        int[] years = createYearMap(people, min, max);
        int best = getMaxAliveYear(years);
        return min + best;
    }

    private int[] createYearMap(Person[] people, int min, int max){
        int[] years = new int[max - min + 1];
        for(Person person : people){
            incrementRange(years, person.birth - min, person.death - min);
        }
        return years;
    }

    private void incrementRange(int[] years, int left, int right){
        for(int i = left; i <= right; i++){
            years[i]++;
        }
    }

    private int getMaxAliveYear(int[] years){
        int maxAliveYear = 0;
        for(int i = 0; i < years.length; i++){
            if(years[i] > years[maxAliveYear]){
                maxAliveYear = i;
            }
        }
        return maxAliveYear;
    }

}