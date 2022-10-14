import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) { this.addColor(c); }
    // implement appropriate methods

    public String toString() {
	    if (this.color() == Color.WHITE) {
            return ("wp");
        } else {
            return("bp");
        }
    }

    public List<String> moves(Board b, String loc) {
        ArrayList<String> moves = new ArrayList<>();

        int col = b.convertCol(loc.charAt(0));
        int row = b.convertRow(loc.charAt(1));
        Color color = this.color();

        if (color == Color.WHITE) {
            if (row == 7) {
                return moves;
            }

            if (b.getPiece(b.toGrid(col, row+1)) == null) {
                moves.add(b.toGrid(col, row+1));

                if (row == 1 && b.getPiece(b.toGrid(col, row+2)) == null) {
                    moves.add(b.toGrid(col, row+2));
                }
            }

            if (col - 1 >= 0 && b.getPiece(b.toGrid(col-1, row+1)) != null) {  //check to see if I can capture left
                Piece p2 = b.getPiece(b.toGrid(col-1, row+1));
                if (p2.color() != color) {
                moves.add(b.toGrid(col-1, row+1));
                }
            }

            if (col + 1 <= 7 && b.getPiece(b.toGrid(col+1, row+1)) != null) { //check to see if I can capture right
                Piece p2 = b.getPiece(b.toGrid(col+1, row+1));
                if (p2.color() != color) {
                    moves.add(b.toGrid(col+1, row+1));
                }
            }
        } else {
            if (row == 0) {
                return moves;
            }
            if (b.getPiece(b.toGrid(col, row-1)) == null) {
                moves.add(b.toGrid(col, row-1));
                
                if (row == 6 && b.getPiece(b.toGrid(col, row-2)) == null) {
                    moves.add(b.toGrid(col, row-2));
                }
            }
            if (col-1 >= 0 && b.getPiece(b.toGrid(col-1, row-1)) != null) {   //check to see if I can capture left            
                Piece p2 = b.getPiece(b.toGrid(col-1, row-1));
                if (p2.color() != color) {
                    moves.add(b.toGrid(col-1, row-1));
                }
            }
            if (col + 1 <= 7 && b.getPiece(b.toGrid(col+1, row-1)) != null) {  //check to see if I can capture right
                Piece p2 = b.getPiece(b.toGrid(col+1, row-1));
                if (p2.color() != color) {
                    moves.add(b.toGrid(col+1, row-1));
                }   
            }
        }

        return moves;
    }
}
