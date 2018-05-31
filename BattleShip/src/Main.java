import java.util.Scanner;

public class Main {
    static Map myMap = new Map();

    public static void main(String[] args) {
        intro();
        deploy();
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
        System.out.println("Deploy your ships:");

        for (int i = 0; i < 4; i++){
            while(true){
                System.out.println("Enter X coordinate for your" + i + ". ship(0 - 9): ");
                int x = s.nextInt();
                System.out.println("Enter Y coordinate for your" + i + ". ship(0 - 9): ");
                int y = s.nextInt();
                if (myMap.isValid(x, y) == true) {
                    pShip[i].setX(x);
                    pShip[i].setY(y);
                    myMap.registerShip(pShip[i]);

                }
            }
        }

    }


}