package iv1201.group1.applications.recruitment.error;

/**
 * Email already exists in the database. Email cannot be registered with this email
 */
public final class EmailAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmailAlreadyExistException() {
        super();
    }

    public EmailAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyExistException(final String message) {
        super(message);
    }

    public EmailAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
