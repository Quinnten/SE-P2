import java.util.*;
import java.io.*;

public class LayoutReader {
  private static Scanner reader;
  private static String data = null;

  public LayoutReader(String fileName) {
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      reader = scanner;
    } catch (FileNotFoundException e) {
      return;
    }

  }
  public static boolean hasAnotherLine() {
    return reader.hasNextLine();
  }

  public static String getLine() {
    return data;
  }

  public static Boolean updateLine() {
      if (reader.hasNextLine()) {
        data = reader.nextLine();
        return true;
      } else {
        return false;
      }
  }

  private static char getPieceType() {
    if ((data.charAt(4) != 'p') && (data.charAt(4) != 'b') && (data.charAt(4) != 'r') && (data.charAt(4) != 'n') && (data.charAt(4) != 'q') && (data.charAt(4) != 'k')) {
      throw new UnsupportedOperationException();
    }
    return (data.charAt(4));
  }

  private static char getPieceColor() {
    if((data.charAt(3) == 'w') || (data.charAt(3) == 'b')) {
      return (data.charAt(3));
    } else {
      throw new UnsupportedOperationException();
    }
    
  }

  public static String getPieceInfo() {
      if (isValidLine()) {
        return "" + getPieceColor() + getPieceType();
      } else {
        throw new UnsupportedOperationException();
      }
    }

  public static String getPieceLocal() {
    if (isValidLine()) {
      return "" + getPieceCol() + getPieceRow();
    } else {
      throw new UnsupportedOperationException();
    }
  }

  private static char getPieceCol() {
    if ((data.charAt(0) < 97) || (data.charAt(0) > 104)) {
      throw new UnsupportedOperationException();
    } else {
      return data.charAt(0);
    }
  }

  private static char getPieceRow() {
    if ((data.charAt(1) < 49) || (data.charAt(1) > 56)) {
      throw new UnsupportedOperationException();
    } else {
      return data.charAt(1);
    }
  }

  public static boolean isValidLine() {
    if (data.isEmpty() || data.charAt(0) == '#') {
      return false;
    } else if (data.length() != 5 || data.charAt(2) != '=') {
      throw new UnsupportedOperationException();
    } else {
      return true;
    }
  }

  public static void closeFile() {
    reader.close();
  }

}