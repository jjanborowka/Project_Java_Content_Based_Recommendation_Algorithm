import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class SliderRenderer extends JSlider implements TableCellRenderer {
    public SliderRenderer(int orientation, int min, int max, int value) {
        super(orientation, min, max, value);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column)
    {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }

        TableColumnModel columnModel = table.getColumnModel();
        TableColumn selectedColumn = columnModel.getColumn(column);
        int columnWidth = selectedColumn.getWidth();
        int columnHeight = table.getRowHeight();
        setSize(new Dimension(columnWidth, columnHeight));

        setValue(((Double)value).intValue());
        updateUI();
        return this;
    }
}
