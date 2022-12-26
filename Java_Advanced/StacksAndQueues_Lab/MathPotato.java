import java.util.ArrayDeque;
import java.util.Scanner;
public class MathPotato {
        public static boolean primeNumber(int num) {

            if(num <= 1){
                return false;
            }

            for(int i = 2; i < num; i++) {
                if(num % i == 0) {
                    return false;
                }
            }

            return true;

        }
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            String[] names=scanner.nextLine().split("\\s+");
            int n=Integer.parseInt(scanner.nextLine());
            ArrayDeque<String> potato=new ArrayDeque<>();
            ArrayDeque<String> currentPotato=new ArrayDeque<>();
            int cicle=1;

            for (int i = 0; i < names.length; i++) {
                potato.offer(names[i]);
            }
            while (potato.size()>1){

                for (int i = 1; i <n ; i++) {
                    String currentName= potato.poll();
                    for (int j = 0;  !potato.isEmpty(); j++) {
                        currentPotato.offer(potato.poll());
                    }

                    for (int j = 0; !currentPotato.isEmpty(); j++) {
                        potato.offer(currentPotato.poll());
                    }
                    potato.offer(currentName);


                }

                if (!primeNumber(cicle)||cicle==1) {

                    System.out.println("Removed " + potato.poll());
                    cicle++;
                } else {
                    System.out.println("Prime "+potato.peek());
                    cicle++;
                }

            }
            System.out.println("Last is "+potato.poll());
        }

}
