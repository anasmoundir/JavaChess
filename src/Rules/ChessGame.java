package Rules;

import chessBoard.Board;
import chessBoard.Square;
import ElementsOfTheChess.Piece;
import Players.Player;

import java.util.Scanner;

import static Rules.RulesForTheGame.isValidCoordinate;

public class ChessGame {

    public static void startingGamePlayer() {
        Board board = null;
        try {
            board = new Board();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        Player whitePlayer = new Player(Player.CouleurPlayer.white);
        Player blackPlayer = new Player(Player.CouleurPlayer.black);
        Player currentPlayer = whitePlayer;

        while (!isGameOver(board, currentPlayer)) {
            System.out.print("Enter your move (e.g., 'e2 e4'): ");
            String input = scanner.nextLine();
            String[] move = input.split(" ");
            String sourceSquare = move[0];
            String destinationSquare = move[1];

            String pieceType = determinePieceType(board, sourceSquare);

            int startX = parseX(sourceSquare);
            int startY = parseY(sourceSquare);
            int endX = parseX(destinationSquare);
            int endY = parseY(destinationSquare);

            if (RulesForTheGame.isValidMove(currentPlayer, startX, startY, endX, endY, pieceType)) {
                if (makeMove(board, startX, startY, endX, endY)) {
                    currentPlayer.toggleTurn(); // Toggle the player's turn
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }
    private static boolean isGameOver(Board board, Player currentPlayer) {

        return false;
    }

    private static String determinePieceType(Board board, String sourceSquare) {
        // Implement logic to determine the pieceType based on the sourceSquare
        Square[][] squares = board.getSquares();
        int x = parseX(sourceSquare);
        int y = parseY(sourceSquare);
        Piece piece = squares[x][y].getPiece();

        if (piece != null) {
            return piece.getName().toLowerCase();
        } else {
            return "";
        }
    }

    private static int parseX(String square) {
        return square.charAt(0) - 'a';
    }

    private static int parseY(String square) {
        return Character.getNumericValue(square.charAt(1)) - 1;
    }

    private static boolean makeMove(Board board, int startX, int startY, int endX, int endY) {
        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
            return false;
        }

        Square[][] squares = board.getSquares();
        Piece piece = squares[startX][startY].getPiece();

        if (piece == null) {
            return false;
        }


        String pieceType = piece.getName().toLowerCase();
        if (!RulesForTheGame.isValidMove(board, startX, startY, endX, endY, pieceType)) {
            return false;
        }

        Piece destinationPiece = squares[endX][endY].getPiece();
        if (destinationPiece != null && destinationPiece.getColor() == piece.getColor()) {
            return false;
        }



}