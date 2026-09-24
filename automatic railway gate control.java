import java.util.Scanner;

public class AutomaticRailwayGate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("   AUTOMATIC RAILWAY CONTROL GATE");
        System.out.println("======================================");

        System.out.print("Is train detected? (yes/no): ");
        String trainDetected = sc.nextLine();

        System.out.print("Is another train detected? (yes/no): ");
        String secondTrain = sc.nextLine();

        System.out.println("\n---------- SYSTEM STATUS ----------");

        if (trainDetected.equalsIgnoreCase("yes")
                || secondTrain.equalsIgnoreCase("yes")) {

            System.out.println("Train Detected!");
            System.out.println("Warning Signal: ON");
            System.out.println("Buzzer: ON");
            System.out.println("Railway Gate: CLOSING");
            System.out.println("Gate Status: CLOSED");
            System.out.println("Road Traffic: STOPPED");

        } else {

            System.out.println("No Train Detected.");
            System.out.println("Warning Signal: OFF");
            System.out.println("Buzzer: OFF");
            System.out.println("Railway Gate: OPENING");
            System.out.println("Gate Status: OPEN");
            System.out.println("Road Traffic: ALLOWED");
        }

        System.out.println("------------------------------------");

        sc.close();
    }
}
