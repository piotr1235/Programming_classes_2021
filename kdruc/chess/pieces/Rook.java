package kdruc.chess.pieces;

import kdruc.chess.Board;
import kdruc.chess.pieceattributes.PieceColor;
import kdruc.chess.pieceattributes.Position;

import java.util.List;

public class Rook extends Piece {
	public Rook(PieceColor pieceColor, Position position) {
		super('R', pieceColor, position);
	}

	@Override
	public char icon() {
		if (this.pieceColor == PieceColor.WHITE) return '♖';
		return '♜';
	}

	@Override
	public List<Position> getAllPositions(Board board) {
		return null;
	}

}
