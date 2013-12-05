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
  // Given that the size of the 'actual' collection has already been verified, if an 'expected' item is not found in the 
  // 'actual' collection, then the 'actual' collection is not unique.
  
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
      Assert.assertTrue(expected.contains(iterator.next()));
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
      Assert.assertTrue(expected.contains(iterator.next()));
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
}
