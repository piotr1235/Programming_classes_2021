package kdruc.chess;

import kdruc.chess.pieceattributes.*;
import kdruc.chess.pieces.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kdruc.chess.pieceattributes.Position.getPosition;

public class Board {

	public static final int SIZE = 8;
	private Map<Position, Piece> pieceMap;

	public Board() throws IllegalMoveException {
		this.pieceMap = new HashMap<>();
		setUpBoard();
	}

	private void setUpBoard() throws IllegalMoveException {
		setUpPawns();
		setUpRooks();
		setUpKnights();
		setUpBishops();
		setUpQueens();
		setUpKings();
	}

	private void setUpPawns() throws IllegalMoveException {
		for (int i = 0; i < SIZE; i++) {
			Position whitePosition = getPosition(i, 1);
			Piece whitePawn = new Pawn(PieceColor.WHITE, whitePosition);
			addPiece(whitePawn);

			Position blackPosition = getPosition(i, 6);
			Piece blackPawn = new Pawn(PieceColor.BLACK, blackPosition);
			addPiece(blackPawn);
		}
	}

	private void setUpRooks() throws IllegalMoveException {
		Piece whiteRookLeft = new Rook(PieceColor.WHITE, getPosition(0, 0));
		Piece whiteRookRight = new Rook(PieceColor.WHITE, getPosition(7, 0));
		Piece blackRookLeft = new Rook(PieceColor.BLACK, getPosition(0, 7));
		Piece blackRookRight = new Rook(PieceColor.BLACK, getPosition(7, 7));
		addPiece(whiteRookLeft);
		addPiece(whiteRookRight);
		addPiece(blackRookLeft);
		addPiece(blackRookRight);
	}

	private void setUpKnights() throws IllegalMoveException {
		Piece whiteKnightLeft = new Knight(PieceColor.WHITE, getPosition(1, 0));
		Piece whiteKnightRight = new Knight(PieceColor.WHITE, getPosition(6, 0));
		Piece blackKnightLeft = new Knight(PieceColor.BLACK, getPosition(1, 7));
		Piece blackKnightRight = new Knight(PieceColor.BLACK, getPosition(6, 7));
		addPiece(whiteKnightLeft);
		addPiece(whiteKnightRight);
		addPiece(blackKnightLeft);
		addPiece(blackKnightRight);
	}

	private void setUpBishops() throws IllegalMoveException {
		Piece whiteBishopLeft = new Bishop(PieceColor.WHITE, getPosition(2, 0));
		Piece whiteBishopRight = new Bishop(PieceColor.WHITE, getPosition(5, 0));
		Piece blackBishopLeft = new Bishop(PieceColor.BLACK, getPosition(2, 7));
		Piece blackBishopRight = new Bishop(PieceColor.BLACK, getPosition(5, 7));
		addPiece(whiteBishopLeft);
		addPiece(whiteBishopRight);
		addPiece(blackBishopLeft);
		addPiece(blackBishopRight);
	}

	private void setUpQueens() throws IllegalMoveException {
		Piece whiteQueen = new Queen(PieceColor.WHITE, getPosition(3, 0));
		Piece blackQueen = new Queen(PieceColor.BLACK, getPosition(3, 7));
		addPiece(whiteQueen);
		addPiece(blackQueen);
	}

	private void setUpKings() throws IllegalMoveException {
		Piece whiteKing = new King(PieceColor.WHITE, getPosition(4, 0));
		Piece blackKing = new King(PieceColor.BLACK, getPosition(4, 7));
		addPiece(whiteKing);
		addPiece(blackKing);
	}

	public boolean isOccupied(Position position) {
		return pieceMap.get(position) != null;
	}

	public Piece getPiece(Position position) {
		return pieceMap.get(position);
	}

	public void addPiece(Piece piece) throws IllegalMoveException {
		if (isOccupied(piece.position())) throw new IllegalMoveException();
		pieceMap.put(piece.position(), piece);
	}

	public void removePiece(Piece piece) {
		pieceMap.remove(piece.position());
	}

	public void makeMove(Piece piece, Position finalPosition) throws IllegalMoveException {
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

	public static void main(String[] args) throws IllegalMoveException {
		Board board = new Board();
		System.out.println(board);
	}
}
