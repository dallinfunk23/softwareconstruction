package chessTests;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessPiece;
import chess.ChessPosition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testFactory.TestFactory;

public class ChessBoardTests {

    private ChessBoard board;

    @BeforeEach
    public void setup() {
        board = TestFactory.getNewBoard();
    }


    @Test
    @DisplayName("Add and Get Piece")
    public void getAddPiece() {
        ChessPosition position = TestFactory.getNewPosition(4, 4);
        ChessPiece piece = TestFactory.getNewPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);

        board.addPiece(position, piece);

        ChessPiece foundPiece = board.getPiece(position);

        Assertions.assertEquals(piece.getPieceType(), foundPiece.getPieceType(),
                "ChessPiece returned by getPiece had the wrong piece type");
        Assertions.assertEquals(piece.teamColor(), foundPiece.teamColor(),
                "ChessPiece returned by getPiece had the wrong team color");
    }


    @Test
    @DisplayName("Reset Board")
    public void defaultGameBoard() {

        /*
        |r|n|b|q|k|b|n|r|
		|p|p|p|p|p|p|p|p|
		| | | | | | | | |
		| | | | | | | | |
		| | | | | | | | |
		| | | | | | | | |
		|P|P|P|P|P|P|P|P|
		|R|N|B|Q|K|B|N|R|
         */

        //set board to default
        board.resetBoard();

        //back row pieces
        //white
        Assertions.assertEquals(ChessPiece.PieceType.ROOK,
                board.getPiece(TestFactory.getNewPosition(1, 1)).getPieceType(),
                "Piece at rook starting position was not a rook");
        Assertions.assertEquals(ChessPiece.PieceType.KNIGHT,
                board.getPiece(TestFactory.getNewPosition(1, 2)).getPieceType(),
                "Piece at knight starting position was not a knight");
        Assertions.assertEquals(ChessPiece.PieceType.BISHOP,
                board.getPiece(TestFactory.getNewPosition(1, 3)).getPieceType(),
                "Piece at bishop starting position was not a bishop");
        Assertions.assertEquals(ChessPiece.PieceType.QUEEN,
                board.getPiece(TestFactory.getNewPosition(1, 4)).getPieceType(),
                "Piece at queen starting position was not a queen");
        Assertions.assertEquals(ChessPiece.PieceType.KING,
                board.getPiece(TestFactory.getNewPosition(1, 5)).getPieceType(),
                "Piece at king starting position was not a king");
        Assertions.assertEquals(ChessPiece.PieceType.BISHOP,
                board.getPiece(TestFactory.getNewPosition(1, 6)).getPieceType(),
                "Piece at bishop starting position was not a bishop");
        Assertions.assertEquals(ChessPiece.PieceType.KNIGHT,
                board.getPiece(TestFactory.getNewPosition(1, 7)).getPieceType(),
                "Piece at knight starting position was not a knight");
        Assertions.assertEquals(ChessPiece.PieceType.ROOK,
                board.getPiece(TestFactory.getNewPosition(1, 8)).getPieceType(),
                "Piece at rook starting position was not a rook");

        //black
        Assertions.assertEquals(ChessPiece.PieceType.ROOK,
                board.getPiece(TestFactory.getNewPosition(8, 1)).getPieceType(),
                "Piece at rook starting position was not a rook");
        Assertions.assertEquals(ChessPiece.PieceType.KNIGHT,
                board.getPiece(TestFactory.getNewPosition(8, 2)).getPieceType(),
                "Piece at knight starting position was not a knight");
        Assertions.assertEquals(ChessPiece.PieceType.BISHOP,
                board.getPiece(TestFactory.getNewPosition(8, 3)).getPieceType(),
                "Piece at bishop starting position was not a bishop");
        Assertions.assertEquals(ChessPiece.PieceType.QUEEN,
                board.getPiece(TestFactory.getNewPosition(8, 4)).getPieceType(),
                "Piece at queen starting position was not a queen");
        Assertions.assertEquals(ChessPiece.PieceType.KING,
                board.getPiece(TestFactory.getNewPosition(8, 5)).getPieceType(),
                "Piece at king starting position was not a king");
        Assertions.assertEquals(ChessPiece.PieceType.BISHOP,
                board.getPiece(TestFactory.getNewPosition(8, 6)).getPieceType(),
                "Piece at bishop starting position was not a bishop");
        Assertions.assertEquals(ChessPiece.PieceType.KNIGHT,
                board.getPiece(TestFactory.getNewPosition(8, 7)).getPieceType(),
                "Piece at knight starting position was not a knight");
        Assertions.assertEquals(ChessPiece.PieceType.ROOK,
                board.getPiece(TestFactory.getNewPosition(8, 8)).getPieceType(),
                "Piece at rook starting position was not a rook");

        //pawns
        for (int column = 1; column <= 8; ++column) {
            Assertions.assertEquals(ChessPiece.PieceType.PAWN,
                    board.getPiece(TestFactory.getNewPosition(2, column)).getPieceType(),
                    "Piece at pawn starting position was not a pawn");
            Assertions.assertEquals(ChessPiece.PieceType.PAWN,
                    board.getPiece(TestFactory.getNewPosition(7, column)).getPieceType(),
                    "Piece at pawn starting position was not a pawn");
        }

        //check color
        for (int column = 1; column <= 8; ++column) {
            //white team
            Assertions.assertEquals(ChessGame.TeamColor.WHITE,
                    board.getPiece(TestFactory.getNewPosition(1, column)).teamColor(),
                    "Piece at starting position was incorrect color");
            Assertions.assertEquals(ChessGame.TeamColor.WHITE,
                    board.getPiece(TestFactory.getNewPosition(2, column)).teamColor(),
                    "Piece at starting position was incorrect color");

            //black team
            Assertions.assertEquals(ChessGame.TeamColor.BLACK,
                    board.getPiece(TestFactory.getNewPosition(7, column)).teamColor(),
                    "Piece at starting position was incorrect color");
            Assertions.assertEquals(ChessGame.TeamColor.BLACK,
                    board.getPiece(TestFactory.getNewPosition(8, column)).teamColor(),
                    "Piece at starting position was incorrect color");
        }

        //check nullity
        ChessPosition pawnPosition = TestFactory.getNewPosition(3, 3);
        ChessPosition knightPosition = TestFactory.getNewPosition(4, 4);
        ChessPosition bishopPosition = TestFactory.getNewPosition(5, 5);
        ChessPosition rookPosition = TestFactory.getNewPosition(6, 6);
        board.addPiece(pawnPosition,
                TestFactory.getNewPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        board.addPiece(knightPosition,
                TestFactory.getNewPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT));
        board.addPiece(bishopPosition,
                TestFactory.getNewPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP));
        board.addPiece(rookPosition,
                TestFactory.getNewPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK));
        board.resetBoard();
        for (int row = 3; row <= 6; ++row) {
            for (int column = 1; column <= 8; ++column) {
                Assertions.assertNull(board.getPiece(TestFactory.getNewPosition(row, column)),
                        "Piece in the middle of the board was not reset");
            }
        }
    }

}