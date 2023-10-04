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
//                    System.out.println(startCoordinate);
//                    System.out.println(endCoordinate);

                    char castX = startCoordinate.charAt(0);
                    int startX =castX -'a';
                    System.out.println(startX);
                    int startY = Integer.parseInt(startCoordinate.substring(1));
                    System.out.println(startY);
                    char Xcast = endCoordinate.charAt(0);
                    int endX = castX - 'a';
                    System.out.println(endX);
                    int endY = Integer.parseInt(endCoordinate.substring(1));
                    System.out.println(endY);
                    String piece = board.getPieceAt(startX, startY);
                    System.out.println(piece);



                    if (rules.isValidMove(currentPlayer, startX, startY, endX, endY, piece)) {
                        if (rules.isCheckmate(currentPlayer) || rules.isStalemate(currentPlayer)) {
                            gameOver = true;
                            System.out.println("Game Over!");
                        } else {
                            currentPlayer = (currentPlayer == playerWhite) ? playerBlack : playerWhite;
                        }
                    } else {
                        System.out.println("Invalid move. Please try again.");
                    }
                    board.displayTheSquare();
                } else {
                    System.out.println("Invalid move format. Please enter in the format 'e2 e4'.");
                }
        }

        scanner.close();
    }
}