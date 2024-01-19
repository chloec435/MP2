public class Computer {
  private int computerRow;
  private int computerSticks;
  
  public Computer(Matchsticks m) {
    System.out.println(chooseRow(m));
    System.out.println(takeSticks(m));
  }
  
  public String chooseRow(Matchsticks m) {
    while (true) {
      computerRow = (int)(Math.random() * 6) + 1;
      if (m.totalSticksLeft(computerRow, 0) > 0) {
        return "COMPUTER chooses row " + computerRow + ".";
      }
    }
  }
  
  public String takeSticks(Matchsticks m) {
    while (true) {
      computerSticks = (int)(Math.random() * 3) + 1;
      if (computerSticks <= m.totalSticksLeft(computerRow, 0)) {
        return "COMPUTER takes " + computerSticks + " sticks.";
      }
    }
  }
  
  public int getCompRow() {
    return computerRow;
  }
  
  public int getCompSticks() {
    return computerSticks;
  }
}
