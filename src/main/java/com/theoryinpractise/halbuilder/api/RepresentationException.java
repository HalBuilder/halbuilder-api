package com.theoryinpractise.halbuilder.api;

/**
 * The exception thrown for any HalBuilder based error.
 */
public class RepresentationException
    extends RuntimeException {
  public RepresentationException(String message) {
    super(message);
  }

  public RepresentationException(Throwable throwable) {
    super(throwable);
  }

  public RepresentationException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
