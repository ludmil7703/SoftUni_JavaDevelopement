import java.util.*;
public class FoodFinder {
            public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            Queue<Character> vowels = new ArrayDeque<>();
            Deque<Character> consonant = new ArrayDeque<>();
            String[] words = new String[]{"pear", "flour", "pork", "olive"};
            String[] foundWords = new String[]{"****", "*****", "****", "*****"};
            char[] charArr1 = scanner.nextLine().replace(" ", "").toCharArray();
            char[] charArr2 = scanner.nextLine().replace(" ", "").toCharArray();
            for (int i = 0; i < charArr1.length; i++) {
                vowels.offer(charArr1[i]);
            }
            for (int i = 0; i < charArr2.length; i++) {
                consonant.push(charArr2[i]);
            }
            while (!consonant.isEmpty()){
                char currentVowel = vowels.poll();
                char currentConstant = consonant.pop();
                for (int i = 0; i < words.length ; i++) {
                    int indexOfVowels = words[i].indexOf(currentVowel);
                    int indexOfConstant = words[i].indexOf(currentConstant);
                    if (indexOfVowels >= 0){

                        foundWords[i] = foundWords[i].substring(0, indexOfVowels)
                                + currentVowel
                                + foundWords[i].substring(indexOfVowels+1);
                    }
                    if (indexOfConstant >= 0){

                        foundWords[i] = foundWords[i].substring(0, indexOfConstant)
                                + currentConstant
                                + foundWords[i].substring(indexOfConstant+1);
                    }

                }
                vowels.offer(currentVowel);

            }
            int sumWords = Arrays.stream(foundWords).filter(e-> !e.contains("*")).toArray().length;
            System.out.println("Words found: " + sumWords);
            Arrays.stream(foundWords).filter(e-> !e.contains("*")).forEach(System.out::println);
        }
}
