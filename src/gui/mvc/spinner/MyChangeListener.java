package gui.mvc.spinner;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyChangeListener implements ChangeListener
{
    private JLabel label;

    public MyChangeListener(JLabel label)
    {
        this.label = label;
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        this.label.setText("neuer Wert: " + ((Long) e.getSource()).longValue());
    }
}
