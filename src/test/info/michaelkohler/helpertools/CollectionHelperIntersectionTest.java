package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.collections.CollectionHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CollectionHelperIntersectionTest {
  
  // When testing for unique membership, the codes iterate through the 'expected' collection (instead of the 'actual' collection)
  // to ensures that each unique expected item is verified for membership in the 'actual' collection. 
  // Given that the size of the 'actual' collection has already been verified to be equal to that of the 'expected' collection,
  // if an 'expected' item is not found in the 'actual' collection, then either:
  // 1. the 'actual' collection contains erroneous result or, 
  // 2. the 'actual' collection is not unique.

  @Test
  public void testIntersectionOfTwoLists_TotalCount_Test1() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2);
    listOne.add(3); listOne.add(4);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(2); listTwo.add(3);
    listTwo.add(4); listTwo.add(5);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(2); expected.add(3);
    expected.add(4);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
  }
  
  @Test
  public void testIntersectionOfTwoLists_FindCommonElements_Test1() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2);
    listOne.add(3); listOne.add(4);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(2); listTwo.add(3);
    listTwo.add(4); listTwo.add(5);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(2); expected.add(3);
    expected.add(4);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    for(Integer value : actual)
      Assert.assertTrue(expected.contains(value));
  }
  
  @Test
  public void testIntersectionOfTwoLists_TotalCount_Test2() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1000); listOne.add(2000); listOne.add(3000); 
    listOne.add(4000); listOne.add(5000); listOne.add(6000);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(2000); listTwo.add(3000); listTwo.add(4000);
    listTwo.add(5000); listTwo.add(6000); listTwo.add(7000);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(2000); expected.add(30000); expected.add(4000);
    expected.add(5000); expected.add(60000);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
  }
  
  @Test
  public void testIntersectionOfTwoLists_FindCommonElements_Test2() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1000); listOne.add(2000); listOne.add(3000); 
    listOne.add(4000); listOne.add(5000); listOne.add(6000);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(2000); listTwo.add(3000); listTwo.add(4000);
    listTwo.add(5000); listTwo.add(6000); listTwo.add(7000);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(2000); expected.add(3000); expected.add(4000);
    expected.add(5000); expected.add(6000);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    for(Integer expectedItem : expected)
      Assert.assertTrue(actual.contains(expectedItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_FindCommonElements_ShorterFirstList() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1000);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(1000); listTwo.add(2000); listTwo.add(3000); 
    listTwo.add(4000); listTwo.add(5000); listTwo.add(6000); 
    listTwo.add(7000);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1000);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    for(Integer expectedItem : expected)
      Assert.assertTrue(actual.contains(expectedItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_FindCommonElements_ShorterSecondList() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1000); listOne.add(2000); listOne.add(3000); 
    listOne.add(4000); listOne.add(5000); listOne.add(6000); 
    listOne.add(7000);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(1000);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1000);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    for(Integer expectedItem : expected)
      Assert.assertTrue(actual.contains(expectedItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_NoDuplicates_TotalCount_Test1() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1000); listOne.add(2000); listOne.add(3000);
    listOne.add(4000); listOne.add(5000); listOne.add(6000);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(1000); listTwo.add(2000); listTwo.add(3000);
    listTwo.add(4000); listTwo.add(5000); listTwo.add(6000);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1000); expected.add(2000); expected.add(3000);
    expected.add(4000); expected.add(5000); expected.add(6000);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
  }
  
  @Test
  public void testIntersectionOfTwoLists_NoDuplicates_Test1() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1000); listOne.add(2000); listOne.add(3000);
    listOne.add(4000); listOne.add(5000); listOne.add(6000);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(1000); listTwo.add(2000); listTwo.add(3000);
    listTwo.add(4000); listTwo.add(5000); listTwo.add(6000);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1000); expected.add(2000); expected.add(3000);
    expected.add(4000); expected.add(5000); expected.add(6000);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    for(Integer expectedItem : expected)
      Assert.assertTrue(actual.contains(expectedItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_NoDuplicates_TotalCount_Test2() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1000); listOne.add(2000); listOne.add(3000);
    listOne.add(4000); listOne.add(5000); listOne.add(6000);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(3000); listTwo.add(4000); listTwo.add(5000);
    listTwo.add(7000); listTwo.add(8000); listTwo.add(9000);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(3000); expected.add(4000); expected.add(5000);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
  }
  
  @Test
  public void testIntersectionOfTwoLists_NoDuplicates_NoDuplicates_Test2() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1000); listOne.add(2000); listOne.add(3000);
    listOne.add(4000); listOne.add(5000); listOne.add(6000);
    
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(3000); listTwo.add(4000); listTwo.add(5000);
    listTwo.add(7000); listTwo.add(8000); listTwo.add(9000);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(3000); expected.add(4000); expected.add(5000);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    for(Integer expectedItem : expected)
      Assert.assertTrue(actual.contains(expectedItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_EmptyList() {
    List<Integer> listOne = new ArrayList<Integer>();
    List<Integer> listTwo = new ArrayList<Integer>();
    List<Integer> expected = new ArrayList<Integer>();
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    Assert.assertTrue(actual.isEmpty());
  }
  
  @Test
  public void testIntersectionOfTwoLists_IsNullSafe_FirstListIsNull() {
    List<Integer> listOne = null;
    List<Integer> listTwo = new ArrayList<Integer>();
    listTwo.add(1); listTwo.add(2); listTwo.add(3);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer secondListItem : listTwo)
      Assert.assertTrue(actual.contains(secondListItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_IsNullSafe_SecondListIsNull() {
    List<Integer> listOne = new ArrayList<Integer>();
    listOne.add(1); listOne.add(2); listOne.add(3);
    
    List<Integer> listTwo = null;
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    
    Collection<Integer> actual = CollectionHelper.intersect(listOne, listTwo);
    Assert.assertEquals(expected.size(), actual.size());
    for(Integer firstListItem : listOne)
      Assert.assertTrue(actual.contains(firstListItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_ExcludedElements_IntegerType() {
    List<Integer> firstNamesList = new ArrayList<Integer>();
    firstNamesList.add(1); firstNamesList.add(2); firstNamesList.add(3);
    firstNamesList.add(4); firstNamesList.add(5);
    
    List<Integer> secondNamesList = new ArrayList<Integer>();
    secondNamesList.add(1); secondNamesList.add(2); secondNamesList.add(3);
    
    List<Integer> expectedExcluded = new ArrayList<Integer>();
    expectedExcluded.add(4); expectedExcluded.add(5);
    
    Collection<Integer> actual = CollectionHelper.intersect(firstNamesList, secondNamesList);
    Assert.assertEquals(3, actual.size());
    for(Integer excluded : expectedExcluded)
      Assert.assertTrue(!actual.contains(excluded));
  }
  
  @Test
  public void testIntersectionOfTwoLists_StringComparison_Test1() {
    List<String> firstNamesList = new ArrayList<String>();
    firstNamesList.add("John"); firstNamesList.add("Mike"); firstNamesList.add("Chris");
    firstNamesList.add("Matt"); firstNamesList.add("Bill");
    
    List<String> secondNamesList = new ArrayList<String>();
    secondNamesList.add("John"); secondNamesList.add("Mike"); secondNamesList.add("Peter");
    secondNamesList.add("David"); secondNamesList.add("Matthew");
    
    List<String> expected = new ArrayList<String>();
    expected.add("John"); expected.add("Mike");
    
    Collection<String> actual = CollectionHelper.intersect(firstNamesList, secondNamesList);
    Assert.assertEquals(expected.size(), actual.size());
    for(String expectedItem : expected)
      Assert.assertTrue(actual.contains(expectedItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_StringComparison_Test2() {
    List<String> firstNamesList = new ArrayList<String>();
    firstNamesList.add("Sherry"); firstNamesList.add("Liz"); firstNamesList.add("Mary");
    firstNamesList.add("Jenny"); firstNamesList.add("Christine");
    
    List<String> secondNamesList = new ArrayList<String>();
    secondNamesList.add("Sherry"); secondNamesList.add("Liz"); secondNamesList.add("Mary");
    
    List<String> expected = new ArrayList<String>();
    expected.add("Sherry"); expected.add("Liz"); expected.add("Mary");
    
    Collection<String> actual = CollectionHelper.intersect(firstNamesList, secondNamesList);
    Assert.assertEquals(expected.size(), actual.size());
    for(String expectedItem : expected)
      Assert.assertTrue(actual.contains(expectedItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_StringComparison_NoDuplicates() {
    List<String> firstNamesList = new ArrayList<String>();
    firstNamesList.add("Hansen"); firstNamesList.add("Lisa"); firstNamesList.add("Elizabeth");
    firstNamesList.add("Cassy"); firstNamesList.add("Alex");
    
    List<String> secondNamesList = new ArrayList<String>();
    secondNamesList.add("Hansen");
    
    List<String> expected = new ArrayList<String>();
    expected.add("Hansen");
    
    Collection<String> actual = CollectionHelper.intersect(firstNamesList, secondNamesList);
    Assert.assertEquals(expected.size(), actual.size());
    for(String expectedItem : expected)
      Assert.assertTrue(actual.contains(expectedItem));
  }
  
  @Test
  public void testIntersectionOfTwoLists_ExcludedElements_StringType() {
    List<String> firstNamesList = new ArrayList<String>();
    firstNamesList.add("Hansen"); firstNamesList.add("Lisa"); firstNamesList.add("Elizabeth");
    firstNamesList.add("Cassy"); firstNamesList.add("Alex");
    
    List<String> secondNamesList = new ArrayList<String>();
    secondNamesList.add("Hansen"); secondNamesList.add("Lisa"); secondNamesList.add("Elizabeth");
    
    List<String> expectedExcluded = new ArrayList<String>();
    expectedExcluded.add("Cassy"); expectedExcluded.add("Alex");
    
    Collection<String> actual = CollectionHelper.intersect(firstNamesList, secondNamesList);
    Assert.assertEquals(3, actual.size());
    for(String excluded : expectedExcluded)
      Assert.assertTrue(!actual.contains(excluded));
  }
}
