import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args){
        // greetings
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String userName = input.nextLine();
        System.out.println("Hi " + userName + ", which do you choose? (O)dds or (E)vens?");
        String oddsOrEvens = input.next();
        while (true){
            if (oddsOrEvens.equals("O")) {
                System.out.println(userName + " has picked odds! The computer will be evens.");
                break;
            } else if (oddsOrEvens.equals("E")) {
                System.out.println(userName + " has picked evens! The computer will be odds.");
                break;
            } else {
                System.out.println(userName + ", don't kidding me. Please choose your side. (O)dds or (E)vens?");
                oddsOrEvens = input.next();
            }
        }
        System.out.println("--------------------------------------------------");

        //play
        int pFingers = 0;
        while (true) {
            System.out.print("How many \"fingers\" do you put out?(0-5) ");
            pFingers = input.nextInt();
            if (pFingers > 5) {
                System.out.println("You can't put your fingers more than 5! Try again.");
            } else if (pFingers < 0) {
                System.out.println("No negative fingers are allowed! Try again.");
            } else {
                break;
            }
        }
        Random rand = new Random();
        int cFingers = rand.nextInt(6);
        System.out.println("The computer plays number " + cFingers + " fingers");
        System.out.println("--------------------------------------------------");
        int sumFingers = pFingers + cFingers;
        boolean oddOrEven = sumFingers % 2 == 0;

        // choose winner
        System.out.println(pFingers + " + " + cFingers + " = " + sumFingers);
        if (oddOrEven == true) {
            System.out.println(sumFingers + " is ...even!");
            if (oddsOrEvens.equals("E")) {
                System.out.println("That means " + userName + "wins! :)");
            } else {
                System.out.println("That means computer wins! :(");
            }
        } else {
            System.out.println(sumFingers + " is ...odd!");
            if (oddsOrEvens.equals("O")) {
                System.out.println("That means " + userName + "wins! :)");
            } else {
                System.out.println("That means computer wins! :(");
            }
        }
    }
}