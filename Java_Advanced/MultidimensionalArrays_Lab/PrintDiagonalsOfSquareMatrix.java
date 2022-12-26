import java.util.Arrays;
import java.util.Scanner;
public class PrintDiagonalsOfSquareMatrix {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            int n=Integer.parseInt(scanner.nextLine());

            int[][] matrix=new int[n][n];

            for (int rows = 0; rows < n; rows++) {
                matrix[rows]= Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            for (int rows = 0; rows < n; rows++) {
                System.out.print(matrix[rows][rows]+ " ");
            }
            System.out.println();
            int cols=0;
            for (int rows = n-1; rows >=0; rows--) {
                System.out.print(matrix[rows][cols]+" ");
                cols++;
            }
        }
}
