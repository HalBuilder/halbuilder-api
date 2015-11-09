package com.theoryinpractise.halbuilder.api;

/**
 * The exception thrown for any HalBuilder based error.
 */
public class RepresentationException
    extends RuntimeException {
  public RepresentationException(String s) {
    super(s);
  }

  public RepresentationException(Throwable throwable) {
    super(throwable);
  }
}
