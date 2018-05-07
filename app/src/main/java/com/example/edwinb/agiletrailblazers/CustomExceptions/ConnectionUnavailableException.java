package com.example.edwinb.agiletrailblazers.CustomExceptions;

public class ConnectionUnavailableException extends Exception {

    public ConnectionUnavailableException() { super(); }
    public ConnectionUnavailableException(String message) { super(message); }
    public ConnectionUnavailableException(String message, Throwable cause) { super(message, cause); }
    public ConnectionUnavailableException(Throwable cause) { super(cause); }

}
