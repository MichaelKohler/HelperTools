package info.michaelkohler.helpertools;

import info.michaelkohler.helpertools.collections.CollectionHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CollectionHelperUnionTest {

  // When testing for unique membership, the codes iterate through the 'expected' collection (instead of the 'actual' collection)
  // to ensures that each unique expected item is verified for membership in the 'actual' collection. 
  // Given that the size of the 'actual' collection has already been verified to be equal to that of the 'expected' collection,
  // if an 'expected' item is not found in the 'actual' collection, then either:
  // 1. the 'actual' collection contains erroneous result or, 
  // 2. the 'actual' collection is not unique.
  
  @Test
  public void testUnionOfTwoLists_TotalCount() {
    Collection<Integer> oddNums = new ArrayList<Integer>();
    oddNums.add(1); oddNums.add(3); oddNums.add(5);
    oddNums.add(7); oddNums.add(9);
    
    Collection<Integer> evenNums = new ArrayList<Integer>();
    evenNums.add(2); evenNums.add(4); evenNums.add(6);
    evenNums.add(8); evenNums.add(10);
    
    int expectedTotalCount = 10;
    Collection<Integer> actual = CollectionHelper.union(oddNums, evenNums);
    Assert.assertEquals(expectedTotalCount, actual.size());
  }
  
  @Test
  public void testUnionOfTwoLists_ContainsAll_Test1() {
    List<Integer> oddNums = new ArrayList<Integer>();
    oddNums.add(1); oddNums.add(3); oddNums.add(5);
    oddNums.add(7); oddNums.add(9);
    
    List<Integer> evenNums = new ArrayList<Integer>();
    evenNums.add(2); evenNums.add(4); evenNums.add(6);
    evenNums.add(8); evenNums.add(10);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    expected.add(4); expected.add(5); expected.add(6);
    expected.add(7); expected.add(8); expected.add(9);
    expected.add(10);
    
    Collection<Integer> actual = CollectionHelper.union(oddNums, evenNums);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<Integer> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoLists_ContainsAll_Test2() {
    List<Integer> oddNums = new ArrayList<Integer>();
    oddNums.add(1); oddNums.add(3); oddNums.add(5);
    oddNums.add(7); oddNums.add(9); oddNums.add(11);
    oddNums.add(13); oddNums.add(15); oddNums.add(17);
    oddNums.add(19);
    
    List<Integer> evenNums = new ArrayList<Integer>();
    evenNums.add(2); evenNums.add(4); evenNums.add(6);
    evenNums.add(8); evenNums.add(10); evenNums.add(12);
    evenNums.add(14); evenNums.add(16); evenNums.add(18);
    evenNums.add(20);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    expected.add(4); expected.add(5); expected.add(6);
    expected.add(7); expected.add(8); expected.add(9);
    expected.add(10);
    expected.add(11); expected.add(12); expected.add(13);
    expected.add(14); expected.add(15); expected.add(16);
    expected.add(17); expected.add(18); expected.add(19);
    expected.add(20);
    
    Collection<Integer> actual = CollectionHelper.union(oddNums, evenNums);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<Integer> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoLists_NoDuplicates_Test1() {
    List<Integer> oddNums = new ArrayList<Integer>();
    oddNums.add(1); oddNums.add(3); oddNums.add(5);
    oddNums.add(7); oddNums.add(9);
  
    List<Integer> duplicates = new ArrayList<Integer>();
    duplicates.add(1); duplicates.add(3); duplicates.add(5);
    duplicates.add(7); duplicates.add(9);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(3); expected.add(5);
    expected.add(7); expected.add(9);
    
    Collection<Integer> actual = CollectionHelper.union(oddNums, duplicates);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<Integer> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoLists_NoDuplicates_Test2() {
    List<Integer> oddNums = new ArrayList<Integer>();
    oddNums.add(1); oddNums.add(3); oddNums.add(5);
    oddNums.add(7); oddNums.add(9);
  
    List<Integer> anotherOddNums = new ArrayList<Integer>();
    anotherOddNums.add(2); anotherOddNums.add(6); anotherOddNums.add(8); anotherOddNums.add(10);
    anotherOddNums.add(3); // duplicate
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    expected.add(5); expected.add(6); expected.add(7);
    expected.add(8); expected.add(9); expected.add(10);
    
    Collection<Integer> actual = CollectionHelper.union(oddNums, anotherOddNums);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<Integer> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoLists_EmptyLists(){
    List<Integer> emptyList1 = new ArrayList<Integer>();
    List<Integer> emptyList2 = new ArrayList<Integer>();
    List<Integer> expected = new ArrayList<Integer>();
    
    Collection<Integer> actual = CollectionHelper.union(emptyList1, emptyList2);
    Assert.assertEquals(expected.size(), actual.size());
    Assert.assertTrue(actual.isEmpty());
  }
  
  @Test
  public void testUnionOfTwoLists_NullList_FirstParam(){
    List<Integer> nullList = null;
    List<Integer> aList = new ArrayList<Integer>();
    aList.add(1); aList.add(2); aList.add(3);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    
    Collection<Integer> actual = CollectionHelper.union(nullList, aList);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<Integer> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoLists_NullList_SecondParam(){
    List<Integer> nullList = null;
    List<Integer> aList = new ArrayList<Integer>();
    aList.add(1); aList.add(2); aList.add(3);
    
    List<Integer> expected = new ArrayList<Integer>();
    expected.add(1); expected.add(2); expected.add(3);
    
    Collection<Integer> actual = CollectionHelper.union(aList, nullList);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<Integer> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoStringLists_ContainsAll_Test1() {
    List<String> maleNames = new ArrayList<String>();
    maleNames.add("John"); maleNames.add("Mike"); maleNames.add("Chris");
    maleNames.add("Matt"); maleNames.add("Bill");
    
    List<String> femaleNames = new ArrayList<String>();
    femaleNames.add("Sherry"); femaleNames.add("Liz"); femaleNames.add("Mary");
    femaleNames.add("Michelle"); femaleNames.add("Jane");
    
    List<String> expected = new ArrayList<String>();
    expected.add("John"); expected.add("Mike"); expected.add("Chris");
    expected.add("Matt"); expected.add("Bill");
    expected.add("Sherry"); expected.add("Liz"); expected.add("Mary");
    expected.add("Michelle"); expected.add("Jane");
    
    Collection<String> actual = CollectionHelper.union(maleNames, femaleNames);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<String> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoStringLists_ContainsAll_Test2() {
    List<String> maleNames = new ArrayList<String>();
    maleNames.add("John"); maleNames.add("Mike"); maleNames.add("Chris");
    maleNames.add("Matt"); maleNames.add("Bill"); maleNames.add("Robin"); 
    maleNames.add("Lee"); maleNames.add("Kenneth"); maleNames.add("Howe");
    
    List<String> femaleNames = new ArrayList<String>();
    femaleNames.add("Sherry"); femaleNames.add("Liz"); femaleNames.add("Mary");
    femaleNames.add("Michelle"); femaleNames.add("Jane"); femaleNames.add("Loewe");
    femaleNames.add("Kathy"); femaleNames.add("Renee"); femaleNames.add("Bonny");
    
    List<String> expected = new ArrayList<String>();
    expected.add("John"); expected.add("Mike"); expected.add("Chris");
    expected.add("Matt"); expected.add("Bill"); expected.add("Robin"); 
    expected.add("Lee"); expected.add("Kenneth"); expected.add("Howe");
    expected.add("Sherry"); expected.add("Liz"); expected.add("Mary");
    expected.add("Michelle"); expected.add("Jane"); expected.add("Loewe");
    expected.add("Kathy"); expected.add("Renee"); expected.add("Bonny");
    
    Collection<String> actual = CollectionHelper.union(maleNames, femaleNames);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<String> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoStringLists_UniqueMembership_Test1() {
    List<String> maleNames = new ArrayList<String>();
    maleNames.add("John"); maleNames.add("Mike"); maleNames.add("Chris");
    maleNames.add("Matt"); maleNames.add("Bill");
    
    List<String> duplicates = new ArrayList<String>();
    duplicates.add("John"); duplicates.add("Mike"); duplicates.add("Chris");
    duplicates.add("Matt"); duplicates.add("Bill");
    
    List<String> expected = new ArrayList<String>();
    expected.add("John"); expected.add("Mike"); expected.add("Chris");
    expected.add("Matt"); expected.add("Bill");
    
    Collection<String> actual = CollectionHelper.union(maleNames, duplicates);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<String> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
  
  @Test
  public void testUnionOfTwoStringLists_UniqueMembership_Test2() {
    List<String> maleNames = new ArrayList<String>();
    maleNames.add("John"); maleNames.add("Mike"); maleNames.add("Chris");
    maleNames.add("Matt"); maleNames.add("Bill");
    
    List<String> moreMaleNames = new ArrayList<String>();
    moreMaleNames.add("Mark"); moreMaleNames.add("David"); 
    moreMaleNames.add("Chris"); // duplicate
    moreMaleNames.add("Paul"); moreMaleNames.add("Luke");
    
    List<String> expected = new ArrayList<String>();
    expected.add("John"); expected.add("Mike"); expected.add("Chris");
    expected.add("Matt"); expected.add("Bill"); expected.add("Mark"); 
    expected.add("David"); expected.add("Paul"); expected.add("Luke");
    
    Collection<String> actual = CollectionHelper.union(maleNames, moreMaleNames);
    Assert.assertEquals(expected.size(), actual.size());
    for(Iterator<String> iterator = expected.iterator(); iterator.hasNext();)
      Assert.assertTrue(actual.contains(iterator.next()));
  }
}
