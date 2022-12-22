package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CalorieCounter {

    public int getHighestCalorieCountOfTopReindeers(int numberOfTopReindeers){
        List<Integer> calorieList = descendingReindeerCalorieFileReader();
        int calorieCounter= 0;
        int looper =1;
        Iterator<Integer> iterator = calorieList.iterator();

        while(iterator.hasNext()){
            calorieCounter += iterator.next();
            if (looper == numberOfTopReindeers){
                break;
            }
            looper++;
        }
         return calorieCounter;
    }

    public int getHighestCalorieCount(){
        return descendingReindeerCalorieFileReader().get(0);
    }

    private List<Integer> descendingReindeerCalorieFileReader() {
        List<Integer> calorieCounterList = new ArrayList<>();
        File file = new File("src/day1/dayOneInputFile.txt");
        String st;
        int calorieCounter = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((st = bufferedReader.readLine()) != null)
                if (st.equals("")) {
                    calorieCounterList.add(calorieCounter);
                    calorieCounter = 0;
                } else {
                    calorieCounter += Integer.parseInt(st);
                }
        } catch (IOException e) {
            System.out.println(e);
        }
        return calorieCounterList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }
}
