import java.util.*;
import java.io.*;

public class MovesReader {
  private static Scanner reader;
  private static String data = null;

  public MovesReader(String fileName) {
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

 

  private static char getCol(int index) {
    if ((data.charAt(index) < 97) || (data.charAt(index) > 104)) {
      throw new UnsupportedOperationException();
    } else {
      return data.charAt(index);
    }
  }

  private static char getRow(int index) {
    if ((data.charAt(index) < 49) || (data.charAt(index) > 56)) {
      throw new UnsupportedOperationException();
    } else {
      return data.charAt(index);
    }
  }

  public static String getInitLocal() {
    if (isValidLine()) {
        return "" + getCol(0) + getRow(1);
      } else {
        throw new UnsupportedOperationException();
      }
  }

  public static String getFinalLocal() {
    if (isValidLine()) {
        return "" + getCol(3) + getRow(4);
      } else {
        throw new UnsupportedOperationException();
      }
  }

  public static boolean isValidLine() {
    if (data.isEmpty() || data.charAt(0) == '#') {
      return false;
    } else if (data.length() != 5 || data.charAt(2) != '-') {
      throw new UnsupportedOperationException();
    } else {
      return true;
    }
  }

  public static void closeFile() {
    reader.close();
  }

}