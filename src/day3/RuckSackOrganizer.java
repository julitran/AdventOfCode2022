package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RuckSackOrganizer {

    int _priorityLevel = 0;

    public String readFilepart1() {
        try {
            File fileName = new File("src/inputFiles/day3.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String st;
            _priorityLevel = 0;

            while ((st = bufferedReader.readLine()) != null) {
                int rucksackLength = st.length();
                int compartmentLength = rucksackLength / 2;
                String compartmentOne = st.substring(0, compartmentLength);
                String compartmentTwo = st.substring(compartmentLength, rucksackLength);


                for(int i =0; i < compartmentLength; i ++){
                    char a = compartmentOne.charAt(i);
                    if(compartmentTwo.contains(String.valueOf(a))){
                        _priorityLevel += checkPriority(a);
                        break;
                    }
                }

            }
            return String.valueOf(_priorityLevel);

        }catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return String.valueOf(0);
    }

    private int checkPriority(char c) {
        return (Character.isUpperCase(c)) ? ( c - 38): (c - 96);
    }

    public String readFilepart2() {
        try {
            File fileName = new File("src/inputFiles/day3.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String st;
            _priorityLevel = 0;
            List<String> item = new ArrayList<>(3);


            while ((st = bufferedReader.readLine()) != null) {
                item.add(st);
                if(item.size() == 3) {
                    char badge = findBadge(item);
                    _priorityLevel += checkPriority(badge);
                    item.clear();
                }
            }
            return String.valueOf(_priorityLevel);

        }catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return String.valueOf(0);
    }

    private char findBadge(List<String> item) {
        String sequenceOne = item.get(0);
        String sequenceTwo = item.get(1);
        String sequenceThree = item.get(2);
        char a = 'a';

       int maxLength = getMaxLength(sequenceOne.length(), sequenceTwo.length(), sequenceThree.length());

        for(int i =0; i < maxLength; i ++){
            a = sequenceOne.charAt(i);
            if(sequenceTwo.contains(String.valueOf(a)) && sequenceThree.contains(String.valueOf(a))){
               break;
            }
        }
        return a;
    }

    private int getMaxLength(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
