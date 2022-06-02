package kdruc.chess.pieces;

import kdruc.chess.Board;
import kdruc.chess.pieceattributes.PieceColor;
import kdruc.chess.pieceattributes.Position;

import java.util.ArrayList;
import java.util.List;

import static kdruc.chess.pieceattributes.Position.getPosition;

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
		List<Position> positions = new ArrayList<>();
		int column = this.position().column();
		int row = this.position().row();
		for (int i = 0; i < Board.SIZE; i++) {
			Position target1 = getPosition(column, i);
			Position target2 = getPosition(i, row);
			positions.add(target1);
			positions.add(target2);
		}

		return positions;
	}

}
