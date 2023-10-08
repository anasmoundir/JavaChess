package ElementsOfTheChess;

public class Queen extends Piece{
    public  Queen(String color) throws IllegalAccessException {
        super(color);
    }
    public static boolean isValidQueenMove(Piece piece, int endX, int endY) {
        int  startX  = piece.getX();
        int  startY= piece.getY();
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        return deltaX == 0 || deltaY == 0 || deltaX == deltaY;
    }
}
