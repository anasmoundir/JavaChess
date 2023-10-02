package ElementsOfTheChess;

import static Rules.RulesForTheGame.isValidCoordinate;

public class Pown extends Piece{

    public  Pown(String color) throws IllegalAccessException {
        super(color);
    }
    public static boolean isValidPownMove(Piece piece, int startX, int startY, int endX, int endY) {
        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
            return false;
        }

        if (!piece.getName().equalsIgnoreCase("pawn")) {
            return false;
        }

        String pawnColor = piece.getColor();

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

    public void promotePawn(Pown pown,Piece newPiece)
    {

    }

}
