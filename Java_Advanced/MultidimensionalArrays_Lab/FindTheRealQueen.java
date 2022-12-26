import java.util.Scanner;
public class FindTheRealQueen {
            public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            char[][] matrix = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String[] s = scanner.nextLine().split("\\s+");

                for (int j = 0; j <8; j++) {
                    char currentChar = s[j].charAt(0);

                    matrix[i][j] = currentChar;
                }
            }
            boolean isFound = false;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (isOneQueen(matrix,matrix[i][j], i, j)){
                        System.out.println(i + " " + j);
                        isFound =true;
                        break;
                    }
                }
                if (isFound){
                    break;
                }
            }
        }
        public static boolean isOneQueen(char[][] matrix,char currentSymbol, int row, int col){
            for (int i = 0; i < 8; i++) {
                if (matrix[row][i] == currentSymbol && i!=col){
                    return false;
                }
            }
            for (int i = 0; i < 8; i++) {
                if (matrix[i][col] == currentSymbol && i != row){
                    return false;
                }
            }


            while (isOutOfBound(row, col)){
                int currentRow = row;
                int currentCol = col;
                currentRow++;currentCol--;
                if (matrix[currentRow][currentCol] == currentSymbol){
                    return false;
                }
            }
            while (isOutOfBound(row, col)){
                int currentRow = row;
                int currentCol = col;
                currentRow--;currentCol++;
                if (matrix[currentRow][currentCol] == currentSymbol){
                    return false;
                }

            }
            while (isOutOfBound(row, col)){
                int currentRow = row;
                int currentCol = col;
                currentRow++;currentCol++;
                if (matrix[currentRow][currentCol] == currentSymbol){
                    return false;
                }
            }
            while (isOutOfBound(row, col)){
                int currentRow = row;
                int currentCol = col;
                currentRow--;currentCol--;
                if (matrix[currentRow][currentCol] == currentSymbol){
                    return false;
                }
            }


            return true;
        }
        public static boolean isOutOfBound(int row, int col){
            if (row>=0 && row<8 && col>=0 &&col<8){
                return false;
            }
            return true;
        }
}
