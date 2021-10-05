import java.util.Scanner;
public class AlmostShortestPath
{
    // initalizing variables
    public static Node[] NodeArray;
    public static String input;
    public static int numberOfNodes;
    public static int numberOfEdges;
    public static int startNode;
    public static int endNode;
    public static Node currentNode;
    
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
        
        //building out node array
        setNodeArrayLength();
        
        //populate array of nodes on the map
        for (int i = 0; i < numberOfNodes; i ++)
        {
            currentNode = createNode(i);
            NodeArray[i] = currentNode;
        }
        
        //assign neighbors
        for (int i = 1; i <= numberOfEdges; i++)
        {
            input = scanner.nextLine();
            edgeValueBreakUp(input);
        }

        //print neighbors make sure they are assigned right
        for (int i = 0; i < NodeArray.length; i++)
        {
            
            System.out.println("Node " + i + "Neighbors: ");
            System.out.println(NodeArray[i].getNeighbors());
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
        
        startNode = Integer.parseInt(stringValue[0]);
        endNode = Integer.parseInt(stringValue[1]);
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
    
    public static Node createNode(int nodeValue)
    {
            Node myNewNode = new Node();
            if (nodeValue == startNode)
            {
                myNewNode.setDistance(0);
            }
            myNewNode.setNodeValue(nodeValue);
            return myNewNode;
    }
    
    public static void assignNeighbors(int nodeValue, int neighborValue, int distance)
    {
        for(int i = 0; i < NodeArray.length; i ++)
        {
            if (NodeArray[i].getNodeValue() == nodeValue)
            {
                currentNode = NodeArray[i];
                currentNode.setNeighbors(neighborValue, distance);
                i = NodeArray.length;
            }
            
            if(i == NodeArray.length - 1)
            {
                if (nodeValue != NodeArray[i].getNodeValue())
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
