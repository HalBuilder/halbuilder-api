package com.theoryinpractise.halbuilder.api;

import java.io.Reader;

/**
 * A RepresentationReader takes a Reader and loads/parses it's contents into a ReadableRepresentation.
 */
public interface RepresentationReader {

  /**
   * Read some remote content into a ReadableRepresentation.
   *
   * @param source The source content to read.
   * @return The ReadableRepresentation
   */
  ReadableRepresentation read(Reader source);

}
