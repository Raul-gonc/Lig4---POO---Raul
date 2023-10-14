package Game;

import Util.ValidateInput;

public class GameNormal extends Game{
	public GameNormal(Player player01, Player player02) {
	       super(player01, player02);
	    }
		
	//Implementa makeMove para o modo normal
	public void makeMove(int column) throws ValidateInput {
        insert(column);
        
        /*if(super.getBoard().verifyWin()) {
        	super.getBoard().printBoard();
        	return super.getPlayer().getName();
        }*/
        //switchPlayer();
        //super.getBoard().printBoard();	
        //return null;
    }
}