import java.util.Scanner;

public class ThreePhaseFaultProtection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println(" THREE-PHASE FAULT DIRECTION & PROTECTION");
        System.out.println("======================================");

        System.out.print("Enter Phase A current (A): ");
        double ia = sc.nextDouble();

        System.out.print("Enter Phase B current (A): ");
        double ib = sc.nextDouble();

        System.out.print("Enter Phase C current (A): ");
        double ic = sc.nextDouble();

        System.out.print("Enter Phase A voltage (V): ");
        double va = sc.nextDouble();

        System.out.print("Enter Phase B voltage (V): ");
        double vb = sc.nextDouble();

        System.out.print("Enter Phase C voltage (V): ");
        double vc = sc.nextDouble();

        System.out.print("Enter maximum allowable current (A): ");
        double limit = sc.nextDouble();

        // Find maximum phase current
        double maxCurrent = Math.max(ia, Math.max(ib, ic));

        System.out.println("\n---------- SYSTEM STATUS ----------");

        if (maxCurrent > limit) {

            System.out.println("FAULT DETECTED!");
            System.out.printf("Maximum Current: %.2f A%n", maxCurrent);

            // Determine faulted phase
            if (ia == maxCurrent) {
                System.out.println("Faulted Phase: A");
            }

            if (ib == maxCurrent) {
                System.out.println("Faulted Phase: B");
            }

            if (ic == maxCurrent) {
                System.out.println("Faulted Phase: C");
            }

            // Simple directional indication
            double voltageSum = va + vb + vc;
            double currentSum = ia + ib + ic;

            if (currentSum * voltageSum > 0) {
                System.out.println("Fault Direction: FORWARD");
            } else {
                System.out.println("Fault Direction: REVERSE");
            }

            System.out.println("Protection Action: CIRCUIT BREAKER TRIP");

        } else {

            System.out.println("System Status: NORMAL");
            System.out.println("Protection Action: NO TRIP");
        }

        System.out.println("-----------------------------------");

        sc.close();
    }
}
