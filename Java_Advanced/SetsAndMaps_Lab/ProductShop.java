import java.util.*;
public class ProductShop {
            public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            Map<String, Map<String, Double>> shops = new TreeMap<>();

            String input = scanner.nextLine();

            while (!input.equals("Revision")){
                String[] command = input.split(", ");
                String shop = command[0];
                String product = command[1];
                double price = Double.parseDouble(command[2]);

                shops.putIfAbsent(shop, new LinkedHashMap<>());
                Map<String, Double> products = shops.get(shop);
                products.putIfAbsent(product, price);


                input = scanner.nextLine();
            }

            shops.entrySet().stream()
                    .forEach(e ->
                    {
                        System.out.println(e.getKey() +"->");
                        e.getValue().entrySet().stream().forEach(innerEntry ->
                        {
                            System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());
                        });
                    });


        }
}
