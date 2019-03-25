import java.util.Scanner;

// this class is for executing the game

public class Play{
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		// The scanner is for reading user input
		Scanner scanner = new Scanner(System.in);
		int currentX = 0;  // the positon of current row
		int currentY = 0;  // the positon of current col

		/* use a while loop to continue the game until
		the player want to exit the game */
		while(true) {
			game.printBoard();
			
			// scan players input
			System.out.println(game.currentPlayer == game.X? "player X turn" : 
								"player O turn (To quit : press ctl + c)");
			System.out.println("Please Enter row number first (choose from 1 - 3)");
			currentX = scanner.nextInt();
			System.out.println("Please Enter col number (choose from 1 - 3)");
			currentY = scanner.nextInt();

			// if the players input is invalid, skip the following and ask again.
			if (game.playerMove(currentX, currentY) == false) continue;
			System.out.println("-----------------------------");
			game.printBoard();
			System.out.println("-----------------------------");

			// after player make a move, update the game status.
			int status = game.updateGame();
			if (status == game.PLAYING) continue;
			if (status == game.X_WON) System.out.println("Congratulation X won");
			if (status == game.O_WON) System.out.println("Congratulation O won");
			if (status == game.DRAW) System.out.println("There is a DRAW !!!!");

			// ask the player to continue the game or quit the game
			System.out.println("Do you want to continue  (y/n)?");
			int answer = scanner.next().charAt(0);
			// reset the game is the current game is end.
			if (answer == 'y' || answer == 'Y') game .resetGame();
			if (answer == 'n' || answer == 'N') game.quitGame();
		}
	}
}