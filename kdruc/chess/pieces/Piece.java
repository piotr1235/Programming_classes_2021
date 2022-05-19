package kdruc.chess.pieces;

import kdruc.chess.Board;
import kdruc.chess.pieceattributes.*;

import java.util.List;


public abstract class Piece {
	protected final PieceColor pieceColor;
	private final char name;
	private Position position;


	public Piece(char name, PieceColor pieceColor, Position position) {
		this.pieceColor = pieceColor;
		this.name = name;
		this.position = position;
	}

	public PieceColor color() {
		return pieceColor;
	}

	public char name() {
		return name;
	}

	public Position position() {
		return position;
	}

	public void moveTo(Position position) {
		this.position = position;
	}
	public boolean canCapture( Position target, Board board) {
		if(board.isOccupied(target)){
			return board.getPiece(target).color() != this.color();
		}
		return false;
	}

	public abstract char icon();
		public abstract List<Position> getAllPositions(Board board);

}
