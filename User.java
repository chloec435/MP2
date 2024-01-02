import java.util.Scanner;
import java.util.InputMismatchException;
public class User {
  private int userSticks;
  private int userRow;
  public User(Matchsticks matchsticks) {
    rowAsk();
    stickAsk(matchsticks);
  }
  public void rowAsk() {
    while (userRow < 1 || userRow > Matchsticks.getMaxRow()) {
      System.out.println("What row would you like to remove from?");
      boolean success = false;
      while (!success) {
        try {
          Scanner input = new Scanner(System.in);
          userRow = input.nextInt();
          success = true;
        } catch (Exception InputMismatchException) {
          System.out.println("Invalid row. Please enter an integer.");
        }
      }
      if (userRow < 1 || userRow > Matchsticks.getMaxRow()) {
        System.out.println("Invalid row. Please try again.");
      } else {
        break;
      }
    }
  }
  public void stickAsk(Matchsticks m) {
    while (userSticks < 1 || userSticks > Matchsticks.getMaxSticks()) {
      System.out.println("How many sticks would you like to remove?");
      boolean success = false;
      while (!success) {
        Scanner input = new Scanner(System.in);
        userSticks = input.nextInt();
        try {
        } catch (InputMismatchException i) {
          responseToErr();
        }
        try {
        } catch (ArrayIndexOutOfBoundsException a) {
          responseToErr();
        }
        if (userSticks > 0 && userSticks <= Matchsticks.getMaxSticks()) {
          if (userSticks <= m.maxSticks(userRow, userSticks)) {
            success = true;
          } else {
            cannotTakeSticks(m);
          }
        } else {
          responseToErr();
        }
      }
      if (userSticks < 1 || userSticks > Matchsticks.getMaxSticks()) {
        responseToErr();
      } else {
        break;
      }
    }
  }
  private void cannotTakeSticks(Matchsticks m) {
    if (m.maxSticks(userRow, userSticks) < userSticks) {
      if (m.maxSticks(userRow, userSticks) == 0) {
        System.out.println("There are no sticks left in this row. Please try a different row.");
      } else {
        System.out.println("You can't take that many sticks. Please try again.");
      }
      stickAsk(m);
    }
  }
  private void responseToErr() {
    System.out.println("Invalid number of sticks. Please try again. \nThe max number of sticks you can remove from each row is 3, with the exception of rows 1 and 2, which can only remove 1 or 2 sticks, respectively.");
  }
  public int getUserRow() {
    return userRow;
  }
  public int getUserSticks() {
    return userSticks;
  }
}
