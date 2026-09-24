import java.util.Scanner;

public class SmartGridEnergyManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("     SMART GRID ENERGY MANAGEMENT");
        System.out.println("========================================");

        System.out.print("Enter total energy generated (kWh): ");
        double generatedEnergy = sc.nextDouble();

        System.out.print("Enter residential load (kWh): ");
        double residentialLoad = sc.nextDouble();

        System.out.print("Enter commercial load (kWh): ");
        double commercialLoad = sc.nextDouble();

        System.out.print("Enter industrial load (kWh): ");
        double industrialLoad = sc.nextDouble();

        System.out.print("Enter battery capacity (kWh): ");
        double batteryCapacity = sc.nextDouble();

        System.out.print("Enter current battery energy (kWh): ");
        double batteryEnergy = sc.nextDouble();

        // Total demand
        double totalDemand =
                residentialLoad +
                commercialLoad +
                industrialLoad;

        // Energy balance
        double energyBalance = generatedEnergy - totalDemand;

        System.out.println("\n---------- ENERGY REPORT ----------");

        System.out.printf("Energy Generated     : %.2f kWh%n",
                generatedEnergy);

        System.out.printf("Residential Load     : %.2f kWh%n",
                residentialLoad);

        System.out.printf("Commercial Load      : %.2f kWh%n",
                commercialLoad);

        System.out.printf("Industrial Load      : %.2f kWh%n",
                industrialLoad);

        System.out.printf("Total Energy Demand  : %.2f kWh%n",
                totalDemand);

        System.out.printf("Energy Balance       : %.2f kWh%n",
                energyBalance);

        System.out.printf("Battery Energy       : %.2f kWh%n",
                batteryEnergy);

        System.out.printf("Battery Capacity     : %.2f kWh%n",
                batteryCapacity);

        System.out.println("\n---------- GRID ACTION ----------");

        if (energyBalance > 0) {

            double availableSpace =
                    batteryCapacity - batteryEnergy;

            double energyToBattery =
                    Math.min(energyBalance, availableSpace);

            batteryEnergy += energyToBattery;

            double excessEnergy =
                    energyBalance - energyToBattery;

            System.out.println("Energy Surplus Detected");
            System.out.printf("Energy Stored        : %.2f kWh%n",
                    energyToBattery);

            if (excessEnergy > 0) {
                System.out.printf("Energy Exported      : %.2f kWh%n",
                        excessEnergy);
            }

        } else if (energyBalance < 0) {

            double energyRequired = Math.abs(energyBalance);

            double batteryUsed =
                    Math.min(energyRequired, batteryEnergy);

            batteryEnergy -= batteryUsed;

            double gridEnergy =
                    energyRequired - batteryUsed;

            System.out.println("Energy Deficit Detected");
            System.out.printf("Battery Supplied     : %.2f kWh%n",
                    batteryUsed);

            if (gridEnergy > 0) {
                System.out.printf("Grid Energy Required : %.2f kWh%n",
                        gridEnergy);
            }

        } else {

            System.out.println("Energy Generation Matches Demand");
        }

        System.out.printf("Final Battery Level  : %.2f kWh%n",
                batteryEnergy);

        System.out.println("----------------------------------");

        sc.close();
    }
}
