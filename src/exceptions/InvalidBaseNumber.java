package exceptions;

public class InvalidBaseNumber extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidBaseNumber(String msg) {
		super(msg);
	}

}
