import java.util.Scanner;
import java.util.*;
public class AlmostShortestPath
{
    // initalizing variables
    public static Node[] NodeArray;
    public static String input;
    public static int numberOfNodes;
    public static int numberOfEdges;
    public static int startNodeId;
    public static int endNodeId;
    public static Node endNode;
    public static Node startNode;
    public static Node currentNode;
    public static BinaryHeap MinHeap = new BinaryHeap();
    public static List<Node> Visited = new ArrayList<Node>();
    public static List <Node> UnVisited = new ArrayList<Node>(); 
    
    //initalizing scanner TODO remove this to do test inputs.
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] arg)
    {
        //initalizing nodes and edge value
        input = scanner.nextLine();
        nodeEdgeValueInitalize(input);
        //initalizing start and end node value
        input = scanner.nextLine();
        startNodeEndNodeInitalize(input);
        
        //Setting up the Min Binary Heap to hold number of nodes starting at index 1
        MinHeap.StartHeap(numberOfNodes + 1);
        
        //building out node array
        setNodeArrayLength();
        
        //populate array of nodes on the heap
        for (int i = 0; i < numberOfNodes; i ++)
        {
            currentNode = createNode(i);
            MinHeap.Insert(currentNode, MinHeap.getNearestOpening());
            NodeArray[i] = currentNode;
        }
        
        //assign neighbors
        for (int i = 1; i <= numberOfEdges; i++)
        {
            input = scanner.nextLine();
            edgeValueBreakUp(input);
        }

        //print neighbors make sure they are assigned right
        for (int i = 2; i < NodeArray.length; i++)
        {
            
            MinHeap.ChangeKey(NodeArray[i], 4+i);
        }
        
        dijkstra(MinHeap.FindMin());
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
        System.out.println(edgeData[0]);
        System.out.println(edgeData[1]);
        System.out.println(edgeData[2]);
        assignNeighbors(Integer.parseInt(edgeData[0]), Integer.parseInt(edgeData[1]), Integer.parseInt(edgeData[2]));
    }
    
    public static void setNodeArrayLength()
    {
        NodeArray = new Node[numberOfNodes];
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
    
    public static void dijkstra(Node currentNode)
    {
        boolean stillNodesToVisit = false;
        
        if (UnVisited.isEmpty() == false) // if there's nodes in unvisited check distance
        {
            for (Node n : UnVisited)
            {
                if (n.getDistance() !=  Integer.MAX_VALUE)
                stillNodesToVisit = true;
                break;
            }
        }

        while (!Visited.contains(endNode)|| stillNodesToVisit) // while endNode.visited == false && || invisited distance is infitity
        {
            ArrayList<Edge> edgeListCopy = currentNode.getNeighbors();
            
            for (int i = 0; i < edgeListCopy.size(); i++)
            {
                int neighborId = edgeListCopy.get(i).getEndNode();
                int edgeValue = edgeListCopy.get(i).getLength();
                Node currentNeighbor = MinHeap.FindNode(neighborId);
                
                if (currentNeighbor.getDistance() > (currentNode.getDistance() + edgeValue))
                {
                    currentNeighbor.setDistance((currentNode.getDistance() + edgeValue)); //update new priority value if previous is greater
                }
                Visited.add(currentNode); //stick node we have just visited in a seperate list we will not be coming back to it
            }
        }

        

        //look at unvisited neighbors and go back to step 3

    }
}
