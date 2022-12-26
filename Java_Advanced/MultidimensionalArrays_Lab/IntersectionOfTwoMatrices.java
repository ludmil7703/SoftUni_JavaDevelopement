import java.util.Scanner;
public class IntersectionOfTwoMatrices {
            public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            int M = Integer.parseInt(scanner.nextLine());
            int N = Integer.parseInt(scanner.nextLine());

            String [][] aMatrix=new String[M][N];
            String [][] bMatrix=new String[M][N];


            for (int rows = 0; rows < M; rows++) {
                aMatrix[rows] =scanner.nextLine().split("\\s+");
            }

            for (int rows = 0; rows < M; rows++) {
                bMatrix[rows] =scanner.nextLine().split("\\s+");
            }

            for (int rows = 0; rows < M; rows++) {
                for (int cols = 0; cols < N; cols++) {
                    if (aMatrix[rows][cols].equals(bMatrix[rows][cols])){
                        System.out.print(aMatrix[rows][cols] + " ");
                    } else {
                        System.out.print("*" + " ");
                    }
                }
                System.out.println();
            }
        }
}
