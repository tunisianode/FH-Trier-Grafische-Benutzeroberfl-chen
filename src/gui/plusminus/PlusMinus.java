package gui.plusminus;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlusMinus extends JFrame
{
    private static final long serialVersionUID = 1L;

    private JLabel label;
    private MinusHandler mh;
    private PlusHandler ph;
    private int counter = 0;
    private int min, max, steps;

    public PlusMinus(int min, int max, int steps)
    {
        super("PlusMinus");

        // Parameter initalisieren.
        this.min = min;
        this.max = max;
        this.steps = steps;
        this.counter = min;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        ph = new PlusHandler(this);
        add(ph.getButton());

        String sMin = "" + min;
        label = new JLabel(sMin);
        label.setName("label");
        add(label);

        mh = new MinusHandler(this);
        add(mh.getButton());
        mh.getButton().setEnabled(false);

        if (max == min || min + steps > max)
        {
            mh.getButton().setEnabled(false);
            ph.getButton().setEnabled(false);
        }

        setSize(200, 100);
        setVisible(true);
    }

    public void incrementCounter()
    {
        if (counter + steps > max)
        {
            counter = max;
            ph.getButton().setEnabled(false);
        }
        else
        {
            counter += steps;

            if (counter + steps > max)
            {
                ph.getButton().setEnabled(false);
            }
            else
            {
                ph.getButton().setEnabled(true);
            }

            mh.getButton().setEnabled(true);
        }

        label.setText("" + counter);
    }

    public void decrementCounter()
    {
        if (counter - steps < min)
        {
            counter = min;
            mh.getButton().setEnabled(false);
        }
        else
        {
            counter -= steps;

            if (counter - steps < min)
            {
                mh.getButton().setEnabled(false);
            }
            else
            {
                mh.getButton().setEnabled(true);
            }

            ph.getButton().setEnabled(true);
        }

        label.setText("" + counter);
    }
}