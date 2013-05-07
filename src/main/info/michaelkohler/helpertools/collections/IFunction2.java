package info.michaelkohler.helpertools.collections;

/**
 * The |IFunction2| emulates a function with a return value.<br>
 * R is the return value and T is the type of the argument.
 * @author Victor J. Reventos
 * @version 0.0.1
 */
public interface IFunction2<R,T> {
    
    /**
     * Executes the implemented function
     * @param element 
     * @return the value returned by the implemented function
     */
    R execute(T element);
}
