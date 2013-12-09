package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.collections.CollectionHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CollectionHelperDifferenceTest {

  @Test
  public void testDifference_IntegerElement_NoCommonElements() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2); listOne.add(3);
    listOne.add(4); listOne.add(5); listOne.add(6);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(4); listTwo.add(5); listTwo.add(6);
    listTwo.add(7); listTwo.add(8); listTwo.add(9);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    expected.add(7); expected.add(8); expected.add(9);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_AllElementsAreDifferent() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2); listOne.add(3);
    listOne.add(4); listOne.add(5); listOne.add(6);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(7); listTwo.add(8); listTwo.add(9);
    listTwo.add(10); listTwo.add(11); listTwo.add(12);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    expected.add(4); expected.add(5); expected.add(6);
    expected.add(7); expected.add(8); expected.add(9);
    expected.add(10); expected.add(11); expected.add(12);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_FirstListIsEmpty() {
    List<Integer> listOne = new ArrayList<Integer>();
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(7); listTwo.add(8); listTwo.add(9);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(7); expected.add(8); expected.add(9);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_SecondListIsEmpty() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2); listOne.add(3);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_FirstListIsNull() {
    List<Integer> listOne = null;
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(7); listTwo.add(8); listTwo.add(9);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(7); expected.add(8); expected.add(9);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_SecondListIsNull() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(7); listOne.add(8); listOne.add(9);
    
    List<Integer> listTwo = null;
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(7); expected.add(8); expected.add(9);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_FirstListIsLonger() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2); listOne.add(3);
    listOne.add(4); listOne.add(5); listOne.add(6);
    listOne.add(7); listOne.add(8); listOne.add(9);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(7); listTwo.add(8); listTwo.add(9);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    expected.add(4); expected.add(5); expected.add(6);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_SecondListIsLonger() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2); listOne.add(3);
    listOne.add(4); listOne.add(5); listOne.add(6);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(4); listTwo.add(5); listTwo.add(6);
    listTwo.add(7); listTwo.add(8); listTwo.add(9);
    listTwo.add(10); listTwo.add(11); listTwo.add(12);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    expected.add(7); expected.add(8); expected.add(9);
    expected.add(10); expected.add(11); expected.add(12);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_FirstListIsSubset() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2); listOne.add(3);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(1); listTwo.add(2); listTwo.add(3);
    listTwo.add(7); listTwo.add(8); listTwo.add(9);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(7); expected.add(8); expected.add(9);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_IntegerElement_SecondListIsSubset() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2); listOne.add(3);
    listOne.add(7); listOne.add(8); listOne.add(9);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(1); listTwo.add(2); listTwo.add(3);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(7); expected.add(8); expected.add(9);
    
    Collection<Integer> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_StringElement_FirstListIsSubset() {
    List<String> listOne = new ArrayList<String>();
    listOne.add("Jane"); listOne.add("Elizabeth"); listOne.add("Lisa");
    
    List<String> listTwo = new ArrayList<String>();
    listTwo.add("Jane"); listTwo.add("Alexander"); listTwo.add("Lisa");
    listTwo.add("Bob"); listTwo.add("Lukaz"); listTwo.add("Elizabeth");
    
    List<String> expected = new ArrayList<String>();
    expected.add("Bob"); expected.add("Alexander"); expected.add("Lukaz");
    
    Collection<String> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(String item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_StringElement_SecondListIsSubset() {
    List<String> listOne = new ArrayList<String>();
    listOne.add("John"); listOne.add("Matthew"); listOne.add("Paul");
    listOne.add("Alex"); listOne.add("Arthur"); listOne.add("Troy");
    
    List<String> listTwo = new ArrayList<String>();
    listTwo.add("Matthew"); listTwo.add("Alex"); listTwo.add("Troy");
    
    List<String> expected = new ArrayList<String>();
    expected.add("John"); expected.add("Arthur"); expected.add("Paul");
    
    Collection<String> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(String item : expected)
      Assert.assertTrue(actual.contains(item));
  }
  
  @Test
  public void testDifference_StringElement_NoCommonElements() {
    List<String> listOne = new ArrayList<String>();
    listOne.add("John"); listOne.add("Marco"); listOne.add("Mike");
    listOne.add("Andrew"); listOne.add("Arthur"); listOne.add("Troy");
    
    List<String> listTwo = new ArrayList<String>();
    listTwo.add("Leslie"); listTwo.add("Susan"); listTwo.add("George");
    
    List<String> expected = new ArrayList<String>();
    expected.add("John"); expected.add("Marco"); expected.add("Mike");
    expected.add("Andrew"); expected.add("Arthur"); expected.add("Troy");
    expected.add("Leslie"); expected.add("Susan"); expected.add("George");
    
    Collection<String> actual = CollectionHelper.delta(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(String item : expected)
      Assert.assertTrue(actual.contains(item));
  }

}
