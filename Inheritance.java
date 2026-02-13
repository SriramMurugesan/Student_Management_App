// Inheritance - Mechanism where one class acquires properties of another class
// Types: Single, Multilevel, Hierarchical, Multiple (through interfaces), Hybrid

// ===== SINGLE INHERITANCE =====
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// ===== MULTILEVEL INHERITANCE =====
class Vehicle {
    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving");
    }
}

class SportsCar extends Car {
    void turboBoost() {
        System.out.println("Turbo boost activated!");
    }
}

// ===== HIERARCHICAL INHERITANCE =====
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    void drawCircle() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    void drawRectangle() {
        System.out.println("Drawing a rectangle");
    }
}

// ===== MULTIPLE INHERITANCE (through interfaces) =====
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying");
    }
    
    public void swim() {
        System.out.println("Duck is swimming");
    }
}

// ===== HYBRID INHERITANCE (combination of multiple types) =====
interface Engine {
    void engineType();
}

class Boat {
    void sail() {
        System.out.println("Boat is sailing");
    }
}

class Amphibious extends Boat implements Engine, Flyable {
    public void engineType() {
        System.out.println("Hybrid engine");
    }
    
    public void fly() {
        System.out.println("Amphibious vehicle flying");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("=== INHERITANCE EXAMPLES ===\n");
        
        // Single Inheritance
        System.out.println("1. SINGLE INHERITANCE (Dog extends Animal):");
        Dog dog = new Dog();
        dog.eat();  // Inherited from Animal
        dog.bark(); // Own method
        
        System.out.println("\n2. MULTILEVEL INHERITANCE (SportsCar -> Car -> Vehicle):");
        SportsCar ferrari = new SportsCar();
        ferrari.start();      // From Vehicle
        ferrari.drive();      // From Car
        ferrari.turboBoost(); // Own method
        
        System.out.println("\n3. HIERARCHICAL INHERITANCE (Circle, Rectangle extend Shape):");
        Circle circle = new Circle();
        circle.draw();       // From Shape
        circle.drawCircle(); // Own method
        
        Rectangle rect = new Rectangle();
        rect.draw();          // From Shape
        rect.drawRectangle(); // Own method
        
        System.out.println("\n4. MULTIPLE INHERITANCE (Duck implements Flyable, Swimmable):");
        Duck duck = new Duck();
        duck.fly();  // From Flyable interface
        duck.swim(); // From Swimmable interface
        
        System.out.println("\n5. HYBRID INHERITANCE (Amphibious extends Boat, implements Engine, Flyable):");
        Amphibious vehicle = new Amphibious();
        vehicle.sail();       // From Boat
        vehicle.engineType(); // From Engine interface
        vehicle.fly();        // From Flyable interface
        
        System.out.println("\nBenefit: Code reusability and establishing relationships between classes!");
    }
}
