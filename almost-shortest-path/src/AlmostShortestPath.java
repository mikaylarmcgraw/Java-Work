import java.util.Scanner;
public class AlmostShortestPath extends Node
{
    // initalizing variables
    private static int[] NodeArray;
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
        
        //initalize node array with all points before assigning neighbors
        setNodeArray();
        
        for(int i = 0; i < numberOfEdges; i++)
        {
            
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
    
    public static void setNodeArray()
    {
        NodeArray = new int[numberOfNodes-1];
        for (int i = 0; i <= numberOfNodes-1; i++)
        {
            NodeArray[i] = i;
        }
    }
}
