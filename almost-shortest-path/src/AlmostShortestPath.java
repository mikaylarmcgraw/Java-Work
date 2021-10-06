import java.util.Scanner;
public class AlmostShortestPath
{
    // initalizing variables
    public static Node[] NodeArray;
    public static String input;
    public static int numberOfNodes;
    public static int numberOfEdges;
    public static int startNodeId;
    public static int endNodeId;
    public static Node currentNode;
    public static BinaryHeap MinHeap = new BinaryHeap();
    
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
            if (nodeId == startNodeId)
            {
                myNewNode.setDistance(0);
            }
            myNewNode.setNodeId(nodeId);
            return myNewNode;
    }
    
    public static void assignNeighbors(int nodeValue, int neighborValue, int distance)
    {
        for(int i = 0; i < NodeArray.length; i ++)
        {
            if (NodeArray[i].getNodeId() == nodeValue)
            {
                currentNode = NodeArray[i];
                currentNode.setNeighbors(neighborValue, distance);
                i = NodeArray.length;
            }
            
            if(i == NodeArray.length - 1)
            {
                if (nodeValue != NodeArray[i].getNodeId())
                {
                   System.out.println("Node could not be found to assign neighbor!");
                }
            }
        }
    }
    
    public void dijkstra()
    {
        //current node will start as the startnode 
        // while endNode.visited == false && || invisited distance is infitity 
        // 3.) for each neighbor of currentNode:
                // up dateneighborNode.Distance = currentNode.Distance + currentNode.neighbors[neighborNode.distance]
        //mark current node as visited with setting flag to true
        //stick node we have just visited in a seperate list we will not be coming back to it

        //look at unvisited neighbors and go back to step 3
        {
            
            
        }
    }
}
