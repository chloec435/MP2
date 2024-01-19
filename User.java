import java.util.Scanner;
import java.util.InputMismatchException;
public class User {
  private int userSticks;
  private int userRow;
  private int sticksLeft;
  
  public User(Matchsticks matchsticks) {
    rowAsk();
    sticksLeft = matchsticks.totalSticksLeft(userRow, userSticks);
    stickAsk(matchsticks);
  }
  
  public void rowAsk() {
    userRow = 0;
    while (userRow < 1 || userRow > Matchsticks.getMaxRow()) {
      System.out.println("\nWhat row would you like to remove from?");
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
    userSticks = -1;
    while (userSticks < 0 || userSticks > Matchsticks.getMaxSticks()) {
      System.out.println("How many sticks would you like to remove?");
      boolean success = false;
      while (!success) {
        try {
          Scanner input = new Scanner(System.in);
          userSticks = input.nextInt();
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
          responseToErr();
          stickAsk(m);
        }
        
        if (userSticks >= Integer.MIN_VALUE) {
          if (userSticks > -1 && userSticks <= Matchsticks.getMaxSticks()) {
            success = true;
            if (userSticks <= sticksLeft) {
              success = true;
            } else {
              if (sticksLeft < userSticks) {
                cannotTakeSticks(m);
              } else {
                responseToErr();
              }
            }
          }
          if (userSticks < 0 || userSticks > Matchsticks.getMaxSticks()) {
            responseToErr();
          }
        }
      }
    }
  }
  
  private void cannotTakeSticks(Matchsticks m) {
    if (sticksLeft == 0) {
      System.out.println("There are no sticks left in this row. Please try a different row.");
    } else {
      System.out.println("You can't take that many sticks. Please try again.");
    }
    System.out.println();
    m.layoutMatchsticks(6, 0);
    rowAsk();
    sticksLeft = m.totalSticksLeft(userRow, 0);
    stickAsk(m);
  }
  
  private void responseToErr() {
    System.out.println("Invalid number of sticks. Please try again. \nThe max number of sticks you can remove from each row is 3, with the exception of row 1 and row 2, which can only remove a max of 1 and 2 sticks respectively.");
    System.out.println();
  }
  
  public int getUserRow() {
    return userRow;
  }
  
  public int getUserSticks() {
    return userSticks;
  }
}
