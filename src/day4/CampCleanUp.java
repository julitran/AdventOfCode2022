package day4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CampCleanUp {

    public int fullyContainsAssignmentCount() {
        int counter = 0;
        try {
            File fileName = new File("src/inputFiles/day4.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                int elfOneMinimum = getElfOneMinimum(st);
                int elfOneMaximum = getElfTwoMinimum(st);
                int elfTwoMinimum = getElfTwoMinimum(st);
                int elfTwoMaximum = getElfTwoMaximum(st);

                if (elfOneMinimum <= elfTwoMinimum && elfOneMaximum >= elfTwoMaximum) {
                    counter++;
                } else if (elfOneMinimum >= elfTwoMinimum && elfOneMaximum <= elfTwoMaximum) {
                    counter++;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return counter;
    }

    public int containsAssignmentPairCount() {
        int counter = 0;
        try {
            File fileName = new File("src/inputFiles/day4.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String st;
            while ((st = bufferedReader.readLine()) != null) {
                List<Integer> elfOneRange = createListWithRange(getElfOneMinimum(st), getElfOneMaximum(st));
                List<Integer> elfTwoRange = createListWithRange(getElfTwoMinimum(st), getElfTwoMaximum(st));
                if(isOverlap(elfOneRange, elfTwoRange)){
                    counter++;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return counter;
    }

    private int getElfOneMinimum(String st) {
        return  Integer.parseInt(st.substring(0, st.indexOf("-")));
    }

    private int getElfOneMaximum(String st) {
        return Integer.parseInt(st.substring(st.indexOf("-") + 1, st.indexOf(",")));
    }

   private int getElfTwoMinimum(String st){
       int index = st.lastIndexOf("-");
       return Integer.parseInt(st.substring(st.indexOf(",")+1, index));
   }

    private int getElfTwoMaximum(String st){
        int index = st.lastIndexOf("-");
        int endIndex = st.length();
        return Integer.parseInt(st.substring(index+1, endIndex));
    }

    private boolean isOverlap(List<Integer> elfOneRange, List<Integer> elfTwoRange) {
        for(int value: elfOneRange){
          for(int value2:elfTwoRange){
              if(value == value2){
                  return true;
              }
          }
        }
        return false;
    }

    private List<Integer> createListWithRange(int minimum, int maximum) {
        List<Integer> list = new ArrayList<>();
        for(int i = minimum; i <= maximum; i++){
            list.add(i);
        }
        return list;
    }
}
