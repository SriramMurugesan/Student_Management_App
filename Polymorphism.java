// Polymorphism - Ability to take many forms
// Types: Compile-time (Method Overloading) and Runtime (Method Overriding)

// ===== COMPILE-TIME POLYMORPHISM (Method Overloading) =====
class Calculator {
    // Same method name, different parameters
    int add(int a, int b) {
        System.out.println("Adding two integers");
        return a + b;
    }
    
    int add(int a, int b, int c) {
        System.out.println("Adding three integers");
        return a + b + c;
    }
    
    double add(double a, double b) {
        System.out.println("Adding two doubles");
        return a + b;
    }
}

// ===== RUNTIME POLYMORPHISM (Method Overriding) =====
class Parent {
    void display() {
        System.out.println("Display from Parent class");
    }
    
    void show() {
        System.out.println("Show from Parent class");
    }
}

class Child extends Parent {
    // Overriding parent method
    @Override
    void display() {
        System.out.println("Display from Child class (Overridden)");
    }
}

// Real-world example
class Employee {
    void calculateSalary() {
        System.out.println("Calculating basic salary");
    }
}

class Manager extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Calculating salary with management bonus");
    }
}

class Developer extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Calculating salary with project incentives");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("=== POLYMORPHISM EXAMPLES ===\n");
        
        // Compile-time Polymorphism (Method Overloading)
        System.out.println("1. COMPILE-TIME POLYMORPHISM (Method Overloading):");
        Calculator calc = new Calculator();
        System.out.println("Result: " + calc.add(5, 10));
        System.out.println("Result: " + calc.add(5, 10, 15));
        System.out.println("Result: " + calc.add(5.5, 10.5));
        
        // Runtime Polymorphism (Method Overriding)
        System.out.println("\n2. RUNTIME POLYMORPHISM (Method Overriding):");
        Parent obj1 = new Parent();
        obj1.display();
        
        Parent obj2 = new Child(); // Parent reference, Child object
        obj2.display(); // Calls Child's overridden method
        obj2.show();    // Calls Parent's method (not overridden)
        
        // Real-world example
        System.out.println("\n3. REAL-WORLD EXAMPLE:");
        Employee emp1 = new Manager();
        Employee emp2 = new Developer();
        Employee emp3 = new Employee();
        
        emp1.calculateSalary(); // Calls Manager's method
        emp2.calculateSalary(); // Calls Developer's method
        emp3.calculateSalary(); // Calls Employee's method
        
        System.out.println("\nBenefit: Same interface, different implementations!");
    }
}
