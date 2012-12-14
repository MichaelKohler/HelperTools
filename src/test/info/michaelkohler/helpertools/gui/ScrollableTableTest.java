package info.michaelkohler.helpertools.gui;

import org.junit.Test;

public class ScrollableTableTest {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNullData() {
		new ScrollableTable(null, new String[] {"a"});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNullNames() {
		new ScrollableTable(new String[][] {}, null);
	}
}
