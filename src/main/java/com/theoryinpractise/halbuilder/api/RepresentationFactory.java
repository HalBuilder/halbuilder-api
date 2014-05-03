package com.theoryinpractise.halbuilder.api;

import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

public abstract class RepresentationFactory {
    public static final String HAL_XML = "application/hal+xml";
    public static final String HAL_JSON = "application/hal+json";

    public static final URI PRETTY_PRINT = URI.create("urn:halbuilder:prettyprint");

    public static final URI COALESCE_LINKS = URI.create("urn:halbuilder:coalescelinks");

    public static final URI STRIP_NULLS = URI.create("urn:halbuilder:stripnulls");
    
    public static final URI SINGLE_ELEM_ARRAYS = URI.create("urn:halbuild:singleelemarrays");

    public static final URI HYPERTEXT_CACHE_PATTERN = URI.create("urn:halbuild:hypertextcachepattern");

    public abstract RepresentationFactory withNamespace(String namespace, String href);

    public abstract RepresentationFactory withLink(String rel, String href);

    public abstract RepresentationFactory withFlag(URI flag);

    public abstract Representation newRepresentation(URI uri);

    public abstract Representation newRepresentation();

    public abstract Representation newRepresentation(String href);

    public abstract ReadableRepresentation readRepresentation(String contentType, Reader reader);

    public abstract Set<URI> getFlags();

}
