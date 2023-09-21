package chessBoard;

import ElementsOfTheChess.Piece;

public class Square {
    private String color;
    private boolean available;
    Piece piece;

    public Piece getPiece() {
        return piece;
    }


    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    private int x;
    private int y;

    public Square() {
    }

    public Square(String color, boolean available, int x, int y) {
        this.color = color;
        this.available = true;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}