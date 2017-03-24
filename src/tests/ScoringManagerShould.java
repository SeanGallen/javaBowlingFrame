package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Frame;
import main.Game;
import main.ScoringManager;

public class ScoringManagerShould {
	private ScoringManager manager;
	private Game game;
	private int score;
	private ArrayList<Frame> firstGame;
	private int currentFrame;

	@Before
	public void setup() {
		game = new Game();
		manager = new ScoringManager();
		score = manager.score();

		firstGame = game.getFrames();
	}

	public int rollScore(int first, int second, int currentScore) {

		firstGame.get(currentFrame).attempts.get(0).setPinsKnockedDown(first);
		firstGame.get(currentFrame).attempts.get(1).setPinsKnockedDown(second);

		score = firstGame.get(currentFrame).attempts.get(0).getPinsKnockedDown();
		score += firstGame.get(currentFrame).attempts.get(1).getPinsKnockedDown();
		score += currentScore;

		currentFrame++;
		return score;
	}

	@Test
	public void BeCreated() {
		assertNotNull(manager);
	}

	@Test
	public void scoreFirstFrameGame() {

		int testScore = manager.rollScore(1, 3, 0);

		assertEquals(testScore, manager.score());
	}

	@Test
	public void scoreSecondFrameGame() {

		int testScore = rollScore(6, 3, 4);
		manager.rollScore(6, 3, 4);

		assertEquals(testScore, manager.score());

	}
	
	@Test
	public void scoreThirdFrameGame() {

		int testScore = rollScore(10, 0, 13);
		manager.rollScore(10, 0, 13);
		
		assertEquals(13, manager.score());
	}
	
	@Test
	public void scoreFourthFrameGame() {

		int testScore = rollScore(1, 1, 25);
		manager.rollScore(1, 1, 25);
		
		assertEquals(testScore, manager.score());
	}
	
	
}
