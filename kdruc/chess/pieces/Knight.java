package kdruc.chess.pieces;

import kdruc.chess.pieceattributes.PieceColor;
import kdruc.chess.pieceattributes.Position;

public class Knight extends Piece{

		public Knight(PieceColor pieceColor, Position position) {
				super('N', pieceColor, position);
		}

		@Override
		public char icon() {
				if(this.pieceColor == PieceColor.WHITE) return '♘';
				return '♞';
		}
}
