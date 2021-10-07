public class Edge
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
