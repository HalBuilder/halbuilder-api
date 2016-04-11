package com.theoryinpractise.halbuilder.api;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.List;
import javaslang.collection.Map;
import javaslang.collection.Set;
import javaslang.collection.TreeMap;
import javaslang.control.Option;

import java.util.Objects;

public class Multimap<K extends Comparable, V> {

  private Map<K, List<V>> map;

  private Multimap(Map<K, List<V>> map) {
    this.map = map;
  }

  public static <K extends Comparable, V> Multimap<K, V> empty() {
    return new Multimap<>(TreeMap.empty());
  }

  public List<V> get(K key) {
    return map.get(key).getOrElse(List.empty());
  }

  public Set<K> keySet() {
    return map.keySet();
  }

  public Multimap<K, V> put(K key, V value) {
    List<V> values = map.get(key).getOrElse(List.empty())
                        .append(value);
    Map<K, List<V>> updatedMap = map.put(key, values);

    return new Multimap<>(updatedMap);
  }

  public Multimap<K, V> put(Tuple2<? extends K, ? extends V> entry) {
    return put(entry._1, entry._2);
  }

  public Multimap<K, V> remove(K key) {
    return new Multimap<>(map.remove(key));
  }

  public Multimap<K, V> removeAll(Iterable<? extends K> keys) {
    return new Multimap<>(map.removeAll(keys));
  }

  public int size() {
    return map.values().foldLeft(0, (a, v) -> a + v.length());
  }

  public Map<K, List<V>> asMap() {
    return map;
  }

  public List<Tuple2<K, V>> entries() {
    return map.foldLeft(List.empty(), (a, vs) -> a.appendAll(vs._2.map(v -> Tuple.of(vs._1, v))));
  }

  public boolean containsEntry(K key, V value) {
    return map.get(key)
              .flatMap(keyList -> keyList.contains(value) ? Option.of(value) : Option.none())
              .isDefined();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Multimap<?, ?> multimap = (Multimap<?, ?>) o;
    return Objects.equals(map, multimap.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(map);
  }

}
