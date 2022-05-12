package kdruc.chess.pieceattributes;

public class Position {
		private final int column;
		private final int row;


		public Position(int column, int row) {
				this.column = column;
				this.row = row;
		}

		public int column() {
				return column;
		}

		public int row() {
				return row;
		}

		@Override
		public String toString() {
				return "{" + column + ","+ row + "}";
		}
}
