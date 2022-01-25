package exceptions;

public class NotEnoughMoneyException extends Error {
    public NotEnoughMoneyException(String message){
        super(message);
    }
}
