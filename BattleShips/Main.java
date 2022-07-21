public class Main {
    public static void main(String[] args) {
        // Main game
        Design designTool = new Design();
        System.out.println(designTool.header);

        designTool.makeSpace();
        System.out.println("\u001B[31mPlayer1\u001B[0m sets up the board!");
        Board player1 = new Board(10);
        player1.setUpBoard();

        designTool.makeSpace();
        System.out.println("\u001B[31mPlayer2\u001B[0m sets up the board!");
        Board player2 = new Board(10);
        player2.setUpBoard();

        designTool.makeSpace();
        Game game = new Game(player1, player2);
        game.play();
    }
}
