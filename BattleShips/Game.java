public class Game {
    // Game class
    private final Board player1;
    private final Board player2;
    Design designTool = new Design();
    Game(Board player1, Board player2){
        // Constructs Game object
        this.player1 = player1;
        this.player2 = player2;
    }


    boolean makeMove(Board player){
        // Makes move
        boolean noShips = !player.shipsLeft();
        if (noShips){
            return true;
        }

        player.showRepresentation();
        int[] coordinates = player.getCoordinates();
        int xCoordinate = coordinates[1]; int yCoordinate = coordinates[0];

        if (player.isShip(xCoordinate, yCoordinate)) {
            player.board[xCoordinate][yCoordinate] = 0;
            player.representation[xCoordinate][yCoordinate] = "X";
            System.out.println("\u001B[36mYou shot the enemy!\u001B[0m");
            return makeMove(player);
        }

        player.representation[xCoordinate][yCoordinate] = "_";
        System.out.println("\u001B[31mYou missed!\u001B[31m");
        designTool.makeSpace();
        return false;
        }


    boolean play(){
        // Plays the game
        System.out.println("\n\u001B[31mPlayer1\u001B[0m makes move!");
        boolean playerVictory1 = makeMove(player2);
        if (playerVictory1){
            System.out.println("\n\u001B[33mPlayer1 won!\u001B[0m\n");
            return true;
        }

        System.out.println("\n\u001B[31mPlayer2\u001B[0m makes move!");
        boolean playerVictory2 = makeMove(player1);
        if (playerVictory2){
            System.out.println("\n\u001B[33mPlayer2 won!\u001B[0m\n");
            return true;
        }

        return play();
    }
}
