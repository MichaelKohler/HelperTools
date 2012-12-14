package info.michaelkohler.helpertools;

import javax.swing.JFrame;

import info.michaelkohler.helpertools.gui.GUIHelper;

import org.junit.Test;

public class GUIHelperTest {

    @Test(expected = IllegalArgumentException.class)
    public void testShowComponentNullArg() {
        GUIHelper.showComponent(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHideComponentNullArg() {
        GUIHelper.hideComponent(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetESCClosebaleNullArg() {
        GUIHelper.setESCCloseable(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSizeAndCenterFrameNullArg() {
        GUIHelper.sizeAndCenterFrame(null, 10, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSizeAndCenterFrameNegativeWidth() {
        GUIHelper.sizeAndCenterFrame(new JFrame(), -1, 10);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSizeAndCenterFrameNegativeHeight() {
        GUIHelper.sizeAndCenterFrame(new JFrame(), 10, -1);
    }
}
