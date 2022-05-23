package kdruc.chess;

import kdruc.chess.pieceattributes.*;
import kdruc.chess.pieces.*;

import java.util.*;
import java.util.stream.Collectors;

import static kdruc.chess.pieceattributes.Position.getPosition;

public class Board {

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


	public boolean isOccupied(Position position) {
		return pieceMap.get(position) != null;
	}

	public Piece getPiece(Position position) {
		return pieceMap.get(position);
	}

	public void addPiece(Piece piece) {
		pieceMap.put(piece.position(), piece);
	}

	public void removePiece(Piece piece) {
		pieceMap.remove(piece.position());
	}

	public void makeMove(Piece piece, Position finalPosition) {
		List<Position> positions = piece.getAllPositions(this);
		boolean isPossible = positions.contains(finalPosition);
		if (isPossible) {
			removePiece(piece);
			piece.moveTo(finalPosition);
			addPiece(piece);
		}

	}

	private static final String emptyBoard =
					" ╔═╤═╤═╤═╤═╤═╤═╤═╗\n"
									+ "8║ │░│ │░│ │░│ │░║\n"
									+ " ╟─┼─┼─┼─┼─┼─┼─┼─╢\n"
									+ "7║░│ │░│ │░│ │░│ ║\n"
									+ " ╟─┼─┼─┼─┼─┼─┼─┼─╢\n"
									+ "6║ │░│ │░│ │░│ │░║\n"
									+ " ╟─┼─┼─┼─┼─┼─┼─┼─╢\n"
									+ "5║░│ │░│ │░│ │░│ ║\n"
									+ " ╟─┼─┼─┼─┼─┼─┼─┼─╢\n"
									+ "4║ │░│ │░│ │░│ │░║\n"
									+ " ╟─┼─┼─┼─┼─┼─┼─┼─╢\n"
									+ "3║░│ │░│ │░│ │░│ ║\n"
									+ " ╟─┼─┼─┼─┼─┼─┼─┼─╢\n"
									+ "2║ │░│ │░│ │░│ │░║\n"
									+ " ╟─┼─┼─┼─┼─┼─┼─┼─╢\n"
									+ "1║░│ │░│ │░│ │░│ ║\n"
									+ " ╚═╧═╧═╧═╧═╧═╧═╧═╝\n"
									+ "  a b c d e f g h";


	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(emptyBoard);
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {

				Piece piece = getPiece(getPosition(column, row));
				int a8 = 21;
				int boardWith = 38;
				int id = (SIZE - 1 - row) * boardWith + column * 2 + a8;

				if (piece != null) s.setCharAt(id, piece.icon());


			}
		}


		return s.toString();
	}

	public static void main(String[] args) {

		Board board = new Board();

		System.out.println(board);


	}
}
