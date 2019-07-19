package joaquin;

import java.util.Scanner;

public class StuckInRoom {
    // creates scanner
    Scanner userInput = new Scanner(System.in);

    // setting the scene
        System.out.println("You are stuck in a room");
        System.out.println("The rabbit wants his scissors.");
        System.out.println("He tries to come on trhough the side");
        System.out.println("What will you do?");
        System.out.println("You can.. press 1 for staying still or press 2 to push the ladder over");

    int aliceDoes = userInput.nextInt(); //creates variable to store user selection for this choice
        userInput.nextLine();

    // you choose between different options
        switch (aliceDoes) {
        case 1:
            System.out.println("You have been killed by the rabbit.");
            // plays a spooky audio track
            break;
        case 2:
            System.out.println("You block the entrance and crush the rabbits hands.");
            break;
        default:
            System.out.println("Invalid input!");

    }

    boolean rabbitDoesNotGiveUp = false;

        if (aliceDoes == 1)
    {
        System.out.println("You have been killed by the rabbit.");
        // plays a spooky audio track
    }
        else if (aliceDoes == 2)
    {
        System.out.println("You block the entrance and crush the rabbits hands.");
        rabbitDoesNotGiveUp = true;
    }
        else
    {
        System.out.println("Invalid input!");
    }

        if (rabbitDoesNotGiveUp == true)
    {
        System.out.println("Rabbit decides to come through the window");
        System.out.println("You push over the ladder.");
        System.out.println("The rabbit is unhappy. He schemes...");
        System.out.println("The rabbit sends a creature-minion.");
        System.out.println("Push T to throw rocks to defend yourself.");
        String aliceDefends = userInput.nextLine();
        if (aliceDefends.toUpperCase() == "T")
        {
            System.out.println("You have killed the minion.");
            System.out.println("While they are reviving him you escape by " +
                    "eating a cookie and shrinking down to the size of a doll");
        }
    }

}
