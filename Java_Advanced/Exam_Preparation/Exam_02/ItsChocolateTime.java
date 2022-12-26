import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class ItsChocolateTime {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            ArrayDeque<Double> milkQueue = new ArrayDeque<>();
            ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
            String[] milk = scanner.nextLine().split("\\s+");
            String[] cacao = scanner.nextLine().split("\\s+");

            for (int i = 0; i < milk.length; i++) {
                milkQueue.offer(Double.parseDouble(milk[i]));
            }
            for (int i = 0; i < cacao.length; i++) {
                cacaoStack.push(Double.parseDouble(cacao[i]));
            }

            double cacaoPercent = 0;
            int milkChocolateSum = 0;
            int darkChocolateSum = 0;
            int bakingChocolateSum = 0;
            while (!milkQueue.isEmpty()&&!cacaoStack.isEmpty()){
                double currentMilk = milkQueue.poll();
                double currentCacao = cacaoStack.pop();
                cacaoPercent = currentCacao/(currentMilk+currentCacao);
                if (cacaoPercent == 0.3){
                    milkChocolateSum++;
                } else if (cacaoPercent == 0.5) {
                    darkChocolateSum++;
                } else if (cacaoPercent == 1) {
                    bakingChocolateSum++;
                } else {
                    milkQueue.offer(currentMilk + 10);
                }

            }
            if (milkChocolateSum > 0 && darkChocolateSum > 0 && bakingChocolateSum > 0){
                System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            } else {
                System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
            }
            if (bakingChocolateSum > 0){
                System.out.printf("# Baking Chocolate --> %d%n", bakingChocolateSum);
            }
            if (darkChocolateSum > 0){
                System.out.printf("# Dark Chocolate --> %d%n", darkChocolateSum);
            }
            if (milkChocolateSum > 0){
                System.out.printf("# Milk Chocolate --> %d%n", milkChocolateSum);
            }
        }
}
