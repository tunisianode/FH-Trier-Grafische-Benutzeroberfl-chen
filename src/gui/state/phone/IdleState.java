package gui.state.phone;

class IdleState extends PhoneState
{
    public IdleState(PhoneModel model)
    {
        super(model);
    }

    public void digit(int d) throws PhoneException
    {
        model.addDigitToCurrentNumber(d);
        model.setState(new DialingState(model));
    }

    public void okay() throws PhoneException
    {
        String pNumber = model.getPreviousNumber();
        if(pNumber != null)
        {
            model.setCurrentNumber(pNumber);
            model.setState(new DialingState(model));
        }
    }

    public void phoneList() throws PhoneException
    {
        int entries = model.getPhoneBookLength();
        if(entries != 0)
        {
            model.gotoFirstPhoneBookEntry();
            model.setState(new PhoneListState(model));
        }
    }

    public void menu() throws PhoneException
    {
        model.setState(new MenuState(model));
    }
}
