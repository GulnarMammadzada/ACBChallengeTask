package az.acb.crud.challenge.exception;

public class RegionNotFoundException extends RuntimeException{
    public RegionNotFoundException(String message){
        super(message);
    }
}
