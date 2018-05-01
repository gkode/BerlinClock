package com.ubs.opsit.interviews.exception;

public class BerlinTimeException extends RuntimeException
{
    public BerlinTimeException(String msg)
    {
        super(msg);
    }

    public BerlinTimeException(Throwable t, String msg)
    {
        super(msg, t);
    }
}
