package com.epam.wizzair.page.exception;

/**
 * Created by Dzmitry_Sankouski on 06-Mar-17.
 */
public class ElementNotActiveException extends Exception{
    public ElementNotActiveException(){

    }

    public ElementNotActiveException(String message){
        super(message);
    }
}
