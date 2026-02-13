import java.util.*;
import java.util.regex.Pattern;

// ---------- INTERFACE ----------
interface Rule {
    void followRule();
}

// ---------- ABSTRACT CLASS ----------
abstract class Citizen {
    protected int id;
    protected String name;

    Citizen(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void role();

    void showIdentity() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

// ---------- INHERITANCE + POLYMORPHISM ----------
class Student extends Citizen implements Rule {
    Student(int id, String name) {
        super(id, name);
    }

    public void followRule() {
        System.out.println("Student follows academic rules.");
    }

    void role() {
        System.out.println("Role: Student");
    }
}

class Employee extends Citizen implements Rule {
    Employee(int id, String name) {
        super(id, name);
    }

    public void followRule() {
        System.out.println("Employee follows office rules.");
    }

    void role() {
        System.out.println("Role: Employee");
    }
}

// ---------- MAIN CITY CLASS ----------
class VirtualCitySimulator {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Citizen> citizens = new ArrayList<>();
    static int day = 1;

    // Jagged Array – city zones
    static int[][] cityZones = {
            {1, 1, 1},
            {1, 0},
            {1, 1, 1, 1}
    };

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== JAVA VIRTUAL CITY =====");
            System.out.println("Day: " + day);
            System.out.println("1. Add Citizen");
            System.out.println("2. View Citizens");
            System.out.println("3. City Zones");
            System.out.println("4. Send Message");
            System.out.println("5. Next Day");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addCitizen(); break;
                case 2: viewCitizens(); break;
                case 3: showZones(); break;
                case 4: sendMessage(); break;
                case 5: day++; System.out.println("A new day begins..."); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }

    // ---------- MODULES ----------

    static void addCitizen() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("1. Student  2. Employee");
        int type = sc.nextInt();

        if (type == 1)
            citizens.add(new Student(id, name));
        else
            citizens.add(new Employee(id, name));

        System.out.println("Citizen added to city.");
    }

    static void viewCitizens() {
        if (citizens.isEmpty()) {
            System.out.println("No citizens in city.");
            return;
        }

        for (Citizen c : citizens) {
            c.showIdentity();
            c.role();                 // Polymorphism
            ((Rule)c).followRule();   // Interface usage
            System.out.println("----------------");
        }
    }

    static void showZones() {
        System.out.println("City Zones:");
        for (int i = 0; i < cityZones.length; i++) {
            for (int j : cityZones[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void sendMessage() {
        sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            System.out.println("Invalid Email!");
            return;
        }

        StringBuilder message = new StringBuilder();
        message.append("Emergency Alert for City!\n");
        message.append("Contact: ").append(email);

        System.out.println(message);
    }
}
