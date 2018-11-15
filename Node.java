public class Node {
    //Data fields
    Object data;	//Data element
    Node next;		//Pointer to the next node in the list

    //Constructor for the Node
    public Node(Object data)
    {
        this.data = data;
        this.next = null;
    }
    public String toString()
    {
        System.out.println(data);

        return "";
    }
}