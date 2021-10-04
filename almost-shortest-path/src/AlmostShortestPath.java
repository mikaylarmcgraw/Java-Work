import java.util.Scanner;
public class AlmostShortestPath extends Node
{
    // initalizing variables
    private static Node[] NodeArray;
    private int[] Heap;
    private int currentSize;
    private int maxHeapSize;
    public static String input;
    public static int numberOfNodes;
    public static int numberOfEdges;
    public static int startNode;
    public static int endNode;
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
        for(int i = 0; i < NodeArray.length; i++)
        {
            addNodeToArray(i);
            //debugging purposes print all values
            System.out.println(NodeArray[i].getNodeValue());
        }
        
        //assign neighbors
        for(int i = 0; i < numberOfEdges; i++)
        {
            int x;
            int y;
            int z;
            assignNeighbors(x, y, z);
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
    
    public static void setNodeArrayLength()
    {
        NodeArray = new Node[numberOfNodes];
    }
    
    public static void addNodeToArray(int nodeValue)
    {
            Node myNewNode = new Node();
            myNewNode.setNodeValue(nodeValue);
            NodeArray[nodeValue] = myNewNode;    
    }
    
    public static void assignNeighbors(int nodeValue, int neighborValue, int distance)
    {
        
        
    }
}
