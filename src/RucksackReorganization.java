import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RucksackReorganization {
    private static int calculatePriority(char ch) {
        String lowercaseArr = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseArr = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

        int baseLowercasePriority = 1;
        int baseUppercasePriority = 27;

        int priority = Character.isUpperCase(ch) ?
                baseUppercasePriority + uppercaseArr.indexOf(ch) :
                baseLowercasePriority + lowercaseArr.indexOf(ch);

        return priority;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/data/adventofcode.com_2022_day_3_input.txt");

        // PART I

        Scanner sc1 = new Scanner(file);
        Long sumOfPriorities1 = 0L;

        while (sc1.hasNextLine()) {
            String rucksack = sc1.nextLine();
            int middle = rucksack.length() / 2;
            char[] comp1 = rucksack.substring(0, middle).toCharArray();
            String comp2 = rucksack.substring(middle);

            for (char ch : comp1) {
                if (comp2.contains(String.valueOf(ch))) {
                    sumOfPriorities1 += calculatePriority(ch); // TODO: explore -> "Non-static method 'calculatePriority(char)' cannot be referenced from a static context" -> why I had to make calculatePriority static?
                    break;
                }
            }
        }

        System.out.println(sumOfPriorities1);

        // PART II

        Scanner sc2 = new Scanner(file);
        Long sumOfPriorities2 = 0L;

        while (sc2.hasNextLine()) {
            String rucksack1 = sc2.nextLine();

            if (sc2.hasNextLine()) {
                String rucksack2 = sc2.nextLine();

                if (sc2.hasNextLine()) {
                    String rucksack3 = sc2.nextLine();

                    char[] itemsInRucksack1 = rucksack1.toCharArray();
                    for (char ch : itemsInRucksack1) {
                        String itemToCheck = String.valueOf(ch);
                        if (rucksack2.contains(itemToCheck) && rucksack3.contains(itemToCheck)) {
                            System.out.println(
                                    itemToCheck + ": " +
                                            rucksack1 + ", " +
                                            rucksack2 + ", " +
                                            rucksack3
                            );

                            sumOfPriorities2 += calculatePriority(ch);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(sumOfPriorities2);
    }
}
