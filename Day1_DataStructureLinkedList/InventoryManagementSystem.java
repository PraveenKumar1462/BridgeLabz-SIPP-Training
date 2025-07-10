package Day1_DataStructureLinkedList;

public class InventoryManagementSystem {
    private static class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    private Node head;

    public InventoryManagementSystem() {
        head = null;
    }


    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }


    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Node newNode = new Node(itemName, itemId, quantity, price);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }


    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Removed item with ID: " + itemId);
            return;
        }
        Node current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
            return;
        }
        current.next = current.next.next;
        System.out.println("Removed item with ID: " + itemId);
    }


    public void updateQuantity(int itemId, int newQuantity) {
        Node current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Updated quantity for item ID " + itemId + " to " + newQuantity);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }


    public Node searchByItemId(int itemId) {
        Node current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public Node searchByItemName(String itemName) {
        Node current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public double calculateTotalValue() {
        double total = 0;
        Node current = head;
        while (current != null) {
            total += current.price * current.quantity;
            current = current.next;
        }
        return total;
    }


    public void sortInventory(String sortBy, String order) {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, sortBy, order);
    }

    private Node mergeSort(Node head, String sortBy, String order) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head, sortBy, order);
        Node right = mergeSort(nextOfMiddle, sortBy, order);

        return sortedMerge(left, right, sortBy, order);
    }

    private Node sortedMerge(Node a, Node b, String sortBy, String order) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (sortBy.equalsIgnoreCase("name")) {
            condition = order.equalsIgnoreCase("asc") ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else if (sortBy.equalsIgnoreCase("price")) {
            condition = order.equalsIgnoreCase("asc") ? a.price <= b.price : a.price > b.price;
        } else {
            condition = true;
        }

        Node result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, sortBy, order);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, sortBy, order);
        }
        return result;
    }

    private Node getMiddle(Node head) {
        if (head == null) return head;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Node current = head;
        System.out.println("Inventory Items:");
        while (current != null) {
            System.out.println("Item ID: " + current.itemId + ", Name: " + current.itemName + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.addAtEnd("Pen", 101, 50, 1.5);
        ims.addAtBeginning("Notebook", 102, 30, 2.0);
        ims.addAtPosition("Eraser", 103, 20, 0.5, 2);
        ims.displayAll();
        ims.updateQuantity(102, 40);
        ims.displayAll();
        System.out.println("Total Inventory Value: " + ims.calculateTotalValue());
        ims.sortInventory("name", "asc");
        ims.displayAll();
        ims.sortInventory("price", "desc");
        ims.displayAll();
        ims.removeByItemId(103);
        ims.displayAll();
    }
}
