import java.util.Scanner;
public class SquareRoot {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            calcSqrt(scanner);

        }

        private static void calcSqrt(Scanner scanner) {
            String input = scanner.nextLine();
            try {
                int validNumber = Integer.parseInt(input);
                if (validNumber > 0) {

                    System.out.printf("%.2f%n",Math.sqrt(validNumber));
                } else {
                    System.out.println("Invalid");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid");

            } finally {
                System.out.println("Goodbye");
            }

        }
    }
