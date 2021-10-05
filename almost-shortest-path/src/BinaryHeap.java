public class BinaryHeap
{
    private Node[] MinHeap;
    
    // moves an element located at the specified index upwards in the heap to correctly reposition an element 
    //whose value is less than the value of its parent. This condition may result from removing an element or from 
    //changing an element’s value.
    public void Heapify_Up() 
    {
        
    }
    
    //moves an element located at the specified index downwards in the heap to correctly reposition an element whose value is greater 
    //than the value of either of its children. This condition may result from removing an element or from changing an element’s value.
    public void Heapify_Down() 
    {
        
    }
    
    public void StartHeap(int n) // initializes an empty heap that is set up to store at most N elements.
    {
        this.MinHeap = new Node[n];
    }
    
    //inserts the item, item, with an ordering value, value, into the heap at the end of the array, then uses Heapify_Up 
    //to position the item so as to maintain the heap order. If the heap currently has n elements, this takes O(log n) time.
    public void Insert(Node item, int value)
    {
        for (int i = 0; i < this.MinHeap.length; i++)
        {
            if (this.MinHeap[i] == null)
            {
                this.MinHeap[i] = item;
                i = this.MinHeap.length;
            }
        }
    }
    
    //identifies the minimum element in the heap, which is located at index 1, but does not remove it. This takes O(1) time.
    public Node FindMin()
    {
        Node minNode = this.MinHeap[1];
        return minNode;
    }
    
    public void Delete(Node item)
    {
        
    }
    
    //which changes the key value of element v to newValue. To implement this operation in O(logn) time, 
    //we first need to be able to identify the position of element v in the array, which we do by using the Position structure. 
    //Once we have identified the position of element v, we change the key and then apply Heapify-up or Heapify-down as appropriate.
    public void ChangeKey(Node item, int newValue)
    {
        for (int i = 0; i < this.MinHeap.length; i++)
        {
            if (this.MinHeap[i] == item)
            {
                Node currentNode = this.MinHeap[i];
                int oldValue = currentNode.getNodeValue();
                currentNode.setNodeValue(newValue);
                i = this.MinHeap.length;
            }
        }
    }
}
