package Domaci;

import java.io.*;
import java.util.*;

public class MatchFactory {

	public static MatchSummary fromCsvLine(String line) {

	    // ukloni whitespace i moguće skrivene znakove
	    line = line.trim();

	    String[] parts = line.split("[,;\\t]");

	    int id = Integer.parseInt(parts[0].trim());
	    String bot = parts[1].trim();
	    String result = parts[2].trim();
	    int duration = Integer.parseInt(parts[3]);
	    int clicks = Integer.parseInt(parts[4]);

	    return new MatchSummary(id, bot, result, duration, clicks);
	}

    public static MatchDataset fromCsvFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        SortedSet<MatchSummary> set = new TreeSet<>();

        String line = br.readLine(); // preskoči header

        while ((line = br.readLine()) != null) {
            set.add(fromCsvLine(line));
        }

        br.close();

        return new MatchDataset(set);
    }
}