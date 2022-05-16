package kdruc.chess;

import kdruc.chess.pieceattributes.*;
import kdruc.chess.pieces.*;

import java.util.HashMap;
import java.util.Map;

import static kdruc.chess.pieceattributes.Position.getPosition;

public class Board {

	public static final int SIZE = 8;
	private Map<Position, Piece> pieceMap;

	public Board() {
		this.pieceMap = new HashMap<>();
		setUpBoard();
	}

	private void setUpBoard() {
		Position position = getPosition(0, 0);
		pieceMap.put(position, new Rook(PieceColor.BLACK, position));
		Position position1 = getPosition(2, 0);
		pieceMap.put(position1, new Queen(PieceColor.WHITE, position1));
	}

	public boolean isOccupied(Position position) {
		return pieceMap.get(position) != null;
	}

	@Override
	public String toString() {
		String s = "";
		for (Piece piece : pieceMap.values()) {
			s += piece.icon() + "" + piece.position() + "\n";

		}
		return s;
	}

	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board);
	}
}
