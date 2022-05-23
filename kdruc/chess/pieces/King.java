package kdruc.chess.pieces;

import kdruc.chess.Board;
import kdruc.chess.pieceattributes.PieceColor;
import kdruc.chess.pieceattributes.Position;

import java.util.List;

public class King extends Piece {
	public King(PieceColor pieceColor, Position position) {
		super('K', pieceColor, position);
	}

	@Override
	public char icon() {
		if (this.pieceColor == PieceColor.WHITE) return '♔';
		return '♚';
	}

	@Override
	public List<Position> getAllPositions(Board board) {
		return null;
	}
}
