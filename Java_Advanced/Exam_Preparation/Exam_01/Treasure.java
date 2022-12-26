
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Treasure {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];
        int hunterRow = 0;
        int hunterCol = 0;

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j].equals("Y")){
                    hunterRow = i;
                    hunterCol = j;
                }
            }
        }
        List<String> commands = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Finish")){

            switch (input){
                case "up":
                    if(hunterRow -1 >= 0 && !matrix[hunterRow-1][hunterCol].equals("T") ){
                        hunterRow--;
                        commands.add(input);
                    }
                    break;
                case "down":
                    if (hunterRow + 1 < matrix.length && !matrix[hunterRow+1][hunterCol].equals("T") ){

                        hunterRow++;
                        commands.add(input);
                    }
                    break;
                case "left":
                    if (hunterCol - 1 >= 0 && !matrix[hunterRow][hunterCol-1].equals("T")){
                        hunterCol--;
                        commands.add(input);
                    }
                    break;
                case "right":
                    if (hunterCol + 1 < matrix[hunterRow].length && !matrix[hunterRow][hunterCol+1].equals("T")){
                        hunterCol++;
                        commands.add(input);
                    }
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();

        }
        if (matrix[hunterRow][hunterCol].equals("X")){
            System.out.println("I've found the treasure!");

            System.out.print("The right path is ");
            System.out.print(String.join(", ", commands));
        } else {
            System.out.println("The map is fake!");
        }
    }
}
