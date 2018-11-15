public class SingleLinkList {

    private Node head;		//Head of the Linked List
    private int size;		//How many nodes there are in the list

    public SingleLinkList(){
        this.head = new Node(-1); 	//Creates the head, and stores special value -1
        size = 0;					//At the beginning, the list is empty
    }

    //Add methods
    //Method to add item at the beginning of the list
    public void addFirst(Object item){
        Node first = new Node(item);	//Step 1: Create the node
        first.next = head.next;			//Step 2: Copy the next of head to the next of node
        head.next = first;				//Step 3: Update the head next value to point to the new node
        size++;							//Step 4: Update the number of nodes in the list
    }

    //Method to add item after a given Node reference
    public void addAfter(Node target, Object item){
        Node insert = new Node(item);
        insert.next = target.next;
        target.next = insert;
        size++;
    }

    //Method to add item at the end of the list
    public void addLast(Object item){
        //We will use the getNode() method to retrieve the reference and then call addAfter()
        Node target = getNode(size);	//Get hold of the last node
        addAfter(target, item);			//Then call the addAfter method to do the work
    }

    //Helper method, returns the reference to the node at given index
    public Node getNode(int index){
        if(index < 0 || index > size){
            return null;
        }
        //Otherwise, iterate over the list, and return the reference
        Node iter = head; 	//A dummy iterator
        //Use a loop to iterate over the list and go to the index
        for(int i = 0; i < index; i ++){
            iter = iter.next;
        }
        return iter;
    }

    //Method to remove data
    public Object removeFirst(){
        //Check if there is data to be removed, if not return null
        if(size == 0){	//size 0 indicates no data in the linkedlist
            return null;
        }
        Node removed = head.next;
        head.next = head.next.next;
        size--;
        return removed.data;
    }

    //Helper method to display the contents of the linkedlist
    public void printList(){
        Node temp = head;		//Iterator
        System.out.print("Data: ");
        while(temp.next != null){		//As long as there is data
            System.out.print(temp.next.data + "->");	//Print the data
            temp = temp.next;							//Point to the next node
        }
        System.out.println();						//Go to the next line
    }

    //Printing a linkedlist in reverse
    public void printReverse(Node head){
        if(head.next == null){						//Base case
            System.out.print(head.data + "<-");
            return;
        }
        printReverse(head.next);					//Recursive call
        System.out.print(head.data + "<-");
    }

    public int getSize()
    {
        return size;
    }
}
