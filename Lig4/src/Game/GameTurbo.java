package Game;

import Util.ValidateInput;

public class GameTurbo extends Game{
	public GameTurbo(Player player01, Player player02) {
       super(player01, player02);
    }
	
	//Implementa makeMove para o modo Turbo
	public void makeMove(int column) throws ValidateInput {
		super.insert(column);
    	super.getBoard().turboChange(column);
    	/*
        if(super.getBoard().verifyWin()) {
        	super.getBoard().printBoard();
        	return super.getPlayer().getName();
        }
        //super.switchPlayer();
        super.getBoard().printBoard();	
        return null;
        */
    }
}
