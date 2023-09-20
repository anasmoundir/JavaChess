package chessBoard;

public class Board {

     private static Square[][] squares;
     public Board() {
          squares = new Square[8][8];
           chargingThesquares();
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



}
