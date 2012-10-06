package com.theoryinpractise.halbuilder.api;

import java.io.Writer;
import java.net.URI;
import java.util.Set;

/**
 * A Renderer takes a ReadableRepresentation and renders it to the provided Writer, returning an
 * Optional value.
 * @param <T> A class to return.
 */
public interface Renderer<T> {

    /**
     * Writes the representation to the provided Writer.
     * @param representation The representation to render
     * @param flags A set of URI based flags to provide configuration to renderers
     * @param writer The Writer to write to
     */
    void render(ReadableRepresentation representation, Set<URI> flags, Writer writer);
}
