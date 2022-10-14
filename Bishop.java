import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { this.addColor(c); }
    // implement appropriate methods

    public String toString() {
	    if (this.color() == Color.WHITE) {
            return ("wb");
        } else {
            return("bb");
        }
    }

    public List<String> moves(Board b, String loc) {
	    ArrayList<String> moves = new ArrayList<>();

        int col = b.convertCol(loc.charAt(0));
        int row = b.convertRow(loc.charAt(1));
        Color color = this.color();


        moves = findUpperRight(moves, row+1, col+1, b, color);
        moves = findUpperLeft(moves, row+1, col-1, b, color);
        moves = findLowerLeft(moves, row-1, col-1, b, color);
        moves = findLowerRight(moves, row-1, col+1, b, color);

        return moves;
    }

    private ArrayList<String> findUpperRight(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (row > 7 || col > 7) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return findUpperRight(moves, row + 1, col + 1, b, color);
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return findUpperRight(moves, row + 1, col + 1, b, color);
        } else {
            return moves;
        }

    }

    private ArrayList<String> findUpperLeft(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (row > 7 || col < 0) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return findUpperLeft(moves, row + 1, col - 1, b, color);
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return findUpperLeft(moves, row + 1, col - 1, b, color);
        } else {
            return moves;
        }
    }

    private ArrayList<String> findLowerLeft(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (row < 0 || col < 0) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return findLowerLeft(moves, row - 1, col - 1, b, color);
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return findLowerLeft(moves, row - 1, col - 1, b, color);
        } else {
            return moves;
        }
    }

    private ArrayList<String> findLowerRight(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (row < 0 || col > 7) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return findLowerRight(moves, row - 1, col + 1, b, color);
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return findLowerRight(moves, row - 1, col + 1, b, color);
        } else {
            return moves;
        }
    }
}