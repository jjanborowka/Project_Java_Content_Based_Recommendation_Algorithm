import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {

    final List<Movie> modelList;

    final String[] columnNames = new String[] {
            "Title", "Score", "Number"
    };

    final Class[] columnClass = new Class[] {
            String.class, Double.class, Double.class
    };

    TableModel(List<Movie> modelList){
        this.modelList = modelList;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        return columnClass[columnIndex];
    }

    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return modelList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movie row = modelList.get(rowIndex);
        if(0 == columnIndex){
            return row.getTitle();
        }
        else if(1 == columnIndex || 2==columnIndex){
            return row.getScore();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Movie row = modelList.get(rowIndex);

        if(0 == columnIndex){
            row.setTitle((String) aValue);
        }
        else if(1 == columnIndex){
            row.setScore((Double) aValue);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (0 == columnIndex) {
            return false;
        } else if (1 == columnIndex){
            return true;
        }
        return false;
    }
}
