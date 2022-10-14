import java.util.*;

public class Board {

    private Piece[][] pieces = new Piece[8][8];
    private ArrayList<BoardListener> listeners = new ArrayList<>();
    private static Board theBoard;
    private Board() { }
    
    public static Board theBoard() {
        if (theBoard == null) {
            theBoard = new Board();
        }
        return theBoard;
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public int convertCol(char c) {
        int col = c - 97;
        if (col < 0 || col > 7) {
            throw new UnsupportedOperationException();
        } else {
            return col;
        }
    }

    public int convertRow(char r) {
        int row = r - 49;
        if (row < 0 || row > 7) {
            throw new UnsupportedOperationException();
        } else {
            return row;
        }
    }

    public boolean isEnemy(Piece p1, Piece p2) {
        if (p1.color() == p2.color()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEmptySqaure(String loc) {
        Piece p = this.getPiece(loc);

        if (p == null) {
            return false;
        } else {
            return true;
        }
    }

    public Piece getPiece(String loc) {

        int col = convertCol(loc.charAt(0));
        int row = convertRow(loc.charAt(1));

	return pieces[col][row];
    }

    public void addPiece(Piece p, String loc) {
	    int col = convertCol(loc.charAt(0));
        int row = convertRow(loc.charAt(1));

        if (pieces[col][row] == null) {
            pieces[col][row] = p;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public String toGrid(int col, int row) {
        char colChar = (char)(col + 'a');
        char rowChar = (char)(row + '1');

        String result = "" + colChar + rowChar;
        return result;
    }

    public void movePiece(String from, String to) {
        Piece p = pieces[convertCol(from.charAt(0))][convertRow(from.charAt(1))];
	    if (p == null) {                                 //Check to see if the loc actually has something to move
           throw new UnsupportedOperationException(); 
        } else if (!isValidMove(p, from, to)) {         //Check if it's possible to move to "to"
            throw new UnsupportedOperationException(); 
        } else {

        if(pieces[convertCol(to.charAt(0))][convertRow(to.charAt(1))] == null) {
            listeners.get(0).onMove(from, to, p);
        } else {
            listeners.get(0).onMove(from, to, p);
            listeners.get(0).onCapture(p, pieces[convertCol(to.charAt(0))][convertRow(to.charAt(1))]);

        }
        pieces[convertCol(to.charAt(0))][convertRow(to.charAt(1))] = p;             //Update both to and from
        pieces[convertCol(from.charAt(0))][convertRow(from.charAt(1))] = null;

        }
    }

    private boolean isValidMove(Piece p, String from, String to) { 
        List<String> moves = p.moves(theBoard, from);
        if (moves.contains(to)) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
	    for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }
        }
    }

    public void registerListener(BoardListener bl) {
	    listeners.add(bl);
    }

    public void removeListener(BoardListener bl) {
        listeners.remove(bl);
    }

    public void removeAllListeners() {
        listeners.clear();
    }

    public void iterate(BoardInternalIterator bi) {
	    for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                bi.visit(toGrid(i, j), getPiece(toGrid(i, j)));
            }
        }
    }
}