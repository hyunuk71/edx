import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args){
        greeting();
        timeAndBudget();
        timeDifference();
        country();
    }
    // Ask name and destination with a greeting message
    public static void greeting() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Glad to meet you " + name + ", where are you travelling to? ");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip!");
        System.out.println("*****************");
    }

    public static void timeAndBudget() {
        Scanner input = new Scanner(System.in);

        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt(), hours = days*24, minutes = hours*60;

        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        double budgetInUSD = input.nextInt(), budgetPerDays = ((Math.round((budgetInUSD / days) * 100d)) / 100d);

        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String localCurrencySymbol = input.next();

        System.out.print("How many " + localCurrencySymbol + " are there in 1 USD? ");
        double localCurrency = input.nextDouble();
        double budgetInLocal = localCurrency * budgetInUSD, budgetInLocalPerDays = ((Math.round((budgetInLocal / days) * 100d)) / 100d);

        System.out.println("");
        System.out.println("If you are travelling for " + days + " days that is the same as " + hours + " hours or " + minutes + " minutes");
        System.out.println("If you are going to spend $" + (int)(budgetInUSD) + " USD that means per day you can spend up to $" + budgetPerDays + " USD");
        System.out.println("Your total budget in " + localCurrencySymbol + " is " + budgetInLocal + " " + localCurrencySymbol + ", which per day is " + budgetInLocalPerDays + " " + localCurrencySymbol);
        System.out.println("*****************");

    }

    public static void timeDifference() {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int hours = input.nextInt();
        System.out.println("That means that when it is midnight at home, it will be " + (hours % 24) + ":00 in your travel destination");
        System.out.println("and when it is noon at home, it will be " + ((12 + hours) % 24) + ":00");
        System.out.println("*****************");
    }

    public static void country() {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the square area of your destination country in km2? ");
        double sqrt = input.nextInt(), miles = ((Math.round((sqrt * 0.386102) * 100)) / 100);
        System.out.println("In miles2, that is " + miles);
        System.out.println("*****************");
    }
}
