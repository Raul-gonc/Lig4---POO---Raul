package Game;
public class Game {
    
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game() {
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
        Game game = new Game();
        game.startGame();
    }
}
