package gui.mvc.voting.model;

public interface IVotingModelListener 
{
    /**
     * Wird immer dann aufgerufen, wenn einer der Kandidaten 
     * neue Stimmen erhalten hat.
     */
    public void votesChanged();

    /**
     * Wird immer dann aufgerufen, wenn ein neuer Kandidat zum
     * Modell hinzugefuegt wurde.
     */
    public void candidateAdded();
}
