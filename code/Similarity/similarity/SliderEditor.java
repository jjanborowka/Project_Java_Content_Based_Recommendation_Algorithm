import javax.swing.*;
import java.awt.*;

public class SliderEditor extends DefaultCellEditor {
    protected JSlider slider;

    public SliderEditor(int orientation, int min, int max, int value) {
        super(new JCheckBox());
        slider = new JSlider(orientation, min, max, value);
        slider.setOpaque(true);
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (isSelected) {
            slider.setForeground(table.getSelectionForeground());
            slider.setBackground(table.getSelectionBackground());
        } else {
            slider.setForeground(table.getForeground());
            slider.setBackground(table.getBackground());
        }
        slider.setValue(((Double) value).intValue());

        return slider;
    }

    public Object getCellEditorValue() {
        return new Double(slider.getValue());
    }

    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
