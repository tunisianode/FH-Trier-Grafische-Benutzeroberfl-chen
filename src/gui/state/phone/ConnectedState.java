package gui.state.phone;

class ConnectedState extends PhoneState
{
    public ConnectedState(PhoneModel model)
    {
        super(model);
    }

    public String toString()
    {
        return "bla";
    }

    public void okay() throws PhoneException
    {
        model.disconnect();
        model.reset();
        model.setState(new IdleState(model));
    }
}
