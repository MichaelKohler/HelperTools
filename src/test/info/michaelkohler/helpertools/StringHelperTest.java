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
package info.michaelkohler.helpertools;

import static org.junit.Assert.assertEquals;
import info.michaelkohler.helpertools.string.StringHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {
	private static String nil;
	private static String nothing = new String();
	private static String empty = new String("");
	private static String one = "myString1";
	private static String two = "myStringTwo";
	private static String three = "myThirdString";

	public StringHelperTest() {

	}

	@Before
	public void setUp() {
		// nothing yet
	}

	@Test
	public void nullOrEmptyShouldWorkAsExpected() {
		assertEquals(StringHelper.isNullOrEmpty(nil), true);
		assertEquals(StringHelper.isNullOrEmpty(nothing), true);
		assertEquals(StringHelper.isNullOrEmpty(empty), true);
		assertEquals(StringHelper.isNullOrEmpty(one), false);
	}

	@Test
	public void joinShouldJoin() {
		assertEquals(StringHelper.join(new String[] { one, two }, ""),
				"myString1myStringTwo");
		assertEquals(StringHelper.join(new String[] { one, two }, " "),
				"myString1 myStringTwo");
		assertEquals(StringHelper.join(new String[] { three, two }, one),
				"myThirdStringmyString1myStringTwo");
		assertEquals(StringHelper.join(new String[] { one, two }, "."),
				"myString1.myStringTwo");

		assertEquals(StringHelper.join(new String[] { one, two }, nil),
				"myString1nullmyStringTwo");
		assertEquals(StringHelper.join(new String[] { one, nil }, " "),
				"myString1 null");
		assertEquals(StringHelper.join(new String[] { nil, one }, " "),
				"null myString1");
	}

	@Test
	public void replaceShouldWork() {
		assertEquals(StringHelper.replaceWithoutRepetition(
				"My house is a house keeper", "house", "house keeper"),
				"My house keeper is a house keeper");
		assertEquals(StringHelper.replaceWithoutRepetition(
				"My house is a housekeeper", "house", "housekeeper"),
				"My housekeeper is a housekeeper");
		assertEquals(StringHelper.replaceWithoutRepetition(
				"My big house is a house", "house", "big house"),
				"My big house is a big house");
		assertEquals(StringHelper.replaceWithoutRepetition(
				"Lukas Diener's name is Lukas", "Lukas", "Lukas Diener"),
				"Lukas Diener's name is Lukas Diener");
	}

	@Test
	public void prePadding() {
		assertEquals(StringHelper.prepad("asdf", 6, 'a'), "aaasdf");
		assertEquals(StringHelper.prepad("asdf", 6, ' '), "  asdf");
		assertEquals(StringHelper.prepad("asdf", 3, 'a'), "asdf");
	}

	@Test
	public void numberPrePadding() {
		assertEquals(StringHelper.prepadNumber(1234, 6), "001234");
		assertEquals(StringHelper.prepadNumber(234, 2), "234");
		assertEquals(StringHelper.prepadNumber(3, -10), "3");
	}

	@Test
	public void postPadding() {
		assertEquals(StringHelper.postpad("asdf", 6, 'a'), "asdfaa");
		assertEquals(StringHelper.postpad("asdf", 6, ' '), "asdf  ");
		assertEquals(StringHelper.postpad("asdf", 3, 'a'), "asdf");
	}

	@After
	public void tearDown() {
		// nothing to do here
	}
}