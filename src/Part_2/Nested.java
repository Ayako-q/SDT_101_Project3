package Part_2;

public class Nested {

    // Inner class example
    public class InnerClass
    {
        public void printMessage() {
            System.out.println("This is an inner class.");
        }
    }

    // Local class example
    public void printMessage() {
        class LocalClass {
            public void print() {
                System.out.println("This is a local class.");
            }
        }
        LocalClass local = new LocalClass();
        local.print();
    }
    // Anonymous class example
    public void displayMessage()
    {
        InnerClass anon = new InnerClass()
        {
            @Override
            public void printMessage() {
                System.out.println("This is an ANONYMOUS!!! class.");
            }
        };
    }

    // Main method to test the classes
    public static void main(String[] args) {
        Nested demo = new Nested();
        InnerClass inner = demo.new InnerClass();
        inner.printMessage();
        demo.printMessage();
        demo.displayMessage();
    }
}
