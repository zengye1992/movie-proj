import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Session {
	
	
	private Movie movie;
	private String cineplexName;
	private String cinemaCode;
	private Date dateMovieStart;
	private Seat[][] seatLayout; 
    
    //constructor
    public Session() {
		
		this.movie = null;
		this.cineplexName ="";
		this.cinemaCode ="";
		this.dateMovieStart = null;
		this.seatLayout=null;
	}
    //constructor 
	public Session(Movie movie, Cineplex cineplex, Cinema cinema,
			Date dateMovieStart) {
		
		this.movie = movie;
		this.cineplexName = cineplex.getCineplexName();
		this.cinemaCode = cinema.getCinemaCode();
		this.dateMovieStart = dateMovieStart;
		if (cinema.isCinemaNormal()){
			for (int i=0;i<10;i++)
				for (int j=0;j<10;j++)
					seatLayout[i][j]=new Seat(i+1,j+1);
		}
		else{
			for (int i=0;i<5;i++)
				for (int j=0;j<5;j++)
					seatLayout[i][j]=new Seat(i+1,j+1);	
		}
	}
	
	public boolean isSeatOccupied(int row,int column){
		return seatLayout[row][column].isOccupied();
	}
	
    public void assignSeat(int row, int column){
		
		if(!isSeatOccupied(row,column)){
		    seatLayout[row][column].assign();
		    System.out.println("Seat Assigned!");
		}
		else
			System.out.println("Seat has already been occupied  to  another customer.");
		
		
	}
    public void printSessionLayout(){
    	
    }
    
    
    public Movie getMovie() {
		return movie;
	}



	public void setMovie(Movie movie) {
		this.movie = movie;
	}



	public Cineplex getCineplex() {
		return cineplex;
	}



	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}



	public Cinema getCinema() {
		return cinema;
	}



	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}



	public Date getdateMovieStart() {
		return dateMovieStart;
	}



	public void setdateMovieStart(Date dateMovieStart) {
		this.dateMovieStart = dateMovieStart;
	}

}
