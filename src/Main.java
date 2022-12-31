import day1.CalorieCounter;
import day2.RockPaperScissorsStrategizer;
import day4.CampCleanUp;

public class Main {

    public static void main(String[] args) {

        //day 1
        CalorieCounter calorieCounter = new CalorieCounter();
        System.out.println("Day 1: " + calorieCounter.getHighestCalorieCountOfTopReindeers(3));

        //day 2
	    RockPaperScissorsStrategizer rps = new RockPaperScissorsStrategizer();
        System.out.println("Day 2: " + rps.rockPaperScissorFileReader());

        //day 3

        //day 4
        CampCleanUp ccu = new CampCleanUp();
        System.out.println("Day 4: " + ccu.containsAssignmentPairCount());

        //day 5

    }
}
