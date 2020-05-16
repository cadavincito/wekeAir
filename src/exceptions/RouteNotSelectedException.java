package exceptions;

public class RouteNotSelectedException extends Exception {

	public RouteNotSelectedException(String message) {
		
		
		super("You must select both origin and destination to calculate the "+message+" flight");
		
	}

}
