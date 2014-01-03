package gui.state.phone;

class PhoneListState extends PhoneState
{
    public PhoneListState(PhoneModel model)
    {
        super(model);
    }

    public void up() throws PhoneException
    {
        model.gotoNextPhoneBookEntry();
        System.out.println("test");
    }

    public void down() throws PhoneException
    {
        model.gotoPreviousPhoneBookEntry();
    }

    public void ok()
    {
        model.rememberNumber();
        model.connect();
        model.setState(new ConnectedState(model));
    }

}
