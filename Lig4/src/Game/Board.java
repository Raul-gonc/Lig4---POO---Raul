package Game;
import java.util.Random;

public class Board implements IBoard{
	private final int rows = 6;
    private final int columns = 7;

    private String[][] boardArray;

    public Board() {
        boardArray = new String[rows][columns];
        cleanBoard();
    }
    
    public String[][] getBoardArray(){
    	return boardArray;
    }

    //Metodo para limpar o tabuleiro(voltar os valores para null)
    public void cleanBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardArray[i][j] = null;
            }
        }
    }

    //verifica se a coluna está cheia
    public boolean verifyInsert(int column) {
        return boardArray[0][column] == null;
    }
    
    //para debug
    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String piece = (boardArray[i][j] == null) ? " " : boardArray[i][j];
                System.out.print("| " + piece + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------------");
        for (int j = 0; j < columns; j++) {
            System.out.print("  " + j + " ");
        }
        System.out.println();
    }
    

    //Insere peça na coluna
    public void insertPiece(int column, String pieceColor) {
        for (int i = rows - 1; i >= 0; i--) {
            if (boardArray[i][column] == null) {
                boardArray[i][column] = pieceColor;
                break;
            }
        }
    }
    
    //Mudança de peças vizinhas no TurboMaluco
    public void turboMalucoChange(int column, double probability) {
    	int numRows = boardArray.length;
        int numColumns = boardArray[0].length;
        String pieceColor = new String();
        Random random = new Random();

        int row = -1;
        for (int i = 0; i < numRows; i++) {
            if (boardArray[i][column] != null) {
                row = i;
                pieceColor = boardArray[i][column];
                break;
            }
        }
        //Left
        if(random.nextDouble() < probability) {
        	if ((column - 1) >= 0) {
	            if (boardArray[row][column - 1] != null) {
	                boardArray[row][column - 1] = pieceColor;
	            }
	        }
        }
        //Right
        if(random.nextDouble() < probability) {
        	if ((column + 1)< numColumns) {
	            if (boardArray[row][column + 1] != null) {
	                boardArray[row][column + 1] = pieceColor;
	            } 
        	}
        }
        //Bottom
        if(random.nextDouble() < probability) {
        	if ((row + 1) < numRows) {
	            if (boardArray[row + 1][column] != null) {
	                boardArray[row + 1][column] = pieceColor;
	            } 
        	}
        }
        //Bottom Right
        if(random.nextDouble() < probability) {
        	if ((column + 1)< numColumns && (row + 1) < numRows) {
	            if (boardArray[row + 1][column + 1] != null) {
	                boardArray[row + 1][column + 1] = pieceColor;
	            } 
        	}
        }
      //Bottom Left
        if(random.nextDouble() < probability) {
        	if ((column - 1) >= 0 && (row + 1) < numRows) {
	            if (boardArray[row + 1][column - 1] != null) {
	                boardArray[row + 1][column - 1] = pieceColor;
	            } 
        	}
        }
      //Top Right
        if(random.nextDouble() < probability) {
        	if ((column + 1)< numColumns && (row - 1) >= 0) {
	            if (boardArray[row - 1][column + 1] != null) {
	                boardArray[row - 1][column + 1] = pieceColor;
	            } 
        	}
        }
      //Top Left
        if(random.nextDouble() < probability) {
        	if ((column - 1) >= 0 && (row - 1) >= 0) {
	            if (boardArray[row - 1][column - 1] != null) {
	                boardArray[row - 1][column - 1] = pieceColor;
	            } 
        	}
        }
        
    }
    
    //Mudança das peças vizinhas horizontal Turbo
    public void turboChange(int column) {
    	int numRows = boardArray.length;
        int numColumns = boardArray[0].length;
        String pieceColor = new String();

        int row = -1;
        for (int i = 0; i < numRows; i++) {
            if (boardArray[i][column] != null) {
                row = i;
                pieceColor = boardArray[i][column];
                break;
            }
        }

        if ((column - 1) >= 0) {
            if (boardArray[row][column - 1] != null) {
                boardArray[row][column - 1] = pieceColor;
            }
        }

        if ((column + 1)< numColumns) {
            if (boardArray[row][column + 1] != null) {
                boardArray[row][column + 1] = pieceColor;
            } 
    	}
    }
    
    //Calcular pontos para determinada cor
    public int calculatePoints(String letter) {
        int points = 0;

        // Verificar vitória horizontal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <= columns - 4; col++) {
                if (letter.equals(boardArray[row][col]) &&
                    letter.equals(boardArray[row][col + 1]) &&
                    letter.equals(boardArray[row][col + 2]) &&
                    letter.equals(boardArray[row][col + 3])) {
                	
                	//mudar as peças para uma letra diferente, para não contar novamente
                	boardArray[row][col]=" ";
                    boardArray[row][col + 1]=" ";
                    boardArray[row][col + 2]=" ";
                    boardArray[row][col + 3]=" ";
                    points++;
                }
            }
        }

        // Verificar vitória vertical
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row <= rows - 4; row++) {
                if (letter.equals(boardArray[row][col]) &&
                    letter.equals(boardArray[row + 1][col]) &&
                    letter.equals(boardArray[row + 2][col]) &&
                    letter.equals(boardArray[row + 3][col])) {
                	
                	//mudar as peças para uma letra diferente, para não contar novamente
                	boardArray[row][col]=" ";
                    boardArray[row + 1][col]=" ";
                    boardArray[row + 2][col]=" ";
                    boardArray[row + 3][col]=" ";
                    points++;
                }
            }
        }

        // Verificar vitória na diagonal (esquerda para a direita)
        for (int row = 0; row <= rows - 4; row++) {
            for (int col = 0; col <= columns - 4; col++) {
                if (letter.equals(boardArray[row][col]) &&
                    letter.equals(boardArray[row + 1][col + 1]) &&
                    letter.equals(boardArray[row + 2][col + 2]) &&
                    letter.equals(boardArray[row + 3][col + 3])) {
                	
                	//mudar as peças para uma letra diferente, para não contar novamente
                	boardArray[row][col]=" ";
                    boardArray[row + 1][col + 1]=" ";
                    boardArray[row + 2][col + 2]=" ";
                    boardArray[row + 3][col + 3]=" ";
                    points++;
                }
            }
        }

        // Verificar vitória na diagonal (direita para a esquerda)
        for (int row = 0; row <= rows - 4; row++) {
            for (int col = 3; col < columns; col++) {
                if (letter.equals(boardArray[row][col]) &&
                    letter.equals(boardArray[row + 1][col - 1]) &&
                    letter.equals(boardArray[row + 2][col - 2]) &&
                    letter.equals(boardArray[row + 3][col - 3])) {
                	
                	//mudar as peças para uma letra diferente, para não contar novamente
                	boardArray[row][col]=" ";
                    boardArray[row + 1][col - 1]=" ";
                    boardArray[row + 2][col - 2]=" ";
                    boardArray[row + 3][col - 3]=" ";
                    points++;
                }
            }
        }

        return points;
    }
    
    

    // Verificar vitória
    public boolean verifyWin() {
        // Verificar vitória horizontal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <= columns - 4; col++) {
                String piece = boardArray[row][col];
                if (piece != null &&
                    piece.equals(boardArray[row][col + 1]) &&
                    piece.equals(boardArray[row][col + 2]) &&
                    piece.equals(boardArray[row][col + 3])) {
                    return true;
                }
            }
        }

        // Verificar vitória vertical
        for (int col = 0; col < columns; col++) {
            for (int row = 0; row <= rows - 4; row++) {
                String piece = boardArray[row][col];
                if (piece != null &&
                    piece.equals(boardArray[row + 1][col]) &&
                    piece.equals(boardArray[row + 2][col]) &&
                    piece.equals(boardArray[row + 3][col])) {
                    return true;
                }
            }
        }

        // Verificar vitória na diagonal (esquerda para a direita)
        for (int row = 0; row <= rows - 4; row++) {
            for (int col = 0; col <= columns - 4; col++) {
                String piece = boardArray[row][col];
                if (piece != null &&
                    piece.equals(boardArray[row + 1][col + 1]) &&
                    piece.equals(boardArray[row + 2][col + 2]) &&
                    piece.equals(boardArray[row + 3][col + 3])) {
                    return true;
                }
            }
        }

        // Verificar vitória na diagonal (direita para a esquerda)
        for (int row = 0; row <= rows - 4; row++) {
            for (int col = 3; col < columns; col++) {
                String piece = boardArray[row][col];
                if (piece != null &&
                    piece.equals(boardArray[row + 1][col - 1]) &&
                    piece.equals(boardArray[row + 2][col - 2]) &&
                    piece.equals(boardArray[row + 3][col - 3])) {
                    return true;
                }
            }
        }

        return false; // Nenhuma vitória encontrada
    }


    // Verificar empate
    public boolean verifyDraw() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (boardArray[row][col] == null) {
                    return false;
                }
            }
        }
        return !verifyWin();
    }
    
    // Verificar Final do game(Independente do Win)
    public boolean verifyEnd() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (boardArray[row][col] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}