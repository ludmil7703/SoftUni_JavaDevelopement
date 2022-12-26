import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class SoftUniParty {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            String input = scanner.nextLine();

            Set<String> VIP = new TreeSet<>();
            Set<String> regular = new TreeSet<>();

            while (!input.equals("PARTY")){

                boolean isVip = Character.isDigit(input.charAt(0));

                if (isVip){
                    VIP.add(input);
                } else {
                    regular.add(input);
                }

                input = scanner.nextLine();;
            }
            input = scanner.nextLine();

            while (!input.equals("END")){

                boolean isVip = Character.isDigit(input.charAt(0));

                if (isVip){
                    VIP.remove(input);

                } else {
                    regular.remove(input);

                }


                input = scanner.nextLine();;
            }
            System.out.println(VIP.size()+ regular.size());
            for (String r : VIP) {
                System.out.println(r);
            }
            for (String s : regular) {
                System.out.println(s);

            }
        }
}
