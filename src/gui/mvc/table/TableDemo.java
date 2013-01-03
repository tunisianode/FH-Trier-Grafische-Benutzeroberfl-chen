package gui.mvc.table;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TableDemo
{
    public static void main(String[] args)
    {
        // Erzeugen eines JFrame-Objekts
        JFrame frame = new JFrame("Einmaleins");

        // Erzeugen des Modells und der JTable:
        TableModel tm = new MyTableModel(10, 10);
        JTable jt = new JTable(tm);

        // Erzeugen in einer JScrollPane,
        // die die JTable enth�lt:
        JScrollPane jscp = new JScrollPane(jt);

        // Hinzuf�gen der JScrollPane in das Frame,
        frame.add(jscp);

        // Position und Gr��e setzen und Frame sichtbar machen
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}