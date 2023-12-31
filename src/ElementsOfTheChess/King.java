package ElementsOfTheChess;

import Players.Player;
import Rules.RulesForTheGame;
import chessBoard.Square;

import static Rules.RulesForTheGame.board;
import static Rules.RulesForTheGame.isValidCoordinate;
import static chessBoard.Board.getSquares;

public class King  extends Piece{

    public King(String color) throws IllegalAccessException {
        super(color);
    }
    public static boolean isValidKingMove(Piece piece, int endX, int endY) {
        if (!isValidCoordinate(endX, endY)) {
            return false;
        }

        int startX = piece.getX();
        int startY = piece.getY();

        int rowDiff = Math.abs(endX - startX);
        int colDiff = Math.abs(endY - startY);

        if (rowDiff <= 1 && colDiff <= 1) {
            return true;
        }

        return false;
    }

    private static boolean isUnderThreat(Player currentPlayer, int newKingX, int newKingY) {
        String opponentColor = (currentPlayer.getColor() == Player.CouleurPlayer.white) ? Player.CouleurPlayer.black.toString() : Player.CouleurPlayer.white.toString();

        Square[][] squares = getSquares();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = squares[x][y].getPiece();
                String  kingString ="king";
                if (piece != null && piece.getColor().equals(opponentColor)) {
                    if (RulesForTheGame.isValidMove(currentPlayer,x, y, newKingX, newKingY,kingString,piece)) {
                        return true;
                    }
                }
            }
        }


        return false;
    }
    public boolean isValidCapture(Piece piece, int endX, int endY, Square[][] squares) {
        if (squares[endX][endY].getPiece() != null &&
                !piece.getColor().equals(squares[endX][endY].getPiece().getColor())) {
                 squares[endX][endY].getPiece().removeFromBoard();
            return true;
        }
        return false;
    }
    public boolean canEscapeCheck(Player currentPlayer, King king) {
        int kingX = king.getX();
        int kingY = king.getY();
        Square[][] squares = getSquares();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }

                int newKingX = kingX + dx;
                int newKingY = kingY + dy;

                if (!isValidCoordinate(newKingX, newKingY)) {
                    continue;
                }
                if (!King.isUnderThreat(currentPlayer, newKingX, newKingY)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean captureWithKing(Player player, int startX, int startY, int endX, int endY, Piece piece) {
        if (!piece.getName().equalsIgnoreCase("king")) {
            return false;
        }

        int rowDiff = Math.abs(endX - startX);
        int colDiff = Math.abs(endY - startY);

        if (rowDiff <= 1 && colDiff <= 1) {
            Piece capturedPiece = board.getPieceAt(endX, endY);
            if (capturedPiece != null) {
                capturedPiece.removeFromBoard();
            }
            return true;
        }

        return false;
    }
}
