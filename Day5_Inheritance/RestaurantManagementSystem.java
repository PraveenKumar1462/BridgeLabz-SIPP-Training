package Day5_Inheritance;


interface Worker {
    void performDuties();
}


class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}


class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " (ID: " + id + ") is preparing meals.");
    }
}


class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " (ID: " + id + ") is serving customers.");
    }
}


public class RestaurantManagementSystem {
    public static void main(String[] args) {
    
        Worker chef = new Chef("Ravi", 101);
        Worker waiter = new Waiter("Sita", 201);

        chef.performDuties();
        waiter.performDuties();
    }
}