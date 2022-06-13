import java.util.ArrayList;

public class Game
{
  public static void play(GameWheel g)
  {
    
    Slice fi = g.spinWheel(); //generates a random slice
    Slice se = g.spinWheel();
    Slice th = g.spinWheel();
    
    int total = fi.getPrizeAmount() + se.getPrizeAmount() + th.getPrizeAmount(); //sum of values
    
    //printing calculated info
    if(fi.getColor().equals(se.getColor()) && fi.getColor().equals(th.getColor()))
    {
      total*=2;
      System.out.println("Total prize money: $" + total);
      System.out.println();
      System.out.println("Spin 1 - Color: " + fi.getColor() + ", Prize Amount: $" + fi.getPrizeAmount());
      System.out.println("Spin 2 - Color: " + se.getColor() + ", Prize Amount: $" + se.getPrizeAmount());
      System.out.println("Spin 3 - Color: " + th.getColor() + ", Prize Amount: $" + th.getPrizeAmount());
      System.out.println("Three " + fi.getColor() + "s = double your money!");
    }
    else
    {
      System.out.println("Total prize money: $" + total);
      System.out.println();
      System.out.println("Spin 1 - Color: " + fi.getColor() + ", Prize Amount: $" + fi.getPrizeAmount());
      System.out.println("Spin 2 - Color: " + se.getColor() + ", Prize Amount: $" + se.getPrizeAmount());
      System.out.println("Spin 3 - Color: " + th.getColor() + ", Prize Amount: $" + th.getPrizeAmount());
    }
  }
}