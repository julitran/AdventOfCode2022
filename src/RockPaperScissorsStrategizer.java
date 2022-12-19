import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissorsStrategizer {

    public int rockPaperScissorFileReader() {
        Character opponent = null;
        Character gameResult = null;
        Character self = null;
        int tally = 0;
        try {
            File file = new File("src/fileInput.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String st;
            while ((st = bufferedReader.readLine()) != null) {
                opponent = st.charAt(0);
                gameResult = st.charAt(2);

                self = determineYourStrategy(opponent, gameResult);
                tally += calculateWinsOrLoss(opponent, self);
                tally += calculatePersonalPoints(self);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return tally;

    }
    //X - lose
    //Y - draw
    //Z - win
    //part 2 methods
    private Character determineYourStrategy(Character opponent, Character gameResult) {
        if (gameResult == 'Y') {
            if (opponent == 'A') {
                return 'X';
            } else if (opponent == 'B') {
                return 'Y';
            } else {
                return 'Z';
            }
        }
        else if (gameResult == 'Z'){
            if(opponent == 'A'){ return 'Y';}
            else if (opponent == 'B'){ return 'Z';}
            else {return 'X';}
        }
        else{
            if(opponent == 'A'){ return 'Z';}
            else if (opponent == 'B'){ return 'X';}
            else {return 'Y';}
        }
    }

    // A - rock, B - paper, C - scissor
    // X - rock, Y - paper, Z - scissor

    private int calculateWinsOrLoss(Character opponent, Character self) {
        if ((self == 'X' && opponent == 'A') ||
            ( self == 'Z' && opponent == 'C') ||
            ( self == 'Y' && opponent == 'B'))
            { return 3;} //draws
        else if ((self == 'Y' && opponent == 'A') ||
                ( self == 'X' && opponent == 'C') ||
                ( self == 'Z' && opponent == 'B')){
            return 6;}
        else { return 0;}

    }
    // 1 rock X
    // 2 paper Y
    // 3 scissor Z

    private int calculatePersonalPoints(Character self) {
        if(self == 'Y') { return 2; }
        else if (self == 'X') { return 1; }
        else { return 3; }
    }

}
