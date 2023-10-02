import Players.Player;
import Rules.RulesForTheGame;
import chessBoard.Board;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        boolean gameOver = false;
        Player playerBlack = new Player(Player.CouleurPlayer.black);
        Player playerWhite = new Player(Player.CouleurPlayer.white);

        Player currentPlayer = playerWhite;

        Board board = new Board();
        RulesForTheGame rules = new RulesForTheGame(board);

        while (!gameOver) {
            String move = currentPlayer.getUserInput();

            String[] moveParts = move.split(" ");
            if (moveParts.length == 2) {
                String startCoordinate = moveParts[0];
                String endCoordinate = moveParts[1];

                char startX = startCoordinate.charAt(0);
                int startY = Integer.parseInt(startCoordinate.charAt(1) + "");
                char endX = endCoordinate.charAt(0);
                int endY = Integer.parseInt(endCoordinate.charAt(1) + "");

                String pieceType = "pawn";

                if (rules.isValidMove(currentPlayer, startX, startY, endX, endY, pieceType)) {

                    if (rules.isCheckmate(currentPlayer)|| rules.isStalemate(currentPlayer)) {
                        gameOver = true;
                        System.out.println("Game Over!");
                    } else {

                        currentPlayer = (currentPlayer == playerWhite) ? playerBlack : playerWhite;
                    }
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            } else {
                System.out.println("Invalid move format. Please enter in the format 'e2 e4'.");
            }
        }
    }
}