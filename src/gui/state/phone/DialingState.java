package gui.state.phone;

class DialingState extends PhoneState
{
    public DialingState(PhoneModel model)
    {
        super(model);
    }

    public void digit(int d) throws PhoneException
    {
        model.addDigitToCurrentNumber(d);
    }
    
    public void okay() throws PhoneException
    {
        model.rememberNumber();
        model.connect();
        model.setState(new ConnectedState(model));
    }
}
