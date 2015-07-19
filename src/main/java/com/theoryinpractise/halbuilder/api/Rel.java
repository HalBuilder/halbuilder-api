package com.theoryinpractise.halbuilder.api;


import com.google.auto.value.AutoValue;

import java.util.Comparator;

public abstract class Rel {

  public abstract boolean isSingleton();

  public abstract String rel();

  public abstract Comparator<ReadableRepresentation> comparator();

  public static Singleton singleton(String rel) {
    return new AutoValue_Rel_Singleton(rel);
  }

  public static Sorted sorted(String rel, String id, Comparator<ReadableRepresentation> comparator) {
    return new AutoValue_Rel_Sorted(rel, id, comparator);
  }

  @AutoValue
  public abstract static class Singleton extends Rel {
    public abstract String rel();

    @Override
    public boolean isSingleton() {
      return true;
    }

    @Override
    public Comparator<ReadableRepresentation> comparator() {
      throw new UnsupportedOperationException("Singleton Rels don't have comparators");
    }
  }

  @AutoValue
  public abstract static class Sorted extends Rel {
    public abstract String rel();
    public abstract String id();
    public abstract Comparator<ReadableRepresentation> comparator();

    @Override
    public boolean isSingleton() {
      return false;
    }

  }

}
