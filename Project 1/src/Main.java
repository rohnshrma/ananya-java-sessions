// A class is a blueprint that defines data (fields) and behavior (methods).
class Student {
    String name; // Instance field: stores student name for each object.
    int age; // Instance field: stores student age for each object.

    void study() { // Instance method: behavior that uses object data.
        System.out.println(name + " is studying"); // Print message using this object's name.
    }
}

class User {
    String name; // Property to store user's name.
    String email; // Property to store user's email.
    String password; // Property to store user's password.

    // Constructor: runs automatically when 'new User(...)' is called.
    // Its main job is to initialize object state at creation time.
    User(String n, String e, String p) {
        name = n; // Assign constructor parameter to object property.
        email = e; // Assign constructor parameter to object property.
        password = p; // Assign constructor parameter to object property.
    }

    // Normal method (not constructor): can be called any time after object
    // creation.
    void showDetails() {
        System.out.println(name + " " + email); // Print selected user details.
    }

    @Override // Indicates this method replaces Object.toString() behavior.
    public String toString() {
        return "Name : " + name + ", Email : " + email; // Text form of a User object.
    }
}

class Course {
    String courseName; // Course title.
    int duration; // Duration in months.
    double fees; // Total course fee.

    // Normal setter-like method: assigns values after object is created.
    void setValues(String name, int dur, double f) {
        courseName = name; // Set courseName from method parameter.
        duration = dur; // Set duration from method parameter.
        fees = f; // Set fees from method parameter.
    }

    @Override
    public String toString() {
        return courseName + " is of " + duration + " months"; // Return readable summary.
    }

    void showDetails() {
        System.out.println(courseName + " " + duration + " " + fees); // Print all fields.
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(); // Create Student object using default constructor.
        s1.name = "John"; // Assign name directly to field.
        s1.age = 25; // Assign age directly to field.
        s1.study(); // Call method on s1 object.

        User u1 = new User("john doe", "john@email.com", "hellojohn@123"); // Constructor call.
        u1.showDetails(); // Call normal method after object creation.
        System.out.println(u1); // toString() is called automatically by println.

        Course c1 = new Course();
        c1.setValues("Mathematic", 4, 12345);
        // Difference: here values are assigned later through a normal method,
        // not during object creation like in constructor.

        System.out.println(c1);

        c1.showDetails();

    }

}

/*
 * Difference: Constructor vs Normal Function (method) with parameters
 * 1) Constructor name must match class name; normal method can have any valid
 * name.
 * 2) Constructor has no return type; normal method has a return type (or void).
 * 3) Constructor runs automatically during object creation with 'new'; normal
 * method is called manually.
 * 4) Constructor is for initial object setup; normal method performs actions
 * anytime after creation.
 * 5) Constructor can enforce required values at creation; normal method can
 * update/change values later.
 * 
 * 10 Practice Tasks
 * 1) Create a class Book with title and price; initialize both using a
 * constructor.
 * 2) Add a method setDiscount(double d) in Book and update final price.
 * 3) Create class Employee with id, name, salary and print details using
 * toString().
 * 4) Overload Employee constructor: one with all fields, one with only name and
 * default salary.
 * 5) Create class Car with brand and model via constructor; add method
 * changeModel(String m).
 * 6) Create class BankAccount with balance initialized in constructor; add
 * deposit and withdraw methods.
 * 7) Create class Laptop with setSpecs(...) method and compare with
 * constructor-based initialization.
 * 8) Create class Student2 with constructor validation (age must be > 0).
 * 9) Add a method resetDetails(...) to User that updates all fields after
 * creation.
 * 10) Print objects directly with System.out.println(object) and verify
 * toString() output.
 */
