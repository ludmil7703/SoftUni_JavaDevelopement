import java.util.Arrays;
import java.util.Scanner;
public class MaximumSumOf2x2SubMatrix {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            String[] command=scanner.nextLine().split(", ");

            int rows= Integer.parseInt(command[0]);
            int cols= Integer.parseInt(command[1]);

            int[][] matrix = new int[rows][cols];
            int[][] maxSumMatrix= new int[2][2];

            for (int r = 0; r < rows; r++) {
                matrix[r] = Arrays.stream(scanner.nextLine().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

            }
            int maxSum=Integer.MIN_VALUE;

            for (int r = 0; r < matrix.length-1; r++) {
                for (int c = 0; c < matrix[r].length-1; c++) {
                    int sum=0;

                    sum =      matrix[r][c]  +   matrix[r][c+1]
                            + matrix[r+1][c] + matrix[r+1][c+1];

                    if (sum > maxSum){
                        maxSum=sum;

                        maxSumMatrix[0][0]=matrix[r][c];
                        maxSumMatrix[0][1]=matrix[r][c+1];
                        maxSumMatrix[1][0]=matrix[r+1][c];
                        maxSumMatrix[1][1]=matrix[r+1][c+1];
                    }
                }
            }

            for(int[] arr : maxSumMatrix){
                for (int n : arr){
                    System.out.print(n + " ");
                }
                System.out.println();
            }
            System.out.println(maxSum);

        }
}
