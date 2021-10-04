import java.util.*;
public class Node
{
   private static int value;
   private static Hashtable<Integer, Integer> neighbors = new Hashtable<>();
   
   public void setNodeValue(int nodeValue)
   {
       value = nodeValue;
   }
   
   public int getNodeValue()
   {
       return value;
   }
   
   public void setNeighbors(int value, int distance)
   {
       neighbors.put(value, distance);
   }
   
   public Hashtable getNeighbors()
   {
       return neighbors;
   }
}
