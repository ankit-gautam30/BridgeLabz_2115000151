import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagementSystem {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public Set<Policy> getAllPolicies() {
        return new HashSet<>(hashSet);
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new HashSet<>();
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date threshold = calendar.getTime();
        
        for (Policy policy : treeSet) {
            if (policy.getExpiryDate().before(threshold)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        Set<Policy> policies = new HashSet<>();
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public Set<Policy> getDuplicatePolicies() {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (Policy policy : hashSet) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        system.addPolicy(new Policy("123", "John Doe", new Date(), "Health", 500.0));
        system.addPolicy(new Policy("124", "Jane Doe", new Date(), "Auto", 600.0));
        System.out.println("All Policies: " + system.getAllPolicies());
    }
}
