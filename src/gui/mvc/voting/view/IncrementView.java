package gui.mvc.voting.view;

import gui.mvc.voting.control.IncrementController;
import gui.mvc.voting.model.IVotingModelListener;
import gui.mvc.voting.model.VotingModel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IncrementView extends JPanel implements IVotingModelListener
{
    private static final long serialVersionUID = 1L;
    private VotingModel model;

    public IncrementView(VotingModel model)
    {
        this.model = model;
        this.setLayout(new GridLayout(model.getNumberOfCandidates(), 2));
        this.draw();
        this.model.addVotingModelListener(this);
    }

    @Override
    public void votesChanged()
    {
        this.draw();
        System.out.println("test");
        System.out.println(model.getCandidateVotes(0));
    }

    @Override
    public void candidateAdded()
    {
        // TODO Auto-generated method stub
    }

    private void draw()
    {
        for (int i = 0; i < model.getNumberOfCandidates(); i++)
        {
            JLabel label = new JLabel(model.getCandidateName(i) + ": " + model.getCandidateVotes(i) + " von " + model.getTotalVotes());
            this.add(label);

            JButton button = new JButton();
            button.setText("Erhoehen");
            this.add(button);

            button.addActionListener(new IncrementController(model, i));
        }
    }
}