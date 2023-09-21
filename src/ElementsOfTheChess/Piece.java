package ElementsOfTheChess;

public class Piece {
        private String color;
        private boolean stillOnBoard;
        Bishop bishop;
        King king;
        Knight knight;
        Pown pown;
        Queen queen;
        Rook rook;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isStillOnBoard() {
        return stillOnBoard;
    }

    public void setStillOnBoard(boolean stillOnBoard) {
        this.stillOnBoard = stillOnBoard;
    }

    public Bishop getBishop() {
        return bishop;
    }

    public void setBishop(Bishop bishop) {
        this.bishop = bishop;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public Pown getPown() {
        return pown;
    }

    public void setPown(Pown pown) {
        this.pown = pown;
    }

    public Queen getQueen() {
        return queen;
    }

    public void setQueen(Queen queen) {
        this.queen = queen;
    }

    public Rook getRook() {
        return rook;
    }

    public void setRook(Rook rook) {
        this.rook = rook;
    }
    public  Piece(String name,String color) throws IllegalAccessException {
            this.color =color;
        switch (name.toLowerCase()) {
            case "bishop":
                bishop = new Bishop(color);
                break;
            case "king":
                king = new King(color);
                break;
            case "knight":
                knight = new Knight(color);
                break;
            case "pawn":
                pown = new Pown(color);
                break;
            case "queen":
                queen = new Queen(color);
                break;
            case "rook":
                rook = new Rook(color);
                break;
            default:
                throw new IllegalAccessException("Wrong selection of the piece: " + name);
        }

    }
     public Piece(String color)
     {
         this.color =color;
     }

}
