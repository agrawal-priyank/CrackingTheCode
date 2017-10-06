package MathAndLogicPuzzles;

public class EggDropProblem {

    private static final int breakingPoint = 76;
    private static int countDrops = 0;

    public static void main(String[] args){
        int floors = 100;
        EggDropProblem eDP = new EggDropProblem();
        System.out.println("Breaking Point: " + eDP.findBreakingPoint(floors));
        System.out.println("Max drops: " + countDrops);
    }

    public int findBreakingPoint(int floors){
        int interval = 14;
        int previousFloor = 0;
        int egg1 = interval;
        while(!drop(egg1) && egg1 <= floors){
            interval -= 1;
            previousFloor = egg1;
            egg1 += interval;
        }
        int egg2 = previousFloor + 1;
        while(egg2 < egg1 && egg2 <= floors && !drop(egg2)){
            egg2 += 1;
        }
        return egg2 > floors ? -1 : egg2;
    }

    private boolean drop(int floor){
        countDrops++;
        return floor >= breakingPoint;
    }

}