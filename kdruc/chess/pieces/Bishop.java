package kdruc.chess.pieces;

import kdruc.chess.pieceattributes.PieceColor;
import kdruc.chess.pieceattributes.Position;

public class Bishop extends Piece {

	public Bishop(PieceColor pieceColor, Position position) {
		super('B', pieceColor, position);
	}

	@Override
	public char icon() {
		if (this.pieceColor == PieceColor.WHITE) return '♗';
		return '♝';
	}
}
