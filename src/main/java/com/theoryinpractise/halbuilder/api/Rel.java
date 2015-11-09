package com.theoryinpractise.halbuilder.api;

import org.derive4j.Data;

import java.util.Comparator;

/**
 * Rel defines the base class of a Algebraic Data Type for relationship semantics.
 */
@Data
public abstract class Rel {

  public static final Comparator<ReadableRepresentation> naturalComparator =
      Comparator.comparing(rep -> rep.getResourceLink()
                                     .map(Link::getRel)
                                     .orElse(""));

  @Override
  public abstract String toString();

  public String fullRel() {
    return this.match(Rels.cases(
        (rel) -> rel,
        (rel) -> rel,
        (rel, id, comarator) -> String.format("%s sorted:%s", rel, id)
    ));
  }

  public abstract <R> R match(Cases<R> cases);

  public String rel() {
    return this.match(Rels.cases(
        (rel) -> rel,
        (rel) -> rel,
        (rel, id, comarator) -> rel
    ));
  }

  /**
   * The data type covers three separate cases: singleton, natural, and sorted.
   *
   * @param <R> The return type used in the various derive4j generated mapping functions.
   */
  interface Cases<R> {

    /**
     * `singleton` relationships are checked for uniqueness, and render directly as an object ( rather than array of objects )
     * when rendered as JSON.
     *
     * @param rel The relationship type
     */
    R singleton(String rel);

    /**
     * `natural` relationships are rendered in natural order, and are rendered as a list of objects.
     *
     * @param rel The relationship type
     */
    R natural(String rel);

    /**
     * `sorted` relationships are rendered in the order mandated by the associated `Comparator` and are rendered as a list of
     * objects.
     *
     * @param rel        The relationship type
     * @param id         An identifier to associate with the sorting technique used.
     * @param comparator The comparator to use when sorting representations.
     */
    R sorted(String rel, String id, Comparator<ReadableRepresentation> comparator);
  }

}
