package gui.state.phone;

abstract class PhoneState
{
    protected PhoneModel model;

    public PhoneState(PhoneModel model)
    {
        this.model = model;
    }

    public void digit(int d) throws PhoneException
    {
        throw new PhoneException("Ziffer " + d +
                                 " in diesem Zustand nicht m�glich");
    }

    public void okay() throws PhoneException
    {
        throw new PhoneException("Okay-Taste" +
                                 " in diesem Zustand nicht m�glich");
    }

    public void cancel()
    {
        model.reset();
        model.setState(new IdleState(model));
        
    }

    public void phoneList() throws PhoneException
    {
        throw new PhoneException("Telefonbuch" +
                                 " in diesem Zustand nicht m�glich");
    }

    public void menu() throws PhoneException
    {
        throw new PhoneException("Men�" +
                                 " in diesem Zustand nicht m�glich");
    }

    public void up() throws PhoneException
    {
        throw new PhoneException("Pfeil nach oben" +
                                 " in diesem Zustand nicht m�glich");
    }

    public void down() throws PhoneException
    {
        throw new PhoneException("Pfeil nach unten" +
                                 " in diesem Zustand nicht m�glich");
    }
}
