package cm.cti.utilisateur.exceptions ;

public class FormValidationException extends Exception {
	private static final long serialVersionUID = 1L;

	public FormValidationException(String message) {
		super(message);
	}
}
