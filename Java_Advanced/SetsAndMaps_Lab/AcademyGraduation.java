import java.text.DecimalFormat;
import java.util.*;
public class AcademyGraduation {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            Map<String, List<Double>> students = new TreeMap<>();

            int n = Integer.parseInt(scanner.nextLine());

            while (n-->0){
                String student = scanner.nextLine();
                String[] grades = scanner.nextLine().split("\\s+");

                students.putIfAbsent(student, new ArrayList<>());
                for (int i = 0; i < grades.length; i++) {
                    double grade = Double.parseDouble(grades[i]);
                    students.get(student).add(grade);
                }
            }

            students.entrySet().stream().forEach(e->
            { double gradeSum = 0.0;
                for (int i = 0; i < e.getValue().size(); i++) {
                    gradeSum += e.getValue().get(i);
                }
                DecimalFormat format = new DecimalFormat("#.################");

                System.out.printf("%s is graduated with %s%n", e.getKey(), format.format(gradeSum/e.getValue().size()));
            });
        }
}
