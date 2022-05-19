package kdruc.chess;

import kdruc.chess.pieceattributes.*;
import kdruc.chess.pieces.*;

import java.util.HashMap;
import java.util.Map;

import static kdruc.chess.pieceattributes.Position.getPosition;

public class Board {

	private static final Board board = new Board();
	public static final int SIZE = 8;
	private Map<Position, Piece> pieceMap;

	public Board() {
		this.pieceMap = new HashMap<>();
		setUpBoard();
	}

	private void setUpBoard() {
		setUpPawns();
	}

	private void setUpPawns() {
		for (int i = 0; i < SIZE; i++) {
			Position whitePosition = getPosition(i, 1);
			Piece whitePawn = new Pawn(PieceColor.WHITE, whitePosition);
			addPiece(whitePawn);

			Position blackPosition = getPosition(i, 6);
			Piece blackPawn = new Pawn(PieceColor.BLACK, blackPosition);
			addPiece(blackPawn);
		}
	}

	public static Board getBoard() {
		return board;
	}

	public boolean isOccupied(Position position) {
		return pieceMap.get(position) != null;
	}

	public Piece getPiece(Position position) {
		return pieceMap.get(position);
	}

	public void addPiece(Piece piece) {
		pieceMap.put(piece.position(), piece);
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
