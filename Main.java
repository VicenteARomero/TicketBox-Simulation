public class Main {
    public static void main(String[] args) {
        Ticket myTicket = new Ticket();
	    ArrayStack Avengers = myTicket.createMovie("Avengers");
	    ArrayStack Spiderman = myTicket.createMovie("Spiderman");
        ArrayStack Deadpool = myTicket.createMovie("Deadpool");
        ArrayStack Punisher = myTicket.createMovie("Punisher");
        ArrayStack SherlockHomes = myTicket.createMovie("SherlockHomes");
        myTicket.movieMenu(Avengers,Spiderman,Deadpool,Punisher,SherlockHomes);
    }
}
