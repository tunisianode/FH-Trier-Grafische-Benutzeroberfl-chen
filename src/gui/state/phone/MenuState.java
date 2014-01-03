package gui.state.phone;

class MenuState extends PhoneState implements PhoneListener
{
    private String state;

    public MenuState(PhoneModel model)
    {
        super(model);
    }

    public String toString()
    {
        return this.state;
    }

    @Override
    public void stateChanged(String newState)
    {
        this.state = newState;
    }

    @Override
    public void currentNumberChanged(String newCurrentNumber)
    {
        // TODO Auto-generated method stub

    }
}
