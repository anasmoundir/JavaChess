package Rules;


import ElementsOfTheChess.King;
import ElementsOfTheChess.Piece;
import ElementsOfTheChess.Pown;
import ElementsOfTheChess.Rook;
import Players.Adversaires;
import chessBoard.Board;

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

    public boolean isValidBishopMove(Piece piece,int startX,int startY,int endX,int endY)
    {
        if(!isValidCoordinate(startX,startY) || !isValidCoordinate(endX,endY))
        {
            return  false;
        }

        return  false;
    }
    public boolean isValidRookMove(Piece piece,int startX,int startY,int endX,int endY)
    {

        return false;
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

    private boolean isValidCoordinate(int x, int y)
    {
        return x >=0 && x<8 && y >=0  && y <8;
    }
}
