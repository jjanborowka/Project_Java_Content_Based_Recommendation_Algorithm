import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class CellRenderer implements TableCellRenderer {
    JPanel panel;
    JSlider slider;
    JTextArea txt;

    public CellRenderer(){
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        slider = new JSlider(SwingConstants.HORIZONTAL,0,10, 0);
        slider.setSize(600, 50);
        txt  = new JTextArea("0");

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                txt.setText("" + source.getValue());
            }
        });
        txt.setBackground(new ColorUIResource(238,238,238));
        panel.add(slider);
        panel.add(txt);
        panel.setVisible(true);

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Double val = (Double) value;
        slider.setValue(val.intValue());

        return panel;
    }
}
