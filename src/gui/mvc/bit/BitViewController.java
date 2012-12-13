package gui.mvc.bit;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BitViewController implements ItemListener
{
    private IBitModel bm;
    private int position;

    public BitViewController(IBitModel bm, int position)
    {
        this.bm = bm;
        this.position = position;
    }

    public void itemStateChanged(ItemEvent evt)
    {
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            this.bm.set(this.position, true);
        }
        else
        {
            this.bm.set(this.position, false);
        }
    }
}