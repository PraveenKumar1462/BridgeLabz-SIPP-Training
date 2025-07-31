import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolderName;
    LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return policyNumber + " - " + policyHolderName + " - " + expiryDate;
    }
}

public class InsurancePolicySystem {
    Map<String, Policy> hashMapStore = new HashMap<>();
    Map<String, Policy> linkedHashMapStore = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> expirySortedPolicies = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMapStore.put(policy.policyNumber, policy);
        linkedHashMapStore.put(policy.policyNumber, policy);

        expirySortedPolicies.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapStore.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringInNext30Days() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        return expirySortedPolicies.subMap(today, true, next30Days, true)
                .values().stream().flatMap(List::stream).toList();
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashMapStore.values()) {
            if (p.policyHolderName.equalsIgnoreCase(holderName)) {
                result.add(p);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy>>> itr = expirySortedPolicies.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = itr.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy p : entry.getValue()) {
                    hashMapStore.remove(p.policyNumber);
                    linkedHashMapStore.remove(p.policyNumber);
                }
                itr.remove();
            }
        }
    }

    public void printAllPolicies() {
        for (Policy p : linkedHashMapStore.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        system.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P103", "Alice", LocalDate.now().plusDays(5)));
        system.addPolicy(new Policy("P104", "Carol", LocalDate.now().minusDays(1)));

        System.out.println("All Policies:");
        system.printAllPolicies();

        System.out.println("\nExpiring in 30 Days:");
        for (Policy p : system.getPoliciesExpiringInNext30Days()) {
            System.out.println(p);
        }

        System.out.println("\nPolicies for Alice:");
        for (Policy p : system.getPoliciesByHolder("Alice")) {
            System.out.println(p);
        }

        System.out.println("\nRemoving expired policies...");
        system.removeExpiredPolicies();

        System.out.println("\nPolicies after removal:");
        system.printAllPolicies();
    }
}
