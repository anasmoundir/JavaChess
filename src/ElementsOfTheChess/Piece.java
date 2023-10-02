package ElementsOfTheChess;

import chessBoard.Board;

public class Piece {
    private String name;
    private String color;
    private boolean stillOnBoard;
    private int x;
    private int y;


    public Piece() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStillOnBoard() {
        return stillOnBoard;
    }

    public void setStillOnBoard(boolean stillOnBoard) {
        this.stillOnBoard = stillOnBoard;
    }
    public void removeFromBoard() {
        this.stillOnBoard = false;
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

    public Piece(String name, String color) throws IllegalAccessException {
        this.color = color;
        switch (name.toLowerCase()) {
            case "bishop":
                this.name = "bishop";
                break;
            case "king":
                this.name = "king";
                break;
            case "knight":
                this.name = "knight";
                break;
            case "pown":
                this.name = "pown";
                break;
            case "queen":
                this.name = "queen";
                break;
            case "rook":
                this.name = "rook";
                break;
            default:
                throw new IllegalAccessException("Wrong selection of the piece: " + name);
        }
    }


    public Piece(String color) {
        this.color = color;
    }


}