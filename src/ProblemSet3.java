/**
 * Problem Set 3.
 * 
 * It's time to put your skills to the test. This problem set focuses on using
 * conditional control structures. It's also your first introduction to methods,
 * so things look a little different. The main method is done for you. Lines 31-40
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 * 
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the Deliverables section).
 * 
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet3 {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        ProblemSet3 ps = new ProblemSet3();
        
        // comment out or uncomment as needed
        
        //ps.sign();          // executes Exercise 1
        //ps.parity();        // executes Exercise 2
        //ps.ordered();       // executes Exercise 3
        //ps.gpa();           // executes Exercise 4
        //ps.grade();         // executes Exercise 5
        //ps.cards();         // executes Exercise 6
        //ps.leapYear();      // executes Exercise 7
        ps.state();         // executes Exercise 8
        ps.months();        // executes Exercise 9
        ps.salary();        // executes Exercise 10
        
        in.close();
    }
    
    /*
     * Exercise 1.
     * 
     * Prompt the user to enter an integer. Is it positive, negative, or zero?
     * 
     * Solved!
     * 
     */
    
    public void sign() {
        System.out.print("\nEnter an integer: ");
        int userInt = in.nextInt();
        in.nextLine();

        if (userInt > 0) {
            System.out.println("\nPositive.");
        } else if (userInt < 0) {
            System.out.println("\nNegative.");
        } else {
            System.out.println("\nZero.");
        }

    }
    
    /*
     * Exercise 2.
     * 
     * Prompt the user to enter an integer. Is it even or odd?
     * 
     * Solved!
     * 
     */
    
    public void parity() {

        System.out.print("\nEnter an integer: ");
        int userInt = in.nextInt();
        in.nextLine();

        if (userInt % 2 == 1) {
            System.out.println("\nOdd.");
        } else {
            System.out.println("\nEven.");
        }


    }
    
    /*
     * Exercise 3.
     * 
     * Prompt the user to enter three integers. How are the integers ordered?
     * 
     * Solved, for now.
     * 
     */
    
    public void ordered() {

        boolean strictlySpaced = false; //declaration + initialization for later use

        System.out.print("\nEnter three integers, one at a time.\n\nEnter an integer: ");
        int userInt1 = in.nextInt();
        in.nextLine();
        System.out.print("Enter an integer: ");
        int userInt2 = in.nextInt();
        in.nextLine();
        System.out.print("Enter an integer: ");
        int userInt3 = in.nextInt();
        in.nextLine();  

        if ((userInt2 - userInt1) == (userInt3 - userInt2)) { //if 2-1 = 3-2, the #'s are equidistant
            strictlySpaced = true;
        }

        if (userInt1 == userInt2 && userInt2 == userInt3) { //if all ints are equal
            System.out.println("\nSame.");
        } else if (userInt1 <= userInt2 && userInt2 <= userInt3) { //if each # is bigger than the last
            if(strictlySpaced == true){ 
                System.out.println("\nStrictly increasing.");
            } else {
                System.out.println("\nIncreasing.");
            }
        } else if (userInt1 >= userInt2 && userInt2 >= userInt3) { //if each # is smaller than the last
            if(strictlySpaced == true){ 
                System.out.println("\nStrictly decreasing.");
            } else {
                System.out.println("\nDecreasing.");
            }
        } else { //numbers must logically be unordered
            System.out.println("\nUnordered.");
        }

    }
    
    /*
     * Exercise 4.
     * 
     * Prompt the user to enter a letter grade. What's the corresponding GPA?
     * 
     * Solved.
     * 
     */
    
    public void gpa() {

        boolean validInput = true;
        String gradeLetter = "";
        String gradeSign = "";
        double GPA = 0.00;
        
        final double A_VALUE = 4.00;
        final double B_VALUE = 3.00;
        final double C_VALUE = 2.00;
        final double D_VALUE = 1.00;
        final double F_VALUE = 0.00;
        final double PLUS_VALUE = 0.33;
        final double MINUS_VALUE = -0.33;

        System.out.print("\nEnter a letter grade: ");
        String userGrade = in.nextLine();

        if (userGrade.length() == 0 || userGrade.length() > 2 ) { //acceptable inputs are 1 or 2 characters
            validInput = false;
        } else if (userGrade.equals("F+") || userGrade.equals("F-")) { //checks for invalid F grades, separated for readibility
            validInput = false;
        } else { //separates letter from sign, if there is one
            gradeLetter = userGrade.substring(0, 1);
            gradeLetter = gradeLetter.toUpperCase();
            if (userGrade.length() == 2) {
                gradeSign = userGrade.substring(1);
            }
        }


        switch (gradeLetter) { //determines letter value
            case "A": GPA = A_VALUE; break;
            case "B": GPA = B_VALUE; break;
            case "C": GPA = C_VALUE; break;
            case "D": GPA = D_VALUE; break;
            case "F": GPA = F_VALUE; break;
            default: validInput = false; break;
        }

        switch (gradeSign) { //determines sign's value, if any
            case "+": if (!(gradeLetter.equals("A"))) { GPA += PLUS_VALUE; } break;
            case "-":  GPA += MINUS_VALUE; break;
            case "": break;
            default: validInput = false; break;
        }


        if (validInput == true) {
            System.out.printf("\nYour GPA is %.2f.", GPA);
        } else {
            System.out.println("\nThat's not a valid letter grade.");
        }

    }
    
    /*
     * Exercise 5.
     * 
     * Prompt the user to enter a grade. What's the corresponding letter grade?
     * 
     * Solved!
     */
    
    public void grade() {

        boolean validInput = true;
        boolean useAn = false;
        final int A_THRESHOLD = 90;
        final int B_THRESHOLD = 80;
        final int C_THRESHOLD = 70;
        final int D_THRESHOLD = 60;
        String userLetterGrade = "";

        System.out.print("\nEnter a number grade: ");
        double userNumberGrade = in.nextDouble();

        if (userNumberGrade >= A_THRESHOLD) {
            userLetterGrade = "A";
            useAn = true;
        } else if (userNumberGrade >= B_THRESHOLD) {
            userLetterGrade = "B";
        } else if (userNumberGrade >= C_THRESHOLD) {
            userLetterGrade = "C";
        } else if (userNumberGrade >= D_THRESHOLD) {
            userLetterGrade = "D";
        } else {
            userLetterGrade = "F";
            useAn = true;
        }

        
        if (userNumberGrade < 0){
            System.out.println("\nGrades below 0 are invalid.");               
        } else if (userNumberGrade > 100) {
            System.out.println("\nGrades above 100 are invalid.");
        } else if (useAn == true) {
            System.out.println("\nYou received an " + userLetterGrade + ".");
        } else {
            System.out.println("\nYou received a " + userLetterGrade + ".");
        }
    }
    
    /*
     * Exercise 6.
     * 
     * Prompt the user to enter a playing card. What card was entered?
     * 
     * Solved!
     * 
     */
    
    public void cards() {

        String cardRankAbbrev = ""; //Card Rank Abbreviated (T)
        String cardSuitAbbrev = ""; //Card Suit Abbreviated (C)
        boolean validSuit = true;
        boolean validRank = true;
        String cardRankFull = ""; //Card Rank Full (Ten)
        String cardSuitFull = ""; //Card Suit Full (Clubs)

        System.out.print("\nEnter a card: ");
        String userCard = in.nextLine();

        cardRankAbbrev = userCard.substring(0, 1);
        cardRankAbbrev = cardRankAbbrev.toUpperCase();
        cardSuitAbbrev = userCard.substring(1);
        cardSuitAbbrev = cardSuitAbbrev.toUpperCase();

        switch(cardRankAbbrev) {
            case "2": cardRankFull = "Two"; break;
            case "3": cardRankFull = "Three"; break;
            case "4": cardRankFull = "Four"; break;
            case "5": cardRankFull = "Five"; break;
            case "6": cardRankFull = "Six"; break;
            case "7": cardRankFull = "Seven"; break;
            case "8": cardRankFull = "Eight"; break;
            case "9": cardRankFull = "Nine"; break;
            case "T": cardRankFull = "Ten"; break;
            case "J": cardRankFull = "Jack"; break;
            case "Q": cardRankFull = "Queen"; break;
            case "K": cardRankFull = "King"; break;
            case "A": cardRankFull = "Ace"; break;
            default: validRank = false; break;
        }

        switch(cardSuitAbbrev) {
            case "C": cardSuitFull = "Clubs"; break;
            case "D": cardSuitFull = "Diamonds"; break;
            case "H": cardSuitFull = "Hearts"; break;
            case "S": cardSuitFull = "Spades"; break;
            default: validSuit = false; break;
        }

        if (validSuit == false) {
            System.out.print("\nThat's not a valid suit.");
        } else if (validRank == false) {
            System.out.print("\nThat's not a valid rank.");
        } else {
            System.out.println("\n" + cardRankFull + " of " + cardSuitFull);
        }
    }
    
    /*
     * Exercise 7.
     * 
     * Prompt the user to enter a year. Is it a leap year or not?
     * 
     * Solved, though it feels TOO easy...
     * 
     */
    
    public void leapYear() {

        System.out.print("\nEnter a year: ");
        int userYear = in.nextInt();
        in.nextLine();

        boolean isLeapYear = ((userYear % 4) == 0) && ((userYear % 100) != 0) || ((userYear % 400) == 0);

        if (isLeapYear == true) {
            System.out.print("\n" + userYear + " is a leap year.");
        } else {
            System.out.print("\n" + userYear + " is not a leap year.");
        }
    }
    
    /*
     * Exercise 8.
     * 
     * Prompt the user to enter a temperature. At that temperature, is water a solid,
     * liquid, or gas?
     */
    
    public void state() {

        final int FREEZING_POINT_C = 0;
        final int FREEZING_POINT_F = 32;
        final int BOILING_POINT_C = 100;
        final int BOILING_POINT_F = 212;
        boolean validScale = true;
        String state = "";

        System.out.print("\nEnter a temperature: ");
        double temperature = in.nextDouble();
        in.nextLine(); 
        System.out.print("Enter a scale: ");
        String scale = in.nextLine(); 

        if (scale.equals("C")) {
            if (temperature >= BOILING_POINT_C) {
                state = "Gas.";
            } else if (temperature > FREEZING_POINT_C) {
                state = "Liquid.";
            } else {
                state = "Solid.";
            }
        } else if (scale.equals("F")) {
            if (temperature >= BOILING_POINT_F) {
                state = "Gas.";
            } else if (temperature > FREEZING_POINT_F) {
                state = "Liquid.";
            } else {
                state = "Solid.";
            }
        } else {
            validScale = false;
        }

        if (validScale == false) {
            System.out.print("\n That's not a valid scale.");
        } else {
            System.out.print("\n" + state);
        }
    }
    
    /*
     * Exercise 9.
     * 
     * Prompt the user to enter a month. How many days are in that month?
     */
    
    public void months() {        

    }
    
    /*
     * Exercise 10.
     * 
     * Prompt the user to enter a wage and hours worked. How much money will be made?
     */
    
    public void salary() {

    }
}