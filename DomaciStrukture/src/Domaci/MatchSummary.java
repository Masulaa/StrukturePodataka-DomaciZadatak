package Domaci;

public class MatchSummary implements Comparable<MatchSummary> {

    private int matchId;
    private String botType;
    private String result;
    private long timeMs;
    private int totalClicks;

    public MatchSummary(int matchId, String botType, String result, long timeMs, int totalClicks) {
        this.matchId = matchId;
        this.botType = botType;
        this.result = result;
        this.timeMs = timeMs;
        this.totalClicks = totalClicks;
    }

    public int getMatchId() { return matchId; }
    public String getBotType() { return botType; }
    public String getResult() { return result; }
    public long getTimeMs() { return timeMs; }
    public int getTotalClicks() { return totalClicks; }

    @Override
    public int compareTo(MatchSummary other) {

        int cmp = Long.compare(this.timeMs, other.timeMs);

        if (cmp == 0) {
            return Integer.compare(this.matchId, other.matchId);
        }

        return cmp;
    }
}