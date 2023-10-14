package Game;
import Util.ValidateInput;

public abstract class Game implements IGame{
	private Board board = new Board();;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player01, Player player02) {
        player1 = player01;
        player2 = player02;
        currentPlayer = player1;
    }
    
    public Board getBoard() {
    	return board;
    }
    
    public Player getPlayer() {
    	return currentPlayer;
    }
    
    //Insere a peça na coluna
    public void insert(int column) throws ValidateInput {
    	if(column >= 7) {
    		throw new ValidateInput("Coluna não existente.");
        }
    	if(board.verifyInsert(column)) {
        	board.insertPiece(column, currentPlayer.getPieceColor());
        } else {
        	throw new ValidateInput("Coluna Cheia.");
        }
    }
    
    //Alterna entre os players
    public void switchPlayer() {
    	if(currentPlayer == player1) {
    		currentPlayer =player2;
    	}else {
    		currentPlayer =player1;
    	}
    }
    
    //classe abstrata que faz a jogada
    public abstract void makeMove(int column) throws ValidateInput;
}
