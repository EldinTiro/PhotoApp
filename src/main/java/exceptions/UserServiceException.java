package exceptions;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = 2013035264804704252L;

    public UserServiceException(String message) {
        super(message);
    }
}
