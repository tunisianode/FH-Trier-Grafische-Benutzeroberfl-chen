package gui.plusminus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class PlusHandler implements ActionListener
{
    private JButton b;
    private PlusMinus pm;

    public PlusHandler(PlusMinus pm)
    {
        this.pm = pm;

        ImageIcon img = new ImageIcon("img/icon.png");
        b = new JButton("+", img);
        b.setName("plus");
        b.addActionListener(this);
        b.setToolTipText("plus");
    }

    public JButton getButton()
    {
        return b;
    }

    public void actionPerformed(ActionEvent e)
    {
        pm.incrementCounter();
    }
}