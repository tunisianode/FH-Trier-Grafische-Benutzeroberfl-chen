package gui.state.clock;

public class NormalState extends State
{
    private Clock clock;

    public NormalState(Clock clock)
    {
        this.clock = clock;
    }

    public void set()
    {
        this.clock.setState(new HoursSettingState(clock));
    }

    @Override
    public void plus()
    {
        System.out.println("hey");
    }

    @Override
    public void minus()
    {
    }
}
