package ElementsOfTheChess;

import Rules.RulesForTheGame;
import chessBoard.Square;

import static Rules.RulesForTheGame.isValidCoordinate;
import static chessBoard.Board.getSquares;

public class Rook extends Piece{
  public Rook(String color) throws IllegalAccessException {
      super(color);
  }
    public static boolean isValidRookMove(Piece piece, int startX, int startY, int endX, int endY)
    {
        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
            return false;
        }
        Square[][] squares = getSquares();
        int rowDiff = Math.abs(endX - startX);
        int colDiff = Math.abs(endY - startY);

        if (rowDiff == 0 && colDiff > 0) {
            return RulesForTheGame.isVerticalPathClear(startX, startY, endX, endY);
        } else if (rowDiff > 0 && colDiff == 0) {
            return RulesForTheGame.isHorizontalPathClear(startX, startY, endX, endY);
        }
        return false;
    }
}
