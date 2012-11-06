package com.theoryinpractise.halbuilder.api;

import java.io.Writer;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A ReadableRepresentation is a read-only, immutable HAL Representation object.
 */
public interface ReadableRepresentation {

    /**
     * Returns a Link with a rel of "self".
     * @return A Link
     */
    Link getResourceLink();

    /**
     * Returns an ImmutableMap of the currently defined resource namespaces
     * @return A Map
     */
    Map<String, String> getNamespaces();

    /**
     * Returns an ImmutableList of individual Link instances on this resource.
     * @return A List of Links
     */
    List<Link> getCanonicalLinks();

    /**
     * Returns an ImmutableList of collated Link instances on this resource.
     *
     * Multiple links to the same resolved HREF are collated into a single Link
     * instance with a space separated combined rel attribute.
     * @return A List of Links
     */
    List<Link> getLinks();

    /**
     * Returns the first link matching the given rel by searching this, then
     * any embedded resource instance.
     * @param rel The rel type to search for.
     * @return A Guava Optional Link
     */
    Link getLinkByRel(String rel);

    /**
     * Returns all links matching the given rel by searching this, then
     * any embedded resource instance.
     * @param rel The rel type to search for.
     * @return An Immutable List of Links
     */
    List<Link> getLinksByRel(String rel);

    /**
     * Returns all embedded resources matching the given rel by searching this, then
     * any embedded resource instance.
     * @param rel The rel type to search for.
     * @return An Immutable List of Resources
     */
    List<? extends ReadableRepresentation> getResourcesByRel(String rel);

    /**
     * Returns a property from the Representation
     * @param name The property to return
     * @return An Object of the property value, or throws RepresentationException if missing
     */
    Object getValue(String name);

    /**
     * Returns a property from the Representation
     * @param name The property to return
     * @return An Object of the property value, or a user supplied default value
     */
    Object getValue(String name, Object defaultValue);

    /**
     * Returns an ImmutableMap of the resources properties.
     * @return A Map
     */
    Map<String, Object> getProperties();

    /**
     * Return an indication of whether this resource, or subresources of this
     * resource, contain null properties.
     * @return True if this resource, or subresources of this resource,
     * contain null properties.  False if not.
     */
    boolean hasNullProperties();

    /**
     * Returns an immutable Collection of the resources currently embedded in this resource.
     * @return A Map
     */
    Collection<Map.Entry<String, ReadableRepresentation>> getResources();

    /**
     * Returns a map of all embedded resources
     * @return
     */
    Map<String, Collection<ReadableRepresentation>> getResourceMap();

    /**
     * Returns whether this resource is satisfied by the provided Contact.
     * @param contract The contract to check.
     * @return A boolean
     */
    boolean isSatisfiedBy(Contract contract);

    /**
     * Returns an proxy to the given interface mirroring the resource.
     *
     * @param anInterface An interface to mirror
     * @return A Representation Proxy or throws a RepresentationException
     */
    <T> T toClass(Class<T> anInterface);

    /**
     * Returns the resource in the requested content-type.
     *
     * application/hal+xml and application/hal+json are provided by default,
     * additional Renderers can be added to a RepresentationFactory.
     *
     * @param contentType The content type requested
     * @return A String
     */
    String toString(String contentType);

    /**
     * Returns the resource in the requested content-type, along with additional flags.
     *
     * application/hal+xml and application/hal+json are provided by default,
     * additional Renderers can be added to a RepresentationFactory.
     *
     * @param contentType The content type requested
     * @param flags A set of URI based flags to customize rendering
     * @return A String
     */
    String toString(String contentType, final Set<URI> flags);

    /**
     * Write the resource in the requested content-type, to the specified Writer
     *
     * application/hal+xml and application/hal+json are provided by default,
     * additional Renderers can be added to a RepresentationFactory.
     *
     * @param contentType The content type requested
     * @param writer The Writer to write to
     */
    void toString(String contentType, Writer writer);

    /**
     * Write the resource in the requested content-type, along with additional flags to the specified Writer
     *
     * application/hal+xml and application/hal+json are provided by default,
     * additional Renderers can be added to a RepresentationFactory.
     *
     * @param contentType The content type requested
     * @param flags A set of URI based flags to customize rendering
     * @param writer The Writer to write to
     */
    void toString(String contentType, final Set<URI> flags, Writer writer);

}
