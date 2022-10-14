import java.util.*;

public class King extends Piece {
    public King(Color c) { this.addColor(c); }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.WHITE) {
            return ("wk");
        } else {
            return("bk");
        }
    }

    public List<String> moves(Board b, String loc) {
	    ArrayList<String> moves = new ArrayList<>();

        int col = b.convertCol(loc.charAt(0));
        int row = b.convertRow(loc.charAt(1));
        Color color = this.color();


        moves = findAdjacent(moves, row + 1, col, b, color);
        moves = findAdjacent(moves, row - 1, col, b, color);
        moves = findAdjacent(moves, row, col + 1, b, color);
        moves = findAdjacent(moves, row, col - 1, b, color);
        moves = findAdjacent(moves, row+1, col+1, b, color);
        moves = findAdjacent(moves, row+1, col-1, b, color);
        moves = findAdjacent(moves, row-1, col-1, b, color);
        moves = findAdjacent(moves, row-1, col+1, b, color);

        return moves;
    }

    private ArrayList<String> findAdjacent(ArrayList<String> moves, int row, int col, Board b, Color color) {
        if (row > 7 || col > 7) {
            return moves;
        } else if (row < 0 || col < 0) {
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)) == null) {
            moves.add(b.toGrid(col, row));
            return moves;
        } else if (b.getPiece(b.toGrid(col, row)).color() != color) {
            moves.add(b.toGrid(col, row));
            return moves;
        } else {
            return moves;
        }
    }
}