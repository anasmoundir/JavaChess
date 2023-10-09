package ElementsOfTheChess;

import Players.Player;
import chessBoard.Square;

import static Rules.RulesForTheGame.board;
import static Rules.RulesForTheGame.isValidCoordinate;
import static chessBoard.Board.getSquares;

public class Bishop extends Piece{


    public Bishop(String color) throws IllegalAccessException {
        super( color);
    }
    public static boolean isValidBishopMove(Piece piece, int startX, int startY, int endX, int endY)
    {
        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
            return false;
        }
        int rowDiff = Math.abs(endX - startX);
        int colDiff = Math.abs(endY - startY);

        if (rowDiff == colDiff) {
            int rowStep = (endX > startX) ? 1 : -1;
            int colStep = (endY > startY) ? 1 : -1;

            for (int i = 1; i < rowDiff; i++) {
                int nextX = startX + i * rowStep;
                int nextY = startY + i * colStep;
                Square[][] squares = getSquares();
                if (squares[nextX][nextY].getPiece() != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
