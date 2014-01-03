package gui.state.phone;

import java.util.ArrayList;

public class PhoneModel
{
    private PhoneState state;
    private String previousNumber;
    private String currentNumber;
    private String[] phoneBook;
    private int phoneBookIndex;
    private ArrayList<PhoneListener> listener;

    public PhoneModel()
    {
        this(null);
    }

    public PhoneModel(String[] book)
    {
        listener = new ArrayList<PhoneListener>();

        state = new IdleState(this);
        previousNumber = "";
        currentNumber = "";
        if (book != null)
        {
            phoneBook = book.clone();
        }
        else
        {
            phoneBook = new String[0];
        }
        phoneBookIndex = 0;
    }

    public void addListener(PhoneListener e)
    {
        listener.add(e);
    }

    public void removeListener(PhoneListener e)
    {
        listener.remove(e);
    }

    public void numberChanged(String number)
    {
        for (PhoneListener listElem : listener)
        {
            listElem.currentNumberChanged(number);
        }
    }

    public void stateChanged(String newstate)
    {
        for (PhoneListener listElem : listener)
        {
            listElem.stateChanged(newstate);
        }
    }

    void setState(PhoneState state)
    {
        this.state = state;
        this.stateChanged(state.getClass().toString());
    }

    void reset()
    {
        currentNumber = "";
        this.numberChanged(currentNumber);
    }

    void addDigitToCurrentNumber(int d)
    {
        if (d < 0 || d > 9)
        {
            throw new IllegalArgumentException("Ziffer muss zwichen " + "0 und 9 sein");
        }
        currentNumber += d;
    }

    String getPreviousNumber()
    {
        return previousNumber;
    }

    void setCurrentNumber(String number)
    {
        currentNumber = number;
    }

    int getPhoneBookLength()
    {
        return phoneBook.length;
    }

    void gotoFirstPhoneBookEntry()
    {
        phoneBookIndex = 0;
        currentNumber = phoneBook[phoneBookIndex];
    }

    void gotoNextPhoneBookEntry()
    {
        int i = 0;
        for (i = 0; i < phoneBook.length; i++)
        {
            if (currentNumber.equals(phoneBook[i]))
            {
                break;
            }
        }
        currentNumber = phoneBook[i + 1];
        this.numberChanged(currentNumber);
    }

    void gotoPreviousPhoneBookEntry()
    {
        int i = 0;
        for (i = 0; i < phoneBook.length; i++)
        {
            if (currentNumber.equals(phoneBook[i]))
            {
                break;
            }
        }
        currentNumber = phoneBook[i - 1];
        this.numberChanged(currentNumber);
    }

    void rememberNumber()
    {
        currentNumber = previousNumber;
    }

    void connect()
    {
        System.out.println("SIMULATION DES VERBINDUNGSAUFBAUS");
    }

    void disconnect()
    {
        System.out.println("SIMULATION DES VERBINDUNGSABBAUS");
    }

    public void digit(int d) throws PhoneException
    {
        state.digit(d);
        // this.addDigitToCurrentNumber(d);
        this.numberChanged(currentNumber);
    }

    public void okay() throws PhoneException
    {
        state.okay();
    }

    public void cancel()
    {
        state.cancel();
    }

    public void phoneList() throws PhoneException
    {
        state.phoneList();
        this.numberChanged(currentNumber);
    }

    public void menu() throws PhoneException
    {
        state.menu();
    }

    public void up() throws PhoneException
    {
        state.up();
    }

    public void down() throws PhoneException
    {
        state.down();
    }
}
