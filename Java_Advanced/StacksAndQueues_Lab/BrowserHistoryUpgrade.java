import java.util.ArrayDeque;
import java.util.Scanner;
public class BrowserHistoryUpgrade {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();


            String currentUrl=null;

            ArrayDeque<String> history=new ArrayDeque<>();
            ArrayDeque<String> forward=new ArrayDeque<>();
            while (!input.equals("Home")){
                if (input.equals("back")){
                    if (history.isEmpty()){
                        System.out.println("no previous URLs");
                        input= scanner.nextLine();
                        continue;
                    } else {
                        forward.push(currentUrl);
                        currentUrl=history.pop();

                    }

                } else if (input.equals("forward")){
                    if (!forward.isEmpty()) {
                        history.push(currentUrl);
                        currentUrl=forward.pop();

                    } else {
                        System.out.println("no next URLs");
                        input= scanner.nextLine();
                        continue;
                    }
                }
                else {
                    if (currentUrl!=null) {
                        history.push(currentUrl);
                    }
                    currentUrl=input;
                    forward.clear();
                }
                if (currentUrl!=null){
                    System.out.println(currentUrl);
                }

                input= scanner.nextLine();

            }

        }
}
