package gui.state.phone;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhoneMain extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private JButton menu, up, down, one, two, three, four, five, six, seven, eight, nine, zero, ok, book, cancel;
    private PhoneModel model;

    public PhoneMain()
    {
        this.setLayout(new GridLayout(8, 1));
        this.setSize(300, 400);

        String[] bookNumbers =
        { "erster string", "zweiter string" };

        model = new PhoneModel(bookNumbers);

        StateView state = new StateView("state");
        state.setStateText("Idle State");
        NumberView numberView = new NumberView("number");
        numberView.setStateText("-");

        model.addListener(state);
        model.addListener(numberView);

        menu = new JButton("Menü");
        menu.addActionListener(this);
        up = new JButton("up");
        up.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        ok = new JButton("okay");
        ok.addActionListener(this);
        book = new JButton("book");
        book.addActionListener(this);
        cancel = new JButton("cancel");
        cancel.addActionListener(this);

        buttonPanel.add(ok);
        buttonPanel.add(book);
        buttonPanel.add(cancel);

        down = new JButton("down");
        down.addActionListener(this);

        one = new JButton("1");
        one.addActionListener(this);
        two = new JButton("2");
        two.addActionListener(this);
        three = new JButton("3");
        three.addActionListener(this);
        four = new JButton("4");
        four.addActionListener(this);
        five = new JButton("5");
        five.addActionListener(this);
        six = new JButton("6");
        six.addActionListener(this);
        seven = new JButton("7");
        seven.addActionListener(this);
        eight = new JButton("8");
        eight.addActionListener(this);
        nine = new JButton("9");
        nine.addActionListener(this);
        zero = new JButton("10");
        zero.addActionListener(this);

        JPanel numberPanel = new JPanel(new GridLayout(3, 3));
        numberPanel.add(one);
        numberPanel.add(two);
        numberPanel.add(three);
        numberPanel.add(four);
        numberPanel.add(five);
        numberPanel.add(six);
        numberPanel.add(seven);
        numberPanel.add(eight);
        numberPanel.add(nine);

        add(state);
        add(numberView);
        add(menu);
        add(up);
        add(buttonPanel);
        add(down);
        add(numberPanel);
        add(zero);

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        // PhoneMain pm = new PhoneMain();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == menu)
        {
            model.setState(new MenuState(model));
        }

        else if (e.getSource() == ok)
        {
            try
            {
                model.okay();
            }
            catch (PhoneException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        else if (e.getSource() == book)
        {
            try
            {
                model.phoneList();
            }
            catch (PhoneException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        else if (e.getSource() == cancel)
        {
            model.cancel();
        }

        else if (e.getSource() == up)
        {
            try
            {
                model.up();
            }
            catch (PhoneException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        else if (e.getSource() == down)
        {
            try
            {
                model.down();
            }
            catch (PhoneException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else
        {
            try
            {
                model.digit(Integer.parseInt(e.getActionCommand()));
            }
            catch (PhoneException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }
}
