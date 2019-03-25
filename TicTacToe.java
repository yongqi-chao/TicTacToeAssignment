// Built a Tic Tac Toe Game

public class TicTacToe{
	// X stands for player x ; O stands for player o;
	// Empty stands for empty slot.
	public static final int X = 1;
	public static final int O = -1;
	public static final int EMPTY = 0;

	public static final int ROW = 3;
	public static final int COL = 3;

	/* game has 4 different status, each status indicate
	current game staus*/
	public static final int PLAYING = 0;
	public static final int DRAW = 1;
	public static final int X_WON = 2;
	public static final int O_WON = 3;

	// default board has 3 by 3 grid
	// default player will start with X
	public int[][] board = new int[ROW][COL];
	public int currentPlayer = X;

	/* ======================================================================== */
	// The following methods is for start / reset / quit the game .
	public void initGame() {
		board = new int[ROW][COL];
		currentPlayer = X;
	}

	public void resetGame() {
		initGame();
	}

    public void quitGame() {
		System.exit(0);
	}
	/* ======================================================================== */
	// The following methods is the game main logic

	// when a player make a move, update the game board
	public boolean playerMove(int x, int y) {
		if (x < 1 || x > ROW || y < 1 || y > COL) {
			System.out.println("\nInvalid input, your input is out of the range");
			return false;
		}
		if (board[x-1][y-1] != EMPTY) {
			System.out.println("\nSorry, the current cell is occupied. Please choose another");
			return false;
		}

		board[x-1][y-1] = currentPlayer; // place the player's mark on the board 
		currentPlayer = -currentPlayer; //switch player
		return true;
	}

	// check the board  if there is a Draw situation.
	public boolean isDraw() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (board[i][j] == EMPTY) return false;
			}
		}
		return true;
	}

	// check whether the current player is the winner
	public boolean isWin(int player) {
		for (int i = 0; i < ROW; i++) {
			if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
			(board[0][i] == player && board[1][i] == player && board[2][i] == player) ||
			(board[1][1] == player && board[2][2] == player && board[0][0] == player) ||
			(board[0][2] == player && board[1][1] == player && board[2][0] == player)) return true;
		}
		return false;
	}

	/* after player make a move, update the game status
	 in order to find a winner */
	public int updateGame() {
		if (isWin(X)) return X_WON;
		if (isWin(O)) return O_WON;
		if (isDraw()) return DRAW;

		return PLAYING;
	}

	/* ======================================================================== */
    // the following functions is for printing the board on the screen.
    
	// print the whole board on the screen
	public void printBoard() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				printCell(board[i][j]);
				if (j != ROW - 1) System.out.print("|");;
			}

			System.out.print("\n");
		}
	}

	// helper function for printing a single cell on the screen
	public void printCell(int player) {
		switch (player) {
			case EMPTY: 
				System.out.print("-");
				break;
			case X :
				System.out.print("X");
				break;
			case O :
				System.out.print("O");
				break;	
		}
	}
}

