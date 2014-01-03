package gui.state.phone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PhoneController extends JButton implements ActionListener
{
    private static final long serialVersionUID = 1L;

    public PhoneController(String text)
    {
        this.setActionCommand(text);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("up"))
        {

        }
    }

}
