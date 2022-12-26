import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class AverageStudentsGrades {
            public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            int numberOfStudent = Integer.parseInt(scanner.nextLine());

            Map<String, ArrayList<Double>> studentMapGrade = new TreeMap<>();

            for (int i = 0; i < numberOfStudent; i++) {

                String[] input = scanner.nextLine().split("\\s+");

                String name = input[0];
                double grade = Double.parseDouble(input[1]);

                if (!studentMapGrade.containsKey(name)){
                    studentMapGrade.put(name, new ArrayList<>());
                    studentMapGrade.get(name).add(grade);
                } else {
                    studentMapGrade.get(name).add(grade);
                }

            }
            for (String student : studentMapGrade.keySet()) {
                System.out.print(student + " -> ");
                double gradeSum = 0;
                for (int i = 0; i < studentMapGrade.get(student).size(); i++) {
                    double currentGrade = studentMapGrade.get(student).get(i);
                    System.out.printf("%.2f ", currentGrade);
                    gradeSum +=currentGrade;

                }
                double average = gradeSum/studentMapGrade.get(student).size();
                System.out.printf("(avg: %.2f)%n", average);
            }
        }
}
