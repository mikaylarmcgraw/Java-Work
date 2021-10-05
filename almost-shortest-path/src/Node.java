import java.util.*;
public class Node
{
   private int value; //node id here instead
   private Hashtable<Integer, Integer> neighbors = new Hashtable<>();
   private boolean visited = false;
   private int distance = Integer.MAX_VALUE;
   public void setNodeValue(int nodeValue)
   {
       this.value = nodeValue;
   }
   public void setDistance(int distanceValue)
   {
       this.distance = distanceValue;
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
