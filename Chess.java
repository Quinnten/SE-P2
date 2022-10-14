import java.util.*;
import java.io.*;

public class Chess {
    public static void main(String[] args) {
	if (args.length != 2) {
	    System.out.println("Usage: java Chess layout moves");
	}
	Piece.registerPiece(new KingFactory());
	Piece.registerPiece(new QueenFactory());
	Piece.registerPiece(new KnightFactory());
	Piece.registerPiece(new BishopFactory());
	Piece.registerPiece(new RookFactory());
	Piece.registerPiece(new PawnFactory());
	Board.theBoard().registerListener(new Logger());
	// args[0] is the layout file name
	// args[1] is the moves file name
	// Put your code to read the layout file and moves files
	// here.
	Board board = Board.theBoard();

	
	LayoutReader layout = new LayoutReader(args[0]);
	MovesReader moves = new MovesReader(args[1]);

	while (layout.hasAnotherLine()) {
		layout.updateLine();
	  if(layout.isValidLine()) {
			String type = layout.getPieceInfo();
			String local = layout.getPieceLocal();
			Piece piece = Piece.createPiece(type);
			board.addPiece(piece, local);
		}
	}
	layout.closeFile();
	
	while (moves.hasAnotherLine()) {
	  moves.updateLine();

	  if(moves.isValidLine()) {
			String from = moves.getInitLocal();
			String to = moves.getFinalLocal();
			board.movePiece(from, to);

		}
	}
	moves.closeFile();

	// Leave the following code at the end of the simulation:
	System.out.println("Final board:");
	Board.theBoard().iterate(new BoardPrinter());
    }
}