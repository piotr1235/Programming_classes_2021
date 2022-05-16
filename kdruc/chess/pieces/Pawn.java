package kdruc.chess.pieces;

import kdruc.chess.Board;
import kdruc.chess.pieceattributes.*;

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
	public List<Position> getAllPositions() {
		List<Position> positions = new ArrayList<>();
		int column = this.position().column();
		int row = this.position().row();
		int direction = this.color() == PieceColor.WHITE ? 1 : -1;

		Board board = Board.getBoard();
		Position newPosition1 = getPosition(column, row + direction);
		if (!board.isOccupied(newPosition1)) {
			positions.add(newPosition1);
		}

		Position newPosition2 = getPosition(column, row+ (direction * 2));
		if (firstMove && !board.isOccupied(newPosition2)) {
			positions.add(newPosition2);
		}
		Position target = getPosition(column,row);
		if(this.canCapture()){

		}




		return positions;
	}
}
