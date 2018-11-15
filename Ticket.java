import java.util.Scanner;


public class Ticket
{
    private double price;
    private boolean freePopcorn;
    private String name;
    private static Scanner input = new Scanner(System.in);
    private double costAvengers;
    private double costSpiderman;
    private double costDeadpool;
    private double costPunisher;
    private double costSherlockHomes;

    public Ticket()
    {
        price=0;
        freePopcorn=false;
    }

    public Ticket(double price,boolean freePopcorn,String movie)
    {
        this.price=price;
        this.freePopcorn=freePopcorn;
        name=movie;
    }

    public ArrayStack createMovie(String movie)
    {

        int size=(int)(Math.random()*5+2);
        ArrayStack myStack = new ArrayStack(size);
        return generateTickets(myStack,size,movie);
    }

    public void movieAvailability(ArrayStack Avengers,ArrayStack Spiderman, ArrayStack Deadpool,ArrayStack Punisher, ArrayStack SherlockHomes)
    {
        if(Avengers.peek()!=null)
            System.out.println("Avengers Movie is Available");
        if(Spiderman.peek()!=null)
            System.out.println("Spiderman Movie is Available");
        if(Deadpool.peek()!=null)
            System.out.println("Deadpool Movie is Available");
        if(Punisher.peek()!=null)
            System.out.println("Punisher Movie is Available");
        if(SherlockHomes.peek()!=null)
            System.out.println("Sherlock Homes movie is Available");

        System.out.println("\n***********************************************************\n");
    }

    public ArrayStack generateTickets(ArrayStack myStack,int size,String movie)
    {
        double cost = Math.random()*10+10;

        for(int i=0;i<size;i++)
        {
            int check = (int) (Math.random() * 3 + 1);
            boolean popcorn;
            if (check % 2 == 0)
                popcorn = false;
            else
                popcorn = true;

            Ticket myTic = new Ticket(cost, popcorn,movie);
            myStack.push(myTic);
        }
        return myStack;
    }

    //Overloaded Method
    public ArrayStack generateTickets(ArrayStack myStack,int size,String movie,double cost)
    {
        for(int i=0;i<size;i++)
        {
            int check = (int) (Math.random() * 3 + 1);
            boolean popcorn;
            if (check % 2 == 0)
                popcorn = false;
            else
                popcorn = true;

            Ticket myTic = new Ticket(cost, popcorn,movie);
            myStack.push(myTic);
        }
        return myStack;
    }

    public void refundTickets(ArrayStack Avengers,ArrayStack Spiderman, ArrayStack Deadpool,ArrayStack Punisher, ArrayStack SherlockHomes)
    {
        boolean exitName = false;
        boolean exitNum = false;
        int ticketNumber = 0;
        String name = "";
        ArrayStack tempStack;
        while (!exitName)                                                                    //Error Checking to ensure an acceptable name has been entered
        {
            System.out.println("----------------------Movies for Today----------------------");
            System.out.println("Avengers| Spiderman | Deadpool | Punisher | Sherlock Homes");
            System.out.println("Please enter a Movie");
            name = input.nextLine();
            name = name.toLowerCase();
            if (name.equals("avengers") || name.equals("spiderman") || name.equals("deadpool") || name.equals("punisher") || name.equals("sherlock homes")) {
                exitName = true;
            }
        }

        while (!exitNum)                                                                       //Error checking to ensure an acceptable number has been entered
        {
            System.out.println("Please enter how many tickets you would like to return. A max of 5 at a time.");
            ticketNumber = input.nextInt();
            input.nextLine();
            if (ticketNumber > 0 && ticketNumber < 6)
                exitNum = true;
            else
                System.out.println("Error. You entered an incorrect number. Please enter a number between 1-5");
        }
        tempStack= new ArrayStack(ticketNumber);
        int count=0;
        switch (name)
        {
            case "avengers":
                {
                    tempStack = generateTickets(tempStack,ticketNumber,"Avengers",costAvengers);
                    for (int i = 0; i < ticketNumber; i++)
                    {
                        if(!Avengers.isFull())
                        {
                            Avengers.push(tempStack.pop());
                            count++;
                        }
                    }
                    System.out.println("We were able to refund only "+count+" Tickets.");
                    break;
                }
            case "spiderman":
            {
                tempStack = generateTickets(tempStack,ticketNumber,"Spiderman",costAvengers);
                for (int i = 0; i < ticketNumber; i++)
                {
                    if(!Spiderman.isFull())
                    {
                        Spiderman.push(tempStack.pop());
                        count++;
                    }
                }
                System.out.println("We were able to refund only "+count+" Tickets.");
                break;
            }
            case "deadpool":
            {
                tempStack = generateTickets(tempStack,ticketNumber,"Deadpool",costAvengers);
                for (int i = 0; i < ticketNumber; i++)
                {
                    if(!Deadpool.isFull())
                    {
                        Deadpool.push(tempStack.pop());
                        count++;
                    }
                }
                System.out.println("We were able to refund only "+count+" Tickets.");
                break;
            }
            case "punisher":
            {
                tempStack = generateTickets(tempStack,ticketNumber,"Punisher",costAvengers);
                for (int i = 0; i < ticketNumber; i++)
                {
                    if(!Punisher.isFull())
                    {
                        Punisher.push(tempStack.pop());
                        count++;
                    }
                }
                System.out.println("We were able to refund only "+count+" Tickets.");
                break;
            }
            case "sherlock homes":
            {
                tempStack = generateTickets(tempStack,ticketNumber,"Sherlock Homes",costAvengers);
                for (int i = 0; i < ticketNumber; i++)
                {
                    if(!SherlockHomes.isFull())
                    {
                        SherlockHomes.push(tempStack.pop());
                        count++;
                    }
                }
                System.out.println("We were able to refund only "+count+" Tickets.");
                break;
            }
            default:
                System.out.println("Error. Please enter a movie that is showing today.");
        }
    }

    public void purchaseTicket(ArrayStack Avengers,ArrayStack Spiderman, ArrayStack Deadpool,ArrayStack Punisher, ArrayStack SherlockHomes)
    {
        boolean exitName = false;
        boolean exitNum = false;
        int freePop = 0;
        double totalCost=0;
        String name="";
        Ticket tempTicket;
        while(!exitName)                                                                    //Error Checking to ensure an acceptable name has been entered
        {
            System.out.println("----------------------Movies for Today----------------------");
            System.out.println("Avengers| Spiderman | Deadpool | Punisher | Sherlock Homes");
            System.out.println("Please enter a Movie");
            name = input.nextLine();
            name = name.toLowerCase();
            if(name.equals("avengers") || name.equals("spiderman") || name.equals("deadpool") || name.equals("punisher") || name.equals("sherlock homes"))
            {
                exitName=true;
            }
        }

        int ticketNumber=0;
        while(!exitNum)                                                                       //Error checking to ensure an acceptable number has been entered
        {
                System.out.println("Please enter how many tickets you would like to buy. A max of 5 at a time.");
                ticketNumber= input.nextInt();
                input.nextLine();
                if(ticketNumber>0 && ticketNumber<6)
                    exitNum=true;
                else
                    System.out.println("Error. You entered an incorrect number. Please enter a number between 1-5");
        }
        ArrayStack temp = new ArrayStack(ticketNumber);
        switch (name)
        {
            case "avengers":
                for(int i = 0;i<ticketNumber;i++)
                {
                    if(Avengers.peek()!=null)
                    {
                        totalCost = totalCost+ costAvengers;
                        tempTicket =(Ticket)Avengers.peek();
                        if(tempTicket.freePopcorn)
                            freePop++;
                        temp.push(Avengers.pop());
                        if(i==ticketNumber-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your ticket");
                        }
                    }
                    else {
                        System.out.println("Error. There is not enough tickets available for this movie.\nThere is only " + i + " tickets available.");
                        movieAvailability(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
                        while(!temp.empty())
                        {
                            Avengers.push(temp.pop());
                        }
                        break;
                    }
                }

                break;
            case "spiderman":
                for(int i=0;i<ticketNumber;i++)
                {
                    if(Spiderman.peek()!=null)
                    {
                        tempTicket =(Ticket)Spiderman.peek();
                        if(tempTicket.freePopcorn)
                            freePop++;
                        totalCost = totalCost+ costSpiderman;
                        temp.push(Spiderman.pop());
                        if(i==ticketNumber-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your ticket");
                        }
                    }
                    else
                    {
                        System.out.println("Error. There is not enough tickets available for this movie.\nThere is only " + i + " tickets available.");
                        movieAvailability(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
                        while(!temp.empty())
                        {
                            Spiderman.push(temp.pop());
                        }
                        break;
                    }
                }
                break;
            case "deadpool":
                for(int i=0;i<ticketNumber;i++)
                {
                    if(Deadpool.peek()!=null)
                    {
                        tempTicket =(Ticket)Deadpool.peek();
                        if(tempTicket.freePopcorn)
                            freePop++;
                        totalCost = totalCost+ costDeadpool;
                        temp.push(Deadpool.pop());
                        if(i==ticketNumber-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your ticket");
                        }
                    }
                    else
                    {
                        System.out.println("Error. There is not enough tickets available for this movie.\nThere is only " + i + " tickets available.");
                        movieAvailability(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
                        while(!temp.empty())
                        {
                            Deadpool.push(temp.pop());
                        }
                        break;
                    }
                }
                break;
            case "punisher":
                for(int i=0;i<ticketNumber;i++)
                {
                    if(Punisher.peek()!=null)
                    {
                        tempTicket =(Ticket)Punisher.peek();
                        if(tempTicket.freePopcorn)
                            freePop++;
                        totalCost = totalCost+ costPunisher;
                        temp.push(Punisher.pop());
                        if(i==ticketNumber-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your ticket");
                        }
                    }
                    else
                    {
                        System.out.println("Error. There is not enough tickets available for this movie.\nThere is only " + i + " tickets available.");
                        movieAvailability(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
                        while(!temp.empty())
                        {
                            Punisher.push(temp.pop());
                        }
                        break;
                    }
                }
                break;
            case "sherlock homes":
                for(int i=0;i<ticketNumber;i++)
                {
                    if(SherlockHomes.peek()!=null)
                    {
                        tempTicket =(Ticket)SherlockHomes.peek();
                        if(tempTicket.freePopcorn)
                            freePop++;
                        totalCost = totalCost+ costSherlockHomes;
                        temp.push(SherlockHomes.pop());
                        if(i==ticketNumber-1)
                        {
                            System.out.printf("Total Cost of the tickets are: %.2f\n",totalCost);
                            System.out.println("You received "+freePop+" Free Popcorn on your ticket");
                        }
                    }
                    else
                    {
                        System.out.println("Error. There is not enough tickets available for this movie.\nThere is only " + i + " tickets available.");
                        movieAvailability(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
                        while(!temp.empty())
                        {
                            SherlockHomes.push(temp.pop());
                        }
                        break;
                    }
                }
                break;
            default:
                System.out.println("Error. Please enter a movie that is showing today.");
        }

    }


    public void movieMenu(ArrayStack Avengers,ArrayStack Spiderman, ArrayStack Deadpool,ArrayStack Punisher, ArrayStack SherlockHomes)
    {
        LinkListQueue people = new LinkListQueue(10);
        for(int i=0;i<10;i++)
        {
            String x = "Person "+i;
            Node myNode = new Node(x);
            people.enqueue(myNode);
        }
        Ticket tempTicket = (Ticket)Avengers.peek();
        costAvengers = tempTicket.price;
        tempTicket = (Ticket) Spiderman.peek();
        costSpiderman = tempTicket.price;
        tempTicket = (Ticket)Deadpool.peek();
        costDeadpool = tempTicket.price;
        tempTicket = (Ticket)Punisher.peek();
        costPunisher = tempTicket.price;
        tempTicket = (Ticket)SherlockHomes.peek();
        costSherlockHomes = tempTicket.price;
        boolean exit = false;
        int choice;
        while(!exit)
        {

            System.out.println("Enter 1 to display all shows with at least one ticket\nEnter 2 to buy tickets\nEnter 3 to return tickets");
            choice=input.nextInt();
            input.nextLine();
            switch(choice)
            {
                case 1:
                    movieAvailability(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
                    break;
                case 2:
                    purchaseTicket(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
                    break;
                case 3:
                    refundTickets(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
                    break;
                default:
                    System.out.println("Error. Please Enter only from the available options.");
            }
            people.dequeue();

            if((Avengers.empty() && Spiderman.empty() && Deadpool.empty() && Punisher.empty() && SherlockHomes.empty()) || people.isEmpty())
                exit = true;
        }
        System.out.println("The Theater is Closed.");

    }

    public String toString()
    {
        System.out.println("                  "+name);
        System.out.printf("Cost: %.2f\n",price);
        if(freePopcorn)
            System.out.println("Popcorn is free");
        else
            System.out.println("Popcorn is not free");
        return"";
    }
}
