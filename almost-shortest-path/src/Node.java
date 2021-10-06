import java.util.*;
public class Node
{
   private int Id; //unique identifier for nodes
   private ArrayList<Edge> neighborEdges = new ArrayList<Edge>();
   private int distance = Integer.MAX_VALUE;
   private Node prevNode = null;
   
   public void setPrevNode(Node prevNodeCopy)
   {
       this.prevNode = prevNodeCopy;
   }
   
   public Node getPrevNode()
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
   
   public int getDistance()
   {
       return this.distance;
   }
   
   public int getNodeId()
   {
       return this.Id;
   }
   
   public void setNeighbors(Edge newNeighbor)
   {
       this.neighborEdges.add(newNeighbor);
   }
   
   public ArrayList getNeighbors()
   {
       return this.neighborEdges;
   }
}
