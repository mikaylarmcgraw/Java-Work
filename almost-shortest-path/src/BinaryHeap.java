import java.util.*;
public class BinaryHeap
{
    private Node[] MinHeap;
    private int length;
    private ArrayList<Node> dictionary = new ArrayList<Node>();
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
                dictionary.remove(MinHeap[i]);
                dictionary.add(i, tempNode);
                dictionary.remove(MinHeap[smallest]);
                dictionary.add(smallest, MinHeap[i]);
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
            this.dictionary.add(item);
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
        dictionary.remove(removedNode); //removing from heap dictionary
        MinHeap[index] = MinHeap[getNearestOpening() - 1];
        dictionary.add(index, MinHeap[getNearestOpening()-1]); // replace with the node to fill the spot
        this.nearestOpenIndex--; //decrement nearest opening
        Heapify_Down(index); //position node you replaced in the opening to the correct spot of heap
    }
    
    //identifies and deletes the element with the minimum key value, located at index 1, from the heap. 
    //This is a combination of the preceding two operations, and so it takes O(log n) time.
    public void ExtractMin()
    {
       Node minNode = FindMin();
       Delete(dictionary.indexOf(minNode));
    }
    
    //which changes the key value of element v to newValue. To implement this operation in O(logn) time, 
    //we first need to be able to identify the position of element v in the array, which we do by using the Position structure. 
    //Once we have identified the position of element v, we change the key and then apply Heapify-up or Heapify-down as appropriate.
    public void ChangeKey(Node item, int newDistance)
    {
        int i = dictionary.indexOf(item);
        Node currentNode = this.MinHeap[i];
        int oldValue = currentNode.getDistance();
        currentNode.setDistance(newDistance);
        if (newDistance < oldValue)
        {
           Heapify_Up(i);
        }
        else
        {
           Heapify_Down(i);
        }
    }
}
