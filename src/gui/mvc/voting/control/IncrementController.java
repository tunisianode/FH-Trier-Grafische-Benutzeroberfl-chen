package gui.mvc.voting.control;

import gui.mvc.voting.model.VotingModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncrementController implements ActionListener
{
    private VotingModel model;
    private int index;

    public IncrementController(VotingModel model, int index)
    {
        this.model = model;
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.model.incrementCandidateVotes(index);
    }

}
