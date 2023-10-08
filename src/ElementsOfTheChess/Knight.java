package ElementsOfTheChess;

import static Rules.RulesForTheGame.isValidCoordinate;

public class Knight extends Piece {


    public Knight(String color) throws IllegalAccessException {
        super(color);
    }

    public static boolean isValidKnightMove(Piece piece, int endX, int endY) {
        if (!isValidCoordinate(endX, endY)) {
            return false;
        }

        int startX = piece.getX();
        int startY = piece.getY();

        int rowDiff = Math.abs(endX - startX);
        int colDiff = Math.abs(endY - startY);

        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}