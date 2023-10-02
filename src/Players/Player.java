package Players;

import java.util.*;
public class Player {
    private CouleurPlayer color;
    private boolean isTurn;

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move (e.g., 'e2 e4'): ");
        return scanner.nextLine();
    }
    public Player(CouleurPlayer color) {
        this.color = color;
        this.isTurn = false;
    }
    public void toggleTurn() {
        isTurn = !isTurn;
    }
    public  enum  CouleurPlayer
    {
        white,
        black
    }

}

