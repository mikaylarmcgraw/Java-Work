import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

class Edge //my edge object
{
    int srcNodeId;
    int endNodeId;
    int length;
    
    //get & set src node info
    public void setSrcNode(int srcNodeIdCopy)
    {
        this.srcNodeId = srcNodeIdCopy;
    }
    
    public int getSrcNode()
    {
        return this.srcNodeId; 
    }
    
    //get & set end node info
    public void setEndNode(int endNodeIdCopy)
    {
        this.endNodeId = endNodeIdCopy;
    }
    
    public int getEndNode()
    {
        return this.endNodeId; 
    }
    
    //get & set length of edge
    public void setEdgeLength(int lengthValue)
    {
        this.length = lengthValue;
    }
    
    public int getEdgeLength()
    {
        return this.length; 
    }
}

class Node //my node object
{
    int nodeId;
    int distanceFromStart = Integer.MAX_VALUE;
    ArrayList<Edge> nodeEdges = new ArrayList <Edge>();
    
    //get & set node ID
    public void setNodeId(int ID)
    {
        this.nodeId = ID;
    }
    
    public int getNodeId()
    {
        return this.nodeId;
    }
    
    //get & set node distance from start
    public void setDistance(int distanceValue)
    {
        this.distanceFromStart = distanceValue;
    }
    
    public int getDistance()
    {
        return this.distanceFromStart;
    }
    
    //get & set edges connected to node
    public void setEdges(Edge edgeObj)
    {
        this.nodeEdges.add(edgeObj);
    }
    
    public ArrayList<Edge> getEdges()
    {
        return this.nodeEdges;
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
            if ((2* i) + 1 < length) //check if index has right child
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
        this.MinHeap = new Node[n+1];
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

public class AlmostShortestPathDriver
{
    //initalizing variables
    public static String data;
    public static int testCases = 1;
    public static int numberOfNodes;
    public static int numberOfEdges;
    public static int srcNodeId;
    public static int endNodeId;
    public static Node srcNode;
    public static Node endNode;
    public static BinaryHeap MinHeap;
    
    public static void main(String[] arg)
    {
        try 
        {
          File myObj = new File("inputValues.txt");
          Scanner myReader = new Scanner(myObj);
          
          data = myReader.nextLine();//fetch first line including number of edges and nodes
          String[] stringValue = data.split(" ");
          while (!data.equals("0 0"))
          {
              System.out.println("Test case : " + testCases);
              String[] stringValues = data.split(" "); 
              nodeEdgeValueInitalize(stringValues); //send array to assign number of nodes & edges

              data = myReader.nextLine();//fetch second line including start and end node IDs
              String[] values = data.split(" ");
              startNodeEndNodeIdInitalize(values); //send start and end node data
              
              //create BinaryHeapObject and initalize length and add nodes
              MinHeap = new BinaryHeap();
              MinHeap.StartHeap(numberOfNodes);
              
              //TODO test case 15 having issues 2 nodes 1 edge going from 1 -> 0 assigning both nodes node ID 1
              for (int i = 0; i < MinHeap.getLength(); i++)
              {
                  Node newCreatedNode = createNode(i);
                  MinHeap.Insert(newCreatedNode, MinHeap.getNearestOpening());
              }
              
              boolean flag = true; //this helps control second while
              
              while(flag)
              {
                  data = myReader.nextLine();
                  String[] edgeInfo = data.split(" ");
                  if(edgeInfo.length == 3)
                  {
                      edgeValueBreakup(edgeInfo);
                  }
                  else
                  {
                      flag = false;
                  }
              }
              testCases++;
              System.out.println("All Done!");
          }
          myReader.close();
        } 
        catch (FileNotFoundException e) 
        {
          //System.out.println("An error occurred.");
          e.printStackTrace();
        }
   
    }
    
    public static void nodeEdgeValueInitalize(String [] array)
    {
        numberOfNodes = Integer.parseInt(array[0]);
        numberOfEdges = Integer.parseInt(array[1]);
    }
    
    public static void startNodeEndNodeIdInitalize(String [] array)
    {
        srcNodeId = Integer.parseInt(array[0]);
        endNodeId = Integer.parseInt(array[1]);
    }
    
    public static Node createNode(int nodeId)
    {
            Node myNewNode = new Node();
            if (nodeId == endNodeId)
            {
                endNode = myNewNode;
            }
            if (nodeId == srcNodeId)
            {
                myNewNode.setDistance(0);
                srcNode = myNewNode;
            }
            myNewNode.setNodeId(nodeId);
            return myNewNode;
    }
    
    public static void edgeValueBreakup(String[] values)
    {
        int srcIdValue = Integer.parseInt(values[0]);
        int endIdValue = Integer.parseInt(values[1]);
        int lengthValue = Integer.parseInt(values[2]);
        Node currentNode = MinHeap.FindNode(srcIdValue);
        Edge newEdge = new Edge();
        newEdge.setSrcNode(srcIdValue);
        newEdge.setEndNode(endIdValue);
        newEdge.setEdgeLength(lengthValue);
        currentNode.setEdges(newEdge);
    }
}
