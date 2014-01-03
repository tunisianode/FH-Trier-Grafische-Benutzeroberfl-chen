package gui.state.clock;

import java.util.ArrayList;

public class Clock
{
    private int hours, minutes;
    private State state;
    private ArrayList<ClockListener> listener;

    public Clock()
    {
        listener = new ArrayList<ClockListener>();
    }

    public void addListener(ClockListener e)
    {
        listener.add(e);
    }

    public void removeListener(ClockListener e)
    {
        listener.remove(e);
    }

    public void msgListener()
    {
        for (ClockListener elem : listener)
        {
            elem.update(this.hours, this.minutes);
        }
    }

    public void incrementHours()
    {
        System.out.println("incHouers");
        if (hours == 23)
        {
            this.hours = 0;
        }
        else
        {
            this.hours++;
        }

        this.msgListener();
    }

    public void decrementHours()
    {
        if (this.hours == 0)
        {
            this.hours = 23;
        }
        else
        {
            this.hours--;
        }

        this.msgListener();
    }

    public void incrementMinutes()
    {
        if (this.minutes == 59)
        {
            this.minutes = 0;
        }
        else
        {
            this.minutes++;
        }

        this.msgListener();
    }

    public void decrementMinutes()
    {
        if (this.minutes == 0)
        {
            this.minutes = 59;
        }
        else
        {
            this.minutes--;
        }

        this.msgListener();
    }

    public void set()
    {
        this.state.set();
    }

    public void plus()
    {
        this.state.plus();
    }

    public void minus()
    {
        this.state.minus();
    }

    public void setState(State state)
    {
        System.out.println(state.toString());
        this.state = state;
    }
}