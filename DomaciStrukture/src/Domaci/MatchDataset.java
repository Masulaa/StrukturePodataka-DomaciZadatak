package Domaci;

import java.util.*;
import java.util.stream.*;

public class MatchDataset {

    private SortedSet<MatchSummary> matches;

    public MatchDataset(SortedSet<MatchSummary> matches) {
        this.matches = matches;
    }

    public Double getAverageClicksByResult(String result) {

        return matches.stream()
                .filter(m -> m.getResult().equals(result))
                .mapToInt(MatchSummary::getTotalClicks)
                .average()
                .orElse(0.0);
    }

    public MatchSummary getMatchWithHighestClickRate() {

        return matches.stream()
                .max(Comparator.comparing(m -> {
                    long time = m.getTimeMs() == 0 ? 1 : m.getTimeMs();
                    return (double) m.getTotalClicks() / time;
                }))
                .orElse(null);
    }

    // dodatno: najbrža pobjeda (prirodni sort)
    public MatchSummary getFastestMatch() {
        return matches.first();
    }

    // dodatno: broj pobjeda
    public long countVictories() {
        return matches.stream()
                .filter(m -> m.getResult().equals("VICTORY"))
                .count();
    }
}