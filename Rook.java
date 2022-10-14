import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) { this.addColor(c); }
    // implement appropriate methods

    public String toString() {
	    if (this.color() == Color.WHITE) {
            return ("wr");
        } else {
            return("br");
        }
    }

    public List<String> moves(Board b, String loc) {
        ArrayList<String> moves = new ArrayList<>();

        int col = b.convertCol(loc.charAt(0));
        int row = b.convertRow(loc.charAt(1));
        Color color = this.color();

        moves = findUp(moves, row + 1, col, b, color);
        moves = findDown(moves, row - 1, col, b, color);
        moves = findRight(moves, row, col + 1, b, color);
        moves = findLeft(moves, row, col - 1, b, color);

        return moves;
    }

    private ArrayList<String> findUp(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (row > 7) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return findUp(moves, row + 1, col, b, color);
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return findUp(moves, row + 1, col, b, color);
        } else {
            return moves;
        }
    }

    private ArrayList<String> findDown(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (row < 0) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return findDown(moves, row - 1, col, b, color);
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return findDown(moves, row - 1, col, b, color);
        } else {
            return moves;
        }
    }

    private ArrayList<String> findLeft(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (col < 0) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return findLeft(moves, row, col - 1, b, color);
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return findLeft(moves, row, col - 1, b, color);
        } else {
            return moves;
        }
    }

    private ArrayList<String> findRight(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (col > 7) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return findRight(moves, row, col + 1, b, color);
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return findRight(moves, row, col + 1, b, color);
        } else {
            return moves;
        }
    }

}