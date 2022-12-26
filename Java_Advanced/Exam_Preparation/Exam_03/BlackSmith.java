import java.util.*;
import java.util.stream.Collectors;
public class BlackSmith {
          public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            Queue<Integer> steel = new ArrayDeque<>();
            Deque<Integer> carbon = new ArrayDeque<>();
            Map<String, Integer> swords = new TreeMap<>();

            int[] dataSteel = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < dataSteel.length; i++) {
                steel.offer(dataSteel[i]);
            }

            int[] dataCarbon = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < dataCarbon.length ; i++) {
                carbon.push(dataCarbon[i]);
            }
            swords.put("Gladius", 0);
            swords.put("Shamshir", 0);
            swords.put("Katana", 0);
            swords.put("Sabre", 0);

            while (!steel.isEmpty()&&!carbon.isEmpty()){
                int currentSteel = steel.poll();
                int currentCarbon = carbon.pop();
                int sum = currentSteel + currentCarbon;

                if (currentCarbon + currentSteel == 70){
                    swords.put("Gladius", swords.get("Gladius") + 1);
                }else if (currentCarbon + currentSteel == 80){
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                }else if (currentCarbon + currentSteel == 90){
                    swords.put("Katana", swords.get("Katana") + 1);
                }else if (currentCarbon + currentSteel == 110){
                    swords.put("Sabre", swords.get("Sabre") + 1);
                }else {
                    carbon.push(currentCarbon + 5);
                }

            }
            int sum = swords.values().stream().mapToInt(Integer::intValue).sum();

            if (sum == 0) {
                System.out.println("You did not have enough resources to forge a sword.");
            } else {
                System.out.printf("You have forged %d swords.%n", sum);
            }

            if (steel.isEmpty()) {
                System.out.println("Steel left: none");
            } else {
                System.out.print("Steel left: ");
                String collect = steel.stream().map(String::valueOf).collect(Collectors.joining(", "));
                System.out.println(collect);
            }
            if (carbon.isEmpty()){
                System.out.println("Carbon left: none");
            } else {
                System.out.print("Carbon left: ");
                String collect = carbon.stream().map(String::valueOf).collect(Collectors.joining(", "));
                System.out.println(collect);

            }
            swords.entrySet().stream().filter(e-> e.getValue() != 0)
                    .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        }
}
