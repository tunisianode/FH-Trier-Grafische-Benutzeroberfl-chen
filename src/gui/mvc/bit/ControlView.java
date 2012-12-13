package gui.mvc.bit;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class ControlView extends JPanel implements IBitModelListener
{
    private static final long serialVersionUID = 1L;
    private IBitModel bm;
    private JCheckBox[] cb;

    public ControlView(IBitModel bm)
    {
        this.setLayout(new GridLayout(1, 0));

        this.bm = bm;
        this.cb = new JCheckBox[this.bm.getLength()];

        for (int i = this.cb.length - 1; i >= 0; i--)
        {
            this.cb[i] = new JCheckBox(i + "");
            this.cb[i].setName(i + "");
            this.cb[i].addItemListener(new BitViewController(this.bm, i));
            this.add(this.cb[i]);
        }
    }

    public void modelChanged()
    {
        // bitte ergänzen: Reaktion auf Veränderung des Modells
    }
}