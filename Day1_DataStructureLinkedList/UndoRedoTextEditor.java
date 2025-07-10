package Day1_DataStructureLinkedList;

public class UndoRedoTextEditor {
    private static class Node {
        String textState;
        Node next;
        Node prev;

        Node(String textState) {
            this.textState = textState;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node current;
    private int maxHistorySize;
    private int currentSize;

    public UndoRedoTextEditor(int maxHistorySize) {
        this.head = null;
        this.current = null;
        this.maxHistorySize = maxHistorySize;
        this.currentSize = 0;
    }


    public void addState(String newState) {
        Node newNode = new Node(newState);
        if (head == null) {
            head = newNode;
            current = newNode;
            currentSize = 1;
            return;
        }

        if (current.next != null) {
            Node temp = current.next;
            while (temp != null) {
                Node next = temp.next;
                temp.prev = null;
                temp.next = null;
                temp = next;
                currentSize--;
            }
            current.next = null;
        }
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        currentSize++;


        if (currentSize > maxHistorySize) {

            head = head.next;
            head.prev.next = null;
            head.prev = null;
            currentSize--;
        }
    }


    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("No more undo available.");
            return;
        }
        current = current.prev;
        System.out.println("Undo: " + current.textState);
    }


    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("No more redo available.");
            return;
        }
        current = current.next;
        System.out.println("Redo: " + current.textState);
    }


    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text state available.");
            return;
        }
        System.out.println("Current State: " + current.textState);
    }


    public static void main(String[] args) {
        UndoRedoTextEditor editor = new UndoRedoTextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState();
        editor.undo();
        editor.undo();
        editor.redo();
        editor.addState("Hello, Java!");
        editor.displayCurrentState();
        editor.redo();
    }
}
