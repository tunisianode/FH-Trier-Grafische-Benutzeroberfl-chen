package gui.pizza;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CursorTest extends JFrame implements ActionListener
{
    private JButton button1, button2;
    private JRadioButton defaultRadio, crosshair, hand, text, wait, move, heightRs, widthRs, nwSe, neSw;
    private JPanel panel;

    public CursorTest()
    {
        super("Beispiele fuer Cursor");

        panel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));
        panel.setLayout(new GridLayout(0, 1));

        button1 = new JButton("North");
        button1.setName("button1");
        add(button1);
        button1.addActionListener(this);

        defaultRadio = new JRadioButton("Default");
        panel.add(defaultRadio);
        defaultRadio.addActionListener(this);

        crosshair = new JRadioButton("Crosshair");
        panel.add(crosshair);
        crosshair.addActionListener(this);

        hand = new JRadioButton("Hand");
        panel.add(hand);
        hand.addActionListener(this);

        text = new JRadioButton("Text");
        panel.add(text);
        text.addActionListener(this);

        wait = new JRadioButton("Wait");
        panel.add(wait);
        wait.addActionListener(this);

        move = new JRadioButton("Move");
        panel.add(move);
        move.addActionListener(this);

        heightRs = new JRadioButton("heightRs");
        panel.add(heightRs);
        heightRs.addActionListener(this);

        widthRs = new JRadioButton("widthRs");
        panel.add(widthRs);
        widthRs.addActionListener(this);

        nwSe = new JRadioButton("nwSe");
        panel.add(nwSe);
        nwSe.addActionListener(this);

        neSw = new JRadioButton("neSw");
        panel.add(neSw);
        neSw.addActionListener(this);

        add(panel);

        button2 = new JButton("South");
        button2.setName("button2");
        add(button2);
        button2.addActionListener(this);

        ButtonGroup g = new ButtonGroup();
        g.add(defaultRadio);
        g.add(crosshair);
        g.add(hand);
        g.add(text);
        g.add(wait);
        g.add(move);
        g.add(heightRs);
        g.add(widthRs);
        g.add(nwSe);
        g.add(neSw);

        setSize(200, 500);
        setLocationByPlatform(true);
        setVisible(true);
    }

    private static final long serialVersionUID = 1L;

    public void actionPerformed(ActionEvent arg0)
    {
        if (arg0.getActionCommand().equals("Default"))
        {
            panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        else if (arg0.getActionCommand().equals("Crosshair"))
        {
            panel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
        else if (arg0.getActionCommand().equals("Hand"))
        {
            panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        else if (arg0.getActionCommand().equals("Text"))
        {
            panel.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        }
        else if (arg0.getActionCommand().equals("Wait"))
        {
            panel.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        }
        else if (arg0.getActionCommand().equals("Move"))
        {
            panel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }
        else if (arg0.getActionCommand().equals("heightRs"))
        {
            panel.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
        }
        else if (arg0.getActionCommand().equals("widthRs"))
        {
            panel.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
        }
        else if (arg0.getActionCommand().equals("nwSe"))
        {
            panel.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
        }
        else if (arg0.getActionCommand().equals("neSw"))
        {
            panel.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
        }
    }
}