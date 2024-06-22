package finalQuiz;

import java.time.LocalDate;

public class DeliveryThread implements Runnable{
    private String location;
    private LocalDate deliveryDate;
    private int totalDistanceKm;
    private int groupValue;
    private int groupRevenue;

    public DeliveryThread(String location, LocalDate deliveryDate, int totalDistanceKm, int groupValue, int groupRevenue) {
        this.location = location;
        this.deliveryDate = deliveryDate;
        this.totalDistanceKm = totalDistanceKm;
        this.groupValue = groupValue;
        this.groupRevenue = groupRevenue;
    }

    @Override
    public void run() {
        int deliveryTimeSeconds = totalDistanceKm;


        System.out.println("-----------------------------------------");
        System.out.printf("[Delivering for %s and date %s in %d seconds]%n", location, deliveryDate, deliveryTimeSeconds);


        try {
            Thread.sleep(deliveryTimeSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Delivery completed for %s on %s.%n", location, deliveryDate);
        System.out.printf("Group value: %d, Group revenue: %d LEU%n", groupValue, groupRevenue);
    }
}
