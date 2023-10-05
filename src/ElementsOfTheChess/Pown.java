package ElementsOfTheChess;

import chessBoard.Square;

import static Rules.RulesForTheGame.isValidCoordinate;
import static chessBoard.Board.squares;

public class Pown extends Piece {
    public Pown(String color) throws IllegalAccessException {
        super(color);
    }

    public static boolean isValidPownMove(Piece piece, int endX, int endY) {
        //        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
        //            return false;
        //        }

        int startX = piece.getX();
        int startY = piece.getY();

        Square startSquare = squares[startX][startY];
        Piece startPiece = startSquare.getPiece();
//        System.out.println("here"+piece);
        if (!startPiece.getName().equalsIgnoreCase("pown")) {
            return false;
        }

        String pawnColor = startPiece.getColor();

        int rowDiff = endX - startX;
        int colDiff = Math.abs(endY - startY);

        if (pawnColor.equalsIgnoreCase("white")) {
            if (rowDiff == -1 && colDiff == 0) {
                return true;
            }
        } else if (pawnColor.equalsIgnoreCase("black")) {
            if (rowDiff == 1 && colDiff == 0) {
                return true;
            }
        }
        if (pawnColor.equalsIgnoreCase("white") && startX == 6) {
            if (rowDiff == -2 && colDiff == 0) {
                return true;
            }
        } else if (pawnColor.equalsIgnoreCase("black") && startX == 1) {
            if (rowDiff == 2 && colDiff == 0) {
                return true;
            }
        }

        if (colDiff == 1 && (pawnColor.equalsIgnoreCase("white") && rowDiff == -1 || pawnColor.equalsIgnoreCase("black") && rowDiff == 1)) {
            return true;
        }
        return false;
    }

    public void promotePawn(Pown pown, Piece newPiece) {

    }
}