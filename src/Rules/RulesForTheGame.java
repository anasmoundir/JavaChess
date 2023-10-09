package Rules;
import ElementsOfTheChess.*;
import Players.Player;
import chessBoard.Board;
import chessBoard.Square;

import javax.swing.*;

import static chessBoard.Board.getSquares;
import static chessBoard.Board.squares;

public class RulesForTheGame {

    public static Board board;
    public  RulesForTheGame(Board board)
    {


    }

    public boolean isPathClear(Piece piece, int endX, int endY, Square[][] squares) {
        int startX = piece.getX();
        int startY = piece.getY();
        int dx = Integer.compare(endX, piece.getX());
        int dy = Integer.compare(endY, piece.getY());
        int x = startX + dx;
        int y = startY + dy;

        while (x != endX || y != endY) {
            if (squares[x][y].getPiece() != null) {
                System.out.println("Path not clear at (" + x + ", " + y + ")");
                return false;
            }
            x += dx;
            y += dy;
        }

        return true;
    }

//    public boolean isCheck(Player currentPlayer) {
//        King king = findKing(currentPlayer);
//        int kingX = king.getX();
//        int kingY = king.getY();
//        Square[][] squares = getSquares();
//        String opponentColor = (currentPlayer.getColor() == Player.CouleurPlayer.white) ? Player.CouleurPlayer.black.name() : Player.CouleurPlayer.white.name();
//        for (int x = 0; x < 8; x++) {
//            for (int y = 0; y < 8; y++) {
//                Piece piece = squares[x][y].getPiece();
//                if (piece != null && piece.getColor().equals(opponentColor)) {
//                    if (isValidMove(currentPlayer, x, y, kingX, kingY, piece.getName()),piece) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

//    public boolean isCheckmate(Player currentPlayer) {
//        King king = findKing(currentPlayer);
//        if (isCheck(currentPlayer)) {
//            for (Piece piece : currentPlayer.getPieces()) {
//                for (int x = 0; x < 8; x++) {
//                    for (int y = 0; y < 8; y++) {
//                        if (isValidMove(currentPlayer, piece.getX(), piece.getY(), x, y, piece.getName())) {
//                            return false;
//                        }
//                    }
//                }
//            }
//            return true;
//        }
//        return false;
//    }

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

    public void movePiece(int startX, int startY, int endX, int endY, Piece piece) {

        if (piece == null) {
            throw new IllegalArgumentException("No piece at the starting square.");
        }
        piece.setY(endY);
        piece.setX(endX);

        squares[endX][endY].setPiece(piece);

        System.out.println(squares[endX][endY].getColor());
        squares[startX][startY].setPiece(null);
    }

    public void makeMove(Player player, int startX, int startY, int endX, int endY, String pieceType, Piece piece) {
        if(piece.getName() == "knight" && isValidMove(player, startX, startY, endX, endY, pieceType, piece))
        {
            movePiece(startX, startY, endX, endY, piece);
        }
        else if (isValidMove(player, startX, startY, endX, endY, pieceType, piece)) {
            if (isPathClear(piece, endX, endY, board.getSquares())) {
                movePiece(startX, startY, endX, endY, piece);
            } else {
                throw new IllegalArgumentException("Invalid move. The path is not clear.");
            }
        } else {
            throw new IllegalArgumentException("Invalid move.");
        }
    }
    public static   boolean isValidMove(Player player, int startX, int startY, int endX, int endY, String pieceType, Piece piece) {
        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
            return false;
        }

        System.out.println("valide cordonating");
         switch (pieceType.toLowerCase()) {
            case "pown":
                return Pown.isValidPownMove(piece,endX,endY);
            case "rook":
                return Rook.isValidRookMove(piece, startX, startY, endX, endY);
            case "knight":
                return Knight.isValidKnightMove(piece, endX, endY);
            case "bishop":
                return Bishop.isValidBishopMove(piece, startX, startY, endX, endY);
            case "queen":
                return Queen.isValidQueenMove(piece, endX, endY);
            case "king":
                return King.isValidKingMove(piece, endX, endY);
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
