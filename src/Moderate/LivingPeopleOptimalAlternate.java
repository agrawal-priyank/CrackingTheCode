package Moderate;

public class LivingPeopleOptimalAlternate {

    public static void main(String[] args){
        int num = 5;
        Person[] people = new Person[num];
        people[0] = new Person(1905, 1950);
        people[1] = new Person(1945, 1975);
        people[2] = new Person(1950, 2000);
        people[3] = new Person(1900, 1975);
        people[4] = new Person(1920, 2000);
        LivingPeopleOptimalAlternate lPO2 = new LivingPeopleOptimalAlternate();
        System.out.println(lPO2.maxAliveYear(people, 1900, 2000));
    }

    public int maxAliveYear(Person[] people, int min, int max){
        int[] deltas = getPopulationDeltas(people, min, max);
        int best = getMaxAliveYear(deltas);
        return min + best;
    }

    private int[] getPopulationDeltas(Person[] people, int min, int max){
        int[] delta = new int[max - min + 2];
        for(Person person : people){
            delta[person.birth - min]++;
            delta[person.death - min + 1]--;
        }
        return delta;
    }

    private int getMaxAliveYear(int[] deltas){
        int maxAliveYear = 0;
        int maxAlive = 0;
        int currentlyAlive = 0;
        for(int year = 0; year < deltas.length; year++){
            currentlyAlive += deltas[year];
            if(currentlyAlive > maxAlive){
                maxAlive = currentlyAlive;
                maxAliveYear = year;
            }
        }
        return maxAliveYear;
    }

}