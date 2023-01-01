package day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class CommunicationMarker {

    public int getCommunicationMarkerIndex(int distinctCharacters){
        try {
            File fileName = new File("src/inputFiles/day6.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String st;

            while ((st = bufferedReader.readLine()) != null) {
                for(int i = 0; i <st.length(); i++){
                    HashSet<Character> potentialPacket = populateSet(st, i, distinctCharacters);
                    if(potentialPacket.size() == distinctCharacters){
                        return i+distinctCharacters;
                    }


                }
            }
        }catch(Exception e){
            System.out.println(e);}

        return 0;
    }

    private HashSet<Character> populateSet(String st, int index, int distinctCharacter) {

        HashSet<Character> marker = new HashSet<>();
        for(int j =0; j <distinctCharacter; j++) {
            marker.add(st.charAt(index +j));
        }
        return marker;
    }
}
