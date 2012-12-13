package gui.mvc.textarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class AppendListener implements ActionListener
{
    private JTextArea ta;

    public AppendListener(JTextArea ta)
    {
        this.ta = ta;
    }

    public void actionPerformed(ActionEvent e)
    {
        ta.append("#\n");
    }
}