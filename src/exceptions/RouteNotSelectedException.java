package exceptions;

public class RouteNotSelectedException extends Exception {
	
	private static final long serialVersionUID = 2L;

	public RouteNotSelectedException(String message) {
		
		
		super("You must select both origin and destination to calculate the "+message+" flight");
		
	}

}