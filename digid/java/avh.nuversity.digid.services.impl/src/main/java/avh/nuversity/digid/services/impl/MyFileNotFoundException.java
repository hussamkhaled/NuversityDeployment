package avh.nuversity.digid.services.impl;

	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class MyFileNotFoundException extends RuntimeException {
	    /**
		 * 
		 */
		private static final long serialVersionUID = -7934134458016353744L;

		public MyFileNotFoundException(String message) {
	        super(message);
	    }

	    public MyFileNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
