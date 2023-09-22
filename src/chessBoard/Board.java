package chessBoard;

import ElementsOfTheChess.*;

import static java.awt.Color.white;

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
          squares[0][0].setColor("yellow");
     }

     public static void displayTheSquare() {
          for (int x = 0; x <= 7; x++) {
               System.out.println("\n");
               for (int y = 0; y <= 7; y++) {
                    Piece piece = squares[x][y].getPiece();
                    if (piece != null) {
                         System.out.print(squares[x][y].getPiece().getName()+ "  ");
                         System.out.print((char)(squares[x][y].getX()+65));

                    } else {
                         System.out.print(squares[x][y].getColor() + "  ");
                         System.out.print(squares[x][y].getX());
                         System.out.print((char)(squares[x][y].getX()+65));
                    }
               }
          }
     }
     public static Square[][] getSquares() {
          return squares;
     }
     private void initializePieces() throws IllegalAccessException {


          squares[0][0].setPiece(new Piece("king", "white"));
          System.out.println(squares[0][0].isAvailable() = false);
          squares[0][1].setPiece(new Piece("knight", "white"));
          squares[0][2].setPiece(new Piece("bishop", "white"));
          squares[0][3].setPiece(new Piece("queen", "white"));
          squares[0][4].setPiece(new Piece("king", "white"));
          squares[0][5].setPiece(new Piece("bishop", "white"));
          squares[0][6].setPiece(new Piece("knight", "white"));
          squares[0][7].setPiece(new Piece("rook", "white"));

          for (int col = 0; col < 8; col++) {
               squares[1][col].setPiece(new Piece("pown", "white"));
          }

          squares[7][0].setPiece(new Piece("rook", "black"));
          squares[7][1].setPiece(new Piece("knight", "black"));
          squares[7][2].setPiece(new Piece("bishop", "black"));
          squares[7][3].setPiece(new Piece("queen", "black"));
          squares[7][4].setPiece(new Piece("king", "black"));
          squares[7][5].setPiece(new Piece("bishop", "black"));
          squares[7][6].setPiece(new Piece("knight", "black"));
          squares[7][7].setPiece(new Piece("rook", "black"));

          for (int col = 0; col < 8; col++) {
               squares[6][col].setPiece(new Piece("pown", "black"));
          }


}
}
