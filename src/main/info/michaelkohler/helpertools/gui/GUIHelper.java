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

import info.michaelkohler.helpertools.logging.Debugger;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 * GUI Helper for the project. It makes different helper methods available
 * to the other classes.
 *
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */
public final class GUIHelper {

    /**
     * Private constructor since we don't want other classes
     * to instantiate this class.
     */
    private GUIHelper() {
    }

    /**
     * makes the component visible.
     *
     * @param aComponent which component should be visible
     */
    public static void showComponent(final Component aComponent) {
        aComponent.setVisible(true);
    }

    /**
     * makes the component invisible.
     *
     * @param aComponent which component should be invisible
     */
    public static void hideComponent(final Component aComponent) {
        aComponent.setVisible(false);
    }

    /**
     * makes the application pretty using the standard OS design.
     */
    public static void prettify() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Debugger.logMessage(ex);
        }
    }

    /**
     * sizes and centers the JFrame.
     *
     * @param aFrame which needs to be sized
     * @param aWidth defining the width of the window
     * @param aHeight defining the height of the window
     */
    public static void sizeAndCenterFrame(JFrame aFrame, int aWidth, int aHeight) {
        aFrame.setSize(aWidth, aHeight);
        aFrame.setLocationRelativeTo(null);
    }

    /**
     * makes the JFrame closeable with ESC key.
     *
     * @param aFrame which needs to be closeable with the ESC key
     */
    @SuppressWarnings("serial")
    public static void setESCCloseable(final JFrame aFrame) {
        KeyStroke escapeKS = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0,  false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(final ActionEvent ae) {
                aFrame.dispose();
            }
        };
        aFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                  .put(escapeKS, "ESCAPE");
        aFrame.getRootPane().getActionMap().put("ESCAPE", escapeAction);

    }

}