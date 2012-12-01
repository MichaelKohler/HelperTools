/* ============== HelperTools ==============
 * Initial developer: Michael Kohler <michaelkohler@live.com>
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

package info.michaelkohler.helpertools.tools;

/**
 * Validator is inspired by Google Guava as linked below and is used in lieu of
 * adding the full Google Guava library package to this project.
 * 
 * https://code.google.com/p/guava-libraries/wiki/PreconditionsExplained
 * 
 * This class helps to add precondition argument checks to public methods to
 * avoid Null as much as possible as also inspired by Google Guava here:
 * 
 * https://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained
 * 
 * @author markyv
 * @version 0.0.4
 */
public class Validator {

	/**
	 * Validates that an expression is true and throws an error if it false.
	 * This is meant to be used in validating arguments for public methods.
	 * 
	 * @param expression The expression to evaluate as true, an assertion
	 * @param errorMessage The error message to provide for the thrown exception
	 * @throws IllegalArgumentException 
	 * 		with the provided errorMessage if expression is false
	 */
	public static void checkArgument(boolean expression, String errorMessage) {
		if (!expression) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	/**
	 * Convenience method to validate an argument is not null. Rather than throw
	 * a NullPointerError, throw an
	 * 
	 * @param toCheck The object to confirm is not null
	 * @param errorMessage The error message to provide for the thrown exception
	 * @return toCheck as a convenience for assignment
	 * @throws IllegalArgumentException
	 *             to make it clear that there is a problem with the argument
	 *             being supplied to the method rather than a bug in the method
	 *             itself.
	 * @see Validator#checkArgument(boolean, String)
	 */
	public static Object checkNotNull(Object toCheck, String errorMessage) {
		checkArgument(null != toCheck, errorMessage);
		return toCheck;
	}
}
