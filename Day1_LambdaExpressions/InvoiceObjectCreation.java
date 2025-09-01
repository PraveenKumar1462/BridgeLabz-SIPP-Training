package Day1_LambdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;

    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice for transaction: " + transactionId;
    }
}

public class InvoiceObjectCreation {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("T1001", "T1002", "T1003");

        List<Invoice> invoices = transactionIds.stream()
            .map(Invoice::new)
            .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
