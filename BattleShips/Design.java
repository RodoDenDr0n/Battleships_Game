public class Design {
    String header = "\n\n" +
            "  ____        _   _   _       _____ _     _           \n" +
            " |  _ \\      | | | | | |     / ____| |   (_)          \n" +
            " | |_) | __ _| |_| |_| | ___| (___ | |__  _ _ __  ___ \n" +
            " |  _ < / _` | __| __| |/ _ \\\\___ \\| '_ \\| | '_ \\/ __|\n" +
            " | |_) | (_| | |_| |_| |  __/____) | | | | | |_) \\__ \\\n" +
            " |____/ \\__,_|\\__|\\__|_|\\___|_____/|_| |_|_| .__/|___/\n" +
            "                                           | |        \n" +
            "                                           |_|        ";
    Design(){}


    String colorBoard(String[][] board){
        // Returns colored board
        String boardStr = "    0  1  2  3  4  5  6  7  8  9\n";
        for (int i = 0; i < board.length; i++){
            boardStr += " " + i + " \u001B[35m[\u001B[0m";
            for (int j = 0; j < board.length; j++){
                boardStr += board[i][j] + "  ";
            }
            boardStr = boardStr.stripTrailing();
            boardStr += "\u001B[35m]\u001B[0m\n";
        }

        boardStr = boardStr.replaceAll("X", "\u001B[31mX\u001B[0m");
        boardStr = boardStr.replaceAll("o", "\u001B[34mo\u001B[0m");
        boardStr = boardStr.replaceAll("_", "\u001B[37m_\u001B[0m");

        return boardStr.stripTrailing();
    }


    String colorBoard(int[][] board){
        String boardStr = "    0  1  2  3  4  5  6  7  8  9\n";
        for (int i = 0; i < board.length; i++){
            boardStr += " " + i + " \u001B[35m[\u001B[0m";
            for (int j = 0; j < board.length; j++){
                int symbol = board[i][j];
                String coloredSymbol = symbol == 1? "\u001B[33m1\u001B[0m":"\u001B[30m0\u001B[0m";
                boardStr += coloredSymbol + "  ";
            }
            boardStr = boardStr.stripTrailing();
            boardStr += "\u001B[35m]\u001B[0m\n";
        }
        return boardStr.stripTrailing();
    }

    void makeSpace(){
        // Makes space
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }
}
