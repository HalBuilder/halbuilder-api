package com.theoryinpractise.halbuilder.api;

import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

public abstract class RepresentationFactory {
    public static final String HAL_XML = "application/hal+xml";
    public static final String HAL_JSON = "application/hal+json";

    public static final URI PRETTY_PRINT = makeUri("urn:halbuilder:prettyprint");

    public static final URI COALESCE_LINKS = makeUri("urn:halbuilder:coalescelinks");

    public static final URI STRIP_NULLS = makeUri("urn:halbuilder:stripnulls");

    protected static URI makeUri(String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new RepresentationException(e);
        }
    }

    public abstract RepresentationFactory withNamespace(String namespace, String href);

    public abstract RepresentationFactory withLink(String rel, String href);

    public abstract RepresentationFactory withFlag(URI flag);

    public abstract Representation newRepresentation(URI uri);

    public abstract Representation newRepresentation();

    public abstract Representation newRepresentation(String href);

    public abstract ReadableRepresentation readRepresentation(Reader reader);

    public abstract RepresentationWriter<String> lookupRenderer(String contentType);

    public abstract Set<URI> getFlags();

}
