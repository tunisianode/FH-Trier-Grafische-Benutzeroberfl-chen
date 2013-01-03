package gui.mvc.spinner;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class SpinnerDemo extends JFrame
{
    private static final long serialVersionUID = 1L;

    public SpinnerDemo(String title, long min, long max, long increment)
    {
        this.setTitle(title);
        this.setLayout(new GridLayout(4, 0));

        MySpinnerModel msm = new MySpinnerModel(min, max, increment);

        JSpinner spinner = new JSpinner(msm);
        spinner.setName("spinner");

        JLabel label = new JLabel();
        label.setName("infoLabel");
        label.setText("neuer Wert: " + min);

        MyChangeListener mcl = new MyChangeListener(label);
        msm.addChangeListener(mcl);

        this.add(spinner);
        this.add(label);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        // SpinnerDemo sd = new SpinnerDemo("testklj", -10, 10, 4);
    }
}
