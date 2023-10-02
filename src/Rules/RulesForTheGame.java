package Rules;


import ElementsOfTheChess.*;
import Players.Player;
import chessBoard.Board;
import chessBoard.Square;

import static chessBoard.Board.getSquares;

public class RulesForTheGame {

    private   Board board;
    public  RulesForTheGame(Board board)
    {

    }

    public boolean isPathClear(int startX,int startY, int endX, int endY)
    {
        boolean varriable =false;
        return  varriable;
    }

    public boolean isCheck(Player currentPlayer) {
        King king = findKing(currentPlayer);
        int kingX = king.getX();
        int kingY = king.getY();
        Square[][] squares = getSquares();
        String opponentColor = (currentPlayer.getColor() == Player.CouleurPlayer.white) ? Player.CouleurPlayer.black.toString();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = squares[x][y].getPiece();
                if (piece != null && piece.getColor().equals(opponentColor)) {
                    if (isValidMove(currentPlayer, x, y, kingX, kingY, piece.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCheckmate(Player currentPlayer) {
        King king = findKing(currentPlayer);
        if (isCheck(currentPlayer)) {
            for (Piece piece : currentPlayer.getPieces()) {
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (isValidMove(currentPlayer, piece.getX(), piece.getY(), x, y, piece.getName())) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private King findKing(Player currentPlayer) {
        for (Piece piece : currentPlayer.getPieces()) {
            if (piece instanceof King) {
                return (King) piece;
            }
        }
        return null;
    }



    public boolean isStalemate(Player currentplayer)
    {
        boolean  pourevitererur =false;
        return  pourevitererur;
    }
    public boolean isDraw()
    {
        boolean  pourevitererur =false;
        return  pourevitererur;
    }
    public boolean isUnderThreat(Piece piece, Piece[][] board) {
        int x = piece.getX();
        int y = piece.getY();
        String color = piece.getColor();
        int[] pawnDeltas = (color.equals("white")) ? new int[]{-1, 1} : new int[]{1, -1};
        for (int delta : pawnDeltas) {
            int pawnX = x + delta;
            if (isValidCoordinate(pawnX, y - 1) && isOpponentPawn(board[pawnX][y - 1], color)) {
                return true;
            }
            if (isValidCoordinate(pawnX, y + 1) && isOpponentPawn(board[pawnX][y + 1], color)) {
                return true;
            }
        }


        return false;
    }


    private boolean isOpponentPawn(Piece piece, String color) {

        return piece != null && !piece.getColor().equals(color) && piece.getName().equals("pawn");
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
            throw new IllegalArgumentException("Invalid coordinates for move.");
        }

        Square[][] squares = getSquares();
        Piece piece = squares[startX][startY].getPiece();

        if (piece == null) {
            throw new IllegalArgumentException("No piece at the starting square.");
        }

        squares[startX][startY].removePiece();
        squares[endX][endY].setPiece(piece);
        piece.setX(endX);
        piece.setY(endY);
    }
    public void makeMove(Player player, int startX, int startY, int endX, int endY, String pieceType) {
        if (isValidMove(player, startX, startY, endX, endY, pieceType)) {
            movePiece(startX, startY, endX, endY);
        } else {
            throw new IllegalArgumentException("Invalid move.");
        }
    }

    public static   boolean isValidMove(Player player, int startX, int startY, int endX, int endY, String pieceType) {
        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
            return false;
        }
        Square[][] squares = getSquares();
        Piece piece = squares[startX][startY].getPiece();
         switch (pieceType.toLowerCase()) {
            case "pown":
                return Pown.isValidPownMove(piece, startX, startY, endX, endY);
            case "rook":
                return Rook.isValidRookMove(piece, startX, startY, endX, endY);
            case "knight":
                return Knight.isValidKnightMove(piece, startX, startY, endX, endY);
            case "bishop":
                return Bishop.isValidBishopMove(piece, startX, startY, endX, endY);
            case "queen":
                return Queen.isValidQueenMove(piece, startX, startY, endX, endY);
            case "king":
                return King.isValidKingMove(piece, startX, startY, endX, endY);
            default:
                return false;
        }
    }


    public static boolean isVerticalPathClear(int startX, int startY, int endX, int endY) {
        int step = (endY > startY) ? 1 : -1;
        Square[][] squares = getSquares();
        for (int i = startY + step; i != endY; i += step) {
            if (squares[startX][i].getPiece() != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHorizontalPathClear(int startX, int startY, int endX, int endY) {
        int step = (endX > startX) ? 1 : -1;
        Square[][] squares = getSquares();
        for (int i = startX + step; i != endX; i += step) {
            if (squares[i][startY].getPiece() != null) {
                return false;
            }
        }
        return  true;
    }
    public static boolean isValidCoordinate(int x, int y)
    {
        return x >=0 && x<8 && y >=0  && y <8;
    }
    public void resetGame() throws IllegalAccessException {
        board.initializePieces();
        System.out.println("Game reset to the initial state.");
    }
}
