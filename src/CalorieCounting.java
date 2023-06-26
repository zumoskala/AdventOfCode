import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CalorieCounting {
    public static void main(String[] args) throws FileNotFoundException {
        List<Long> calories = new ArrayList<Long>();

        File file = new File(
                "C:\\Users\\zuzan\\Repozytoria\\AdventOfCode\\src\\Day 1\\adventofcode.com_2022_day_1_input.txt"
        );
        Scanner sc = new Scanner(file);

        Long current = 0L;

        while (sc.hasNextLine()) {//hasNextLine - another line of text, hasNext - any more non-whitespace characters
            String currentLine = sc.nextLine();
            if (currentLine.isEmpty()) {
                calories.add(current);
                current = 0L;
            } else {
                current += Integer.parseInt(currentLine);
            }
        }

        Collections.sort(calories);
        /*
        I need mapToLong bc stream is a generic type.
        As calories.stream() returns an object of Type Stream and Stream interface does not have any method like sum.
        calories.stream().mapToLong(e -> e) returns LongStream which has the sum method.
        */
        Long topThree = calories.subList(calories.size()-3, calories.size()).stream().mapToLong(n -> n).sum();
        System.out.println(topThree);
    }
}
