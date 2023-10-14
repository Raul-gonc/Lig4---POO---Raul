package Game;

import Util.ValidateInput;

public interface IGame {
	public Board getBoard();
    public Player getPlayer();
    public void makeMove(int column) throws ValidateInput;
    public void insert(int column) throws ValidateInput;
    public void switchPlayer();
}
