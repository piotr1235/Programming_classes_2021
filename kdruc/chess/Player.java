package kdruc.chess;

import kdruc.chess.pieceattributes.*;
import kdruc.chess.pieces.Piece;

public class Player {

	private final PieceColor playerColor;
	private Board board;

	public Player(PieceColor playerColor, Board board) {
		this.playerColor = playerColor;
		this.board = board;
	}

	public void makeMove(Piece piece, Position finalPosition) throws IllegalMoveException {
		if (piece.color() == playerColor) board.makeMove(piece, finalPosition);
	}
}
