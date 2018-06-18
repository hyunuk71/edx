import java.util.Scanner;

public class Main {
    static Map myMap = new Map();

    public static void main(String[] args) {
        intro();
        deploy();
        System.out.println("---------------------------");
        battle();
    }

    public static void intro(){
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println();
        System.out.println("Right now, the sea is empty.");
        System.out.println();

        myMap.printMap(); //Initialize the map
    }

    public static void deploy() {
        Scanner s = new Scanner(System.in);
        Ship[] pShip = new Ship[4];
        Ship[] cShip = new Ship[4];
        int x = 99;
        int y = 99;
        System.out.println("Deploy your ships:");

        for (int i = 0; i < 4; i++) { // Deploy player's ships.
            pShip[i] = new Ship();
            do {
                System.out.print("Enter X coordinate for your " + (i + 1) + ". ship(0 - 9): ");
                x = s.nextInt();
                System.out.print("Enter Y coordinate for your " + (i + 1) + ". ship(0 - 9): ");
                y = s.nextInt();
            } while (myMap.isValid(x, y) == false);
            pShip[i].setCoordinate(x, y);
            myMap.deployPShip(x, y);
            myMap.printMap();
            System.out.println("Ship " + (i + 1) + " is deployed!");
        }

        for (int i = 0; i < 4; i++) {
            cShip[i] = new Ship();
            do {
                System.out.println("Computer is deploying ships");
                x = (int)(Math.random() * 10);
                y = (int)(Math.random() * 10);

            } while (myMap.isValid(x, y) == false);
            try {Thread.sleep(1000);} catch (InterruptedException e){}
            cShip[i].setCoordinate(x, y);
            System.out.println((i + 1) + ". ship DEPLOYED");
        }
    }

    public static void battle() {
        System.out.println();
    }
}