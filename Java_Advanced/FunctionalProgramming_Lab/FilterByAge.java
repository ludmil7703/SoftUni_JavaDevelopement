import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class FilterByAge {
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            Map<String, Integer> map =new LinkedHashMap<>();
            int n =Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                String[] data = scanner.nextLine().split(", ");
                String name = data[0];
                int age =Integer.parseInt(data[1]);
                map.putIfAbsent(name, age);
                if (!map.containsKey(name)){
                    map.put(name, age);
                }
            }
            String condition = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String[] printOrder = scanner.nextLine().split(" ");
            if (printOrder.length == 1&&printOrder[0].equals("name")) {

                printName(map, condition, age);
            }
            if (printOrder.length == 1 && printOrder[0].equals("age")) {

                printAge(map, condition, age);
            }

            if (printOrder.length>1) {
                printNameAge(map, condition, age);

            }



        }

        private static void printAge(Map<String, Integer> map, String condition, int age) {
            if (condition.equals("older")) {
                map.entrySet().stream()
                        .filter(e -> e.getValue() >= age)
                        .forEach(e -> System.out.printf("%d%n", e.getValue()));
            } else if (condition.equals("younger")) {
                map.entrySet().stream()
                        .filter(e -> e.getValue() <= age)
                        .forEach(e -> System.out.printf("%d%n",e.getValue()));
            }
        }

        private static void printName(Map<String, Integer> map, String condition, int age) {
            if (condition.equals("older")) {
                map.entrySet().stream()
                        .filter(e -> e.getValue() >= age)
                        .forEach(e -> System.out.printf("%s%n", e.getKey()));
            } else if (condition.equals("younger")) {
                map.entrySet().stream()
                        .filter(e -> e.getValue() <= age)
                        .forEach(e -> System.out.printf("%s%n", e.getKey()));
            }
        }

        private static void printNameAge(Map<String, Integer> map, String condition, int age) {
            if (condition.equals("older")) {
                map.entrySet().stream()
                        .filter(e -> e.getValue() >= age)
                        .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
            } else if (condition.equals("younger")) {
                map.entrySet().stream()
                        .filter(e -> e.getValue() <= age)
                        .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
            }
        }
}
