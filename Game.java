import java.util.Scanner;
public class Game{
  private Matchsticks matchsticks;
  private User user;
  private Computer computer;
  private int numSticks = 21;
  private int row;
  private int sticks;
  private int gameMode;
  private String playerOne;
  private String playerTwo;
  
  public Game() {
    instructions();
    askPlayer();
    play();
  }
  
  public static void instructions() {
    System.out.println("|||      |||        |        |||||||||||     |||||||     |||      |||   ||||||||   |||||||||||  |||     |||||||     |||   |||   |||||||| ");
    System.out.println("||||    ||||       |||       |||||||||||   ||||    |||   |||      |||  |||    |||  |||||||||||  |||   ||||    |||   |||  |||   |||    |||");
    System.out.println("|||||  |||||      || ||          |||      ||||      |||  |||      |||  |||             |||      |||  ||||      |||  ||| |||    |||       ");
    System.out.println("||||||||||||     ||| |||         |||      ||||           ||||||||||||   ||||||||       |||      |||  ||||           ||||||      |||||||| ");
    System.out.println("|||| || ||||    |||||||||        |||      ||||      |||  |||      |||         |||      |||      |||  ||||      |||  ||| |||           |||");
    System.out.println("||||    ||||   ||||   ||||       |||       ||||    |||   |||      |||  |||    |||      |||      |||   ||||    |||   |||  |||   |||    |||");
    System.out.println("||||    ||||  ||||     ||||      |||         |||||||     |||      |||   ||||||||       |||      |||     |||||||     |||   |||   |||||||| ");
    System.out.println();
    System.out.println("Welcome to the game of 21 Matchsticks!");
    System.out.println("The game starts with 21 matchsticks, separated into 6 rows.");
    System.out.println("Depending on how many sticks are in each row, each player will take turns picking up 1, 2, or 3 matchsticks.");
    System.out.println("The player who picks up the last matchstick loses.");
    System.out.println("Let's begin!");
    System.out.println();
  }
  
  public void askPlayer() {
    System.out.println("Would you like to play against a computer (type \"1\") or another player (type \"2\")?");
    Scanner input = new Scanner(System.in);
    gameMode = input.nextInt();
    Scanner player = new Scanner(System.in);
    if (gameMode == 1) {
      System.out.println("What is your name?");
      playerOne = player.nextLine();
    } else if (gameMode == 2) {
      System.out.println("What is player one's name?");
      playerOne = player.nextLine();
      System.out.println("What is player two's name?");
      playerTwo = player.nextLine();
    } else {
      System.out.println("Invalid input. Please try again.");
      askPlayer();
    }
  }
  
  public void play() {
    matchsticks = new Matchsticks();
    matchsticks.layoutMatchsticks(6, 0);
    while (numSticks > 0) {
      System.out.println("\nIt is now " + playerOne.toUpperCase() + "'s turn.");
      userTurn(matchsticks);
      numSticks -= sticks;
      if (numSticks == 0) {
        if (gameMode == 1) {
          System.out.println("\nCOMPUTER wins!");
        } else {
          System.out.println("\n" + playerTwo.toUpperCase() + " wins!");
        }
        break;
      }
      if (gameMode == 2) {
        System.out.println("\nIt is now " + playerTwo.toUpperCase() + "'s turn.");
        userTurn(matchsticks);
        numSticks -= sticks;
        if (numSticks == 0) {
          System.out.println("\n" + playerOne.toUpperCase() + " wins!");
          break;
        }
      } else {
        System.out.println("\nIt is now COMPUTER's turn.\n");
        computerTurn(matchsticks);
        numSticks -= sticks;
        if (numSticks == 0) {
          System.out.println("\n" + playerOne.toUpperCase() + " wins!");
          break;
        }
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
