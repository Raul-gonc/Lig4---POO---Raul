package Game;

import Util.ValidateInput;

public class GameTurboMaluco extends Game{
		private double dificult;
		public GameTurboMaluco(Player player01, Player player02, double dificult) {
	       super(player01, player02);
	       if(dificult == 1) {
	    	   this.dificult = 0.25;
	       }else if(dificult == 2) {
	    	   this.dificult = 0.5;
	       } else {
	    	   this.dificult = 0.75;
	       }
	    }
		
		//Implementa makeMove para TurboMaluco
		public void makeMove(int column) throws ValidateInput {
			super.insert(column);
	    	super.getBoard().turboMalucoChange(column, dificult);
	    	/*
	        if(super.getBoard().verifyWin()) {
	        	super.getBoard().printBoard();
	        	return super.getPlayer().getName();
	        }
	        //super.switchPlayer();
	        super.getBoard().printBoard();	
	        return null;*/
	    }
}