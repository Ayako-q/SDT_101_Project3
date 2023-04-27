package Part_1;

import Part_1.BasePolymorphic;
import Part_1.SubPolymorphic;

public class Main
{
    public static void main(String[] args)
    {
        // Part 1.1: Polymorphism example
        BasePolymorphic a = new SubPolymorphic();
        // We create an instance of the subclass using the base class

        // We call theMethod, which exists in both the sub and base classes
        a.theMethod();

        // We can see that we access a method of the SUB class. That's because
        // when we define an object of the base class as an instance of the subclass
    }
}