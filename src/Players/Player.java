package Players;

import java.util.*;
public class Player {
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move (e.g., 'e2 e4'): ");
        return scanner.nextLine();
    }

}
