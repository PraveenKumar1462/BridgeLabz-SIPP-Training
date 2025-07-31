package Workshop;
import java.util.HashSet;
import java.util.Set;

public class RouteTrackerSystem {
    public interface Checkpoint {
        String getCheckpointId();
        String getLocationName();
        double getDistanceFromLast();
        double getExpectedDuration();
        double getActualDuration();
        boolean isCritical();
        String getType();
        boolean isDelayed();
        double calculatePenalty();
    }
    public static class DeliveryCheckpoint implements Checkpoint {
        private String checkpointId;
        private String locationName;
        private double distanceFromLast;
        private double expectedDuration;
        private double actualDuration;

        public DeliveryCheckpoint(String checkpointId, String locationName, double distanceFromLast,
                                  double expectedDuration, double actualDuration) {
            this.checkpointId = checkpointId;
            this.locationName = locationName;
            this.distanceFromLast = distanceFromLast;
            this.expectedDuration = expectedDuration;
            this.actualDuration = actualDuration;
        }
        public String getCheckpointId() { return checkpointId; }
        public String getLocationName() { return locationName; }
        public double getDistanceFromLast() { return distanceFromLast; }
        public double getExpectedDuration() { return expectedDuration; }
        public double getActualDuration() { return actualDuration; }
        public boolean isCritical() { return true; }
        public String getType() { return "DeliveryCheckpoint"; }
        public boolean isDelayed() { return actualDuration > expectedDuration; }
        public double calculatePenalty() {
            if (isDelayed()) {
                return (actualDuration - expectedDuration) * 2;
            }
            return 0;
        }
    }
    public static class FuelCheckpoint implements Checkpoint {
        private String checkpointId;
        private String locationName;
        private double distanceFromLast;
        private double expectedDuration;
        private double actualDuration;

        public FuelCheckpoint(String checkpointId, String locationName, double distanceFromLast,
                             double expectedDuration, double actualDuration) {
            this.checkpointId = checkpointId;
            this.locationName = locationName;
            this.distanceFromLast = distanceFromLast;
            this.expectedDuration = expectedDuration;
            this.actualDuration = actualDuration;
        }
        public String getCheckpointId() { return checkpointId; }
        public String getLocationName() { return locationName; }
        public double getDistanceFromLast() { return distanceFromLast; }
        public double getExpectedDuration() { return expectedDuration; }
        public double getActualDuration() { return actualDuration; }
        public boolean isCritical() { return true; }
        public String getType() { return "FuelCheckpoint"; }
        public boolean isDelayed() { return actualDuration > expectedDuration; }
        public double calculatePenalty() {
            if (isDelayed()) {
                return 10;
            }
            return 0;
        }
    }
    public static class RestCheckpoint implements Checkpoint {
        private String checkpointId;
        private String locationName;
        private double distanceFromLast;
        private double expectedDuration;
        private double actualDuration;

        public RestCheckpoint(String checkpointId, String locationName, double distanceFromLast,
                              double expectedDuration, double actualDuration) {
            this.checkpointId = checkpointId;
            this.locationName = locationName;
            this.distanceFromLast = distanceFromLast;
            this.expectedDuration = expectedDuration;
            this.actualDuration = actualDuration;
        }
        public String getCheckpointId() { return checkpointId; }
        public String getLocationName() { return locationName; }
        public double getDistanceFromLast() { return distanceFromLast; }
        public double getExpectedDuration() { return expectedDuration; }
        public double getActualDuration() { return actualDuration; }
        public boolean isCritical() { return false; }
        public String getType() { return "RestCheckpoint"; }
        public boolean isDelayed() { return actualDuration > expectedDuration; }
        public double calculatePenalty() {
            if (isDelayed() && (actualDuration - expectedDuration) > 30) {
                return (actualDuration - expectedDuration) * 0.5;
            }
            return 0;
        }
    }
    public static class RouteLinkedList<T extends Checkpoint> {
        private class Node {
            T data;
            Node next;
            Node(T data) { this.data = data; }
        }
        private Node head;

        public void addCheckpoint(T checkpoint) {
            if (head == null) {
                head = new Node(checkpoint);
            } else {
                Node current = head;
                while (current.next != null) current = current.next;
                current.next = new Node(checkpoint);
            }
        }
        public boolean removeCheckpoint(String checkpointId) {
            if (head == null) return false;
            if (head.data.getCheckpointId().equals(checkpointId)) {
                head = head.next;
                return true;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.data.getCheckpointId().equals(checkpointId)) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        }
        public T findCheckpoint(String checkpointId) {
            Node current = head;
            while (current != null) {
                if (current.data.getCheckpointId().equals(checkpointId)) {
                    return current.data;
                }
                current = current.next;
            }
            return null;
        }
        public double computeTotalDistance() {
            double total = 0;
            Node current = head;
            while (current != null) {
                total += current.data.getDistanceFromLast();
                current = current.next;
            }
            return total;
        }
        public double computeTotalPenalty() {
            double total = 0;
            Node current = head;
            while (current != null) {
                total += current.data.calculatePenalty();
                current = current.next;
            }
            return total;
        }
        public void printRoute() {
            Node current = head;
            int index = 1;
            while (current != null) {
                T cp = current.data;
                String status = cp.isDelayed() ? "Delayed" : "On Time";
                System.out.printf("%d. %s – %s – %s – Penalty: %.1f%n",
                    index++, cp.getType(), cp.getLocationName(), status, cp.calculatePenalty());
                current = current.next;
            }
        }
        public boolean checkConsistency() {
            Node current = head;
            Set<String> criticalIds = new HashSet<>();
            while (current != null) {
                if (current.data.isCritical()) {
                    criticalIds.add(current.data.getCheckpointId());
                }
                current = current.next;
            }
            return !criticalIds.isEmpty();
        }
    }
    public static class Driver {
        private String driverId;
        private String name;
        private RouteLinkedList<Checkpoint> routeHistory;

        public Driver(String driverId, String name) {
            this.driverId = driverId;
            this.name = name;
            this.routeHistory = new RouteLinkedList<>();
        }
        public RouteLinkedList<Checkpoint> getRouteHistory() {
            return routeHistory;
        }
        public void printRouteSummary() {
            System.out.printf("Driver: %s – %s%n", driverId, name);
            System.out.println("Route Summary:");
            routeHistory.printRoute();
            double totalDistance = routeHistory.computeTotalDistance();
            double totalPenalty = routeHistory.computeTotalPenalty();
            double routeScore = totalDistance - totalPenalty;
            System.out.printf("Total Distance: %.1f km%n", totalDistance);
            System.out.printf("Total Penalty: %.1f%n", totalPenalty);
            System.out.printf("Route Score: %.1f%n", routeScore);
            boolean consistent = routeHistory.checkConsistency();
            System.out.printf("Critical Route Check: %s%n", consistent ? "All required checkpoints present." : "Missing critical checkpoints.");
        }
    }
    public static void main(String[] args) {
        Driver driver = new Driver("D1204", "Kavita Nair");
        RouteLinkedList<Checkpoint> route = driver.getRouteHistory();

        route.addCheckpoint(new DeliveryCheckpoint("CP1", "Warehouse A", 30, 60, 70));
        route.addCheckpoint(new FuelCheckpoint("CP2", "Pump 12", 20, 15, 15));
        route.addCheckpoint(new RestCheckpoint("CP3", "Motel X", 40, 45, 80));
        route.addCheckpoint(new DeliveryCheckpoint("CP4", "Client Hub", 30, 50, 65));
        driver.printRouteSummary();
    }
}
