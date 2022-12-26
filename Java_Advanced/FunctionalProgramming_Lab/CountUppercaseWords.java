import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class CountUppercaseWords {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            AtomicInteger sum = new AtomicInteger();
            Predicate<String> isUppercase = w->Character.isUpperCase(w.charAt(0));

            words.stream().filter(isUppercase)
                    .forEach(n-> {
                        sum.getAndIncrement();});
            System.out.println(sum);
            words.stream().filter(isUppercase)
                    .forEach(System.out::println);
        }
}
