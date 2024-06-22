package finalQuiz;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageManager {
    private static final double PRICE_PER_KM = 1.0; 

    public static void main(String[] args) {
        List<Package> packages = new ArrayList<>();

        // Load data from file into packages list
        try (BufferedReader br = new BufferedReader(new FileReader("packages.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String targetLocation = parts[0].trim();
                int targetDistanceKm = Integer.parseInt(parts[1].trim());
                int packageValue = Integer.parseInt(parts[2].trim());
                LocalDate deliveryDate = LocalDate.parse(parts[3].trim());

                Package packageInfo = new Package(targetLocation, targetDistanceKm, packageValue, deliveryDate);
                packages.add(packageInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        int totalValueOfAllPackages = 0;
        int totalRevenueOfAllGroups = 0;
        for(Package p:packages) {
            Thread deliveryThread = new Thread(new DeliveryThread(p.getLocation(), p.getDeliveryDate(), p.getDistance(),0, 0));
            deliveryThread.start();
        }

        System.out.println("\nRESULT:");
        System.out.printf("Total value of all delivered packages: %d%n", totalValueOfAllPackages);
        System.out.printf("Total value of the revenue computed for all groups delivered: %d LEU%n", totalRevenueOfAllGroups);
    }
}
