import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) throws IOException {

        // PART I

        HashMap<String, Integer> actionToScore = new HashMap<String, Integer>();
        actionToScore.put("A", 1);
        actionToScore.put("X", 1);
        actionToScore.put("B", 2);
        actionToScore.put("Y", 2);
        actionToScore.put("C", 3);
        actionToScore.put("Z", 3);


        // V1: Reading input from data directory TODO: Try to read it directly from url
        File file = new File("src/data/adventofcode.com_2022_day_2_input.txt"); // TODO: Check why can't I do "./data/fileName"?
        Scanner sc = new Scanner(file);
        Long score = 0L;

        /*
                me: rock(1), elf: scissors(3)
                1 - 3 = -2                 WIN
                me: rock(1), elf: paper(2)
                1 - 2 = -1
                me: paper(2), elf: rock(1)
                2 - 1 = 1                  WIN
                me: paper(2), elf: scissors(3)
                2 - 3 = -1
                me: scissors(3), elf: rock(1)
                3 - 1 = 2
                me: scissors(3), elf: paper(2)
                3 - 2 = 1                  WIN
        */

        while (sc.hasNextLine()) {
            String movesString = sc.nextLine();
            String[] moves = movesString.split("\\s+");

            Integer myMoveValue = actionToScore.get(moves[1]);
            Integer opponentsMoveValue = actionToScore.get(moves[0]);
            Integer roundOutcome = myMoveValue - opponentsMoveValue;

            if (roundOutcome.equals(0)) {
                int currentRoundScore = myMoveValue + 3;
                score += currentRoundScore;
            } else if (roundOutcome.equals(1) || roundOutcome.equals(-2)) {
                int currentRoundScore = myMoveValue + 6;
                score += currentRoundScore;
            } else {
                score += myMoveValue;
            }
        }

        System.out.println(score);

        // PART II
        // X - lose
        // Y - draw
        // Z - win

        Scanner sc2 = new Scanner(file);
        Long score2 = 0L;

        while (sc2.hasNextLine()) {
            String movesString = sc2.nextLine();
            String[] moves = movesString.split("\\s+");

            Integer opponentsMoveValue = actionToScore.get(moves[0]);

            if (moves[1].equals("X")) {
                if (moves[0].equals("A")) {
                    score2 += 3;
                } else if (moves[0].equals("B")) {
                    score2 += 1;
                } else if (moves[0].equals("C")) {
                    score2 += 2;
                }
            } else if (moves[1].equals("Y")) {
                int roundScore = 3 + opponentsMoveValue;
                score2 += roundScore;
            } else if (moves[1].equals("Z")) {
                int roundScore = 6;

                if (moves[0].equals("A")) {
                    roundScore += 2;
                } else if (moves[0].equals("B")) {
                    roundScore += 3;
                } else if (moves[0].equals("C")) {
                    roundScore += 1;
                }

                score2 += roundScore;
            }
        }

        System.out.println(score2);
    }
}

        /*

        1. What is the purpose of wrapping InputStreamReader into BufferedReader?
            The BufferedReader can’t read the InputStream directly,
            so, we need to use an adapter like InputStreamReader to convert bytes to characters format.

        2. How to make it work? Now -> err 400: Puzzle inputs differ by user.  Please log in to get your puzzle input.
            TODO: Try to log in

        URL input = new URL("https://adventofcode.com/2022/day/2/input");

        BufferedReader in = new BufferedReader( // reads data (in characters) more efficiently
                new InputStreamReader(input.openStream()) // converts data in bytes into data in characters
        );

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();

         */