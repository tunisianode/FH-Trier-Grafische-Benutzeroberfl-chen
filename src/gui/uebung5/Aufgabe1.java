package gui.uebung5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Aufgabe1 extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;

    private JButton button1, button2, button3, button4;

    public Aufgabe1()
    {
        super("Dialogtest");

        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        button1 = new JButton("Dialog: modal und abhängig");
        button1.setName("button1");
        add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Dialog: nicht modal und abhängig");
        button2.setName("button2");
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Dialog: modal und nicht abhängig");
        button3.setName("button3");
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("Dialog: nicht modal und nicht abhängig");
        button4.setName("button4");
        button4.addActionListener(this);
        add(button4);

        setSize(200, 200);
        setLocationByPlatform(true);
        setVisible(true);
    }
/*
    public static void main(String[] args)
    {
        Aufgabe1 aufg1 = new Aufgabe1();
        System.out.println("sd");
    }
*/
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button1)
        {
            JOptionPane.showMessageDialog(this,
                    "Hallo, ich bin ein modaler und abhängiger Dialog.");
        }
        else if (e.getSource() == button2)
        {
            JDialog dialog = new JDialog(this);
            dialog.setModal(false);
            dialog.setLayout(new GridLayout(0, 1));
            dialog.setSize(200, 200);
            dialog.setVisible(true);

            JLabel label = new JLabel("ich bin der zweite Dialog!");
            dialog.add(label);
        }
        else if (e.getSource() == button3)
        {
            JDialog dialog = new JDialog();
            dialog.setModal(true);
            dialog.setVisible(true);
        }
        else if (e.getSource() == button4)
        {
            JDialog dialog = new JDialog();
            dialog.setModal(false);
            dialog.setVisible(true);
        }
    }
}
