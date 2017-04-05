package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Attempt;
import main.Game;
import main.NonFinalFrame;

import org.junit.Before;
import org.junit.Test;


public class NonFinalFrameShould {
	private NonFinalFrame nonFinalFrame;
	private Game game;

	@Before
	public void setup() {
		game = new Game();
		nonFinalFrame = new NonFinalFrame();
	}

	@Test
	public void BeCreated() {
		assertNotNull(nonFinalFrame);
	}
	
	@Test
	public void HaveInitializedAttemptsInANonFinalFrame() {
		int expected = 2;
		ArrayList<Attempt> attempts = nonFinalFrame.getAttempts();
		assertEquals(expected, attempts.size());
	}
	
	@Test
	public void CompleteNonFinalFrame() {
		int attempt1PinsKnockedDown = 1;
		int attempt2PinsKnockedDown = 5;
		
		NonFinalFrame frame = (NonFinalFrame) game.getFrames().get(0);
		
		ArrayList<Attempt> attempts = frame.getAttempts();
		
		Attempt attempt1 = attempts.get(0);
		Attempt attempt2 = attempts.get(1);
		
		attempt1.setPinsKnockedDown(attempt1PinsKnockedDown);
		attempt2.setPinsKnockedDown(attempt2PinsKnockedDown);

		frame.markAsComplete();
		
		assertTrue(frame.isComplete);
	}
}
