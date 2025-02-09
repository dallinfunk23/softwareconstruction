package chess;

/**
 * Indicates an invalid move was made in a game
 */
public class InvalidMoveException extends Exception {

    public InvalidMoveException() {
        throw new IllegalArgumentException("Invalid Move.");
    }

    public InvalidMoveException(String message) {
        super(message);
    }
}