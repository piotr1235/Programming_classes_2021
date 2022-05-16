package kdruc.chess.pieceattributes;

import kdruc.chess.Board;

public class Position {
	private final int column;
	private final int row;
	private static Position[][] allPositions = new Position[8][8];

	static {
		for (int i = 0; i < Board.SIZE; i++) {
			for (int j = 0; j < Board.SIZE; j++) {
				allPositions[i][j] = new Position(i, j);
			}
		}
	}


	private Position(int column, int row) {
		this.column = column;
		this.row = row;
	}

	public static Position getPosition(int column, int row) {
		return allPositions[column][row];
	}

	public int column() {
		return column;
	}

	public int row() {
		return row;
	}

	@Override
	public String toString() {
		return "{" + column + "," + row + "}";
	}
}
