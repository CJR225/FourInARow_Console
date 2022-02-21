import java.util.Scanner;

/**
 * Four in a row: Two-player console, non-graphics
 * 
 * @author relkharboutly
 * @date 1/22/2020
 */
public class FIRConsole {

	public static Scanner in = new Scanner(System.in); // the input Scanner

	public static FourInARow FIRboard = new FourInARow();

	public static int Player;

	/** The entry main method (the program starts here) */
	public static void main(String[] args) {

		int currentState = FourInARow.PLAYING;
		String userInput = "";
		String userWin = "";
		// game loop
		do {

			FIRboard.printBoard();

			System.out.println("What is your move? | 0-35 |");
			Scanner Input = new Scanner(System.in);
			userInput = Input.nextLine();
			Integer playerMove = Integer.valueOf(userInput);
			while (playerMove > 35 || playerMove < 0) {
				System.out.println("Move is out of bounds, please enter a number from | 0-35 |");
				userInput = Input.nextLine();
				playerMove = Integer.valueOf(userInput);
			}

			FIRboard.setMove(2, playerMove);
			FIRboard.setMove(1, FIRboard.getComputerMove());

			if (FIRboard.checkForWinner() == 2) {
				FIRboard.printBoard();
				currentState = FourInARow.RED_WON;

				System.out.println("Congratulations RED has won!");
				System.out.println();
				System.out.println("Would you like to play again? Y | N");
				userInput = Input.nextLine();
				if (userInput.toUpperCase().equals("Y")) {
					FIRboard.clearBoard();

					currentState = FourInARow.PLAYING;
				} else if (userInput.toUpperCase().equals("N")) {

					System.out.println("Thanks for playing!");
				}

			} else if (FIRboard.checkForWinner() == 3) {
				FIRboard.printBoard();
				currentState = FourInARow.BLUE_WON;

				System.out.println("Congratulations the COMPUTER HAS BEAT YOU!");
				System.out.println();
				System.out.println("Would you like to play again? Y | N");
				userInput = Input.nextLine();
				if (userInput.toUpperCase().equals("Y")) {
					FIRboard.clearBoard();

					currentState = FourInARow.PLAYING;
				} else if (userInput.toUpperCase().equals("N")) {

					System.out.println("Thanks for playing!");
				}

			} else if (FIRboard.checkForWinner() == 1) {
				FIRboard.printBoard();
				currentState = FourInARow.TIE;

				System.out.println("Game is a Tie");
				System.out.println();
				System.out.println("Would you like to play again? Y | N");
				userInput = Input.nextLine();
				if (userInput.toUpperCase().equals("Y")) {
					FIRboard.clearBoard();

					currentState = FourInARow.PLAYING;
				} else if (userInput.toUpperCase().equals("N")) {

					System.out.println("Thanks for playing!");
				}

			} else {
				currentState = FourInARow.PLAYING;
			}

			/**
			 * TODO implement the game loop 1- accept user move 2- call getComputerMove 3-
			 * Check for winner 4- Print game end messages in case of Win , Lose or Tie !
			 */

		} while ((currentState == IGame.PLAYING) && (!userInput.equals("N"))); // repeat if not game-over
	}

}