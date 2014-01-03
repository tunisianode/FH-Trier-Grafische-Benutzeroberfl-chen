package gui.state.clock;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ClockView extends JLabel implements ClockListener
{
    private static final long serialVersionUID = 1L;

    ClockView()
    {
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Helvetica", Font.BOLD, 46));
    }

    public void update(int hours, int minutes)
    {
        String hoursString = hours + "";
        if (hours < 10)
        {
            hoursString = "0" + hours;
        }

        String minutesString = minutes + "";
        if (minutes < 10)
        {
            minutesString = "0" + minutes;
        }

        this.setText(hoursString + ":" + minutesString);
    }
}
