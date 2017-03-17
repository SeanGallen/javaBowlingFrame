package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import main.NonFinalFrame;
import main.Attempt;
import main.Frame;
import main.Game;
import main.ScoringManager;

public class ScoringManagerShould {
	private ScoringManager manager;
	private Game game;
	
	@Before
	public void setup() {
		game = new Game();
		manager = new ScoringManager();
	}

	@Test
	public void BeCreated() {
		assertNotNull(manager);
	}
	
	@Test
	public void ScoreAGame() {
		int attempt1PinsKnockedDown = 1;
		int attempt2PinsKnockedDown = 5;
		
		NonFinalFrame frame = (NonFinalFrame) game.getFrames().get(0);
		
		ArrayList<Attempt> attempts = frame.getAttempts();
		
		Attempt attempt1 = attempts.get(0);
		Attempt attempt2 = attempts.get(1);
		
		attempt1.setPinsKnockedDown(attempt1PinsKnockedDown);
		attempt2.setPinsKnockedDown(attempt2PinsKnockedDown);

		frame.markAsComplete();
		
		int expectedScore = 6;
	    int score = manager.score(game);
		
		assertEquals(expectedScore, score);
	}
}
	
	

