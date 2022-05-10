package kdruc.chess.pieces;

import kdruc.chess.pieceattributes.PieceColor;
import kdruc.chess.pieceattributes.Position;

public class King extends Piece{
		public King(PieceColor pieceColor, Position position) {
				super('K', pieceColor, position);
		}

		@Override
		public char icon() {
				if(this.pieceColor == PieceColor.WHITE) return '♔';
				return '♚';
		}
}
