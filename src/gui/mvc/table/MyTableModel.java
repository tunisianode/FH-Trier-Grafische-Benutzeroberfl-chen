package gui.mvc.table;

import javax.swing.table.AbstractTableModel;

/* import-Anweisungen 
 */
public class MyTableModel extends AbstractTableModel
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /*
     * Attribute.
     */
    private int rows, columns;

    /*
     * Konstruktor.
     */
    public MyTableModel(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
    }

    /*
     * Achtung: Bei der Anzahl der Zeilen zählen die Spaltenüberschriften nicht
     * mit. Mit anderen Worten: Es geht nur um die Anzahl der Zeilen mit weißem
     * Hintergrund.
     */
    public int getRowCount()
    {
        return rows;
    }

    public int getColumnCount()
    {
        return columns;
    }

    /*
     * Achtung: Beachten Sie, dass das erste Feld ganz links oben in der Tabelle
     * mit der Beschriftung "1 * 1 = 1" in der Zeile 0 und der Spalte 0 steht.
     * Hinweis: Geben Sie ein Objekt vom Typ String zurück.
     */
    public Object getValueAt(int row, int column)
    {
        int rowResult = row + 1;
        int columnResult = column + 1;
        int result = rowResult * columnResult;
        return new String(rowResult + " * " + columnResult + " = " + result);
    }

    /*
     * Liefert Tabellenüberschrift zurück.
     */
    public String getColumnName(int column)
    {
        int columnResult = column + 1;
        return columnResult + "er";
    }
}