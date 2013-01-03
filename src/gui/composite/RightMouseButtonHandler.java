package gui.composite;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

public class RightMouseButtonHandler implements MouseListener
{
    private JPopupMenu popup;

    public RightMouseButtonHandler(JTree tree, ActionListener listener)
    {
        tree.getAlignmentX();
        popup = new JPopupMenu();
        JMenuItem menu;
        menu = new JMenuItem("Schachtel hinzuf�gen");
        // gleichen Listener wie f�r den entsprechenden JButton
        // hinzuf�gen:
        // -> menu.addActionListener(...);
        menu.addActionListener(listener);
        popup.add(menu);
        menu = new JMenuItem("Gegenstand hinzuf�gen");
        // gleichen Listener wie f�r den entsprechenden JButton
        // hinzuf�gen:
        // -> menu.addActionListener(...);
        menu.addActionListener(listener);
        popup.add(menu);
        menu = new JMenuItem("l�schen");
        // gleichen Listener wie f�r den entsprechenden JButton
        // hinzuf�gen:
        // -> menu.addActionListener(...);
        menu.addActionListener(listener);
        popup.add(menu);
    }

    public void mousePressed(MouseEvent e)
    {
        // falls nicht die linke Maustaste gedr�ckt wurde:
        if (e.getButton() != MouseEvent.BUTTON1)
        {
            JTree tree = (JTree) e.getSource();
            // Pfad zur�ckliefern, der angeklickt wurde
            TreePath path = tree.getPathForLocation(e.getX(), e.getY());
            // falls �berhaupt ein Knoten angeklickt wurde:
            if (path != null)
            {
                System.out.println("sdf");
                // Pfad selektieren (passiert nicht automatisch,
                // ist einfacher f�r nachfolgende Aktionen, da
                // dann dieselben ActionListener benutzt werden
                // k�nnen wie f�r die Buttons, diese arbeiten
                // auf dem gerade selektierten Knoten):
                tree.setSelectionPath(path);
                // Men� an der Stelle anzeigen,
                // an der geklickt wurde:
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0)
    {
        // TODO Auto-generated method stub

    }
}