import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {

    private Map<String, Integer> votes = new HashMap<>();

    public void addVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }

    public Map<String, Integer> getVotes() {
        return votes;
    }

    public Map<String, Integer> getSortedResults() {
        return new TreeMap<>(votes);
    }

    public Map<String, Integer> getInsertionOrderResults() {
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        for (String candidate : votes.keySet()) {
            linkedMap.put(candidate, votes.get(candidate));
        }
        return linkedMap;
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.addVote("Alice");
        votingSystem.addVote("Bob");
        votingSystem.addVote("Alice");
        votingSystem.addVote("Charlie");
        votingSystem.addVote("Bob");
        votingSystem.addVote("Alice");

        System.out.println("Votes (HashMap): " + votingSystem.getVotes());
        System.out.println("Votes (TreeMap - Sorted): " + votingSystem.getSortedResults());
        System.out.println("Votes (LinkedHashMap - Insertion Order): " + votingSystem.getInsertionOrderResults());
    }
}
