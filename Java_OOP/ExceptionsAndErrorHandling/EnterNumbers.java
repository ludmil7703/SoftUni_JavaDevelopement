import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class EnterNumbers {
           public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] array = new int[10];
            int start = 1;
            int end = 100;


            for (int i = 1; i < 11; i++) {

                int num = readNumber(scanner, start, end);
                start = num;
                array[i-1] = num;

            }
            String result = IntStream.of(array)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(result);

        }

        private static int readNumber(Scanner scanner, int start, int end) {
            String input = scanner.nextLine();
            while (true) {
                try {
                    int number = Integer.parseInt(input);
                    if (number > start && number < end) {
                        return number;
                    } else {
                        System.out.printf("Your number is not in range %d - 100!%n", start);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid Number!");

                }
                input = scanner.nextLine();
            }

        }
}
