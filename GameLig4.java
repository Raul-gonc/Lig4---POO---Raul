public class GameLig4 {
    
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public GameLig4() {
        board = new Board();
        player1 = new Player("Player 1", "red");
        player2 = new Player("Player 2", "yellow");
        currentPlayer = player1;
    }

    public void startGame() {
        
        /* temporario, apenas pra testar o acréscimo das peças
        
        if(board.verifyInsert(1)){
            board.insertPiece(1, currentPlayer.getPieceColor());
            currentPlayer = player2;
        }
        if(board.verifyInsert(1)){
            board.insertPiece(1, currentPlayer.getPieceColor());
            currentPlayer = player1;
        }
        if(board.verifyInsert(1)){
            board.insertPiece(1, currentPlayer.getPieceColor());
            currentPlayer = player2;
        }*/
         
        
    }

    public static void main(String[] args) {
        GameLig4 game = new GameLig4();
        game.startGame();
    }
}

class Board {
    private int rows = 6;
    private int columns = 7;

    private String[][] boardArray;

    public Board() {
        boardArray = new String[rows][columns];
        cleanBoard();
    }

    public void cleanBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardArray[i][j] = null;
            }
        }
    }

    public boolean verifyInsert(int column) {
        return boardArray[0][column] == null;
    }

    public void insertPiece(int column, String pieceColor) {
        for (int i = rows - 1; i >= 0; i--) {
            if (boardArray[i][column] == null) {
                boardArray[i][column] = pieceColor;
                
                /* exibir a matriz para verificar se a posições estão corretas
                for (int x = 0; x < boardArray.length; x++) {
                    for (int y = 0; y < boardArray[x].length; y++) {
                        System.out.print(boardArray[x][y] + " ");
                    }
                    System.out.println();
                }
                System.out.println("------------");
                */
                
                break;
            }
        }
    }

    public boolean verifyWin() {
        // Lógica para verificar a vitória
        return false;
    }

    public boolean verifyDraw() {
        // Lógica para verificar empate
        return false;
    }
}

class Player {
    private String name;
    private String pieceColor;

    public Player(String name, String pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }

    public String getName() {
        return name;
    }

    public String getPieceColor() {
        return pieceColor;
    }
}
