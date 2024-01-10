public class Game{
  private Matchsticks matchsticks;
  private User user;
  private Computer computer;
  private int numSticks = 21;
  private int row;
  private int sticks;
  public Game() {
    instructions();
    play();
  }
  public static void instructions() {
    System.out.println("Welcome to the game of 21 Matchsticks!");
    System.out.println("You will be playing against the computer.");
    System.out.println("The game starts with 21 matchsticks, separated into 6 rows.");
    System.out.println("Depending on how many sticks are in each row, you and the computer will take turns picking up 1, 2, or 3 matchsticks.");
    System.out.println("The player who picks up the last matchstick loses.");
    System.out.println();
    System.out.println("Let's begin!");
  }
  public void play() {
    matchsticks = new Matchsticks();
    matchsticks.layoutMatchsticks(6, 0);
    while (numSticks > 0) {
      userTurn(matchsticks);
      numSticks -= sticks;
      System.out.println("There are " + numSticks + " matchsticks left.");
      if (numSticks == 0) {
        System.out.println("You lose!");
        break;
      }
      System.out.println("\nIt is now COMPUTER's turn.\n");
      computerTurn(matchsticks);
      numSticks -= sticks;
      System.out.println("There are " + numSticks + " matchsticks left.");
      if (numSticks == 0) {
        System.out.println("You win!");
        break;
      }
    }
  }
  public void userTurn(Matchsticks m) {
    user = new User(m);
    row = user.getUserRow();
    sticks = user.getUserSticks();
    matchsticks.layoutMatchsticks(row, sticks);
  }
  public void computerTurn(Matchsticks m) {
    computer = new Computer(m);
    row = computer.getCompRow();
    sticks = computer.getCompSticks();
    matchsticks.layoutMatchsticks(row, sticks);
  }
}
