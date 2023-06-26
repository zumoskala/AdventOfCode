import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CampCleanup {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/data/adventofcode.com_2022_day_4_input.txt");

        // PART I
        Scanner sc = new Scanner(file);

        Long count = 0L;

        while (sc.hasNextLine()) {
            String[] sectionsForPair = sc.nextLine().split(",");
            String[] firstElfSection = sectionsForPair[0].split("-");
            String[] secondElfSection = sectionsForPair[1].split("-");

            if (
                    Integer.valueOf(firstElfSection[0]) >= Integer.valueOf(secondElfSection[0]) &&
                            Integer.valueOf(firstElfSection[1]) <= Integer.valueOf(secondElfSection[1]) ||
                            Integer.valueOf(firstElfSection[0]) <= Integer.valueOf(secondElfSection[0]) &&
                                    Integer.valueOf(firstElfSection[1]) >= Integer.valueOf(secondElfSection[1])
            ) {
                count++;
            }
        }
        System.out.println(count);

        // PART II
        Scanner sc2 = new Scanner(file);

        Long overlapCount = 0L;

        while (sc2.hasNextLine()) {
            String[] sectionsForPair = sc2.nextLine().split(",");
            String[] firstElfSection = sectionsForPair[0].split("-");
            String[] secondElfSection = sectionsForPair[1].split("-");

            if (
                    Integer.valueOf(firstElfSection[0]) >= Integer.valueOf(secondElfSection[0]) && Integer.valueOf(firstElfSection[0]) <= Integer.valueOf(secondElfSection[1]) ||
                            Integer.valueOf(firstElfSection[1]) >= Integer.valueOf(secondElfSection[0]) && Integer.valueOf(firstElfSection[1]) <= Integer.valueOf(secondElfSection[1]) ||
                            Integer.valueOf(secondElfSection[1]) >= Integer.valueOf(firstElfSection[0]) && Integer.valueOf(secondElfSection[1]) <= Integer.valueOf(firstElfSection[1])
            ) {
                overlapCount++;
            }
        }
        System.out.println(overlapCount);
    }
}
