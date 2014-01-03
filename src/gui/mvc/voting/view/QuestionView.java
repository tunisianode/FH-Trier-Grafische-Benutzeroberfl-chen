package gui.mvc.voting.view;

import gui.mvc.voting.model.IVotingModelListener;

import javax.swing.JLabel;

public class QuestionView extends JLabel implements IVotingModelListener
{
    private static final long serialVersionUID = 1L;
    private String question;

    public QuestionView(String question)
    {
        this.question = question;
        this.setText(question);
    }

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
