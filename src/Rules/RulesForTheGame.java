package Rules;


import ElementsOfTheChess.King;
import ElementsOfTheChess.Piece;
import ElementsOfTheChess.Pown;
import ElementsOfTheChess.Rook;
import Players.Adversaires;
import chessBoard.Board;
import chessBoard.Square;

import static chessBoard.Board.squares;

public class RulesForTheGame {

    private  Board board;
    public  RulesForTheGame(Board board)
    {

    }
    public RulesForTheGame() throws IllegalAccessException {
    }


    public boolean isValidMove()
    {
        boolean varriable =false;
        return  varriable;
    }


    public boolean isPathClear(int startX,int startY, int endX, int endY)
    {
        boolean varriable =false;
        return  varriable;
    }

    public boolean canCastle(King king, Rook rook)
    {
        boolean  pourevitererur =false;
        return  pourevitererur;
    }
    public  boolean isCheckmate(King king)
    {
        boolean  pourevitererur =false;
        return  pourevitererur;
    }

    public boolean isStalemate(Adversaires currentplayer)
    {
        boolean  pourevitererur =false;
        return  pourevitererur;
    }
    public boolean isDraw()
    {
        boolean  pourevitererur =false;
        return  pourevitererur;
    }

    public  boolean  isValidPownMove(Piece piece, int startX,int startY,int endX,int endY)
    {
        if (!isValidCoordinate(startX, endX ) || !isValidCoordinate(startY, endY)) {
            return false;
        }

        return false;
    }

    public boolean isValidKingmove(Piece piece, int startX,int startY,int endX,int endY)
    {
        if(!isValidCoordinate(startX,endX) || !isValidCoordinate(startY,endY))
        {
            return false;
        }
        return false;
    }
    public boolean isValidKnightMove(Piece piece,int startX,int startY,int endX,int endY)
    {
        if(!isValidCoordinate(startX,startY) || !isValidCoordinate(endX,endY))
        {
            return  false;
        }
        return  false;
    }



    public  boolean isValidQueenMove(Piece piece,int startX,int startY,int endX,int endY)
    {
        return false;
    }
    public  void  movepiece(Piece piece, int startX,int startY,int endX,int endY)
    {

    }
    public void promotePawn(Pown pown,Piece newPiece)
    {

    }
    public void undoMove()
    {

    }

    public  void saveGame(String fileName)
    {

    }
    public  void loadGame(String filename)
    {

    }

    public boolean isValidBishopMove(Piece piece,int startX,int startY,int endX,int endY)
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


                Square[][] squares = Board.getSquares();

                if (squares[nextX][nextY].getPiece() != null) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
    public boolean isValidRookMove(Piece piece,int startX,int startY,int endX,int endY)
    {
        if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
            return false;
        }
        Square[][] squares = Board.getSquares();
        int rowDiff = Math.abs(endX - startX);
        int colDiff = Math.abs(endY - startY);

        if (rowDiff == 0 && colDiff > 0) {
            return isVerticalPathClear(startX, startY, endX, endY);
        } else if (rowDiff > 0 && colDiff == 0) {
            return isHorizontalPathClear(startX, startY, endX, endY);
        }

        return false;
    }


    private boolean isVerticalPathClear(int startX, int startY, int endX, int endY) {
        int step = (endY > startY) ? 1 : -1;
        Square[][] squares = Board.getSquares();
        for (int i = startY + step; i != endY; i += step) {
            if (squares[startX][i].getPiece() != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isHorizontalPathClear(int startX, int startY, int endX, int endY) {
        int step = (endX > startX) ? 1 : -1;
        Square[][] squares = Board.getSquares();
        for (int i = startX + step; i != endX; i += step) {
            if (squares[i][startY].getPiece() != null) {
                return false; // There's a piece in the path
            }
        }
        return  true;
    }
    private boolean isValidCoordinate(int x, int y)
    {
        return x >=0 && x<8 && y >=0  && y <8;
    }
}
