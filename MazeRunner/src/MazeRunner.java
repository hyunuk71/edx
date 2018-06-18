import java.util.*;
public class MazeRunner {
    static Maze myMap = new Maze();
    static Scanner input = new Scanner(System.in);
    static int moves = 0;

    public static void main(String[] args){
        intro();                                // make map, greeting, print map
        while (myMap.didIWin() == false){
            String dir = inputFunc();           // put input and return, check whether input is RLUD or not.
            boolean canIMove = movePossibility(dir);
            boolean isThereAPit = pitChecker(dir);
            if (canIMove == true){              // false means two things. Wall and Pit.
                userMove(dir);
            } else if (isThereAPit == false) {  // case wall
                System.out.println("Sorry, you've hit a wall.");
            } else {                            // case pit
                pitJump(dir);
            }
        }
        System.out.println("Congratulations! you escaped the maze successfully!");
        System.out.println("and you did it in " + moves + " moves");
        System.exit(0);
    }

    public static void intro(){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
    }

    public static String inputFunc() {
        String dir;
        while (true) {
            System.out.print("Where would you like to move? (R, L, U, D) ");
            dir = input.next().toUpperCase();
            if (dir.equals("R") || dir.equals("L") || dir.equals("U") || dir.equals("D")) {
                break;
            } else {
                System.out.println("Wrong input. You should put R, L, U, and D only. Try again.");
            }
        }
        return dir;
    }

    public static boolean movePossibility(String dir){
        if (dir.equals("R") == true && myMap.canIMoveRight() == true) {
            return true;
        } else if (dir.equals("L") == true && myMap.canIMoveLeft() == true) {
            return true;
        } else if (dir.equals("U") == true && myMap.canIMoveUp() == true) {
            return true;
        } else if (dir.equals("D") == true && myMap.canIMoveDown() == true) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean pitChecker(String dir){
        if (myMap.isThereAPit(dir) == true) {
            return true;
        } else {
            return false;
        }
    }

    public static void pitJump(String dir){
        System.out.println("Watch out! There's a pit ahead, jump it? (Y/N) ");
        String pitJumpAnswer = input.next().toUpperCase();
        if (pitJumpAnswer.startsWith("Y")){
            myMap.jumpOverPit(dir);
            myMap.printMap();
            moves++;
            movesMessage(moves);
        } else {
            pitJump(dir);
        }
    }

    public static void userMove(String dir){
        if (dir.equals("R") == true) {
            myMap.moveRight();
        } else if (dir.equals("L") == true) {
            myMap.moveLeft();
        } else if (dir.equals("U") == true) {
            myMap.moveUp();
        } else if (dir.equals("D") == true) {
            myMap.moveDown();
        }
        myMap.printMap();
        moves++;
        movesMessage(moves);
    }

    public static void movesMessage(int moves){
        switch (moves) {
            case 50:
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
                break;
            case 75:
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90:
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                break;
            case 100:
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                System.exit(0);
                break;
        }
    }
}
