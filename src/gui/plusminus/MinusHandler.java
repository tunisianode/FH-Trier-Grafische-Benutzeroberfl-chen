package gui.plusminus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class MinusHandler implements ActionListener
{
    private JButton b;
    private PlusMinus pm;

    public MinusHandler(PlusMinus pm)
    {
        this.pm = pm;

        b = new JButton("-");
        b.setName("minus");
        b.addActionListener(this);
        b.setToolTipText("minus");
    }

    public JButton getButton()
    {
        return b;
    }

    public void actionPerformed(ActionEvent e)
    {
        pm.decrementCounter();
    }
}