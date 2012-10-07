package com.theoryinpractise.halbuilder.api;

/**
 * Implementers of this interface can provide customized means of representing a class
 * to a Representation.
 */
public interface Representable {

    /**
     * "Serializes" data to the given resource.
     * @param resource The resource to serialize into.
     */
    void representResource(Representation resource);

}
