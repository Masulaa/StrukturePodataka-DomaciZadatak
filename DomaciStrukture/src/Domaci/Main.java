package Domaci;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   try (FileWriter writer = new FileWriter("matches.csv")) {

	            writer.append("MatchId,BotType,Result,TimeMs,TotalClicks\n");

	            for (int matchId = 1; matchId <= 1000; matchId++) {

	                Board board = new Board(8, 6);
	                Player bot = GamesSimulator.createBot(board);

	                long start = System.currentTimeMillis();

	                GameOutcome outcome;

	                do {
	                    outcome = bot.playTurn();
	                } while (outcome == GameOutcome.IN_PROGRESS);

	                long end = System.currentTimeMillis();
	                long timeMs = end - start;

	                // broj klikova iz LinkedListe
	                int clicks = 0;
	                NodeMove node = bot.getMoveHistory().getHead();
	                while (node != null) {
	                    clicks++;
	                    node = node.next;
	                }

	                writer.append(matchId + ",")
	                      .append("RandomBot,")
	                      .append(outcome.toString() + ",")
	                      .append(timeMs + ",")
	                      .append(clicks + "\n");
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
