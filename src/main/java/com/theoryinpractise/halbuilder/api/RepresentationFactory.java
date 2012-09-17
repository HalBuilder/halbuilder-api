package com.theoryinpractise.halbuilder.api;

import java.io.Reader;
import java.net.URI;

public interface RepresentationFactory {
    String HAL_XML = "application/hal+xml";
    String HAL_JSON = "application/hal+json";

    String getBaseHref();

    RepresentationFactory withNamespace(String namespace, String url);

    RepresentationFactory withLink(String url, String rel);

    Representation newRepresentation(URI uri);

    Representation newRepresentation();

    Representation newRepresentation(String href);

    ReadableRepresentation readRepresentation(Reader reader);

    Renderer<String> lookupRenderer(String contentType);

}
