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
   public void removeNeighbor(Edge removeNeighbor)
   {
       this.neighborEdges.remove(removeNeighbor);
    }
    public void sortNeighbors(ArrayList<Edge> edgeList) 
    {
        Edge edge1 = null;
        Edge edge2 = null;
        Edge ascendingEdge = null;
        int index;
        for (int i = 0; i < edgeList.size() - 1; i++)
        {
            edge1 = edgeList.get(i);
            
            for (int j = i + 1; j < edgeList.size(); j++)
            {
                 edge2 = edgeList.get(j);   
                 if (edgeList.get(i).getLength() > edgeList.get(j).getLength()) //switching positions
                 {
                      index = j;
                      ascendingEdge = edgeList.get(index);
                      edgeList.set(index, edgeList.get(i));
                      edgeList.set(i, ascendingEdge);
                 }

            }
        }
        this.neighborEdges = edgeList; // save sorted list
    }
   
   public ArrayList getNeighbors()
   {
       return this.neighborEdges;
   }
}
