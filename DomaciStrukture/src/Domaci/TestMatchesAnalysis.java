package Domaci;

public class TestMatchesAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   try {
	            MatchDataset dataset = MatchFactory.fromCsvFile("matches.csv");

	            System.out.println("===== MATCH ANALYSIS REPORT =====\n");

	            System.out.println("Average clicks in VICTORY: " +
	                    dataset.getAverageClicksByResult("VICTORY"));

	            System.out.println("Average clicks in DEFEAT: " +
	                    dataset.getAverageClicksByResult("DEFEAT"));

	            System.out.println("\nFastest match:");
	            MatchSummary fastest = dataset.getFastestMatch();
	            System.out.println("Match ID: " + fastest.getMatchId() +
	                    ", Time: " + fastest.getTimeMs() + "ms");

	            System.out.println("\nMatch with highest Click Rate:");
	            MatchSummary bestRate = dataset.getMatchWithHighestClickRate();
	            System.out.println("Match ID: " + bestRate.getMatchId());

	            System.out.println("\nTotal victories: " +
	                    dataset.countVictories());

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
