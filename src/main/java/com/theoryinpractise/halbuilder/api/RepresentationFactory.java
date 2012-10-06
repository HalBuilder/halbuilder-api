package com.theoryinpractise.halbuilder.api;

import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

public abstract class RepresentationFactory {
    public static final String HAL_XML = "application/hal+xml";
    public static final String HAL_JSON = "application/hal+json";

    public static final URI PRETTY_PRINT = makeUri("urn:halbuilder:prettyprint");

    protected static URI makeUri(String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new RepresentationException(e);
        }
    }

    public abstract String getBaseHref();

    public abstract RepresentationFactory withNamespace(String namespace, String url);

    public abstract RepresentationFactory withLink(String url, String rel);

    public abstract RepresentationFactory withFlag(URI flag);

    public abstract Representation newRepresentation(URI uri);

    public abstract Representation newRepresentation();

    public abstract Representation newRepresentation(String href);

    public abstract ReadableRepresentation readRepresentation(Reader reader);

    public abstract Renderer<String> lookupRenderer(String contentType);

    public abstract Set<URI> getFlags();

}
