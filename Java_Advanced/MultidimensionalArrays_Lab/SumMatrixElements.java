import java.util.Scanner;
public class SumMatrixElements {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            String[] command=scanner.nextLine().split(", ");

            int rows= Integer.parseInt(command[0]);
            int cols= Integer.parseInt(command[1]);

            int[][] matrix = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                command=scanner.nextLine().split(", ");
                for (int c = 0; c < cols; c++) {
                    matrix[r][c] = Integer.parseInt(command[c]);
                }
            }
            int sum=0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    sum+=matrix[r][c];
                }
            }
            System.out.println(rows);
            System.out.println(cols);
            System.out.println(sum);
        }
}
