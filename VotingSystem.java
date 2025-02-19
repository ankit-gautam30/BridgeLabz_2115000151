import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>();
    
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, orderedVotes.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, sortedVotes.getOrDefault(candidate, 0) + 1);
    }
    
    public int getVotes(String candidate) {
        return voteMap.getOrDefault(candidate, 0);
    }
    
    public Map<String, Integer> getSortedResults() {
        return sortedVotes;
    }
    
    public Map<String, Integer> getOrderedVotes() {
        return orderedVotes;
    }
    
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        
        System.out.println("Votes: " + system.voteMap);
        System.out.println("Sorted Results: " + system.getSortedResults());
        System.out.println("Ordered Votes: " + system.getOrderedVotes());
    }
}
