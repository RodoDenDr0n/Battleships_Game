import java.util.Scanner;


public class Board {
    // Board class
    public final int size;  // game board size
    public int[][] board;    // creates board array
    public String[][] representation;  // board that will be played on
    Design designTool = new Design();
    Board(int size){
        // Constructs Map object
        this.size = size;
        this.board = new int[size][size];
        this.representation = new String[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                representation[i][j] = "o";
            }
        }
        showBoard();
    }


    void showBoard(){
        // prints out board
        String coloredBoard = designTool.colorBoard(board);
        System.out.println("\n" + coloredBoard);
    }


    void showRepresentation(){
        // prints out colored board
        String coloredBoard = designTool.colorBoard(representation);
        System.out.println("\n" + coloredBoard);
    }


    String askDirection(int deckNumber){
        // Asks direction either 'horizontal' or 'vertical'
        System.out.println("\nChoose the direction for " + "\u001B[32m" + deckNumber + "-deck ship\u001B[0m:");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine();
        if (direction.equalsIgnoreCase("horizontal") ||
                direction.equalsIgnoreCase("vertical")){
            return direction;
        }
        System.out.println("Input is not valid. Try again!");
        return askDirection(deckNumber);
    }


    boolean isShip(int rowValue, int columnValue) {
        // Checks if board coordinate is ship
        return board[rowValue][columnValue] == 1;
    }


    boolean shipsLeft(){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (isShip(i, j)){
                    return true;
                }
            }
        }
        return false;
    }


    boolean placementIsValid(int decksNumber, int coordinate, boolean isHorizontal,
                             int xCoordinate, int yCoordinate) {
        // Validates the placement
        boolean isInsideBoard = size - coordinate >= decksNumber;
        boolean doesNotIntersect = true;
        for (int i = coordinate; i < coordinate + decksNumber; i++) {
            if (isHorizontal) {
                doesNotIntersect &= !isShip(yCoordinate, i);
            } else {
                doesNotIntersect &= !isShip(i, xCoordinate);
            }
        }
        return isInsideBoard & doesNotIntersect;
    }


    int[] getCoordinates(){
        // Asks user for coordinates
        int[] coordinates = new int[2];

        System.out.println("\nEnter value of " + "\u001B[32mX coordinate\u001B[0m" + ":");
        Scanner getXCoordinate = new Scanner(System.in);
        int xCoordinate = getXCoordinate.nextInt();

        System.out.println("Enter value of " + "\u001B[32mY coordinate\u001B[0m" + ":");
        Scanner getYCoordinate = new Scanner(System.in);
        int yCoordinate = getYCoordinate.nextInt();

        coordinates[0] = xCoordinate; coordinates[1] = yCoordinate;
        return coordinates;
    }


    void placeShip(int decksNumber, String direction) {
        // Places the ship on the board
        int[] coordinates = getCoordinates();
        int xCoordinate = coordinates[0]; int yCoordinate = coordinates[1];

        // places ship horizontally or vertically
        boolean isHorizontal = direction.equalsIgnoreCase("horizontal");
        int coordinate = (isHorizontal) ? xCoordinate : yCoordinate;
        if (placementIsValid(decksNumber, coordinate, isHorizontal,
                xCoordinate, yCoordinate)) {
            for (int i = coordinate; i < coordinate + decksNumber; i++) {
                if (isHorizontal) {
                    board[yCoordinate][i] = 1;
                } else {
                    board[i][xCoordinate] = 1;
                }
            }
            showBoard();
        } else {
            System.out.println("Input is not valid. Try again!");
            placeShip(decksNumber, direction);
        }
    }


    void setUpBoard(){
        // Creates ships and places them on game board
        int shipsLogic = 5;  // the sum of ships and decks they have always equals 5
        for (int amount = 1; amount < shipsLogic; amount++){
            int deckNumber = shipsLogic - amount;
            for (int i = 0; i < amount; i++){
                String direction = askDirection(deckNumber);
                placeShip(deckNumber, direction);
            }
        }
    }
}
