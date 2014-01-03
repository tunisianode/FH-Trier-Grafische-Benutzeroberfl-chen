package gui.state.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClockController extends JButton implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private Clock clock;

    ClockController(String text, Clock clock)
    {
        super(text);
        this.clock = clock;
        this.addActionListener(this);
        this.setActionCommand(text);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("set"))
        {
            this.clock.set();
        }

        if (e.getActionCommand().equals("+"))
        {
            this.clock.plus();
        }

        if (e.getActionCommand().equals("-"))
        {
            this.clock.minus();
        }
    }
}
