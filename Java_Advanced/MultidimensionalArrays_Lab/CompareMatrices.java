import java.util.Scanner;
public class CompareMatrices {
            public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);


            int arraysCount = scanner.nextInt();
            int sizeOfArray= scanner.nextInt();

            int[][] first=new int[arraysCount][sizeOfArray];

            for (int r = 0; r < arraysCount; r++) {
                for (int c = 0; c < sizeOfArray; c++) {
                    first[r][c]=scanner.nextInt();
                }
            }

            arraysCount = scanner.nextInt();
            sizeOfArray = scanner.nextInt();

            int[][] second = new int[arraysCount][sizeOfArray];

            for (int r = 0; r < arraysCount; r++) {
                for (int c = 0; c < sizeOfArray; c++) {
                    second[r][c]=scanner.nextInt();
                }
            }
            boolean areEqual = first.length == second.length && areArraysAreEqual(first, second);

            System.out.println(areEqual ? "equal" : "not equal");
        }

        private static boolean areArraysAreEqual(int[][] first, int[][] second) {

            for (int r = 0; r < first.length; r++) {

                int[] firstArr = first[r];
                int[] secondArr = second[r];

                if (firstArr.length != secondArr.length) {
                    return false;
                }

                for (int i = 0; i < firstArr.length; i++) {
                    int firstNumber = firstArr[i];
                    int secondNumber = secondArr[i];

                    if (firstNumber != secondNumber) {
                        return false;
                    }
                }
            }
            return true;
        }
}
