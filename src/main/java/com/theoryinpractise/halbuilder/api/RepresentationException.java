package com.theoryinpractise.halbuilder.api;

public class RepresentationException extends RuntimeException {
    public RepresentationException(String s) {
        super(s);
    }

    public RepresentationException(Throwable throwable) {
        super(throwable);
    }
}
