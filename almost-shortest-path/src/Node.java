import java.util.*;
public class Node
{
   private int Id; //unique identifier for nodes
   private Hashtable<Integer, Integer> neighbors = new Hashtable<>();
   private boolean visited = false;
   private int distance = Integer.MAX_VALUE;
   private int prevNode = Integer.MAX_VALUE;
   
   public void setPrevNode(int value)
   {
       this.prevNode = value;
   }
   
   public int getPrevNode()
   {
       return this.prevNode;
   }
   
   public void setNodeId(int nodeId)
   {
       this.Id = nodeId;
   }
   public void setDistance(int distanceValue)
   {
       this.distance = distanceValue;
   }
   
   public int getNodeId()
   {
       return this.Id;
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
