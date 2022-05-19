package kdruc.chess.pieces;

import kdruc.chess.Board;
import kdruc.chess.pieceattributes.PieceColor;
import kdruc.chess.pieceattributes.Position;

import java.util.List;

public class Queen extends Piece {

	public Queen(PieceColor pieceColor, Position position) {
		super('Q', pieceColor, position);
	}

	@Override
	public char icon() {
		if (this.pieceColor == PieceColor.WHITE) return '♕';
		return '♛';
	}

	@Override
	public List<Position> getAllPositions(Board board) {
		return null;
	}

}
