package com.theoryinpractise.halbuilder.api;

import java.net.URI;

public interface Representation extends ReadableRepresentation {

    Representation withLink(String rel, String href);

    Representation withLink(String rel, URI uri);

    Representation withLink(String rel, String href, String name, String title, String hreflang, String profile);

    Representation withProperty(String name, Object value);

    Representation withBean(Object value);

    Representation withFields(Object value);

    Representation withRepresentable(Representable representable);

    Representation withFieldBasedRepresentation(String rel, String href, Object o);

    Representation withBeanBasedRepresentation(String rel, String href, Object o);

    Representation withNamespace(String namespace, String href);

    Representation withRepresentation(String rel, ReadableRepresentation resource);

}
