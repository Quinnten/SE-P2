import java.util.*;

abstract public class Piece {
    private Color color;
    private static HashMap<Character, PieceFactory> pieces = new HashMap<>();

    public static void registerPiece(PieceFactory pf) {
        if (!pieces.containsKey(pf.symbol())) {
            pieces.put(pf.symbol(), pf);
        }
    }

    public static Piece createPiece(String name) {
	    if (pieces.containsKey(name.charAt(1))) {
            Color peiceColor;
            if (name.charAt(0) == 'w') {
                peiceColor = Color.WHITE;
            } else {
                peiceColor = Color.BLACK;
            }
            return pieces.get(name.charAt(1)).create(peiceColor);
        
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public Color color() {
        return color;
    }

    public void addColor(Color c) {
        color = c;
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}
