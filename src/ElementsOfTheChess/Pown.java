package ElementsOfTheChess;

import chessBoard.Square;

import static Rules.RulesForTheGame.isValidCoordinate;
import static chessBoard.Board.squares;

public class Pown extends Piece {
    public Pown(String color) throws IllegalAccessException {
        super(color);
    }

    public static boolean isValidPownMove(Piece piece, int endX, int endY) {
        if (!isValidCoordinate(endX, endY)) {
            return false;
        }

        int  startY= piece.getX();
        int startX = piece.getY();

        Square startSquare = squares[startY][startX];
        Piece startPiece = startSquare.getPiece();

        if (!startPiece.getName().equalsIgnoreCase("pown")) {
            return false;
        }

        String pawnColor = startPiece.getColor();

        int rowDiff = endX - startX;
        int colDiff = Math.abs(endY - startY);

        if (pawnColor.equalsIgnoreCase("white")) {
            if (rowDiff == 0 && colDiff == 1 || colDiff == 2) {
                return true;
            }
            if (startX == 1 && rowDiff == 2 && colDiff == 0) {
                return true;
            }
            if (rowDiff == 1 && colDiff == 1) {
                return true;
            }
        } else if (pawnColor.equalsIgnoreCase("black")) {
            if (rowDiff == -1 && colDiff == 0) {
                return true;
            }
            if (startX == 6 && rowDiff == -2 && colDiff == 0) {
                return true;
            }
            if (rowDiff == -1 && colDiff == 1) {
                return true;  // Pawn captures diagonally
            }
        }

        return false;
    }
    public void promotePawn(Pown pown, Piece newPiece) {
    }
}