public class ArrayStack<E>
{
    //Data
    //Storage for the stack
    private E[] theData;
    private int topOfStack = -1;
    private static final int INITIAL_CAPACITY = 10;

    //Consructors
    //Default Constructor: Create a stack of default capacity
    public ArrayStack()
    {
        this.theData = (E[]) new Object[INITIAL_CAPACITY];

    }
    //Overloaded Constructor: To create a Stack of custom size
    public ArrayStack(int size)
    {
        this.theData = (E[]) new Object[size];
    }

    public void push(E obj)
    {
        //This method adds elements to the stack if there is space for it
        //Check if the satck is full
        if(topOfStack == theData.length-1)
        {
            System.out.println("Stack Overflow...!!");
            return;
        }
        //Else, there is space, and we can increment topOfStack and insert data
        topOfStack++;
        this.theData[topOfStack]=obj;
        //this.display();
        return;

    }

    public E pop()
    {

        //this method removes elements from the stack if there is something
        if(empty())
        {
            //System.out.println("Stack Underflow...!!");
            return null;
        }
        //There is some element, delete it and return
        E temp = theData[topOfStack];
        topOfStack--;
        //this.display();
        return temp;

    }

    public E peek()
    {
        //Similar to pop except doesn't deleting the element
        if(empty())
        {
            //System.out.println("Stack Underflow...!!");
            return null;
        }
        //There is some element, delete it and return
        return theData[topOfStack];

    }


    public boolean empty()
    {
        return(topOfStack == -1);
    }

    public boolean isFull()
    {
        if(topOfStack == theData.length-1)
        {
            return true;
        }
        return false;
    }


    public void display()
    {
        //Method to display the contents of the stack
        System.out.println("Stack: ");
        for(int i=0; i<= topOfStack; i++)
        {
            System.out.print(theData[i]); //Printing from the bottom of the stack
            System.out.println("-----------------------------------------------");
        }
        System.out.println();
    }

}