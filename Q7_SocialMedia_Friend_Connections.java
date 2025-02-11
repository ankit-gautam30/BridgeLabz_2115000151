import java.util.*;

class User {
    int userID, age;
    String name;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    public void addFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null && !user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
            user2.friendIDs.add(userID1);
        }
    }

    public void removeFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null) {
            user1.friendIDs.remove(Integer.valueOf(userID2));
            user2.friendIDs.remove(Integer.valueOf(userID1));
        }
    }

    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);
        if (user1 != null && user2 != null) {
            Set<Integer> mutualFriends = new HashSet<>(user1.friendIDs);
            mutualFriends.retainAll(user2.friendIDs);
            System.out.println("Mutual Friends: " + mutualFriends);
        }
    }

    public void displayFriends(int userID) {
        User user = findUserByID(userID);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendIDs);
        }
    }

    public void searchUser(int userID, String name) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found");
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friends.");
            temp = temp.next;
        }
    }

    private User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) return temp;
            temp = temp.next;
        }
        return null;
    }
}

public class Q7_SocialMedia_Friend_Connections {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 27);
        sm.addUser(3, "Charlie", 22);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.displayFriends(1);
        sm.findMutualFriends(2, 3);
        sm.countFriends();
    }
}
