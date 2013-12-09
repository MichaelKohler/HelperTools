/* ============== HelperTools ==============
 * Initial developer: Lukas Diener <lukas.diener@hotmail.com>
 *
 * =====
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE - Version 2
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 *
 * =====
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.
 *
 */

package info.michaelkohler.helpertools.collections;

import static info.michaelkohler.helpertools.tools.Validator.checkArgument;
import static info.michaelkohler.helpertools.tools.Validator.checkNotNull;
import info.michaelkohler.helpertools.string.StringHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The |CollectionHelper| is a static class which helps
 * performing batch operations on collections.
 *
 * @author Lukas Diener, Victor J. Reventos
 * @version 0.0.2
 */
public final class CollectionHelper {

    /**
     * Empty private constructor, no instantiation needed.
     */
    private CollectionHelper() {
        throw new AssertionError("Cannot instantiate this class");
    }

    /**
     * Collects a specific property of elements in a collection
     * and returns them as a Collection. It's possible to access
     * private properties.
     *
     * @throws NoSuchFieldException Signals that the class doesn't
     * have a field of a specified name.
     *
     * @param collection the collection to be traversed
     * @param <T> typed param for the collection
     * @param property the name of the property to be extracted
     *
     * @return a Collection of the selected properties
     */
    public static <T> Collection<Object> all(Collection<T> collection, String property)
        throws NoSuchFieldException {
        checkNotNull(collection, "collection cannot be null");
        checkArgument(!StringHelper.isNullOrEmpty(property),
                        "property cannot be null or empty");

        Collection<Object> properties = new ArrayList<Object>();
        for (T element : collection) {
            Class<? extends Object> elementClass = element.getClass();
            Field field = elementClass.getDeclaredField(property);

            //Make the field accessible even if private
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            try {
                properties.add(field.get(element));
            } catch (IllegalArgumentException e) {
                // this won't ever happen.
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // this as well.
                e.printStackTrace();
            }
        }

        return properties;
    }

    /**
     * Calls a function for every element in a collection
     * with the element as first parameter and the index as
     * the second.
     *
     * <pre>
     * {@code
     * // be myCollection a |Collection| of class myClass, which
     * // contains a property named myProperty of type |String|.
     * CollectionHelper.each(stringCollection, new IFunction<String>() {
     *   public void execute(String element, int index) {
     *      element.trim();
     *   }
     * });
     * }
     * </pre>
     *
     * @param collection the collection to be traversed
     * @param <T> typed param for the collection
     * @param function the method to be executed
     */
    public static <T> void each(Collection<T> collection, IFunction<T> function) {
        checkNotNull(collection, "collection cannot be null");
        checkNotNull(function, "function cannot be null");

        int index = 0;
        for (T element : collection) {
            function.execute(element, index);
            index++;
        }
    }

    /**
     * This method performs a union on two collections of elements as per definition of the <i>union</i> operation in set theory. 
     * The resulting collection guarantees unique membership as per implementation of the Java {@link java.util.Set} interface.
     * This is a null-safe operation.
     * @see <a href="http://en.wikipedia.org/wiki/Union_(set_theory)">Union (set theory)</a>
     * @param firstGroup Collection to be used.
     * @param secondGroup Collection to be used.
     * @return The resulting collection containing all distinct members from the two groups.
     */
    public static <T> Collection<T> union(Collection<T> firstGroup,
        Collection<T> secondGroup) {
      
      if(firstGroup == null)
        return secondGroup;
      else if(secondGroup == null)
        return firstGroup;
      else {
        Set<T> firstSet = new HashSet<T>(firstGroup);
        firstSet.addAll(secondGroup);
        return firstSet;
      }
    }

    /**
     * This method performs an intersection on two collections of elements as per definition of the <i>intersect</i> operation in set theory.
     * The resulting collection guarantees unique membership as per implementation of the Java {@link java.util.Set} interface.
     * This is a null-safe operation.
     * @see <a href="http://en.wikipedia.org/wiki/Union_(set_theory)">Union (set theory)</a>
     * @param firstGroup Collection to be used.
     * @param secondGroup Collection to be used.
     * @return The resulting collection containing all common members from the two groups.
     */
    public static <T> Collection<T> intersect(Collection<T> groupOne,
        Collection<T> groupTwo) {
      
      if(groupOne == null)
        return groupTwo;
      else if(groupTwo == null)
        return groupOne;
      else {
        Collection<T> results = new HashSet<T>();
        for(T listOneItem : groupOne)
          if(groupTwo.contains(listOneItem))
            results.add(listOneItem);
        return results;
      }
    }

    /**
     * 
     * @param groupOne
     * @param groupTwo
     * @return
     */
    public static <T> Collection<T> difference(Collection<T> groupOne,
        Collection<T> groupTwo) {
      
      if(groupOne == null)
        return groupTwo;
      else if(groupTwo == null)
        return groupOne;
      
      Set<T> results = new HashSet<T>();
      results.addAll(findGroupOneDelta(groupOne, groupTwo));
      results.addAll(findGroupTwoDelta(groupTwo, groupOne));
      
      return results;
    }

    private static <T> Set<T> findGroupOneDelta(Collection<T> groupOne,
        Collection<T> groupTwo) {
      
      Set<T> delta = new HashSet<T>();
      for(T groupOneItem : groupOne)
        if(!groupTwo.contains(groupOneItem))
          delta.add(groupOneItem);
      return delta;
    }
    
    private static <T> Set<T> findGroupTwoDelta(Collection<T> groupOne,
        Collection<T> groupTwo) {
      
      Set<T> delta = new HashSet<T>();
      for(T groupOneItem : groupOne)
        if(!groupTwo.contains(groupOneItem))
          delta.add(groupOneItem);
      return delta;
    }
}