import ElementsOfTheChess.Knight;
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
            board.displayTheSquare();

            System.out.print("\nPlayer, enter your move (e.g., 'e2 e4'): ");
            String move = scanner.nextLine().trim();

            if (move.isEmpty()) {
                continue;
            }

            String[] moveParts = move.split(" ");
            if (moveParts.length == 2) {
                String startCoordinate = moveParts[0];
                String endCoordinate = moveParts[1];

                if (isValidCoordinate(startCoordinate) && isValidCoordinate(endCoordinate)) {
                    int startY = startCoordinate.charAt(0) - 'a';
                    int startX = Integer.parseInt(startCoordinate.substring(1)) - 1;

                    int endY = endCoordinate.charAt(0) - 'a';
                    int endX = Integer.parseInt(endCoordinate.substring(1)) - 1;

                    Piece piece = board.getPieceAt(startX, startY);
                    if (piece != null) {
                        String pieceName = piece.getName();

                        if ("knight".equalsIgnoreCase(pieceName) &&
                                Knight.isValidKnightMove(piece, endX, endY)) {
                            rules.makeMove(currentPlayer, startX, startY, endX, endY, pieceName, piece);
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
                        } else if (rules.isValidMove(currentPlayer, startX, startY, endX, endY, pieceName, piece) &&
                                rules.isPathClear(piece, endX, endY, board.getSquares())) {
                            rules.makeMove(currentPlayer, startX, startY, endX, endY, pieceName, piece);
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
                } else {
                    System.out.println("Invalid input format. Please enter valid coordinates.");
                }
            } else {
                System.out.println("Invalid input format. Please enter your move in the format 'start end'.");
            }
        }

        scanner.close();
    }

    private static boolean isValidCoordinate(String coordinate) {
        return coordinate.matches("[a-h][1-8]");
    }
}