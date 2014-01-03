package gui.state.clock;

public class HoursSettingState extends State
{
    private Clock clock;

    public HoursSettingState(Clock clock)
    {
        this.clock = clock;
    }

    public void set()
    {
        this.clock.setState(new MinutesSettingState(clock));
    }

    public void plus()
    {
        this.clock.incrementHours();
    }

    public void minus()
    {
        this.clock.decrementHours();
    }
}
