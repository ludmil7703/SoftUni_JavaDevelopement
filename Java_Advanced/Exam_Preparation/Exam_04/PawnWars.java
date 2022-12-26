import java.util.Scanner;
public class PawnWars {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int sizeOfMatrix = 8;
            int whiteRow = 0;
            int whiteCol = 0;
            int blackRow = 0;
            int blackCol = 0;

            char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

            for (int i = 0; i < sizeOfMatrix; i++) {
                matrix[i] = scanner.nextLine().toCharArray();
                for (int j = 0; j < sizeOfMatrix; j++) {
                    if (matrix[i][j] == 'w'){
                        whiteRow = i;
                        whiteCol = j;
                    }
                    if (matrix[i][j] == 'b'){
                        blackRow = i;
                        blackCol = j;
                    }
                }
            }
            while (whiteRow !=0 && blackRow !=7){

                if (isCaptureBlack(whiteRow, whiteCol, blackRow, blackCol)){
                    System.out.printf("Game over! White capture on %s%d.%n", signOfCol(blackCol), signOfRow(blackRow));
                    break;
                }
                matrix[whiteRow][whiteCol] = '-';
                whiteRow--;
                matrix[whiteRow][whiteCol] = 'w';

                if (whiteRow == 0){
                    System.out.printf("Game over! White pawn is promoted to a queen at %s%d.%n", signOfCol(whiteCol), signOfRow(whiteRow));
                    break;
                }


                if (isCaptureWhite(whiteRow, whiteCol, blackRow, blackCol)){
                    System.out.printf("Game over! Black capture on %s%d.%n", signOfCol(whiteCol), signOfRow(whiteRow));
                    break;
                }
                matrix[blackRow][blackCol] = '-';
                blackRow++;
                matrix[blackRow][blackCol] = 'b';

                if (blackRow == 7){
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s%d.%n", signOfCol(blackCol), signOfRow(blackRow));
                    break;
                }
            }
        }

        private static int signOfRow(int r) {
            if (r == 0) return 8;
            if (r == 1) return 7;
            if (r == 2) return 6;
            if (r == 3) return 5;
            if (r == 4) return 4;
            if (r == 5) return 3;
            if (r == 6) return 2;
            if (r == 7) return 1;
            return 0;
        }

        private static String signOfCol(int c) {
            if (c == 0) return "a";
            if (c == 1) return "b";
            if (c == 2) return "c";
            if (c == 3) return "d";
            if (c == 4) return "e";
            if (c == 5) return "f";
            if (c == 6) return "g";
            if (c == 7) return "h";
            return null;
        }

        private static boolean isCaptureBlack(int wr, int wc, int br, int bc) {
            return wr -1 == br && (wc -1 == bc || wc +1 == bc);
        }
        private static boolean isCaptureWhite(int wr, int wc, int br, int bc){
            return br + 1 == wr  && (wc == bc + 1 || wc == bc - 1);
        }
}
