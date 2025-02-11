class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(String name, int id, int quantity, double price, int position) {
        if (position < 1) return;
        if (position == 1) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItem(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    public void updateQuantity(int id, int quantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.name + " | " + temp.quantity + " | " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.id + " | " + temp.quantity + " | " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }

    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public void sortByName() {
        if (head == null || head.next == null) return;
        head = mergeSortByName(head);
    }

    private Item mergeSortByName(Item head) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByName(head);
        Item right = mergeSortByName(nextOfMiddle);
        return sortedMergeByName(left, right);
    }

    private Item sortedMergeByName(Item a, Item b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.name.compareToIgnoreCase(b.name) < 0) {
            a.next = sortedMergeByName(a.next, b);
            return a;
        } else {
            b.next = sortedMergeByName(a, b.next);
            return b;
        }
    }

    public void sortByPrice() {
        if (head == null || head.next == null) return;
        head = mergeSortByPrice(head);
    }

    private Item mergeSortByPrice(Item head) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByPrice(head);
        Item right = mergeSortByPrice(nextOfMiddle);
        return sortedMergeByPrice(left, right);
    }

    private Item sortedMergeByPrice(Item a, Item b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.price < b.price) {
            a.next = sortedMergeByPrice(a.next, b);
            return a;
        } else {
            b.next = sortedMergeByPrice(a, b.next);
            return b;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.name + " | " + temp.quantity + " | " + temp.price);
            temp = temp.next;
        }
    }
}

public class Q4_Inventory_Management_System {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addAtBeginning("Laptop", 101, 5, 800);
        inventory.addAtEnd("Phone", 102, 10, 500);
        inventory.addAtPosition("Tablet", 103, 7, 300, 2);
        inventory.displayInventory();
        inventory.calculateTotalValue();
        inventory.sortByPrice();
        inventory.displayInventory();
    }
}
