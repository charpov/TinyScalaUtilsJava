package tinyscalautils.java;

import java.util.*;
import java.util.random.RandomGenerator;

/**
 * Java wrappers for collection functions.
 * <p>
 * This class cannot be instantiated.
 * </p>
 *
 * @see <a href="https://charpov.github.io/TinyScalaUtils/tinyscalautils/collection.html">
 * tinyscalautils.collection
 * </a>
 * @since 1.0
 */
public class Collection {
  private Collection() {
    throw new AssertionError("this class cannot be instantiated");
  }

  private static final CollectionScala collection = new CollectionScala();

  public static <A> Iterator<A> circular(Iterable<A> iterable) {
    return collection.circular(iterable);
  }

  public static <A> Iterator<A> randomly(Iterable<A> iterable, RandomGenerator rand) {
    return collection.randomly(iterable, rand);
  }

  public static <A> A pickOne(Iterable<A> iterable, RandomGenerator rand) {
    return collection.pickOne(iterable, rand);
  }

  public static <A> Optional<A> pickOneOption(Iterable<A> iterable, RandomGenerator rand) {
    return collection.pickOneOption(iterable, rand);
  }

  /**
   * Mutable Java lists.
   */
  public static class JavaList {
    private JavaList() {
      throw new AssertionError("this class cannot be instantiated");
    }

    /**
     * Like {@code java.util.List.of} except that the list is mutable.
     */
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <A> List<A> of(A... values) {
      return new ArrayList<>(List.of(values));
    }
  }
}
