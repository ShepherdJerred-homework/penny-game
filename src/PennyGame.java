// Penny Game
// Jerred Shepherd
// O(N)

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class PennyGame {
    private static final int NUMBER_OF_TOSSES_IN_ONE_GAME = 40;

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("penny.in.txt");
        File outputFile = new File("penny.out.txt");

        Scanner scanner = new Scanner(inputFile);
        String input = scanner.nextLine();

        PrintWriter printWriter = new PrintWriter(outputFile);

        int numberOfGames = Integer.valueOf(input);

        for (int i = 0; i < numberOfGames; i++) {
            input = scanner.nextLine();
            HashMap<String, Integer> map = new HashMap<>();

            // TODO need to consider overlaps
            for (int n = 0; n < NUMBER_OF_TOSSES_IN_ONE_GAME - 2; n++) {
                String s = input.substring(n, n + 3).toUpperCase();
                if (map.containsKey(s)) {
                    int x = map.get(s);
                    x += 1;
                    map.put(s, x);
                } else {
                    map.put(s, 1);
                }
            }

            String output = String.format("%s %s %s %s %s %s %s %s",
                    map.getOrDefault("TTT", 0),
                    map.getOrDefault("TTH", 0),
                    map.getOrDefault("THT", 0),
                    map.getOrDefault("THH", 0),
                    map.getOrDefault("HTT", 0),
                    map.getOrDefault("HTH", 0),
                    map.getOrDefault("HHT", 0),
                    map.getOrDefault("HHH", 0)
            );

            printWriter.println(output);
            System.out.println(output);
        }

        printWriter.close();
    }
}
