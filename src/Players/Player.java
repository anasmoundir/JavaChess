package Players;

import ElementsOfTheChess.*;

import java.util.*;

import static chessBoard.Board.squares;

public class Player {
    private CouleurPlayer color;
    private boolean isTurn;
    private List<Piece> pieces;

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move (e.g., 'e2 e4'): ");
        return scanner.nextLine();
    }

    public Player(CouleurPlayer color) throws IllegalAccessException {
        this.color = color;
        this.isTurn = false;
        initializePieces();
    }


    public void toggleTurn() {
        isTurn = !isTurn;
    }

    public enum CouleurPlayer {
        white,
        black
    }

    public CouleurPlayer getColor() {
        return color;
    }



    private void initializePieces() throws IllegalAccessException {
        pieces = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            pieces.add(new Pown("white"));
        }

        for (int i = 0; i < 2; i++) {
            pieces.add(new Rook("white"));
        }

        for (int i = 0; i < 2; i++) {
            pieces.add(new Knight("white"));
        }

        for (int i = 0; i < 2; i++) {
            pieces.add(new Bishop("white"));
        }

        pieces.add(new Queen("white"));

        pieces.add(new King("white"));

        for (int i = 0; i < 8; i++) {
            pieces.add(new Pown("black"));
        }

        for (int i = 0; i < 2; i++) {
            pieces.add(new Rook("black"));
        }

        for (int i = 0; i < 2; i++) {
            pieces.add(new Knight("black"));
        }

        for (int i = 0; i < 2; i++) {
            pieces.add(new Bishop("black"));
        }

        pieces.add(new Queen("black"));
        pieces.add(new King("black"));
    }
    public List<Piece> getPieces() {
        return pieces;
    }
    @Override
    public String toString() {
        return "Player{" +
                "color=" + color +
                ", isTurn=" + isTurn +
                ", pieces=" + pieces +
                '}';
    }
}

