import java.util.Scanner;
public class NumberInRange {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String[] rangeOfNumber = scanner.nextLine().split("\\s+");
            int startIndex = Integer.parseInt(rangeOfNumber[0]);
            int endIndex = Integer.parseInt(rangeOfNumber[1]);

            System.out.printf("Range: [%d...%d]%n", startIndex, endIndex);
            int num = readNumber(scanner, startIndex, endIndex);
            System.out.println("Valid number: " + num);

        }

        private static int readNumber(Scanner scanner, int startIndex, int endIndex) {
            while (true) {
                String input = scanner.nextLine();
                try {
                    int validNumber = Integer.parseInt(input);
                    if (validNumber >= startIndex && validNumber <= endIndex) {

                        return validNumber;
                    }

                } catch (IllegalArgumentException ignored) {

                }
                System.out.println("Invalid number: " + input);
            }
        }
}
