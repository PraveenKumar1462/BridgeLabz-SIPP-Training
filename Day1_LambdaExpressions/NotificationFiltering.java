package Day1_LambdaExpressions;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Alert {
    String type;
    String message;

    public Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical", "Patient heart rate abnormal"),
            new Alert("Info", "Patient scheduled for checkup"),
            new Alert("Warning", "Patient blood pressure high")
        );


        Predicate<Alert> criticalOnly = alert -> "Critical".equals(alert.type);

        List<Alert> filteredAlerts = alerts.stream()
            .filter(criticalOnly)
            .collect(Collectors.toList());

        filteredAlerts.forEach(System.out::println);
    }
}
