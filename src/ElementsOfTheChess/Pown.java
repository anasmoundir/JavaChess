package ElementsOfTheChess;

import chessBoard.Square;

import static Rules.RulesForTheGame.isValidCoordinate;
import static chessBoard.Board.squares;

public class Pown extends Piece {
    public Pown(String color) throws IllegalAccessException {
        super(color);
    }

    public static boolean isValidPownMove(Piece piece, int endX, int endY) {

        int  startX  = piece.getX();
        int  startY= piece.getY();

    //    Square startSquare = squares[startX][startY];



        if (!piece.getName().equalsIgnoreCase("pown")) {
            return false;
        }

        String pawnColor = piece.getColor();

        int rowDiff = endX - startX;
        int colDiff = Math.abs(endY - startY);
        int colDiffRev = endY - startY;

        if (pawnColor.equalsIgnoreCase("black")) {
            if (rowDiff == -1 && colDiff == 0) {
                return true;
            }
            if (rowDiff == -2 && colDiff == 0 && startX == 6) {
                return true;
            }
            if (rowDiff == -1 && colDiff == 1) {
                return true;
            }
            if (rowDiff == -1 && colDiffRev == -1) {
                return true;
            }
        } else if (pawnColor.equalsIgnoreCase("white")) {
            if (rowDiff == 1 && colDiff == 0) {
                return true;
            }
            if (rowDiff == 2 && colDiff == 0 && startX == 1) {
                return true;
            }
            if (rowDiff == 1 && colDiff == 1) {
                return true;
            }
            if (rowDiff == 0 && colDiffRev == -1) {
                return true;
            }
        }
        return false;
    }
    public void promotePawn(Pown pown, Piece newPiece) {
    }
}