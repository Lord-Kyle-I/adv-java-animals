// Kyle Leverence
// 03/30/26
// Software Architecture
// Matt Green

package us.kyleleverence;

import java.util.*;


// Created by Kyle William Leverence on 03/30/2026
public class TalkableCreator {

    private Talkable getTalkable() {
        Scanner input = new Scanner(System.in);
        String name;
        System.out.println("What is the name of your talkable?");
        name = input.nextLine();
        while(true) {
            System.out.println("What kind of talkable would you like to create?");
            switch (input.nextLine()) {
                case "Cat":
                    return createCat(name);
                case "Dog":
                    return createDog(name);
                case "Teacher":
                    return createTeacher(name);
                default:
                    System.out.println("Please enter \"Cat\", \"Dog\", or \"Teacher\".");
            }
        }
    }

    private Cat createCat(String name) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many mouse kills does " + name + " have?");
        try {
            return new Cat(input.nextInt(), name);
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer.");
            return createCat(name);
        }
    }

    private Dog createDog(String name) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter yes if that dog is loyal.");
        return new Dog(input.nextLine() == "yes", name);
    }

    private Teacher createTeacher(String name) {
        Scanner input = new Scanner(System.in);
        System.out.println("How old is " + name + "?");
        try {
            return new Teacher(input.nextInt(), name);
        } catch (InputMismatchException e) {
            System.out.println("Please enter an integer.");
            return createTeacher(name);
        }
    }

    public void createTalkable(List<Talkable> talkables) {
        talkables.add(getTalkable());
    }

}
