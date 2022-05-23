package kdruc.chess.pieces;

import kdruc.chess.Board;
import kdruc.chess.pieceattributes.PieceColor;
import kdruc.chess.pieceattributes.Position;

import java.util.ArrayList;
import java.util.List;

import static kdruc.chess.pieceattributes.Position.getPosition;

public class Pawn extends Piece {
	private boolean firstMove = true;

	public Pawn(PieceColor pieceColor, Position position) {
		super('P', pieceColor, position);
	}

	@Override
	public char icon() {
		if (this.pieceColor == PieceColor.WHITE) return '♙';
		return '♟';
	}

	@Override
	public List<Position> getAllPositions(Board board) {
		List<Position> positions = new ArrayList<>();
		int column = this.position().column();
		int row = this.position().row();
		int direction = this.color() == PieceColor.WHITE ? 1 : -1;


		Position newPosition1 = getPosition(column, row + direction);
		if (!board.isOccupied(newPosition1)) {
			positions.add(newPosition1);
		}

		Position newPosition2 = getPosition(column, row + (direction * 2));
		if (firstMove && !board.isOccupied(newPosition2)) {
			positions.add(newPosition2);
		}
		Position targetR = getPosition(column + 1, row + direction); // right kill
		Position targetL = getPosition(column - 1, row + direction); // Left kill
		if (this.canCapture(targetR, board)) {
			positions.add(targetR);
		}
		if (this.canCapture(targetL, board)) {
			positions.add(targetL);
		}

		return positions;
	}
}
