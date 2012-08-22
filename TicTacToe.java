/** Command Line 2-Player Tic-Tac-Toe */

import java.util.Scanner;

public class TicTacToe {
    
    public static void main(String[] args) {
        playGame(newGame());
    }
    
    public static void playGame(char[][] gameBoard) {
        System.out.println("\n*** Welcome to Tic-Tac-Toe ***");
        while (true) {
            printGame(gameBoard);
            move('X', gameBoard);
            if (gameOver('X', gameBoard)) break;
            printGame(gameBoard);
            move('O', gameBoard);
            if (gameOver('O', gameBoard)) break;
        }
    }
    
    public static boolean gameOver(char player, char[][] gameBoard) {
        if (threeInRow(gameBoard) == player) {
            printGame(gameBoard);
            System.out.println("Player " + player + " wins!");
            return true;
        }
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j] == ' ') return false;
            }
        }
        System.out.println("Tie game!");
        return true;
    }

    public static void move(char player, char[][] gameBoard) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a row (1-3) for player " + player + ": ");
            int row = input.nextInt();
            System.out.print("\nEnter a column (1-3) for player " + player + ": ");
            int column = input.nextInt();
            if (gameBoard[row - 1][column - 1] != ' ') {
                System.out.println("\nPlease enter a valid square");
                continue;
            }
            else {
                gameBoard[row - 1][column - 1] = player;
            }
            break;
        }
    }

    public static char threeInRow(char[][] gameBoard) {
        int xSum = 0;
        int oSum = 0;
        /* Check horizontally */
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j] == 'X') xSum++;
                if (gameBoard[i][j] == 'O') oSum++;
                if (xSum == 3) return 'X';
                if (oSum == 3) return 'O';
            }
            xSum = 0;
            oSum = 0;
        }
        /* Check vertically */
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[j][i] == 'X') xSum++;
                if (gameBoard[j][i] == 'O') oSum++;
                if (xSum == 3) return 'X';
                if (oSum == 3) return 'O';
            }
            xSum = 0;
            oSum = 0;
        }
        /* Check forward diagonal */
        int k = 2;
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][k] == 'X') xSum++;
            if (gameBoard[i][k] == 'O') oSum++;
            k--;
        }
        if (xSum == 3) return 'X';
        if (oSum == 3) return 'O';
        xSum = 0;
        oSum = 0;
        /* Check backwards diagonal */
        for (int i = gameBoard.length - 1; i >= 0; i--) {
            if (gameBoard[i][i] == 'X') xSum++;
            if (gameBoard[i][i] == 'O') oSum++;
        }
        if (xSum == 3) return 'X';
        if (oSum == 3) return 'O';
        return ' ';
    }

    public static char[][] newGame() {
        char[][] gameBoard = new char[3][3];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = ' ';
            }
        }
        return gameBoard;
    }
    
    public static void printGame(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.println("\n-------------");
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print("| " + gameBoard[i][j] + " ");
            }
            System.out.print("|");
        }
        System.out.println("\n-------------");
    }

}
