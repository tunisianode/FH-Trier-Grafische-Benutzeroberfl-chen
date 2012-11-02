package gui.center;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CenterFrame extends JFrame implements ActionListener, WindowListener
{
    private static final long serialVersionUID = 1L;

    private JButton visible, unvisible;
    
    public CenterFrame(String name)
    {
        super(name);

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIntoCenter();
        setLayout(new GridLayout(0, 1));

        visible = new JButton("Alle sichtbar!"); 
        visible.setName("visible"); 
        add(visible);
        visible.addActionListener(this);
        
        unvisible = new JButton("Alle unsichtbar!"); 
        unvisible.setName("unvisible"); 
        add(unvisible);
        unvisible.addActionListener(this);
        
        this.pack();
        this.setVisible(true);
    }

    public void setIntoCenter()
    {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        this.setLocation((int) (width / 2)-(this.getWidth()/2), (int) (height / 2)-(this.getHeight()/2));
    }

    public static void setAllIntoCenter()
    {
        for (Frame frame : Frame.getFrames())
        {
            if (frame instanceof CenterFrame)
            {
                ((CenterFrame) frame).setIntoCenter();
            }
        }
    }
    
    public static void setAllVisible(boolean visbile)
    {
        for (Frame frame : Frame.getFrames())
        {
            if (frame instanceof CenterFrame)
            {
                ((CenterFrame) frame).setVisible(visbile);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == visible)
        {
            CenterFrame.setAllVisible(true);
        }
        else
        {
            CenterFrame.setAllVisible(false);
        }
    }
    
    @Override
    public void windowActivated(WindowEvent e)
    {
        System.out.println(this.getTitle() + ": windowActivated");
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
        System.out.println(this.getTitle() + ": windowClosed");
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        System.out.println(this.getTitle() + ": windowClosing");
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        System.out.println(this.getTitle() + ": windowDeactivated");
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
        System.out.println(this.getTitle() + ": windowDeiconified");
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        System.out.println(this.getTitle() + ": windowIconified");
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
        // TODO Auto-generated method stub
        
    }
}