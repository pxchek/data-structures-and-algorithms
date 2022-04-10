import java.util.Iterator;

/**
 * A multiset represents a group of objects (known as its <i>elements</i>) that may contain duplicate elements.
 * <p>
 * More formally, a multiset may contain pairs of elements <tt>e1</tt> and <tt>e2</tt> such that <tt>e1.equals(e2)</tt>, and in this case
 * <tt>e1</tt> and <tt>e2</tt> would be considered <i>copies</i> of each other inside the multiset. Note that if <tt>e1 == e2</tt>, they are
 * still considered copies of each other, even though they are the exact same object.
 *
 * @param <E>
 *            the type of elements maintained by this multiset
 */
public interface Multiset<E> extends Iterable<E> {

    /**
     * Adds one copy of the specified element to this multiset.
     *
     * @param object
     *            object to be added to this multiset
     */
    void add(E object);

    /**
     * Adds one or more copies of the specified element to this multiset.
     *
     * @param object
     *            object to be added to this multiset
     * @param copies
     *            number of copies of the element to add
     * @throws IllegalArgumentException
     *             if <tt>copies</tt> is less than 1
     */
    void add(E object, int copies);

    /**
     * Returns <tt>true</tt> if this multiset contains at least one copy of the specified element. More formally, returns <tt>true</tt> if
     * and only if this multiset contains at least one element <tt>e</tt> such that <tt>object.equals(e)</tt>.
     *
     * @param object
     *            object whose presence in this multiset is to be tested
     */
    boolean contains(E object);

    /**
     * Returns the number of copies of the specified element that this multiset contains. More formally, returns the number of elements in
     * this multiset where the element in the multiset is <tt>e</tt> and <tt>object.equals(e)</tt>.
     *
     * @param object
     *            object whose copies in this multiset are to be counted
     * @return the number of copies of the specified element that this multiset contains, or 0 if it is not present
     */
    int count(E object);

    /**
     * Removes all copies of the specified element from this multiset if any copies are present. More formally, removes all elements from
     * this multiset where the element from the multiset is <tt>e</tt> and <tt>object.equals(e)</tt>, if this multiset contains at least
     * one such element. (This multiset will not contain the element once the call returns.)
     *
     * @param object
     *            object to be removed from this multiset, if present
     */
    void removeAllCopies(E object);

    /**
     * Returns <tt>true</tt> if this multiset contains no elements.
     *
     * @return <tt>true</tt> if this multiset contains no elements
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this multiset.
     *
     * @return the number of elements in this multiset
     */
    int size();

    /**
     * Returns an iterator over the elements in this multiset. The elements are returned in no particular order (unless this multiset is an
     * instance of some class that provides a guarantee).
     *
     * @return an iterator over the elements in this multiset
     */
    @Override
    Iterator<E> iterator();

}
