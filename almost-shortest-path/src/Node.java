import java.util.*;
public class Node
{
   private int value;
   private Hashtable<Integer, Integer> neighbors = new Hashtable<>();
    
   public void setNodeValue(int nodeValue)
   {
       this.value = nodeValue;
   }
   
   public int getNodeValue()
   {
       return this.value;
   }
   
   public void setNeighbors(int value, int distance)
   {
       this.neighbors.put(value, distance);
   }
   
   public Hashtable getNeighbors()
   {
       return this.neighbors;
   }
}
