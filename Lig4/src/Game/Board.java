package Game;
public class Board {
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