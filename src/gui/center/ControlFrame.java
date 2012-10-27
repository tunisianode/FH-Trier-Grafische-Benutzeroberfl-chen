package gui.center;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ControlFrame extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;

    public ControlFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b = new JButton("Zentrieren!"); 
        b.setName("control"); 
        this.getContentPane().add(b);
        b.addActionListener(this);
        
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        CenterFrame.setAllIntoCenter();
    }

}
