package info.michaelkohler.helpertools.collections;

/**
 * The |IFunction| is an interface to be used
 * with {@link CollectionHelper}.
 *
 * @author Lukas Diener
 * @version 0.0.1
 */
public interface IFunction<T> {

    /**
     * This method will be executed for every element in
     * a collection when you use
     * {@link CollectionHelper#each(java.util.Collection, IFunction)}.
     *
     * @param element the current element
     * @param index the current index in the collection
     */
    void execute(T element, int index);
}