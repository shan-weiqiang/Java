package anonymous_class;

// Java Program to Demonstrate Anonymous inner class

// Interface
interface Age {
    int x = 21;

    void getAge();
}

// Main class
public class App {

    // Main driver method
    public static void main(String[] args) {

        // Anonymous class that implements an interface
        // Myclass is hidden inner class of Age interface
        // whose name is not written but an object to it
        // is created.
        Age oj1 = new Age() {

            @Override
            public void getAge() {
                // printing age
                System.out.print("Age is " + x);
            }
        };

        oj1.getAge();

        // Anonymous class that extends a class
        Thread rn = new Thread() {
            public void run() {
                System.out.println("From anonymous inner class that extends Runnable class");
            }
        };

        rn.start();

        // Anonymous Inner class that defines inside method/constructor argument

        Thread th = new Thread(new Runnable() {
            public void run(){
                System.out.println("From anonymous class as argument");
            }
        });
        th.start();

    }
}
