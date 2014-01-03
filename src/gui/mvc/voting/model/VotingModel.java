package gui.mvc.voting.model;

import java.util.ArrayList;

public class VotingModel implements IVotingModel
{
    private String[] candidates;
    private int[] candidatesVotes;
    private ArrayList<IVotingModelListener> listener;

    public VotingModel(String[] candidates)
    {
        this.candidates = candidates;
        candidatesVotes = new int[candidates.length];

        for (int i = 0; i < candidates.length; i++)
        {
            this.setCandidateVotes(i, 0);
        }

        listener = new ArrayList<IVotingModelListener>();
    }

    @Override
    public void addCandidate(String name)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCandidateName(int index)
    {
        return candidates[index];
    }

    @Override
    public int getCandidateVotes(int index)
    {
        return candidatesVotes[index];
    }

    @Override
    public int getCandidatePercentage(int index)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getTotalVotes()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getNumberOfCandidates()
    {
        return candidates.length;
    }

    @Override
    public void incrementCandidateVotes(int index)
    {
        candidatesVotes[index]++;
        System.out.println("erhoeht");
        this.votesChanged();
    }

    @Override
    public void setCandidateVotes(int index, int votes)
    {
        System.out.println(index);
        candidatesVotes[index] = votes;
    }

    @Override
    public void addVotingModelListener(IVotingModelListener l)
    {
        listener.add(l);
    }

    @Override
    public void removeVotingModelListener(IVotingModelListener l)
    {
        listener.remove(l);
    }

    public void votesChanged()
    {
        for (IVotingModelListener elem : listener)
        {
            elem.votesChanged();
        }
    }
}
