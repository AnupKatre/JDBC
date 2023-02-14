package com.JDBC.Exception;

public class QueryFailedException extends Exception{
    private String msg;

    public QueryFailedException(String msg){
        super(msg);
        this.msg = msg;
    }

}
