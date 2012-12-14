package info.michaelkohler.helpertools;

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


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import info.michaelkohler.helpertools.collections.CollectionHelper;
import info.michaelkohler.helpertools.collections.IFunction;

public class CollectionHelperTest {
    /**
     * This class is only used to test the {@link #all(Collection<T>,String)
     * method. This proves that public as well as private and public fields can be accessed.
     */
    private class MyClass {
        
        public final int a;
        private final int b;
        public MyClass(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private List<String> stringCollection = new ArrayList<String>();
    private List<MyClass> myClassCollection = new ArrayList<MyClass>();
    
    @Before
    public void setUp() {
        String s1 = new String("firstString");
        String s2 = new String("second");
        String s3 = new String("thisIsTheThird");
        stringCollection = Arrays.asList(s1, s2, s3);
        
        MyClass m1 = new MyClass(0, 0);
        MyClass m2 = new MyClass(1, 2);
        MyClass m3 = new MyClass(2, 4);
        myClassCollection = Arrays.asList(m1, m2, m3);
    }

    @Test
    public void stringCollectionEach() {
        CollectionHelper.each(stringCollection, new IFunction() {
            public void execute(Object o, int index ) {
                String s = (String) o;
                if(index == 0) assertEquals(s.length(), 11);
                if(index == 1) assertEquals(s.length(), 6);
                if(index == 2) assertEquals(s.length(), 14);
            }
        });
    }

    @Test
    public void myClassCollection() {
        try {
            Collection<Object> collectionOfA = CollectionHelper.all(myClassCollection, "a");
            Collection<Object> collectionOfB = CollectionHelper.all(myClassCollection, "b");
            for(int i=0; i<collectionOfA.size(); i++) {
                int valOfA = (Integer)collectionOfA.toArray()[i];
                int valOfB = (Integer)collectionOfB.toArray()[i];
                assertEquals(valOfA, i);
                assertEquals(valOfB, i*2);
            }
        } catch (NoSuchFieldException e) {
            fail("NoSuchFieldException occured.");
        }
    }
    
    @Test(expected = NoSuchFieldException.class)
    public void inexistentFieldShouldThrow() throws NoSuchFieldException {
        Collection<Object> collectionOfC = CollectionHelper.all(myClassCollection, "c");
        assertEquals(collectionOfC, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAllNullCollection() throws NoSuchFieldException {
        CollectionHelper.all(null, "a");    
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAllNullString() throws NoSuchFieldException {
        CollectionHelper.all(myClassCollection, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEachNullCollection() {
        CollectionHelper.each(null, new IFunction() {
            public void execute(Object element, int index) {
                // Dont need to do anything
            }
        });
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEachNullIFunction() {
        CollectionHelper.each(myClassCollection, null);
    }
}