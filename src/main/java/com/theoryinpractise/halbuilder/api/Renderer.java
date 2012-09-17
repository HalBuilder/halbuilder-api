package com.theoryinpractise.halbuilder.api;

import java.io.Writer;

/**
 * A Renderer takes a ReadableRepresentation and renders it to the provided Writer, returning an
 * Optional value.
 * @param <T> A class to return.
 */
public interface Renderer<T> {

    /**
     * Writes the representation to the provided Writer.
     * @param representation The representation to render
     * @param writer The Writer to write to
     */
    void render(ReadableRepresentation representation, Writer writer);
}
