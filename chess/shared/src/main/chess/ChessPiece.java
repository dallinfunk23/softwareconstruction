package chess;

import java.util.Collection;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this interface, but you should not alter the existing
 * methods.
 */
public interface ChessPiece {

    /**
     * @return Which team this chess piece belongs to
     */
    ChessGame.TeamColor teamColor();

    /**
     * @return which type of chess piece this piece is
     */
    PieceType getPieceType();

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);

    /**
     * @return whether the piece has been moved yet
     */
    boolean hasMoved();

    /**
     * Mark whether the pieces has been moved yet
     */
    void markAsMoved();

    /**
     * The various different chess piece options
     */
    enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }
}