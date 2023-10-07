import ElementsOfTheChess.Piece;
import Players.Player;
import Rules.RulesForTheGame;
import chessBoard.Board;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        boolean gameOver = false;
        Player playerBlack = new Player(Player.CouleurPlayer.black);
        Player playerWhite = new Player(Player.CouleurPlayer.white);

        Player currentPlayer = playerWhite;

        Board board = new Board();
        RulesForTheGame rules = new RulesForTheGame(board);
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.print("\nPlayer, enter your move (e.g., 'e2 e4'): ");
            String move = scanner.nextLine();

            String[] moveParts = move.split(" ");
            if (moveParts.length == 2) {
                String startCoordinate = moveParts[0];
                String endCoordinate = moveParts[1];

                int startY = startCoordinate.charAt(0) - 'a';
                int startX = Integer.parseInt(startCoordinate.substring(1) ) - 1;

                int  endY = endCoordinate.charAt(0) - 'a';
                int  endX= Integer.parseInt(endCoordinate.substring(1)) - 1;
                System.out.println("StartX: " + startX);
                System.out.println("StartY: " + startY);
                System.out.println("EndX: " + endX);
                System.out.println("EndY: " + endY);
                Piece piece = board.getPieceAt(startX, startY);
                if (piece != null) {
                    String pieceName = piece.getName();
                    System.out.println("Piece: " + pieceName);
                    System.out.println("StartX: " + startX);
                    System.out.println("StartY: " + startY);
                    System.out.println("EndX: " + endX);
                    System.out.println("EndY: " + endY);

                    rules.makeMove(currentPlayer, startX, startY, endX, endY, pieceName, piece);
                    board.displayTheSquare();
                    if (!pieceName.isEmpty() && rules.isValidMove(currentPlayer, startX, startY, endX, endY, pieceName, piece)) {
                        boolean isCheckmate = false;
                        boolean isStalemate = false;

                        if (isCheckmate) {
                            gameOver = true;
                            System.out.println("Checkmate! Game Over!");
                        } else if (isStalemate) {
                            gameOver = true;
                            System.out.println("Stalemate! Game Over!");
                        } else {
                            currentPlayer = (currentPlayer == playerWhite) ? playerBlack : playerWhite;
                        }
                    } else {
                        System.out.println("Invalid move. Please try again.");
                    }
                } else {
                    System.out.println("This square is empty. You can't move in it.");
                }

            }

        }

        scanner.close();
    }
}