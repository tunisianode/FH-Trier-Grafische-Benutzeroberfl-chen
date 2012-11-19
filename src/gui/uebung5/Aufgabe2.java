package gui.uebung5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Diese Klasse zeigt zwei Buttons und ein Label an. Die Vordergrund- und
 * Hintergrundfarbe des Labels kann ueber den JColorChooser bearbeitet werden.
 * 
 */
public class Aufgabe2 extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private JButton button1, button2;
    private JLabel label;

    public Aufgabe2()
    {
        super("Dialogtest");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        button1 = new JButton("Dialog fuer Vordergrundfarbe");
        button1.setName("button1");
        add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Dialog fuer Hintergrundfarbe");
        button2.setName("button2");
        add(button2);
        button2.addActionListener(this);

        label = new JLabel("Beispieltext");
        label.setOpaque(true);
        add(label);

        setSize(200, 200);
        setLocationByPlatform(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button1)
        {
            label.setForeground(JColorChooser.showDialog(this, "Farbe",
                    label.getForeground()));
        }
        else
        {
            label.setBackground(JColorChooser.showDialog(this, "Farbe",
                    label.getBackground()));
        }
    }
}
