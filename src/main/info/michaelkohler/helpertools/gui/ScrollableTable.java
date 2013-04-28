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

import info.michaelkohler.helpertools.tools.Validator;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * The ScrollableTable is responsible to produce a scrollable table with
 * the given data input. It automatically adds a JTable to a JScrollPane
 * which then can be used further.
 *
 * @author Michael Kohler <michaelkohler@linux.com>
 * @version 0.0.1
 *
 */

@SuppressWarnings("serial")
public class ScrollableTable extends JScrollPane {

    /**
     * Constructor which initializes the component.
     *
     * @param aData specifying the data which should be displayed in the table
     * @param aColumnNames specifying the column names
     */
    public ScrollableTable(String[][] aData, String[] aColumnNames) {
        super();

        Validator.checkNotNull(aData, "Illegal NULL data set");
        Validator.checkNotNull(aColumnNames, "Illegal NULL columns");
        TableModel model = getTableModel(aData, aColumnNames);
        JTable overviewTable = new JTable(model);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        overviewTable.setRowSorter(sorter);

        this.setViewportView(overviewTable);
    }

    /**
     * Produces the TableModel which is used by the table. This is a standard
     * model.
     *
     * @param aData specifying the data which should be displayed in the table
     * @param aColumnNames specifying the column names
     * @return model which was produced
     */
    private TableModel getTableModel(String[][] aData, String[] aColumnNames) {
        TableModel model = new DefaultTableModel(aData, aColumnNames) {
            @Override
            public Class<?> getColumnClass(final int column) {
                return getValueAt(0, column).getClass();
            }
        };
        return model;
    }
}