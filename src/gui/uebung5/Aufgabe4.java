package gui.uebung5;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Aufgabe4 extends JFrame
{
    private static final long serialVersionUID = 1L;

    public Aufgabe4()
    {
        super("GridBagLayoutDemo");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        contentPane.setLayout(gridbag);
        JButton button;
        GridBagConstraints constraints;
        Insets insets = new Insets(0, 0, 0, 0);

        button = new JButton("Button 1");
        constraints = new GridBagConstraints(0, 0, // gridx, gridy
                1, 1, // gridwidth, gridheight
                0.0, 0.0, // weightx, weighty
                GridBagConstraints.CENTER, // anchor
                GridBagConstraints.BOTH, // fill
                // GridBagConstraints.NONE, // fill
                // GridBagConstraints.VERTICAL, // fill
                // GridBagConstraints.HORIZONTAL, // fill
                insets, // insets
                20, 100); // ipadx, ipady
        contentPane.add(button, constraints);

        button = new JButton("Button 2");
        constraints = new GridBagConstraints(1, 0, // gridx, gridy
                3, 4, // gridwidth, gridheight
                0.0, 0.0, // weightx, weighty
                GridBagConstraints.CENTER, // anchor
                GridBagConstraints.BOTH, // fill
                // GridBagConstraints.NONE, // fill
                // GridBagConstraints.VERTICAL, // fill
                // GridBagConstraints.HORIZONTAL, // fill
                insets, // insets
                0, 0); // ipadx, ipady
        contentPane.add(button, constraints);

        button = new JButton("Button 3");
        constraints = new GridBagConstraints(0, 3, // gridx, gridy
                1, 1, // gridwidth, gridheight
                0.0, 0.0, // weightx, weighty
                GridBagConstraints.WEST, // anchor
                // GridBagConstraints.BOTH, // fill
                GridBagConstraints.NONE, // fill
                // GridBagConstraints.VERTICAL, // fill
                // GridBagConstraints.HORIZONTAL, // fill
                insets, // insets
                100, 0); // ipadx, ipady
        contentPane.add(button, constraints);

        button = new JButton("Button 4");
        constraints = new GridBagConstraints(0, 4, // gridx, gridy
                1, 1, // gridwidth, gridheight
                0.0, 0.0, // weightx, weighty
                GridBagConstraints.CENTER, // anchor
                GridBagConstraints.BOTH, // fill
                // GridBagConstraints.NONE, // fill
                // GridBagConstraints.VERTICAL, // fill
                // GridBagConstraints.HORIZONTAL, // fill
                insets, // insets
                0, 0); // ipadx, ipady
        contentPane.add(button, constraints);

        button = new JButton("Button 4");
        constraints = new GridBagConstraints(1, 4, // gridx, gridy
                1, 1, // gridwidth, gridheight
                0.0, 0.0, // weightx, weighty
                GridBagConstraints.CENTER, // anchor
                GridBagConstraints.BOTH, // fill
                // GridBagConstraints.NONE, // fill
                // GridBagConstraints.VERTICAL, // fill
                // GridBagConstraints.HORIZONTAL, // fill
                insets, // insets
                0, 0); // ipadx, ipady
        contentPane.add(button, constraints);

        button = new JButton("Button 4");
        constraints = new GridBagConstraints(2, 4, // gridx, gridy
                1, 1, // gridwidth, gridheight
                0.0, 0.0, // weightx, weighty
                GridBagConstraints.CENTER, // anchor
                GridBagConstraints.BOTH, // fill
                // GridBagConstraints.NONE, // fill
                // GridBagConstraints.VERTICAL, // fill
                // GridBagConstraints.HORIZONTAL, // fill
                insets, // insets
                0, 0); // ipadx, ipady
        contentPane.add(button, constraints);

        button = new JButton("Button 4");
        constraints = new GridBagConstraints(3, 4, // gridx, gridy
                1, 1, // gridwidth, gridheight
                0.0, 0.0, // weightx, weighty
                GridBagConstraints.CENTER, // anchor
                GridBagConstraints.BOTH, // fill
                // GridBagConstraints.NONE, // fill
                // GridBagConstraints.VERTICAL, // fill
                // GridBagConstraints.HORIZONTAL, // fill
                insets, // insets
                0, 0); // ipadx, ipady
        contentPane.add(button, constraints);

        add(contentPane);
        setSize(400, 500);
    }

    public static void main(String[] args)
    {
        Aufgabe4 auf = new Aufgabe4();
        auf.pack();
        auf.setVisible(true);
    }
}
