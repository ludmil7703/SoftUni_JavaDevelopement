import java.util.Scanner;
public class Armory {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
            char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];
            int officerRow = 0;
            int officerRCol = 0;
            boolean isLeaves = false;

            for (int i = 0; i < sizeOfMatrix; i++) {
                matrix[i] = scanner.nextLine().replace(" ", "").toCharArray();
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'A'){
                        officerRow = i;
                        officerRCol = j;
                    }
                }
            }
            int coinsPaid = 0;
            String command = scanner.nextLine();
            while (isInbounds(sizeOfMatrix, officerRow, officerRCol)){
                if (command.equals("up") && isInbounds(sizeOfMatrix, officerRow, officerRCol)){
                    matrix[officerRow][officerRCol] = '-';
                    officerRow--;


                } else if (command.equals("down")) {
                    matrix[officerRow][officerRCol] = '-';
                    officerRow++;
                } else if (command.equals("right")) {
                    matrix[officerRow][officerRCol] = '-';
                    officerRCol++;
                } else if (command.equals("left")) {
                    matrix[officerRow][officerRCol] = '-';
                    officerRCol--;
                }
                if (!isInbounds(sizeOfMatrix, officerRow, officerRCol)){
                    isLeaves = true;
                    break;

                }

                if (Character.isDigit(matrix[officerRow][officerRCol])){
                    coinsPaid += Character.getNumericValue(matrix[officerRow][officerRCol]);
                    matrix[officerRow][officerRCol] = 'A';
                } else if (matrix[officerRow][officerRCol] == 'M'){
                    matrix[officerRow][officerRCol] = '-';
                    for (int i = 0; i < sizeOfMatrix; i++) {
                        for (int j = 0; j < sizeOfMatrix; j++) {
                            if (matrix[i][j] == 'M'){
                                officerRow = i;
                                officerRCol = j;
                                matrix[i][j] = 'A';
                                break;
                            }
                        }
                    }
                } else {
                    matrix[officerRow][officerRCol] = 'A';
                }
                if (coinsPaid > 65){
                    break;
                }
                command = scanner.nextLine();
            }
            if (isLeaves){
                System.out.println("I do not need more swords!");
            } else {
                System.out.println("Very nice swords, I will come back for more!");
            }
            System.out.printf("The king paid %d gold coins.%n", coinsPaid);
            for (int i = 0; i < sizeOfMatrix; i++) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }

        private static boolean isInbounds(int sizeOfMatrix, int r, int c) {
            return r >= 0 && r < sizeOfMatrix && c >= 0 && c < sizeOfMatrix;
        }
}
