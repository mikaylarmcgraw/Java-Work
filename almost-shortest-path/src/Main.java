import java.util.Scanner;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
class Edge
{
    private int srcNodeId;
    private int endNodeId;
    private int length;
    
    public void setSrcNode(int NodeId)
    {
        this.srcNodeId = NodeId;
    }
    
    public int getSrcNode()
    {
        return this.srcNodeId;
    }
    
        public void setLength(int lengthInfo)
    {
        this.length= lengthInfo;
    }
    
    public int getLength()
    {
        return this.length;
    }
    
        public void setEndNode(int nodeId)
    {
        this.endNodeId = nodeId;
    }
    
    public int getEndNode()
    {
        return this.endNodeId;
    }
    
}


class Node
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

class BinaryHeap
{
    private Node[] MinHeap;
    private int length;
    private int nearestOpenIndex = 1;
    
    // moves an element located at the specified index upwards in the heap to correctly reposition an element 
    //whose value is less than the value of its parent. This condition may result from removing an element or from 
    //changing an element’s value.
    public void Heapify_Up(int index) 
    {
        //Check if im the root, if I am there's no one above me
        if(index > 1)
	{
	    int parentIndex = parent(index); // im not the root so find my parent
	    if (this.MinHeap[index].getDistance() < MinHeap[parentIndex].getDistance()) // compare to see if the node is less than parent
	    {
		Node ParentCopy = MinHeap[parentIndex]; //if it is you need to swap the two values
		MinHeap[parentIndex] = MinHeap[index];
		MinHeap[index] = ParentCopy;
		Heapify_Up(parentIndex); //make sure you are large than your parent
            }
	}
    }
    
    public ArrayList<Node> initalizeDictionary(ArrayList <Node> dictionary)
    {
        dictionary.clear();
        for (int i = 0; i < getLength(); i++)
        {
            dictionary.add(MinHeap[i]);
        }
        return dictionary;
    }
    
    public int parent(int i)
    {
        if (i == 1) // if `i` is already a root node
        {
            return 1;
        }
        return (i / 2); //else my parent is 1/2
    }
    
    //moves an element located at the specified index downwards in the heap to correctly reposition an element whose value is greater 
    //than the value of either of its children. This condition may result from removing an element or from changing an element’s value.
    public void Heapify_Down(int i) 
    {
        int smallest = i;
        
        if (2 * i < length) //means index i has atleast has a left child
        {
            int leftChild = 2 * i;
            
            smallest = leftChild; //set smallest to left child first
            if ((2* i) + 1 <= length) //check if index has right child
            {
                int rightChild = (2*i) + 1; //assign right child
                if (this.MinHeap[rightChild].getDistance() < this.MinHeap[leftChild].getDistance()) // find smallest value between children
                {
                    smallest = rightChild;
                }
            }
            
        }
        
        if (this.MinHeap[smallest].getDistance() < this.MinHeap[i].getDistance()) // compare if child is smaller than parent
        {
                Node tempNode = MinHeap[smallest]; // if they are swap the values and update dictionary
                MinHeap[smallest] = MinHeap[i];
                MinHeap[i] = tempNode;
                Heapify_Down(smallest);
        }
    }
    
    public void StartHeap(int n) // initializes an empty heap to store at most N  + 1 elements since we are starting at index 1
    {
        this.MinHeap = new Node[n];
        setLength(n);
    }
    
    public void setNearestOpening(int n)
    {
        this.nearestOpenIndex = n;
    }
    
    public int getNearestOpening()
    {
        return this.nearestOpenIndex;
    }
    
    public void setLength(int n)
    {
        this.length = n;
    }
    
    public int getLength()
    {
        return this.length;
    }
    //inserts the item, item, with an ordering value, value, into the heap at the end of the array, then uses Heapify_Up 
    //to position the item so as to maintain the heap order. If the heap currently has n elements, this takes O(log n) time.
    public void Insert(Node item, int value)
    {
        //if I have my start node insert at root because this will be highest priority
        if (item.getDistance() == 0)
        {
            this.MinHeap[1] = item;
        }
        //else insert at nearest opening on heap and heapify up
        this.MinHeap[value] = item;
        this.nearestOpenIndex++;
        Heapify_Up(value);
    }
    
    //identifies the minimum element in the heap, which is located at index 1, but does not remove it. This takes O(1) time.
    public Node FindMin()
    {
        return this.MinHeap[1];
    }
    
    public Node FindNode(int nodeId)
    {
        for (int i = 1; i < MinHeap.length; i++)
        {
           if (MinHeap[i].getNodeId() == nodeId)
           {
              Node foundNode = MinHeap[i];
               return foundNode;
           }
        }
        return null;
    }
    //Delete(index) – deletes the element in the specified heap position by moving the item in the last array position to index, 
    //then using Heapify_Down to reposition that item. This is implemented in O(log n) time for heaps that have n elements.
    public void Delete(int index)
    {
        Node removedNode = MinHeap[index]; // saving remove node data
        MinHeap[index] = null; //clearing space
        MinHeap[index] = MinHeap[getNearestOpening() - 1];
        this.nearestOpenIndex--; //decrement nearest opening
        Heapify_Down(index); //position node you replaced in the opening to the correct spot of heap
    }
    
    //identifies and deletes the element with the minimum key value, located at index 1, from the heap. 
    //This is a combination of the preceding two operations, and so it takes O(log n) time.
    public void ExtractMin()
    {
       Node minNode = FindMin();
       Delete(1);
    }
    
    //which changes the key value of element v to newValue. To implement this operation in O(logn) time, 
    //we first need to be able to identify the position of element v in the array, which we do by using the Position structure. 
    //Once we have identified the position of element v, we change the key and then apply Heapify-up or Heapify-down as appropriate.
    public void ChangeKey(Node item, int newDistance)
    {
        int index = 0;
        for (int i = 1; i < MinHeap.length; i++) // may not need this we need this to set current Node when we have item?
        {
            if (MinHeap[i].getNodeId() == item.getNodeId()) //compare ID they won't be equal at this point.
            {
                index = i;
                break;
            }
        }
        int oldValue = item.getDistance();
        item.setDistance(newDistance);
        if (newDistance < oldValue)
        {
           Heapify_Up(index);
        }
        else
        {
           Heapify_Down(index);
        }
    }
}

public class Main
{
    // initalizing variables
    public static String data;
    public static int numberOfNodes;
    public static int numberOfEdges;
    public static int startNodeId;
    public static int endNodeId;
    public static int actualShortestDistance;
    public static int almostShortestDistance;
    public static Node endNode;
    public static Node startNode;
    public static BinaryHeap MinHeap = new BinaryHeap();
    public static List<Node> Visited = new ArrayList<Node>();
    public static List <Node> UnVisited = new ArrayList<Node>(); 
    private static ArrayList<Node> dictionary = new ArrayList<Node>();
    
    //initalizing scanner TODO remove this to do test inputs.
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] arg)
    {
       try 
       {
          File myObj = new File("inputValues.txt");
          Scanner myReader = new Scanner(myObj);
          data = myReader.nextLine();
          String[] stringValue = data.split(" ");
          nodeEdgeValueInitalize(data);
          data = myReader.nextLine();
          startNodeEndNodeInitalize(data);
          //Setting up the Min Binary Heap to hold number of nodes starting at index 1
          MinHeap.StartHeap(numberOfNodes + 1);
          //populate heap with nodes
          for (int i = 0; i < numberOfNodes; i ++)
          {
                Node newCreatedNode = createNode(i);
                MinHeap.Insert(newCreatedNode, MinHeap.getNearestOpening());
          }
          
          while (myReader.hasNextLine()) 
          {
                data = myReader.nextLine();
                edgeValueBreakUp(data);
          }
          myReader.close();
        } 
        catch (FileNotFoundException e) 
        {
          //System.out.println("An error occurred.");
          e.printStackTrace();
        }
        //initalize dictionary with values
        dictionary = MinHeap.initalizeDictionary(dictionary);
        for (int i = 0; i <= 2; i++)
        {
            initalizeUnVisitedList();
            Visited.clear();
            dijkstra(MinHeap.FindMin());
            dictionary = MinHeap.initalizeDictionary(dictionary);
            for (int j = 2; j < dictionary.size(); j++)
            {
               setDistancesToInfinity(dictionary.get(j)); //set all distances besides startNode back to infinity
            }
        }

    }
    
    public static void setDistancesToInfinity(Node nodeItem)
    {
            MinHeap.ChangeKey(nodeItem, Integer.MAX_VALUE);
    }
    
    public static void initalizeUnVisitedList()
    {
        for (int i = 0; i < dictionary.size(); i ++)
        {
            UnVisited.add(dictionary.get(i));
        }
    }
    
    public static int calculateEdges(Node endNode)
    {
        Node currentNode = endNode;
        int distanceFromStart = currentNode.getDistance(); //get total distance from start (this is the shortest path)
        System.out.println(distanceFromStart);
        //System.out.println("");
        while (currentNode != startNode)
        {
            Node previousNode = currentNode.getPrevNode();
            ArrayList <Edge> copyOfEdges = previousNode.getNeighbors();
            
            for (int i = 0; i < copyOfEdges.size(); i++)
            {
                if(copyOfEdges.get(i).getSrcNode() == previousNode.getNodeId() && copyOfEdges.get(i).getEndNode() == currentNode.getNodeId())
                {
                    Edge edgeFound = copyOfEdges.get(i);
                    //System.out.println(edgeFound.getSrcNode() + " -> " + edgeFound.getEndNode()); //TODO git rid debugging
                    previousNode.removeNeighbor(edgeFound); // now remove these edges of the shortest path
                    break;
                }
            }
            currentNode = previousNode;
        }
        
        return 0;
    }
    
    public static void nodeEdgeValueInitalize(String nodeEdgeInput)
    {
        String[] stringValue = nodeEdgeInput.split(" ");
        
        numberOfNodes = Integer.parseInt(stringValue[0]);
        numberOfEdges = Integer.parseInt(stringValue[1]);
    }
    
    public static void startNodeEndNodeInitalize(String startEndNodeInput)
    {
        String[] stringValue = startEndNodeInput.split(" ");
        
        startNodeId = Integer.parseInt(stringValue[0]);
        endNodeId = Integer.parseInt(stringValue[1]);
    }
    
    public static void edgeValueBreakUp(String edgeInformation)
    {
        String[] edgeData = edgeInformation.split(" ");
        assignNeighbors(Integer.parseInt(edgeData[0]), Integer.parseInt(edgeData[1]), Integer.parseInt(edgeData[2]));
    }
    
    
    public static Node createNode(int nodeId)
    {
            Node myNewNode = new Node();
            if (nodeId == endNodeId)
            {
                endNode = myNewNode;
            }
            if (nodeId == startNodeId)
            {
                myNewNode.setDistance(0);
                startNode = myNewNode;
            }
            myNewNode.setNodeId(nodeId);
            return myNewNode;
    }
    
    public static void assignNeighbors(int srcId, int endId, int distance)
    {
        Node currentNode = MinHeap.FindNode(srcId);
        Edge newEdge = new Edge();
        newEdge.setSrcNode(srcId);
        newEdge.setEndNode(endId);
        newEdge.setLength(distance);
        currentNode.setNeighbors(newEdge);
    }
    
    public static int dijkstra(Node currentNode)
    {
        boolean stillNodesToVisit = true;
        
        //load up unvisited list
        for (int i = 1; i < dictionary.size(); i++)
        {
            UnVisited.clear();
            UnVisited.add(dictionary.get(i));
        }
        
        while (!Visited.contains(endNode) && stillNodesToVisit) // while endNode.visited == false && || invisited distance is infitity
        {
            ArrayList<Edge> edgeListCopy = currentNode.getNeighbors();
            
            for (int i = 0; i < edgeListCopy.size(); i++)
            {
                int neighborId = edgeListCopy.get(i).getEndNode();
                int edgeValue = edgeListCopy.get(i).getLength();
                Node currentNeighbor = MinHeap.FindNode(neighborId);
                
                if (currentNeighbor.getDistance() > (currentNode.getDistance() + edgeValue))
                {
                    MinHeap.ChangeKey(currentNeighbor, currentNode.getDistance() + edgeValue); //update new priority value if previous is greater
                    currentNeighbor.setPrevNode(currentNode); //set previous node to current node so we know what edge we kept
                }
            }
            Visited.add(currentNode); //stick node we have just visited in a seperate list we will not be coming back to it
            UnVisited.remove(currentNode); // removing node from unvisited list
            for(int i = 0; i < UnVisited.size(); i++)
            {
                if (UnVisited.get(i).getDistance() != Integer.MAX_VALUE)
                {
                    stillNodesToVisit = true; 
                    break;
                }
                else
                {
                    stillNodesToVisit = false;
                }
            }
            MinHeap.initalizeDictionary(dictionary); // keep dictionary up to date
            if (currentNode != endNode) // sort through list to order neighbors from distance from startNode
            {
              currentNode.sortNeighbors(edgeListCopy);
              int newCurrentNodeId = edgeListCopy.get(0).getEndNode(); //look at unvisited neighbors and go back to step 3
              currentNode = MinHeap.FindNode(newCurrentNodeId); // extract from dictionary
            }
        }

        if (!Visited.contains(endNode))
        {
            return -1;
        }
        else
        {
            //System.out.println("Finished Dijkstra! Almost shortest distance found!");
            calculateEdges(endNode);
            return 0;
        }
    }
}
