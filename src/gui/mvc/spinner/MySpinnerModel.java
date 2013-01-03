package gui.mvc.spinner;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SpinnerModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MySpinnerModel implements SpinnerModel
{
    /**
     * Aktueller Wert.
     */
    private long value;
    /**
     * Minimum.
     */
    private long min;
    /**
     * Maximum.
     */
    private long max;
    /**
     * Wert, um den der aktuelle Wert jeweils erhöht bzw. erniedrigt wird.
     */
    private long increment;

    /**
     * Weitere Attribute, falls noch benötigt.
     */
    private List<ChangeListener> listener = new ArrayList<ChangeListener>();

    /**
     * Konstruktor. Es soll eine IllegalArgumentException geworfen werden, falls
     * die Parameter unsinnig sind (d.h. min > max oder increment <= 0). Der
     * Startwert soll min sein.
     * 
     * @param min
     * @param max
     * @param increment
     */
    public MySpinnerModel(long min, long max, long increment)
    {
        if (min > max)
        {
            throw new IllegalArgumentException("min darf nicht groesser max sein!");
        }

        if (increment <= 0)
        {
            throw new IllegalArgumentException();
        }

        this.min = min;
        this.max = max;
        this.increment = increment;
        this.value = min;

    }

    /**
     * Methode getNextValue. Falls es einen nächsten Wert gibt, muss dieser als
     * Object zurückgeliefert werden, sonst null.
     */
    public Object getNextValue()
    {
        if (this.value + this.increment <= this.max)
        {
            long valueTemp = this.value + this.increment;
            return new Long(valueTemp);
        }
        else
        {
            return null;
        }
    }

    /**
     * Methode getPreviousValue. Falls es einen vorigen Wert gibt, muss dieser
     * als Object zurückgeliefert werden, sonst null.
     */
    public Object getPreviousValue()
    {
        if (this.value - this.increment >= this.min)
        {
            long valueTemp = this.value - this.increment;
            return new Long(valueTemp);
        }
        else
        {
            return null;
        }
    }

    /**
     * Methode getValue. Der aktuelle Wert als Object.
     */
    public Object getValue()
    {
        return new Long(this.value);
    }

    /**
     * Methode setValue. Sie können davon ausgehen, dass der Parameter o vom
     * selben Typ ist wie von Ihnen bei getNextValue, getPreviousValue und
     * getValue zurückgeliefert. Es müssen alle angemeldeten Listener
     * benachrichtigt werden.
     */
    public void setValue(Object o)
    {
        this.value = ((Long) o).longValue();

        ChangeEvent ce = new ChangeEvent(o);

        for (ChangeListener item : listener)
        {
            item.stateChanged(ce);
        }
    }

    /**
     * Registriert einen ChangeListener.
     */
    public void addChangeListener(ChangeListener l)
    {
        listener.add(l);
    }

    /**
     * Meldet einen ChangeListener ab.
     */
    public void removeChangeListener(ChangeListener l)
    {
        listener.remove(l);
    }
}