     package chessBoard;

     import ElementsOfTheChess.*;

     import java.util.Optional;

     import static Rules.RulesForTheGame.isValidCoordinate;
     import static java.awt.Color.white;

     public class Board {

          public static Square[][] squares;


          public static void setSquares(Square[][] squares) {
               Board.squares = squares;
          }

          public Board() throws IllegalAccessException {
               squares = new Square[8][8];
                chargingThesquares();
               initializePieces();
                displayTheSquare();
          }


          public static void chargingThesquares() {
               String emptyWhiteSquareIcon = "□";
               String emptyBlackSquareIcon = "■";

               for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                         String squareIcon = (row + col) % 2 == 0 ? emptyWhiteSquareIcon : emptyBlackSquareIcon;
                         squares[row][col] = new Square(squareIcon, true, row, col);
                    }
               }
          }

          public static void displayTheSquare() {
               System.out.println("  a  b  c  d  e  f  g  h");
               for (int row =0 ; row <= 7; row++) {
                    System.out.println("\n");
                    for (int col = 0; col < 8; col++) {
                         Piece piece = squares[row][col].getPiece();
                         if (piece != null) {
                              String pieceName = piece.getName();
                              String pieceIcon = getPieceIcon(pieceName, piece.getColor());
                              System.out.print(pieceIcon + "  ");
                         } else {
                              System.out.print(squares[row][col].getColor() + "  " + "row:  "+row +"   " + "col: "+col +"  ");
                         }
                    }
                    System.out.println((row + 1));
               }
               System.out.println("  a  b  c  d  e  f  g  h");
          }

          public static String getPieceIcon(String pieceName, String pieceColor) {
               String icon = "";

               if ("king".equals(pieceName)) {
                    icon = "♚";
               } else if ("queen".equals(pieceName)) {
                    icon = "♛";
               } else if ("rook".equals(pieceName)) {
                    icon = "♜";
               } else if ("bishop".equals(pieceName)) {
                    icon = "♝";
               } else if ("knight".equals(pieceName)) {
                    icon = "♞";
               } else if ("pown".equals(pieceName)) {
                    icon = "♟";
               }

               if ("white".equals(pieceColor)) {
                    icon = icon.toUpperCase();
               }

               return icon;
          }
          public static Square[][] getSquares() {
               return squares;
          }
          public void initializePieces() throws IllegalAccessException {
               squares[0][0].setPiece(new Piece("rook", "white"));
               squares[0][0].getPiece().setX(0);
               squares[0][0].getPiece().setY(0);

               squares[0][1].setPiece(new Piece("knight", "white"));
               squares[0][1].getPiece().setX(0);
               squares[0][1].getPiece().setY(1);

               squares[0][2].setPiece(new Piece("bishop", "white"));
               squares[0][2].getPiece().setX(0);
               squares[0][2].getPiece().setY(2);

               squares[0][3].setPiece(new Piece("queen", "white"));
               squares[0][3].getPiece().setX(0);
               squares[0][3].getPiece().setY(3);

               squares[0][4].setPiece(new Piece("king", "white"));
               squares[0][4].getPiece().setX(0);
               squares[0][4].getPiece().setY(4);

               squares[0][5].setPiece(new Piece("bishop", "white"));
               squares[0][5].getPiece().setX(0);
               squares[0][5].getPiece().setY(5);

               squares[0][6].setPiece(new Piece("knight", "white"));
               squares[0][6].getPiece().setX(0);
               squares[0][6].getPiece().setY(6);

               squares[0][7].setPiece(new Piece("rook", "white"));
               squares[0][7].getPiece().setX(0);
               squares[0][7].getPiece().setY(7);

               for (int row = 0; row < 8; row++) {
                    squares[1][row].setPiece(new Piece("pown", "white"));
                    squares[1][row].getPiece().setX(1);
                    squares[1][row].getPiece().setY(row);
               }

               squares[7][0].setPiece(new Piece("rook", "black"));
               squares[7][0].getPiece().setX(7);
               squares[7][0].getPiece().setY(0);

               squares[7][1].setPiece(new Piece("knight", "black"));
               squares[7][1].getPiece().setX(7);
               squares[7][1].getPiece().setY(1);

               squares[7][2].setPiece(new Piece("bishop", "black"));
               squares[7][2].getPiece().setX(7);
               squares[7][2].getPiece().setY(2);

               squares[7][3].setPiece(new Piece("queen", "black"));
               squares[7][3].getPiece().setX(7);
               squares[7][3].getPiece().setY(3);

               squares[7][4].setPiece(new Piece("king", "black"));
               squares[7][4].getPiece().setX(7);
               squares[7][4].getPiece().setY(4);

               squares[7][5].setPiece(new Piece("bishop", "black"));
               squares[7][5].getPiece().setX(7);
               squares[7][5].getPiece().setY(5);

               squares[7][6].setPiece(new Piece("knight", "black"));
               squares[7][6].getPiece().setX(7);
               squares[7][6].getPiece().setY(6);

               squares[7][7].setPiece(new Piece("rook", "black"));
               squares[7][7].getPiece().setX(7);
               squares[7][7].getPiece().setY(7);

               for (int row = 0; row < 8; row++) {
                    squares[6][row].setPiece(new Piece("pown", "black"));
                    squares[6][row].getPiece().setX(6);
                    squares[6][row].getPiece().setY(row);
               }
          }
          public Piece getPieceAt(int startX, int startY) {
               Piece piece = squares[startY][startX].getPiece();
               if (piece == null) {
                    System.out.println("there is no piece here");
               }
               return piece;
          }

     }
