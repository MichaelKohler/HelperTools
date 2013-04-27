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
