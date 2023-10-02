import Players.Player;
import Rules.RulesForTheGame;
import chessBoard.Board;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        // Initialize the game
        boolean gameOver = false;
        Player playerBlack = new Player(Player.CouleurPlayer.black);
        Player playerWhite = new Player(Player.CouleurPlayer.white);

        Player currentPlayer = playerWhite;

        // Create an instance of RulesForTheGame with the game board
        Board board = new Board(); // Initialize the board as needed
        RulesForTheGame rules = new RulesForTheGame(board);

        while (!gameOver) {
            // Get the player's move input
            String move = currentPlayer.getUserInput();


            String[] moveParts = move.split(" ");
            if (moveParts.length == 2) {
                String startCoordinate = moveParts[0]; // e2
                String endCoordinate = moveParts[1];   // e4

                // Extract coordinates from start and end
                char startX = startCoordinate.charAt(0); // 'e'
                int startY = Integer.parseInt(startCoordinate.charAt(1) + ""); // 2
                char endX = endCoordinate.charAt(0);     // 'e'
                int endY = Integer.parseInt(endCoordinate.charAt(1) + "");   // 4

                // You can determine the piece type based on your game logic
                String pieceType = "pawn"; // Example piece type

                // Check if the move is valid using the RulesForTheGame.isValidMove method
                if (rules.isValidMove(currentPlayer, startX, startY, endX, endY, pieceType)) {
                    // Move is valid, apply the move logic here
                    // For example, update the chessboard with the move
                    // ...

                    // Check if the game is over (checkmate or stalemate)
                    if (rules.isCheckmate()|| rules.isStalemate(currentPlayer)) {
                        gameOver = true;
                        System.out.println("Game Over!");
                    } else {
                        // Switch to the other player's turn
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