
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, imagePanel;
    JLabel titleNameLabel, imageLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    JButton startButton, choice1, choice2, choice3;
    JTextArea mainTextArea;

    String position;
    ImageIcon image;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args){
        new Game();

    }
    public Game(){
            //Windows
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        con = window.getContentPane();

                //Title Screen
        titleNamePanel =new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("PATH OF ALICE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(270,400,230,100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

    }

    public void createGameScreen(){
                //Game Screen
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(50,350,700,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(50,350,700,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(480,170,270,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton();
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton();
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);


        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);


                //Image
        imagePanel = new JPanel();
        imagePanel.setBounds(50,50,420,280);
        imagePanel.setBackground(Color.black);


        imageLabel = new JLabel();

        image = new ImageIcon("C:\\Users\\tello\\Images\\src\\Tello\\alice_img1_3_30.png");

        imageLabel.setIcon(image);
        imagePanel.add(imageLabel);
        con.add(imagePanel);

        beginningScene();

    }
//    public void playerSetup(){
//
//        beginningScene();
//    }
    public void beginningScene() {

        position = "beginningScene";
        mainTextArea.setText("Water passes through a stream in a wooded area. You decide to\nflip through the book next to you (3) " +
                "You are slapped on the hand. \n\nAlice thought to herself now you will see a film, made for children, \nperhaps " +
                "but I nearly forget. You must close your eyes, \notherwise - you won't see anything!");

        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);

    }
    public void rabbitStage() {
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\beginning_rabbit_30.png");
        imageLabel.setIcon(image);

        position = "rabbitStage";
        mainTextArea.setText("You are stuck in a room.\nThe rabbit wants his scissors. He tries to come on through the side \n\n\nWhat will you do? ");

        choice1.setText("Staying still");
        choice2.setText("Push the ladder over");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);


    }

    public void stayStill(){
        position = "stayStill";
        mainTextArea.setText("You have been killed by the rabbit. ");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);


    }
    public void pushLadder(){
        position = "pushLadder";
        mainTextArea.setText("You block the entrance and crush the rabbits hands. ");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);

    }
    public void rabbitDoesNotGiveUp(){
        position = "rabbitDoesNotGiveUp";
        mainTextArea.setText("Rabbit decides to come through the window. \nYou push over the ladder. The rabbit is unhappy. He schemes...\n" +
                "The rabbit sends a creature-minion.");
        choice1.setText("Throw rocks to defend ");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);

    }

    public void deadMinion(){
        position = "deadMinion";
        mainTextArea.setText("You have killed the minion.\nWhile they are reviving him you escape by\n" +
                "Eating a cookie and shrinking down to the size of a \ndoll.");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }

    public void babyCrying(){

        image = new ImageIcon("C:\\Users\\tello\\Images\\src\\Tello\\alice_img1_3_30.png");
        imageLabel.setIcon(image);

        position = "babyCrying";
        mainTextArea.setText("Alice hears a baby crying in a house she bites a stick of wood to \nenlarge the house\nAlice hears a knock.\n" +
                "Alice says 'Come in!/' ");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }
    public void fishFootMan(){

        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\fish-footman_40.png");
        imageLabel.setIcon(image);

        position = "fishFootMan";
        mainTextArea.setText("The creature is a fish-footman \nThe fish-footman hands Alice an invitation.");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }

    public void frogFootMan(){

        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\frog-footman_fly_50.png");
        imageLabel.setIcon(image);

        position = "frogFootMan";
        mainTextArea.setText("The frog-footman appears, he seems to have been talking to the\n fish-footman. \nAlice sees flies, so does the footman.");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }










//    public void gameEnding(){
//        position = "gameEnding";
//        mainTextArea.setText("             THE END ");
//        choice1.setText("");
//        choice2.setText("");
//        choice3.setText("");
//    }

    public void gameOver(){

        imageLabel.setVisible(false);

        position = "gameOver";
        mainTextArea.setText("You are dead!!\n\n\n  " +
                "                                          <GAME OVER>");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }







    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }


    public class ChoiceHandler implements  ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch (position){
                case "beginningScene":
                    switch(yourChoice) {
                        case "c1":
                            rabbitStage();
                            break;
                    }
                    break;
                case "rabbitStage":
                    switch(yourChoice){
                    case "c1": stayStill(); break;
                        case "c2": pushLadder(); break;
                }
                break;
                case "stayStill":
                        switch(yourChoice){
                            case"c1":gameOver();  break;
                        }
                        break;
                case"pushLadder":
                    switch(yourChoice){
                        case"c1": rabbitDoesNotGiveUp(); break;
                    }
                    break;
                case"rabbitDoesNotGiveUp":
                    switch (yourChoice) {
                        case "c1": deadMinion(); break;
                    }
                    break;
                case"deadMinion":
                    switch (yourChoice){
                        case "c1": babyCrying(); break;
                    }
                    break;
                case"babyCrying":
                    switch (yourChoice){
                        case "c1": fishFootMan(); break;
                    }
                    break;
                case"fishFootMan":
                    switch (yourChoice){
                        case "c1": frogFootMan(); break;
                    }


            }



            }

        }
    }





