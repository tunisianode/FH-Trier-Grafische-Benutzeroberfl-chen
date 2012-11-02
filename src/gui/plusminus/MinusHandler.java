package gui.plusminus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class MinusHandler implements ActionListener
{
    private JButton b;
    private PlusMinus pm;

    public MinusHandler(PlusMinus pm)
    {
        this.pm = pm;

        ImageIcon img = new ImageIcon("img/icon.png");
        b = new JButton("-", img);
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