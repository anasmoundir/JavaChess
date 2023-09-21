package chessBoard;

import ElementsOfTheChess.*;

public class Board {

     private static Square[][] squares;



     public static void setSquares(Square[][] squares) {
          Board.squares = squares;
     }

     public Board() throws IllegalAccessException {
          squares = new Square[8][8];
           chargingThesquares();
          initializePieces();
           displayTheSquare();
     }


     public static void  chargingThesquares()
     {
          for(int x = 0; x<= 7; x++)
          {
               for (int y = 0;y<= 7;y++ )
               {
                    String color = (x+y) % 2 == 0 ? "white" : "black";
                    squares[x][y] = new Square(color,true,x,y);
               }
          }

     }

     public static  void displayTheSquare()
     {
          for(int x = 0; x<= 7; x++)
          {
               System.out.println("\n");
               for (int y = 0;y<=7;y++ )
               {
                    System.out.print(squares[x][y].getColor() +"  ");

               }
          }
     }
     public static Square[][] getSquares() {
          return squares;
     }
     private void initializePieces() throws IllegalAccessException {

          squares[0][0].setPiece(new Rook("white"));
          squares[0][1].setPiece(new Knight("white"));
          squares[0][2].setPiece(new Bishop("white"));
          squares[0][3].setPiece(new Queen("white"));
          squares[0][4].setPiece(new King("white"));
          squares[0][5].setPiece(new Bishop("white"));
          squares[0][6].setPiece(new Knight("white"));
          squares[0][7].setPiece(new Rook("white"));


          for (int col = 0; col < 8; col++) {
               squares[1][col].setPiece(new Pown("white"));
          }

          squares[7][0].setPiece(new Rook("black"));
          squares[7][1].setPiece(new Knight("black"));
          squares[7][2].setPiece(new Bishop("black"));
          squares[7][3].setPiece(new Queen("black"));
          squares[7][4].setPiece(new King("black"));
          squares[7][5].setPiece(new Bishop("black"));
          squares[7][6].setPiece(new Knight("black"));
          squares[7][7].setPiece(new Rook("black"));

          for (int col = 0; col < 8; col++) {
               squares[6][col].setPiece(new Pown("black"));
          }
     }


}
