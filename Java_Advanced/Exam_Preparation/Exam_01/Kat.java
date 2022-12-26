import java.util.*;
public class Kat {
           public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);

            Queue<Integer> plates = new ArrayDeque<>();
            Deque<Integer> cars = new ArrayDeque<>();

            int[] dataPlates = Arrays.stream(scanner.nextLine()
                            .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < dataPlates.length; i++) {
                plates.offer(dataPlates[i]);
            }

            int[] dataCars = Arrays.stream(scanner.nextLine()
                            .split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < dataCars.length ; i++) {
                cars.push(dataCars[i]);
            }
            int carRegistered = 0;
            int days = 0;
            while (!plates.isEmpty() && !cars.isEmpty()){
                int currentPlate= plates.poll();
                int currentCar= cars.pop();

                if (currentCar*2 < currentPlate) {
                    currentPlate -= currentCar*2;
                    carRegistered += currentCar;
                    days++;
                    plates.offer(currentPlate);
                } else  if(currentCar*2 > currentPlate){
                    currentCar -= currentPlate/2;
                    carRegistered += currentPlate/2;
                    days++;
                    cars.offer(currentCar);
                } else {
                    carRegistered += currentCar;
                    days++;
                }
            }
            System.out.printf("%d cars were registered for %d days!%n", carRegistered, days);
            int restingPlates = 0;
            int carsWithoutPlates = 0;
            if (!plates.isEmpty()){
                while (!plates.isEmpty()){
                    restingPlates+=plates.poll();
                }
                System.out.printf("%d license plates remain!%n", restingPlates);
            } else if (!cars.isEmpty()) {
                while (!cars.isEmpty()){
                    carsWithoutPlates+=cars.pop();
                }
                System.out.printf("%s cars remain without license plates!", carsWithoutPlates);

            } else {
                System.out.println("Good job! There is no queue in front of the KAT!");

            }
        }
}
