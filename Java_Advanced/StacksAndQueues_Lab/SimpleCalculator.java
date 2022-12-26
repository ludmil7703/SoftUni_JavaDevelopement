import java.util.ArrayDeque;
import java.util.Scanner;
public class SimpleCalculator {
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            ArrayDeque<String> stack1=new ArrayDeque<>();

            String[] expression=scanner.nextLine().split("\\s+");
            for (int i = 0; i < expression.length; i++) {
                stack1.push(expression[i]);
            }
            ArrayDeque<String> stack=new ArrayDeque<>();
            for (int i = 0; i < expression.length; i++) {
                stack.push(stack1.pop());
            }

            int number=Integer.parseInt(stack.pop());
            int result=number;
            while (!stack.isEmpty()){
                if (stack.peek().equals("+")){
                    stack.pop();
                    result+=Integer.parseInt(stack.pop());
                } else if (stack.peek().equals("-")) {
                    stack.pop();
                    result-=Integer.parseInt(stack.pop());
                }
            }
            System.out.println(result);
        }
}
