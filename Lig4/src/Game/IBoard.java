package Game;

public interface IBoard {
	public String[][] getBoardArray();
	
    public void cleanBoard();
    
    public boolean verifyInsert(int column);
    
    public void printBoard();
    
    public void insertPiece(int column, String pieceColor);
    
    public void turboMalucoChange(int column, double probability);
    
    public void turboChange(int column);
    
    public boolean verifyWin();
    
    public boolean verifyDraw();
    
}
