package br.com.azship.admshipping.domain.exception;

public class FreightNotFoundException extends RuntimeException{
    public FreightNotFoundException(String message) {
        super(message);
    }
}
