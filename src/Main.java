import java.util.Scanner;

import ElementsOfTheChess.Piece;
import Players.Player;
import Rules.RulesForTheGame;
import chessBoard.Board;

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
                System.out.print("\n player, enter your move (e.g., 'e2 e4'): ");
                String move = scanner.nextLine();

                String[] moveParts = move.split(" ");
                if (moveParts.length == 2) {
                    String startCoordinate = moveParts[0];
                    String endCoordinate = moveParts[1];


                    char castX = startCoordinate.charAt(0);
                    int startX =castX -'a';

                    int startY = Integer.parseInt(startCoordinate.substring(1));
                    startY = 8 - startY ;

                    char Xcast = endCoordinate.charAt(0);
                    int endX = Xcast - 'a';

                    int endY = Integer.parseInt(endCoordinate.substring(1));
                    Piece piece =board.getPieceAt(startX,startY);
                    String pieceName = piece.getName();
                     System.out.println(piece);


                    if (!pieceName.isEmpty() && rules.isValidMove(currentPlayer, startX, startY, endX, endY, pieceName, piece)) {
                        // Custom check for checkmate (replace this logic)
                        boolean isCheckmate = false; // Replace with your custom check

                        // Custom check for stalemate (replace this logic)
                        boolean isStalemate = false; // Replace with your custom check

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

                    board.displayTheSquare();
                }
        }

        scanner.close();
    }
}