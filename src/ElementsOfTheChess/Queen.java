package ElementsOfTheChess;

import Players.Player;

import static Rules.RulesForTheGame.board;

public class Queen extends Piece{
    public  Queen(String color) throws IllegalAccessException {
        super(color);
    }
    public static boolean isValidQueenMove(Piece piece, int endX, int endY) {
        int  startX  = piece.getX();
        int  startY= piece.getY();
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        return deltaX == 0 || deltaY == 0 || deltaX == deltaY;
    }
    public boolean captureWithQueen(Player player, int startX, int startY, int endX, int endY, Piece piece) {
        if (!piece.getName().equalsIgnoreCase("queen")) {
            return false;
        }

        int rowDiff = Math.abs(endX - startX);
        int colDiff = Math.abs(endY - startY);

        if ((rowDiff == colDiff) || (startX == endX || startY == endY)) {
            Piece capturedPiece = board.getPieceAt(endX, endY);
            if (capturedPiece != null) {
                capturedPiece.removeFromBoard();
            }
            return true;
        }

        return false;
    }
}
