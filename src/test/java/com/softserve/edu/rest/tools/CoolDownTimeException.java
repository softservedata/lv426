package com.softserve.edu.rest.tools;

public class CoolDownTimeException extends RuntimeException {

    public CoolDownTimeException(String massage){
        super(massage);
    }
}
