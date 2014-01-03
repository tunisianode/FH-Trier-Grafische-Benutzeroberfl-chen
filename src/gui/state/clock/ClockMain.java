package gui.state.clock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class ClockMain extends JFrame
{
    private static final long serialVersionUID = 1L;

    public ClockMain()
    {
        this.setLayout(new GridBagLayout());

        Clock clock = new Clock();
        clock.setState(new NormalState(clock));

        ClockView viewClock = new ClockView();
        viewClock.update(0, 0);
        viewClock.setName("view");

        ClockController set = new ClockController("set", clock);
        set.setName("set");

        ClockController plus = new ClockController("+", clock);
        plus.setName("plus");

        ClockController minus = new ClockController("-", clock);
        minus.setName("minus");

        this.add(viewClock, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0));
        this.add(set, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0),
                0, 0));
        this.add(plus, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0),
                0, 0));
        this.add(minus, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

        clock.addListener(viewClock);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        // ClockMain m = new ClockMain();
    }
}
