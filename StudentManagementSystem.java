import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    int age;
    String course;

    //constructor
    Student(int id,String name,int age, String course){
        this.id=id;
        this.name=name;
        this.age=age;
        this.course=course;
    }
    void display(){
        System.out.println("ID:"+id);
        System.out.println("Name:"+name);
        System.out.println("Age:"+age);
        System.out.println("Course:"+course);
    }

}

//main class

public class StudentManagementSystem{

        static ArrayList<Student> studentList=new ArrayList<>();
        static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the Student Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }   
    }

    public static void addStudent(){
        System.out.println("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        System.out.println("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter student course: ");
        String course = sc.nextLine();
        Student student = new Student(id, name, age, course);
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    public static void viewStudents(){
        if(studentList.isEmpty()){
            System.out.println("No students found.");
        }else{
            for(Student student : studentList){
                student.display();
            }
        }
    }

    public static void updateStudent(){
        System.out.println("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for(Student student : studentList){
            if(student.id == id){
                System.out.println("Enter new name: ");
                String name = sc.nextLine();
                System.out.println("Enter new age: ");
                int age = sc.nextInt();
                sc.nextLine();  
                System.out.println("Enter new course: ");
                String course = sc.nextLine();
                student.name = name;
                student.age = age;
                student.course = course;
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void deleteStudent(){
        System.out.println("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        for(Student student : studentList){
            if(student.id == id){
                studentList.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

}