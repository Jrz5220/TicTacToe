import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
	
	private String xPos, oPos;
	private LinkedList<Integer> xPositions = new LinkedList<>();
	private LinkedList<Integer> oPositions = new LinkedList<>();
	private char[][] board = {	{' ', '|', ' ', '|', ' '},
								{' ', '|', ' ', '|', ' '},
								{' ', '|', ' ', '|', ' '}	};

	public void beginGame() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Positions on the game board: \n");
		displayBoardPositions();
		System.out.println("\nBegin new game: ");
		displayGameBoard();
		while(true) {
			xPlayerTurn(scan);
			if(isGameFinished())
				break;
			oPlayerTurn(scan);
			if(isGameFinished())
				break;
		}
		scan.close();
	}
	
	private boolean isGameFinished() {
		if(winnerFound(xPositions))
			System.out.println("Player X wins!");
		else if(winnerFound(oPositions))
			System.out.println("Player O wins!");
		else if(xPositions.size() + oPositions.size() >= 9)
			System.out.println("Game ends in a draw.");
		else
			return false;
		
		return true;
	}
	
	private void xPlayerTurn(Scanner xScan) {
		while(true) {
			System.out.println("X: Enter a position 1-9");
			xPos = xScan.nextLine().trim();
			if(isValidMove(xPos)) {
				placeTokenOnBoard('X', xPos);
				break;
			}
		}
		xPositions.add(Integer.parseInt(xPos));
		displayGameBoard();
	}

	private void oPlayerTurn(Scanner oScan) {
		while(true) {
			System.out.println("O: Enter a position 1-9");
			oPos = oScan.nextLine().trim();
			if(isValidMove(oPos)) {
				placeTokenOnBoard('O', oPos);
				break;
			}
		}
		oPositions.add(Integer.parseInt(oPos));
		displayGameBoard();
	}
	
	private boolean isValidMove(String pos) {
		switch(pos) {
		case "1":
			if(board[0][0] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		case "2":
			if(board[0][2] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		case "3":
			if(board[0][4] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		case "4":
			if(board[1][0] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		case "5":
			if(board[1][2] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		case "6":
			if(board[1][4] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		case "7":
			if(board[2][0] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		case "8":
			if(board[2][2] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		case "9":
			if(board[2][4] == ' ')
				return true;
			else
				System.out.println("Position " + pos + " is already taken.");
			return false;
		default:
			System.out.println("You did not enter a valid number.");
			return false;
		}
	}

	private void placeTokenOnBoard(char token, String pos) {
		switch(pos) {
		case "1":
			board[0][0] = token;
			break;
		case "2":
			board[0][2] = token;
			break;
		case "3":
			board[0][4] = token;
			break;
		case "4":
			board[1][0] = token;
			break;
		case "5":
			board[1][2] = token;
			break;
		case "6":
			board[1][4] = token;
			break;
		case "7":
			board[2][0] = token;
			break;
		case "8":
			board[2][2] = token;
			break;
		case "9":
			board[2][4] = token;
			break;
		default:
			System.out.println("You did not enter a valid number");
			break;
		}
	}
	
	private boolean winnerFound(List<Integer> positions) {
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> midRow = Arrays.asList(4, 5, 6);
		List<Integer> botRow = Arrays.asList(7, 8, 9);
		List<Integer> cross1 = Arrays.asList(1, 5, 9);
		List<Integer> cross2 = Arrays.asList(3, 5, 7);
		List<Integer> firstCol = Arrays.asList(1, 4, 7);
		List<Integer> secCol = Arrays.asList(2, 5, 8);
		List<Integer> thirdCol = Arrays.asList(3, 6, 9);
		
		List<List<Integer>> winningSets = new LinkedList<>();
		winningSets.add(topRow);
		winningSets.add(midRow);
		winningSets.add(botRow);
		winningSets.add(cross1);
		winningSets.add(cross2);
		winningSets.add(firstCol);
		winningSets.add(secCol);
		winningSets.add(thirdCol);
		
		for(List<Integer> winningNums : winningSets) {
			if(positions.containsAll(winningNums))
				return true;
		}
		
		return false;
	}

	private void displayBoardPositions() {
		char[][] boardPos = {	{'1', '|', '2', '|', '3'},
								{'4', '|', '5', '|', '6'},
								{'7', '|', '8', '|', '9'}	};
		for(char[] row : boardPos) {
			for(char pos : row) {
				System.out.print(pos);
			}
			System.out.println("\n-----");
		}
	}

	private void displayGameBoard() {
		for(char[] row : board) {
			for(char pos : row) {
				System.out.print(pos);
			}
			System.out.println("\n-----");
		}
	}

}
