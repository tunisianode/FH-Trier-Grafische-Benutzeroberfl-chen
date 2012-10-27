package gui.center;

import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CenterFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    public CenterFrame(String name)
    {
        super(name);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIntoCenter();
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
}