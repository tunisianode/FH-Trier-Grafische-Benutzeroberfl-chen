package gui.state.clock;

public class MinutesSettingState extends State
{
    private Clock clock;

    public MinutesSettingState(Clock clock)
    {
        this.clock = clock;
    }

    public void set()
    {
        this.clock.setState(new NormalState(clock));
    }

    @Override
    public void plus()
    {
        this.clock.incrementMinutes();
    }

    @Override
    public void minus()
    {
        this.clock.decrementMinutes();
    }
}
