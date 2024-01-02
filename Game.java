public class Game{
  private Matchsticks matchsticks = new Matchsticks();
  private User user;
  private Computer computer;
  private int numSticks = 21;
  private int row;
  private int sticks;
  public Game() {
    instructions();
    startingLayout();
    System.out.println();
    play();
  }
  public void instructions() {
    System.out.println("Welcome to the game of 21 Matchsticks!");
    System.out.println("You will be playing against the computer.");
    System.out.println("The game starts with 21 matchsticks, separated into 6 rows.");
    System.out.println("Depending on how many sticks are in each row, you and the computer will take turns picking up 1, 2, or 3 matchsticks.");
    System.out.println("The player who picks up the last matchstick loses.");
    System.out.println("Let's begin!");
    System.out.println();
  }
  public void startingLayout() {
    String[] layout = {"Row 1:      |", 
                       "Row 2:     | |", 
                       "Row 3:    | | |", 
                       "Row 4:   | | | |", 
                       "Row 5:  | | | | |", 
                       "Row 6: | | | | | |"};
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < layout.length; i++) {
      sb.append(layout[i]);
      if (i < layout.length - 1) {
        sb.append("\n");
      }
    }
    System.out.println(sb.toString());
  }
  public void play() {
    while (numSticks > 0) {
      userTurn();
      numSticks -= sticks;
      if (numSticks == 0) {
        System.out.println("You lose!");
        break;
      }
      matchsticks.layoutMatchsticks(row, sticks);
      // computerTurn();
      // numSticks -= sticks;
      // if (numSticks == 0) {
      //   System.out.println("You win!");
      //   break;
      // }
      // matchsticks.layoutMatchsticks(row, sticks);
    }
  }
  public void userTurn() {
    user = new User(matchsticks);
    row = user.getUserRow();
    sticks = user.getUserSticks();
  }
  public void computerTurn() {
    computer = new Computer();
    row = computer.getCompRow();
    sticks = computer.getCompSticks();
  }
}
