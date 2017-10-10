package Moderate;

import java.util.Arrays;

public class LivingPeopleOptimal {

    public static void main(String[] args){
        int num = 5;
        Person[] people = new Person[num];
        people[0] = new Person(1905, 1950);
        people[1] = new Person(1945, 1975);
        people[2] = new Person(1950, 2000);
        people[3] = new Person(1900, 1975);
        people[4] = new Person(1920, 2000);
        LivingPeopleOptimal lPO = new LivingPeopleOptimal();
        System.out.println(lPO.maxAliveYear(people, 1900, 2000));
    }

    public int maxAliveYear(Person[] people, int min, int max){
        int[] births = getSortedYears(people, true);
        int[] deaths = getSortedYears(people, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int maxAliveYear = 0;
        int maxAlive = 0;
        int currentlyAlive = 0;

        while(birthIndex < births.length){
            if(births[birthIndex] <= deaths[deathIndex]){
                currentlyAlive++;
                if(currentlyAlive > maxAlive){
                    maxAlive = currentlyAlive;
                    maxAliveYear = births[birthIndex];
                }
                birthIndex++;
            } else{
                currentlyAlive--;
                deathIndex++;
            }
        }
        return maxAliveYear;
    }

    private int[] getSortedYears(Person[] people, boolean copyBirthYear){
        int[] years = new int[people.length];
        for(int i = 0; i < people.length; i++){
            years[i] = copyBirthYear ? people[i].birth : people[i].death;
        }
        Arrays.sort(years);
        return years;
    }

}