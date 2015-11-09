package com.theoryinpractise.halbuilder.api;

/**
 * Implementers of this interface can provide customized means of representing a class to a Representation.
 */
public interface Representable {

  /**
   * "Serializes" data against the given resource, returning a new Representation with updated data.
   *
   * @param resource The resource to serialize into.
   * @return An updated, persistent representation
   */
  Representation representResource(Representation resource);

}
