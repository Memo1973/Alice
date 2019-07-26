
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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

    String position , clickSound;
    ImageIcon image;

    SoundEffect se = new SoundEffect();

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

        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_00_01_39-00_02_20.wav";


        beginningScene();

    }

    public class  SoundEffect{

        Clip clip;

        public void setFile(String soundFilename){

            try {
                File file = new File(soundFilename);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            catch (Exception e){

            }

        }

        public void play(){

            clip.setFramePosition(0);
            clip.start();
        }
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

        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_00_58_57-00_59_00.wav";

        se.setFile(clickSound);
        se.play();

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

    public void eatingFly(){
///needs new image and sound
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\flies_to_eliminate.png");
        imageLabel.setIcon(image);

        position = "eatingFly";
        mainTextArea.setText("Press Button x to eliminate flies with frog-footman tongue.");
        choice1.setText("X");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }

    public void frogmanLeaves(){
///needs image and sound
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\frogman_window.png");
        imageLabel.setIcon(image);

        position = "frogmanLeaves";
        mainTextArea.setText("Frog-footman leaves by jumping out the window.  \n\nAlice notices a sound\nPursue the sound?");
        choice1.setText("Yes!");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }

    public void askRabbit(){


            //Images for Method
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
            //Audio for Method
        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_01_13-01_01_16.wav";
        se.setFile(clickSound);
        se.play();

        position = "askRabbit";
        mainTextArea.setText("You see the rabbit.\nYou ask of the rabbit, 'sir please!\nYou are now rabbit!" +
                "You are feeding a baby and you hear Alice knocking at the door.\n\nThere are dishes nearby..\n");
        choice1.setText("Throw dishes");
        choice2.setText("Throw baby");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);
    }

    public void babyThrown(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\now_alice_50.png");
        imageLabel.setIcon(image);
        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_01_13-01_01_16.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "babyThrown";
        mainTextArea.setText("Baby thrown. Baby is pig!\nYou are now Alice!  Alice releases pig.\nYou pick up the invitation.");
        choice1.setText("Read invitation");
        choice2.setText("Disregard message");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);

    }

    public void whoCares(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
//        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_01_13-01_01_16.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "whoCares";
        mainTextArea.setText("Who cares what the queen wants!\n\n\nYou fell asleep.");
        choice1.setText("");
        choice2.setText(">>>");
        choice3.setText("");

        choice1.setVisible(false);
        choice2.setVisible(true);
        choice3.setVisible(false);

    }

    public void queenNote(){

        //needs image
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_10_36-01_10_43.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "queenNote";
        mainTextArea.setText("Greetings,\n" + "\n" + "Come to the palace.\n" + "\n" + "Firmly,\n" + "The Queen\n");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);

    }

    public void noRoom(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
        
        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_10_36-01_10_43.wav";
        se.setFile(clickSound);
        se.play();

        position = "noRoom";
        mainTextArea.setText("You are being shouted at by the Mad Hatter.\n\nNo room, no room, no room, no room, no room!' is what you hear\n" +
                "You are at a door.\nWould you like to enter?");
        choice1.setText("");
        choice2.setText("Yes");
        choice3.setText("");

        choice1.setVisible(false);
        choice2.setVisible(true);
        choice3.setVisible(false);

    }


    public void climbSteps(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\up_the_stairs_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_01_13-01_01_16.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "climbSteps";
        mainTextArea.setText("You see the rabbit, would you like to chase him?\n\nPress Climb button to climb steps");
        choice1.setText("Climb");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);

    }
//
    public void followQueen(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_img2_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_01_13-01_01_16.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "followQueen";
        mainTextArea.setText("You have climbed the stairs  You follow him.\nAfter following him you see the queen." +
                "Would you like to know what the queen wants?");
        choice1.setText("Yes");
        choice2.setText("No");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(false);

    }
    public void deadQueen(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_img2_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_01_13-01_01_16.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "deadQueen";
        mainTextArea.setText("The Queen is Dead! And so are you!");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);

    }
//
    public void queenCroquet(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_01_13-01_01_16.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "queenCroquet";
        mainTextArea.setText("She asks you to play croquet. You decide yes.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText(">>>");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(true);

    }

    public void namelessCrime(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_22_44-01_22_50.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "namelessCrime";
        mainTextArea.setText("You start to realize that this is not what you thought.\nYour mind is fuzzy and suddenly you are standing before a jury with the " +
                "King and Queen at the forefront accusing you of a nameless\n crime!\nThey want to know if you committed the crime.\nThey are upset and want with you to apologize.\n");
        choice1.setText("Apologize");
        choice2.setText("Shake head");
        choice3.setText("No");

        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);

    }
    public void allHappy(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
//        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_22_44-01_22_50.wav";
//        se.setFile(clickSound);
//        se.play();

        position = "allHappy";
        mainTextArea.setText("All are happy. You dance with all!");
        choice1.setText(">>>");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(true);
        choice2.setVisible(false);
        choice3.setVisible(false);

    }
    public void offWithHerHead(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_22_44-01_22_50.wav";
        se.setFile(clickSound);
        se.play();

        position = "offWithHerHead";
        mainTextArea.setText("Off with her head they proclaim\n\n\nSuddenly you awake.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText(">>>");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(true);

    }
    public void allADream(){
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\rabbit_with_baby_40.png");
        imageLabel.setIcon(image);
        //Audio for Method
        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_01_25_00-01_25_10.wav";
        se.setFile(clickSound);
        se.play();

        position = "allADream";
        mainTextArea.setText("You are safe now. It was all a dream. After all you are alive.\nYou look to the corner of the room and see the rabbit that was" +
                "there before is now gone with the nails that held him left behind\nYou decide to take matters into your own hands. You grab a pair of scissors from the rabbits glass box\n" +
                "You realize you were the queen.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText(">>>");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(true);

    }









    public void gameEnding(){
        position = "gameEnding";
        mainTextArea.setText("                     The End ");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
    }

    public void gameOver(){


        clickSound = "C:\\Users\\tello\\Alice2\\src\\joaquin\\Alice_Dies_Mario_Sound.wav";

        se.setFile(clickSound);
        se.play();
        image = new ImageIcon("C:\\Users\\tello\\Alice2\\src\\joaquin\\game_over.png");
        imageLabel.setIcon(image);

        imageLabel.setVisible(true);

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
            se.setFile(clickSound);
            se.play();
        }
    }


    public class ChoiceHandler implements  ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "beginningScene":
                    switch (yourChoice) {
                        case "c1":
                            rabbitStage();
                            break;
                    }
                    break;
                case "rabbitStage":
                    switch (yourChoice) {
                        case "c1":
                            stayStill();
                            break;
                        case "c2":
                            pushLadder();
                            break;
                    }
                    break;
                case "stayStill":
                    switch (yourChoice) {
                        case "c1":
                            gameOver();
                            break;
                    }
                    break;
                case "pushLadder":
                    switch (yourChoice) {
                        case "c1":
                            rabbitDoesNotGiveUp();
                            break;
                    }
                    break;
                case "rabbitDoesNotGiveUp":
                    switch (yourChoice) {
                        case "c1":
                            deadMinion();
                            break;
                    }
                    break;
                case "deadMinion":
                    switch (yourChoice) {
                        case "c1":
                            babyCrying();
                            break;
                    }
                    break;
                case "babyCrying":
                    switch (yourChoice) {
                        case "c1":
                            fishFootMan();
                            break;
                    }
                    break;
                case "fishFootMan":
                    switch (yourChoice) {
                        case "c1":
                            frogFootMan();
                            break;
                    }
                    break;
                case "frogFootMan":
                    switch (yourChoice) {
                        case "c1":
                            eatingFly();
                            break;
                    }
                    break;
                case "eatingFly":
                    switch (yourChoice) {
                        case "c1":
                            frogmanLeaves();
                            break;
                    }
                    break;
                case "frogmanLeaves":
                    switch (yourChoice) {
                        case "c1":
                            askRabbit();
                            break;
                    }
                    break;
                case "askRabbit":
                    switch (yourChoice) {
                        case "c1":
                            gameOver();
                            break;
                        case "c2":
                            babyThrown();
                            break;
                    }
                    break;
                case "babyThrown":
                    switch (yourChoice) {
                        case "c1":
                            queenNote();
                            break;
                        case "c2":
                            whoCares();
                            break;
                    }
                    break;
                case "whoCares":
                    switch (yourChoice) {
                        case "c2":
                            gameOver();
                            break;
                    }

                break;
                case "queenNote":
                    switch (yourChoice) {
                        case "c1":
                            noRoom();
                            break;
                    }
                break;
                case"noRoom":
                    switch (yourChoice){
                        case"c2": climbSteps();break;
                    }
                    break;
                case "climbSteps":
                    switch (yourChoice){
                        case "c1": followQueen();break;
                    }
                    break;
                case "followQueen":
                    switch (yourChoice){
                        case"c1": queenCroquet(); break;
                        case"c2": deadQueen(); break;
                    }
                    break;
                case "deadQueen":
                    switch (yourChoice){
                        case"c3": gameOver(); break;
                    }

                    break;
                case "queenCroquet":
                    switch (yourChoice){
                        case"c3": namelessCrime(); break;
                    }
                    break;
                case"namelessCrime":
                    switch (yourChoice){
                        case"c1":  allHappy(); break;
                        case"c2": offWithHerHead(); break;
                        case"c3": allADream(); break;
                    }
                    break;
                case "allHappy":
                    switch (yourChoice){
                        case"c1": allADream(); break;
                    }
                    break;
                case "offWithHerHead":
                    switch (yourChoice){
                        case"c3": allADream(); break;
                    }
                    break;
                case "allADream":
                    switch (yourChoice){
                        case"c3": gameEnding(); break;
                    }







            }



            }

        }
    }





