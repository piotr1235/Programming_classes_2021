package kdruc.chess.pieces;

import kdruc.chess.pieceattributes.*;

public class Pawn extends Piece {
	public Pawn(PieceColor pieceColor, Position position) {
		super('P', pieceColor, position);
	}

	@Override
	public char icon() {
		if (this.pieceColor == PieceColor.WHITE) return '♙';
		return '♟';
	}
}
