import java.util.Scanner;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java_8_to_21 {

    // Java 8
    // lambda expressions were introduced in java 8 , which reduced the number of lines of code required to define a function
    // they are also called as closure or anonymous functions and are implemented by Functional interfaces

    // without lambda
    public void display() {
        System.out.println("Hello Spreezy");


    }

    // with lambda
    static Runnable Hello =  () -> System.out.println("Hello Spreezy");


    // Java 9
    // Easier try catch blocks were introduced and Jshell was provided which can be directly be accessed from terminal
    public static class MyThread extends Thread
    {
        public void run()
        {
            System.out.println("Thread is running");
        }
    }


// Java 15 classes
    static abstract sealed class Shape permits Circle, Rectangle {
        abstract double area();
    }

    // Subclasses of sealed class
    static final class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }
    }

    static final class Rectangle extends Shape {
        private final double length;
        private final double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        double area() {
            return length * width;
        }
    }


    // Java 16
    // With the release of Java 16, we can now define records as class members of inner classes.
    // This is due to relaxing restrictions that were missed as part of the incremental release of Java 15
    public record Book(String title, String author, String isbn) {
    }

    static class OuterClass {
        static class InnerClass {
            Book book = new Book("Title", "author", "isbn");


        }
    }





    public static void main(String[] args) {
        // Checking Java Version
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);

        // For Java 8
        Hello.run();


        // Java 9 ...from java 9, we can define our resources anywhere in our code which are
        // auto closable then we can use them directly in the try block like the below:
        MyThread th = new MyThread();

        try {
            th.start();
        } catch (Exception ex) {
            System.out.println("Exception : "+ex);
        }

        // Java 10
        // It has very minor changes from java 9 : use of var to define variable and minor changes in collections api
        // which allows you to create immutable list using .toUmmodifiableList() method

        var x = 10;
        System.out.println("Value of var x is : "+ x);

        // Java 11
        // IsBlank() method: This has added to the String class. If a Java String has any number of blanks inside it then, this method will return true.
        // Even if the String contains a single blank (white space) also (String str=” ”); then, the isBlank() method will return true.
        String str = "Hello Spreezy";
        System.out.println(str.isBlank());

        // Lines(): This new method in Java 11 returns a stream of Strings by splitting the string using the
        // new line character when the string has a new line character inside it. For Ex.:
        String str2 = "I\nam\na\nBackend Developer";
        System.out.println(str2.lines().collect(Collectors.toList()));


        // Java 12
        // Java 12 has been offering new languages as well as features especially API as well as clean-up techniques.
        // One of the quiet characteristics comprises Unicode eleven and maintenance as well as the performance of a switch appearance.
        //1. Micro benchmark Suite
        //Java 12 presents a set of more than a hundred micro-benchmark examinations of its Java sourcing coding.
        // Such tests would let for unceasing presentation challenges on the JVM and would develop to be valuable for each programmer
        // wanting to function towards the java and make a newer microbenchmark.


        // Java 13
        // Benefits of Java 13
        //1. It is just very simple to use as it comprises several API
        //
        //2. Java 13 comes with enhanced structures that can establish programs that lets creating findings of chains easier.
        //
        //3. These new Java 13 features are proficient in assembling not so modified gatherings via streams.
        //
        //4. Its ‘Text Blocks’ feature is excellent for packaging and deploying only the selected JDK that is significant for deployment.
        //
        //5. It offers excellent legacy opening APIs.


        // Java 14
        // With new switch expressions, we can write the same thing more succinctly:
//        Scanner sc = new Scanner(System.in);
          String day ;
//        System.out.print("Enter the Day to check if its holiday : ");
//        day = sc.next();

         day = "sunday";

        boolean isTodayHoliday = switch (day.toUpperCase()) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
            case "SATURDAY", "SUNDAY" -> true;
            default -> throw new IllegalArgumentException("What's a " + day);
        };

        System.out.println(isTodayHoliday);

        // Records were introduced to reduce repetitive boilerplate code in data model POJOs. They simplify day to day development, improve efficiency and greatly minimize the risk of human error.
        //
        //For example, a data model for a User with an id and password can be simply defined as:
        record User(int id, String password) { };
        // As we can see, we are making use of a new keyword, record, here.
        // This simple declaration will automatically add a constructor, getters, equals, hashCode and
        // toString methods for us.

        User user1 = new User(0, "UserOne");
        System.out.println(user1);



        // Java 15
        // Sealed Classes : The goal of sealed classes is to allow individual classes to declare which types may be used as
        // sub-types. This also applies to interfaces and determining which types can implement them.
        // Sealed classes involve two new keywords — sealed and permits:

        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());


        // Java 16
        // Example is give above the main function(public static void main)
        //  public record Book(String title, String author, String isbn) {
        //    }


        // Java 17
        // 2.4. macOS/AArch64 Port
        //Apple announced a long-term plan to transition its computer line from X64 to AArch64.
        // This JEP ports the JDK to run on AArch64 in macOS platforms.

        // Pattern Matching for Switch
        // record Human (String name, int age, String profession) {};
        //
        //        public String checkObject(Object obj) {
        //            return switch (obj) {
        //                case Human h -> "Name: %s, age: %s and profession: %s".formatted(h.name(), h.age(), h.profession());
        //                case Circle c -> "This is a circle";
        //                case Shape s -> "It is just a shape";
        //                case null -> "It is null";
        //                default -> "It is an object";
        //            };
        //        }
        //
        //        public String checkShape(Shape shape) {
        //            return switch (shape) {
        //                case Triangle t && (t.getNumberOfSides() != 3) -> "This is a weird triangle";
        //                case Circle c && (c.getNumberOfSides() != 0) -> "This is a weird circle";
        //                default -> "Just a normal shape";
        //            };
        //        }


        // Java 18
        // Code Snippets in Java API Documentation
        //The Javadoc compiler has also seen improvements.
        // It now offers better support for code snippets as part of the documentation (JEP 413),
        // including support for syntax highlights. The addition of the @snippet tag also allows IDEs and other tooling to
        // distinguish code snippets more easily from other documentation. This can provide code insight, highlight, and linting during editing.

        // Simple Web Server
        //An out-of-the-box static HTTP file server with easy setup and minimal functionality,
        // reducing developer activation energy, making the JDK more approachable, and offering a default implementation
        // via the command line together with a small API for programmatic creation and customization.


        // Java 19
        // it dos not have any new language features apart form the preview for Pattern Matching for Switch, Record Patterns.
        // and vector api

        // Java 20
        // Scoped Values
        //A large number of Java applications have components or modules that need to share data among themselves. Often, these modules are thread based, so we must protect the data they share from any change.
        //
        //We’ve been using variables of the type ThreadLocal to allow components to share data.
        //
        //But it has some consequences:
        //
        //A ThreadLocal variable is mutable. The ThreadLocal API allows access to both get() and set() methods of its variable type.
        //We may face memory leak issues since the value of the ThreadLocal variables is retained until we explicitly call the remove() method on it or the thread exits. Thus, there’s no binding to the lifetime of these per-thread variables.
        //They may lead to excessive memory footprints in case of using large numbers of threads. This is because the child threads can inherit the ThreadLocal variables of parent threads, thus allocating memory for every ThreadLocal variable.
        //To overcome these problems of ThreadLocal variables, Java 20 has introduced scoped values for sharing data within and across threads.
        //
        //Scoped values provide a simple, immutable, and inheritable data-sharing option, specifically in situations where we’re working with a large number of threads.
        //
        //A ScopedValue is an immutable value that is available for reading for a bounded period of execution by a thread. Since it’s immutable, it allows safe and easy data-sharing for a limited period of thread execution. Also, we need not pass the values as method arguments.
        //
        //We can use the where() method of the class ScopedValue to set the value of a variable for the bounded period of thread execution. Moreover, once we get the data using the get() method, we cannot access it again.

        // Java 21
        //( Determines if the given code point can have an emoji modifier applied to it.
        // For instance, the hand emoji can have different skin tones applied.)

        boolean canHaveModifier = Character.isEmojiModifierBase('✋');
        System.out.println(canHaveModifier);











    }









}
