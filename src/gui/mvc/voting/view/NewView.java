package gui.mvc.voting.view;

import gui.mvc.voting.model.IVotingModelListener;

import javax.swing.JTextField;

public class NewView extends JTextField implements IVotingModelListener
{
    private static final long serialVersionUID = 1L;

    @Override
    public void votesChanged()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void candidateAdded()
    {
        // TODO Auto-generated method stub

    }

}
