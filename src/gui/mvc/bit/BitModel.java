package gui.mvc.bit;

import java.util.ArrayList;
import java.util.List;

public class BitModel implements IBitModel
{
    private List<IBitModelListener> listener = new ArrayList<IBitModelListener>();

    private boolean[] field;

    // nötige Attribute (bitte ergänzen):
    public BitModel(int length)
    {
        field = new boolean[length];
    }

    @Override
    public int getLength()
    {
        return field.length;
    }

    @Override
    public boolean get(int index)
    {
        return field[index];
    }

    @Override
    public void set(int index, boolean b)
    {
        field[index] = b;
        this.modelChange();
    }

    @Override
    public void addModelListener(IBitModelListener l)
    {
        this.listener.add(l);
    }

    @Override
    public void removeModelListener(IBitModelListener l)
    {
        this.listener.remove(l);
    }

    public void modelChange()
    {
        for (IBitModelListener elem : listener)
        {
            elem.modelChanged();
        }
    }
}