import java.util.Scanner;
public class AlmostShortestPath extends Node
{
    // initalizing variables
    private int[] Heap;
    private int currentSize;
    private int maxHeapSize;
    public static int numberOfNodes;
    public static int numberOfEdges;
    public static int startNode;
    public static int endNode;
    //initalizing scanner TODO remove this to do test inputs.
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] arg)
    {
        System.out.println("Please input the number of nodes included in your graph: ");
        numberOfNodes = scanner.nextInt();
        
        System.out.println("Please input the number of edges included in your graph: ");
        numberOfEdges = scanner.nextInt();
        
        System.out.println("Please enter start node: ");
        startNode = scanner.nextInt();
        
        System.out.println("Please enter start node: ");
        endNode = scanner.nextInt();
        
        System.out.println("Please input the number of edges included in your graph: ");
        for (int i = 1; i <= numberOfEdges; i++)
        {
            System.out.println("Please enter sequence of node info: ");
            String nodeInfo = scanner.nextLine();
            Node newNode = new Node();
            
        }
        
        
    }
}
