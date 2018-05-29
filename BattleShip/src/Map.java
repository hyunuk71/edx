public class Map {
    private char[][] myMap;

    public Map() {
        this.myMap = new char[10][10];
        fillMap(myMap);
    }

    private void fillMap(char[][] map) { // initialise the ocean map with blank.
        for (int row = 0; row < myMap.length; row++) {
            for (int column = 0; column < map[row].length; column++) {
                map[row][column] = ' ';
            }
        }
    }

    public void printMap() { printMap(myMap);} // print map with the coordinates.

    private void printMap(char[][] map) {
        System.out.println("   0123456789   ");
        for (int row = 0; row < myMap.length; row++) {
            System.out.print(row + " |");
            for (int column = 0; column < map[row].length; column++) {
                System.out.print(map[row][column]);
            }
            System.out.print("| " + row);
            System.out.println();
        }
        System.out.println("   0123456789   ");
    }


    public boolean isValid(int x, int y){
        boolean isValid = false;
        if (myMap[x][y] != ' ')
            isValid = true;
        return isValid;
    }

    public void setX(int x){

    }

    public void setY(int y){

    }
}
