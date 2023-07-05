package com.qst.crop.exception;
/**
 * token令牌过期失效异常
 */
public class InvalidateTokenException extends Exception{
    public InvalidateTokenException() {
    }

    public InvalidateTokenException(String message) {
        super(message);
    }
}
