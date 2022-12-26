import java.util.Scanner;
public class StickyFingers {

        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int dillingerRow = 0;
            int dillingerCol = 0;
            int stolenMoney = 0;

            int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

            String[] commandsPart = scanner.nextLine().split(",");
            String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

            for (int i = 0; i < sizeOfMatrix; i++) {
                String[] rowOfMatrix = scanner.nextLine().split("\\s+");
                matrix[i] = rowOfMatrix;
                for (int j = 0; j < sizeOfMatrix; j++) {
                    if (matrix[i][j].equals("D")){
                        dillingerRow = i;
                        dillingerCol = j;
                    }
                }
            }
            boolean isJail = false;
            int money = 0;
            for (int i = 0; i < commandsPart.length; i++) {
                String command = commandsPart[i];

                if (command.equals("left") && isInBounds(matrix, dillingerRow, dillingerCol-1)){
                    matrix[dillingerRow][dillingerCol] = "+";
                    dillingerCol--;


                } else if (command.equals("right") && isInBounds(matrix, dillingerRow, dillingerCol+1)) {
                    matrix[dillingerRow][dillingerCol] = "+";
                    dillingerCol++;

                } else if (command.equals("up") && isInBounds(matrix, dillingerRow-1, dillingerCol)) {
                    matrix[dillingerRow][dillingerCol] = "+";
                    dillingerRow--;


                } else if (command.equals("down") && isInBounds(matrix, dillingerRow+1, dillingerCol)) {
                    matrix[dillingerRow][dillingerCol] = "+";
                    dillingerRow++;


                } else {

                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;
                }

                if (matrix[dillingerRow][dillingerCol].equals("$")){
                    money =dillingerCol*dillingerRow;
                    stolenMoney += money;
                    matrix[dillingerRow][dillingerCol] = "D";
                    System.out.printf("You successfully stole %d$.%n", money);
                } else if (matrix[dillingerRow][dillingerCol].equals("P")) {
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                    matrix[dillingerRow][dillingerCol] = "#";
                    isJail =true;
                    break;
                } else {
                    matrix[dillingerRow][dillingerCol] = "D";
                }
                if (isJail){
                    break;
                }

            }
            if (!isJail){
                System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney );
            }
            for (int i = 0; i < sizeOfMatrix; i++) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        private static boolean isInBounds(String[][] matrix, int r, int c) {
            return r >= 0 && r < matrix.length && c >= 0 && c < matrix.length;
        }
}
