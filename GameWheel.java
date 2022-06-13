import java.util.ArrayList;

public class GameWheel
{
  private ArrayList<Slice> slices; // List of slices making up the wheel
  private int currentPos;   // Position of currently selected slice on wheel
  
  /* COMPLETED METHODS - YOU DO NOT NEED TO CHANGE THESE */

  /* Creates a wheel with 20 preset slices
   */
  public GameWheel()
  {
    this(getStandardPrizes());
  }

  /* Creates a wheel with 20 slices, using values from array parameter
   */
  public GameWheel(int[] prizes)
  {
    currentPos = 0;
    slices = new ArrayList<Slice>();
    for(int i = 0; i < 20; i++)
    {
      int pa = 0;
      String col = "blue";
      if(i < prizes.length)
      {
        pa = prizes[i];
      }
  
      if (i%5 == 0)
      {
        col = "black";
      }
      else if (i%2 == 1)
      {
        col = "red";
      }
        
      slices.add(new Slice(col, pa));
    }
  }

  /* Spins the wheel by so that a different slice is selected. Returns that
   * slice (Note: the 10 slices following the current slice are more likely to
   * be returned than the other 10).
   */
  public Slice spinWheel()
  {
    //spin power between range of 1-50 (inclusive)
    int power = (int)(Math.random()*50 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;
    return slices.get(currentPos);
  }

  public Slice getSlice(int i){
    int sliceNum = i;
    if(i < 0 || i > 19)
      sliceNum = 0;
    return slices.get(sliceNum);
  }

  // Makes an array with a standard list of prizes
  private static int[] getStandardPrizes()
  {
    int[] arr = new int[20];
    for (int i=0; i < 20; i++)
    {
      if (i%5 == 0)
        arr[i] = i*1000;
      else if (i%2 == 1)
        arr[i] = i*100;
      else
        arr[i] = i*200;
    }
    return arr;
  }


  /* Returns string representation of GameWheel with each numbered slice
   * on a new line
   */
  public String toString(){
    String wheelInfo = "";
    for(int i = 0; i<20; i++)
    {
      wheelInfo += i + " - Color: " + slices.get(i).getColor() + ", Prize Amount: $" + slices.get(i).getPrizeAmount();
      
      if(i<19)
      {
        wheelInfo += "\n";
      }
    }
    return wheelInfo;
  }


  /* Randomizes the positions of the slices that are in the wheel, but without
   * changing the pattern of the colors
   */
  public void scramble()
  {
    System.out.println("Before scramble:");
    System.out.println(slices);
    
    ArrayList<Slice> blackSlices = new ArrayList<Slice>();
    ArrayList<Slice> redSlices = new ArrayList<Slice>();
    ArrayList<Slice> blueSlices = new ArrayList<Slice>();
    
    for(int i = 0; i<20; i++) //populate the color ArrayLists from slices ArrayList
    {
      if(i%5 == 0) //black
      {
        blackSlices.add(slices.get(i));
      }
      else if(i%2 == 1) //red
      {
        redSlices.add(slices.get(i));
      }
      else if(i%2 == 0) //blue
      {
        blueSlices.add(slices.get(i));
      }
    }
    
    slices.clear();
    
    for(int k = 0; k<20; k++)
    {
      if(k%5 == 0)
      {
        slices.add(blackSlices.remove((int)(Math.random()*(blackSlices.size()))));
      }
      else if(k%2 == 1)
      {
        slices.add(redSlices.remove((int)(Math.random()*(redSlices.size()))));
      }
      else if(k%2 == 0)
      {
        slices.add(blueSlices.remove((int)(Math.random()*(blueSlices.size()))));
      }
    }
    System.out.println("After scramble:");
    System.out.println(slices);
  }
  
  public static void helperInsertionSort(ArrayList<Slice> elements)
  {
    for(int z = 1; z<elements.size(); z++)
    {
      Slice temp = elements.get(z);
      int possibleIndex = z;
      while(possibleIndex > 0 && temp.getPrizeAmount() < elements.get(possibleIndex - 1).getPrizeAmount())
      {
        elements.set(possibleIndex, elements.get(possibleIndex - 1));
        possibleIndex--;
      }
      elements.set(possibleIndex, temp);
    }
  }
  

  /* Sorts the positions of the slices that are in the wheel by prize amount,
   * but without changing the pattern of the colors.
   */
  public void sort(){
    System.out.println("Before sort:");
    System.out.println(slices);
    
    ArrayList<Slice> blackSlices2 = new ArrayList<Slice>();
    ArrayList<Slice> redSlices2 = new ArrayList<Slice>();
    ArrayList<Slice> blueSlices2 = new ArrayList<Slice>();
    
    for(int i = 0; i<20; i++) //populate the color ArrayLists from slices ArrayList
    {
      if(i%5 == 0) //black
      {
        blackSlices2.add(slices.get(i));
      }
      else if(i%2 == 1) //red
      {
        redSlices2.add(slices.get(i));
      }
      else if(i%2 == 0) //blue
      {
        blueSlices2.add(slices.get(i));
      }
    }
    
    slices.clear();
    helperInsertionSort(blackSlices2);
    helperInsertionSort(redSlices2);
    helperInsertionSort(blueSlices2);
    
    for(int b = 0; b<20; b++) //refill slices ArrayList with sortedd 
    {
      if(b%5 == 0) //black
      {
        slices.add(blackSlices2.remove(0));
      }
      else if(b%2 == 1) //red
      {
        slices.add(redSlices2.remove(0));
      }
      else if(b%2 == 0) //blue
      {
        slices.add(blueSlices2.remove(0));
      }
    }
    System.out.println("After sort:");
    System.out.println(slices);
  }

}
