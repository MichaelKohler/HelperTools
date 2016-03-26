/* ============== HelperTools ==============
 * Initial developer: Lukas Diener (@LukasSkywalker)
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.michaelkohler.helpertools.string.StringHelper;

import org.junit.Test;

public class StringHelperTest {
    private static String nil;
    private static String nothing = new String();
    private static String empty = new String("");
    private static String one = "myString1";
    private static String two = "myStringTwo";
    private static String three = "myThirdString";

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

    @Test
    public void testCharCount() {
        String s = "baccbd";
        char noChars = 'z';
        char oneChars = 'a';
        char twoChars = 'b';
        
        assertEquals(0, StringHelper.countChar(s, noChars));
        // ^^ Regression test to prevent ArrayIndexOutOfBounds on no char found
        assertEquals(1, StringHelper.countChar(s, oneChars));
        assertEquals(2, StringHelper.countChar(s, twoChars));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullJoinItems() {
        StringHelper.join(null, ",");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyJoinItems() {
        StringHelper.join(new String[]{}, ",");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullCountCharArg() {
        StringHelper.countChar(null, 'a');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullPrepadArg() {
        StringHelper.prepad(null, 10, 'e');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullPostpadArg() {
        StringHelper.postpad(null, 10, 'e');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullTextReplace() {
        StringHelper.replaceWithoutRepetition(null, "find", "replace");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullFindReplace() {
        StringHelper.replaceWithoutRepetition("text", null, "replace");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullReplaceArg() {
        StringHelper.replaceWithoutRepetition("text", "find", null);
    }
    
    @Test
    public void testEmptyTextReplace() {
        StringHelper.replaceWithoutRepetition("", "find", "replace");
    }
    
    @Test
    public void testEmptyFindReplace() {
        StringHelper.replaceWithoutRepetition("text", "", "replace");
    }
    
    @Test
    public void testEmptyReplaceArg() {
        StringHelper.replaceWithoutRepetition("text", "find", "");
    }
    
    @Test
    public void testNullAndEmptyReverseArg(){
        assertEquals("",StringHelper.reverse(""));
        assertEquals(null,StringHelper.reverse(null));
    }
    
    public void testNullIterableJoinArg(){
        assertEquals(null,StringHelper.join(null, '.'));
    }
    
    @Test
    public void testReverse(){
        String test = "abc";
        assertEquals("cba", StringHelper.reverse(test));
    }
    
    @Test
    public void testJoinIterable(){
        List<String> a = new ArrayList<String>(Arrays.asList("apu","jil","joe"));
        String expected = "apu,jil,joe";
        assertEquals(expected,StringHelper.join(a,','));
    }
    
    @Test
    public void testJoinIterableOneItem(){
        List<String> a = new ArrayList<String>(1);
        a.add("apu");
        String expected = "apu";
        assertEquals(expected,StringHelper.join(a,','));
    }
    
    @Test
    public void testIndexOfDifferenceWithDifferences(){
        String s1 = "abc";
        String s2 = "abcd";
        assertEquals(3, StringHelper.indexOfDifference(s1, s2));
        
        s1 = "abc";
        s2 = "adc";
        assertEquals(1, StringHelper.indexOfDifference(s1, s2));
        
        s1 = "";
        s2 = "adc";
        assertEquals(0, StringHelper.indexOfDifference(s1, s2));
    }
    
    @Test
    public void testIndexOfDifferenceWithNoDifferences(){
        String s1 = "";
        String s2 = "";
        assertEquals(-1, StringHelper.indexOfDifference(s1, s2));
        
        s1 = "abc";
        s2 = "abc";
        assertEquals(-1, StringHelper.indexOfDifference(s1, s2));
    }
    
}