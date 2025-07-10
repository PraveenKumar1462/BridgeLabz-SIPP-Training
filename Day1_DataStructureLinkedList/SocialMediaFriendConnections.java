package Day1_DataStructureLinkedList;

import java.util.ArrayList;
import java.util.HashSet;

public class SocialMediaFriendConnections {
    private static class Node {
        int userId;
        String name;
        int age;
        ArrayList<Integer> friendIds;
        Node next;

        Node(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendIds = new ArrayList<>();
            this.next = null;
        }
    }

    private Node head;

    public SocialMediaFriendConnections() {
        head = null;
    }


    public void addUser(int userId, String name, int age) {
        Node newNode = new Node(userId, name, age);
        newNode.next = head;
        head = newNode;
    }


    private Node findUserById(int userId) {
        Node current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    private Node findUserByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public void addFriendConnection(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
        System.out.println("Friend connection added between " + userId1 + " and " + userId2);
    }


    public void removeFriendConnection(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed between " + userId1 + " and " + userId2);
    }


    public void findMutualFriends(int userId1, int userId2) {
        Node user1 = findUserById(userId1);
        Node user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        HashSet<Integer> set1 = new HashSet<>(user1.friendIds);
        HashSet<Integer> set2 = new HashSet<>(user2.friendIds);
        set1.retainAll(set2);
        if (set1.isEmpty()) {
            System.out.println("No mutual friends found.");
        } else {
            System.out.println("Mutual friends of " + userId1 + " and " + userId2 + ": " + set1);
        }
    }


    public void displayFriends(int userId) {
        Node user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of user " + userId + ": " + user.friendIds);
    }


    public void searchUser(String query) {
        Node user = null;
        try {
            int id = Integer.parseInt(query);
            user = findUserById(id);
        } catch (NumberFormatException e) {
            user = findUserByName(query);
        }
        if (user == null) {
            System.out.println("User not found.");
        } else {
            System.out.println("User found: ID=" + user.userId + ", Name=" + user.name + ", Age=" + user.age);
        }
    }


    public void countFriends() {
        Node current = head;
        while (current != null) {
            System.out.println("User ID: " + current.userId + ", Name: " + current.name + ", Number of friends: " + current.friendIds.size());
            current = current.next;
        }
    }


    public static void main(String[] args) {
        SocialMediaFriendConnections smfc = new SocialMediaFriendConnections();
        smfc.addUser(1, "Alice", 25);
        smfc.addUser(2, "Bob", 30);
        smfc.addUser(3, "Charlie", 28);
        smfc.addFriendConnection(1, 2);
        smfc.addFriendConnection(1, 3);
        smfc.displayFriends(1);
        smfc.findMutualFriends(2, 3);
        smfc.removeFriendConnection(1, 3);
        smfc.displayFriends(1);
        smfc.searchUser("Alice");
        smfc.searchUser("2");
        smfc.countFriends();
    }
}
