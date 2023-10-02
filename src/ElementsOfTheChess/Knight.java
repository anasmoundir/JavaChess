package ElementsOfTheChess;

import static Rules.RulesForTheGame.isValidCoordinate;

public class Knight extends Piece {


    public  Knight(String color) throws IllegalAccessException {
        super(color);
    }
    public static boolean isValidKnightMove(Piece piece, int startX, int startY, int endX, int endY)
    {
        if(!isValidCoordinate(startX,startY) || !isValidCoordinate(endX,endY))
        {
            return  false;
        }
        return  false;
    }

}
