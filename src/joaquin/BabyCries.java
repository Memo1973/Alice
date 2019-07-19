package joaquin;

import java.util.Arrays;
import java.util.Scanner;

public class BabyCries {
    Scanner userInput = new Scanner(System.in);

        System.out.println("Alice hears a baby crying in a house");
        System.out.println("She bites a stick of wood to enlarge the house");
        System.out.println("Alice hears a knock.");
        /* display the picture of the fish-footman by calling
        ImageParsing and placing photo inside IntelliJ project
         */
    /* play audio at 59:58 or settle for using the text below */
        System.out.println("Alice says 'Come in!/'");
        System.out.println("The creature is a fish-footman");
        System.out.println("The fish-footman hands Alice an invitation.");

        System.out.println("The frog-footman appears, he seems to have been talking to the fish-footman.");
        System.out.println("Alice sees flies, so does the footman.");
    // picture of the frog-footman when he sees flies

    String[][] flies = new String [4][4];
    Arrays.flies[][].fill("%8%");
        for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++);
        {
            System.out.println(flies[i][j]);
        }
    }

        System.out.println("Enter x to eliminate flies with frog-footman tongue.");
    String tongueCatch = userInput.nextLine();
    boolean frogFootManWasHere = false;
        while (//flies.isNotEmpty)
    {
        if (tongueCatch.equalsIgnoreCase("x"))
        {
            Arrays.flies[][].fill("x");

        }
        frogFootManWasHere = true;
    }

        if (frogFootManWasHere == true)
    {
        System.out.println("Frog-footman leaves by jumping out the window.");
        // optional: add audio clip of glass breaking, get audio from archive.org
    }

        System.out.println("Alice notices a sound");
        System.out.println("Pursue the sound?");
    String didShePursue = userInput.nextLine();
        if (didShePursue.equalsIgnoreCase("Yes")) {
        System.out.println("You see the rabbit.");
        // play audio that says 'Sir please' or following line of code audio at 1:01:13 - 1:01:16
        System.out.println("You ask of the rabbit, 'sir please!\'");
        System.out.println("You are now rabbit!");
        System.out.println("You are feeding a baby and you hear Alice knocking at the door." +
                "There are dishes nearby..");
        System.out.println("Press 1 to throw dishes or 2 to throw the baby");
        int rabbitSelection = userInput.nextInt();
        userInput.nextLine();
        switch (rabbitSelection) {
            case 1:
                System.out.println("Dishes thrown.");
            case 2:
                System.out.println("Baby thrown");
                break;
            default:
                System.out.println("Invalid input");
        }
        System.out.println("Baby is pig!");
        System.out.println("You are now Alice!");
        // Show a picture of alice at this point
        System.out.println("Alice releases pig.");

        System.out.println("You pick up the invitation.");
        System.out.println("Press 1 to read the text or 0 to disregard the message");

        int readText = userInput.nextInt();
        userInput.nextLine();
        switch (readText) {
            case 0:
                System.out.println("Who cares what the queen wants!");
                break;
            case 1:
                // access file QueensNote.txt
                break;
            default:
                System.out.println("Invalid input");
        }

    }

        else
    {
        System.out.println("You fell asleep. Game over!");
    }
}
