package gui.uebung5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * JFileChooser-Experiment
 * 
 * @author stefanprobst
 */
public class Aufgabe3 extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private JButton button1, button2;
    private JLabel label;
    private JFileChooser fileChooser;

    public Aufgabe3()
    {
        super("Dialogtest");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        button1 = new JButton("Dialog oeffnen");
        button1.setName("button1");
        add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Dialog speichern");
        button2.setName("button2");
        add(button2);
        button2.addActionListener(this);

        label = new JLabel("");
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
            try
            {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION)
                {
                    label.setText("open: "
                            + fileChooser.getSelectedFile().getAbsolutePath()
                                    .toString());
                }
                else
                {
                    label.setText("open: Abbruch der Aktion");
                }
            }
            catch (NullPointerException ex)
            {
            }
        }
        else
        {
            try
            {
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION)
                {
                    label.setText("speichern: "
                            + fileChooser.getSelectedFile().getAbsolutePath()
                                    .toString());
                }
                else
                {
                    label.setText("speichern: Abbruch der Aktion");
                }
            }
            catch (NullPointerException ex)
            {
            }
        }
    }
}