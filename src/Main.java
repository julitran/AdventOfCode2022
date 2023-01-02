import day1.CalorieCounter;
import day2.RockPaperScissorsStrategizer;
import day3.RuckSackOrganizer;
import day4.CampCleanUp;
import day5.SupplyStack;
import day6.CommunicationMarker;
import day7.DirectorySize;

public class Main {

    public static void main(String[] args) {

        //day 1
/*        CalorieCounter calorieCounter = new CalorieCounter();
        System.out.println("Day 1: " + calorieCounter.getHighestCalorieCountOfTopReindeers(3));

        //day 2
	    RockPaperScissorsStrategizer rps = new RockPaperScissorsStrategizer();
        System.out.println("Day 2: " + rps.rockPaperScissorFileReader());*/

        //day 3
        RuckSackOrganizer rso = new RuckSackOrganizer();
        System.out.println("Day 3: " + rso.readFilepart2());

        //day 4
/*        CampCleanUp ccu = new CampCleanUp();
        System.out.println("Day 4: " + ccu.containsAssignmentPairCount());

        //day 5
        SupplyStack ss = new SupplyStack();
        System.out.println("Day 5:" + ss.readFile());*/

        //day 6
        //CommunicationMarker cm = new CommunicationMarker();
        //System.out.println("Day 6: " +  cm.getCommunicationMarkerIndex(14));

        //day 7
        //DirectorySize ds = new DirectorySize();
        //System.out.println("Day 7: " +  ds.readFile());


    }
}
