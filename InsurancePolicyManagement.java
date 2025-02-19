import java.util.*;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    
    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }
    
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    public String getPolicyholderName() {
        return policyholderName;
    }
    
    public Date getExpiryDate() {
        return expiryDate;
    }
    
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry: " + expiryDate;
    }
}

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<Date, InsurancePolicy> sortedPolicies = new TreeMap<>();
    
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicies.put(policy.getPolicyNumber(), policy);
        sortedPolicies.put(policy.getExpiryDate(), policy);
    }
    
    public InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }
    
    public List<InsurancePolicy> getExpiringPolicies(int days) {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_YEAR, days);
        Date thresholdDate = cal.getTime();
        
        for (Map.Entry<Date, InsurancePolicy> entry : sortedPolicies.entrySet()) {
            if (entry.getKey().before(thresholdDate)) {
                expiringPolicies.add(entry.getValue());
            } else {
                break;
            }
        }
        return expiringPolicies;
    }
    
    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }
    
    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        Iterator<Map.Entry<Date, InsurancePolicy>> iterator = sortedPolicies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Date, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().before(currentDate)) {
                policyMap.remove(entry.getValue().getPolicyNumber());
                orderedPolicies.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            } else {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new InsurancePolicy("P001", "Alice", new Date(System.currentTimeMillis() + 86400000L * 10)));
        system.addPolicy(new InsurancePolicy("P002", "Bob", new Date(System.currentTimeMillis() + 86400000L * 5)));
        system.addPolicy(new InsurancePolicy("P003", "Alice", new Date(System.currentTimeMillis() - 86400000L)));
        
        System.out.println("Policies expiring in 30 days: " + system.getExpiringPolicies(30));
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));
        system.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + system.policyMap);
    }
}
