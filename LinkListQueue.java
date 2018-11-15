public class LinkListQueue extends SingleLinkList
{
    //Data
    private int capacity;			// How many elements can be stored max?
    private int size;				// How many elements are currently in the queue
    private SingleLinkList linkList;

    // Constructors
    public LinkListQueue()
    {
        // Default Constructor
        this.capacity = 5;
        linkList = new SingleLinkList();
        this.size = 0;

    }

    // Overlaoded Constructor
    public LinkListQueue(int capacity)
    {
        linkList= new SingleLinkList();
        this.capacity = capacity;
        this.size = 0;
    }



    public void enqueue(Node obj)
    {
                                                                     // This method adds elements to the end of the queue
                                                                     // Check if there is space to add elements to the Queue
        if(isFull())
        {
            // These no more space, you need to call reallocate(). or say it's full
            System.out.println("Queue overflow...!!");
        }
        linkList.addLast(obj);
        size++;

    }


    public Object dequeue()
    {
        // This Method removes elements from teh front of the queue
        //Check if there is any elemnts that can be removed
        if(isEmpty())
        {
            System.out.println("Queue underflow...!!");
            return null;
        }

        Object temp =linkList.removeFirst();
        size--;
        return temp;
    }


    public boolean isEmpty()
    {
        return (this.size==0);
    }


    public boolean isFull()
    {

        return (this.capacity == this.size);
    }


    public int getSize()
    {
        return linkList.getSize();
    }

    public void printQueue()
    {
        linkList.printList();
    }
}
