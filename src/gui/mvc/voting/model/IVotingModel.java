package gui.mvc.voting.model;

public interface IVotingModel 
{
    /**
     * Fuegt dem Modell einen neuen Kandidaten mit 0 Stimmen hinzu.
     * @param name - Name des hinzuzufuegenden Kandidaten
     */
    public void addCandidate(String name);

    /**
     * Liefert den Namen des Kandidaten zum uebergebenen Index.
     * @param index - Index des Kandidaten, dessen Namen zurueckgegeben werden soll
     * @return Name des Kandidaten mit dem uebergebenen Index
     */
    public String getCandidateName(int index);

    /**
     * Liefert die Stimmen des Kandidaten zum uebergebenen Index.
     * @param index - Index des Kandidaten, dessen Stimmen zurueckgegeben werden sollen
     * @return Stimmen des Kandidaten mit dem uebergebenen Index
     */
    public int getCandidateVotes(int index);

    /**
     * Liefert den prozentualen Anteil (0 - 100) der Stimmen des Kandidaten mit 
     * dem uebergebenen Index. Sollte der prozentuale Anteil Dezimalstellen aufweisen,
     * so soll kaufmaennisch gerundet werden.
     * @param index - Index des Kandidaten, dessen prozentualer Stimmanteil 
     *                zurueckgegeben werden soll
     * @return Stimmenanteil des Kandidaten mit dem uebergebenen Index
     */
    public int getCandidatePercentage(int index);

    /**
     * Gibt die Gesamtanzahl an abgegebenen Stimmen zurueck.
     * @return Gesamtanzahl an Stimmen
     */
    public int getTotalVotes();

    /**
     * Gibt die Anzahl der vom Modell verwalteten Kandidaten zurueck.
     * @return Anzahl der Kandidaten
     */
    public int getNumberOfCandidates();

    /**
     * Inkrementiert die Anzahl der Stimmen des Kandidaten mit dem 
     * uebergebenen Index um eine Stimme.
     * @param index - Index des Kandidaten, dessen Stimmen erhoeht
     *                werden sollen
     */
    public void incrementCandidateVotes(int index);

    /**
     * Setzt die Anzahl der Stimmen des Kandidaten mit dem 
     * uebergebenen Index auf den gegebenen Wert.
     * @param index - Index des Kandidaten, dessen Stimmen erhoeht
     *                werden sollen
     * @param votes - Anzahl der Stimmen, um die erhoeht werden soll
     */
    public void setCandidateVotes(int index, int votes);

    /**
     * Fuegt dem Modell einen neuen IVotingModelListener hinzu.
     * @param l - Hinzuzufuegender IVotingModelListener
     */
    public void addVotingModelListener(IVotingModelListener l);

    /**
     * Entfernt einen IVotingModelListener aus dem Modell
     * @param l - Zu entfernender IVotingModelListener
     */
    public void removeVotingModelListener(IVotingModelListener l);
}
