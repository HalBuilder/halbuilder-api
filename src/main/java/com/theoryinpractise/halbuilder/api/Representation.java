package com.theoryinpractise.halbuilder.api;

import javaslang.collection.Map;

import java.net.URI;

/**
 * An extension of the `ReadableRepresentation` interface that provides mutation methods, this interface does not prescribe the
 * implementing class to be either mutable or persistent so care should be used.
 */
public interface Representation
    extends ReadableRepresentation {

  Representation withRel(Rel rel);

  Representation withLink(String rel, String href);

  Representation withLink(String rel, URI uri);

  Representation withLink(String rel, String href, String name, String title, String hreflang,
                          String profile);

  Representation withProperty(String name, Object value);

  Representation withProperties(Map<String, Object> properties);

  Representation withBean(Object value);

  Representation withFields(Object value);

  Representation withRepresentable(Representable representable);

  Representation withFieldBasedRepresentation(String rel, String href, Object o);

  Representation withBeanBasedRepresentation(String rel, String href, Object o);

  Representation withNamespace(String namespace, String href);

  Representation withRepresentation(String rel, ReadableRepresentation resource);
}
