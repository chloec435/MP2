import java.util.Arrays;
public class Matchsticks {
  // private User user;
  // private Computer computer;
  // private int numSticks = 21;
  final private static int maxSticks = 3;
  final private static int maxRow = 6;
  private int row[];
  private int[] row1 = {0, 0, 0, 0, 0, 0, 1};
  private int[] row2 = {0, 0, 0, 0, 0, 1, 0, 1};
  private int[] row3 = {0, 0, 0, 0, 1, 0, 1, 0, 1};
  private int[] row4 = {0, 0, 0, 1, 0, 1, 0, 1, 0, 1};
  private int[] row5 = {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
  private int[] row6 = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
  public void layoutMatchsticks(int row, int sticks) {
    this.row = rowNum(row, sticks);
    if (row == 1) System.out.println("Row 1: " + toString(this.row));
    else System.out.println("Row 1: " + toString(row1));
    if (row == 2) System.out.println("Row 2: " + toString(this.row));
    else System.out.println("Row 2: " + toString(row2));
    if (row == 3) System.out.println("Row 3: " + toString(this.row));
    else System.out.println("Row 3: " + toString(row3));
    if (row == 4) System.out.println("Row 4: " + toString(this.row));
    else System.out.println("Row 4: " + toString(row4));
    if (row == 5) System.out.println("Row 5: " + toString(this.row));
    else System.out.println("Row 5: " + toString(row5));
    if (row == 6) System.out.println("Row 6: " + toString(this.row));
    else System.out.println("Row 6: " + toString(row6));
  }
  public int[] removeSticks(int[] row, int sticks) {
    int i = 0;
    for (int s = 1; s <= sticks; s++) {
      while (row[i] == 0 && i < row.length-1) {
        i++;
      }
      row[i] = 0;
    }
    return row;
  }
  public int[] rowNum(int row, int sticks) {
    if (row == 1) {
      return removeSticks(row1, sticks);
    }
    else if (row == 2) {
      return removeSticks(row2, sticks);
    }
    else if (row == 3) {
      return removeSticks(row3, sticks);
    }
    else if (row == 4) {
      return removeSticks(row4, sticks);
    }
    else if (row == 5) {
      return removeSticks(row5, sticks);
    }
    else if (row == 6) {
      return removeSticks(row6, sticks);
    }
  return null;
  }
  public static int getMaxRow() {
    return maxRow;
  }
  public static int getMaxSticks() {
    return maxSticks;
  }
  public int maxSticks(int row, int sticks) {
    for (int i = 0; i < rowNum(row, sticks).length; i++) {
      if (rowNum(row, sticks)[i] == 1) {
        sticks++;
      }
    }
    return sticks;
  }
  public String toString(int[] arr) {
    String layout = "";
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] == 1) {
        layout += "|";
      } else {
        layout += " ";
      }
    }
    return layout;
  }
}
