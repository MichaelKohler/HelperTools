package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.tools.Validator;

import org.junit.Test;

public class ValidatorTest {

	private static final String errorMsg = "There is a problem with the provided argument";
	
	@Test
	public void testTrueConditionDoesntThrowError() {	
		Validator.checkArgument(5 > 2, errorMsg); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalseConditionThrowsError() {	
		Validator.checkArgument(-1 > 2, errorMsg); 
	}
	
	@Test
	public void testNonNullDoesntThrowError() {
		Validator.checkNotNull("I'm not null", errorMsg);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullThrowsError() {
		Validator.checkNotNull(null, errorMsg);
	}
}
