package Part_1_2;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(new Cat());
        animalList.add(new Cow());
        animalList.add(new Dog());
        animalList.add(new Pig());

        // iterate through every animal in arraylist and call makeSound
        for(Animal a : animalList)
        {
            a.makeSound();
        }
    }
}
